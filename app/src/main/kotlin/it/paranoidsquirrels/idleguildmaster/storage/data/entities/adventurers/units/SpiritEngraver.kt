package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class SpiritEngraver : Adventurer() {
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
        onTargetHit = StatusEffect(StatusEffectType.BLEED, this, 60, 1.0)
        imageId = R.drawable.unit_spirit_engraver
        idName = R.string.adventurer_spirit_engraver_name
        idDescription = R.string.adventurer_spirit_engraver_description
        passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_III
        activeSkill = Skills.ACTIVE_THOUSAND_CUTS_II
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
    }
}
