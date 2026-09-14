package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.max

class TheSouthernGrove : Area() {
    companion object {
        private const val PROGRESS_FOR_WURM = 14000
    }

    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 15

    override fun getName(): Int = R.string.dungeon_name_the_southern_grove

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_southern_grove

    override fun getDetailDrawable(): Int = R.drawable.area_the_southern_grove

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.theSouthernGrove

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event
        if (ev != null && ev.key == 1 && ev.progress >= PROGRESS_FOR_WURM) {
            event = Event(Event.PRIMEVAL_WURM_COOLDOWN)
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PrimevalWurm")))
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 600.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 20.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantTortoise")))
        }
        if (dRandom < 40.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 60.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 90.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 120.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 150.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 180.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 210.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("AncientEnt"), Enemy.getInstance("Dryad")))
        }
        if (dRandom < 240.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantMoth"), Enemy.getInstance("AncientEnt"), Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 260.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 280.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 300.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 320.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("Dryad")))
        }
        if (dRandom < 340.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("Dryad"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth")))
        }
        if (dRandom < 360.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("AncientEnt"), Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 380.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")))
        }
        if (dRandom < 400.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val ev = event ?: Event(Event.PRIMEVAL_WURM_PROGRESS).also { event = it }
        if (ev.key == 1) {
            var dCalculateTotalDexterity = 0.0
            var i = 0
            for (adventurer in adventurersExploring) {
                if (adventurer.currentHp > 0 && !adventurer.isSummonedMinion()) {
                    dCalculateTotalDexterity += adventurer.calculateTotalDexterity().toDouble()
                    i++
                }
            }
            val iRound = Utils.round(dCalculateTotalDexterity / max(1, i).toDouble())
            val iMax = max(14, 300 - iRound)
            ev.progress = ev.progress + iMax
            val progress = ((PROGRESS_FOR_WURM - ev.progress) / iMax) + 1
            if (ev.progress >= PROGRESS_FOR_WURM) {
                trapEncounter(R.string.log_the_southern_grove_wurm_trap, R.string.dexterity, 80, 1000, false)
                return
            }
            Logger.log(this, 104, iRound, progress)
        } else if (ev.key == 2) {
            ev.progress = ev.progress + 1
            if (ev.progress > 40) {
                event = Event(Event.PRIMEVAL_WURM_PROGRESS)
            }
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 60.0) {
            Item.getInstance("ElysianWood", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 110.0) {
            trapEncounter(R.string.log_the_southern_grove_finding_1, R.string.dexterity, 50, 75, false)
        } else if (dRandom < 135.0) {
            trapEncounter(R.string.log_the_southern_grove_finding_2, R.string.intelligence, 40, 90, true)
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_Dryad" -> {
                QuestsManager.increment(QuestsManager.innocence, 1L)
            }
            "enter_room" -> {
                val ev = event
                if (ev != null && ev.key == 1) {
                    QuestsManager.incrementToValue(QuestsManager.marathon, progress.toLong())
                }
                val dRandom = Utils.random()
                if (dRandom < 0.1) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_1)
                } else if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_2)
                } else if (dRandom < 0.3) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_3)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_4)
                } else if (dRandom < 0.5) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_5)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_6)
                } else if (dRandom < 0.7) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_7)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_8)
                } else if (dRandom < 0.9) {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_9)
                } else {
                    Logger.log(this, 100, R.string.log_the_southern_grove_room_10)
                }
            }
            "kill_GiantTortoise" -> {
                QuestsManager.increment(QuestsManager.speedyHare, 1L)
            }
            "fight_start" -> {
                val ev = event
                if (ev != null && ev.key == 2 && ev.progress == 0) {
                    Logger.log(this, 101, R.string.log_the_southern_grove_wurm_spawn)
                } else {
                    val dRandom2 = Utils.random()
                    if (dRandom2 < 0.2) {
                        Logger.log(this, 101, R.string.log_the_southern_grove_encounter_1)
                    } else if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_the_southern_grove_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_the_southern_grove_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_the_southern_grove_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_the_southern_grove_encounter_5)
                    }
                }
            }
            "respawn" -> {
                event = Event(Event.PRIMEVAL_WURM_PROGRESS)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_southern_grove_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.barrenWastelands?.let { linkedHashMap[it] = 60 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("GiantTortoise"),
            Enemy.getInstance("GiantMoth"),
            Enemy.getInstance("GreenSpitfang"),
            Enemy.getInstance("Dryad"),
            Enemy.getInstance("AncientEnt"),
            Enemy.getInstance("PrimevalWurm")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("ElysianWood", 12)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("SpitfangScale", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("GiantShellFragment", 6)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("GiantMothWing", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("FleetfootFabric", 2)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("TortoiseThorn", 2)?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("TortoiseArmor", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("SpitfangJacket", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("MothRobe", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("VerdantHelm", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("TortoiseShield", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("VerdantBoots", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("VerdantGloves", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("VerdantBow", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("VerdantBlade", 1)?.let { linkedHashMap[it] = 112 }
        return linkedHashMap
    }
}
