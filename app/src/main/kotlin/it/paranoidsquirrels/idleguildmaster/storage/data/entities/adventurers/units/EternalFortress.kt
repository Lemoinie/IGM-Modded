package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class EternalFortress : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 40
        baseIntelligence = 20
        baseDexterity = 12
        baseDefense = 30
        baseMagicDefense = 30
        threat = 5
        imageId = R.drawable.unit_eternal_fortress
        idName = R.string.adventurer_eternal_fortress_name
        idDescription = R.string.adventurer_eternal_fortress_description
        passiveSkill = Skills.PASSIVE_THREATENING_IV
        activeSkill = Skills.ACTIVE_TAUNT_IV
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }
}
