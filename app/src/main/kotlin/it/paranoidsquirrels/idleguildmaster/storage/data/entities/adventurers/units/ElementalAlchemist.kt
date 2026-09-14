package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ElementalAlchemist : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 195
        baseConstitution = 10
        baseIntelligence = 20
        baseDexterity = 28
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 1, 0.4)
        onDeathEffectsOnEnemies.add(StatusEffect(StatusEffectType.POISON, this, 5, 1.0))
        onDeathEffectsOnEnemies.add(StatusEffect(StatusEffectType.STUN, this, 1, 1.0))
        onDeathEffectsOnEnemies.add(StatusEffect(StatusEffectType.ABLAZE, this, 5, 1.0))
        onDeathEffectsOnEnemies.add(StatusEffect(StatusEffectType.FROZEN, this, 5, 1.0))
        imageId = R.drawable.unit_elemental_alchemist
        idName = R.string.adventurer_elemental_alchemist_name
        idDescription = R.string.adventurer_elemental_alchemist_description
        passiveSkill = Skills.PASSIVE_THAUMATURGY_II
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("EsotericAlchemist")
    }
}
