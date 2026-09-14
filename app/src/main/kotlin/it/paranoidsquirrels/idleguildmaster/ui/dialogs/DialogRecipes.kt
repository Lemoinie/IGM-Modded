package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRecipesBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import java.util.ArrayList

class DialogRecipes : CustomDialog() {
    private var adapter: BaseAdapter? = null
    @JvmField
    var binding: DialogRecipesBinding? = null
    private var recipes: MutableList<Recipes> = ArrayList()

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogRecipesBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_workshop_recipes_title)

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogRecipesBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.radiobuttonType.isChecked = true
        b.radiobuttonAll.isChecked = true
        b.hideInsufficientIngredients.isChecked = true
        configureVisibility()
    }

    private fun configureOrder() {
        val b = binding ?: return
        val checkedId = b.radioGroupOrderBy.checkedRadioButtonId
        if (checkedId == b.radiobuttonType.id) {
            recipes.sortWith(Utils.recipesByTypeComparator)
        } else if (checkedId == b.radiobuttonAlphabetical.id) {
            recipes.sortBy { getString(it.getResult()!!.getIdName()) }
        } else if (checkedId == b.radiobuttonCraftableAmount.id) {
            recipes.sortBy { -Utils.maxCraftableAmount(it) }
        }
        adapter?.notifyDataSetChanged()
        b.noRecipesTooltip.visibility = if (recipes.isEmpty()) 0 else 8
        b.recipeList.visibility = if (recipes.isEmpty()) 4 else 0
    }

    private fun configureVisibility() {
        recipes = ArrayList(MainActivity.data.knownRecipes)
        val b = binding ?: return
        val checkedId = b.radioGroupVisibility.checkedRadioButtonId
        if (checkedId == b.radiobuttonMaterials.id) {
            recipes.removeAll { it.getResult() is Equipment }
        } else if (checkedId == b.radiobuttonWeapons.id) {
            recipes.removeAll { it.getResult() !is Weapon }
        } else if (checkedId == b.radiobuttonArmors.id) {
            recipes.removeAll { it.getResult() !is Armor }
        } else if (checkedId == b.radiobuttonAccessories.id) {
            recipes.removeAll { it.getResult() !is Accessory }
        }
        if (b.hideInsufficientIngredients.isChecked) {
            recipes.removeAll { Utils.maxCraftableAmount(it) < 1 }
        }
        adapter = UIUtils.getRecipesListAdapter(recipes)
        b.recipeList.adapter = adapter as ListAdapter
        configureOrder()
    }

    fun update() {
        val b = binding ?: return
        if (b.hideInsufficientIngredients.isChecked) {
            recipes.removeAll { Utils.maxCraftableAmount(it) < 1 }
        }
        adapter?.notifyDataSetChanged()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.radioGroupOrderBy.setOnCheckedChangeListener { _, _ ->
            configureOrder()
        }
        b.radioGroupVisibility.setOnCheckedChangeListener { _, _ ->
            configureVisibility()
        }
        b.hideInsufficientIngredients.setOnCheckedChangeListener { _, _ ->
            configureVisibility()
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogRecipes = this
    }

    override fun onStop() {
        MainActivity.shownDialogRecipes = null
        super.onStop()
    }
}
