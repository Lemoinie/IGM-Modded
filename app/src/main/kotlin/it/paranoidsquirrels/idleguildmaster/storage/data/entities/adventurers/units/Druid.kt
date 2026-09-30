package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Druid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 14
        baseIntelligence = 14
        baseDexterity = 4
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_druid
        idName = R.string.unit_druid_name
        idDescription = R.string.unit_druid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("ForestDruid")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
