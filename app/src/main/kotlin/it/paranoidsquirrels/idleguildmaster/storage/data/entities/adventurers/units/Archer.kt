package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Archer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 5
        baseMaxHp = 30
        baseConstitution = 4
        baseIntelligence = 4
        baseDexterity = 8
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_archer
        idName = R.string.adventurer_archer_name
        idDescription = R.string.adventurer_archer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_BARRAGE_I
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("Huntress")
    }
}
