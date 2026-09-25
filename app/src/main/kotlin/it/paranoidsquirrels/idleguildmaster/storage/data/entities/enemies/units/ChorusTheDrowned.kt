package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

/**
 * Chorus the Drowned — the ultra-rare (0.1% hook) specter of The Slumbering Shallows.
 * Hits devastatingly hard (70–100) but carries no made-up equipment: he drops a plain
 * vanilla CoinPurse, guaranteed.
 */
class ChorusTheDrowned : Enemy() {
    override fun getMaxDamage(): Int = 100
    override fun getMinDamage(): Int = 70
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1850
        baseConstitution = 120
        baseIntelligence = 60
        baseDexterity = 45
        baseDefense = 35
        baseMagicDefense = 35
        imageId = R.drawable.chorus_the_drowned
        idName = R.string.enemy_chorus_the_drowned_name
        idDescription = R.string.enemy_chorus_the_drowned_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 2
        expGiven = 1500
    }

    /** Chorus drops a vanilla CoinPurse (weight 1000 = guaranteed 1x). No fabricated boss gear. */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("CoinPurse", 1), 1000)
        return drops
    }
}