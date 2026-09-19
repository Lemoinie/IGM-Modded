package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogWorkshopBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutWorkshopItemBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.CopperArmor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Leather
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class DialogWorkshop : CustomDialog() {
    companion object {
        private const val MAX_LEVEL_QUEUE = 10
        private const val MAX_LEVEL_TIME = 25
    }

    @JvmField
    var binding: DialogWorkshopBinding? = null
    private var cancel: AlertDialog? = null
    private var upgradeConfirm: AlertDialog? = null
    private var craftedInThisInstance = 0

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogWorkshopBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_workshop_name)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogWorkshopBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        updateUpgrades()
        populateCraftingList()
        updateAnimation()
        updateVisibility()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgradeQueue.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpWorkshopQueue()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_workshop_upgrade_queue) { _, _ ->
                    levelUpWorkshopQueue()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }

        b.buttonUpgradeTime.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpWorkshopTime()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_workshop_upgrade_time) { _, _ ->
                    levelUpWorkshopTime()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }

        b.exit.setOnClickListener { dismiss() }

        b.recipes.setOnClickListener {
            if (MainActivity.shownDialogRecipes == null) {
                DialogRecipes().show(parentFragmentManager, "dialog_recipes")
            }
        }
    }

    private fun populateCraftingList() {
        val b = binding ?: return
        b.list.removeAllViews()
        for (itemAction in MainActivity.data.completedWorkshopItems) {
            b.list.addView(getItemLayout(itemAction, true).root)
        }
        for (itemAction in MainActivity.data.workshopQueue) {
            b.list.addView(getItemLayout(itemAction, false).root)
        }
    }

    private fun updateUpgrades() {
        val b = binding ?: return
        b.description1.text = String.format(
            getString(R.string.headquarters_workshop_description_long_1),
            Formulas.workshopQueue()
        )
        b.description2.text = String.format(
            getString(R.string.headquarters_workshop_description_long_2),
            UIUtils.formatDouble2Decimals(1.0 / Math.pow(0.9, (MainActivity.data.levelWorkshopTime + MainActivity.data.upgradeWorkshopTime).toDouble()))
        )

        val queuePrice = Formulas.getWorkshopQueuePrice()
        UIUtils.populateMoneyContainer(b.money, queuePrice, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= queuePrice)
        b.buttonUpgradeQueue.visibility = if (MainActivity.data.levelWorkshopQueue >= MAX_LEVEL_QUEUE) View.GONE else View.VISIBLE

        val timePrice = Formulas.getWorkshopTimePrice()
        UIUtils.populateMoneyContainer(b.money2, timePrice, true)
        UIUtils.changeMoneyContainerColor(b.money2, MainActivity.data.money >= timePrice)
        b.buttonUpgradeTime.visibility = if (MainActivity.data.levelWorkshopTime >= MAX_LEVEL_TIME) View.GONE else View.VISIBLE
    }

    private fun updateVisibility() {
        val b = binding ?: return
        val workshopSpeedBonus = (if (MainActivity.data.isApprenticeWorkshopPurchased) 20 else 0) +
            (if (MainActivity.data.isJourneymanWorkshopPurchased) 40 else 0) +
            (if (MainActivity.data.isMasterWorkshopPurchased) 40 else 0) +
            (if (MainActivity.data.isGrandmasterWorkshopPurchased) 60 else 0)
        b.merchantPackBonus.visibility = if (workshopSpeedBonus > 0) View.VISIBLE else View.GONE
        if (workshopSpeedBonus > 0) {
            b.merchantPackBonus.text = "+ $workshopSpeedBonus%"
        }
        b.scrollView.visibility = if (b.list.childCount > 0) View.VISIBLE else View.GONE
        b.emptyList.visibility = if (b.list.childCount > 0) View.GONE else View.VISIBLE
    }

    fun completeItem() {
        val b = binding ?: return
        val childIndex = MainActivity.data.completedWorkshopItems.size - 1
        val child = b.list.getChildAt(childIndex) ?: return
        child.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        val textView = child.findViewById<TextView>(R.id.time_to_completion)
        textView.text = getString(R.string.complete)
        textView.setTextColor(resources.getColor(R.color.brass_border, context?.theme))
        val imageView = child.findViewById<ImageView>(R.id.action)
        imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.check_brass, context?.theme))
        imageView.setOnClickListener {
            collect(MainActivity.data.completedWorkshopItems[MainActivity.data.completedWorkshopItems.size - 1])
        }
        updateAnimation()
    }

    fun updateCountdown() {
        val b = binding ?: return
        if (MainActivity.data.workshopQueue.isEmpty()) return
        val child = b.list.getChildAt(MainActivity.data.completedWorkshopItems.size) ?: return
        val textView = child.findViewById<TextView>(R.id.time_to_completion)
        val itemAction = MainActivity.data.workshopQueue[0]
        val item = itemAction.item ?: return
        textView.text = UIUtils.formatSeconds(item.getSecondsToCraft() - itemAction.secondsPassed)
    }

    fun addProject(itemAction: ItemAction) {
        val b = binding ?: return
        b.list.addView(getItemLayout(itemAction, false).root)
        updateVisibility()
        if (MainActivity.data.workshopQueue.size == 1) {
            updateAnimation()
        }
    }

    private fun getItemLayout(itemAction: ItemAction, isCompleted: Boolean): LayoutWorkshopItemBinding {
        val itemBinding = LayoutWorkshopItemBinding.inflate(layoutInflater, binding?.list, false)
        val item = itemAction.item
        if (item != null) {
            itemBinding.name.setText(item.getIdName())
            itemBinding.item.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, item.getIdImage(), context?.theme)
            )
            itemBinding.item.image.setBackgroundResource(R.drawable.object_border_rounded_left)
            itemBinding.item.stack.text = item.getStack().toString()
            itemBinding.progressBar.visibility = if (isCompleted) View.GONE else View.VISIBLE
            itemBinding.progressBar.progress = ((itemAction.secondsPassed * 1000) / item.getSecondsToCraft()).toInt()
            itemBinding.timeToCompletion.text = if (isCompleted) getString(R.string.complete) else UIUtils.formatSeconds(item.getSecondsToCraft() - itemAction.secondsPassed)
            itemBinding.timeToCompletion.setTextColor(
                resources.getColor(if (isCompleted) R.color.brass_border else R.color.dim_white, context?.theme)
            )
            itemBinding.action.setImageDrawable(
                ResourcesCompat.getDrawable(resources, if (isCompleted) R.drawable.check_brass else R.drawable.delete, context?.theme)
            )
            itemBinding.action.setOnClickListener {
                if (isCompleted) collect(itemAction) else cancel(itemAction)
            }
            itemBinding.containerItemWorkshop.setOnClickListener {
                UIUtils.openItemDetail(item)
            }
        }
        return itemBinding
    }

    private fun collect(itemAction: ItemAction) {
        val item = itemAction.item ?: return
        if (MainActivity.data.completedWorkshopItems.contains(itemAction)) {
            if (Formulas.storageSpaces() <= MainActivity.data.items.size && !MainActivity.data.items.contains(item)) {
                if (MainActivity.shownDialogFullStorage != null) return
                val dialog = UIUtils.getInfoDialog(
                    context,
                    R.string.no_storage_space_title,
                    getString(R.string.no_storage_space_body_craft),
                    false
                )
                MainActivity.shownDialogFullStorage = dialog
                dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
                dialog.show()
                return
            }
            val index = MainActivity.data.completedWorkshopItems.indexOf(itemAction)
            binding?.list?.removeView(binding?.list?.getChildAt(index))
            MainActivity.data.completedWorkshopItems.remove(itemAction)
            Utils.collectItem(item, MainActivity.data.items)
            craftedInThisInstance += item.getStack()
            updateVisibility()
            QuestsManager.incrementToValue(QuestsManager.masterCrafter, (item.getPrice() * 0.01).toLong())
            if (MainActivity.data.tutorialStep == 3 && item is Leather) {
                MainActivity.data.tutorialStep = 4
                val copper = Item.getInstance("CopperIngot", 2)
                if (copper != null) {
                    Utils.collectItem(copper, MainActivity.data.items)
                }
                (MainActivity.dungeonsFragment.activity as? MainActivity)?.refresh()
            } else if (MainActivity.data.tutorialStep == 4 && item is CopperArmor) {
                MainActivity.data.tutorialStep = 5
                (MainActivity.dungeonsFragment.activity as? MainActivity)?.refresh()
            }
            MainActivity.headquartersFragment.refresh()
        }
    }

    private fun cancel(itemAction: ItemAction) {
        val item = itemAction.item ?: return
        if (cancel != null) return
        val dialog = UIUtils.getActionDialog(
            context,
            R.string.cancel,
            String.format(
                getString(R.string.cancel_crafting_confirmation),
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
        if (MainActivity.data.workshopQueue.contains(itemAction)) {
            val index = MainActivity.data.workshopQueue.indexOf(itemAction)
            b.list.removeView(b.list.getChildAt(MainActivity.data.completedWorkshopItems.size + index))
            MainActivity.data.workshopQueue.remove(itemAction)
            val recipesInto = Recipes.into(item)
            if (recipesInto != null) {
                for (ing in recipesInto.getIngredients()) {
                    if (ing != null) {
                        val refunded = Item.getInstance(ing.getTrueClass() ?: "", ing.getStack() * item.getStack())
                        if (refunded != null) {
                            Utils.collectItem(refunded, MainActivity.data.items)
                        }
                    }
                }
            }
            updateVisibility()
            if (index == 0) {
                updateAnimation()
            }
            MainActivity.headquartersFragment.refresh()
        }
    }

    private fun updateAnimation() {
        val b = binding ?: return
        if (MainActivity.data.workshopQueue.isEmpty()) return
        val child = b.list.getChildAt(MainActivity.data.completedWorkshopItems.size) ?: return
        val progressBar = child.findViewById<ProgressBar>(R.id.progressBar) ?: return
        val itemAction = MainActivity.data.workshopQueue[0]
        val item = itemAction.item ?: return

        val fMillis = ((((TrueTimeUtils.millis() - MainActivity.data.lastAccess) / 1000.0) + itemAction.secondsPassed) / item.getSecondsToCraft()).toFloat()
        val animator = ValueAnimator.ofInt(Math.round(fMillis * 1000.0f), 1000)
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { anim ->
            progressBar.progress = anim.animatedValue as Int
        }
        animator.duration = Math.max(0L, ((1.0f - fMillis) * 1000.0f * item.getSecondsToCraft()).toLong() + 1000L)
        animator.start()
    }

    private fun levelUpWorkshopQueue() {
        val price = Formulas.getWorkshopQueuePrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelWorkshopQueue += 1
        updateUpgrades()
        (activity as? MainActivity)?.refresh()
    }

    private fun levelUpWorkshopTime() {
        val price = Formulas.getWorkshopTimePrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelWorkshopTime += 1
        initialize(null)
        (activity as? MainActivity)?.refresh()
    }

    override fun onStart() {
        super.onStart()
        craftedInThisInstance = 0
        MainActivity.shownDialogWorkshop = this
    }

    override fun onStop() {
        val itemsCrafted = MainActivity.data.itemsCrafted
        val count = craftedInThisInstance
        if (itemsCrafted < WorkRequest.MIN_BACKOFF_MILLIS && count > 0) {
            if (itemsCrafted < 100L) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_APPRENTICE_BLACKSMITH, count)
            }
            if (itemsCrafted < 1000L) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_SEASONED_BLACKSMITH, count)
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_LEGENDARY_BLACKSMITH, count)
            MainActivity.data.itemsCrafted = Math.min(WorkRequest.MIN_BACKOFF_MILLIS, itemsCrafted + count.toLong())
        }
        MainActivity.shownDialogWorkshop = null
        super.onStop()
    }
}
