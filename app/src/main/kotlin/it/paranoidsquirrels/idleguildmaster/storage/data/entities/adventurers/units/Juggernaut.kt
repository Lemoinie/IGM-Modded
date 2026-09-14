package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Juggernaut : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 215
        baseConstitution = 28
        baseIntelligence = 14
        baseDexterity = 9
        baseDefense = 25
        baseMagicDefense = 25
        threat = 4
        imageId = R.drawable.unit_juggernaut
        idName = R.string.adventurer_juggernaut_name
        idDescription = R.string.adventurer_juggernaut_description
        passiveSkill = Skills.PASSIVE_THREATENING_III
        activeSkill = Skills.ACTIVE_TAUNT_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Titan")
    }
}
