package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Eidolon : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 290
        baseConstitution = 23
        baseIntelligence = 26
        baseDexterity = 23
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_EXALT_II
        imageId = R.drawable.unit_eidolon
        idName = R.string.adventurer_eidolon_name
        idDescription = R.string.adventurer_eidolon_description
        passiveSkill = Skills.PASSIVE_EXALTING_II
        activeSkill = Skills.ACTIVE_PETRIFYING_MELODY
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
    }
}
