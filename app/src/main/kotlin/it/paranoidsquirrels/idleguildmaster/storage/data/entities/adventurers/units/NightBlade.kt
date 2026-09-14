package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger

class NightBlade : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 18
        baseIntelligence = 8
        baseDexterity = 18
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_night_blade
        idName = R.string.adventurer_night_blade_name
        idDescription = R.string.adventurer_night_blade_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_II
        activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("NightSpecter")
    }
}
