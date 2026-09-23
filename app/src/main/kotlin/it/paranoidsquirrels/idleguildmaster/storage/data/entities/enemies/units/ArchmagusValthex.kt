package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ArchmagusValthex : Enemy() {
    override fun getMaxDamage(): Int = 600
    override fun getMinDamage(): Int = 500
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 100000
        baseConstitution = 100
        baseDexterity = 300
        baseIntelligence = 600
        baseDefense = 10
        baseMagicDefense = 90
        baseLifesteal = 200
        immunityToStatus = 1.0
        criticalDamage = 2.5
        imageId = R.drawable.scarlet_grand_mage
        idName = R.string.enemy_archmagus_valthex_name
        idDescription = R.string.enemy_archmagus_valthex_description
        passiveSkill = Skills.PASSIVE_BLOOD_CONVOCATION
        activeSkill = Skills.ACTIVE_SCARLET_AEONIA
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScarletStrand", 1), 10)
        return linkedHashMap
    }

    override fun calculateCriticalChance(): Double = 1.0
}