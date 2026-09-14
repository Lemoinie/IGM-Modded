package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Assassin : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 90
        baseConstitution = 15
        baseIntelligence = 7
        baseDexterity = 15
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        imageId = R.drawable.unit_assassin
        idName = R.string.adventurer_assassin_name
        idDescription = R.string.adventurer_assassin_description
        passiveSkill = Skills.PASSIVE_INFILTRATOR
        activeSkill = Skills.ACTIVE_BACKSTAB_III
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("SpireInitiate")
        nextClasses.add("RedStalker")
    }
}
