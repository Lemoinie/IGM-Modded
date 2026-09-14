package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ShadowCrawler : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 12
        baseIntelligence = 6
        baseDexterity = 12
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        nightVision = true
        imageId = R.drawable.unit_shadow_crawler
        idName = R.string.adventurer_shadow_crawler_name
        idDescription = R.string.adventurer_shadow_crawler_description
        passiveSkill = Skills.PASSIVE_NIGHT_VISION_I
        activeSkill = Skills.ACTIVE_BACKSTAB_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("ShadowDancer")
    }
}
