package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger

class WorgRider : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 8
        baseIntelligence = 12
        baseDexterity = 24
        baseDefense = 10
        baseMagicDefense = 10
        endOfTurnAction = EndOfTurnAction.RIDER_III
        imageId = R.drawable.unit_worg_rider
        idName = R.string.adventurer_worg_rider_name
        idDescription = R.string.adventurer_worg_rider_description
        passiveSkill = Skills.PASSIVE_RIDER_III
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("SpitfangRider")
    }
}
