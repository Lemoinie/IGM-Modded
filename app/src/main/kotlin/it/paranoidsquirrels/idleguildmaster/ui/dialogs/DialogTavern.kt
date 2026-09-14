package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogTavernBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTavernAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer

class DialogTavern : CustomDialog() {
    companion object {
        private const val MAX_LEVEL_TAVERN_CAPACITY = 7
        private const val MAX_LEVEL_TAVERN_TIME = 20
    }

    @JvmField
    var binding: DialogTavernBinding? = null
    private var recruitUnavailableDialog: AlertDialog? = null
    private var help: AlertDialog? = null
    private var upgradeConfirm: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogTavernBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_tavern_name)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogTavernBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val theme = context?.theme
        val tavernCapacityPrice = Formulas.getTavernCapacityPrice()
        UIUtils.populateMoneyContainer(b.money, tavernCapacityPrice, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= tavernCapacityPrice)
        b.buttonUpgradeCapacity.visibility = if (MainActivity.data.levelTavernCapacity >= MAX_LEVEL_TAVERN_CAPACITY) 8 else 0

        val tavernTimePrice = Formulas.getTavernTimePrice()
        UIUtils.populateMoneyContainer(b.money2, tavernTimePrice, true)
        UIUtils.changeMoneyContainerColor(b.money2, MainActivity.data.money >= tavernTimePrice)
        b.buttonUpgradeTime.visibility = if (MainActivity.data.levelTavernTime >= MAX_LEVEL_TAVERN_TIME) 8 else 0

        b.lock.background = ResourcesCompat.getDrawable(resources, if (MainActivity.data.isTavernLocked) R.drawable.lock_close else R.drawable.lock_open, theme)
        refreshProgressBar()
        refreshAdventurers()
    }

    fun refreshProgressBar() {
        val b = binding ?: return
        b.nextVisitor.text = String.format(getString(R.string.next_visitor), UIUtils.formatSeconds(MainActivity.data.nextTavernVisit))
        val tavernVisitorInterval = Formulas.getTavernVisitorInterval()
        b.progressBar.progress = ((1.0 - ((tavernVisitorInterval - (MainActivity.data.nextTavernVisit * 1000.0)) / tavernVisitorInterval)) * 100.0).toInt()
    }

    fun refreshAdventurers() {
        val b = binding ?: return
        b.list.removeAllViews()
        val tavernGuests = MainActivity.data.tavernGuests
        val theme = context?.theme
        for (guest in tavernGuests) {
            val itemBinding = LayoutTavernAdventurerBinding.inflate(layoutInflater, b.list, false)
            itemBinding.name.text = getString(guest.idName)
            itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, guest.imageId, theme))
            if (!guest.isSeen()) {
                itemBinding.isNew.setText(R.string.is_new)
            }
            itemBinding.traits.text = UIUtils.traitsToShortString(guest, resources)
            if (Formulas.getQuartersCapacity() <= MainActivity.data.adventurers.size) {
                itemBinding.recruitButton.background = ResourcesCompat.getDrawable(resources, R.drawable.object_border_unavailable_rounded_right, theme)
                itemBinding.recruitButton.setOnClickListener {
                    showFullQuartersDialog()
                }
            } else {
                itemBinding.recruitButton.setOnClickListener { view ->
                    val parentView = view.parent as ViewGroup
                    val container = parentView.parent as ViewGroup
                    recruitAdventurer(container.indexOfChild(parentView))
                }
            }
            itemBinding.containerAdventurerTavern.setOnClickListener {
                UIUtils.getAdventurerDetailDialog(parentFragmentManager, guest, false, false)
            }
            b.list.addView(itemBinding.root)
        }

        MainActivity.shownDialogEntityDetail?.let { detail ->
            if (!tavernGuests.contains(detail.entity)) {
                detail.dismiss()
            }
        }
        recruitUnavailableDialog?.dismiss()

        b.scrollView.visibility = if (tavernGuests.isEmpty()) 8 else 0
        b.emptyList.visibility = if (tavernGuests.isEmpty()) 0 else 8
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgradeCapacity.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpTavernCapacity()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_tavern_upgrade_capacity) { _, _ ->
                    levelUpTavernCapacity()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }
        b.buttonUpgradeTime.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                levelUpTavernTime()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_tavern_upgrade_time) { _, _ ->
                    levelUpTavernTime()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }
        b.lock.setOnClickListener {
            toggleLock()
        }
        b.exit.setOnClickListener {
            dismiss()
        }
        b.help.setOnClickListener {
            if (help != null) return@setOnClickListener
            val dialog = UIUtils.getInfoDialog(context, R.string.headquarters_tavern_name, getString(R.string.headquarters_tavern_help), false)
            help = dialog
            dialog.setOnDismissListener { help = null }
            dialog.show()
        }
    }

    private fun levelUpTavernCapacity() {
        val price = Formulas.getTavernCapacityPrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelTavernCapacity += 1
        initialize(null)
        (activity as? MainActivity)?.refresh()
        MainActivity.headquartersFragment?.refresh()
    }

    private fun levelUpTavernTime() {
        val price = Formulas.getTavernTimePrice()
        if (MainActivity.data.money < price) return
        MainActivity.data.money -= price
        MainActivity.data.levelTavernTime += 1
        MainActivity.data.nextTavernVisit = (MainActivity.data.nextTavernVisit * 0.9).toLong()
        initialize(null)
        (activity as? MainActivity)?.refresh()
    }

    private fun toggleLock() {
        val theme = context?.theme
        if (MainActivity.data.isTavernLocked) {
            MainActivity.data.isTavernLocked = false
            binding?.lock?.background = ResourcesCompat.getDrawable(resources, R.drawable.lock_open, theme)
        } else {
            MainActivity.data.isTavernLocked = true
            binding?.lock?.background = ResourcesCompat.getDrawable(resources, R.drawable.lock_close, theme)
        }
        MainActivity.headquartersFragment?.refresh()
    }

    private fun showFullQuartersDialog() {
        if (recruitUnavailableDialog != null) return
        val dialog = UIUtils.getInfoDialog(context, R.string.recruit_unavailable_title, getString(R.string.recruit_unavailable_body), false)
        recruitUnavailableDialog = dialog
        dialog.setOnDismissListener { recruitUnavailableDialog = null }
        dialog.show()
    }

    private fun recruitAdventurer(index: Int) {
        val guest = MainActivity.data.tavernGuests.getOrNull(index) ?: return
        MainActivity.data.tavernGuests.remove(guest)
        guest.id = Utils.calculateNewAdventurerId()
        MainActivity.data.adventurers.add(guest)
        Utils.triggerGuildSizeAchievementCheck()
        refreshAdventurers()
        val tutorialStep = MainActivity.data.tutorialStep
        if (tutorialStep == 1 || tutorialStep == 6) {
            MainActivity.data.tutorialStep = tutorialStep + 1
            if (tutorialStep == 6) {
                Utils.progressTavernTime(28800L)
            }
            (activity as? MainActivity)?.refreshTutorial()
        }
        MainActivity.headquartersFragment?.refresh()
        MainActivity.adventurersFragment?.refresh()
        MainActivity.adventurersFragment?.switchMode(0)
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogTavern = this
    }

    override fun onStop() {
        MainActivity.shownDialogTavern = null
        for (guest in MainActivity.data.tavernGuests) {
            guest.setSeen(true)
        }
        MainActivity.headquartersFragment?.refresh()
        super.onStop()
    }
}
