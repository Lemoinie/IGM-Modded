package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class SleepingPlanet : Area() {
    override fun adventurersNumber(): Int = 14

    override fun costToRefresh(): Int = 15

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_sleeping_planet

    override fun getSummaryDrawable(): Int = R.drawable.summary_sleeping_planet

    override fun getDetailDrawable(): Int = R.drawable.area_sleeping_planet

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.sleepingPlanet

    override fun rollEnemies(): MutableList<Enemy> {
        return when (progress) {
            5 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("DreamwroughtBeast"),
                Enemy.getInstance("DreamwroughtBeast"),
                Enemy.getInstance("DreamwroughtBeast")
            ))
            8 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("DreamwroughtBeast"),
                Enemy.getInstance("DreamwroughtDragon"),
                Enemy.getInstance("DreamwroughtBeast")
            ))
            10 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("DreamwroughtBeast"),
                Enemy.getInstance("DreamwroughtSwarm"),
                Enemy.getInstance("DreamwroughtBeast")
            ))
            12 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("DreamwroughtBeast"),
                Enemy.getInstance("DreamwroughtForge"),
                Enemy.getInstance("DreamwroughtBeast")
            ))
            14 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Singularity")
            ))
            else -> CopyOnWriteArrayList()
        }
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_Singularity" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_UNITY)
            }
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_1)
                    2 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_2)
                    3 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_3)
                    4 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_4)
                    5 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_5)
                    6 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_6)
                    7 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_7)
                    8 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_8)
                    9 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_9)
                    10 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_10)
                    11 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_11)
                    12 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_12)
                    13 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_13)
                    14 -> Logger.log(this, 100, R.string.log_sleeping_planet_room_14)
                    15 -> {
                        Logger.log(this, 100, R.string.log_sleeping_planet_room_15)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    5 -> Logger.log(this, 101, R.string.log_sleeping_planet_encounter_1)
                    8 -> Logger.log(this, 101, R.string.log_sleeping_planet_encounter_2)
                    10 -> Logger.log(this, 101, R.string.log_sleeping_planet_encounter_3)
                    12 -> Logger.log(this, 101, R.string.log_sleeping_planet_encounter_4)
                    14 -> Logger.log(this, 101, R.string.log_sleeping_planet_encounter_5)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_sleeping_planet_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("DreamwroughtBeast"),
            Enemy.getInstance("DreamwroughtDragon"),
            Enemy.getInstance("DreamwroughtSwarm"),
            Enemy.getInstance("DreamwroughtForge"),
            Enemy.getInstance("Singularity")
        )
    }
}
