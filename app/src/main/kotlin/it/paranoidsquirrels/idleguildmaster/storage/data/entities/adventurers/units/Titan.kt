package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Titan : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 265
        baseConstitution = 32
        baseIntelligence = 16
        baseDexterity = 10
        baseDefense = 27
        baseMagicDefense = 27
        threat = 4
        imageId = R.drawable.unit_titan
        idName = R.string.adventurer_titan_name
        idDescription = R.string.adventurer_titan_description
        passiveSkill = Skills.PASSIVE_THREATENING_III
        activeSkill = Skills.ACTIVE_TAUNT_III
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("UndyingBastion")
    }
}
