package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class KnightSlime : Enemy() {
    init {
        trueClass = "KnightSlime"
    }
    override fun configureStatistics() {
        baseMaxHp = 400
        baseDefense = 60
        baseMagicDefense = 0
        baseConstitution = 40
        baseDexterity = 6
        baseIntelligence = 2
        passiveSkill = Skills.PASSIVE_ARMORED
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 40
        imageId = R.drawable.unit_knight_slime
        idName = R.string.unit_knight_slime_name
        idDescription = R.string.unit_knight_slime_description
    }

    override fun getMinDamage(): Int = 50
    override fun getMaxDamage(): Int = 75

    override fun listDrops(rarity: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops[ItemWrapper.getInstance("GreenSlime", 2)] = 100
        drops[ItemWrapper.getInstance("IronHelm", 1)] = 30
        return drops
    }

    override fun applyDamage(d: Double, z: Boolean, i: Int, d2: Double): Int {
        var dmg = d
        if (!z && Math.random() < 0.5) {
            dmg *= 0.5
        }
        return super.applyDamage(dmg, z, i, d2)
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
