package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class WoundsWeaver : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 24
        baseIntelligence = 10
        baseDexterity = 24
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        onTargetHit = StatusEffect(StatusEffectType.BLEED, this, 30, 1.0)
        imageId = R.drawable.unit_wound_weaver
        idName = R.string.adventurer_wounds_weaver_name
        idDescription = R.string.adventurer_wounds_weaver_description
        passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_II
        activeSkill = Skills.ACTIVE_THOUSAND_CUTS
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("HellishSculptor")
    }
}
