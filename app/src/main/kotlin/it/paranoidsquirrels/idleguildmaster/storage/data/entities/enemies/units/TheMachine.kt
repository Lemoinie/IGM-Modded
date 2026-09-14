package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class TheMachine : Enemy() {
    override fun getMaxDamage(): Int = 9999
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 42500
        baseConstitution = 100
        baseIntelligence = 100
        baseDexterity = 100
        baseDefense = 0
        baseMagicDefense = 0
        alwaysHits = true
        imageId = R.drawable.unit_the_machine
        idName = R.string.enemy_the_machine_name
        idDescription = R.string.enemy_the_machine_description
        passiveSkill = Skills.PASSIVE_BEND_REALITY
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 20000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("MysteriousCog", 1), 1000)
        return linkedHashMap
    }
}
