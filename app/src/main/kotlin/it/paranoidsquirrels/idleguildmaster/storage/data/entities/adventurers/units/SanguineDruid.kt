package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SanguineDruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 215
        baseConstitution = 28
        baseIntelligence = 34
        baseDexterity = 12
        baseDefense = 16
        baseMagicDefense = 22
        imageId = R.drawable.unit_sanguine_druid
        idName = R.string.adventurer_sanguine_druid_name
        idDescription = R.string.adventurer_sanguine_druid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("BloodthornDruid")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
