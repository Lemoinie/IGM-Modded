package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class MeatCarver : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 21
        baseIntelligence = 9
        baseDexterity = 21
        baseDefense = 10
        baseMagicDefense = 10
        saboteur = true
        flatDodgeChance = 0.1
        onTargetHit = StatusEffect(StatusEffectType.BLEED, this, 15, 1.0)
        imageId = R.drawable.unit_meat_carver
        idName = R.string.adventurer_meat_carver_name
        idDescription = R.string.adventurer_meat_carver_description
        passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_I
        activeSkill = Skills.ACTIVE_THOUSAND_CUTS
        weaponType = R.string.type_dagger
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.THIEF
        nextClasses.add("WoundsWeaver")
    }
}
