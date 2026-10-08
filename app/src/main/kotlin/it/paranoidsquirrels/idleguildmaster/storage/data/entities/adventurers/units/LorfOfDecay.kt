package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class LorfOfDecay : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 160
        baseConstitution = 9
        baseIntelligence = 45
        baseDexterity = 11
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        healsMinionBound = true
        imageId = R.drawable.unit_lord_of_decay
        idName = R.string.adventurer_lord_of_decay_name
        idDescription = R.string.adventurer_lord_of_decay_description
        passiveSkill = Skills.PASSIVE_WITHERING_LINK_III
        activeSkill = Skills.ACTIVE_CURSE_IV
        maxMinions = 3
        soulTetherPercent = 0.40
        minionSummonClass = "BoneAbomination"
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("BlackIdol")
    }
}
