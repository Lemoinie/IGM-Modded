package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BearTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 230
        baseConstitution = 29
        baseIntelligence = 26
        baseDexterity = 16
        baseDefense = 18
        baseMagicDefense = 18
        imageId = R.drawable.unit_bear_tamer
        idName = R.string.adventurer_bear_tamer_name
        idDescription = R.string.adventurer_bear_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("TigerTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
