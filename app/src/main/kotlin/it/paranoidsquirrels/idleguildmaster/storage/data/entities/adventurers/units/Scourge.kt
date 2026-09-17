package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Scourge : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 215
        baseConstitution = 28
        baseIntelligence = 11
        baseDexterity = 12
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        attackConstitutionScaling = 1.5 // 150% CON weapon scaling (Knight branch)
        imageId = R.drawable.unit_scourge
        idName = R.string.adventurer_scourge_name
        idDescription = R.string.adventurer_scourge_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_DECIMATE_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Tyrant")
    }
}
