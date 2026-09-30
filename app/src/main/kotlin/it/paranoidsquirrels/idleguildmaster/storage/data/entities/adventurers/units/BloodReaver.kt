package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class BloodReaver : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 230
        baseConstitution = 35
        baseIntelligence = 18
        baseDexterity = 5
        baseDefense = 17
        baseMagicDefense = 17
        baseLifesteal = 25
        attackConstitutionScaling = 1.15
        imageId = R.drawable.unit_blood_reaver
        idName = R.string.adventurer_blood_reaver_name
        idDescription = R.string.adventurer_blood_reaver_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_SAVAGE_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BLOODY_SLAUGHTER
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("CrimsonWarlord")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
