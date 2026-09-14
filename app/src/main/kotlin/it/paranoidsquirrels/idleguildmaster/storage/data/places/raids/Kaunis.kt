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

class Kaunis : Area() {
    override fun adventurersNumber(): Int = 14

    override fun costToRefresh(): Int = 15

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 18

    override fun getName(): Int = R.string.raid_name_kaunis

    override fun getSummaryDrawable(): Int = R.drawable.summary_kaunis

    override fun getDetailDrawable(): Int = R.drawable.area_kaunis

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.kaunis

    override fun rollEnemies(): MutableList<Enemy> {
        return when (progress) {
            1 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot")
            ))
            6 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Enforcer"),
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot")
            ))
            9 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Phantasm")))
            10 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Enforcer"),
                Enemy.getInstance("Enforcer"),
                Enemy.getInstance("Necrobot")
            ))
            11 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Cerebrum"),
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Necrobot")
            ))
            12 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrobot"),
                Enemy.getInstance("Phantasm"),
                Enemy.getInstance("Necrobot")
            ))
            16 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("ChiefScientistAva"),
                Enemy.getInstance("KingAino"),
                Enemy.getInstance("FirstMinisterAtos")
            ))
            else -> CopyOnWriteArrayList()
        }
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_KingAino", "kill_ChiefScientistAva", "kill_FirstMinisterAtos" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_COUNCIL)
            }
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_kaunis_room_1)
                    2 -> Logger.log(this, 100, R.string.log_kaunis_room_2)
                    3 -> Logger.log(this, 100, R.string.log_kaunis_room_3)
                    4 -> Logger.log(this, 100, R.string.log_kaunis_room_4)
                    5 -> Logger.log(this, 100, R.string.log_kaunis_room_5)
                    6 -> Logger.log(this, 100, R.string.log_kaunis_room_6)
                    7 -> Logger.log(this, 100, R.string.log_kaunis_room_7)
                    8 -> Logger.log(this, 100, R.string.log_kaunis_room_8)
                    9 -> Logger.log(this, 100, R.string.log_kaunis_room_9)
                    10 -> Logger.log(this, 100, R.string.log_kaunis_room_10)
                    11 -> Logger.log(this, 100, R.string.log_kaunis_room_11)
                    12 -> Logger.log(this, 100, R.string.log_kaunis_room_12)
                    13 -> Logger.log(this, 100, R.string.log_kaunis_room_13)
                    14 -> Logger.log(this, 100, R.string.log_kaunis_room_14)
                    15 -> Logger.log(this, 100, R.string.log_kaunis_room_15)
                    16 -> Logger.log(this, 100, R.string.log_kaunis_room_16)
                    17 -> {
                        Logger.log(this, 100, R.string.log_kaunis_room_17)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    1 -> Logger.log(this, 101, R.string.log_kaunis_encounter_1)
                    6 -> Logger.log(this, 101, R.string.log_kaunis_encounter_2)
                    9 -> Logger.log(this, 101, R.string.log_kaunis_encounter_3)
                    10 -> Logger.log(this, 101, R.string.log_kaunis_encounter_4)
                    11 -> Logger.log(this, 101, R.string.log_kaunis_encounter_5)
                    12 -> Logger.log(this, 101, R.string.log_kaunis_encounter_6)
                    16 -> Logger.log(this, 101, R.string.log_kaunis_encounter_7)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_kaunis_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Necrobot"),
            Enemy.getInstance("Enforcer"),
            Enemy.getInstance("Phantasm"),
            Enemy.getInstance("Cerebrum"),
            Enemy.getInstance("ChiefScientistAva"),
            Enemy.getInstance("KingAino"),
            Enemy.getInstance("FirstMinisterAtos")
        )
    }
}
