package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Shadow : Enemy() {
    override fun getMaxDamage(): Int = 1000
    override fun getMinDamage(): Int = 100
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1000
        baseConstitution = 100
        baseIntelligence = 100
        baseDexterity = 100
        baseDefense = 50
        baseMagicDefense = 50
        criticalDamage = 2.0
        immunityToStatus = 1.0
        flatDodgeChance = 0.20
        imageId = R.drawable.shadow
        idName = R.string.enemy_shadow_name
        idDescription = R.string.enemy_shadow_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 2
        expGiven = 500
    }

    override fun calculateCriticalChance(): Double = 0.50
    override fun calculateCriticalDamage(): Double = 2.0
    override fun calculateImmunityToStatus(): Double = 1.0
    override fun calculateTotalFlatDodgeChance(): Double = 0.20
    override fun calculateTotalMaxHp(): Int = 1000

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        // Shadow always rolls exactly one Geode stack per kill (weights are per-1000):
        // 80% -> 100 Geodes, 15% -> 150, 4% -> 200, 1% -> 300.
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Geode", 50), 800)
        linkedHashMap.put(ItemWrapper.getInstance("Geode", 100), 150)
        linkedHashMap.put(ItemWrapper.getInstance("Geode", 200), 40)
        linkedHashMap.put(ItemWrapper.getInstance("Geode", 300), 10)
        return linkedHashMap
    }
}
