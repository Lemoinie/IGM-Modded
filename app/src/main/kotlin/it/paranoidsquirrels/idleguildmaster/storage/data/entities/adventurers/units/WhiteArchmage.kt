package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WhiteArchmage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 70
        baseConstitution = 6
        baseIntelligence = 30
        baseDexterity = 8
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        cleanser = true
        imageId = R.drawable.unit_white_archmage
        idName = R.string.adventurer_white_archmage_name
        idDescription = R.string.adventurer_white_archmage_description
        passiveSkill = Skills.PASSIVE_HEALER_II
        activeSkill = Skills.ACTIVE_MASS_HEAL_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("WhiteElder")
    }
}
