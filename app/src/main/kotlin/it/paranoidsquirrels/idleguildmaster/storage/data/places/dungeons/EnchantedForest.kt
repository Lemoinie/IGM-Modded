package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.Formulas
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

class EnchantedForest : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_enchanted_forest

    override fun getSummaryDrawable(): Int = R.drawable.summary_enchanted_forest

    override fun getDetailDrawable(): Int = R.drawable.area_enchanted_forest

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.enchantedForest

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key != 0) {
            if (key == 1) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ForestSpirit")))
            }
            if (key == 2) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("TutorialWolf")))
            }
        } else {
            if (dRandom >= 500.0) {
                return CopyOnWriteArrayList()
            }
            if (Formulas.getQuartersCapacity() <= 2) {
                if (dRandom < 100.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf")))
                }
                if (dRandom < 200.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Boar")))
                }
                if (dRandom < 300.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Treant")))
                }
                if (dRandom < 400.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Centaur")))
                }
                if (dRandom < 500.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")))
                }
            } else {
                if (dRandom < 10.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("GoldenRabbit")))
                }
                if (dRandom < 30.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Ent")))
                }
                if (dRandom < 80.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf")))
                }
                if (dRandom < 130.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Boar")))
                }
                if (dRandom < 180.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Treant")))
                }
                if (dRandom < 210.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Centaur")))
                }
                if (dRandom < 240.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 270.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 300.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Boar"), Enemy.getInstance("Boar")))
                }
                if (dRandom < 330.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Treant")))
                }
                if (dRandom < 360.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Boar"), Enemy.getInstance("Treant")))
                }
                if (dRandom < 380.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Treant"), Enemy.getInstance("Treant")))
                }
                if (dRandom < 400.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Centaur"), Enemy.getInstance("Centaur")))
                }
                if (dRandom < 420.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 440.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 460.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Treant"), Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 480.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Wolf"), Enemy.getInstance("Centaur"), Enemy.getInstance("Wolf")))
                }
                if (dRandom < 500.0) {
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Treant"), Enemy.getInstance("Centaur"), Enemy.getInstance("Boar")))
                }
            }
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 50.0) {
            Item.getInstance("CopperOre", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 150.0) {
            Item.getInstance("Wood", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 170.0) {
            for (adventurer in adventurersExploring) {
                adventurer.currentHp = adventurer.calculateTotalMaxHp()
            }
            refreshDialog()
            Logger.log(this, 102, R.string.log_enchanted_forest_finding_1)
            return
        }
        if (dRandom >= 190.0) {
            if (dRandom < 230.0) {
                trapEncounter(R.string.log_enchanted_forest_finding_3, R.string.dexterity, 10, 10, false)
                return
            } else {
                Logger.log(this, 41)
                return
            }
        }
        for (adventurer2 in adventurersExploring) {
            if (adventurer2.currentHp > 0) {
                adventurer2.currentMana = 100
            }
        }
        refreshDialog()
        Logger.log(this, 102, R.string.log_enchanted_forest_finding_2)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_enchanted_forest_room_1)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_enchanted_forest_room_2)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_enchanted_forest_room_3)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_enchanted_forest_room_4)
                } else {
                    Logger.log(this, 100, R.string.log_enchanted_forest_room_5)
                }
            }
            "kill_GoldenRabbit" -> {
                QuestsManager.increment(QuestsManager.softAndFluffy, 1L)
                event = Event(Event.ENRAGED_SPIRIT)
                Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_enchanted_forest_event_1a)
            }
            "fight_start" -> {
                if (event != null && event?.key == 1) {
                    event = null
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_enchanted_forest_event_1b)
                } else {
                    val dRandom2 = Utils.random()
                    if (dRandom2 < 0.2) {
                        Logger.log(this, 101, R.string.log_enchanted_forest_encounter_1)
                    } else if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_enchanted_forest_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_enchanted_forest_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_enchanted_forest_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_enchanted_forest_encounter_5)
                    }
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_enchanted_forest_enter)
                if (MainActivity.data.tutorialStep == 2) {
                    event = Event(Event.TUTORIAL)
                }
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.theDesert?.let { linkedHashMap[it] = 80 }
        MainActivity.data.theSlimePond?.let { linkedHashMap[it] = 150 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Wolf"),
            Enemy.getInstance("Boar"),
            Enemy.getInstance("Treant"),
            Enemy.getInstance("Centaur"),
            Enemy.getInstance("Ent"),
            Enemy.getInstance("GoldenRabbit"),
            Enemy.getInstance("ForestSpirit")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("Wood", 12)?.let { linkedHashMap[it] = 240 }
        Item.getInstance("WolfSkin", 8)?.let { linkedHashMap[it] = 240 }
        Item.getInstance("CopperOre", 8)?.let { linkedHashMap[it] = 240 }
        Item.getInstance("Acorn", 5)?.let { linkedHashMap[it] = 140 }
        Item.getInstance("CentaurHoof", 3)?.let { linkedHashMap[it] = 140 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("CopperSword", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WoodenBow", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WoodenStaff", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("CopperDagger", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("LeatherArmor", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ClothRobe", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("CopperArmor", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("WoodenBuckler", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ClothHat", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("Boots", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("LeatherGloves", 1)?.let { linkedHashMap[it] = 90 }
        return linkedHashMap
    }
}
