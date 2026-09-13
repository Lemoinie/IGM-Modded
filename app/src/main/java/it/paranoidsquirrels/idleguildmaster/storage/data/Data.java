package it.paranoidsquirrels.idleguildmaster.storage.data;

import it.paranoidsquirrels.idleguildmaster.KingMessage;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
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
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class Data {
    private int adsWatched;
    private boolean adventurerPackPurchased;
    private int afflictionLevel;
    private int afflictionProgress;
    private int amountOfPurchases;
    private AncientGraveDigging ancientGraveDigging;
    private BarrenWastelands barrenWastelands;
    private BlackwaterPort blackwaterPort;
    private CelestialMothership celestialMothership;
    private int controlLevel;
    private int controlProgress;
    private DivineArcheology divineArcheology;
    private boolean doctrineMaxed;
    private EnchantedForest enchantedForest;
    private EternalBattlefield eternalBattlefield;
    private boolean everAscended;
    private int fortitudeLevel;
    private int fortitudeProgress;
    private FrostbitePeaks frostbitePeaks;
    private long gems;
    private int graceLevel;
    private int graceProgress;
    private HiddenCityOfLarox hiddenCityOfLarox;
    private int illusionLevel;
    private int illusionProgress;
    private ImperialRescue imperialRescue;
    private boolean imperialVanguardPurchased;
    private long itemsCrafted;
    private long itemsSold;
    private Kaunis kaunis;
    private int knowledgeLevel;
    private int knowledgeProgress;
    private long last24Triggered;
    private long lastAccess;
    private long lastHourTriggered;
    private long lastWeekTriggered;
    private int levelMarketListings;
    private int levelMarketTime;
    private int levelQuarters;
    private int levelShelter;
    private int levelShelterAutofeed;
    private int levelStorage;
    private int levelTavernCapacity;
    private int levelTavernTime;
    private int levelWorkshopQueue;
    private int levelWorkshopTime;
    private LostLands lostLands;
    private int maxAdventurerTier;
    private int maxAdventurersOwned;
    private long maxWealth;
    private boolean merchantPackPurchased;
    private long money;
    private boolean newMerchantRegularItems;
    private boolean newMerchantSpecialItems;
    private long nextTavernVisit;
    private ObsidianMines obsidianMines;
    private boolean potsMaxed;
    private int questsCompleted;
    private int ruinLevel;
    private int ruinProgress;
    private boolean settingAutoOpenDungeonDetail;
    private boolean settingColorblindMode;
    private boolean settingConfirmRetreat;
    private boolean settingConfirmSwap;
    private boolean settingConfirmUpgrade;
    private boolean settingCraftMaxAmount;
    private boolean settingSellMaxAmount;
    private boolean settingVerboseLogs;
    private String settingsLanguage;
    private boolean shownDialogEpicRaid;
    private boolean shownDialogRaid;
    private SleepingPlanet sleepingPlanet;
    private boolean starterPackPurchased;
    private boolean t4Pet;
    private boolean tavernLocked;
    private TheCultistRebels theCultistRebels;
    private TheDesert theDesert;
    private TheDireDescent theDireDescent;
    private TheDreadfulAscent theDreadfulAscent;
    private TheGoldenCity theGoldenCity;
    private TheLostExpedition theLostExpedition;
    private TheSlimePond theSlimePond;
    private TheSouthernGrove theSouthernGrove;
    private TheTower theTower;
    private long totalGemsPurchased;
    private int tutorialStep;
    private boolean unholyCrusadePurchased;
    private int upgradeMarketQueue;
    private int upgradeMarketTime;
    private int upgradeQuarters;
    private int upgradeShelter;
    private int upgradeStorage;
    private int upgradeTavernCapacity;
    private int upgradeTavernTime;
    private int upgradeWorkshopQueue;
    private int upgradeWorkshopTime;
    private int warLevel;
    private int warProgress;
    private List<KingMessage> messagesToShow = new CopyOnWriteArrayList();
    private List<KingMessage> messagesGotten = new CopyOnWriteArrayList();
    private List<Adventurer> adventurers = new CopyOnWriteArrayList();
    private List<Item> items = new CopyOnWriteArrayList();
    private Set<String> seenItems = new CopyOnWriteArraySet();
    private Set<String> seenEnemies = new CopyOnWriteArraySet();
    private Set<Recipes> knownRecipes = new CopyOnWriteArraySet();
    private Set<String> uniqueItemsLost = new CopyOnWriteArraySet();
    private List<Pet> pets = new CopyOnWriteArrayList();
    private List<Adventurer> tavernGuests = new CopyOnWriteArrayList();
    private List<Adventurer> dismissedAdventurers = new CopyOnWriteArrayList();
    private List<ItemAction> soldMarketItems = new CopyOnWriteArrayList();
    private List<ItemAction> marketListings = new CopyOnWriteArrayList();
    private List<ItemAction> completedWorkshopItems = new CopyOnWriteArrayList();
    private List<ItemAction> workshopQueue = new CopyOnWriteArrayList();
    private List<MerchantOffer> merchantRegularStockItems = new CopyOnWriteArrayList();
    private List<MerchantOffer> merchantSpecialReserve = new CopyOnWriteArrayList();
    private boolean questsSeen = false;
    private boolean questsRefreshed = false;
    private List<Quest> kingsQuests = new CopyOnWriteArrayList();
    private List<Quest> afflictionQuests = new CopyOnWriteArrayList();
    private List<Quest> controlQuests = new CopyOnWriteArrayList();
    private List<Quest> fortitudeQuests = new CopyOnWriteArrayList();
    private List<Quest> graceQuests = new CopyOnWriteArrayList();
    private List<Quest> illusionQuests = new CopyOnWriteArrayList();
    private List<Quest> knowledgeQuests = new CopyOnWriteArrayList();
    private List<Quest> ruinQuests = new CopyOnWriteArrayList();
    private List<Quest> warQuests = new CopyOnWriteArrayList();
    private boolean reviewTrigger = false;
    private boolean reviewShown = false;
    private boolean redeemed_f8hf3045 = false;
    private boolean redeemed_g294ps91 = false;
    private boolean redeemed_vre8983y = false;
    private boolean redeemed_vrw74ync = false;
    private boolean redeemed_e44opo7z = false;
    private boolean redeem_potionsRefund1 = false;
    private boolean redeem_f1r39h15 = false;
    private int redeem_m975nfu5 = 0;
    private boolean redeem_g73mfkf4 = false;
    private boolean redeemed_fj9rf8hh = false;
    private boolean intercessionsRetroactivelyGranted = false;
    private boolean vial2RetGrant = false;

    public Data() {
        this.messagesToShow.add(KingMessage.MESSAGE_1);
        this.messagesGotten.add(KingMessage.MESSAGE_1);
        this.tutorialStep = 1;
        this.settingsLanguage = "";
        this.settingSellMaxAmount = false;
        this.settingConfirmUpgrade = false;
        this.settingConfirmRetreat = true;
        this.settingConfirmSwap = true;
        this.settingAutoOpenDungeonDetail = true;
        this.settingVerboseLogs = true;
        this.enchantedForest = new EnchantedForest();
        this.theDesert = new TheDesert();
        this.eternalBattlefield = new EternalBattlefield();
        this.theGoldenCity = new TheGoldenCity();
        this.blackwaterPort = new BlackwaterPort();
        this.frostbitePeaks = new FrostbitePeaks();
        this.obsidianMines = new ObsidianMines();
        this.theSouthernGrove = new TheSouthernGrove();
        this.barrenWastelands = new BarrenWastelands();
        this.hiddenCityOfLarox = new HiddenCityOfLarox();
        this.lostLands = new LostLands();
        this.theSlimePond = new TheSlimePond();
        this.divineArcheology = new DivineArcheology();
        this.ancientGraveDigging = new AncientGraveDigging();
        this.imperialRescue = new ImperialRescue();
        this.theCultistRebels = new TheCultistRebels();
        this.theLostExpedition = new TheLostExpedition();
        this.theDreadfulAscent = new TheDreadfulAscent();
        this.celestialMothership = new CelestialMothership();
        this.theDireDescent = new TheDireDescent();
        this.sleepingPlanet = new SleepingPlanet();
        this.kaunis = new Kaunis();
        this.theTower = new TheTower();
        this.enchantedForest.setUnlocked(true);
        this.seenItems.add("ScarletStrand");
        this.seenItems.add("Intercession");
        this.seenItems.add("Dreamcatcher");
        this.seenItems.add("UpgradeMarketQueue");
        this.seenItems.add("UpgradeMarketTime");
        this.seenItems.add("UpgradeQuarters");
        this.seenItems.add("UpgradeShelter");
        this.seenItems.add("UpgradeStorage");
        this.seenItems.add("UpgradeTavernCapacity");
        this.seenItems.add("UpgradeTavernTime");
        this.seenItems.add("UpgradeWorkshopQueue");
        this.seenItems.add("UpgradeWorkshopTime");
        this.seenItems.add("Evo23Vial2");
    }

    public int getTutorialStep() {
        return this.tutorialStep;
    }

    public void setTutorialStep(int i) {
        this.tutorialStep = i;
    }

    public long getLastAccess() {
        return this.lastAccess;
    }

    public void setLastAccess(long j) {
        this.lastAccess = j;
    }

    public long getNextTavernVisit() {
        return this.nextTavernVisit;
    }

    public void setNextTavernVisit(long j) {
        this.nextTavernVisit = j;
    }

    public boolean isTavernLocked() {
        return this.tavernLocked;
    }

    public void setTavernLocked(boolean z) {
        this.tavernLocked = z;
    }

    public List<KingMessage> getMessagesToShow() {
        return this.messagesToShow;
    }

    public void setMessagesToShow(List<KingMessage> list) {
        this.messagesToShow = list;
    }

    public List<KingMessage> getMessagesGotten() {
        return this.messagesGotten;
    }

    public void setMessagesGotten(List<KingMessage> list) {
        this.messagesGotten = list;
    }

    public long getMoney() {
        return this.money;
    }

    public void setMoney(long j) {
        this.money = j;
    }

    public long getGems() {
        return this.gems;
    }

    public void setGems(long j) {
        this.gems = j;
    }

    public int getLevelQuarters() {
        return this.levelQuarters;
    }

    public void setLevelQuarters(int i) {
        this.levelQuarters = i;
    }

    public int getLevelTavernCapacity() {
        return this.levelTavernCapacity;
    }

    public void setLevelTavernCapacity(int i) {
        this.levelTavernCapacity = i;
    }

    public int getLevelTavernTime() {
        return this.levelTavernTime;
    }

    public void setLevelTavernTime(int i) {
        this.levelTavernTime = i;
    }

    public int getLevelStorage() {
        return this.levelStorage;
    }

    public void setLevelStorage(int i) {
        this.levelStorage = i;
    }

    public int getLevelMarketListings() {
        return this.levelMarketListings;
    }

    public void setLevelMarketListings(int i) {
        this.levelMarketListings = i;
    }

    public int getLevelMarketTime() {
        return this.levelMarketTime;
    }

    public void setLevelMarketTime(int i) {
        this.levelMarketTime = i;
    }

    public int getLevelWorkshopQueue() {
        return this.levelWorkshopQueue;
    }

    public void setLevelWorkshopQueue(int i) {
        this.levelWorkshopQueue = i;
    }

    public int getLevelWorkshopTime() {
        return this.levelWorkshopTime;
    }

    public void setLevelWorkshopTime(int i) {
        this.levelWorkshopTime = i;
    }

    public int getLevelShelter() {
        return this.levelShelter;
    }

    public void setLevelShelter(int i) {
        this.levelShelter = i;
    }

    public int getLevelShelterAutofeed() {
        return this.levelShelterAutofeed;
    }

    public void setLevelShelterAutofeed(int i) {
        this.levelShelterAutofeed = i;
    }

    public int getUpgradeMarketQueue() {
        return this.upgradeMarketQueue;
    }

    public void setUpgradeMarketQueue(int i) {
        this.upgradeMarketQueue = i;
    }

    public int getUpgradeMarketTime() {
        return this.upgradeMarketTime;
    }

    public void setUpgradeMarketTime(int i) {
        this.upgradeMarketTime = i;
    }

    public int getUpgradeQuarters() {
        return this.upgradeQuarters;
    }

    public void setUpgradeQuarters(int i) {
        this.upgradeQuarters = i;
    }

    public int getUpgradeShelter() {
        return this.upgradeShelter;
    }

    public void setUpgradeShelter(int i) {
        this.upgradeShelter = i;
    }

    public int getUpgradeStorage() {
        return this.upgradeStorage;
    }

    public void setUpgradeStorage(int i) {
        this.upgradeStorage = i;
    }

    public int getUpgradeTavernCapacity() {
        return this.upgradeTavernCapacity;
    }

    public void setUpgradeTavernCapacity(int i) {
        this.upgradeTavernCapacity = i;
    }

    public int getUpgradeTavernTime() {
        return this.upgradeTavernTime;
    }

    public void setUpgradeTavernTime(int i) {
        this.upgradeTavernTime = i;
    }

    public int getUpgradeWorkshopQueue() {
        return this.upgradeWorkshopQueue;
    }

    public void setUpgradeWorkshopQueue(int i) {
        this.upgradeWorkshopQueue = i;
    }

    public int getUpgradeWorkshopTime() {
        return this.upgradeWorkshopTime;
    }

    public void setUpgradeWorkshopTime(int i) {
        this.upgradeWorkshopTime = i;
    }

    public List<Adventurer> getAdventurers() {
        return this.adventurers;
    }

    public void setAdventurers(List<Adventurer> list) {
        this.adventurers = list;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> list) {
        this.items = list;
    }

    public Set<String> getSeenItems() {
        return this.seenItems;
    }

    public void setSeenItems(Set<String> set) {
        this.seenItems = set;
    }

    public Set<String> getSeenEnemies() {
        return this.seenEnemies;
    }

    public void setSeenEnemies(Set<String> set) {
        this.seenEnemies = set;
    }

    public Set<Recipes> getKnownRecipes() {
        return this.knownRecipes;
    }

    public void setKnownRecipes(Set<Recipes> set) {
        this.knownRecipes = set;
    }

    public Set<String> getUniqueItemsLost() {
        return this.uniqueItemsLost;
    }

    public void setUniqueItemsLost(Set<String> set) {
        this.uniqueItemsLost = set;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setPets(List<Pet> list) {
        this.pets = list;
    }

    public List<Adventurer> getTavernGuests() {
        return this.tavernGuests;
    }

    public void setTavernGuests(List<Adventurer> list) {
        this.tavernGuests = list;
    }

    public List<Adventurer> getDismissedAdventurers() {
        return this.dismissedAdventurers;
    }

    public void setDismissedAdventurers(List<Adventurer> list) {
        this.dismissedAdventurers = list;
    }

    public List<ItemAction> getSoldMarketItems() {
        return this.soldMarketItems;
    }

    public void setSoldMarketItems(List<ItemAction> list) {
        this.soldMarketItems = list;
    }

    public List<ItemAction> getMarketListings() {
        return this.marketListings;
    }

    public void setMarketListings(List<ItemAction> list) {
        this.marketListings = list;
    }

    public List<ItemAction> getCompletedWorkshopItems() {
        return this.completedWorkshopItems;
    }

    public void setCompletedWorkshopItems(List<ItemAction> list) {
        this.completedWorkshopItems = list;
    }

    public List<ItemAction> getWorkshopQueue() {
        return this.workshopQueue;
    }

    public void setWorkshopQueue(List<ItemAction> list) {
        this.workshopQueue = list;
    }

    public List<MerchantOffer> getMerchantRegularStockItems() {
        return this.merchantRegularStockItems;
    }

    public void setMerchantRegularStockItems(List<MerchantOffer> list) {
        this.merchantRegularStockItems = list;
    }

    public List<MerchantOffer> getMerchantSpecialReserve() {
        return this.merchantSpecialReserve;
    }

    public void setMerchantSpecialReserve(List<MerchantOffer> list) {
        this.merchantSpecialReserve = list;
    }

    public boolean isNewMerchantRegularItems() {
        return this.newMerchantRegularItems;
    }

    public void setNewMerchantRegularItems(boolean z) {
        this.newMerchantRegularItems = z;
    }

    public boolean isNewMerchantSpecialItems() {
        return this.newMerchantSpecialItems;
    }

    public void setNewMerchantSpecialItems(boolean z) {
        this.newMerchantSpecialItems = z;
    }

    public long getLastHourTriggered() {
        return this.lastHourTriggered;
    }

    public void setLastHourTriggered(long j) {
        this.lastHourTriggered = j;
    }

    public long getLast24Triggered() {
        return this.last24Triggered;
    }

    public void setLast24Triggered(long j) {
        this.last24Triggered = j;
    }

    public long getLastWeekTriggered() {
        return this.lastWeekTriggered;
    }

    public void setLastWeekTriggered(long j) {
        this.lastWeekTriggered = j;
    }

    public boolean isQuestsSeen() {
        return this.questsSeen;
    }

    public void setQuestsSeen(boolean z) {
        this.questsSeen = z;
    }

    public boolean isQuestsRefreshed() {
        return this.questsRefreshed;
    }

    public void setQuestsRefreshed(boolean z) {
        this.questsRefreshed = z;
    }

    public List<Quest> getKingsQuests() {
        return this.kingsQuests;
    }

    public void setKingsQuests(List<Quest> list) {
        this.kingsQuests = list;
    }

    public List<Quest> getAfflictionQuests() {
        return this.afflictionQuests;
    }

    public void setAfflictionQuests(List<Quest> list) {
        this.afflictionQuests = list;
    }

    public List<Quest> getControlQuests() {
        return this.controlQuests;
    }

    public void setControlQuests(List<Quest> list) {
        this.controlQuests = list;
    }

    public List<Quest> getFortitudeQuests() {
        return this.fortitudeQuests;
    }

    public void setFortitudeQuests(List<Quest> list) {
        this.fortitudeQuests = list;
    }

    public List<Quest> getGraceQuests() {
        return this.graceQuests;
    }

    public void setGraceQuests(List<Quest> list) {
        this.graceQuests = list;
    }

    public List<Quest> getIllusionQuests() {
        return this.illusionQuests;
    }

    public void setIllusionQuests(List<Quest> list) {
        this.illusionQuests = list;
    }

    public List<Quest> getKnowledgeQuests() {
        return this.knowledgeQuests;
    }

    public void setKnowledgeQuests(List<Quest> list) {
        this.knowledgeQuests = list;
    }

    public List<Quest> getRuinQuests() {
        return this.ruinQuests;
    }

    public void setRuinQuests(List<Quest> list) {
        this.ruinQuests = list;
    }

    public List<Quest> getWarQuests() {
        return this.warQuests;
    }

    public void setWarQuests(List<Quest> list) {
        this.warQuests = list;
    }

    public int getAfflictionLevel() {
        return this.afflictionLevel;
    }

    public void setAfflictionLevel(int i) {
        this.afflictionLevel = i;
    }

    public int getControlLevel() {
        return this.controlLevel;
    }

    public void setControlLevel(int i) {
        this.controlLevel = i;
    }

    public int getFortitudeLevel() {
        return this.fortitudeLevel;
    }

    public void setFortitudeLevel(int i) {
        this.fortitudeLevel = i;
    }

    public int getGraceLevel() {
        return this.graceLevel;
    }

    public void setGraceLevel(int i) {
        this.graceLevel = i;
    }

    public int getIllusionLevel() {
        return this.illusionLevel;
    }

    public void setIllusionLevel(int i) {
        this.illusionLevel = i;
    }

    public int getKnowledgeLevel() {
        return this.knowledgeLevel;
    }

    public void setKnowledgeLevel(int i) {
        this.knowledgeLevel = i;
    }

    public int getRuinLevel() {
        return this.ruinLevel;
    }

    public void setRuinLevel(int i) {
        this.ruinLevel = i;
    }

    public int getWarLevel() {
        return this.warLevel;
    }

    public void setWarLevel(int i) {
        this.warLevel = i;
    }

    public int getAfflictionProgress() {
        return this.afflictionProgress;
    }

    public void setAfflictionProgress(int i) {
        this.afflictionProgress = i;
    }

    public int getControlProgress() {
        return this.controlProgress;
    }

    public void setControlProgress(int i) {
        this.controlProgress = i;
    }

    public int getFortitudeProgress() {
        return this.fortitudeProgress;
    }

    public void setFortitudeProgress(int i) {
        this.fortitudeProgress = i;
    }

    public int getGraceProgress() {
        return this.graceProgress;
    }

    public void setGraceProgress(int i) {
        this.graceProgress = i;
    }

    public int getIllusionProgress() {
        return this.illusionProgress;
    }

    public void setIllusionProgress(int i) {
        this.illusionProgress = i;
    }

    public int getKnowledgeProgress() {
        return this.knowledgeProgress;
    }

    public void setKnowledgeProgress(int i) {
        this.knowledgeProgress = i;
    }

    public int getRuinProgress() {
        return this.ruinProgress;
    }

    public void setRuinProgress(int i) {
        this.ruinProgress = i;
    }

    public int getWarProgress() {
        return this.warProgress;
    }

    public void setWarProgress(int i) {
        this.warProgress = i;
    }

    public int getAdsWatched() {
        return this.adsWatched;
    }

    public void setAdsWatched(int i) {
        this.adsWatched = i;
    }

    public boolean isShownDialogRaid() {
        return this.shownDialogRaid;
    }

    public void setShownDialogRaid(boolean z) {
        this.shownDialogRaid = z;
    }

    public boolean isShownDialogEpicRaid() {
        return this.shownDialogEpicRaid;
    }

    public void setShownDialogEpicRaid(boolean z) {
        this.shownDialogEpicRaid = z;
    }

    public String getSettingsLanguage() {
        return this.settingsLanguage;
    }

    public void setSettingsLanguage(String str) {
        this.settingsLanguage = str;
    }

    public boolean isSettingSellMaxAmount() {
        return this.settingSellMaxAmount;
    }

    public void setSettingSellMaxAmount(boolean z) {
        this.settingSellMaxAmount = z;
    }

    public boolean isSettingCraftMaxAmount() {
        return this.settingCraftMaxAmount;
    }

    public void setSettingCraftMaxAmount(boolean z) {
        this.settingCraftMaxAmount = z;
    }

    public boolean isSettingConfirmUpgrade() {
        return this.settingConfirmUpgrade;
    }

    public void setSettingConfirmUpgrade(boolean z) {
        this.settingConfirmUpgrade = z;
    }

    public boolean isSettingConfirmRetreat() {
        return this.settingConfirmRetreat;
    }

    public void setSettingConfirmRetreat(boolean z) {
        this.settingConfirmRetreat = z;
    }

    public boolean isSettingConfirmSwap() {
        return this.settingConfirmSwap;
    }

    public void setSettingConfirmSwap(boolean z) {
        this.settingConfirmSwap = z;
    }

    public boolean isSettingAutoOpenDungeonDetail() {
        return this.settingAutoOpenDungeonDetail;
    }

    public void setSettingAutoOpenDungeonDetail(boolean z) {
        this.settingAutoOpenDungeonDetail = z;
    }

    public boolean isSettingVerboseLogs() {
        return this.settingVerboseLogs;
    }

    public void setSettingVerboseLogs(boolean z) {
        this.settingVerboseLogs = z;
    }

    public boolean isSettingColorblindMode() {
        return this.settingColorblindMode;
    }

    public void setSettingColorblindMode(boolean z) {
        this.settingColorblindMode = z;
    }

    public boolean isStarterPackPurchased() {
        return this.starterPackPurchased;
    }

    public void setStarterPackPurchased(boolean z) {
        this.starterPackPurchased = z;
    }

    public boolean isAdventurerPackPurchased() {
        return this.adventurerPackPurchased;
    }

    public void setAdventurerPackPurchased(boolean z) {
        this.adventurerPackPurchased = z;
    }

    public boolean isMerchantPackPurchased() {
        return this.merchantPackPurchased;
    }

    public void setMerchantPackPurchased(boolean z) {
        this.merchantPackPurchased = z;
    }

    public boolean isImperialVanguardPurchased() {
        return this.imperialVanguardPurchased;
    }

    public void setImperialVanguardPurchased(boolean z) {
        this.imperialVanguardPurchased = z;
    }

    public boolean isUnholyCrusadePurchased() {
        return this.unholyCrusadePurchased;
    }

    public void setUnholyCrusadePurchased(boolean z) {
        this.unholyCrusadePurchased = z;
    }

    public int getAmountOfPurchases() {
        return this.amountOfPurchases;
    }

    public void setAmountOfPurchases(int i) {
        this.amountOfPurchases = i;
    }

    public long getTotalGemsPurchased() {
        return this.totalGemsPurchased;
    }

    public void setTotalGemsPurchased(long j) {
        this.totalGemsPurchased = j;
    }

    public boolean isReviewTrigger() {
        return this.reviewTrigger;
    }

    public void setReviewTrigger(boolean z) {
        this.reviewTrigger = z;
    }

    public boolean isReviewShown() {
        return this.reviewShown;
    }

    public void setReviewShown(boolean z) {
        this.reviewShown = z;
    }

    public int getMaxAdventurerTier() {
        return this.maxAdventurerTier;
    }

    public void setMaxAdventurerTier(int i) {
        this.maxAdventurerTier = i;
    }

    public long getItemsCrafted() {
        return this.itemsCrafted;
    }

    public void setItemsCrafted(long j) {
        this.itemsCrafted = j;
    }

    public long getItemsSold() {
        return this.itemsSold;
    }

    public void setItemsSold(long j) {
        this.itemsSold = j;
    }

    public int getMaxAdventurersOwned() {
        return this.maxAdventurersOwned;
    }

    public void setMaxAdventurersOwned(int i) {
        this.maxAdventurersOwned = i;
    }

    public boolean isT4Pet() {
        return this.t4Pet;
    }

    public void setT4Pet(boolean z) {
        this.t4Pet = z;
    }

    public boolean isEverAscended() {
        return this.everAscended;
    }

    public void setEverAscended(boolean z) {
        this.everAscended = z;
    }

    public int getQuestsCompleted() {
        return this.questsCompleted;
    }

    public void setQuestsCompleted(int i) {
        this.questsCompleted = i;
    }

    public boolean isDoctrineMaxed() {
        return this.doctrineMaxed;
    }

    public void setDoctrineMaxed(boolean z) {
        this.doctrineMaxed = z;
    }

    public boolean isPotsMaxed() {
        return this.potsMaxed;
    }

    public void setPotsMaxed(boolean z) {
        this.potsMaxed = z;
    }

    public long getMaxWealth() {
        return this.maxWealth;
    }

    public void setMaxWealth(long j) {
        this.maxWealth = j;
    }

    public EnchantedForest getEnchantedForest() {
        return this.enchantedForest;
    }

    public void setEnchantedForest(EnchantedForest enchantedForest) {
        this.enchantedForest = enchantedForest;
    }

    public TheDesert getTheDesert() {
        return this.theDesert;
    }

    public void setTheDesert(TheDesert theDesert) {
        this.theDesert = theDesert;
    }

    public EternalBattlefield getEternalBattlefield() {
        return this.eternalBattlefield;
    }

    public void setEternalBattlefield(EternalBattlefield eternalBattlefield) {
        this.eternalBattlefield = eternalBattlefield;
    }

    public TheGoldenCity getTheGoldenCity() {
        return this.theGoldenCity;
    }

    public void setTheGoldenCity(TheGoldenCity theGoldenCity) {
        this.theGoldenCity = theGoldenCity;
    }

    public BlackwaterPort getBlackwaterPort() {
        return this.blackwaterPort;
    }

    public void setBlackwaterPort(BlackwaterPort blackwaterPort) {
        this.blackwaterPort = blackwaterPort;
    }

    public FrostbitePeaks getFrostbitePeaks() {
        return this.frostbitePeaks;
    }

    public void setFrostbitePeaks(FrostbitePeaks frostbitePeaks) {
        this.frostbitePeaks = frostbitePeaks;
    }

    public ObsidianMines getObsidianMines() {
        return this.obsidianMines;
    }

    public void setObsidianMines(ObsidianMines obsidianMines) {
        this.obsidianMines = obsidianMines;
    }

    public TheSouthernGrove getTheSouthernGrove() {
        return this.theSouthernGrove;
    }

    public void setTheSouthernGrove(TheSouthernGrove theSouthernGrove) {
        this.theSouthernGrove = theSouthernGrove;
    }

    public BarrenWastelands getBarrenWastelands() {
        return this.barrenWastelands;
    }

    public void setBarrenWastelands(BarrenWastelands barrenWastelands) {
        this.barrenWastelands = barrenWastelands;
    }

    public HiddenCityOfLarox getHiddenCityOfLarox() {
        return this.hiddenCityOfLarox;
    }

    public void setHiddenCityOfLarox(HiddenCityOfLarox hiddenCityOfLarox) {
        this.hiddenCityOfLarox = hiddenCityOfLarox;
    }

    public LostLands getLostLands() {
        return this.lostLands;
    }

    public void setLostLands(LostLands lostLands) {
        this.lostLands = lostLands;
    }

    public TheSlimePond getTheSlimePond() {
        return this.theSlimePond;
    }

    public void setTheSlimePond(TheSlimePond theSlimePond) {
        this.theSlimePond = theSlimePond;
    }

    public DivineArcheology getDivineArcheology() {
        return this.divineArcheology;
    }

    public void setDivineArcheology(DivineArcheology divineArcheology) {
        this.divineArcheology = divineArcheology;
    }

    public AncientGraveDigging getAncientGraveDigging() {
        return this.ancientGraveDigging;
    }

    public void setAncientGraveDigging(AncientGraveDigging ancientGraveDigging) {
        this.ancientGraveDigging = ancientGraveDigging;
    }

    public ImperialRescue getImperialRescue() {
        return this.imperialRescue;
    }

    public void setImperialRescue(ImperialRescue imperialRescue) {
        this.imperialRescue = imperialRescue;
    }

    public TheCultistRebels getTheCultistRebels() {
        return this.theCultistRebels;
    }

    public void setTheCultistRebels(TheCultistRebels theCultistRebels) {
        this.theCultistRebels = theCultistRebels;
    }

    public TheLostExpedition getTheLostExpedition() {
        return this.theLostExpedition;
    }

    public void setTheLostExpedition(TheLostExpedition theLostExpedition) {
        this.theLostExpedition = theLostExpedition;
    }

    public TheDreadfulAscent getTheDreadfulAscent() {
        return this.theDreadfulAscent;
    }

    public void setTheDreadfulAscent(TheDreadfulAscent theDreadfulAscent) {
        this.theDreadfulAscent = theDreadfulAscent;
    }

    public CelestialMothership getCelestialMothership() {
        return this.celestialMothership;
    }

    public void setCelestialMothership(CelestialMothership celestialMothership) {
        this.celestialMothership = celestialMothership;
    }

    public TheDireDescent getTheDireDescent() {
        return this.theDireDescent;
    }

    public void setTheDireDescent(TheDireDescent theDireDescent) {
        this.theDireDescent = theDireDescent;
    }

    public SleepingPlanet getSleepingPlanet() {
        return this.sleepingPlanet;
    }

    public void setSleepingPlanet(SleepingPlanet sleepingPlanet) {
        this.sleepingPlanet = sleepingPlanet;
    }

    public Kaunis getKaunis() {
        return this.kaunis;
    }

    public void setKaunis(Kaunis kaunis) {
        this.kaunis = kaunis;
    }

    public TheTower getTheTower() {
        return this.theTower;
    }

    public void setTheTower(TheTower theTower) {
        this.theTower = theTower;
    }

    public boolean isRedeemed_f8hf3045() {
        return this.redeemed_f8hf3045;
    }

    public void setRedeemed_f8hf3045(boolean z) {
        this.redeemed_f8hf3045 = z;
    }

    public boolean isRedeemed_g294ps91() {
        return this.redeemed_g294ps91;
    }

    public void setRedeemed_g294ps91(boolean z) {
        this.redeemed_g294ps91 = z;
    }

    public boolean isRedeemed_fj9rf8hh() {
        return this.redeemed_fj9rf8hh;
    }

    public void setRedeemed_fj9rf8hh(boolean z) {
        this.redeemed_fj9rf8hh = z;
    }

    public boolean isRedeemed_vre8983y() {
        return this.redeemed_vre8983y;
    }

    public void setRedeemed_vre8983y(boolean z) {
        this.redeemed_vre8983y = z;
    }

    public boolean isRedeemed_vrw74ync() {
        return this.redeemed_vrw74ync;
    }

    public void setRedeemed_vrw74ync(boolean z) {
        this.redeemed_vrw74ync = z;
    }

    public boolean isRedeem_potionsRefund1() {
        return this.redeem_potionsRefund1;
    }

    public void setRedeem_potionsRefund1(boolean z) {
        this.redeem_potionsRefund1 = z;
    }

    public boolean isRedeem_f1r39h15() {
        return this.redeem_f1r39h15;
    }

    public void setRedeem_f1r39h15(boolean z) {
        this.redeem_f1r39h15 = z;
    }

    public int getRedeem_m975nfu5() {
        return this.redeem_m975nfu5;
    }

    public void setRedeem_m975nfu5(int i) {
        this.redeem_m975nfu5 = i;
    }

    public boolean isRedeemed_e44opo7z() {
        return this.redeemed_e44opo7z;
    }

    public void setRedeemed_e44opo7z(boolean z) {
        this.redeemed_e44opo7z = z;
    }

    public boolean isIntercessionsRetroactivelyGranted() {
        return this.intercessionsRetroactivelyGranted;
    }

    public void setIntercessionsRetroactivelyGranted(boolean z) {
        this.intercessionsRetroactivelyGranted = z;
    }

    public boolean isVial2RetGrant() {
        return this.vial2RetGrant;
    }

    public void setVial2RetGrant(boolean z) {
        this.vial2RetGrant = z;
    }

    public boolean isRedeem_g73mfkf4() {
        return this.redeem_g73mfkf4;
    }

    public void setRedeem_g73mfkf4(boolean z) {
        this.redeem_g73mfkf4 = z;
    }
}
