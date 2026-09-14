package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Hurricane : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 240
        baseConstitution = 11
        baseIntelligence = 18
        baseDexterity = 36
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        imageId = R.drawable.unit_hurricane
        idName = R.string.adventurer_hurricane_name
        idDescription = R.string.adventurer_hurricane_description
        passiveSkill = Skills.PASSIVE_KEEN_VISION
        activeSkill = Skills.ACTIVE_BARRAGE_VII
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("CelestialRain")
    }
}
