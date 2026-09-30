package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SavageBerserker : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 170
        baseConstitution = 25
        baseIntelligence = 13
        baseDexterity = 4
        baseDefense = 10
        baseMagicDefense = 10
        baseLifesteal = 25
        attackConstitutionScaling = 1.05
        imageId = R.drawable.unit_savage_berserker
        idName = R.string.adventurer_savage_berserker_name
        idDescription = R.string.adventurer_savage_berserker_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_SAVAGE_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BRUTAL_STRIKES
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("ScarletBerserker")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
