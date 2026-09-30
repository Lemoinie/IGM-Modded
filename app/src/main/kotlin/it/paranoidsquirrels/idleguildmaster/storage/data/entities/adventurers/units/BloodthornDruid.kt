package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BloodthornDruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 265
        baseConstitution = 32
        baseIntelligence = 40
        baseDexterity = 14
        baseDefense = 18
        baseMagicDefense = 26
        imageId = R.drawable.unit_bloodthorn_druid
        idName = R.string.unit_bloodthorn_druid_name
        idDescription = R.string.unit_bloodthorn_druid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("DaturaHierophant")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
