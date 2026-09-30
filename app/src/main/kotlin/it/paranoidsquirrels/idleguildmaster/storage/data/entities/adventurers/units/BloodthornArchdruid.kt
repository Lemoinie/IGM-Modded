package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BloodthornArchdruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 220
        baseConstitution = 26
        baseIntelligence = 33
        baseDexterity = 9
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_bloodthorn_druid
        idName = R.string.adventurer_bloodthorn_archdruid_name
        idDescription = R.string.adventurer_bloodthorn_archdruid_description
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
