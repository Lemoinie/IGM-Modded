package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

class TheSlimePond : Area() {
    override fun adventurersNumber(): Int = 5

    override fun getAreaType(): Int = 1

    override fun getDarkness(): Int = 0

    override fun getName(): Int = R.string.raid_name_the_slime_pond

    override fun getSummaryDrawable(): Int = R.drawable.summary_the_slime_pond

    override fun getDetailDrawable(): Int = R.drawable.area_the_slime_pond

    override fun getLayout(): LayoutDungeonBinding = MainActivity.raidsFragment.binding!!.theSlimePond

    override fun rollEnemies(): MutableList<Enemy> {
        val i = progress
        if (i != 2 && i != 3 && i != 4) {
            if (i == 6) {
                return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("SlimeKing")))
            }
            return CopyOnWriteArrayList()
        }
        val i2 = progress + 1
        val list = CopyOnWriteArrayList<Enemy>()
        for (i3 in 0 until i2) {
            val dRandom = Utils.random()
            if (dRandom < 0.695) {
                Enemy.getInstance("Slime")?.let { list.add(it) }
            } else if (dRandom < 0.795) {
                Enemy.getInstance("FireSlime")?.let { list.add(it) }
            } else if (dRandom < 0.895) {
                Enemy.getInstance("ElectricSlime")?.let { list.add(it) }
            } else if (dRandom < 0.995) {
                Enemy.getInstance("FrozenSlime")?.let { list.add(it) }
            } else {
                Enemy.getInstance("VoidSlime")?.let { list.add(it) }
            }
        }
        return list
    }

    override fun searchRoom() {
        Logger.log(this, 41)
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_room" -> {
                when (progress) {
                    1 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_1)
                    2 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_2)
                    3 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_3)
                    4 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_4)
                    5 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_5)
                    6 -> Logger.log(this, 100, R.string.log_the_slime_pond_room_6)
                    7 -> {
                        Logger.log(this, 100, R.string.log_the_slime_pond_room_7)
                        terminationRequested = true
                    }
                }
            }
            "fight_start" -> {
                when (progress) {
                    2 -> Logger.log(this, 101, R.string.log_the_slime_pond_encounter_1)
                    3 -> Logger.log(this, 101, R.string.log_the_slime_pond_encounter_2)
                    4 -> Logger.log(this, 101, R.string.log_the_slime_pond_encounter_3)
                    6 -> Logger.log(this, 101, R.string.log_the_slime_pond_encounter_4)
                }
            }
            "kill_SlimeKing" -> {
                QuestsManager.increment(QuestsManager.regicide, 1L)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ROYAL_PUDDING)
            }
            "enter_dungeon" -> {
                Logger.log(this, 100, R.string.log_the_slime_pond_enter)
            }
        }
    }

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Slime"),
            Enemy.getInstance("FireSlime"),
            Enemy.getInstance("ElectricSlime"),
            Enemy.getInstance("FrozenSlime"),
            Enemy.getInstance("VoidSlime"),
            Enemy.getInstance("SlimeKing")
        )
    }
}
