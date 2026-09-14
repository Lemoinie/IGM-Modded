package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SpireLeader : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 24
        baseIntelligence = 10
        baseDexterity = 24
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        imageId = R.drawable.unit_spire_leader
        idName = R.string.adventurer_spire_leader_name
        idDescription = R.string.adventurer_spire_leader_description
        passiveSkill = Skills.PASSIVE_INFILTRATOR
        activeSkill = Skills.ACTIVE_ECLIPSE_III
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("SpireSage")
    }
}
