package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids

import android.os.Handler
import android.os.Looper
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

/**
 * The Slumbering Shallows — an enchanted, murky guild fishing pond.
 *
 * The party casts lines continuously (no final boss chamber, no floor cutoff) and
 * fishes until recalled or wiped. Every cast has a strict 0.1% chance to hook
 * Chorus the Drowned, who hits devastatingly hard (70–100).
 */
class TheSlumberingShallowsArea : Area() {
    override fun adventurersNumber(): Int = 4

    /** Dungeon-style continuous loop: the party retires only when recalled or wiped. */
    override fun getAreaType(): Int = Area.TYPE_DUNGEON

    /** No darkness: the catch difficulty is purely DEX-driven (high-dodge fish). */
    override fun getDarkness(): Int = 0

    /** Always-accessible guild activity — never refillable with gems. */
    override fun canRefillWithGems(): Boolean = false

    override fun getName(): Int = R.string.guild_slumbering_shallows_name

    override fun getSummaryDrawable(): Int = R.drawable.summary_fishing_pond

    override fun getDetailDrawable(): Int = R.drawable.area_fishing_pond

    override fun getLayout(): LayoutDungeonBinding = MainActivity.guildActivitiesFragment.binding!!.theSlumberingShallows

    override fun listAreasUnlocked(): LinkedHashMap<Area, Int> = LinkedHashMap()

    override fun listEnemies(): List<Enemy> {
        return listOfNotNull(
            Enemy.getInstance("Perch"),
            Enemy.getInstance("BlueTrout"),
            Enemy.getInstance("Angelfish"),
            Enemy.getInstance("WingedRay"),
            Enemy.getInstance("BlueShark"),
            Enemy.getInstance("MagmaShark"),
            Enemy.getInstance("ChorusTheDrowned")
        )
    }

    /**
     * Rolls a cast: 0.1% chance for Chorus the Drowned, otherwise a standard
     * wave of 1–3 fish from the rarity tiers (50% Common / 35% Intermediate /
     * 15% Rare).
     */
    public override fun rollEnemies(): MutableList<Enemy> {
        if (Utils.random() < 0.001) {
            Logger.log(this, Logger.EVENT, R.string.log_slumbering_shallows_chorus)
            return CopyOnWriteArrayList(listOfNotNull(Enemy.getInstance("ChorusTheDrowned")))
        }
        val fishCount = 1 + (Utils.random() * 3.0).toInt()
        val list = CopyOnWriteArrayList<Enemy>()
        for (i in 0 until fishCount) {
            Enemy.getInstance(rollFishType())?.let { list.add(it) }
        }
        return list
    }

    private fun rollFishType(): String {
        val r = Utils.random()
        if (r < 0.50) {
            return if (Utils.random() < 0.5) "Perch" else "BlueTrout"
        }
        if (r < 0.85) {
            return if (Utils.random() < 0.5) "Angelfish" else "WingedRay"
        }
        return if (Utils.random() < 0.5) "BlueShark" else "MagmaShark"
    }

    /** Ambient gathering between casts: 25% Perch, 10% sunken CoinPurse. */
    public override fun searchRoom() {
        val dRandom = Utils.random() * 1000.0
        if (dRandom < 250.0) {
            Logger.log(this, Logger.EVENT_BENEFICIAL, R.string.log_slumbering_shallows_found_perch)
            Item.getInstance("Perch", 1)?.let { collectItemFromGround(it) }
        } else if (dRandom < 350.0) {
            Logger.log(this, Logger.EVENT_BENEFICIAL, R.string.log_slumbering_shallows_found_coin_purse)
            Item.getInstance("CoinPurse", 1)?.let { collectItemFromGround(it) }
        } else {
            Logger.log(this, 41)
        }
    }

    override fun triggerEvent(str: String) {
        when (str) {
            "enter_dungeon" -> {
                Logger.log(this, Logger.EVENT, R.string.log_slumbering_shallows_enter)
            }

            "enter_room" -> {
                Logger.log(this, Logger.EVENT, R.string.log_slumbering_shallows_room)
            }

            "fight_start" -> {
                Logger.log(this, Logger.EVENT, R.string.log_slumbering_shallows_fight)
            }
        }
    }

    override fun refreshTries() {
        if (MainActivity.guildActivitiesFragment.context == null || MainActivity.guildActivitiesFragment.binding == null) {
            return
        }
        if (!Utils.isMainLooper()) {
            Handler(Looper.getMainLooper()).post { refreshTries() }
            return
        }
        val layout = getLayout()
        val available = adventurersExploringIds.isEmpty()
        this.triesAvailable = available
        layout.raidTryAvailable.setImageResource(
            if (available) R.drawable.raid_try_available else R.drawable.raid_try_unavailable
        )
        layout.raidTryAvailable.visibility = android.view.View.VISIBLE
    }
}