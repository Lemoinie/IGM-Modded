package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ElSalvador : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 320
        baseConstitution = 30
        baseIntelligence = 18
        baseDexterity = 48
        baseDefense = 20
        baseMagicDefense = 20
        imageId = R.drawable.unit_el_salvador_1
        idName = R.string.unit_el_salvador_name
        idDescription = R.string.unit_el_salvador_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
