package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DrakeRider : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 10
        baseIntelligence = 16
        baseDexterity = 32
        baseDefense = 10
        baseMagicDefense = 10
        endOfTurnAction = EndOfTurnAction.RIDER_V
        imageId = R.drawable.unit_drake_rider
        idName = R.string.adventurer_drake_rider_name
        idDescription = R.string.adventurer_drake_rider_description
        passiveSkill = Skills.PASSIVE_RIDER_V
        activeSkill = Skills.ACTIVE_INCINERATE
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("GoldenRider")
    }
}
