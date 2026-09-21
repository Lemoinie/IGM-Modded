package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogItemDetailBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Evo22Vial
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Evo23Vial
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Evo23Vial2
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Intercession
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.PotionOfClumsiness
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.PotionOfRejuvenation
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.XPBook1
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.XPBook10
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.XPBook2
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.XPBook3
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.ArrayList

class DialogItemDetail : CustomDialog() {
    @JvmField
    var binding: DialogItemDetailBinding? = null
    private var consumeDialog: AlertDialog? = null
    @JvmField
    var items: MutableList<Item> = ArrayList()

    fun getItems(): MutableList<Item> = items

    fun setItems(list: MutableList<Item>) {
        items = list
    }

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogItemDetailBinding
    }

    override fun getTitle(): String {
        if (items.isEmpty()) {
            dismiss()
            return ""
        }
        return getString(items[0].getIdName())
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogItemDetailBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        val b = binding ?: return
        if (items.isEmpty()) return

        val index = MainActivity.data.items.indexOf(items[0])
        val item = if (index == -1) Item.getInstance(items[0].getTrueClass() ?: "", 0) else MainActivity.data.items[index]
        if (item == null) return

        b.item.image.setImageDrawable(ResourcesCompat.getDrawable(resources, item.getIdImage(), context?.theme))
        b.item.image.setBackgroundResource(UIUtils.backgroundFromRarity(item.getRarity()))
        b.type.setText(item.printType())
        b.item.stack.text = item.getStack().toString()
        UIUtils.populateMoneyContainer(b.money, item.getPrice(), true)
        b.description.setText(item.getIdDescription())
        b.sell.visibility = if (item.isNotSellable()) View.INVISIBLE else View.VISIBLE
        b.messageNotSellable.visibility = if (item.isNotSellable()) View.VISIBLE else View.INVISIBLE
        b.effects.text = getEffect(item)
        b.effects.visibility = if (item is Equipment || item is Food) View.VISIBLE else View.GONE

        val source = getSource(item)
        b.source.text = source
        b.source.visibility = if (source.isEmpty()) View.GONE else View.VISIBLE
        b.sourceTitle.visibility = if (source.isEmpty()) View.GONE else View.VISIBLE

        val recipesInto = Recipes.into(item)
        b.buildsFromTitle.visibility = if (recipesInto == null) View.GONE else View.VISIBLE
        b.craft.visibility = if (recipesInto == null) View.GONE else View.VISIBLE

        val isConsumable = item is Consumable
        b.consume.visibility = if (isConsumable) View.VISIBLE else View.GONE
        if (isConsumable) {
            b.consume.setImageDrawable(
                ResourcesCompat.getDrawable(resources, (item as Consumable).printConsumeImage(), context?.theme)
            )
        }

        populateCraftLayout(b.buildsFrom, recipesInto)
        b.buildsIntoTitle.visibility = View.VISIBLE

        if (MainActivity.data.seenItems.contains(item.getTrueClass())) {
            b.buildsIntoList.visibility = View.VISIBLE
            b.buildsIntoHidden.visibility = View.GONE
            b.buildsIntoList.removeAllViews()
            val listFrom = Recipes.from(item)
            if (listFrom.isEmpty()) {
                b.buildsIntoTitle.visibility = View.GONE
            }
            for (recipe in listFrom) {
                val craftBinding = LayoutCraftBinding.inflate(layoutInflater, b.buildsIntoList, false)
                populateCraftLayout(craftBinding, recipe)
                b.buildsIntoList.addView(craftBinding.root)
            }
        } else {
            b.buildsIntoTitle.visibility = View.VISIBLE
            b.buildsIntoList.visibility = View.GONE
            b.buildsIntoHidden.visibility = View.VISIBLE
        }

        b.back.visibility = if (items.size <= 1) View.GONE else View.VISIBLE
    }

    private fun getEffect(item: Item): String {
        if (item is Equipment) {
            return UIUtils.formatEquipmentDescription(item, resources)
        }
        return if (item is Food) {
            String.format(getString(R.string.food_feed_power), item.getFeedPower())
        } else ""
    }

    private fun getSource(item: Item): String {
        val sb = StringBuilder()
        for (resId in item.getSource()) {
            sb.append("- ").append(getString(resId)).append("\n")
        }
        return if (sb.isEmpty()) "" else sb.substring(0, sb.length - 1)
    }

    private fun populateCraftLayout(craftBinding: LayoutCraftBinding, recipes: Recipes?) {
        if (recipes == null) {
            craftBinding.root.visibility = View.GONE
            return
        }
        val resultItem = recipes.getResult()
        val ingredients = recipes.getIngredients()

        craftBinding.root.visibility = View.VISIBLE
        if (resultItem != null) {
            craftBinding.result.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, resultItem.getIdImage(), context?.theme)
            )
            craftBinding.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(resultItem.getRarity()))
            craftBinding.result.stack.text = "1"
            craftBinding.result.root.setOnClickListener { openItemDetail(resultItem) }
        }

        val ing0 = ingredients.getOrNull(0)
        if (ing0 != null) {
            craftBinding.ingredient1.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, ing0.getIdImage(), context?.theme)
            )
            craftBinding.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing0.getRarity()))
            craftBinding.ingredient1.stack.text = ing0.getStack().toString()
            craftBinding.ingredient1.root.setOnClickListener { openItemDetail(ing0) }
        }

        val ing1 = ingredients.getOrNull(1)
        if (ing1 != null) {
            craftBinding.plusSign1.visibility = View.VISIBLE
            craftBinding.ingredient2.root.visibility = View.VISIBLE
            craftBinding.ingredient2.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, ing1.getIdImage(), context?.theme)
            )
            craftBinding.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing1.getRarity()))
            craftBinding.ingredient2.stack.text = ing1.getStack().toString()
            craftBinding.ingredient2.root.setOnClickListener { openItemDetail(ing1) }
        } else {
            craftBinding.plusSign1.visibility = View.GONE
            craftBinding.ingredient2.root.visibility = View.GONE
        }

        val ing2 = ingredients.getOrNull(2)
        if (ing2 != null) {
            craftBinding.plusSign2.visibility = View.VISIBLE
            craftBinding.ingredient3.root.visibility = View.VISIBLE
            craftBinding.ingredient3.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, ing2.getIdImage(), context?.theme)
            )
            craftBinding.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing2.getRarity()))
            craftBinding.ingredient3.stack.text = ing2.getStack().toString()
            craftBinding.ingredient3.root.setOnClickListener { openItemDetail(ing2) }
        } else {
            craftBinding.plusSign2.visibility = View.GONE
            craftBinding.ingredient3.root.visibility = View.GONE
        }

        val ing3 = ingredients.getOrNull(3)
        if (ing3 != null) {
            craftBinding.plusSign3.visibility = View.VISIBLE
            craftBinding.ingredient4.root.visibility = View.VISIBLE
            craftBinding.ingredient4.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, ing3.getIdImage(), context?.theme)
            )
            craftBinding.ingredient4.image.setBackgroundResource(UIUtils.backgroundFromRarity(ing3.getRarity()))
            craftBinding.ingredient4.stack.text = ing3.getStack().toString()
            craftBinding.ingredient4.root.setOnClickListener { openItemDetail(ing3) }
        } else {
            craftBinding.plusSign3.visibility = View.GONE
            craftBinding.ingredient4.root.visibility = View.GONE
        }
    }

    fun openItemDetail(item: Item) {
        if (items.isNotEmpty() && item == items[0]) return
        items.add(0, item)
        dialog?.setTitle(getString(item.getIdName()))
        initialize(null)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.close.setOnClickListener { dismiss() }
        b.back.setOnClickListener {
            if (items.isNotEmpty()) {
                items.removeAt(0)
                if (items.isNotEmpty()) {
                    dialog?.setTitle(getString(items[0].getIdName()))
                    initialize(null)
                }
            }
        }
        b.craft.setOnClickListener {
            if (MainActivity.shownDialogCraft != null) return@setOnClickListener
            if (items.isEmpty()) return@setOnClickListener
            val dialogCraft = DialogCraft()
            dialogCraft.recipe = Recipes.into(items[0])
            dialogCraft.show(MainActivity.headquartersFragment.parentFragmentManager, "craft")
        }
        b.consume.setOnClickListener {
            if (items.isEmpty()) return@setOnClickListener
            val index = MainActivity.data.items.indexOf(items[0])
            val item = if (index == -1) Item.getInstance(items[0].getTrueClass() ?: "", 0) else MainActivity.data.items[index]
            if (item == null) return@setOnClickListener

            if (item is XPBook1 || item is XPBook2 || item is XPBook3 || item is XPBook10) {
                if (item.stack > 0) {
                    val dialog = DialogConsumeXPBook()
                    dialog.selectedBook = item as Consumable
                    dialog.show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_xpbook")
                }
                return@setOnClickListener
            } else if (item is Evo22Vial) {
                if (item.stack > 0) {
                    val dialog = DialogConsumeEvo22()
                    dialog.show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_evo22")
                }
                return@setOnClickListener
            }

            if (item is Potion) {
                if (MainActivity.shownDialogConsumePotion != null) return@setOnClickListener
                val dialog = DialogConsumePotion()
                dialog.selected = item
                dialog.show(MainActivity.headquartersFragment.parentFragmentManager, "consume_potion")
                return@setOnClickListener
            }

            if ("Geode" == item.getTrueClass()) {
                if (item.getStack() <= 0) return@setOnClickListener
                var gemsGained = 0
                for (i in 0 until item.getStack()) {
                    val preset = item.getGemValue()
                    gemsGained += if (preset != null) preset else if (Utils.random() < 0.01) 100 else 1
                }
                QuestsManager.increment(QuestsManager.paleontologist, item.getStack().toLong())
                Utils.removeItemFromStorage(item)
                item.setStack(0)
                MainActivity.data.gems += gemsGained.toLong()
                initialize(null)
                MainActivity.shownDialogStorage?.update()
                MainActivity.headquartersFragment.refresh()
                (MainActivity.dungeonsFragment.activity as? MainActivity)?.refreshGems()

                if (consumeDialog != null) return@setOnClickListener
                val dialog = UIUtils.getInfoDialog(
                    context,
                    R.string.consume_geode_title,
                    String.format(getString(R.string.consume_geode_body), gemsGained),
                    false
                )
                consumeDialog = dialog
                dialog.setOnDismissListener { consumeDialog = null }
                dialog.show()
                return@setOnClickListener
            }

            if (item is Egg) {
                if (item.getStack() <= 0) return@setOnClickListener
                if (MainActivity.data.pets.size >= Formulas.shelterCapacity()) {
                    if (consumeDialog != null) return@setOnClickListener
                    val dialog = UIUtils.getInfoDialog(
                        context,
                        R.string.consume_egg_no_spaces_title,
                        getString(R.string.consume_egg_no_spaces_body),
                        false
                    )
                    consumeDialog = dialog
                    dialog.setOnDismissListener { consumeDialog = null }
                    dialog.show()
                    return@setOnClickListener
                }
                val hatchedPet = item.hatch()
                if (hatchedPet != null) {
                    MainActivity.data.pets.add(hatchedPet)
                    val eggUnit = Item.getInstance(item.getTrueClass() ?: "", 1)
                    if (eggUnit != null) {
                        Utils.removeItemFromStorage(eggUnit)
                    }
                    initialize(null)
                    MainActivity.shownDialogStorage?.update()
                    MainActivity.headquartersFragment.refresh()
                    if (!MainActivity.data.isT4Pet && hatchedPet.abilityNumber == 4) {
                        MainActivity.data.isT4Pet = true
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RARE_SPECIMEN)
                    }
                    val petDetail = DialogPetDetail()
                    petDetail.pet = hatchedPet
                    petDetail.show(parentFragmentManager, "pet_detail")
                }
                return@setOnClickListener
            }

            if (item is Food) {
                if (MainActivity.shownDialogConsumeFood != null) return@setOnClickListener
                val dialog = DialogConsumeFood()
                dialog.selected = item
                dialog.show(MainActivity.headquartersFragment.parentFragmentManager, "consume_food")
                return@setOnClickListener
            }

            if (item is Evo23Vial) {
                if (MainActivity.shownDialogConsumeEvo23 == null && item.getStack() > 0) {
                    DialogConsumeEvo23().show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_evo23")
                }
                return@setOnClickListener
            }

            if (item is Evo23Vial2) {
                if (MainActivity.shownDialogConsumeEvo23 == null && item.getStack() > 0) {
                    val dialog = DialogConsumeEvo23()
                    dialog.alternative = true
                    dialog.show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_evo23")
                }
                return@setOnClickListener
            }

            if (item is Intercession) {
                if (MainActivity.shownDialogConsumeIntercession == null && item.getStack() > 0) {
                    DialogConsumeIntercession().show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_intercession")
                }
                return@setOnClickListener
            }

            if (item is PotionOfRejuvenation) {
                if (MainActivity.shownDialogConsumePotionOfRejuvenation == null && item.getStack() > 0) {
                    DialogConsumePotionOfRejuvenation().show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_potion_of_rejuvenation")
                }
                return@setOnClickListener
            }

            if (item is PotionOfClumsiness && MainActivity.shownDialogConsumePotionOfClumsiness == null && item.getStack() > 0) {
                DialogConsumePotionOfClumsiness().show(MainActivity.headquartersFragment.parentFragmentManager, "dialog_consume_potion_of_clumsiness")
            }
        }

        b.sell.setOnClickListener {
            if (MainActivity.shownDialogSell != null || items.isEmpty()) return@setOnClickListener
            val dialogSell = DialogSell()
            dialogSell.item = items[0]
            dialogSell.show(MainActivity.headquartersFragment.parentFragmentManager, "sell")
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogItemDetail = this
    }

    override fun onStop() {
        MainActivity.shownDialogItemDetail = null
        super.onStop()
    }
}
