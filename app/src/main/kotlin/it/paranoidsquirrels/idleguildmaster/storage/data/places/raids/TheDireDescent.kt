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

class TheDireDescent : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 2

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_the_dire_descent

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_dire_descent

    override fun getDetailDrawable(): Int = R.drawable.area_the_dire_descent

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding.theDireDescent

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress < maxProgress) {
            return CopyOnWriteArrayList()
        }
        if (progress != 5) {
            return CopyOnWriteArrayList()
        }
        return if (Utils.gotUniqueDrop("SerpentLunge", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(
            Enemy.getInstance("HeraldXavi"),
            Enemy.getInstance("HeraldMaya"),
            Enemy.getInstance("HeraldShoran")
        ))
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_1)
                    2 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_2)
                    3 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_3)
                    4 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_4)
                    5 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_5)
                    6 -> {
                        Logger.log(this, 100, R.string.log_the_dire_descent_room_6)
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_CORE)
                    }
                    7 -> Logger.log(this, 100, R.string.log_the_dire_descent_room_7)
                    8 -> {
                        Logger.log(this, 100, R.string.log_the_dire_descent_room_8)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                if (progress == 5) {
                    Logger.log(this, 101, R.string.log_the_dire_descent_encounter_1)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_dire_descent_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.sleepingPlanet?.let { linkedHashMap[it] = 7 }
        MainActivity.data.kaunis?.let { linkedHashMap[it] = 7 }
        MainActivity.data.theTower?.let { linkedHashMap[it] = 7 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("HeraldXavi"),
            Enemy.getInstance("HeraldMaya"),
            Enemy.getInstance("HeraldShoran")
        )
    }

    override fun completed(): Boolean {
        return maxProgress >= 7 && drops.isEmpty()
    }
}
