package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Zombie : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 130
        baseConstitution = 34
        baseIntelligence = 1
        baseDexterity = 11
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_zombie
        idName = R.string.summoned_zombie_name
        idDescription = R.string.summoned_zombie_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }
}
