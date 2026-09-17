package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BlackRegent : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 40
        baseIntelligence = 14
        baseDexterity = 18
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        attackConstitutionScaling = 1.5 // 150% CON weapon scaling
        stunChanceOnLowerHp = 1.0
        imageId = R.drawable.unit_black_regent
        idName = R.string.adventurer_black_regent_name
        idDescription = R.string.adventurer_black_regent_description
        passiveSkill = Skills.PASSIVE_SUBJUGATE_II
        activeSkill = Skills.ACTIVE_DECIMATE_III
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }
}
