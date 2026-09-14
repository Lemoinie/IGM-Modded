package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class FireWizard : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 35
        baseConstitution = 4
        baseIntelligence = 20
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_fire_wizard
        idName = R.string.adventurer_fire_wizard_name
        idDescription = R.string.adventurer_fire_wizard_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_FIRE_BURST
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("RedMage")
    }
}
