package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeFoodBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutPetFeedingBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import java.util.ArrayList

class DialogConsumeFood : CustomDialog() {
    private var binding: DialogConsumeFoodBinding? = null
    @JvmField
    var selected: Food? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeFoodBinding
    }

    override fun getTitle(): String = getString(selected?.getIdName() ?: 0)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumeFoodBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val food = selected ?: return
        val b = binding ?: return
        b.feedAll.isChecked = true
        context?.let { ctx ->
            b.foodSelected.image.setImageDrawable(ResourcesCompat.getDrawable(resources, food.getIdImage(), ctx.theme))
        }
        b.foodSelected.stack.text = food.getStack().toString()
        b.list.removeAllViews()
        val pets = ArrayList(MainActivity.data.pets)
        pets.sortWith(Utils.petsComparator)
        for (pet in pets) {
            val itemBinding = LayoutPetFeedingBinding.inflate(layoutInflater, b.list, false)
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, pet.idImage, ctx.theme))
            }
            itemBinding.level.text = pet.level.toString()
            itemBinding.name.text = getString(pet.idName)
            val totalFood = pet.totalFoodToNextLevel()
            itemBinding.detailFood.text = String.format(getString(R.string.min_bar_max), pet.food, totalFood)
            itemBinding.detailFoodBar.progress = ((pet.food * 100) / totalFood)
            itemBinding.confirm.setOnClickListener {
                if (food.getStack() <= 0) return@setOnClickListener
                val count = if (b.feedAll.isChecked) food.getStack() else 1
                pet.feed(food.getFeedPower() * count)
                Utils.removeItemFromStorage(Item.getInstance(food.getTrueClass() ?: "", count))
                MainActivity.shownDialogItemDetail?.initialize(null)
                MainActivity.shownDialogStorage?.update()
                MainActivity.headquartersFragment?.refresh()
                b.foodSelected.stack.text = food.getStack().toString()
                itemBinding.level.text = pet.level.toString()
                val nextTotal = pet.totalFoodToNextLevel()
                itemBinding.detailFood.text = String.format(getString(R.string.min_bar_max), pet.food, nextTotal)
                itemBinding.detailFoodBar.progress = ((pet.food * 100) / nextTotal)
            }
            b.list.addView(itemBinding.root)
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
        MainActivity.shownDialogConsumeFood = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumeFood = null
        super.onStop()
    }
}
