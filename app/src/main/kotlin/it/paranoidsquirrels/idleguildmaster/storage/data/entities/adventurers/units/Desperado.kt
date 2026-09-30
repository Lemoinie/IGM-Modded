package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Desperado : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 215
        baseConstitution = 23
        baseIntelligence = 14
        baseDexterity = 33
        baseDefense = 16
        baseMagicDefense = 16
        imageId = R.drawable.unit_desperado
        idName = R.string.adventurer_desperado_name
        idDescription = R.string.adventurer_desperado_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Renegade")
    }

    override fun isRanged(): Boolean = false
    override fun isMagic(): Boolean = false
}
