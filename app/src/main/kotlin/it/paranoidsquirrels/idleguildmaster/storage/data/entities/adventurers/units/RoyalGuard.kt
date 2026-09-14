package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RoyalGuard : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 130
        baseConstitution = 20
        baseIntelligence = 9
        baseDexterity = 8
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.3
        imageId = R.drawable.unit_royal_guard
        idName = R.string.adventurer_royal_guard_name
        idDescription = R.string.adventurer_royal_guard_description
        passiveSkill = Skills.PASSIVE_SWORD_MASTERY_I
        activeSkill = Skills.ACTIVE_MIGHTY_STRIKE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("RoyalSwordsman")
    }
}
