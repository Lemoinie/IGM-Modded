package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonTiger : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 130
        baseConstitution = 24
        baseIntelligence = 10
        baseDexterity = 24
        baseDefense = 14
        baseMagicDefense = 12
        imageId = R.drawable.unit_summon_tiger
        idName = R.string.adventurer_summon_tiger_name
        idDescription = R.string.adventurer_summon_tiger_description
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
