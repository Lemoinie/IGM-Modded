package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Justiciar : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 320
        baseConstitution = 36
        baseIntelligence = 18
        baseDexterity = 11
        baseDefense = 20
        baseMagicDefense = 36
        threat = 2
        darknessReduction = 50
        imageId = R.drawable.unit_justiciar
        idName = R.string.adventurer_justiciar_name
        idDescription = R.string.adventurer_justiciar_description
        passiveSkill = Skills.PASSIVE_BLINDING_V
        activeSkill = Skills.ACTIVE_CONDEMN_ALL_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("AngelOfWar")
    }
}
