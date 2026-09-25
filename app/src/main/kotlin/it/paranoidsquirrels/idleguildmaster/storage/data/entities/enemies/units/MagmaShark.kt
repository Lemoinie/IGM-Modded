package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

/** A standard high-tier fish (NOT a miniboss) with extreme dodge. */
class MagmaShark : Enemy() {
    override fun getMaxDamage(): Int = 7
    override fun getMinDamage(): Int = 4
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 260
        baseConstitution = 40
        baseIntelligence = 8
        baseDexterity = 300
        baseDefense = 12
        baseMagicDefense = 8
        imageId = R.drawable.magma_shark
        idName = R.string.enemy_magma_shark_name
        idDescription = R.string.enemy_magma_shark_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 60
    }

    /** "Fish only drops the fish": a Magma Shark always drops itself as Magma Shark food (~60%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("MagmaShark", 1), 600)
        return drops
    }
}