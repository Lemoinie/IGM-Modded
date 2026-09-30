package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Vagabond : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 170
        baseConstitution = 20
        baseIntelligence = 12
        baseDexterity = 27
        baseDefense = 14
        baseMagicDefense = 14
        imageId = R.drawable.unit_vagabond
        idName = R.string.unit_vagabond_name
        idDescription = R.string.unit_vagabond_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Desperado")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
