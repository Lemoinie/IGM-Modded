package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Barbarian : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 85
        baseConstitution = 15
        baseIntelligence = 9
        baseDexterity = 3
        baseDefense = 10
        baseMagicDefense = 10
        attackConstitutionScaling = 1.05
        imageId = R.drawable.unit_barbarian
        idName = R.string.adventurer_barbarian_name
        idDescription = R.string.adventurer_barbarian_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_RAGE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BRUTAL_STRIKES
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("Berserker")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
