package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Apprentice : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 5
        baseMaxHp = 20
        baseConstitution = 2
        baseIntelligence = 10
        baseDexterity = 4
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_apprentice
        idName = R.string.adventurer_apprentice_name
        idDescription = R.string.adventurer_apprentice_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_ENERGY_BURST_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("LightDisciple")
        nextClasses.add("Adept")
    }
}
