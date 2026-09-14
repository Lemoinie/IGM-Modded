package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Warrior : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 65
        baseConstitution = 12
        baseIntelligence = 6
        baseDexterity = 5
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        imageId = R.drawable.unit_warrior
        idName = R.string.adventurer_warrior_name
        idDescription = R.string.adventurer_warrior_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_MIGHTY_STRIKE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Guard")
        nextClasses.add("Knight")
    }
}
