package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger

class SpireInitiate : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 18
        baseIntelligence = 8
        baseDexterity = 18
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        imageId = R.drawable.unit_spire_initiate
        idName = R.string.adventurer_spire_initiate_name
        idDescription = R.string.adventurer_spire_initiate_description
        passiveSkill = Skills.PASSIVE_INFILTRATOR
        activeSkill = Skills.ACTIVE_ECLIPSE_I
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("SpireAcolyte")
    }
}
