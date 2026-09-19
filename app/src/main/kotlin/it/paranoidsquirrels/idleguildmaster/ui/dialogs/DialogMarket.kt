package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import androidx.work.WorkRequest
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMarketBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutMarketItemBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction

class DialogMarket : CustomDialog() {
    companion object {
        private const val MAX_LEVEL_LISTINGS = 10
        private const val MAX_LEVEL_TIME = 25
    }

    @JvmField
    var binding: DialogMarketBinding? = null
    private var cancel: AlertDialog? = null
    private var upgradeConfirm: AlertDialog? = null
    private var soldInThisInstance = 0

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogMarketBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_market_name)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogMarketBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        updateUpgrades()
        populateListings()
        updateAnimation()
        updateVisibility()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgradeListings.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpMarketListings()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_market_upgrade_queue) { _, _ ->
                    levelUpMarketListings()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }

        b.buttonUpgradeTime.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpMarketTime()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_market_upgrade_time) { _, _ ->
                    levelUpMarketTime()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }

        b.exit.setOnClickListener { dismiss() }
    }

    private fun populateListings() {
        val b = binding ?: return
        b.list.removeAllViews()
        for (itemAction in MainActivity.data.soldMarketItems) {
            b.list.addView(getItemLayout(itemAction, true).root)
        }
        for (itemAction in MainActivity.data.marketListings) {
            b.list.addView(getItemLayout(itemAction, false).root)
        }
    }

    private fun updateUpgrades() {
        val b = binding ?: return
        b.description1.text = String.format(
            getString(R.string.headquarters_market_description_long_1),
            Formulas.marketListings()
        )
        b.description2.text = String.format(
            getString(R.string.headquarters_market_description_long_2),
            UIUtils.formatDouble2Decimals(1.0 / Math.pow(0.9, (MainActivity.data.levelMarketTime + MainActivity.data.upgradeMarketTime).toDouble()))
        )

        val listingsPrice = Formulas.getMarketListingsPrice()
        UIUtils.populateMoneyContainer(b.money, listingsPrice, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= listingsPrice)
        b.buttonUpgradeListings.visibility = if (MainActivity.data.levelMarketListings >= MAX_LEVEL_LISTINGS) View.GONE else View.VISIBLE

        val timePrice = Formulas.getMarketTimePrice()
        UIUtils.populateMoneyContainer(b.money2, timePrice, true)
        UIUtils.changeMoneyContainerColor(b.money2, MainActivity.data.money >= timePrice)
        b.buttonUpgradeTime.visibility = if (MainActivity.data.levelMarketTime >= MAX_LEVEL_TIME) View.GONE else View.VISIBLE
    }

    private fun updateVisibility() {
        val b = binding ?: return
        val marketSpeedBonus = (if (MainActivity.data.isApprenticeMerchantPurchased) 20 else 0) +
            (if (MainActivity.data.isJourneymanMerchantPurchased) 40 else 0) +
            (if (MainActivity.data.isMerchantPackPurchased) 40 else 0) +
            (if (MainActivity.data.isTradeBaronPurchased) 60 else 0)
        b.merchantPackBonus.visibility = if (marketSpeedBonus > 0) View.VISIBLE else View.GONE
        if (marketSpeedBonus > 0) {
            b.merchantPackBonus.text = "+ $marketSpeedBonus%"
        }
        b.scrollView.visibility = if (b.list.childCount > 0) View.VISIBLE else View.GONE
        b.emptyList.visibility = if (b.list.childCount > 0) View.GONE else View.VISIBLE
    }

    fun completeItem() {
        val b = binding ?: return
        val childIndex = MainActivity.data.soldMarketItems.size - 1
        val child = b.list.getChildAt(childIndex) ?: return
        child.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        val textView = child.findViewById<TextView>(R.id.time_to_completion)
        textView.text = getString(R.string.sold)
        textView.setTextColor(resources.getColor(R.color.brass_border, context?.theme))
        child.findViewById<View>(R.id.price_container).visibility = View.VISIBLE
        child.findViewById<View>(R.id.cancel).visibility = View.GONE
        updateAnimation()
    }

    fun updateCountdown() {
        val b = binding ?: return
        if (MainActivity.data.marketListings.isEmpty()) return
        val child = b.list.getChildAt(MainActivity.data.soldMarketItems.size) ?: return
        val textView = child.findViewById<TextView>(R.id.time_to_completion)
        val itemAction = MainActivity.data.marketListings[0]
        val item = itemAction.item ?: return
        textView.text = UIUtils.formatSeconds(item.getSecondsToSell() - itemAction.secondsPassed)
    }

    fun addListing(itemAction: ItemAction) {
        val b = binding ?: return
        b.list.addView(getItemLayout(itemAction, false).root)
        updateVisibility()
        if (MainActivity.data.marketListings.size == 1) {
            updateAnimation()
        }
    }

    private fun updateAnimation() {
        val b = binding ?: return
        if (MainActivity.data.marketListings.isEmpty()) return
        val child = b.list.getChildAt(MainActivity.data.soldMarketItems.size) ?: return
        val progressBar = child.findViewById<ProgressBar>(R.id.progressBar) ?: return
        val itemAction = MainActivity.data.marketListings[0]
        val item = itemAction.item ?: return

        val fMillis = ((((TrueTimeUtils.millis() - MainActivity.data.lastAccess) / 1000.0) + itemAction.secondsPassed) / item.getSecondsToSell()).toFloat()
        val animator = ValueAnimator.ofInt(Math.round(fMillis * 1000.0f), 1000)
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { anim ->
            progressBar.progress = anim.animatedValue as Int
        }
        animator.duration = Math.max(0L, ((1.0f - fMillis) * 1000.0f * item.getSecondsToSell()).toLong() + 1000L)
        animator.start()
    }

    private fun getItemLayout(itemAction: ItemAction, isSold: Boolean): LayoutMarketItemBinding {
        val itemBinding = LayoutMarketItemBinding.inflate(layoutInflater, binding?.list, false)
        val item = itemAction.item
        if (item != null) {
            itemBinding.name.setText(item.getIdName())
            itemBinding.item.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, item.getIdImage(), context?.theme)
            )
            itemBinding.item.image.setBackgroundResource(R.drawable.object_border_rounded_left)
            itemBinding.item.stack.text = item.getStack().toString()
            itemBinding.progressBar.visibility = if (isSold) View.GONE else View.VISIBLE
            itemBinding.progressBar.progress = ((itemAction.secondsPassed * 1000) / item.getSecondsToSell()).toInt()
            itemBinding.timeToCompletion.text = if (isSold) getString(R.string.sold) else UIUtils.formatSeconds(item.getSecondsToSell() - itemAction.secondsPassed)
            itemBinding.timeToCompletion.setTextColor(
                resources.getColor(if (isSold) R.color.brass_border else R.color.dim_white, context?.theme)
            )
            UIUtils.populateMoneyContainer(itemBinding.price, item.getPrice() * item.getStack().toLong(), true)
            val brassColor = resources.getColor(R.color.brass_border, context?.theme)
            itemBinding.price.amountCopper.setTextColor(brassColor)
            itemBinding.price.amountDiamond.setTextColor(brassColor)
            itemBinding.price.amountSilver.setTextColor(brassColor)
            itemBinding.price.amountGold.setTextColor(brassColor)
            itemBinding.price.amountPlatinum.setTextColor(brassColor)

            itemBinding.priceContainer.setOnClickListener { collect(itemAction) }
            itemBinding.priceContainer.visibility = if (isSold) View.VISIBLE else View.GONE

            itemBinding.cancel.setOnClickListener { cancel(itemAction) }
            itemBinding.cancel.visibility = if (isSold) View.GONE else View.VISIBLE

            itemBinding.containerItemWorkshop.setOnClickListener {
                UIUtils.openItemDetail(item)
            }
        }
        return itemBinding
    }

    private fun collect(itemAction: ItemAction) {
        val b = binding ?: return
        val item = itemAction.item ?: return
        if (MainActivity.data.soldMarketItems.contains(itemAction)) {
            val index = MainActivity.data.soldMarketItems.indexOf(itemAction)
            b.list.removeView(b.list.getChildAt(index))
            MainActivity.data.soldMarketItems.remove(itemAction)
            val money = MainActivity.data.money + (item.getPrice() * item.getStack().toLong())
            MainActivity.data.money = money

            if (MainActivity.data.maxWealth < 1000000L) {
                if (MainActivity.data.maxWealth < WorkRequest.MIN_BACKOFF_MILLIS && money >= WorkRequest.MIN_BACKOFF_MILLIS) {
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_WEALTHY)
                }
                if (money >= 1000000L) {
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FILTHY_RICH)
                }
                MainActivity.data.maxWealth = Math.max(MainActivity.data.maxWealth, money)
            }
            soldInThisInstance += item.getStack()
            val unique = item.getUniqueOrigin()
            if (unique != null) {
                MainActivity.data.uniqueItemsLost.add(unique)
            }
            updateVisibility()
            updateUpgrades()
            MainActivity.headquartersFragment.refresh()
            (activity as? MainActivity)?.refresh()
        }
    }

    private fun cancel(itemAction: ItemAction) {
        val item = itemAction.item ?: return
        if (Formulas.storageSpaces() <= MainActivity.data.items.size && !MainActivity.data.items.contains(item)) {
            if (MainActivity.shownDialogFullStorage != null) return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                getString(R.string.no_storage_space_body_cancel_listing),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
            dialog.show()
            return
        }

        if (cancel != null) return
        val dialog = UIUtils.getActionDialog(
            context,
            R.string.cancel,
            String.format(
                getString(R.string.cancel_listing_confirmation),
                item.getStack(),
                getString(item.getIdName())
            ),
            R.string.yes
        ) { _, _ -> refund(itemAction) }
        cancel = dialog
        dialog.setOnDismissListener { cancel = null }
        dialog.show()
    }

    private fun refund(itemAction: ItemAction) {
        val b = binding ?: return
        val item = itemAction.item ?: return
        if (MainActivity.data.marketListings.contains(itemAction)) {
            val index = MainActivity.data.marketListings.indexOf(itemAction)
            b.list.removeView(b.list.getChildAt(MainActivity.data.soldMarketItems.size + index))
            MainActivity.data.marketListings.remove(itemAction)
            val refundItem = Item.getInstance(item.getTrueClass() ?: "", item.getStack())
            if (refundItem != null) {
                Utils.collectItem(refundItem, MainActivity.data.items)
            }
            updateVisibility()
            if (index == 0) {
                updateAnimation()
            }
            MainActivity.headquartersFragment.refresh()
        }
    }

    private fun levelUpMarketListings() {
        val price = Formulas.getMarketListingsPrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelMarketListings += 1
        updateUpgrades()
        (activity as? MainActivity)?.refresh()
    }

    private fun levelUpMarketTime() {
        val price = Formulas.getMarketTimePrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelMarketTime += 1
        initialize(null)
        (activity as? MainActivity)?.refresh()
    }

    override fun onStart() {
        super.onStart()
        soldInThisInstance = 0
        MainActivity.shownDialogMarket = this
    }

    override fun onStop() {
        val itemsSold = MainActivity.data.itemsSold
        val count = soldInThisInstance
        if (itemsSold < WorkRequest.MIN_BACKOFF_MILLIS && count > 0) {
            if (itemsSold < 100L) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_APPRENTICE_MERCHANT, count)
            }
            if (itemsSold < 1000L) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_SEASONED_MERCHANT, count)
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_LEGENDARY_MERCHANT, count)
            MainActivity.data.itemsCrafted = Math.min(WorkRequest.MIN_BACKOFF_MILLIS, itemsSold + count.toLong())
        }
        MainActivity.shownDialogMarket = null
        super.onStop()
    }
}
