package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChangeTraitRareBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait

class DialogChangeTraitCommonSelect : CustomDialog() {
    companion object {
        /** The 7 base Common traits Evo-21 can switch to. */
        val COMMON_TRAITS = listOf(
            Trait.BOOKWORM, Trait.BRUTE, Trait.FERAL, Trait.VERSATILE,
            Trait.ZEALOUS, Trait.CUNNING, Trait.ATHLETIC
        )
    }

    @JvmField
    var adventurer: Adventurer? = null
    private var binding: DialogChangeTraitRareBinding? = null
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChangeTraitRareBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo21_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChangeTraitRareBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val adv = adventurer ?: return
        b.current.name.text = getString(adv.traitCommon?.nameRes ?: R.string.trait_null_name)
        b.current.description.text = getString(adv.traitCommon?.description ?: R.string.trait_null_description)
        b.list.removeAllViews()
        for (trait in COMMON_TRAITS) {
            val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
            itemBinding.name.text = getString(trait.nameRes)
            itemBinding.description.text = getString(trait.description)
            itemBinding.root.setOnClickListener {
                if (confirmDialog != null) return@setOnClickListener
                val message = String.format(
                    getString(R.string.dialog_consume_evo21_confirm_body),
                    getString(adv.idName),
                    getString(trait.nameRes)
                )
                val dialog = UIUtils.getActionDialog(
                    context,
                    R.string.dialog_change_trait_common_select_title,
                    message,
                    R.string.yes
                ) { dialogInterface, _ ->
                    executeChange(adv, trait)
                    dialogInterface.dismiss()
                }
                confirmDialog = dialog
                dialog.setOnDismissListener { confirmDialog = null }
                dialog.show()
            }
            b.list.addView(itemBinding.root)
        }
    }

    private fun executeChange(adv: Adventurer, newTrait: Trait) {
        if (!DialogConsumeEvo21.applyCommonTraitChange(adv, newTrait)) return
        // Reflect the consumed vial immediately and close the select dialog, like Evo-22.
        MainActivity.shownDialogItemDetail?.initialize(null)
        MainActivity.shownDialogStorage?.update()
        MainActivity.headquartersFragment?.refresh()
        MainActivity.adventurersFragment?.refresh()
        MainActivity.shownDialogConsumeEvo21?.dismiss()
        dismiss()
        context?.let { FileManager.saveNow(it) }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }
}