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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeEvo23Binding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DialogConsumeEvo21 : CustomDialog() {
    companion object {
        /** PLUS common traits are permanent (Evo-22 amplification) — cannot be rerolled via Evo-21. */
        @JvmStatic
        fun isCommonTraitLocked(adventurer: Adventurer): Boolean = adventurer.traitCommon?.isPlus() == true

        /** Shared Evo-21 core (UI confirmation and unit tests): swaps the base Common trait to any
         *  of the 7 base traits and consumes 1x Evo-21 Vial. Returns false when the adventurer has a
         *  locked PLUS common trait or no vial is available. */
        @JvmStatic
        fun applyCommonTraitChange(adventurer: Adventurer, newTrait: Trait): Boolean {
            if (isCommonTraitLocked(adventurer) || newTrait.isPlus()) return false
            val hasVial = MainActivity.data.items.any { it.getTrueClass() == "Evo21Vial" && it.getStack() > 0 }
            if (!hasVial) return false
            adventurer.traitCommon = newTrait
            Utils.removeItemFromStorage(Item.getInstance("Evo21Vial", 1))
            return true
        }
    }

    private var binding: DialogConsumeEvo23Binding? = null
    private var traitLockedDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeEvo23Binding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo21_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumeEvo23Binding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        for (adventurer in MainActivity.data.adventurers) {
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
            if (isCommonTraitLocked(adventurer)) {
                // PLUS common traits are permanent (Evo-22 amplification) — cannot be rerolled.
                itemBinding.root.alpha = 0.4f
                itemBinding.root.setOnClickListener {
                    if (traitLockedDialog != null) return@setOnClickListener
                    val dialog = UIUtils.getInfoDialog(context, R.string.dialog_consume_evo21_title, getString(R.string.trait_locked_plus), false)
                    traitLockedDialog = dialog
                    dialog.setOnDismissListener { traitLockedDialog = null }
                    dialog.show()
                }
            } else {
                itemBinding.root.setOnClickListener {
                    val dialog = DialogChangeTraitCommonSelect()
                    dialog.adventurer = adventurer
                    MainActivity.headquartersFragment?.parentFragmentManager?.let { fm ->
                        dialog.show(fm, "dialog_change_trait_common_select")
                    }
                }
            }
            b.list.addView(itemBinding.root)
        }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogConsumeEvo21 = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumeEvo21 = null
        super.onStop()
    }
}