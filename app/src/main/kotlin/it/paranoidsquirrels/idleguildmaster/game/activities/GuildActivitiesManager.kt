package it.paranoidsquirrels.idleguildmaster.game.activities

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildRequestArea
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildSiegeArea
import java.util.Calendar
import java.util.concurrent.CopyOnWriteArrayList

object GuildActivitiesManager {

    private val KNOWN_BOSSES = setOf(
        "SlimeKing", "LegateHadrian", "ImperialCaptain", "Shadow",
        "Devourer", "CelestialHarvester", "AncientDragon", "Titan", "SpiderQueen"
    )

    // Per-area siege monster rules (keyed by Area subclass simple name).
    private val SIEGE_INCLUDE_ONLY = mapOf(
        "DivineArcheology" to setOf("SandDemon"),
        "TheCultistRebels" to setOf("Crusader", "LesserTitan"),
        "TheDreadfulAscent" to setOf("EtherealSoul"),
        "SleepingPlanet" to setOf("DreamwroughtBeast", "DreamwroughtDragon", "DreamwroughtSwarm"),
        "Kaunis" to setOf("Necrobot", "Enforcer", "Phantasm"),
        "TheTower" to setOf("Lazarus", "Phoenix", "HeadlessKnight")
    )

    private val SIEGE_EXCLUDE = mapOf(
        "EnchantedForest" to setOf("GoldenRabbit"),
        "TheGoldenCity" to setOf("ImperialCaptain"),
        "TheSouthernGrove" to setOf("PrimevalWurm"),
        "TheSlimePond" to setOf("SlimeKing"),
        "AncientGraveDigging" to setOf("KabarTheRotten", "Necrolith"),
        "ImperialRescue" to setOf("EmperorClovisXXVIII"),
        "TheLostExpedition" to setOf("TekeliLiFirstApostle", "AvatarOfTheAncient"),
        "CelestialMothership" to setOf("LegateHadrian")
    )

    /** Areas whose waves spawn no monsters at all (never selected). */
    private val SIEGE_NO_MONSTERS = setOf("TheDireDescent")

    @JvmStatic
    fun isRequestAvailable(): Boolean {
        val state = MainActivity.data.guildActivitiesState
        return state.requestStatus == GuildActivitiesState.STATUS_ACTIVE && !state.requestRewardClaimed
    }

    @JvmStatic
    fun isSiegeAvailable(): Boolean {
        val state = MainActivity.data.guildActivitiesState
        return state.siegeStatus == GuildActivitiesState.STATUS_ACTIVE
    }

    @JvmStatic
    fun getDayBoundary(timeMillis: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timeMillis
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }

    @JvmStatic
    fun getWeekBoundary(timeMillis: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timeMillis
        cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }

    @JvmStatic
    fun ensureActivities(currentTime: Long) {
        ensureRequest(currentTime)
        ensureSiege(currentTime)
    }

    @JvmStatic
    fun ensureRequest(currentTime: Long) {
        val boundary = getDayBoundary(currentTime)
        val state = MainActivity.data.guildActivitiesState
        if (state.requestDayBoundary != boundary) {
            val req = MainActivity.data.guildRequest
            if (req != null && req.adventurersExploringIds.isNotEmpty()) {
                // Actively exploring, defer rollover until party finishes
                return
            }
            state.requestDayBoundary = boundary
            state.requestStatus = GuildActivitiesState.STATUS_ACTIVE
            state.requestRewardClaimed = false
            req?.progress = 0
            req?.refreshTries()
        }
    }

    @JvmStatic
    fun ensureSiege(currentTime: Long) {
        val boundary = getWeekBoundary(currentTime)
        val state = MainActivity.data.guildActivitiesState
        if (state.siegeWeekBoundary != boundary) {
            val siege = MainActivity.data.guildSiege
            if (siege != null && siege.adventurersExploringIds.isNotEmpty()) {
                // Actively exploring, defer rollover until party finishes
                return
            }
            // Uncompleted siege rollover simply rotates a fresh siege for the new week
            state.siegeWeekBoundary = boundary
            state.siegeStatus = GuildActivitiesState.STATUS_ACTIVE
            state.siegeWavesCleared = 0
            siege?.progress = 0
            siege?.refreshTries()
        }
    }

    /**
     * Forced reroll of both guild activities (REROLL redeem code). Returns false while a
     * party is actively exploring one of them — the in-progress attempt is preserved.
     */
    @JvmStatic
    fun forceRerollHuntAndSiege(): Boolean {
        val req = MainActivity.data.guildRequest
        val siege = MainActivity.data.guildSiege
        if ((req != null && req.adventurersExploringIds.isNotEmpty()) ||
            (siege != null && siege.adventurersExploringIds.isNotEmpty())) {
            return false
        }
        val state = MainActivity.data.guildActivitiesState
        state.requestDayBoundary = 0L
        state.requestStatus = GuildActivitiesState.STATUS_ACTIVE
        state.requestRewardClaimed = false
        state.siegeWeekBoundary = 0L
        state.siegeStatus = GuildActivitiesState.STATUS_ACTIVE
        state.siegeWavesCleared = 0
        req?.progress = 0
        req?.drops?.clear()
        siege?.progress = 0
        siege?.drops?.clear()
        ensureActivities(TrueTimeUtils.millis())
        MainActivity.guildActivitiesFragment.refresh()
        return true
    }

    @JvmStatic
    fun onRequestVictory(area: GuildRequestArea) {
        val state = MainActivity.data.guildActivitiesState
        if (state.requestStatus != GuildActivitiesState.STATUS_COMPLETED && !state.requestRewardClaimed) {
            state.requestStatus = GuildActivitiesState.STATUS_COMPLETED
            state.requestRewardClaimed = true
            area.refreshTries()
        }
    }

    @JvmStatic
    fun onSiegeDefeat(area: GuildSiegeArea) {
        val state = MainActivity.data.guildActivitiesState
        if (state.siegeStatus == GuildActivitiesState.STATUS_ACTIVE) {
            state.siegeStatus = GuildActivitiesState.STATUS_FAILED
            area.refreshTries()
        }
    }

    @JvmStatic
    fun onSiegeVictory(area: GuildSiegeArea) {
        val state = MainActivity.data.guildActivitiesState
        if (state.siegeStatus == GuildActivitiesState.STATUS_ACTIVE) {
            state.siegeStatus = GuildActivitiesState.STATUS_COMPLETED
            state.siegeWavesCleared = 10
            area.refreshTries()
        }
    }

    /** The Hunt's 1 daily try was used or abandoned (retreat) — mark it consumed. */
    @JvmStatic
    fun consumeRequestAttempt() {
        val state = MainActivity.data.guildActivitiesState
        state.requestStatus = GuildActivitiesState.STATUS_COMPLETED
        state.requestRewardClaimed = true
        MainActivity.guildActivitiesFragment.refresh()
    }

    /** The Siege's 1 weekly try was used or abandoned (retreat) — mark it consumed. */
    @JvmStatic
    fun consumeSiegeAttempt() {
        val state = MainActivity.data.guildActivitiesState
        state.siegeStatus = GuildActivitiesState.STATUS_COMPLETED
        MainActivity.guildActivitiesFragment.refresh()
    }

    /** Reentrancy guard: `GuildSiegeArea.listEnemies()` delegates here, so guard against
     * any area (current or future) whose `listEnemies()` funnels back into this method —
     * returning the fallback list instead of recursing into a StackOverflowError. */
    @JvmStatic
    private val siegeEnemyBuilding = ThreadLocal<Boolean>()

    @JvmStatic
    fun getEligibleSiegeEnemies(): List<String> {
        if (siegeEnemyBuilding.get() == true) {
            return listOf("Slime", "FireSlime", "ElectricSlime", "FrozenSlime", "VoidSlime")
        }
        siegeEnemyBuilding.set(true)
        try {
            val result = mutableListOf<String>()
            // Exclude the guild activity areas themselves: GuildSiegeArea.listEnemies()
            // delegates here, so iterating it would recurse forever.
            val areas = Utils.compileDungeonRaidList().filter { it.isUnlocked && it !is GuildSiegeArea && it !is GuildRequestArea }
            for (area in areas) {
                for (enemy in area.listEnemies()) {
                    val tc = enemy.getTrueClass() ?: continue
                    if (enemy.getRarity() < 2 && !KNOWN_BOSSES.contains(tc) && !result.contains(tc)) {
                        result.add(tc)
                    }
                }
            }
            if (result.isEmpty()) {
                result.addAll(listOf("Slime", "FireSlime", "ElectricSlime", "FrozenSlime", "VoidSlime"))
            }
            return result
        } finally {
            siegeEnemyBuilding.set(false)
        }
    }

    @JvmStatic
    fun rollSiegeWaveEnemies(wave: Int): CopyOnWriteArrayList<Enemy> {
        // 5 to 10 enemies per wave (randomized each wave).
        val count = 5 + (Utils.random() * 6).toInt().coerceIn(0, 5)
        val area = pickSiegeArea(wave)
        val allowed = area?.let { siegeAllowedMonsters(it) } ?: emptyList()
        val list = CopyOnWriteArrayList<Enemy>()
        if (allowed.isEmpty()) {
            return list
        }
        for (i in 0 until count) {
            val idx = (Utils.random() * allowed.size).toInt().coerceIn(0, allowed.size - 1)
            Enemy.getInstance(allowed[idx])?.let { list.add(it) }
        }
        return list
    }

    /**
     * Monsters that may appear when the given area is chosen for a siege wave,
     * following the per-area include/exclude rules above.
     */
    @JvmStatic
    fun siegeAllowedMonsters(area: Area): List<String> {
        val key = area.javaClass.simpleName
        if (SIEGE_NO_MONSTERS.contains(key)) return emptyList()
        val include = SIEGE_INCLUDE_ONLY[key]
        val exclude = SIEGE_EXCLUDE[key] ?: emptySet()
        return area.listEnemies().mapNotNull { it.getTrueClass() }
            .filter { (include == null || include.contains(it)) && !exclude.contains(it) }
            .distinct()
    }

    /**
     * Selects the single dungeon/raid for a siege wave. Later waves are weighted
     * toward later/harder areas: wave 1 mostly Enchanted Forest / Slime Pond,
     * wave 10 mostly Lost Lands / Kaunis / The Tower.
     */
    @JvmStatic
    fun pickSiegeArea(wave: Int): Area? {
        val tiers = siegeAreaTiers().map { tier ->
            tier.filter { it.isUnlocked && siegeAllowedMonsters(it).isNotEmpty() }
        }
        val t = ((wave - 1).coerceIn(0, 9)) / 9.0
        val mean = t * t * (tiers.size - 1).toDouble()
        var tierIndex = (mean + Utils.random() * 2.0).toInt().coerceIn(0, tiers.size - 1)
        var candidate = tiers[tierIndex]
        if (candidate.isEmpty()) {
            var down = tierIndex - 1
            while (down >= 0 && tiers[down].isEmpty()) down--
            if (down >= 0) {
                tierIndex = down
                candidate = tiers[down]
            } else {
                var up = tierIndex + 1
                while (up < tiers.size && tiers[up].isEmpty()) up++
                if (up < tiers.size) candidate = tiers[up]
            }
        }
        if (candidate.isEmpty()) return null
        return candidate[(Utils.random() * candidate.size).toInt().coerceIn(0, candidate.size - 1)]
    }

    /** Dungeons/raids grouped by difficulty tier, lowest to highest. */
    private fun siegeAreaTiers(): List<List<Area>> = listOf(
        listOfNotNull(MainActivity.data.enchantedForest, MainActivity.data.theSlimePond),
        listOfNotNull(MainActivity.data.theDesert, MainActivity.data.divineArcheology),
        listOfNotNull(MainActivity.data.eternalBattlefield, MainActivity.data.ancientGraveDigging),
        listOfNotNull(MainActivity.data.theGoldenCity, MainActivity.data.imperialRescue),
        listOfNotNull(MainActivity.data.blackwaterPort, MainActivity.data.theCultistRebels),
        listOfNotNull(MainActivity.data.frostbitePeaks, MainActivity.data.theDreadfulAscent),
        listOfNotNull(MainActivity.data.obsidianMines, MainActivity.data.theLostExpedition),
        listOfNotNull(MainActivity.data.theSouthernGrove, MainActivity.data.celestialMothership),
        listOfNotNull(MainActivity.data.barrenWastelands, MainActivity.data.theDireDescent),
        listOfNotNull(MainActivity.data.hiddenCityOfLarox, MainActivity.data.sleepingPlanet),
        listOfNotNull(MainActivity.data.lostLands, MainActivity.data.kaunis),
        listOfNotNull(MainActivity.data.theTower)
    )
}
