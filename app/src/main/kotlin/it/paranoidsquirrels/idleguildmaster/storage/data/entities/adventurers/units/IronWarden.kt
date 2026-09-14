package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class IronWarden : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 130
        baseConstitution = 20
        baseIntelligence = 10
        baseDexterity = 7
        baseDefense = 22
        baseMagicDefense = 22
        threat = 3
        imageId = R.drawable.unit_iron_warden
        idName = R.string.adventurer_iron_warden_name
        idDescription = R.string.adventurer_iron_warden_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_TAUNT_I
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("IronDefender")
    }
}
