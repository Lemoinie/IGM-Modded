package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
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
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

/**
 * Live Battle Status Effects Inspector.
 *
 * Opened from the dungeon detail view's STATUS button; lists every active positive and
 * negative status effect (icon, name, remaining turns, cause) for all living allies and
 * enemies, and refreshes in real time whenever DialogDungeonDetail.refreshUnits() runs.
 */
class DialogBattleStatusEffects : CustomDialog() {
    companion object {
        /** Returns the string resource key for an effect's remaining-turns label. */
        @JvmStatic
        fun statusTurnsLeftLabelResource(turnsLeft: Int): Int {
            return if (turnsLeft >= 999) R.string.status_permanent
            else if (turnsLeft == 1) R.string.status_turn_left
            else R.string.status_turns_left
        }
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
        refreshStatusList()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.close.setOnClickListener {
            dismiss()
        }
    }

    /** Rebuilds the whole list from the live battle state. */
    fun refreshStatusList() {
        val b = binding ?: return
        val a = area ?: return
        b.battleStatusList.removeAllViews()

        addSectionHeader(getString(R.string.status_allies))
        for (entity in a.adventurersExploring) {
            if (entity.currentHp <= 0) continue
            addUnitRow(entity)
        }

        addSectionHeader(getString(R.string.status_enemies))
        for (entity in a.enemies) {
            if (entity.currentHp <= 0) continue
            addUnitRow(entity)
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
        val durationKey = statusTurnsLeftLabelResource(effect.turnsLeft)
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