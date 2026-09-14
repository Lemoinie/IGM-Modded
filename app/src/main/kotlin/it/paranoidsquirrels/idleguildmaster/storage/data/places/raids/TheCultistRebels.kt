package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SkeletonKey
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class TheCultistRebels : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_the_cultist_rebels

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_cultist_rebels

    override fun getDetailDrawable(): Int = R.drawable.area_the_cultist_rebels

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding.theCultistRebels

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event ?: return CopyOnWriteArrayList()
        if (ev.key == 1 && (ev.progress in listOf(1, 2, 3, 6, 7, 8, 11, 12, 13))) {
            val dRandom = Utils.random()
            if (dRandom < 0.4) {
                return CopyOnWriteArrayList()
            }
            if (dRandom < 0.75) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("LesserTitan")))
            }
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Crusader"),
                Enemy.getInstance("Crusader"),
                Enemy.getInstance("Crusader"),
                Enemy.getInstance("Crusader"),
                Enemy.getInstance("Crusader")
            ))
        }
        if (ev.key == 1 && ev.progress == 14) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("Claris"),
                Enemy.getInstance("Thorvus")
            ))
        }
        return if (ev.key == 2 && ev.progress == 2) {
            CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PrimordialTitan")))
        } else {
            CopyOnWriteArrayList()
        }
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_Thorvus", "kill_Claris" -> {
                if (enemies.isEmpty()) {
                    QuestsManager.increment(QuestsManager.botchedRitual, 1L)
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_CULTISTS)
                }
            }
            "enter_room" -> {
                val i3 = progress
                if (i3 == 1) {
                    Logger.log(this, 100, R.string.log_the_cultist_rebels_room_1)
                } else if (i3 == 2) {
                    Logger.log(this, 100, R.string.log_the_cultist_rebels_room_2)
                } else if (i3 == 3) {
                    Logger.log(this, 100, R.string.log_the_cultist_rebels_room_3)
                } else if (i3 == 4) {
                    Logger.log(this, 100, R.string.log_the_cultist_rebels_room_4)
                } else if (i3 == 5) {
                    Logger.log(this, 100, R.string.log_the_cultist_rebels_room_5)
                    event = Event(Event.HALLS_EXPLORATION)
                } else {
                    val ev = event
                    if (ev == null) {
                        terminationRequested = true
                    } else if (ev.key == 1) {
                        val p = ev.progress
                        if (p == 3) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_7)
                            ev.progress = p + 1
                        } else if (p == 4) {
                            val dRandom = Utils.random()
                            val msgRes = if (dRandom <= 0.2) {
                                R.string.log_the_cultist_rebels_room_7a
                            } else if (dRandom <= 0.4) {
                                R.string.log_the_cultist_rebels_room_7b
                            } else if (dRandom <= 0.6) {
                                R.string.log_the_cultist_rebels_room_7c
                            } else if (dRandom <= 0.8) {
                                R.string.log_the_cultist_rebels_room_7d
                            } else {
                                R.string.log_the_cultist_rebels_room_7e
                            }
                            Logger.log(this, 100, msgRes)
                            ev.progress = p + 1
                        } else if (p == 8) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_8)
                            ev.progress = p + 1
                            for (adv in adventurersExploring) {
                                if (adv.accessory is SkeletonKey) {
                                    event = Event(Event.HALLS_SKELETON_DOOR)
                                    break
                                }
                            }
                        } else if (p == 9) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_cultist_rebels_room_9)
                            ev.progress = p + 1
                        } else if (p == 13) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_10)
                            ev.progress = p + 1
                        } else if (p == 14) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_11)
                            ev.progress = p + 1
                            terminationRequested = true
                        } else {
                            val dRandom2 = Utils.random()
                            val msgRes2 = if (dRandom2 <= 0.333) {
                                R.string.log_the_cultist_rebels_room_6a
                            } else if (dRandom2 <= 0.666) {
                                R.string.log_the_cultist_rebels_room_6b
                            } else {
                                R.string.log_the_cultist_rebels_room_6c
                            }
                            Logger.log(this, 100, msgRes2)
                            if (Utils.random() < 0.5) {
                                ev.progress = p + 1
                            }
                        }
                    } else if (ev.key == 2) {
                        val progress2 = ev.progress
                        if (progress2 == 0) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_cultist_rebels_room_9a)
                            ev.progress = progress2 + 1
                        } else if (progress2 == 1) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_10a)
                            ev.progress = progress2 + 1
                        } else if (progress2 == 2) {
                            Logger.log(this, 100, R.string.log_the_cultist_rebels_room_11)
                            ev.progress = progress2 + 1
                            terminationRequested = true
                        }
                    }
                }
            }
            "fight_start" -> {
                val ev = event
                if (ev != null) {
                    if (ev.key == 1 && ev.progress == 14) {
                        Logger.log(this, 101, R.string.log_the_cultist_rebels_encounter_3)
                    } else if (ev.key == 2 && ev.progress == 2) {
                        Logger.log(this, 101, R.string.log_the_cultist_rebels_encounter_4)
                    } else if (enemies.size != 1) {
                        Logger.log(this, 101, R.string.log_the_cultist_rebels_encounter_2)
                    } else {
                        Logger.log(this, 101, R.string.log_the_cultist_rebels_encounter_1)
                    }
                }
            }
            "kill_PrimordialTitan" -> {
                QuestsManager.increment(QuestsManager.endlessAgony, 1L)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_AGONIZING_TITAN)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_cultist_rebels_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Crusader"),
            Enemy.getInstance("LesserTitan"),
            Enemy.getInstance("Claris"),
            Enemy.getInstance("Thorvus"),
            Enemy.getInstance("PrimordialTitan")
        )
    }
}
