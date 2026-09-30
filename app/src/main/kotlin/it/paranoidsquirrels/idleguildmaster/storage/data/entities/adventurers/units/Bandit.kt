package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Bandit : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 100
        baseConstitution = 17
        baseIntelligence = 15
        baseDexterity = 4
        baseDefense = 15
        baseMagicDefense = 15
        imageId = R.drawable.unit_bandit
        idName = R.string.adventurer_bandit_name
        idDescription = R.string.adventurer_bandit_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Vagabond")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
