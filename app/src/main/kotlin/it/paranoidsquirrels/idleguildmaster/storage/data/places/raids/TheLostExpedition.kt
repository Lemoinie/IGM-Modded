package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.min

class TheLostExpedition : Area() {
    companion object {
        private const val PROBABILITY_OF_TRAPDOOR = 0.2
    }

    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 100

    override fun getName(): Int = R.string.raid_name_the_lost_expedition

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_lost_expedition

    override fun getDetailDrawable(): Int = R.drawable.area_the_lost_expedition

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.theLostExpedition

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event
        if (ev == null) {
            val i = progress
            if (i == 2) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("LostMiner")))
            }
            if (i == 4) {
                return CopyOnWriteArrayList(listOfNotNull(
                    Enemy.getInstance("LostMiner"),
                    Enemy.getInstance("LostMiner"),
                    Enemy.getInstance("LostMiner"),
                    Enemy.getInstance("LostMiner"),
                    Enemy.getInstance("LostMiner")
                ))
            }
            if (i != 14) {
                when (i) {
                    8 -> return CopyOnWriteArrayList(listOfNotNull(
                        Enemy.getInstance("BleakDisciple"),
                        Enemy.getInstance("EldritchHound"),
                        Enemy.getInstance("BleakDisciple")
                    ))
                    9 -> return CopyOnWriteArrayList(listOfNotNull(
                        Enemy.getInstance("EldritchHound"),
                        Enemy.getInstance("EldritchHound"),
                        Enemy.getInstance("BleakDisciple"),
                        Enemy.getInstance("EldritchHound"),
                        Enemy.getInstance("EldritchHound")
                    ))
                    10 -> return CopyOnWriteArrayList(listOfNotNull(
                        Enemy.getInstance("EldritchHound"),
                        Enemy.getInstance("BleakDisciple"),
                        Enemy.getInstance("BleakDeacon"),
                        Enemy.getInstance("BleakDisciple"),
                        Enemy.getInstance("EldritchHound")
                    ))
                }
            }
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("BleakDisciple"),
                Enemy.getInstance("AvatarOfTheAncient"),
                Enemy.getInstance("BleakDisciple")
            ))
        }
        val p = ev.progress
        if (p == 5) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("LostMiner"),
                Enemy.getInstance("LostMiner")
            ))
        }
        if (p == 7) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("LostMiner"),
                Enemy.getInstance("LostMiner"),
                Enemy.getInstance("TekeliLiFirstApostle"),
                Enemy.getInstance("LostMiner"),
                Enemy.getInstance("LostMiner")
            ))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val ev = event
                if (ev == null) {
                    when (progress) {
                        1 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_1)
                        2 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_2)
                        3 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_3)
                        4 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_4)
                        5 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_5)
                        6 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_6)
                        7 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_7)
                        8 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_8)
                        9 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_9)
                        10 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_10)
                        11 -> {
                            Logger.log(this, 100, R.string.log_the_lost_expedition_room_11)
                            if (Utils.random() < PROBABILITY_OF_TRAPDOOR) {
                                event = Event(Event.LOST_EXPEDITION_TRAPDOOR)
                            }
                        }
                        12 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_12)
                        13 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_13)
                        14 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_14)
                        15 -> {
                            Logger.log(this, 100, R.string.log_the_lost_expedition_room_15)
                            terminationRequested = true
                        }
                    }
                } else {
                    when (ev.progress) {
                        1 -> {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_lost_expedition_room_12a)
                            val barrier = petExploring?.barrier ?: 0
                            for (adventurer in adventurersExploring) {
                                if (adventurer.currentHp > 0) {
                                    val iApplyDamage = adventurer.applyDamage(40.0, false, barrier, 0.0)
                                    refreshDialog()
                                    Logger.log(this, 112, adventurer, iApplyDamage)
                                }
                            }
                        }
                        2 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_13a)
                        3 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_14a)
                        4 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_15a)
                        5 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_16a)
                        6 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_17a)
                        7 -> Logger.log(this, 100, R.string.log_the_lost_expedition_room_18a)
                        8 -> {
                            Logger.log(this, 100, R.string.log_the_lost_expedition_room_19a)
                            terminationRequested = true
                        }
                    }
                    ev.progress = min(8, ev.progress + 1)
                }
            }
            "kill_AvatarOfTheAncient" -> {
                QuestsManager.increment(QuestsManager.eldritchHorror, 1L)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_COSMIC_HORROR)
            }
            "fight_start" -> {
                val ev = event
                if (ev == null) {
                    val i = progress
                    if (i == 2) {
                        Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_1)
                    } else if (i == 4) {
                        Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_2)
                    } else if (i != 14) {
                        when (i) {
                            8 -> Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_3)
                            9 -> Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_4)
                            10 -> Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_5)
                        }
                    } else {
                        Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_6)
                    }
                } else {
                    val p = ev.progress
                    if (p == 5) {
                        Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_6a)
                    } else if (p == 7) {
                        Logger.log(this, 101, R.string.log_the_lost_expedition_encounter_7a)
                    }
                }
            }
            "kill_TekeliLiFirstApostle" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_APOSTLE)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_lost_expedition_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("LostMiner"),
            Enemy.getInstance("BleakDisciple"),
            Enemy.getInstance("EldritchHound"),
            Enemy.getInstance("BleakDeacon"),
            Enemy.getInstance("TekeliLiFirstApostle"),
            Enemy.getInstance("AvatarOfTheAncient")
        )
    }
}
