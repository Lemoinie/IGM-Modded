package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ForestSpirit : Enemy() {
    override fun getMaxDamage(): Int = 92
    override fun getMinDamage(): Int = 72
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 2000
        baseConstitution = 34
        baseIntelligence = 40
        baseDexterity = 35
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_forest_spirit
        idName = R.string.enemy_forest_spirit_name
        idDescription = R.string.enemy_forest_spirit_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_SOOTHING_WINDS
        rarity = 1
        expGiven = 600
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PrimordialEssence", 1), 250)
        return linkedHashMap
    }
}
