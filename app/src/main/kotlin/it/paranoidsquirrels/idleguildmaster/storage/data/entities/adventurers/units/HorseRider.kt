package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class HorseRider : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 6
        baseIntelligence = 8
        baseDexterity = 16
        baseDefense = 10
        baseMagicDefense = 10
        endOfTurnAction = EndOfTurnAction.RIDER_I
        imageId = R.drawable.unit_horse_rider
        idName = R.string.adventurer_horse_rider_name
        idDescription = R.string.adventurer_horse_rider_description
        passiveSkill = Skills.PASSIVE_RIDER_I
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("WolfRider")
    }
}
