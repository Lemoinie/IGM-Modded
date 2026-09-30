package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class AvatarOfWrath : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 320
        baseConstitution = 44
        baseIntelligence = 25
        baseDexterity = 7
        baseDefense = 25
        baseMagicDefense = 25
        baseLifesteal = 25
        attackConstitutionScaling = 1.3
        imageId = R.drawable.unit_avatar_of_wrath
        idName = R.string.unit_avatar_of_wrath_name
        idDescription = R.string.unit_avatar_of_wrath_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_SAVAGE_RAGE_II
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BLESSING_OF_SLAUGHTER
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
