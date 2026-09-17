package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import android.os.Handler
import android.os.Looper
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class GuildSiegeArea : Area() {
    override fun adventurersNumber(): Int = 10

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    /** The Siege cannot be re-entered by spending gems — 1 try per reroll, period. */
    override fun canRefillWithGems(): Boolean = false

    override fun getName(): Int = R.string.guild_siege_name

    override fun getSummaryDrawable(): Int = R.drawable.test_area_image_summary_forest

    override fun getDetailDrawable(): Int = R.drawable.area_the_siege

    override fun getLayout(): LayoutDungeonBinding = MainActivity.guildActivitiesFragment.binding!!.guildSiege

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return GuildActivitiesManager.getEligibleSiegeEnemies().mapNotNull { Enemy.getInstance(it) }
    }

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress in 1..10) {
            return GuildActivitiesManager.rollSiegeWaveEnemies(progress)
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_dungeon" -> {
                Logger.log(this, Logger.EVENT, R.string.guild_siege_enter_dungeon)
            }
            "enter_room" -> {
                Logger.log(this, Logger.EVENT, R.string.guild_siege_enter_room)
                if (progress > 10) {
                    GuildActivitiesManager.onSiegeVictory(this)
                    terminationRequested = true
                }
            }
            "fight_start" -> {
                Logger.log(this, Logger.YELLOW_LOG, R.string.guild_siege_wave, progress, 10)
            }
            "victory" -> {
                if (progress >= 10) {
                    // Do NOT terminate here: the Area loop still runs the loot() phase for the
                    // bodies that just died, so the final wave's drops are preserved.
                    GuildActivitiesManager.onSiegeVictory(this)
                }
            }
            "respawn" -> {
                GuildActivitiesManager.onSiegeDefeat(this)
                terminationRequested = true
            }
        }
    }

    override fun onRetreat() {
        super.onRetreat()
        GuildActivitiesManager.consumeSiegeAttempt()
        refreshTries()
    }

    override fun refreshTries() {
        if (MainActivity.guildActivitiesFragment.context == null || MainActivity.guildActivitiesFragment.binding == null) {
            return
        }
        if (!Utils.isMainLooper()) {
            Handler(Looper.getMainLooper()).post { refreshTries() }
            return
        }
        val layout = getLayout()
        val available = GuildActivitiesManager.isSiegeAvailable() && adventurersExploringIds.isEmpty()
        this.triesAvailable = available
        layout.raidTryAvailable.setImageResource(
            if (available) R.drawable.raid_try_available else R.drawable.raid_try_unavailable
        )
        layout.raidTryAvailable.visibility = android.view.View.VISIBLE
    }
}
