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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeIntercessionBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DialogConsumeIntercession : CustomDialog() {
    private var binding: DialogConsumeIntercessionBinding? = null
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeIntercessionBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo23_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumeIntercessionBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        for (adventurer in MainActivity.data.adventurers) {
            if (!adventurer.isAscended()) {
                val itemBinding = LayoutAdventurerChangeTraitBinding.inflate(layoutInflater, b.list, false)
                context?.let { ctx ->
                    itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, ctx.theme))
                }
                itemBinding.level.text = adventurer.level.toString()
                itemBinding.cardView.visibility = 8
                itemBinding.name.text = getString(adventurer.idName)
                itemBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
                itemBinding.root.setOnClickListener {
                    if (confirmDialog != null) return@setOnClickListener
                    val actionDialog = UIUtils.getActionDialog(
                        context,
                        R.string.confirm,
                        String.format(getString(R.string.dialog_intercession_confirm_choose), getString(adventurer.idName)),
                        R.string.yes
                    ) { _, _ ->
                        adventurer.setAscended(true)
                        Utils.removeItemFromStorage(Item.getInstance("Intercession", 1))
                        MainActivity.shownDialogItemDetail?.initialize(null)
                        MainActivity.shownDialogStorage?.update()
                        MainActivity.adventurersFragment?.refresh()
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
        MainActivity.shownDialogConsumeIntercession = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumeIntercession = null
        super.onStop()
    }
}
