package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Rat : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 10
        baseConstitution = 5
        baseIntelligence = 5
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_rat
        idName = R.string.adventurer_rat_name
        idDescription = R.string.adventurer_rat_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
