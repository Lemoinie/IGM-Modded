package it.paranoidsquirrels.idleguildmaster.game.redeem

import android.content.Context
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity

/**
 * Redeem-code console for the player. Codes modify live game state directly and
 * persist through [FileManager.saveNow].
 *
 * Supported codes (case-insensitive):
 * - `SHOP`            – force restock of regular merchant offers
 * - `QUEST`           – refresh / reroll King's quests
 * - `GOLD <amount>`   – add gold to the guild vault
 * - `STORAGE <slots>` – expand warehouse capacity
 * - `IDLETIME <h>`    – offline-idle cap in hours (12..168)
 * - `LOOTCAP <cap>`   – dungeon chest loot cap (override)
 * - `KILLS` / `SETKILLS <n>` – query/set Imperial Guard kill count
 * - `ITEM <Name> [count]`    – grant an item
 * - `HERO <Class> [level] [trait] [trait]` – create an adventurer
 * - `PET <Class> [level]`    – add a pet to the shelter
 */
object RedeemCodes {

    @JvmStatic
    fun process(code: String?, context: Context?): String? {
        if (code.isNullOrBlank() || MainActivity.data == null) return null
        val upper = code.trim().uppercase()

        if (upper == "SHOP") {
            refreshMerchantStock()
            FileManager.saveNow(context)
            return "Shop refreshed!"
        }
        if (upper.startsWith("GOLD ")) {
            return try {
                val amount = code.substring(5).trim().toLong()
                addGold(amount)
                FileManager.saveNow(context)
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
                MainActivity.data.idleTimeCapHours = hours.coerceIn(12, 168)
                FileManager.saveNow(context)
                "Idle progress cap set to $hours hours!"
            } catch (e: Exception) { "Usage: IDLETIME <12-168>" }
        }
        if (upper.startsWith("LOOTCAP ")) {
            return try {
                val cap = code.substring(8).trim().toInt()
                MainActivity.data.lootCap = cap.coerceIn(10, 16000)
                FileManager.saveNow(context)
                "Chest loot capacity set to $cap!"
            } catch (e: Exception) { "Usage: LOOTCAP <10-16000>" }
        }
        if (upper == "QUEST") {
            try {
                MainActivity.data.kingsQuests.clear()
                MainActivity.data.isQuestsRefreshed = true
                MainActivity.headquartersFragment.refresh()
                FileManager.saveNow(context)
                return "Quests refreshed!"
            } catch (e: Exception) { return "Failed to refresh quests" }
        }
        if (upper == "KILLS") {
            val kills = MainActivity.data.imperialKills
            return "Imperial Guard kills: $kills / ${TheGoldenCity.IMPERIAL_CAPTAIN_KILL_THRESHOLD}"
        }
        if (upper.startsWith("SETKILLS ")) {
            return try {
                val n = code.substring(9).trim().toInt()
                MainActivity.data.imperialKills = n.coerceIn(0, 1023)
                FileManager.saveNow(context)
                "Imperial Guard kills set to $n!"
            } catch (e: Exception) { "Usage: SETKILLS <0-1023>" }
        }
        if (upper.startsWith("ITEM ")) {
            return giveItem(code.substring(5).trim(), context)
        }
        if (upper.startsWith("HERO ")) {
            return createCustomAdventurer(code.substring(5).trim(), context)
        }
        if (upper.startsWith("PET ")) {
            return spawnPet(code.substring(4).trim(), context)
        }

        return null
    }

    /** Forces an immediate restock of regular merchant offers. */
    @JvmStatic
    fun refreshMerchantStock() {
        try {
            val d = MainActivity.data ?: return
            d.merchantRegularStockItems.clear()
            d.isNewMerchantRegularItems = true
            MainActivity.headquartersFragment.refresh()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun addGold(amount: Long) {
        val d = MainActivity.data ?: return
        d.money = (d.money + amount).coerceAtLeast(0L)
        MainActivity.headquartersFragment.refresh()
    }

    @JvmStatic
    fun expandStorage(extraSlots: Int, context: Context?) {
        val d = MainActivity.data ?: return
        d.upgradeStorage += extraSlots
        MainActivity.headquartersFragment.refresh()
        FileManager.saveNow(context)
    }

    @JvmStatic
    fun giveItem(itemSpec: String, context: Context?): String {
        return try {
            val parts = itemSpec.split(" ")
            val name = parts[0]
            val count = if (parts.size > 1) parts[1].toInt() else 1
            val item = Item.getInstance(name, count) ?: return "Item '$name' not found"
            Utils.collectItem(item, MainActivity.data.items)
            MainActivity.shownDialogStorage?.update()
            FileManager.saveNow(context)
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
            MainActivity.adventurersFragment.refresh()
            MainActivity.headquartersFragment.refresh()
            FileManager.saveNow(context)
            "Created $unitClass (Lvl $level)!"
        } catch (e: Exception) {
            "Usage: HERO <Class> [level] [commonTrait] [rareTrait]"
        }
    }

    @JvmStatic
    fun spawnPet(spec: String, context: Context?): String {
        return try {
            val parts = spec.split(" ")
            val petClass = parts[0]
            val level = if (parts.size > 1) parts[1].toInt() else 1
            val id = Utils.calculateNewPetId()
            val pet = Pet.getInstance(petClass, id) ?: return "Pet '$petClass' not found"
            pet.level = level
            MainActivity.data.pets.add(pet)
            MainActivity.headquartersFragment.refresh()
            FileManager.saveNow(context)
            "Pet '$petClass' added to shelter!"
        } catch (e: Exception) {
            "Usage: PET <PetClass> [level]"
        }
    }
}