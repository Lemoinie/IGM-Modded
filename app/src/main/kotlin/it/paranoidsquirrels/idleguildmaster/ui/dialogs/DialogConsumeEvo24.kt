package it.paranoidsquirrels.idleguildmaster.ui.dialogs

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

class DialogConsumeEvo24 : CustomDialog() {
    companion object {
        /** An adventurer can be amplified only when holding one of the 6 base Rare traits. */
        @JvmStatic
        fun isEligibleForPlus(adventurer: Adventurer): Boolean = Trait.getRarePlusUpgrade(adventurer.traitRare) != null

        /** Shared Evo-24 core (UI confirmation and unit tests): amplifies the base Rare trait to its
         *  permanent PLUS form and consumes 1x Evo-24 Vial. Returns the new PLUS trait, or null when
         *  the adventurer is not eligible (missing base trait / already PLUS) or no vial is available. */
        @JvmStatic
        fun applyRarePlusUpgrade(adventurer: Adventurer): Trait? {
            if (!isEligibleForPlus(adventurer)) return null
            val hasVial = MainActivity.data.items.any { it.getTrueClass() == "Evo24Vial" && it.getStack() > 0 }
            if (!hasVial) return null
            val plus = Trait.getRarePlusUpgrade(adventurer.traitRare) ?: return null
            adventurer.traitRare = plus
            Utils.removeItemFromStorage(Item.getInstance("Evo24Vial", 1))
            return plus
        }
    }

    private var binding: DialogConsumeEvo23Binding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeEvo23Binding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo24_title)

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
            val plusTrait = Trait.getRarePlusUpgrade(adventurer.traitRare)
            if (plusTrait == null) {
                // No eligible base Rare trait (or already PLUS) — cannot be targeted by Evo-24.
                itemBinding.root.alpha = 0.4f
            } else {
                itemBinding.root.setOnClickListener {
                    val dialog = DialogChangeTraitRareUpgrade()
                    dialog.adventurer = adventurer
                    MainActivity.headquartersFragment?.parentFragmentManager?.let { fm ->
                        dialog.show(fm, "dialog_change_trait_rare_upgrade")
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
        MainActivity.shownDialogConsumeEvo24 = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumeEvo24 = null
        super.onStop()
    }
}