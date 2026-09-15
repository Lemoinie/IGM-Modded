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
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.max

class TheGoldenCity : Area() {
    companion object {
        /** Imperial Guard kills required before the Imperial Captain can appear. */
        const val IMPERIAL_CAPTAIN_KILL_THRESHOLD: Int = 100
    }

    /** Resets the Imperial Guard kill counter after the Imperial Captain is defeated. */
    fun onImperialCaptainDefeated() {
        MainActivity.data.imperialKills = 0
        FileManager.saveNow(MainActivity.context)
    }

    /** Resets the Imperial Guard kill counter after a team wipe (respawn). */
    fun onTeamWipe() {
        MainActivity.data.imperialKills = 0
        FileManager.saveNow(MainActivity.context)
    }

    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_the_golden_city

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_golden_city

    override fun getDetailDrawable(): Int = R.drawable.area_the_golden_city

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.theGoldenCity

    override fun rollEnemies(): MutableList<Enemy> {
        val kills = MainActivity.data.imperialKills
        if (kills >= IMPERIAL_CAPTAIN_KILL_THRESHOLD && Math.random() < 0.5) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ImperialCaptain")))
        }
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key == 0 || key == 1) {
            if (dRandom >= 470.0) {
                return CopyOnWriteArrayList()
            }
            if (dRandom < 30.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 60.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 80.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 100.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 120.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 130.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard")))
            }
            if (dRandom < 150.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest")))
            }
            if (dRandom < 170.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 190.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 210.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 230.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 240.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 250.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 260.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 270.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 280.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ImperialGuard")))
            }
            if (dRandom < 300.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 320.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 340.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 360.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 370.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 380.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsaneCitizen")))
            }
            if (dRandom < 390.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsanePriest")))
            }
            if (dRandom < 400.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("ImperialGuard")))
            }
            if (dRandom < 410.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 420.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 430.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 440.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 460.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")))
            }
            if (dRandom < 470.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")))
            }
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 40.0) {
            trapEncounter(R.string.log_the_golden_city_finding_3, R.string.dexterity, 20, 50, false)
            return
        }
        if (dRandom < 60.0) {
            Logger.log(this, 101, R.string.log_the_golden_city_finding_2)
            for (adventurer in adventurersExploring) {
                if (adventurer.currentHp > 0) {
                    val iMax = max(1, 40 - adventurer.calculateTotalConstitution())
                    adventurer.applyDamage(iMax.toDouble(), true, petExploring?.barrier ?: 0, 0.0)
                    refreshDialog()
                    Logger.log(this, 48, iMax, adventurer.idName)
                }
            }
            return
        }
        if (dRandom < 90.0) {
            for (adventurer2 in adventurersExploring) {
                adventurer2.currentHp = adventurer2.calculateTotalMaxHp()
            }
            refreshDialog()
            Logger.log(this, 102, R.string.log_the_golden_city_finding_1)
            return
        }
        if (dRandom < 100.0) {
            Item.getInstance("SilkThread", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 110.0) {
            Item.getInstance("Redwood", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 115.0) {
            Item.getInstance("Ivory", 1)?.let { collectItemFromGround(it) }
        } else if (dRandom < 117.0) {
            Item.getInstance("GoldScraps", 1)?.let { collectItemFromGround(it) }
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_the_golden_city_room_1)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_the_golden_city_room_2)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_the_golden_city_room_3)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_the_golden_city_room_4)
                } else {
                    Logger.log(this, 100, R.string.log_the_golden_city_room_5)
                }
                if (event == null && Utils.random() < 0.003) {
                    val ev = Event(Event.ANGRY_EYE)
                    ev.progress = 5
                    event = ev
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_golden_city_event_1a)
                }
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 < 0.2) {
                    Logger.log(this, 101, R.string.log_the_golden_city_encounter_1)
                } else if (dRandom2 < 0.4) {
                    Logger.log(this, 101, R.string.log_the_golden_city_encounter_2)
                } else if (dRandom2 < 0.6) {
                    Logger.log(this, 101, R.string.log_the_golden_city_encounter_3)
                } else if (dRandom2 < 0.8) {
                    Logger.log(this, 101, R.string.log_the_golden_city_encounter_4)
                } else {
                    Logger.log(this, 101, R.string.log_the_golden_city_encounter_5)
                }
                val ev = event
                if (ev != null && ev.key == 1) {
                    if (Utils.random() < 0.25) {
                        event = null
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_the_golden_city_event_1b)
                    } else {
                        for (enemy in enemies) {
                            applyStatus(enemy, StatusEffect(StatusEffectType.DELIRIUM, enemy, 999, 1.0), 0.0)
                        }
                    }
                }
            }
            "victory" -> {
                val ev = event
                if (ev != null && ev.key == 1) {
                    QuestsManager.increment(QuestsManager.delirious, corpses.size.toLong())
                }
            }
            "kill_InsaneCitizen" -> {
                QuestsManager.increment(QuestsManager.psychiatrist, 1L)
            }
            "kill_ImperialGuard" -> {
                MainActivity.data.imperialKills = (MainActivity.data.imperialKills + 1).coerceIn(0, 1023)
            }
            "kill_ImperialCaptain" -> {
                onImperialCaptainDefeated()
                Logger.log(this, 100, R.string.log_the_golden_city_threat)
            }
            "respawn" -> {
                onTeamWipe()
                event = null
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_golden_city_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.blackwaterPort?.let { linkedHashMap[it] = 100 }
        MainActivity.data.imperialRescue?.let { linkedHashMap[it] = 150 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("InsaneCitizen"),
            Enemy.getInstance("InsaneMerchant"),
            Enemy.getInstance("InsanePriest"),
            Enemy.getInstance("CityWarden"),
            Enemy.getInstance("ImperialGuard"),
            Enemy.getInstance("ImperialMage"),
            Enemy.getInstance("ArcaneAssassin"),
            Enemy.getInstance("ImperialCaptain")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("SilkThread", 8)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("GoldScraps", 6)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("Emerald", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("Ruby", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("Ivory", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("BlackOoze", 10)?.let { linkedHashMap[it] = 160 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("SilkRobe", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("BeltJacket", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenArmor", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenSword", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenBoots", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenGauntlets", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenHelm", 1)?.let { linkedHashMap[it] = 125 }
        Item.getInstance("GoldenShield", 1)?.let { linkedHashMap[it] = 125 }
        return linkedHashMap
    }
}
