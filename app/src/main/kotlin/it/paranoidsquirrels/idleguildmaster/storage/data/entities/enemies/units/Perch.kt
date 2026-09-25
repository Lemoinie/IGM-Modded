package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Perch : Enemy() {
    override fun getMaxDamage(): Int = 2
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 16
        baseConstitution = 5
        baseIntelligence = 2
        baseDexterity = 60
        baseDefense = 2
        baseMagicDefense = 2
        imageId = R.drawable.perch
        idName = R.string.enemy_perch_name
        idDescription = R.string.enemy_perch_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 5
    }

    /** "Fish only drops the fish": a Perch always drops itself as Perch food (~80%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("Perch", 1), 800)
        return drops
    }
}