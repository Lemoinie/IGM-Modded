package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Disintegrator : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 130
        baseConstitution = 8
        baseIntelligence = 54
        baseDexterity = 14
        baseDefense = 0
        baseMagicDefense = 30
        attackIntelligenceScaling = 1.5
        imageId = R.drawable.unit_disintegrator
        idName = R.string.adventurer_disintegrator_name
        idDescription = R.string.adventurer_disintegrator_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_V
        activeSkill = Skills.ACTIVE_DISINTEGRATE_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("GrandMagus")
    }
}
