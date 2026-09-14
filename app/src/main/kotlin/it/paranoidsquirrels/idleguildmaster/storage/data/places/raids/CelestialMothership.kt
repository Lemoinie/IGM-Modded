package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Gcss
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class CelestialMothership : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 2

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_celestial_mothership

    override fun getSummaryDrawable(): Int = R.drawable.summary_celestial_mothership

    override fun getDetailDrawable(): Int = R.drawable.area_celestial_mothership

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding.celestialMothership

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress < maxProgress) {
            return CopyOnWriteArrayList()
        }
        val i = progress
        if (i == 2) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus")))
        }
        if (i == 3) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Oculus"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("Oculus")
            ))
        }
        if (i == 4 || i == 5 || i == 6) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer")
            ))
        }
        if (i == 8) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialDestroyer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer")
            ))
        }
        if (i == 9) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("CelestialDestroyer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialLancer"),
                Enemy.getInstance("CelestialDestroyer")
            ))
        }
        if (i == 12 || i == 15) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Gcss"),
                Enemy.getInstance("ReinforcedDoor"),
                Enemy.getInstance("Gcss")
            ))
        }
        if (i != 17) {
            return CopyOnWriteArrayList()
        }
        return if (Utils.gotUniqueDrop("Evo23Vial", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("LegateHadrian")))
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_ReinforcedDoor" -> {
                for (enemy in enemies) {
                    if (enemy is Gcss) {
                        enemy.currentHp = 0
                        checkDeath(enemy)
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_celestial_mothership_event_1)
                    }
                }
            }
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_1)
                    2 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_2)
                    3 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_3)
                    4 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_4)
                    5 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_5)
                    6 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_6)
                    7 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_7)
                    8 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_8)
                    9 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_9)
                    10 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_10)
                    11 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_11)
                    12 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_12)
                    13 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_13)
                    14 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_14)
                    15 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_15)
                    16 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_16)
                    17 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_17)
                    18 -> Logger.log(this, 100, R.string.log_celestial_mothership_room_18)
                    19 -> {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_celestial_mothership_room_19)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    2 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_1)
                    3 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_2)
                    4 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_3)
                    5 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_4)
                    6 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_5)
                    8 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_6)
                    9 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_7)
                    12 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_8)
                    15 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_9)
                    17 -> Logger.log(this, 101, R.string.log_celestial_mothership_encounter_10)
                }
            }
            "kill_LegateHadrian" -> {
                MainActivity.data.seenEnemies.add("Gcss")
                MainActivity.data.seenEnemies.add("ReinforcedDoor")
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_INFILTRATOR)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_celestial_mothership_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Oculus"),
            Enemy.getInstance("CelestialLancer"),
            Enemy.getInstance("CelestialDestroyer"),
            Enemy.getInstance("Gcss"),
            Enemy.getInstance("ReinforcedDoor"),
            Enemy.getInstance("LegateHadrian")
        )
    }

    override fun completed(): Boolean {
        return maxProgress >= 18 && drops.isEmpty()
    }
}
