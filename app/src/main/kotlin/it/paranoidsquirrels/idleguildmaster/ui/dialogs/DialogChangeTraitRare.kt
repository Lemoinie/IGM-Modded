package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChangeTraitRareBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DialogChangeTraitRare : CustomDialog() {
    @JvmField
    var adventurer: Adventurer? = null
    @JvmField
    var alternative: Boolean = false
    private var binding: DialogChangeTraitRareBinding? = null
    private var confirm: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChangeTraitRareBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_change_trait_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChangeTraitRareBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val adv = adventurer ?: return
        val b = binding ?: return
        b.current.name.text = getString(adv.traitRare?.nameRes ?: R.string.trait_null_name)
        b.current.description.text = getString(adv.traitRare?.description ?: R.string.trait_null_description)
        val traits = mutableListOf(
            Trait.EMPATHETIC, Trait.GIFTED, Trait.INTIMIDATING, Trait.FOCUSED,
            Trait.DRAGON_BLOOD, Trait.CURSED, Trait.REACTIVE, Trait.NOCTURNAL,
            Trait.MINDFUL, Trait.TROLL_BLOOD, Trait.NIMBLE, Trait.RUTHLESS,
            Trait.BLESSED, Trait.ALERT
        )
        adv.traitRare?.let { traits.remove(it) }
        b.list.removeAllViews()
        for (trait in traits) {
            addTraitToList(trait)
        }
    }

    private fun addTraitToList(trait: Trait) {
        val b = binding ?: return
        val adv = adventurer ?: return
        val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
        itemBinding.name.text = getString(trait.nameRes)
        itemBinding.description.text = getString(trait.description)
        itemBinding.root.setOnClickListener {
            if (confirm != null) return@setOnClickListener
            val actionDialog = UIUtils.getActionDialog(
                context,
                R.string.dialog_change_trait_confirm_title,
                String.format(
                    getString(R.string.dialog_change_trait_confirm_body),
                    getString(adv.idName),
                    getString(adv.traitRare?.nameRes ?: R.string.trait_null_name),
                    getString(trait.nameRes)
                ),
                R.string.yes
            ) { dialogInterface, _ ->
                adv.changeRareTrait(trait)
                Utils.removeItemFromStorage(Item.getInstance(if (alternative) "Evo23Vial2" else "Evo23Vial", 1))
                MainActivity.shownDialogItemDetail?.initialize(null)
                MainActivity.shownDialogStorage?.update()
                MainActivity.shownDialogEntityDetail?.update()
                MainActivity.headquartersFragment?.refresh()
                MainActivity.adventurersFragment?.refresh()
                MainActivity.shownDialogConsumeEvo23?.dismiss()
                MainActivity.shownDialogChangeTraitRare?.dismiss()
                dialogInterface.dismiss()
            }
            confirm = actionDialog
            actionDialog.setOnDismissListener {
                confirm = null
            }
            confirm?.show()
        }
        b.list.addView(itemBinding.root)
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogChangeTraitRare = this
    }

    override fun onStop() {
        MainActivity.shownDialogChangeTraitRare = null
        super.onStop()
    }
}
