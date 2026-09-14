package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SilverTongue : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 90
        baseConstitution = 13
        baseIntelligence = 11
        baseDexterity = 13
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_I
        imageId = R.drawable.unit_silver_tongue
        idName = R.string.adventurer_silver_tongue_name
        idDescription = R.string.adventurer_silver_tongue_description
        passiveSkill = Skills.PASSIVE_INSPIRING_I
        activeSkill = Skills.ACTIVE_FEINT
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Minstrel")
    }
}
