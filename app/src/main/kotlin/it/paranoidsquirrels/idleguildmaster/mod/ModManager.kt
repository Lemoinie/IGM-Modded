package it.paranoidsquirrels.idleguildmaster.mod

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager
import it.paranoidsquirrels.idleguildmaster.storage.SaveResetter
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo22
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeXPBook
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings
import java.util.concurrent.CopyOnWriteArrayList
import java.util.regex.Pattern

object ModManager {

    const val IMPERIAL_CAPTAIN_THRESHOLD = 100

    @JvmStatic
    fun onItemConsume(item: Item): Boolean {
        if (item is XPBook1 || item is XPBook2 || item is XPBook3 || item is XPBook10) {
            if (item.stack > 0 && MainActivity.headquartersFragment != null) {
                val dialog = DialogConsumeXPBook()
                dialog.selectedBook = item as Consumable
                dialog.show(MainActivity.headquartersFragment!!.parentFragmentManager, "dialog_consume_xpbook")
                return true
            }
        } else if (item is Evo22Vial) {
            if (item.stack > 0 && MainActivity.headquartersFragment != null) {
                val dialog = DialogConsumeEvo22()
                dialog.show(MainActivity.headquartersFragment!!.parentFragmentManager, "dialog_consume_evo22")
                return true
            }
        }
        return false
    }

    @JvmStatic
    fun onAdventurerDismissed(adventurer: Adventurer?) {
        if (adventurer == null) return
        adventurer.weapon?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.weapon = null
        }
        adventurer.armor?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.armor = null
        }
        adventurer.accessory?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.accessory = null
        }
    }

    @JvmStatic
    fun saveGameSynchronous(context: Context?) {
        if (context == null || MainActivity.data == null) return
        try {
            MainActivity.data.lastAccess = TrueTimeUtils.millis()
            if (!SaveManager.inhibitSave && (MainActivity.IDLE_THREAD_FINISHED == null || MainActivity.IDLE_THREAD_FINISHED.value)) {
                FileManager.save(context)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Packed int field storage in data.redeem_m975nfu5:
    // Bits 0-9: Imperial kills (0-1023)
    // Bits 10-17: Idle progress cap in hours (12 to 168)
    // Bits 18-31: Loot cap override
    private fun getPacked(): Int {
        return try { MainActivity.data.redeem_m975nfu5 } catch (e: Exception) { 0 }
    }

    private fun setPacked(packed: Int) {
        try { MainActivity.data.redeem_m975nfu5 = packed } catch (e: Exception) { e.printStackTrace() }
    }

    @JvmStatic
    fun getImperialKills(): Int = getPacked() and 0x3FF

    @JvmStatic
    fun setImperialKills(amount: Int, context: Context?) {
        val clamped = amount.coerceIn(0, 1023)
        setPacked((getPacked() and 0x3FF.inv()) or clamped)
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun shouldSpawnImperialCaptain(): Boolean {
        return try {
            if (MainActivity.data == null) false
            else getImperialKills() >= IMPERIAL_CAPTAIN_THRESHOLD && Math.random() < 0.5
        } catch (e: Exception) {
            false
        }
    }

    @JvmStatic
    fun onEnemyKilled(trueClass: String, context: Context?): Boolean {
        if (trueClass == "ImperialGuard") {
            setImperialKills(getImperialKills() + 1, context)
            return true
        }
        return false
    }

    @JvmStatic
    fun getIdleTimeCap(vanillaCapSeconds: Int): Int {
        val hours = (getPacked() shr 10) and 0xFF
        return if (hours in 12..168) hours * 3600 else vanillaCapSeconds
    }

    @JvmStatic
    fun setIdleTimeCap(hours: Int, context: Context?) {
        val clamped = hours.coerceIn(12, 168)
        setPacked((getPacked() and (0xFF shl 10).inv()) or (clamped shl 10))
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun getLootCap(): Int {
        val cap = (getPacked() shr 18) and 0x3FFF
        return if (cap > 0) cap else 50
    }

    @JvmStatic
    fun setLootCap(cap: Int, context: Context?) {
        val clamped = cap.coerceIn(10, 16000)
        setPacked((getPacked() and (0x3FFF shl 18).inv()) or (clamped shl 18))
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun dragonBloodMultiplier(entity: Entity, currentDamage: Double): Double {
        return try {
            if (entity is Adventurer && entity.traitRare == Trait.DRAGON_BLOOD) {
                val tier = entity.maxLevel / 5
                currentDamage * Math.max(0.0, 1.0 - (tier * 0.01))
            } else {
                currentDamage
            }
        } catch (e: Exception) {
            currentDamage
        }
    }

    @JvmStatic
    fun setAdventurerCommonTrait(adv: Adventurer, trait: Trait): Boolean {
        adv.traitCommon = trait
        return true
    }

    @JvmStatic
    fun refreshShop() {
        try {
            val d = MainActivity.data ?: return
            d.merchantRegularStockItems.clear()
            d.isNewMerchantRegularItems = true
            MainActivity.headquartersFragment?.refresh()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun addGold(amount: Long) {
        val d = MainActivity.data ?: return
        d.money = (d.money + amount).coerceAtLeast(0L)
        MainActivity.headquartersFragment?.refresh()
    }

    @JvmStatic
    fun expandStorage(extraSlots: Int, context: Context?) {
        val d = MainActivity.data ?: return
        d.upgradeStorage += extraSlots
        MainActivity.headquartersFragment?.refresh()
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun processRedeemCode(code: String?, context: Context?): String? {
        if (code.isNullOrBlank() || MainActivity.data == null) return null
        val upper = code.trim().uppercase()

        if (upper == "SHOP") {
            refreshShop()
            saveGameSynchronous(context)
            return "Shop refreshed!"
        }
        if (upper.startsWith("GOLD ")) {
            return try {
                val amount = code.substring(5).trim().toLong()
                addGold(amount)
                saveGameSynchronous(context)
                "Added $amount Gold!"
            } catch (e: Exception) { "Invalid gold amount" }
        }
        if (upper.startsWith("STORAGE ")) {
            return try {
                val slots = code.substring(8).trim().toInt()
                expandStorage(slots, context)
                "Expanded warehouse by $slots slots!"
            } catch (e: Exception) { "Invalid storage slots" }
        }
        if (upper.startsWith("IDLETIME ")) {
            return try {
                val hours = code.substring(9).trim().toInt()
                setIdleTimeCap(hours, context)
                "Idle progress cap set to $hours hours!"
            } catch (e: Exception) { "Usage: IDLETIME <12-168>" }
        }
        if (upper.startsWith("LOOTCAP ")) {
            return try {
                val cap = code.substring(8).trim().toInt()
                setLootCap(cap, context)
                "Chest loot capacity set to $cap!"
            } catch (e: Exception) { "Usage: LOOTCAP <10-16000>" }
        }
        if (upper == "QUEST") {
            try {
                MainActivity.data.kingsQuests.clear()
                MainActivity.data.isQuestsRefreshed = true
                MainActivity.headquartersFragment?.refresh()
                saveGameSynchronous(context)
                return "Quests refreshed!"
            } catch (e: Exception) { return "Failed to refresh quests" }
        }
        if (upper == "KILLS") {
            return "Imperial Guard kills: ${getImperialKills()} / $IMPERIAL_CAPTAIN_THRESHOLD"
        }
        if (upper.startsWith("SETKILLS ")) {
            return try {
                val n = code.substring(9).trim().toInt()
                setImperialKills(n, context)
                "Imperial Guard kills set to $n!"
            } catch (e: Exception) { "Usage: SETKILLS <0-1023>" }
        }
        if (upper.startsWith("ITEM ")) {
            return giveItemCode(code.substring(5).trim(), context)
        }
        if (upper.startsWith("HERO ")) {
            return createCustomAdventurer(code.substring(5).trim(), context)
        }
        if (upper.startsWith("PET ")) {
            return spawnPetCode(code.substring(4).trim(), context)
        }

        return null
    }

    @JvmStatic
    fun giveItemCode(itemSpec: String, context: Context?): String {
        return try {
            val parts = itemSpec.split(" ")
            val name = parts[0]
            val count = if (parts.size > 1) parts[1].toInt() else 1
            val item = Item.getInstance(name, count) ?: return "Item '$name' not found"
            Utils.collectItem(item, MainActivity.data.items)
            MainActivity.shownDialogStorage?.update()
            saveGameSynchronous(context)
            "Collected $count x $name!"
        } catch (e: Exception) {
            "Usage: ITEM <ItemName> [count]"
        }
    }

    @JvmStatic
    fun createCustomAdventurer(spec: String, context: Context?): String {
        return try {
            val parts = spec.split(" ")
            val unitClass = parts[0]
            val level = if (parts.size > 1) parts[1].toInt() else 1
            val newId = Utils.calculateNewAdventurerId()
            val adv = Adventurer.getInstance(unitClass, newId, level, 0, null, null, null, null, null, PotionsDrank(), null, false)
                ?: return "Hero class '$unitClass' not found"
            if (parts.size > 2) adv.traitCommon = Trait.fromString(parts[2])
            if (parts.size > 3) adv.traitRare = Trait.fromString(parts[3])
            MainActivity.data.adventurers.add(adv)
            MainActivity.adventurersFragment?.refresh()
            MainActivity.headquartersFragment?.refresh()
            saveGameSynchronous(context)
            "Created $unitClass (Lvl $level)!"
        } catch (e: Exception) {
            "Usage: HERO <Class> [level] [commonTrait] [rareTrait]"
        }
    }

    @JvmStatic
    fun spawnPetCode(spec: String, context: Context?): String {
        return try {
            val parts = spec.split(" ")
            val petClass = parts[0]
            val level = if (parts.size > 1) parts[1].toInt() else 1
            val id = Utils.calculateNewPetId()
            val pet = Pet.getInstance(petClass, id) ?: return "Pet '$petClass' not found"
            pet.level = level
            MainActivity.data.pets.add(pet)
            MainActivity.headquartersFragment?.refresh()
            saveGameSynchronous(context)
            "Pet '$petClass' added to shelter!"
        } catch (e: Exception) {
            "Usage: PET <PetClass> [level]"
        }
    }

    @JvmStatic
    fun wireSettingsReset(dialog: DialogSettings) {
        val ctx = dialog.context ?: return
        val dlg = dialog.dialog ?: return
        val win = dlg.window ?: return
        val root = win.decorView
        val resetId = ctx.resources.getIdentifier("reset", "id", ctx.packageName)
        if (resetId != 0) {
            root.findViewById<View>(resetId)?.setOnClickListener {
                SaveResetter.showResetConfirmation(ctx, dialog.activity)
            }
        }
    }

    @JvmStatic
    fun showModAbout(activity: Activity) {
        val versions = arrayOf(
            "v2.148-mod-rebuilt.1 - Standalone 100% Kotlin Rebuild",
            "v2.148-mod.8 - Imperial Captain & Execution Order",
            "v2.148-mod.7 - Knight Slime & Slime Pond Boss",
            "v2.148-mod.6 - Custom Consumables (XP Books & Evo22)",
            "v2.148-mod.5 - Comprehensive Redeem Engine",
            "v2.148-mod.4 - Balance Reworks & Ruthless+",
            "v2.148-mod.3 - Celestial Bow & Captain's Sword",
            "v2.148-mod.2 - Senko the Divine Kitsune Pet",
            "v2.148-mod.1 - Initial Modded Release"
        )
        val details = arrayOf(
            "Rebuilt entire game codebase cleanly into 100% native Kotlin without smali patches. Integrated wireless ADB tooling and automated build pipeline.",
            "Encounter the Imperial Captain in The Golden City after slaying 100 Imperial Guards. Features stacking Imperial Authority and Execution Order boss skill.",
            "Defeat the Knight Slime in The Slime Pond raid. Armored defender with 50% physical damage resistance and rare Iron Helm drops.",
            "Consume XP Books (Tier 1-10) to grant direct experience to any adventurer. Use Evo-22 Vials to upgrade common traits to PLUS variants.",
            "Expanded Redeem Code engine: GOLD, STORAGE, IDLETIME, LOOTCAP, SHOP, QUEST, KILLS, SETKILLS, ITEM, HERO, PET.",
            "Buffed doctrines (Improved Health +25, Troll Resistance max 5, Lightning Speed +20%). Reworked traits (Troll Blood % HP, Dragon Blood % dmg reduction, Ruthless+ 1.3x crit).",
            "Added Captain's Sword (stun on hit) and Celestial Bow (astral multi-attack).",
            "Added Senko: divine kitsune spirit pet with +20% healer, +5 regen, light, and 4 ability slots.",
            "App name updated to IGM Modded, Balrog unit icon, independent build and deployment scripts."
        )

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("IGM Modded - Changelog")
        builder.setItems(versions) { _, which ->
            AlertDialog.Builder(activity)
                .setTitle(versions[which])
                .setMessage(details[which])
                .setPositiveButton("OK", null)
                .show()
        }
        builder.setPositiveButton("Close", null)
        builder.show()
    }

}
