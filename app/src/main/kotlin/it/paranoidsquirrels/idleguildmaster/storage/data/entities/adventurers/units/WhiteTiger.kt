package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WhiteTiger : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 160
        baseConstitution = 28
        baseIntelligence = 12
        baseDexterity = 28
        baseDefense = 16
        baseMagicDefense = 14
        imageId = R.drawable.unit_summon_tiger
        idName = R.string.adventurer_white_tiger_name
        idDescription = R.string.adventurer_white_tiger_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_LESSER_WOLF_CALLER
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
