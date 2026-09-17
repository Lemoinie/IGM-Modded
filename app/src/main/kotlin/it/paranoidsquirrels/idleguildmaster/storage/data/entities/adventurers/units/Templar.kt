package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Templar : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 215
        baseConstitution = 28
        baseIntelligence = 14
        baseDexterity = 9
        baseDefense = 20
        baseMagicDefense = 30
        threat = 2
        attackConstitutionScaling = 1.0 // 100% CON weapon scaling
        attackIntelligenceScaling = 0.7 // 70% INT weapon scaling
        attackDexterityScaling = 0.0
        darknessReduction = 35
        imageId = R.drawable.unit_templar
        idName = R.string.adventurer_templar_name
        idDescription = R.string.adventurer_templar_description
        passiveSkill = Skills.PASSIVE_AURA_OF_DEVOTION_I
        activeSkill = Skills.ACTIVE_RADIANT_JUDGMENT_I
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Inquisitor")
    }
}
