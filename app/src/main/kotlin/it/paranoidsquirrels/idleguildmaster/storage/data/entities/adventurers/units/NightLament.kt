package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class NightLament : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 290
        baseConstitution = 30
        baseIntelligence = 12
        baseDexterity = 30
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.02
        imageId = R.drawable.unit_night_lament
        idName = R.string.adventurer_night_lament_name
        idDescription = R.string.adventurer_night_lament_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_IV
        activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_III
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
    }
}
