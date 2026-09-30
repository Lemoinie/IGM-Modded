package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Desperado : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 230
        baseConstitution = 31
        baseIntelligence = 27
        baseDexterity = 9
        baseDefense = 15
        baseMagicDefense = 40
        imageId = R.drawable.unit_desperado
        idName = R.string.adventurer_desperado_name
        idDescription = R.string.adventurer_desperado_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_axe
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("ElSalvador")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
