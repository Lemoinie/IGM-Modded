package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class BlueTrout : Enemy() {
    override fun getMaxDamage(): Int = 2
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 24
        baseConstitution = 8
        baseIntelligence = 3
        baseDexterity = 90
        baseDefense = 3
        baseMagicDefense = 3
        imageId = R.drawable.blue_trout
        idName = R.string.enemy_blue_trout_name
        idDescription = R.string.enemy_blue_trout_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 10
    }

    /** "Fish only drops the fish": a Blue Trout always drops itself as Blue Trout food (~75%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("BlueTrout", 1), 750)
        return drops
    }
}