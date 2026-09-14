package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Rogue : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 5
        baseMaxHp = 30
        baseConstitution = 6
        baseIntelligence = 4
        baseDexterity = 6
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_rogue
        idName = R.string.adventurer_rogue_name
        idDescription = R.string.adventurer_rogue_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_BACKSTAB_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Thief")
    }
}
