package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RoyalSwordsman : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 170
        baseConstitution = 24
        baseIntelligence = 10
        baseDexterity = 10
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.3
        imageId = R.drawable.unit_royal_swordman
        idName = R.string.adventurer_royal_swordsman_name
        idDescription = R.string.adventurer_royal_swordsman_description
        passiveSkill = Skills.PASSIVE_SWORD_MASTERY_I
        activeSkill = Skills.ACTIVE_EN_GARDE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("RoyalCaptain")
    }
}
