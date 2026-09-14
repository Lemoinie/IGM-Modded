package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Sureshot : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 90
        baseConstitution = 7
        baseIntelligence = 10
        baseDexterity = 20
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        imageId = R.drawable.unit_sureshot
        idName = R.string.adventurer_sureshot_name
        idDescription = R.string.adventurer_sureshot_description
        passiveSkill = Skills.PASSIVE_KEEN_VISION
        activeSkill = Skills.ACTIVE_BARRAGE_III
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("Fury")
    }
}
