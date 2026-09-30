package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DaturaHierophant : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 265
        baseConstitution = 29
        baseIntelligence = 39
        baseDexterity = 10
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_datura_hierophant
        idName = R.string.adventurer_datura_hierophant_name
        idDescription = R.string.adventurer_datura_hierophant_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
