package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WeaselTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 120
        baseConstitution = 19
        baseIntelligence = 20
        baseDexterity = 5
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_weasel_tamer
        idName = R.string.adventurer_weasel_tamer_name
        idDescription = R.string.adventurer_weasel_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("WolfTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
