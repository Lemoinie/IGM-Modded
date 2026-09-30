package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WolfTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 145
        baseConstitution = 20
        baseIntelligence = 24
        baseDexterity = 6
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_wolf_tamer
        idName = R.string.adventurer_wolf_tamer_name
        idDescription = R.string.adventurer_wolf_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("TigerTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
