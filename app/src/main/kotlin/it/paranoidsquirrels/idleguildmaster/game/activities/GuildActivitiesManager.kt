package it.paranoidsquirrels.idleguildmaster.game.activities

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildRequestArea
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildSiegeArea
import java.util.Calendar
import java.util.concurrent.CopyOnWriteArrayList

object GuildActivitiesManager {

    /** Gem payout for completing the Daily Request (replaces the removed Reputation stat). */
    const val REQUEST_GEM_REWARD = 100L

    private val KNOWN_BOSSES = setOf(
        "SlimeKing", "LegateHadrian", "ImperialCaptain", "Shadow",
        "Devourer", "CelestialHarvester", "AncientDragon", "Titan", "SpiderQueen"
    )

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

    @JvmStatic
    fun onRequestVictory(area: GuildRequestArea) {
        val state = MainActivity.data.guildActivitiesState
        if (state.requestStatus != GuildActivitiesState.STATUS_COMPLETED && !state.requestRewardClaimed) {
            MainActivity.data.gems += REQUEST_GEM_REWARD
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

    @JvmStatic
    fun getEligibleSiegeEnemies(): List<String> {
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
    }

    @JvmStatic
    fun rollSiegeWaveEnemies(wave: Int): CopyOnWriteArrayList<Enemy> {
        val count = 5 + ((wave * 5) / 10).coerceIn(0, 5) // 5 to 10 enemies
        val eligible = getEligibleSiegeEnemies()
        val list = CopyOnWriteArrayList<Enemy>()
        if (eligible.isEmpty()) {
            return list
        }
        for (i in 0 until count) {
            val idx = (Utils.random() * eligible.size).toInt().coerceIn(0, eligible.size - 1)
            Enemy.getInstance(eligible[idx])?.let { list.add(it) }
        }
        return list
    }
}
