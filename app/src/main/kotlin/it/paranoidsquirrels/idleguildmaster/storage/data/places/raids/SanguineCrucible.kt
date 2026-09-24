package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class SanguineCrucible : Area() {
    // Whether the boss has been slain during this run. Used to let the standard
    // Victory -> Experience -> Loot action sequence finish before the raid ends, so a
    // successful boss kill still pays out its drops and XP.
    @Transient
    private var bossDefeated: Boolean = false

    // Party cap matches the engine's 14 adventurer slots (same as The Tower).
    override fun adventurersNumber(): Int = 14

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_sanguine_crucible

    override fun getSummaryDrawable(): Int = R.drawable.summary_scarlet

    override fun getDetailDrawable(): Int = R.drawable.area_scarlet

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.sanguineCrucible

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event ?: return CopyOnWriteArrayList()
        // The boss has already been slain: instead of re-spawning the sanctum wave, end the
        // run right after the last fight's loot was rolled.
        if (bossDefeated) {
            bossDefeated = false
            terminationRequested = true
            return CopyOnWriteArrayList()
        }
        // Inner sanctum: Archmagus Valthex flanked by 4 Crimson Acolytes (Valthex in the middle).
        if (progress >= ev.progress) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("CrimsonAcolyte"),
                Enemy.getInstance("CrimsonAcolyte"),
                Enemy.getInstance("ArchmagusValthex"),
                Enemy.getInstance("CrimsonAcolyte"),
                Enemy.getInstance("CrimsonAcolyte")
            ))
        }
        // Wandering corridor: 80% combat chamber (1-5 Acolytes), 20% atmospheric chamber.
        if (Utils.random() < 0.8) {
            val count = 1 + (Utils.random() * 5).toInt()
            val acolytes = CopyOnWriteArrayList<Enemy>()
            for (i in 0 until count) {
                Enemy.getInstance("CrimsonAcolyte")?.let { acolytes.add(it) }
            }
            Logger.log(this, Logger.EVENT_HARMFUL, R.string.log_sanguine_crucible_combat_chamber)
            return acolytes
        }
        val dRandom = Utils.random()
        val msgRes = if (dRandom < 0.5) {
            R.string.log_sanguine_crucible_atmosphere_1
        } else if (dRandom < 0.75) {
            R.string.log_sanguine_crucible_atmosphere_2
        } else {
            R.string.log_sanguine_crucible_atmosphere_3
        }
        Logger.log(this, 100, msgRes)
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                if (progress == 1 && event == null) {
                    Logger.log(this, 100, R.string.log_sanguine_crucible_enter)
                    event = Event(Event.HALLS_EXPLORATION)
                    // bossRoomThreshold = 5 + random(0..10) -> 5 to 15 rooms.
                    event?.progress = 5 + (Utils.random() * 11).toInt()
                    // Fresh run: the previous run's boss-kill flag must not be carried over.
                    bossDefeated = false
                } else if (event != null && progress >= event!!.progress) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_sanguine_crucible_sanctum)
                }
            }
            "kill_ArchmagusValthex" -> {
                // Do NOT terminate here: that would preempt the Victory -> Experience ->
                // Loot actions, ending the run with no loot and no XP. Mark the boss as
                // defeated and let rollEnemies() close the raid right after the loot tick.
                bossDefeated = true
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_sanguine_crucible_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("CrimsonAcolyte"),
            Enemy.getInstance("ArchmagusValthex")
        )
    }
}