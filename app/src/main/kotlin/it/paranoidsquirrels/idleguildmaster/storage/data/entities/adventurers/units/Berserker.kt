package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Berserker : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 125
        baseConstitution = 17
        baseIntelligence = 10
        baseDexterity = 3
        baseDefense = 10
        baseMagicDefense = 10
        attackConstitutionScaling = 1.05
        imageId = R.drawable.unit_berserker_hero
        idName = R.string.adventurer_berserker_name
        idDescription = R.string.adventurer_berserker_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_BERSERKERR_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BRUTAL_STRIKES
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("SavageBerserker")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
