package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DarkKnight : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 130
        baseConstitution = 20
        baseIntelligence = 9
        baseDexterity = 8
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        imageId = R.drawable.unit_dark_knight
        idName = R.string.adventurer_dark_knight_name
        idDescription = R.string.adventurer_dark_knight_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_OVERWHELM
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("DeathKnight")
    }
}
