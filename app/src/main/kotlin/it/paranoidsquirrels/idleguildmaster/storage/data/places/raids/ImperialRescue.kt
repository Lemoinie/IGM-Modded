package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class ImperialRescue : Area() {
    override fun adventurersNumber(): Int = 8

    override fun getAreaType(): Int = 2

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_imperial_rescue

    override fun getSummaryDrawable(): Int = R.drawable.summary_imperial_rescue

    override fun getDetailDrawable(): Int = R.drawable.area_imperial_rescue

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding.imperialRescue

    override fun rollEnemies(): MutableList<Enemy> {
        if (progress < maxProgress) {
            return CopyOnWriteArrayList()
        }
        val i = progress
        if (i == 1) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("CityWarden"),
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("InsaneCitizen")
            ))
        }
        if (i == 2) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("CityWarden"),
                Enemy.getInstance("InsaneMerchant"),
                Enemy.getInstance("CityWarden"),
                Enemy.getInstance("InsaneCitizen")
            ))
        }
        if (i == 3) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("CityWarden"),
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("CityWarden")
            ))
        }
        if (i == 6) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard")
            ))
        }
        if (i == 7) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialMage"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialGuard")
            ))
        }
        if (i == 9) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("InsaneMerchant"),
                Enemy.getInstance("InsaneCitizen"),
                Enemy.getInstance("InsaneMerchant"),
                Enemy.getInstance("InsaneCitizen")
            ))
        }
        if (i == 11) {
            return CopyOnWriteArrayList(listOfNotNull(
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialMage"),
                Enemy.getInstance("ImperialGuard"),
                Enemy.getInstance("ImperialMage"),
                Enemy.getInstance("ImperialGuard")
            ))
        }
        if (i != 14) {
            return CopyOnWriteArrayList()
        }
        return if (Utils.gotUniqueDrop("SkeletonKey", this)) CopyOnWriteArrayList() else CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("EmperorClovisXXVIII")))
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_1)
                    2 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_2)
                    3 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_3)
                    4 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_4)
                    5 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_5)
                    6 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_6)
                    7 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_7)
                    8 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_8)
                    9 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_9)
                    10 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_10)
                    11 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_11)
                    12 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_12)
                    13 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_13)
                    14 -> Logger.log(this, 100, R.string.log_imperial_rescue_room_14)
                    15 -> {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, R.string.log_imperial_rescue_room_15)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    1 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_1)
                    2 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_2)
                    3 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_3)
                    6 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_4)
                    7 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_5)
                    9 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_6)
                    11 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_7)
                    14 -> Logger.log(this, 101, R.string.log_imperial_rescue_encounter_8)
                }
                for (enemy in enemies) {
                    applyStatus(enemy, StatusEffect(StatusEffectType.DELIRIUM, enemy, 999, 1.0), 0.0)
                }
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_imperial_rescue_enter)
            }
            "kill_EmperorClovisXXVIII" -> {
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RESCUE_TEAM)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("InsaneCitizen"),
            Enemy.getInstance("InsaneMerchant"),
            Enemy.getInstance("CityWarden"),
            Enemy.getInstance("ImperialGuard"),
            Enemy.getInstance("ImperialMage"),
            Enemy.getInstance("EmperorClovisXXVIII")
        )
    }

    override fun completed(): Boolean {
        return maxProgress >= 15 && drops.isEmpty()
    }
}
