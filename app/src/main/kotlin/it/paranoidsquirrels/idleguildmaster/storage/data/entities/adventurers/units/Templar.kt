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
        darknessReduction = 30
        imageId = R.drawable.unit_templar
        idName = R.string.adventurer_templar_name
        idDescription = R.string.adventurer_templar_description
        passiveSkill = Skills.PASSIVE_BLINDING_III
        activeSkill = Skills.ACTIVE_CONDEMN_ALL_I
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Inquisitor")
    }
}
