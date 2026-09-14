package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class LightDisciple : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 25
        baseConstitution = 3
        baseIntelligence = 15
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        imageId = R.drawable.unit_light_disciple
        idName = R.string.adventurer_light_disciple_name
        idDescription = R.string.adventurer_light_disciple_description
        passiveSkill = Skills.PASSIVE_HEALER_I
        activeSkill = Skills.ACTIVE_ENERGY_BURST_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Cleric")
    }
}
