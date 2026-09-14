package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Skeleton : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 170
        baseConstitution = 50
        baseIntelligence = 1
        baseDexterity = 14
        baseDefense = 50
        baseMagicDefense = 0
        threat = 2
        imageId = R.drawable.unit_skeleton
        idName = R.string.summoned_skeleton_name
        idDescription = R.string.summoned_skeleton_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }
}
