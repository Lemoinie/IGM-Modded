package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ElSalvador : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 280
        baseConstitution = 38
        baseIntelligence = 30
        baseDexterity = 10
        baseDefense = 15
        baseMagicDefense = 50
        imageId = R.drawable.unit_el_salvador_1
        idName = R.string.adventurer_el_salvador_name
        idDescription = R.string.adventurer_el_salvador_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
