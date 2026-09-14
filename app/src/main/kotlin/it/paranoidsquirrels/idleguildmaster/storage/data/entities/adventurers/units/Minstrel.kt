package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger

class Minstrel : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 15
        baseIntelligence = 14
        baseDexterity = 15
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_II
        imageId = R.drawable.unit_minstrel
        idName = R.string.adventurer_minstrel_name
        idDescription = R.string.adventurer_minstrel_description
        passiveSkill = Skills.PASSIVE_INSPIRING_II
        activeSkill = Skills.ACTIVE_FEINT
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Bard")
    }
}
