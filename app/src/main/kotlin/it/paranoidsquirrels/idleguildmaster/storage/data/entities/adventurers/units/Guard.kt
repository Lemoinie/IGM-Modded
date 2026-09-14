package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Guard : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 95
        baseConstitution = 16
        baseIntelligence = 8
        baseDexterity = 6
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        imageId = R.drawable.unit_guard
        idName = R.string.adventurer_guard_name
        idDescription = R.string.adventurer_guard_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_MIGHTY_STRIKE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("IronWarden")
        nextClasses.add("RoyalGuard")
    }
}
