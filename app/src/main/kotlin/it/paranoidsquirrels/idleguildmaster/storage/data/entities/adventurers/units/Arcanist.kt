package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Arcanist : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 35
        baseConstitution = 4
        baseIntelligence = 21
        baseDexterity = 6
        baseDefense = 0
        baseMagicDefense = 30
        attackIntelligenceScaling = 1.1
        imageId = R.drawable.unit_arcanist
        idName = R.string.adventurer_arcanist_name
        idDescription = R.string.adventurer_arcanist_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_I
        activeSkill = Skills.ACTIVE_ENERGY_BURST_III
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Spellweaver")
    }
}
