package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Cutthroat : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 12
        baseIntelligence = 6
        baseDexterity = 12
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        imageId = R.drawable.unit_cuttroath
        idName = R.string.adventurer_cutthroat_name
        idDescription = R.string.adventurer_cutthroat_description
        passiveSkill = Skills.PASSIVE_SABOTEUR
        activeSkill = Skills.ACTIVE_BACKSTAB_II
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Assassin")
    }
}
