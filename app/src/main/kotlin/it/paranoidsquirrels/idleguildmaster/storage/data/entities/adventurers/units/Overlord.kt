package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Overlord : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 320
        baseConstitution = 36
        baseIntelligence = 13
        baseDexterity = 16
        baseDefense = 20
        baseMagicDefense = 20
        threat = 2
        stunChanceOnLowerHp = 0.5
        imageId = R.drawable.unit_overlord
        idName = R.string.adventurer_overlord_name
        idDescription = R.string.adventurer_overlord_description
        passiveSkill = Skills.PASSIVE_SUBJUGATE_I
        activeSkill = Skills.ACTIVE_DECIMATE_III
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("BlackRegent")
    }
}
