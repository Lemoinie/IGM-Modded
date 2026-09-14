package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class IronDefender : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 170
        baseConstitution = 24
        baseIntelligence = 12
        baseDexterity = 8
        baseDefense = 24
        baseMagicDefense = 24
        threat = 3
        imageId = R.drawable.unit_iron_defender
        idName = R.string.adventurer_iron_defender_name
        idDescription = R.string.adventurer_iron_defender_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_TAUNT_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Juggernaut")
    }
}
