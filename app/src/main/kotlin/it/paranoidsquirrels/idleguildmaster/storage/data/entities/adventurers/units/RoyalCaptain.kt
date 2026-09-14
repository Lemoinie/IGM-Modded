package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RoyalCaptain : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 215
        baseConstitution = 28
        baseIntelligence = 11
        baseDexterity = 12
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.45
        imageId = R.drawable.unit_royal_captain
        idName = R.string.adventurer_royal_captain_name
        idDescription = R.string.adventurer_royal_captain_description
        passiveSkill = Skills.PASSIVE_SWORD_MASTERY_II
        activeSkill = Skills.ACTIVE_EN_GARDE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("KingsHand")
    }
}
