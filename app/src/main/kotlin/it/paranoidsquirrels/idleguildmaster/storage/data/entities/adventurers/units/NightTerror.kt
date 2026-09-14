package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class NightTerror : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 24
        baseIntelligence = 10
        baseDexterity = 24
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.015
        imageId = R.drawable.unit_night_terror
        idName = R.string.adventurer_night_terror_name
        idDescription = R.string.adventurer_night_terror_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_III
        activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_II
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("NightVeil")
    }
}
