package it.paranoidsquirrels.idleguildmaster.storage.data;

import androidx.core.app.NotificationCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import it.paranoidsquirrels.idleguildmaster.KingMessage;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Action;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.AncientGraveDigging;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.CelestialMothership;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.DivineArcheology;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.ImperialRescue;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.Kaunis;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheCultistRebels;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDireDescent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheLostExpedition;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheSlimePond;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheTower;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DataDeserializer implements JsonDeserializer<Data> {
    private Data data;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Data deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Data data = new Data();
        this.data = data;
        data.setLastAccess(asJsonObject.get("lastAccess").getAsLong());
        this.data.setTutorialStep(asJsonObject.get("tutorialStep").getAsInt());
        this.data.setNextTavernVisit(asJsonObject.get("nextTavernVisit").getAsLong());
        this.data.setTavernLocked(asJsonObject.get("tavernLocked").getAsBoolean());
        this.data.getMessagesToShow().clear();
        Iterator<JsonElement> it2 = asJsonObject.get("messagesToShow").getAsJsonArray().iterator();
        while (it2.hasNext()) {
            this.data.getMessagesToShow().add(KingMessage.valueOf(it2.next().getAsString()));
        }
        this.data.getMessagesGotten().clear();
        Iterator<JsonElement> it3 = asJsonObject.get("messagesGotten").getAsJsonArray().iterator();
        while (it3.hasNext()) {
            this.data.getMessagesGotten().add(KingMessage.valueOf(it3.next().getAsString()));
        }
        this.data.setMoney(asJsonObject.get("money").getAsLong());
        this.data.setGems(asJsonObject.get("gems").getAsLong());
        this.data.setLevelQuarters(asJsonObject.get("levelQuarters").getAsInt());
        this.data.setLevelTavernCapacity(asJsonObject.get("levelTavernCapacity").getAsInt());
        this.data.setLevelTavernTime(asJsonObject.get("levelTavernTime").getAsInt());
        this.data.setLevelStorage(asJsonObject.get("levelStorage").getAsInt());
        this.data.setLevelMarketListings(asJsonObject.get("levelMarketListings").getAsInt());
        this.data.setLevelMarketTime(asJsonObject.get("levelMarketTime").getAsInt());
        this.data.setLevelWorkshopQueue(asJsonObject.get("levelWorkshopQueue").getAsInt());
        this.data.setLevelWorkshopTime(asJsonObject.get("levelWorkshopTime").getAsInt());
        boolean z = false;
        this.data.setLevelShelter(asJsonObject.has("levelShelter") ? asJsonObject.get("levelShelter").getAsInt() : 0);
        this.data.setLevelShelterAutofeed(asJsonObject.has("levelShelterAutofeed") ? asJsonObject.get("levelShelterAutofeed").getAsInt() : 0);
        this.data.setUpgradeMarketQueue(asJsonObject.has("upgradeMarketQueue") ? asJsonObject.get("upgradeMarketQueue").getAsInt() : 0);
        this.data.setUpgradeMarketTime(asJsonObject.has("upgradeMarketTime") ? asJsonObject.get("upgradeMarketTime").getAsInt() : 0);
        this.data.setUpgradeQuarters(asJsonObject.has("upgradeQuarters") ? asJsonObject.get("upgradeQuarters").getAsInt() : 0);
        this.data.setUpgradeShelter(asJsonObject.has("upgradeShelter") ? asJsonObject.get("upgradeShelter").getAsInt() : 0);
        this.data.setUpgradeStorage(asJsonObject.has("upgradeStorage") ? asJsonObject.get("upgradeStorage").getAsInt() : 0);
        this.data.setUpgradeTavernCapacity(asJsonObject.has("upgradeTavernCapacity") ? asJsonObject.get("upgradeTavernCapacity").getAsInt() : 0);
        this.data.setUpgradeTavernTime(asJsonObject.has("upgradeTavernTime") ? asJsonObject.get("upgradeTavernTime").getAsInt() : 0);
        this.data.setUpgradeWorkshopQueue(asJsonObject.has("upgradeWorkshopQueue") ? asJsonObject.get("upgradeWorkshopQueue").getAsInt() : 0);
        this.data.setUpgradeWorkshopTime(asJsonObject.has("upgradeWorkshopTime") ? asJsonObject.get("upgradeWorkshopTime").getAsInt() : 0);
        Iterator<JsonElement> it4 = asJsonObject.get("adventurers").getAsJsonArray().iterator();
        while (it4.hasNext()) {
            this.data.getAdventurers().add(getAdventurer(it4.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it5 = asJsonObject.get("items").getAsJsonArray().iterator();
        while (it5.hasNext()) {
            this.data.getItems().add(getItem(it5.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it6 = asJsonObject.get("seenItems").getAsJsonArray().iterator();
        while (it6.hasNext()) {
            this.data.getSeenItems().add(it6.next().getAsString());
        }
        if (asJsonObject.has("seenEnemies")) {
            Iterator<JsonElement> it7 = asJsonObject.get("seenEnemies").getAsJsonArray().iterator();
            while (it7.hasNext()) {
                this.data.getSeenEnemies().add(it7.next().getAsString());
            }
        }
        Iterator<JsonElement> it8 = asJsonObject.get("knownRecipes").getAsJsonArray().iterator();
        while (it8.hasNext()) {
            try {
                this.data.getKnownRecipes().add(Recipes.valueOf(it8.next().getAsString()));
            } catch (Exception unused) {
            }
        }
        Iterator<JsonElement> it9 = asJsonObject.get("uniqueItemsLost").getAsJsonArray().iterator();
        while (it9.hasNext()) {
            this.data.getUniqueItemsLost().add(it9.next().getAsString());
        }
        if (asJsonObject.has("pets")) {
            Iterator<JsonElement> it10 = asJsonObject.get("pets").getAsJsonArray().iterator();
            while (it10.hasNext()) {
                this.data.getPets().add(getPet(it10.next().getAsJsonObject()));
            }
        }
        Iterator<JsonElement> it11 = asJsonObject.get("tavernGuests").getAsJsonArray().iterator();
        while (it11.hasNext()) {
            this.data.getTavernGuests().add(getAdventurer(it11.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it12 = asJsonObject.get("dismissedAdventurers").getAsJsonArray().iterator();
        while (it12.hasNext()) {
            this.data.getDismissedAdventurers().add(getAdventurer(it12.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it13 = asJsonObject.get("soldMarketItems").getAsJsonArray().iterator();
        while (it13.hasNext()) {
            this.data.getSoldMarketItems().add(getItemAction(it13.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it14 = asJsonObject.get("marketListings").getAsJsonArray().iterator();
        while (it14.hasNext()) {
            this.data.getMarketListings().add(getItemAction(it14.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it15 = asJsonObject.get("completedWorkshopItems").getAsJsonArray().iterator();
        while (it15.hasNext()) {
            this.data.getCompletedWorkshopItems().add(getItemAction(it15.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it16 = asJsonObject.get("workshopQueue").getAsJsonArray().iterator();
        while (it16.hasNext()) {
            this.data.getWorkshopQueue().add(getItemAction(it16.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it17 = asJsonObject.get("merchantRegularStockItems").getAsJsonArray().iterator();
        while (it17.hasNext()) {
            this.data.getMerchantRegularStockItems().add(getMerchantOffer(it17.next().getAsJsonObject()));
        }
        Iterator<JsonElement> it18 = asJsonObject.get("merchantSpecialReserve").getAsJsonArray().iterator();
        while (it18.hasNext()) {
            this.data.getMerchantSpecialReserve().add(getMerchantOffer(it18.next().getAsJsonObject()));
        }
        this.data.setRedeemed_fj9rf8hh(asJsonObject.has("redeemed_fj9rf8hh") && asJsonObject.get("redeemed_fj9rf8hh").getAsBoolean());
        this.data.setRedeemed_f8hf3045(asJsonObject.has("redeemed_f8hf3045") && asJsonObject.get("redeemed_f8hf3045").getAsBoolean());
        this.data.setRedeemed_g294ps91(asJsonObject.has("redeemed_g294ps91") && asJsonObject.get("redeemed_g294ps91").getAsBoolean());
        this.data.setRedeemed_vre8983y(asJsonObject.has("redeemed_vre8983y") && asJsonObject.get("redeemed_vre8983y").getAsBoolean());
        this.data.setRedeemed_vrw74ync(asJsonObject.has("redeemed_vrw74ync") && asJsonObject.get("redeemed_vrw74ync").getAsBoolean());
        this.data.setRedeemed_e44opo7z(asJsonObject.has("redeemed_e44opo7z") && asJsonObject.get("redeemed_e44opo7z").getAsBoolean());
        this.data.setRedeem_potionsRefund1(asJsonObject.has("redeem_potionsRefund1") && asJsonObject.get("redeem_potionsRefund1").getAsBoolean());
        this.data.setRedeem_f1r39h15(asJsonObject.has("redeem_f1r39h15") && asJsonObject.get("redeem_f1r39h15").getAsBoolean());
        this.data.setRedeem_m975nfu5(asJsonObject.has("redeem_m975nfu5") ? asJsonObject.get("redeem_m975nfu5").getAsInt() : 0);
        this.data.setRedeem_g73mfkf4(asJsonObject.has("redeem_g73mfkf4") && asJsonObject.get("redeem_g73mfkf4").getAsBoolean());
        this.data.setNewMerchantRegularItems(asJsonObject.get("newMerchantRegularItems").getAsBoolean());
        this.data.setNewMerchantSpecialItems(asJsonObject.get("newMerchantSpecialItems").getAsBoolean());
        this.data.setSettingsLanguage(asJsonObject.get("settingsLanguage").getAsString());
        this.data.setSettingSellMaxAmount(asJsonObject.get("settingSellMaxAmount").getAsBoolean());
        this.data.setSettingCraftMaxAmount(asJsonObject.has("settingCraftMaxAmount") && asJsonObject.get("settingCraftMaxAmount").getAsBoolean());
        this.data.setSettingConfirmUpgrade(asJsonObject.has("settingConfirmUpgrade") && asJsonObject.get("settingConfirmUpgrade").getAsBoolean());
        this.data.setSettingConfirmRetreat(asJsonObject.get("settingConfirmRetreat").getAsBoolean());
        this.data.setSettingConfirmSwap(asJsonObject.get("settingConfirmSwap").getAsBoolean());
        this.data.setSettingAutoOpenDungeonDetail(asJsonObject.get("settingAutoOpenDungeonDetail").getAsBoolean());
        this.data.setSettingVerboseLogs(!asJsonObject.has("settingVerboseLogs") || asJsonObject.get("settingVerboseLogs").getAsBoolean());
        this.data.setSettingColorblindMode(asJsonObject.has("settingColorblindMode") && asJsonObject.get("settingColorblindMode").getAsBoolean());
        this.data.setStarterPackPurchased(asJsonObject.has("starterPackPurchased") && asJsonObject.get("starterPackPurchased").getAsBoolean());
        this.data.setAdventurerPackPurchased(asJsonObject.has("adventurerPackPurchased") && asJsonObject.get("adventurerPackPurchased").getAsBoolean());
        this.data.setMerchantPackPurchased(asJsonObject.has("merchantPackPurchased") && asJsonObject.get("merchantPackPurchased").getAsBoolean());
        this.data.setImperialVanguardPurchased(asJsonObject.has("imperialVanguardPurchased") && asJsonObject.get("imperialVanguardPurchased").getAsBoolean());
        this.data.setUnholyCrusadePurchased(asJsonObject.has("unholyCrusadePurchased") && asJsonObject.get("unholyCrusadePurchased").getAsBoolean());
        this.data.setAmountOfPurchases(asJsonObject.has("amountOfPurchases") ? asJsonObject.get("amountOfPurchases").getAsInt() : 0);
        this.data.setTotalGemsPurchased(asJsonObject.has("totalGemsPurchased") ? asJsonObject.get("totalGemsPurchased").getAsLong() : 0L);
        this.data.setIntercessionsRetroactivelyGranted(asJsonObject.has("intercessionsRetroactivelyGranted") && asJsonObject.get("intercessionsRetroactivelyGranted").getAsBoolean());
        this.data.setVial2RetGrant(asJsonObject.has("vial2RetGrant") && asJsonObject.get("vial2RetGrant").getAsBoolean());
        this.data.setLastHourTriggered(asJsonObject.has("lastHourTriggered") ? asJsonObject.get("lastHourTriggered").getAsLong() : 0L);
        this.data.setLast24Triggered(asJsonObject.get("last24Triggered").getAsLong());
        this.data.setLastWeekTriggered(asJsonObject.get("lastWeekTriggered").getAsLong());
        this.data.setQuestsSeen(asJsonObject.has("questsSeen") && asJsonObject.get("questsSeen").getAsBoolean());
        this.data.setQuestsRefreshed(asJsonObject.has("questsRefreshed") && asJsonObject.get("questsRefreshed").getAsBoolean());
        if (asJsonObject.has("kingsQuests")) {
            Iterator<JsonElement> it19 = asJsonObject.get("kingsQuests").getAsJsonArray().iterator();
            while (it19.hasNext()) {
                Quest quest = getQuest(it19.next().getAsJsonObject());
                if (quest != null) {
                    this.data.getKingsQuests().add(quest);
                }
            }
        }
        if (asJsonObject.has("afflictionQuests")) {
            Iterator<JsonElement> it20 = asJsonObject.get("afflictionQuests").getAsJsonArray().iterator();
            while (it20.hasNext()) {
                Quest quest2 = getQuest(it20.next().getAsJsonObject());
                if (quest2 != null) {
                    this.data.getAfflictionQuests().add(quest2);
                }
            }
        }
        if (asJsonObject.has("controlQuests")) {
            Iterator<JsonElement> it21 = asJsonObject.get("controlQuests").getAsJsonArray().iterator();
            while (it21.hasNext()) {
                Quest quest3 = getQuest(it21.next().getAsJsonObject());
                if (quest3 != null) {
                    this.data.getControlQuests().add(quest3);
                }
            }
        }
        if (asJsonObject.has("fortitudeQuests")) {
            Iterator<JsonElement> it22 = asJsonObject.get("fortitudeQuests").getAsJsonArray().iterator();
            while (it22.hasNext()) {
                Quest quest4 = getQuest(it22.next().getAsJsonObject());
                if (quest4 != null) {
                    this.data.getFortitudeQuests().add(quest4);
                }
            }
        }
        if (asJsonObject.has("graceQuests")) {
            Iterator<JsonElement> it23 = asJsonObject.get("graceQuests").getAsJsonArray().iterator();
            while (it23.hasNext()) {
                Quest quest5 = getQuest(it23.next().getAsJsonObject());
                if (quest5 != null) {
                    this.data.getGraceQuests().add(quest5);
                }
            }
        }
        if (asJsonObject.has("illusionQuests")) {
            Iterator<JsonElement> it24 = asJsonObject.get("illusionQuests").getAsJsonArray().iterator();
            while (it24.hasNext()) {
                Quest quest6 = getQuest(it24.next().getAsJsonObject());
                if (quest6 != null) {
                    this.data.getIllusionQuests().add(quest6);
                }
            }
        }
        if (asJsonObject.has("knowledgeQuests")) {
            Iterator<JsonElement> it25 = asJsonObject.get("knowledgeQuests").getAsJsonArray().iterator();
            while (it25.hasNext()) {
                Quest quest7 = getQuest(it25.next().getAsJsonObject());
                if (quest7 != null) {
                    this.data.getKnowledgeQuests().add(quest7);
                }
            }
        }
        if (asJsonObject.has("ruinQuests")) {
            Iterator<JsonElement> it26 = asJsonObject.get("ruinQuests").getAsJsonArray().iterator();
            while (it26.hasNext()) {
                Quest quest8 = getQuest(it26.next().getAsJsonObject());
                if (quest8 != null) {
                    this.data.getRuinQuests().add(quest8);
                }
            }
        }
        if (asJsonObject.has("warQuests")) {
            Iterator<JsonElement> it27 = asJsonObject.get("warQuests").getAsJsonArray().iterator();
            while (it27.hasNext()) {
                Quest quest9 = getQuest(it27.next().getAsJsonObject());
                if (quest9 != null) {
                    this.data.getWarQuests().add(quest9);
                }
            }
        }
        this.data.setAfflictionLevel(asJsonObject.has("afflictionLevel") ? asJsonObject.get("afflictionLevel").getAsInt() : 0);
        this.data.setControlLevel(asJsonObject.has("controlLevel") ? asJsonObject.get("controlLevel").getAsInt() : 0);
        this.data.setFortitudeLevel(asJsonObject.has("fortitudeLevel") ? asJsonObject.get("fortitudeLevel").getAsInt() : 0);
        this.data.setGraceLevel(asJsonObject.has("graceLevel") ? asJsonObject.get("graceLevel").getAsInt() : 0);
        this.data.setIllusionLevel(asJsonObject.has("illusionLevel") ? asJsonObject.get("illusionLevel").getAsInt() : 0);
        this.data.setKnowledgeLevel(asJsonObject.has("knowledgeLevel") ? asJsonObject.get("knowledgeLevel").getAsInt() : 0);
        this.data.setRuinLevel(asJsonObject.has("ruinLevel") ? asJsonObject.get("ruinLevel").getAsInt() : 0);
        this.data.setWarLevel(asJsonObject.has("warLevel") ? asJsonObject.get("warLevel").getAsInt() : 0);
        this.data.setAfflictionProgress(asJsonObject.has("afflictionProgress") ? asJsonObject.get("afflictionProgress").getAsInt() : 0);
        this.data.setControlProgress(asJsonObject.has("controlProgress") ? asJsonObject.get("controlProgress").getAsInt() : 0);
        this.data.setFortitudeProgress(asJsonObject.has("fortitudeProgress") ? asJsonObject.get("fortitudeProgress").getAsInt() : 0);
        this.data.setGraceProgress(asJsonObject.has("graceProgress") ? asJsonObject.get("graceProgress").getAsInt() : 0);
        this.data.setIllusionProgress(asJsonObject.has("illusionProgress") ? asJsonObject.get("illusionProgress").getAsInt() : 0);
        this.data.setKnowledgeProgress(asJsonObject.has("knowledgeProgress") ? asJsonObject.get("knowledgeProgress").getAsInt() : 0);
        this.data.setRuinProgress(asJsonObject.has("ruinProgress") ? asJsonObject.get("ruinProgress").getAsInt() : 0);
        this.data.setWarProgress(asJsonObject.has("warProgress") ? asJsonObject.get("warProgress").getAsInt() : 0);
        this.data.setAdsWatched(asJsonObject.get("adsWatched").getAsInt());
        this.data.setShownDialogRaid(asJsonObject.get("shownDialogRaid").getAsBoolean());
        this.data.setShownDialogEpicRaid(asJsonObject.get("shownDialogEpicRaid").getAsBoolean());
        this.data.setReviewTrigger(asJsonObject.has("reviewTrigger") && asJsonObject.get("reviewTrigger").getAsBoolean());
        this.data.setReviewShown(asJsonObject.has("reviewShown") && asJsonObject.get("reviewShown").getAsBoolean());
        this.data.setMaxAdventurerTier(asJsonObject.has("maxAdventurerTier") ? asJsonObject.get("maxAdventurerTier").getAsInt() : 0);
        this.data.setItemsCrafted(asJsonObject.has("itemsCrafted") ? asJsonObject.get("itemsCrafted").getAsLong() : 0L);
        this.data.setItemsSold(asJsonObject.has("itemsSold") ? asJsonObject.get("itemsSold").getAsLong() : 0L);
        this.data.setMaxAdventurersOwned(asJsonObject.has("maxAdventurersOwned") ? asJsonObject.get("maxAdventurersOwned").getAsInt() : 0);
        this.data.setT4Pet(asJsonObject.has("t4Pet") && asJsonObject.get("t4Pet").getAsBoolean());
        this.data.setEverAscended(asJsonObject.has("everAscended") && asJsonObject.get("everAscended").getAsBoolean());
        this.data.setQuestsCompleted(asJsonObject.has("questsCompleted") ? asJsonObject.get("questsCompleted").getAsInt() : 0);
        this.data.setDoctrineMaxed(asJsonObject.has("doctrineMaxed") && asJsonObject.get("doctrineMaxed").getAsBoolean());
        Data data2 = this.data;
        if (asJsonObject.has("potsMaxed") && asJsonObject.get("potsMaxed").getAsBoolean()) {
            z = true;
        }
        data2.setPotsMaxed(z);
        this.data.setMaxWealth(asJsonObject.has("maxWealth") ? asJsonObject.get("maxWealth").getAsLong() : 0L);
        this.data.setEnchantedForest((EnchantedForest) getArea(EnchantedForest.class, asJsonObject, "enchantedForest"));
        this.data.setTheDesert((TheDesert) getArea(TheDesert.class, asJsonObject, "theDesert"));
        this.data.setEternalBattlefield((EternalBattlefield) getArea(EternalBattlefield.class, asJsonObject, "eternalBattlefield"));
        this.data.setTheGoldenCity((TheGoldenCity) getArea(TheGoldenCity.class, asJsonObject, "theGoldenCity"));
        this.data.setBlackwaterPort((BlackwaterPort) getArea(BlackwaterPort.class, asJsonObject, "blackwaterPort"));
        this.data.setFrostbitePeaks((FrostbitePeaks) getArea(FrostbitePeaks.class, asJsonObject, "frostbitePeaks"));
        this.data.setObsidianMines((ObsidianMines) getArea(ObsidianMines.class, asJsonObject, "obsidianMines"));
        this.data.setTheSouthernGrove((TheSouthernGrove) getArea(TheSouthernGrove.class, asJsonObject, "theSouthernGrove"));
        this.data.setBarrenWastelands((BarrenWastelands) getArea(BarrenWastelands.class, asJsonObject, "barrenWastelands"));
        this.data.setHiddenCityOfLarox((HiddenCityOfLarox) getArea(HiddenCityOfLarox.class, asJsonObject, "hiddenCityOfLarox"));
        this.data.setLostLands((LostLands) getArea(LostLands.class, asJsonObject, "lostLands"));
        this.data.setTheSlimePond((TheSlimePond) getArea(TheSlimePond.class, asJsonObject, "theSlimePond"));
        this.data.setDivineArcheology((DivineArcheology) getArea(DivineArcheology.class, asJsonObject, "divineArcheology"));
        this.data.setAncientGraveDigging((AncientGraveDigging) getArea(AncientGraveDigging.class, asJsonObject, "ancientGraveDigging"));
        this.data.setImperialRescue((ImperialRescue) getArea(ImperialRescue.class, asJsonObject, "imperialRescue"));
        this.data.setTheCultistRebels((TheCultistRebels) getArea(TheCultistRebels.class, asJsonObject, "theCultistRebels"));
        this.data.setTheLostExpedition((TheLostExpedition) getArea(TheLostExpedition.class, asJsonObject, "theLostExpedition"));
        this.data.setTheDreadfulAscent((TheDreadfulAscent) getArea(TheDreadfulAscent.class, asJsonObject, "theDreadfulAscent"));
        this.data.setCelestialMothership((CelestialMothership) getArea(CelestialMothership.class, asJsonObject, "celestialMothership"));
        this.data.setTheDireDescent((TheDireDescent) getArea(TheDireDescent.class, asJsonObject, "theDireDescent"));
        this.data.setSleepingPlanet((SleepingPlanet) getArea(SleepingPlanet.class, asJsonObject, "sleepingPlanet"));
        this.data.setKaunis((Kaunis) getArea(Kaunis.class, asJsonObject, "kaunis"));
        this.data.setTheTower((TheTower) getArea(TheTower.class, asJsonObject, "theTower"));
        return this.data;
    }

    private Adventurer getAdventurer(JsonObject jsonObject) {
        Adventurer adventurer = Adventurer.getInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("id").getAsInt(), jsonObject.get("level").getAsInt(), jsonObject.get("experience").getAsInt(), jsonObject.has("weapon") ? (Weapon) getItem(jsonObject.get("weapon").getAsJsonObject()) : null, jsonObject.has("armor") ? (Armor) getItem(jsonObject.get("armor").getAsJsonObject()) : null, jsonObject.has("accessory") ? (Accessory) getItem(jsonObject.get("accessory").getAsJsonObject()) : null, jsonObject.has("traitCommon") ? Trait.fromString(jsonObject.get("traitCommon").getAsString()) : null, jsonObject.has("traitRare") ? Trait.fromString(jsonObject.get("traitRare").getAsString()) : null, jsonObject.has("potionsDrank") ? getPotionsDrank(jsonObject.get("potionsDrank").getAsJsonObject()) : new PotionsDrank(), jsonObject.has("doctrine") ? getDoctrine(jsonObject.get("doctrine").getAsJsonObject()) : null, jsonObject.has("ascended") ? jsonObject.get("ascended").getAsBoolean() : false);
        adventurer.setCurrentHp(jsonObject.get("currentHp").getAsInt());
        adventurer.setCurrentMana(jsonObject.get("currentMana").getAsInt());
        adventurer.setCurrentShield(jsonObject.has("currentShield") ? jsonObject.get("currentShield").getAsInt() : 0);
        adventurer.setPositiveStatusEffects(getEffects(jsonObject.get("positiveStatusEffects").getAsJsonArray()));
        adventurer.setNegativeStatusEffects(getEffects(jsonObject.get("negativeStatusEffects").getAsJsonArray()));
        adventurer.setSeen(jsonObject.get("seen").getAsBoolean());
        adventurer.setTimeWhenDismissed(jsonObject.get("timeWhenDismissed").getAsLong());
        return adventurer;
    }

    private Pet getPet(JsonObject jsonObject) {
        Pet pet = Pet.getInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("id").getAsInt(), jsonObject.get("level").getAsInt(), jsonObject.get("food").getAsInt(), PetAbility.fromString(jsonObject.get("petAbility1").getAsString()), PetAbility.fromString(jsonObject.get("petAbility2").getAsString()), PetAbility.fromString(jsonObject.get("petAbility3").getAsString()), PetAbility.fromString(jsonObject.get("petAbility4").getAsString()));
        pet.setFavourite(jsonObject.get("favourite").getAsBoolean());
        return pet;
    }

    private Enemy getEnemy(JsonObject jsonObject) {
        Enemy enemy = Enemy.getInstance(jsonObject.get("trueClass").getAsString());
        enemy.setCurrentHp(jsonObject.get("currentHp").getAsInt());
        enemy.setCurrentMana(jsonObject.get("currentMana").getAsInt());
        enemy.setCurrentShield(jsonObject.has("currentShield") ? jsonObject.get("currentShield").getAsInt() : 0);
        enemy.setPositiveStatusEffects(getEffects(jsonObject.get("positiveStatusEffects").getAsJsonArray()));
        enemy.setNegativeStatusEffects(getEffects(jsonObject.get("negativeStatusEffects").getAsJsonArray()));
        return enemy;
    }

    private List<StatusEffect> getEffects(JsonArray jsonArray) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<JsonElement> it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            JsonObject asJsonObject = it2.next().getAsJsonObject();
            StatusEffectType statusEffectTypeValueOf = StatusEffectType.valueOf(asJsonObject.get("type").getAsString());
            if (statusEffectTypeValueOf.serialized) {
                copyOnWriteArrayList.add(new StatusEffect(statusEffectTypeValueOf, null, asJsonObject.get("turnsLeft").getAsInt(), 0.0d));
            }
        }
        return copyOnWriteArrayList;
    }

    private Item getItem(JsonObject jsonObject) {
        return Item.getInstance(jsonObject.get("trueClass").getAsString(), Math.max(jsonObject.get("stack").getAsInt(), 1));
    }

    private PotionsDrank getPotionsDrank(JsonObject jsonObject) {
        try {
            return new PotionsDrank(jsonObject.get("potionOfConstitutionDrank").getAsInt(), jsonObject.get("potionOfDexterityDrank").getAsInt(), jsonObject.get("potionOfIntelligenceDrank").getAsInt(), jsonObject.get("potionOfHealthDrank").getAsInt(), jsonObject.get("potionOfDefenseDrank").getAsInt(), jsonObject.get("potionOfMagicDefenseDrank").getAsInt(), jsonObject.get("potionOfPrecisionDrank").getAsInt(), jsonObject.get("potionOfViciousnessDrank").getAsInt(), jsonObject.get("potionOfDarknessDrank").getAsInt(), jsonObject.get("potionOfImmunityDrank").getAsInt(), jsonObject.get("potionOfAgilityDrank").getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
            return new PotionsDrank();
        }
    }

    private Doctrine getDoctrine(JsonObject jsonObject) {
        try {
            return Doctrine.getInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("l1").getAsInt(), jsonObject.get("l2").getAsInt(), jsonObject.get("l3").getAsInt(), jsonObject.get("l4").getAsInt(), jsonObject.get("l5").getAsInt(), jsonObject.get("l6").getAsInt());
        } catch (Exception unused) {
            return null;
        }
    }

    private ItemAction getItemAction(JsonObject jsonObject) {
        ItemAction itemAction = new ItemAction(getItem(jsonObject.get("item").getAsJsonObject()));
        itemAction.setSecondsPassed(jsonObject.get("secondsPassed").getAsLong());
        return itemAction;
    }

    private MerchantOffer getMerchantOffer(JsonObject jsonObject) {
        MerchantOffer merchantOffer = new MerchantOffer(getItem(jsonObject.get("item").getAsJsonObject()));
        merchantOffer.setPrice(jsonObject.get("price").getAsLong());
        merchantOffer.setGems(jsonObject.get("gems").getAsBoolean());
        return merchantOffer;
    }

    private Quest getQuest(JsonObject jsonObject) {
        try {
            return Quest.loadInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("rarity").getAsInt(), jsonObject.get("targetProgress").getAsInt(), jsonObject.get("progress").getAsInt());
        } catch (Exception unused) {
            return null;
        }
    }

    private EnemyCounter getEnemyCounter(JsonObject jsonObject) {
        return new EnemyCounter(jsonObject.get("enemy").getAsString(), jsonObject.get("timesSlain").getAsInt());
    }

    private <T extends Area> T getArea(Class<T> cls, JsonObject jsonObject, String str) {
        Integer numValueOf = null;
        try {
            T tNewInstance = cls.newInstance();
            if (!jsonObject.has(str)) {
                return tNewInstance;
            }
            JsonObject asJsonObject = jsonObject.get(str).getAsJsonObject();
            try {
                JsonArray asJsonArray = asJsonObject.get("adventurersExploringIds").getAsJsonArray();
                Iterator<JsonElement> it2 = asJsonArray.iterator();
                while (it2.hasNext()) {
                    tNewInstance.getAdventurersExploringIds().add(Integer.valueOf(it2.next().getAsInt()));
                }
                Iterator<JsonElement> it3 = asJsonObject.get("savedAdventurersIds").getAsJsonArray().iterator();
                while (it3.hasNext()) {
                    tNewInstance.getSavedAdventurersIds().add(Integer.valueOf(it3.next().getAsInt()));
                }
                tNewInstance.setPetExploringId(asJsonObject.has("petExploringId") ? Integer.valueOf(asJsonObject.get("petExploringId").getAsInt()) : null);
                tNewInstance.setSavedPetId(asJsonObject.has("savedPetId") ? Integer.valueOf(asJsonObject.get("savedPetId").getAsInt()) : null);
                Iterator<JsonElement> it4 = asJsonObject.get("drops").getAsJsonArray().iterator();
                while (it4.hasNext()) {
                    tNewInstance.getDrops().add(getItem(it4.next().getAsJsonObject()));
                }
                tNewInstance.setProgress(asJsonObject.get("progress").getAsInt());
                tNewInstance.setMaxProgress(asJsonObject.get("maxProgress").getAsInt());
                tNewInstance.setUnlocked(asJsonObject.get("unlocked").getAsBoolean());
                tNewInstance.setTriesAvailable(asJsonObject.get("triesAvailable").getAsBoolean());
                AdventureRecap adventureRecap = new AdventureRecap();
                if (asJsonObject.has("adventureRecap")) {
                    JsonObject asJsonObject2 = asJsonObject.get("adventureRecap").getAsJsonObject();
                    adventureRecap.setSecondsPassed(asJsonObject2.get("secondsPassed").getAsInt());
                    adventureRecap.setAreasCleared(asJsonObject2.get("areasCleared").getAsInt());
                    adventureRecap.setWiped(asJsonObject2.get("wiped").getAsInt());
                    adventureRecap.setExpEarned(asJsonObject2.get("expEarned").getAsInt());
                    adventureRecap.setExpLost(asJsonObject2.get("expLost").getAsInt());
                    if (asJsonObject2.has("enemiesKilled")) {
                        Iterator<JsonElement> it5 = asJsonObject2.get("enemiesKilled").getAsJsonArray().iterator();
                        while (it5.hasNext()) {
                            adventureRecap.getEnemiesKilled().add(getEnemyCounter(it5.next().getAsJsonObject()));
                        }
                    }
                }
                tNewInstance.setAdventureRecap(adventureRecap);
                if (asJsonArray.size() > 0) {
                    Iterator<JsonElement> it6 = asJsonObject.get("enemies").getAsJsonArray().iterator();
                    while (it6.hasNext()) {
                        tNewInstance.getEnemies().add(getEnemy(it6.next().getAsJsonObject()));
                    }
                    Iterator<JsonElement> it7 = asJsonObject.get("corpses").getAsJsonArray().iterator();
                    while (it7.hasNext()) {
                        tNewInstance.getCorpses().add(getEnemy(it7.next().getAsJsonObject()));
                    }
                    JsonObject asJsonObject3 = asJsonObject.get("action").getAsJsonObject();
                    Action action = new Action(asJsonObject3.get("type").getAsInt());
                    action.setTurnsPassed(asJsonObject3.get("turnsPassed").getAsInt());
                    tNewInstance.setAction(action);
                    tNewInstance.setupAdventurers(this.data.getAdventurers(), this.data.getPets());
                    if (asJsonObject.has("savedActingEntity")) {
                        numValueOf = Integer.valueOf(asJsonObject.get("savedActingEntity").getAsInt());
                    }
                    tNewInstance.setSavedActingEntity(numValueOf);
                    tNewInstance.setTurnsFighting(asJsonObject.get("turnsFighting").getAsInt());
                    if (asJsonObject.has(NotificationCompat.CATEGORY_EVENT)) {
                        JsonObject asJsonObject4 = asJsonObject.get(NotificationCompat.CATEGORY_EVENT).getAsJsonObject();
                        Event event = new Event();
                        event.setKey(asJsonObject4.get("key").getAsInt());
                        event.setProgress(asJsonObject4.get("progress").getAsInt());
                        tNewInstance.setEvent(event);
                    }
                }
                tNewInstance.setupInitialDarkness();
                return tNewInstance;
            } catch (Exception e) {
                e.printStackTrace();
                return tNewInstance;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
