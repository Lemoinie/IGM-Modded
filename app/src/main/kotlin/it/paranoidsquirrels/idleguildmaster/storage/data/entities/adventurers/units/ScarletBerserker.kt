package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ScarletBerserker : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 200
        baseConstitution = 27
        baseIntelligence = 15
        baseDexterity = 4
        baseDefense = 10
        baseMagicDefense = 10
        baseLifesteal = 25
        attackConstitutionScaling = 1.1
        imageId = R.drawable.unit_scarlet_berserker
        idName = R.string.unit_scarlet_berserker_name
        idDescription = R.string.unit_scarlet_berserker_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_SAVAGE_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BRUTAL_STRIKES_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("BloodReaver")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
