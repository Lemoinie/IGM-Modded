package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Renegade : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 265
        baseConstitution = 26
        baseIntelligence = 16
        baseDexterity = 40
        baseDefense = 18
        baseMagicDefense = 18
        imageId = R.drawable.unit_renegade
        idName = R.string.unit_renegade_name
        idDescription = R.string.unit_renegade_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("ElSalvador")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
