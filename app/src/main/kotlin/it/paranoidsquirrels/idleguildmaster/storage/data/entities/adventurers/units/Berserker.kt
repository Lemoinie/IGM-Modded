package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Berserker : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 55
        baseIntelligence = 20
        baseDexterity = 22
        baseDefense = 30
        baseMagicDefense = 0
        threat = 6
        baseLifesteal = 20
        imageId = R.drawable.unit_hero_berserker
        idName = R.string.unit_berserker_name
        idDescription = R.string.unit_berserker_description
        passiveSkill = Skills.PASSIVE_BERSERKER_RAGE
        activeSkill = Skills.ACTIVE_TAUNT_IV
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }

    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val actions = mutableListOf<EndOfTurnAction>()
        super.endOfTurnActions()?.let { actions.addAll(it) }
        actions.add(EndOfTurnAction.EXTRA_ATTACK)
        return actions
    }

    override fun calculateTotalLifesteal(): Int {
        return Math.max(super.calculateTotalLifesteal(), 20)
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
