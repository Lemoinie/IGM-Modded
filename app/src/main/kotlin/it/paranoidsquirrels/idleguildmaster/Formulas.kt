package it.paranoidsquirrels.idleguildmaster

import kotlin.math.min
import kotlin.math.pow

object Formulas {
    private const val BASE_MARKET_SPACES = 1
    private const val BASE_QUARTERS_SPACES = 2
    private const val BASE_STORAGE_SPACES = 35
    private const val BASE_TAVERN_SPACES = 1
    private const val BASE_TAVERN_VISITOR_INTERVAL = 28800L
    private const val BASE_WORKSHOP_SPACES = 1
    private const val IMPOSSIBLY_HIGH_PRICE = 99999999999999L

    @JvmStatic
    fun totalStarsToNextLp(level: Int): Int = (level * 3) + 4

    @JvmStatic
    fun getQuartersPrice(): Long {
        val price = when (MainActivity.data.levelQuarters) {
            0 -> 5L
            1 -> 275L
            2 -> 2000L
            3 -> 10000L
            4 -> 40000L
            5 -> 100000L
            6 -> 200000L
            7 -> 300000L
            8 -> 400000L
            9 -> 500000L
            10 -> 700000L
            11 -> 1000000L
            12 -> 1400000L
            13 -> 1850000L
            14 -> 2400000L
            15 -> 3000000L
            16 -> 4000000L
            17 -> 5000000L
            18 -> 6000000L
            19 -> 7000000L
            20 -> 8000000L
            21 -> 9000000L
            22 -> 10000000L
            else -> IMPOSSIBLY_HIGH_PRICE
        }
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getTavernCapacityPrice(): Long {
        val price = (3.0.pow(MainActivity.data.levelTavernCapacity.toDouble()) * 5000.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getTavernTimePrice(): Long {
        val price = (1.7.pow(MainActivity.data.levelTavernTime.toDouble()) * 200.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getStorageCapacityPrice(): Long {
        val levelStorage = MainActivity.data.levelStorage
        val nextLevel = levelStorage + 1
        if (nextLevel > 80) {
            return IMPOSSIBLY_HIGH_PRICE
        }
        var price = if (nextLevel > 60) min(levelStorage - 59, 20).toLong() * 30000L else 0L
        if (nextLevel > 50) price += min(levelStorage - 49, 10).toLong() * 22000L
        if (nextLevel > 40) price += min(levelStorage - 39, 10).toLong() * 12000L
        if (nextLevel > 30) price += min(levelStorage - 29, 10).toLong() * 4000L
        if (nextLevel > 20) price += min(levelStorage - 19, 10).toLong() * 800L
        if (nextLevel > 10) price += min(levelStorage - 9, 10).toLong() * 150L
        return price + (min(nextLevel, 10).toLong() * 50L)
    }

    @JvmStatic
    fun getMarketListingsPrice(): Long {
        val price = (4.5.pow(MainActivity.data.levelMarketListings.toDouble()) * 20.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getMarketTimePrice(): Long {
        val price = (1.7.pow(MainActivity.data.levelMarketTime.toDouble()) * 10.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getWorkshopQueuePrice(): Long {
        val price = (4.5.pow(MainActivity.data.levelWorkshopQueue.toDouble()) * 20.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getWorkshopTimePrice(): Long {
        val price = (1.7.pow(MainActivity.data.levelWorkshopTime.toDouble()) * 10.0).toLong()
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getShelterPrice(): Long {
        val price = when (MainActivity.data.levelShelter) {
            0 -> 500L
            1 -> 2000L
            2 -> 8000L
            3 -> 32000L
            4 -> 64000L
            5 -> 128000L
            6 -> 256000L
            7 -> 512000L
            8 -> 1000000L
            9 -> 2000000L
            10 -> 4000000L
            else -> IMPOSSIBLY_HIGH_PRICE
        }
        return Utils.truncatePrice(price)
    }

    @JvmStatic
    fun getShelterAutofeedPrice(): Long {
        return Utils.truncatePrice(
            if (MainActivity.data.levelShelterAutofeed > 0) IMPOSSIBLY_HIGH_PRICE else 10000L
        )
    }

    /**
     * Shelter Effectiveness (gold tiers, purchased in the Shelter dialog after Auto-Feed):
     * 5 Gold -> 50G -> 5 P -> 50 P -> 5 D, capping out at level 5.
     */
    @JvmStatic
    fun getShelterEffectivenessPrice(): Long {
        val price = when (MainActivity.data.levelShelterEffectiveness) {
            0 -> 50000L          // 5 Gold
            1 -> 500000L         // 50 Gold
            2 -> 5000000L        // 5 Platinum
            3 -> 50000000L       // 50 Platinum
            4 -> 500000000L      // 5 Diamond
            else -> IMPOSSIBLY_HIGH_PRICE
        }
        return Utils.truncatePrice(price)
    }

    /** Combined auto-feed effectiveness percent: gold tiers + gem tiers, each +10% per level. */
    @JvmStatic
    fun getShelterEffectivenessPercent(): Int {
        return (MainActivity.data.levelShelterEffectiveness + MainActivity.data.upgradeShelterEffectiveness) * 10
    }

    @JvmStatic
    fun getQuartersCapacity(): Int {
        var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
        if (MainActivity.data.isAdventurerPackPurchased) packBonus += 2
        if (MainActivity.data.isImperialVanguardPurchased) packBonus += 4
        if (MainActivity.data.isUnholyCrusadePurchased) packBonus += 4
        return MainActivity.data.levelQuarters + 2 + MainActivity.data.upgradeQuarters + packBonus
    }

    @JvmStatic
    fun getTavernVisitorInterval(): Long {
        val exponent = (MainActivity.data.levelTavernTime + MainActivity.data.upgradeTavernTime).toDouble()
        return (0.9.pow(exponent) * 28800.0 * 1000.0).toLong()
    }

    @JvmStatic
    fun getTavernCapacity(): Int {
        var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
        if (MainActivity.data.isAdventurerPackPurchased) packBonus += 2
        return MainActivity.data.levelTavernCapacity + 1 + MainActivity.data.upgradeTavernCapacity + packBonus
    }

    @JvmStatic
    fun marketListings(): Int {
        var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
        if (MainActivity.data.isMerchantPackPurchased) packBonus += 2
        return MainActivity.data.levelMarketListings + 1 + MainActivity.data.upgradeMarketQueue + packBonus
    }

    @JvmStatic
    fun workshopQueue(): Int {
        var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
        if (MainActivity.data.isMerchantPackPurchased) packBonus += 2
        return MainActivity.data.levelWorkshopQueue + 1 + MainActivity.data.upgradeWorkshopQueue + packBonus
    }

    @JvmStatic
    fun storageSpaces(): Int {
        var packBonus = if (MainActivity.data.isStarterPackPurchased) 35 else 0
        if (MainActivity.data.isAdventurerPackPurchased) packBonus += 35
        if (MainActivity.data.isMerchantPackPurchased) packBonus += 70
        return MainActivity.data.levelStorage + 35 + MainActivity.data.upgradeStorage + packBonus
    }

    @JvmStatic
    fun shelterCapacity(): Int {
        return MainActivity.data.levelShelter + MainActivity.data.upgradeShelter + 2
    }

    @JvmStatic
    @JvmOverloads
    fun experienceToNextLevel(level: Int, doubled: Boolean = false): Int {
        val pow = level.toDouble().pow(1.4)
        var exp = ((3.0 + pow) * 10.0 * pow).toInt()
        if (doubled) {
            exp *= 2
        }
        return when {
            exp >= 10000 -> (exp / 1000) * 1000
            exp >= 1000 -> (exp / 100) * 100
            exp >= 100 -> (exp / 10) * 10
            else -> exp
        }
    }

    @JvmStatic
    fun foodToNextLevel(level: Int): Int {
        return (1.085.pow(level.toDouble()) * 30.0).toInt()
    }
}
