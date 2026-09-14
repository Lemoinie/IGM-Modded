package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Enforcer : Enemy() {
    override fun getMaxDamage(): Int = 1100
    override fun getMinDamage(): Int = 825
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 18000
        baseConstitution = 400
        baseIntelligence = 1
        baseDexterity = 35
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 80
        imageId = R.drawable.unit_enforcer
        idName = R.string.enemy_enforcer_name
        idDescription = R.string.enemy_enforcer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_SMASH
        rarity = 1
        expGiven = 575
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("MutantHide", 1), 800)
        return linkedHashMap
    }
}
