package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AlbinoRat : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 15
        baseConstitution = 6
        baseIntelligence = 6
        baseDexterity = 6
        baseDefense = 1
        baseMagicDefense = 1
        imageId = R.drawable.unit_albino_rat
        idName = R.string.adventurer_albino_rat_name
        idDescription = R.string.adventurer_albino_rat_description
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
