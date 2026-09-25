package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class BlueShark : Enemy() {
    override fun getMaxDamage(): Int = 4
    override fun getMinDamage(): Int = 2
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 85
        baseConstitution = 20
        baseIntelligence = 6
        baseDexterity = 220
        baseDefense = 8
        baseMagicDefense = 6
        imageId = R.drawable.blue_shark
        idName = R.string.enemy_blue_shark_name
        idDescription = R.string.enemy_blue_shark_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 35
    }

    /** "Fish only drops the fish": a Blue Shark always drops itself as Blue Shark food (~60%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("BlueShark", 1), 600)
        return drops
    }
}