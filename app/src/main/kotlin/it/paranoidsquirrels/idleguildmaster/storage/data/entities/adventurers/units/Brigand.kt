package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Brigand : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 24
        baseIntelligence = 20
        baseDexterity = 6
        baseDefense = 15
        baseMagicDefense = 25
        imageId = R.drawable.unit_brigand
        idName = R.string.adventurer_brigand_name
        idDescription = R.string.adventurer_brigand_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Renegade")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
