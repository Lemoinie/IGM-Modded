package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines

abstract class Doctrine {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.%s"

        @JvmStatic
        fun getInstance(str: String?): Doctrine? {
            return getInstance(str, 0, 0, 0, 0, 0, 0)
        }

        @JvmStatic
        fun getInstance(str: String?, i: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int): Doctrine? {
            if (str == null) return null
            try {
                val clazz = Class.forName(String.format(CLASS_PATH, str))
                val doctrine = clazz.getConstructor().newInstance() as Doctrine
                doctrine.trueClass = str
                doctrine.l1 = i
                doctrine.l2 = i2
                doctrine.l3 = i3
                doctrine.l4 = i4
                doctrine.l5 = i5
                doctrine.l6 = i6
                doctrine.setupValues()
                for ((idx, abilityType) in doctrine.setupAbilities().withIndex()) {
                    doctrine.setupAbility(abilityType, idx)
                }
                return doctrine
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }
    }

    @JvmField
    @Transient
    var abilities: MutableList<DoctrineAbility> = ArrayList()

    @JvmField
    @Transient
    var idDescription: Int = 0

    @JvmField
    @Transient
    var idDescriptionShort: Int = 0

    @JvmField
    @Transient
    var idImage: Int = 0

    @JvmField
    @Transient
    var idName: Int = 0

    @JvmField var l1: Int = 0
    @JvmField var l2: Int = 0
    @JvmField var l3: Int = 0
    @JvmField var l4: Int = 0
    @JvmField var l5: Int = 0
    @JvmField var l6: Int = 0
    @JvmField var trueClass: String? = null

    open fun addsDefensesToRetaliate(): Boolean = false
    open fun bonusConstitution(): Int = 0
    open fun bonusCounterattack(): Int = 0
    open fun bonusCritChance(): Int = 0
    open fun bonusCritDamage(): Int = 0
    open fun bonusDefense(): Int = 0
    open fun bonusDexterity(): Int = 0
    open fun bonusDodgeChance(): Int = 0
    open fun bonusHealingModifier(): Int = 0
    open fun bonusHp(): Int = 0
    open fun bonusIntelligence(): Int = 0
    open fun bonusLifesteal(): Int = 0
    open fun bonusMagicDefense(): Int = 0
    open fun bonusManaRegen(): Int = 0
    abstract fun bonusQuestPoints(): Int
    open fun bonusResurrectionChance(): Int = 0
    open fun bonusStatusImmunity(): Int = 0
    open fun bonusThreat(): Int = 0
    open fun canUseAllWeapons(): Boolean = false
    open fun damageOnFalseLifeRemoval(): Int = 0
    open fun damagePerTurnPerStatus(): Int = 0
    open fun darknessDamageIncrease(): Int = 0
    open fun doubleAccessoryStats(): Boolean = false
    open fun extraAttackChance(): Int = 0
    open fun falseLifeChance(): Int = 0
    open fun forcesCounterattack(): Boolean = false
    open fun freezeOnHit(): Int = 0
    open fun healingNova(): Int = 0
    open fun ignoreArmorPercentage(): Int = 0
    open fun ignoreEnemyImmunities(): Int = 0
    open fun maxLifestealOverheal(): Int = 0
    open fun maxOverheal(): Int = 0
    open fun moreDamageDealtAndTaken(): Boolean = false
    open fun moreDamageWhenHalfLife(): Boolean = false
    open fun petrifyOnHit(): Int = 0
    open fun reduceCriticalBonusDamage(): Int = 0
    open fun rollDamageThreeTimes(): Boolean = false

    protected abstract fun setupAbilities(): List<DoctrineAbilityType>
    protected abstract fun setupValues()

    private fun setupAbility(doctrineAbilityType: DoctrineAbilityType, i: Int) {
        val level = when (i) {
            0 -> l1
            1 -> l2
            2 -> l3
            3 -> l4
            4 -> l5
            5 -> l6
            else -> 0
        }
        abilities.add(DoctrineAbility(doctrineAbilityType, level))
    }

    fun realignLevels() {
        for ((i, doctrineAbility) in abilities.withIndex()) {
            when (i) {
                0 -> l1 = doctrineAbility.level
                1 -> l2 = doctrineAbility.level
                2 -> l3 = doctrineAbility.level
                3 -> l4 = doctrineAbility.level
                4 -> l5 = doctrineAbility.level
                5 -> l6 = doctrineAbility.level
            }
        }
    }

    protected fun getValue(doctrineAbilityType: DoctrineAbilityType): Int {
        val idx = abilities.indexOf(DoctrineAbility(doctrineAbilityType, 0))
        return if (idx >= 0) abilities[idx].getValue() else 0
    }

    fun getIdImage(): Int = idImage
    fun getIdName(): Int = idName
    fun getIdDescription(): Int = idDescription
    fun getIdDescriptionShort(): Int = idDescriptionShort
    fun getAbilities(): List<DoctrineAbility> = abilities
    fun getTrueClass(): String? = trueClass
}
