package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.AbstractMap
import java.util.LinkedHashMap

class NexusResearcher : Enemy() {
    override fun getMaxDamage(): Int = 240
    override fun getMinDamage(): Int = 225
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 735
        baseConstitution = 22
        baseIntelligence = 154
        baseDexterity = 15
        baseDefense = 0
        baseMagicDefense = 0
        healer = true
        increaseHealingAgainst = AbstractMap.SimpleEntry("MagicArmor", 2.0)
        imageId = R.drawable.unit_nexus_researcher
        idName = R.string.enemy_nexus_researcher_name
        idDescription = R.string.enemy_nexus_researcher_description
        passiveSkill = Skills.PASSIVE_REVERSE_ENTROPY
        activeSkill = Skills.ACTIVE_OVERDRIVE
        rarity = 1
        expGiven = 140
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 25)
        linkedHashMap.put(ItemWrapper.getInstance("VeilBreaker", 1), 3)
        linkedHashMap.put(ItemWrapper.getInstance("UnstableGem", 1), 3)
        return linkedHashMap
    }
}
