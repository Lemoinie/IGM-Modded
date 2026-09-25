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

class GuildRequestArea : Area() {
    override fun adventurersNumber(): Int = 5

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 50

    /** The Hunt cannot be re-entered by spending gems — 1 try per reroll, period. */
    override fun canRefillWithGems(): Boolean = false

    override fun getName(): Int = R.string.guild_request_name

    override fun getSummaryDrawable(): Int = R.drawable.summary_request

    override fun getDetailDrawable(): Int = R.drawable.area_request

    override fun getLayout(): LayoutDungeonBinding = MainActivity.guildActivitiesFragment.binding!!.guildRequest

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        // Only new monsters are shown here (Bestiary "Other" tab must not repeat
        // monsters that already appear in the Dungeons/Raids tabs). Void Slime is
        // already listed by TheSlimePond raid.
        return listOfNotNull(Enemy.getInstance("Shadow"))
    }

    public override fun rollEnemies(): MutableList<Enemy> {
        if (progress == 1) {
            // Void Slime count: 70% -> 1, 20% -> 2, 10% -> 4. Shadow always sits
            // in the middle of the formation (slime(s) ... Shadow ... slime(s)).
            val r = Utils.random()
            val slimeCount = if (r < 0.70) 1 else if (r < 0.90) 2 else 4
            val total = slimeCount + 1
            val shadowIndex = total / 2
            val result = CopyOnWriteArrayList<Enemy>()
            for (i in 0 until total) {
                result.add(
                    if (i == shadowIndex) Enemy.getInstance("Shadow")
                    else Enemy.getInstance("VoidSlime")
                )
            }
            return result
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_dungeon" -> {
                Logger.log(this, Logger.EVENT, R.string.guild_hunt_enter_dungeon)
            }

            "enter_room" -> {
                Logger.log(this, Logger.EVENT, R.string.guild_hunt_enter_room)
                if (progress >= 2) {
                    terminationRequested = true
                }
            }

            "victory" -> {
                // Do NOT terminate here: the Area loop still runs the loot() phase for the
                // bodies that just died. Terminating immediately skipped loot (no drops).
                GuildActivitiesManager.onRequestVictory(this)
            }

            "respawn" -> {
                progress = 0
            }
        }
    }

    override fun onRetreat() {
        super.onRetreat()
        GuildActivitiesManager.consumeRequestAttempt()
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
        val available = GuildActivitiesManager.isRequestAvailable() && adventurersExploringIds.isEmpty()
        this.triesAvailable = available
        layout.raidTryAvailable.setImageResource(
            if (available) R.drawable.raid_try_available else R.drawable.raid_try_unavailable
        )
        layout.raidTryAvailable.visibility = android.view.View.VISIBLE
    }
}
