package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Iconoclast : Enemy() {
    override fun getMaxDamage(): Int = 82
    override fun getMinDamage(): Int = 80
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 820
        baseConstitution = 15
        baseIntelligence = 32
        baseDexterity = 22
        baseDefense = 30
        baseMagicDefense = 30
        team = 1
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 3, 1.0)
        imageId = R.drawable.unit_iconoclast
        idName = R.string.enemy_iconoclast_name
        idDescription = R.string.enemy_iconoclast_description
        passiveSkill = Skills.PASSIVE_PURIFIER
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 80
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ChainLink", 1), 40)
        linkedHashMap.put(ItemWrapper.getInstance("CharredHeart", 1), 1)
        return linkedHashMap
    }
}
