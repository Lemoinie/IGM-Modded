package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class PolarBear : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 130
        baseConstitution = 25
        baseIntelligence = 11
        baseDexterity = 15
        baseDefense = 15
        baseMagicDefense = 13
        imageId = R.drawable.unit_summon_bear
        idName = R.string.adventurer_polar_bear_name
        idDescription = R.string.adventurer_polar_bear_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_TIGER_CALLER
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
