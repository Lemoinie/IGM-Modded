package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RatTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 70
        baseConstitution = 13
        baseIntelligence = 12
        baseDexterity = 5
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_rat_tamer
        idName = R.string.unit_rat_tamer_name
        idDescription = R.string.unit_rat_tamer_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_RAT_CALLER
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_WILD_STRIKES_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("WeaselTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
