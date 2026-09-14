package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class TheDreadfulAscent : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 2

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_the_dreadful_ascent

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_dreadful_ascent

    override fun getDetailDrawable(): Int = R.drawable.area_the_dreadful_ascent

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding.theDreadfulAscent

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress < maxProgress) {
            return CopyOnWriteArrayList()
        }
        val i = progress
        if (i == 2) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul")
            ))
        }
        if (i == 3) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul")
            ))
        }
        if (i == 4 || i == 5 || i == 8) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul"),
                Enemy.getInstance("EtherealSoul")
            ))
        }
        if (i == 10) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("KasimirTheSeer")))
        }
        if (i != 11) {
            return CopyOnWriteArrayList()
        }
        return if (Utils.gotUniqueDrop("SerpentStaff", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("HeraldKali")))
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_HeraldKali" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_SEER)
            }
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_1)
                    2 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_2)
                    3 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_3)
                    4 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_4)
                    5 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_5)
                    6 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_6)
                    7 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_7)
                    8 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_8)
                    9 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_9)
                    10 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_10)
                    11 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_11)
                    12 -> Logger.log(this, 100, R.string.log_the_dreadful_ascent_room_12)
                    13 -> {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_dreadful_ascent_room_13)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    2 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_1)
                    3 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_2)
                    4 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_3)
                    5 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_4)
                    8 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_5)
                    10 -> Logger.log(this, 101, R.string.log_the_dreadful_ascent_encounter_6)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_dreadful_ascent_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.theSouthernGrove?.let { linkedHashMap[it] = 13 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("EtherealSoul"),
            Enemy.getInstance("KasimirTheSeer"),
            Enemy.getInstance("HeraldKali")
        )
    }

    override fun completed(): Boolean {
        return maxProgress >= 13 && drops.isEmpty()
    }
}
