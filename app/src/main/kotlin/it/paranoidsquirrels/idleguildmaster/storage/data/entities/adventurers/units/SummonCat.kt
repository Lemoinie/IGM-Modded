package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonCat : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 40
        baseConstitution = 10
        baseIntelligence = 7
        baseDexterity = 15
        baseDefense = 4
        baseMagicDefense = 4
        imageId = R.drawable.unit_summon_cat
        idName = R.string.adventurer_summon_cat_name
        idDescription = R.string.adventurer_summon_cat_description
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
