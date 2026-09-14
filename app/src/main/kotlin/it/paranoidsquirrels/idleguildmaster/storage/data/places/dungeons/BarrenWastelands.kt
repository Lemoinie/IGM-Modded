package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class BarrenWastelands : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_barren_wastelands

    override fun getSummaryDrawable(): Int = R.drawable.summary_barren_wastelands

    override fun getDetailDrawable(): Int = R.drawable.area_barren_wastelands

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding.barrenWastelands

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 495.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 100.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Banshee")))
        }
        if (dRandom < 130.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Banshee")))
        }
        if (dRandom < 160.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Banshee")))
        }
        if (dRandom < 190.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Banshee")))
        }
        if (dRandom < 220.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Banshee"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 250.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus"), Enemy.getInstance("Banshee"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast")))
        }
        if (dRandom < 280.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Banshee"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast")))
        }
        if (dRandom < 310.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Banshee"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer")))
        }
        if (dRandom < 335.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 352.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 369.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 386.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast")))
        }
        if (dRandom < 403.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 420.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 437.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer")))
        }
        if (dRandom < 454.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 471.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")))
        }
        if (dRandom < 488.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast")))
        }
        if (dRandom < 495.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("Oculus")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        if (Utils.random() * 1000.0 < 20.0) {
            trapEncounter(R.string.log_barren_wastelands_finding_1, R.string.dexterity, 30, 70, false)
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_Banshee" -> {
                QuestsManager.increment(QuestsManager.clashOfTitans, 1L)
            }
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.1) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_1)
                } else if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_2)
                } else if (dRandom < 0.3) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_3)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_4)
                } else if (dRandom < 0.5) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_5)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_6)
                } else if (dRandom < 0.7) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_7)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_8)
                } else if (dRandom < 0.9) {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_9)
                } else {
                    Logger.log(this, 100, R.string.log_barren_wastelands_room_10)
                }
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 < 0.2) {
                    Logger.log(this, 101, R.string.log_barren_wastelands_encounter_1)
                } else if (dRandom2 < 0.4) {
                    Logger.log(this, 101, R.string.log_barren_wastelands_encounter_2)
                } else if (dRandom2 < 0.6) {
                    Logger.log(this, 101, R.string.log_barren_wastelands_encounter_3)
                } else if (dRandom2 < 0.8) {
                    Logger.log(this, 101, R.string.log_barren_wastelands_encounter_4)
                } else {
                    Logger.log(this, 101, R.string.log_barren_wastelands_encounter_5)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_barren_wastelands_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.hiddenCityOfLarox?.let { linkedHashMap[it] = 100 }
        MainActivity.data.celestialMothership?.let { linkedHashMap[it] = 180 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Iconoclast"),
            Enemy.getInstance("Oculus"),
            Enemy.getInstance("CelestialLancer"),
            Enemy.getInstance("CelestialDestroyer"),
            Enemy.getInstance("Banshee")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("ElasticMembrane", 12)?.let { linkedHashMap[it] = 260 }
        Item.getInstance("CelestialScraps", 5)?.let { linkedHashMap[it] = 260 }
        Item.getInstance("BansheeScale", 6)?.let { linkedHashMap[it] = 260 }
        Item.getInstance("AetherIgnis", 1)?.let { linkedHashMap[it] = 110 }
        Item.getInstance("ChainLink", 1)?.let { linkedHashMap[it] = 110 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("CelestialArmor", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("BansheeJacket", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("ElasticRobe", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("CelestialHelmet", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("CelestialShield", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("BansheeGloves", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("ElasticBoots", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("CelestialSword", 1)?.let { linkedHashMap[it] = 111 }
        Item.getInstance("BansheeDagger", 1)?.let { linkedHashMap[it] = 112 }
        return linkedHashMap
    }
}
