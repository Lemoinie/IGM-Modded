package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Whisper : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 290
        baseConstitution = 30
        baseIntelligence = 12
        baseDexterity = 30
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        imageId = R.drawable.unit_whisper
        idName = R.string.adventurer_whisper_name
        idDescription = R.string.adventurer_whisper_description
        passiveSkill = Skills.PASSIVE_DESPISE_WEAKNESS
        activeSkill = Skills.ACTIVE_ECLIPSE_IV
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
    }
}
