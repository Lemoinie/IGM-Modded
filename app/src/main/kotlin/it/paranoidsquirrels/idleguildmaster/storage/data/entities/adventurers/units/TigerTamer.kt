package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class TigerTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 180
        baseConstitution = 23
        baseIntelligence = 28
        baseDexterity = 7
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_tiger_tamer
        idName = R.string.adventurer_tiger_tamer_name
        idDescription = R.string.adventurer_tiger_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("BearTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
