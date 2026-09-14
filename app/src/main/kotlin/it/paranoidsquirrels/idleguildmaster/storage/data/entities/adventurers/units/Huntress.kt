package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Huntress : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 45
        baseConstitution = 5
        baseIntelligence = 6
        baseDexterity = 12
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_huntress
        idName = R.string.adventurer_huntress_name
        idDescription = R.string.adventurer_huntress_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("HorseRider")
        nextClasses.add("Marksman")
    }
}
