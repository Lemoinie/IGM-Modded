package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ForestDruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 95
        baseConstitution = 17
        baseIntelligence = 15
        baseDexterity = 4
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_forest_druid
        idName = R.string.adventurer_forest_druid_name
        idDescription = R.string.adventurer_forest_druid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("GloomDruid")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
