package it.paranoidsquirrels.idleguildmaster.storage.data.pets

import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.Utils
import java.util.ArrayList

abstract class Pet {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.%s"

        @JvmStatic
        fun getInstance(
            str: String,
            id: Int,
            level: Int,
            food: Int,
            petAbility1: PetAbility,
            petAbility2: PetAbility,
            petAbility3: PetAbility,
            petAbility4: PetAbility
        ): Pet? {
            return try {
                val resolved = if (str.equals("Semi", ignoreCase = true)) "Senko" else str
                val clazz = Class.forName(String.format(CLASS_PATH, resolved))
                val pet = clazz.getConstructor().newInstance() as Pet
                pet.configureStatistics()
                pet.trueClass = resolved
                pet.level = level
                pet.food = food
                pet.id = id
                pet.petAbility1 = petAbility1
                pet.petAbility2 = petAbility2
                pet.petAbility3 = petAbility3
                pet.petAbility4 = petAbility4
                pet.configureAbilities()
                pet
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

        @JvmStatic
        fun getInstance(str: String, id: Int): Pet? {
            return try {
                val resolved = if (str.equals("Semi", ignoreCase = true)) "Senko" else str
                val clazz = Class.forName(String.format(CLASS_PATH, resolved))
                val pet = clazz.getConstructor().newInstance() as Pet
                pet.configureStatistics()
                pet.trueClass = resolved
                pet.level = 1
                pet.food = 0
                pet.id = id
                val arrayList = ArrayList<PetAbility>()
                val guaranteed = pet.guaranteedFirstAbility()
                val petAbility = guaranteed[(Utils.random() * guaranteed.size.toDouble()).toInt()]
                arrayList.add(petAbility)
                pet.petAbility1 = petAbility
                val petAbilityRollPetAbility = Utils.rollPetAbility(arrayList)
                arrayList.add(petAbilityRollPetAbility)
                pet.petAbility2 = petAbilityRollPetAbility
                val petAbilityRollPetAbility2 = if (pet.abilityNumber > 2) Utils.rollPetAbility(arrayList) else PetAbility.EMPTY
                arrayList.add(petAbilityRollPetAbility2)
                pet.petAbility3 = petAbilityRollPetAbility2
                val petAbilityRollPetAbility3 = if (pet.abilityNumber > 3) Utils.rollPetAbility(arrayList) else PetAbility.EMPTY
                arrayList.add(petAbilityRollPetAbility3)
                pet.petAbility4 = petAbilityRollPetAbility3
                pet.configureAbilities()
                pet
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    @JvmField @Transient var abilityNumber: Int = 0
    @JvmField var favourite: Boolean = false
    @JvmField var food: Int = 0
    @JvmField var id: Int = 0
    @JvmField @Transient var idDescription: Int = 0
    @JvmField @Transient var idImage: Int = 0
    @JvmField @Transient var idName: Int = 0
    @JvmField var level: Int = 0
    @JvmField var petAbility1: PetAbility = PetAbility.EMPTY
    @JvmField var petAbility2: PetAbility = PetAbility.EMPTY
    @JvmField var petAbility3: PetAbility = PetAbility.EMPTY
    @JvmField var petAbility4: PetAbility = PetAbility.EMPTY
    @JvmField var trueClass: String = ""
    @JvmField @Transient var fighter: Double = 0.0
    @JvmField @Transient var healer: Double = 0.0
    @JvmField @Transient var decoy: Double = 0.0
    @JvmField @Transient var opportunist: Double = 0.0
    @JvmField @Transient var statusEffectChance: Double = 0.0
    @JvmField @Transient var statusEffectTurns: Int = 0
    @JvmField @Transient var savage: Double = 0.0
    @JvmField @Transient var bloodcrave: Double = 0.0
    @JvmField @Transient var lacerate: Double = 0.0
    @JvmField @Transient var serrated: Double = 0.0
    /** Kitsune Spirit Blessing magnitude currently applied to [healer] (recomputed on every configureAbilities call). */
    @JvmField @Transient var kitsuneBlessingApplied: Double = 0.0
    @JvmField @Transient var bright: Int = 0
    @JvmField @Transient var experience: Double = 0.0
    @JvmField @Transient var drops: Double = 0.0
    @JvmField @Transient var counterattack: Double = 0.0
    @JvmField @Transient var lifesteal: Double = 0.0
    @JvmField @Transient var regeneration: Int = 0
    @JvmField @Transient var barrier: Int = 0

    protected abstract fun configureStatistics()
    protected abstract fun guaranteedFirstAbility(): List<PetAbility>
    abstract fun printPetType(): Int

    fun totalFoodToNextLevel(): Int = Formulas.foodToNextLevel(this.level)

    fun calculateTotalFoodGiven(): Int {
        var total = 0
        for (i in 1 until this.level) {
            total += Formulas.foodToNextLevel(i)
        }
        return total + this.food
    }

    fun feed(amount: Int): Int {
        var remaining = amount
        val prevLevel = getLevel()
        while (remaining > 0) {
            val toNext = totalFoodToNextLevel() - this.food
            val min = Math.min(toNext, remaining)
            remaining -= min
            this.food += min
            if (this.food >= totalFoodToNextLevel()) {
                this.level++
                this.food = 0
            }
        }
        if (this.level > prevLevel) {
            configureAbilities()
        }
        return this.level - prevLevel
    }

    /**
     * Recomputes ability magnitudes for the current level. Needed whenever the level is
     * changed programmatically AFTER construction (e.g. the PET redeem code), because the
     * factory only configured abilities for the original level — otherwise traits such as
     * Savage stay at their level-1/zero magnitude and never activate.
     */
    fun refreshAbilities() {
        configureAbilities()
    }

    private fun configureAbilities() {
        val isSenko = (trueClass.equals("Senko", ignoreCase = true) || trueClass.equals("Semi", ignoreCase = true) || this is it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.Senko)
        if (isSenko) {
            // Senko/Semi unlocks all traits at Level 1
            configureAbility(this.petAbility1, this.level)
            configureAbility(this.petAbility2, this.level)
            configureAbility(this.petAbility3, this.level)
            configureAbility(this.petAbility4, this.level)
            // 5th trait: Kitsune Spirit Blessing — +(level * 0.6%) healing, applied as a MULTIPLIER
            // at heal time (see Area.petHeal). Recomputed idempotently on every call.
            this.kitsuneBlessingApplied = this.level * 0.006
        } else {
            configureAbility(this.petAbility1, this.level)
            configureAbility(this.petAbility2, this.level - 20)
            configureAbility(this.petAbility3, this.level - 40)
            configureAbility(this.petAbility4, this.level - 60)
        }
    }

    protected open fun configureAbility(petAbility: PetAbility, level: Int) {
        if (level <= 0) return
        val d = level.toDouble()
        when (petAbility) {
            PetAbility.FIGHTER -> this.fighter = (d * 0.5) + 1.0
            PetAbility.HEALER -> this.healer = (d * 0.2) + 1.0
            PetAbility.DECOY -> this.decoy = d * 0.01
            PetAbility.OPPORTUNIST -> this.opportunist = d * 0.2
            PetAbility.MAGIC -> {
                this.statusEffectChance = 0.3 * d
                this.statusEffectTurns = Utils.round((d * 0.028) + 1.0)
            }
            PetAbility.SAVAGE -> this.savage = d * 0.3
            PetAbility.BLOODCRAVE -> this.bloodcrave = Math.floor(d * 0.5)
            PetAbility.LACERATE -> this.lacerate = d * 0.6
            PetAbility.SERRATED -> this.serrated = d * 0.6
            PetAbility.BRIGHT -> this.bright = Utils.round((d * 0.5) + 1.0)
            PetAbility.EXPERIENCE -> this.experience = d * 0.4
            PetAbility.DROPS -> this.drops = d * 0.3
            PetAbility.COUNTERATTACK -> this.counterattack = d * 0.35
            PetAbility.LIFESTEAL -> this.lifesteal = d * 0.15
            PetAbility.REGENERATION -> this.regeneration = Utils.round((d * 0.3) + 1.0)
            PetAbility.BARRIER -> this.barrier = Utils.round((d * 0.1) + 1.0)
            else -> {}
        }
    }

    open fun getPetAbility1(): PetAbility = petAbility1
    open fun getPetAbility2(): PetAbility = petAbility2
    open fun getPetAbility3(): PetAbility = petAbility3
    open fun getPetAbility4(): PetAbility = petAbility4
    open fun getFighter(): Double = fighter
    open fun getHealer(): Double = healer
    open fun getDecoy(): Double = decoy
    open fun getOpportunist(): Double = opportunist
    open fun getLevel(): Int = level
    open fun getFood(): Int = food
    open fun getTrueClass(): String = trueClass
    open fun getId(): Int = id
    open fun getAbilityNumber(): Int = abilityNumber
    open fun isFavourite(): Boolean = favourite
    open fun setFavourite(favourite: Boolean) { this.favourite = favourite }
    open fun getIdName(): Int = idName
    open fun getIdDescription(): Int = idDescription
    open fun getIdImage(): Int = idImage
    open fun getStatusEffectChance(): Double = statusEffectChance
    open fun getStatusEffectTurns(): Int = statusEffectTurns
    open fun getSavage(): Double = savage
    open fun getBloodcrave(): Double = bloodcrave
    open fun getLacerate(): Double = lacerate
    open fun getSerrated(): Double = serrated
    open fun getKitsuneBlessing(): Double = kitsuneBlessingApplied
    open fun getBright(): Int = bright
    open fun getExperience(): Double = experience
    open fun getDrops(): Double = drops
    open fun getCounterattack(): Double = counterattack
    open fun getLifesteal(): Double = lifesteal
    open fun getRegeneration(): Int = regeneration
    open fun getBarrier(): Int = barrier
}
