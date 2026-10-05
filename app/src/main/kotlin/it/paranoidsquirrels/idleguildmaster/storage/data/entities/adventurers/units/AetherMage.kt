package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AetherMage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 70
        baseConstitution = 6
        baseIntelligence = 36
        baseDexterity = 10
        baseDefense = 0
        baseMagicDefense = 30
        attackIntelligenceScaling = 1.3
        imageId = R.drawable.unit_aether_mage
        idName = R.string.adventurer_aether_mage_name
        idDescription = R.string.adventurer_aether_mage_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_III
        activeSkill = Skills.ACTIVE_ARCANE_BLAST_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("AetherArchmage")
    }
}
