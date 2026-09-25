package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Angelfish : Enemy() {
    override fun getMaxDamage(): Int = 2
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 20
        baseConstitution = 6
        baseIntelligence = 4
        baseDexterity = 120
        baseDefense = 3
        baseMagicDefense = 4
        imageId = R.drawable.angelfish
        idName = R.string.enemy_angelfish_name
        idDescription = R.string.enemy_angelfish_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 0
        expGiven = 15
    }

    /** "Fish only drops the fish": an Angelfish always drops itself as Angelfish food (~70%). */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops.put(ItemWrapper.getInstance("Angelfish", 1), 700)
        return drops
    }
}