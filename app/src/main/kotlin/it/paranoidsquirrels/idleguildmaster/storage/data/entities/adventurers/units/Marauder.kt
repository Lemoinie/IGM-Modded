package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Marauder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 60
        baseConstitution = 14
        baseIntelligence = 6
        baseDexterity = 3
        baseDefense = 10
        baseMagicDefense = 10
        attackConstitutionScaling = 1.05
        imageId = R.drawable.unit_marauder
        idName = R.string.adventurer_marauder_name
        idDescription = R.string.adventurer_marauder_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_WILD_STRIKES
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Barbarian")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
