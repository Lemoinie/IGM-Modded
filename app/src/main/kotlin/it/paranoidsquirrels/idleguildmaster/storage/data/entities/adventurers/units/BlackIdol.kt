package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BlackIdol : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 200
        baseConstitution = 10
        baseIntelligence = 50
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        healsMinionBound = true
        imageId = R.drawable.unit_black_idol
        idName = R.string.adventurer_black_idol_name
        idDescription = R.string.adventurer_black_idol_description
        passiveSkill = Skills.PASSIVE_WITHERING_LINK
        activeSkill = Skills.ACTIVE_CURSE_V
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }
}
