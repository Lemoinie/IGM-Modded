package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class SandVulture : Enemy() {
    override fun getMaxDamage(): Int = 12
    override fun getMinDamage(): Int = 6
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 90
        baseConstitution = 10
        baseIntelligence = 2
        baseDexterity = 27
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_sand_vulture
        idName = R.string.enemy_sand_vulture_name
        idDescription = R.string.enemy_sand_vulture_description
        flying = true
        passiveSkill = Skills.PASSIVE_FLYING
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 14
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Feather", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("Egg", 1), 30)
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1)
        return linkedHashMap
    }
}
