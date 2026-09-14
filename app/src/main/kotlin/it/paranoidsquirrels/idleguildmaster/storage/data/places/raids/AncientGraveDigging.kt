package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Necrolith
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class AncientGraveDigging : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 1

    override fun getName(): Int = R.string.raid_name_ancient_grave_digging

    override fun getSummaryDrawable(): Int = R.drawable.summary_ancient_grave_digging

    override fun getDetailDrawable(): Int = R.drawable.area_ancient_grave_digging

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.ancientGraveDigging

    override fun rollEnemies(): MutableList<Enemy> {
        return when (progress) {
            3 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Undead"),
                Enemy.getInstance("Undead"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("Undead"),
                Enemy.getInstance("Undead")
            ))
            4 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Undead"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("Abomination"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("Undead")
            ))
            6 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("UndeadArcher"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadGeneral"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadArcher")
            ))
            11 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Necrolith"),
                Enemy.getInstance("KabarTheRotten"),
                Enemy.getInstance("Necrolith")
            ))
            8 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("DeathHound"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("DeathHound")
            ))
            9 -> CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadGeneral"),
                Enemy.getInstance("UndeadWarlord"),
                Enemy.getInstance("UndeadWarlord")
            ))
            else -> CopyOnWriteArrayList()
        }
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_1)
                    2 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_2)
                    3 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_3)
                    4 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_4)
                    5 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_5)
                    6 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_6)
                    7 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_7)
                    8 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_8)
                    9 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_9)
                    10 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_10)
                    11 -> Logger.log(this, 100, R.string.log_ancient_grave_digging_room_11)
                    12 -> {
                        Logger.log(this, 100, R.string.log_ancient_grave_digging_room_12)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    3 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_1)
                    4 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_2)
                    6 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_3)
                    11 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_6)
                    8 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_4)
                    9 -> Logger.log(this, 101, R.string.log_ancient_grave_digging_encounter_5)
                }
            }
            "kill_KabarTheRotten" -> {
                for (enemy in enemies) {
                    if (enemy is Necrolith) {
                        enemy.currentHp = 0
                        checkDeath(enemy)
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_ancient_grave_digging_event_1)
                    }
                }
                QuestsManager.increment(QuestsManager.andStayDead, 1L)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_NECROMANCER)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_ancient_grave_digging_enter)
            }
        }
    }

    override fun getDarkness(): Int = progress + 25

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Undead"),
            Enemy.getInstance("UndeadArcher"),
            Enemy.getInstance("DeathHound"),
            Enemy.getInstance("UndeadWarlord"),
            Enemy.getInstance("Abomination"),
            Enemy.getInstance("UndeadGeneral"),
            Enemy.getInstance("KabarTheRotten"),
            Enemy.getInstance("Necrolith")
        )
    }
}
