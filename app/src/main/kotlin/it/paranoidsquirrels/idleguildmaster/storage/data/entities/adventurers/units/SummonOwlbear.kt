package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonOwlbear : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 180
        baseConstitution = 30
        baseIntelligence = 12
        baseDexterity = 20
        baseDefense = 18
        baseMagicDefense = 15
        imageId = R.drawable.unit_summon_owlbear
        idName = R.string.unit_summon_owlbear_name
        idDescription = R.string.unit_summon_owlbear_description
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
