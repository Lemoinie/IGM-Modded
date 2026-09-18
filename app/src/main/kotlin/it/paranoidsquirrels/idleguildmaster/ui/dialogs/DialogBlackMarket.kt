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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBlackMarketBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
import java.util.ArrayList
import java.util.function.BooleanSupplier

/**
 * Nocturnal Black Market stall: a 12-slot grid of smuggled goods, contraband and
 * discounted guild upgrades, with a departure countdown to the next daily reset.
 * Reached from the top-bar icon while [Data.isBlackMarketActive].
 */
class DialogBlackMarket : CustomDialog() {
    @JvmField
    var binding: DialogBlackMarketBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogBlackMarketBinding
    }

    override fun getTitle(): String = getString(R.string.black_market_dialog_title)

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogBlackMarketBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        MainActivity.data.isNewBlackMarketItems = false
        (activity as? MainActivity)?.refreshIcons()

        val items = ArrayList<Item>()
        for (offer in MainActivity.data.blackMarketStock) {
            offer.item?.let { items.add(it) }
        }
        b.itemGrid.adapter = UIUtils.getItemsGridAdapter(context, items) as ListAdapter

        val isEmpty = MainActivity.data.blackMarketStock.isEmpty()
        b.itemGrid.visibility = if (isEmpty) 8 else 0
        b.noItems.visibility = if (isEmpty) 0 else 8

        // Show the departure countdown (plain text, tavern style): time left until the next daily reset.
        val remaining = (Utils.ONE_DAY_IN_MILLISECONDS - (TrueTimeUtils.millis() - MainActivity.data.last24Triggered)) / 60000L
        val days = (remaining / 1440L).toInt().coerceAtLeast(0)
        val rest = remaining % 1440L
        val hours = (rest / 60L).toInt().coerceAtLeast(0)
        val minutes = (rest % 60L).toInt().coerceAtLeast(0)
        refreshCountdown(days, hours, minutes)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.itemGrid.setOnItemClickListener { _, _, position, _ ->
            openBuyDialog(MainActivity.data.blackMarketStock[position])
        }
        b.itemGrid.setOnItemLongClickListener { _, _, position, _ ->
            MainActivity.data.blackMarketStock[position].item?.let { item ->
                UIUtils.vibrate(context)
                UIUtils.openItemDetail(item)
            }
            true
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    fun refreshCountdown(days: Int, hours: Int, minutes: Int) {
        val text = String.format(getString(R.string.time_days_hours_minutes), days, hours, minutes)
        binding?.itemsHeader?.text = text
    }

    fun newItems() {
        MainActivity.shownDialogBuyFromMerchant?.dismiss()
        initialize(null)
    }

    private fun openBuyDialog(merchantOffer: MerchantOffer) {
        if (MainActivity.shownDialogBuyFromMerchant != null) {
            return
        }
        val dialog = DialogBuyFromMerchant()
        dialog.offer = merchantOffer
        dialog.callback = BooleanSupplier {
            handleBuy(merchantOffer)
        }
        dialog.show(parentFragmentManager, "select_equipment")
    }

    private fun handleBuy(merchantOffer: MerchantOffer): Boolean {
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

        MainActivity.data.blackMarketStock.remove(merchantOffer)

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

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogBlackMarket = this
    }

    override fun onStop() {
        MainActivity.shownDialogBlackMarket = null
        super.onStop()
    }
}