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

class BlackwaterPort : Area() {
    companion object {
        private const val EMPTY_ENEMIES_FOR_KRAKEN = 10
    }

    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_blackwater_port

    override fun getSummaryDrawable(): Int = R.drawable.summary_blackwater_port

    override fun getDetailDrawable(): Int = R.drawable.area_blackwater_port

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.blackwaterPort

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key != 0) {
            if (key == 1) {
                val progress = event?.progress ?: 0
                if (progress >= 10) {
                    event = Event(Event.THE_KRAKEN_FIGHT)
                    return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle")))
                }
                event?.progress = progress + 1
            } else if (key == 2) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle")))
            }
        } else {
            if (dRandom >= 385.0) {
                return CopyOnWriteArrayList()
            }
            if (dRandom < 15.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Mimic")))
            }
            if (dRandom < 45.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PirateCaptain"), Enemy.getInstance("PirateLieutenant")))
            }
            if (dRandom < 75.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PirateCaptain"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 105.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PirateCaptain"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Pirate")))
            }
            if (dRandom < 135.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PirateCaptain"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 165.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("PirateCaptain"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 195.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 210.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 235.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 250.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 280.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")))
            }
            if (dRandom < 310.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 340.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 355.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")))
            }
            if (dRandom < 370.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")))
            }
            if (dRandom < 385.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")))
            }
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        if (event != null && event?.key == 2) {
            QuestsManager.increment(QuestsManager.thalassophobia, 1L)
            val item = Item.getInstance("EyeOfTheAbyss", 1)
            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_blackwater_port_event_1d)
            item?.let { collectItemFromGround(it) }
            event = null
            return
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 30.0) {
            val item2 = Item.getInstance("Pearl", 1)
            Logger.log(this, 102, R.string.log_blackwater_port_finding_1)
            item2?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 60.0) {
            Item.getInstance("GhostwoodStump", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 110.0) {
            Item.getInstance("MissingPage", 1)?.let { collectItemFromGround(it) }
            return
        }
        if (dRandom < 160.0) {
            trapEncounter(R.string.log_blackwater_port_finding_2, R.string.dexterity, 40, 40, false)
            return
        }
        if (dRandom < 210.0) {
            trapEncounter(R.string.log_blackwater_port_finding_3, R.string.dexterity, 10, 150, false)
            return
        }
        if (dRandom < 260.0) {
            trapEncounter(R.string.log_blackwater_port_finding_4, R.string.constitution, 20, 60, true)
        } else if (dRandom < 310.0) {
            trapEncounter(R.string.log_blackwater_port_finding_5, R.string.intelligence, 20, 60, false)
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "kill_Mimic" -> {
                QuestsManager.increment(QuestsManager.niceTry, 1L)
            }
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_blackwater_port_room_1)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_blackwater_port_room_2)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_blackwater_port_room_3)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_blackwater_port_room_4)
                } else {
                    Logger.log(this, 100, R.string.log_blackwater_port_room_5)
                }
            }
            "flee", "respawn" -> {
                event = null
            }
            "fight_start" -> {
                if (event != null && event?.key == 2) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_blackwater_port_event_1b)
                } else {
                    val dRandom2 = Utils.random()
                    if (dRandom2 < 0.2) {
                        Logger.log(this, 101, R.string.log_blackwater_port_encounter_1)
                    } else if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_blackwater_port_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_blackwater_port_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_blackwater_port_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_blackwater_port_encounter_5)
                    }
                }
            }
            "victory" -> {
                if (event != null && event?.key == 2) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_blackwater_port_event_1c)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_blackwater_port_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.frostbitePeaks?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Deckhand"),
            Enemy.getInstance("Pirate"),
            Enemy.getInstance("PirateLieutenant"),
            Enemy.getInstance("PirateCaptain"),
            Enemy.getInstance("MysteriousTentacle"),
            Enemy.getInstance("Mimic")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("GhostwoodBoard", 2)?.let { linkedHashMap[it] = 170 }
        Item.getInstance("BlackIronScraps", 8)?.let { linkedHashMap[it] = 166 }
        Item.getInstance("ExoticVelvet", 2)?.let { linkedHashMap[it] = 166 }
        Item.getInstance("MysteriousAppendage", 4)?.let { linkedHashMap[it] = 166 }
        Item.getInstance("AbyssalSeashell", 8)?.let { linkedHashMap[it] = 166 }
        Item.getInstance("MonkeyHide", 5)?.let { linkedHashMap[it] = 166 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("BlackIronArmor", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ExoticRobe", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("BlackIronHelm", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("ExoticBoots", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("BlackIronGauntlets", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("GhostwoodShield", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("BlackIronCutlass", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("BlackIronScepter", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("BlackIronDagger", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("GhostwoodBow", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("MonkeyHideJacket", 1)?.let { linkedHashMap[it] = 90 }
        return linkedHashMap
    }
}
