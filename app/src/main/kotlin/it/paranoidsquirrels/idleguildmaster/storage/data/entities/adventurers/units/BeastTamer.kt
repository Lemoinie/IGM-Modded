package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BeastTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 265
        baseConstitution = 29
        baseIntelligence = 39
        baseDexterity = 10
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_beast_tamer
        idName = R.string.adventurer_beast_tamer_name
        idDescription = R.string.adventurer_beast_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
