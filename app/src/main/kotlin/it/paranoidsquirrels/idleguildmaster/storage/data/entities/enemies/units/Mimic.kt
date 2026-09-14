package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Mimic : Enemy() {
    override fun getMaxDamage(): Int = 78
    override fun getMinDamage(): Int = 42
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 236
        baseConstitution = 25
        baseIntelligence = 1
        baseDexterity = 18
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        imageId = R.drawable.unit_mimic
        idName = R.string.enemy_mimic_name
        idDescription = R.string.enemy_mimic_description
        passiveSkill = Skills.PASSIVE_INITIATIVE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 132
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GhostwoodStump", 3), 666)
        linkedHashMap.put(ItemWrapper.getInstance("CoinPurse", 1), 333)
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1)
        return linkedHashMap
    }
}
