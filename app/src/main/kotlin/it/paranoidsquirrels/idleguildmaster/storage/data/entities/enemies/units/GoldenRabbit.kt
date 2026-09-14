package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class GoldenRabbit : Enemy() {
    override fun getMaxDamage(): Int = 2
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 40
        baseConstitution = 3
        baseIntelligence = 2
        baseDexterity = 42
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 100
        imageId = R.drawable.unit_golden_rabbit
        idName = R.string.enemy_golden_rabbit_name
        idDescription = R.string.enemy_golden_rabbit_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_ESCAPE
        rarity = 1
        expGiven = Logger.BARD_SHIELD
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("CottontailFur", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("MeatChop", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("WildEgg", 1), 1)
        return linkedHashMap
    }
}
