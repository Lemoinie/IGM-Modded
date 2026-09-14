package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Cerebrum : Enemy() {
    override fun getMaxDamage(): Int = 800
    override fun getMinDamage(): Int = 500
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 5000
        baseConstitution = 100
        baseIntelligence = 250
        baseDexterity = 1
        baseDefense = 0
        baseMagicDefense = 0
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        onTargetHit = StatusEffect(StatusEffectType.PETRIFY, this, 2, 1.0)
        imageId = R.drawable.unit_cerebrum
        idName = R.string.enemy_cerebrum_name
        idDescription = R.string.enemy_cerebrum_description
        passiveSkill = Skills.PASSIVE_MIND_FLAY
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 860
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AbioticCore", 1), 100)
        return linkedHashMap
    }
}
