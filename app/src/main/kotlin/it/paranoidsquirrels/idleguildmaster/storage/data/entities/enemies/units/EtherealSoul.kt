package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class EtherealSoul : Enemy() {
    override fun getMaxDamage(): Int = 138
    override fun getMinDamage(): Int = Logger.LOST_EXPEDITION_FALL_DAMAGE
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 3180
        baseConstitution = 20
        baseIntelligence = 1
        baseDexterity = 23
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_ethereal_soul
        idName = R.string.enemy_ethereal_soul_name
        idDescription = R.string.enemy_ethereal_soul_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        return LinkedHashMap<ItemWrapper, Int>()
    }
}
