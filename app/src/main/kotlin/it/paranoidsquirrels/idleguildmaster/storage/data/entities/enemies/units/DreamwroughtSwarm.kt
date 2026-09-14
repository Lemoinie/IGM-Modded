package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.Collections
import java.util.LinkedHashMap

class DreamwroughtSwarm : Enemy() {
    override fun getMaxDamage(): Int = 285
    override fun getMinDamage(): Int = 275
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 30
        baseConstitution = 1
        baseIntelligence = 50
        baseDexterity = 65
        baseDefense = 0
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.STUN)
        statusImmunities.add(StatusEffectType.PETRIFY)
        imageId = R.drawable.unit_dreamwrought_swarm
        idName = R.string.enemy_dreamwrought_swarm_name
        idDescription = R.string.enemy_dreamwrought_swarm_description
        passiveSkill = Skills.PASSIVE_SWARM
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 1), 334)
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 2), 333)
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 3), 333)
        return linkedHashMap
    }
    override fun endOfTurnActions(): List<EndOfTurnAction> {
        return if (currentHp <= 1) ArrayList() else Collections.nCopies(currentHp - 1, EndOfTurnAction.EXTRA_ATTACK_90)
    }

    override fun applyDamage(d: Double, z: Boolean, i: Int, d2: Double): Int {
        return super.applyDamage(1.0, z, i, 0.0)
    }
}
