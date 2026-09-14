package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChangeTraitRareBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTraitBinding
import it.paranoidsquirrels.idleguildmaster.mod.ModManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DialogChangeTraitCommon : CustomDialog() {
    @JvmField
    var adventurer: Adventurer? = null
    private var binding: DialogChangeTraitRareBinding? = null
    private var confirm: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChangeTraitRareBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_change_trait_common_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChangeTraitRareBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val adv = adventurer ?: return
        val b = binding ?: return
        val curTrait = adv.traitCommon
        b.current.name.text = getString(curTrait?.nameRes ?: R.string.trait_null_name)
        b.current.description.text = getString(curTrait?.description ?: R.string.trait_null_description)

        b.list.removeAllViews()
        val upgradeOptions = mutableListOf<Trait>()
        when (curTrait) {
            Trait.BRUTE -> upgradeOptions.add(Trait.BRUTE_PLUS)
            Trait.FERAL -> upgradeOptions.add(Trait.FERAL_PLUS)
            Trait.BOOKWORM -> upgradeOptions.add(Trait.BOOKWORM_PLUS)
            else -> {}
        }

        if (upgradeOptions.isEmpty()) {
            val emptyText = TextView(context)
            emptyText.text = "This trait cannot be upgraded further."
            emptyText.setPadding(32, 32, 32, 32)
            emptyText.setTextColor(-0x333334)
            b.list.addView(emptyText)
            return
        }

        for (trait in upgradeOptions) {
            addTraitToList(trait)
        }
    }

    private fun addTraitToList(targetTrait: Trait) {
        val b = binding ?: return
        val adv = adventurer ?: return
        val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
        itemBinding.name.text = getString(targetTrait.nameRes)
        itemBinding.description.text = getString(targetTrait.description)
        itemBinding.root.setOnClickListener {
            if (confirm != null) return@setOnClickListener
            val advName = getString(adv.idName)
            val curTraitName = getString(adv.traitCommon?.nameRes ?: R.string.trait_null_name)
            val newTraitName = getString(targetTrait.nameRes)
            val message = "Upgrade $advName's trait from [$curTraitName] to [$newTraitName] using 1x Evo-22 Vial?"

            val actionDialog = UIUtils.getActionDialog(
                context,
                R.string.dialog_change_trait_common_title,
                message,
                R.string.yes
            ) { dialogInterface, _ ->
                applyTraitChange(targetTrait)
                dialogInterface.dismiss()
            }
            confirm = actionDialog
            actionDialog.setOnDismissListener { confirm = null }
            actionDialog.show()
        }
        b.list.addView(itemBinding.root)
    }

    private fun applyTraitChange(targetTrait: Trait) {
        val adv = adventurer ?: return
        ModManager.setAdventurerCommonTrait(adv, targetTrait)
        Item.getInstance("Evo22Vial", 1)?.let { Utils.removeItemFromStorage(it) }

        MainActivity.shownDialogItemDetail?.initialize(null)
        MainActivity.shownDialogStorage?.update()
        MainActivity.shownDialogEntityDetail?.update()
        MainActivity.headquartersFragment?.refresh()
        MainActivity.adventurersFragment?.refresh()

        DialogConsumeEvo22.currentDialog?.dismiss()
        dismiss()
        context?.let { ModManager.saveGameSynchronous(it) }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }
}
