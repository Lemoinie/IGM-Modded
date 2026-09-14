package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class InfernalPrince : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 320
        baseConstitution = 32
        baseIntelligence = 32
        baseDexterity = 32
        baseDefense = 32
        baseMagicDefense = 32
        imageId = R.drawable.unit_infernal_prince
        idName = R.string.adventurer_infernal_prince_name
        idDescription = R.string.adventurer_infernal_prince_description
        passiveSkill = Skills.PASSIVE_CHAOTIC
        activeSkill = Skills.ACTIVE_EXTIRPATE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Balrog")
    }
}
