package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.min

class TheDesert : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_the_desert

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_desert

    override fun getDetailDrawable(): Int = R.drawable.area_the_desert

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding.theDesert

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key == 0 || key == 1) {
            if (dRandom >= 450.0) {
                return CopyOnWriteArrayList()
            }
            if (dRandom < 25.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 50.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriArcher")))
            }
            if (dRandom < 75.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wurm")))
            }
            if (dRandom < 100.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SandVulture")))
            }
            if (dRandom < 125.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wurm"), Enemy.getInstance("SandVulture")))
            }
            if (dRandom < 150.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wurm"), Enemy.getInstance("Wurm")))
            }
            if (dRandom < 175.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SandVulture"), Enemy.getInstance("SandVulture")))
            }
            if (dRandom < 200.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 225.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriArcher")))
            }
            if (dRandom < 245.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wurm"), Enemy.getInstance("SandVulture"), Enemy.getInstance("Wurm")))
            }
            if (dRandom < 265.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher")))
            }
            if (dRandom < 285.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 305.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage")))
            }
            if (dRandom < 325.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 345.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage")))
            }
            if (dRandom < 360.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage")))
            }
            if (dRandom < 375.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 390.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 405.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher")))
            }
            if (dRandom < 420.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage")))
            }
            if (dRandom < 435.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior")))
            }
            if (dRandom < 450.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Djinn")))
            }
        } else if (key == 2) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key != 0 && key != 1) {
            if (key != 2) {
                return
            }
            Logger.log(this, 41)
            return
        }
        if (dRandom < 10.0) {
            Item.getInstance("Quartz", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 35.0) {
            Item.getInstance("Sandstone", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 85.0) {
            Logger.log(this, 101, R.string.log_the_desert_finding_1)
            val statusEffect = StatusEffect(StatusEffectType.SILENCE, null, 5, 100.0)
            for (adventurer in adventurersExploring) {
                if (adventurer.currentHp > 0) {
                    applyStatus(adventurer, statusEffect, 0.0)
                }
            }
            return
        }
        if (dRandom < 100.0) {
            for (adventurer2 in adventurersExploring) {
                if (adventurer2.currentHp > 0) {
                    adventurer2.currentHp = min(adventurer2.calculateTotalMaxHp(), adventurer2.currentHp + 10)
                    adventurer2.currentMana = min(100, adventurer2.currentMana + 10)
                }
            }
            refreshDialog()
            Logger.log(this, 102, R.string.log_the_desert_finding_2)
            return
        }
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        val key = event?.key ?: 0
        when (str) {
            "kill_SandStatue" -> {
                QuestsManager.increment(QuestsManager.godFeared, 1L)
            }
            "kill_ShahuriWarrior", "kill_ShahuriMage", "kill_ShahuriArcher" -> {
                if (key == 0) {
                    val ev = Event(Event.SHAHURI_ARMY_CHARGING)
                    ev.progress = 1
                    event = ev
                    Logger.log(this, 44, R.string.log_the_desert_event_1a, 1)
                } else if (key == 1) {
                    val ev = event
                    if (ev != null) {
                        val progress = ev.progress + 1
                        ev.progress = progress
                        Logger.log(this, 44, R.string.log_the_desert_event_1a, progress)
                        if (ev.progress >= 100) {
                            event = Event(Event.SHAHURI_ARMY_READY)
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_desert_event_1b)
                        }
                    }
                }
                QuestsManager.increment(QuestsManager.conqueror, 1L)
            }
            "enter_room" -> {
                if (key == 0 || key == 1) {
                    val dRandom = Utils.random()
                    if (dRandom < 0.2) {
                        Logger.log(this, 100, R.string.log_the_desert_room_1)
                    } else if (dRandom < 0.4) {
                        Logger.log(this, 100, R.string.log_the_desert_room_2)
                    } else if (dRandom < 0.6) {
                        Logger.log(this, 100, R.string.log_the_desert_room_3)
                    } else if (dRandom < 0.8) {
                        Logger.log(this, 100, R.string.log_the_desert_room_4)
                    } else {
                        Logger.log(this, 100, R.string.log_the_desert_room_5)
                    }
                } else if (key == 2) {
                    val ev = event
                    if (ev != null) {
                        if (ev.progress < 10) {
                            Logger.log(this, 100, R.string.log_the_desert_event_1c)
                        } else {
                            event = null
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_desert_event_1e)
                        }
                    }
                }
            }
            "fight_start" -> {
                if (key == 0 || key == 1) {
                    val dRandom2 = Utils.random()
                    if (dRandom2 < 0.2) {
                        Logger.log(this, 101, R.string.log_the_desert_encounter_1)
                    } else if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_the_desert_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_the_desert_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_the_desert_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_the_desert_encounter_5)
                    }
                } else if (key == 2) {
                    val ev = event
                    if (ev != null) {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_desert_event_1d)
                        ev.progress = ev.progress + 1
                    }
                }
            }
            "respawn" -> {
                event = null
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_desert_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.eternalBattlefield?.let { linkedHashMap[it] = 100 }
        MainActivity.data.divineArcheology?.let { linkedHashMap[it] = 150 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Wurm"),
            Enemy.getInstance("SandVulture"),
            Enemy.getInstance("ShahuriWarrior"),
            Enemy.getInstance("ShahuriArcher"),
            Enemy.getInstance("ShahuriMage"),
            Enemy.getInstance("Djinn"),
            Enemy.getInstance("SandStatue")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("ScrapMetal", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("Sandstone", 6)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("WurmScale", 8)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("Feather", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("MetamorphicSand", 10)?.let { linkedHashMap[it] = 200 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("GlassKnife", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("WurmscalesShield", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("FeatherRobe", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("WurmscalesGloves", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("Scimitar", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("ShahuriBow", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("IronChainmail", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("WurmscalesJacket", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("WurmscalesBoots", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("IronHelm", 1)?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }
}
