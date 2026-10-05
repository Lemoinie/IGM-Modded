package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AetherArchmage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 95
        baseConstitution = 7
        baseIntelligence = 45
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_aether_archmage
        idName = R.string.adventurer_aether_archmage_name
        idDescription = R.string.adventurer_aether_archmage_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_IV
        activeSkill = Skills.ACTIVE_ARCANE_BLAST_III
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Disintegrator")
    }
}
