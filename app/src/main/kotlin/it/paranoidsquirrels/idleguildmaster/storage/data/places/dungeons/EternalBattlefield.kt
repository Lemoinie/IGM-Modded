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

class EternalBattlefield : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.dungeon_name_eternal_battlefield

    override fun getSummaryDrawable(): Int = R.drawable.summary_eternal_battlefield

    override fun getDetailDrawable(): Int = R.drawable.area_eternal_battlefield

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding.eternalBattlefield

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        val key = event?.key ?: 0
        if (key != 0) {
            if (key == 1) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("WillOWisp")))
            }
        } else {
            if (dRandom >= 580.0) {
                return CopyOnWriteArrayList()
            }
            if (dRandom < 30.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Abomination")))
            }
            if (dRandom < 70.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead")))
            }
            if (dRandom < 110.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 150.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 190.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 230.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 270.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 310.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 350.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 380.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 410.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 440.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 460.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 480.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Ghoul"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 500.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 520.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher")))
            }
            if (dRandom < 540.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 560.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")))
            }
            if (dRandom < 580.0) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Undead"), Enemy.getInstance("WillOWisp"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")))
            }
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        if ((event?.key ?: 0) == 1 && (event?.progress ?: 0) >= 200) {
            event = null
            Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_eternal_battlefield_event_1b)
            Item.getInstance("OrbOfEctoplasm", 1)?.let { collectItemFromGround(it) }
            return
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 40.0) {
            trapEncounter(R.string.log_eternal_battlefield_finding_1, R.string.dexterity, 7, 80, false)
        } else if (dRandom < 80.0) {
            trapEncounter(R.string.log_eternal_battlefield_finding_2, R.string.intelligence, 21, 30, true)
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_eternal_battlefield_room_1)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_eternal_battlefield_room_2)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_eternal_battlefield_room_3)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_eternal_battlefield_room_4)
                } else {
                    Logger.log(this, 100, R.string.log_eternal_battlefield_room_5)
                }
            }
            "kill_WillOWisp" -> {
                if (event == null || event?.key == 0) {
                    event = Event(Event.WILL_O_WISP_HUNT)
                }
                val progress = (event?.progress ?: 0) + 1
                event?.progress = progress
                Logger.log(this, 47, progress)
                QuestsManager.increment(QuestsManager.exorcism, 1L)
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 < 0.2) {
                    Logger.log(this, 101, R.string.log_eternal_battlefield_encounter_1)
                } else if (dRandom2 < 0.4) {
                    Logger.log(this, 101, R.string.log_eternal_battlefield_encounter_2)
                } else if (dRandom2 < 0.6) {
                    Logger.log(this, 101, R.string.log_eternal_battlefield_encounter_3)
                } else if (dRandom2 < 0.8) {
                    Logger.log(this, 101, R.string.log_eternal_battlefield_encounter_4)
                } else {
                    Logger.log(this, 101, R.string.log_eternal_battlefield_encounter_5)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_eternal_battlefield_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.theGoldenCity?.let { linkedHashMap[it] = 100 }
        MainActivity.data.ancientGraveDigging?.let { linkedHashMap[it] = 150 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Undead"),
            Enemy.getInstance("UndeadArcher"),
            Enemy.getInstance("DeathHound"),
            Enemy.getInstance("UndeadWarlord"),
            Enemy.getInstance("WillOWisp"),
            Enemy.getInstance("Ghoul"),
            Enemy.getInstance("Abomination")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("BoneFragment", 8)?.let { linkedHashMap[it] = 200 }
        Item.getInstance("TatteredHide", 5)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("ElongatedBone", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("SharpRib", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("SpectralCloth", 1)?.let { linkedHashMap[it] = 160 }
        Item.getInstance("InfectedBlood", 1)?.let { linkedHashMap[it] = 160 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("UndeadGreaves", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadHelm", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadGloves", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadStaff", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadShield", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadSword", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadJacket", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadCuirass", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("UndeadKnife", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("SpectralRobe", 1)?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }
}
