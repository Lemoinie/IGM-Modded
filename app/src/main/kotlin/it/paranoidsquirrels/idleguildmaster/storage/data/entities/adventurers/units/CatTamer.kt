package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class CatTamer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 95
        baseConstitution = 17
        baseIntelligence = 15
        baseDexterity = 4
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_cat_tamer
        idName = R.string.adventurer_cat_tamer_name
        idDescription = R.string.adventurer_cat_tamer_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("WeaselTamer")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
