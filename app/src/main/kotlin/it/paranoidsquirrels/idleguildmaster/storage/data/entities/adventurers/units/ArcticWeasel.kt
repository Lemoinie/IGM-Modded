package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ArcticWeasel : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 35
        baseConstitution = 10
        baseIntelligence = 7
        baseDexterity = 13
        baseDefense = 3
        baseMagicDefense = 3
        imageId = R.drawable.unit_summon_weasel
        idName = R.string.adventurer_arctic_weasel_name
        idDescription = R.string.adventurer_arctic_weasel_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.NONE
        summonedMinion = true
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
