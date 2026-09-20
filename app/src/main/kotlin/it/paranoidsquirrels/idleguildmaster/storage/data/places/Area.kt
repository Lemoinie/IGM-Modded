package it.paranoidsquirrels.idleguildmaster.storage.data.places

import com.google.gson.annotations.SerializedName

import android.animation.ValueAnimator
import android.content.res.Resources
import android.view.animation.LinearInterpolator
import androidx.core.content.res.ResourcesCompat
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.EnemyType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.ChiefScientistAva
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.AmuletOfResurrection
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SkeletonKey
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.io.PrintStream
import java.util.ArrayList
import java.util.Collections
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

abstract class Area {
    companion object {
        const val BEHAVIOUR_NORMAL = 0
        const val BEHAVIOUR_SILENCE = 1
        const val BEHAVIOUR_SKIP = 2
        const val EFFECT_PROBABILITY = 0.1
        const val MAX_SIGNIFICANT_PROGRESS = 250

        @JvmField
        val TARGET_ALL = "all"

        @JvmField
        val TARGET_ALL_ALLIES = "all_allies"

        @JvmField
        val TARGET_ALL_ENEMIES = "all_enemies"

        @JvmField
        val TARGET_ALL_EXCEPT_SELF = "all_except_self"

        @JvmField
        val TARGET_LOWEST_ABSOLUTE_ALLY = "lowest_absolute_ally"

        @JvmField
        val TARGET_LOWEST_ABSOLUTE_ENEMY = "lowest_absolute_enemy"

        @JvmField
        val TARGET_LOWEST_RELATIVE_ALLY = "lowest_relative_ally"

        @JvmField
        val TARGET_LOWEST_RELATIVE_ENEMY = "lowest_relative_enemy"

        @JvmField
        val TARGET_LOWEST_SHIELD_ALLY = "lowest_shield_ally"

        @JvmField
        val TARGET_MOST_NEGATIVE_CONDITIONS_OR_LOWEST_RELATIVE_ALLY = "most_negative_conditions_or_lowest_relative_ally"

        @JvmField
        val TARGET_RANDOM = "random"

        @JvmField
        val TARGET_RANDOM_ALLY = "random_ally"

        @JvmField
        val TARGET_RANDOM_ALLY_EXCEPT_SELF = "random_ally_except_self"

        @JvmField
        val TARGET_RANDOM_ENEMY = "random_enemy"

        @JvmField
        val TARGET_RANDOM_EXCEPT_SELF = "random_except_self"
        private val TETHER = StatusEffect(StatusEffectType.FEEBLE_TETHER, null, 0, 0.0)
        const val TYPE_DUNGEON = 0
        const val TYPE_RAID = 1
        const val TYPE_EPIC_RAID = 2
    }

    @Transient
    open var acting: Entity? = null
    open var action: Action? = null

    @Transient
    private var animator: ValueAnimator? = null
    open var event: Event? = null

    @Transient
    open var fightRarity: Int = 0
    open var maxProgress: Int = 0

    @Transient
    open var petExploring: Pet? = null
    open var petExploringId: Int? = null
    open var progress: Int = 0
    open var savedActingEntity: Int? = null
    open var savedPetId: Int? = null
    open var triesAvailable: Boolean = false
    open var turnsFighting: Int = 0

    @SerializedName("unlocked")
    open var isUnlocked: Boolean = false

    open var savedAdventurersIds: MutableList<Int> = CopyOnWriteArrayList()
    open var adventurersExploringIds: MutableList<Int> = CopyOnWriteArrayList()
    open var drops: MutableList<Item> = CopyOnWriteArrayList()

    @Transient
    open var adventurersExploring: MutableList<Adventurer> = CopyOnWriteArrayList()

    @Transient
    open var localDarkness: Int = 0
    open var enemies: MutableList<Enemy> = CopyOnWriteArrayList()
    open var corpses: MutableList<Enemy> = CopyOnWriteArrayList()

    @Transient
    open var fightingGroup: MutableList<Entity> = ArrayList()
    open var adventureRecap: AdventureRecap = AdventureRecap()

    @Transient
    @JvmField
    var terminationRequested: Boolean = false

    @Transient
    @JvmField
    var restartRequested: Boolean = false

    @Transient
    private var turnEndRequested: Boolean = false

    @Transient
    private var success: Double = 0.0

    @Transient
    private var failure: Double = 0.0

    @Transient
    private var totalProgress: Double = 0.0
    private var collectedExperienceIn24Hours: Double = 0.0

    @Transient
    private var animationInvalidationRequested: Boolean = false


    private fun getCurrentInstance(): Area = this

    open fun adventurersNumber(): Int = 4
    open fun completed(): Boolean = false
    open fun costToRefresh(): Int = 30

    /** Whether the player may spend gems to refill tries. Guild activities disallow this. */
    open fun canRefillWithGems(): Boolean = true

    /** Called when the player retreats from this area (default: no side effects). */
    open fun onRetreat() {
    }

    abstract fun getAreaType(): Int
    abstract fun getDarkness(): Int
    abstract fun getDetailDrawable(): Int
    abstract fun getLayout(): LayoutDungeonBinding
    abstract fun getName(): Int
    abstract fun getSummaryDrawable(): Int
    abstract fun listAreasUnlocked(): LinkedHashMap<Area, Int>
    abstract fun listEnemies(): List<Enemy>
    open fun magicDamageAmplification(): Double = 1.0
    protected abstract fun rollEnemies(): MutableList<Enemy>
    protected abstract fun searchRoom()
    protected abstract fun triggerEvent(str: String)

    open fun tick() {
        if (this.adventurersExploringIds.isEmpty()) {
            return
        }
        if (this.terminationRequested) {
            terminate()
            return
        }
        if (this.adventurersExploring.isEmpty() || this.restartRequested) {
            setupArea()
        }
        val curAction = this.action
        if (curAction == null) {
            resetAdventurers(true)
            this.action = Action(0)
            refreshHpBars()
            refreshActionDisplayed()
            refreshDialog()
            setupInitialDarkness()
        } else {
            curAction.nextTurn()
            this.adventureRecap.addSecondPassed()
        }
        val act = this.action
        if (act != null && act.finished()) {
            if (needsRealignment()) {
                realignToMain()
            }
            invertLogColor()
            try {
                performAction()
            } catch (e: Exception) {
                e.printStackTrace()
                if (MainActivity.headquartersFragment != null) {
                    MainActivity.headquartersFragment.activity?.finish()
                }
                System.exit(0)
            }
            refreshHpBars()
            refreshActionDisplayed()
        }
    }

    private fun needsRealignment(): Boolean {
        return try {
            val adventurer = this.adventurersExploring[0]
            val it2 = MainActivity.data.adventurers.iterator()
            while (it2.hasNext()) {
                val next = it2.next()
                if (next.id == adventurer.id) {
                    return adventurer !== next
                }
            }
            true
        } catch (unused: Exception) {
            false
        }
    }

    private fun realignToMain() {
        this.animationInvalidationRequested = true
        setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)
        refreshActionDisplayed()
        refreshAdventurers()
        refreshDialog()
    }

    private fun terminate() {
        this.adventurersExploringIds.clear()
        this.petExploringId = null
        this.adventurersExploring.clear()
        this.petExploring = null
        this.enemies.clear()
        this.corpses.clear()
        this.fightingGroup.clear()
        this.acting = null
        this.action = null
        this.turnsFighting = 0
        this.terminationRequested = false
        this.event = null
        if (this.progress < 250) {
            this.progress = 0
        }
        refreshActionDisplayed()
        refreshAdventurers()
    }

    private fun setupArea() {
        this.restartRequested = false
        this.enemies.clear()
        this.corpses.clear()
        this.fightingGroup.clear()
        this.acting = null
        this.action = null
        this.turnsFighting = 0
        this.event = null
        if (this.progress < 250 || getAreaType() != 0) {
            this.progress = 0
        }
        setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)
        refreshActionDisplayed()
        refreshAdventurers()
        refreshDialog()
    }

    open fun setupInitialDarkness() {
        val pet = this.petExploring
        var bright = pet?.bright ?: 0
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp > 0) {
                bright += adventurer.darknessReduction()
            }
        }
        this.localDarkness = Math.max(0, getDarkness() - bright)
    }

    open fun setupAdventurers(list: List<Adventurer>, list2: List<Pet>) {
        this.adventurersExploring = CopyOnWriteArrayList()
        for (num in this.adventurersExploringIds) {
            if (num != -100) {
                for (adventurer in list) {
                    if (adventurer.id == num) {
                        adventurer.minionBound = null
                        this.adventurersExploring.add(adventurer)
                        break
                    }
                }
            }
        }
        val petId = this.petExploringId
        if (petId != null) {
            for (pet in list2) {
                if (pet.id == petId) {
                    this.petExploring = pet
                }
            }
        }
    }

    private fun performAction() {
        val curAction = this.action ?: return
        when (curAction.type) {
            0 -> {
                triggerEvent("enter_dungeon")
                this.action = Action(1)
            }

            1 -> {
                if (getAreaType() != 0) {
                    incrementProgress()
                }
                enterRoom()
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true
                    }
                    Logger.log(this, 2)
                    this.action = Action(5)
                } else {
                    val listRollEnemies = rollEnemies()
                    this.enemies = listRollEnemies
                    if (listRollEnemies.isEmpty()) {
                        this.action = Action(if (getAreaType() != 0) 1 else 4)
                    } else {
                        for (enemy in this.enemies) {
                            enemy.getTrueClass()?.let { MainActivity.data.seenEnemies.add(it) }
                        }
                        triggerEvent("fight_start")
                        initializeFight()
                        this.action = Action(2)
                    }
                }
            }

            2 -> {
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true
                    }
                    Logger.log(this, 2)
                    this.action = Action(5)
                } else if (this.enemies.isEmpty()) {
                    Logger.log(this, 5)
                    triggerEvent("victory")
                    collectExperience()
                    this.action = Action(3)
                } else if (this.turnsFighting >= 400 && getAreaType() == 0) {
                    this.action = Action(6)
                } else {
                    val size = this.corpses.size
                    fightTurn()
                    petAttack()
                    petHeal()
                    petExecution()
                    petCast()
                    if (this.corpses.size - size >= 4) {
                        QuestsManager.increment(QuestsManager.tabulaRasa, 1L)
                    }
                    this.action = Action(2)
                }
            }

            3 -> {
                loot()
                this.action = Action(if (getAreaType() != 0) 1 else 4)
            }

            4 -> {
                searchRoom()
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true
                    }
                    Logger.log(this, 2)
                    this.action = Action(5)
                } else {
                    refreshLoot()
                    if (getAreaType() == 0) {
                        incrementProgress()
                    }
                    this.action = Action(1)
                }
            }

            5 -> {
                Logger.log(this, 4)
                respawn()
                if (this.progress < 250) {
                    this.progress = 0
                }
                triggerEvent("respawn")
                this.action = Action(1)
            }

            6 -> {
                Logger.log(this, 3)
                triggerEvent("flee")
                clearEnemies()
                this.action = Action(1)
            }
        }
        refreshDialog()
    }

    private fun logStatistics() {
        val i = this.progress
        if (i >= 100) {
            this.success += 1.0
        } else {
            this.failure += 1.0
        }
        this.totalProgress += i.toDouble()
        val printStream = System.out
        val sb = StringBuilder("Success rate is ")
        val d = this.success
        printStream.println(
            sb.append(d / (this.failure + d)).append("; average progress is ")
                .append(this.totalProgress / (this.success + this.failure)).toString()
        )
        System.out.print("team was killed by: ")
        for (enemy in this.enemies) {
            System.out.print(enemy.getTrueClass() + "; ")
        }
        this.progress = 0
    }

    private fun incrementProgress() {
        QuestsManager.increment(QuestsManager.longMarch, 1L)
        this.adventureRecap.addAreaCleared()
        val i = this.progress
        if (i >= 250) {
            return
        }
        val i2 = i + 1
        this.progress = i2
        if (this.maxProgress < i2) {
            this.maxProgress = i2
        }
        for ((key, iIntValue) in listAreasUnlocked()) {
            if (!key.isUnlocked) {
                Logger.log(this, 55, key.getName(), this.progress, iIntValue)
                if (this.progress >= iIntValue) {
                    UIUtils.unlockArea(key)
                    Logger.log(this, 56, key.getName())
                }
            }
        }
    }

    private fun resetAdventurers(z: Boolean) {
        for (adventurer in this.adventurersExploring) {
            adventurer.currentHp = adventurer.calculateTotalMaxHp()
            adventurer.currentShield = 0
            adventurer.positiveStatusEffects.clear()
            adventurer.negativeStatusEffects.clear()
            if (z) {
                adventurer.currentMana = 0
            }
        }
    }

    private fun clearEnemies() {
        this.enemies.clear()
        this.corpses.clear()
    }

    private fun respawn() {
        this.adventureRecap.addWipe()
        resetAdventurers(false)
        clearEnemies()
    }

    private fun enterRoom() {
        triggerEvent("enter_room")
        val pet = this.petExploring
        var bright = pet?.bright ?: 0
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp > 0) {
                resolveStatus(adventurer)
                if (adventurer.currentHp > 0) {
                    bright += adventurer.darknessReduction()
                    if (adventurer.isHealer()) {
                        val listSelectTargets = selectTargets(adventurer, TARGET_LOWEST_RELATIVE_ALLY)
                        if (listSelectTargets != null) {
                            val entity = listSelectTargets[0]
                            if (entity.currentHp < entity.calculateTotalMaxHp() || (adventurer.isCleanser() && entity.negativeStatusEffects.isNotEmpty())) {
                                heal(adventurer, listSelectTargets[0], null)
                            }
                        }
                    }
                    petHeal()
                }
            }
        }
        QuestsManager.incrementToValue(QuestsManager.lightBringer, bright.toLong())
        this.localDarkness = Math.max(0, getDarkness() - bright)
        refreshDarkness()
        Logger.log(this, 1, this.localDarkness)
    }

    private fun initializeFight() {
        this.turnsFighting = -1
        this.acting = null
        this.savedActingEntity = null
        this.corpses = CopyOnWriteArrayList()
        this.fightRarity = UIUtils.getFightRarity(this.enemies)
        this.fightingGroup = ArrayList()
        applyRadiantBlessing()
    }

    /** Holy Knight-branch units radiate Radiant Blessing to the whole party at battle start. */
    private fun applyRadiantBlessing() {
        // The aura lasts only 1 turn and is renewed every turn by renewRadiantBlessing()
        // while a Holy-branch unit is alive, so it cannot outlive a dead buffer.
        renewRadiantBlessing()
    }

    /** Renews the party Radiant Blessing (1 turn) or strips it when no aura-bearer is alive. */
    private fun renewRadiantBlessing() {
        var immunity = 0.0
        var flatDr = 0
        var regenPct = 0.0
        var undeadBonus = 0.0
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp <= 0) continue // dead bearers cannot sustain the aura
            when (adventurer.passiveSkill) {
                Skills.PASSIVE_AURA_OF_LIGHT_I -> {
                    immunity = maxOf(immunity, 0.10); undeadBonus = maxOf(undeadBonus, 0.05)
                }

                Skills.PASSIVE_AURA_OF_LIGHT_II -> {
                    immunity = maxOf(immunity, 0.15); undeadBonus = maxOf(undeadBonus, 0.10)
                }

                Skills.PASSIVE_AURA_OF_DEVOTION_I -> {
                    immunity = maxOf(immunity, 0.20); undeadBonus = maxOf(undeadBonus, 0.15); flatDr = maxOf(flatDr, 5)
                }

                Skills.PASSIVE_AURA_OF_DEVOTION_II -> {
                    immunity = maxOf(immunity, 0.30); undeadBonus = maxOf(undeadBonus, 0.20); flatDr = maxOf(flatDr, 8)
                }

                Skills.PASSIVE_AURA_OF_SANCTITY -> {
                    immunity = maxOf(immunity, 0.40); undeadBonus = maxOf(undeadBonus, 0.25); flatDr =
                        maxOf(flatDr, 10); regenPct = maxOf(regenPct, 0.03)
                }

                Skills.PASSIVE_AURA_OF_THE_SERAPHIM -> {
                    immunity = maxOf(immunity, 0.50); undeadBonus = maxOf(undeadBonus, 0.30); flatDr =
                        maxOf(flatDr, 15); regenPct = maxOf(regenPct, 0.05)
                }

                else -> {}
            }
        }
        for (adventurer in this.adventurersExploring) {
            adventurer.positiveStatusEffects.removeAll { it.type == StatusEffectType.RADIANT_BLESSING }
        }
        if (immunity <= 0.0 && flatDr <= 0 && regenPct <= 0.0 && undeadBonus <= 0.0) {
            return // no living aura-bearer: the buff expires
        }
        val blessing =
            StatusEffect(StatusEffectType.RADIANT_BLESSING, null, 1, 1.0, immunity, flatDr, regenPct, undeadBonus)
        for (adventurer in this.adventurersExploring) {
            adventurer.positiveStatusEffects.add(
                StatusEffect(
                    blessing.type,
                    blessing.cause,
                    blessing.turnsLeft,
                    blessing.probability,
                    blessing.immunity,
                    blessing.flatDr,
                    blessing.regenPct,
                    blessing.undeadDamageBonus
                )
            )
        }
    }

    /** Turn-start aura renewal + cleanses from Aura of Sanctity and Aura of the Seraphim. */
    private fun radiantBlessingCleanses() {
        renewRadiantBlessing()
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp <= 0) continue
            when (adventurer.passiveSkill) {
                Skills.PASSIVE_AURA_OF_SANCTITY -> {
                    val mostDebuffed = this.adventurersExploring.filter { it.currentHp > 0 }
                        .maxByOrNull { it.negativeStatusEffects.size }
                    if (mostDebuffed != null) {
                        cleanseOneNegative(mostDebuffed)
                    }
                }

                Skills.PASSIVE_AURA_OF_THE_SERAPHIM -> {
                    for (ally in this.adventurersExploring) {
                        if (ally.currentHp > 0) {
                            cleanseAllNegative(ally)
                        }
                    }
                }

                else -> {}
            }
        }
    }

    private fun decideTurnsOrder() {
        this.fightingGroup.clear()
        this.fightingGroup.addAll(this.adventurersExploring.filterNotNull())
        this.fightingGroup.addAll(this.enemies.filterNotNull())
        Utils.orderByTurnsPriority(this.fightingGroup)
    }

    private fun collectExperience() {
        var expGiven = 0.0
        for (enemy in this.corpses) {
            expGiven += enemy.getExpGiven().toDouble()
        }
        val aliveCount = adventurersAlive()
        if (aliveCount <= 0) return
        val dAdventurersAlive = expGiven / aliveCount.toDouble()
        val pet = this.petExploring
        val experience = if (pet != null) 1.0 + (pet.experience / 100.0) else 1.0
        var z = false
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp > 0 && !adventurer.isSummonedMinion()) {
                val dExperienceMultiplier = adventurer.experienceMultiplier() * experience
                val iRound = Utils.round(dAdventurersAlive * dExperienceMultiplier)
                if (dExperienceMultiplier >= 1.5) {
                    QuestsManager.increment(QuestsManager.fastLearner, 1L)
                }
                QuestsManager.increment(QuestsManager.student, iRound.toLong())
                val iAddExperience = adventurer.addExperience(iRound)
                this.adventureRecap.addExpEarned(iRound)
                Logger.log(this, 6, adventurer.getIdName(), iRound)
                if (iAddExperience > 0) {
                    for (i in 0 until iAddExperience) {
                        Logger.log(this, 7, adventurer.getIdName())
                    }
                    z = true
                }
            }
        }
        if (z && Utils.isMainLooper() && MainActivity.adventurersFragment != null) {
            MainActivity.adventurersFragment.refresh()
        }
    }

    private fun loot() {
        if (fullChest()) {
            Logger.log(this, 100, R.string.log_full_drops)
        } else {
            var z = true
            for (enemy in this.corpses) {
                val ev = this.event
                val itemWrapper2 = Utils.rollFromWeightedMap(enemy.listDrops(ev?.key ?: 0)) as? ItemWrapper
                val itemWrapper: ItemWrapper? =
                    if (this.petExploring == null || (itemWrapper2?.item != null && itemWrapper2.item!!.isNotSellable()) || Utils.random() >= this.petExploring!!.drops / 100.0) {
                        null
                    } else {
                        val ev2 = this.event
                        Utils.rollFromWeightedMap(enemy.listDrops(ev2?.key ?: 0)) as? ItemWrapper
                    }
                if (itemWrapper2 != null) {
                    val item = itemWrapper2.item
                    if (item != null) {
                        Utils.collectItem(item, this.drops)
                        Logger.log(this, 8, enemy.getIdName(), item.getStack(), item.getIdName())
                        if (MainActivity.data.tutorialStep == 2) {
                            MainActivity.data.tutorialStep = 3
                            if (Utils.isMainLooper() && MainActivity.dungeonsFragment != null) {
                                (MainActivity.dungeonsFragment.activity as? MainActivity)?.refreshTutorial()
                            }
                            this.event = null
                        }
                        z = false
                    }
                }
                if (itemWrapper != null) {
                    val item2 = itemWrapper.item
                    if (item2 != null) {
                        Utils.collectItem(item2, this.drops)
                        Logger.log(this, 8, enemy.getIdName(), item2.getStack(), item2.getIdName())
                        z = false
                    }
                }
                if (Utils.random() < 5.0e-4) {
                    val item3 = Item.getInstance("Geode")
                    if (item3 != null) {
                        Utils.collectItem(item3, this.drops)
                        Logger.log(this, 8, enemy.getIdName(), item3.getStack(), item3.getIdName())
                        z = false
                    }
                }
            }
            if (z) {
                Logger.log(this, 9)
            } else {
                refreshLoot()
            }
        }
        this.corpses.clear()
    }

    open fun collectItemFromGround(item: Item) {
        if (fullChest()) {
            Logger.log(this, 100, R.string.log_full_drops)
            return
        }
        Logger.log(this, 40, item.getStack(), item.getIdName())
        Utils.collectItem(item, this.drops)
        refreshLoot()
    }

    private fun fullChest(): Boolean {
        var stack = 0
        for (item in this.drops) {
            stack += item.getStack()
        }
        return stack >= getLootCap()
    }

    /** Effective dungeon loot-chest capacity.
     *  - Shop Deep-Pockets / legacy merchant pack (isMaxLootPackPurchased) grants exactly
     *    base 2,000 + 1,000 = 3,000 and is authoritative (a stale LOOTCAP cheat redeem must
     *    not silently keep the cap above the pack's intended value).
     *  - Without the pack, a LOOTCAP redeem (10..16000) still overrides the base cap.
     *  - Otherwise the vanilla cap (2,000) applies. */
    fun getLootCap(): Int {
        if (MainActivity.data.isMaxLootPack2Purchased) {
            return 4000
        }
        if (MainActivity.data.isMaxLootPackPurchased) {
            return 3000
        }
        val lootCap = MainActivity.data.lootCap
        if (lootCap > 0) {
            return lootCap
        }
        return 2000
    }

    private fun adventurersAlive(): Int {
        var i = 0
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp > 0 && !adventurer.isSummonedMinion()) {
                i++
            }
        }
        return i
    }

    private fun fightTurn() {
        this.turnEndRequested = false
        this.turnsFighting++
        radiantBlessingCleanses()
        selectNextActing()
        val curActing = this.acting ?: return
        val iResolveStatus = resolveStatus(curActing)
        if (curActing.currentHp <= 0 || iResolveStatus == 2) {
            return
        }
        val listSelectTargets: List<Entity>?
        if (if (iResolveStatus != 1) increaseMana(curActing) else false) {
            listSelectTargets = cast(curActing)
        } else if (curActing.isHealer()) {
            listSelectTargets = selectTargets(curActing, TARGET_LOWEST_RELATIVE_ALLY)
            if (listSelectTargets == null) {
                return
            } else {
                heal(curActing, listSelectTargets[0], null)
            }
        } else {
            listSelectTargets = selectTargets(curActing, attackTargetStrategy(curActing))
            if (listSelectTargets == null) {
                return
            } else {
                dealDamage(curActing, listSelectTargets[0], null, null)
            }
        }
        if (listSelectTargets == null || listSelectTargets.isEmpty() || this.turnEndRequested) {
            return
        }
        try {
            for (endOfTurnAction in curActing.endOfTurnActions()) {
                if (endOfTurnAction == EndOfTurnAction.STUN_SELF_NOT_CLEANSABLE) {
                    applyStatus(curActing, StatusEffect(StatusEffectType.STUN_NOT_CLEANSABLE, curActing, 1, 1.0), 0.0)
                } else if (endOfTurnAction == EndOfTurnAction.FALSE_LIFE) {
                    val chance = ((curActing as? Adventurer)?.doctrine?.falseLifeChance()?.toDouble() ?: 0.0) * 0.01
                    applyStatus(curActing, StatusEffect(StatusEffectType.FALSE_LIFE, curActing, 999, chance), 0.0)
                } else if (endOfTurnAction.shields) {
                    val listSelectTargets2 = selectTargets(curActing, TARGET_LOWEST_SHIELD_ALLY)
                    if (listSelectTargets2 != null) {
                        val entity4 = listSelectTargets2[0]
                        val currentShield = entity4.currentShield
                        entity4.currentShield = Math.min(
                            Utils.round(endOfTurnAction.damage.toDouble() * curActing.calculateHealingModifier()) + currentShield,
                            (entity4.calculateTotalMaxHp().toDouble() * 0.2).toInt()
                        )
                        val currentShield2 = entity4.currentShield - currentShield
                        if (currentShield2 > 0) {
                            Logger.log(this, Logger.BARD_SHIELD, curActing, entity4, currentShield2)
                        }
                        val eff = endOfTurnAction.effect
                        if (eff != null) {
                            applyStatus(
                                entity4,
                                StatusEffect(
                                    eff.type,
                                    curActing,
                                    eff.turnsLeft + curActing.getInspireExaltBonusTurns(),
                                    eff.probability
                                ),
                                0.0
                            )
                        }
                    }
                } else if (endOfTurnAction.procsOnMelee == null || endOfTurnAction.procsOnMelee != curActing.isRanged()) {
                    val listSelectTargets3 = selectTargets(curActing, attackTargetStrategy(curActing), endOfTurnAction.forceRange)
                    if (listSelectTargets3 != null) {
                        val entity6 = listSelectTargets3[0]
                        if (entity6.currentHp > 0) {
                            dealDamage(curActing, entity6, null, endOfTurnAction)
                        }
                    }
                }
            }
        } catch (unused: Exception) {
        }
    }

    private fun attackTargetStrategy(entity: Entity): String {
        var z = false
        val z2 =
            entity.passiveSkill == Skills.PASSIVE_CHAOTIC || entity.passiveSkill == Skills.PASSIVE_PRIMORDIAL_HUNGER
        if (this is LostLands && (entity.passiveSkill == Skills.PASSIVE_PREHISTORIC_AVIAN || entity.passiveSkill == Skills.PASSIVE_PREHISTORIC_COLOSSUS)) {
            val it2 = this.enemies.iterator()
            while (true) {
                if (!it2.hasNext()) {
                    z = true
                    break
                }
                if (it2.next().passiveSkill == Skills.PASSIVE_NATURAL_EMPATHY) {
                    break
                }
            }
        } else {
            z = z2
        }
        if (z) {
            return TARGET_RANDOM_EXCEPT_SELF
        }
        if (entity.passiveSkill == Skills.PASSIVE_DESPISE_WEAKNESS || entity.passiveSkill == Skills.PASSIVE_WICKED_APPETITE) {
            return TARGET_LOWEST_RELATIVE_ENEMY
        }
        return TARGET_RANDOM_ENEMY
    }

    private fun petAttack() {
        val pet = this.petExploring
        val curActing = this.acting
        if (pet == null || this.enemies.isEmpty() || curActing !is Adventurer || pet.fighter <= 0.0 || this.turnEndRequested) {
            return
        }
        val fighter = pet.fighter * ((curActing.livingCompanionBonusDamage.toDouble() * 0.01) + 1.0)
        val entitySelectPetTarget = selectPetTarget()
        if (entitySelectPetTarget != null) {
            val damage = Utils.round(Math.max(1.0, (0.9 * fighter) + (Utils.random() * fighter * 0.2)))
            Logger.log(
                this,
                105,
                R.string.log_damage_dealt,
                pet,
                entitySelectPetTarget,
                entitySelectPetTarget.applyDamage(damage.toDouble(), false, 0, 0.0)
            )
            checkDeath(entitySelectPetTarget)
            retaliate(null, entitySelectPetTarget, true, 0)
        }
    }

    private fun petHeal() {
        val pet = this.petExploring
        val curActing = this.acting
        if (pet == null || curActing !is Adventurer || pet.healer <= 0.0 || this.turnEndRequested) {
            return
        }
        val healer = pet.healer
        val entitySelectPetHealingTarget = selectPetHealingTarget()
        if (entitySelectPetHealingTarget == null || entitySelectPetHealingTarget.currentHp >= entitySelectPetHealingTarget.calculateTotalMaxHp()) {
            return
        }
        val iRound = Utils.round(Math.max(1.0, (0.9 * healer) + (Utils.random() * healer * 0.2)))
        val currentHp = entitySelectPetHealingTarget.currentHp
        val iMin = Math.min(entitySelectPetHealingTarget.calculateTotalMaxHp(), currentHp + iRound)
        entitySelectPetHealingTarget.currentHp = iMin
        QuestsManager.increment(QuestsManager.medic, (iMin - currentHp).toLong())
        Logger.log(this, Logger.LOG_PET_HEAL, pet, entitySelectPetHealingTarget, iRound)
    }

    private fun petExecution() {
        val pet = this.petExploring
        if (pet == null || pet.opportunist <= 0.0 || this.enemies.isEmpty()) {
            return
        }
        for (enemy in this.enemies) {
            if (enemy.currentHp > 0 && enemy.currentHp.toDouble() / enemy.calculateTotalMaxHp()
                    .toDouble() < pet.opportunist / 100.0
            ) {
                enemy.currentHp = 0
                Logger.log(this, 108, enemy, pet)
                checkDeath(enemy)
            }
        }
    }

    private fun petCast() {
        val curActing = this.acting
        val pet = this.petExploring
        if (curActing !is Adventurer || pet == null || pet.statusEffectChance <= 0.0 || this.turnEndRequested) {
            return
        }
        val dRandom = Utils.random()
        val statusEffectType: StatusEffectType
        var targetAdventurer: Adventurer? = null
        if (dRandom < EFFECT_PROBABILITY) {
            statusEffectType = StatusEffectType.TAUNT
            for (adventurer in this.adventurersExploring) {
                if (adventurer.currentHp > 0 && (targetAdventurer == null || adventurer.threat > targetAdventurer.threat)) {
                    targetAdventurer = adventurer
                }
            }
        } else if (dRandom < 0.2) {
            statusEffectType = StatusEffectType.DEFENSIVE_STANCE
        } else if (dRandom < 0.30000000000000004) {
            statusEffectType = StatusEffectType.STUN
        } else if (dRandom < 0.4) {
            statusEffectType = StatusEffectType.SILENCE
        } else if (dRandom < 0.5) {
            statusEffectType = StatusEffectType.ABLAZE
        } else if (dRandom < 0.6000000000000001) {
            statusEffectType = StatusEffectType.POISON
        } else if (dRandom < 0.7000000000000001) {
            statusEffectType = StatusEffectType.REGENERATION
        } else if (dRandom < 0.8) {
            statusEffectType = StatusEffectType.BLEED
        } else if (dRandom < 0.9) {
            statusEffectType = StatusEffectType.FROZEN
        } else {
            if (pet.statusEffectChance < 15.0) {
                statusEffectType = StatusEffectType.LESSER_CURSE
            } else if (pet.statusEffectChance < 30.0) {
                statusEffectType = StatusEffectType.CURSE
            } else {
                statusEffectType = StatusEffectType.GREATER_CURSE
            }
            for (adventurer in this.adventurersExploring) {
                if (adventurer.currentHp > 0 && (targetAdventurer == null || adventurer.calculateTotalIntelligence() > targetAdventurer.calculateTotalIntelligence())) {
                    targetAdventurer = adventurer
                }
            }
        }
        val statusEffect =
            StatusEffect(statusEffectType, targetAdventurer, pet.statusEffectTurns, pet.statusEffectChance / 100.0)
        val targetEntity: Entity
        val iAddStatusEffect: Int
        if (statusEffect.type?.negative == true) {
            if (this.enemies.isEmpty()) return
            targetEntity = this.enemies[(Utils.random() * this.enemies.size).toInt()]
            iAddStatusEffect = targetEntity.addStatusEffect(statusEffect, 0.0)
        } else {
            val list = ArrayList(this.adventurersExploring)
            list.removeAll { it.isSummonedMinion() || it.currentHp <= 0 }
            if (list.isEmpty()) return
            targetEntity = list[(Utils.random() * list.size).toInt()]
            iAddStatusEffect = targetEntity.addStatusEffect(statusEffect, 0.0)
        }
        if (iAddStatusEffect > 0) {
            if (iAddStatusEffect < 999) {
                Logger.log(this, 11, targetEntity, statusEffect.type, iAddStatusEffect)
            } else {
                Logger.log(this, 12, targetEntity, statusEffect.type)
            }
        }
    }

    private fun selectNextActing() {
        if (this.fightingGroup.isEmpty()) {
            decideTurnsOrder()
        }
        if (this.acting == null) {
            val num = this.savedActingEntity
            if (num != null && num <= this.fightingGroup.size - 1) {
                this.acting = this.fightingGroup[num]
            } else if (this.fightingGroup.isNotEmpty()) {
                this.acting = this.fightingGroup[this.fightingGroup.size - 1]
            }
            this.savedActingEntity = null
        }
        for (i in 1 until this.fightingGroup.size) {
            val iIndexOf = (this.fightingGroup.indexOf(this.acting) + i) % this.fightingGroup.size
            val entity = this.fightingGroup[iIndexOf]
            if (entity.currentHp > 0) {
                this.acting = entity
                this.savedActingEntity = iIndexOf
                return
            }
        }
    }

    private fun resolveStatus(entity: Entity): Int {
        val arrayList = ArrayList<StatusEffect>()
        arrayList.addAll(entity.positiveStatusEffects)
        arrayList.addAll(entity.negativeStatusEffects)
        val iCalculateTotalMaxHp = entity.calculateTotalMaxHp()
        var iCalculateTotalRegeneration = entity.calculateTotalRegeneration()
        val z3 = entity is Adventurer
        val pet = this.petExploring
        if (z3 && pet != null) {
            iCalculateTotalRegeneration += pet.regeneration
        }
        var iRound = iCalculateTotalRegeneration
        var z4 = false
        var damagePerTurnPerStatus = 0
        var i4 = 0

        for (statusEffect in arrayList) {
            val cause = statusEffect.cause
            if (statusEffect.turnsLeft <= 0 || (statusEffect.type == StatusEffectType.TAUNT && (cause == null || cause.currentHp <= 0))) {
                Logger.log(this, 10, entity, statusEffect.type)
                (if (statusEffect.type?.negative == true) entity.negativeStatusEffects else entity.positiveStatusEffects).remove(
                    statusEffect
                )
            } else {
                statusEffect.turnsLeft = statusEffect.turnsLeft - 1
                when (statusEffect.type) {
                    StatusEffectType.TAUNT -> {
                        Logger.log(this, 13, entity, statusEffect)
                    }

                    StatusEffectType.POISON -> {
                        Logger.log(this, 14, entity, statusEffect)
                    }

                    StatusEffectType.FROZEN -> {
                        val cause = statusEffect.cause
                        val freezeBonusDamage = cause?.freezeBonusDamage ?: 0
                        val pet2 = this.petExploring
                        val barrier = if (pet2 == null || !z3) 0 else pet2.barrier
                        val iApplyDamage = entity.applyDamage((freezeBonusDamage + 10).toDouble(), false, barrier, 0.0)
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, iApplyDamage.toLong())
                        }
                        Logger.log(this, 50, entity, statusEffect, iApplyDamage)
                        z4 = true
                    }

                    StatusEffectType.STUN, StatusEffectType.STUN_NOT_CLEANSABLE -> {
                        Logger.log(this, 15, entity, statusEffect)
                        i4 = 2
                    }

                    StatusEffectType.PETRIFY -> {
                        Logger.log(this, Logger.STATUS_PETRIFIED, entity, statusEffect)
                        i4 = 2
                    }

                    StatusEffectType.SILENCE -> {
                        Logger.log(this, 16, entity, statusEffect)
                        if (i4 != 2) {
                            i4 = 1
                        }
                    }

                    StatusEffectType.ABLAZE -> {
                        val cause2 = statusEffect.cause
                        val onFireBonusDamage = if (cause2 != null) cause2.onFireBonusDamage.toDouble() * 0.01 else 0.0
                        val dMagicDamageAmplification = magicDamageAmplification()
                        val pet3 = this.petExploring
                        val barrier = if (pet3 == null || !z3) 0 else pet3.barrier
                        val iApplyDamage2 = entity.applyDamage(
                            Utils.round((onFireBonusDamage + 0.05) * iCalculateTotalMaxHp.toDouble() * dMagicDamageAmplification)
                                .toDouble(), true, barrier, 0.0
                        )
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, iApplyDamage2.toLong())
                        }
                        Logger.log(this, 17, entity, statusEffect, iApplyDamage2)
                        z4 = true
                    }

                    StatusEffectType.BLOODFLAME -> {
                        // Same burn as Ablaze but without the on-fire bonus: exactly 5% of max HP
                        // as magic damage at the start of the unit's turn, boosted by the
                        // Bloodflame damage bonus of the unit that inflicted it.
                        // The bonus multiplies the 5% burn (e.g. +50% => 5% * 1.5 = 7.5% max HP).
                        val causeBloodflame = statusEffect.cause
                        val bloodflameDamageBonus =
                            if (causeBloodflame != null) causeBloodflame.getBloodflameDamageBonus()
                                .toDouble() * 0.01 else 0.0
                        val dMagicDamageAmplificationBlood = magicDamageAmplification()
                        val petBloodflame = this.petExploring
                        val barrierBloodflame = if (petBloodflame == null || !z3) 0 else petBloodflame.barrier
                        val iBloodflameDamage = entity.applyDamage(
                            Utils.round(0.05 * (1.0 + bloodflameDamageBonus) * iCalculateTotalMaxHp.toDouble() * dMagicDamageAmplificationBlood)
                                .toDouble(),
                            true,
                            barrierBloodflame,
                            0.0
                        )
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, iBloodflameDamage.toLong())
                        }
                        Logger.log(this, Logger.STATUS_BLOODFLAME, entity, statusEffect, iBloodflameDamage)
                        z4 = true
                    }

                    StatusEffectType.TERRIFY -> {
                        val dMagicDamageAmplification2 = magicDamageAmplification()
                        val pet4 = this.petExploring
                        val barrier = if (pet4 == null || !z3) 0 else pet4.barrier
                        val iApplyDamage3 = entity.applyDamage(
                            Utils.round(iCalculateTotalMaxHp.toDouble() * 0.2 * dMagicDamageAmplification2).toDouble(),
                            true,
                            barrier,
                            0.0
                        )
                        Logger.log(this, Logger.STATUS_TERRIFIED, entity, statusEffect, iApplyDamage3)
                        z4 = true
                        i4 = 2
                    }

                    StatusEffectType.REGENERATION -> {
                        if (!entity.hasBloodflame()) {
                            val cause3 = statusEffect.cause
                            val regenBonus =
                                if (cause3 != null) 0.06 + (cause3.regenerationBonus.toDouble() * 0.01) else 0.06
                            iRound += Utils.round(regenBonus * iCalculateTotalMaxHp.toDouble())
                            Logger.log(this, 18, entity, statusEffect)
                        }
                    }

                    StatusEffectType.RADIANT_BLESSING -> {
                        if (statusEffect.regenPct > 0.0) {
                            iRound += Utils.round(statusEffect.regenPct * iCalculateTotalMaxHp.toDouble())
                            Logger.log(this, 18, entity, statusEffect)
                        }
                    }

                    StatusEffectType.BLEED -> {
                        val turnsLeft = statusEffect.turnsLeft + 1
                        val petBleed = this.petExploring
                        val bloodcraveBonus = if (petBleed != null) petBleed.getBloodcrave() else 0.0
                        val bleedDamage =
                            if (bloodcraveBonus > 0.0) Utils.round(turnsLeft.toDouble() * (1.0 + bloodcraveBonus * 0.01)) else turnsLeft
                        entity.currentHp = Math.max(0, entity.currentHp - bleedDamage)
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, bleedDamage.toLong())
                        }
                        Logger.log(this, 19, entity, statusEffect, bleedDamage)
                        z4 = true
                        if (petBleed != null && petBleed.getLacerate() > 0.0 && Utils.random() < petBleed.getLacerate() / 100.0) {
                            // Lacerate: bleed deals damage one additional time without consuming an extra stack.
                            entity.currentHp = Math.max(0, entity.currentHp - bleedDamage)
                            Logger.log(this, Logger.STATUS_BLEED_LACERATE, entity, bleedDamage)
                        }
                    }

                    StatusEffectType.FEEBLE_TETHER -> {
                        if (entity.currentMana < 100) {
                            entity.currentHp = 0
                            entity.currentShield = 0
                            Logger.log(this, Logger.STATUS_FEEBLE_TETHER, entity)
                            z4 = true
                        }
                    }

                    else -> {
                    }
                }
                val cause = statusEffect.cause
                if (cause != null && cause.damagePerTurnPerStatus > 0 && statusEffect.type?.negative == true) {
                    damagePerTurnPerStatus += cause.damagePerTurnPerStatus
                }
            }
        }

        if (z3) {
            val adventurer = entity as Adventurer
            val iDecay = adventurer.decay()
            if (iDecay >= 1) {
                QuestsManager.increment(QuestsManager.fallingApart, iDecay.toLong())
                entity.currentHp = Math.max(0, entity.currentHp - iDecay)
                Logger.log(this, 20, adventurer, iDecay)
                z4 = true
            }
        }

        val z: Boolean
        if (damagePerTurnPerStatus > 0) {
            val dMagicDamageAmplification3 = magicDamageAmplification()
            val pet5 = this.petExploring
            val barrier = if (pet5 == null || !z3) 0 else pet5.barrier
            val applied =
                entity.applyDamage(damagePerTurnPerStatus.toDouble() * dMagicDamageAmplification3, true, barrier, 0.0)
            Logger.log(this, Logger.ARCANE_SUPPRESSION, entity, applied)
            z = true
        } else {
            z = z4
        }

        if (!entity.hasBloodflame() && iRound > 0 && entity.currentHp > 0 && entity.currentHp < iCalculateTotalMaxHp) {
            val currentHp = entity.currentHp
            val iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound)
            entity.currentHp = iMin
            if (z3) {
                QuestsManager.increment(QuestsManager.soothingRemedy, (iMin - currentHp).toLong())
            }
            Logger.log(this, 49, entity, iRound)
        }

        if (z) {
            checkDeath(entity)
        }

        if (entity.currentHp <= 0) {
            return 2
        }
        return i4
    }

    private fun increaseMana(entity: Entity): Boolean {
        if (entity.activeSkill != Skills.ACTIVE_NONE && entity.activeSkill != null) {
            if (entity.currentMana >= 100) {
                entity.currentMana = 0
                return true
            }
            entity.currentMana = Math.min(100, entity.currentMana + entity.calculateManaRegen())
        }
        return false
    }

    private fun dodge(entity: Entity, entity2: Entity, z: Boolean, z2: Boolean): Boolean {
        val dMax: Double
        if (!z2 && !entity.isFlying() && entity2.isFlying()) {
            Logger.log(this, 45, entity, entity2)
            return true
        }
        if (entity.isAlwaysHits() || entity2.negativeStatusEffects.contains(StatusEffect.STATIC_INSTANCE_FROZEN)) {
            dMax = 1.0
        } else {
            val stat1 = if (entity.isMagic()) entity.calculateTotalIntelligence()
                .toDouble() else entity.calculateTotalDexterity().toDouble()
            val stat2 = if (entity.isMagic()) entity2.calculateTotalIntelligence()
                .toDouble() else entity2.calculateTotalDexterity().toDouble()
            var hitChance = stat1 / ((stat2 / 5.0) + stat1)
            val entityIsEnemy = entity is Enemy
            val bothEnemies = entityIsEnemy && (entity2 is Enemy)
            if (this.localDarkness > 0 && !bothEnemies) {
                val isNightVision = if (entityIsEnemy) {
                    if (!(entity2 as Adventurer).isNightVision()) 1.0 else 0.0
                } else {
                    if ((entity as Adventurer).isNightVision()) 1.0 else 0.0
                }
                hitChance -= (this.localDarkness.toDouble() * 0.01) * (hitChance - isNightVision)
            }
            if (!entityIsEnemy && (entity as Adventurer).traitRare == Trait.FOCUSED) {
                hitChance += 0.25
            }
            dMax = Math.max(EFFECT_PROBABILITY, hitChance - entity2.calculateTotalFlatDodgeChance())
        }
        val z5 = Utils.random() > dMax
        if (z5) {
            if (z) {
                Logger.log(this, 21, entity, entity2, 100 - Utils.round(dMax * 100.0))
            } else {
                Logger.log(this, 22, entity2, 100 - Utils.round(dMax * 100.0))
            }
        }
        return z5
    }

    open fun heal(entity: Entity, entity2: Entity, skill: Skill?) {
        var dCalculateHealingModifier = entity.calculateHealingModifier() * (skill?.damageAmplification ?: 1.0)
        var dCalculateCriticalMultiplier = calculateCriticalMultiplier(entity, skill, 0.0)
        val z2 = entity is Adventurer
        val pet = this.petExploring
        // Kitsune Spirit Blessing (Semi/Senko 5th trait): multiplies the healing DEALT BY
        // ADVENTURERS in the party by (1 + level * 0.6%) — it boosts the party, not the pet itself.
        if (entity is Adventurer && pet != null && pet.getKitsuneBlessing() > 0.0) {
            dCalculateHealingModifier = dCalculateHealingModifier * (1.0 + pet.getKitsuneBlessing())
        }
        val z: Boolean
        if (!z2 || pet == null || dCalculateCriticalMultiplier <= 1.0 || pet.getSavage() <= 0.0 || Utils.random() >= pet.getSavage() / 100.0) {
            z = false
        } else {
            dCalculateCriticalMultiplier *= dCalculateCriticalMultiplier
            z = true
        }
        val increaseHealingAgainst = entity.increaseHealingAgainst
        if (increaseHealingAgainst != null && entity2.getTrueClass() == increaseHealingAgainst.key) {
            dCalculateHealingModifier *= increaseHealingAgainst.value
        }
        val iMax = Math.max(
            1,
            Utils.round(entity.rollAttackDamage() * dCalculateCriticalMultiplier * dCalculateHealingModifier * 0.5)
        )
        val currentHp = entity2.currentHp
        val iCalculateTotalMaxHp = entity2.calculateTotalMaxHp()
        if (!entity2.hasBloodflame()) {
            val iMin = Math.min(iCalculateTotalMaxHp, currentHp + iMax)
            entity2.currentHp = iMin
            if (z2) {
                QuestsManager.increment(QuestsManager.medic, (iMin - currentHp).toLong())
            }
            if (entity.getMaxOverheal() > 0) {
                val i2 = (iMax - iCalculateTotalMaxHp) + currentHp
                val overhealCap =
                    Utils.round(iCalculateTotalMaxHp.toDouble() * 0.01 * entity.getMaxOverheal().toDouble())
                entity2.currentShield =
                    Math.max(entity2.currentShield, Math.min(entity2.currentShield + Math.max(0, i2), overhealCap))
            }
        }
        val logTier = if (z) 2 else if (dCalculateCriticalMultiplier > 1.0) 1 else 0
        Logger.log(this, 24, logTier, entity, entity2, iMax)
        if (entity.isCleanser()) {
            if (entity is ChiefScientistAva) {
                for (se in entity2.negativeStatusEffects) {
                    Logger.log(this, 10, entity2, se.type)
                }
                entity2.negativeStatusEffects.clear()
            } else {
                var toRemove: StatusEffect? = null
                for (statusEffect2 in entity2.negativeStatusEffects) {
                    if (toRemove == null || toRemove.turnsLeft < statusEffect2.turnsLeft) {
                        toRemove = statusEffect2
                    }
                }
                if (toRemove != null) {
                    entity2.negativeStatusEffects.remove(toRemove)
                    Logger.log(this, 10, entity2, toRemove.type)
                }
            }
        }
        for (effect in entity.onTargetHitEffects()) {
            applyStatus(entity2, effect, entity.calculateIgnoreImmunityToStatus() * 0.01)
        }
        if (skill == null || skill.applyEffectOnDodge) {
            return
        }
        applyStatus(entity2, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01)
    }

    private fun calculateCriticalMultiplier(entity: Entity, skill: Skill?, d: Double): Double {
        if (Utils.random() >= entity.calculateCriticalChance()) {
            return 1.0
        }
        var dCalculateCriticalDamage = entity.calculateCriticalDamage()
        if (skill != null) {
            dCalculateCriticalDamage *= skill.criticalAmplification
        }
        if (d > 0.0) {
            dCalculateCriticalDamage -= (dCalculateCriticalDamage - 1.0) * d
        }
        if (entity is Adventurer) {
            QuestsManager.increment(QuestsManager.criticalHit, 1L)
            if (dCalculateCriticalDamage >= 2.5) {
                QuestsManager.increment(QuestsManager.pulverization, 1L)
            }
        }
        return dCalculateCriticalDamage
    }

    /** Holy Smite: strikes one enemy and heals the lowest-HP ally for a % of the damage dealt. */
    private fun holySmite(entity: Entity, amp: Double, healPct: Double): List<Entity>? {
        val targets = selectTargets(entity, TARGET_RANDOM_ENEMY) ?: return null
        val target = targets[0]
        if (target.currentHp <= 0) return targets
        Logger.log(this, 29, entity)
        val hpBefore = target.currentHp + target.currentShield
        dealDamage(entity, target, Skill(entity).setDamageAmplification(amp), null)
        val dealt = hpBefore - (target.currentHp + target.currentShield)
        if (dealt > 0 && healPct > 0) {
            radiantHealLowest(entity, Utils.round(dealt * healPct))
        }
        return targets
    }

    /** Heals the ally with the lowest HP by `amount`; the Seraphim aura converts overheal into a holy shield. */
    private fun radiantHealLowest(healer: Entity, amount: Int) {
        if (amount <= 0) return
        val lowest = selectTargets(healer, TARGET_LOWEST_RELATIVE_ALLY)?.firstOrNull() ?: return
        if (lowest.currentHp <= 0 || lowest.hasBloodflame() || lowest.currentHp >= lowest.calculateTotalMaxHp()) return
        val maxHp = lowest.calculateTotalMaxHp()
        val before = lowest.currentHp
        lowest.currentHp = Math.min(maxHp, before + amount)
        val healed = lowest.currentHp - before
        if (healed > 0) {
            if (healer is Adventurer) {
                QuestsManager.increment(QuestsManager.medic, healed.toLong())
            }
            Logger.log(this, 24, 0, healer, lowest, healed)
        }
        if (healer.passiveSkill == Skills.PASSIVE_AURA_OF_THE_SERAPHIM && lowest.currentHp >= maxHp) {
            val overheal = Math.max(0, amount - (maxHp - before))
            if (overheal > 0) {
                val shieldCap = Utils.round(maxHp.toDouble() * 0.25)
                lowest.currentShield = Math.min(shieldCap, lowest.currentShield + overheal)
            }
        }
    }

    /** Removes the (longest) negative status effect with one application. */
    private fun cleanseOneNegative(target: Entity) {
        var toRemove: StatusEffect? = null
        for (se in target.negativeStatusEffects) {
            if (toRemove == null || toRemove.turnsLeft < se.turnsLeft) {
                toRemove = se
            }
        }
        if (toRemove != null) {
            target.negativeStatusEffects.remove(toRemove)
            Logger.log(this, 10, target, toRemove.type)
        }
    }

    /** Removes every negative status effect from the target. */
    private fun cleanseAllNegative(target: Entity) {
        if (target.negativeStatusEffects.isEmpty()) return
        for (se in target.negativeStatusEffects) {
            Logger.log(this, 10, target, se.type)
        }
        target.negativeStatusEffects.clear()
    }

    /** Grants every living ally a holy shield worth `pct` of their Max HP. */
    private fun shieldAlliesByMaxHpPct(pct: Double) {
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp <= 0) continue
            val cap = Utils.round(adventurer.calculateTotalMaxHp().toDouble() * pct)
            if (adventurer.currentShield < cap) {
                adventurer.currentShield = cap
            }
        }
    }

    /** Heals every living, un-bloodflamed ally for `pct` of their own Max HP. */
    private fun healAlliesByMaxHpPct(healer: Entity, pct: Double) {
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp <= 0 || adventurer.hasBloodflame()) continue
            val maxHp = adventurer.calculateTotalMaxHp()
            val amount = Utils.round(maxHp.toDouble() * pct)
            if (amount <= 0) continue
            val before = adventurer.currentHp
            adventurer.currentHp = Math.min(maxHp, before + amount)
            val healed = adventurer.currentHp - before
            if (healed > 0) {
                if (healer is Adventurer) {
                    QuestsManager.increment(QuestsManager.medic, healed.toLong())
                }
                Logger.log(this, 24, 0, healer, adventurer, healed)
            }
        }
    }

    open fun applyStatus(entity: Entity?, statusEffect: StatusEffect?, d: Double) {
        if (statusEffect == null || entity == null) {
            return
        }
        if (entity.passiveSkill == Skills.PASSIVE_BEND_REALITY) {
            val type = statusEffect.type
            if (type == StatusEffectType.TAUNT || type == StatusEffectType.LESSER_CURSE || type == StatusEffectType.CURSE || type == StatusEffectType.GREATER_CURSE || type == StatusEffectType.OMINOUS_CURSE || type == StatusEffectType.ABHORRENT_CURSE) {
                return
            }
            applyStatus(statusEffect.cause, statusEffect, d)
            return
        }
        val appliedStatus = StatusEffect(
            statusEffect.type,
            statusEffect.cause,
            statusEffect.turnsLeft,
            statusEffect.probability,
            statusEffect.immunity,
            statusEffect.flatDr,
            statusEffect.regenPct,
            statusEffect.undeadDamageBonus
        )
        if (appliedStatus.type == StatusEffectType.BLEED && entity is Enemy) {
            val petSerrated = this.petExploring
            if (petSerrated != null && petSerrated.getSerrated() > 0.0 && Utils.random() < petSerrated.getSerrated() / 100.0) {
                // Serrated: inflict bleed twice (double the added stacks).
                appliedStatus.turnsLeft = appliedStatus.turnsLeft * 2
                val serratedInflicter = statusEffect.cause ?: entity
                Logger.log(this, Logger.STATUS_BLEED_SERRATED, serratedInflicter, entity, appliedStatus.turnsLeft)
            }
        }
        val iAddStatusEffect = entity.addStatusEffect(appliedStatus, d)
        if (iAddStatusEffect > 0) {
            if (entity is Enemy) {
                if (statusEffect.type == StatusEffectType.STUN) {
                    QuestsManager.increment(QuestsManager.shocking, 1L)
                }
                if (statusEffect.type == StatusEffectType.ABLAZE) {
                    QuestsManager.increment(QuestsManager.smokingHot, 1L)
                }
            }
            if (iAddStatusEffect < 999) {
                Logger.log(this, 11, entity, statusEffect.type, iAddStatusEffect)
            } else {
                Logger.log(this, 12, entity, statusEffect.type)
            }
        }
    }

    /**
     * Instant Elden Ring style blood-loss burst triggered right after Thousand Cuts
     * applies its Bleed stacks. Damage scales with the target's total Bleed stacks and
     * the party pet's Bloodcrave bonus; rolls the inflicter's crit (and the pet's Savage
     * tier) for Critical / Devastating hits. Bleed stacks are preserved.
     */
    private fun triggerHemorrhage(inflicter: Entity, target: Entity) {
        if (target.currentHp <= 0) return
        val stacks = target.getBleedStacks()
        if (stacks <= 0) return
        val petHem = this.petExploring
        val bloodcraveBonus = if (petHem != null) petHem.getBloodcrave() else 0.0
        val baseDamage = stacks.toDouble() * (1.0 + bloodcraveBonus * 0.01)
        val isCrit = Utils.random() * 100.0 < inflicter.calculateCriticalChance()
        val isSuperCrit =
            isCrit && petHem != null && petHem.getSavage() > 0.0 && Utils.random() < petHem.getSavage() / 100.0
        val critMultiplier = if (isSuperCrit) {
            val cd = inflicter.calculateCriticalDamage()
            cd * cd
        } else if (isCrit) {
            inflicter.calculateCriticalDamage()
        } else {
            1.0
        }
        val critTier = if (isSuperCrit) 2 else if (isCrit) 1 else 0
        val iHemorrhageDamage = target.applyDamage(baseDamage * critMultiplier, false, 0, 0.0)
        Logger.log(this, Logger.STATUS_HEMORRHAGE, target, iHemorrhageDamage, critTier)
    }

    open fun trapEncounter(i: Int, i2: Int, i3: Int, i4: Int, z: Boolean) {
        var d = 0.0
        var iCalculateTotalStat = 0
        Logger.log(this, 101, i)
        Logger.log(this, 25, i2, i3)
        val arrayList = ArrayList(this.adventurersExploring)
        arrayList.sortWith(compareByDescending { it.isSaboteur() })
        for (adventurer in arrayList) {
            if (adventurer.currentHp > 0) {
                if (adventurer.isSaboteur()) {
                    iCalculateTotalStat = adventurer.calculateTotalDexterity()
                } else if (i2 == R.string.constitution) {
                    iCalculateTotalStat = adventurer.calculateTotalConstitution()
                } else if (i2 == R.string.dexterity) {
                    iCalculateTotalStat = adventurer.calculateTotalDexterity()
                } else if (i2 == R.string.intelligence) {
                    iCalculateTotalStat = adventurer.calculateTotalIntelligence()
                } else {
                    d = 0.0
                }
                d = iCalculateTotalStat.toDouble()
                val d4 = i3.toDouble()
                var d2 = d4 / (d + d4)
                if (this.localDarkness > 0 && !adventurer.isNightVision()) {
                    d2 -= (this.localDarkness.toDouble() * 0.01) * (d2 - 1.0)
                }
                val d3 = d2
                if (Utils.random() > d3) {
                    QuestsManager.increment(QuestsManager.itsATrap, 1L)
                    Logger.log(this, 26, adventurer, 100 - Utils.round(d3 * 100.0))
                    if (adventurer.isSaboteur()) {
                        Logger.log(this, 28, adventurer)
                        return
                    }
                } else {
                    val pet = this.petExploring
                    val barrier = pet?.barrier ?: 0
                    val dmgMult = if (z) magicDamageAmplification() else 1.0
                    val appliedDmg =
                        adventurer.applyDamage(Utils.round(dmgMult * i4.toDouble()).toDouble(), z, barrier, 0.0)
                    Logger.log(this, 27, adventurer, appliedDmg, 100 - (d3 * 100.0).toInt())
                    checkDeath(adventurer)
                }
            }
        }
    }

    open fun cast(entity: Entity): List<Entity>? {
        if (entity is Adventurer && magicDamageAmplification() >= 1.6) {
            QuestsManager.increment(QuestsManager.laroxianPower, 1L)
        }
        val skill = Skill(entity)
        return when (entity.activeSkill) {
            Skills.ACTIVE_MIGHTY_STRIKE -> skill.setDamageAmplification(2.0).execute()
            Skills.ACTIVE_CRUSHING_STRIKE -> skill.setDamageAmplification(2.5).execute()
            Skills.ACTIVE_TAUNT_I -> skill.setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 2, 1.0))
                .applyEffectOnDodge().setDamageAmplification(2.0).execute()

            Skills.ACTIVE_TAUNT_II -> skill.setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 4, 1.0))
                .applyEffectOnDodge().setDamageAmplification(2.0).execute()

            Skills.ACTIVE_TAUNT_III -> skill.setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 8, 1.0))
                .applyEffectOnDodge().setDamageAmplification(2.0).execute()

            Skills.ACTIVE_TAUNT_IV -> skill.setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 8, 1.0))
                .applyEffectOnDodge().setDamageAmplification(6.0).execute()

            Skills.ACTIVE_EN_GARDE -> {
                val stance = StatusEffect(StatusEffectType.DEFENSIVE_STANCE, entity, 999, 1.0)
                applyStatus(entity, stance, 0.0)
                skill.setDamageAmplification(2.0).execute()
            }

            Skills.ACTIVE_OVERWHELM -> skill.setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 0.7))
                .setDamageAmplification(3.0).execute()

            Skills.ACTIVE_DECIMATE_I -> {
                // Deals damage + STUN (70%) via the skill status, then afflicts Bloodflame for 1 turn.
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 0.7)).setDamageAmplification(3.0)
                    .execute()
                if (targets != null) {
                    for (target in targets) {
                        applyStatus(
                            target,
                            StatusEffect(StatusEffectType.BLOODFLAME, entity, 1, 1.0),
                            entity.calculateIgnoreImmunityToStatus() * 0.01
                        )
                    }
                }
                targets
            }

            Skills.ACTIVE_DECIMATE_II -> {
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)).setDamageAmplification(3.0)
                    .execute()
                if (targets != null) {
                    for (target in targets) {
                        applyStatus(
                            target,
                            StatusEffect(StatusEffectType.BLOODFLAME, entity, 1, 1.0),
                            entity.calculateIgnoreImmunityToStatus() * 0.01
                        )
                    }
                }
                targets
            }

            Skills.ACTIVE_DECIMATE_III -> {
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)).setDamageAmplification(4.0)
                    .execute()
                if (targets != null) {
                    for (target in targets) {
                        applyStatus(
                            target,
                            StatusEffect(StatusEffectType.BLOODFLAME, entity, 1, 1.0),
                            entity.calculateIgnoreImmunityToStatus() * 0.01
                        )
                    }
                }
                targets
            }

            Skills.ACTIVE_CONDEMN -> skill.setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0))
                .applyEffectOnDodge().setDamageAmplification(2.5).execute()

            Skills.ACTIVE_CONDEMN_ALL_I -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0)).applyEffectOnDodge()
                .setDamageAmplification(2.5).execute()

            Skills.ACTIVE_CONDEMN_ALL_II -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 2, 1.0)).applyEffectOnDodge()
                .setDamageAmplification(2.5).execute()

            Skills.ACTIVE_HOLY_SMITE_I -> holySmite(entity, 2.0, 0.50)
            Skills.ACTIVE_HOLY_SMITE_II -> holySmite(entity, 2.2, 0.60)
            Skills.ACTIVE_RADIANT_JUDGMENT_I -> {
                val targets =
                    skill.setTargetSelectionMode("all_enemies").setDamageAmplification(2.2).setForceMagic(true)
                        .setUndeadDamageMultiplier(1.5).execute()
                for (ally in this.adventurersExploring) {
                    if (ally.currentHp > 0) cleanseOneNegative(ally)
                }
                healAlliesByMaxHpPct(entity, 0.15)
                targets
            }

            Skills.ACTIVE_RADIANT_JUDGMENT_II -> {
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0)).applyEffectOnDodge()
                    .setDamageAmplification(2.4).setForceMagic(true).setUndeadDamageMultiplier(1.5).execute()
                for (ally in this.adventurersExploring) {
                    if (ally.currentHp > 0) cleanseOneNegative(ally)
                }
                shieldAlliesByMaxHpPct(0.15)
                targets
            }

            Skills.ACTIVE_WRATH_OF_HEAVEN_I -> {
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0)).applyEffectOnDodge()
                    .setDamageAmplification(2.5).setForceMagic(true).setUndeadDamageMultiplier(1.5).execute()
                for (ally in this.adventurersExploring) {
                    if (ally.currentHp > 0) cleanseAllNegative(ally)
                }
                shieldAlliesByMaxHpPct(0.20)
                targets
            }

            Skills.ACTIVE_WRATH_OF_HEAVEN_II -> {
                val targets = skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 2, 1.0)).applyEffectOnDodge()
                    .setDamageAmplification(2.8).setForceMagic(true).setUndeadDamageMultiplier(1.5).execute()
                for (ally in this.adventurersExploring) {
                    if (ally.currentHp > 0) cleanseAllNegative(ally)
                }
                shieldAlliesByMaxHpPct(0.25)
                targets
            }

            Skills.ACTIVE_BARRAGE_I -> skill.setTargetSelectionMode("2").execute()
            Skills.ACTIVE_BARRAGE_II -> {
                var hasFeebleTether = false
                if (entity.getTrueClass() == "EldritchAlchemist") {
                    for (se in entity.positiveStatusEffects) {
                        if (se.type == StatusEffectType.FEEBLE_TETHER) {
                            hasFeebleTether = true
                            break
                        }
                    }
                }
                val damageAmp = if (hasFeebleTether) 10.0 else 1.0
                skill.setTargetSelectionMode("3").setDamageAmplification(damageAmp).execute()
            }

            Skills.ACTIVE_BARRAGE_III -> skill.setTargetSelectionMode("4").execute()
            Skills.ACTIVE_BARRAGE_IV -> skill.setTargetSelectionMode("5").execute()
            Skills.ACTIVE_BARRAGE_V -> skill.setTargetSelectionMode("6").execute()
            Skills.ACTIVE_BARRAGE_VI -> skill.setTargetSelectionMode("7").execute()
            Skills.ACTIVE_BARRAGE_VII -> skill.setTargetSelectionMode("9").execute()
            Skills.ACTIVE_BARRAGE_VIII -> skill.setTargetSelectionMode("11").execute()
            Skills.ACTIVE_FOCUSED_BARRAGE -> {
                skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5).execute()
                skill.noLog().execute()
            }

            Skills.ACTIVE_INCINERATE -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0)).applyEffectOnDodge()
                .setDamageAmplification(2.0).setForceRange(true).execute()

            Skills.ACTIVE_INCINERATE_II -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0)).applyEffectOnDodge()
                .setDamageAmplification(3.0).setForceRange(true).execute()

            Skills.ACTIVE_SUBLIMATE -> {
                skill.setTargetSelectionMode("all_enemies")
                    .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0)).applyEffectOnDodge()
                    .setDamageAmplification(1.7).setForceRange(true).execute()
                skill.setStatusEffect(StatusEffect(StatusEffectType.FROZEN, entity, 2, 1.0)).setDamageAmplification(1.7)
                    .noLog().execute()
            }

            Skills.ACTIVE_BACKSTAB_I -> skill.setCriticalAmplification(1.5).execute()
            Skills.ACTIVE_BACKSTAB_II -> skill.setCriticalAmplification(2.0).execute()
            Skills.ACTIVE_BACKSTAB_III -> skill.setCriticalAmplification(3.0).execute()
            Skills.ACTIVE_UMBRAL_STRIKE_I -> skill.setCriticalAmplification(1.5).setDamageAmplification(3.0).execute()
            Skills.ACTIVE_UMBRAL_STRIKE_II -> skill.setCriticalAmplification(1.5).setDamageAmplification(3.0).execute()
            Skills.ACTIVE_UMBRAL_STRIKE_III -> skill.setCriticalAmplification(2.0).setDamageAmplification(3.0).execute()
            Skills.ACTIVE_ECLIPSE_I -> skill.setTargetSelectionMode("lowest_absolute_enemy")
                .setCriticalAmplification(3.0).recastOnKill().execute()

            Skills.ACTIVE_ECLIPSE_II -> skill.setTargetSelectionMode("lowest_relative_enemy")
                .setCriticalAmplification(3.0).setExecutionThreshold(0.1).recastOnKill().execute()

            Skills.ACTIVE_ECLIPSE_III -> skill.setTargetSelectionMode("lowest_relative_enemy")
                .setCriticalAmplification(3.0).setExecutionThreshold(0.2).recastOnKill().execute()

            Skills.ACTIVE_ECLIPSE_IV -> skill.setTargetSelectionMode("lowest_relative_enemy")
                .setCriticalAmplification(3.0).setExecutionThreshold(0.25).recastOnKill().execute()

            Skills.ACTIVE_FEINT -> skill.setTargetSelectionMode("random_enemy").setCriticalAmplification(1.5)
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)).execute()

            Skills.ACTIVE_PETRIFYING_MELODY -> skill.setTargetSelectionMode("random_enemy")
                .setCriticalAmplification(1.5).setForceRange(true)
                .setStatusEffect(StatusEffect(StatusEffectType.PETRIFY, entity, 1, 1.0)).execute()

            Skills.ACTIVE_THOUSAND_CUTS -> skill.setStatusEffect(StatusEffect(StatusEffectType.BLEED, entity, 0, 1.0))
                .setCriticalAmplification(3.0).execute()

            Skills.ACTIVE_THOUSAND_CUTS_II -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.BLEED,
                    entity,
                    0,
                    1.0
                )
            ).setCriticalAmplification(3.0).execute()

            Skills.ACTIVE_ENERGY_BURST_I -> skill.setDamageAmplification(1.5).setForceRange(true).execute()
            Skills.ACTIVE_ENERGY_BURST_II -> skill.setDamageAmplification(2.0).setForceRange(true).execute()
            Skills.ACTIVE_FIRE_BURST -> skill.setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0))
                .setForceRange(true).setDamageAmplification(2.0).execute()

            Skills.ACTIVE_FIREBALL -> skill.setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0))
                .setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.0).execute()

            Skills.ACTIVE_METEOR_I -> skill.setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0))
                .setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.3).execute()

            Skills.ACTIVE_METEOR_II -> skill.setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 2, 1.0))
                .setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.3).execute()

            Skills.ACTIVE_HEAL -> skill.setTargetSelectionMode("lowest_relative_ally").healing()
                .setDamageAmplification(2.0).execute()

            Skills.ACTIVE_MASS_HEAL_I -> skill.setTargetSelectionMode("all_allies").healing()
                .setDamageAmplification(2.0).execute()

            Skills.ACTIVE_MASS_HEAL_II -> skill.setTargetSelectionMode("all_allies").healing()
                .setStatusEffect(StatusEffect(StatusEffectType.REGENERATION, entity, 2, 1.0))
                .setDamageAmplification(2.0).execute()

            Skills.ACTIVE_MASS_HEAL_III -> skill.setTargetSelectionMode("all_allies").healing()
                .setStatusEffect(StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0))
                .setDamageAmplification(2.3).execute()

            Skills.ACTIVE_RESTORATION_I -> skill.setTargetSelectionMode("all_allies").healing()
                .setStatusEffect(StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0))
                .setDamageAmplification(2.3).setReviveProbability(0.04).execute()

            Skills.ACTIVE_RESTORATION_II -> skill.setTargetSelectionMode("all_allies").healing()
                .setStatusEffect(StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0))
                .setDamageAmplification(2.6).setReviveProbability(0.06).execute()

            Skills.ACTIVE_CURSE_I -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.LESSER_CURSE,
                    entity,
                    999,
                    1.0
                )
            ).setDamageAmplification(3.0).execute()

            Skills.ACTIVE_CURSE_II -> skill.setStatusEffect(StatusEffect(StatusEffectType.CURSE, entity, 999, 1.0))
                .setDamageAmplification(3.25).execute()

            Skills.ACTIVE_CURSE_III -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.GREATER_CURSE,
                    entity,
                    999,
                    1.0
                )
            ).setDamageAmplification(3.5).execute()

            Skills.ACTIVE_CURSE_IV -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.OMINOUS_CURSE,
                    entity,
                    999,
                    1.0
                )
            ).setDamageAmplification(3.75).execute()

            Skills.ACTIVE_CURSE_V -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.ABHORRENT_CURSE,
                    entity,
                    999,
                    1.0
                )
            ).setDamageAmplification(4.0).execute()

            Skills.ACTIVE_FLAY -> skill.setTargetSelectionMode("random_except_self").setDamageAmplification(10.0)
                .setForceRange(false).execute()

            Skills.ACTIVE_ANNIHILATE -> skill.setTargetSelectionMode("all_except_self").setDamageAmplification(10.0)
                .setForceRange(false).execute()

            Skills.ACTIVE_OBLITERATE -> skill.setTargetSelectionMode("all_except_self").setDamageAmplification(20.0)
                .setForceRange(false).execute()

            Skills.ACTIVE_EXTIRPATE -> skill.setTargetSelectionMode("all_except_self").setDamageAmplification(30.0)
                .setForceRange(false).execute()

            Skills.ACTIVE_WHIP_AND_TEAR -> {
                skill.setTargetSelectionMode("all_except_self").setDamageAmplification(30.0).setForceRange(false)
                    .execute()
                skill.setTargetSelectionMode("random_except_self").setForceRange(true).noLog().execute()
            }

            Skills.ACTIVE_STOMP -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)).execute()

            Skills.ACTIVE_ESCAPE -> {
                enemies.remove(entity)
                fightingGroup.remove(entity)
                Logger.log(this, 43, entity.getIdName())
                null
            }

            Skills.ACTIVE_SOOTHING_WINDS -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 3, 0.6)).applyEffectOnDodge().execute()

            Skills.ACTIVE_QUICKSAND_GRASP -> skill.setStatusEffect(
                StatusEffect(
                    StatusEffectType.SILENCE,
                    entity,
                    4,
                    1.0
                )
            ).setDamageAmplification(2.0).execute()

            Skills.ACTIVE_SANDSTORM -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 5, 0.8)).setDamageAmplification(0.5)
                .applyEffectOnDodge().execute()

            Skills.ACTIVE_RESTORE_ORDER -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.9)
                .execute()

            Skills.ACTIVE_PROTECT_THE_WEAK -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 2, 1.0)).setDamageAmplification(0.1)
                .applyEffectOnDodge().execute()

            Skills.ACTIVE_STATIC_SURGE -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 0.5)).setDamageAmplification(2.5)
                .execute()

            Skills.ACTIVE_ARCANE_STRIKE -> skill.setDamageAmplification(4.0).execute()
            Skills.ACTIVE_FLINTLOCK_SHOT -> skill.setDamageAmplification(2.0).setForceRange(true)
                .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0)).execute()

            Skills.ACTIVE_ICE_TOMB -> skill.setStatusEffect(StatusEffect(StatusEffectType.FROZEN, entity, 20, 1.0))
                .setDamageAmplification(10.0).execute()

            Skills.ACTIVE_FROZEN_BREATH -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.FROZEN, entity, 2, 1.0)).execute()

            Skills.ACTIVE_ARCANE_BARRAGE -> skill.setTargetSelectionMode("12").execute()
            Skills.ACTIVE_DESERT_JUDGEMENT -> skill.setTargetSelectionMode("4").setDamageAmplification(1.5).execute()
            Skills.ACTIVE_DISEMBODY -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(1111.0)
                .setCriticalAmplification(0.66).execute()

            Skills.ACTIVE_PANDEMONIUM -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.75)
                .setCriticalAmplification(0.66).execute()

            Skills.ACTIVE_FRAGMENTATION -> {
                entity.currentHp = Math.max(1, entity.currentHp - 5000)
                Logger.log(this, 101, R.string.log_the_cultist_rebels_fragmentation)
                skill.setTargetSelectionMode("5").setForceRange(true).execute()
            }

            Skills.ACTIVE_ARCANE_DIFFUSION -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.4)
                .execute()

            Skills.ACTIVE_SACRIFICE -> skill.setDamageAmplification(100.0).setCriticalAmplification(0.66).execute()
            Skills.ACTIVE_CHOKING_POWDER -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.4)
                .setStatusEffect(StatusEffect(StatusEffectType.SILENCE, entity, 3, 1.0)).applyEffectOnDodge().execute()

            Skills.ACTIVE_DAZE -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.1)
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 2, 1.0)).execute()

            Skills.ACTIVE_FLEECE -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.35)
                .setStatusEffect(StatusEffect(StatusEffectType.BLEED, entity, 40, 1.0)).execute()

            Skills.ACTIVE_DISASSEMBLE -> skill.setTargetSelectionMode("all_enemies")
                .setStatusEffect(StatusEffect(StatusEffectType.TAUNT, entity, 5, 1.0)).setDamageAmplification(0.1)
                .applyEffectOnDodge().execute()

            Skills.ACTIVE_OVERDRIVE -> {
                var magicArmor: Enemy? = null
                for (e in enemies) {
                    if (e is it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.MagicArmor) {
                        magicArmor = e
                        break
                    }
                }
                if (magicArmor == null) {
                    null
                } else {
                    magicArmor.currentHp = Math.max(1, magicArmor.currentHp - 300)
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_overdrive)
                    val stun = StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)
                    skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.7).setStatusEffect(stun)
                        .execute()
                }
            }

            Skills.ACTIVE_RAYS_OF_DESTRUCTION -> skill.setTargetSelectionMode("8").setDamageAmplification(0.4).execute()
            Skills.ACTIVE_THE_TEN_HELLS -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(100000.0)
                .setCriticalAmplification(0.66).execute()

            Skills.ACTIVE_INSTILL_TERROR -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.15)
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 1, 1.0)).applyEffectOnDodge().execute()

            Skills.ACTIVE_FIRE_DANCE -> {
                Logger.log(this, 29, entity)
                if (event == null) {
                    event = Event("summon_smoldering_titan")
                }
                val curProgress = event!!.progress
                val progress = Math.min(100, curProgress + 1 + (Utils.random() * 5.0).toInt())
                event!!.progress = progress
                val ablaze = StatusEffect(StatusEffectType.ABLAZE, acting, 3, 1.0)
                applyStatus(entity, ablaze, 0.0)
                Logger.log(this, 113, event!!.progress)
                null
            }

            Skills.ACTIVE_BOTCHED_SACRIFICE -> {
                Logger.log(this, 115, entity)
                null
            }

            Skills.ACTIVE_DREAM_FORGE -> {
                val newHp = Math.min(entity.calculateTotalMaxHp(), entity.currentHp + 10000)
                entity.currentHp = newHp
                Logger.log(this, 24, 0, entity, entity, 10000)
                skill.setTargetSelectionMode("10").setDamageAmplification(2.0).execute()
            }

            Skills.ACTIVE_GRAVITY_SHIFT -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5)
                .execute()

            Skills.ACTIVE_SMASH -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5).execute()
            Skills.ACTIVE_LIGHTS_OUT -> skill.setTargetSelectionMode("lowest_relative_enemy")
                .setDamageAmplification(10.0).execute()

            Skills.ACTIVE_LIVE_TEST -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.05)
                .setStatusEffect(StatusEffect(StatusEffectType.POISON, entity, 3, 1.0)).applyEffectOnDodge().execute()

            Skills.ACTIVE_AT_THE_STAKE -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.2)
                .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 4, 1.0)).execute()

            Skills.ACTIVE_TABULA_RASA -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5)
                .setStatusEffect(StatusEffect(StatusEffectType.ABLAZE, entity, 2, 1.0)).execute()

            Skills.ACTIVE_BOUNCE -> skill.setTargetSelectionMode("10").setDamageAmplification(0.5)
                .setStatusEffect(StatusEffect(StatusEffectType.STUN, entity, 4, 1.0)).execute()

            Skills.ACTIVE_DEVOUR_SPIRIT -> skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.2)
                .setStatusEffect(StatusEffect(StatusEffectType.TERRIFY, entity, 1, 1.0)).execute()

            Skills.ACTIVE_EXECUTION_ORDER -> skill.setTargetSelectionMode("lowest_relative_enemy")
                .setExecutionThreshold(0.5).execute()

            else -> null
        }
    }

    inner class Skill(val caster: Entity) {
        var targetSelectionMode: String = TARGET_RANDOM_ENEMY
        var criticalAmplification: Double = 1.0
        var healing: Boolean = false
        var statusEffect: StatusEffect? = null
        var applyEffectOnDodge: Boolean = false
        var damageAmplification: Double = 1.0
        var forceRange: Boolean? = null
        var forceMagic: Boolean? = null
        var undeadDamageMultiplier: Double = 1.0
        var executionThreshold: Double = 0.0
        var recastOnKill: Boolean = false
        var noLog: Boolean = false
        var reviveProbability: Double = 0.0

        fun setTargetSelectionMode(str: String): Skill {
            this.targetSelectionMode = str
            return this
        }

        fun setCriticalAmplification(d: Double): Skill {
            this.criticalAmplification = d
            return this
        }

        fun healing(): Skill {
            this.healing = true
            return this
        }

        fun setStatusEffect(statusEffect: StatusEffect?): Skill {
            this.statusEffect = statusEffect
            return this
        }

        fun applyEffectOnDodge(): Skill {
            this.applyEffectOnDodge = true
            return this
        }

        fun setDamageAmplification(d: Double): Skill {
            this.damageAmplification = d
            return this
        }

        fun setForceRange(bool: Boolean?): Skill {
            this.forceRange = bool
            return this
        }

        fun setForceMagic(bool: Boolean?): Skill {
            this.forceMagic = bool
            return this
        }

        fun setUndeadDamageMultiplier(mult: Double): Skill {
            this.undeadDamageMultiplier = mult
            return this
        }

        fun setExecutionThreshold(d: Double): Skill {
            this.executionThreshold = d
            return this
        }

        fun recastOnKill(): Skill {
            this.recastOnKill = true
            return this
        }

        fun noLog(): Skill {
            this.noLog = true
            return this
        }

        fun setReviveProbability(d: Double): Skill {
            this.reviveProbability = d
            return this
        }

        fun execute(): List<Entity>? {
            val listSelectTargets = selectTargets(this.caster, this.targetSelectionMode, this.forceRange) ?: return null
            if (!this.noLog) {
                if (this.caster is Adventurer && !this.healing) {
                    QuestsManager.increment(QuestsManager.tormentor, 1L)
                }
                Logger.log(this@Area, 29, this.caster)
            }
            for (entity in listSelectTargets) {
                var target: Entity? = entity
                val bonusResurrectChance = this.reviveProbability + (this.caster.bonusResurrectChance.toDouble() * 0.01)
                if (this.healing && target != null && target.currentHp <= 0 && Utils.random() < bonusResurrectChance) {
                    target.currentHp = 1
                    if (this.caster is Adventurer) {
                        QuestsManager.increment(QuestsManager.miracle, 1L)
                    }
                    Logger.log(this@Area, 30, target, this.caster)
                }
                if (!this.healing && target != null && target.currentHp <= 0) {
                    target = selectEnemyTarget(this.caster, this.forceRange)
                }
                if (target == null || target.currentHp <= 0) {
                    if (!this.healing) {
                        break
                    } else {
                        continue
                    }
                }
                if (this.applyEffectOnDodge) {
                    applyStatus(target, this.statusEffect, this.caster.calculateIgnoreImmunityToStatus() * 0.01)
                }
                if (this.healing) {
                    heal(this.caster, target, this)
                } else {
                    dealDamage(this.caster, target, this, null)
                }
                if (this.recastOnKill && target.currentHp <= 0 && this.caster.currentHp > 0) {
                    cast(this.caster)
                }
            }
            return listSelectTargets
        }
    }

    /**
     * Angel of War branch: share of enemy AoE damage this passive's bearer intercepts
     * for same-row allies (Shared Burden). 0 = no interception.
     */
    private fun getAoeDamageInterceptionPct(passiveSkill: Skills?): Double {
        return when (passiveSkill) {
            Skills.PASSIVE_AURA_OF_LIGHT_I -> 0.10
            Skills.PASSIVE_AURA_OF_LIGHT_II -> 0.15
            Skills.PASSIVE_AURA_OF_DEVOTION_I -> 0.20
            Skills.PASSIVE_AURA_OF_DEVOTION_II -> 0.25
            Skills.PASSIVE_AURA_OF_SANCTITY -> 0.30
            Skills.PASSIVE_AURA_OF_THE_SERAPHIM -> 0.35
            else -> 0.0
        }
    }

    /** True when an active, non-healing skill hits multiple entities (AoE attack). */
    private fun isAoeAttack(skill: Skill?): Boolean {
        if (skill == null || skill.healing) return false
        val mode = skill.targetSelectionMode
        return mode == TARGET_ALL || mode == TARGET_ALL_ENEMIES || mode == TARGET_ALL_EXCEPT_SELF ||
            (mode.toIntOrNull() ?: 1) > 1
    }

    open fun dealDamage(entity: Entity, entity2: Entity, skill: Skill?, endOfTurnAction: EndOfTurnAction?) {
        val z4 = entity is Adventurer
        val z5 = entity2 is Adventurer
        val bool: Boolean? = if (skill != null && skill.forceRange != null) {
            skill.forceRange
        } else {
            endOfTurnAction?.forceRange
        }
        val zBooleanValue = bool ?: entity.isRanged()
        val z6 = skill == null && (endOfTurnAction == null || endOfTurnAction.replicatesBasicAttack)

        if (dodge(entity, entity2, z6, zBooleanValue)) {
            if (z5) {
                QuestsManager.increment(QuestsManager.hitOrMiss, 1L)
            }
            return
        }

        // Check for DEFENSIVE_STANCE or FALSE_LIFE
        var statusEffect: StatusEffect? = null
        var iDamageOnFalseLifeRemoval = 0
        for (next in entity2.positiveStatusEffects) {
            if (next.type == StatusEffectType.DEFENSIVE_STANCE || next.type == StatusEffectType.FALSE_LIFE) {
                if (next.type == StatusEffectType.FALSE_LIFE) {
                    iDamageOnFalseLifeRemoval = (entity2 as? Adventurer)?.doctrine?.damageOnFalseLifeRemoval() ?: 0
                }
                statusEffect = next
                break
            }
        }

        if (statusEffect != null) {
            entity2.positiveStatusEffects.remove(statusEffect)
            if (z6) {
                Logger.log(this, 31, entity, entity2)
            } else {
                Logger.log(this, 32, entity2)
            }
            Logger.log(this, 10, entity2, statusEffect.type)
            retaliate(entity, entity2, zBooleanValue, iDamageOnFalseLifeRemoval)
            return
        }

        val flatDamage = endOfTurnAction != null && endOfTurnAction.flatDamage
        var livingCompanionBonusDamage = skill?.damageAmplification ?: 1.0
        if (endOfTurnAction != null && endOfTurnAction.fromLivingCompanion) {
            livingCompanionBonusDamage = (entity.livingCompanionBonusDamage.toDouble() * 0.01) + 1.0
        }
        if (entity.isMoreDamageWhenHalfLife() && entity.currentHp.toDouble() <= entity.calculateTotalMaxHp()
                .toDouble() * 0.5
        ) {
            livingCompanionBonusDamage *= 1.5
        }
        if (entity.isMoreDamageDealtAndTaken()) {
            livingCompanionBonusDamage *= 1.35
        }
        if (entity2.isMoreDamageDealtAndTaken()) {
            livingCompanionBonusDamage *= 1.35
        }
        // Radiant skills deal +50% bonus damage against Undead (T6-T9 actives).
        if (skill != null && entity2 is Enemy && entity2.getEnemyType() == EnemyType.UNDEAD) {
            livingCompanionBonusDamage *= skill.undeadDamageMultiplier
        }

        var dCalculateCriticalMultiplier =
            if (flatDamage) 1.0 else calculateCriticalMultiplier(entity, skill, entity2.criticalReduction)
        val pet2 = this.petExploring
        val isSuperCrit =
            z4 && pet2 != null && dCalculateCriticalMultiplier > 1.0 && pet2.getSavage() > 0.0 && Utils.random() < pet2.getSavage() / 100.0
        if (isSuperCrit) {
            dCalculateCriticalMultiplier *= dCalculateCriticalMultiplier
        }

        val dCalculateTotalDarknessDamageAmplification =
            if (flatDamage) 1.0 else (entity.calculateTotalDarknessDamageAmplification() * this.localDarkness.toDouble()) + 1.0

        var statusDamageMultiplier = 1.0
        for (statusEffect2 in entity.positiveStatusEffects) {
            when (statusEffect2.type) {
                StatusEffectType.DELIRIUM, StatusEffectType.SKELETON_KEY -> statusDamageMultiplier *= 2.0
                StatusEffectType.FRENZY -> statusDamageMultiplier *= 1.3
                StatusEffectType.ANOINTED, StatusEffectType.INSPIRE, StatusEffectType.EXALT -> statusDamageMultiplier *= 1.25
                // Radiant Blessing: all party attacks deal +% damage against Undead.
                StatusEffectType.RADIANT_BLESSING -> {
                    if (entity2 is Enemy && entity2.getEnemyType() == EnemyType.UNDEAD) {
                        statusDamageMultiplier *= (1.0 + statusEffect2.undeadDamageBonus)
                    }
                }

                else -> {}
            }
        }

        for (neg in entity2.negativeStatusEffects) {
            if (neg.type == StatusEffectType.PETRIFY) {
                statusDamageMultiplier = 1.1
                break
            }
        }

        val zIsMagic = skill?.forceMagic ?: endOfTurnAction?.forceMagic ?: entity.isMagic()
        val dMagicDamageAmplification = if (zIsMagic) magicDamageAmplification() else 1.0

        var dRollAttackDamage = if (flatDamage) endOfTurnAction!!.damage.toDouble() else entity.rollAttackDamage()
        if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE) {
            dRollAttackDamage = entity.currentHp.toDouble()
        }

        val pet = this.petExploring
        val barrier = if (pet != null && z5) pet.barrier else 0

        if (entity.passiveSkill != Skills.PASSIVE_CHAOTIC && z4 && z5) {
            if ((entity as Adventurer).id == (entity2 as Adventurer).id) {
                dRollAttackDamage = 1.0
            }
        }

        val rawDamage = (dRollAttackDamage * dCalculateCriticalMultiplier * livingCompanionBonusDamage *
            dCalculateTotalDarknessDamageAmplification * statusDamageMultiplier * dMagicDamageAmplification)

        // Angel of War branch: same-row AoE interception (Shared Burden). When an enemy
        // performs an AoE attack against an adventurer, all alive branch units in the same
        // row intercept the highest-tier % of the PRE-mitigation raw damage, split evenly.
        val aoeProtectors = ArrayList<Adventurer>()
        var aoeInterceptedRaw = 0.0
        if (isAoeAttack(skill) && !z4 && z5) {
            var allyIndex = -1
            for (idx in 0 until this.adventurersExploring.size) {
                if (this.adventurersExploring[idx] === entity2) {
                    allyIndex = idx
                    break
                }
            }
            if (allyIndex >= 0) {
                val allyRow = allyIndex / 5
                for (idx in 0 until this.adventurersExploring.size) {
                    val candidate = this.adventurersExploring[idx]
                    if (candidate !== entity2 && candidate.currentHp > 0 &&
                        (idx / 5) == allyRow &&
                        getAoeDamageInterceptionPct(candidate.passiveSkill) > 0.0
                    ) {
                        aoeProtectors.add(candidate)
                    }
                }
                if (aoeProtectors.isNotEmpty()) {
                    var maxPct = 0.0
                    for (protector in aoeProtectors) {
                        maxPct = Math.max(maxPct, getAoeDamageInterceptionPct(protector.passiveSkill))
                    }
                    aoeInterceptedRaw = rawDamage * maxPct
                }
            }
        }

        val iApplyDamage = entity2.applyDamage(
            if (aoeProtectors.isEmpty()) rawDamage else rawDamage - aoeInterceptedRaw,
            zIsMagic,
            barrier,
            entity.getArmorIgnored()
        )

        if (z4) {
            if (dCalculateCriticalMultiplier > 1.0) {
                QuestsManager.increment(QuestsManager.smartFighter, iApplyDamage.toLong())
            }
            QuestsManager.incrementToValue(QuestsManager.annihilator, iApplyDamage.toLong())
            if (!z5) {
                QuestsManager.increment(QuestsManager.warrior, 1L)
            }
        }
        if (z5 && iApplyDamage <= 1) {
            QuestsManager.increment(QuestsManager.unscathed, 1L)
        }

        val logRes = endOfTurnAction?.log ?: R.string.log_damage_dealt
        val critTier = if (isSuperCrit) 2 else if (dCalculateCriticalMultiplier > 1.0) 1 else 0
        Logger.log(this, 33, logRes, critTier, entity, entity2, iApplyDamage)

        if (aoeProtectors.isNotEmpty()) {
            // Split the intercepted raw damage equally among every living protector in the row;
            // each slice is mitigated by the protector's own defenses via applyDamage.
            val perGuardRaw = aoeInterceptedRaw / aoeProtectors.size
            for (guard in aoeProtectors) {
                val guardBarrier = if (pet != null) pet.barrier else 0
                val iGuardDmg =
                    guard.applyDamage(perGuardRaw, zIsMagic, guardBarrier, entity.getArmorIgnored())
                animateDamage(guard)
                Logger.log(this, Logger.AOE_DAMAGE_INTERCEPTED, guard, entity2, iGuardDmg)
                checkDeath(guard)
            }
        }

        if (skill != null) {
            if (entity2.currentHp.toDouble() / entity2.calculateTotalMaxHp().toDouble() < skill.executionThreshold) {
                entity2.currentHp = 0
                Logger.log(this, 34, entity2, entity)
            }
            if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS) {
                skill.statusEffect?.turnsLeft = Utils.round(iApplyDamage.toDouble() / 3.0)
            }
            if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS_II) {
                skill.statusEffect?.turnsLeft = Utils.round(iApplyDamage.toDouble() / 2.0)
            }
            if (!skill.applyEffectOnDodge) {
                applyStatus(entity2, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01)
            }
            if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS || entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS_II) {
                triggerHemorrhage(entity, entity2)
            }
        } else if (endOfTurnAction?.effect != null) {
            applyStatus(
                entity2,
                StatusEffect(
                    endOfTurnAction.effect.type,
                    entity,
                    endOfTurnAction.effect.turnsLeft,
                    endOfTurnAction.effect.probability
                ),
                entity.calculateIgnoreImmunityToStatus() * 0.01
            )
        }

        val pet3 = this.petExploring
        val lifesteal = if (pet3 != null && z4) pet3.lifesteal else 0.0
        var iRound =
            Utils.round((entity.calculateTotalLifesteal().toDouble() + lifesteal) * 0.01 * iApplyDamage.toDouble())
        if (skill != null && entity.activeSkill == Skills.ACTIVE_FRAGMENTATION) {
            iRound = 1000
        }
        if (!entity.hasBloodflame() && iRound > 0) {
            val currentHp = entity.currentHp
            val iCalculateTotalMaxHp = entity.calculateTotalMaxHp()
            val iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound)
            entity.currentHp = iMin
            if (entity.maxLifestealOverheal > 0) {
                val overheal = Math.max(0, (iRound - iCalculateTotalMaxHp) + currentHp)
                val shieldCap =
                    Utils.round(iCalculateTotalMaxHp.toDouble() * 0.01 * entity.maxLifestealOverheal.toDouble())
                entity.currentShield =
                    Math.max(entity.currentShield, Math.min(entity.currentShield + overheal, shieldCap))
            }
            Logger.log(this, 35, entity, iRound)
            if (z4) {
                QuestsManager.increment(QuestsManager.vampiricThirst, (iMin - currentHp).toLong())
                val minionBound = (entity as Adventurer).minionBound
                if (minionBound != null && (entity as Adventurer).isHealsMinionBound()) {
                    minionBound.currentHp = Math.min(minionBound.calculateTotalMaxHp(), minionBound.currentHp + iRound)
                    Logger.log(this, 35, minionBound, iRound)
                }
            }
        }

        if (endOfTurnAction == null || endOfTurnAction.replicatesBasicAttack) {
            for (hitEffect in entity.onTargetHitEffects()) {
                applyStatus(entity2, hitEffect, entity.calculateIgnoreImmunityToStatus() * 0.01)
            }
            if (entity2.currentHp < entity.currentHp && entity.stunChanceOnLowerHp > 0.0) {
                applyStatus(
                    entity2,
                    StatusEffect(StatusEffectType.STUN, entity, 1, entity.stunChanceOnLowerHp),
                    entity.calculateIgnoreImmunityToStatus() * 0.01
                )
            }
            // Subjugate/Subjugate II: each basic attack hit sets Bloodflame on the target.
            when (entity.passiveSkill) {
                Skills.PASSIVE_SUBJUGATE_I -> applyStatus(
                    entity2,
                    StatusEffect(StatusEffectType.BLOODFLAME, entity, 1, 1.0),
                    entity.calculateIgnoreImmunityToStatus() * 0.01
                )

                Skills.PASSIVE_SUBJUGATE_II -> applyStatus(
                    entity2,
                    StatusEffect(StatusEffectType.BLOODFLAME, entity, 2, 1.0),
                    entity.calculateIgnoreImmunityToStatus() * 0.01
                )

                else -> {}
            }
            // Radiant branch (Paladin -> Angel of War): basic attacks heal the ally with the
            // lowest HP for a % of the damage dealt (Seraphim converts overheal into a shield).
            if (entity is Adventurer && iApplyDamage > 0) {
                val pct = when (entity.passiveSkill) {
                    Skills.PASSIVE_AURA_OF_LIGHT_II -> 0.25
                    Skills.PASSIVE_AURA_OF_DEVOTION_I -> 0.30
                    Skills.PASSIVE_AURA_OF_DEVOTION_II -> 0.35
                    Skills.PASSIVE_AURA_OF_SANCTITY -> 0.40
                    Skills.PASSIVE_AURA_OF_THE_SERAPHIM -> 0.50
                    else -> 0.0
                }
                if (pct > 0.0) {
                    radiantHealLowest(entity, Utils.round(iApplyDamage * pct))
                }
            }
        }

        checkDeath(entity2)

        if (endOfTurnAction == null || endOfTurnAction.triggersRetaliation) {
            retaliate(entity, entity2, zBooleanValue, 0)
        }
    }

    open fun checkDeath(entity: Entity) {
        val zContains = entity.positiveStatusEffects.contains(TETHER)
        if (entity.currentHp == 0) {
            if (entity is Enemy) {
                if (entity.passiveSkill == Skills.PASSIVE_ABSURD_GENEALOGY && Utils.random() < 0.65) {
                    entity.currentHp = entity.calculateTotalMaxHp()
                    entity.currentMana = 100
                    entity.negativeStatusEffects.clear()
                    return
                }
                this.enemies.remove(entity)
                if (entity === this.acting) {
                    var iIndexOf = this.fightingGroup.indexOf(entity)
                    if (iIndexOf == 0) {
                        iIndexOf = this.fightingGroup.size
                    }
                    if (iIndexOf - 1 in 0 until this.fightingGroup.size) {
                        this.acting = this.fightingGroup[iIndexOf - 1]
                    }
                    this.turnEndRequested = true
                }
                this.fightingGroup.remove(entity)
                this.corpses.add(entity)
                this.adventureRecap.addEnemyKilled(entity)
                triggerEvent("kill_" + entity.getTrueClass())
                Logger.log(this, 36, entity.getIdName())
                healingNova()
                reanimate(entity)
            } else {
                val adventurer = entity as Adventurer
                if (adventurer.isSummonedMinion()) {
                    this.adventurersExploring.remove(entity)
                    if (entity === this.acting) {
                        var iIndexOf2 = this.fightingGroup.indexOf(entity)
                        if (iIndexOf2 == 0) {
                            iIndexOf2 = this.fightingGroup.size
                        }
                        if (iIndexOf2 - 1 in 0 until this.fightingGroup.size) {
                            this.acting = this.fightingGroup[iIndexOf2 - 1]
                        }
                        this.turnEndRequested = true
                    }
                    this.fightingGroup.remove(entity)
                    for (adv in this.adventurersExploring) {
                        if (adv.minionBound === entity) {
                            adv.minionBound = null
                            break
                        }
                    }
                    triggerEvent("kill_" + entity.getTrueClass())
                    Logger.log(this, 37, entity.getIdName())
                } else {
                    QuestsManager.increment(QuestsManager.theEnd, 1L)
                    animateDamage(entity)
                    if (adventurer.accessory is AmuletOfResurrection && Utils.random() < 0.4) {
                        adventurer.currentHp = adventurer.calculateTotalMaxHp()
                        adventurer.negativeStatusEffects.clear()
                        adventurer.positiveStatusEffects.remove(TETHER)
                        Logger.log(this, Logger.AMULET_OF_RESURRECTION, adventurer)
                        return
                    }
                    val experience = adventurer.experience / 5
                    Logger.log(this, 38, adventurer.getIdName(), experience, getAreaType())
                    if (getAreaType() == 0) {
                        adventurer.experience = adventurer.experience - experience
                        this.adventureRecap.addExpLost(experience)
                    }
                    val minion = adventurer.minionBound
                    if (minion != null) {
                        minion.currentHp = 0
                        checkDeath(minion)
                    }
                    adventurer.positiveStatusEffects.clear()
                    adventurer.negativeStatusEffects.clear()
                }
            }
            if (zContains) {
                return
            }
            reanimateAlchemistWithFeebleTether(entity)
            applyOnDeathStatusEffects(entity)
            return
        }
        animateDamage(entity)
    }

    private fun healingNova() {
        var healMissingHpOnEnemyDeath = 0.0
        for (adventurer in this.adventurersExploring) {
            if (adventurer.currentHp > 0 && !adventurer.hasBloodflame()) {
                healMissingHpOnEnemyDeath += adventurer.getHealMissingHpOnEnemyDeath()
                    .toDouble() * adventurer.calculateHealingModifier()
            }
        }
        if (healMissingHpOnEnemyDeath == 0.0) {
            return
        }
        for (adventurer2 in this.adventurersExploring) {
            if (adventurer2.currentHp > 0 && !adventurer2.hasBloodflame()) {
                val iCalculateTotalMaxHp = adventurer2.calculateTotalMaxHp()
                adventurer2.currentHp = Math.min(
                    iCalculateTotalMaxHp,
                    adventurer2.currentHp + Utils.round(0.01 * healMissingHpOnEnemyDeath * (iCalculateTotalMaxHp - adventurer2.currentHp).toDouble())
                )
            }
        }
        Logger.log(this, Logger.HEALING_NOVA, healMissingHpOnEnemyDeath.toInt())
    }

    private fun applyOnDeathStatusEffects(entity: Entity) {
        if (entity.calculateOnDeathEffectsOnAllies().isEmpty() && entity.calculateOnDeathEffectsOnEnemies().isEmpty()) {
            return
        }
        val listSelectTargets = selectTargets(entity, TARGET_ALL_ENEMIES)
        val listSelectTargets2 = selectTargets(entity, TARGET_ALL_ALLIES)
        if (listSelectTargets2 != null && listSelectTargets2.isNotEmpty()) {
            for (statusEffect in entity.calculateOnDeathEffectsOnAllies()) {
                for (entity2 in listSelectTargets2) {
                    if (entity2.currentHp > 0) {
                        applyStatus(entity2, statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01)
                    }
                }
            }
        }
        if (listSelectTargets == null || listSelectTargets.isEmpty()) {
            return
        }
        for (statusEffect2 in entity.calculateOnDeathEffectsOnEnemies()) {
            for (entity3 in listSelectTargets) {
                if (entity3.currentHp > 0) {
                    applyStatus(entity3, statusEffect2, entity.calculateIgnoreImmunityToStatus() * 0.01)
                }
            }
        }
    }

    private fun reanimateAlchemistWithFeebleTether(entity: Entity) {
        if (entity.getTrueClass() == "EldritchAlchemist") {
            entity.currentHp = entity.calculateTotalMaxHp()
            entity.currentMana = 100
            applyStatus(entity, StatusEffect(StatusEffectType.FEEBLE_TETHER, entity, 999, 1.0), 0.0)
        }
    }

    private fun reanimate(enemy: Enemy) {
        if (enemy.negativeStatusEffects.isEmpty()) {
            return
        }
        var adventurer: Adventurer? = null
        var str: String? = null
        var z = false
        var z2 = false

        for (next in enemy.negativeStatusEffects) {
            if (next.type == StatusEffectType.ABHORRENT_CURSE) {
                adventurer = next.cause as? Adventurer
                str = "BoneHydra"
                z2 = true
                z = true
                break
            }
            if (next.type == StatusEffectType.OMINOUS_CURSE) {
                adventurer = next.cause as? Adventurer
                str = "BoneNightmare"
                z2 = false
                z = true
                break
            }
            if (next.type == StatusEffectType.GREATER_CURSE) {
                adventurer = next.cause as? Adventurer
                str = "BoneHorror"
            } else {
                if (next.type == StatusEffectType.CURSE) {
                    adventurer = next.cause as? Adventurer
                    str = "Skeleton"
                }
                if (next.type == StatusEffectType.LESSER_CURSE && str == null) {
                    adventurer = next.cause as? Adventurer
                    str = "Zombie"
                }
            }
        }

        if (str == null || adventurer == null || adventurer.currentHp <= 0) {
            return
        }

        for (adventurer2 in this.adventurersExploring) {
            if (adventurer2.isSummonedMinion()) {
                this.adventurersExploring.remove(adventurer2)
                this.fightingGroup.remove(adventurer2)
                break
            }
        }

        val minion = Adventurer.getInstance(str, -100, 1, 0, null, null, null, null, null, PotionsDrank(), null, false)
            ?: return
        minion.weapon = Item.getInstance(if (z) "SerpentJaws" else "DecomposedLimb") as? Weapon
        if (z2) {
            minion.armor = Item.getInstance("SpikedSkeleton") as? Armor
        }
        if ("WickedScepter" == adventurer.weapon?.getTrueClass()) {
            minion.accessory = Item.getInstance("EyeOfUr") as? Accessory
        }
        if ("CursedScepter" == adventurer.weapon?.getTrueClass()) {
            minion.accessory = Item.getInstance("AncientEye") as? Accessory
        }
        minion.currentHp = minion.calculateTotalMaxHp()
        adventurer.minionBound = minion
        if (adventurer.accessory is SkeletonKey) {
            applyStatus(minion, StatusEffect(StatusEffectType.SKELETON_KEY, adventurer, 999, 1.0), 0.0)
        }

        val list = this.fightingGroup
        val idx = list.indexOf(adventurer)
        if (idx >= 0) {
            list.add(idx + 1, minion)
        } else {
            list.add(minion)
        }
        this.adventurersExploring.add(minion)
        Logger.log(this, 39, minion.getIdName(), adventurer.getIdName())
    }

    private fun retaliate(entity: Entity?, entity2: Entity, z: Boolean, i: Int) {
        if (entity2.currentHp > 0 && !z && entity != null) {
            val iCalculateRetaliationPhysicalDamage = entity2.calculateRetaliationPhysicalDamage()
            val iCalculateRetaliationMagicalDamage = entity2.calculateRetaliationMagicalDamage() + i
            val pet = this.petExploring
            val barrier = if (pet == null || entity !is Adventurer) 0 else pet.barrier
            if (iCalculateRetaliationPhysicalDamage > 0) {
                val iApplyDamage = entity.applyDamage(
                    iCalculateRetaliationPhysicalDamage.toDouble(),
                    false,
                    barrier,
                    entity2.getArmorIgnored()
                )
                Logger.log(this, 46, entity, iApplyDamage)
                if (entity2 is Adventurer) {
                    QuestsManager.increment(QuestsManager.spiky, iApplyDamage.toLong())
                }
            }
            if (iCalculateRetaliationMagicalDamage > 0) {
                if (i > 0 && entity2 is Adventurer) {
                    QuestsManager.increment(QuestsManager.activeDeterrent, 1L)
                }
                val iApplyDamage2 = entity.applyDamage(
                    Utils.round(magicDamageAmplification() * iCalculateRetaliationMagicalDamage.toDouble()).toDouble(),
                    true,
                    barrier,
                    entity2.getArmorIgnored()
                )
                Logger.log(this, 46, entity, iApplyDamage2)
                if (entity2 is Adventurer) {
                    QuestsManager.increment(QuestsManager.spiky, iApplyDamage2.toLong())
                }
            }
            if (iCalculateRetaliationPhysicalDamage > 0 || iCalculateRetaliationMagicalDamage > 0) {
                checkDeath(entity)
            }
            for (statusEffect in entity2.onSelfHitEffects()) {
                if (statusEffect.type?.negative == true) {
                    applyStatus(entity, statusEffect, entity2.calculateIgnoreImmunityToStatus() * 0.01)
                }
            }
            val pet2 = this.petExploring
            val counterattack = if (pet2 == null || entity2 !is Adventurer) 0.0 else pet2.counterattack / 100.0
            if (entity.isForcesTargetToCounterattack() || Utils.random() < entity2.calculateCounterattackChance() + counterattack) {
                if (entity2 is Adventurer) {
                    QuestsManager.increment(QuestsManager.expertDuelist, 1L)
                }
                dealDamage(entity2, entity, null, null)
            }
        }
        for (statusEffect2 in entity2.onSelfHitEffects()) {
            if (statusEffect2.type?.negative != true) {
                applyStatus(entity2, statusEffect2, 0.0)
            }
        }
    }

    private fun canReach(attacker: Entity, target: Entity, forceRange: Boolean? = null): Boolean {
        if (!target.isFlying()) return true
        val isRanged = forceRange ?: attacker.isRanged()
        return isRanged || attacker.isFlying()
    }

    open fun selectTargets(entity: Entity, str: String, forceRange: Boolean? = null): List<Entity>? {
        val arrayList = ArrayList<Entity>()
        return when (str) {
            TARGET_LOWEST_SHIELD_ALLY -> {
                val target = selectLowestRelativeShieldAlly(entity) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_MOST_NEGATIVE_CONDITIONS_OR_LOWEST_RELATIVE_ALLY -> {
                val list: List<Entity> = if (entity is Adventurer) this.adventurersExploring else this.enemies
                if (list.isEmpty()) return null
                var target: Entity? = null
                for (candidate in list) {
                    if (candidate.currentHp > 0 && (target == null || candidate.negativeStatusEffects.size > target.negativeStatusEffects.size)) {
                        target = candidate
                    }
                }
                if (target == null) return null
                if (target.negativeStatusEffects.isEmpty()) {
                    return selectTargets(entity, TARGET_LOWEST_RELATIVE_ALLY, forceRange)
                }
                arrayList.add(target)
                arrayList
            }

            TARGET_LOWEST_ABSOLUTE_ALLY -> {
                val target = selectLowestHpTarget(entity, false, true, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_RANDOM -> {
                val target = selectRandomTarget(entity, false, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_RANDOM_ALLY -> {
                val list: List<Entity> = if (entity is Adventurer) this.adventurersExploring else this.enemies
                if (list.isEmpty()) return null
                arrayList.add(list[(Utils.random() * list.size.toDouble()).toInt()])
                arrayList
            }

            TARGET_RANDOM_ENEMY -> {
                val target = selectEnemyTarget(entity, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_LOWEST_RELATIVE_ENEMY -> {
                val target = selectLowestHpTarget(entity, true, false, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_RANDOM_EXCEPT_SELF -> {
                val target = selectRandomTarget(entity, true, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_ALL -> {
                arrayList.addAll(this.adventurersExploring)
                arrayList.addAll(this.enemies)
                if (arrayList.isEmpty()) null else arrayList
            }

            TARGET_LOWEST_ABSOLUTE_ENEMY -> {
                val target = selectLowestHpTarget(entity, true, true, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_ALL_ENEMIES -> {
                arrayList.addAll(if (entity is Adventurer) this.enemies else this.adventurersExploring)
                if (arrayList.isEmpty()) null else arrayList
            }

            TARGET_ALL_ALLIES -> {
                arrayList.addAll(if (entity is Adventurer) this.adventurersExploring else this.enemies)
                if (arrayList.isEmpty()) null else arrayList
            }

            TARGET_ALL_EXCEPT_SELF -> {
                arrayList.addAll(this.adventurersExploring)
                arrayList.addAll(this.enemies)
                arrayList.remove(entity)
                if (arrayList.isEmpty()) null else arrayList
            }

            TARGET_LOWEST_RELATIVE_ALLY -> {
                val target = selectLowestHpTarget(entity, false, false, forceRange) ?: return null
                arrayList.add(target)
                arrayList
            }

            TARGET_RANDOM_ALLY_EXCEPT_SELF -> {
                val list = ArrayList(if (entity is Adventurer) this.adventurersExploring else this.enemies)
                list.remove(entity)
                list.removeAll { it.currentHp <= 0 }
                if (list.isEmpty()) return null
                arrayList.add(list[(Utils.random() * list.size.toDouble()).toInt()])
                arrayList
            }

            else -> {
                val count = try {
                    str.toInt()
                } catch (e: Exception) {
                    1
                }
                for (i2 in 0 until count) {
                    val target = selectEnemyTarget(entity, forceRange) ?: return null
                    arrayList.add(target)
                }
                arrayList
            }
        }
    }

    private fun selectEnemyTarget(entity: Entity, forceRange: Boolean? = null): Entity? {
        val z = entity is Adventurer
        val arrayList = ArrayList<Entity>(if (z) this.enemies else this.adventurersExploring)
        if (entity.team != 0) {
            for (enemy in this.enemies) {
                if (enemy.team != entity.team) {
                    arrayList.add(enemy)
                }
            }
        }
        val arrayList2 = ArrayList(arrayList)
        if (arrayList2.isEmpty()) {
            return null
        }
        val entityTauntedBy = tauntedBy(entity, arrayList2)
        if (entityTauntedBy != null) {
            return entityTauntedBy
        }
        val reachable = arrayList2.filter { it.currentHp > 0 && canReach(entity, it, forceRange) }
        val targetPool = if (reachable.isNotEmpty()) reachable else arrayList2
        val listWeightedSelection = weightedSelection(targetPool)
        if (listWeightedSelection.isEmpty()) {
            return null
        }
        val pet = this.petExploring
        if (!z && pet != null && pet.decoy > 0.0 && Utils.random() < pet.decoy / (listWeightedSelection.size.toDouble() + pet.decoy)) {
            Logger.log(this, Logger.PET_DECOY, pet, entity)
            return null
        }
        return listWeightedSelection[(Utils.random() * listWeightedSelection.size.toDouble()).toInt()]
    }

    private fun selectPetTarget(): Entity? {
        val arrayList = ArrayList(this.enemies)
        if (arrayList.isEmpty()) {
            return null
        }
        val listWeightedSelection = weightedSelection(arrayList)
        if (listWeightedSelection.isEmpty()) return null
        return listWeightedSelection[(Utils.random() * listWeightedSelection.size.toDouble()).toInt()]
    }

    private fun selectPetHealingTarget(): Entity? {
        val arrayList = ArrayList<Entity>(this.adventurersExploring)
        arrayList.sortWith(compareByDescending { it.negativeStatusEffects.size })
        var entity: Entity? = null
        for (candidate in arrayList) {
            if (candidate.currentHp > 0 && (entity == null || candidate.currentHp.toDouble() / candidate.calculateTotalMaxHp()
                    .toDouble() < entity.currentHp.toDouble() / entity.calculateTotalMaxHp().toDouble())
            ) {
                entity = candidate
            }
        }
        return entity
    }

    private fun selectRandomTarget(entity: Entity, z: Boolean, forceRange: Boolean? = null): Entity? {
        val arrayList = ArrayList<Entity>()
        arrayList.addAll(this.enemies)
        arrayList.addAll(this.adventurersExploring)
        if (z) {
            arrayList.remove(entity)
        }
        if (arrayList.isEmpty()) {
            return null
        }
        val entityTauntedBy = tauntedBy(entity, arrayList)
        if (entityTauntedBy != null) {
            return entityTauntedBy
        }
        val reachable = arrayList.filter { it.currentHp > 0 && canReach(entity, it, forceRange) }
        val targetPool = if (reachable.isNotEmpty()) reachable else arrayList
        val listWeightedSelection = weightedSelection(targetPool)
        if (listWeightedSelection.isEmpty()) {
            return null
        }
        return listWeightedSelection[(Utils.random() * listWeightedSelection.size.toDouble()).toInt()]
    }

    private fun weightedSelection(list: List<out Entity>): List<Entity> {
        val arrayList = ArrayList<Entity>()
        for (entity in list) {
            if (entity.currentHp > 0) {
                for (i in 0 until entity.threat) {
                    arrayList.add(entity)
                }
            }
        }
        return arrayList
    }

    private fun tauntedBy(entity: Entity, list: List<out Entity>): Entity? {
        var next: StatusEffect? = null
        val it2 = entity.negativeStatusEffects.iterator()
        while (it2.hasNext()) {
            val se = it2.next()
            if (se.type == StatusEffectType.TAUNT) {
                next = se
                break
            }
        }
        if (next != null) {
            val cause = next.cause
            if (cause != null && list.contains(cause)) {
                return cause
            }
            entity.negativeStatusEffects.remove(next)
        }
        return null
    }

    private fun selectLowestHpTarget(entity: Entity, z: Boolean, z2: Boolean, forceRange: Boolean? = null): Entity? {
        val candidates: List<Entity> =
            if ((entity !is Adventurer || z) && (entity !is Enemy || !z)) this.enemies else this.adventurersExploring
        val arrayList = ArrayList<Entity>(candidates)
        if (!z) {
            arrayList.sortWith(compareByDescending { it.negativeStatusEffects.size })
        }
        val entityTauntedBy = tauntedBy(entity, arrayList)
        if (entityTauntedBy != null) {
            return entityTauntedBy
        }
        val targetPool = if (z) {
            val reachable = arrayList.filter { it.currentHp > 0 && canReach(entity, it, forceRange) }
            if (reachable.isNotEmpty()) reachable else arrayList
        } else {
            arrayList
        }
        var entity2: Entity? = null
        for (candidate in targetPool) {
            if (candidate.currentHp > 0) {
                val matches = if (entity2 == null) {
                    true
                } else if (!z2) {
                    candidate.currentHp.toDouble() / candidate.calculateTotalMaxHp()
                        .toDouble() < entity2.currentHp.toDouble() / entity2.calculateTotalMaxHp().toDouble()
                } else {
                    candidate.currentHp < entity2.currentHp
                }
                if (matches) {
                    entity2 = candidate
                }
            }
        }
        return entity2
    }

    private fun selectLowestRelativeShieldAlly(entity: Entity): Entity? {
        val list: List<Entity> = if (entity is Adventurer) this.adventurersExploring else this.enemies
        val arrayList = ArrayList<Entity>(list)
        Collections.shuffle(arrayList)
        var lowest: Entity? = null
        for (candidate in arrayList) {
            if (candidate.currentHp <= 0) continue
            if (lowest == null) {
                lowest = candidate
            } else {
                val maxHp = candidate.calculateTotalMaxHp().toDouble()
                val maxShield = (0.2 * maxHp).toInt()
                if (candidate.currentShield < maxShield) {
                    val candidateRatio = candidate.currentShield.toDouble() / maxHp
                    val lowestRatio = lowest.currentShield.toDouble() / lowest.calculateTotalMaxHp().toDouble()
                    if (candidateRatio < lowestRatio) {
                        lowest = candidate
                    }
                }
            }
        }
        return lowest
    }

    open fun refreshDialog() {
        val dialog = MainActivity.shownDialogDungeonDetail
        if (dialog == null || dialog.area !== this) {
            return
        }
        try {
            dialog.refreshUnits()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun refreshDarkness() {
        val dialog = MainActivity.shownDialogDungeonDetail
        if (dialog == null || dialog.area !== this) {
            return
        }
        try {
            dialog.refreshDarkness()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun invertLogColor() {
        val dialog = MainActivity.shownDialogDungeonDetail
        if (dialog == null || dialog.area !== this) {
            return
        }
        try {
            dialog.darkLog = !dialog.darkLog
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun animateDamage(entity: Entity) {
        val dialog = MainActivity.shownDialogDungeonDetail
        if (dialog == null || dialog.area !== this) {
            return
        }
        try {
            dialog.animateDamage(entity)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun refreshAdventurers() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.context == null || MainActivity.dungeonsFragment.binding == null) {
            return
        }
        val resources = MainActivity.dungeonsFragment.resources
        val theme = MainActivity.dungeonsFragment.context!!.theme
        val arrayList = ArrayList(this.adventurersExploring)
        arrayList.removeAll { it.isSummonedMinion() }
        val size = arrayList.size
        val layout = getLayout()

        if (size > 0) {
            val adv = arrayList[0]
            layout.adventurerImage1.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage1.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 1) {
            val adv = arrayList[1]
            layout.adventurerImage2.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage2.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 2) {
            val adv = arrayList[2]
            layout.adventurerImage3.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage3.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 3) {
            val adv = arrayList[3]
            layout.adventurerImage4.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage4.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 4) {
            val adv = arrayList[4]
            layout.adventurerImage5.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage5.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 5) {
            val adv = arrayList[5]
            layout.adventurerImage6.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage6.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 6) {
            val adv = arrayList[6]
            layout.adventurerImage7.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage7.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 7) {
            val adv = arrayList[7]
            layout.adventurerImage8.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage8.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 8) {
            val adv = arrayList[8]
            layout.adventurerImage9.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage9.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 9) {
            val adv = arrayList[9]
            layout.adventurerImage10.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage10.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 10) {
            val adv = arrayList[10]
            layout.adventurerImage11.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage11.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 11) {
            val adv = arrayList[11]
            layout.adventurerImage12.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage12.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 12) {
            val adv = arrayList[12]
            layout.adventurerImage13.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage13.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }
        if (size > 13) {
            val adv = arrayList[13]
            layout.adventurerImage14.adventurerImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    adv.imageId,
                    theme
                )
            )
            layout.adventurerImage14.adventurerImage.setBackgroundResource(if (adv.isAscended()) R.drawable.object_border_ascended else R.drawable.object_border_dim_white)
        }

        layout.adventurerImage1.root.visibility = if (size > 0) 0 else 8
        layout.adventurerImage2.root.visibility = if (size > 1) 0 else 8
        layout.adventurerImage3.root.visibility = if (size > 2) 0 else 8
        layout.adventurerImage4.root.visibility = if (size > 3) 0 else 8
        layout.adventurerImage5.root.visibility = if (size > 4) 0 else 8
        layout.adventurerImage6.root.visibility = if (size > 5) 0 else 8
        layout.adventurerImage7.root.visibility = if (size > 6) 0 else 8
        layout.adventurerImage8.root.visibility = if (size > 7) 0 else 8
        layout.adventurerImage9.root.visibility = if (size > 8) 0 else 8
        layout.adventurerImage10.root.visibility = if (size > 9) 0 else 8
        layout.adventurerImage11.root.visibility = if (size > 10) 0 else 8
        layout.adventurerImage12.root.visibility = if (size > 11) 0 else 8
        layout.adventurerImage13.root.visibility = if (size > 12) 0 else 8
        layout.adventurerImage14.root.visibility = if (size > 13) 0 else 8

        layout.explorationTooltip.visibility = if (arrayList.isEmpty()) 4 else 0
        layout.pet.visibility = if (this.petExploring == null) 4 else 0
        if (this.petExploring != null) {
            layout.pet.setImageDrawable(ResourcesCompat.getDrawable(resources, this.petExploring!!.idImage, theme))
        }
        refreshHpBars()
    }

    private fun refreshHpBars() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.context == null || MainActivity.dungeonsFragment.binding == null) {
            return
        }
        val arrayList = ArrayList(this.adventurersExploring)
        arrayList.removeAll { it.isSummonedMinion() }
        val size = arrayList.size
        try {
            val layout = getLayout()
            if (size > 0) layout.adventurerImage1.hpBar.progress = getSummaryHpBarProgress(arrayList[0])
            if (size > 1) layout.adventurerImage2.hpBar.progress = getSummaryHpBarProgress(arrayList[1])
            if (size > 2) layout.adventurerImage3.hpBar.progress = getSummaryHpBarProgress(arrayList[2])
            if (size > 3) layout.adventurerImage4.hpBar.progress = getSummaryHpBarProgress(arrayList[3])
            if (size > 4) layout.adventurerImage5.hpBar.progress = getSummaryHpBarProgress(arrayList[4])
            if (size > 5) layout.adventurerImage6.hpBar.progress = getSummaryHpBarProgress(arrayList[5])
            if (size > 6) layout.adventurerImage7.hpBar.progress = getSummaryHpBarProgress(arrayList[6])
            if (size > 7) layout.adventurerImage8.hpBar.progress = getSummaryHpBarProgress(arrayList[7])
            if (size > 8) layout.adventurerImage9.hpBar.progress = getSummaryHpBarProgress(arrayList[8])
            if (size > 9) layout.adventurerImage10.hpBar.progress = getSummaryHpBarProgress(arrayList[9])
            if (size > 10) layout.adventurerImage11.hpBar.progress = getSummaryHpBarProgress(arrayList[10])
            if (size > 11) layout.adventurerImage12.hpBar.progress = getSummaryHpBarProgress(arrayList[11])
            if (size > 12) layout.adventurerImage13.hpBar.progress = getSummaryHpBarProgress(arrayList[12])
            if (size > 13) layout.adventurerImage14.hpBar.progress = getSummaryHpBarProgress(arrayList[13])
        } catch (unused: Exception) {
        }
    }

    private fun getSummaryHpBarProgress(adventurer: Adventurer): Int {
        return ((adventurer.currentHp.toDouble() * 100.0) / adventurer.calculateTotalMaxHp().toDouble()).toInt()
    }

    open fun refreshLoot() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.context == null || MainActivity.dungeonsFragment.binding == null) {
            return
        }
        val resources = MainActivity.dungeonsFragment.resources
        val theme = MainActivity.dungeonsFragment.context!!.theme
        var stack = 0
        for (item in this.drops) {
            stack += item.getStack()
        }
        val cap = getLootCap()
        val isFull = stack >= cap
        val layout = getLayout()
        layout.lootImage.visibility = if (this.drops.isEmpty()) 8 else 0
        layout.lootImage.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                if (isFull) R.drawable.loot_chest_full else R.drawable.loot_chest,
                theme
            )
        )
        layout.fullLoot.visibility = if (this.drops.isEmpty()) 8 else 0
        layout.fullLoot.text = if (MainActivity.data.isMaxLootPackPurchased) {
            String.format(resources.getString(R.string.loot_percentage_full_with_pack), stack)
        } else if (MainActivity.data.lootCap > 0) {
            "$stack / $cap"
        } else {
            String.format(resources.getString(R.string.loot_percentage_full), stack)
        }
        layout.fullLoot.setTextColor(
            resources.getColor(
                if (isFull) UIUtils.getFailureColor() else R.color.dim_white,
                theme
            )
        )
    }

    open fun refreshActionDisplayed() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.context == null || MainActivity.dungeonsFragment.binding == null || this.action == null) {
            return
        }
        try {
            val layout = getLayout()
            layout.actionDescription.setText(this.action!!.name)
            if (this.animator == null || this.animationInvalidationRequested) {
                this.animationInvalidationRequested = false
                val valueAnimatorOfInt = ValueAnimator.ofInt(0, 1000)
                this.animator = valueAnimatorOfInt
                valueAnimatorOfInt.interpolator = LinearInterpolator()
                this.animator!!.addUpdateListener { animator ->
                    if (MainActivity.applicationPaused.value) return@addUpdateListener
                    val animVal = (animator.animatedValue as? Int) ?: return@addUpdateListener
                    layout.actionProgress.progress = animVal
                    val detail = MainActivity.shownDialogDungeonDetail
                    val binding = detail?.binding
                    if (detail != null && binding != null && detail.area === this) {
                        binding.actionProgressRight.progress = animVal
                        binding.actionProgressLeft.progress = animVal
                    }
                }
            }
            this.animator!!.duration = this.action!!.turnsToComplete.toLong() * 1000L
            this.animator!!.start()
        } catch (unused: Exception) {
        }
    }

    open fun refreshTries() {
        if (!Utils.isMainLooper() || MainActivity.raidsFragment == null || MainActivity.raidsFragment.context == null || MainActivity.raidsFragment.binding == null) {
            return
        }
        getLayout().raidTryAvailable.setImageDrawable(
            ResourcesCompat.getDrawable(
                MainActivity.raidsFragment.resources,
                if (this.triesAvailable) R.drawable.raid_try_available else R.drawable.raid_try_unavailable,
                MainActivity.raidsFragment.context!!.theme
            )
        )
    }

    open fun invalidateAnimator() {
        this.animationInvalidationRequested = true
    }

    open fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        return LinkedHashMap()
    }

    open fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        return LinkedHashMap()
    }
}
