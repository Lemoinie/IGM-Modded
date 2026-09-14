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
        darknessReduction = 20
        imageId = R.drawable.unit_paladin
        idName = R.string.adventurer_paladin_name
        idDescription = R.string.adventurer_paladin_description
        passiveSkill = Skills.PASSIVE_BLINDING_II
        activeSkill = Skills.ACTIVE_CONDEMN
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Templar")
    }
}
