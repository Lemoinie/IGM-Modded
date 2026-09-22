package it.paranoidsquirrels.idleguildmaster.storage.data

import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesState

import com.google.gson.annotations.SerializedName
import it.paranoidsquirrels.idleguildmaster.KingMessage
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.*
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.*
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CopyOnWriteArraySet

class Data {
    @SerializedName("adsWatched")
    var adsWatched: Int = 0
    @SerializedName("adventurerPackPurchased")
    var isAdventurerPackPurchased: Boolean = false
    @SerializedName("afflictionLevel")
    var afflictionLevel: Int = 0
    @SerializedName("afflictionProgress")
    var afflictionProgress: Int = 0
    @SerializedName("amountOfPurchases")
    var amountOfPurchases: Int = 0
    @SerializedName("ancientGraveDigging")
    var ancientGraveDigging: AncientGraveDigging? = AncientGraveDigging()
    @SerializedName("barrenWastelands")
    var barrenWastelands: BarrenWastelands? = BarrenWastelands()
    @SerializedName("blackwaterPort")
    var blackwaterPort: BlackwaterPort? = BlackwaterPort()
    @SerializedName("celestialMothership")
    var celestialMothership: CelestialMothership? = CelestialMothership()
    @SerializedName("controlLevel")
    var controlLevel: Int = 0
    @SerializedName("controlProgress")
    var controlProgress: Int = 0
    @SerializedName("divineArcheology")
    var divineArcheology: DivineArcheology? = DivineArcheology()
    @SerializedName("doctrineMaxed")
    var isDoctrineMaxed: Boolean = false
    @SerializedName("enchantedForest")
    var enchantedForest: EnchantedForest? = EnchantedForest()
    @SerializedName("eternalBattlefield")
    var eternalBattlefield: EternalBattlefield? = EternalBattlefield()
    @SerializedName("everAscended")
    var isEverAscended: Boolean = false
    @SerializedName("fortitudeLevel")
    var fortitudeLevel: Int = 0
    @SerializedName("fortitudeProgress")
    var fortitudeProgress: Int = 0
    @SerializedName("frostbitePeaks")
    var frostbitePeaks: FrostbitePeaks? = FrostbitePeaks()
    @SerializedName("gems")
    var gems: Long = 0L
    @SerializedName("graceLevel")
    var graceLevel: Int = 0
    @SerializedName("graceProgress")
    var graceProgress: Int = 0
    @SerializedName("hiddenCityOfLarox")
    var hiddenCityOfLarox: HiddenCityOfLarox? = HiddenCityOfLarox()
    @SerializedName("illusionLevel")
    var illusionLevel: Int = 0
    @SerializedName("illusionProgress")
    var illusionProgress: Int = 0
    @SerializedName("imperialRescue")
    var imperialRescue: ImperialRescue? = ImperialRescue()
    @SerializedName("imperialVanguardPurchased")
    var isImperialVanguardPurchased: Boolean = false
    @SerializedName("itemsCrafted")
    var itemsCrafted: Long = 0L
    @SerializedName("itemsSold")
    var itemsSold: Long = 0L
    @SerializedName("kaunis")
    var kaunis: Kaunis? = Kaunis()
    @SerializedName("knowledgeLevel")
    var knowledgeLevel: Int = 0
    @SerializedName("knowledgeProgress")
    var knowledgeProgress: Int = 0
    @SerializedName("last24Triggered")
    var last24Triggered: Long = 0L
    @SerializedName("lastAccess")
    var lastAccess: Long = 0L
    @SerializedName("lastHourTriggered")
    var lastHourTriggered: Long = 0L
    @SerializedName("lastWeekTriggered")
    var lastWeekTriggered: Long = 0L
    @SerializedName("levelMarketListings")
    var levelMarketListings: Int = 0
    @SerializedName("levelMarketTime")
    var levelMarketTime: Int = 0
    @SerializedName("levelQuarters")
    var levelQuarters: Int = 0
    @SerializedName("levelShelter")
    var levelShelter: Int = 0
    @SerializedName("levelShelterAutofeed")
    var levelShelterAutofeed: Int = 0
    @SerializedName("levelShelterEffectiveness")
    var levelShelterEffectiveness: Int = 0
    @SerializedName("levelStorage")
    var levelStorage: Int = 0
    @SerializedName("levelTavernCapacity")
    var levelTavernCapacity: Int = 0
    @SerializedName("levelTavernTime")
    var levelTavernTime: Int = 0
    @SerializedName("levelWorkshopQueue")
    var levelWorkshopQueue: Int = 0
    @SerializedName("levelWorkshopTime")
    var levelWorkshopTime: Int = 0
    @SerializedName("lostLands")
    var lostLands: LostLands? = LostLands()
    @SerializedName("maxAdventurerTier")
    var maxAdventurerTier: Int = 0
    @SerializedName("maxAdventurersOwned")
    var maxAdventurersOwned: Int = 0
    @SerializedName("maxWealth")
    var maxWealth: Long = 0L
    @SerializedName("merchantPackPurchased")
    var isMerchantPackPurchased: Boolean = false
    @SerializedName("money")
    var money: Long = 0L
    @SerializedName("newMerchantRegularItems")
    var isNewMerchantRegularItems: Boolean = false
    @SerializedName("newMerchantSpecialItems")
    var isNewMerchantSpecialItems: Boolean = false
    @SerializedName("nextTavernVisit")
    var nextTavernVisit: Long = 0L
    @SerializedName("obsidianMines")
    var obsidianMines: ObsidianMines? = ObsidianMines()
    @SerializedName("potsMaxed")
    var isPotsMaxed: Boolean = false
    @SerializedName("questsCompleted")
    var questsCompleted: Int = 0
    @SerializedName("ruinLevel")
    var ruinLevel: Int = 0
    @SerializedName("ruinProgress")
    var ruinProgress: Int = 0
    @SerializedName("settingAutoOpenDungeonDetail")
    var isSettingAutoOpenDungeonDetail: Boolean = false
    @SerializedName("settingColorblindMode")
    var isSettingColorblindMode: Boolean = false
    @SerializedName("settingConfirmRetreat")
    var isSettingConfirmRetreat: Boolean = false
    @SerializedName("settingConfirmSwap")
    var isSettingConfirmSwap: Boolean = false
    @SerializedName("settingConfirmUpgrade")
    var isSettingConfirmUpgrade: Boolean = false
    @SerializedName("settingCraftMaxAmount")
    var isSettingCraftMaxAmount: Boolean = false
    @SerializedName("settingSellMaxAmount")
    var isSettingSellMaxAmount: Boolean = false
    @SerializedName("settingVerboseLogs")
    var isSettingVerboseLogs: Boolean = false
    @SerializedName("settingsLanguage")
    var settingsLanguage: String? = ""
    @SerializedName("shownDialogEpicRaid")
    var isShownDialogEpicRaid: Boolean = false
    @SerializedName("shownDialogRaid")
    var isShownDialogRaid: Boolean = false
    @SerializedName("sleepingPlanet")
    var sleepingPlanet: SleepingPlanet? = SleepingPlanet()
    @SerializedName("primalVanguardPurchased")
    var isPrimalVanguardPurchased: Boolean = false
    @SerializedName("senkoPackPurchased")
    var isSenkoPackPurchased: Boolean = false
    @SerializedName("mythicEggPack10Purchased")
    var isMythicEggPack10Purchased: Boolean = false
    @SerializedName("mythicEggPack25Purchased")
    var isMythicEggPack25Purchased: Boolean = false
    @SerializedName("mythicEggPack50Purchased")
    var isMythicEggPack50Purchased: Boolean = false
    @SerializedName("apprenticeMerchantPurchased")
    var isApprenticeMerchantPurchased: Boolean = false
    @SerializedName("journeymanMerchantPurchased")
    var isJourneymanMerchantPurchased: Boolean = false
    @SerializedName("tradeBaronPurchased")
    var isTradeBaronPurchased: Boolean = false
    @SerializedName("apprenticeWorkshopPurchased")
    var isApprenticeWorkshopPurchased: Boolean = false
    @SerializedName("journeymanWorkshopPurchased")
    var isJourneymanWorkshopPurchased: Boolean = false
    @SerializedName("masterWorkshopPurchased")
    var isMasterWorkshopPurchased: Boolean = false
    @SerializedName("grandmasterWorkshopPurchased")
    var isGrandmasterWorkshopPurchased: Boolean = false
    @SerializedName("storagePack35Purchased")
    var isStoragePack35Purchased: Boolean = false
    @SerializedName("storagePack50Purchased")
    var isStoragePack50Purchased: Boolean = false
    @SerializedName("storagePack70Purchased")
    var isStoragePack70Purchased: Boolean = false
    @SerializedName("maxLootPackPurchased")
    var isMaxLootPackPurchased: Boolean = false
    @SerializedName("idleHoursPackPurchased")
    var isIdleHoursPackPurchased: Boolean = false
    @SerializedName("sacredIntercessionPurchased")
    var isSacredIntercessionPurchased: Boolean = false
    @SerializedName("cakePackPurchased")
    var isCakePackPurchased: Boolean = false
    @SerializedName("divineChampionPackPurchased")
    var isDivineChampionPackPurchased: Boolean = false
    @SerializedName("eternalReliquaryPurchased")
    var isEternalReliquaryPurchased: Boolean = false
    @SerializedName("alchemistBountyPurchased")
    var isAlchemistBountyPurchased: Boolean = false
    @SerializedName("patricianWardrobePurchased")
    var isPatricianWardrobePurchased: Boolean = false
    @SerializedName("royalTreasuryPurchased")
    var isRoyalTreasuryPurchased: Boolean = false
    @SerializedName("scarletShroudPurchased")
    var isScarletShroudPurchased: Boolean = false
    @SerializedName("celestialBowPurchased")
    var isCelestialBowPurchased: Boolean = false
    @SerializedName("barracks1Purchased")
    var isBarracks1Purchased: Boolean = false
    @SerializedName("barracks2Purchased")
    var isBarracks2Purchased: Boolean = false
    @SerializedName("grandTavernPurchased")
    var isGrandTavernPurchased: Boolean = false
    @SerializedName("sanctuary1Purchased")
    var isSanctuary1Purchased: Boolean = false
    @SerializedName("sanctuary2Purchased")
    var isSanctuary2Purchased: Boolean = false
    @SerializedName("idleHoursPack2Purchased")
    var isIdleHoursPack2Purchased: Boolean = false
    @SerializedName("idleHoursPack3Purchased")
    var isIdleHoursPack3Purchased: Boolean = false
    @SerializedName("idleHoursPack4Purchased")
    var isIdleHoursPack4Purchased: Boolean = false
    @SerializedName("eternalVigilPurchased")
    var isEternalVigilPurchased: Boolean = false
    @SerializedName("maxLootPack2Purchased")
    var isMaxLootPack2Purchased: Boolean = false
    @SerializedName("evolutionSynthesisPurchased")
    var isEvolutionSynthesisPurchased: Boolean = false
    @SerializedName("storagePack100Purchased")
    var isStoragePack100Purchased: Boolean = false
    @SerializedName("storagePack150Purchased")
    var isStoragePack150Purchased: Boolean = false
    @SerializedName("starterPackPurchased")
    var isStarterPackPurchased: Boolean = false
    @SerializedName("t4Pet")
    var isT4Pet: Boolean = false
    @SerializedName("tavernLocked")
    var isTavernLocked: Boolean = false
    @SerializedName("theCultistRebels")
    var theCultistRebels: TheCultistRebels? = TheCultistRebels()
    @SerializedName("theDesert")
    var theDesert: TheDesert? = TheDesert()
    @SerializedName("theDireDescent")
    var theDireDescent: TheDireDescent? = TheDireDescent()
    @SerializedName("theDreadfulAscent")
    var theDreadfulAscent: TheDreadfulAscent? = TheDreadfulAscent()
    @SerializedName("theGoldenCity")
    var theGoldenCity: TheGoldenCity? = TheGoldenCity()
    @SerializedName("theLostExpedition")
    var theLostExpedition: TheLostExpedition? = TheLostExpedition()
    @SerializedName("theSlimePond")
    var theSlimePond: TheSlimePond? = TheSlimePond()
    @SerializedName("theSouthernGrove")
    var theSouthernGrove: TheSouthernGrove? = TheSouthernGrove()
    @SerializedName("guildRequest")
    var guildRequest: GuildRequestArea? = GuildRequestArea()

    @SerializedName("guildSiege")
    var guildSiege: GuildSiegeArea? = GuildSiegeArea()

    @SerializedName("guildActivitiesState")
    var guildActivitiesState: GuildActivitiesState = GuildActivitiesState()

    @SerializedName("theTower")
    var theTower: TheTower? = TheTower()
    @SerializedName("totalGemsPurchased")
    var totalGemsPurchased: Long = 0L
    @SerializedName("tutorialStep")
    var tutorialStep: Int = 0
    @SerializedName("unholyCrusadePurchased")
    var isUnholyCrusadePurchased: Boolean = false
    @SerializedName("upgradeMarketQueue")
    var upgradeMarketQueue: Int = 0
    @SerializedName("upgradeMarketTime")
    var upgradeMarketTime: Int = 0
    @SerializedName("upgradeQuarters")
    var upgradeQuarters: Int = 0
    @SerializedName("upgradeShelter")
    var upgradeShelter: Int = 0
    @SerializedName("upgradeShelterEffectiveness")
    var upgradeShelterEffectiveness: Int = 0
    @SerializedName("upgradeStorage")
    var upgradeStorage: Int = 0
    @SerializedName("upgradeTavernCapacity")
    var upgradeTavernCapacity: Int = 0
    @SerializedName("upgradeTavernTime")
    var upgradeTavernTime: Int = 0
    @SerializedName("upgradeWorkshopQueue")
    var upgradeWorkshopQueue: Int = 0
    @SerializedName("upgradeWorkshopTime")
    var upgradeWorkshopTime: Int = 0
    @SerializedName("warLevel")
    var warLevel: Int = 0
    @SerializedName("warProgress")
    var warProgress: Int = 0
    @SerializedName("messagesToShow")
    var messagesToShow: MutableList<KingMessage> = CopyOnWriteArrayList()
    @SerializedName("messagesGotten")
    var messagesGotten: MutableList<KingMessage> = CopyOnWriteArrayList()
    @SerializedName("adventurers")
    var adventurers: MutableList<Adventurer> = CopyOnWriteArrayList()
    @SerializedName("items")
    var items: MutableList<Item> = CopyOnWriteArrayList()
    @SerializedName("seenItems")
    var seenItems: MutableSet<String> = CopyOnWriteArraySet()
    @SerializedName("seenEnemies")
    var seenEnemies: MutableSet<String> = CopyOnWriteArraySet()
    @SerializedName("knownRecipes")
    var knownRecipes: MutableSet<Recipes> = CopyOnWriteArraySet()
    @SerializedName("uniqueItemsLost")
    var uniqueItemsLost: MutableSet<String> = CopyOnWriteArraySet()
    @SerializedName("pets")
    var pets: MutableList<Pet> = CopyOnWriteArrayList()
    @SerializedName("tavernGuests")
    var tavernGuests: MutableList<Adventurer> = CopyOnWriteArrayList()
    @SerializedName("dismissedAdventurers")
    var dismissedAdventurers: MutableList<Adventurer> = CopyOnWriteArrayList()
    @SerializedName("soldMarketItems")
    var soldMarketItems: MutableList<ItemAction> = CopyOnWriteArrayList()
    @SerializedName("marketListings")
    var marketListings: MutableList<ItemAction> = CopyOnWriteArrayList()
    @SerializedName("completedWorkshopItems")
    var completedWorkshopItems: MutableList<ItemAction> = CopyOnWriteArrayList()
    @SerializedName("workshopQueue")
    var workshopQueue: MutableList<ItemAction> = CopyOnWriteArrayList()
    @SerializedName("merchantRegularStockItems")
    var merchantRegularStockItems: MutableList<MerchantOffer> = CopyOnWriteArrayList()
    @SerializedName("merchantSpecialReserve")
    var merchantSpecialReserve: MutableList<MerchantOffer> = CopyOnWriteArrayList()
    @SerializedName("blackMarketStock")
    var blackMarketStock: MutableList<MerchantOffer> = CopyOnWriteArrayList()
    @SerializedName("blackMarketActive")
    var isBlackMarketActive: Boolean = false
    @SerializedName("newBlackMarketItems")
    var isNewBlackMarketItems: Boolean = false
    @SerializedName("blackMarketMissedDays")
    var blackMarketMissedDays: Int = 0
    @SerializedName("questsSeen")
    var isQuestsSeen: Boolean = false
    @SerializedName("questsRefreshed")
    var isQuestsRefreshed: Boolean = false
    @SerializedName("kingsQuests")
    var kingsQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("afflictionQuests")
    var afflictionQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("controlQuests")
    var controlQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("fortitudeQuests")
    var fortitudeQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("graceQuests")
    var graceQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("illusionQuests")
    var illusionQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("knowledgeQuests")
    var knowledgeQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("ruinQuests")
    var ruinQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("warQuests")
    var warQuests: MutableList<Quest> = CopyOnWriteArrayList()
    @SerializedName("reviewTrigger")
    var isReviewTrigger: Boolean = false
    @SerializedName("reviewShown")
    var isReviewShown: Boolean = false
    @SerializedName("redeemed_f8hf3045")
    var isRedeemed_f8hf3045: Boolean = false
    @SerializedName("redeemed_g294ps91")
    var isRedeemed_g294ps91: Boolean = false
    @SerializedName("redeemed_vre8983y")
    var isRedeemed_vre8983y: Boolean = false
    @SerializedName("redeemed_vrw74ync")
    var isRedeemed_vrw74ync: Boolean = false
    @SerializedName("redeemed_e44opo7z")
    var isRedeemed_e44opo7z: Boolean = false
    @SerializedName("redeem_potionsRefund1")
    var isRedeem_potionsRefund1: Boolean = false
    @SerializedName("redeem_f1r39h15")
    var isRedeem_f1r39h15: Boolean = false
    @SerializedName("redeem_m975nfu5")
    var redeem_m975nfu5: Int = 0
    @SerializedName("imperialKills")
    var imperialKills: Int = 0
    @SerializedName("idleTimeCapHours")
    var idleTimeCapHours: Int = 0
    @SerializedName("lootCap")
    var lootCap: Int = 0
    @SerializedName("redeem_g73mfkf4")
    var isRedeem_g73mfkf4: Boolean = false
    @SerializedName("redeemed_fj9rf8hh")
    var isRedeemed_fj9rf8hh: Boolean = false
    @SerializedName("intercessionsRetroactivelyGranted")
    var isIntercessionsRetroactivelyGranted: Boolean = false
    @SerializedName("vial2RetGrant")
    var isVial2RetGrant: Boolean = false
    @SerializedName("redeemed_z3gaazrt")
    var isRedeemed_z3gaazrt: Boolean = false

    init {
        messagesToShow.add(KingMessage.MESSAGE_1)
        messagesGotten.add(KingMessage.MESSAGE_1)
        tutorialStep = 1
        settingsLanguage = ""
        isSettingSellMaxAmount = false
        isSettingConfirmUpgrade = false
        isSettingConfirmRetreat = true
        isSettingConfirmSwap = true
        isSettingAutoOpenDungeonDetail = true
        isSettingVerboseLogs = true
        enchantedForest = EnchantedForest()
        theDesert = TheDesert()
        eternalBattlefield = EternalBattlefield()
        theGoldenCity = TheGoldenCity()
        blackwaterPort = BlackwaterPort()
        frostbitePeaks = FrostbitePeaks()
        obsidianMines = ObsidianMines()
        theSouthernGrove = TheSouthernGrove()
        barrenWastelands = BarrenWastelands()
        hiddenCityOfLarox = HiddenCityOfLarox()
        lostLands = LostLands()
        theSlimePond = TheSlimePond()
        divineArcheology = DivineArcheology()
        ancientGraveDigging = AncientGraveDigging()
        imperialRescue = ImperialRescue()
        theCultistRebels = TheCultistRebels()
        theLostExpedition = TheLostExpedition()
        theDreadfulAscent = TheDreadfulAscent()
        celestialMothership = CelestialMothership()
        theDireDescent = TheDireDescent()
        sleepingPlanet = SleepingPlanet()
        kaunis = Kaunis()
        theTower = TheTower()
        guildRequest = GuildRequestArea()
        guildSiege = GuildSiegeArea()
        guildActivitiesState = GuildActivitiesState()
        guildRequest?.isUnlocked = true
        guildSiege?.isUnlocked = true

        enchantedForest?.isUnlocked = true
        seenItems.add("ScarletStrand")
        seenItems.add("Intercession")
        seenItems.add("Dreamcatcher")
        seenItems.add("UpgradeMarketQueue")
        seenItems.add("UpgradeMarketTime")
        seenItems.add("UpgradeQuarters")
        seenItems.add("UpgradeShelter")
        seenItems.add("UpgradeShelterEffectiveness")
        seenItems.add("UpgradeStorage")
        seenItems.add("UpgradeTavernCapacity")
        seenItems.add("UpgradeTavernTime")
        seenItems.add("UpgradeWorkshopQueue")
        seenItems.add("UpgradeWorkshopTime")
        seenItems.add("Evo23Vial2")
    }
}
