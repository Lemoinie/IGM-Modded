package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Troll : Enemy() {
    override fun getMaxDamage(): Int = 62
    override fun getMinDamage(): Int = 48
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 600
        baseConstitution = 30
        baseIntelligence = 2
        baseDexterity = 8
        baseDefense = 70
        baseMagicDefense = 0
        regeneration = 30
        imageId = R.drawable.unit_troll
        idName = R.string.enemy_troll_name
        idDescription = R.string.enemy_troll_description
        passiveSkill = Skills.PASSIVE_REGENERATION_II
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 68
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("Winterwood", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("IceFiber", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 25)
        return linkedHashMap
    }
}
