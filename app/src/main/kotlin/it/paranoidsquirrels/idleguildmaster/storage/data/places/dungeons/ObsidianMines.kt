package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.min

class ObsidianMines : Area() {
    override fun getAreaType(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_obsidian_mines

    override fun getSummaryDrawable(): Int = R.drawable.summary_obsidian_mines

    override fun getDetailDrawable(): Int = R.drawable.area_obsidian_mines

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding.obsidianMines

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event
        if (ev != null && ev.key == 1 && ev.progress >= 70) {
            event = Event(Event.UNSPEAKABLE_HORROR_COOLDOWN)
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PaleHermit")))
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 600.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 15.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 30.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("VampireBat")))
        }
        if (dRandom < 45.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ObsidianGolem")))
        }
        if (dRandom < 60.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("LostMiner")))
        }
        if (dRandom < 85.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 110.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("VampireBat"), Enemy.getInstance("VampireBat")))
        }
        if (dRandom < 135.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat")))
        }
        if (dRandom < 160.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("LostMiner"), Enemy.getInstance("ObsidianGolem")))
        }
        if (dRandom < 200.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 240.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 280.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("VampireBat")))
        }
        if (dRandom < 320.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 360.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("VampireBat")))
        }
        if (dRandom < 400.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("ObsidianGolem")))
        }
        if (dRandom < 440.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("VampireBat"), Enemy.getInstance("Beholder"), Enemy.getInstance("ObsidianGolem")))
        }
        if (dRandom < 480.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 520.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 560.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("GiantSpider")))
        }
        if (dRandom < 600.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("VampireBat"), Enemy.getInstance("Beholder"), Enemy.getInstance("GiantSpider")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        if (Utils.random() * 1000.0 < 10.0) {
            Item.getInstance("ObsidianChunk", 1)?.let { collectItemFromGround(it) }
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.14) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_1)
                } else if (dRandom < 0.28) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_2)
                } else if (dRandom < 0.43) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_3)
                } else if (dRandom < 0.57) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_4)
                } else if (dRandom < 0.71) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_5)
                } else if (dRandom < 0.85) {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_6)
                } else {
                    Logger.log(this, 100, R.string.log_obsidian_mines_room_7)
                }
                val ev = event
                if (ev == null) {
                    event = Event(Event.UNSPEAKABLE_HORROR)
                } else {
                    if (ev.key == 2) {
                        val progress = ev.progress + 1
                        if (progress < 10) {
                            ev.progress = progress
                        } else {
                            event = Event(Event.UNSPEAKABLE_HORROR)
                        }
                    } else if (ev.key == 1) {
                        val progress2 = ev.progress
                        val z = progress2 >= 50
                        ev.progress = progress2 + (if (z) 5 else 1)
                        if (z) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_obsidian_mines_event_1a)
                        }
                    }
                }
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 < 0.2) {
                    Logger.log(this, 101, R.string.log_obsidian_mines_encounter_1)
                } else if (dRandom2 < 0.4) {
                    Logger.log(this, 101, R.string.log_obsidian_mines_encounter_2)
                } else if (dRandom2 < 0.6) {
                    Logger.log(this, 101, R.string.log_obsidian_mines_encounter_3)
                } else if (dRandom2 < 0.8) {
                    Logger.log(this, 101, R.string.log_obsidian_mines_encounter_4)
                } else {
                    Logger.log(this, 101, R.string.log_obsidian_mines_encounter_5)
                }
            }
            "kill_PaleHermit" -> {
                QuestsManager.increment(QuestsManager.darknessWithin, 1L)
            }
            "kill_Beholder" -> {
                QuestsManager.increment(QuestsManager.myopia, 1L)
            }
            "respawn" -> {
                event = Event(Event.UNSPEAKABLE_HORROR_COOLDOWN)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_obsidian_mines_enter)
            }
        }
    }

    override fun getDarkness(): Int {
        val ev = event
        if (ev == null || ev.key != 1) {
            return 10
        }
        return 10 + min(70, ev.progress)
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.theDreadfulAscent?.let { linkedHashMap[it] = 100 }
        MainActivity.data.theLostExpedition?.let { linkedHashMap[it] = 220 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("VampireBat"),
            Enemy.getInstance("GiantSpider"),
            Enemy.getInstance("ObsidianGolem"),
            Enemy.getInstance("Beholder"),
            Enemy.getInstance("LostMiner"),
            Enemy.getInstance("PaleHermit")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("BatWing", 6)?.let { linkedHashMap[it] = 230 }
        Item.getInstance("CobwebBundle", 5)?.let { linkedHashMap[it] = 230 }
        Item.getInstance("ObsidianChunk", 6)?.let { linkedHashMap[it] = 230 }
        Item.getInstance("BatTooth", 4)?.let { linkedHashMap[it] = 105 }
        Item.getInstance("SpiderLeg", 4)?.let { linkedHashMap[it] = 105 }
        Item.getInstance("EldritchTendril", 2)?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("SpiderGloves", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("SpiderBoots", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianHelm", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianShield", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("SpiderRobe", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("NightwingJacket", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianCuirass", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianSword", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianDagger", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianBow", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ObsidianScepter", 1)?.let { linkedHashMap[it] = 90 }
        return linkedHashMap
    }
}
