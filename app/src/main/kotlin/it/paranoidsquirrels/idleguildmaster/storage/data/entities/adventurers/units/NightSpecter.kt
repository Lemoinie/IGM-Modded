package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class NightSpecter : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 21
        baseIntelligence = 9
        baseDexterity = 21
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.015
        imageId = R.drawable.unit_night_specter
        idName = R.string.adventurer_night_specter_name
        idDescription = R.string.adventurer_night_specter_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_III
        activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("NightTerror")
    }
}
