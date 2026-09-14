package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Tempest : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 10
        baseIntelligence = 16
        baseDexterity = 32
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        imageId = R.drawable.unit_tempest
        idName = R.string.adventurer_tempest_name
        idDescription = R.string.adventurer_tempest_description
        passiveSkill = Skills.PASSIVE_KEEN_VISION
        activeSkill = Skills.ACTIVE_BARRAGE_VI
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("Hurricane")
    }
}
