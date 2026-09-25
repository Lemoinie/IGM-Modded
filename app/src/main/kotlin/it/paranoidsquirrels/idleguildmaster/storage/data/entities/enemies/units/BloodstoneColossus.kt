package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

/**
 * Bloodstone Colossus — a high-threat frontline construct in The Sanguine Crucible.
 * Slow but extremely durable, it peels attacks away from the fragile Crimson Acolytes
 * and Archmagus Valthex (threat 8 vs the Acolyte's 4 and Valthex's 1).
 */
class BloodstoneColossus : Enemy() {
    override fun getMaxDamage(): Int = 180
    override fun getMinDamage(): Int = 120
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 12000
        baseConstitution = 120
        baseDexterity = 30
        baseIntelligence = 10
        baseDefense = 80
        baseMagicDefense = 40
        threat = 8
        imageId = R.drawable.bloodstone_colossus
        idName = R.string.enemy_bloodstone_colossus_name
        idDescription = R.string.enemy_bloodstone_colossus_description
        passiveSkill = Skills.PASSIVE_THREATENING_IV
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 3500

        // Standard Crucible elemental immunity.
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLOODFLAME)
        // Inorganic construct: immune to bleeding and poisons.
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
    }

    /** Scarlet Debris is the only drop, displayed in the Bestiary / inspection UI. */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScarletDebris", 1), 1000)
        return linkedHashMap
    }

    /** Independent roll: 1% Scarlet Debris per kill. */
    override fun rollDrops(evKey: Int): List<ItemWrapper> {
        val rolled = ArrayList<ItemWrapper>()
        if (Utils.random() < 0.01) rolled.add(ItemWrapper.getInstance("ScarletDebris", 1))
        return rolled
    }
}