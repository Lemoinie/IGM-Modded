package it.paranoidsquirrels.idleguildmaster;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.work.WorkRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import it.paranoidsquirrels.idleguildmaster.storage.FileManager;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public static final long ONE_DAY_IN_MILLISECONDS = 86400000;
    public static final int ONE_DAY_IN_SECONDS = 86400;
    public static final long ONE_HOUR_IN_MILLISECONDS = 3600000;
    public static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final double PET_ABILITY_INDIVIDUAL_PROBABILITY = 0.07692307692307693d;
    private static final double POTION_INDIVIDUAL_PROBABILITY = 0.09090909090909091d;
    private static final double SPECIAL_FOOD_INDIVIDUAL_PROBABILITY = 0.16666666666666666d;
    private static final double TRAIT_COMMON_INDIVIDUAL_PROBABILITY = 0.13333333333333333d;
    private static final double TRAIT_RARE_INDIVIDUAL_PROBABILITY = 0.014285714285714287d;
    private static List<Area> dungeonsList;
    private static List<Area> dungeonsRaidsList;
    private static List<Area> raidsList;
    private static SplittableRandom randomGenerator = new SplittableRandom();
    private static final Comparator<Entity> fightPriorityComparator = new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda6
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Utils.lambda$static$0((Entity) obj, (Entity) obj2);
        }
    };
    public static final Comparator<Item> itemsByTypeComparator = new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda7
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Utils.lambda$static$1((Item) obj, (Item) obj2);
        }
    };
    public static final Comparator<Recipes> recipesByTypeComparator = new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda8
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Utils.lambda$static$2((Recipes) obj, (Recipes) obj2);
        }
    };
    public static final Comparator<Pet> petsComparator = new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda9
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Utils.lambda$static$3((Pet) obj, (Pet) obj2);
        }
    };
    static int checks = 60;
    static boolean firstRunTriggered = false;

    static /* synthetic */ void lambda$showReviewCard$6(Task task) {
    }

    public static int round(double d) {
        return (int) (d + 1.0E-4d);
    }

    static /* synthetic */ int lambda$static$0(Entity entity, Entity entity2) {
        if (entity.isInitiative() != entity2.isInitiative()) {
            return entity.isInitiative() ? -1 : 1;
        }
        return entity2.calculateTotalDexterity() - entity.calculateTotalDexterity();
    }

    static /* synthetic */ int lambda$static$1(Item item, Item item2) {
        int iTypeToPriority = typeToPriority(item) - typeToPriority(item2);
        if (iTypeToPriority != 0) {
            return iTypeToPriority;
        }
        if (item.getPrice() != item2.getPrice()) {
            return item2.getPrice() > item.getPrice() ? -1 : 1;
        }
        return 0;
    }

    static /* synthetic */ int lambda$static$2(Recipes recipes, Recipes recipes2) {
        int iTypeToPriority = typeToPriority(recipes.getResult()) - typeToPriority(recipes2.getResult());
        if (iTypeToPriority != 0) {
            return iTypeToPriority;
        }
        if (recipes.getResult().getPrice() != recipes2.getResult().getPrice()) {
            return recipes2.getResult().getPrice() > recipes.getResult().getPrice() ? -1 : 1;
        }
        return 0;
    }

    static /* synthetic */ int lambda$static$3(Pet pet, Pet pet2) {
        if (pet.isFavourite() != pet2.isFavourite()) {
            return pet.isFavourite() ? -1 : 1;
        }
        return pet2.getLevel() - pet.getLevel();
    }

    private static int typeToPriority(Item item) {
        try {
            if (item instanceof Sword) {
                return 1;
            }
            if (item instanceof Bow) {
                return 2;
            }
            if (item instanceof Dagger) {
                return 3;
            }
            if (item instanceof Staff) {
                return 4;
            }
            if (item instanceof LightArmor) {
                return 5;
            }
            if (item instanceof MediumArmor) {
                return 6;
            }
            if (item instanceof HeavyArmor) {
                return 7;
            }
            if (item instanceof Accessory) {
                return 8;
            }
            if (item instanceof Potion) {
                return 9;
            }
            if (item instanceof Egg) {
                return 10;
            }
            if (item instanceof Food) {
                return 11;
            }
        } catch (Exception unused) {
        }
        return 13;
    }

    public static double random() {
        return randomGenerator.nextDouble();
    }

    public static void newTavernVisitor() {
        Adventurer adventurer;
        int tutorialStep = MainActivity.data.getTutorialStep();
        if (tutorialStep <= 1) {
            adventurer = Adventurer.getInstance("Footman", -1, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        } else if (tutorialStep == 6) {
            adventurer = Adventurer.getInstance("LightDisciple", -1, 1, 0, null, null, null, Trait.BOOKWORM, null, new PotionsDrank(), null, false);
        } else if (tutorialStep == 7) {
            adventurer = Adventurer.getInstance("Archer", -1, 1, 0, null, null, null, Trait.FERAL, null, new PotionsDrank(), null, false);
            MainActivity.data.setTutorialStep(8);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_GUILD_MANAGEMENT_101);
        } else {
            adventurer = Adventurer.getInstance(rollClass(), -1, 1, 0, null, null, null, rollCommonTrait(), rollRareTrait(), new PotionsDrank(), null, false);
        }
        adventurer.setWeapon(getDefaultWeapon(adventurer.getWeaponType()));
        MainActivity.data.getTavernGuests().add(0, adventurer);
        if (MainActivity.data.getTavernGuests().size() > Formulas.getTavernCapacity()) {
            MainActivity.data.getTavernGuests().remove(MainActivity.data.getTavernGuests().size() - 1);
        }
    }

    private static String rollClass() {
        double dRandom = random();
        if (dRandom < 0.25d) {
            return "Footman";
        }
        if (dRandom < 0.5d) {
            return "Rogue";
        }
        return dRandom < 0.75d ? "Archer" : "Apprentice";
    }

    private static Trait rollCommonTrait() {
        double dRandom = random();
        if (dRandom < TRAIT_COMMON_INDIVIDUAL_PROBABILITY) {
            return Trait.BOOKWORM;
        }
        if (dRandom < 0.26666666666666666d) {
            return Trait.BRUTE;
        }
        if (dRandom < 0.4d) {
            return Trait.FERAL;
        }
        return null;
    }

    private static Trait rollRareTrait() {
        double dRandom = random();
        if (dRandom < TRAIT_RARE_INDIVIDUAL_PROBABILITY) {
            return Trait.EMPATHETIC;
        }
        if (dRandom < 0.028571428571428574d) {
            return Trait.GIFTED;
        }
        if (dRandom < 0.04285714285714286d) {
            return Trait.INTIMIDATING;
        }
        if (dRandom < 0.05714285714285715d) {
            return Trait.FOCUSED;
        }
        if (dRandom < 0.07142857142857144d) {
            return Trait.DRAGON_BLOOD;
        }
        if (dRandom < 0.08571428571428572d) {
            return Trait.CURSED;
        }
        if (dRandom < 0.1d) {
            return Trait.REACTIVE;
        }
        if (dRandom < 0.1142857142857143d) {
            return Trait.NOCTURNAL;
        }
        if (dRandom < 0.1285714285714286d) {
            return Trait.MINDFUL;
        }
        if (dRandom < 0.14285714285714288d) {
            return Trait.TROLL_BLOOD;
        }
        if (dRandom < 0.15714285714285717d) {
            return Trait.RUTHLESS;
        }
        if (dRandom < 0.17142857142857143d) {
            return Trait.BLESSED;
        }
        if (dRandom < 0.18571428571428572d) {
            return Trait.ALERT;
        }
        if (dRandom < 0.2d) {
            return Trait.NIMBLE;
        }
        return null;
    }

    public static PetAbility rollPetAbility(List<PetAbility> list) {
        PetAbility petAbility = null;
        while (true) {
            if (petAbility != null && !list.contains(petAbility)) {
                return petAbility;
            }
            double dRandom = random();
            if (dRandom < PET_ABILITY_INDIVIDUAL_PROBABILITY) {
                petAbility = PetAbility.FIGHTER;
            } else if (dRandom < 0.15384615384615385d) {
                petAbility = PetAbility.HEALER;
            } else if (dRandom < 0.23076923076923078d) {
                petAbility = PetAbility.DECOY;
            } else if (dRandom < 0.3076923076923077d) {
                petAbility = PetAbility.OPPORTUNIST;
            } else if (dRandom < 0.38461538461538464d) {
                petAbility = PetAbility.MAGIC;
            } else if (dRandom < 0.46153846153846156d) {
                petAbility = PetAbility.SAVAGE;
            } else if (dRandom < 0.5384615384615385d) {
                petAbility = PetAbility.BRIGHT;
            } else if (dRandom < 0.6153846153846154d) {
                petAbility = PetAbility.EXPERIENCE;
            } else if (dRandom < 0.6923076923076923d) {
                petAbility = PetAbility.DROPS;
            } else if (dRandom < 0.7692307692307693d) {
                petAbility = PetAbility.COUNTERATTACK;
            } else if (dRandom < 0.8461538461538463d) {
                petAbility = PetAbility.LIFESTEAL;
            } else if (dRandom < 0.9230769230769231d) {
                petAbility = PetAbility.REGENERATION;
            } else if (dRandom < 1.0d) {
                petAbility = PetAbility.BARRIER;
            }
        }
    }

    public static MerchantOffer rollPotion() {
        Item item;
        double dRandom = random();
        int i = 80;
        if (dRandom < POTION_INDIVIDUAL_PROBABILITY) {
            item = Item.getInstance("PotionOfConstitution");
        } else if (dRandom < 0.18181818181818182d) {
            item = Item.getInstance("PotionOfDexterity");
        } else if (dRandom < 0.2727272727272727d) {
            item = Item.getInstance("PotionOfIntelligence");
        } else if (dRandom < 0.36363636363636365d) {
            item = Item.getInstance("PotionOfHealth");
        } else if (dRandom < 0.4545454545454546d) {
            item = Item.getInstance("PotionOfDefense");
            i = Logger.STATUS_FEEBLE_TETHER;
        } else if (dRandom < 0.5454545454545454d) {
            item = Item.getInstance("PotionOfMagicDefense");
            i = 100;
        } else if (dRandom < 0.6363636363636364d) {
            item = Item.getInstance("PotionOfPrecision");
        } else if (dRandom < 0.7272727272727273d) {
            item = Item.getInstance("PotionOfViciousness");
        } else if (dRandom < 0.8181818181818182d) {
            item = Item.getInstance("PotionOfDarkness");
        } else if (dRandom < 0.9090909090909092d) {
            item = Item.getInstance("PotionOfImmunity");
            i = 70;
        } else if (dRandom < 1.0d) {
            item = Item.getInstance("PotionOfAgility");
        } else {
            item = null;
            i = 0;
        }
        MerchantOffer merchantOffer = new MerchantOffer(item);
        merchantOffer.setPrice(i);
        merchantOffer.setGems(true);
        return merchantOffer;
    }

    public static List<MerchantOffer> rollSpecialFoods() {
        int i;
        Item item;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            MerchantOffer merchantOffer = null;
            while (merchantOffer == null || arrayList.contains(merchantOffer)) {
                    double dRandom = random();
                    if (dRandom < SPECIAL_FOOD_INDIVIDUAL_PROBABILITY) {
                        item = Item.getInstance("GlazedDonut");
                        i = 50;
                    } else if (dRandom < 0.3333333333333333d) {
                        item = Item.getInstance("GourmetIcecream");
                        i = 100;
                    } else if (dRandom < 0.5d) {
                        item = Item.getInstance("Maxxiburger");
                        i = 200;
                    } else if (dRandom < 0.6666666666666666d) {
                        item = Item.getInstance("Cheesecake");
                        i = 400;
                    } else if (dRandom < 0.8333333333333333d) {
                        item = Item.getInstance("Ambrosia");
                        i = 800;
                    } else if (dRandom < 1.0d) {
                        item = Item.getInstance("CeremonialCake");
                        i = 1500;
                    } else {
                        i = 0;
                        item = null;
                    }
                    MerchantOffer merchantOffer2 = new MerchantOffer(item);
                    merchantOffer2.setPrice(i);
                    merchantOffer2.setGems(true);
                    merchantOffer = merchantOffer2;
            }
            arrayList.add(merchantOffer);
        }
        arrayList.sort(Comparator.comparingInt(new ToIntFunction() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda2
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Food) ((MerchantOffer) obj).getItem()).getFeedPower();
            }
        }));
        return arrayList;
    }

    public static List<MerchantOffer> rollUpgrades() {
        ArrayList arrayList = new ArrayList();
        if (MainActivity.data.getUpgradeMarketQueue() < 1) {
            arrayList.add(Item.getInstance("UpgradeMarketQueue"));
        }
        if (MainActivity.data.getUpgradeMarketTime() < 2) {
            arrayList.add(Item.getInstance("UpgradeMarketTime"));
        }
        if (MainActivity.data.getUpgradeQuarters() < 1) {
            arrayList.add(Item.getInstance("UpgradeQuarters"));
        }
        if (MainActivity.data.getUpgradeShelter() < 1) {
            arrayList.add(Item.getInstance("UpgradeShelter"));
        }
        if (MainActivity.data.getUpgradeStorage() < 10) {
            arrayList.add(Item.getInstance("UpgradeStorage"));
        }
        if (MainActivity.data.getUpgradeTavernCapacity() < 1) {
            arrayList.add(Item.getInstance("UpgradeTavernCapacity"));
        }
        if (MainActivity.data.getUpgradeTavernTime() < 2) {
            arrayList.add(Item.getInstance("UpgradeTavernTime"));
        }
        if (MainActivity.data.getUpgradeWorkshopQueue() < 1) {
            arrayList.add(Item.getInstance("UpgradeWorkshopQueue"));
        }
        if (MainActivity.data.getUpgradeWorkshopTime() < 2) {
            arrayList.add(Item.getInstance("UpgradeWorkshopTime"));
        }
        ArrayList arrayList2 = new ArrayList();
        if (MainActivity.data.getUpgradeStorage() < 6) {
            Item item = Item.getInstance("UpgradeStorage");
            arrayList.remove(item);
            MerchantOffer merchantOffer = new MerchantOffer(item);
            merchantOffer.setPrice(((Upgrade) item).getGemPrice());
            merchantOffer.setGems(true);
            arrayList2.add(merchantOffer);
        }
        while (!arrayList.isEmpty() && arrayList2.size() < 3) {
            Item item2 = (Item) arrayList.get((int) (random() * ((double) arrayList.size())));
            arrayList.remove(item2);
            MerchantOffer merchantOffer2 = new MerchantOffer(item2);
            merchantOffer2.setPrice(((Upgrade) item2).getGemPrice());
            merchantOffer2.setGems(true);
            arrayList2.add(merchantOffer2);
        }
        return arrayList2;
    }

    public static void nextTimeTick() {
        MainActivity.data.setLastAccess(TrueTimeUtils.millis());
        progressTavernTime(1L);
        progressMarketTime(1L);
        progressWorkshopTime(1L);
        tick60();
        Iterator<Area> it2 = compileDungeonRaidList().iterator();
        while (it2.hasNext()) {
            it2.next().tick();
        }
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
        }
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.update();
        }
        if (QuestsManager.QUEST_COMPLETED_RECENTLY && isMainLooper()) {
            QuestsManager.QUEST_COMPLETED_RECENTLY = false;
            QuestsManager.QUEST_NOTIFICATION = true;
            ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshIcons();
            if (MainActivity.shownDialogQuests != null) {
                MainActivity.shownDialogQuests.reInitialize();
            }
        }
    }

    public static void progressTavernTime(long j) {
        if (MainActivity.data.isTavernLocked()) {
            return;
        }
        long tavernVisitorInterval = Formulas.getTavernVisitorInterval() / 1000;
        long j2 = j / tavernVisitorInterval;
        long nextTavernVisit = MainActivity.data.getNextTavernVisit() - (j % tavernVisitorInterval);
        if (nextTavernVisit < 0) {
            nextTavernVisit += tavernVisitorInterval;
            j2++;
        }
        MainActivity.data.setNextTavernVisit(nextTavernVisit);
        long jMin = Math.min(j2, Formulas.getTavernCapacity());
        for (int i = 0; i < jMin; i++) {
            newTavernVisitor();
        }
        if (jMin > 0) {
            if (MainActivity.headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null) {
                MainActivity.headquartersFragment.refresh();
            }
            if (MainActivity.shownDialogTavern != null) {
                MainActivity.shownDialogTavern.refreshAdventurers();
            }
        }
        if (MainActivity.shownDialogTavern != null) {
            MainActivity.shownDialogTavern.refreshProgressBar();
        }
    }

    public static void progressMarketTime(long j) {
        ArrayList<ItemAction> arrayList = new ArrayList();
        for (ItemAction itemAction : MainActivity.data.getMarketListings()) {
            long secondsPassed = itemAction.getSecondsPassed();
            long secondsToSell = itemAction.getItem().getSecondsToSell();
            long jMin = Math.min(j, (1 + secondsToSell) - secondsPassed);
            j -= jMin;
            long j2 = secondsPassed + jMin;
            itemAction.setSecondsPassed(j2);
            if (MainActivity.shownDialogMarket != null) {
                MainActivity.shownDialogMarket.updateCountdown();
            }
            if (j2 > secondsToSell) {
                arrayList.add(itemAction);
            }
            if (j <= 0) {
                break;
            }
        }
        for (ItemAction itemAction2 : arrayList) {
            MainActivity.data.getMarketListings().remove(itemAction2);
            MainActivity.data.getSoldMarketItems().add(MainActivity.data.getSoldMarketItems().size(), itemAction2);
            if (MainActivity.shownDialogMarket != null) {
                MainActivity.shownDialogMarket.completeItem();
            }
        }
        if (MainActivity.headquartersFragment == null || MainActivity.headquartersFragment.getBinding() == null || arrayList.size() <= 0) {
            return;
        }
        MainActivity.headquartersFragment.refresh();
    }

    public static void progressWorkshopTime(long j) {
        ArrayList<ItemAction> arrayList = new ArrayList();
        for (ItemAction itemAction : MainActivity.data.getWorkshopQueue()) {
            long secondsPassed = itemAction.getSecondsPassed();
            long secondsToCraft = itemAction.getItem().getSecondsToCraft();
            long jMin = Math.min(j, (1 + secondsToCraft) - secondsPassed);
            j -= jMin;
            long j2 = secondsPassed + jMin;
            itemAction.setSecondsPassed(j2);
            if (MainActivity.shownDialogWorkshop != null) {
                MainActivity.shownDialogWorkshop.updateCountdown();
            }
            if (j2 > secondsToCraft) {
                arrayList.add(itemAction);
            }
            if (j <= 0) {
                break;
            }
        }
        for (ItemAction itemAction2 : arrayList) {
            MainActivity.data.getWorkshopQueue().remove(itemAction2);
            MainActivity.data.getCompletedWorkshopItems().add(MainActivity.data.getCompletedWorkshopItems().size(), itemAction2);
            if (MainActivity.shownDialogWorkshop != null) {
                MainActivity.shownDialogWorkshop.completeItem();
            }
        }
        if (MainActivity.headquartersFragment == null || MainActivity.headquartersFragment.getBinding() == null || arrayList.size() <= 0) {
            return;
        }
        MainActivity.headquartersFragment.refresh();
    }

    public static void tick60() {
        int i = checks;
        if (i < 60) {
            checks = i + 1;
            return;
        }
        long jMillis = TrueTimeUtils.millis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(jMillis));
        checks = calendar.get(13) - 1;
        checkDismissedAdventurersExpiration(jMillis);
        refreshCooldowns(jMillis);
        if (firstRunTriggered && MainActivity.data.isReviewTrigger() && !MainActivity.data.isReviewShown()) {
            MainActivity.data.setReviewShown(true);
            showReviewCard();
        }
        if (jMillis - MainActivity.data.getLastWeekTriggered() > 604800000) {
            tickWeek(jMillis);
        }
        if (jMillis - MainActivity.data.getLast24Triggered() > ONE_DAY_IN_MILLISECONDS) {
            tick24Hours(jMillis);
        }
        if (jMillis - MainActivity.data.getLastHourTriggered() > ONE_HOUR_IN_MILLISECONDS) {
            tickHour(jMillis);
        }
        firstRunTriggered = true;
    }

    private static void tickHour(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(12, 0);
        calendar.set(13, 0);
        MainActivity.data.setLastHourTriggered(calendar.getTime().getTime());
        FileManager.writeToCloud();
    }

    private static void tick24Hours(long j) {
        Item item;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        MainActivity.data.setLast24Triggered(calendar.getTime().getTime());
        for (Area area : compileRaidList()) {
            int areaType = area.getAreaType();
            if (areaType == 1 || areaType == 2) {
                area.setTriesAvailable(true);
                area.refreshTries();
            }
        }
        MainActivity.data.getMerchantRegularStockItems().clear();
        List<Area> arrayList = new ArrayList(compileDungeonList());
        arrayList.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Utils.lambda$tick24Hours$5((Area) obj);
            }
        });
        if (arrayList.size() > 4) {
            arrayList = arrayList.subList(arrayList.size() - 4, arrayList.size());
        }
        for (Area area2 : arrayList) {
            if (area2.isUnlocked() && (item = (Item) rollFromWeightedMap(area2.rollMerchantRegularOffers())) != null) {
                MerchantOffer merchantOffer = new MerchantOffer(item);
                merchantOffer.setGems(false);
                merchantOffer.setPrice(item.getPrice() * ((long) item.getStack()) * 10);
                MainActivity.data.getMerchantRegularStockItems().add(merchantOffer);
            }
        }
        MainActivity.data.setNewMerchantRegularItems(true);
        ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshIcons();
        if (MainActivity.shownDialogMerchant != null) {
            MainActivity.shownDialogMerchant.newItems();
        }
        MainActivity.data.setAdsWatched(0);
        ((MainActivity) MainActivity.dungeonsFragment.getActivity()).loadAd();
        restoreErroneouslyCompletedEpicRaids();
    }

    static /* synthetic */ boolean lambda$tick24Hours$5(Area area) {
        return !area.isUnlocked();
    }

    private static void tickWeek(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.add(7, -(calendar.get(7) - 1));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        MainActivity.data.setLastWeekTriggered(calendar.getTime().getTime());
        QuestsManager.extractQuests();
        QuestsManager.QUEST_NOTIFICATION = true;
        ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshIcons();
        MainActivity.data.getMerchantSpecialReserve().clear();
        List<Area> listCompileDungeonList = compileDungeonList();
        Area enchantedForest = MainActivity.data.getEnchantedForest();
        int i = 50;
        for (Area area : listCompileDungeonList) {
            if (area.isUnlocked()) {
                i += 5;
                enchantedForest = area;
            }
        }
        Item item = (Item) rollFromWeightedMap(enchantedForest.rollMerchantSpecialOffers());
        if (item != null) {
            MerchantOffer merchantOffer = new MerchantOffer(item);
            merchantOffer.setPrice(i);
            merchantOffer.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add(merchantOffer);
        }
        if (random() < 0.55d) {
            MerchantOffer merchantOffer2 = new MerchantOffer(Item.getInstance("Aegis"));
            merchantOffer2.setPrice(1000L);
            merchantOffer2.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add(merchantOffer2);
        }
        MerchantOffer merchantOffer3 = new MerchantOffer(Item.getInstance("ScarletStrand"));
        merchantOffer3.setPrice(650L);
        merchantOffer3.setGems(true);
        MainActivity.data.getMerchantSpecialReserve().add(merchantOffer3);
        Iterator<String> it2 = listUniqueDropsMissing().iterator();
        while (it2.hasNext()) {
            MerchantOffer merchantOffer4 = new MerchantOffer(Item.getInstance(it2.next()));
            merchantOffer4.setPrice(1L);
            merchantOffer4.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add(merchantOffer4);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            MainActivity.data.getMerchantSpecialReserve().add(rollPotion());
        }
        MainActivity.data.getMerchantSpecialReserve().addAll(rollSpecialFoods());
        MainActivity.data.getMerchantSpecialReserve().addAll(rollUpgrades());
        MainActivity.data.setNewMerchantSpecialItems(true);
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.dismiss();
        }
    }

    private static void showReviewCard() {
        try {
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(MainActivity.headquartersFragment.getContext());
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Utils.lambda$showReviewCard$7(reviewManagerCreate, task);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$showReviewCard$7(ReviewManager reviewManager, Task task) {
        try {
            if (task.isSuccessful()) {
                reviewManager.launchReviewFlow(MainActivity.headquartersFragment.getActivity(), (ReviewInfo) task.getResult()).addOnCompleteListener(new OnCompleteListener() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task2) {
                        Utils.lambda$showReviewCard$6(task2);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    private static void restoreErroneouslyCompletedEpicRaids() {
        boolean z;
        boolean z2 = true;
        if (!MainActivity.data.getCelestialMothership().completed() || MainActivity.data.getSeenItems().contains("Evo23Vial")) {
            z = false;
        } else {
            MainActivity.data.getCelestialMothership().setMaxProgress(1);
            MainActivity.data.getCelestialMothership().getDrops().clear();
            z = true;
        }
        if (MainActivity.data.getImperialRescue().completed() && !MainActivity.data.getSeenItems().contains("SkeletonKey")) {
            MainActivity.data.getImperialRescue().setMaxProgress(1);
            MainActivity.data.getImperialRescue().getDrops().clear();
            z = true;
        }
        if (!MainActivity.data.getDivineArcheology().completed() || MainActivity.data.getSeenItems().contains("DivineZygote")) {
            z2 = z;
        } else {
            MainActivity.data.getDivineArcheology().setMaxProgress(1);
            MainActivity.data.getDivineArcheology().getDrops().clear();
        }
        if (z2) {
            try {
                MainActivity.raidsFragment.refresh();
            } catch (Exception unused) {
            }
        }
    }

    public static void checkDismissedAdventurersExpiration(final long j) {
        try {
            MainActivity.data.getDismissedAdventurers().removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Utils.lambda$checkDismissedAdventurersExpiration$8(j, (Adventurer) obj);
                }
            });
        } catch (UnsupportedOperationException unused) {
        }
    }

    static /* synthetic */ boolean lambda$checkDismissedAdventurersExpiration$8(long j, Adventurer adventurer) {
        return j - adventurer.getTimeWhenDismissed() > 93600000;
    }

    public static void refreshCooldowns(long j) {
        long lastWeekTriggered = (604800000 - (j - MainActivity.data.getLastWeekTriggered())) / 60000;
        int i = (int) (lastWeekTriggered / 1440);
        long j2 = lastWeekTriggered % 1440;
        int i2 = (int) (j2 / 60);
        int i3 = (int) (j2 % 60);
        if (MainActivity.raidsFragment != null && MainActivity.raidsFragment.getBinding() != null) {
            MainActivity.raidsFragment.getBinding().raidRefreshTime.setText(String.format(MainActivity.raidsFragment.getString(R.string.time_hours_minutes), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (MainActivity.shownDialogMerchant != null) {
            MainActivity.shownDialogMerchant.refreshCooldowns(i, i2, i3);
        }
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.refreshCooldowns(i, i2, i3);
        }
    }

    public static Drawable getEquipmentDrawable(Equipment equipment, Context context) {
        return ResourcesCompat.getDrawable(context.getResources(), equipment == null ? R.drawable.empty_equipment : equipment.getIdImage(), context.getTheme());
    }

    public static List<Adventurer> getIdleAdventurers(Integer... numArr) {
        HashSet hashSet = new HashSet(Arrays.asList(numArr));
        Iterator<Area> it2 = compileDungeonRaidList().iterator();
        while (it2.hasNext()) {
            hashSet.addAll(it2.next().getAdventurersExploringIds());
        }
        ArrayList arrayList = new ArrayList();
        for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
            if (!hashSet.contains(Integer.valueOf(adventurer.getId()))) {
                arrayList.add(adventurer);
            }
        }
        return arrayList;
    }

    public static List<Pet> getIdlePets() {
        ArrayList arrayList = new ArrayList();
        for (Area area : compileDungeonRaidList()) {
            if (area.getPetExploringId() != null) {
                arrayList.add(area.getPetExploringId());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Pet pet : MainActivity.data.getPets()) {
            if (!arrayList.contains(Integer.valueOf(pet.getId()))) {
                arrayList2.add(pet);
            }
        }
        return arrayList2;
    }

    public static void collectItem(Item item, List<Item> list) {
        MainActivity.data.getSeenItems().add(item.getTrueClass());
        if (MainActivity.data.getItems().equals(list)) {
            if ("DivineZygote".equals(item.getTrueClass())) {
                MainActivity.data.setReviewTrigger(true);
            }
            Recipes recipesInto = Recipes.into(item);
            if (recipesInto != null) {
                MainActivity.data.getKnownRecipes().add(recipesInto);
            }
            MainActivity.data.getKnownRecipes().addAll(Recipes.from(item));
        }
        if (list.contains(item)) {
            Item item2 = list.get(list.indexOf(item));
            item2.setStack(Math.min(99999, item2.getStack() + item.getStack()));
        } else {
            list.add(Item.getInstance(item.getTrueClass(), Math.min(99999, item.getStack())));
        }
    }

    public static void removeItemFromStorage(Item item) {
        int iIndexOf = MainActivity.data.getItems().indexOf(item);
        if (iIndexOf == -1) {
            return;
        }
        Item item2 = MainActivity.data.getItems().get(iIndexOf);
        item2.setStack(Math.max(0, item2.getStack() - item.getStack()));
        if (item2.getStack() == 0) {
            MainActivity.data.getItems().remove(item2);
        }
    }

    public static void orderByTurnsPriority(List<Entity> list) {
        list.sort(fightPriorityComparator);
    }

    public static int calculateNewAdventurerId() {
        int id = -1;
        for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
            if (adventurer.getId() > id) {
                id = adventurer.getId();
            }
        }
        return id + 1;
    }

    public static int calculateNewPetId() {
        int id = -1;
        for (Pet pet : MainActivity.data.getPets()) {
            if (pet.getId() > id) {
                id = pet.getId();
            }
        }
        return id + 1;
    }

    public static long truncatePrice(long j) {
        long j2;
        if (j <= WorkRequest.MIN_BACKOFF_MILLIS) {
            return j;
        }
        if (j <= 1000000) {
            j2 = j % 100;
        } else {
            j2 = j % WorkRequest.MIN_BACKOFF_MILLIS;
        }
        return j - j2;
    }

    public static boolean gotEnoughItem(Item item) {
        int iIndexOf = MainActivity.data.getItems().indexOf(item);
        return iIndexOf != -1 && MainActivity.data.getItems().get(iIndexOf).getStack() >= item.getStack();
    }

    public static int maxCraftableAmount(Recipes recipes) {
        int iMin = 99999;
        for (Item item : recipes.getIngredients()) {
            int iIndexOf = MainActivity.data.getItems().indexOf(item);
            if (iIndexOf == -1) {
                return 0;
            }
            iMin = Math.min(iMin, MainActivity.data.getItems().get(iIndexOf).getStack() / item.getStack());
        }
        return iMin;
    }

    public static Weapon getDefaultWeapon(int i) {
        if (i == R.string.type_sword) {
            return (Weapon) Item.getInstance("Spade");
        }
        if (i == R.string.type_staff) {
            return (Weapon) Item.getInstance("Cane");
        }
        if (i == R.string.type_dagger) {
            return (Weapon) Item.getInstance("Sickle");
        }
        if (i == R.string.type_bow) {
            return (Weapon) Item.getInstance("TrainingBow");
        }
        return null;
    }

    public static void collectDrops(Fragment fragment, Area area) {
        ArrayList arrayList = new ArrayList();
        for (Pet pet : MainActivity.data.getPets()) {
            if (pet.isFavourite()) {
                arrayList.add(pet);
            }
        }
        int size = arrayList.size();
        int iRemainingInventorySpaceAfterCollecting = remainingInventorySpaceAfterCollecting(size > 0, (Item[]) area.getDrops().toArray(new Item[0]));
        if (iRemainingInventorySpaceAfterCollecting < 0) {
            if (MainActivity.shownDialogFullStorage != null) {
                return;
            }
            MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(fragment.getContext(), Integer.valueOf(R.string.no_storage_space_title), String.format(fragment.getString(R.string.no_storage_space_body_loot), Integer.valueOf(iRemainingInventorySpaceAfterCollecting * (-1))), false);
            MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.Utils$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownDialogFullStorage = null;
                }
            });
            MainActivity.shownDialogFullStorage.show();
            return;
        }
        DialogCollectDrops dialogCollectDrops = new DialogCollectDrops();
        dialogCollectDrops.setCancelable(false);
        dialogCollectDrops.drops = new ArrayList(area.getDrops());
        dialogCollectDrops.sourceArea = fragment.getString(area.getName());
        dialogCollectDrops.recap = area.getAdventureRecap();
        area.setAdventureRecap(new AdventureRecap());
        dialogCollectDrops.show(fragment.getParentFragmentManager(), "dialog_collect_drops");
        int feedPower = 0;
        for (Item item : area.getDrops()) {
            if (size <= 0 || !(item instanceof Food)) {
                collectItem(item, MainActivity.data.getItems());
            } else {
                feedPower += ((Food) item).getFeedPower() * item.getStack();
            }
        }
        if (size > 0) {
            int i = feedPower / size;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Pet) it2.next()).feed(i);
            }
        }
        area.getDrops().clear();
        area.refreshLoot();
        if (area.getAreaType() == 2 && area.completed()) {
            ((RaidsFragment) fragment).refreshRaidVisibility();
            UIUtils.getInfoDialog(fragment.getContext(), Integer.valueOf(R.string.epic_raid_completed_title), String.format(fragment.getString(R.string.epic_raid_completed_body), fragment.getString(area.getName())), false).show();
        }
        MainActivity.headquartersFragment.refresh();
    }

    public static int remainingInventorySpaceAfterCollecting(boolean z, Item... itemArr) {
        int i = 0;
        for (Item item : itemArr) {
            if (!MainActivity.data.getItems().contains(item) && (!z || !(item instanceof Food))) {
                i++;
            }
        }
        return Formulas.storageSpaces() - (i + MainActivity.data.getItems().size());
    }

    public static List<String> listUniqueDropsMissing() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : Arrays.asList("DivineZygote", "DivineEmbryo", "DivineLarvae", "Sha", "EyesOfTheSwordsman", "AmuletOfTheSwordsman", "SkeletonKey", "SerpentStaff", "SerpentLunge", "SerpentBite", "SerpentSting")) {
                if (MainActivity.data.getSeenItems().contains(str)) {
                    arrayList.add(str);
                    Item item = Item.getInstance(str);
                    if (!item.getUniqueOrigin().equals(item.getTrueClass())) {
                        arrayList.remove(item.getUniqueOrigin());
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Item item2 : MainActivity.data.getItems()) {
                if (arrayList.contains(item2.getTrueClass())) {
                    arrayList2.add(item2.getTrueClass());
                }
            }
            for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
                if (adventurer.getWeapon() != null && arrayList.contains(adventurer.getWeapon().getTrueClass())) {
                    arrayList2.add(adventurer.getWeapon().getTrueClass());
                }
                if (adventurer.getArmor() != null && arrayList.contains(adventurer.getArmor().getTrueClass())) {
                    arrayList2.add(adventurer.getArmor().getTrueClass());
                }
                if (adventurer.getAccessory() != null && arrayList.contains(adventurer.getAccessory().getTrueClass())) {
                    arrayList2.add(adventurer.getAccessory().getTrueClass());
                }
            }
            Iterator<Area> it2 = compileRaidList().iterator();
            while (it2.hasNext()) {
                for (Item item3 : it2.next().getDrops()) {
                    if (arrayList.contains(item3.getTrueClass())) {
                        arrayList2.add(item3.getTrueClass());
                    }
                }
            }
            Iterator<ItemAction> it3 = MainActivity.data.getWorkshopQueue().iterator();
            while (it3.hasNext()) {
                Iterator<Item> it4 = Recipes.into(it3.next().getItem()).getIngredients().iterator();
                while (it4.hasNext()) {
                    arrayList2.add(it4.next().getTrueClass());
                }
            }
            Iterator<ItemAction> it5 = MainActivity.data.getCompletedWorkshopItems().iterator();
            while (it5.hasNext()) {
                Iterator<Item> it6 = Recipes.into(it5.next().getItem()).getIngredients().iterator();
                while (it6.hasNext()) {
                    arrayList2.add(it6.next().getTrueClass());
                }
            }
            arrayList.removeAll(arrayList2);
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static boolean gotUniqueDrop(String str, Area area) {
        if (MainActivity.data.getSeenItems().contains(str)) {
            return true;
        }
        Iterator<Item> it2 = area.getDrops().iterator();
        while (it2.hasNext()) {
            if (it2.next().getTrueClass().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T rollFromWeightedMap(Map<T, Integer> map) {
        if (map != null && !map.isEmpty()) {
            double dRandom = random() * 1000.0d;
            int iIntValue = 0;
            for (Map.Entry<T, Integer> entry : map.entrySet()) {
                iIntValue += entry.getValue().intValue();
                if (dRandom < iIntValue) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public static Data getNewestSaveFile(Data data, Data data2) {
        boolean z = data.getLastAccess() - data2.getLastAccess() > 0;
        boolean z2 = calculateAdventurersLevelSum(data) < 6;
        if (z2 == (calculateAdventurersLevelSum(data2) < 6)) {
            return z ? data : data2;
        }
        return z2 ? data2 : data;
    }

    public static int calculateAdventurersLevelSum(Data data) {
        int maxLevel = 0;
        for (Adventurer adventurer : data.getAdventurers()) {
            maxLevel += (((adventurer.getMaxLevel() / 5) - 1) * 5) + adventurer.getLevel();
        }
        for (Adventurer adventurer2 : data.getDismissedAdventurers()) {
            maxLevel += (((adventurer2.getMaxLevel() / 5) - 1) * 5) + adventurer2.getLevel();
        }
        return maxLevel;
    }

    public static List<Area> compileDungeonList() {
        if (dungeonsList == null) {
            dungeonsList = Arrays.asList(MainActivity.data.getEnchantedForest(), MainActivity.data.getTheDesert(), MainActivity.data.getEternalBattlefield(), MainActivity.data.getTheGoldenCity(), MainActivity.data.getBlackwaterPort(), MainActivity.data.getFrostbitePeaks(), MainActivity.data.getObsidianMines(), MainActivity.data.getTheSouthernGrove(), MainActivity.data.getBarrenWastelands(), MainActivity.data.getHiddenCityOfLarox(), MainActivity.data.getLostLands());
        }
        return dungeonsList;
    }

    public static List<Area> compileRaidList() {
        if (raidsList == null) {
            raidsList = Arrays.asList(MainActivity.data.getTheSlimePond(), MainActivity.data.getDivineArcheology(), MainActivity.data.getAncientGraveDigging(), MainActivity.data.getImperialRescue(), MainActivity.data.getTheCultistRebels(), MainActivity.data.getTheDreadfulAscent(), MainActivity.data.getTheLostExpedition(), MainActivity.data.getCelestialMothership(), MainActivity.data.getTheDireDescent(), MainActivity.data.getSleepingPlanet(), MainActivity.data.getKaunis(), MainActivity.data.getTheTower());
        }
        return raidsList;
    }

    public static List<Area> compileDungeonRaidList() {
        if (dungeonsRaidsList == null) {
            ArrayList arrayList = new ArrayList();
            dungeonsRaidsList = arrayList;
            arrayList.addAll(compileDungeonList());
            dungeonsRaidsList.addAll(compileRaidList());
        }
        return dungeonsRaidsList;
    }

    public static String getBaseClass(Adventurer adventurer) {
        if (adventurer.getWeaponType() == R.string.type_bow) {
            return "Archer";
        }
        if (adventurer.getWeaponType() == R.string.type_dagger) {
            return "Rogue";
        }
        return adventurer.getWeaponType() == R.string.type_staff ? "Apprentice" : "Footman";
    }

    public static void triggerGuildSizeAchievementCheck() {
        int maxAdventurersOwned = MainActivity.data.getMaxAdventurersOwned();
        if (maxAdventurersOwned >= 20) {
            return;
        }
        int size = MainActivity.data.getAdventurers().size();
        if (maxAdventurersOwned < 5 && size >= 5) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_SMALL_GUILD);
        }
        if (maxAdventurersOwned < 12 && size >= 12) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RESPECTABLE_GUILD);
        }
        if (size >= 20) {
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_VERSATILE_ARMY);
        }
        MainActivity.data.setMaxAdventurersOwned(Math.max(size, maxAdventurersOwned));
    }

    public static boolean isMainLooper() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
