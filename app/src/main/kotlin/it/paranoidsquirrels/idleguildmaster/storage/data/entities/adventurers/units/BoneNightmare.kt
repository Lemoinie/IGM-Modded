package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BoneNightmare : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 345
        baseConstitution = 105
        baseIntelligence = 1
        baseDexterity = 20
        baseDefense = 50
        baseMagicDefense = 0
        threat = 3
        imageId = R.drawable.unit_bone_nightmare
        idName = R.string.summoned_bone_nightmare_name
        idDescription = R.string.summoned_bone_nightmare_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }
}
