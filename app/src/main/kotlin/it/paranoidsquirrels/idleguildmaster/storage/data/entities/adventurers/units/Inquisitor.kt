package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Inquisitor : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 265
        baseConstitution = 32
        baseIntelligence = 16
        baseDexterity = 10
        baseDefense = 20
        baseMagicDefense = 33
        threat = 2
        attackConstitutionScaling = 1.0 // 100% CON weapon scaling
        attackIntelligenceScaling = 0.7 // 70% INT weapon scaling
        attackDexterityScaling = 0.0
        darknessReduction = 45
        imageId = R.drawable.unit_inquisitor
        idName = R.string.adventurer_inquisitor_name
        idDescription = R.string.adventurer_inquisitor_description
        passiveSkill = Skills.PASSIVE_AURA_OF_DEVOTION_II
        activeSkill = Skills.ACTIVE_RADIANT_JUDGMENT_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Justiciar")
    }
}
