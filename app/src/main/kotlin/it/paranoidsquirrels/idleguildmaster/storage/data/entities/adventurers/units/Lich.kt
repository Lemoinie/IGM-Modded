package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Lich : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 95
        baseConstitution = 7
        baseIntelligence = 35
        baseDexterity = 9
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        healsMinionBound = true
        imageId = R.drawable.unit_lich
        idName = R.string.adventurer_lich_name
        idDescription = R.string.adventurer_lich_description
        passiveSkill = Skills.PASSIVE_WITHERING_LINK
        activeSkill = Skills.ACTIVE_CURSE_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("AncientLich")
    }
}
