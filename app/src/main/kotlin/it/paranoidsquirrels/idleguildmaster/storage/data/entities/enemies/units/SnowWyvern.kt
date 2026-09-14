package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class SnowWyvern : Enemy() {
    override fun getMaxDamage(): Int = 90
    override fun getMinDamage(): Int = 65
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1250
        baseConstitution = 15
        baseIntelligence = 30
        baseDexterity = 40
        baseDefense = 0
        baseMagicDefense = 0
        flying = true
        imageId = R.drawable.unit_snow_wyvern
        idName = R.string.enemy_snow_wyvern_name
        idDescription = R.string.enemy_snow_wyvern_description
        passiveSkill = Skills.PASSIVE_FLYING
        activeSkill = Skills.ACTIVE_FROZEN_BREATH
        rarity = 1
        expGiven = 520
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("FrozenScale", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("FrozenEgg", 1), 5)
        linkedHashMap.put(ItemWrapper.getInstance("WyvernChop", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1)
        return linkedHashMap
    }
}
