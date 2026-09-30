package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class GloomDruid : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 130
        baseConstitution = 20
        baseIntelligence = 23
        baseDexterity = 8
        baseDefense = 12
        baseMagicDefense = 15
        imageId = R.drawable.unit_gloom_druid
        idName = R.string.adventurer_gloom_druid_name
        idDescription = R.string.adventurer_gloom_druid_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Hemodruid")
    }

    override fun isRanged(): Boolean = true
    override fun isMagic(): Boolean = true
}
