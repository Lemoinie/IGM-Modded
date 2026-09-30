package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonBear : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 100
        baseConstitution = 20
        baseIntelligence = 9
        baseDexterity = 12
        baseDefense = 12
        baseMagicDefense = 10
        imageId = R.drawable.unit_summon_bear
        idName = R.string.unit_summon_bear_name
        idDescription = R.string.unit_summon_bear_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
