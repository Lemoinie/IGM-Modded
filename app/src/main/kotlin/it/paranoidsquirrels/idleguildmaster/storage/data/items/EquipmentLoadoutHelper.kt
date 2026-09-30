package it.paranoidsquirrels.idleguildmaster.storage.data.items

import android.content.res.Resources
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.SavedEquipment

/**
 * Conflict-safe resolver for Area Gear Loadouts.
 *
 * `snapshotHeroGear` captures a hero's currently equipped weapon/armor/accessory as
 * class-name strings; `applyHeroGear` re-equips a saved loadout resolving each slot as:
 * keep when already equipped -> take from warehouse storage -> swap from an idle guild
 * hero -> skip with a warning when the piece is on an active explorer or no longer exists.
 *
 * Active explorers are always protected: a piece equipped on a hero mid-run elsewhere can
 * never be stolen. Default weapons are never collected into storage, matching the vanilla
 * equip/unequip flow (`DialogSelectEquipment`).
 */
object EquipmentLoadoutHelper {
    private var cachedResources: Resources? = null

    @JvmStatic
    fun snapshotHeroGear(adv: Adventurer): SavedEquipment {
        return SavedEquipment(
            adv.weapon?.getTrueClass(),
            adv.armor?.getTrueClass(),
            adv.accessory?.getTrueClass()
        )
    }

    @JvmStatic
    fun applyHeroGear(adv: Adventurer, target: SavedEquipment, warnings: MutableList<String>) {
        applySlot(
            adv, target.weapon, adv.weapon,
            { it -> adv.weapon = it as? Weapon },
            { holder: Adventurer -> holder.weapon },
            { holder: Adventurer, it -> holder.weapon = it as? Weapon },
            { holder: Adventurer -> Utils.getDefaultWeapon(holder.weaponType) },
            warnings
        )
        applySlot(
            adv, target.armor, adv.armor,
            { it -> adv.armor = it as? Armor },
            { holder: Adventurer -> holder.armor },
            { holder: Adventurer, it -> holder.armor = it as? Armor },
            { _: Adventurer -> null },
            warnings
        )
        applySlot(
            adv, target.accessory, adv.accessory,
            { it -> adv.accessory = it as? Accessory },
            { holder: Adventurer -> holder.accessory },
            { holder: Adventurer, it -> holder.accessory = it as? Accessory },
            { _: Adventurer -> null },
            warnings
        )
    }

    /**
     * Applies one saved equipment slot to [adv], resolving conflicts per the loadout rules.
     *
     * @param adv the target hero receiving the loadout
     * @param savedClassName the saved item class name for this slot (null = nothing saved -> keep current)
     * @param current the hero's current equipment in this slot
     * @param setOnHero assigns an item to the target hero's slot
     * @param readFromAdventurer reads the same slot of any other hero (to find the holder)
     * @param setOnAdventurer assigns a fallback to a yielding idle hero's same slot
     * @param fallbackFor the fallback a yielding idle hero receives (default weapon for weapon slots, else null)
     */
    private fun applySlot(
        adv: Adventurer,
        savedClassName: String?,
        current: Equipment?,
        setOnHero: (Equipment?) -> Unit,
        readFromAdventurer: (Adventurer) -> Equipment?,
        setOnAdventurer: (Adventurer, Equipment?) -> Unit,
        fallbackFor: (Adventurer) -> Equipment?,
        warnings: MutableList<String>
    ) {
        if (savedClassName == null || savedClassName.isEmpty()) return
        // Already equipped -> keep (no change).
        if (current?.getTrueClass() == savedClassName) return

        val targetItem = Item.getInstance(savedClassName, 1)
        if (targetItem == null || targetItem !is Equipment) {
            warnMissing(adv, savedClassName, warnings)
            return
        }

        val storage = MainActivity.data.items
        val defaultWeapon = Utils.getDefaultWeapon(adv.weaponType)
        val currentIsCollectable = current != null && defaultWeapon != current

        // 1) Prefer warehouse storage: take the piece and swap it with the current one.
        val stored = storage.firstOrNull { it.getTrueClass() == savedClassName }
        if (stored != null) {
            // Remove first so the 1-for-1 exchange never exceeds the storage capacity.
            Utils.removeItemFromStorage(targetItem)
            if (currentIsCollectable) {
                Utils.collectItem(current, storage)
            }
            setOnHero(targetItem)
            return
        }

        // 2) The piece is equipped on another adventurer.
        var holder: Adventurer? = null
        for (candidate in MainActivity.data.adventurers) {
            if (candidate.id == adv.id) continue
            if (readFromAdventurer(candidate)?.getTrueClass() == savedClassName) {
                holder = candidate
                break
            }
        }
        if (holder == null) {
            // 3) The piece no longer exists (sold / deleted) -> keep current gear.
            warnMissing(adv, savedClassName, warnings)
            return
        }
        if (isExploringElsewhere(holder!!)) {
            // Active explorers are protected: the piece cannot be taken mid-run.
            warnInUse(adv, targetItem, holder!!, warnings)
            return
        }

        // Idle guild members yield their gear; they fall back to the default weapon / empty slot.
        if (currentIsCollectable && Formulas.storageSpaces() <= storage.size) {
            warnStorageFull(adv, targetItem, warnings)
            return
        }
        if (currentIsCollectable) {
            Utils.collectItem(current, storage)
        }
        setOnHero(targetItem)
        setOnAdventurer(holder!!, fallbackFor(holder!!))
    }

    private fun isExploringElsewhere(adv: Adventurer): Boolean {
        for (area in Utils.compileDungeonRaidList()) {
            if (area.adventurersExploringIds.contains(adv.id)) return true
        }
        return false
    }

    private fun findAreaOf(adv: Adventurer): Area? {
        for (area in Utils.compileDungeonRaidList()) {
            if (area.adventurersExploringIds.contains(adv.id)) return area
        }
        return null
    }

    private fun warnMissing(adv: Adventurer, itemClass: String, warnings: MutableList<String>) {
        warnings.add(String.format(str(R.string.load_team_gear_missing, "%s can\'t equip %s: item not found"), heroName(adv), itemClass))
    }

    private fun warnInUse(adv: Adventurer, item: Item, explorer: Adventurer, warnings: MutableList<String>) {
        val holderArea = findAreaOf(explorer)
        val areaLabel = if (holderArea != null) areaName(holderArea) else "?"
        warnings.add(String.format(str(R.string.load_team_gear_busy, "%s can\'t equip %s: currently in use by %s in %s"), heroName(adv), itemName(item), heroName(explorer), areaLabel))
    }

    private fun warnStorageFull(adv: Adventurer, item: Item, warnings: MutableList<String>) {
        warnings.add(String.format(str(R.string.load_team_gear_storage_full, "%s can\'t equip %s: storage is full"), heroName(adv), itemName(item)))
    }

    private fun heroName(adv: Adventurer): String = str(adv.idName, adv.trueClass ?: "?")

    private fun itemName(item: Item): String = str(item.getIdName(), item.getTrueClass() ?: "?")

    private fun areaName(area: Area): String = str(area.getName(), (area as java.lang.Object).getClass().getSimpleName())

    private fun str(resId: Int, fallback: String): String = resources()?.getString(resId) ?: fallback

    private fun resources(): Resources? {
        if (cachedResources == null) {
            cachedResources = try {
                val frag = MainActivity.dungeonsFragment
                if (frag != null) frag.resources else null
            } catch (_: Exception) {
                null
            }
        }
        return cachedResources
    }
}