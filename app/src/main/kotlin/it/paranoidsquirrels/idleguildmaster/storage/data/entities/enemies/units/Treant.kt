package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Treant : Enemy() {
    override fun getMaxDamage(): Int = 9
    override fun getMinDamage(): Int = 6
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 100
        baseConstitution = 10
        baseIntelligence = 5
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_treant
        idName = R.string.enemy_treant_name
        idDescription = R.string.enemy_treant_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 24
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Wood", 1), 599)
        linkedHashMap.put(ItemWrapper.getInstance("PlantFiber", 1), 345)
        linkedHashMap.put(ItemWrapper.getInstance("LivingSap", 1), 5)
        linkedHashMap.put(ItemWrapper.getInstance("Tomato", 1), 12)
        linkedHashMap.put(ItemWrapper.getInstance("WoodenEgg", 1), 1)
        return linkedHashMap
    }
}
