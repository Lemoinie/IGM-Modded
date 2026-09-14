package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Tyrant : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 265
        baseConstitution = 32
        baseIntelligence = 12
        baseDexterity = 14
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        imageId = R.drawable.unit_tyrant
        idName = R.string.adventurer_tyrant_name
        idDescription = R.string.adventurer_tyrant_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_DECIMATE_III
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Overlord")
    }
}
