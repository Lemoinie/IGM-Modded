package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AngelOfWar : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 40
        baseIntelligence = 20
        baseDexterity = 12
        baseDefense = 20
        baseMagicDefense = 40
        threat = 2
        attackConstitutionScaling = 1.0 // 100% CON weapon scaling
        attackIntelligenceScaling = 0.7 // 70% INT weapon scaling
        attackDexterityScaling = 0.0
        darknessReduction = 50
        immunityToStatus = 0.7
        imageId = R.drawable.unit_angel_of_war
        idName = R.string.adventurer_angel_of_war_name
        idDescription = R.string.adventurer_angel_of_war_description
        passiveSkill = Skills.PASSIVE_AURA_OF_THE_SERAPHIM
        activeSkill = Skills.ACTIVE_WRATH_OF_HEAVEN_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }
}
