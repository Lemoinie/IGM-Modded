package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Balrog : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 36
        baseIntelligence = 36
        baseDexterity = 36
        baseDefense = 36
        baseMagicDefense = 36
        imageId = R.drawable.unit_balrog
        idName = R.string.adventurer_balrog_name
        idDescription = R.string.adventurer_balrog_description
        passiveSkill = Skills.PASSIVE_CHAOTIC
        activeSkill = Skills.ACTIVE_WHIP_AND_TEAR
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }
}
