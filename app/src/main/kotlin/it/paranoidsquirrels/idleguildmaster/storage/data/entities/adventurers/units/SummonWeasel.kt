package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonWeasel : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 25
        baseConstitution = 8
        baseIntelligence = 6
        baseDexterity = 10
        baseDefense = 2
        baseMagicDefense = 2
        imageId = R.drawable.unit_summon_weasel
        idName = R.string.unit_summon_weasel_name
        idDescription = R.string.unit_summon_weasel_description
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
