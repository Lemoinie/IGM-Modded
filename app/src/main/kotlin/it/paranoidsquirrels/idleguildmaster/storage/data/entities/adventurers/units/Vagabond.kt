package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Vagabond : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 125
        baseConstitution = 22
        baseIntelligence = 17
        baseDexterity = 5
        baseDefense = 15
        baseMagicDefense = 20
        imageId = R.drawable.unit_vagabond
        idName = R.string.adventurer_vagabond_name
        idDescription = R.string.adventurer_vagabond_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Brigand")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
