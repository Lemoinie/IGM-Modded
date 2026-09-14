package it.paranoidsquirrels.idleguildmaster

import android.app.Activity
import androidx.work.WorkRequest
import com.google.android.gms.games.PlayGames
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion
import java.util.ArrayList
import kotlin.math.max

object AchievementsUtils {
    const val ACHIEVEMENT_AGONIZING_TITAN = "CgkIttPX_-AEEAIQJQ"
    const val ACHIEVEMENT_APPRENTICE_BLACKSMITH = "CgkIttPX_-AEEAIQAg"
    const val ACHIEVEMENT_APPRENTICE_MERCHANT = "CgkIttPX_-AEEAIQBQ"
    const val ACHIEVEMENT_ASCENDED = "CgkIttPX_-AEEAIQDA"
    const val ACHIEVEMENT_BLACKWATER_PORT = "CgkIttPX_-AEEAIQFg"
    const val ACHIEVEMENT_BUSY = "CgkIttPX_-AEEAIQDQ"
    const val ACHIEVEMENT_COSMIC_HORROR = "CgkIttPX_-AEEAIQJg"
    const val ACHIEVEMENT_DEICIDE = "CgkIttPX_-AEEAIQHQ"
    const val ACHIEVEMENT_DIVINE = "CgkIttPX_-AEEAIQMg"
    const val ACHIEVEMENT_ETERNAL_BATTLEFIELD = "CgkIttPX_-AEEAIQFA"
    const val ACHIEVEMENT_EXPERT = "CgkIttPX_-AEEAIQLQ"
    const val ACHIEVEMENT_FABLED = "CgkIttPX_-AEEAIQMQ"
    const val ACHIEVEMENT_FILTHY_RICH = "CgkIttPX_-AEEAIQEg"
    const val ACHIEVEMENT_FROSTBITE_PEAKS = "CgkIttPX_-AEEAIQFw"
    const val ACHIEVEMENT_GUILD_MANAGEMENT_101 = "CgkIttPX_-AEEAIQAQ"
    const val ACHIEVEMENT_HEAVY_DRINKER = "CgkIttPX_-AEEAIQEA"
    const val ACHIEVEMENT_INFILTRATOR = "CgkIttPX_-AEEAIQIA"
    const val ACHIEVEMENT_JACK_OF_ONE_TRADE = "CgkIttPX_-AEEAIQDw"
    const val ACHIEVEMENT_LEGENDARY = "CgkIttPX_-AEEAIQLw"
    const val ACHIEVEMENT_LEGENDARY_BLACKSMITH = "CgkIttPX_-AEEAIQBA"
    const val ACHIEVEMENT_LEGENDARY_MERCHANT = "CgkIttPX_-AEEAIQBw"
    const val ACHIEVEMENT_MYTHIC = "CgkIttPX_-AEEAIQMA"
    const val ACHIEVEMENT_NOVICE = "CgkIttPX_-AEEAIQKw"
    const val ACHIEVEMENT_OBSIDIAN_MINES = "CgkIttPX_-AEEAIQGA"
    const val ACHIEVEMENT_RARE_SPECIMEN = "CgkIttPX_-AEEAIQCw"
    const val ACHIEVEMENT_RESCUE_TEAM = "CgkIttPX_-AEEAIQHg"
    const val ACHIEVEMENT_RESPECTABLE_GUILD = "CgkIttPX_-AEEAIQCQ"
    const val ACHIEVEMENT_ROYAL_PUDDING = "CgkIttPX_-AEEAIQIg"
    const val ACHIEVEMENT_SEASONED_BLACKSMITH = "CgkIttPX_-AEEAIQAw"
    const val ACHIEVEMENT_SEASONED_MERCHANT = "CgkIttPX_-AEEAIQBg"
    const val ACHIEVEMENT_SKILLED = "CgkIttPX_-AEEAIQLA"
    const val ACHIEVEMENT_SMALL_GUILD = "CgkIttPX_-AEEAIQCA"
    const val ACHIEVEMENT_THE_APOSTLE = "CgkIttPX_-AEEAIQJw"
    const val ACHIEVEMENT_THE_BARREN_WASTELANDS = "CgkIttPX_-AEEAIQGg"
    const val ACHIEVEMENT_THE_CORE = "CgkIttPX_-AEEAIQIQ"
    const val ACHIEVEMENT_THE_COUNCIL = "CgkIttPX_-AEEAIQKQ"
    const val ACHIEVEMENT_THE_CULTISTS = "CgkIttPX_-AEEAIQJA"
    const val ACHIEVEMENT_THE_DESERT = "CgkIttPX_-AEEAIQEw"
    const val ACHIEVEMENT_THE_GOLDEN_CITY = "CgkIttPX_-AEEAIQFQ"
    const val ACHIEVEMENT_THE_HIDDEN_CITY = "CgkIttPX_-AEEAIQGw"
    const val ACHIEVEMENT_THE_LOST_LANDS = "CgkIttPX_-AEEAIQHA"
    const val ACHIEVEMENT_THE_NECROMANCER = "CgkIttPX_-AEEAIQIw"
    const val ACHIEVEMENT_THE_SEER = "CgkIttPX_-AEEAIQHw"
    const val ACHIEVEMENT_THE_SOUTHERN_GROVE = "CgkIttPX_-AEEAIQGQ"
    const val ACHIEVEMENT_THE_TOWER = "CgkIttPX_-AEEAIQKg"
    const val ACHIEVEMENT_UNITY = "CgkIttPX_-AEEAIQKA"
    const val ACHIEVEMENT_VERSATILE_ARMY = "CgkIttPX_-AEEAIQCg"
    const val ACHIEVEMENT_VETERAN = "CgkIttPX_-AEEAIQLg"
    const val ACHIEVEMENT_WEALTHY = "CgkIttPX_-AEEAIQEQ"
    const val ACHIEVEMENT_WORKAHOLIC = "CgkIttPX_-AEEAIQDg"

    private val achievementQueue: MutableList<String> = ArrayList()

    private val activity: Activity?
        get() = try {
            MainActivity.dungeonsFragment?.activity
        } catch (_: Exception) {
            null
        }

    @JvmStatic
    fun unlock(str: String) {
        val act = activity
        if (act != null) {
            PlayGames.getAchievementsClient(act).unlock(str)
        } else {
            achievementQueue.add(str)
        }
    }

    @JvmStatic
    fun increment(str: String, i: Int) {
        val act = activity
        if (act != null) {
            PlayGames.getAchievementsClient(act).increment(str, i)
        }
    }

    @JvmStatic
    fun flushQueue() {
        if (achievementQueue.isEmpty()) return
        val act = activity ?: return
        for (str in achievementQueue) {
            PlayGames.getAchievementsClient(act).unlock(str)
        }
        achievementQueue.clear()
    }

    @JvmStatic
    fun retroactivelyUnlockAchievements() {
        if (MainActivity.data.tutorialStep >= 8) {
            unlock(ACHIEVEMENT_GUILD_MANAGEMENT_101)
        }
        val size = MainActivity.data.adventurers.size
        MainActivity.data.maxAdventurersOwned = size
        if (size >= 5) {
            unlock(ACHIEVEMENT_SMALL_GUILD)
        }
        if (size >= 12) {
            unlock(ACHIEVEMENT_RESPECTABLE_GUILD)
        }
        if (size >= 20) {
            unlock(ACHIEVEMENT_VERSATILE_ARMY)
        }
        var z2 = false
        for (pet in MainActivity.data.pets) {
            if (pet.abilityNumber == 4) {
                z2 = true
                break
            }
        }
        MainActivity.data.isT4Pet = z2
        if (z2) {
            unlock(ACHIEVEMENT_RARE_SPECIMEN)
        }
        var iMax = 1
        var z = false
        for (adventurer in MainActivity.data.adventurers) {
            iMax = max(iMax, adventurer.maxLevel / 5)
            if (adventurer.isAscended()) {
                z = true
            }
            DialogConsumePotion.checkHeavyDrinker(adventurer)
            if (!MainActivity.data.isDoctrineMaxed) {
                doctrineMaxed(adventurer)
            }
        }
        MainActivity.data.isEverAscended = z
        if (z) {
            unlock(ACHIEVEMENT_ASCENDED)
        }
        val money = MainActivity.data.money
        MainActivity.data.maxWealth = money
        if (money > WorkRequest.MIN_BACKOFF_MILLIS) {
            unlock(ACHIEVEMENT_WEALTHY)
        }
        if (money > 1000000) {
            unlock(ACHIEVEMENT_FILTHY_RICH)
        }
        if (MainActivity.data.theDesert?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_DESERT)
        }
        if (MainActivity.data.eternalBattlefield?.isUnlocked == true) {
            unlock(ACHIEVEMENT_ETERNAL_BATTLEFIELD)
        }
        if (MainActivity.data.theGoldenCity?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_GOLDEN_CITY)
        }
        if (MainActivity.data.blackwaterPort?.isUnlocked == true) {
            unlock(ACHIEVEMENT_BLACKWATER_PORT)
        }
        if (MainActivity.data.frostbitePeaks?.isUnlocked == true) {
            unlock(ACHIEVEMENT_FROSTBITE_PEAKS)
        }
        if (MainActivity.data.obsidianMines?.isUnlocked == true) {
            unlock(ACHIEVEMENT_OBSIDIAN_MINES)
        }
        if (MainActivity.data.theSouthernGrove?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_SOUTHERN_GROVE)
        }
        if (MainActivity.data.barrenWastelands?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_BARREN_WASTELANDS)
        }
        if (MainActivity.data.hiddenCityOfLarox?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_HIDDEN_CITY)
        }
        if (MainActivity.data.lostLands?.isUnlocked == true) {
            unlock(ACHIEVEMENT_THE_LOST_LANDS)
        }
        if (MainActivity.data.divineArcheology?.completed() == true) {
            unlock(ACHIEVEMENT_DEICIDE)
        }
        if (MainActivity.data.imperialRescue?.completed() == true) {
            unlock(ACHIEVEMENT_RESCUE_TEAM)
        }
        if (MainActivity.data.theDreadfulAscent?.completed() == true) {
            unlock(ACHIEVEMENT_THE_SEER)
        }
        if (MainActivity.data.celestialMothership?.completed() == true) {
            unlock(ACHIEVEMENT_INFILTRATOR)
        }
        if (MainActivity.data.theDireDescent?.completed() == true) {
            unlock(ACHIEVEMENT_THE_CORE)
        }
        if ((MainActivity.data.theSlimePond?.maxProgress ?: 0) > 6) {
            unlock(ACHIEVEMENT_ROYAL_PUDDING)
        }
        if ((MainActivity.data.ancientGraveDigging?.maxProgress ?: 0) > 11) {
            unlock(ACHIEVEMENT_THE_NECROMANCER)
        }
        if (MainActivity.data.seenItems.contains("ElixirOfLearning") || MainActivity.data.seenItems.contains("EternalHunger") || MainActivity.data.seenItems.contains("SealOfClaris")) {
            unlock(ACHIEVEMENT_THE_CULTISTS)
        }
        if (MainActivity.data.seenItems.contains("ExaltedPowder") || MainActivity.data.seenItems.contains("ColossalSword")) {
            unlock(ACHIEVEMENT_AGONIZING_TITAN)
        }
        if (MainActivity.data.seenItems.contains("StarFragment")) {
            unlock(ACHIEVEMENT_COSMIC_HORROR)
        }
        if (MainActivity.data.seenItems.contains("AstralGoo") || MainActivity.data.seenItems.contains("CosmicViolin")) {
            unlock(ACHIEVEMENT_THE_APOSTLE)
        }
        if ((MainActivity.data.sleepingPlanet?.maxProgress ?: 0) > 14) {
            unlock(ACHIEVEMENT_UNITY)
        }
        if ((MainActivity.data.sleepingPlanet?.maxProgress ?: 0) > 16) {
            unlock(ACHIEVEMENT_THE_COUNCIL)
        }
        if ((MainActivity.data.sleepingPlanet?.maxProgress ?: 0) > 35) {
            unlock(ACHIEVEMENT_THE_TOWER)
        }
        if (iMax > 1) {
            unlock(ACHIEVEMENT_NOVICE)
        }
        if (iMax > 2) {
            unlock(ACHIEVEMENT_SKILLED)
        }
        if (iMax > 3) {
            unlock(ACHIEVEMENT_EXPERT)
        }
        if (iMax > 4) {
            unlock(ACHIEVEMENT_VETERAN)
        }
        if (iMax > 5) {
            unlock(ACHIEVEMENT_LEGENDARY)
        }
        if (iMax > 6) {
            unlock(ACHIEVEMENT_MYTHIC)
        }
        if (iMax > 7) {
            unlock(ACHIEVEMENT_FABLED)
        }
        if (iMax > 8) {
            unlock(ACHIEVEMENT_DIVINE)
        }
    }

    private fun doctrineMaxed(adventurer: Adventurer) {
        val doctrine = adventurer.doctrine
        if (doctrine == null || doctrine is EmptyDoctrine) {
            return
        }
        for (doctrineAbility in doctrine.abilities) {
            val maxLvl = doctrineAbility.type?.maxLevel ?: 0
            if (doctrineAbility.level < maxLvl) {
                return
            }
        }
        MainActivity.data.isDoctrineMaxed = true
        unlock(ACHIEVEMENT_JACK_OF_ONE_TRADE)
    }
}
