package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SpireSage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 240
        baseConstitution = 27
        baseIntelligence = 11
        baseDexterity = 27
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        imageId = R.drawable.unit_spire_sage
        idName = R.string.adventurer_spire_sage_name
        idDescription = R.string.adventurer_spire_sage_description
        passiveSkill = Skills.PASSIVE_DESPISE_WEAKNESS
        activeSkill = Skills.ACTIVE_ECLIPSE_III
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("Whisper")
    }
}
