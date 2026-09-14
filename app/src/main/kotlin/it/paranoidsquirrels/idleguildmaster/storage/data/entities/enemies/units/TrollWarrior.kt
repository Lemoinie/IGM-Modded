package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class TrollWarrior : Enemy() {
    override fun getMaxDamage(): Int = 78
    override fun getMinDamage(): Int = 67
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 820
        baseConstitution = 30
        baseIntelligence = 2
        baseDexterity = 10
        baseDefense = 70
        baseMagicDefense = 0
        regeneration = 30
        imageId = R.drawable.unit_troll_warrior
        idName = R.string.enemy_troll_warrior_name
        idDescription = R.string.enemy_troll_warrior_description
        passiveSkill = Skills.PASSIVE_REGENERATION_II
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = Logger.SUMMON_SMOLDERING_TITAN
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 30)
        return linkedHashMap
    }
}
