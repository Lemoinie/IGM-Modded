package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class HeavenlyCantor : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 240
        baseConstitution = 21
        baseIntelligence = 23
        baseDexterity = 21
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_EXALT_I
        imageId = R.drawable.unit_heavenly_cantor
        idName = R.string.adventurer_heavenly_cantor_name
        idDescription = R.string.adventurer_heavenly_cantor_description
        passiveSkill = Skills.PASSIVE_EXALTING_I
        activeSkill = Skills.ACTIVE_PETRIFYING_MELODY
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Eidolon")
    }
}
