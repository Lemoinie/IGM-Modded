package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
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

class DivineArcheology : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 2

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_divine_archeology

    override fun getSummaryDrawable(): Int = R.drawable.summary_divine_archeology

    override fun getDetailDrawable(): Int = R.drawable.area_divine_archeology

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.divineArcheology

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress < maxProgress) {
            return CopyOnWriteArrayList()
        }
        val i = progress
        if (i == 2) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("ShahuriWarrior"),
                Enemy.getInstance("ShahuriArcher"),
                Enemy.getInstance("ShahuriMage"),
                Enemy.getInstance("ShahuriArcher"),
                Enemy.getInstance("ShahuriWarrior")
            ))
        }
        if (i == 9) {
            return if (Utils.gotUniqueDrop("EyesOfTheSwordsman", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShaKireFirstSwordsman")))
        }
        if (i == 12) {
            val ev = event
            if (ev == null || ev.key != 1) {
                return CopyOnWriteArrayList()
            }
            return if (Utils.gotUniqueDrop("DivineZygote", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShaTheHiddenGod")))
        }
        if (i == 4 || i == 5 || i == 6) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("SandDemon"),
                Enemy.getInstance("SandDemon"),
                Enemy.getInstance("SandDemon"),
                Enemy.getInstance("SandDemon"),
                Enemy.getInstance("SandDemon")
            ))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        var iCalculateTotalConstitution = 0
        when (str) {
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_divine_archeology_room_1)
                    2 -> Logger.log(this, 100, R.string.log_divine_archeology_room_2)
                    3 -> Logger.log(this, 100, R.string.log_divine_archeology_room_3)
                    4, 5, 6 -> Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_divine_archeology_room_4)
                    7 -> Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_divine_archeology_room_5)
                    8 -> Logger.log(this, 100, R.string.log_divine_archeology_room_6)
                    9 -> Logger.log(this, 100, R.string.log_divine_archeology_room_7)
                    10 -> Logger.log(this, 100, R.string.log_divine_archeology_room_8)
                    11 -> Logger.log(this, 100, R.string.log_divine_archeology_room_9)
                    12 -> {
                        for (adventurer in adventurersExploring) {
                            if (adventurer.currentHp > 0) {
                                iCalculateTotalConstitution += adventurer.calculateTotalConstitution()
                            }
                        }
                        if (iCalculateTotalConstitution >= 200) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_divine_archeology_room_10b)
                            event = Event(Event.PYRAMID_DOOR_OPEN)
                        } else {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_divine_archeology_room_10a)
                            terminationRequested = true
                            event = null
                        }
                    }
                    13 -> {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_divine_archeology_room_11)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    2 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_1)
                    9 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_5)
                    12 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_6)
                    4 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_2)
                    5 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_3)
                    6 -> Logger.log(this, 101, R.string.log_divine_archeology_encounter_4)
                }
            }
            "kill_ShaTheHiddenGod" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_DEICIDE)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_divine_archeology_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("ShahuriWarrior"),
            Enemy.getInstance("ShahuriArcher"),
            Enemy.getInstance("ShahuriMage"),
            Enemy.getInstance("SandDemon"),
            Enemy.getInstance("ShaKireFirstSwordsman"),
            Enemy.getInstance("ShaTheHiddenGod")
        )
    }

    override fun completed(): Boolean {
        return maxProgress >= 13 && drops.isEmpty()
    }
}
