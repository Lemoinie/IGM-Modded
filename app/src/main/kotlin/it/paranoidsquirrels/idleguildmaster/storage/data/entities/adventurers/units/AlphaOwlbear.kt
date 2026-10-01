package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AlphaOwlbear : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 220
        baseConstitution = 36
        baseIntelligence = 15
        baseDexterity = 24
        baseDefense = 22
        baseMagicDefense = 18
        imageId = R.drawable.unit_summon_owlbear
        idName = R.string.adventurer_alpha_owlbear_name
        idDescription = R.string.adventurer_alpha_owlbear_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BEAR_CALLER
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
