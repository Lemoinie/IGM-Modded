package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Necrolith : Enemy() {
    override fun getMaxDamage(): Int = 2
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1000000
        baseConstitution = 500
        baseIntelligence = 1
        baseDexterity = 1
        baseDefense = 100
        baseMagicDefense = 100
        threat = 2
        imageId = R.drawable.unit_necrolith
        idName = R.string.enemy_necrolith_name
        idDescription = R.string.enemy_necrolith_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 10
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        return LinkedHashMap<ItemWrapper, Int>()
    }
}
