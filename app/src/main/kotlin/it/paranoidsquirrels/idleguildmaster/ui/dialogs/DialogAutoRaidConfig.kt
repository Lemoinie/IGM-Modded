package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogAutoRaidConfigBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Auto-Raid configuration dialog.
 *
 * Lets the player pick a target run count (5 / 10 / 25 / Unlimited, or a fine-tuned
 * number via the stepper) and the "stop on wipe" safety toggle, then activates the
 * Auto-Raid loop on the given raid Area.
 */
class DialogAutoRaidConfig : CustomDialog() {
    @JvmField
    var area: Area? = null
    @JvmField
    var binding: DialogAutoRaidConfigBinding? = null

    private var runsSelected: Int = 5
    private var unlimited: Boolean = false
    private var stopOnWipe: Boolean = true

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogAutoRaidConfigBinding
    }

    override fun getTitle(): String {
        val a = area ?: return getString(R.string.auto_raid_title)
        return getString(R.string.auto_raid_title) + ": " + getString(a.getName())
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogAutoRaidConfigBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val a = area ?: return
        val b = binding ?: return
        val cost = a.costToRefresh()
        b.infoGems.text = String.format(getString(R.string.auto_raid_current_gems), MainActivity.data.gems)
        b.infoCost.text = String.format(getString(R.string.auto_raid_cost_per_run), cost)
        val affordable = if (cost > 0) (MainActivity.data.gems / cost.toLong()).toInt() else 0
        b.infoAffordable.text = String.format(getString(R.string.auto_raid_affordable_runs), affordable)
        b.chip5.text = String.format(getString(R.string.auto_raid_runs), 5)
        b.chip10.text = String.format(getString(R.string.auto_raid_runs), 10)
        b.chip25.text = String.format(getString(R.string.auto_raid_runs), 25)
        b.chipUnlimited.text = getString(R.string.auto_raid_unlimited)
        b.stopOnWipeLabel.text = getString(R.string.auto_raid_stop_on_wipe)
        runsSelected = 5
        unlimited = false
        stopOnWipe = a.autoRaidStopOnWipe
        refreshSelection()
        refreshStepper()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.chip5.setOnClickListener {
            selectChip(5, false)
        }
        b.chip10.setOnClickListener {
            selectChip(10, false)
        }
        b.chip25.setOnClickListener {
            selectChip(25, false)
        }
        b.chipUnlimited.setOnClickListener {
            selectChip(1, true)
        }
        b.stepperMinus.setOnClickListener {
            if (unlimited) return@setOnClickListener
            if (runsSelected > 1) {
                runsSelected--
                refreshSelection()
                refreshStepper()
            }
        }
        b.stepperPlus.setOnClickListener {
            if (unlimited) return@setOnClickListener
            if (runsSelected < 999) {
                runsSelected++
                refreshSelection()
                refreshStepper()
            }
        }
        b.stopOnWipeYes.setOnClickListener {
            stopOnWipe = true
            refreshSelection()
        }
        b.stopOnWipeNo.setOnClickListener {
            stopOnWipe = false
            refreshSelection()
        }
        b.cancel.setOnClickListener {
            dismiss()
        }
        b.start.setOnClickListener {
            startAutoRaid()
        }
    }

    private fun selectChip(runs: Int, isUnlimited: Boolean) {
        unlimited = isUnlimited
        if (!isUnlimited) {
            runsSelected = runs
        }
        refreshSelection()
        refreshStepper()
    }

    private fun refreshSelection() {
        val b = binding ?: return
        val theme = context?.theme
        val brass = resources.getColor(R.color.brass_border, theme)
        val dim = resources.getColor(R.color.dim_white, theme)
        b.chip5.setTextColor(if (!unlimited && runsSelected == 5) brass else dim)
        b.chip10.setTextColor(if (!unlimited && runsSelected == 10) brass else dim)
        b.chip25.setTextColor(if (!unlimited && runsSelected == 25) brass else dim)
        b.chipUnlimited.setTextColor(if (unlimited) brass else dim)
        b.stopOnWipeYes.setTextColor(if (stopOnWipe) brass else dim)
        b.stopOnWipeNo.setTextColor(if (!stopOnWipe) brass else dim)
    }

    private fun refreshStepper() {
        val b = binding ?: return
        b.stepperValue.text = if (unlimited) getString(R.string.auto_raid_unlimited) else String.format(getString(R.string.auto_raid_runs), runsSelected)
    }

    private fun startAutoRaid() {
        val a = area ?: return
        // The re-dispatch loop reuses the saved team, so record the current/selected one.
        if (a.savedAdventurersIds.isEmpty()) {
            a.savedAdventurersIds = CopyOnWriteArrayList(a.adventurersExploringIds)
            a.savedPetId = a.petExploringId
        }
        a.isAutoRaidActive = true
        a.autoRaidRunsRemaining = if (unlimited) -1 else runsSelected
        a.autoRaidStopOnWipe = stopOnWipe
        a.autoRaidRunsCompleted = 0
        a.autoRaidGemsSpent = 0
        a.terminationRequested = false
        if (a.adventurersExploringIds.isEmpty()) {
            // Started from the send-team dialog: dispatch the first run now, consuming
            // the free try exactly like the vanilla Send button.
            a.adventurersExploringIds = CopyOnWriteArrayList(a.savedAdventurersIds)
            a.petExploringId = a.savedPetId
            a.triesAvailable = false
        }
        a.refreshTries()
        a.refreshLoot()
        a.refreshActionDisplayed()
        a.refreshAdventurers()
        a.refreshAutoRaidIndicator()
        MainActivity.raidsFragment?.refresh()
        if (MainActivity.data.isSettingAutoOpenDungeonDetail) {
            UIUtils.clickArea(MainActivity.dungeonsFragment, a)
        }
        dismiss()
        MainActivity.shownDialogSendTeam?.dismiss()
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownAutoRaidConfig = this
    }

    override fun onStop() {
        MainActivity.shownAutoRaidConfig = null
        super.onStop()
    }
}