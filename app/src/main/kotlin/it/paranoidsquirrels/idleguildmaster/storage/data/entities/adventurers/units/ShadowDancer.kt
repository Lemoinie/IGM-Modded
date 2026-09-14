package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ShadowDancer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 90
        baseConstitution = 15
        baseIntelligence = 7
        baseDexterity = 15
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_shadow_dancer
        idName = R.string.adventurer_shadow_dancer_name
        idDescription = R.string.adventurer_shadow_dancer_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_II
        activeSkill = Skills.ACTIVE_BACKSTAB_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("NightBlade")
    }
}
