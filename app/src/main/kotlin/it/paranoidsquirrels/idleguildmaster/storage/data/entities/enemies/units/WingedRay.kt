package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class WingedRay : Enemy() {
    override fun getMaxDamage(): Int = 3
    override fun getMinDamage(): Int = 2
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    /** The Winged Ray glides over the water — only ranged/flying hits can land. */
    override fun isFlying(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 45
        baseConstitution = 12
        baseIntelligence = 5
        baseDexterity = 160
        baseDefense = 5
        baseMagicDefense = 5
        imageId = R.drawable.winged_ray
        idName = R.string.enemy_winged_ray_name
        idDescription = R.string.enemy_winged_ray_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 20
    }

    /** "Fish only drops the fish": a Winged Ray always drops itself as Winged Ray food (~65%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("WingedRay", 1), 650)
        return drops
    }
}