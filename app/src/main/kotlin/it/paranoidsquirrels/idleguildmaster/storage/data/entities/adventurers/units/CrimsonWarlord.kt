package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class CrimsonWarlord : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 280
        baseConstitution = 39
        baseIntelligence = 22
        baseDexterity = 7
        baseDefense = 20
        baseMagicDefense = 20
        baseLifesteal = 25
        attackConstitutionScaling = 1.2
        imageId = R.drawable.unit_crimson_warlord
        idName = R.string.adventurer_crimson_warlord_name
        idDescription = R.string.adventurer_crimson_warlord_description
        passiveSkill = Skills.PASSIVE_NONE // Planned: PASSIVE_SAVAGE_RAGE_II
        activeSkill = Skills.ACTIVE_NONE // Planned: ACTIVE_BLOODY_SLAUGHTER
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("AvatarOfWrath")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
