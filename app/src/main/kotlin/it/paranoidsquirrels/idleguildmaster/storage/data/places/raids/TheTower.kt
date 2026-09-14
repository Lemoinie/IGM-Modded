package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class TheTower : Area() {
    override fun adventurersNumber(): Int = 14

    override fun costToRefresh(): Int = 15

    override fun getAreaType(): Int = 1

    override fun getName(): Int = R.string.raid_name_the_tower

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_tower

    override fun getDetailDrawable(): Int = R.drawable.area_the_tower

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.theTower

    override fun rollEnemies(): MutableList<Enemy> {
        return when (progress) {
            8 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Lazarus")))
            12 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Phoenix")))
            16 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("HeadlessKnight")))
            22 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Ultraslime")))
            26 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TheExiled")))
            31 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TheAncient")))
            35 -> CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TheMachine")))
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
                    1 -> Logger.log(this, 100, R.string.log_the_tower_room_1)
                    2 -> Logger.log(this, 100, R.string.log_the_tower_room_2)
                    3 -> Logger.log(this, 100, R.string.log_the_tower_room_3)
                    4 -> Logger.log(this, 100, R.string.log_the_tower_room_4)
                    5 -> Logger.log(this, 100, R.string.log_the_tower_room_5)
                    6 -> Logger.log(this, 100, R.string.log_the_tower_room_6)
                    7 -> Logger.log(this, 100, R.string.log_the_tower_room_7)
                    8 -> Logger.log(this, 100, R.string.log_the_tower_room_8)
                    9 -> Logger.log(this, 100, R.string.log_the_tower_room_9)
                    10, 14, 18, 24, 28, 33 -> resurrectAndHeal()
                    11 -> Logger.log(this, 100, R.string.log_the_tower_room_11)
                    12 -> Logger.log(this, 100, R.string.log_the_tower_room_12)
                    13 -> Logger.log(this, 100, R.string.log_the_tower_room_13)
                    15 -> Logger.log(this, 100, R.string.log_the_tower_room_15)
                    16 -> Logger.log(this, 100, R.string.log_the_tower_room_16)
                    17 -> Logger.log(this, 100, R.string.log_the_tower_room_17)
                    19 -> Logger.log(this, 100, R.string.log_the_tower_room_19)
                    20 -> Logger.log(this, 100, R.string.log_the_tower_room_20)
                    21 -> Logger.log(this, 100, R.string.log_the_tower_room_21)
                    22 -> Logger.log(this, 100, R.string.log_the_tower_room_22)
                    23 -> Logger.log(this, 100, R.string.log_the_tower_room_23)
                    25 -> Logger.log(this, 100, R.string.log_the_tower_room_25)
                    26 -> Logger.log(this, 100, R.string.log_the_tower_room_26)
                    27 -> Logger.log(this, 100, R.string.log_the_tower_room_27)
                    29 -> Logger.log(this, 100, R.string.log_the_tower_room_29)
                    30 -> Logger.log(this, 100, R.string.log_the_tower_room_30)
                    31 -> Logger.log(this, 100, R.string.log_the_tower_room_31)
                    32 -> Logger.log(this, 100, R.string.log_the_tower_room_32)
                    34 -> Logger.log(this, 100, R.string.log_the_tower_room_34)
                    35 -> Logger.log(this, 100, R.string.log_the_tower_room_35)
                    36 -> Logger.log(this, 100, R.string.log_the_tower_room_36)
                    37 -> Logger.log(this, 100, R.string.log_the_tower_room_37)
                    38 -> Logger.log(this, 100, R.string.log_the_tower_room_38)
                    39 -> {
                        Logger.log(this, 100, R.string.log_the_tower_room_39)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    8 -> Logger.log(this, 101, R.string.log_the_tower_encounter_1)
                    12 -> Logger.log(this, 101, R.string.log_the_tower_encounter_2)
                    16 -> Logger.log(this, 101, R.string.log_the_tower_encounter_3)
                    22 -> Logger.log(this, 101, R.string.log_the_tower_encounter_4)
                    26 -> Logger.log(this, 101, R.string.log_the_tower_encounter_5)
                    31 -> Logger.log(this, 101, R.string.log_the_tower_encounter_6)
                    35 -> Logger.log(this, 101, R.string.log_the_tower_encounter_7)
                }
            }
            "kill_TheMachine" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_TOWER)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_tower_enter)
            }
        }
    }

    private fun resurrectAndHeal() {
        var deadAdv: Adventurer? = null
        for (adventurer2 in adventurersExploring) {
            if (adventurer2.currentHp <= 0 && deadAdv == null) {
                deadAdv = adventurer2
            }
            if (adventurer2.currentHp > 0) {
                adventurer2.currentHp = adventurer2.calculateTotalMaxHp()
            }
        }
        if (deadAdv != null) {
            deadAdv.currentHp = deadAdv.calculateTotalMaxHp()
            Logger.log(this, 102, R.string.log_the_tower_event_resurrect)
        }
        Logger.log(this, 102, R.string.log_the_tower_event_heal)
    }

    override fun getDarkness(): Int {
        return if (progress == 31) 50 else 0
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Lazarus"),
            Enemy.getInstance("Phoenix"),
            Enemy.getInstance("HeadlessKnight"),
            Enemy.getInstance("Ultraslime"),
            Enemy.getInstance("TheExiled"),
            Enemy.getInstance("TheAncient"),
            Enemy.getInstance("TheMachine")
        )
    }
}
