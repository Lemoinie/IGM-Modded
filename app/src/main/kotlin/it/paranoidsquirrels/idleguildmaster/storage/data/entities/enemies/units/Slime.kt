package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Slime : Enemy() {
    override fun getMaxDamage(): Int = 35
    override fun getMinDamage(): Int = 26
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 130
        baseConstitution = 40
        baseIntelligence = 2
        baseDexterity = 6
        baseDefense = 40
        baseMagicDefense = 0
        imageId = R.drawable.unit_slime
        idName = R.string.enemy_slime_name
        idDescription = R.string.enemy_slime_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 24
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 650)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 2), 200)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 50)
        return linkedHashMap
    }
}
