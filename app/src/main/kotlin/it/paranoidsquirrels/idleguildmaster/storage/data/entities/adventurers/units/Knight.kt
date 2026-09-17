package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Knight : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 95
        baseConstitution = 16
        baseIntelligence = 8
        baseDexterity = 6
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        attackConstitutionScaling = 1.5 // 150% CON weapon scaling (Knight branch)
        imageId = R.drawable.unit_knight
        idName = R.string.adventurer_knight_name
        idDescription = R.string.adventurer_knight_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_CRUSHING_STRIKE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("DarkKnight")
        nextClasses.add("HolyKnight")
    }
}
