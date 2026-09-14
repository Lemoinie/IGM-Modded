package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Cleric : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 35
        baseConstitution = 4
        baseIntelligence = 20
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        imageId = R.drawable.unit_cleric
        idName = R.string.adventurer_cleric_name
        idDescription = R.string.adventurer_cleric_description
        passiveSkill = Skills.PASSIVE_HEALER_I
        activeSkill = Skills.ACTIVE_HEAL
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("WhiteMage")
    }
}
