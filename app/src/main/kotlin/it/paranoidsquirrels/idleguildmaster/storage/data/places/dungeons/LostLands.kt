package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.SmolderingTitan
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class LostLands : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 12

    override fun getName(): Int = R.string.dungeon_name_lost_lands

    override fun getSummaryDrawable(): Int = R.drawable.summary_lost_lands

    override fun getDetailDrawable(): Int = R.drawable.area_lost_lands

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.lostLands

    override fun rollEnemies(): MutableList<Enemy> {
        val ev = event
        if (ev != null && ev.key == 1 && ev.progress >= 100) {
            event = null
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SmolderingTitan")))
        }
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 312.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 26.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Berserker")))
        }
        if (dRandom < 52.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Pterodactyl")))
        }
        if (dRandom < 78.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Terrorsaurus")))
        }
        if (dRandom < 104.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("Berserker")))
        }
        if (dRandom < 130.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Berserker"), Enemy.getInstance("Berserker")))
        }
        if (dRandom < 156.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")))
        }
        if (dRandom < 182.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Berserker"), Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("Berserker")))
        }
        if (dRandom < 208.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Terrorsaurus"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")))
        }
        if (dRandom < 234.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Terrorsaurus"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Terrorsaurus")))
        }
        if (dRandom < 260.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Pterodactyl"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")))
        }
        if (dRandom < 286.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Berserker"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Terrorsaurus")))
        }
        if (dRandom < 312.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        if (Utils.random() * 1000.0 < 1.0 && Utils.random() < 0.1) {
            val item = Item.getInstance("Diamond", 1)
            Logger.log(this, 102, R.string.log_lost_lands_finding_1)
            item?.let { collectItemFromGround(it) }
            return
        }
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.1) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_1)
                } else if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_2)
                } else if (dRandom < 0.3) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_3)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_4)
                } else if (dRandom < 0.5) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_5)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_6)
                } else if (dRandom < 0.7) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_7)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_8)
                } else if (dRandom < 0.9) {
                    Logger.log(this, 100, R.string.log_lost_lands_room_9)
                } else {
                    Logger.log(this, 100, R.string.log_lost_lands_room_10)
                }
            }
            "fight_start" -> {
                if (enemies.size == 1 && enemies[0] is SmolderingTitan) {
                    Logger.log(this, Logger.SUMMON_SMOLDERING_TITAN)
                } else {
                    val dRandom2 = Utils.random()
                    if (dRandom2 < 0.2) {
                        Logger.log(this, 101, R.string.log_lost_lands_encounter_1)
                    } else if (dRandom2 < 0.4) {
                        Logger.log(this, 101, R.string.log_lost_lands_encounter_2)
                    } else if (dRandom2 < 0.6) {
                        Logger.log(this, 101, R.string.log_lost_lands_encounter_3)
                    } else if (dRandom2 < 0.8) {
                        Logger.log(this, 101, R.string.log_lost_lands_encounter_4)
                    } else {
                        Logger.log(this, 101, R.string.log_lost_lands_encounter_5)
                    }
                }
            }
            "respawn" -> {
                event = null
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_lost_lands_enter)
            }
            "kill_SmolderingTitan" -> {
                QuestsManager.increment(QuestsManager.ragingVolcano, 1L)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.theDireDescent?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("AmanitaObscura"),
            Enemy.getInstance("Berserker"),
            Enemy.getInstance("Terrorsaurus"),
            Enemy.getInstance("Pterodactyl"),
            Enemy.getInstance("StoneShaman"),
            Enemy.getInstance("SmolderingTitan")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("Mithril", 9)?.let { linkedHashMap[it] = 279 }
        Item.getInstance("AncientHide", 9)?.let { linkedHashMap[it] = 279 }
        Item.getInstance("AncientMembrane", 9)?.let { linkedHashMap[it] = 279 }
        Item.getInstance("PoisonousFlesh", 1)?.let { linkedHashMap[it] = 151 }
        Item.getInstance("Kindlequartz", 1)?.let { linkedHashMap[it] = 11 }
        Item.getInstance("Diamond", 1)?.let { linkedHashMap[it] = 1 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("AncientBoots", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("AncientGloves", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("MithrilHelm", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("MithrilShield", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("AncientArmor", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("AncientJacket", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("AncientRobe", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("MithrilSword", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("MithrilBow", 1)?.let { linkedHashMap[it] = 100 }
        Item.getInstance("MithrilDagger", 1)?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }
}
