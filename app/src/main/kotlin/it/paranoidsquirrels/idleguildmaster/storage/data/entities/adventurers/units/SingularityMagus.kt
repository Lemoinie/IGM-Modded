package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SingularityMagus : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 220
        baseConstitution = 10
        baseIntelligence = 75
        baseDexterity = 18
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_singularity_magus
        idName = R.string.adventurer_singularity_magus_name
        idDescription = R.string.adventurer_singularity_magus_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_VII
        activeSkill = Skills.ACTIVE_DISINTEGRATE_III
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }
}
