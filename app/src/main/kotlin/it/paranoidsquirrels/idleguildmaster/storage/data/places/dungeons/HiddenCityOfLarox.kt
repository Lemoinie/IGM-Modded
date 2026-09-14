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

class HiddenCityOfLarox : Area() {
    override fun getAreaType(): Int = 0

    override fun getDarkness(): Int = 8

    override fun getName(): Int = R.string.dungeon_name_hidden_city_of_larox

    override fun getSummaryDrawable(): Int = R.drawable.summary_hidden_city_of_larox

    override fun getDetailDrawable(): Int = R.drawable.area_hidden_city_of_larox

    override fun getLayout(): LayoutDungeonBinding = MainActivity.dungeonsFragment.binding!!.hiddenCityOfLarox

    override fun rollEnemies(): MutableList<Enemy> {
        val dRandom = Utils.random() * 1000.0
        if (dRandom >= 464.0) {
            return CopyOnWriteArrayList()
        }
        if (dRandom < 25.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp")))
        }
        if (dRandom < 50.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 75.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("Imp")))
        }
        if (dRandom < 100.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 125.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher")))
        }
        if (dRandom < 150.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 175.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 200.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")))
        }
        if (dRandom < 222.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("Imp"), Enemy.getInstance("Imp")))
        }
        if (dRandom < 244.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 266.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 288.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("WizardOfLarox")))
        }
        if (dRandom < 310.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")))
        }
        if (dRandom < 332.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")))
        }
        if (dRandom < 354.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 376.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 398.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("ArchmageOfLarox"), Enemy.getInstance("MagicArmor")))
        }
        if (dRandom < 420.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("Imp")))
        }
        if (dRandom < 442.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("Imp")))
        }
        if (dRandom < 464.0) {
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WickedTribute"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")))
        }
        return CopyOnWriteArrayList()
    }

    override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        if (event == null || dRandom < 200.0) {
            val ev = Event(Event.MAGIC_AMPLIFICATION)
            ev.progress = (Utils.random() * 100.0).toInt()
            event = ev
            Logger.log(this, 109, ((magicDamageAmplification() * 100.0) - 100.0).toInt())
            return
        }
        if (dRandom < 230.0) {
            trapEncounter(R.string.log_hidden_city_of_larox_finding_1, R.string.intelligence, 50, 100, true)
            return
        }
        if (dRandom >= 260.0) {
            if (dRandom < 280.0) {
                for (adventurer in adventurersExploring) {
                    adventurer.currentHp = adventurer.calculateTotalMaxHp()
                    adventurer.negativeStatusEffects.clear()
                }
                refreshDialog()
                Logger.log(this, 102, R.string.log_hidden_city_of_larox_finding_3)
                return
            }
            Logger.log(this, 41)
            return
        }
        Logger.log(this, 101, R.string.log_hidden_city_of_larox_finding_2)
        val statusEffect = StatusEffect(StatusEffectType.ABLAZE, null, 5, 0.85)
        val statusEffect2 = StatusEffect(StatusEffectType.FROZEN, null, 5, 0.85)
        val statusEffect3 = StatusEffect(StatusEffectType.SILENCE, null, 5, 0.85)
        for (adventurer2 in adventurersExploring) {
            if (adventurer2.currentHp > 0) {
                applyStatus(adventurer2, statusEffect, 0.0)
                applyStatus(adventurer2, statusEffect2, 0.0)
                applyStatus(adventurer2, statusEffect3, 0.0)
            }
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                val dRandom = Utils.random()
                if (dRandom < 0.1) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_1)
                } else if (dRandom < 0.2) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_2)
                } else if (dRandom < 0.3) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_3)
                } else if (dRandom < 0.4) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_4)
                } else if (dRandom < 0.5) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_5)
                } else if (dRandom < 0.6) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_6)
                } else if (dRandom < 0.7) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_7)
                } else if (dRandom < 0.8) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_8)
                } else if (dRandom < 0.9) {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_9)
                } else {
                    Logger.log(this, 100, R.string.log_hidden_city_of_larox_room_10)
                }
            }
            "fight_start" -> {
                val dRandom2 = Utils.random()
                if (dRandom2 < 0.2) {
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_encounter_1)
                } else if (dRandom2 < 0.4) {
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_encounter_2)
                } else if (dRandom2 < 0.6) {
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_encounter_3)
                } else if (dRandom2 < 0.8) {
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_encounter_4)
                } else {
                    Logger.log(this, 101, R.string.log_hidden_city_of_larox_encounter_5)
                }
            }
            "kill_ArchmageOfLarox" -> {
                QuestsManager.increment(QuestsManager.coupDEtat, 1L)
            }
            "kill_WickedTribute" -> {
                QuestsManager.increment(QuestsManager.fromHell, 1L)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_hidden_city_of_larox_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> {
        val linkedHashMap = LinkedHashMap<Area, Int>()
        MainActivity.data.lostLands?.let { linkedHashMap[it] = 100 }
        return linkedHashMap
    }

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Imp"),
            Enemy.getInstance("MagicArmor"),
            Enemy.getInstance("NexusResearcher"),
            Enemy.getInstance("WizardOfLarox"),
            Enemy.getInstance("ArchmageOfLarox"),
            Enemy.getInstance("WickedTribute")
        )
    }

    override fun rollMerchantRegularOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("SpellwovenHide", 6)?.let { linkedHashMap[it] = 326 }
        Item.getInstance("AnimatedScraps", 9)?.let { linkedHashMap[it] = 326 }
        Item.getInstance("LaroxianFabric", 3)?.let { linkedHashMap[it] = 326 }
        Item.getInstance("VeilBreaker", 1)?.let { linkedHashMap[it] = 11 }
        Item.getInstance("UnstableGem", 1)?.let { linkedHashMap[it] = 11 }
        return linkedHashMap
    }

    override fun rollMerchantSpecialOffers(): LinkedHashMap<Item, Int> {
        val linkedHashMap = LinkedHashMap<Item, Int>()
        Item.getInstance("SpellwovenJacket", 1)?.let { linkedHashMap[it] = 90 }
        Item.getInstance("AnimatedCuirass", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("LaroxianRobe", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedSword", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedStaff", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedDagger", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedBow", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedHelm", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("AnimatedBuckler", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("LaroxianGloves", 1)?.let { linkedHashMap[it] = 91 }
        Item.getInstance("LaroxianBoots", 1)?.let { linkedHashMap[it] = 91 }
        return linkedHashMap
    }

    override fun magicDamageAmplification(): Double {
        val progress = event?.progress ?: 0
        if (progress <= 45) {
            return ((progress.toDouble() * 10.0) / 900.0) + 0.5
        }
        if (progress < 55) {
            return 1.0
        }
        return (((progress - 54).toDouble() * 15.0) / 900.0) + 1.0
    }
}
