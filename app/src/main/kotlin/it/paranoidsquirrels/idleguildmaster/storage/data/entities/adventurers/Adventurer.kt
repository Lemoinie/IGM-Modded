package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers

import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SerpentBite
import java.util.ArrayList
import java.util.Arrays

abstract class Adventurer : Entity() {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.%s"
        private const val KEY_CONSTITUTION = 0
        private const val KEY_INTELLIGENCE = 1
        private const val KEY_DEXTERITY = 2
        private const val KEY_HP = 3
        private const val KEY_DEFENSE = 4
        private const val KEY_MAGIC_DEFENSE = 5
        const val RESERVED_ID_ENTITY_BOUND: Int = -100

        @JvmStatic
        fun getInstance(
            str: String,
            i: Int,
            i2: Int,
            i3: Int,
            weapon: Weapon?,
            armor: Armor?,
            accessory: Accessory?,
            trait: Trait?,
            trait2: Trait?,
            potionsDrank: PotionsDrank?,
            doctrine: Doctrine?,
            z: Boolean
        ): Adventurer? {
            return try {
                val clazz = Class.forName(String.format(CLASS_PATH, str))
                val adventurer = clazz.getConstructor().newInstance() as Adventurer
                adventurer.trueClass = str
                adventurer.id = i
                adventurer.level = i2
                adventurer.experience = i3
                adventurer.weapon = weapon
                adventurer.armor = armor
                adventurer.accessory = accessory
                adventurer.traitCommon = trait
                adventurer.traitRare = trait2
                adventurer.potionsDrank = potionsDrank
                adventurer.doctrine = doctrine ?: Doctrine.getInstance("EmptyDoctrine")
                adventurer.ascended = z
                adventurer.configureStatistics()
                adventurer
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    @JvmField var accessory: Accessory? = null
    @JvmField var armor: Armor? = null
    @JvmField @Transient var armorType: Int = 0
    @JvmField var ascended: Boolean = false
    @JvmField var doctrine: Doctrine? = null
    @JvmField var experience: Int = 0
    @JvmField var id: Int = 0
    @JvmField var level: Int = 0
    @JvmField @Transient var maxLevel: Int = 0
    @JvmField var minionBound: Adventurer? = null
    @JvmField @Transient var potionDrinkerType: PotionDrinkerType? = null
    @JvmField var potionsDrank: PotionsDrank? = null
    @JvmField var seen: Boolean = false
    @JvmField var timeWhenDismissed: Long = 0L
    @JvmField var traitCommon: Trait? = null
    @JvmField var traitRare: Trait? = null
    @JvmField var weapon: Weapon? = null
    @JvmField @Transient var weaponType: Int = 0
    @JvmField @Transient var healsMinionBound: Boolean = false
    @JvmField @Transient var summonedMinion: Boolean = false
    @JvmField @Transient var darknessReduction: Int = 0
    @JvmField @Transient var saboteur: Boolean = false
    @JvmField @Transient var nightVision: Boolean = false
    @JvmField @Transient var nextClasses: MutableList<String> = ArrayList()

    /**
     * Weapon-stat scaling multipliers (default 1.0). Multiplies each stat BEFORE it feeds into
     * the weapon's damage modifier, so a class can scale e.g. Constitution at 150% (1.5).
     * Set inside `configureStatistics()`; never persisted.
     */
    @Transient open var attackConstitutionScaling: Double = 1.0
    @Transient open var attackIntelligenceScaling: Double = 1.0
    @Transient open var attackDexterityScaling: Double = 1.0

    protected abstract fun configureStatistics()

    override fun getTeam(): Int = 0

    open fun getId(): Int = id
    open fun setId(i: Int) { id = i }
    open fun isSeen(): Boolean = seen
    open fun setSeen(z: Boolean) { seen = z }
    open fun getTimeWhenDismissed(): Long = timeWhenDismissed
    open fun setTimeWhenDismissed(j: Long) { timeWhenDismissed = j }
    open fun getLevel(): Int = level
    open fun setLevel(i: Int) { level = i }
    open fun getMaxLevel(): Int = maxLevel
    open fun setMaxLevel(i: Int) { maxLevel = i }
    open fun getExperience(): Int = experience
    open fun setExperience(i: Int) { experience = i }
    open fun getWeapon(): Weapon? = weapon
    open fun setWeapon(weapon: Weapon?) { this.weapon = weapon }
    open fun getArmor(): Armor? = armor
    open fun setArmor(armor: Armor?) { this.armor = armor }
    open fun getAccessory(): Accessory? = accessory
    open fun setAccessory(accessory: Accessory?) { this.accessory = accessory }
    open fun getTraitCommon(): Trait? = traitCommon
    open fun getTraitRare(): Trait? = traitRare
    open fun getPotionsDrank(): PotionsDrank? = potionsDrank
    open fun setPotionsDrank(potionsDrank: PotionsDrank?) { this.potionsDrank = potionsDrank }
    open fun getDoctrine(): Doctrine? = doctrine
    open fun setDoctrine(doctrine: Doctrine?) { this.doctrine = doctrine }
    open fun isAscended(): Boolean = ascended
    open fun setAscended(z: Boolean) { ascended = z }

    open fun calculateMaxPotions(i: Int): Int {
        val pdt = potionDrinkerType ?: return 0
        return pdt.getMaxAmount(i, maxLevel, ascended).toInt()
    }

    open fun getWeaponType(): Int = weaponType
    open fun getArmorType(): Int = armorType
    open fun getMinionBound(): Adventurer? = minionBound
    open fun setMinionBound(adventurer: Adventurer?) { minionBound = adventurer }
    open fun isHealsMinionBound(): Boolean = healsMinionBound
    open fun isSummonedMinion(): Boolean = summonedMinion
    open fun getNextClasses(): List<String> = nextClasses

    override fun isRanged(): Boolean = weapon?.isRanged() ?: false
    override fun isMagic(): Boolean = weapon?.isMagic() ?: false
    override fun rollsDamageThreeTimes(): Boolean = doctrine?.rollDamageThreeTimes() ?: false

    override fun calculateMinAttackDamage(): Int {
        val w = weapon ?: return 1
        val con = Utils.round(calculateTotalConstitution() * attackConstitutionScaling)
        val int = Utils.round(calculateTotalIntelligence() * attackIntelligenceScaling)
        val dex = Utils.round(calculateTotalDexterity() * attackDexterityScaling)
        var damageModifier = w.getDamageModifier(con, int, dex).toFloat()
        if (w is SerpentBite) {
            damageModifier *= getThreat().toFloat()
        }
        return Utils.round(damageModifier.toDouble() * (1.0 - w.damageDelta()))
    }

    override fun calculateMaxAttackDamage(): Int {
        val w = weapon ?: return 1
        val con = Utils.round(calculateTotalConstitution() * attackConstitutionScaling)
        val int = Utils.round(calculateTotalIntelligence() * attackIntelligenceScaling)
        val dex = Utils.round(calculateTotalDexterity() * attackDexterityScaling)
        var damageModifier = w.getDamageModifier(con, int, dex).toFloat()
        if (w is SerpentBite) {
            damageModifier *= getThreat().toFloat()
        }
        return Utils.round(damageModifier.toDouble() * (w.damageDelta() + 1.0))
    }

    override fun calculateManaRegen(): Int {
        val iCalculateManaRegen = super.calculateManaRegen() + (doctrine?.bonusManaRegen() ?: 0)
        return if (traitRare == Trait.GIFTED) iCalculateManaRegen + 2 else iCalculateManaRegen
    }

    override fun calculateCounterattackChance(): Double {
        var ca = counterattack
        val w = weapon
        if (w != null) ca += w.getCounterattack()
        val a = armor
        if (a != null) ca += a.getCounterattack()
        val acc = accessory
        if (acc != null) ca += acc.getCounterattack()
        if (traitRare == Trait.REACTIVE) ca += 0.1
        return ca + ((doctrine?.bonusCounterattack() ?: 0).toDouble() * 0.01)
    }

    override fun getThreat(): Int {
        var t = threat
        val w = weapon
        if (w != null) t += w.getThreat()
        val a = armor
        if (a != null) t += a.getThreat()
        val acc = accessory
        if (acc != null) t += acc.getThreat()
        if (traitRare == Trait.INTIMIDATING) t++
        return Math.max(1, t + (doctrine?.bonusThreat() ?: 0))
    }

    override fun getInspireExaltBonusTurns(): Int {
        var extra = inspireExaltExtraTurns
        val w = weapon
        if (w != null) extra += w.getExaltInspireBonusTurns()
        val a = armor
        if (a != null) extra += a.getExaltInspireBonusTurns()
        val acc = accessory
        return if (acc != null) extra + acc.getExaltInspireBonusTurns() else extra
    }

    override fun getCriticalReduction(): Double {
        return (criticalReduction + (doctrine?.reduceCriticalBonusDamage() ?: 0).toDouble()) * 0.01
    }

    override fun getMaxLifestealOverheal(): Int {
        return maxLifestealOverheal + (doctrine?.maxLifestealOverheal() ?: 0)
    }

    override fun getDamagePerTurnPerStatus(): Int {
        return damagePerTurnPerStatus + (doctrine?.damagePerTurnPerStatus() ?: 0)
    }

    override fun getArmorIgnored(): Double {
        return armorIgnored + ((doctrine?.ignoreArmorPercentage() ?: 0).toDouble() * 0.01)
    }

    override fun isForcesTargetToCounterattack(): Boolean {
        return forcesTargetToCounterattack || (doctrine?.forcesCounterattack() ?: false)
    }

    override fun isAddsDefensesToRetaliate(): Boolean {
        return addsDefensesToRetaliate || (doctrine?.addsDefensesToRetaliate() ?: false)
    }

    override fun isMoreDamageWhenHalfLife(): Boolean {
        return moreDamageWhenHalfLife || (doctrine?.moreDamageWhenHalfLife() ?: false)
    }

    override fun isMoreDamageDealtAndTaken(): Boolean {
        return moreDamageDealtAndTaken || (doctrine?.moreDamageDealtAndTaken() ?: false)
    }

    override fun getMaxOverheal(): Int {
        return maxOverheal + (doctrine?.maxOverheal() ?: 0)
    }

    override fun getBonusResurrectChance(): Int {
        return bonusResurrectChance + (doctrine?.bonusResurrectionChance() ?: 0)
    }

    override fun getHealMissingHpOnEnemyDeath(): Int {
        return healMissingHpOnEnemyDeath + (doctrine?.healingNova() ?: 0)
    }

    override fun calculateFlatDamageReduction(): Int {
        return super.calculateFlatDamageReduction()
    }

    override fun calculateTotalConstitution(): Int = calculateTotalStat(0)
    override fun calculateTotalIntelligence(): Int = calculateTotalStat(1)
    override fun calculateTotalDexterity(): Int = calculateTotalStat(2)
    override fun calculateTotalMaxHp(): Int = calculateTotalStat(3)
    override fun calculateTotalDefense(): Int = calculateTotalStat(4)
    override fun calculateTotalMagicDefense(): Int = calculateTotalStat(5)

    override fun calculateTotalLifesteal(): Int {
        var ls = 0
        val w = weapon
        if (w != null) {
            ls = w.getLifesteal()
            if (minionBound != null) {
                ls += w.getLifestealWithMinion()
            }
        }
        val a = armor
        if (a != null) {
            ls += a.getLifesteal()
            if (minionBound != null) {
                ls += a.getLifestealWithMinion()
            }
        }
        val acc = accessory
        if (acc != null) {
            ls += acc.getLifesteal()
            if (minionBound != null) {
                ls += acc.getLifestealWithMinion()
            }
        }
        return baseLifesteal + ls + (if (traitRare == Trait.CURSED) 20 else 0) + (doctrine?.bonusLifesteal() ?: 0)
    }

    override fun calculateTotalDarknessDamageAmplification(): Double {
        var dda = darknessDamageAmplification + ((potionsDrank?.get(8) ?: 0).toDouble() * 0.001)
        val w = weapon
        if (w != null) dda += w.getDarknessDamageAmplification()
        val a = armor
        if (a != null) dda += a.getDarknessDamageAmplification()
        val acc = accessory
        if (acc != null) dda += acc.getDarknessDamageAmplification()
        if (traitRare == Trait.NOCTURNAL) dda += 0.01
        return dda + ((doctrine?.darknessDamageIncrease() ?: 0).toDouble() * 0.001)
    }

    open fun darknessReduction(): Int {
        var dr = darknessReduction
        val w = weapon
        if (w != null) dr += w.getDarknessReduction()
        val a = armor
        if (a != null) dr += a.getDarknessReduction()
        val acc = accessory
        if (acc != null) dr += acc.getDarknessReduction()
        return if (traitRare == Trait.BLESSED) dr + 15 else dr
    }

    open fun experienceMultiplier(): Double {
        var bonus = 0.0
        val w = weapon
        if (w != null) bonus += w.getBonusExperience().toDouble()
        val a = armor
        if (a != null) bonus += a.getBonusExperience().toDouble()
        val acc = accessory
        if (acc != null) bonus += acc.getBonusExperience().toDouble()
        return (bonus / 100.0) + 1.0
    }

    override fun calculateRetaliationPhysicalDamage(): Int {
        var rpd = retaliationPhysicalDamage
        val w = weapon
        if (w != null) rpd += w.getRetaliationPhysicalDamage()
        val a = armor
        if (a != null) rpd += a.getRetaliationPhysicalDamage()
        val acc = accessory
        if (acc != null) rpd += acc.getRetaliationPhysicalDamage()
        return if (isAddsDefensesToRetaliate()) rpd + calculateTotalDefense() else rpd
    }

    override fun calculateRetaliationMagicalDamage(): Int {
        var rmd = retaliationMagicalDamage
        val w = weapon
        if (w != null) rmd += w.getRetaliationMagicalDamage()
        val a = armor
        if (a != null) rmd += a.getRetaliationMagicalDamage()
        val acc = accessory
        if (acc != null) rmd += acc.getRetaliationMagicalDamage()
        return if (isAddsDefensesToRetaliate()) rmd + calculateTotalMagicDefense() else rmd
    }

    override fun calculateHealingModifier(): Double {
        var hm = healingModifier
        val w = weapon
        if (w != null) hm += w.getHealingModifier()
        val a = armor
        if (a != null) hm += a.getHealingModifier()
        val acc = accessory
        if (acc != null) hm += acc.getHealingModifier()
        val dBonus = hm + ((doctrine?.bonusHealingModifier() ?: 0).toDouble() * 0.01)
        return if (traitRare == Trait.EMPATHETIC) dBonus * 1.2 else dBonus
    }

    override fun calculateImmunityToStatus(): Double {
        var its = immunityToStatus + ((potionsDrank?.get(9) ?: 0).toDouble() * 0.01)
        val w = weapon
        if (w != null) its += w.getImmunityToStatus()
        val a = armor
        if (a != null) its += a.getImmunityToStatus()
        val acc = accessory
        if (acc != null) its += acc.getImmunityToStatus()
        if (traitRare == Trait.MINDFUL) its += 0.1
        return its + ((doctrine?.bonusStatusImmunity() ?: 0).toDouble() * 0.01)
    }

    override fun calculateIgnoreImmunityToStatus(): Double {
        return ignoreImmunityToStatus + (doctrine?.ignoreEnemyImmunities() ?: 0).toDouble()
    }

    override fun calculateTotalRegeneration(): Int {
        var regen = regeneration
        val w = weapon
        if (w != null) regen += w.getRegeneration()
        val a = armor
        if (a != null) regen += a.getRegeneration()
        val acc = accessory
        if (acc != null) regen += acc.getRegeneration()
        if (traitRare != Trait.TROLL_BLOOD) {
            return regen
        }
        val tier = maxLevel / 5
        val bonus = (calculateTotalMaxHp() * tier + 100) / 200
        return regen + bonus
    }

    override fun calculateTotalFlatDodgeChance(): Double {
        var dc = flatDodgeChance + ((potionsDrank?.get(10) ?: 0).toDouble() * 0.01)
        val w = weapon
        if (w != null) dc += w.getFlatDodgeChance()
        val a = armor
        if (a != null) dc += a.getFlatDodgeChance()
        val acc = accessory
        if (acc != null) dc += acc.getFlatDodgeChance()
        if (traitRare == Trait.NIMBLE) dc += 0.15
        return dc + ((doctrine?.bonusDodgeChance() ?: 0).toDouble() * 0.01)
    }

    override fun calculateCriticalDamage(): Double {
        var cd = criticalDamage + ((potionsDrank?.get(7) ?: 0).toDouble() * 0.02)
        val w = weapon
        if (w != null) cd += w.getCriticalDamage()
        val a = armor
        if (a != null) cd += a.getCriticalDamage()
        val acc = accessory
        if (acc != null) cd += acc.getCriticalDamage()
        val dBonus = cd + ((doctrine?.bonusCritDamage() ?: 0).toDouble() * 0.01)
        return when (traitRare) {
            Trait.RUTHLESS -> dBonus * 1.2
            Trait.RUTHLESS_PLUS -> dBonus * 1.3
            else -> dBonus
        }
    }

    override fun calculateCriticalChance(): Double {
        val stat = if (isMagic()) calculateTotalIntelligence() else calculateTotalDexterity()
        var cc = Math.min(0.4, stat.toDouble() * 0.004) + ((potionsDrank?.get(6) ?: 0).toDouble() * 0.01)
        val w = weapon
        if (w != null) cc += w.getCriticalChance()
        val a = armor
        if (a != null) cc += a.getCriticalChance()
        val acc = accessory
        if (acc != null) cc += acc.getCriticalChance()
        return cc + ((doctrine?.bonusCritChance() ?: 0).toDouble() * 0.01)
    }

    open fun isSaboteur(): Boolean = saboteur
    open fun setSaboteur(z: Boolean) { saboteur = z }
    open fun isNightVision(): Boolean = nightVision
    open fun setNightVision(z: Boolean) { nightVision = z }

    open fun decay(): Int {
        val totalMaxHp = calculateTotalMaxHp()
        var d = 0.0
        val w = weapon
        if (w != null) d += w.getDecay().toDouble()
        val a = armor
        if (a != null) d += a.getDecay().toDouble()
        val acc = accessory
        if (acc != null) d += acc.getDecay().toDouble()
        if (summonedMinion) {
            d = Math.max(1.0, d + (totalMaxHp.toDouble() * 0.25))
        }
        if (traitRare == Trait.CURSED) {
            d = Math.max(1.0, d + (totalMaxHp.toDouble() * 0.02))
        }
        return Utils.round(d)
    }

    override fun isInitiative(): Boolean {
        if (initiative || traitRare == Trait.ALERT) return true
        if (weapon?.isInitiative() == true) return true
        if (armor?.isInitiative() == true) return true
        return accessory?.isInitiative() == true
    }

    override fun isAlwaysHits(): Boolean {
        if (alwaysHits) return true
        if (weapon?.isAlwaysHits() == true) return true
        if (armor?.isAlwaysHits() == true) return true
        return accessory?.isAlwaysHits() == true
    }

    override fun getOnFireBonusDamage(): Int {
        var dmg = onFireBonusDamage
        val w = weapon
        if (w != null) dmg += w.getOnFireBonusDamage()
        val a = armor
        if (a != null) dmg += a.getOnFireBonusDamage()
        val acc = accessory
        return if (acc != null) dmg + acc.getOnFireBonusDamage() else dmg
    }

    override fun getBloodflameDamageBonus(): Int {
        var bonus = bloodflameDamageBonus
        val w = weapon
        if (w != null) bonus += w.getBloodflameDamageBonus()
        val a = armor
        if (a != null) bonus += a.getBloodflameDamageBonus()
        val acc = accessory
        return if (acc != null) bonus + acc.getBloodflameDamageBonus() else bonus
    }

    override fun getFreezeBonusDamage(): Int {
        var dmg = freezeBonusDamage
        val w = weapon
        if (w != null) dmg += w.getFreezeBonusDamage()
        val a = armor
        if (a != null) dmg += a.getFreezeBonusDamage()
        val acc = accessory
        return if (acc != null) dmg + acc.getFreezeBonusDamage() else dmg
    }

    override fun getLivingCompanionBonusDamage(): Int {
        var dmg = livingCompanionBonusDamage
        val w = weapon
        if (w != null) dmg += w.getLivingCompanionBonusDamage()
        val a = armor
        if (a != null) dmg += a.getLivingCompanionBonusDamage()
        val acc = accessory
        return if (acc != null) dmg + acc.getLivingCompanionBonusDamage() else dmg
    }

    override fun getPoisonBonus(): Int {
        var pb = poisonBonus
        val w = weapon
        if (w != null) pb += w.getPoisonBonus()
        val a = armor
        if (a != null) pb += a.getPoisonBonus()
        val acc = accessory
        return if (acc != null) pb + acc.getPoisonBonus() else pb
    }

    override fun getRegenerationBonus(): Int {
        var rb = regenerationBonus
        val w = weapon
        if (w != null) rb += w.getRegenerationBonus()
        val a = armor
        if (a != null) rb += a.getRegenerationBonus()
        val acc = accessory
        return if (acc != null) rb + acc.getRegenerationBonus() else rb
    }

    override fun onTargetHitEffects(): List<StatusEffect> {
        val arrayList = ArrayList<StatusEffect>()
        val effect = onTargetHit
        if (effect != null) {
            arrayList.add(StatusEffect(effect.type, this, effect.turnsLeft, effect.probability))
        }
        val w = weapon
        if (w != null && w.getOnTargetHit() != null) {
            val onTargetHit = w.getOnTargetHit()!!
            onTargetHit.cause = this
            arrayList.add(onTargetHit)
        }
        val a = armor
        if (a != null && a.getOnTargetHit() != null) {
            val onTargetHit2 = a.getOnTargetHit()!!
            onTargetHit2.cause = this
            arrayList.add(onTargetHit2)
        }
        val acc = accessory
        if (acc != null && acc.getOnTargetHit() != null) {
            val onTargetHit3 = acc.getOnTargetHit()!!
            onTargetHit3.cause = this
            arrayList.add(onTargetHit3)
        }
        val doc = doctrine
        if (doc != null) {
            if (doc.freezeOnHit() > 0) {
                arrayList.add(StatusEffect(StatusEffectType.FROZEN, this, 1, doc.freezeOnHit().toDouble() * 0.01))
            }
            if (doc.petrifyOnHit() > 0) {
                arrayList.add(StatusEffect(StatusEffectType.PETRIFY, this, 1, doc.petrifyOnHit().toDouble() * 0.01))
            }
        }
        return arrayList
    }

    override fun onSelfHitEffects(): List<StatusEffect> {
        val arrayList = ArrayList<StatusEffect>()
        val effect = onSelfHit
        if (effect != null) {
            arrayList.add(StatusEffect(effect.type, this, effect.turnsLeft, effect.probability))
        }
        val w = weapon
        if (w != null && w.getOnSelfHit() != null) {
            val onSelfHit = w.getOnSelfHit()!!
            onSelfHit.cause = this
            arrayList.add(onSelfHit)
        }
        val a = armor
        if (a != null && a.getOnSelfHit() != null) {
            val onSelfHit2 = a.getOnSelfHit()!!
            onSelfHit2.cause = this
            arrayList.add(onSelfHit2)
        }
        val acc = accessory
        if (acc != null && acc.getOnSelfHit() != null) {
            val onSelfHit3 = acc.getOnSelfHit()!!
            onSelfHit3.cause = this
            arrayList.add(onSelfHit3)
        }
        return arrayList
    }

    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val arrayList = ArrayList<EndOfTurnAction>()
        val action = endOfTurnAction
        if (action != null) {
            arrayList.add(action)
        }
        val w = weapon
        if (w != null && w.getEndOfTurnAction() != null) {
            val wAction = w.getEndOfTurnAction()!!
            for (i in 0 until w.getEndOfTurnActionRepeats()) {
                arrayList.add(wAction)
            }
        }
        val a = armor
        if (a != null && a.getEndOfTurnAction() != null) {
            val aAction = a.getEndOfTurnAction()!!
            for (i in 0 until a.getEndOfTurnActionRepeats()) {
                arrayList.add(aAction)
            }
        }
        val acc = accessory
        if (acc != null && acc.getEndOfTurnAction() != null) {
            val accAction = acc.getEndOfTurnAction()!!
            for (i in 0 until acc.getEndOfTurnActionRepeats()) {
                arrayList.add(accAction)
            }
        }
        val doc = doctrine
        if (doc != null) {
            if (doc.extraAttackChance() > 0 && Utils.random() < doc.extraAttackChance().toDouble() * 0.01) {
                arrayList.add(EndOfTurnAction.EXTRA_ATTACK)
            }
            if (doc.falseLifeChance() > 0) {
                arrayList.add(EndOfTurnAction.FALSE_LIFE)
            }
        }
        return arrayList
    }

    private fun calculateTotalStat(i: Int): Int {
        val d2 = if (ascended) 1.5 else 1.0
        val doc = doctrine
        val pd = potionsDrank
        val i3: Int = when (i) {
            0 -> ((baseConstitution.toDouble() * d2).toInt()) + (pd?.get(0) ?: 0) + (doc?.bonusConstitution() ?: 0)
            1 -> ((baseIntelligence.toDouble() * d2).toInt()) + (pd?.get(2) ?: 0) + (doc?.bonusIntelligence() ?: 0)
            2 -> ((baseDexterity.toDouble() * d2).toInt()) + (pd?.get(1) ?: 0) + (doc?.bonusDexterity() ?: 0)
            3 -> (((baseMaxHp + level - 1).toDouble() * d2).toInt()) + ((pd?.get(3) ?: 0) * 5) + (doc?.bonusHp() ?: 0)
            4 -> baseDefense + (pd?.get(4) ?: 0) + (doc?.bonusDefense() ?: 0)
            5 -> baseMagicDefense + (pd?.get(5) ?: 0) + (doc?.bonusMagicDefense() ?: 0)
            else -> 0
        }

        val zDoubleAccessoryStats = doc?.doubleAccessoryStats() ?: false
        var i5 = 0
        for (equipment in listOfNotNull(weapon, armor, accessory)) {
            val mult = if (zDoubleAccessoryStats && equipment is Accessory) 2 else 1
            when (i) {
                0 -> i5 += equipment.getConstitution() * mult
                1 -> i5 += equipment.getIntelligence() * mult
                2 -> i5 += equipment.getDexterity() * mult
                3 -> i5 += equipment.getMaxHp() * mult
                4 -> i5 += equipment.getDefense()
                5 -> i5 += equipment.getMagicDefense()
            }
        }

        var d = 1.0
        val tc = traitCommon
        if (tc != null) {
            when (tc) {
                Trait.BOOKWORM -> if (i == 0) d = 1.15
                Trait.FERAL -> if (i == 2) d = 1.15
                Trait.BRUTE -> if (i == 1) d = 1.15
                Trait.BOOKWORM_PLUS -> {
                    if (i == 0) d = 1.2
                    else if (i == 1 || i == 2) d = 0.95
                }
                Trait.FERAL_PLUS -> {
                    if (i == 2) d = 1.2
                    else if (i == 0 || i == 1) d = 0.95
                }
                Trait.BRUTE_PLUS -> {
                    if (i == 1) d = 1.2
                    else if (i == 0 || i == 2) d = 0.95
                }
                else -> {}
            }
        }
        return Utils.round((i3 + i5).toDouble() * d)
    }

    open fun totalExperienceToNextLevel(): Int {
        return Formulas.experienceToNextLevel(level, isAscended())
    }

    open fun addExperience(i: Int): Int {
        var remaining = i
        val oldLevel = getLevel()
        while (level < maxLevel && remaining > 0) {
            val needed = totalExperienceToNextLevel() - experience
            val iMin = Math.min(needed, remaining)
            remaining -= iMin
            experience += iMin
            if (experience >= totalExperienceToNextLevel()) {
                level++
                experience = 0
                currentHp = calculateTotalMaxHp()
            }
        }
        return getLevel() - oldLevel
    }

    open fun changeRareTrait(trait: Trait?) {
        traitRare = trait
    }

    open fun getDoctrinePoints(): Int {
        val doc = doctrine ?: return 0
        if (!ascended || doc.getTrueClass() == "EmptyDoctrine") {
            return 0
        }
        var iDoctrinePointsFromLevels = doctrinePointsFromLevels() + doc.bonusQuestPoints()
        for (doctrineAbility in doc.abilities) {
            val type = doctrineAbility.type ?: continue
            iDoctrinePointsFromLevels -= doctrineAbility.level * type.cost
        }
        return iDoctrinePointsFromLevels
    }

    open fun doctrinePointsFromLevels(): Int {
        val i = maxLevel
        return ((((i - 5).toDouble() * 0.5 * (i / 5).toDouble()).toInt() + level) / 15) + 3
    }

    open fun simulateDoctrinePoints(doctrine: Doctrine?): Int {
        if (doctrine == null || !ascended || doctrine.getTrueClass() == "EmptyDoctrine") {
            return 0
        }
        return doctrinePointsFromLevels() + doctrine.bonusQuestPoints()
    }

    override fun canPickDoctrine(): Boolean = ascended
}
