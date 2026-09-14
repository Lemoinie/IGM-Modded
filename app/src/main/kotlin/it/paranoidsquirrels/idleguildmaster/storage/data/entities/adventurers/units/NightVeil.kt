package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class NightVeil : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 240
        baseConstitution = 27
        baseIntelligence = 11
        baseDexterity = 27
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.02
        imageId = R.drawable.unit_night_veil
        idName = R.string.adventurer_night_veil_name
        idDescription = R.string.adventurer_night_veil_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_IV
        activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_II
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("NightLament")
    }
}
