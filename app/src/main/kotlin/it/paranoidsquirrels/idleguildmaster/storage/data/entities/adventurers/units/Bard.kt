package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Bard : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 17
        baseIntelligence = 17
        baseDexterity = 17
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_III
        imageId = R.drawable.unit_bard
        idName = R.string.adventurer_bard_name
        idDescription = R.string.adventurer_bard_description
        passiveSkill = Skills.PASSIVE_INSPIRING_III
        activeSkill = Skills.ACTIVE_FEINT
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Lorekeeper")
    }
}
