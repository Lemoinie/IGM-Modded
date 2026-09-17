package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
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

    @JvmField @Transient var enemyType: EnemyType? = null

    open fun getEnemyType(): EnemyType {
        val explicit = enemyType
        if (explicit != null) return explicit
        val t = EnemyTypeRegistry.getTypeForClass(trueClass ?: this::class.java.simpleName)
        enemyType = t
        return t
    }

    @JvmField @Transient protected var expGiven: Int = 0
    @JvmField @Transient protected var rarity: Int = 0

    protected abstract fun configureStatistics()
    protected abstract fun getMaxDamage(): Int
    protected abstract fun getMinDamage(): Int
    abstract fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int>

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

    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val arrayList = ArrayList<EndOfTurnAction>()
        val action = endOfTurnAction
        if (action != null) {
            arrayList.add(action)
        }
        return arrayList
    }
}
