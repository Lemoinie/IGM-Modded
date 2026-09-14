package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Unchained : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 170
        baseConstitution = 20
        baseIntelligence = 20
        baseDexterity = 20
        baseDefense = 20
        baseMagicDefense = 20
        imageId = R.drawable.unit_unchained
        idName = R.string.adventurer_unchained_name
        idDescription = R.string.adventurer_unchained_description
        passiveSkill = Skills.PASSIVE_CHAOTIC
        activeSkill = Skills.ACTIVE_FLAY
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Demon")
    }
}
