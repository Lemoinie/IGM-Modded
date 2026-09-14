package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import com.google.android.material.card.MaterialCardView
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDoctrineBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDoctrineAbilityBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import java.text.DecimalFormat

class DialogDoctrine : CustomDialog() {
    companion object {
        private val df = DecimalFormat("#.#")

        @JvmStatic
        fun removeWeaponMaster(resources: Resources, adventurer: Adventurer) {
            val weapon = adventurer.weapon ?: return
            if (weapon.printType() == adventurer.weaponType) {
                return
            }
            val defaultWeapon = Utils.getDefaultWeapon(adventurer.weaponType)
            Utils.collectItem(weapon, MainActivity.data.items)
            adventurer.weapon = defaultWeapon
            MainActivity.adventurersFragment.refresh()
            MainActivity.headquartersFragment.refresh()
            MainActivity.shownDialogEntityDetail?.let { detail ->
                detail.update()
                detail.populateHelp(
                    null,
                    DialogEntityDetail.formatEquipmentHelp(defaultWeapon, resources),
                    true,
                    "weapon"
                )
            }
            val totalMaxHp = adventurer.calculateTotalMaxHp()
            if (adventurer.currentHp > totalMaxHp) {
                adventurer.currentHp = totalMaxHp
            }
        }
    }

    @JvmField
    var adventurer: Adventurer? = null
    @JvmField
    var binding: DialogDoctrineBinding? = null
    private var confirmChoose: AlertDialog? = null
    @JvmField
    var doctrine: Doctrine? = null
    private var levelOfSelectedUI: TextView? = null
    private var openWithAvailablePoints: Boolean = false
    @JvmField
    var readOnly: Boolean = false
    private var selected: DoctrineAbility? = null
    private var selectedUI: MaterialCardView? = null

    fun getAdventurer(): Adventurer? = adventurer
    fun setAdventurer(adv: Adventurer?) { adventurer = adv }

    fun getDoctrine(): Doctrine? = doctrine
    fun setDoctrine(doc: Doctrine?) { doctrine = doc }

    fun isReadOnly(): Boolean = readOnly
    fun setReadOnly(ro: Boolean) { readOnly = ro }

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogDoctrineBinding
    }

    override fun getTitle(): String {
        return try {
            val doc = doctrine ?: return ""
            getString(doc.idName)
        } catch (unused: Exception) {
            dismiss()
            ""
        }
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogDoctrineBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        val doc = doctrine ?: run { dismiss(); return }
        val adv = adventurer ?: run { dismiss(); return }
        val b = binding ?: return

        var pts = adv.getDoctrinePoints()
        openWithAvailablePoints = pts > 0
        if (readOnly) {
            pts = adv.simulateDoctrinePoints(doc)
        }
        b.loyaltyPoints.text = String.format(getString(R.string.dialog_doctrine_loyalty_points_formatted), pts)

        var bonusStr = String.format(
            getString(R.string.dialog_doctrine_loyalty_points_bonus_formatted),
            doc.bonusQuestPoints(),
            adv.doctrinePointsFromLevels()
        )
        if (adv.level < 45) {
            val remaining = 15 - ((adv.level.toDouble() + (adv.maxLevel - 5) * 0.5 * (adv.maxLevel / 5)).toInt() % 15)
            bonusStr += " " + String.format(getString(R.string.dialog_doctrine_loyalty_points_bonus_addendum), remaining)
        }
        b.lpFromQuests.text = bonusStr

        clearAbilitySelected()
        b.description.setText(doc.idDescription)
        b.abilitiesRow1.removeAllViews()
        b.abilitiesRow2.removeAllViews()
        b.abilitiesRow3.removeAllViews()

        for (doctrineAbility in doc.abilities) {
            val type = doctrineAbility.type ?: continue
            val row = getCorrectRow(type.row)
            val abilityBinding = LayoutDoctrineAbilityBinding.inflate(layoutInflater, row, false)
            abilityBinding.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, type.image, context?.theme)
            )
            abilityBinding.level.text = doctrineAbility.level.toString()
            abilityBinding.root.setOnClickListener {
                onClick(doctrineAbility)
                selectedUI = abilityBinding.cardView
                abilityBinding.cardView.strokeWidth = 2
                levelOfSelectedUI = abilityBinding.level
            }
            row.addView(abilityBinding.root)
        }

        val sel = selected
        if (sel != null) {
            onClick(sel)
        }

        b.reset.visibility = if (readOnly) View.GONE else View.VISIBLE
        b.choose.visibility = if (readOnly) View.VISIBLE else View.GONE
    }

    private fun onClick(doctrineAbility: DoctrineAbility?) {
        selectedUI?.strokeWidth = 0
        selectedUI = null
        if (doctrineAbility == null) {
            clearAbilitySelected()
            return
        }
        selected = doctrineAbility
        updatePlusMinusVisibility(doctrineAbility)
        updateDescription(doctrineAbility)
    }

    private fun updatePlusMinusVisibility(doctrineAbility: DoctrineAbility) {
        val b = binding ?: return
        if (readOnly) return
        val type = doctrineAbility.type ?: return
        b.plus.visibility = if (doctrineAbility.level < type.maxLevel) View.VISIBLE else View.GONE
        b.minus.visibility = if (doctrineAbility.level <= 0) View.GONE else View.VISIBLE
    }

    private fun updateDescription(doctrineAbility: DoctrineAbility) {
        val b = binding ?: return
        val type = doctrineAbility.type ?: return
        b.name.visibility = View.VISIBLE
        b.cost.visibility = View.VISIBLE
        b.name.text = String.format(
            getString(R.string.dialog_doctrine_name_level_formatted),
            getString(type.nameRes),
            doctrineAbility.level,
            type.maxLevel
        )
        b.cost.text = type.cost.toString()

        val descStr: String? = when (type.formatMode) {
            0 -> getString(type.description)
            1 -> {
                val isMax = doctrineAbility.level >= type.maxLevel
                val totalVal = (type.increasePerLevel * doctrineAbility.level).toString()
                val incArg = if (isMax) "" else String.format(getString(R.string.doctrine_ability_increased_arg), type.increasePerLevel.toString())
                val formatted = if (isMax) String.format(getString(R.string.doctrine_ability_max_flat), totalVal)
                else String.format(getString(R.string.doctrine_ability_increased_flat), totalVal, incArg)
                String.format(getString(type.description), formatted)
            }
            2 -> {
                val isMax = doctrineAbility.level >= type.maxLevel
                val totalVal = (type.increasePerLevel * doctrineAbility.level).toString()
                val incArg = if (isMax) "" else String.format(getString(R.string.doctrine_ability_increased_arg), type.increasePerLevel.toString())
                val formatted = if (isMax) String.format(getString(R.string.doctrine_ability_max_percent), totalVal)
                else String.format(getString(R.string.doctrine_ability_increased_percent), totalVal, incArg)
                String.format(getString(type.description), formatted)
            }
            3 -> {
                val isMax = doctrineAbility.level >= type.maxLevel
                val totalVal = df.format(type.increasePerLevel * doctrineAbility.level * 0.1)
                val incArg = if (isMax) "" else String.format(getString(R.string.doctrine_ability_increased_arg), df.format(type.increasePerLevel * 0.1))
                val formatted = if (isMax) String.format(getString(R.string.doctrine_ability_max_percent), totalVal)
                else String.format(getString(R.string.doctrine_ability_increased_percent), totalVal, incArg)
                String.format(getString(type.description), formatted)
            }
            else -> null
        }
        b.description.text = descStr
    }

    private fun clearAbilitySelected() {
        selected = null
        val b = binding ?: return
        b.name.visibility = View.GONE
        b.cost.visibility = View.GONE
        b.plus.visibility = View.GONE
        b.minus.visibility = View.GONE
        b.description.text = ""
    }

    private fun getCorrectRow(i: Int): LinearLayout {
        val b = binding!!
        return when (i) {
            1 -> b.abilitiesRow1
            2 -> b.abilitiesRow2
            3 -> b.abilitiesRow3
            else -> b.abilitiesRow1
        }
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.root.setOnClickListener { onClick(null) }

        b.minus.setOnClickListener {
            val sel = selected ?: return@setOnClickListener
            val adv = adventurer ?: return@setOnClickListener
            val doc = doctrine ?: return@setOnClickListener
            if (sel.level <= 0) return@setOnClickListener

            val newLevel = sel.level - 1
            sel.level = newLevel
            doc.realignLevels()
            levelOfSelectedUI?.text = newLevel.toString()
            updateDescription(sel)
            updatePlusMinusVisibility(sel)
            b.loyaltyPoints.text = String.format(getString(R.string.dialog_doctrine_loyalty_points_formatted), adv.getDoctrinePoints())
        }

        b.plus.setOnClickListener {
            val sel = selected ?: return@setOnClickListener
            val adv = adventurer ?: return@setOnClickListener
            val doc = doctrine ?: return@setOnClickListener
            val type = sel.type ?: return@setOnClickListener
            if (sel.level >= type.maxLevel) return@setOnClickListener

            if (adv.getDoctrinePoints() < type.cost) {
                val colorFail = resources.getColor(UIUtils.getFailureColor(), context?.theme)
                val colorWhite = resources.getColor(R.color.dim_white, context?.theme)
                val colorBrass = resources.getColor(R.color.brass_border, context?.theme)

                val animCost = ValueAnimator.ofArgb(colorFail, colorWhite)
                animCost.interpolator = LinearInterpolator()
                animCost.addUpdateListener { a ->
                    b.cost.setTextColor(a.animatedValue as Int)
                    b.loyaltyPoints.setTextColor(a.animatedValue as Int)
                }
                animCost.duration = 750L
                animCost.start()
                return@setOnClickListener
            }

            val newLevel = sel.level + 1
            sel.level = newLevel
            doc.realignLevels()
            levelOfSelectedUI?.text = newLevel.toString()
            updateDescription(sel)
            updatePlusMinusVisibility(sel)
            b.loyaltyPoints.text = String.format(getString(R.string.dialog_doctrine_loyalty_points_formatted), adv.getDoctrinePoints())
        }

        b.choose.setOnClickListener {
            val adv = adventurer ?: return@setOnClickListener
            val doc = doctrine ?: return@setOnClickListener
            if (confirmChoose != null) return@setOnClickListener

            val dialog = UIUtils.getActionDialog(
                context,
                R.string.confirm,
                String.format(getString(R.string.dialog_doctrine_confirm_choose), getString(adv.idName), getString(doc.idName)),
                R.string.yes
            ) { _, _ ->
                adv.doctrine = doc
                readOnly = false
                MainActivity.shownDialogChooseDoctrine?.dismiss()
                MainActivity.shownDialogEntityDetail?.update()
                MainActivity.adventurersFragment.refresh()
                initialize(null)
            }
            confirmChoose = dialog
            dialog.setOnDismissListener { confirmChoose = null }
            dialog.show()
        }

        b.reset.setOnClickListener {
            val adv = adventurer ?: return@setOnClickListener
            if (MainActivity.shownDialogDoctrineReset != null) return@setOnClickListener
            val resetDialog = DialogDoctrineReset()
            resetDialog.adventurer = adv
            MainActivity.shownDialogDoctrineReset = resetDialog
            resetDialog.show(parentFragmentManager, "dialog_reset_doctrine")
        }

        b.close.setOnClickListener { dismiss() }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogDoctrine = this
    }

    override fun onStop() {
        if (!MainActivity.data.isDoctrineMaxed && isMaxed()) {
            MainActivity.data.isDoctrineMaxed = true
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_JACK_OF_ONE_TRADE)
        }
        MainActivity.shownDialogDoctrine = null
        super.onStop()
    }

    override fun onDismiss(dialog: DialogInterface) {
        try {
            val adv = adventurer
            if (adv != null && openWithAvailablePoints != (adv.getDoctrinePoints() > 0)) {
                MainActivity.shownDialogEntityDetail?.update()
                MainActivity.adventurersFragment.refresh()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onDismiss(dialog)
    }

    private fun isMaxed(): Boolean {
        val doc = doctrine ?: return false
        if (doc is EmptyDoctrine) return false
        for (ability in doc.abilities) {
            val type = ability.type ?: continue
            if (ability.level < type.maxLevel) {
                return false
            }
        }
        return true
    }
}
