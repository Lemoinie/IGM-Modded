package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BearTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 220
        baseConstitution = 26
        baseIntelligence = 33
        baseDexterity = 9
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_bear_tamer
        idName = R.string.adventurer_bear_tamer_name
        idDescription = R.string.adventurer_bear_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("BeastTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
