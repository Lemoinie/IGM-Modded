package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Centaur : Enemy() {
    override fun getMaxDamage(): Int = 15
    override fun getMinDamage(): Int = 8
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 80
        baseConstitution = 12
        baseIntelligence = 10
        baseDexterity = 22
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        imageId = R.drawable.unit_centaur
        idName = R.string.enemy_centaur_name
        idDescription = R.string.enemy_centaur_description
        passiveSkill = Skills.PASSIVE_INITIATIVE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 24
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PlantFiber", 1), 450)
        linkedHashMap.put(ItemWrapper.getInstance("CopperOre", 1), 450)
        linkedHashMap.put(ItemWrapper.getInstance("Cheese", 1), 25)
        return linkedHashMap
    }
}
