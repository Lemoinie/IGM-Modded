package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class CatTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 140
        baseConstitution = 20
        baseIntelligence = 18
        baseDexterity = 10
        baseDefense = 12
        baseMagicDefense = 12
        imageId = R.drawable.unit_cat_tamer
        idName = R.string.unit_cat_tamer_name
        idDescription = R.string.unit_cat_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("WolfTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
