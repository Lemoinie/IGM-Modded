package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BoneAbomination : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 370
        baseConstitution = 115
        baseIntelligence = 1
        baseDexterity = 22
        baseDefense = 50
        baseMagicDefense = 0
        threat = 3
        imageId = R.drawable.unit_abomination
        idName = R.string.summoned_bone_abomination_name
        idDescription = R.string.summoned_bone_abomination_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
        minionDecayRate = 0.12
    }
}
