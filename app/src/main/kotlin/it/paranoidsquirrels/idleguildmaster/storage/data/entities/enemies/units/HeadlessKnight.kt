package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.Collections
import java.util.LinkedHashMap

class HeadlessKnight : Enemy() {
    @Transient private var customEndOfTurnActions: List<EndOfTurnAction>? = null
    override fun getMaxDamage(): Int = 1800
    override fun getMinDamage(): Int = 1650
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 22500
        baseConstitution = 200
        baseIntelligence = Logger.BARD_SHIELD
        baseDexterity = 170
        baseDefense = 0
        baseMagicDefense = 0
        customEndOfTurnActions = Collections.nCopies(2, EndOfTurnAction.EXTRA_ATTACK)
        statusImmunities.add(StatusEffectType.STUN)
        statusImmunities.add(StatusEffectType.PETRIFY)
        imageId = R.drawable.unit_headless_knight
        idName = R.string.enemy_healdess_knight_name
        idDescription = R.string.enemy_healdess_knight_description
        passiveSkill = Skills.PASSIVE_BLIND_RAGE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 10000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DreadfulMorningstar", 1), 75)
        return linkedHashMap
    }
    override fun endOfTurnActions(): List<EndOfTurnAction> = customEndOfTurnActions ?: emptyList()

    override fun calculateCriticalChance(): Double = 1.0
}
