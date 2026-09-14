package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class KingsHand : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 265
        baseConstitution = 32
        baseIntelligence = 12
        baseDexterity = 14
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.6
        imageId = R.drawable.unit_kings_hand
        idName = R.string.adventurer_kings_hand_name
        idDescription = R.string.adventurer_kings_hand_description
        passiveSkill = Skills.PASSIVE_SWORD_MASTERY_III
        activeSkill = Skills.ACTIVE_EN_GARDE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("DivineDuelist")
    }
}
