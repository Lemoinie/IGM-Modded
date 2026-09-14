package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WhiteMage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 50
        baseConstitution = 5
        baseIntelligence = 25
        baseDexterity = 7
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        imageId = R.drawable.unit_white_mage
        idName = R.string.adventurer_white_mage_name
        idDescription = R.string.adventurer_white_mage_description
        passiveSkill = Skills.PASSIVE_HEALER_I
        activeSkill = Skills.ACTIVE_MASS_HEAL_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("WhiteArchmage")
    }
}
