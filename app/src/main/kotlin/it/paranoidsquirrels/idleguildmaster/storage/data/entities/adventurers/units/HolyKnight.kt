package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class HolyKnight : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 130
        baseConstitution = 20
        baseIntelligence = 10
        baseDexterity = 7
        baseDefense = 20
        baseMagicDefense = 23
        threat = 2
        attackConstitutionScaling = 1.0 // 100% CON weapon scaling
        attackIntelligenceScaling = 0.7 // 70% INT weapon scaling
        attackDexterityScaling = 0.0
        darknessReduction = 15
        imageId = R.drawable.unit_holy_knight
        idName = R.string.adventurer_holy_knight_name
        idDescription = R.string.adventurer_holy_knight_description
        passiveSkill = Skills.PASSIVE_AURA_OF_LIGHT_I
        activeSkill = Skills.ACTIVE_HOLY_SMITE_I
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Paladin")
    }
}
