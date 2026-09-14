package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSelectEquipmentBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutSelectEquipmentBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.CopperArmor
import java.util.ArrayList

class DialogSelectEquipment : CustomDialog() {
    @JvmField
    var adventurer: Adventurer? = null
    @JvmField
    var binding: DialogSelectEquipmentBinding? = null
    private var confirm: AlertDialog? = null
    @JvmField
    var type: String? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogSelectEquipmentBinding
    }

    override fun getTitle(): String {
        val adv = adventurer
        val t = type
        if (adv == null || t == null) {
            dismiss()
            return ""
        }
        return when (t) {
            "accessory" -> getString(R.string.select_accessory_title)
            "weapon" -> String.format(
                getString(R.string.select_equipment_variable_title),
                getString(if (adv.doctrine?.canUseAllWeapons() == true) R.string.type_generic else adv.weaponType)
            )
            "armor" -> String.format(
                getString(R.string.select_equipment_variable_title),
                getString(adv.armorType)
            )
            else -> ""
        }
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogSelectEquipmentBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        val b = binding ?: return
        val adv = adventurer ?: run { dismiss(); return }
        val t = type ?: run { dismiss(); return }

        val equipped: Equipment?
        val slotType: Int
        when (t) {
            "accessory" -> {
                equipped = adv.accessory
                slotType = R.string.type_accessory
            }
            "weapon" -> {
                equipped = adv.weapon
                slotType = adv.weaponType
            }
            "armor" -> {
                equipped = adv.armor
                slotType = adv.armorType
            }
            else -> throw NullPointerException("null type in DialogSelectEquipment initialize")
        }

        if (equipped != null) {
            b.equipped.item.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, equipped.getIdImage(), context?.theme)
            )
            b.equipped.item.stack.text = ""
            b.equipped.name.setText(equipped.getIdName())
            setGainLoss(b.equipped, null, equipped)
            b.equipped.effect.text = if (equipped.getIdEffect() != 0) getString(equipped.getIdEffect()) else ""
        }

        val available = ArrayList<Equipment>()
        for (item in MainActivity.data.items) {
            if (item.printType() == slotType || (adv.doctrine?.canUseAllWeapons() == true && "weapon" == t && item is Weapon)) {
                if (item is Equipment) {
                    available.add(item)
                }
            }
        }
        available.sortBy { -it.getRarity() }

        b.list.removeAllViews()
        for (equipment in available) {
            val itemBinding = LayoutSelectEquipmentBinding.inflate(layoutInflater, b.list, false)
            itemBinding.item.image.setBackgroundResource(R.drawable.object_border_rounded_left)
            itemBinding.item.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, equipment.getIdImage(), context?.theme)
            )
            itemBinding.item.stack.text = equipment.getStack().toString()
            itemBinding.name.setText(equipment.getIdName())
            setGainLoss(itemBinding, equipped, equipment)
            itemBinding.gain.setTextColor(resources.getColor(R.color.success, context?.theme))
            itemBinding.loss.setTextColor(resources.getColor(UIUtils.getFailureColor(), context?.theme))
            itemBinding.effect.text = if (equipment.getIdEffect() != 0) getString(equipment.getIdEffect()) else ""
            itemBinding.root.setOnClickListener { askSwap(equipment) }
            b.list.addView(itemBinding.root)
        }

        b.scrollView.visibility = if (available.isNotEmpty()) View.VISIBLE else View.GONE
        b.noEquipments.visibility = if (available.isNotEmpty()) View.GONE else View.VISIBLE
    }

    private fun askSwap(equipment: Equipment) {
        val adv = adventurer ?: return
        val t = type ?: return
        val current: Equipment? = when (t) {
            "accessory" -> adv.accessory
            "weapon" -> adv.weapon
            "armor" -> adv.armor
            else -> throw NullPointerException("null type in DialogSelectEquipment askSwap")
        }

        if (current == null) {
            swap(null, equipment)
            return
        }

        if (Formulas.storageSpaces() <= MainActivity.data.items.size && !MainActivity.data.items.contains(current) && equipment.getStack() > 1) {
            if (MainActivity.shownDialogFullStorage != null) return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                getString(R.string.no_storage_space_body_swap),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
            dialog.show()
            return
        }

        if (MainActivity.data.isSettingConfirmSwap) {
            val isKorean = "ko" == getString(R.string.language_code)
            val dialog = UIUtils.getActionDialog(
                context,
                R.string.change_equipment_title,
                String.format(
                    getString(R.string.change_equipment_body),
                    getString(if (isKorean) current.getIdName() else equipment.getIdName()),
                    getString(if (isKorean) equipment.getIdName() else current.getIdName())
                ),
                R.string.yes
            ) { _, _ -> swap(current, equipment) }
            confirm = dialog
            dialog.setOnDismissListener { confirm = null }
            dialog.show()
            return
        }

        swap(current, equipment)
    }

    private fun swap(current: Equipment?, newEq: Equipment) {
        val adv = adventurer ?: return
        val t = type ?: return
        val toEquip = Item.getInstance(newEq.getTrueClass() ?: "", 1) as Equipment
        val defaultWeapon = Utils.getDefaultWeapon(adv.weaponType)

        if (current != null && defaultWeapon != current) {
            Utils.collectItem(current, MainActivity.data.items)
        }
        Utils.removeItemFromStorage(toEquip)

        when (t) {
            "accessory" -> adv.accessory = toEquip as? Accessory
            "weapon" -> adv.weapon = toEquip as? Weapon
            "armor" -> adv.armor = toEquip as? Armor
            else -> throw NullPointerException("null type in DialogSelectEquipment swap")
        }

        MainActivity.adventurersFragment.refresh()
        MainActivity.headquartersFragment.refresh()
        MainActivity.shownDialogEntityDetail?.let { detail ->
            detail.update()
            detail.populateHelp(
                null,
                DialogEntityDetail.formatEquipmentHelp(newEq, resources),
                true,
                t
            )
        }

        if (MainActivity.data.tutorialStep == 5 && newEq is CopperArmor) {
            MainActivity.data.tutorialStep = 6
            Utils.progressTavernTime(28800L)
            (MainActivity.dungeonsFragment.activity as? MainActivity)?.refresh()
        }

        val maxHp = adv.calculateTotalMaxHp()
        if (adv.currentHp > maxHp) {
            adv.currentHp = maxHp
        }

        if ("SerpentSting" == toEquip.getTrueClass()) {
            adv.addStatusEffect(StatusEffect(StatusEffectType.STUN_NOT_CLEANSABLE, adv, 1, 1.0), 0.0)
        }

        dismiss()
    }

    private fun unequip() {
        val adv = adventurer ?: return
        val t = type ?: return
        val defaultWeapon = Utils.getDefaultWeapon(adv.weaponType)

        val current: Equipment? = when (t) {
            "accessory" -> adv.accessory
            "weapon" -> adv.weapon
            "armor" -> adv.armor
            else -> throw NullPointerException("null type in DialogSelectEquipment askSwap")
        }

        if (current == null || current == defaultWeapon) return

        if (Formulas.storageSpaces() <= MainActivity.data.items.size && !MainActivity.data.items.contains(current)) {
            if (MainActivity.shownDialogFullStorage != null) return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                getString(R.string.no_storage_space_body_unequip),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
            dialog.show()
            return
        }

        if (defaultWeapon != current) {
            Utils.collectItem(current, MainActivity.data.items)
        }

        when (t) {
            "accessory" -> adv.accessory = null
            "weapon" -> adv.weapon = defaultWeapon
            "armor" -> adv.armor = null
            else -> throw NullPointerException("null type in DialogSelectEquipment unequip")
        }

        MainActivity.adventurersFragment.refresh()
        MainActivity.headquartersFragment.refresh()
        MainActivity.shownDialogEntityDetail?.let { detail ->
            detail.update()
            detail.populateHelp(
                null,
                if ("weapon" == t) DialogEntityDetail.formatEquipmentHelp(defaultWeapon, resources) else "",
                true,
                t
            )
        }

        val maxHp = adv.calculateTotalMaxHp()
        if (adv.currentHp > maxHp) {
            adv.currentHp = maxHp
        }

        dismiss()
    }

    private fun setGainLoss(itemBinding: LayoutSelectEquipmentBinding, current: Equipment?, newEq: Equipment) {
        var gainStr = ""
        var lossStr = ""

        val hpDiff = newEq.getMaxHp() - (current?.getMaxHp() ?: 0)
        val hpText = UIUtils.formatStat(R.string.hp_difference, hpDiff, resources)
        if (hpDiff > 0) gainStr += hpText else if (hpDiff < 0) lossStr += hpText

        val conDiff = newEq.getConstitution() - (current?.getConstitution() ?: 0)
        val conText = UIUtils.formatStat(R.string.constitution_difference, conDiff, resources)
        if (conDiff > 0) gainStr += conText else if (conDiff < 0) lossStr += conText

        val intDiff = newEq.getIntelligence() - (current?.getIntelligence() ?: 0)
        val intText = UIUtils.formatStat(R.string.intelligence_difference, intDiff, resources)
        if (intDiff > 0) gainStr += intText else if (intDiff < 0) lossStr += intText

        val dexDiff = newEq.getDexterity() - (current?.getDexterity() ?: 0)
        val dexText = UIUtils.formatStat(R.string.dexterity_difference, dexDiff, resources)
        if (dexDiff > 0) gainStr += dexText else if (dexDiff < 0) lossStr += dexText

        val defDiff = newEq.getDefense() - (current?.getDefense() ?: 0)
        val defText = UIUtils.formatStat(R.string.defense_difference, defDiff, resources)
        if (defDiff > 0) gainStr += defText else if (defDiff < 0) lossStr += defText

        val mDefDiff = newEq.getMagicDefense() - (current?.getMagicDefense() ?: 0)
        val mDefText = UIUtils.formatStat(R.string.magic_defence_difference, mDefDiff, resources)
        if (mDefDiff > 0) gainStr += mDefText else if (mDefDiff < 0) lossStr += mDefText

        itemBinding.gain.text = gainStr
        itemBinding.gain.visibility = if (gainStr.isEmpty()) View.GONE else View.VISIBLE
        itemBinding.loss.text = lossStr
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.close.setOnClickListener { dismiss() }
        b.unequip.setOnClickListener { unequip() }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogSelectEquipment = this
    }

    override fun onStop() {
        MainActivity.shownDialogSelectEquipment = null
        super.onStop()
    }
}
