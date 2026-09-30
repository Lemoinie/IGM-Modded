package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SummonWolf : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 60
        baseConstitution = 14
        baseIntelligence = 8
        baseDexterity = 18
        baseDefense = 6
        baseMagicDefense = 6
        imageId = R.drawable.unit_summon_wolf
        idName = R.string.adventurer_summon_wolf_name
        idDescription = R.string.adventurer_summon_wolf_description
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
