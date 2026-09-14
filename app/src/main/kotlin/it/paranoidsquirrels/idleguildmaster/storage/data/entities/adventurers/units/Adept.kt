package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Adept : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 25
        baseConstitution = 3
        baseIntelligence = 15
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_adept
        idName = R.string.adventurer_adept_name
        idDescription = R.string.adventurer_adept_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_ENERGY_BURST_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("FireWizard")
        nextClasses.add("DarkSorcerer")
    }
}
