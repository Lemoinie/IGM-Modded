package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBattleStatusEffectsBinding
import it.paranoidsquirrels.idleguildmaster.databinding.ItemBattleStatusEffectBinding
import it.paranoidsquirrels.idleguildmaster.databinding.ItemUnitStatusEffectsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

/**
 * Live Battle Status Effects Inspector.
 *
 * Opened from the dungeon detail view's STATUS button; lists every active positive and
 * negative status effect (icon, name, remaining turns, cause) for all living allies and
 * enemies, and refreshes in real time whenever DialogDungeonDetail.refreshUnits() runs.
 *
 * Features top tabs (Enemies, Allies, All) and a filter checkbox to hide unaffected units.
 */
class DialogBattleStatusEffects : CustomDialog() {
    companion object {
        /** Returns the string resource key for an effect's remaining-turns label. */
        @JvmStatic
        fun statusTurnsLeftLabelResource(turnsLeft: Int): Int =
            statusTurnsLeftLabelResource(turnsLeft, null)

        @JvmStatic
        fun statusTurnsLeftLabelResource(turnsLeft: Int, type: StatusEffectType?): Int {
            return if (type != StatusEffectType.BLEED && turnsLeft >= 999) R.string.status_permanent
            else if (turnsLeft == 1) R.string.status_turn_left
            else R.string.status_turns_left
        }

        /** Checks if an entity has any active status effects. */
        @JvmStatic
        fun hasActiveEffects(entity: Entity): Boolean =
            entity.positiveStatusEffects.isNotEmpty() || entity.negativeStatusEffects.isNotEmpty()
    }

    @JvmField
    var area: Area? = null
    @JvmField
    var binding: DialogBattleStatusEffectsBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogBattleStatusEffectsBinding
    }

    override fun getTitle(): String = getString(R.string.status_effects_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogBattleStatusEffectsBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.tabEnemies.isChecked = true
        b.checkboxHideUnaffected.isChecked = false
        refreshStatusList()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.battleStatusTabs.setOnCheckedChangeListener { _, _ ->
            refreshStatusList()
        }
        b.checkboxHideUnaffected.setOnCheckedChangeListener { _, _ ->
            refreshStatusList()
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    /** Rebuilds the list from the live battle state based on selected tab and filters. */
    fun refreshStatusList() {
        val b = binding ?: return
        val a = area ?: return
        b.battleStatusList.removeAllViews()

        val hideUnaffected = b.checkboxHideUnaffected.isChecked
        val selectedTabId = b.battleStatusTabs.checkedRadioButtonId
        val showAllies = selectedTabId == R.id.tab_allies || selectedTabId == R.id.tab_all
        val showEnemies = selectedTabId == R.id.tab_enemies || selectedTabId == R.id.tab_all || !showAllies
        val showBoth = selectedTabId == R.id.tab_all

        var totalUnitsDisplayed = 0

        if (showEnemies && !showBoth) {
            // When on Enemies tab, list enemies directly
            for (entity in a.enemies) {
                if (entity.currentHp <= 0) continue
                if (hideUnaffected && !hasActiveEffects(entity)) continue
                addUnitRow(entity)
                totalUnitsDisplayed++
            }
        } else if (showAllies && !showBoth) {
            // When on Allies tab, list allies directly
            for (entity in a.adventurersExploring) {
                if (entity.currentHp <= 0) continue
                if (hideUnaffected && !hasActiveEffects(entity)) continue
                addUnitRow(entity)
                totalUnitsDisplayed++
            }
        } else {
            // When on All tab, list allies first, then enemies, with section headers
            val alliesToDisplay = a.adventurersExploring.filter { entity ->
                entity.currentHp > 0 && (!hideUnaffected || hasActiveEffects(entity))
            }
            if (alliesToDisplay.isNotEmpty()) {
                addSectionHeader(getString(R.string.status_allies))
                for (entity in alliesToDisplay) {
                    addUnitRow(entity)
                    totalUnitsDisplayed++
                }
            }

            val enemiesToDisplay = a.enemies.filter { entity ->
                entity.currentHp > 0 && (!hideUnaffected || hasActiveEffects(entity))
            }
            if (enemiesToDisplay.isNotEmpty()) {
                addSectionHeader(getString(R.string.status_enemies))
                for (entity in enemiesToDisplay) {
                    addUnitRow(entity)
                    totalUnitsDisplayed++
                }
            }
        }

        if (totalUnitsDisplayed == 0) {
            b.battleStatusEmpty.visibility = View.VISIBLE
            b.battleStatusScroll.visibility = View.GONE
        } else {
            b.battleStatusEmpty.visibility = View.GONE
            b.battleStatusScroll.visibility = View.VISIBLE
        }
    }

    private fun addSectionHeader(title: String) {
        val ctx = context ?: return
        val b = binding ?: return
        val header = TextView(ctx)
        header.text = title
        header.setPadding(8, 8, 8, 4)
        header.layoutParams = ViewGroup.LayoutParams(-1, -2)
        header.setBackgroundColor(ctx.resources.getColor(R.color.extra_opaque_background, ctx.theme))
        b.battleStatusList.addView(header)
    }

    private fun addUnitRow(entity: Entity) {
        val b = binding ?: return
        val theme = context?.theme
        // inflate(..., attachToRoot = false) only builds the view tree; the root must be
        // attached to the list container explicitly or the row is never rendered.
        val row = ItemUnitStatusEffectsBinding.inflate(layoutInflater, b.battleStatusList, false)
        row.battleUnitImage.setImageDrawable(ResourcesCompat.getDrawable(resources, entity.imageId, theme))
        row.battleUnitName.text = getString(entity.idName)
        val maxHp = entity.calculateTotalMaxHp()
        val hpPct = if (maxHp > 0) (entity.currentHp * 100 / maxHp) else 0
        row.battleUnitHp.text = String.format(getString(R.string.status_unit_hp), entity.currentHp, maxHp, entity.currentShield, hpPct)
        for (effect in entity.positiveStatusEffects) {
            addEffectLine(row, effect)
        }
        for (effect in entity.negativeStatusEffects) {
            addEffectLine(row, effect)
        }
        b.battleStatusList.addView(row.root)
    }

    private fun addEffectLine(row: ItemUnitStatusEffectsBinding, effect: StatusEffect) {
        val type = effect.type ?: return
        val theme = context?.theme
        // Same attach-to-container requirement as addUnitRow: without this the effect
        // line is inflated but never rendered inside the unit's effects column.
        val line = ItemBattleStatusEffectBinding.inflate(layoutInflater, row.battleUnitEffects, false)
        line.battleEffectIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, type.icon, theme))
        val durationKey = statusTurnsLeftLabelResource(effect.turnsLeft, type)
        val durationText =
            if (durationKey == R.string.status_turns_left) String.format(getString(durationKey), effect.turnsLeft)
            else getString(durationKey)
        val sb = StringBuilder(getString(type.nameRes))
        sb.append(" — ").append(durationText)
        val cause = effect.cause
        if (cause != null) {
            sb.append(" (").append(String.format(getString(R.string.status_by_cause), getString(cause.idName))).append(")")
        }
        line.battleEffectDescription.text = sb.toString()
        line.battleEffectDescription.setTextColor(
            resources.getColor(if (type.negative) R.color.failure else R.color.success, theme)
        )
        row.battleUnitEffects.addView(line.root)
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownStatusDialog = this
    }

    override fun onStop() {
        MainActivity.shownStatusDialog = null
        super.onStop()
    }
}