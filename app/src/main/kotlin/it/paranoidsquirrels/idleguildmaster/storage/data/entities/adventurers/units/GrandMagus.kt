package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class GrandMagus : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 170
        baseConstitution = 9
        baseIntelligence = 64
        baseDexterity = 16
        baseDefense = 0
        baseMagicDefense = 30
        attackIntelligenceScaling = 1.6
        imageId = R.drawable.unit_grand_magus
        idName = R.string.adventurer_grand_magus_name
        idDescription = R.string.adventurer_grand_magus_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_VI
        activeSkill = Skills.ACTIVE_DISINTEGRATE_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("SingularityMagus")
    }
}
