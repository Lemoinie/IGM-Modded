package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogStorageBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import java.util.ArrayList

class DialogStorage : CustomDialog() {
    companion object {
        const val MAX_STORAGE_LEVEL: Int = 80
    }

    private var adapter: ArrayAdapter<Item>? = null
    @JvmField
    var binding: DialogStorageBinding? = null
    private var filtersHidden: Boolean = true
    private var items: MutableList<Item> = ArrayList()
    private var upgradeConfirm: AlertDialog? = null
    private var cantSell: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogStorageBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_storage_name)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogStorageBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        refreshSpaces()
        val b = binding ?: return
        b.radiobuttonType.isChecked = true
        b.radiobuttonAll.isChecked = true
        filtersHidden = true
        configureFiltersVisibility()
        configureVisibility()
    }

    private fun configureFiltersVisibility() {
        val b = binding ?: return
        configureFilterVisibility(b.radiobuttonAll)
        configureFilterVisibility(b.radiobuttonMaterials)
        configureFilterVisibility(b.radiobuttonWeapons)
        configureFilterVisibility(b.radiobuttonArmors)
        configureFilterVisibility(b.radiobuttonAccessories)
        configureFilterVisibility(b.radiobuttonConsumables)
        configureFilterVisibility(b.radiobuttonType)
        configureFilterVisibility(b.radiobuttonQuantity)
        configureFilterVisibility(b.radiobuttonAlphabetical)
        configureFilterVisibility(b.radiobuttonPriceUnit)
        configureFilterVisibility(b.radiobuttonPriceTotal)
    }

    private fun configureFilterVisibility(radioButton: RadioButton) {
        radioButton.visibility = if (!filtersHidden || radioButton.isChecked) View.VISIBLE else View.GONE
    }

    private fun configureOrder() {
        val b = binding ?: return
        when (b.radioGroupOrderBy.checkedRadioButtonId) {
            b.radiobuttonType.id -> items.sortWith(Utils.itemsByTypeComparator)
            b.radiobuttonQuantity.id -> items.sortBy { -it.getStack() }
            b.radiobuttonAlphabetical.id -> items.sortBy { getString(it.getIdName()) }
            b.radiobuttonPriceUnit.id -> items.sortBy { -it.getPrice() }
            b.radiobuttonPriceTotal.id -> items.sortBy { -it.getPrice() * it.getStack().toLong() }
        }
        adapter?.notifyDataSetChanged()
        b.noItemsTooltip.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
        b.itemGrid.visibility = if (items.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    private fun configureVisibility() {
        val b = binding ?: return
        val checkedId = b.radioGroupVisibility.checkedRadioButtonId
        items = ArrayList(MainActivity.data.items)
        when (checkedId) {
            b.radiobuttonMaterials.id -> items.removeAll { it is Equipment || it is Consumable }
            b.radiobuttonWeapons.id -> items.removeAll { it !is Weapon }
            b.radiobuttonArmors.id -> items.removeAll { it !is Armor }
            b.radiobuttonAccessories.id -> items.removeAll { it !is Accessory }
            b.radiobuttonConsumables.id -> items.removeAll { it !is Consumable }
        }
        adapter = UIUtils.getItemsGridAdapter(context, items)
        b.itemGrid.adapter = adapter
        configureOrder()
    }

    fun update() {
        refreshSpaces()
        items.removeAll { it.getStack() == 0 }
        adapter?.notifyDataSetChanged()
        val b = binding ?: return
        b.noItemsTooltip.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
        b.itemGrid.visibility = if (items.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgradeSpaces.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpStorageSpaces()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_storage_upgrade_capacity) { _, _ ->
                    levelUpStorageSpaces()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                upgradeConfirm?.show()
            }
        }

        b.itemGrid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            UIUtils.openItemDetail(items[position])
        }

        b.itemGrid.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val item = items[position]
            UIUtils.vibrate(context)
            if (item.isNotSellable()) {
                if (cantSell != null) return@OnItemLongClickListener true
                val dialog = UIUtils.getInfoDialog(
                    context,
                    R.string.headquarters_storage_dialog_not_sellable_title,
                    getString(R.string.headquarters_storage_dialog_not_sellable_body),
                    false
                )
                cantSell = dialog
                dialog.setOnDismissListener { cantSell = null }
                cantSell?.show()
            } else {
                val dialogSell = DialogSell()
                dialogSell.item = item
                dialogSell.show(MainActivity.headquartersFragment.parentFragmentManager, "sell")
            }
            true
        }

        b.filtersArrow.setOnClickListener {
            b.filtersArrow.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    if (filtersHidden) R.drawable.menu_lift else R.drawable.menu_drop,
                    context?.theme
                )
            )
            filtersHidden = !filtersHidden
            configureFiltersVisibility()
            b.buttonUpgradeSpaces.visibility = if (!filtersHidden || MainActivity.data.levelStorage >= MAX_STORAGE_LEVEL) View.GONE else View.VISIBLE
        }

        b.radioGroupOrderBy.setOnCheckedChangeListener { _, _ -> configureOrder() }
        b.radioGroupVisibility.setOnCheckedChangeListener { _, _ -> configureVisibility() }
        b.close.setOnClickListener { dismiss() }
    }

    private fun levelUpStorageSpaces() {
        val price = Formulas.getStorageCapacityPrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelStorage += 1
        refreshSpaces()
        (activity as? MainActivity)?.refresh()
        MainActivity.headquartersFragment.refresh()
    }

    private fun refreshSpaces() {
        val b = binding ?: return
        val price = Formulas.getStorageCapacityPrice()
        UIUtils.populateMoneyContainer(b.money, price, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= price)
        b.description.text = String.format(
            getString(R.string.headquarters_storage_description_long),
            MainActivity.data.items.size,
            Formulas.storageSpaces()
        )
        b.buttonUpgradeSpaces.visibility = if (MainActivity.data.levelStorage >= MAX_STORAGE_LEVEL) View.GONE else View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogStorage = this
    }

    override fun onStop() {
        MainActivity.shownDialogStorage = null
        super.onStop()
    }
}
