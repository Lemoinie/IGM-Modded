package it.paranoidsquirrels.idleguildmaster.storage.data

import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesState

import androidx.core.app.NotificationCompat
import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import it.paranoidsquirrels.idleguildmaster.KingMessage
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Action
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.*
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.*
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import java.lang.reflect.Type
import java.util.concurrent.CopyOnWriteArrayList

class DataDeserializer : JsonDeserializer<Data> {
    private var data: Data = Data()

    override fun deserialize(
        jsonElement: JsonElement,
        type: Type,
        jsonDeserializationContext: JsonDeserializationContext
    ): Data {
        val asJsonObject = jsonElement.asJsonObject
        val data = Data()
        this.data = data

        this.data.lastAccess = asJsonObject.get("lastAccess").asLong
        this.data.tutorialStep = asJsonObject.get("tutorialStep").asInt
        this.data.nextTavernVisit = asJsonObject.get("nextTavernVisit").asLong
        this.data.isTavernLocked = asJsonObject.get("tavernLocked").asBoolean
        this.data.messagesToShow.clear()
        val it2 = asJsonObject.get("messagesToShow").asJsonArray.iterator()
        while (it2.hasNext()) {
        this.data.messagesToShow.add(KingMessage.valueOf(it2.next().asString))
        }
        this.data.messagesGotten.clear()
        val it3 = asJsonObject.get("messagesGotten").asJsonArray.iterator()
        while (it3.hasNext()) {
        this.data.messagesGotten.add(KingMessage.valueOf(it3.next().asString))
        }
        this.data.money = asJsonObject.get("money").asLong
        this.data.gems = asJsonObject.get("gems").asLong
        this.data.levelQuarters = asJsonObject.get("levelQuarters").asInt
        this.data.levelTavernCapacity = asJsonObject.get("levelTavernCapacity").asInt
        this.data.levelTavernTime = asJsonObject.get("levelTavernTime").asInt
        this.data.levelStorage = asJsonObject.get("levelStorage").asInt
        this.data.levelMarketListings = asJsonObject.get("levelMarketListings").asInt
        this.data.levelMarketTime = asJsonObject.get("levelMarketTime").asInt
        this.data.levelWorkshopQueue = asJsonObject.get("levelWorkshopQueue").asInt
        this.data.levelWorkshopTime = asJsonObject.get("levelWorkshopTime").asInt
        var z = false
        this.data.levelShelter = if (asJsonObject.has("levelShelter")) asJsonObject.get("levelShelter").asInt  else 0
        this.data.levelShelterAutofeed = if (asJsonObject.has("levelShelterAutofeed")) asJsonObject.get("levelShelterAutofeed").asInt  else 0
        this.data.levelShelterEffectiveness = if (asJsonObject.has("levelShelterEffectiveness")) asJsonObject.get("levelShelterEffectiveness").asInt  else 0
        this.data.upgradeMarketQueue = if (asJsonObject.has("upgradeMarketQueue")) asJsonObject.get("upgradeMarketQueue").asInt  else 0
        this.data.upgradeMarketTime = if (asJsonObject.has("upgradeMarketTime")) asJsonObject.get("upgradeMarketTime").asInt  else 0
        this.data.upgradeQuarters = if (asJsonObject.has("upgradeQuarters")) asJsonObject.get("upgradeQuarters").asInt  else 0
        this.data.upgradeShelter = if (asJsonObject.has("upgradeShelter")) asJsonObject.get("upgradeShelter").asInt  else 0
        this.data.upgradeShelterEffectiveness = if (asJsonObject.has("upgradeShelterEffectiveness")) asJsonObject.get("upgradeShelterEffectiveness").asInt  else 0
        this.data.upgradeStorage = if (asJsonObject.has("upgradeStorage")) asJsonObject.get("upgradeStorage").asInt  else 0
        this.data.upgradeTavernCapacity = if (asJsonObject.has("upgradeTavernCapacity")) asJsonObject.get("upgradeTavernCapacity").asInt  else 0
        this.data.upgradeTavernTime = if (asJsonObject.has("upgradeTavernTime")) asJsonObject.get("upgradeTavernTime").asInt  else 0
        this.data.upgradeWorkshopQueue = if (asJsonObject.has("upgradeWorkshopQueue")) asJsonObject.get("upgradeWorkshopQueue").asInt  else 0
        this.data.upgradeWorkshopTime = if (asJsonObject.has("upgradeWorkshopTime")) asJsonObject.get("upgradeWorkshopTime").asInt  else 0
        val it4 = asJsonObject.get("adventurers").asJsonArray.iterator()
        while (it4.hasNext()) {
        getAdventurer(it4.next().asJsonObject)?.let { this.data.adventurers.add(it) }
        }
        val it5 = asJsonObject.get("items").asJsonArray.iterator()
        while (it5.hasNext()) {
        getItem(it5.next().asJsonObject)?.let { this.data.items.add(it) }
        }
        val it6 = asJsonObject.get("seenItems").asJsonArray.iterator()
        while (it6.hasNext()) {
        this.data.seenItems.add(it6.next().asString)
        }
        if (asJsonObject.has("seenEnemies")) {
        val it7 = asJsonObject.get("seenEnemies").asJsonArray.iterator()
        while (it7.hasNext()) {
        this.data.seenEnemies.add(it7.next().asString)
        }
        }
        val it8 = asJsonObject.get("knownRecipes").asJsonArray.iterator()
        while (it8.hasNext()) {
        try {
        this.data.knownRecipes.add(Recipes.valueOf(it8.next().asString))
        } catch (unused: Exception) {
        }
        }
        val it9 = asJsonObject.get("uniqueItemsLost").asJsonArray.iterator()
        while (it9.hasNext()) {
        this.data.uniqueItemsLost.add(it9.next().asString)
        }
        if (asJsonObject.has("pets")) {
        val it10 = asJsonObject.get("pets").asJsonArray.iterator()
        while (it10.hasNext()) {
        getPet(it10.next().asJsonObject)?.let { this.data.pets.add(it) }
        }
        }
        val it11 = asJsonObject.get("tavernGuests").asJsonArray.iterator()
        while (it11.hasNext()) {
        getAdventurer(it11.next().asJsonObject)?.let { this.data.tavernGuests.add(it) }
        }
        val it12 = asJsonObject.get("dismissedAdventurers").asJsonArray.iterator()
        while (it12.hasNext()) {
        getAdventurer(it12.next().asJsonObject)?.let { this.data.dismissedAdventurers.add(it) }
        }
        val it13 = asJsonObject.get("soldMarketItems").asJsonArray.iterator()
        while (it13.hasNext()) {
        this.data.soldMarketItems.add(getItemAction(it13.next().asJsonObject))
        }
        val it14 = asJsonObject.get("marketListings").asJsonArray.iterator()
        while (it14.hasNext()) {
        this.data.marketListings.add(getItemAction(it14.next().asJsonObject))
        }
        val it15 = asJsonObject.get("completedWorkshopItems").asJsonArray.iterator()
        while (it15.hasNext()) {
        this.data.completedWorkshopItems.add(getItemAction(it15.next().asJsonObject))
        }
        val it16 = asJsonObject.get("workshopQueue").asJsonArray.iterator()
        while (it16.hasNext()) {
        this.data.workshopQueue.add(getItemAction(it16.next().asJsonObject))
        }
        val it17 = asJsonObject.get("merchantRegularStockItems").asJsonArray.iterator()
        while (it17.hasNext()) {
        this.data.merchantRegularStockItems.add(getMerchantOffer(it17.next().asJsonObject))
        }
        val it18 = asJsonObject.get("merchantSpecialReserve").asJsonArray.iterator()
        while (it18.hasNext()) {
        this.data.merchantSpecialReserve.add(getMerchantOffer(it18.next().asJsonObject))
        }
        this.data.isRedeemed_fj9rf8hh = asJsonObject.has("redeemed_fj9rf8hh") && asJsonObject.get("redeemed_fj9rf8hh").asBoolean
        this.data.isRedeemed_f8hf3045 = asJsonObject.has("redeemed_f8hf3045") && asJsonObject.get("redeemed_f8hf3045").asBoolean
        this.data.isRedeemed_g294ps91 = asJsonObject.has("redeemed_g294ps91") && asJsonObject.get("redeemed_g294ps91").asBoolean
        this.data.isRedeemed_vre8983y = asJsonObject.has("redeemed_vre8983y") && asJsonObject.get("redeemed_vre8983y").asBoolean
        this.data.isRedeemed_vrw74ync = asJsonObject.has("redeemed_vrw74ync") && asJsonObject.get("redeemed_vrw74ync").asBoolean
        this.data.isRedeemed_e44opo7z = asJsonObject.has("redeemed_e44opo7z") && asJsonObject.get("redeemed_e44opo7z").asBoolean
        this.data.isRedeemed_z3gaazrt = asJsonObject.has("redeemed_z3gaazrt") && asJsonObject.get("redeemed_z3gaazrt").asBoolean
        if (asJsonObject.has("blackMarketStock")) {
        val itBlackMarket = asJsonObject.get("blackMarketStock").asJsonArray.iterator()
        while (itBlackMarket.hasNext()) {
        this.data.blackMarketStock.add(getMerchantOffer(itBlackMarket.next().asJsonObject))
        }
        }
        this.data.isBlackMarketActive = asJsonObject.has("blackMarketActive") && asJsonObject.get("blackMarketActive").asBoolean
        this.data.isNewBlackMarketItems = asJsonObject.has("newBlackMarketItems") && asJsonObject.get("newBlackMarketItems").asBoolean
        this.data.blackMarketMissedDays = if (asJsonObject.has("blackMarketMissedDays")) asJsonObject.get("blackMarketMissedDays").asInt else 0
        this.data.isRedeem_potionsRefund1 = asJsonObject.has("redeem_potionsRefund1") && asJsonObject.get("redeem_potionsRefund1").asBoolean
        this.data.isRedeem_f1r39h15 = asJsonObject.has("redeem_f1r39h15") && asJsonObject.get("redeem_f1r39h15").asBoolean
        this.data.redeem_m975nfu5 = if (asJsonObject.has("redeem_m975nfu5")) asJsonObject.get("redeem_m975nfu5").asInt  else 0

        // Mod progression fields (formerly packed into redeem_m975nfu5 by the old
        // ModManager). New keys take precedence; legacy saves fall back to unpacking
        // the packed int: bits 0-9 kills, bits 10-17 idle cap hours, bits 18-31 loot cap.
        val packedLegacy = this.data.redeem_m975nfu5
        this.data.imperialKills = if (asJsonObject.has("imperialKills")) asJsonObject.get("imperialKills").asInt else packedLegacy and 0x3FF
        this.data.idleTimeCapHours = if (asJsonObject.has("idleTimeCapHours")) asJsonObject.get("idleTimeCapHours").asInt else (packedLegacy shr 10) and 0xFF
        this.data.lootCap = if (asJsonObject.has("lootCap")) asJsonObject.get("lootCap").asInt else (packedLegacy shr 18) and 0x3FFF
        this.data.isRedeem_g73mfkf4 = asJsonObject.has("redeem_g73mfkf4") && asJsonObject.get("redeem_g73mfkf4").asBoolean
        this.data.isNewMerchantRegularItems = asJsonObject.get("newMerchantRegularItems").asBoolean
        this.data.isNewMerchantSpecialItems = asJsonObject.get("newMerchantSpecialItems").asBoolean
        this.data.settingsLanguage = asJsonObject.get("settingsLanguage").asString
        this.data.isSettingSellMaxAmount = asJsonObject.get("settingSellMaxAmount").asBoolean
        this.data.isSettingCraftMaxAmount = asJsonObject.has("settingCraftMaxAmount") && asJsonObject.get("settingCraftMaxAmount").asBoolean
        this.data.isSettingConfirmUpgrade = asJsonObject.has("settingConfirmUpgrade") && asJsonObject.get("settingConfirmUpgrade").asBoolean
        this.data.isSettingConfirmRetreat = asJsonObject.get("settingConfirmRetreat").asBoolean
        this.data.isSettingConfirmSwap = asJsonObject.get("settingConfirmSwap").asBoolean
        this.data.isSettingAutoOpenDungeonDetail = asJsonObject.get("settingAutoOpenDungeonDetail").asBoolean
        this.data.isSettingVerboseLogs = !asJsonObject.has("settingVerboseLogs") || asJsonObject.get("settingVerboseLogs").asBoolean
        this.data.isSettingColorblindMode = asJsonObject.has("settingColorblindMode") && asJsonObject.get("settingColorblindMode").asBoolean
        this.data.isSettingClaimAllChests = asJsonObject.has("settingClaimAllChests") && asJsonObject.get("settingClaimAllChests").asBoolean
        this.data.isStarterPackPurchased = asJsonObject.has("starterPackPurchased") && asJsonObject.get("starterPackPurchased").asBoolean
        this.data.isAdventurerPackPurchased = asJsonObject.has("adventurerPackPurchased") && asJsonObject.get("adventurerPackPurchased").asBoolean
        this.data.isMerchantPackPurchased = asJsonObject.has("merchantPackPurchased") && asJsonObject.get("merchantPackPurchased").asBoolean
        this.data.isImperialVanguardPurchased = asJsonObject.has("imperialVanguardPurchased") && asJsonObject.get("imperialVanguardPurchased").asBoolean
        this.data.isUnholyCrusadePurchased = asJsonObject.has("unholyCrusadePurchased") && asJsonObject.get("unholyCrusadePurchased").asBoolean
        this.data.isPrimalVanguardPurchased = asJsonObject.has("primalVanguardPurchased") && asJsonObject.get("primalVanguardPurchased").asBoolean
        this.data.isSenkoPackPurchased = asJsonObject.has("senkoPackPurchased") && asJsonObject.get("senkoPackPurchased").asBoolean
        this.data.isMythicEggPack10Purchased = asJsonObject.has("mythicEggPack10Purchased") && asJsonObject.get("mythicEggPack10Purchased").asBoolean
        this.data.isMythicEggPack25Purchased = asJsonObject.has("mythicEggPack25Purchased") && asJsonObject.get("mythicEggPack25Purchased").asBoolean
        this.data.isMythicEggPack50Purchased = asJsonObject.has("mythicEggPack50Purchased") && asJsonObject.get("mythicEggPack50Purchased").asBoolean
        this.data.isApprenticeMerchantPurchased = asJsonObject.has("apprenticeMerchantPurchased") && asJsonObject.get("apprenticeMerchantPurchased").asBoolean
        this.data.isJourneymanMerchantPurchased = asJsonObject.has("journeymanMerchantPurchased") && asJsonObject.get("journeymanMerchantPurchased").asBoolean
        this.data.isTradeBaronPurchased = asJsonObject.has("tradeBaronPurchased") && asJsonObject.get("tradeBaronPurchased").asBoolean
        this.data.isApprenticeWorkshopPurchased = asJsonObject.has("apprenticeWorkshopPurchased") && asJsonObject.get("apprenticeWorkshopPurchased").asBoolean
        this.data.isJourneymanWorkshopPurchased = asJsonObject.has("journeymanWorkshopPurchased") && asJsonObject.get("journeymanWorkshopPurchased").asBoolean
        this.data.isMasterWorkshopPurchased = asJsonObject.has("masterWorkshopPurchased") && asJsonObject.get("masterWorkshopPurchased").asBoolean
        this.data.isGrandmasterWorkshopPurchased = asJsonObject.has("grandmasterWorkshopPurchased") && asJsonObject.get("grandmasterWorkshopPurchased").asBoolean
        this.data.isStoragePack35Purchased = asJsonObject.has("storagePack35Purchased") && asJsonObject.get("storagePack35Purchased").asBoolean
        this.data.isStoragePack50Purchased = asJsonObject.has("storagePack50Purchased") && asJsonObject.get("storagePack50Purchased").asBoolean
        this.data.isStoragePack70Purchased = asJsonObject.has("storagePack70Purchased") && asJsonObject.get("storagePack70Purchased").asBoolean
        this.data.isMaxLootPackPurchased = asJsonObject.has("maxLootPackPurchased") && asJsonObject.get("maxLootPackPurchased").asBoolean
        this.data.isIdleHoursPackPurchased = asJsonObject.has("idleHoursPackPurchased") && asJsonObject.get("idleHoursPackPurchased").asBoolean
        this.data.isSacredIntercessionPurchased = asJsonObject.has("sacredIntercessionPurchased") && asJsonObject.get("sacredIntercessionPurchased").asBoolean
        this.data.isCakePackPurchased = asJsonObject.has("cakePackPurchased") && asJsonObject.get("cakePackPurchased").asBoolean
        this.data.isDivineChampionPackPurchased = asJsonObject.has("divineChampionPackPurchased") && asJsonObject.get("divineChampionPackPurchased").asBoolean
        this.data.isEternalReliquaryPurchased = asJsonObject.has("eternalReliquaryPurchased") && asJsonObject.get("eternalReliquaryPurchased").asBoolean
        this.data.isAlchemistBountyPurchased = asJsonObject.has("alchemistBountyPurchased") && asJsonObject.get("alchemistBountyPurchased").asBoolean
        this.data.isPatricianWardrobePurchased = asJsonObject.has("patricianWardrobePurchased") && asJsonObject.get("patricianWardrobePurchased").asBoolean
        this.data.isRoyalTreasuryPurchased = asJsonObject.has("royalTreasuryPurchased") && asJsonObject.get("royalTreasuryPurchased").asBoolean
        this.data.isScarletShroudPurchased = asJsonObject.has("scarletShroudPurchased") && asJsonObject.get("scarletShroudPurchased").asBoolean
        this.data.isCelestialBowPurchased = asJsonObject.has("celestialBowPurchased") && asJsonObject.get("celestialBowPurchased").asBoolean
        this.data.isBarracks1Purchased = asJsonObject.has("barracks1Purchased") && asJsonObject.get("barracks1Purchased").asBoolean
        this.data.isBarracks2Purchased = asJsonObject.has("barracks2Purchased") && asJsonObject.get("barracks2Purchased").asBoolean
        this.data.isGrandTavernPurchased = asJsonObject.has("grandTavernPurchased") && asJsonObject.get("grandTavernPurchased").asBoolean
        this.data.isSanctuary1Purchased = asJsonObject.has("sanctuary1Purchased") && asJsonObject.get("sanctuary1Purchased").asBoolean
        this.data.isSanctuary2Purchased = asJsonObject.has("sanctuary2Purchased") && asJsonObject.get("sanctuary2Purchased").asBoolean
        this.data.isIdleHoursPack2Purchased = asJsonObject.has("idleHoursPack2Purchased") && asJsonObject.get("idleHoursPack2Purchased").asBoolean
        this.data.isIdleHoursPack3Purchased = asJsonObject.has("idleHoursPack3Purchased") && asJsonObject.get("idleHoursPack3Purchased").asBoolean
        this.data.isIdleHoursPack4Purchased = asJsonObject.has("idleHoursPack4Purchased") && asJsonObject.get("idleHoursPack4Purchased").asBoolean
        this.data.isEternalVigilPurchased = asJsonObject.has("eternalVigilPurchased") && asJsonObject.get("eternalVigilPurchased").asBoolean
        this.data.isMaxLootPack2Purchased = asJsonObject.has("maxLootPack2Purchased") && asJsonObject.get("maxLootPack2Purchased").asBoolean
        this.data.isEvolutionSynthesisPurchased = asJsonObject.has("evolutionSynthesisPurchased") && asJsonObject.get("evolutionSynthesisPurchased").asBoolean
        this.data.isStoragePack100Purchased = asJsonObject.has("storagePack100Purchased") && asJsonObject.get("storagePack100Purchased").asBoolean
        this.data.isStoragePack150Purchased = asJsonObject.has("storagePack150Purchased") && asJsonObject.get("storagePack150Purchased").asBoolean

        // Backward Compatibility / Save Migration for Shop Rework (v1.3.8.1)
        // If an imported or older save has the legacy packs, ensure they retain their full storage,
        // workshop queue/speed, and max loot bonuses via the new dedicated modular flags.
        if (this.data.isStarterPackPurchased && !this.data.isStoragePack35Purchased) {
            this.data.isStoragePack35Purchased = true
        }
        if (this.data.isAdventurerPackPurchased && !this.data.isStoragePack50Purchased) {
            this.data.isStoragePack50Purchased = true
        }
        if (this.data.isMerchantPackPurchased) {
            if (!this.data.isStoragePack70Purchased) this.data.isStoragePack70Purchased = true
            if (!this.data.isMasterWorkshopPurchased) this.data.isMasterWorkshopPurchased = true
            if (!this.data.isMaxLootPackPurchased) this.data.isMaxLootPackPurchased = true
        }

        // Backward Compatibility / Save Migration for Shop Expansion (v1.3.8.5)
        // Legacy vanilla redeem codes migrate into the new converted starter packs.
        if (this.data.isRedeem_f1r39h15) {
            if (!this.data.isDivineChampionPackPurchased) this.data.isDivineChampionPackPurchased = true
            if (!this.data.isEternalReliquaryPurchased) this.data.isEternalReliquaryPurchased = true
        }
        if (this.data.isRedeem_potionsRefund1) {
            if (!this.data.isAlchemistBountyPurchased) this.data.isAlchemistBountyPurchased = true
            if (!this.data.isPatricianWardrobePurchased) this.data.isPatricianWardrobePurchased = true
            if (!this.data.isRoyalTreasuryPurchased) this.data.isRoyalTreasuryPurchased = true
        }
        if (this.data.isRedeemed_f8hf3045 || this.data.isRedeemed_g294ps91) {
            if (!this.data.isScarletShroudPurchased) this.data.isScarletShroudPurchased = true
        }

        this.data.amountOfPurchases = if (asJsonObject.has("amountOfPurchases")) asJsonObject.get("amountOfPurchases").asInt  else 0
        this.data.totalGemsPurchased = if (asJsonObject.has("totalGemsPurchased")) asJsonObject.get("totalGemsPurchased").asLong  else 0L
        this.data.isIntercessionsRetroactivelyGranted = asJsonObject.has("intercessionsRetroactivelyGranted") && asJsonObject.get("intercessionsRetroactivelyGranted").asBoolean
        this.data.isVial2RetGrant = asJsonObject.has("vial2RetGrant") && asJsonObject.get("vial2RetGrant").asBoolean
        this.data.lastHourTriggered = if (asJsonObject.has("lastHourTriggered")) asJsonObject.get("lastHourTriggered").asLong  else 0L
        this.data.last24Triggered = asJsonObject.get("last24Triggered").asLong
        this.data.lastWeekTriggered = asJsonObject.get("lastWeekTriggered").asLong
        this.data.isQuestsSeen = asJsonObject.has("questsSeen") && asJsonObject.get("questsSeen").asBoolean
        this.data.isQuestsRefreshed = asJsonObject.has("questsRefreshed") && asJsonObject.get("questsRefreshed").asBoolean
        if (asJsonObject.has("kingsQuests")) {
        val it19 = asJsonObject.get("kingsQuests").asJsonArray.iterator()
        while (it19.hasNext()) {
        val quest = getQuest(it19.next().asJsonObject)
        if (quest != null) {
        this.data.kingsQuests.add(quest)
        }
        }
        }
        if (asJsonObject.has("afflictionQuests")) {
        val it20 = asJsonObject.get("afflictionQuests").asJsonArray.iterator()
        while (it20.hasNext()) {
        val quest2 = getQuest(it20.next().asJsonObject)
        if (quest2 != null) {
        this.data.afflictionQuests.add(quest2)
        }
        }
        }
        if (asJsonObject.has("controlQuests")) {
        val it21 = asJsonObject.get("controlQuests").asJsonArray.iterator()
        while (it21.hasNext()) {
        val quest3 = getQuest(it21.next().asJsonObject)
        if (quest3 != null) {
        this.data.controlQuests.add(quest3)
        }
        }
        }
        if (asJsonObject.has("fortitudeQuests")) {
        val it22 = asJsonObject.get("fortitudeQuests").asJsonArray.iterator()
        while (it22.hasNext()) {
        val quest4 = getQuest(it22.next().asJsonObject)
        if (quest4 != null) {
        this.data.fortitudeQuests.add(quest4)
        }
        }
        }
        if (asJsonObject.has("graceQuests")) {
        val it23 = asJsonObject.get("graceQuests").asJsonArray.iterator()
        while (it23.hasNext()) {
        val quest5 = getQuest(it23.next().asJsonObject)
        if (quest5 != null) {
        this.data.graceQuests.add(quest5)
        }
        }
        }
        if (asJsonObject.has("illusionQuests")) {
        val it24 = asJsonObject.get("illusionQuests").asJsonArray.iterator()
        while (it24.hasNext()) {
        val quest6 = getQuest(it24.next().asJsonObject)
        if (quest6 != null) {
        this.data.illusionQuests.add(quest6)
        }
        }
        }
        if (asJsonObject.has("knowledgeQuests")) {
        val it25 = asJsonObject.get("knowledgeQuests").asJsonArray.iterator()
        while (it25.hasNext()) {
        val quest7 = getQuest(it25.next().asJsonObject)
        if (quest7 != null) {
        this.data.knowledgeQuests.add(quest7)
        }
        }
        }
        if (asJsonObject.has("ruinQuests")) {
        val it26 = asJsonObject.get("ruinQuests").asJsonArray.iterator()
        while (it26.hasNext()) {
        val quest8 = getQuest(it26.next().asJsonObject)
        if (quest8 != null) {
        this.data.ruinQuests.add(quest8)
        }
        }
        }
        if (asJsonObject.has("warQuests")) {
        val it27 = asJsonObject.get("warQuests").asJsonArray.iterator()
        while (it27.hasNext()) {
        val quest9 = getQuest(it27.next().asJsonObject)
        if (quest9 != null) {
        this.data.warQuests.add(quest9)
        }
        }
        }
        this.data.afflictionLevel = if (asJsonObject.has("afflictionLevel")) asJsonObject.get("afflictionLevel").asInt  else 0
        this.data.controlLevel = if (asJsonObject.has("controlLevel")) asJsonObject.get("controlLevel").asInt  else 0
        this.data.fortitudeLevel = if (asJsonObject.has("fortitudeLevel")) asJsonObject.get("fortitudeLevel").asInt  else 0
        this.data.graceLevel = if (asJsonObject.has("graceLevel")) asJsonObject.get("graceLevel").asInt  else 0
        this.data.illusionLevel = if (asJsonObject.has("illusionLevel")) asJsonObject.get("illusionLevel").asInt  else 0
        this.data.knowledgeLevel = if (asJsonObject.has("knowledgeLevel")) asJsonObject.get("knowledgeLevel").asInt  else 0
        this.data.ruinLevel = if (asJsonObject.has("ruinLevel")) asJsonObject.get("ruinLevel").asInt  else 0
        this.data.warLevel = if (asJsonObject.has("warLevel")) asJsonObject.get("warLevel").asInt  else 0
        this.data.afflictionProgress = if (asJsonObject.has("afflictionProgress")) asJsonObject.get("afflictionProgress").asInt  else 0
        this.data.controlProgress = if (asJsonObject.has("controlProgress")) asJsonObject.get("controlProgress").asInt  else 0
        this.data.fortitudeProgress = if (asJsonObject.has("fortitudeProgress")) asJsonObject.get("fortitudeProgress").asInt  else 0
        this.data.graceProgress = if (asJsonObject.has("graceProgress")) asJsonObject.get("graceProgress").asInt  else 0
        this.data.illusionProgress = if (asJsonObject.has("illusionProgress")) asJsonObject.get("illusionProgress").asInt  else 0
        this.data.knowledgeProgress = if (asJsonObject.has("knowledgeProgress")) asJsonObject.get("knowledgeProgress").asInt  else 0
        this.data.ruinProgress = if (asJsonObject.has("ruinProgress")) asJsonObject.get("ruinProgress").asInt  else 0
        this.data.warProgress = if (asJsonObject.has("warProgress")) asJsonObject.get("warProgress").asInt  else 0
        this.data.adsWatched = asJsonObject.get("adsWatched").asInt
        this.data.isShownDialogRaid = asJsonObject.get("shownDialogRaid").asBoolean
        this.data.isShownDialogEpicRaid = asJsonObject.get("shownDialogEpicRaid").asBoolean
        this.data.isReviewTrigger = asJsonObject.has("reviewTrigger") && asJsonObject.get("reviewTrigger").asBoolean
        this.data.isReviewShown = asJsonObject.has("reviewShown") && asJsonObject.get("reviewShown").asBoolean
        this.data.maxAdventurerTier = if (asJsonObject.has("maxAdventurerTier")) asJsonObject.get("maxAdventurerTier").asInt  else 0
        this.data.itemsCrafted = if (asJsonObject.has("itemsCrafted")) asJsonObject.get("itemsCrafted").asLong  else 0L
        this.data.itemsSold = if (asJsonObject.has("itemsSold")) asJsonObject.get("itemsSold").asLong  else 0L
        this.data.maxAdventurersOwned = if (asJsonObject.has("maxAdventurersOwned")) asJsonObject.get("maxAdventurersOwned").asInt  else 0
        this.data.isT4Pet = asJsonObject.has("t4Pet") && asJsonObject.get("t4Pet").asBoolean
        this.data.isEverAscended = asJsonObject.has("everAscended") && asJsonObject.get("everAscended").asBoolean
        this.data.questsCompleted = if (asJsonObject.has("questsCompleted")) asJsonObject.get("questsCompleted").asInt  else 0
        this.data.isDoctrineMaxed = asJsonObject.has("doctrineMaxed") && asJsonObject.get("doctrineMaxed").asBoolean
        val data2 = this.data
        if (asJsonObject.has("potsMaxed") && asJsonObject.get("potsMaxed").asBoolean) {
        z = true
        }
        data2.isPotsMaxed = z
        this.data.maxWealth = if (asJsonObject.has("maxWealth")) asJsonObject.get("maxWealth").asLong  else 0L
        this.data.enchantedForest = getArea(EnchantedForest::class.java, asJsonObject, "enchantedForest")
        this.data.theDesert = getArea(TheDesert::class.java, asJsonObject, "theDesert")
        this.data.eternalBattlefield = getArea(EternalBattlefield::class.java, asJsonObject, "eternalBattlefield")
        this.data.theGoldenCity = getArea(TheGoldenCity::class.java, asJsonObject, "theGoldenCity")
        this.data.blackwaterPort = getArea(BlackwaterPort::class.java, asJsonObject, "blackwaterPort")
        this.data.frostbitePeaks = getArea(FrostbitePeaks::class.java, asJsonObject, "frostbitePeaks")
        this.data.obsidianMines = getArea(ObsidianMines::class.java, asJsonObject, "obsidianMines")
        this.data.theSouthernGrove = getArea(TheSouthernGrove::class.java, asJsonObject, "theSouthernGrove")
        this.data.barrenWastelands = getArea(BarrenWastelands::class.java, asJsonObject, "barrenWastelands")
        this.data.hiddenCityOfLarox = getArea(HiddenCityOfLarox::class.java, asJsonObject, "hiddenCityOfLarox")
        this.data.lostLands = getArea(LostLands::class.java, asJsonObject, "lostLands")
        this.data.theSlimePond = getArea(TheSlimePond::class.java, asJsonObject, "theSlimePond")
        this.data.divineArcheology = getArea(DivineArcheology::class.java, asJsonObject, "divineArcheology")
        this.data.ancientGraveDigging = getArea(AncientGraveDigging::class.java, asJsonObject, "ancientGraveDigging")
        this.data.imperialRescue = getArea(ImperialRescue::class.java, asJsonObject, "imperialRescue")
        this.data.theCultistRebels = getArea(TheCultistRebels::class.java, asJsonObject, "theCultistRebels")
        this.data.theLostExpedition = getArea(TheLostExpedition::class.java, asJsonObject, "theLostExpedition")
        this.data.theDreadfulAscent = getArea(TheDreadfulAscent::class.java, asJsonObject, "theDreadfulAscent")
        this.data.celestialMothership = getArea(CelestialMothership::class.java, asJsonObject, "celestialMothership")
        this.data.theDireDescent = getArea(TheDireDescent::class.java, asJsonObject, "theDireDescent")
        this.data.sleepingPlanet = getArea(SleepingPlanet::class.java, asJsonObject, "sleepingPlanet")
        this.data.kaunis = getArea(Kaunis::class.java, asJsonObject, "kaunis")
this.data.theTower = getArea(TheTower::class.java, asJsonObject, "theTower")
        this.data.sanguineCrucible = getArea(SanguineCrucible::class.java, asJsonObject, "sanguineCrucible")
        this.data.guildRequest = getArea(GuildRequestArea::class.java, asJsonObject, "guildRequest")
        if (this.data.guildRequest == null) {
            this.data.guildRequest = GuildRequestArea()
        }
        this.data.guildRequest?.isUnlocked = true

        this.data.guildSiege = getArea(GuildSiegeArea::class.java, asJsonObject, "guildSiege")
        if (this.data.guildSiege == null) {
            this.data.guildSiege = GuildSiegeArea()
        }
        this.data.guildSiege?.isUnlocked = true

        if (asJsonObject.has("guildActivitiesState") && !asJsonObject.get("guildActivitiesState").isJsonNull) {
            try {
                this.data.guildActivitiesState = jsonDeserializationContext.deserialize<GuildActivitiesState>(
                    asJsonObject.get("guildActivitiesState"),
                    GuildActivitiesState::class.java
                )
            } catch (e: Exception) {
                this.data.guildActivitiesState = GuildActivitiesState()
            }
        } else {
            this.data.guildActivitiesState = GuildActivitiesState()
        }
        // The Sanguine Crucible unlocks for saves that have already acquired a Scarlet Strand.
        // Only the unlock is propagated here. Forcing triesAvailable = true used to re-grant
        // the daily free try on every launch after it had been consumed; the daily reset in
        // Utils.tick24Hours is the only thing that may hand out a new free try.
        if (this.data.seenItems.contains("ScarletStrand")) {
            this.data.sanguineCrucible?.isUnlocked = true
        }
        return this.data
    }


    private fun getAdventurer(jsonObject: JsonObject): Adventurer? {
        val adventurer = Adventurer.getInstance(
            jsonObject.get("trueClass").asString,
            jsonObject.get("id").asInt,
            jsonObject.get("level").asInt,
            jsonObject.get("experience").asInt,
            if (jsonObject.has("weapon")) getItem(jsonObject.get("weapon").asJsonObject) as Weapon? else null,
            if (jsonObject.has("armor")) getItem(jsonObject.get("armor").asJsonObject) as Armor? else null,
            if (jsonObject.has("accessory")) getItem(jsonObject.get("accessory").asJsonObject) as Accessory? else null,
            if (jsonObject.has("traitCommon")) Trait.fromString(jsonObject.get("traitCommon").asString) else null,
            if (jsonObject.has("traitRare")) Trait.fromString(jsonObject.get("traitRare").asString) else null,
            if (jsonObject.has("potionsDrank")) getPotionsDrank(jsonObject.get("potionsDrank").asJsonObject) else PotionsDrank(),
            if (jsonObject.has("doctrine")) getDoctrine(jsonObject.get("doctrine").asJsonObject) else null,
            if (jsonObject.has("ascended")) jsonObject.get("ascended").asBoolean else false
        ) ?: return null
        adventurer.currentHp = jsonObject.get("currentHp").asInt
        adventurer.currentMana = jsonObject.get("currentMana").asInt
        adventurer.currentShield = if (jsonObject.has("currentShield")) jsonObject.get("currentShield").asInt else 0
        adventurer.positiveStatusEffects = getEffects(jsonObject.get("positiveStatusEffects").asJsonArray)
        adventurer.negativeStatusEffects = getEffects(jsonObject.get("negativeStatusEffects").asJsonArray)
        adventurer.seen = jsonObject.get("seen").asBoolean
        adventurer.timeWhenDismissed = jsonObject.get("timeWhenDismissed").asLong
        return adventurer
    }

    private fun getPet(jsonObject: JsonObject): Pet? {
        val pet = Pet.getInstance(
            jsonObject.get("trueClass").asString,
            jsonObject.get("id").asInt,
            jsonObject.get("level").asInt,
            jsonObject.get("food").asInt,
            PetAbility.fromString(jsonObject.get("petAbility1").asString) ?: PetAbility.EMPTY,
            PetAbility.fromString(jsonObject.get("petAbility2").asString) ?: PetAbility.EMPTY,
            PetAbility.fromString(jsonObject.get("petAbility3").asString) ?: PetAbility.EMPTY,
            PetAbility.fromString(jsonObject.get("petAbility4").asString) ?: PetAbility.EMPTY
        ) ?: return null
        pet.favourite = jsonObject.get("favourite").asBoolean
        return pet
    }

    private fun getEnemy(jsonObject: JsonObject): Enemy? {
        val enemy = Enemy.getInstance(jsonObject.get("trueClass").asString) ?: return null
        enemy.currentHp = jsonObject.get("currentHp").asInt
        enemy.currentMana = jsonObject.get("currentMana").asInt
        enemy.currentShield = if (jsonObject.has("currentShield")) jsonObject.get("currentShield").asInt else 0
        enemy.positiveStatusEffects = getEffects(jsonObject.get("positiveStatusEffects").asJsonArray)
        enemy.negativeStatusEffects = getEffects(jsonObject.get("negativeStatusEffects").asJsonArray)
        return enemy
    }

    private fun getEffects(jsonArray: JsonArray): MutableList<StatusEffect> {
        val copyOnWriteArrayList = CopyOnWriteArrayList<StatusEffect>()
        for (elem in jsonArray) {
            val asJsonObject = elem.asJsonObject
            val statusEffectTypeValueOf = StatusEffectType.valueOf(asJsonObject.get("type").asString)
            if (statusEffectTypeValueOf.serialized) {
                copyOnWriteArrayList.add(StatusEffect(statusEffectTypeValueOf, null, asJsonObject.get("turnsLeft").asInt, 0.0))
            }
        }
        return copyOnWriteArrayList
    }

    private fun getItem(jsonObject: JsonObject): Item? {
        val item = Item.getInstance(jsonObject.get("trueClass").asString, Math.max(jsonObject.get("stack").asInt, 1)) ?: return null
        if (jsonObject.has("gemValue") && !jsonObject.get("gemValue").isJsonNull) {
            item.setGemValue(jsonObject.get("gemValue").asInt)
        }
        return item
    }

    private fun getPotionsDrank(jsonObject: JsonObject): PotionsDrank {
        return try {
            PotionsDrank(
                jsonObject.get("potionOfConstitutionDrank").asInt,
                jsonObject.get("potionOfDexterityDrank").asInt,
                jsonObject.get("potionOfIntelligenceDrank").asInt,
                jsonObject.get("potionOfHealthDrank").asInt,
                jsonObject.get("potionOfDefenseDrank").asInt,
                jsonObject.get("potionOfMagicDefenseDrank").asInt,
                jsonObject.get("potionOfPrecisionDrank").asInt,
                jsonObject.get("potionOfViciousnessDrank").asInt,
                jsonObject.get("potionOfDarknessDrank").asInt,
                jsonObject.get("potionOfImmunityDrank").asInt,
                jsonObject.get("potionOfAgilityDrank").asInt
            )
        } catch (e: Exception) {
            e.printStackTrace()
            PotionsDrank()
        }
    }

    private fun getDoctrine(jsonObject: JsonObject): Doctrine? {
        return try {
            Doctrine.getInstance(
                jsonObject.get("trueClass").asString,
                jsonObject.get("l1").asInt,
                jsonObject.get("l2").asInt,
                jsonObject.get("l3").asInt,
                jsonObject.get("l4").asInt,
                jsonObject.get("l5").asInt,
                jsonObject.get("l6").asInt
            )
        } catch (unused: Exception) {
            null
        }
    }

    private fun getItemAction(jsonObject: JsonObject): ItemAction {
        val itemAction = ItemAction(getItem(jsonObject.get("item").asJsonObject))
        itemAction.secondsPassed = jsonObject.get("secondsPassed").asLong
        return itemAction
    }

    private fun getMerchantOffer(jsonObject: JsonObject): MerchantOffer {
        val merchantOffer = MerchantOffer(getItem(jsonObject.get("item").asJsonObject))
        merchantOffer.price = jsonObject.get("price").asLong
        merchantOffer.isGems = jsonObject.get("gems").asBoolean
        return merchantOffer
    }

    private fun getQuest(jsonObject: JsonObject): Quest? {
        return try {
            Quest.loadInstance(
                jsonObject.get("trueClass").asString,
                jsonObject.get("rarity").asInt,
                jsonObject.get("targetProgress").asInt,
                jsonObject.get("progress").asInt
            )
        } catch (unused: Exception) {
            null
        }
    }

    private fun getEnemyCounter(jsonObject: JsonObject): EnemyCounter {
        return EnemyCounter(jsonObject.get("enemy").asString, jsonObject.get("timesSlain").asInt)
    }

    private fun <T : Area> getArea(cls: Class<T>, jsonObject: JsonObject, str: String): T? {
        var numValueOf: Int? = null
        try {
            val tNewInstance = cls.getDeclaredConstructor().newInstance()
            if (!jsonObject.has(str)) {
                return tNewInstance
            }
            val asJsonObject = jsonObject.get(str).asJsonObject
            try {
                val asJsonArray = asJsonObject.get("adventurersExploringIds").asJsonArray
                for (elem in asJsonArray) {
                    tNewInstance.adventurersExploringIds.add(elem.asInt)
                }
                for (elem in asJsonObject.get("savedAdventurersIds").asJsonArray) {
                    tNewInstance.savedAdventurersIds.add(elem.asInt)
                }
                tNewInstance.petExploringId = if (asJsonObject.has("petExploringId")) asJsonObject.get("petExploringId").asInt else null
                tNewInstance.savedPetId = if (asJsonObject.has("savedPetId")) asJsonObject.get("savedPetId").asInt else null
                for (elem in asJsonObject.get("drops").asJsonArray) {
                    getItem(elem.asJsonObject)?.let { tNewInstance.drops.add(it) }
                }
                tNewInstance.progress = asJsonObject.get("progress").asInt
                tNewInstance.maxProgress = asJsonObject.get("maxProgress").asInt
                tNewInstance.isUnlocked = if (asJsonObject.has("unlocked")) asJsonObject.get("unlocked").asBoolean else if (asJsonObject.has("isUnlocked")) asJsonObject.get("isUnlocked").asBoolean else false
                tNewInstance.triesAvailable = asJsonObject.get("triesAvailable").asBoolean
                tNewInstance.isAutoRaidActive = if (asJsonObject.has("isAutoRaidActive")) asJsonObject.get("isAutoRaidActive").asBoolean else false
                tNewInstance.autoRaidRunsRemaining = if (asJsonObject.has("autoRaidRunsRemaining")) asJsonObject.get("autoRaidRunsRemaining").asInt else -1
                tNewInstance.autoRaidRunsCompleted = if (asJsonObject.has("autoRaidRunsCompleted")) asJsonObject.get("autoRaidRunsCompleted").asInt else 0
                tNewInstance.autoRaidStopOnWipe = if (asJsonObject.has("autoRaidStopOnWipe")) asJsonObject.get("autoRaidStopOnWipe").asBoolean else true
                tNewInstance.autoRaidStopReasonRes = if (asJsonObject.has("autoRaidStopReasonRes")) asJsonObject.get("autoRaidStopReasonRes").asInt else 0
                val adventureRecap = AdventureRecap()
                if (asJsonObject.has("adventureRecap")) {
                    val asJsonObject2 = asJsonObject.get("adventureRecap").asJsonObject
                    adventureRecap.secondsPassed = asJsonObject2.get("secondsPassed").asInt
                    adventureRecap.areasCleared = asJsonObject2.get("areasCleared").asInt
                    adventureRecap.wiped = asJsonObject2.get("wiped").asInt
                    adventureRecap.expEarned = asJsonObject2.get("expEarned").asInt
                    adventureRecap.expLost = asJsonObject2.get("expLost").asInt
                    if (asJsonObject2.has("enemiesKilled")) {
                        for (elem in asJsonObject2.get("enemiesKilled").asJsonArray) {
                            adventureRecap.enemiesKilled.add(getEnemyCounter(elem.asJsonObject))
                        }
                    }
                }
                tNewInstance.adventureRecap = adventureRecap
                if (asJsonArray.size() > 0) {
                    for (elem in asJsonObject.get("enemies").asJsonArray) {
                        getEnemy(elem.asJsonObject)?.let { tNewInstance.enemies.add(it) }
                    }
                    for (elem in asJsonObject.get("corpses").asJsonArray) {
                        getEnemy(elem.asJsonObject)?.let { tNewInstance.corpses.add(it) }
                    }
                    val asJsonObject3 = asJsonObject.get("action").asJsonObject
                    val action = Action(asJsonObject3.get("type").asInt)
                    action.turnsPassed = asJsonObject3.get("turnsPassed").asInt
                    tNewInstance.action = action
                    tNewInstance.setupAdventurers(this.data.adventurers, this.data.pets)
                    if (asJsonObject.has("savedActingEntity")) {
                        numValueOf = asJsonObject.get("savedActingEntity").asInt
                    }
                    tNewInstance.savedActingEntity = numValueOf
                    tNewInstance.turnsFighting = asJsonObject.get("turnsFighting").asInt
                    if (asJsonObject.has(NotificationCompat.CATEGORY_EVENT)) {
                        val asJsonObject4 = asJsonObject.get(NotificationCompat.CATEGORY_EVENT).asJsonObject
                        val event = Event()
                        event.key = asJsonObject4.get("key").asInt
                        event.progress = asJsonObject4.get("progress").asInt
                        tNewInstance.event = event
                    }
                }
                tNewInstance.setupInitialDarkness()
                return tNewInstance
            } catch (e: Exception) {
                e.printStackTrace()
                return tNewInstance
            }
        } catch (e2: Exception) {
            e2.printStackTrace()
            return null
        }
    }
}
