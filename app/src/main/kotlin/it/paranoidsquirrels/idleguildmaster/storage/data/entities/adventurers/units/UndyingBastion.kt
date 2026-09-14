package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class UndyingBastion : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 320
        baseConstitution = 36
        baseIntelligence = 18
        baseDexterity = 11
        baseDefense = 29
        baseMagicDefense = 29
        threat = 4
        imageId = R.drawable.unit_undying_bastion
        idName = R.string.adventurer_undying_bastion_name
        idDescription = R.string.adventurer_undying_bastion_description
        passiveSkill = Skills.PASSIVE_THREATENING_III
        activeSkill = Skills.ACTIVE_TAUNT_IV
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("EternalFortress")
    }
}
