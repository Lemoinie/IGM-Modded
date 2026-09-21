package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogCraftBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftBigBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes

class DialogCraft : CustomDialog() {
    @JvmField
    var binding: DialogCraftBinding? = null
    var item: Item? = null
    private var maxAmount: Int = 0
    var recipe: Recipes? = null
    private var slotsAvailable: Boolean = false

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogCraftBinding
    }

    override fun getTitle(): String {
        val r = recipe ?: return ""
        val result = r.getResult() ?: return ""
        return String.format(getString(R.string.craft_dialog_title), getString(result.getIdName()))
    }

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogCraftBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val r = recipe ?: return
        val b = binding ?: return
        val result = r.getResult() ?: return
        slotsAvailable = Formulas.workshopQueue() > MainActivity.data.workshopQueue.size + MainActivity.data.completedWorkshopItems.size
        maxAmount = Utils.maxCraftableAmount(r)
        item = Item.getInstance(result.getTrueClass()!!, if (MainActivity.data.isSettingCraftMaxAmount) maxAmount else 1)
        populateCraftLayout(b.buildsFrom, r)
        b.warningFullQueue.setTextColor(resources.getColor(UIUtils.getFailureColor(), context?.theme))
        b.warningNoIngredients.setTextColor(resources.getColor(UIUtils.getFailureColor(), context?.theme))
        b.craftPanel.visibility = if (maxAmount <= 0 || !slotsAvailable) 4 else 0
        b.warningNoIngredients.visibility = if (maxAmount > 0) 8 else 0
        b.warningFullQueue.visibility = if (slotsAvailable) 8 else 0
        b.seekBar.max = Math.max(0, maxAmount - 1)
        changeAmount()
    }

    private fun populateCraftLayout(layoutCraftBigBinding: LayoutCraftBigBinding, recipes: Recipes?) {
        if (recipes == null) {
            layoutCraftBigBinding.root.visibility = 8
            return
        }
        val result = recipes.getResult() ?: return
        val theme = context?.theme
        layoutCraftBigBinding.root.visibility = 0
        layoutCraftBigBinding.result.image.setImageDrawable(ResourcesCompat.getDrawable(resources, result.getIdImage(), theme))
        layoutCraftBigBinding.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(result.getRarity()))
        val ing0 = recipes.getIngredients()[0]!!
        layoutCraftBigBinding.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(resources, ing0.getIdImage(), theme))
        layoutCraftBigBinding.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing0.getRarity()))
        layoutCraftBigBinding.ingredient1.stack.setTextColor(
            resources.getColor(
                if (Utils.gotEnoughItem(ing0)) R.color.dim_white else UIUtils.getFailureColor(),
                theme
            )
        )
        if (recipes.getIngredients().size > 1) {
            val ing1 = recipes.getIngredients()[1]!!
            layoutCraftBigBinding.plusSign1.visibility = 0
            layoutCraftBigBinding.ingredient2.root.visibility = 0
            layoutCraftBigBinding.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(resources, ing1.getIdImage(), theme))
            layoutCraftBigBinding.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing1.getRarity()))
            layoutCraftBigBinding.ingredient2.stack.setTextColor(
                resources.getColor(
                    if (Utils.gotEnoughItem(ing1)) R.color.dim_white else UIUtils.getFailureColor(),
                    theme
                )
            )
        } else {
            layoutCraftBigBinding.plusSign1.visibility = 8
            layoutCraftBigBinding.ingredient2.root.visibility = 8
        }
        if (recipes.getIngredients().size > 2) {
            val ing2 = recipes.getIngredients()[2]!!
            layoutCraftBigBinding.plusSign2.visibility = 0
            layoutCraftBigBinding.ingredient3.root.visibility = 0
            layoutCraftBigBinding.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(resources, ing2.getIdImage(), theme))
            layoutCraftBigBinding.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing2.getRarity()))
            layoutCraftBigBinding.ingredient3.stack.setTextColor(
                resources.getColor(
                    if (Utils.gotEnoughItem(ing2)) R.color.dim_white else UIUtils.getFailureColor(),
                    theme
                )
            )
        } else {
            layoutCraftBigBinding.plusSign2.visibility = 8
            layoutCraftBigBinding.ingredient3.root.visibility = 8
        }
        if (recipes.getIngredients().size > 3) {
            val ing3 = recipes.getIngredients()[3]!!
            layoutCraftBigBinding.plusSign3.visibility = 0
            layoutCraftBigBinding.ingredient4.root.visibility = 0
            layoutCraftBigBinding.ingredient4.image.setImageDrawable(ResourcesCompat.getDrawable(resources, ing3.getIdImage(), theme))
            layoutCraftBigBinding.ingredient4.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing3.getRarity()))
            layoutCraftBigBinding.ingredient4.stack.setTextColor(
                resources.getColor(
                    if (Utils.gotEnoughItem(ing3)) R.color.dim_white else UIUtils.getFailureColor(),
                    theme
                )
            )
        } else {
            layoutCraftBigBinding.plusSign3.visibility = 8
            layoutCraftBigBinding.ingredient4.root.visibility = 8
        }
    }

    private fun changeAmount() {
        val b = binding ?: return
        val itm = item ?: return
        val r = recipe ?: return
        b.seekBar.progress = itm.getStack() - 1
        b.time.text = UIUtils.formatSeconds(itm.getSecondsToCraft())
        b.number.text = itm.getStack().toString()
        b.buildsFrom.result.stack.text = itm.getStack().toString()
        val ing0 = r.getIngredients()[0]!!
        b.buildsFrom.ingredient1.stack.text = (ing0.getStack() * itm.getStack()).toString()
        if (r.getIngredients().size > 1) {
            val ing1 = r.getIngredients()[1]!!
            b.buildsFrom.ingredient2.stack.text = (ing1.getStack() * itm.getStack()).toString()
        }
        if (r.getIngredients().size > 2) {
            val ing2 = r.getIngredients()[2]!!
            b.buildsFrom.ingredient3.stack.text = (ing2.getStack() * itm.getStack()).toString()
        }
        if (r.getIngredients().size > 3) {
            val ing3 = r.getIngredients()[3]!!
            b.buildsFrom.ingredient4.stack.text = (ing3.getStack() * itm.getStack()).toString()
        }
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.craft.setOnClickListener {
            if (maxAmount <= 0 || !slotsAvailable) {
                return@setOnClickListener
            }
            val itm = item ?: return@setOnClickListener
            val r = recipe ?: return@setOnClickListener
            val result = r.getResult() ?: return@setOnClickListener
            val itemAction = ItemAction(Item.getInstance(result.getTrueClass()!!, itm.getStack()))
            MainActivity.data.workshopQueue.add(itemAction)
            for (ingredient in r.getIngredients()) {
                if (ingredient != null) {
                    Utils.removeItemFromStorage(Item.getInstance(ingredient.getTrueClass()!!, ingredient.getStack() * itm.getStack()))
                }
            }
            MainActivity.shownDialogStorage?.update()
            MainActivity.shownDialogRecipes?.update()
            MainActivity.shownDialogWorkshop?.addProject(itemAction)
            MainActivity.headquartersFragment?.refresh()
            dismiss()
        }
        b.close.setOnClickListener {
            dismiss()
        }
        b.buttonPlus.setOnClickListener {
            val itm = item ?: return@setOnClickListener
            if (itm.getStack() >= maxAmount) {
                itm.setStack(maxAmount)
                return@setOnClickListener
            }
            itm.setStack(itm.getStack() + 1)
            changeAmount()
        }
        b.buttonMinus.setOnClickListener {
            val itm = item ?: return@setOnClickListener
            if (itm.getStack() <= 1) {
                itm.setStack(1)
                return@setOnClickListener
            }
            itm.setStack(itm.getStack() - 1)
            changeAmount()
        }
        b.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    item?.setStack(progress + 1)
                    changeAmount()
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogCraft = this
    }

    override fun onStop() {
        MainActivity.shownDialogCraft = null
        super.onStop()
    }
}
