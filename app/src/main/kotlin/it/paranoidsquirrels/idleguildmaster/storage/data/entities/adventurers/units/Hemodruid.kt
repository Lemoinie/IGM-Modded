package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Hemodruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 170
        baseConstitution = 24
        baseIntelligence = 28
        baseDexterity = 10
        baseDefense = 14
        baseMagicDefense = 18
        imageId = R.drawable.unit_hemodruid
        idName = R.string.unit_hemodruid_name
        idDescription = R.string.unit_hemodruid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("SanguineDruid")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
