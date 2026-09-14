package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Lorekeeper : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 19
        baseIntelligence = 20
        baseDexterity = 19
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_III
        imageId = R.drawable.unit_lorekeeper
        idName = R.string.adventurer_lorekeeper_name
        idDescription = R.string.adventurer_lorekeeper_description
        passiveSkill = Skills.PASSIVE_INSPIRING_III
        activeSkill = Skills.ACTIVE_PETRIFYING_MELODY
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("HeavenlyCantor")
    }
}
