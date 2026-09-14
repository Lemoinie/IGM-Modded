package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Boar : Enemy() {
    override fun getMaxDamage(): Int = 3
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 100
        baseConstitution = 10
        baseIntelligence = 2
        baseDexterity = 2
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_boar
        idName = R.string.enemy_boar_name
        idDescription = R.string.enemy_boar_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 12
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BoarTusk", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("BeastPelt", 1), 450)
        linkedHashMap.put(ItemWrapper.getInstance("MeatChop", 1), 12)
        linkedHashMap.put(ItemWrapper.getInstance("WildEgg", 1), 1)
        return linkedHashMap
    }
}
