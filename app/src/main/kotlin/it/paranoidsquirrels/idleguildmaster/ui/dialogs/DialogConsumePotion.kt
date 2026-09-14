package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerPotionsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class DialogConsumePotion : CustomDialog() {
    companion object {
        @JvmStatic
        fun checkHeavyDrinker(adventurer: Adventurer) {
            if (MainActivity.data.isPotsMaxed) return
            for (i in 0..10) {
                if ((adventurer.potionsDrank?.get(i) ?: 0) < adventurer.calculateMaxPotions(i)) {
                    return
                }
            }
            MainActivity.data.isPotsMaxed = true
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_HEAVY_DRINKER)
        }
    }

    private var binding: DialogConsumePotionBinding? = null
    @JvmField
    var selected: Potion? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumePotionBinding
    }

    override fun getTitle(): String = getString(selected?.getIdName() ?: 0)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumePotionBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val potion = selected ?: return
        val b = binding ?: return
        context?.let { ctx ->
            b.potionSelected.image.setImageDrawable(ResourcesCompat.getDrawable(resources, potion.getIdImage(), ctx.theme))
        }
        b.potionSelected.stack.text = potion.getStack().toString()
        b.list.removeAllViews()
        for (adventurer in MainActivity.data.adventurers) {
            val maxPotions = adventurer.calculateMaxPotions(potion.getPotionType())
            val current = adventurer.potionsDrank?.get(potion.getPotionType()) ?: 0
            if (current < maxPotions) {
                val itemBinding = LayoutAdventurerPotionsBinding.inflate(layoutInflater, b.list, false)
                if (adventurer.isAscended()) {
                    itemBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
                    itemBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
                    itemBinding.potionsContainer.setBackgroundResource(R.drawable.object_border_rounded_right_ascended)
                    context?.let { ctx ->
                        itemBinding.name.setTextColor(resources.getColor(R.color.ascended_unit, ctx.theme))
                        itemBinding.potionAmount.setTextColor(resources.getColor(R.color.ascended_unit, ctx.theme))
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
                itemBinding.potionAmount.text = String.format(getString(R.string.min_bar_max), current, maxPotions)
                itemBinding.potionsContainer.setOnClickListener {
                    if (potion.getStack() <= 0) return@setOnClickListener
                    adventurer.potionsDrank?.increase(potion.getPotionType())
                    Utils.removeItemFromStorage(Item.getInstance(potion.getTrueClass() ?: "", 1))
                    MainActivity.shownDialogItemDetail?.initialize(null)
                    MainActivity.shownDialogStorage?.update()
                    MainActivity.headquartersFragment?.refresh()
                    b.potionSelected.stack.text = potion.getStack().toString()
                    val newCurrent = adventurer.potionsDrank?.get(potion.getPotionType()) ?: 0
                    itemBinding.potionAmount.text = String.format(getString(R.string.min_bar_max), newCurrent, maxPotions)
                    if (newCurrent >= maxPotions) {
                        b.list.removeView(itemBinding.root)
                        refreshListVisibility()
                        checkHeavyDrinker(adventurer)
                    }
                }
                b.list.addView(itemBinding.root)
            }
        }
        refreshListVisibility()
    }

    private fun refreshListVisibility() {
        val b = binding ?: return
        val empty = b.list.childCount <= 0
        b.scrollView.visibility = if (empty) 8 else 0
        b.emptyList.visibility = if (empty) 0 else 8
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogConsumePotion = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumePotion = null
        super.onStop()
    }
}
