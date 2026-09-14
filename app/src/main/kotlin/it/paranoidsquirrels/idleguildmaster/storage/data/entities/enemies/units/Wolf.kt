package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Wolf : Enemy() {
    override fun getMaxDamage(): Int = 6
    override fun getMinDamage(): Int = 2
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 60
        baseConstitution = 8
        baseIntelligence = 2
        baseDexterity = 7
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_wolf
        idName = R.string.enemy_wolf_name
        idDescription = R.string.enemy_wolf_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 12
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BeastPelt", 1), 700)
        linkedHashMap.put(ItemWrapper.getInstance("AlphaWolfFang", 1), 80)
        linkedHashMap.put(ItemWrapper.getInstance("WerewolfFang", 1), 2)
        linkedHashMap.put(ItemWrapper.getInstance("WildEgg", 1), 1)
        return linkedHashMap
    }
}
