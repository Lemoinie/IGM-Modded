package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Footman : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 5
        baseMaxHp = 40
        baseConstitution = 8
        baseIntelligence = 4
        baseDexterity = 4
        baseDefense = 20
        baseMagicDefense = 20
        imageId = R.drawable.unit_footman
        idName = R.string.adventurer_footman_name
        idDescription = R.string.adventurer_footman_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_MIGHTY_STRIKE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Warrior")
    }
}
