package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Wurm : Enemy() {
    override fun getMaxDamage(): Int = 16
    override fun getMinDamage(): Int = 8
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 160
        baseConstitution = 16
        baseIntelligence = 2
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_wurm
        idName = R.string.enemy_wurm_name
        idDescription = R.string.enemy_wurm_description
        baseLifesteal = 100
        passiveSkill = Skills.PASSIVE_LEECH
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 14
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("WurmScale", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("WurmBlood", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1)
        return linkedHashMap
    }
}
