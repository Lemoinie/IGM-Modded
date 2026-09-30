package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Heathen : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 50
        baseConstitution = 11
        baseIntelligence = 9
        baseDexterity = 3
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_heathen
        idName = R.string.adventurer_heathen_name
        idDescription = R.string.adventurer_heathen_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_WILD_STRIKES_II
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("RatTamer")
        nextClasses.add("Druid")
        nextClasses.add("Exile")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
