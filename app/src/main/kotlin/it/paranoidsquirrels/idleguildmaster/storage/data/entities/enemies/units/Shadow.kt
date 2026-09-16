package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Geode
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
        // Always drops a Geode whose gem yield is rolled here:
        // 10% -> 100 gems, 20% -> 50 gems, 70% -> 20 gems.
        val drops = LinkedHashMap<ItemWrapper, Int>()
        val wrapper = ItemWrapper.getInstance("Geode", 1)
        (wrapper.item as? Geode)?.let { geode ->
            val r = Utils.random()
            geode.setGemValue(if (r < 0.10) 100 else if (r < 0.30) 50 else 20)
        }
        drops.put(wrapper, 1)
        return drops
    }
}
