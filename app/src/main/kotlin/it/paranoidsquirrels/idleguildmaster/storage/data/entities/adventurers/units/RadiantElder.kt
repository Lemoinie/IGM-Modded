package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RadiantElder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 125
        baseConstitution = 8
        baseIntelligence = 40
        baseDexterity = 10
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        cleanser = true
        imageId = R.drawable.unit_radiant_elder
        idName = R.string.adventurer_radiant_elder_name
        idDescription = R.string.adventurer_radiant_elder_description
        passiveSkill = Skills.PASSIVE_HEALER_II
        activeSkill = Skills.ACTIVE_MASS_HEAL_III
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Angel")
    }
}
