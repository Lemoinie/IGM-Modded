package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AncientLich : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 125
        baseConstitution = 8
        baseIntelligence = 40
        baseDexterity = 10
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        healsMinionBound = true
        imageId = R.drawable.unit_ancient_lich
        idName = R.string.adventurer_ancient_lich_name
        idDescription = R.string.adventurer_ancient_lich_description
        passiveSkill = Skills.PASSIVE_WITHERING_LINK
        activeSkill = Skills.ACTIVE_CURSE_III
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("LorfOfDecay")
    }
}
