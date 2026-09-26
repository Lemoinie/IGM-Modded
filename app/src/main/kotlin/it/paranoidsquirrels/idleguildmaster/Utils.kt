package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesManager

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Looper
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.work.WorkRequest
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment
import java.util.ArrayList
import java.util.Arrays
import java.util.Calendar
import java.util.Comparator
import java.util.Date
import java.util.HashSet
import java.util.SplittableRandom

object Utils {
    const val ONE_DAY_IN_MILLISECONDS: Long = 86400000L
    const val ONE_DAY_IN_SECONDS: Int = 86400
    const val ONE_HOUR_IN_MILLISECONDS: Long = 3600000L
    const val ONE_HOUR_IN_SECONDS: Int = 3600
    private const val PET_ABILITY_INDIVIDUAL_PROBABILITY: Double = 0.0625
    private const val POTION_INDIVIDUAL_PROBABILITY: Double = 0.09090909090909091
    private const val SPECIAL_FOOD_INDIVIDUAL_PROBABILITY: Double = 0.16666666666666666
    private const val TRAIT_COMMON_INDIVIDUAL_PROBABILITY: Double = 0.13333333333333333
    private const val TRAIT_RARE_INDIVIDUAL_PROBABILITY: Double = 0.014285714285714287

    private var dungeonsList: List<Area>? = null
    private var dungeonsRaidsList: MutableList<Area>? = null
    private var raidsList: List<Area>? = null
    private val randomGenerator = SplittableRandom()

    private val fightPriorityComparator: Comparator<Entity> = Comparator { entity1, entity2 ->
        if (entity1.isInitiative() != entity2.isInitiative()) {
            if (entity1.isInitiative()) -1 else 1
        } else {
            entity2.calculateTotalDexterity() - entity1.calculateTotalDexterity()
        }
    }

    @JvmField
    val itemsByTypeComparator: Comparator<Item> = Comparator { item1, item2 ->
        val p = typeToPriority(item1) - typeToPriority(item2)
        if (p != 0) return@Comparator p
        if (item1.getPrice() != item2.getPrice()) {
            if (item2.getPrice() > item1.getPrice()) -1 else 1
        } else {
            0
        }
    }

    @JvmField
    val recipesByTypeComparator: Comparator<Recipes> = Comparator { recipes1, recipes2 ->
        val res1 = recipes1.getResult()
        val res2 = recipes2.getResult()
        val p = typeToPriority(res1) - typeToPriority(res2)
        if (p != 0) return@Comparator p
        val price1 = res1?.getPrice() ?: 0L
        val price2 = res2?.getPrice() ?: 0L
        if (price1 != price2) {
            if (price2 > price1) -1 else 1
        } else {
            0
        }
    }

    @JvmField
    val petsComparator: Comparator<Pet> = Comparator { pet1, pet2 ->
        if (pet1.isFavourite() != pet2.isFavourite()) {
            if (pet1.isFavourite()) -1 else 1
        } else {
            pet2.getLevel() - pet1.getLevel()
        }
    }

    @JvmField
    var checks: Int = 60
    @JvmField
    var firstRunTriggered: Boolean = false

    @JvmStatic
    fun round(d: Double): Int {
        return (d + 1.0E-4).toInt()
    }

    private fun typeToPriority(item: Item?): Int {
        if (item == null) return 13
        return try {
            when (item) {
                is Sword -> 1
                is Bow -> 2
                is Dagger -> 3
                is Staff -> 4
                is LightArmor -> 5
                is MediumArmor -> 6
                is HeavyArmor -> 7
                is Accessory -> 8
                is Potion -> 9
                is Egg -> 10
                is Food -> 11
                else -> 13
            }
        } catch (_: Exception) {
            13
        }
    }

    @JvmStatic
    fun random(): Double {
        return randomGenerator.nextDouble()
    }

    @JvmStatic
    fun newTavernVisitor() {
        val tutorialStep = MainActivity.data.tutorialStep
        val adventurer = (when {
            tutorialStep <= 1 -> {
                Adventurer.getInstance("Footman", -1, 1, 0, null, null, null, null, null, PotionsDrank(), null, false)
            }
            tutorialStep == 6 -> {
                Adventurer.getInstance("LightDisciple", -1, 1, 0, null, null, null, Trait.BOOKWORM, null, PotionsDrank(), null, false)
            }
            tutorialStep == 7 -> {
                val adv = Adventurer.getInstance("Archer", -1, 1, 0, null, null, null, Trait.FERAL, null, PotionsDrank(), null, false)
                MainActivity.data.tutorialStep = 8
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_GUILD_MANAGEMENT_101)
                adv
            }
            else -> {
                Adventurer.getInstance(rollClass(), -1, 1, 0, null, null, null, rollCommonTrait(), rollRareTrait(), PotionsDrank(), null, false)
            }
        }) ?: return
        adventurer.setWeapon(getDefaultWeapon(adventurer.weaponType))
        MainActivity.data.tavernGuests.add(0, adventurer)
        if (MainActivity.data.tavernGuests.size > Formulas.getTavernCapacity()) {
            MainActivity.data.tavernGuests.removeAt(MainActivity.data.tavernGuests.size - 1)
        }
    }

    private fun rollClass(): String {
        val dRandom = random()
        return when {
            dRandom < 0.25 -> "Footman"
            dRandom < 0.5 -> "Rogue"
            dRandom < 0.75 -> "Archer"
            else -> "Apprentice"
        }
    }

    private fun rollCommonTrait(): Trait? {
        val dRandom = random()
        return when {
            dRandom < TRAIT_COMMON_INDIVIDUAL_PROBABILITY -> Trait.BOOKWORM
            dRandom < 0.26666666666666666 -> Trait.BRUTE
            dRandom < 0.4 -> Trait.FERAL
            else -> null
        }
    }

    private fun rollRareTrait(): Trait? {
        val dRandom = random()
        return when {
            dRandom < TRAIT_RARE_INDIVIDUAL_PROBABILITY -> Trait.EMPATHETIC
            dRandom < 0.028571428571428574 -> Trait.GIFTED
            dRandom < 0.04285714285714286 -> Trait.INTIMIDATING
            dRandom < 0.05714285714285715 -> Trait.FOCUSED
            dRandom < 0.07142857142857144 -> Trait.DRAGON_BLOOD
            dRandom < 0.08571428571428572 -> Trait.CURSED
            dRandom < 0.1 -> Trait.REACTIVE
            dRandom < 0.1142857142857143 -> Trait.NOCTURNAL
            dRandom < 0.1285714285714286 -> Trait.MINDFUL
            dRandom < 0.14285714285714288 -> Trait.TROLL_BLOOD
            dRandom < 0.15714285714285717 -> Trait.RUTHLESS
            dRandom < 0.17142857142857143 -> Trait.BLESSED
            dRandom < 0.18571428571428572 -> Trait.ALERT
            dRandom < 0.2 -> Trait.NIMBLE
            else -> null
        }
    }

    @JvmStatic
    fun rollPetAbility(list: List<PetAbility>): PetAbility {
        var petAbility = PetAbility.EMPTY
        while (true) {
            if (petAbility != PetAbility.EMPTY && !list.contains(petAbility)) {
                return petAbility
            }
            val dRandom = random()
            petAbility = when {
                dRandom < PET_ABILITY_INDIVIDUAL_PROBABILITY -> PetAbility.FIGHTER
                dRandom < 0.125 -> PetAbility.HEALER
                dRandom < 0.1875 -> PetAbility.DECOY
                dRandom < 0.25 -> PetAbility.OPPORTUNIST
                dRandom < 0.3125 -> PetAbility.MAGIC
                dRandom < 0.375 -> PetAbility.SAVAGE
                dRandom < 0.4375 -> PetAbility.BRIGHT
                dRandom < 0.5 -> PetAbility.EXPERIENCE
                dRandom < 0.5625 -> PetAbility.DROPS
                dRandom < 0.625 -> PetAbility.COUNTERATTACK
                dRandom < 0.6875 -> PetAbility.LIFESTEAL
                dRandom < 0.75 -> PetAbility.REGENERATION
                dRandom < 0.8125 -> PetAbility.BARRIER
                dRandom < 0.875 -> PetAbility.BLOODCRAVE
                dRandom < 0.9375 -> PetAbility.LACERATE
                dRandom < 1.0 -> PetAbility.SERRATED
                else -> PetAbility.EMPTY
            }
        }
    }

    @JvmStatic
    fun rollPotion(): MerchantOffer {
        val dRandom = random()
        var i = 80
        val item = when {
            dRandom < POTION_INDIVIDUAL_PROBABILITY -> Item.getInstance("PotionOfConstitution")
            dRandom < 0.18181818181818182 -> Item.getInstance("PotionOfDexterity")
            dRandom < 0.2727272727272727 -> Item.getInstance("PotionOfIntelligence")
            dRandom < 0.36363636363636365 -> Item.getInstance("PotionOfHealth")
            dRandom < 0.4545454545454546 -> {
                i = Logger.STATUS_FEEBLE_TETHER
                Item.getInstance("PotionOfDefense")
            }
            dRandom < 0.5454545454545454 -> {
                i = 100
                Item.getInstance("PotionOfMagicDefense")
            }
            dRandom < 0.6363636363636364 -> Item.getInstance("PotionOfPrecision")
            dRandom < 0.7272727272727273 -> Item.getInstance("PotionOfViciousness")
            dRandom < 0.8181818181818182 -> Item.getInstance("PotionOfDarkness")
            dRandom < 0.9090909090909092 -> {
                i = 70
                Item.getInstance("PotionOfImmunity")
            }
            dRandom < 1.0 -> Item.getInstance("PotionOfAgility")
            else -> {
                i = 0
                null
            }
        }
        val merchantOffer = MerchantOffer(item)
        merchantOffer.price = i.toLong()
        merchantOffer.isGems = true
        return merchantOffer
    }

    @JvmStatic
    fun rollSpecialFoods(): List<MerchantOffer> {
        val arrayList = ArrayList<MerchantOffer>()
        for (i2 in 0 until 3) {
            var merchantOffer: MerchantOffer? = null
            while (merchantOffer == null || arrayList.contains(merchantOffer)) {
                val dRandom = random()
                var price = 0
                val item = when {
                    dRandom < SPECIAL_FOOD_INDIVIDUAL_PROBABILITY -> {
                        price = 50
                        Item.getInstance("GlazedDonut")
                    }
                    dRandom < 0.3333333333333333 -> {
                        price = 100
                        Item.getInstance("GourmetIcecream")
                    }
                    dRandom < 0.5 -> {
                        price = 200
                        Item.getInstance("Maxxiburger")
                    }
                    dRandom < 0.6666666666666666 -> {
                        price = 400
                        Item.getInstance("Cheesecake")
                    }
                    dRandom < 0.8333333333333333 -> {
                        price = 800
                        Item.getInstance("Ambrosia")
                    }
                    dRandom < 1.0 -> {
                        price = 1500
                        Item.getInstance("CeremonialCake")
                    }
                    else -> null
                }
                val offer = MerchantOffer(item)
                offer.price = price.toLong()
                offer.isGems = true
                merchantOffer = offer
            }
            arrayList.add(merchantOffer)
        }
        arrayList.sortWith(Comparator.comparingInt { ((it.item as? Food)?.getFeedPower() ?: 0) })
        return arrayList
    }

    @JvmStatic
    fun rollUpgrades(): List<MerchantOffer> {
        val arrayList = ArrayList<Item>()
        if (MainActivity.data.upgradeMarketQueue < 1) {
            Item.getInstance("UpgradeMarketQueue")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeMarketTime < 15) {
            Item.getInstance("UpgradeMarketTime")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeQuarters < 15) {
            Item.getInstance("UpgradeQuarters")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeShelter < 7) {
            Item.getInstance("UpgradeShelter")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.levelShelterAutofeed >= 1 && MainActivity.data.upgradeShelterEffectiveness < 5) {
            Item.getInstance("UpgradeShelterEffectiveness")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeStorage < 185) {
            Item.getInstance("UpgradeStorage")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeTavernCapacity < 7) {
            Item.getInstance("UpgradeTavernCapacity")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeTavernTime < 5) {
            Item.getInstance("UpgradeTavernTime")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeWorkshopQueue < 1) {
            Item.getInstance("UpgradeWorkshopQueue")?.let { arrayList.add(it) }
        }
        if (MainActivity.data.upgradeWorkshopTime < 15) {
            Item.getInstance("UpgradeWorkshopTime")?.let { arrayList.add(it) }
        }
        val arrayList2 = ArrayList<MerchantOffer>()
        if (MainActivity.data.upgradeStorage < 6) {
            val item = Item.getInstance("UpgradeStorage")
            if (item != null) {
                arrayList.remove(item)
                val merchantOffer = MerchantOffer(item)
                merchantOffer.price = (item as Upgrade).getGemPrice().toLong()
                merchantOffer.isGems = true
                arrayList2.add(merchantOffer)
            }
        }
        while (arrayList.isNotEmpty() && arrayList2.size < 3) {
            val item2 = arrayList[(random() * arrayList.size.toDouble()).toInt()]
            arrayList.remove(item2)
            val merchantOffer2 = MerchantOffer(item2)
            merchantOffer2.price = (item2 as Upgrade).getGemPrice().toLong()
            merchantOffer2.isGems = true
            arrayList2.add(merchantOffer2)
        }
        return arrayList2
    }

    @JvmStatic
    fun nextTimeTick() {
        MainActivity.data.lastAccess = TrueTimeUtils.millis()
        progressTavernTime(1L)
        progressMarketTime(1L)
        progressWorkshopTime(1L)
        tick60()
        for (area in compileDungeonRaidList()) {
            area.tick()
        }
        MainActivity.shownDialogEntityDetail?.update()
        MainActivity.shownDialogQuests?.update()
        if (QuestsManager.QUEST_COMPLETED_RECENTLY && isMainLooper()) {
            QuestsManager.QUEST_COMPLETED_RECENTLY = false
            QuestsManager.QUEST_NOTIFICATION = true
            (MainActivity.dungeonsFragment?.activity as? MainActivity)?.refreshIcons()
            MainActivity.shownDialogQuests?.reInitialize()
        }
    }

    @JvmStatic
    fun progressTavernTime(j: Long) {
        if (MainActivity.data.isTavernLocked) {
            return
        }
        val tavernVisitorInterval = Formulas.getTavernVisitorInterval() / 1000L
        var j2 = j / tavernVisitorInterval
        var nextTavernVisit = MainActivity.data.nextTavernVisit - (j % tavernVisitorInterval)
        if (nextTavernVisit < 0L) {
            nextTavernVisit += tavernVisitorInterval
            j2++
        }
        MainActivity.data.nextTavernVisit = nextTavernVisit
        val jMin = Math.min(j2, Formulas.getTavernCapacity().toLong())
        for (i in 0 until jMin.toInt()) {
            newTavernVisitor()
        }
        if (jMin > 0L) {
            if (MainActivity.headquartersFragment?.binding != null) {
                MainActivity.headquartersFragment?.refresh()
            }
            MainActivity.shownDialogTavern?.refreshAdventurers()
        }
        MainActivity.shownDialogTavern?.refreshProgressBar()
    }

    @JvmStatic
    fun progressMarketTime(j: Long) {
        var remaining = j
        val arrayList = ArrayList<ItemAction>()
        for (itemAction in MainActivity.data.marketListings) {
            val item = itemAction.item ?: continue
            val secondsPassed = itemAction.secondsPassed
            val secondsToSell = item.getSecondsToSell()
            val jMin = Math.min(remaining, (1L + secondsToSell) - secondsPassed)
            remaining -= jMin
            val j2 = secondsPassed + jMin
            itemAction.secondsPassed = j2
            MainActivity.shownDialogMarket?.updateCountdown()
            if (j2 > secondsToSell) {
                arrayList.add(itemAction)
            }
            if (remaining <= 0L) {
                break
            }
        }
        for (itemAction2 in arrayList) {
            MainActivity.data.marketListings.remove(itemAction2)
            MainActivity.data.soldMarketItems.add(MainActivity.data.soldMarketItems.size, itemAction2)
            MainActivity.shownDialogMarket?.completeItem()
        }
        if (MainActivity.headquartersFragment?.binding != null && arrayList.isNotEmpty()) {
            MainActivity.headquartersFragment?.refresh()
        }
    }

    @JvmStatic
    fun progressWorkshopTime(j: Long) {
        var remaining = j
        val arrayList = ArrayList<ItemAction>()
        for (itemAction in MainActivity.data.workshopQueue) {
            val item = itemAction.item ?: continue
            val secondsPassed = itemAction.secondsPassed
            val secondsToCraft = item.getSecondsToCraft()
            val jMin = Math.min(remaining, (1L + secondsToCraft) - secondsPassed)
            remaining -= jMin
            val j2 = secondsPassed + jMin
            itemAction.secondsPassed = j2
            MainActivity.shownDialogWorkshop?.updateCountdown()
            if (j2 > secondsToCraft) {
                arrayList.add(itemAction)
            }
            if (remaining <= 0L) {
                break
            }
        }
        for (itemAction2 in arrayList) {
            MainActivity.data.workshopQueue.remove(itemAction2)
            MainActivity.data.completedWorkshopItems.add(MainActivity.data.completedWorkshopItems.size, itemAction2)
            MainActivity.shownDialogWorkshop?.completeItem()
        }
        if (MainActivity.headquartersFragment?.binding != null && arrayList.isNotEmpty()) {
            MainActivity.headquartersFragment?.refresh()
        }
    }

    @JvmStatic
    fun tick60() {
        val i = checks
        if (i < 60) {
            checks = i + 1
            return
        }
        val jMillis = TrueTimeUtils.millis()
        val calendar = Calendar.getInstance()
        calendar.time = Date(jMillis)
        checks = calendar.get(Calendar.SECOND) - 1
        checkDismissedAdventurersExpiration(jMillis)
        refreshCooldowns(jMillis)
        if (firstRunTriggered && MainActivity.data.isReviewTrigger && !MainActivity.data.isReviewShown) {
            MainActivity.data.isReviewShown = true
            showReviewCard()
        }
        if (jMillis - MainActivity.data.lastWeekTriggered > 604800000L) {
            tickWeek(jMillis)
        }
        if (jMillis - MainActivity.data.last24Triggered > ONE_DAY_IN_MILLISECONDS) {
            tick24Hours(jMillis)
        }
        if (jMillis - MainActivity.data.lastHourTriggered > ONE_HOUR_IN_MILLISECONDS) {
            tickHour(jMillis)
        }
        firstRunTriggered = true
    }

    private fun tickHour(j: Long) {
        val calendar = Calendar.getInstance()
        calendar.time = Date(j)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        MainActivity.data.lastHourTriggered = calendar.time.time
        FileManager.writeToCloud()
    }

    private fun tick24Hours(j: Long) {
        val calendar = Calendar.getInstance()
        calendar.time = Date(j)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        MainActivity.data.last24Triggered = calendar.time.time
        GuildActivitiesManager.ensureRequest(j)
        for (area in compileRaidList()) {
            val areaType = area.getAreaType()
            if (areaType == 1 || areaType == 2) {
                area.triesAvailable = true
                area.refreshTries()
            }
        }
        refreshMerchantRegularStock()
        checkBlackMarketDailyArrival()
        (MainActivity.dungeonsFragment?.activity as? MainActivity)?.refreshIcons()
        MainActivity.data.adsWatched = 0
        (MainActivity.dungeonsFragment?.activity as? MainActivity)?.loadAd()
        restoreErroneouslyCompletedEpicRaids()
    }

    private fun tickWeek(j: Long) {
        val calendar = Calendar.getInstance()
        calendar.time = Date(j)
        calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK) - 1))
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        MainActivity.data.lastWeekTriggered = calendar.time.time
        GuildActivitiesManager.ensureSiege(j)
        QuestsManager.extractQuests()
        QuestsManager.QUEST_NOTIFICATION = true
        (MainActivity.dungeonsFragment?.activity as? MainActivity)?.refreshIcons()
        refreshMerchantSpecialReserve()
        MainActivity.shownDialogQuests?.dismiss()
    }

    /** Rerolls the traveling merchant's regular stock (4 latest unlocked dungeons). */
    @JvmStatic
    fun refreshMerchantRegularStock() {
        val d = MainActivity.data
        d.merchantRegularStockItems.clear()
        var arrayList: MutableList<Area> = ArrayList(compileDungeonList())
        arrayList.removeAll { !it.isUnlocked }
        if (arrayList.size > 4) {
            arrayList = arrayList.subList(arrayList.size - 4, arrayList.size)
        }
        for (area2 in arrayList) {
            if (area2.isUnlocked) {
                val item = rollFromWeightedMap(area2.rollMerchantRegularOffers()) as? Item
                if (item != null) {
                    val merchantOffer = MerchantOffer(item)
                    merchantOffer.isGems = false
                    merchantOffer.price = item.getPrice() * item.getStack().toLong() * 10L
                    d.merchantRegularStockItems.add(merchantOffer)
                }
            }
        }
        d.isNewMerchantRegularItems = true
        MainActivity.shownDialogMerchant?.newItems()
    }

    /** Rerolls the traveling merchant's special reserve (weekly rotation + unique drops). */
    @JvmStatic
    fun refreshMerchantSpecialReserve() {
        val d = MainActivity.data
        d.merchantSpecialReserve.clear()
        val listCompileDungeonList = compileDungeonList()
        var currentDungeon: Area? = MainActivity.data.enchantedForest
        var i = 50
        for (area in listCompileDungeonList) {
            if (area.isUnlocked) {
                i += 5
                currentDungeon = area
            }
        }
        val item = rollFromWeightedMap(currentDungeon?.rollMerchantSpecialOffers()) as? Item
        if (item != null) {
            val merchantOffer = MerchantOffer(item)
            merchantOffer.price = i.toLong()
            merchantOffer.isGems = true
            d.merchantSpecialReserve.add(merchantOffer)
        }
        if (random() < 0.55) {
            val itemAegis = Item.getInstance("Aegis")
            val merchantOffer2 = MerchantOffer(itemAegis)
            merchantOffer2.price = 1000L
            merchantOffer2.isGems = true
            d.merchantSpecialReserve.add(merchantOffer2)
        }
        val itemStrand = Item.getInstance("ScarletStrand")
        val merchantOffer3 = MerchantOffer(itemStrand)
        merchantOffer3.price = 650L
        merchantOffer3.isGems = true
        d.merchantSpecialReserve.add(merchantOffer3)
        for (missingUnique in listUniqueDropsMissing()) {
            val itemUnique = Item.getInstance(missingUnique)
            val merchantOffer4 = MerchantOffer(itemUnique)
            merchantOffer4.price = 1L
            merchantOffer4.isGems = true
            d.merchantSpecialReserve.add(merchantOffer4)
        }
        for (i2 in 0 until 3) {
            d.merchantSpecialReserve.add(rollPotion())
        }
        d.merchantSpecialReserve.addAll(rollSpecialFoods())
        d.merchantSpecialReserve.addAll(rollUpgrades())
        d.isNewMerchantSpecialItems = true
    }

    /**
     * Daily roll for the Black Market: 10% chance per day, guaranteed on the 7th
     * consecutive missed day (bad luck protection). Called from [tick24Hours].
     */
    @JvmStatic
    fun checkBlackMarketDailyArrival() {
        val d = MainActivity.data
        if (d.blackMarketMissedDays >= 6 || random() < 0.10) {
            d.isBlackMarketActive = true
            d.blackMarketMissedDays = 0
            refreshBlackMarketStock()
        } else {
            d.isBlackMarketActive = false
            d.isNewBlackMarketItems = false
            d.blackMarketStock.clear()
            d.blackMarketMissedDays += 1
            MainActivity.shownDialogBlackMarket?.dismiss()
        }
        ((MainActivity.dungeonsFragment?.activity as? MainActivity) ?: (MainActivity.headquartersFragment.activity as? MainActivity))?.refreshIcons()
    }

    /**
     * Rerolls the Black Market's 12-slot nocturnal stall:
     * 1-4 smuggled materials (-50% gold), 5 smuggled legendary (ScarletStrand/Aegis),
     * 6-7 contraband potions (-40%), 8 shady delicacy (-40%), 9 evolution vial,
     * 10-12 guild upgrades at -35% gems.
     */
    @JvmStatic
    fun refreshBlackMarketStock() {
        val d = MainActivity.data
        d.blackMarketStock.clear()

        // Slots 1-4: Smuggled Materials — 4 random materials from unlocked dungeons at 5x sell price (-50% gold).
        val materialPool = ArrayList<Item>()
        for (area in compileDungeonList()) {
            if (area.isUnlocked) {
                val mat = rollFromWeightedMap(area.rollMerchantRegularOffers()) as? Item
                if (mat != null) {
                    materialPool.add(mat)
                }
            }
        }
        val seenMaterials = ArrayList<String>()
        var materialSlots = 0
        while (materialSlots < 4 && materialPool.isNotEmpty()) {
            val mat = materialPool[(random() * materialPool.size.toDouble()).toInt()]
            val trueClass = mat.getTrueClass() ?: ""
            if (!seenMaterials.contains(trueClass)) {
                seenMaterials.add(trueClass)
                val materialOffer = MerchantOffer(mat)
                materialOffer.price = mat.getPrice() * mat.getStack().toLong() * 5L
                materialOffer.isGems = false
                d.blackMarketStock.add(materialOffer)
                materialSlots++
            } else {
                materialPool.remove(mat)
            }
        }

        // Slot 5: Smuggled Legendary — 90% gems at -35%, 10% gold.
        val legendary = if (random() < 0.5) Item.getInstance("ScarletStrand") else Item.getInstance("Aegis")
        if (legendary != null) {
            val legendaryOffer = MerchantOffer(legendary)
            val isScarlet = legendary.getTrueClass() == "ScarletStrand"
            if (random() < 0.9) {
                legendaryOffer.isGems = true
                legendaryOffer.price = if (isScarlet) 420L else 650L
            } else {
                legendaryOffer.isGems = false
                legendaryOffer.price = if (isScarlet) 75000L else 120000L
            }
            d.blackMarketStock.add(legendaryOffer)
        }

        // Slots 6-7: Contraband Potions — 2 at -40% gems (42-60), 25% chance of gold equivalent.
        for (i2 in 0 until 2) {
            val potionOffer = rollPotion()
            val discounted = (potionOffer.price * 0.6).toLong()
            potionOffer.price = discounted
            if (random() < 0.25) {
                potionOffer.isGems = false
            }
            d.blackMarketStock.add(potionOffer)
        }

        // Slot 8: Shady Delicacy — 1 food at -40% gems (30-900).
        val delicacy = rollBlackMarketDelicacy()
        if (delicacy != null) {
            d.blackMarketStock.add(delicacy)
        }

        // Slot 9: Evolution Vial — Evo22Vial (1000) or Evo23Vial (1200) gems.
        val vial = if (random() < 0.5) Item.getInstance("Evo22Vial") else Item.getInstance("Evo23Vial")
        if (vial != null) {
            val vialOffer = MerchantOffer(vial)
            vialOffer.isGems = true
            vialOffer.price = if (vial.getTrueClass() == "Evo22Vial") 1000L else 1200L
            d.blackMarketStock.add(vialOffer)
        }

        // Slots 10-12: Guild Upgrades at -35% gem discount.
        for (upgradeOffer in rollUpgrades()) {
            val upgradeItem = upgradeOffer.item ?: continue
            val discounted = Utils.round((upgradeItem as? Upgrade)?.getGemPrice()?.toDouble() ?: 0.0).toLong()
            val blackMarketUpgrade = MerchantOffer(upgradeItem)
            blackMarketUpgrade.isGems = true
            blackMarketUpgrade.price = (discounted * 0.65).toLong()
            d.blackMarketStock.add(blackMarketUpgrade)
        }

        d.isNewBlackMarketItems = true
        MainActivity.shownDialogBlackMarket?.newItems()
    }

    private fun rollBlackMarketDelicacy(): MerchantOffer? {
        val dRandom = random()
        var price = 0
        val item = when {
            dRandom < SPECIAL_FOOD_INDIVIDUAL_PROBABILITY -> {
                price = 50
                Item.getInstance("GlazedDonut")
            }
            dRandom < 0.3333333333333333 -> {
                price = 100
                Item.getInstance("GourmetIcecream")
            }
            dRandom < 0.5 -> {
                price = 200
                Item.getInstance("Maxxiburger")
            }
            dRandom < 0.6666666666666666 -> {
                price = 400
                Item.getInstance("Cheesecake")
            }
            dRandom < 0.8333333333333333 -> {
                price = 800
                Item.getInstance("Ambrosia")
            }
            dRandom < 1.0 -> {
                price = 1500
                Item.getInstance("CeremonialCake")
            }
            else -> null
        }
        if (item == null) return null
        val offer = MerchantOffer(item)
        offer.price = (price.toLong() * 0.6).toLong()
        offer.isGems = true
        return offer
    }

    private fun showReviewCard() {
        try {
            val context = MainActivity.headquartersFragment?.context ?: return
            val activity = MainActivity.headquartersFragment?.activity ?: return
            val reviewManagerCreate = ReviewManagerFactory.create(context)
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener { task ->
                try {
                    if (task.isSuccessful) {
                        val reviewInfo = task.result as? ReviewInfo
                        if (reviewInfo != null) {
                            reviewManagerCreate.launchReviewFlow(activity, reviewInfo).addOnCompleteListener { }
                        }
                    }
                } catch (_: Exception) {
                }
            }
        } catch (_: Exception) {
        }
    }

    private fun restoreErroneouslyCompletedEpicRaids() {
        var z = false
        var z2 = true
        val celestial = MainActivity.data.celestialMothership
        if (celestial != null) {
            if (!celestial.completed() || MainActivity.data.seenItems.contains("Evo23Vial")) {
                z = false
            } else {
                celestial.maxProgress = 1
                celestial.drops.clear()
                z = true
            }
        }
        val imperial = MainActivity.data.imperialRescue
        if (imperial != null && imperial.completed() && !MainActivity.data.seenItems.contains("SkeletonKey")) {
            imperial.maxProgress = 1
            imperial.drops.clear()
            z = true
        }
        val divine = MainActivity.data.divineArcheology
        if (divine != null) {
            if (!divine.completed() || MainActivity.data.seenItems.contains("DivineZygote")) {
                z2 = z
            } else {
                divine.maxProgress = 1
                divine.drops.clear()
            }
        }
        if (z2) {
            try {
                MainActivity.raidsFragment?.refresh()
            } catch (_: Exception) {
            }
        }
    }

    @JvmStatic
    fun checkDismissedAdventurersExpiration(j: Long) {
        try {
            MainActivity.data.dismissedAdventurers.removeAll { adventurer ->
                j - adventurer.timeWhenDismissed > 93600000L
            }
        } catch (_: UnsupportedOperationException) {
        }
    }

    @JvmStatic
    fun refreshCooldowns(j: Long) {
        GuildActivitiesManager.ensureActivities(j)
        val lastWeekTriggered = (604800000L - (j - MainActivity.data.lastWeekTriggered)) / 60000L
        val i = (lastWeekTriggered / 1440L).toInt()
        val j2 = lastWeekTriggered % 1440L
        val i2 = (j2 / 60L).toInt()
        val i3 = (j2 % 60L).toInt()
        val raidsFrag = MainActivity.raidsFragment
        if (raidsFrag?.binding != null) {
            raidsFrag.binding?.raidRefreshTime?.text = String.format(raidsFrag.getString(R.string.time_hours_minutes), i2, i3)
        }
        val guildFrag = MainActivity.guildActivitiesFragment
        if (guildFrag.binding != null) {
            val lastHunt = (ONE_DAY_IN_MILLISECONDS - (j - MainActivity.data.last24Triggered)) / 60000L
            val huntHours = (lastHunt / 60L).toInt().coerceAtLeast(0)
            val huntMinutes = (lastHunt % 60L).toInt().coerceAtLeast(0)
            val lastSiege = (604800000L - (j - MainActivity.data.lastWeekTriggered)) / 60000L
            val siegeDays = (lastSiege / 1440L).toInt().coerceAtLeast(0)
            val siegeRest = lastSiege % 1440L
            val siegeHours = (siegeRest / 60L).toInt().coerceAtLeast(0)
            val siegeMinutes = (siegeRest % 60L).toInt().coerceAtLeast(0)
            guildFrag.binding?.guildHuntRefreshTime?.text = String.format(guildFrag.getString(R.string.time_hours_minutes), huntHours, huntMinutes)
            guildFrag.binding?.guildSiegeRefreshTime?.text = String.format(guildFrag.getString(R.string.time_days_hours_minutes), siegeDays, siegeHours, siegeMinutes)
        }
        MainActivity.shownDialogMerchant?.refreshCooldowns(i, i2, i3)
        MainActivity.shownDialogQuests?.refreshCooldowns(i, i2, i3)
        val lastBlackMarket = (ONE_DAY_IN_MILLISECONDS - (j - MainActivity.data.last24Triggered)) / 60000L
        val blackMarketDays = (lastBlackMarket / 1440L).toInt().coerceAtLeast(0)
        val blackMarketRest = lastBlackMarket % 1440L
        val blackMarketHours = (blackMarketRest / 60L).toInt().coerceAtLeast(0)
        val blackMarketMinutes = (blackMarketRest % 60L).toInt().coerceAtLeast(0)
        MainActivity.shownDialogBlackMarket?.refreshCountdown(blackMarketDays, blackMarketHours, blackMarketMinutes)
    }

    @JvmStatic
    fun getEquipmentDrawable(equipment: Equipment?, context: Context?): Drawable? {
        val ctx = context ?: return null
        return ResourcesCompat.getDrawable(ctx.resources, equipment?.getIdImage() ?: R.drawable.empty_equipment, ctx.theme)
    }

    @JvmStatic
    fun getIdleAdventurers(vararg numArr: Int?): List<Adventurer> {
        val hashSet = HashSet<Int?>()
        hashSet.addAll(numArr)
        for (area in compileDungeonRaidList()) {
            hashSet.addAll(area.adventurersExploringIds)
        }
        val arrayList = ArrayList<Adventurer>()
        for (adventurer in MainActivity.data.adventurers) {
            if (!hashSet.contains(adventurer.id)) {
                arrayList.add(adventurer)
            }
        }
        return arrayList
    }

    @JvmStatic
    fun getIdlePets(): MutableList<Pet> {
        val arrayList = ArrayList<Int>()
        for (area in compileDungeonRaidList()) {
            if (area.petExploringId != null) {
                arrayList.add(area.petExploringId!!)
            }
        }
        val arrayList2 = ArrayList<Pet>()
        for (pet in MainActivity.data.pets) {
            if (!arrayList.contains(pet.id)) {
                arrayList2.add(pet)
            }
        }
        return arrayList2
    }

    @JvmStatic
    fun collectItem(item: Item?, list: MutableList<Item>?) {
        if (item == null || list == null) return
        val trueClass = item.getTrueClass() ?: return
        MainActivity.data.seenItems.add(trueClass)
        // First Scarlet Strand acquisition unlocks The Sanguine Crucible raid.
        if (trueClass == "ScarletStrand") {
            MainActivity.data.sanguineCrucible?.let {
                if (!it.isUnlocked) {
                    UIUtils.unlockArea(it)
                }
            }
        }
        if (MainActivity.data.items == list) {
            if ("DivineZygote" == trueClass) {
                MainActivity.data.isReviewTrigger = true
            }
            val recipesInto = Recipes.into(item)
            if (recipesInto != null) {
                MainActivity.data.knownRecipes.add(recipesInto)
            }
            MainActivity.data.knownRecipes.addAll(Recipes.from(item))
        }
        val idx = list.indexOf(item)
        if (idx != -1) {
            val item2 = list[idx]
            item2.setStack(Math.min(99999, item2.getStack() + item.getStack()))
        } else {
            val newItem = Item.getInstance(trueClass, Math.min(99999, item.getStack()))
            if (newItem != null) {
                list.add(newItem)
            }
        }
    }

    @JvmStatic
    fun removeItemFromStorage(item: Item?) {
        if (item == null) return
        val idx = MainActivity.data.items.indexOf(item)
        if (idx == -1) return
        val item2 = MainActivity.data.items[idx]
        item2.setStack(Math.max(0, item2.getStack() - item.getStack()))
        if (item2.getStack() == 0) {
            MainActivity.data.items.removeAt(idx)
        }
    }

    @JvmStatic
    fun orderByTurnsPriority(list: MutableList<Entity>) {
        list.sortWith(fightPriorityComparator)
    }

    @JvmStatic
    fun calculateNewAdventurerId(): Int {
        var id = -1
        for (adventurer in MainActivity.data.adventurers) {
            if (adventurer.id > id) {
                id = adventurer.id
            }
        }
        return id + 1
    }

    @JvmStatic
    fun calculateNewPetId(): Int {
        var id = -1
        for (pet in MainActivity.data.pets) {
            if (pet.id > id) {
                id = pet.id
            }
        }
        return id + 1
    }

    @JvmStatic
    fun truncatePrice(j: Long): Long {
        if (j <= WorkRequest.MIN_BACKOFF_MILLIS) {
            return j
        }
        val j2 = if (j <= 1000000L) {
            j % 100
        } else {
            j % WorkRequest.MIN_BACKOFF_MILLIS
        }
        return j - j2
    }

    @JvmStatic
    fun gotEnoughItem(item: Item?): Boolean {
        if (item == null) return false
        val idx = MainActivity.data.items.indexOf(item)
        return idx != -1 && MainActivity.data.items[idx].getStack() >= item.getStack()
    }

    @JvmStatic
    fun maxCraftableAmount(recipes: Recipes?): Int {
        if (recipes == null) return 0
        var minAmount = 99999
        for (item in recipes.getIngredients()) {
            if (item == null) continue
            val idx = MainActivity.data.items.indexOf(item)
            if (idx == -1) {
                return 0
            }
            minAmount = Math.min(minAmount, MainActivity.data.items[idx].getStack() / item.getStack())
        }
        return minAmount
    }

    @JvmStatic
    fun getDefaultWeapon(i: Int): Weapon? {
        return when (i) {
            R.string.type_sword -> Item.getInstance("Spade") as? Weapon
            R.string.type_staff -> Item.getInstance("Cane") as? Weapon
            R.string.type_dagger -> Item.getInstance("Sickle") as? Weapon
            R.string.type_bow -> Item.getInstance("TrainingBow") as? Weapon
            else -> null
        }
    }

    /**
     * Scales a raw auto-feed feed-power amount by the Shelter Effectiveness bonus
     * (Formulas.getShelterEffectivenessPercent), rounded to the nearest integer.
     * Only used by dungeon/raid auto-feeding — manual feeding is never affected.
     */
    @JvmStatic
    fun effectiveAutoFeedPower(feedPower: Int): Int {
        val percent = Formulas.getShelterEffectivenessPercent()
        if (percent <= 0) return feedPower
        return Math.round(feedPower * (1.0 + percent * 0.01)).toInt()
    }

    @JvmStatic
    fun collectDrops(fragment: Fragment, area: Area) {
        val arrayList = ArrayList<Pet>()
        for (pet in MainActivity.data.pets) {
            if (pet.favourite) {
                arrayList.add(pet)
            }
        }
        val size = arrayList.size
        val dropsArray = area.drops.toTypedArray()
        val remainingSpace = remainingInventorySpaceAfterCollecting(size > 0, *dropsArray)
        if (remainingSpace < 0) {
            if (MainActivity.shownDialogFullStorage != null) return
            val context = fragment.context ?: return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                String.format(fragment.getString(R.string.no_storage_space_body_loot), -remainingSpace),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
            dialog.show()
            return
        }
        val dialogCollectDrops = DialogCollectDrops()
        dialogCollectDrops.isCancelable = false
        dialogCollectDrops.drops = ArrayList(area.drops)
        dialogCollectDrops.sourceArea = fragment.getString(area.getName())
        dialogCollectDrops.recap = area.adventureRecap
        area.adventureRecap = AdventureRecap()
        // Hand the Auto-Raid session report over to the collect dialog, then clear the
        // session counters so a later manual claim doesn't re-show the same report.
        dialogCollectDrops.autoRaidAttempts = area.autoRaidRunsCompleted
        dialogCollectDrops.autoRaidGemsSpent = area.autoRaidGemsSpent
        dialogCollectDrops.autoRaidStopReasonRes = area.autoRaidStopReasonRes
        area.autoRaidRunsCompleted = 0
        area.autoRaidGemsSpent = 0
        area.autoRaidStopReasonRes = 0
        dialogCollectDrops.show(fragment.parentFragmentManager, "dialog_collect_drops")
        var feedPower = 0
        for (item in area.drops) {
            if (size <= 0 || item !is Food) {
                collectItem(item, MainActivity.data.items)
            } else {
                feedPower += item.getFeedPower() * item.getStack()
            }
        }
        if (size > 0) {
            // Shelter Effectiveness scales only the auto-feed amount (never manual feeding).
            val effectiveFeedPower = effectiveAutoFeedPower(feedPower)
            val i = effectiveFeedPower / size
            for (pet in arrayList) {
                pet.feed(i)
            }
        }
        area.drops.clear()
        area.refreshLoot()
        if (area.getAreaType() == 2 && area.completed()) {
            (fragment as? RaidsFragment)?.refreshRaidVisibility()
            val context = fragment.context
            if (context != null) {
                UIUtils.getInfoDialog(
                    context,
                    R.string.epic_raid_completed_title,
                    String.format(fragment.getString(R.string.epic_raid_completed_body), fragment.getString(area.getName())),
                    false
                ).show()
            }
        }
        MainActivity.headquartersFragment?.refresh()
    }

    /**
     * "Claim all chests" batch collection: collapses every active dungeon's loot into a
     * single consolidated claim dialog ("All Dungeons").
     */
    @JvmStatic
    fun collectAllDungeonDrops(fragment: Fragment) {
        val activeDungeons = compileDungeonList().filter { it.drops.isNotEmpty() }
        if (activeDungeons.isEmpty()) return

        // 1. Consolidate drop stacks across all dungeons to accurately calculate the
        //    inventory slot requirement (no duplicate slots for identical items).
        val consolidatedDrops = consolidateDropsForClaim(activeDungeons)

        val favPets = MainActivity.data.pets.filter { it.favourite }
        val remainingSpace = remainingInventorySpaceAfterCollecting(favPets.isNotEmpty(), *consolidatedDrops.toTypedArray())

        // 2. Prevent collection if inventory would overflow.
        if (remainingSpace < 0) {
            if (MainActivity.shownDialogFullStorage != null) return
            val context = fragment.context ?: return
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                String.format(fragment.getString(R.string.no_storage_space_body_loot), -remainingSpace),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener { MainActivity.shownDialogFullStorage = null }
            dialog.show()
            return
        }

        // 3. Pet auto-feeding across pooled food.
        var feedPower = 0
        for (item in consolidatedDrops) {
            if (favPets.isEmpty() || item !is Food) {
                collectItem(item, MainActivity.data.items)
            } else {
                feedPower += item.getFeedPower() * item.getStack()
            }
        }
        if (favPets.isNotEmpty() && feedPower > 0) {
            val effectiveFeedPower = effectiveAutoFeedPower(feedPower)
            val perPet = effectiveFeedPower / favPets.size
            for (pet in favPets) {
                pet.feed(perPet)
            }
        }

        // 4. Merge the adventure recaps into a single consolidated guild report.
        val mergedRecap = mergeAdventureRecaps(activeDungeons)

        // 5. Clear collected dungeon state.
        for (area in activeDungeons) {
            area.adventureRecap = AdventureRecap()
            area.drops.clear()
            area.refreshLoot()
        }

        // 6. Present the consolidated claim dialog.
        val dialogCollectDrops = DialogCollectDrops()
        dialogCollectDrops.isCancelable = false
        dialogCollectDrops.drops = consolidatedDrops
        dialogCollectDrops.sourceArea = fragment.getString(R.string.all_dungeons)
        dialogCollectDrops.recap = mergedRecap
        dialogCollectDrops.show(fragment.parentFragmentManager, "dialog_collect_all_drops")

        MainActivity.headquartersFragment?.refresh()
    }

    /** Merges identical item stacks from the given areas into a single list. */
    @JvmStatic
    fun consolidateDropsForClaim(areas: List<Area>): MutableList<Item> {
        val consolidatedDrops = ArrayList<Item>()
        for (area in areas) {
            for (item in area.drops) {
                val existing = consolidatedDrops.find { it.getTrueClass() == item.getTrueClass() }
                if (existing != null) {
                    existing.setStack(existing.getStack() + item.getStack())
                } else {
                    val newItem = Item.getInstance(item.getTrueClass() ?: "", item.getStack()) ?: item
                    consolidatedDrops.add(newItem)
                }
            }
        }
        return consolidatedDrops
    }

    /** Aggregates several adventure recaps into one consolidated guild report. */
    @JvmStatic
    fun mergeAdventureRecaps(areas: List<Area>): AdventureRecap {
        val mergedRecap = AdventureRecap()
        mergedRecap.secondsPassed = areas.maxOfOrNull { it.adventureRecap.secondsPassed } ?: 0
        mergedRecap.areasCleared = areas.sumOf { it.adventureRecap.areasCleared }
        mergedRecap.wiped = areas.sumOf { it.adventureRecap.wiped }
        mergedRecap.expEarned = areas.sumOf { it.adventureRecap.expEarned }
        mergedRecap.expLost = areas.sumOf { it.adventureRecap.expLost }

        for (area in areas) {
            for (counter in area.adventureRecap.enemiesKilled) {
                val existing = mergedRecap.enemiesKilled.find { it.enemy == counter.enemy }
                if (existing != null) {
                    existing.timesSlain += counter.timesSlain
                } else {
                    mergedRecap.enemiesKilled.add(EnemyCounter(counter.enemy, counter.timesSlain))
                }
            }
        }
        return mergedRecap
    }

    @JvmStatic
    fun remainingInventorySpaceAfterCollecting(z: Boolean, vararg itemArr: Item?): Int {
        var i = 0
        for (item in itemArr) {
            if (item == null) continue
            if (!MainActivity.data.items.contains(item) && (!z || item !is Food)) {
                i++
            }
        }
        return Formulas.storageSpaces() - (i + MainActivity.data.items.size)
    }

    @JvmStatic
    fun listUniqueDropsMissing(): MutableList<String> {
        try {
            val arrayList = ArrayList<String>()
            val uniqueIds = listOf(
                "DivineZygote", "DivineEmbryo", "DivineLarvae", "Sha",
                "EyesOfTheSwordsman", "AmuletOfTheSwordsman", "SkeletonKey",
                "SerpentStaff", "SerpentLunge", "SerpentBite", "SerpentSting"
            )
            for (str in uniqueIds) {
                if (MainActivity.data.seenItems.contains(str)) {
                    arrayList.add(str)
                    val item = Item.getInstance(str)
                    if (item != null && item.getUniqueOrigin() != item.getTrueClass()) {
                        val origin = item.getUniqueOrigin()
                        if (origin != null) {
                            arrayList.remove(origin)
                        }
                    }
                }
            }
            val arrayList2 = ArrayList<String>()
            for (item2 in MainActivity.data.items) {
                val tc = item2.getTrueClass()
                if (tc != null && arrayList.contains(tc)) {
                    arrayList2.add(tc)
                }
            }
            for (adventurer in MainActivity.data.adventurers) {
                val w = adventurer.weapon?.getTrueClass()
                if (w != null && arrayList.contains(w)) arrayList2.add(w)
                val a = adventurer.armor?.getTrueClass()
                if (a != null && arrayList.contains(a)) arrayList2.add(a)
                val acc = adventurer.accessory?.getTrueClass()
                if (acc != null && arrayList.contains(acc)) arrayList2.add(acc)
            }
            for (area in compileRaidList()) {
                for (item3 in area.drops) {
                    val tc = item3.getTrueClass()
                    if (tc != null && arrayList.contains(tc)) {
                        arrayList2.add(tc)
                    }
                }
            }
            for (action in MainActivity.data.workshopQueue) {
                val item = action.item ?: continue
                val recipes = Recipes.into(item) ?: continue
                for (ing in recipes.getIngredients()) {
                    val tc = ing?.getTrueClass()
                    if (tc != null) arrayList2.add(tc)
                }
            }
            for (action in MainActivity.data.completedWorkshopItems) {
                val item = action.item ?: continue
                val recipes = Recipes.into(item) ?: continue
                for (ing in recipes.getIngredients()) {
                    val tc = ing?.getTrueClass()
                    if (tc != null) arrayList2.add(tc)
                }
            }
            arrayList.removeAll(arrayList2)
            return arrayList
        } catch (_: Exception) {
            return ArrayList()
        }
    }

    @JvmStatic
    fun gotUniqueDrop(str: String, area: Area): Boolean {
        if (MainActivity.data.seenItems.contains(str)) {
            return true
        }
        for (item in area.drops) {
            if (item.getTrueClass() == str) {
                return true
            }
        }
        return false
    }

    @JvmStatic
    fun <T> rollFromWeightedMap(map: Map<T, Int>?): T? {
        if (map != null && map.isNotEmpty()) {
            val dRandom = random() * 1000.0
            var iIntValue = 0
            for ((key, value) in map) {
                iIntValue += value
                if (dRandom < iIntValue) {
                    return key
                }
            }
        }
        return null
    }

    @JvmStatic
    fun getNewestSaveFile(data: Data, data2: Data): Data {
        val z = data.lastAccess - data2.lastAccess > 0
        val z2 = calculateAdventurersLevelSum(data) < 6
        return if (z2 == (calculateAdventurersLevelSum(data2) < 6)) {
            if (z) data else data2
        } else {
            if (z2) data2 else data
        }
    }

    @JvmStatic
    fun calculateAdventurersLevelSum(data: Data): Int {
        var maxLevel = 0
        for (adventurer in data.adventurers) {
            maxLevel += (((adventurer.maxLevel / 5) - 1) * 5) + adventurer.level
        }
        for (adventurer2 in data.dismissedAdventurers) {
            maxLevel += (((adventurer2.maxLevel / 5) - 1) * 5) + adventurer2.level
        }
        return maxLevel
    }

    @JvmStatic
    fun compileDungeonList(): List<Area> {
        if (dungeonsList == null) {
            dungeonsList = listOfNotNull(
                MainActivity.data.enchantedForest,
                MainActivity.data.theDesert,
                MainActivity.data.eternalBattlefield,
                MainActivity.data.theGoldenCity,
                MainActivity.data.blackwaterPort,
                MainActivity.data.frostbitePeaks,
                MainActivity.data.obsidianMines,
                MainActivity.data.theSouthernGrove,
                MainActivity.data.barrenWastelands,
                MainActivity.data.hiddenCityOfLarox,
                MainActivity.data.lostLands
            )
        }
        return dungeonsList!!
    }

    @JvmStatic
    fun compileRaidList(): List<Area> {
        if (raidsList == null) {
            raidsList = listOfNotNull(
                MainActivity.data.theSlimePond,
                MainActivity.data.divineArcheology,
                MainActivity.data.ancientGraveDigging,
                MainActivity.data.imperialRescue,
                MainActivity.data.theCultistRebels,
                MainActivity.data.theDreadfulAscent,
                MainActivity.data.theLostExpedition,
                MainActivity.data.celestialMothership,
                MainActivity.data.theDireDescent,
                MainActivity.data.sleepingPlanet,
                MainActivity.data.kaunis,
                MainActivity.data.theTower,
                MainActivity.data.sanguineCrucible
            )
        }
        return raidsList!!
    }

    /** The guild-activity areas (The Hunt / The Siege / The Slumbering Shallows), shown on the 5th Guild Activities tab. */
    @JvmStatic
    fun compileGuildActivitiesList(): List<Area> {
        return listOfNotNull(MainActivity.data.guildRequest, MainActivity.data.guildSiege, MainActivity.data.theSlumberingShallows)
    }

    @JvmStatic
    fun compileDungeonRaidList(): List<Area> {
        if (dungeonsRaidsList == null) {
            val list = ArrayList<Area>()
            dungeonsRaidsList = list
            list.addAll(compileDungeonList())
            list.addAll(compileRaidList())
            list.addAll(compileGuildActivitiesList())
        }
        return dungeonsRaidsList!!
    }

    /**
     * Drops the cached area lists so the next compileDungeonList()/compileRaidList()/
     * compileDungeonRaidList() call rebuilds them from the current MainActivity.data.
     *
     * Called after importing a save or starting a new game. Without this, the static
     * caches keep pointing at the old save's Area instances (which only reset when the
     * process is killed), so the dungeon/raid screens keep showing the old save.
     */
    @JvmStatic
    fun invalidateAreaCaches() {
        dungeonsList = null
        raidsList = null
        dungeonsRaidsList = null
    }

    @JvmStatic
    fun getBaseClass(adventurer: Adventurer): String {
        if (adventurer.weaponType == R.string.type_bow) {
            return "Archer"
        }
        if (adventurer.weaponType == R.string.type_dagger) {
            return "Rogue"
        }
        return if (adventurer.weaponType == R.string.type_staff) "Apprentice" else "Footman"
    }

    @JvmStatic
    fun triggerGuildSizeAchievementCheck() {
        val maxAdventurersOwned = MainActivity.data.maxAdventurersOwned
        if (maxAdventurersOwned >= 20) {
            return
        }
        val size = MainActivity.data.adventurers.size
        if (maxAdventurersOwned < 5 && size >= 5) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_SMALL_GUILD)
        }
        if (maxAdventurersOwned < 12 && size >= 12) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RESPECTABLE_GUILD)
        }
        if (size >= 20) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_VERSATILE_ARMY)
        }
        MainActivity.data.maxAdventurersOwned = Math.max(size, maxAdventurersOwned)
    }

    @JvmStatic
    fun isMainLooper(): Boolean {
        return Looper.myLooper() == Looper.getMainLooper()
    }
}
