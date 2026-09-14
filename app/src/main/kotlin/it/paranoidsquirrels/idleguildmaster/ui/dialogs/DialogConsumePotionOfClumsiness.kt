package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionOfClumsinessBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DialogConsumePotionOfClumsiness : CustomDialog() {
    private var binding: DialogConsumePotionOfClumsinessBinding? = null
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumePotionOfClumsinessBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo23_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumePotionOfClumsinessBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        for (adventurer in MainActivity.data.adventurers) {
            if ((adventurer.potionsDrank?.get(10) ?: 0) != 0) {
                val itemBinding = LayoutAdventurerChangeTraitBinding.inflate(layoutInflater, b.list, false)
                if (adventurer.isAscended()) {
                    itemBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
                    itemBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
                    context?.let { ctx ->
                        itemBinding.name.setTextColor(resources.getColor(R.color.ascended_unit, ctx.theme))
                    }
                }
                context?.let { ctx ->
                    itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, ctx.theme))
                    adventurer.doctrine?.let { doc ->
                        itemBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, ctx.theme))
                    }
                }
                itemBinding.level.text = adventurer.level.toString()
                itemBinding.cardView.visibility = if (adventurer.doctrine?.trueClass == "EmptyDoctrine") 8 else 0
                itemBinding.name.text = getString(adventurer.idName)
                itemBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
                itemBinding.root.setOnClickListener {
                    if (confirmDialog != null) return@setOnClickListener
                    val actionDialog = UIUtils.getActionDialog(
                        context,
                        R.string.confirm,
                        String.format(getString(R.string.dialog_clumsiness_confirm), getString(adventurer.idName)),
                        R.string.yes
                    ) { _, _ ->
                        Utils.removeItemFromStorage(Item.getInstance("PotionOfClumsiness", 1))
                        adventurer.potionsDrank?.resetAgility()
                        MainActivity.shownDialogItemDetail?.initialize(null)
                        MainActivity.shownDialogStorage?.update()
                        dismiss()
                    }
                    confirmDialog = actionDialog
                    actionDialog.setOnDismissListener {
                        confirmDialog = null
                    }
                    confirmDialog?.show()
                }
                b.list.addView(itemBinding.root)
            }
        }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogConsumePotionOfClumsiness = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumePotionOfClumsiness = null
        super.onStop()
    }
}
