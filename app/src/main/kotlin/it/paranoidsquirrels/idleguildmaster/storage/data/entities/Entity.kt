package it.paranoidsquirrels.idleguildmaster.storage.data.entities

import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.ArrayList
import java.util.concurrent.CopyOnWriteArrayList

abstract class Entity {
    companion object {
        const val MAX_MANA: Int = 100
    }

    @JvmField @Transient var activeSkill: Skills? = null
    @JvmField @Transient var baseConstitution: Int = 0
    @JvmField @Transient var baseDefense: Int = 0
    @JvmField @Transient var baseDexterity: Int = 0
    @JvmField @Transient var baseIntelligence: Int = 0
    @JvmField @Transient var baseMagicDefense: Int = 0
    @JvmField @Transient var baseMaxHp: Int = 0
    @JvmField var currentHp: Int = 0
    @JvmField var currentMana: Int = 0
    @JvmField var currentShield: Int = 0
    @JvmField @Transient var endOfTurnAction: EndOfTurnAction? = null
    @JvmField @Transient var enemy: Int = 0
    @JvmField @Transient var idDescription: Int = 0
    @JvmField @Transient var idName: Int = 0
    @JvmField @Transient var imageId: Int = 0
    @JvmField @Transient var onSelfHit: StatusEffect? = null
    @JvmField @Transient var onTargetHit: StatusEffect? = null
    @JvmField @Transient var passiveSkill: Skills? = null
    @JvmField var trueClass: String? = null
    @JvmField @Transient var threat: Int = 1
    @JvmField @Transient var counterattack: Double = 0.0
    @JvmField @Transient var flying: Boolean = false
    @JvmField @Transient var baseLifesteal: Int = 0
    @JvmField @Transient var darknessDamageAmplification: Double = 0.0
    @JvmField @Transient var healer: Boolean = false
    @JvmField @Transient var cleanser: Boolean = false
    @JvmField @Transient var initiative: Boolean = false
    @JvmField @Transient var retaliationPhysicalDamage: Int = 0
    @JvmField @Transient var retaliationMagicalDamage: Int = 0
    @JvmField @Transient var healingModifier: Double = 1.0
    @JvmField @Transient var immunityToStatus: Double = 0.0
    @JvmField @Transient var ignoreImmunityToStatus: Double = 0.0
    @JvmField @Transient var regeneration: Int = 0
    @JvmField @Transient var criticalDamage: Double = 1.5
    @JvmField @Transient var alwaysHits: Boolean = false
    @JvmField @Transient var onFireBonusDamage: Int = 0
    @JvmField @Transient var freezeBonusDamage: Int = 0
    @JvmField @Transient var poisonBonus: Int = 0
    @JvmField @Transient var livingCompanionBonusDamage: Int = 0
    @JvmField @Transient var regenerationBonus: Int = 0
    @JvmField @Transient var flatDodgeChance: Double = 0.0
    @JvmField @Transient var stunChanceOnLowerHp: Double = 0.0
    @JvmField @Transient var inspireExaltExtraTurns: Int = 0
    @JvmField @Transient var criticalReduction: Double = 0.0
    @JvmField @Transient var maxLifestealOverheal: Int = 0
    @JvmField @Transient var damagePerTurnPerStatus: Int = 0
    @JvmField @Transient var armorIgnored: Double = 0.0
    @JvmField @Transient var forcesTargetToCounterattack: Boolean = false
    @JvmField @Transient var addsDefensesToRetaliate: Boolean = false
    @JvmField @Transient var moreDamageWhenHalfLife: Boolean = false
    @JvmField @Transient var moreDamageDealtAndTaken: Boolean = false
    @JvmField @Transient var maxOverheal: Int = 0
    @JvmField @Transient var bonusResurrectChance: Int = 0
    @JvmField @Transient var healMissingHpOnEnemyDeath: Int = 0
    @JvmField @Transient var team: Int = 0
    @JvmField @Transient var increaseHealingAgainst: Map.Entry<String, Double>? = null
    @JvmField @Transient var statusImmunities: MutableList<StatusEffectType> = ArrayList()
    @JvmField @Transient var onDeathEffectsOnEnemies: MutableList<StatusEffect> = ArrayList()
    @JvmField @Transient var onDeathEffectsOnAllies: MutableList<StatusEffect> = ArrayList()
    @JvmField var negativeStatusEffects: MutableList<StatusEffect> = CopyOnWriteArrayList()
    @JvmField var positiveStatusEffects: MutableList<StatusEffect> = CopyOnWriteArrayList()

    abstract fun calculateCounterattackChance(): Double
    abstract fun calculateCriticalChance(): Double
    abstract fun calculateCriticalDamage(): Double
    abstract fun calculateHealingModifier(): Double
    abstract fun calculateImmunityToStatus(): Double
    abstract fun calculateMaxAttackDamage(): Int
    abstract fun calculateMinAttackDamage(): Int
    abstract fun calculateRetaliationMagicalDamage(): Int
    abstract fun calculateRetaliationPhysicalDamage(): Int
    abstract fun calculateTotalConstitution(): Int
    abstract fun calculateTotalDarknessDamageAmplification(): Double
    abstract fun calculateTotalDefense(): Int
    abstract fun calculateTotalDexterity(): Int
    abstract fun calculateTotalFlatDodgeChance(): Double
    abstract fun calculateTotalIntelligence(): Int
    abstract fun calculateTotalLifesteal(): Int
    abstract fun calculateTotalMagicDefense(): Int
    abstract fun calculateTotalMaxHp(): Int
    abstract fun calculateTotalRegeneration(): Int

    open fun canPickDoctrine(): Boolean = false
    abstract fun endOfTurnActions(): List<EndOfTurnAction>
    abstract fun isMagic(): Boolean
    abstract fun isRanged(): Boolean
    abstract fun onSelfHitEffects(): List<StatusEffect>
    abstract fun onTargetHitEffects(): List<StatusEffect>
    abstract fun rollsDamageThreeTimes(): Boolean

    open fun getIdName(): Int = idName
    open fun getIdDescription(): Int = idDescription
    open fun getTrueClass(): String? = trueClass
    open fun getImageId(): Int = imageId
    open fun getPassiveSkill(): Skills? = passiveSkill
    open fun getActiveSkill(): Skills? = activeSkill
    open fun getCurrentHp(): Int = currentHp
    open fun setCurrentHp(i: Int) { currentHp = i }
    open fun getCurrentMana(): Int = currentMana
    open fun setCurrentMana(i: Int) { currentMana = i }
    open fun getCurrentShield(): Int = currentShield
    open fun setCurrentShield(i: Int) { currentShield = i }
    open fun isFlying(): Boolean = flying
    open fun isHealer(): Boolean = healer
    open fun isCleanser(): Boolean = cleanser
    open fun isInitiative(): Boolean = initiative
    open fun calculateIgnoreImmunityToStatus(): Double = ignoreImmunityToStatus
    open fun isAlwaysHits(): Boolean = alwaysHits
    open fun getOnFireBonusDamage(): Int = onFireBonusDamage
    open fun getFreezeBonusDamage(): Int = freezeBonusDamage
    open fun getPoisonBonus(): Int = poisonBonus
    open fun getLivingCompanionBonusDamage(): Int = livingCompanionBonusDamage
    open fun getRegenerationBonus(): Int = regenerationBonus
    open fun getFlatDodgeChance(): Double = flatDodgeChance
    open fun getStunChanceOnLowerHp(): Double = stunChanceOnLowerHp
    open fun getInspireExaltBonusTurns(): Int = inspireExaltExtraTurns
    open fun getCriticalReduction(): Double = criticalReduction
    open fun getMaxLifestealOverheal(): Int = maxLifestealOverheal
    open fun getDamagePerTurnPerStatus(): Int = damagePerTurnPerStatus
    open fun getArmorIgnored(): Double = armorIgnored
    open fun isForcesTargetToCounterattack(): Boolean = forcesTargetToCounterattack
    open fun isAddsDefensesToRetaliate(): Boolean = addsDefensesToRetaliate
    open fun isMoreDamageWhenHalfLife(): Boolean = moreDamageWhenHalfLife
    open fun isMoreDamageDealtAndTaken(): Boolean = moreDamageDealtAndTaken
    open fun getMaxOverheal(): Int = maxOverheal
    open fun getBonusResurrectChance(): Int = bonusResurrectChance
    open fun getHealMissingHpOnEnemyDeath(): Int = healMissingHpOnEnemyDeath
    open fun getTeam(): Int = team
    open fun getIncreaseHealingAgainst(): Map.Entry<String, Double>? = increaseHealingAgainst
    open fun getThreat(): Int = threat
    open fun getNegativeStatusEffects(): List<StatusEffect> = negativeStatusEffects
    open fun setNegativeStatusEffects(list: MutableList<StatusEffect>) { negativeStatusEffects = list }

    /** True when this unit carries Bloodblaze: burns each turn and cannot benefit from healing. */
    open fun hasBloodblaze(): Boolean = negativeStatusEffects.any { it.type == StatusEffectType.BLOODBLAZE }
    open fun getPositiveStatusEffects(): List<StatusEffect> = positiveStatusEffects
    open fun setPositiveStatusEffects(list: MutableList<StatusEffect>) { positiveStatusEffects = list }
    open fun calculateOnDeathEffectsOnEnemies(): List<StatusEffect> = onDeathEffectsOnEnemies
    open fun calculateOnDeathEffectsOnAllies(): List<StatusEffect> = onDeathEffectsOnAllies
    open fun calculateManaRegen(): Int = (calculateTotalIntelligence() / 10) + 10

    open fun rollAttackDamage(): Double {
        val iCalculateMinAttackDamage = calculateMinAttackDamage()
        val iCalculateMaxAttackDamage = calculateMaxAttackDamage()
        var dRandom = Utils.random()
        if (rollsDamageThreeTimes()) {
            dRandom = Math.max(Math.max(dRandom, Utils.random()), Utils.random())
        }
        val d = (dRandom * (iCalculateMaxAttackDamage - iCalculateMinAttackDamage).toDouble()) + iCalculateMinAttackDamage.toDouble()
        if (this is Adventurer && d > (iCalculateMaxAttackDamage - 1).toDouble()) {
            QuestsManager.increment(QuestsManager.luckyRoll, 1L)
        }
        var poisonBonus = 0.0
        for (statusEffect in negativeStatusEffects) {
            if (statusEffect.type == StatusEffectType.POISON) {
                poisonBonus = 0.2
                val cause = statusEffect.cause
                if (cause != null) {
                    poisonBonus = 0.2 + (cause.poisonBonus.toDouble() * 0.01)
                }
                return d * (1.0 - poisonBonus)
            }
        }
        return d * (1.0 - poisonBonus)
    }

    open fun applyDamage(d: Double, z: Boolean, i: Int, d2: Double): Int {
        var flatReduction = i
        if (this is Enemy) {
            flatReduction = 0
        }
        val maxDef = if (z) calculateTotalMagicDefense() else calculateTotalDefense()
        val armorFactor = Math.min(1.0, (1.0 - d2) * 0.01 * maxDef.toDouble())
        var damageAfterArmor = (1.0 - armorFactor) * d
        if (this is Adventurer && traitRare == Trait.DRAGON_BLOOD) {
            val tier = maxLevel / 5
            damageAfterArmor *= Math.max(0.0, 1.0 - (tier.toDouble() * 0.01))
        }
        val totalReduction = calculateFlatDamageReduction().toDouble() + flatReduction.toDouble()
        val iRound = Utils.round(Math.max(1.0, damageAfterArmor - totalReduction))

        if (this is Adventurer) {
            QuestsManager.increment(QuestsManager.heavyArmor, (d - iRound.toDouble()).toLong())
            QuestsManager.increment(QuestsManager.protector, iRound.toLong())
        }

        if (currentShield >= iRound) {
            currentShield -= iRound
        } else {
            currentHp = Math.max(0, currentHp - iRound + currentShield)
            currentShield = 0
        }
        return iRound
    }

    protected open fun calculateFlatDamageReduction(): Int {
        var i = 0
        for (effect in positiveStatusEffects) {
            if (effect.type == StatusEffectType.EXALT) {
                i += 5
            }
        }
        return i + (calculateTotalConstitution() / 8)
    }

    open fun addStatusEffect(statusEffect: StatusEffect, d: Double): Int {
        val type = statusEffect.type ?: return 0
        val z = Utils.random() < d
        if ((!z && statusImmunities.contains(type)) || Utils.random() > statusEffect.probability) {
            return 0
        }
        val dCalculateImmunityToStatus = if (type.negative) calculateImmunityToStatus() else 0.0
        if (!z && Utils.random() < dCalculateImmunityToStatus) {
            if (this is Adventurer) {
                QuestsManager.increment(QuestsManager.crystalClear, 1L)
            }
            return 0
        }
        val statusEffect2 = StatusEffect(type, statusEffect.cause, statusEffect.turnsLeft, 1.0)
        val list = if (type.negative) negativeStatusEffects else positiveStatusEffects
        var next: StatusEffect? = null
        for (effect in list) {
            if (effect.type == type) {
                next = effect
                break
            }
        }
        if (type == StatusEffectType.BLEED) {
            if (next != null) {
                val turnsLeft = next.turnsLeft + statusEffect2.turnsLeft
                next.turnsLeft = turnsLeft
                return turnsLeft
            }
            list.add(statusEffect2)
            return statusEffect2.turnsLeft
        } else {
            if (next != null) {
                if (next.turnsLeft >= statusEffect2.turnsLeft) {
                    return 0
                }
                list.remove(next)
            }
            list.add(statusEffect2)
            return statusEffect2.turnsLeft
        }
    }
}
