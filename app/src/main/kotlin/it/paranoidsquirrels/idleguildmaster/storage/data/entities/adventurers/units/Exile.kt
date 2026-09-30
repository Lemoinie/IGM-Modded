package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Exile : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 15
        baseMaxHp = 65
        baseConstitution = 12
        baseIntelligence = 6
        baseDexterity = 12
        baseDefense = 8
        baseMagicDefense = 8
        imageId = R.drawable.unit_exile
        idName = R.string.adventurer_exile_name
        idDescription = R.string.adventurer_exile_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_FOCUSED_EYE
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_WILD_STRIKES_II
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Bandit")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
