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

class FrostbitePeaks : Area() {
    override fun getAreaType(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_frostbite_peaks

    override fun getSummaryDrawable(): Int = R.drawable.summary_frostbite_peaks

    override fun getDetailDrawable(): Int = R.drawable.area_frostbite_peaks

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding.frostbitePeaks

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 470.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 30.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SnowWyvern")))
        }
        if (dRandom < 60.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("IceElemental")))
        }
        if (dRandom < 90.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 120.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 150.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Troll")))
        }
        if (dRandom < 180.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 210.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 240.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 270.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Troll"), Enemy.getInstance("Troll")))
        }
        if (dRandom < 300.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Troll"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 330.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 360.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("Troll")))
        }
        if (dRandom < 390.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Troll"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 410.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman")))
        }
        if (dRandom < 430.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("TrollWhelp")))
        }
        if (dRandom < 450.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("Troll")))
        }
        if (dRandom < 470.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("TrollWarrior")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 10.0) {
            if (dRandom < 30.0) {
                Item.getInstance("Winterwood", 1)?.let { collectItemFromGround(it) }
                return
            }
            if (dRandom < 50.0) {
                Item.getInstance("IceFiber", 1)?.let { collectItemFromGround(it) }
                return
            }
            if (dRandom < 60.0) {
                Item.getInstance("FrostmetalOre", 1)?.let { collectItemFromGround(it) }
                return
            } else if (dRandom < 100.0) {
                trapEncounter(R.string.log_frostbite_peaks_finding_2, R.string.constitution, 35, 70, false)
                return
            } else {
                Logger.log(this, 41)
                return
            }
        }
        var adventurer: Adventurer? = null
        var i = 0
        for (adventurer2 in adventurersExploring) {
            if (adventurer2.currentHp > 0) {
                val iCalculateTotalDexterity = adventurer2.calculateTotalDexterity()
                if (adventurer == null || iCalculateTotalDexterity > i) {
                    adventurer = adventurer2
                    i = iCalculateTotalDexterity
                }
            }
        }
        if (adventurer != null) {
            val i2 = i / 2
            Logger.log(this, 51, i, adventurer.idName, i2)
            if (Utils.random() * 100.0 < i2) {
                Logger.log(this, 53, adventurer.idName)
                Item.getInstance("Winterwood", 3)?.let { collectItemFromGround(it) }
                Item.getInstance("FrostmetalOre", 3)?.let { collectItemFromGround(it) }
                Item.getInstance("IceFiber", 3)?.let { collectItemFromGround(it) }
                if (Utils.random() < 0.25) {
                    Item.getInstance("FrostCrystal", 1)?.let { collectItemFromGround(it) }
                    return
                }
                return
            }
            Logger.log(this, 52, adventurer.idName)
            return
        }
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        var z = false
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.14) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_1)
                } else if (dRandom < 0.28) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_2)
                } else if (dRandom < 0.43) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_3)
                } else if (dRandom < 0.57) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_4)
                } else if (dRandom < 0.71) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_5)
                } else if (dRandom < 0.85) {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_6)
                } else {
                    Logger.log(this, 100, R.string.log_frostbite_peaks_room_7)
                }
                if (event == null) {
                    if (Utils.random() < 0.01) {
                        event = Event(Event.BLIZZARD)
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_frostbite_peaks_event_1a)
                    }
                } else if (event?.key == 1) {
                    val progress = (event?.progress ?: 0) + 1
                    event?.progress = progress
                    if (progress > 5) {
                        event = null
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_frostbite_peaks_event_1b)
                    }
                }
                val statusEffect = StatusEffect(StatusEffectType.FROZEN, null, 3, 100.0)
                if (event != null && event?.key == 1) {
                    z = true
                }
                for (adventurer in adventurersExploring) {
                    if (Utils.random() < if (z) 0.15 else 0.05) {
                        applyStatus(adventurer, statusEffect, 0.0)
                    }
                }
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 >= 0.2) {
                    if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_frostbite_peaks_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_frostbite_peaks_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_frostbite_peaks_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_frostbite_peaks_encounter_5)
                    }
                } else {
                    Logger.log(this, 101, R.string.log_frostbite_peaks_encounter_1)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_frostbite_peaks_enter)
            }
            "kill_IceElemental" -> {
                QuestsManager.increment(QuestsManager.iceBreaker, 1L)
            }
        }
    }

    override fun getDarkness(): Int {
        if (event == null || event?.key != 1) {
            return 0
        }
        return (Utils.random() * 20.0).toInt() + 40
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.obsidianMines?.let { linkedHashMap[it] = 100 }
        MainActivity.data.theCultistRebels?.let { linkedHashMap[it] = 150 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("TrollWhelp"),
            Enemy.getInstance("Troll"),
            Enemy.getInstance("TrollWarrior"),
            Enemy.getInstance("TrollShaman"),
            Enemy.getInstance("IceElemental"),
            Enemy.getInstance("SnowWyvern")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("IceFiber", 6)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("FrostmetalOre", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("TrollHide", 5)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("Winterwood", 6)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("FrostCrystal", 1)?.let { linkedHashMap[it] = 200 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("FrostmetalSword", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterwoodBow", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterwoodStaff", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("FrostmetalDagger", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterCape", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("TrollskinJacket", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("FrostmetalArmor", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterBoots", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterGloves", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterHelm", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WinterShield", 1)?.let { linkedHashMap[it] = 90 }
        return linkedHashMap
    }
}
