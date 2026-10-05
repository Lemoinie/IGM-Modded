package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

abstract class Enemy : Entity() {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.%s"

        @JvmStatic
        fun getInstance(str: String): Enemy? {
            if (str.startsWith("Elite_")) return EliteEnemy.forTrueClass(str)
            return try {
                val clazz = Class.forName(String.format(CLASS_PATH, str))
                val enemy = clazz.getConstructor().newInstance() as Enemy
                enemy.trueClass = str
                enemy.configureStatistics()
                enemy.currentHp = enemy.calculateTotalMaxHp()
                enemy
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    @JvmField
    @Transient
    var enemyType: EnemyType? = null

    open fun getEnemyType(): EnemyType {
        val explicit = enemyType
        if (explicit != null) return explicit
        val t = EnemyTypeRegistry.getTypeForClass(trueClass ?: this::class.java.simpleName)
        enemyType = t
        return t
    }

    @JvmField
    @Transient
    var isBoss: Boolean = false

    override fun isBoss(): Boolean = isBoss


    @JvmField
    @Transient
    protected var expGiven: Int = 0

    @JvmField
    @Transient
    protected var rarity: Int = 0

    protected abstract fun configureStatistics()
    protected abstract fun getMaxDamage(): Int
    protected abstract fun getMinDamage(): Int
    abstract fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int>

    /**
     * Rolls this enemy's drop table. Default preserves the vanilla single weighted
     * roll over [listDrops]; subclasses may override to roll each drop independently.
     */
    open fun rollDrops(evKey: Int): List<ItemWrapper> {
        val rolled = Utils.rollFromWeightedMap(listDrops(evKey)) as? ItemWrapper ?: return emptyList()
        return listOf(rolled)
    }

    override fun rollsDamageThreeTimes(): Boolean = false

    open fun getRarity(): Int = rarity
    open fun getExpGiven(): Int = expGiven

    override fun calculateMinAttackDamage(): Int = getMinDamage()
    override fun calculateMaxAttackDamage(): Int = getMaxDamage()
    override fun calculateTotalConstitution(): Int = baseConstitution
    override fun calculateTotalIntelligence(): Int = baseIntelligence
    override fun calculateTotalDexterity(): Int = baseDexterity
    override fun calculateTotalMaxHp(): Int = baseMaxHp
    override fun calculateTotalDefense(): Int = baseDefense
    override fun calculateTotalMagicDefense(): Int = baseMagicDefense
    override fun calculateTotalLifesteal(): Int = baseLifesteal
    override fun calculateCounterattackChance(): Double = counterattack
    override fun calculateTotalDarknessDamageAmplification(): Double = darknessDamageAmplification
    override fun calculateRetaliationPhysicalDamage(): Int = retaliationPhysicalDamage
    override fun calculateRetaliationMagicalDamage(): Int = retaliationMagicalDamage
    override fun calculateHealingModifier(): Double = healingModifier
    override fun calculateImmunityToStatus(): Double = immunityToStatus
    override fun calculateTotalRegeneration(): Int = regeneration
    override fun calculateTotalFlatDodgeChance(): Double = flatDodgeChance
    override fun calculateCriticalDamage(): Double = criticalDamage

    override fun calculateCriticalChance(): Double {
        val stat = if (isMagic()) calculateTotalIntelligence() else calculateTotalDexterity()
        return Math.min(0.4, stat.toDouble() * 0.004)
    }

    override fun onTargetHitEffects(): List<StatusEffect> {
        val arrayList = ArrayList<StatusEffect>()
        val effect = onTargetHit
        if (effect != null) {
            arrayList.add(effect)
        }
        return arrayList
    }

    override fun onSelfHitEffects(): List<StatusEffect> {
        val arrayList = ArrayList<StatusEffect>()
        val effect = onSelfHit
        if (effect != null) {
            arrayList.add(effect)
        }
        return arrayList
    }

    override fun calculateTotalAttackSpeed(): Int {
        var speed = 100
        val action = endOfTurnAction
        if (action == EndOfTurnAction.EXTRA_ATTACK) {
            speed += Math.round(100.0 * endOfTurnActionProbability).toInt()
        }
        if (passiveSkill == Skills.PASSIVE_BERSERKER_RAGE && currentHp.toDouble() <= calculateTotalMaxHp().toDouble() * 0.5) {
            speed += 100
        }
        when (passiveSkill) {
            Skills.PASSIVE_DEADLY_FINESSE_I -> speed += 50
            Skills.PASSIVE_DEADLY_FINESSE_II -> speed += 75
            Skills.PASSIVE_DEADLY_FINESSE_III -> speed += 100
            else -> {}
        }
        return speed
    }

    override fun calculateTotalNormalAttackAmp(): Double {
        var amp = super.calculateTotalNormalAttackAmp()
        when (passiveSkill) {
            Skills.PASSIVE_DEADLY_FINESSE_I -> amp -= 0.25
            Skills.PASSIVE_DEADLY_FINESSE_II -> amp -= 0.35
            Skills.PASSIVE_DEADLY_FINESSE_III -> amp -= 0.50
            else -> {}
        }
        return Math.max(0.0, amp)
    }

    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val arrayList = ArrayList<EndOfTurnAction>()
        val action = endOfTurnAction
        if (action != null && action != EndOfTurnAction.EXTRA_ATTACK && (endOfTurnActionProbability >= 1.0 || Utils.random() < endOfTurnActionProbability)) {
            arrayList.add(action)
        }
        val totalSpeed = calculateTotalAttackSpeed()
        if (totalSpeed > 100) {
            val extraAttacks = (totalSpeed - 100) / 100
            val extraChance = (totalSpeed - 100) % 100
            for (i in 0 until extraAttacks) {
                arrayList.add(EndOfTurnAction.EXTRA_ATTACK)
            }
            if (extraChance > 0 && Utils.random() < extraChance.toDouble() * 0.01) {
                arrayList.add(EndOfTurnAction.EXTRA_ATTACK)
            }
        }
        return arrayList
    }
}
