package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WolfRider : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 90
        baseConstitution = 7
        baseIntelligence = 10
        baseDexterity = 20
        baseDefense = 10
        baseMagicDefense = 10
        endOfTurnAction = EndOfTurnAction.RIDER_II
        imageId = R.drawable.unit_wolf_rider
        idName = R.string.adventurer_wolf_rider_name
        idDescription = R.string.adventurer_wolf_rider_description
        passiveSkill = Skills.PASSIVE_RIDER_II
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("WorgRider")
    }
}
