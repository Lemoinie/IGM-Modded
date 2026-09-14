package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class InfernalLord : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 265
        baseConstitution = 28
        baseIntelligence = 28
        baseDexterity = 28
        baseDefense = 28
        baseMagicDefense = 28
        imageId = R.drawable.unit_infernal_lord
        idName = R.string.adventurer_infernal_lord_name
        idDescription = R.string.adventurer_infernal_lord_description
        passiveSkill = Skills.PASSIVE_CHAOTIC
        activeSkill = Skills.ACTIVE_OBLITERATE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("InfernalPrince")
    }
}
