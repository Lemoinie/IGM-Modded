package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMerchantBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
import java.util.ArrayList
import java.util.function.BooleanSupplier

class DialogMerchant : CustomDialog() {
    @JvmField
    var binding: DialogMerchantBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogMerchantBinding
    }

    override fun getTitle(): String = getString(R.string.merchant_dialog_title)

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogMerchantBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.newRegular.visibility = if (MainActivity.data.isNewMerchantRegularItems) 0 else 4
        b.newSpecial.visibility = if (MainActivity.data.isNewMerchantSpecialItems) 0 else 4
        MainActivity.data.isNewMerchantRegularItems = false
        MainActivity.data.isNewMerchantSpecialItems = false
        (activity as? MainActivity)?.refreshIcons()

        val regularItems = ArrayList<Item>()
        for (offer in MainActivity.data.merchantRegularStockItems) {
            offer.item?.let { regularItems.add(it) }
        }
        b.regularItemGrid.adapter = UIUtils.getItemsGridAdapter(context, regularItems) as ListAdapter

        val specialItems = ArrayList<Item>()
        for (offer in MainActivity.data.merchantSpecialReserve) {
            offer.item?.let { specialItems.add(it) }
        }
        b.specialItemGrid.adapter = UIUtils.getItemsGridAdapter(context, specialItems) as ListAdapter

        val isRegularEmpty = MainActivity.data.merchantRegularStockItems.isEmpty()
        b.regularItemGrid.visibility = if (isRegularEmpty) 8 else 0
        b.noRegularItems.visibility = if (isRegularEmpty) 0 else 8

        val isSpecialEmpty = MainActivity.data.merchantSpecialReserve.isEmpty()
        b.specialItemGrid.visibility = if (isSpecialEmpty) 8 else 0
        b.noSpecialItems.visibility = if (isSpecialEmpty) 0 else 8

        Utils.refreshCooldowns(TrueTimeUtils.millis())
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.regularItemGrid.setOnItemClickListener { _, _, position, _ ->
            openBuyDialog(MainActivity.data.merchantRegularStockItems[position], false)
        }
        b.specialItemGrid.setOnItemClickListener { _, _, position, _ ->
            openBuyDialog(MainActivity.data.merchantSpecialReserve[position], true)
        }
        b.regularItemGrid.setOnItemLongClickListener { _, _, position, _ ->
            MainActivity.data.merchantRegularStockItems[position].item?.let { item ->
                UIUtils.vibrate(context)
                UIUtils.openItemDetail(item)
            }
            true
        }
        b.specialItemGrid.setOnItemLongClickListener { _, _, position, _ ->
            MainActivity.data.merchantSpecialReserve[position].item?.let { item ->
                UIUtils.vibrate(context)
                UIUtils.openItemDetail(item)
            }
            true
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    private fun openBuyDialog(merchantOffer: MerchantOffer, isSpecial: Boolean) {
        if (MainActivity.shownDialogBuyFromMerchant != null) {
            return
        }
        val dialog = DialogBuyFromMerchant()
        dialog.offer = merchantOffer
        dialog.callback = BooleanSupplier {
            handleBuy(merchantOffer, isSpecial)
        }
        dialog.show(parentFragmentManager, "select_equipment")
    }

    private fun handleBuy(merchantOffer: MerchantOffer, isSpecial: Boolean): Boolean {
        val offerItem = merchantOffer.item ?: return false
        if (offerItem !is Upgrade && Utils.remainingInventorySpaceAfterCollecting(false, offerItem) < 0) {
            MainActivity.shownDialogBuyFromMerchant?.writeError(getString(R.string.error_not_enough_space))
            return false
        }
        if (merchantOffer.isGems) {
            val gems = MainActivity.data.gems - merchantOffer.price
            if (gems < 0) {
                MainActivity.shownDialogBuyFromMerchant?.writeError(getString(R.string.error_not_enough_gems))
                return false
            }
            MainActivity.data.gems = gems
            (activity as? MainActivity)?.refreshGems()
        } else {
            val money = MainActivity.data.money - merchantOffer.price
            if (money < 0) {
                MainActivity.shownDialogBuyFromMerchant?.writeError(getString(R.string.error_not_enough_money))
                return false
            }
            MainActivity.data.money = money
            (activity as? MainActivity)?.refreshMoney()
        }

        if (isSpecial) {
            MainActivity.data.merchantSpecialReserve.remove(merchantOffer)
        } else {
            MainActivity.data.merchantRegularStockItems.remove(merchantOffer)
        }

        if (offerItem.getUniqueOrigin() != null) {
            MainActivity.data.uniqueItemsLost.remove(offerItem.getUniqueOrigin())
        }

        if (offerItem is Upgrade) {
            (offerItem as Upgrade).use()
        } else {
            Utils.collectItem(offerItem, MainActivity.data.items)
        }

        MainActivity.headquartersFragment?.refresh()
        initialize(null)
        return true
    }

    fun refreshCooldowns(days: Int, hours: Int, minutes: Int) {
        binding?.regularItemsCountdown?.text = String.format(getString(R.string.time_hours_minutes), hours, minutes)
        binding?.specialItemsCountdown?.text = String.format(getString(R.string.time_days_hours_minutes), days, hours, minutes)
    }

    fun newItems() {
        MainActivity.shownDialogBuyFromMerchant?.dismiss()
        initialize(null)
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogMerchant = this
    }

    override fun onStop() {
        MainActivity.shownDialogMerchant = null
        super.onStop()
    }
}
