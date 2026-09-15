package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

abstract class Equipment : Item() {
    @JvmField @Transient protected var constitution: Int = 0
    @JvmField @Transient protected var defense: Int = 0
    @JvmField @Transient protected var dexterity: Int = 0
    @JvmField @Transient protected var endOfTurnAction: EndOfTurnAction? = null
    @JvmField @Transient protected var endOfTurnActionRepeats: Int = 1
    @JvmField @Transient protected var intelligence: Int = 0
    @JvmField @Transient protected var magicDefense: Int = 0
    @JvmField @Transient protected var maxHp: Int = 0
    @JvmField @Transient protected var onSelfHit: StatusEffect? = null
    @JvmField @Transient protected var onTargetHit: StatusEffect? = null
    @JvmField @Transient protected var lifesteal: Int = 0
    @JvmField @Transient protected var lifestealWithMinion: Int = 0
    @JvmField @Transient protected var threat: Int = 0
    @JvmField @Transient protected var bonusExperience: Int = 0
    @JvmField @Transient protected var darknessReduction: Int = 0
    @JvmField @Transient protected var counterattack: Double = 0.0
    @JvmField @Transient protected var darknessDamageAmplification: Double = 0.0
    @JvmField @Transient protected var retaliationPhysicalDamage: Int = 0
    @JvmField @Transient protected var retaliationMagicalDamage: Int = 0
    @JvmField @Transient protected var healingModifier: Double = 0.0
    @JvmField @Transient protected var immunityToStatus: Double = 0.0
    @JvmField @Transient protected var regeneration: Int = 0
    @JvmField @Transient protected var criticalDamage: Double = 0.0
    @JvmField @Transient protected var criticalChance: Double = 0.0
    @JvmField @Transient protected var initiative: Boolean = false
    @JvmField @Transient protected var alwaysHits: Boolean = false
    @JvmField @Transient protected var onFireBonusDamage: Int = 0
    @JvmField @Transient protected var freezeBonusDamage: Int = 0
    @JvmField @Transient protected var poisonBonus: Int = 0
    @JvmField @Transient protected var livingCompanionBonusDamage: Int = 0
    @JvmField @Transient protected var regenerationBonus: Int = 0
    @JvmField @Transient protected var flatDodgeChance: Double = 0.0
    @JvmField @Transient protected var decay: Int = 0
    @JvmField @Transient protected var exaltInspireBonusTurns: Int = 0

    open fun getConstitution(): Int = constitution
    open fun setConstitution(i: Int) { constitution = i }
    open fun getIntelligence(): Int = intelligence
    open fun setIntelligence(i: Int) { intelligence = i }
    open fun getDexterity(): Int = dexterity
    open fun setDexterity(i: Int) { dexterity = i }
    open fun getMaxHp(): Int = maxHp
    open fun setMaxHp(i: Int) { maxHp = i }
    open fun getDefense(): Int = defense
    open fun setDefense(i: Int) { defense = i }
    open fun getMagicDefense(): Int = magicDefense
    open fun setMagicDefense(i: Int) { magicDefense = i }
    open fun getOnTargetHit(): StatusEffect? = onTargetHit
    open fun setOnTargetHit(statusEffect: StatusEffect?) { onTargetHit = statusEffect }
    open fun getOnSelfHit(): StatusEffect? = onSelfHit
    open fun setOnSelfHit(statusEffect: StatusEffect?) { onSelfHit = statusEffect }
    open fun getEndOfTurnAction(): EndOfTurnAction? = endOfTurnAction
    open fun getEndOfTurnActionRepeats(): Int = if (endOfTurnActionRepeats > 0) endOfTurnActionRepeats else 1
    open fun getLifesteal(): Int = lifesteal
    open fun getLifestealWithMinion(): Int = lifestealWithMinion
    open fun getThreat(): Int = threat
    open fun setThreat(i: Int) { threat = i }
    open fun getRetaliationPhysicalDamage(): Int = retaliationPhysicalDamage
    open fun getRetaliationMagicalDamage(): Int = retaliationMagicalDamage
    open fun getHealingModifier(): Double = healingModifier
    open fun getImmunityToStatus(): Double = immunityToStatus
    open fun setImmunityToStatus(d: Double) { immunityToStatus = d }
    open fun getRegeneration(): Int = regeneration
    open fun setRegeneration(i: Int) { regeneration = i }
    open fun getCriticalDamage(): Double = criticalDamage
    open fun getCriticalChance(): Double = criticalChance
    open fun isInitiative(): Boolean = initiative
    open fun setInitiative(z: Boolean) { initiative = z }
    open fun isAlwaysHits(): Boolean = alwaysHits
    open fun setAlwaysHits(z: Boolean) { alwaysHits = z }
    open fun getOnFireBonusDamage(): Int = onFireBonusDamage
    open fun getFreezeBonusDamage(): Int = freezeBonusDamage
    open fun getPoisonBonus(): Int = poisonBonus
    open fun getLivingCompanionBonusDamage(): Int = livingCompanionBonusDamage
    open fun getRegenerationBonus(): Int = regenerationBonus
    open fun getFlatDodgeChance(): Double = flatDodgeChance
    open fun getDecay(): Int = decay
    open fun getExaltInspireBonusTurns(): Int = exaltInspireBonusTurns
    open fun getBonusExperience(): Int = bonusExperience
    open fun getDarknessReduction(): Int = darknessReduction
    open fun getCounterattack(): Double = counterattack
    open fun setCounterattack(d: Double) { counterattack = d }
    open fun getDarknessDamageAmplification(): Double = darknessDamageAmplification
    open fun setDarknessDamageAmplification(d: Double) { darknessDamageAmplification = d }
}
