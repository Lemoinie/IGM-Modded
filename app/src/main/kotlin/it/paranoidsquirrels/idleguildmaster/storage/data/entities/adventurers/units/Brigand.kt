package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Brigand : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 130
        baseConstitution = 17
        baseIntelligence = 10
        baseDexterity = 21
        baseDefense = 12
        baseMagicDefense = 12
        imageId = R.drawable.unit_brigand
        idName = R.string.adventurer_brigand_name
        idDescription = R.string.adventurer_brigand_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Vagabond")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
