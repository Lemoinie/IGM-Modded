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

/** Evo-24 upgrade dialog: shows the adventurer's current Rare trait and the enhanced PLUS
 *  form (name + description) so the player can preview the stat change before amplifying. */
class DialogChangeTraitRareUpgrade : CustomDialog() {
    @JvmField
    var adventurer: Adventurer? = null
    private var binding: DialogChangeTraitRareBinding? = null
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChangeTraitRareBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_change_trait_rare_upgrade_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChangeTraitRareBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val adv = adventurer ?: return
        b.current.name.text = getString(adv.traitRare?.nameRes ?: R.string.trait_null_name)
        b.current.description.text = getString(adv.traitRare?.description ?: R.string.trait_null_description)

        b.list.removeAllViews()
        val plusTrait = Trait.getRarePlusUpgrade(adv.traitRare) ?: return
        val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
        itemBinding.name.text = getString(plusTrait.nameRes)
        itemBinding.description.text = getString(plusTrait.description)
        itemBinding.root.setOnClickListener {
            if (confirmDialog != null) return@setOnClickListener
            val message = String.format(
                getString(R.string.dialog_consume_evo24_confirm_body),
                getString(adv.idName),
                getString(adv.traitRare?.nameRes ?: R.string.trait_null_name),
                getString(plusTrait.nameRes)
            )
            val dialog = UIUtils.getActionDialog(
                context,
                R.string.dialog_change_trait_rare_upgrade_title,
                message,
                R.string.yes
            ) { dialogInterface, _ ->
                executeUpgrade(adv)
                dialogInterface.dismiss()
            }
            confirmDialog = dialog
            dialog.setOnDismissListener { confirmDialog = null }
            dialog.show()
        }
        b.list.addView(itemBinding.root)
    }

    private fun executeUpgrade(adv: Adventurer) {
        if (DialogConsumeEvo24.applyRarePlusUpgrade(adv) == null) return
        // Reflect the consumed vial immediately, like Evo-22.
        MainActivity.shownDialogItemDetail?.initialize(null)
        MainActivity.shownDialogStorage?.update()
        MainActivity.headquartersFragment?.refresh()
        MainActivity.adventurersFragment?.refresh()
        MainActivity.shownDialogConsumeEvo24?.dismiss()
        dismiss()
        context?.let { FileManager.saveNow(it) }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }
}