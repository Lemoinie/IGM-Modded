package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DarkSorcerer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 35
        baseConstitution = 4
        baseIntelligence = 20
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        imageId = R.drawable.unit_dark_sorcerer
        idName = R.string.adventurer_dark_sorcerer_name
        idDescription = R.string.adventurer_dark_sorcerer_description
        passiveSkill = Skills.PASSIVE_WITHERING_TOUCH
        activeSkill = Skills.ACTIVE_ENERGY_BURST_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Necromancer")
    }
}
