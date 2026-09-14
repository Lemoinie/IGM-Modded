package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Ghoul : Enemy() {
    override fun getMaxDamage(): Int = 32
    override fun getMinDamage(): Int = 18
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 150
        baseConstitution = 20
        baseIntelligence = 1
        baseDexterity = 42
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_ghoul
        idName = R.string.enemy_ghoul_name
        idDescription = R.string.enemy_ghoul_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 90
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("InfectedBlood", 1), 50)
        return linkedHashMap
    }
}
