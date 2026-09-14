package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class CelestialLancer : Enemy() {
    override fun getMaxDamage(): Int = 170
    override fun getMinDamage(): Int = 130
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 2280
        baseConstitution = Logger.BARD_SHIELD
        baseIntelligence = 95
        baseDexterity = 75
        baseDefense = 0
        baseMagicDefense = 0
        threat = 3
        team = 1
        imageId = R.drawable.unit_celestial_lancer
        idName = R.string.enemy_celestial_lancer_name
        idDescription = R.string.enemy_celestial_lancer_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 200
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("CelestialScraps", 1), 550)
        linkedHashMap.put(ItemWrapper.getInstance("Synapse", 1), 15)
        return linkedHashMap
    }
}
