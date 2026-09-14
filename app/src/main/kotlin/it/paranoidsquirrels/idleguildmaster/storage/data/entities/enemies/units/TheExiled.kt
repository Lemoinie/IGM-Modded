package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class TheExiled : Enemy() {
    override fun getMaxDamage(): Int = 1425
    override fun getMinDamage(): Int = 1075
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 30000
        baseConstitution = 215
        baseIntelligence = 215
        baseDexterity = 215
        baseDefense = 25
        baseMagicDefense = 25
        threat = 5
        alwaysHits = true
        baseLifesteal = 35
        counterattack = 0.8
        darknessDamageAmplification = 0.02
        immunityToStatus = 0.9
        regeneration = 500
        flatDodgeChance = 0.3
        criticalDamage = 2.5
        initiative = true
        imageId = R.drawable.unit_the_exiled
        idName = R.string.enemy_the_exiled_name
        idDescription = R.string.enemy_the_exiled_description
        passiveSkill = Skills.PASSIVE_BIOENHANCED_II
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 15000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GiftOfLight", 1), 666)
        return linkedHashMap
    }
    override fun calculateFlatDamageReduction(): Int = super.calculateFlatDamageReduction() + 40
}
