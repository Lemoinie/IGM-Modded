package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.Collections
import java.util.LinkedHashMap

class CelestialDestroyer : Enemy() {
    @Transient private var customEndOfTurnActions: List<EndOfTurnAction>? = null
    override fun getMaxDamage(): Int = Logger.BARD_SHIELD
    override fun getMinDamage(): Int = 100
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 4000
        baseConstitution = 200
        baseIntelligence = 1
        baseDexterity = 62
        baseDefense = 20
        baseMagicDefense = 20
        team = 1
        imageId = R.drawable.unit_celestial_destroyer
        idName = R.string.enemy_celestial_destroyer_name
        idDescription = R.string.enemy_celestial_destroyer_description
        flying = true
        customEndOfTurnActions = Collections.nCopies(5, EndOfTurnAction.EXTRA_ATTACK_90)
        passiveSkill = Skills.PASSIVE_FLYING_FORTRESS
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 2400
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("CelestialScraps", 3), 600)
        linkedHashMap.put(ItemWrapper.getInstance("AetherIgnis", 1), 400)
        return linkedHashMap
    }
    override fun endOfTurnActions(): List<EndOfTurnAction> = customEndOfTurnActions ?: emptyList()
}
