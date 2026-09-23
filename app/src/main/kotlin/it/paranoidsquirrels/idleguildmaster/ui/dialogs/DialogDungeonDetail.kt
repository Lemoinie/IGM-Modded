package it.paranoidsquirrels.idleguildmaster.ui.dialogs
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDungeonDetailBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutEntityFightingBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class DialogDungeonDetail : CustomDialog() {
    @JvmField
    var area: Area? = null
    @JvmField
    var binding: DialogDungeonDetailBinding? = null
    @JvmField
    var darkLog = true
    private var darknessDialog: AlertDialog? = null
    private var retreatDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogDungeonDetailBinding
    }

    override fun getTitle(): String {
        val a = area ?: return ""
        return getString(a.getName())
    }

    override fun setLayout() {
        dialog?.window?.setLayout(-1, (resources.displayMetrics.heightPixels * 0.9).toInt())
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogDungeonDetailBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val a = area ?: return
        val b = binding ?: return
        val theme = context?.theme
        b.imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, a.getDetailDrawable(), theme))
        refreshUnits()
        refreshDarkness()
        val large = a.adventurersNumber() > 8
        b.paddingToRemove1.visibility = if (large) 8 else 0
        b.paddingToRemove2.visibility = if (large) 8 else 0
    }

    override fun attachListeners() {
        val b = binding ?: return
        val a = area ?: return
        b.exit.setOnClickListener {
            dismiss()
        }
        b.retreat.setOnClickListener {
            if (MainActivity.data.isSettingConfirmRetreat) {
                if (retreatDialog != null) return@setOnClickListener
                val dialog = UIUtils.getActionDialog(context, R.string.retreat, getString(R.string.retreat_confirmation), R.string.yes) { _, _ ->
                    a.onRetreat()
                    a.terminationRequested = true
                    dismiss()
                }
                retreatDialog = dialog
                dialog.setOnDismissListener { retreatDialog = null }
                dialog.show()
                return@setOnClickListener
            }
            a.onRetreat()
            a.terminationRequested = true
            dismiss()
        }
        b.moon.setOnClickListener {
            if (darknessDialog != null || a.getDarkness() == 0) return@setOnClickListener
            val dialog = UIUtils.getInfoDialog(context, R.string.darkness_dialog_title, UIUtils.darknessDescription(a.localDarkness, resources), false)
            darknessDialog = dialog
            dialog.setOnDismissListener { darknessDialog = null }
            dialog.show()
        }
        b.btnStatusEffects.setOnClickListener {
            if (MainActivity.shownStatusDialog == null) {
                val dialog = DialogBattleStatusEffects()
                MainActivity.shownStatusDialog = dialog
                dialog.area = a
                dialog.show(parentFragmentManager, "battle_status_effects")
            }
        }
    }

    fun refreshDarkness() {
        val a = area ?: return
        val b = binding ?: return
        if (a.getDarkness() == 0) {
            b.moon.visibility = 8
            return
        }
        val theme = context?.theme
        val localDarkness = a.localDarkness
        if (localDarkness < 17) {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_0, theme))
        } else if (localDarkness < 34) {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_1, theme))
        } else if (localDarkness < 50) {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_2, theme))
        } else if (localDarkness < 67) {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_3, theme))
        } else if (localDarkness < 84) {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_4, theme))
        } else {
            b.moon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.darkness_5, theme))
        }
        b.moon.visibility = 0
    }

    fun refreshUnits() {
        val a = area ?: return
        val b = binding ?: return
        val advSize = a.adventurersExploring.size
        for (i in 1..15) {
            refreshUnit(true, i, advSize)
        }
        val enemySize = a.enemies.size
        for (i in 1..10) {
            refreshUnit(false, i, enemySize)
        }
        val pet = a.petExploring
        if (pet != null) {
            b.pet.setImageDrawable(ResourcesCompat.getDrawable(resources, pet.idImage, context?.theme))
            b.pet.setOnClickListener {
                if (MainActivity.shownDialogPetDetail != null) return@setOnClickListener
                val dialog = DialogPetDetail()
                MainActivity.shownDialogPetDetail = dialog
                dialog.pet = pet
                dialog.show(parentFragmentManager, "pet_detail")
            }
        }
        b.pet.visibility = if (pet == null) 4 else 0
        // Keep the open Status Effects inspector in sync with every unit refresh.
        MainActivity.shownStatusDialog?.refreshStatusList()
    }

    private fun refreshUnit(isAdventurer: Boolean, slot: Int, count: Int) {
        val view = getView(slot, isAdventurer)
        if (slot <= count) {
            val a = area ?: return
            val entity = if (isAdventurer) a.adventurersExploring[slot - 1] else a.enemies[slot - 1]
            view.root.visibility = 0
            refreshView(entity, view)
            refreshStatus(entity, view)
            attachDetailListener(isAdventurer, entity, view)
        } else {
            view.root.visibility = 8
        }
    }

    private fun refreshView(entity: Entity, layoutEntityFightingBinding: LayoutEntityFightingBinding) {
        val theme = context?.theme
        layoutEntityFightingBinding.image.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                if (entity.currentHp > 0) entity.imageId else R.drawable.tombstone,
                theme
            )
        )
        val maxHp = entity.calculateTotalMaxHp().toDouble()
        layoutEntityFightingBinding.hpBar.progress = if (maxHp > 0) ((entity.currentHp / maxHp) * 100.0).toInt() else 0
        layoutEntityFightingBinding.shieldBar.progress = if (maxHp > 0) ((entity.currentShield / maxHp) * 100.0).toInt() else 0
        layoutEntityFightingBinding.manaBar.progress = entity.currentMana
        val hasActiveSkill = entity.activeSkill != null && entity.activeSkill != Skills.ACTIVE_NONE
        layoutEntityFightingBinding.manaBar.visibility = if (hasActiveSkill) 0 else 8
        layoutEntityFightingBinding.manaBar.progressTintList = ColorStateList.valueOf(
            resources.getColor(if (entity.currentMana == 100) R.color.white else R.color.mana_bar, theme)
        )
    }

    private fun refreshStatus(entity: Entity, layoutEntityFightingBinding: LayoutEntityFightingBinding) {
        val theme = context?.theme
        var i = 0
        for (effect in entity.positiveStatusEffects) {
            if (i >= 3) break
            i++
            getStatusSlot(layoutEntityFightingBinding, i).setImageDrawable(ResourcesCompat.getDrawable(resources, effect.type?.icon ?: 0, theme))
        }
        for (effect in entity.negativeStatusEffects) {
            if (i >= 3) break
            i++
            getStatusSlot(layoutEntityFightingBinding, i).setImageDrawable(ResourcesCompat.getDrawable(resources, effect.type?.icon ?: 0, theme))
        }
        while (true) {
            i++
            if (i >= 4) return
            getStatusSlot(layoutEntityFightingBinding, i).setImageResource(0)
        }
    }

    private fun attachDetailListener(isAdventurer: Boolean, entity: Entity, layoutEntityFightingBinding: LayoutEntityFightingBinding) {
        layoutEntityFightingBinding.root.setOnClickListener {
            if (!isAdventurer) {
                UIUtils.getEnemyDetailDialog(parentFragmentManager, entity as Enemy)
            } else {
                val adv = entity as Adventurer
                UIUtils.getAdventurerDetailDialog(parentFragmentManager, adv, !adv.isSummonedMinion(), false)
            }
        }
    }

    fun animateDamage(entity: Entity) {
        val isAdventurer = entity is Adventurer
        val a = area ?: return
        val list = if (isAdventurer) a.adventurersExploring else a.enemies
        val view = getView(list.indexOf(entity) + 1, isAdventurer)
        val anim1 = ObjectAnimator.ofFloat(view.image, "translationX", 0.0f, 10.0f, 0.0f, -10.0f, 0.0f)
        anim1.repeatCount = 3
        anim1.duration = 50L
        anim1.start()
        view.animation.setImageResource(R.drawable.animated_icon_damaged)
        val anim2 = ObjectAnimator.ofFloat(view.animation, "alpha", 1.0f, 0.0f)
        anim2.duration = 500L
        anim2.start()
    }

    fun log(str: String?) {
        if (str == null) return
        val ctx = context ?: return
        val b = binding ?: return
        val textView = TextView(ctx)
        textView.text = Html.fromHtml(str, 0)
        textView.setPadding(12, 4, 12, 4)
        textView.layoutParams = ViewGroup.LayoutParams(-1, -2)
        if (!darkLog) {
            textView.setBackgroundColor(ctx.resources.getColor(R.color.dungeon_log_lighter_background, ctx.theme))
        }
        b.logs.addView(textView, 0)
        if (b.logs.childCount > 100) {
            b.logs.removeViewAt(99)
        }
    }

    private fun getStatusSlot(layoutEntityFightingBinding: LayoutEntityFightingBinding, i: Int): ImageView {
        return when (i) {
            1 -> layoutEntityFightingBinding.status1
            2 -> layoutEntityFightingBinding.status2
            else -> layoutEntityFightingBinding.status3
        }
    }

    private fun getView(slot: Int, isAdventurer: Boolean): LayoutEntityFightingBinding {
        val b = binding!!
        return when (slot) {
            1 -> if (isAdventurer) b.adventurer1 else b.enemy1
            2 -> if (isAdventurer) b.adventurer2 else b.enemy2
            3 -> if (isAdventurer) b.adventurer3 else b.enemy3
            4 -> if (isAdventurer) b.adventurer4 else b.enemy4
            5 -> if (isAdventurer) b.adventurer5 else b.enemy5
            6 -> if (isAdventurer) b.adventurer6 else b.enemy6
            7 -> if (isAdventurer) b.adventurer7 else b.enemy7
            8 -> if (isAdventurer) b.adventurer8 else b.enemy8
            9 -> if (isAdventurer) b.adventurer9 else b.enemy9
            10 -> if (isAdventurer) b.adventurer10 else b.enemy10
            11 -> b.adventurer11
            12 -> b.adventurer12
            13 -> b.adventurer13
            14 -> b.adventurer14
            else -> b.adventurer15
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogDungeonDetail = this
    }

    override fun onStop() {
        MainActivity.shownDialogDungeonDetail = null
        super.onStop()
    }
}
