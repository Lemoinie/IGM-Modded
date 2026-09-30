package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Bandit : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 95
        baseConstitution = 14
        baseIntelligence = 8
        baseDexterity = 16
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_bandit
        idName = R.string.adventurer_bandit_name
        idDescription = R.string.adventurer_bandit_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Brigand")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
