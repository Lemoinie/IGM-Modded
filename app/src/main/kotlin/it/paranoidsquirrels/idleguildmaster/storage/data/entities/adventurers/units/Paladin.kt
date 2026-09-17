package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Paladin : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 170
        baseConstitution = 24
        baseIntelligence = 12
        baseDexterity = 8
        baseDefense = 20
        baseMagicDefense = 26
        threat = 2
        attackConstitutionScaling = 1.0 // 100% CON weapon scaling
        attackIntelligenceScaling = 0.7 // 70% INT weapon scaling
        attackDexterityScaling = 0.0
        darknessReduction = 25
        imageId = R.drawable.unit_paladin
        idName = R.string.adventurer_paladin_name
        idDescription = R.string.adventurer_paladin_description
        passiveSkill = Skills.PASSIVE_AURA_OF_LIGHT_II
        activeSkill = Skills.ACTIVE_HOLY_SMITE_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Templar")
    }
}
