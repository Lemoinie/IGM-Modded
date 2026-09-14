package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRecallAdventurersBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer

class DialogRecallAdventurers : CustomDialog() {
    private var binding: DialogRecallAdventurersBinding? = null
    private var confirmDialog: AlertDialog? = null
    private var noSpaceDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogRecallAdventurersBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_recall_adventurers_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogRecallAdventurersBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        val dismissed = MainActivity.data.dismissedAdventurers
        for (adv in dismissed) {
            val itemBinding = LayoutAdventurerBinding.inflate(layoutInflater, b.list, false)
            if (adv.isAscended()) {
                UIUtils.applyAscendedPalette(itemBinding)
            }
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adv.imageId, ctx.theme))
                adv.doctrine?.let { doc ->
                    itemBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, ctx.theme))
                }
                itemBinding.weapon.setImageDrawable(Utils.getEquipmentDrawable(adv.weapon, ctx))
                itemBinding.accessory.setImageDrawable(Utils.getEquipmentDrawable(adv.accessory, ctx))
            }
            itemBinding.level.text = adv.level.toString()
            itemBinding.name.text = getString(adv.idName)
            itemBinding.cardView.visibility = if (adv.doctrine?.trueClass == "EmptyDoctrine") 8 else 0
            itemBinding.expendableDoctrinePoints.visibility = 8
            itemBinding.traits.text = UIUtils.traitsToShortString(adv, resources)
            itemBinding.root.setOnClickListener {
                onAdventurerClicked(adv)
            }
            b.list.addView(itemBinding.root)
        }
        b.scrollView.visibility = if (dismissed.isEmpty()) 8 else 0
        b.emptyList.visibility = if (dismissed.isEmpty()) 0 else 8
    }

    private fun onAdventurerClicked(adv: Adventurer) {
        if (Formulas.getQuartersCapacity() <= MainActivity.data.adventurers.size) {
            if (noSpaceDialog != null) return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.drawer_recall_adventurers_warning_no_space_header,
                String.format(getString(R.string.drawer_recall_adventurers_warning_no_space_body), getString(adv.idName)),
                false
            )
            noSpaceDialog = dialog
            dialog.setOnDismissListener { noSpaceDialog = null }
            dialog.show()
            return
        }
        if (confirmDialog != null) return
        val dialog = UIUtils.getActionDialog(
            context,
            R.string.drawer_recall_adventurers_title,
            String.format(getString(R.string.drawer_recall_adventurers_confirmation_body), getString(adv.idName)),
            R.string.yes
        ) { _, _ ->
            MainActivity.data.dismissedAdventurers.remove(adv)
            if (adv.id >= 0) {
                adv.id = Utils.calculateNewAdventurerId()
            }
            MainActivity.data.adventurers.add(adv)
            Utils.triggerGuildSizeAchievementCheck()
            initialize(null)
            MainActivity.headquartersFragment?.refresh()
            MainActivity.adventurersFragment?.refresh()
            MainActivity.adventurersFragment?.switchMode(0)
        }
        confirmDialog = dialog
        dialog.setOnDismissListener { confirmDialog = null }
        dialog.show()
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogRecallAdventurers = this
    }

    override fun onStop() {
        MainActivity.shownDialogRecallAdventurers = null
        super.onStop()
    }
}
