package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

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
    override fun adventurersNumber(): Int = 12

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.guild_request_name

    override fun getSummaryDrawable(): Int = R.drawable.test_area_image_summary_forest

    override fun getDetailDrawable(): Int = R.drawable.area_request

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.guildRequest

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(Enemy.getInstance("Shadow"), Enemy.getInstance("VoidSlime"))
    }

    public override fun rollEnemies(): MutableList<Enemy> {
        if (progress == 1) {
            return CopyOnWriteArrayList(
                listOfNotNull(
                    Enemy.getInstance("VoidSlime"),
                    Enemy.getInstance("Shadow"),
                    Enemy.getInstance("VoidSlime")
                )
            )
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                if (progress >= 2) {
                    terminationRequested = true
                }
            }
            "victory" -> {
                GuildActivitiesManager.onRequestVictory(this)
                terminationRequested = true
            }
            "respawn" -> {
                progress = 0
            }
        }
    }

    override fun refreshTries() {
        if (!Utils.isMainLooper() || MainActivity.raidsFragment == null || MainActivity.raidsFragment.context == null || MainActivity.raidsFragment.binding == null) {
            return
        }
        val layout = getLayout()
        val available = GuildActivitiesManager.isRequestAvailable()
        layout.raidTryAvailable.setImageResource(
            if (available) R.drawable.raid_try_available else R.drawable.raid_try_unavailable
        )
        layout.raidTryAvailable.visibility = android.view.View.VISIBLE
    }
}
