package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Thief : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 10
        baseMaxHp = 45
        baseConstitution = 9
        baseIntelligence = 5
        baseDexterity = 9
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        imageId = R.drawable.unit_thief
        idName = R.string.adventurer_thief_name
        idDescription = R.string.adventurer_thief_description
        passiveSkill = Skills.PASSIVE_SABOTEUR
        activeSkill = Skills.ACTIVE_BACKSTAB_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("ShadowCrawler")
        nextClasses.add("Cutthroat")
        nextClasses.add("Trickster")
    }
}
