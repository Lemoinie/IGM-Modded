package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class HellishSculptor : Adventurer() {
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
        onTargetHit = StatusEffect(StatusEffectType.BLEED, this, 60, 1.0)
        imageId = R.drawable.unit_hellish_sculptor
        idName = R.string.adventurer_hellish_sculptor_name
        idDescription = R.string.adventurer_hellish_sculptor_description
        passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_III
        activeSkill = Skills.ACTIVE_THOUSAND_CUTS
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("SpiritEngraver")
    }
}
