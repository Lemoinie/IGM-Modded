package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Renegade : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 185
        baseConstitution = 28
        baseIntelligence = 23
        baseDexterity = 7
        baseDefense = 15
        baseMagicDefense = 30
        imageId = R.drawable.unit_renegade
        idName = R.string.adventurer_renegade_name
        idDescription = R.string.adventurer_renegade_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Desperado")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
