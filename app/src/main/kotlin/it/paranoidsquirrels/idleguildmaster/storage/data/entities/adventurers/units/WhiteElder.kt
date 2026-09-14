package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WhiteElder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 95
        baseConstitution = 7
        baseIntelligence = 35
        baseDexterity = 9
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        cleanser = true
        imageId = R.drawable.unit_white_elder
        idName = R.string.adventurer_white_elder_name
        idDescription = R.string.adventurer_white_elder_description
        passiveSkill = Skills.PASSIVE_HEALER_II
        activeSkill = Skills.ACTIVE_MASS_HEAL_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("RadiantElder")
    }
}
