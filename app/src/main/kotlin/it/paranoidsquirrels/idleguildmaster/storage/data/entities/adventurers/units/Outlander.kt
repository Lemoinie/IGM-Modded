package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Outlander : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 5
        baseMaxHp = 35
        baseConstitution = 8
        baseIntelligence = 6
        baseDexterity = 2
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_outlander
        idName = R.string.adventurer_outlander_name
        idDescription = R.string.adventurer_outlander_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Marauder")
        nextClasses.add("Heathen")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
