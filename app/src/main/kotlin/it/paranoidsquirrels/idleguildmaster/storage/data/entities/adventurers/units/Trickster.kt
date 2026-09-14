package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Trickster : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 11
        baseIntelligence = 8
        baseDexterity = 11
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        imageId = R.drawable.unit_trickster
        idName = R.string.adventurer_trickster_name
        idDescription = R.string.adventurer_trickster_description
        passiveSkill = Skills.PASSIVE_SABOTEUR
        activeSkill = Skills.ACTIVE_FEINT
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("SilverTongue")
    }
}
