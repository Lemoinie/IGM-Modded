package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BoneHorror : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 315
        baseConstitution = 72
        baseIntelligence = 1
        baseDexterity = 17
        baseDefense = 50
        baseMagicDefense = 0
        threat = 3
        imageId = R.drawable.unit_bone_horror
        idName = R.string.summoned_bone_horror_name
        idDescription = R.string.summoned_bone_horror_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }
}
