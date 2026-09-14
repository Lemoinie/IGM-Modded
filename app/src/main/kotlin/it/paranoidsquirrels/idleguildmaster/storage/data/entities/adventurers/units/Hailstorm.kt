package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Hailstorm : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 9
        baseIntelligence = 14
        baseDexterity = 28
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        imageId = R.drawable.unit_hailstorm
        idName = R.string.adventurer_hailstorm_name
        idDescription = R.string.adventurer_hailstorm_description
        passiveSkill = Skills.PASSIVE_KEEN_VISION
        activeSkill = Skills.ACTIVE_BARRAGE_V
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("Tempest")
    }
}
