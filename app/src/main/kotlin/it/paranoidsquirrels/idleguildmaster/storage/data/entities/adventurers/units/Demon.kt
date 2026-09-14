package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Demon : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 215
        baseConstitution = 24
        baseIntelligence = 24
        baseDexterity = 24
        baseDefense = 24
        baseMagicDefense = 24
        imageId = R.drawable.unit_demon
        idName = R.string.adventurer_demon_name
        idDescription = R.string.adventurer_demon_description
        passiveSkill = Skills.PASSIVE_CHAOTIC
        activeSkill = Skills.ACTIVE_ANNIHILATE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("InfernalLord")
    }
}
