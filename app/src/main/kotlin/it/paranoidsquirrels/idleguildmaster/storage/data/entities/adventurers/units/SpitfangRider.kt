package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SpitfangRider : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 9
        baseIntelligence = 14
        baseDexterity = 28
        baseDefense = 10
        baseMagicDefense = 10
        endOfTurnAction = EndOfTurnAction.RIDER_IV
        imageId = R.drawable.unit_spitfang_rider
        idName = R.string.adventurer_spitfang_rider_name
        idDescription = R.string.adventurer_spitfang_rider_description
        passiveSkill = Skills.PASSIVE_RIDER_IV
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("DrakeRider")
    }
}
