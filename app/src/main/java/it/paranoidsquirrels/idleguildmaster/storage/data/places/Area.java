package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.base.Ascii;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.ChiefScientistAva;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.AmuletOfResurrection;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SkeletonKey;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Area {
    private static final transient int BEHAVIOUR_NORMAL = 0;
    private static final transient int BEHAVIOUR_SILENCE = 1;
    private static final transient int BEHAVIOUR_SKIP = 2;
    private static final double EFFECT_PROBABILITY = 0.1d;
    private static final int MAX_SIGNIFICANT_PROGRESS = 250;
    public static final transient String TARGET_ALL = "all";
    public static final transient String TARGET_ALL_ALLIES = "all_allies";
    public static final transient String TARGET_ALL_ENEMIES = "all_enemies";
    public static final transient String TARGET_ALL_EXCEPT_SELF = "all_except_self";
    public static final transient String TARGET_LOWEST_ABSOLUTE_ALLY = "lowest_absolute_ally";
    public static final transient String TARGET_LOWEST_ABSOLUTE_ENEMY = "lowest_absolute_enemy";
    public static final transient String TARGET_LOWEST_RELATIVE_ALLY = "lowest_relative_ally";
    public static final transient String TARGET_LOWEST_RELATIVE_ENEMY = "lowest_relative_enemy";
    public static final transient String TARGET_LOWEST_SHIELD_ALLY = "lowest_shield_ally";
    public static final transient String TARGET_MOST_NEGATIVE_CONDITIONS_OR_LOWEST_RELATIVE_ALLY = "most_negative_conditions_or_lowest_relative_ally";
    public static final transient String TARGET_RANDOM = "random";
    public static final transient String TARGET_RANDOM_ALLY = "random_ally";
    public static final transient String TARGET_RANDOM_ALLY_EXCEPT_SELF = "random_ally_except_self";
    public static final transient String TARGET_RANDOM_ENEMY = "random_enemy";
    public static final transient String TARGET_RANDOM_EXCEPT_SELF = "random_except_self";
    private static StatusEffect TETHER = new StatusEffect(StatusEffectType.FEEBLE_TETHER, null, 0, 0.0d);
    public static final int TYPE_DUNGEON = 0;
    public static final int TYPE_EPIC_RAID = 2;
    public static final int TYPE_RAID = 1;
    protected transient Entity acting;
    protected Action action;
    private transient ValueAnimator animator;
    protected Event event;
    protected transient int fightRarity;
    protected int maxProgress;
    protected transient Pet petExploring;
    protected Integer petExploringId;
    protected int progress;
    protected Integer savedActingEntity;
    protected Integer savedPetId;
    private boolean triesAvailable;
    protected int turnsFighting;
    private boolean unlocked;
    protected List<Integer> savedAdventurersIds = new CopyOnWriteArrayList();
    protected List<Integer> adventurersExploringIds = new CopyOnWriteArrayList();
    protected List<Item> drops = new CopyOnWriteArrayList();
    protected transient List<Adventurer> adventurersExploring = new CopyOnWriteArrayList();
    protected transient int localDarkness = 0;
    protected List<Enemy> enemies = new CopyOnWriteArrayList();
    protected List<Enemy> corpses = new CopyOnWriteArrayList();
    protected transient List<Entity> fightingGroup = new ArrayList();
    private AdventureRecap adventureRecap = new AdventureRecap();
    public transient boolean terminationRequested = false;
    public transient boolean restartRequested = false;
    private transient boolean turnEndRequested = false;
    private transient double success = 0.0d;
    private transient double failure = 0.0d;
    private transient double totalProgress = 0.0d;
    private double collectedExperienceIn24Hours = 0.0d;
    private transient boolean animationInvalidationRequested = false;

    /* JADX INFO: Access modifiers changed from: private */
    public Area getCurrentInstance() {
        return this;
    }

    public int adventurersNumber() {
        return 4;
    }

    public boolean completed() {
        return false;
    }

    public int costToRefresh() {
        return 30;
    }

    public abstract int getAreaType();

    public abstract int getDarkness();

    public abstract int getDetailDrawable();

    public abstract LayoutDungeonBinding getLayout();

    public abstract int getName();

    public abstract int getSummaryDrawable();

    public abstract LinkedHashMap<Area, Integer> listAreasUnlocked();

    public abstract List<Enemy> listEnemies();

    protected double magicDamageAmplification() {
        return 1.0d;
    }

    protected abstract List<Enemy> rollEnemies();

    protected abstract void searchRoom();

    protected abstract void triggerEvent(String str);

    public List<Integer> getSavedAdventurersIds() {
        return this.savedAdventurersIds;
    }

    public void setSavedAdventurersIds(List<Integer> list) {
        this.savedAdventurersIds = list;
    }

    public List<Integer> getAdventurersExploringIds() {
        return this.adventurersExploringIds;
    }

    public void setAdventurersExploringIds(List<Integer> list) {
        this.adventurersExploringIds = list;
    }

    public Integer getSavedPetId() {
        return this.savedPetId;
    }

    public void setSavedPetId(Integer num) {
        this.savedPetId = num;
    }

    public Integer getPetExploringId() {
        return this.petExploringId;
    }

    public void setPetExploringId(Integer num) {
        this.petExploringId = num;
    }

    public List<Item> getDrops() {
        return this.drops;
    }

    public void setDrops(List<Item> list) {
        this.drops = list;
    }

    public Integer getSavedActingEntity() {
        return this.savedActingEntity;
    }

    public void setSavedActingEntity(Integer num) {
        this.savedActingEntity = num;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setTurnsFighting(int i) {
        this.turnsFighting = i;
    }

    public List<Adventurer> getAdventurersExploring() {
        return this.adventurersExploring;
    }

    public Pet getPetExploring() {
        return this.petExploring;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public List<Enemy> getCorpses() {
        return this.corpses;
    }

    public int getLocalDarkness() {
        return this.localDarkness;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public int getMaxProgress() {
        return this.maxProgress;
    }

    public void setMaxProgress(int i) {
        this.maxProgress = i;
    }

    public boolean getTriesAvailable() {
        return this.triesAvailable;
    }

    public void setTriesAvailable(boolean z) {
        this.triesAvailable = z;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public void setUnlocked(boolean z) {
        this.unlocked = z;
    }

    public AdventureRecap getAdventureRecap() {
        return this.adventureRecap;
    }

    public void setAdventureRecap(AdventureRecap adventureRecap) {
        this.adventureRecap = adventureRecap;
    }

    public void tick() {
        if (this.adventurersExploringIds.isEmpty()) {
            return;
        }
        if (this.terminationRequested) {
            terminate();
            return;
        }
        if (this.adventurersExploring.isEmpty() || this.restartRequested) {
            setupArea();
        }
        Action action = this.action;
        if (action == null) {
            resetAdventurers(true);
            this.action = new Action(0);
            refreshHpBars();
            refreshActionDisplayed();
            refreshDialog();
            setupInitialDarkness();
        } else {
            action.nextTurn();
            this.adventureRecap.addSecondPassed();
        }
        if (this.action.finished()) {
            if (needsRealignment()) {
                realignToMain();
            }
            invertLogColor();
            try {
                performAction();
            } catch (Exception e) {
                e.printStackTrace();
                if (MainActivity.headquartersFragment != null) {
                    MainActivity.headquartersFragment.getActivity().finish();
                }
                System.exit(0);
            }
            refreshHpBars();
            refreshActionDisplayed();
        }
    }

    private boolean needsRealignment() {
        try {
            Adventurer adventurer = this.adventurersExploring.get(0);
            Iterator<Adventurer> it2 = MainActivity.data.getAdventurers().iterator();
            while (it2.hasNext()) {
                Adventurer next = it2.next();
                if (next.getId() == adventurer.getId()) {
                    return adventurer != next;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void realignToMain() {
        this.animationInvalidationRequested = true;
        setupAdventurers(MainActivity.data.getAdventurers(), MainActivity.data.getPets());
        refreshActionDisplayed();
        refreshAdventurers();
        refreshDialog();
    }

    private void terminate() {
        this.adventurersExploringIds.clear();
        this.petExploringId = null;
        this.adventurersExploring.clear();
        this.petExploring = null;
        this.enemies.clear();
        this.corpses.clear();
        this.fightingGroup.clear();
        this.acting = null;
        this.action = null;
        this.turnsFighting = 0;
        this.terminationRequested = false;
        this.event = null;
        if (this.progress < 250) {
            this.progress = 0;
        }
        refreshActionDisplayed();
        refreshAdventurers();
    }

    private void setupArea() {
        this.restartRequested = false;
        this.enemies.clear();
        this.corpses.clear();
        this.fightingGroup.clear();
        this.acting = null;
        this.action = null;
        this.turnsFighting = 0;
        this.event = null;
        if (this.progress < 250 || getAreaType() != 0) {
            this.progress = 0;
        }
        setupAdventurers(MainActivity.data.getAdventurers(), MainActivity.data.getPets());
        refreshActionDisplayed();
        refreshAdventurers();
        refreshDialog();
    }

    public void setupInitialDarkness() {
        Pet pet = this.petExploring;
        int bright = pet != null ? pet.getBright() : 0;
        for (Adventurer adventurer : this.adventurersExploring) {
            if (adventurer.getCurrentHp() > 0) {
                bright += adventurer.darknessReduction();
            }
        }
        this.localDarkness = Math.max(0, getDarkness() - bright);
    }

    public void setupAdventurers(List<Adventurer> list, List<Pet> list2) {
        this.adventurersExploring = new CopyOnWriteArrayList();
        for (Integer num : this.adventurersExploringIds) {
            if (num.intValue() != -100) {
                for (Adventurer adventurer : list) {
                    if (adventurer.getId() == num.intValue()) {
                        adventurer.setMinionBound(null);
                        this.adventurersExploring.add(adventurer);
                        break;
                    }
                }
            }
        }
        if (this.petExploringId != null) {
            for (Pet pet : list2) {
                if (pet.getId() == this.petExploringId.intValue()) {
                    this.petExploring = pet;
                }
            }
        }
    }

    private void performAction() {
        switch (this.action.getType()) {
            case 0:
                triggerEvent("enter_dungeon");
                this.action = new Action(1);
                break;
            case 1:
                if (getAreaType() != 0) {
                    incrementProgress();
                }
                enterRoom();
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true;
                    }
                    Logger.log(this, 2, new Object[0]);
                    this.action = new Action(5);
                } else {
                    List<Enemy> listRollEnemies = rollEnemies();
                    this.enemies = listRollEnemies;
                    if (listRollEnemies.isEmpty()) {
                        this.action = new Action(getAreaType() != 0 ? 1 : 4);
                    } else {
                        Iterator<Enemy> it2 = this.enemies.iterator();
                        while (it2.hasNext()) {
                            MainActivity.data.getSeenEnemies().add(it2.next().getTrueClass());
                        }
                        triggerEvent("fight_start");
                        initializeFight();
                        this.action = new Action(2);
                    }
                }
                break;
            case 2:
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true;
                    }
                    Logger.log(this, 2, new Object[0]);
                    this.action = new Action(5);
                } else if (this.enemies.isEmpty()) {
                    Logger.log(this, 5, new Object[0]);
                    triggerEvent("victory");
                    collectExperience();
                    this.action = new Action(3);
                } else if (this.turnsFighting >= 400 && getAreaType() == 0) {
                    this.action = new Action(6);
                } else {
                    int size = this.corpses.size();
                    fightTurn();
                    petAttack();
                    petHeal();
                    petExecution();
                    petCast();
                    if (this.corpses.size() - size >= 4) {
                        QuestsManager.increment(QuestsManager.tabulaRasa, 1L);
                    }
                    this.action = new Action(2);
                }
                break;
            case 3:
                loot();
                this.action = new Action(getAreaType() != 0 ? 1 : 4);
                break;
            case 4:
                searchRoom();
                if (adventurersAlive() == 0) {
                    if (getAreaType() != 0) {
                        this.terminationRequested = true;
                    }
                    Logger.log(this, 2, new Object[0]);
                    this.action = new Action(5);
                } else {
                    refreshLoot();
                    if (getAreaType() == 0) {
                        incrementProgress();
                    }
                    this.action = new Action(1);
                }
                break;
            case 5:
                Logger.log(this, 4, new Object[0]);
                respawn();
                if (this.progress < 250) {
                    this.progress = 0;
                }
                triggerEvent("respawn");
                this.action = new Action(1);
                break;
            case 6:
                Logger.log(this, 3, new Object[0]);
                triggerEvent("flee");
                clearEnemies();
                this.action = new Action(1);
                break;
        }
        refreshDialog();
    }

    private void logStatistics() {
        int i = this.progress;
        if (i >= 100) {
            this.success += 1.0d;
        } else {
            this.failure += 1.0d;
        }
        this.totalProgress += (double) i;
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Success rate is ");
        double d = this.success;
        printStream.println(sb.append(d / (this.failure + d)).append("; average progress is ").append(this.totalProgress / (this.success + this.failure)).toString());
        System.out.print("team was killed by: ");
        Iterator<Enemy> it2 = this.enemies.iterator();
        while (it2.hasNext()) {
            System.out.print(it2.next().getTrueClass() + "; ");
        }
        this.progress = 0;
    }

    private void incrementProgress() {
        QuestsManager.increment(QuestsManager.longMarch, 1L);
        this.adventureRecap.addAreaCleared();
        int i = this.progress;
        if (i >= 250) {
            return;
        }
        int i2 = i + 1;
        this.progress = i2;
        if (this.maxProgress < i2) {
            this.maxProgress = i2;
        }
        for (Map.Entry<Area, Integer> entry : listAreasUnlocked().entrySet()) {
            Area key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            if (!key.isUnlocked()) {
                Logger.log(this, 55, Integer.valueOf(key.getName()), Integer.valueOf(this.progress), Integer.valueOf(iIntValue));
                if (this.progress >= iIntValue) {
                    UIUtils.unlockArea(key);
                    Logger.log(this, 56, Integer.valueOf(key.getName()));
                }
            }
        }
    }

    private void resetAdventurers(boolean z) {
        for (Adventurer adventurer : this.adventurersExploring) {
            adventurer.setCurrentHp(adventurer.calculateTotalMaxHp());
            adventurer.setCurrentShield(0);
            adventurer.getPositiveStatusEffects().clear();
            adventurer.getNegativeStatusEffects().clear();
            if (z) {
                adventurer.setCurrentMana(0);
            }
        }
    }

    private void clearEnemies() {
        this.enemies.clear();
        this.corpses.clear();
    }

    private void respawn() {
        this.adventureRecap.addWipe();
        resetAdventurers(false);
        clearEnemies();
    }

    private void enterRoom() {
        List<Entity> listSelectTargets;
        triggerEvent("enter_room");
        Pet pet = this.petExploring;
        int bright = pet != null ? pet.getBright() : 0;
        for (Adventurer adventurer : this.adventurersExploring) {
            if (adventurer.getCurrentHp() > 0) {
                resolveStatus(adventurer);
                if (adventurer.getCurrentHp() > 0) {
                    bright += adventurer.darknessReduction();
                    if (adventurer.isHealer() && (listSelectTargets = selectTargets(adventurer, TARGET_LOWEST_RELATIVE_ALLY)) != null) {
                        Entity entity = listSelectTargets.get(0);
                        if (entity.getCurrentHp() < entity.calculateTotalMaxHp() || (adventurer.isCleanser() && entity.getNegativeStatusEffects().size() > 0)) {
                            heal(adventurer, listSelectTargets.get(0), null);
                        }
                    }
                    petHeal();
                }
            }
        }
        QuestsManager.incrementToValue(QuestsManager.lightBringer, bright);
        this.localDarkness = Math.max(0, getDarkness() - bright);
        refreshDarkness();
        Logger.log(this, 1, Integer.valueOf(this.localDarkness));
    }

    private void initializeFight() {
        this.turnsFighting = -1;
        this.acting = null;
        this.savedActingEntity = null;
        this.corpses = new CopyOnWriteArrayList();
        this.fightRarity = UIUtils.getFightRarity(this.enemies);
        this.fightingGroup = new ArrayList();
    }

    private void decideTurnsOrder() {
        this.fightingGroup.clear();
        this.fightingGroup.addAll(this.adventurersExploring);
        this.fightingGroup.addAll(this.enemies);
        this.fightingGroup.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.isNull((Entity) obj);
            }
        });
        Utils.orderByTurnsPriority(this.fightingGroup);
    }

    private void collectExperience() {
        Iterator<Enemy> it2 = this.corpses.iterator();
        double expGiven = 0.0d;
        while (it2.hasNext()) {
            expGiven += (double) it2.next().getExpGiven();
        }
        double dAdventurersAlive = expGiven / ((double) adventurersAlive());
        Pet pet = this.petExploring;
        double experience = pet != null ? 1.0d + (pet.getExperience() / 100.0d) : 1.0d;
        boolean z = false;
        for (Adventurer adventurer : this.adventurersExploring) {
            if (adventurer.getCurrentHp() > 0 && !adventurer.isSummonedMinion()) {
                double dExperienceMultiplier = adventurer.experienceMultiplier() * experience;
                int iRound = Utils.round(dAdventurersAlive * dExperienceMultiplier);
                if (dExperienceMultiplier >= 1.5d) {
                    QuestsManager.increment(QuestsManager.fastLearner, 1L);
                }
                QuestsManager.increment(QuestsManager.student, iRound);
                int iAddExperience = adventurer.addExperience(iRound);
                this.adventureRecap.addExpEarned(iRound);
                Logger.log(this, 6, Integer.valueOf(adventurer.getIdName()), Integer.valueOf(iRound));
                if (iAddExperience > 0) {
                    for (int i = 0; i < iAddExperience; i++) {
                        Logger.log(this, 7, Integer.valueOf(adventurer.getIdName()));
                    }
                    z = true;
                }
            }
        }
        if (z && Utils.isMainLooper() && MainActivity.adventurersFragment != null) {
            MainActivity.adventurersFragment.refresh();
        }
    }

    private void loot() {
        ItemWrapper itemWrapper;
        if (fullChest()) {
            Logger.log(this, 100, Integer.valueOf(R.string.log_full_drops));
        } else {
            boolean z = true;
            for (Enemy enemy : this.corpses) {
                Event event = this.event;
                ItemWrapper itemWrapper2 = (ItemWrapper) Utils.rollFromWeightedMap(enemy.listDrops(event == null ? 0 : event.getKey()));
                if (this.petExploring == null || ((itemWrapper2 != null && itemWrapper2.getItem().isNotSellable()) || Utils.random() >= this.petExploring.getDrops() / 100.0d)) {
                    itemWrapper = null;
                } else {
                    Event event2 = this.event;
                    itemWrapper = (ItemWrapper) Utils.rollFromWeightedMap(enemy.listDrops(event2 == null ? 0 : event2.getKey()));
                }
                if (itemWrapper2 != null) {
                    Item item = itemWrapper2.getItem();
                    Utils.collectItem(item, this.drops);
                    Logger.log(this, 8, Integer.valueOf(enemy.getIdName()), Integer.valueOf(item.getStack()), Integer.valueOf(item.getIdName()));
                    if (MainActivity.data.getTutorialStep() == 2) {
                        MainActivity.data.setTutorialStep(3);
                        if (Utils.isMainLooper() && MainActivity.dungeonsFragment != null) {
                            ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshTutorial();
                        }
                        this.event = null;
                    }
                    z = false;
                }
                if (itemWrapper != null) {
                    Item item2 = itemWrapper.getItem();
                    Utils.collectItem(item2, this.drops);
                    Logger.log(this, 8, Integer.valueOf(enemy.getIdName()), Integer.valueOf(item2.getStack()), Integer.valueOf(item2.getIdName()));
                    z = false;
                }
                if (Utils.random() < 5.0E-4d) {
                    Item item3 = Item.getInstance("Geode");
                    Utils.collectItem(item3, this.drops);
                    Logger.log(this, 8, Integer.valueOf(enemy.getIdName()), Integer.valueOf(item3.getStack()), Integer.valueOf(item3.getIdName()));
                    z = false;
                }
            }
            if (z) {
                Logger.log(this, 9, new Object[0]);
            } else {
                refreshLoot();
            }
        }
        this.corpses.clear();
    }

    protected void collectItemFromGround(Item item) {
        if (fullChest()) {
            Logger.log(this, 100, Integer.valueOf(R.string.log_full_drops));
            return;
        }
        Logger.log(this, 40, Integer.valueOf(item.getStack()), Integer.valueOf(item.getIdName()));
        Utils.collectItem(item, this.drops);
        refreshLoot();
    }

    private boolean fullChest() {
        Iterator<Item> it2 = this.drops.iterator();
        int stack = 0;
        while (it2.hasNext()) {
            stack += it2.next().getStack();
        }
        return stack >= (MainActivity.data.isMerchantPackPurchased() ? 3000 : 2000);
    }

    private int adventurersAlive() {
        int i = 0;
        for (Adventurer adventurer : this.adventurersExploring) {
            if (adventurer.getCurrentHp() > 0 && !adventurer.isSummonedMinion()) {
                i++;
            }
        }
        return i;
    }

    private void fightTurn() {
        List<Entity> listSelectTargets;
        this.turnEndRequested = false;
        this.turnsFighting++;
        selectNextActing();
        int iResolveStatus = resolveStatus(this.acting);
        if (this.acting.getCurrentHp() <= 0 || iResolveStatus == 2) {
            return;
        }
        if (iResolveStatus != 1 ? increaseMana(this.acting) : false) {
            listSelectTargets = cast(this.acting);
        } else if (this.acting.isHealer()) {
            listSelectTargets = selectTargets(this.acting, TARGET_LOWEST_RELATIVE_ALLY);
            if (listSelectTargets == null) {
                return;
            } else {
                heal(this.acting, listSelectTargets.get(0), null);
            }
        } else {
            Entity entity = this.acting;
            listSelectTargets = selectTargets(entity, attackTargetStrategy(entity));
            if (listSelectTargets == null) {
                return;
            } else {
                dealDamage(this.acting, listSelectTargets.get(0), null, null);
            }
        }
        if (listSelectTargets == null || listSelectTargets.isEmpty() || this.turnEndRequested) {
            return;
        }
        try {
            for (EndOfTurnAction endOfTurnAction : this.acting.endOfTurnActions()) {
                if (endOfTurnAction == EndOfTurnAction.STUN_SELF_NOT_CLEANSABLE) {
                    applyStatus(this.acting, new StatusEffect(StatusEffectType.STUN_NOT_CLEANSABLE, this.acting, 1, 1.0d), 0.0d);
                } else if (endOfTurnAction == EndOfTurnAction.FALSE_LIFE) {
                    Entity entity2 = this.acting;
                    StatusEffectType statusEffectType = StatusEffectType.FALSE_LIFE;
                    Entity entity3 = this.acting;
                    applyStatus(entity2, new StatusEffect(statusEffectType, entity3, 999, ((double) ((Adventurer) entity3).getDoctrine().falseLifeChance()) * 0.01d), 0.0d);
                } else if (endOfTurnAction.shields) {
                    List<Entity> listSelectTargets2 = selectTargets(this.acting, TARGET_LOWEST_SHIELD_ALLY);
                    if (listSelectTargets2 != null) {
                        Entity entity4 = listSelectTargets2.get(0);
                        int currentShield = entity4.getCurrentShield();
                        entity4.setCurrentShield(Math.min(Utils.round(((double) endOfTurnAction.damage) * this.acting.calculateHealingModifier()) + currentShield, (int) (((double) entity4.calculateTotalMaxHp()) * 0.2d)));
                        int currentShield2 = entity4.getCurrentShield() - currentShield;
                        if (currentShield2 > 0) {
                            Logger.log(this, Logger.BARD_SHIELD, this.acting, entity4, Integer.valueOf(currentShield2));
                        }
                        applyStatus(entity4, new StatusEffect(endOfTurnAction.effect.getType(), this.acting, endOfTurnAction.effect.getTurnsLeft() + this.acting.getInspireExaltBonusTurns(), endOfTurnAction.effect.getProbability()), 0.0d);
                    }
                } else if (endOfTurnAction.procsOnMelee == null || endOfTurnAction.procsOnMelee.booleanValue() != this.acting.isRanged()) {
                    Entity entity5 = this.acting;
                    List<Entity> listSelectTargets3 = selectTargets(entity5, attackTargetStrategy(entity5));
                    if (listSelectTargets3 != null) {
                        Entity entity6 = listSelectTargets3.get(0);
                        if (entity6.getCurrentHp() > 0) {
                            dealDamage(this.acting, entity6, null, endOfTurnAction);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String attackTargetStrategy(Entity entity) {
        boolean z = false;
        boolean z2 = entity.getPassiveSkill() == Skills.PASSIVE_CHAOTIC || entity.getPassiveSkill() == Skills.PASSIVE_PRIMORDIAL_HUNGER;
        if ((this instanceof LostLands) && (entity.getPassiveSkill() == Skills.PASSIVE_PREHISTORIC_AVIAN || entity.getPassiveSkill() == Skills.PASSIVE_PREHISTORIC_COLOSSUS)) {
            Iterator<Enemy> it2 = this.enemies.iterator();
            do {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
            } while (it2.next().getPassiveSkill() != Skills.PASSIVE_NATURAL_EMPATHY);
        } else {
            z = z2;
        }
        if (z) {
            return TARGET_RANDOM_EXCEPT_SELF;
        }
        if (entity.getPassiveSkill() == Skills.PASSIVE_DESPISE_WEAKNESS || entity.getPassiveSkill() == Skills.PASSIVE_WICKED_APPETITE) {
            return TARGET_LOWEST_RELATIVE_ENEMY;
        }
        return TARGET_RANDOM_ENEMY;
    }

    private void petAttack() {
        if (this.petExploring == null || this.enemies.isEmpty() || !(this.acting instanceof Adventurer) || this.petExploring.getFighter() <= 0.0d || this.turnEndRequested) {
            return;
        }
        double fighter = this.petExploring.getFighter() * ((((double) this.acting.getLivingCompanionBonusDamage()) * 0.01d) + 1.0d);
        Entity entitySelectPetTarget = selectPetTarget();
        if (entitySelectPetTarget != null) {
            Logger.log(this, 105, Integer.valueOf(R.string.log_damage_dealt), this.petExploring, entitySelectPetTarget, Integer.valueOf(entitySelectPetTarget.applyDamage(Utils.round(Math.max(1.0d, (0.9d * fighter) + (Utils.random() * fighter * 0.2d))), false, 0, 0.0d)));
            checkDeath(entitySelectPetTarget);
            retaliate(null, entitySelectPetTarget, true, 0);
        }
    }

    private void petHeal() {
        Pet pet = this.petExploring;
        if (pet == null || !(this.acting instanceof Adventurer) || pet.getHealer() <= 0.0d || this.turnEndRequested) {
            return;
        }
        double healer = this.petExploring.getHealer();
        Entity entitySelectPetHealingTarget = selectPetHealingTarget();
        if (entitySelectPetHealingTarget == null || entitySelectPetHealingTarget.getCurrentHp() >= entitySelectPetHealingTarget.calculateTotalMaxHp()) {
            return;
        }
        int iRound = Utils.round(Math.max(1.0d, (0.9d * healer) + (Utils.random() * healer * 0.2d)));
        int currentHp = entitySelectPetHealingTarget.getCurrentHp();
        int iMin = Math.min(entitySelectPetHealingTarget.calculateTotalMaxHp(), currentHp + iRound);
        entitySelectPetHealingTarget.setCurrentHp(iMin);
        QuestsManager.increment(QuestsManager.medic, iMin - currentHp);
        Logger.log(this, Logger.LOG_PET_HEAL, this.petExploring, entitySelectPetHealingTarget, Integer.valueOf(iRound));
    }

    private void petExecution() {
        Pet pet = this.petExploring;
        if (pet == null || pet.getOpportunist() <= 0.0d || this.enemies.isEmpty()) {
            return;
        }
        for (Enemy enemy : this.enemies) {
            if (enemy.getCurrentHp() > 0 && ((double) enemy.getCurrentHp()) / ((double) enemy.calculateTotalMaxHp()) < this.petExploring.getOpportunist() / 100.0d) {
                enemy.setCurrentHp(0);
                Logger.log(this, 108, enemy, this.petExploring);
                checkDeath(enemy);
            }
        }
    }

    private void petCast() {
        Pet pet;
        StatusEffectType statusEffectType;
        Entity enemy;
        int iAddStatusEffect;
        if (!(this.acting instanceof Adventurer) || (pet = this.petExploring) == null || pet.getStatusEffectChance() <= 0.0d || this.turnEndRequested) {
            return;
        }
        double dRandom = Utils.random();
        Adventurer adventurer = null;
        if (dRandom < EFFECT_PROBABILITY) {
            statusEffectType = StatusEffectType.TAUNT;
            for (Adventurer adventurer2 : this.adventurersExploring) {
                if (adventurer2.getCurrentHp() > 0 && (adventurer == null || adventurer2.getThreat() > adventurer.getThreat())) {
                    adventurer = adventurer2;
                }
            }
        } else if (dRandom < 0.2d) {
            statusEffectType = StatusEffectType.DEFENSIVE_STANCE;
        } else if (dRandom < 0.30000000000000004d) {
            statusEffectType = StatusEffectType.STUN;
        } else if (dRandom < 0.4d) {
            statusEffectType = StatusEffectType.SILENCE;
        } else if (dRandom < 0.5d) {
            statusEffectType = StatusEffectType.ABLAZE;
        } else if (dRandom < 0.6000000000000001d) {
            statusEffectType = StatusEffectType.POISON;
        } else if (dRandom < 0.7000000000000001d) {
            statusEffectType = StatusEffectType.REGENERATION;
        } else if (dRandom < 0.8d) {
            statusEffectType = StatusEffectType.BLEED;
        } else if (dRandom < 0.9d) {
            statusEffectType = StatusEffectType.FROZEN;
        } else {
            if (this.petExploring.getStatusEffectChance() < 15.0d) {
                statusEffectType = StatusEffectType.LESSER_CURSE;
            } else if (this.petExploring.getStatusEffectChance() < 30.0d) {
                statusEffectType = StatusEffectType.CURSE;
            } else {
                statusEffectType = StatusEffectType.GREATER_CURSE;
            }
            for (Adventurer adventurer3 : this.adventurersExploring) {
                if (adventurer3.getCurrentHp() > 0 && (adventurer == null || adventurer3.calculateTotalIntelligence() > adventurer.calculateTotalIntelligence())) {
                    adventurer = adventurer3;
                }
            }
        }
        StatusEffect statusEffect = new StatusEffect(statusEffectType, adventurer, this.petExploring.getStatusEffectTurns(), this.petExploring.getStatusEffectChance() / 100.0d);
        if (statusEffect.getType().negative) {
            if (this.enemies.isEmpty()) {
                return;
            }
            enemy = (Entity) this.enemies.get((int) (Utils.random() * ((double) this.enemies.size())));
            iAddStatusEffect = enemy.addStatusEffect(statusEffect, 0.0d);
        } else {
            ArrayList arrayList = new ArrayList(this.adventurersExploring);
            arrayList.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Area.lambda$petCast$0((Adventurer) obj);
                }
            });
            if (arrayList.isEmpty()) {
                return;
            }
            enemy = (Entity) arrayList.get((int) (Utils.random() * ((double) arrayList.size())));
            iAddStatusEffect = enemy.addStatusEffect(statusEffect, 0.0d);
        }
        if (iAddStatusEffect > 0) {
            if (iAddStatusEffect < 999) {
                Logger.log(this, 11, enemy, statusEffect.getType(), Integer.valueOf(iAddStatusEffect));
            } else {
                Logger.log(this, 12, enemy, statusEffect.getType());
            }
        }
    }

    static /* synthetic */ boolean lambda$petCast$0(Adventurer adventurer) {
        return adventurer.isSummonedMinion() || adventurer.getCurrentHp() <= 0;
    }

    private void selectNextActing() {
        if (this.fightingGroup.isEmpty()) {
            decideTurnsOrder();
        }
        if (this.acting == null) {
            Integer num = this.savedActingEntity;
            if (num != null && num.intValue() <= this.fightingGroup.size() - 1) {
                this.acting = this.fightingGroup.get(this.savedActingEntity.intValue());
            } else {
                List<Entity> list = this.fightingGroup;
                this.acting = list.get(list.size() - 1);
            }
            this.savedActingEntity = null;
        }
        for (int i = 1; i < this.fightingGroup.size(); i++) {
            int iIndexOf = (this.fightingGroup.indexOf(this.acting) + i) % this.fightingGroup.size();
            Entity entity = this.fightingGroup.get(iIndexOf);
            if (entity.getCurrentHp() > 0) {
                this.acting = entity;
                this.savedActingEntity = Integer.valueOf(iIndexOf);
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x00e1 A[PHI: r13
  0x00e1: PHI (r13v3 int) = (r13v1 int), (r13v4 int), (r13v1 int) binds: [B:18:0x0078, B:32:0x00d1, B:21:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    private int resolveStatus(Entity entity) {
        int i;
        boolean z;
        Adventurer adventurer;
        int iDecay;
        boolean z2;
        int i2;
        Pet pet;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(entity.getPositiveStatusEffects());
        arrayList.addAll(entity.getNegativeStatusEffects());
        int iCalculateTotalMaxHp = entity.calculateTotalMaxHp();
        int iCalculateTotalRegeneration = entity.calculateTotalRegeneration();
        boolean z3 = entity instanceof Adventurer;
        if (z3 && (pet = this.petExploring) != null) {
            iCalculateTotalRegeneration += pet.getRegeneration();
        }
        Iterator it2 = arrayList.iterator();
        int i3 = 0;
        int iRound = iCalculateTotalRegeneration;
        boolean z4 = false;
        int damagePerTurnPerStatus = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            StatusEffect statusEffect = (StatusEffect) it2.next();
            if (statusEffect.getTurnsLeft() <= 0 || (statusEffect.getType() == StatusEffectType.TAUNT && statusEffect.getCause().getCurrentHp() <= 0)) {
                it2 = it2;
                Logger.log(this, 10, entity, statusEffect.getType());
                (statusEffect.getType().negative ? entity.getNegativeStatusEffects() : entity.getPositiveStatusEffects()).remove(statusEffect);
            } else {
                statusEffect.setTurnsLeft(statusEffect.getTurnsLeft() - 1);
                switch (AnonymousClass1.$SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[statusEffect.getType().ordinal()]) {
                    case 1:
                        statusEffect = statusEffect;
                        it2 = it2;
                        Logger.log(this, 13, entity, statusEffect);
                        break;
                    case 2:
                        statusEffect = statusEffect;
                        it2 = it2;
                        Logger.log(this, 14, entity, statusEffect);
                        break;
                    case 3:
                        statusEffect = statusEffect;
                        Entity cause = statusEffect.getCause();
                        int freezeBonusDamage = cause != null ? cause.getFreezeBonusDamage() : 0;
                        Pet pet2 = this.petExploring;
                        z2 = true;
                        int iApplyDamage = entity.applyDamage(freezeBonusDamage + 10, false, (pet2 == null || !z3) ? 0 : pet2.getBarrier(), 0.0d);
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, iApplyDamage);
                        }
                        Logger.log(this, 50, entity, statusEffect, Integer.valueOf(iApplyDamage));
                        z4 = z2;
                        break;
                    case 4:
                    case 5:
                        statusEffect = statusEffect;
                        i2 = 2;
                        Logger.log(this, 15, entity, statusEffect);
                        i4 = i2;
                        break;
                    case 6:
                        statusEffect = statusEffect;
                        i2 = 2;
                        Logger.log(this, Logger.STATUS_PETRIFIED, entity, statusEffect);
                        i4 = i2;
                        break;
                    case 7:
                        statusEffect = statusEffect;
                        it2 = it2;
                        Logger.log(this, 16, entity, statusEffect);
                        if (i4 != 2) {
                            i4 = 1;
                        }
                        break;
                    case 8:
                        statusEffect = statusEffect;
                        z2 = true;
                        Entity cause2 = statusEffect.getCause();
                        double onFireBonusDamage = cause2 != null ? ((double) cause2.getOnFireBonusDamage()) * 0.01d : 0.0d;
                        double dMagicDamageAmplification = magicDamageAmplification();
                        Pet pet3 = this.petExploring;
                        int iApplyDamage2 = entity.applyDamage(Utils.round((onFireBonusDamage + 0.05d) * ((double) iCalculateTotalMaxHp) * dMagicDamageAmplification), true, (pet3 == null || !z3) ? 0 : pet3.getBarrier(), 0.0d);
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, iApplyDamage2);
                        }
                        Logger.log(this, 17, entity, statusEffect, Integer.valueOf(iApplyDamage2));
                        z4 = z2;
                        break;
                    case 9:
                        double dMagicDamageAmplification2 = magicDamageAmplification();
                        Pet pet4 = this.petExploring;
                        int barrier = (pet4 == null || !z3) ? i3 : pet4.getBarrier();
                        statusEffect = statusEffect;
                        i2 = 2;
                        Logger.log(this, Logger.STATUS_TERRIFIED, entity, statusEffect, Integer.valueOf(entity.applyDamage(Utils.round(((double) iCalculateTotalMaxHp) * 0.2d * dMagicDamageAmplification2), true, barrier, 0.0d)));
                        z4 = true;
                        i4 = i2;
                        break;
                    case 10:
                        Entity cause3 = statusEffect.getCause();
                        iRound += Utils.round((cause3 != null ? 0.06d + (((double) cause3.getRegenerationBonus()) * 0.01d) : 0.06d) * ((double) iCalculateTotalMaxHp));
                        Logger.log(this, 18, entity, statusEffect);
                        it2 = it2;
                        break;
                    case 11:
                        int turnsLeft = statusEffect.getTurnsLeft() + 1;
                        entity.setCurrentHp(Math.max(i3, entity.getCurrentHp() - turnsLeft));
                        if (!z3) {
                            QuestsManager.increment(QuestsManager.slowBurn, turnsLeft);
                        }
                        Logger.log(this, 19, entity, statusEffect, Integer.valueOf(turnsLeft));
                        z4 = true;
                        it2 = it2;
                        break;
                    case 12:
                        if (entity.getCurrentMana() < 100) {
                            entity.setCurrentHp(i3);
                            entity.setCurrentShield(i3);
                            Logger.log(this, Logger.STATUS_FEEBLE_TETHER, entity);
                            z4 = true;
                        }
                        it2 = it2;
                        break;
                    default:
                        it2 = it2;
                        break;
                }
                if (statusEffect.getCause() != null && statusEffect.getCause().getDamagePerTurnPerStatus() > 0 && statusEffect.getType().negative) {
                    damagePerTurnPerStatus += statusEffect.getCause().getDamagePerTurnPerStatus();
                }
            }
            it2 = it2;
            i3 = 0;
        }
        if (!z3 || (iDecay = (adventurer = (Adventurer) entity).decay()) < 1) {
            i = 0;
        } else {
            QuestsManager.increment(QuestsManager.fallingApart, iDecay);
            i = 0;
            entity.setCurrentHp(Math.max(0, entity.getCurrentHp() - iDecay));
            Logger.log(this, 20, adventurer, Integer.valueOf(iDecay));
            z4 = true;
        }
        if (damagePerTurnPerStatus > 0) {
            double dMagicDamageAmplification3 = magicDamageAmplification();
            Pet pet5 = this.petExploring;
            Logger.log(this, Logger.ARCANE_SUPPRESSION, entity, Integer.valueOf(entity.applyDamage(((double) damagePerTurnPerStatus) * dMagicDamageAmplification3, true, (pet5 == null || !z3) ? i : pet5.getBarrier(), 0.0d)));
            z = true;
        } else {
            z = z4;
        }
        if (iRound > 0 && entity.getCurrentHp() > 0 && entity.getCurrentHp() < iCalculateTotalMaxHp) {
            int currentHp = entity.getCurrentHp();
            int iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound);
            entity.setCurrentHp(iMin);
            if (z3) {
                QuestsManager.increment(QuestsManager.soothingRemedy, iMin - currentHp);
            }
            Logger.log(this, 49, entity, Integer.valueOf(iRound));
        }
        if (z) {
            checkDeath(entity);
        }
        if (entity.getCurrentHp() <= 0) {
            return 2;
        }
        return i4;
    }

    private boolean increaseMana(Entity entity) {
        if (entity.getActiveSkill() != Skills.ACTIVE_NONE && entity.getActiveSkill() != null) {
            if (entity.getCurrentMana() >= 100) {
                entity.setCurrentMana(0);
                return true;
            }
            entity.setCurrentMana(Math.min(100, entity.getCurrentMana() + entity.calculateManaRegen()));
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v22 */
    private boolean dodge(Entity entity, Entity entity2, boolean z, boolean z2) {
        double dMax;
        int IsNightVision;
        if (!z2 && !entity.isFlying() && entity2.isFlying()) {
            Logger.log(this, 45, entity, entity2);
            return true;
        }
        if (entity.isAlwaysHits() || entity2.getNegativeStatusEffects().contains(StatusEffect.STATIC_INSTANCE_FROZEN)) {
            dMax = 1.0d;
        } else {
            double dCalculateTotalIntelligence = entity.isMagic() ? entity.calculateTotalIntelligence() : entity.calculateTotalDexterity();
            double dCalculateTotalIntelligence2 = dCalculateTotalIntelligence / ((((double) (entity.isMagic() ? entity2.calculateTotalIntelligence() : entity2.calculateTotalDexterity())) / 5.0d) + dCalculateTotalIntelligence);
            boolean z3 = entity instanceof Enemy;
            boolean z4 = z3 && (entity2 instanceof Enemy);
            if (this.localDarkness > 0 && !z4) {
                if (z3) {
                    IsNightVision = !((Adventurer) entity2).isNightVision() ? 1 : 0;
                } else {
                    IsNightVision = ((Adventurer) entity).isNightVision() ? 1 : 0;
                }
                dCalculateTotalIntelligence2 -= (((double) this.localDarkness) * 0.01d) * (dCalculateTotalIntelligence2 - ((double) IsNightVision));
            }
            if (!z3 && ((Adventurer) entity).getTraitRare() == Trait.FOCUSED) {
                dCalculateTotalIntelligence2 += 0.15d;
            }
            dMax = Math.max(EFFECT_PROBABILITY, dCalculateTotalIntelligence2 - entity2.calculateTotalFlatDodgeChance());
        }
        boolean z5 = Utils.random() > dMax;
        if (z5) {
            if (z) {
                Logger.log(this, 21, entity, entity2, Integer.valueOf(100 - Utils.round(dMax * 100.0d)));
            } else {
                Logger.log(this, 22, entity2, Integer.valueOf(100 - Utils.round(dMax * 100.0d)));
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void heal(Entity entity, Entity entity2, Skill skill) {
        boolean z;
        int i;
        Pet pet;
        double dCalculateHealingModifier = entity.calculateHealingModifier() * (skill == null ? 1.0d : skill.damageAmplification);
        double dCalculateCriticalMultiplier = calculateCriticalMultiplier(entity, skill, 0.0d);
        boolean z2 = entity instanceof Adventurer;
        if (!z2 || (pet = this.petExploring) == null || dCalculateCriticalMultiplier <= 1.0d || pet.getSavage() <= 0.0d || Utils.random() >= this.petExploring.getSavage() / 100.0d) {
            z = false;
        } else {
            dCalculateCriticalMultiplier *= dCalculateCriticalMultiplier;
            z = true;
        }
        Map.Entry<String, Double> increaseHealingAgainst = entity.getIncreaseHealingAgainst();
        if (increaseHealingAgainst != null && entity2.getTrueClass().equals(increaseHealingAgainst.getKey())) {
            dCalculateHealingModifier *= increaseHealingAgainst.getValue().doubleValue();
        }
        int iMax = Math.max(1, Utils.round(entity.rollAttackDamage() * dCalculateCriticalMultiplier * dCalculateHealingModifier * 0.5d));
        int currentHp = entity2.getCurrentHp();
        int iCalculateTotalMaxHp = entity2.calculateTotalMaxHp();
        int iMin = Math.min(iCalculateTotalMaxHp, currentHp + iMax);
        entity2.setCurrentHp(iMin);
        if (z2) {
            QuestsManager.increment(QuestsManager.medic, iMin - currentHp);
        }
        if (entity.getMaxOverheal() > 0) {
            int i2 = (iMax - iCalculateTotalMaxHp) + currentHp;
            i = 0;
            entity2.setCurrentShield(Math.max(entity2.getCurrentShield(), Math.min(entity2.getCurrentShield() + Math.max(0, i2), Utils.round(((double) iCalculateTotalMaxHp) * 0.01d * ((double) entity.getMaxOverheal())))));
        } else {
            i = 0;
        }
        Logger.log(this, 24, Integer.valueOf(z ? 2 : dCalculateCriticalMultiplier > 1.0d ? 1 : i), entity, entity2, Integer.valueOf(iMax));
        if (entity.isCleanser()) {
            if (entity instanceof ChiefScientistAva) {
                Iterator<StatusEffect> it2 = entity2.getNegativeStatusEffects().iterator();
                while (it2.hasNext()) {
                    Logger.log(this, 10, entity2, it2.next().getType());
                }
                entity2.getNegativeStatusEffects().clear();
            } else {
                StatusEffect statusEffect = null;
                for (StatusEffect statusEffect2 : entity2.getNegativeStatusEffects()) {
                    if (statusEffect == null || statusEffect.getTurnsLeft() < statusEffect2.getTurnsLeft()) {
                        statusEffect = statusEffect2;
                    }
                }
                if (statusEffect != null) {
                    entity2.getNegativeStatusEffects().remove(statusEffect);
                    Logger.log(this, 10, entity2, statusEffect.getType());
                }
            }
        }
        Iterator<StatusEffect> it3 = entity.onTargetHitEffects().iterator();
        while (it3.hasNext()) {
            applyStatus(entity2, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
        }
        if (skill == null || skill.applyEffectOnDodge) {
            return;
        }
        applyStatus(entity2, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01d);
    }

    private double calculateCriticalMultiplier(Entity entity, Skill skill, double d) {
        if (Utils.random() >= entity.calculateCriticalChance()) {
            return 1.0d;
        }
        double dCalculateCriticalDamage = entity.calculateCriticalDamage();
        if (skill != null) {
            dCalculateCriticalDamage *= skill.criticalAmplification;
        }
        if (d > 0.0d) {
            dCalculateCriticalDamage -= (dCalculateCriticalDamage - 1.0d) * d;
        }
        if (entity instanceof Adventurer) {
            QuestsManager.increment(QuestsManager.criticalHit, 1L);
            if (dCalculateCriticalDamage >= 2.5d) {
                QuestsManager.increment(QuestsManager.pulverization, 1L);
            }
        }
        return dCalculateCriticalDamage;
    }

    protected void applyStatus(Entity entity, StatusEffect statusEffect, double d) {
        if (statusEffect == null || entity == null) {
            return;
        }
        if (entity.getPassiveSkill() == Skills.PASSIVE_BEND_REALITY) {
            if (statusEffect.getType() == StatusEffectType.TAUNT || statusEffect.getType() == StatusEffectType.LESSER_CURSE || statusEffect.getType() == StatusEffectType.CURSE || statusEffect.getType() == StatusEffectType.GREATER_CURSE || statusEffect.getType() == StatusEffectType.OMINOUS_CURSE || statusEffect.getType() == StatusEffectType.ABHORRENT_CURSE) {
                return;
            }
            applyStatus(statusEffect.getCause(), statusEffect, d);
            return;
        }
        int iAddStatusEffect = entity.addStatusEffect(statusEffect, d);
        if (iAddStatusEffect > 0) {
            if (entity instanceof Enemy) {
                if (statusEffect.getType() == StatusEffectType.STUN) {
                    QuestsManager.increment(QuestsManager.shocking, 1L);
                }
                if (statusEffect.getType() == StatusEffectType.ABLAZE) {
                    QuestsManager.increment(QuestsManager.smokingHot, 1L);
                }
            }
            if (iAddStatusEffect < 999) {
                Logger.log(this, 11, entity, statusEffect.getType(), Integer.valueOf(iAddStatusEffect));
            } else {
                Logger.log(this, 12, entity, statusEffect.getType());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0035 A[SYNTHETIC] */
    protected void trapEncounter(int i, int i2, int i3, int i4, boolean z) {
        double d = 0.0d;
        int iCalculateTotalIntelligence = 0;
        double d2;
        double d3 = 1.0d;
        Pet pet;
        int barrier;
        Logger.log(this, 101, Integer.valueOf(i));
        Logger.log(this, 25, Integer.valueOf(i2), Integer.valueOf(i3));
        ArrayList<Adventurer> arrayList = new ArrayList(this.adventurersExploring);
        arrayList.sort(new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Area.lambda$trapEncounter$1((Adventurer) obj, (Adventurer) obj2);
            }
        });
        for (Adventurer adventurer : arrayList) {
            if (adventurer.getCurrentHp() > 0) {
                if (adventurer.isSaboteur()) {
                    iCalculateTotalIntelligence = adventurer.calculateTotalDexterity();
                } else if (i2 == R.string.constitution) {
                    iCalculateTotalIntelligence = adventurer.calculateTotalConstitution();
                } else if (i2 == R.string.dexterity) {
                    iCalculateTotalIntelligence = adventurer.calculateTotalDexterity();
                } else {
                    if (i2 == R.string.intelligence) {
                        iCalculateTotalIntelligence = adventurer.calculateTotalIntelligence();
                    } else {
                        d = 0.0d;
                    }
                    double d4 = i3;
                    d2 = d4 / (d + d4);
                    if (this.localDarkness > 0 && !adventurer.isNightVision()) {
                        d2 -= (((double) this.localDarkness) * 0.01d) * (d2 - 1.0d);
                    }
                    d3 = d2;
                    if (Utils.random() > d3) {
                        QuestsManager.increment(QuestsManager.itsATrap, 1L);
                        Logger.log(this, 26, adventurer, Integer.valueOf(100 - Utils.round(d3 * 100.0d)));
                        if (adventurer.isSaboteur()) {
                            Logger.log(this, 28, adventurer);
                            return;
                        }
                    } else {
                        pet = this.petExploring;
                        if (pet != null) {
                            barrier = pet.getBarrier();
                        } else {
                            barrier = 0;
                        }
                        Logger.log(this, 27, adventurer, Integer.valueOf(adventurer.applyDamage(Utils.round((z ? magicDamageAmplification() : 1.0d) * ((double) i4)), z, barrier, 0.0d)), Integer.valueOf(100 - ((int) (d3 * 100.0d))));
                        checkDeath(adventurer);
                    }
                }
                d = iCalculateTotalIntelligence;
                double d5 = i3;
                d2 = d5 / (d + d5);
                if (this.localDarkness > 0) {
                    d2 -= (((double) this.localDarkness) * 0.01d) * (d2 - 1.0d);
                }
                d3 = d2;
                if (Utils.random() > d3) {
                    QuestsManager.increment(QuestsManager.itsATrap, 1L);
                    Logger.log(this, 26, adventurer, Integer.valueOf(100 - Utils.round(d3 * 100.0d)));
                    if (adventurer.isSaboteur()) {
                        Logger.log(this, 28, adventurer);
                        return;
                    }
                } else {
                    pet = this.petExploring;
                    if (pet != null) {
                        barrier = pet.getBarrier();
                    } else {
                        barrier = 0;
                    }
                    Logger.log(this, 27, adventurer, Integer.valueOf(adventurer.applyDamage(Utils.round((z ? magicDamageAmplification() : 1.0d) * ((double) i4)), z, barrier, 0.0d)), Integer.valueOf(100 - ((int) (d3 * 100.0d))));
                    checkDeath(adventurer);
                }
            }
        }
    }

    static /* synthetic */ int lambda$trapEncounter$1(Adventurer adventurer, Adventurer adventurer2) {
        if (adventurer.isSaboteur() == adventurer2.isSaboteur()) {
            return 0;
        }
        return adventurer.isSaboteur() ? -1 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x022d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x022f  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v131 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, still in use, count: 2, list:
          (r2v131 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy) from 0x0225: INSTANCE_OF (r2v131 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy) A[WRAPPED] (LINE:1715) it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.MagicArmor
          (r2v131 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy) from 0x022b: PHI (r2 I:??) = 
          (r2v125 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy)
          (r2v131 it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy)
         binds: [B:47:0x022a, B:235:0x022b] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
        public List<Entity> cast(Entity entity) {
        if ((entity instanceof Adventurer) && magicDamageAmplification() >= 1.6d) {
            QuestsManager.increment(QuestsManager.laroxianPower, 1L);
        }
        Skill skill = new Skill(entity);
        switch (entity.getActiveSkill()) {
        case ACTIVE_MIGHTY_STRIKE:
            return skill.setDamageAmplification(2.0d).execute();
        case ACTIVE_CRUSHING_STRIKE:
            return skill.setDamageAmplification(2.5d).execute();
        case ACTIVE_TAUNT_I:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 2, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.0d).execute();
        case ACTIVE_TAUNT_II:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 4, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.0d).execute();
        case ACTIVE_TAUNT_III:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 8, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.0d).execute();
        case ACTIVE_TAUNT_IV:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 8, 1.0d)).applyEffectOnDodge().setDamageAmplification(6.0d).execute();
        case ACTIVE_EN_GARDE:
            StatusEffect stance = new StatusEffect(StatusEffectType.DEFENSIVE_STANCE, entity, 999, 1.0d);
            applyStatus(entity, stance, 0.0d);
            return skill.setDamageAmplification(2.0d).execute();
        case ACTIVE_OVERWHELM:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 0.7d)).setDamageAmplification(3.0d).execute();
        case ACTIVE_DECIMATE_I:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 0.7d)).setDamageAmplification(3.0d).execute();
        case ACTIVE_DECIMATE_II:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d)).setDamageAmplification(3.0d).execute();
        case ACTIVE_DECIMATE_III:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d)).setDamageAmplification(4.0d).execute();
        case ACTIVE_CONDEMN:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.5d).execute();
        case ACTIVE_CONDEMN_ALL_I:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 1, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.5d).execute();
        case ACTIVE_CONDEMN_ALL_II:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 2, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.5d).execute();
        case ACTIVE_BARRAGE_I:
            return skill.setTargetSelectionMode("2").execute();
        case ACTIVE_BARRAGE_II:
            boolean hasFeebleTether = false;
            if (entity.getTrueClass().equals("EldritchAlchemist")) {
                for (StatusEffect se : entity.getPositiveStatusEffects()) {
                    if (se.getType() == StatusEffectType.FEEBLE_TETHER) {
                        hasFeebleTether = true;
                        break;
                    }
                }
            }
            double damageAmp = hasFeebleTether ? 10.0d : 1.0d;
            return skill.setTargetSelectionMode("3").setDamageAmplification(damageAmp).execute();
        case ACTIVE_BARRAGE_III:
            return skill.setTargetSelectionMode("4").execute();
        case ACTIVE_BARRAGE_IV:
            return skill.setTargetSelectionMode("5").execute();
        case ACTIVE_BARRAGE_V:
            return skill.setTargetSelectionMode("6").execute();
        case ACTIVE_BARRAGE_VI:
            return skill.setTargetSelectionMode("7").execute();
        case ACTIVE_BARRAGE_VII:
            return skill.setTargetSelectionMode("9").execute();
        case ACTIVE_BARRAGE_VIII:
            return skill.setTargetSelectionMode("11").execute();
        case ACTIVE_FOCUSED_BARRAGE:
            skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5d).execute();
            return skill.noLog().execute();
        case ACTIVE_INCINERATE:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).applyEffectOnDodge().setDamageAmplification(2.0d).setForceRange(true).execute();
        case ACTIVE_INCINERATE_II:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).applyEffectOnDodge().setDamageAmplification(3.0d).setForceRange(true).execute();
        case ACTIVE_SUBLIMATE:
            skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).applyEffectOnDodge().setDamageAmplification(1.7d).setForceRange(true).execute();
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.FROZEN, entity, 2, 1.0d)).setDamageAmplification(1.7d).noLog().execute();
        case ACTIVE_BACKSTAB_I:
            return skill.setCriticalAmplification(1.5d).execute();
        case ACTIVE_BACKSTAB_II:
            return skill.setCriticalAmplification(2.0d).execute();
        case ACTIVE_BACKSTAB_III:
            return skill.setCriticalAmplification(3.0d).execute();
        case ACTIVE_UMBRAL_STRIKE_I:
            return skill.setCriticalAmplification(1.5d).setDamageAmplification(3.0d).execute();
        case ACTIVE_UMBRAL_STRIKE_II:
            return skill.setCriticalAmplification(1.5d).setDamageAmplification(3.0d).execute();
        case ACTIVE_UMBRAL_STRIKE_III:
            return skill.setCriticalAmplification(2.0d).setDamageAmplification(3.0d).execute();
        case ACTIVE_ECLIPSE_I:
            return skill.setTargetSelectionMode("lowest_absolute_enemy").setCriticalAmplification(3.0d).recastOnKill().execute();
        case ACTIVE_ECLIPSE_II:
            return skill.setTargetSelectionMode("lowest_relative_enemy").setCriticalAmplification(3.0d).setExecutionThreshold(0.1d).recastOnKill().execute();
        case ACTIVE_ECLIPSE_III:
            return skill.setTargetSelectionMode("lowest_relative_enemy").setCriticalAmplification(3.0d).setExecutionThreshold(0.2d).recastOnKill().execute();
        case ACTIVE_ECLIPSE_IV:
            return skill.setTargetSelectionMode("lowest_relative_enemy").setCriticalAmplification(3.0d).setExecutionThreshold(0.25d).recastOnKill().execute();
        case ACTIVE_FEINT:
            return skill.setTargetSelectionMode("random_enemy").setCriticalAmplification(1.5d).setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d)).execute();
        case ACTIVE_PETRIFYING_MELODY:
            return skill.setTargetSelectionMode("random_enemy").setCriticalAmplification(1.5d).setForceRange(true).setStatusEffect(new StatusEffect(StatusEffectType.PETRIFY, entity, 1, 1.0d)).execute();
        case ACTIVE_THOUSAND_CUTS:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.BLEED, entity, 0, 1.0d)).setCriticalAmplification(3.0d).execute();
        case ACTIVE_THOUSAND_CUTS_II:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.BLEED, entity, 0, 1.0d)).setCriticalAmplification(3.0d).execute();
        case ACTIVE_ENERGY_BURST_I:
            return skill.setDamageAmplification(1.5d).setForceRange(true).execute();
        case ACTIVE_ENERGY_BURST_II:
            return skill.setDamageAmplification(2.0d).setForceRange(true).execute();
        case ACTIVE_FIRE_BURST:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).setForceRange(true).setDamageAmplification(2.0d).execute();
        case ACTIVE_FIREBALL:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.0d).execute();
        case ACTIVE_METEOR_I:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.3d).execute();
        case ACTIVE_METEOR_II:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 2, 1.0d)).setTargetSelectionMode("all_enemies").setForceRange(true).setDamageAmplification(2.3d).execute();
        case ACTIVE_HEAL:
            return skill.setTargetSelectionMode("lowest_relative_ally").healing().setDamageAmplification(2.0d).execute();
        case ACTIVE_MASS_HEAL_I:
            return skill.setTargetSelectionMode("all_allies").healing().setDamageAmplification(2.0d).execute();
        case ACTIVE_MASS_HEAL_II:
            return skill.setTargetSelectionMode("all_allies").healing().setStatusEffect(new StatusEffect(StatusEffectType.REGENERATION, entity, 2, 1.0d)).setDamageAmplification(2.0d).execute();
        case ACTIVE_MASS_HEAL_III:
            return skill.setTargetSelectionMode("all_allies").healing().setStatusEffect(new StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0d)).setDamageAmplification(2.3d).execute();
        case ACTIVE_RESTORATION_I:
            return skill.setTargetSelectionMode("all_allies").healing().setStatusEffect(new StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0d)).setDamageAmplification(2.3d).setReviveProbability(0.04d).execute();
        case ACTIVE_RESTORATION_II:
            return skill.setTargetSelectionMode("all_allies").healing().setStatusEffect(new StatusEffect(StatusEffectType.REGENERATION, entity, 3, 1.0d)).setDamageAmplification(2.6d).setReviveProbability(0.06d).execute();
        case ACTIVE_CURSE_I:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.LESSER_CURSE, entity, 999, 1.0d)).setDamageAmplification(3.0d).execute();
        case ACTIVE_CURSE_II:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.CURSE, entity, 999, 1.0d)).setDamageAmplification(3.25d).execute();
        case ACTIVE_CURSE_III:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.GREATER_CURSE, entity, 999, 1.0d)).setDamageAmplification(3.5d).execute();
        case ACTIVE_CURSE_IV:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.OMINOUS_CURSE, entity, 999, 1.0d)).setDamageAmplification(3.75d).execute();
        case ACTIVE_CURSE_V:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.ABHORRENT_CURSE, entity, 999, 1.0d)).setDamageAmplification(4.0d).execute();
        case ACTIVE_FLAY:
            return skill.setTargetSelectionMode("random_except_self").setDamageAmplification(10.0d).setForceRange(false).execute();
        case ACTIVE_ANNIHILATE:
            return skill.setTargetSelectionMode("all_except_self").setDamageAmplification(10.0d).setForceRange(false).execute();
        case ACTIVE_OBLITERATE:
            return skill.setTargetSelectionMode("all_except_self").setDamageAmplification(20.0d).setForceRange(false).execute();
        case ACTIVE_EXTIRPATE:
            return skill.setTargetSelectionMode("all_except_self").setDamageAmplification(30.0d).setForceRange(false).execute();
        case ACTIVE_WHIP_AND_TEAR:
            skill.setTargetSelectionMode("all_except_self").setDamageAmplification(30.0d).setForceRange(false).execute();
            return skill.setTargetSelectionMode("random_except_self").setForceRange(true).noLog().execute();
        case ACTIVE_STOMP:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d)).execute();
        case ACTIVE_ESCAPE:
            this.enemies.remove(entity);
            this.fightingGroup.remove(entity);
            Logger.log(this, 43, Integer.valueOf(entity.getIdName()));
            return null;
        case ACTIVE_SOOTHING_WINDS:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 3, 0.6d)).applyEffectOnDodge().execute();
        case ACTIVE_QUICKSAND_GRASP:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 4, 1.0d)).setDamageAmplification(2.0d).execute();
        case ACTIVE_SANDSTORM:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 5, 0.8d)).setDamageAmplification(0.5d).applyEffectOnDodge().execute();
        case ACTIVE_RESTORE_ORDER:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.9d).execute();
        case ACTIVE_PROTECT_THE_WEAK:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 2, 1.0d)).setDamageAmplification(0.1d).applyEffectOnDodge().execute();
        case ACTIVE_STATIC_SURGE:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 0.5d)).setDamageAmplification(2.5d).execute();
        case ACTIVE_ARCANE_STRIKE:
            return skill.setDamageAmplification(4.0d).execute();
        case ACTIVE_FLINTLOCK_SHOT:
            return skill.setDamageAmplification(2.0d).setForceRange(true).setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 1, 1.0d)).execute();
        case ACTIVE_ICE_TOMB:
            return skill.setStatusEffect(new StatusEffect(StatusEffectType.FROZEN, entity, 20, 1.0d)).setDamageAmplification(10.0d).execute();
        case ACTIVE_FROZEN_BREATH:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.FROZEN, entity, 2, 1.0d)).execute();
        case ACTIVE_ARCANE_BARRAGE:
            return skill.setTargetSelectionMode("12").execute();
        case ACTIVE_DESERT_JUDGEMENT:
            return skill.setTargetSelectionMode("4").setDamageAmplification(1.5d).execute();
        case ACTIVE_DISEMBODY:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(1111.0d).setCriticalAmplification(0.66d).execute();
        case ACTIVE_PANDEMONIUM:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.75d).setCriticalAmplification(0.66d).execute();
        case ACTIVE_FRAGMENTATION:
            entity.setCurrentHp(Math.max(1, entity.getCurrentHp() - 5000));
            Logger.log(this, 101, Integer.valueOf(R.string.log_the_cultist_rebels_fragmentation));
            return skill.setTargetSelectionMode("5").setForceRange(true).execute();
        case ACTIVE_ARCANE_DIFFUSION:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.4d).execute();
        case ACTIVE_SACRIFICE:
            return skill.setDamageAmplification(100.0d).setCriticalAmplification(0.66d).execute();
        case ACTIVE_CHOKING_POWDER:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.4d).setStatusEffect(new StatusEffect(StatusEffectType.SILENCE, entity, 3, 1.0d)).applyEffectOnDodge().execute();
        case ACTIVE_DAZE:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.1d).setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 2, 1.0d)).execute();
        case ACTIVE_FLEECE:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.35d).setStatusEffect(new StatusEffect(StatusEffectType.BLEED, entity, 40, 1.0d)).execute();
        case ACTIVE_DISASSEMBLE:
            return skill.setTargetSelectionMode("all_enemies").setStatusEffect(new StatusEffect(StatusEffectType.TAUNT, entity, 5, 1.0d)).setDamageAmplification(0.1d).applyEffectOnDodge().execute();
        case ACTIVE_OVERDRIVE:
            Enemy magicArmor = null;
            for (Enemy e : this.enemies) {
                if (e instanceof it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.MagicArmor) {
                    magicArmor = e;
                    break;
                }
            }
            if (magicArmor == null) {
                return null;
            }
            magicArmor.setCurrentHp(Math.max(1, magicArmor.getCurrentHp() - 300));
            Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_overdrive));
            StatusEffect stun = new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d);
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.7d).setStatusEffect(stun).execute();
        case ACTIVE_RAYS_OF_DESTRUCTION:
            return skill.setTargetSelectionMode("8").setDamageAmplification(0.4d).execute();
        case ACTIVE_THE_TEN_HELLS:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(100000.0d).setCriticalAmplification(0.66d).execute();
        case ACTIVE_INSTILL_TERROR:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.15d).setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 1, 1.0d)).applyEffectOnDodge().execute();
        case ACTIVE_FIRE_DANCE:
            Logger.log(this, 29, entity);
            if (this.event == null) {
                this.event = new Event("summon_smoldering_titan");
            }
            int progress = Math.min(100, this.event.getProgress() + 1 + ((int) (Utils.random() * 5.0d)));
            this.event.setProgress(progress);
            StatusEffect ablaze = new StatusEffect(StatusEffectType.ABLAZE, this.acting, 3, 1.0d);
            applyStatus(entity, ablaze, 0.0d);
            Logger.log(this, 113, Integer.valueOf(this.event.getProgress()));
            return null;
        case ACTIVE_BOTCHED_SACRIFICE:
            Logger.log(this, 115, entity);
            return null;
        case ACTIVE_DREAM_FORGE:
            int newHp = Math.min(entity.calculateTotalMaxHp(), entity.getCurrentHp() + 10000);
            entity.setCurrentHp(newHp);
            Logger.log(this, 24, Integer.valueOf(0), entity, entity, Integer.valueOf(10000));
            return skill.setTargetSelectionMode("10").setDamageAmplification(2.0d).execute();
        case ACTIVE_GRAVITY_SHIFT:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5d).execute();
        case ACTIVE_SMASH:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5d).execute();
        case ACTIVE_LIGHTS_OUT:
            return skill.setTargetSelectionMode("lowest_relative_enemy").setDamageAmplification(10.0d).execute();
        case ACTIVE_LIVE_TEST:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.05d).setStatusEffect(new StatusEffect(StatusEffectType.POISON, entity, 3, 1.0d)).applyEffectOnDodge().execute();
        case ACTIVE_AT_THE_STAKE:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.2d).setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 4, 1.0d)).execute();
        case ACTIVE_TABULA_RASA:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.5d).setStatusEffect(new StatusEffect(StatusEffectType.ABLAZE, entity, 2, 1.0d)).execute();
        case ACTIVE_BOUNCE:
            return skill.setTargetSelectionMode("10").setDamageAmplification(0.5d).setStatusEffect(new StatusEffect(StatusEffectType.STUN, entity, 4, 1.0d)).execute();
        case ACTIVE_DEVOUR_SPIRIT:
            return skill.setTargetSelectionMode("all_enemies").setDamageAmplification(0.2d).setStatusEffect(new StatusEffect(StatusEffectType.TERRIFY, entity, 1, 1.0d)).execute();
        default:
            return null;
        }
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills;
        static final /* synthetic */ int[] $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType;

        static {
            int[] iArr = new int[Skills.values().length];
            $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills = iArr;
            try {
                iArr[Skills.ACTIVE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_MIGHTY_STRIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CRUSHING_STRIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_TAUNT_I.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_TAUNT_II.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_TAUNT_III.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_TAUNT_IV.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_EN_GARDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_OVERWHELM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DECIMATE_I.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DECIMATE_II.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DECIMATE_III.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CONDEMN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CONDEMN_ALL_I.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CONDEMN_ALL_II.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_I.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_II.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_III.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_IV.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_V.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_VI.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_VII.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BARRAGE_VIII.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FOCUSED_BARRAGE.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_INCINERATE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_INCINERATE_II.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_SUBLIMATE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BACKSTAB_I.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BACKSTAB_II.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BACKSTAB_III.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_UMBRAL_STRIKE_I.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_UMBRAL_STRIKE_II.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_UMBRAL_STRIKE_III.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ECLIPSE_I.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ECLIPSE_II.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ECLIPSE_III.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ECLIPSE_IV.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FEINT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_PETRIFYING_MELODY.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_THOUSAND_CUTS.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_THOUSAND_CUTS_II.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ENERGY_BURST_I.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ENERGY_BURST_II.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FIRE_BURST.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FIREBALL.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_METEOR_I.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_METEOR_II.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_HEAL.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_MASS_HEAL_I.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_MASS_HEAL_II.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_MASS_HEAL_III.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_RESTORATION_I.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_RESTORATION_II.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CURSE_I.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CURSE_II.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CURSE_III.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CURSE_IV.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CURSE_V.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FLAY.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ANNIHILATE.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_OBLITERATE.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_EXTIRPATE.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_WHIP_AND_TEAR.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_STOMP.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ESCAPE.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_SOOTHING_WINDS.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_QUICKSAND_GRASP.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_SANDSTORM.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_RESTORE_ORDER.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_PROTECT_THE_WEAK.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_STATIC_SURGE.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ARCANE_STRIKE.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FLINTLOCK_SHOT.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ICE_TOMB.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FROZEN_BREATH.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ARCANE_BARRAGE.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DESERT_JUDGEMENT.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DISEMBODY.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_PANDEMONIUM.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FRAGMENTATION.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_ARCANE_DIFFUSION.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_SACRIFICE.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_CHOKING_POWDER.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DAZE.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FLEECE.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DISASSEMBLE.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_OVERDRIVE.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_RAYS_OF_DESTRUCTION.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_THE_TEN_HELLS.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_INSTILL_TERROR.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_FIRE_DANCE.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BOTCHED_SACRIFICE.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DREAM_FORGE.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_GRAVITY_SHIFT.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_SMASH.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_LIGHTS_OUT.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_LIVE_TEST.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_AT_THE_STAKE.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_TABULA_RASA.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_BOUNCE.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$Skills[Skills.ACTIVE_DEVOUR_SPIRIT.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            int[] iArr2 = new int[StatusEffectType.values().length];
            $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType = iArr2;
            try {
                iArr2[StatusEffectType.TAUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.POISON.ordinal()] = 2;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FROZEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.STUN.ordinal()] = 4;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.STUN_NOT_CLEANSABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.PETRIFY.ordinal()] = 6;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.SILENCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.ABLAZE.ordinal()] = 8;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.TERRIFY.ordinal()] = 9;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.REGENERATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.BLEED.ordinal()] = 11;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FEEBLE_TETHER.ordinal()] = 12;
            } catch (NoSuchFieldError unused113) {
            }
        }
    }

    private class Skill {
        private Entity caster;
        private String targetSelectionMode = Area.TARGET_RANDOM_ENEMY;
        private double criticalAmplification = 1.0d;
        private boolean healing = false;
        private StatusEffect statusEffect = null;
        private boolean applyEffectOnDodge = false;
        private double damageAmplification = 1.0d;
        private Boolean forceRange = null;
        private double executionThreshold = 0.0d;
        private boolean recastOnKill = false;
        private boolean noLog = false;
        private double reviveProbability = 0.0d;

        public Skill(Entity entity) {
            this.caster = entity;
        }

        public Skill setTargetSelectionMode(String str) {
            this.targetSelectionMode = str;
            return this;
        }

        public Skill setCriticalAmplification(double d) {
            this.criticalAmplification = d;
            return this;
        }

        public Skill healing() {
            this.healing = true;
            return this;
        }

        public Skill setStatusEffect(StatusEffect statusEffect) {
            this.statusEffect = statusEffect;
            return this;
        }

        public Skill applyEffectOnDodge() {
            this.applyEffectOnDodge = true;
            return this;
        }

        public Skill setDamageAmplification(double d) {
            this.damageAmplification = d;
            return this;
        }

        public Skill setForceRange(Boolean bool) {
            this.forceRange = bool;
            return this;
        }

        public Skill setExecutionThreshold(double d) {
            this.executionThreshold = d;
            return this;
        }

        public Skill recastOnKill() {
            this.recastOnKill = true;
            return this;
        }

        public Skill noLog() {
            this.noLog = true;
            return this;
        }

        public Skill setReviveProbability(double d) {
            this.reviveProbability = d;
            return this;
        }

        public List<Entity> execute() {
            List<Entity> listSelectTargets = Area.this.selectTargets(this.caster, this.targetSelectionMode);
            if (listSelectTargets == null) {
                return null;
            }
            if (!this.noLog) {
                if ((this.caster instanceof Adventurer) && !this.healing) {
                    QuestsManager.increment(QuestsManager.tormentor, 1L);
                }
                Logger.log(Area.this.getCurrentInstance(), 29, this.caster);
            }
            for (Entity entity : listSelectTargets) {
                double bonusResurrectChance = this.reviveProbability + (((double) this.caster.getBonusResurrectChance()) * 0.01d);
                if (this.healing && entity.getCurrentHp() <= 0 && Utils.random() < bonusResurrectChance) {
                    entity.setCurrentHp(1);
                    if (this.caster instanceof Adventurer) {
                        QuestsManager.increment(QuestsManager.miracle, 1L);
                    }
                    Logger.log(Area.this.getCurrentInstance(), 30, entity, this.caster);
                }
                if (entity.getCurrentHp() > 0) {
                    if (this.applyEffectOnDodge) {
                        Area.this.applyStatus(entity, this.statusEffect, this.caster.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                    if (this.healing) {
                        Area.this.heal(this.caster, entity, this);
                    } else {
                        Area.this.dealDamage(this.caster, entity, this, null);
                    }
                    if (this.recastOnKill && entity.getCurrentHp() <= 0 && this.caster.getCurrentHp() > 0) {
                        Area.this.cast(this.caster);
                    }
                }
            }
            return listSelectTargets;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0197  */
    /* JADX WARN: Code duplicated, block: B:102:0x019f  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:121:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:123:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:126:0x0201  */
    /* JADX WARN: Code duplicated, block: B:127:0x0207  */
    /* JADX WARN: Code duplicated, block: B:130:0x0211  */
    /* JADX WARN: Code duplicated, block: B:135:0x0223  */
    /* JADX WARN: Code duplicated, block: B:143:0x0248  */
    /* JADX WARN: Code duplicated, block: B:146:0x0267  */
    /* JADX WARN: Code duplicated, block: B:148:0x026b  */
    /* JADX WARN: Code duplicated, block: B:151:0x0279  */
    /* JADX WARN: Code duplicated, block: B:157:0x028d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0295  */
    /* JADX WARN: Code duplicated, block: B:161:0x0297  */
    /* JADX WARN: Code duplicated, block: B:163:0x029b  */
    /* JADX WARN: Code duplicated, block: B:164:0x029d  */
    /* JADX WARN: Code duplicated, block: B:167:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:169:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:172:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:175:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:178:0x0304  */
    /* JADX WARN: Code duplicated, block: B:179:0x0312  */
    /* JADX WARN: Code duplicated, block: B:187:0x034d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:189:0x0354  */
    /* JADX WARN: Code duplicated, block: B:192:0x0366  */
    /* JADX WARN: Code duplicated, block: B:196:0x0372  */
    /* JADX WARN: Code duplicated, block: B:198:0x0389  */
    /* JADX WARN: Code duplicated, block: B:201:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:203:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:208:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:210:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:213:0x0407 A[LOOP:1: B:211:0x0401->B:213:0x0407, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:216:0x0421  */
    /* JADX WARN: Code duplicated, block: B:221:0x0446  */
    /* JADX WARN: Code duplicated, block: B:234:0x01df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:? A[LOOP:3: B:111:0x01cb->B:235:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0098  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00da  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:73:0x011b  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:85:0x014f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0154  */
    /* JADX WARN: Code duplicated, block: B:88:0x0157  */
    /* JADX WARN: Code duplicated, block: B:92:0x0171  */
    /* JADX WARN: Code duplicated, block: B:94:0x0183  */
    public void dealDamage(Entity entity, Entity entity2, Skill skill, EndOfTurnAction endOfTurnAction) {
        Boolean bool = null;
        StatusEffect statusEffect = null;
        int iDamageOnFalseLifeRemoval = 0;
        boolean z;
        double livingCompanionBonusDamage;
        double dCalculateCriticalMultiplier;
        double d;
        boolean z2;
        double dCalculateTotalDarknessDamageAmplification;
        double d2;
        boolean z3;
        Iterator<StatusEffect> it2;
        boolean zIsMagic;
        double dMagicDamageAmplification;
        double dRollAttackDamage;
        Pet pet;
        int barrier;
        int i;
        int iApplyDamage;
        int i2;
        EndOfTurnAction endOfTurnAction2;
        int i3;
        double d3 = 1.0d;
        Pet pet2;
        int i4;
        Pet pet3;
        double lifesteal;
        int iRound;
        Iterator<StatusEffect> it3;
        int currentHp;
        int iCalculateTotalMaxHp;
        int iMin;
        Adventurer minionBound;
        Entity entity3 = entity2;
        boolean z4 = entity instanceof Adventurer;
        boolean z5 = entity3 instanceof Adventurer;
        if (skill != null && skill.forceRange != null) {
            bool = skill.forceRange;
        } else {
            bool = (endOfTurnAction == null || endOfTurnAction.forceRange == null) ? null : endOfTurnAction.forceRange;
        }
        boolean zBooleanValue = bool != null ? bool.booleanValue() : entity.isRanged();
        boolean z6 = skill == null && (endOfTurnAction == null || endOfTurnAction.replicatesBasicAttack);
        if (dodge(entity, entity3, z6, zBooleanValue)) {
            if (z5) {
                QuestsManager.increment(QuestsManager.hitOrMiss, 1L);
                return;
            }
            return;
        }
        Iterator<StatusEffect> it4 = entity2.getPositiveStatusEffects().iterator();
        while (true) {
            if (it4.hasNext()) {
                StatusEffect next = it4.next();
                if (next.getType() == StatusEffectType.DEFENSIVE_STANCE || next.getType() == StatusEffectType.FALSE_LIFE) {
                    if (next.getType() == StatusEffectType.FALSE_LIFE) {
                        iDamageOnFalseLifeRemoval = ((Adventurer) entity3).getDoctrine().damageOnFalseLifeRemoval();
                        statusEffect = next;
                    } else {
                        statusEffect = next;
                    }
                    if (statusEffect != null) {
                        entity2.getPositiveStatusEffects().remove(statusEffect);
                        if (z6) {
                            Logger.log(this, 31, entity, entity2);
                        } else {
                            Logger.log(this, 32, entity2);
                        }
                        Logger.log(this, 10, entity3, statusEffect.getType());
                        z3 = zBooleanValue;
                        endOfTurnAction2 = endOfTurnAction;
                        i = iDamageOnFalseLifeRemoval;
                        iApplyDamage = 0;
                    } else {
                        if (endOfTurnAction == null && endOfTurnAction.flatDamage) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (skill != null) {
                            livingCompanionBonusDamage = skill.damageAmplification;
                        } else {
                            livingCompanionBonusDamage = 1.0d;
                        }
                        if (endOfTurnAction != null && endOfTurnAction.fromLivingCompanion) {
                            livingCompanionBonusDamage = (((double) entity.getLivingCompanionBonusDamage()) * 0.01d) + 1.0d;
                        }
                        if (entity.isMoreDamageWhenHalfLife() && entity.getCurrentHp() <= ((double) entity.calculateTotalMaxHp()) * 0.5d) {
                            livingCompanionBonusDamage *= 1.5d;
                        }
                        if (entity.isMoreDamageDealtAndTaken()) {
                            livingCompanionBonusDamage *= 1.35d;
                        }
                        if (entity2.isMoreDamageDealtAndTaken()) {
                            livingCompanionBonusDamage *= 1.35d;
                        }
                        if (z) {
                            dCalculateCriticalMultiplier = 1.0d;
                        } else {
                            dCalculateCriticalMultiplier = calculateCriticalMultiplier(entity, skill, entity2.getCriticalReduction());
                        }
                        if (z4 || (pet2 = this.petExploring) == null || dCalculateCriticalMultiplier <= 1.0d || pet2.getSavage() <= 0.0d || Utils.random() >= this.petExploring.getSavage() / 100.0d) {
                            d = dCalculateCriticalMultiplier;
                            z2 = false;
                        } else {
                            d = dCalculateCriticalMultiplier * dCalculateCriticalMultiplier;
                            z2 = true;
                        }
                        if (z) {
                            dCalculateTotalDarknessDamageAmplification = 1.0d;
                        } else {
                            dCalculateTotalDarknessDamageAmplification = (entity.calculateTotalDarknessDamageAmplification() * ((double) this.localDarkness)) + 1.0d;
                        }
                        d2 = 1.0d;
                        for (StatusEffect statusEffect2 : entity.getPositiveStatusEffects()) {
                            boolean z7 = zBooleanValue;
                            int i5 = iDamageOnFalseLifeRemoval;
                            if (statusEffect2.getType() == StatusEffectType.DELIRIUM && statusEffect2.getType() != StatusEffectType.SKELETON_KEY) {
                                if (statusEffect2.getType() == StatusEffectType.FRENZY) {
                                    d3 = 1.3d;
                                } else if (statusEffect2.getType() != StatusEffectType.ANOINTED || statusEffect2.getType() == StatusEffectType.INSPIRE || statusEffect2.getType() == StatusEffectType.EXALT) {
                                    d3 = 1.25d;
                                }
                                d2 *= d3;
                            } else {
                                d2 *= 2.0d;
                            }
                            zBooleanValue = z7;
                            iDamageOnFalseLifeRemoval = i5;
                        }
                        z3 = zBooleanValue;
                        int i6 = iDamageOnFalseLifeRemoval;
                        it2 = entity2.getNegativeStatusEffects().iterator();
                        while (it2.hasNext()) {
                            if (it2.next().getType() == StatusEffectType.PETRIFY) {
                                d2 = 1.1d;
                                break;
                            }
                        }
                        if (endOfTurnAction != null || endOfTurnAction.forceMagic == null) {
                            zIsMagic = entity.isMagic();
                        } else {
                            zIsMagic = endOfTurnAction.forceMagic.booleanValue();
                        }
                        if (zIsMagic) {
                            dMagicDamageAmplification = magicDamageAmplification();
                        } else {
                            dMagicDamageAmplification = 1.0d;
                        }
                        if (z) {
                            dRollAttackDamage = endOfTurnAction.damage;
                        } else {
                            dRollAttackDamage = entity.rollAttackDamage();
                        }
                        if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE) {
                            dRollAttackDamage = entity.getCurrentHp();
                        }
                        pet = this.petExploring;
                        if (pet == null && z5) {
                            barrier = pet.getBarrier();
                        } else {
                            barrier = 0;
                        }
                        if (entity.getPassiveSkill() != Skills.PASSIVE_CHAOTIC && z4 && z5) {
                            entity3 = entity2;
                            if (((Adventurer) entity).getId() == ((Adventurer) entity3).getId()) {
                                dRollAttackDamage = 1.0d;
                            }
                        } else {
                            entity3 = entity2;
                        }
                        boolean z8 = zIsMagic;
                        i = i6;
                        iApplyDamage = entity2.applyDamage(dRollAttackDamage * d * livingCompanionBonusDamage * dCalculateTotalDarknessDamageAmplification * d2 * dMagicDamageAmplification, z8, barrier, entity.getArmorIgnored());
                        if (z4) {
                            if (d > 1.0d) {
                                QuestsManager.increment(QuestsManager.smartFighter, iApplyDamage);
                            }
                            QuestsManager.incrementToValue(QuestsManager.annihilator, iApplyDamage);
                            if (!z5) {
                                QuestsManager.increment(QuestsManager.warrior, 1L);
                            }
                        }
                        if (z5 && iApplyDamage <= 1) {
                            QuestsManager.increment(QuestsManager.unscathed, 1L);
                        }
                        i2 = R.string.log_damage_dealt;
                        endOfTurnAction2 = endOfTurnAction;
                        if (endOfTurnAction2 != null) {
                            i2 = endOfTurnAction2.log;
                        }
                        Integer numValueOf = Integer.valueOf(i2);
                        if (z2) {
                            i3 = 2;
                        } else if (d > 1.0d) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        Logger.log(this, 33, numValueOf, Integer.valueOf(i3), entity, entity3, Integer.valueOf(iApplyDamage));
                    }
                    if (skill != null) {
                        i4 = 0;
                        if (((double) entity2.getCurrentHp()) / ((double) entity2.calculateTotalMaxHp()) < skill.executionThreshold) {
                            entity3.setCurrentHp(0);
                            Logger.log(this, 34, entity3, entity);
                        }
                        if (entity.getActiveSkill() == Skills.ACTIVE_THOUSAND_CUTS) {
                            skill.statusEffect.setTurnsLeft(Utils.round(((double) iApplyDamage) / 3.0d));
                        }
                        if (entity.getActiveSkill() == Skills.ACTIVE_THOUSAND_CUTS_II) {
                            skill.statusEffect.setTurnsLeft(Utils.round(((double) iApplyDamage) / 2.0d));
                        }
                        if (!skill.applyEffectOnDodge) {
                            applyStatus(entity3, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                    } else {
                        i4 = 0;
                        if (endOfTurnAction2 == null && endOfTurnAction2.effect != null) {
                            applyStatus(entity3, new StatusEffect(endOfTurnAction2.effect.getType(), entity, endOfTurnAction2.effect.getTurnsLeft(), endOfTurnAction2.effect.getProbability()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                        pet3 = this.petExploring;
                        if (pet3 == null && z4) {
                            lifesteal = pet3.getLifesteal();
                        } else {
                            lifesteal = 0.0d;
                        }
                        iRound = Utils.round((((double) entity.calculateTotalLifesteal()) + lifesteal) * 0.01d * ((double) iApplyDamage));
                        if (skill != null && entity.getActiveSkill() == Skills.ACTIVE_FRAGMENTATION) {
                            iRound = 1000;
                        }
                        if (iRound > 0) {
                            currentHp = entity.getCurrentHp();
                            iCalculateTotalMaxHp = entity.calculateTotalMaxHp();
                            iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound);
                            entity.setCurrentHp(iMin);
                            if (entity.getMaxLifestealOverheal() > 0) {
                                entity.setCurrentShield(Math.max(entity.getCurrentShield(), Math.min(entity.getCurrentShield() + Math.max(i4, (iRound - iCalculateTotalMaxHp) + currentHp), Utils.round(((double) iCalculateTotalMaxHp) * 0.01d * ((double) entity.getMaxLifestealOverheal())))));
                            }
                            Logger.log(this, 35, entity, Integer.valueOf(iRound));
                            if (z4) {
                                QuestsManager.increment(QuestsManager.vampiricThirst, iMin - currentHp);
                                Adventurer adventurer = (Adventurer) entity;
                                minionBound = adventurer.getMinionBound();
                                if (minionBound != null && adventurer.isHealsMinionBound()) {
                                    minionBound.setCurrentHp(Math.min(minionBound.calculateTotalMaxHp(), minionBound.getCurrentHp() + iRound));
                                    Logger.log(this, 35, minionBound, Integer.valueOf(iRound));
                                }
                            }
                        }
                        if (endOfTurnAction != null || endOfTurnAction.replicatesBasicAttack) {
                            it3 = entity.onTargetHitEffects().iterator();
                            while (it3.hasNext()) {
                                applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                            }
                            if (entity2.getCurrentHp() < entity.getCurrentHp() && entity.getStunChanceOnLowerHp() > 0.0d) {
                                applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                            }
                        }
                        checkDeath(entity3);
                        if (endOfTurnAction != null || endOfTurnAction.triggersRetaliation) {
                            retaliate(entity, entity3, z3, i);
                            return;
                        }
                        return;
                    }
                    pet3 = this.petExploring;
                    if (pet3 == null) {
                        lifesteal = 0.0d;
                    } else {
                        lifesteal = 0.0d;
                    }
                    iRound = Utils.round((((double) entity.calculateTotalLifesteal()) + lifesteal) * 0.01d * ((double) iApplyDamage));
                    if (skill != null) {
                        iRound = 1000;
                    }
                    if (iRound > 0) {
                        currentHp = entity.getCurrentHp();
                        iCalculateTotalMaxHp = entity.calculateTotalMaxHp();
                        iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound);
                        entity.setCurrentHp(iMin);
                        if (entity.getMaxLifestealOverheal() > 0) {
                            entity.setCurrentShield(Math.max(entity.getCurrentShield(), Math.min(entity.getCurrentShield() + Math.max(i4, (iRound - iCalculateTotalMaxHp) + currentHp), Utils.round(((double) iCalculateTotalMaxHp) * 0.01d * ((double) entity.getMaxLifestealOverheal())))));
                        }
                        Logger.log(this, 35, entity, Integer.valueOf(iRound));
                        if (z4) {
                            QuestsManager.increment(QuestsManager.vampiricThirst, iMin - currentHp);
                            Adventurer adventurer2 = (Adventurer) entity;
                            minionBound = adventurer2.getMinionBound();
                            if (minionBound != null) {
                                minionBound.setCurrentHp(Math.min(minionBound.calculateTotalMaxHp(), minionBound.getCurrentHp() + iRound));
                                Logger.log(this, 35, minionBound, Integer.valueOf(iRound));
                            }
                        }
                    }
                    if (endOfTurnAction != null) {
                        it3 = entity.onTargetHitEffects().iterator();
                        while (it3.hasNext()) {
                            applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                        if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                            applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                    } else {
                        it3 = entity.onTargetHitEffects().iterator();
                        while (it3.hasNext()) {
                            applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                        if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                            applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                        }
                    }
                    checkDeath(entity3);
                    if (endOfTurnAction != null) {
                    }
                    retaliate(entity, entity3, z3, i);
                    return;
                }
            } else {
                statusEffect = null;
            }
            iDamageOnFalseLifeRemoval = 0;
            if (statusEffect != null) {
                entity2.getPositiveStatusEffects().remove(statusEffect);
                if (z6) {
                    Logger.log(this, 31, entity, entity2);
                } else {
                    Logger.log(this, 32, entity2);
                }
                Logger.log(this, 10, entity3, statusEffect.getType());
                z3 = zBooleanValue;
                endOfTurnAction2 = endOfTurnAction;
                i = iDamageOnFalseLifeRemoval;
                iApplyDamage = 0;
            } else {
                if (endOfTurnAction == null) {
                    z = false;
                } else {
                    z = false;
                }
                if (skill != null) {
                    livingCompanionBonusDamage = skill.damageAmplification;
                } else {
                    livingCompanionBonusDamage = 1.0d;
                }
                if (endOfTurnAction != null) {
                    livingCompanionBonusDamage = (((double) entity.getLivingCompanionBonusDamage()) * 0.01d) + 1.0d;
                }
                if (entity.isMoreDamageWhenHalfLife()) {
                    livingCompanionBonusDamage *= 1.5d;
                }
                if (entity.isMoreDamageDealtAndTaken()) {
                    livingCompanionBonusDamage *= 1.35d;
                }
                if (entity2.isMoreDamageDealtAndTaken()) {
                    livingCompanionBonusDamage *= 1.35d;
                }
                if (z) {
                    dCalculateCriticalMultiplier = 1.0d;
                } else {
                    dCalculateCriticalMultiplier = calculateCriticalMultiplier(entity, skill, entity2.getCriticalReduction());
                }
                if (z4) {
                    d = dCalculateCriticalMultiplier;
                    z2 = false;
                } else {
                    d = dCalculateCriticalMultiplier;
                    z2 = false;
                }
                if (z) {
                    dCalculateTotalDarknessDamageAmplification = 1.0d;
                } else {
                    dCalculateTotalDarknessDamageAmplification = (entity.calculateTotalDarknessDamageAmplification() * ((double) this.localDarkness)) + 1.0d;
                }
                d2 = 1.0d;
                for (StatusEffect statusEffect2 : entity.getPositiveStatusEffects()) {
                    StatusEffectType type = statusEffect2.getType();
                    if (type == StatusEffectType.DELIRIUM || type == StatusEffectType.SKELETON_KEY) {
                        d2 *= 2.0d;
                    } else if (type == StatusEffectType.FRENZY) {
                        d2 *= 1.3d;
                    } else if (type == StatusEffectType.ANOINTED || type == StatusEffectType.INSPIRE || type == StatusEffectType.EXALT) {
                        d2 *= 1.25d;
                    }
                }
                z3 = zBooleanValue;
                int i8 = iDamageOnFalseLifeRemoval;
                it2 = entity2.getNegativeStatusEffects().iterator();
                while (it2.hasNext()) {
                    if (it2.next().getType() == StatusEffectType.PETRIFY) {
                        d2 = 1.1d;
                        break;
                    }
                }
                if (endOfTurnAction != null) {
                    zIsMagic = entity.isMagic();
                } else {
                    zIsMagic = entity.isMagic();
                }
                if (zIsMagic) {
                    dMagicDamageAmplification = magicDamageAmplification();
                } else {
                    dMagicDamageAmplification = 1.0d;
                }
                if (z) {
                    dRollAttackDamage = endOfTurnAction.damage;
                } else {
                    dRollAttackDamage = entity.rollAttackDamage();
                }
                if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE) {
                    dRollAttackDamage = entity.getCurrentHp();
                }
                pet = this.petExploring;
                if (pet == null) {
                    barrier = 0;
                } else {
                    barrier = 0;
                }
                if (entity.getPassiveSkill() != Skills.PASSIVE_CHAOTIC) {
                    entity3 = entity2;
                } else {
                    entity3 = entity2;
                }
                boolean z10 = zIsMagic;
                i = i8;
                iApplyDamage = entity2.applyDamage(dRollAttackDamage * d * livingCompanionBonusDamage * dCalculateTotalDarknessDamageAmplification * d2 * dMagicDamageAmplification, z10, barrier, entity.getArmorIgnored());
                if (z4) {
                    if (d > 1.0d) {
                        QuestsManager.increment(QuestsManager.smartFighter, iApplyDamage);
                    }
                    QuestsManager.incrementToValue(QuestsManager.annihilator, iApplyDamage);
                    if (!z5) {
                        QuestsManager.increment(QuestsManager.warrior, 1L);
                    }
                }
                if (z5) {
                    QuestsManager.increment(QuestsManager.unscathed, 1L);
                }
                i2 = R.string.log_damage_dealt;
                endOfTurnAction2 = endOfTurnAction;
                if (endOfTurnAction2 != null) {
                    i2 = endOfTurnAction2.log;
                }
                Integer numValueOf2 = Integer.valueOf(i2);
                if (z2) {
                    i3 = 2;
                } else if (d > 1.0d) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                Logger.log(this, 33, numValueOf2, Integer.valueOf(i3), entity, entity3, Integer.valueOf(iApplyDamage));
            }
            if (skill != null) {
                i4 = 0;
                if (((double) entity2.getCurrentHp()) / ((double) entity2.calculateTotalMaxHp()) < skill.executionThreshold) {
                    entity3.setCurrentHp(0);
                    Logger.log(this, 34, entity3, entity);
                }
                if (entity.getActiveSkill() == Skills.ACTIVE_THOUSAND_CUTS) {
                    skill.statusEffect.setTurnsLeft(Utils.round(((double) iApplyDamage) / 3.0d));
                }
                if (entity.getActiveSkill() == Skills.ACTIVE_THOUSAND_CUTS_II) {
                    skill.statusEffect.setTurnsLeft(Utils.round(((double) iApplyDamage) / 2.0d));
                }
                if (!skill.applyEffectOnDodge) {
                    applyStatus(entity3, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
            } else {
                i4 = 0;
                if (endOfTurnAction2 == null) {
                }
                pet3 = this.petExploring;
                if (pet3 == null) {
                    lifesteal = 0.0d;
                } else {
                    lifesteal = 0.0d;
                }
                iRound = Utils.round((((double) entity.calculateTotalLifesteal()) + lifesteal) * 0.01d * ((double) iApplyDamage));
                if (skill != null) {
                    iRound = 1000;
                }
                if (iRound > 0) {
                    currentHp = entity.getCurrentHp();
                    iCalculateTotalMaxHp = entity.calculateTotalMaxHp();
                    iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound);
                    entity.setCurrentHp(iMin);
                    if (entity.getMaxLifestealOverheal() > 0) {
                        entity.setCurrentShield(Math.max(entity.getCurrentShield(), Math.min(entity.getCurrentShield() + Math.max(i4, (iRound - iCalculateTotalMaxHp) + currentHp), Utils.round(((double) iCalculateTotalMaxHp) * 0.01d * ((double) entity.getMaxLifestealOverheal())))));
                    }
                    Logger.log(this, 35, entity, Integer.valueOf(iRound));
                    if (z4) {
                        QuestsManager.increment(QuestsManager.vampiricThirst, iMin - currentHp);
                        Adventurer adventurer3 = (Adventurer) entity;
                        minionBound = adventurer3.getMinionBound();
                        if (minionBound != null) {
                            minionBound.setCurrentHp(Math.min(minionBound.calculateTotalMaxHp(), minionBound.getCurrentHp() + iRound));
                            Logger.log(this, 35, minionBound, Integer.valueOf(iRound));
                        }
                    }
                }
                if (endOfTurnAction != null) {
                    it3 = entity.onTargetHitEffects().iterator();
                    while (it3.hasNext()) {
                        applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                    if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                        applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                } else {
                    it3 = entity.onTargetHitEffects().iterator();
                    while (it3.hasNext()) {
                        applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                    if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                        applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                }
                checkDeath(entity3);
                if (endOfTurnAction != null) {
                }
                retaliate(entity, entity3, z3, i);
                return;
            }
            pet3 = this.petExploring;
            if (pet3 == null) {
                lifesteal = 0.0d;
            } else {
                lifesteal = 0.0d;
            }
            iRound = Utils.round((((double) entity.calculateTotalLifesteal()) + lifesteal) * 0.01d * ((double) iApplyDamage));
            if (skill != null) {
                iRound = 1000;
            }
            if (iRound > 0) {
                currentHp = entity.getCurrentHp();
                iCalculateTotalMaxHp = entity.calculateTotalMaxHp();
                iMin = Math.min(iCalculateTotalMaxHp, currentHp + iRound);
                entity.setCurrentHp(iMin);
                if (entity.getMaxLifestealOverheal() > 0) {
                    entity.setCurrentShield(Math.max(entity.getCurrentShield(), Math.min(entity.getCurrentShield() + Math.max(i4, (iRound - iCalculateTotalMaxHp) + currentHp), Utils.round(((double) iCalculateTotalMaxHp) * 0.01d * ((double) entity.getMaxLifestealOverheal())))));
                }
                Logger.log(this, 35, entity, Integer.valueOf(iRound));
                if (z4) {
                    QuestsManager.increment(QuestsManager.vampiricThirst, iMin - currentHp);
                    Adventurer adventurer4 = (Adventurer) entity;
                    minionBound = adventurer4.getMinionBound();
                    if (minionBound != null) {
                        minionBound.setCurrentHp(Math.min(minionBound.calculateTotalMaxHp(), minionBound.getCurrentHp() + iRound));
                        Logger.log(this, 35, minionBound, Integer.valueOf(iRound));
                    }
                }
            }
            if (endOfTurnAction != null) {
                it3 = entity.onTargetHitEffects().iterator();
                while (it3.hasNext()) {
                    applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
                if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                    applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
            } else {
                it3 = entity.onTargetHitEffects().iterator();
                while (it3.hasNext()) {
                    applyStatus(entity3, it3.next(), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
                if (entity2.getCurrentHp() < entity.getCurrentHp()) {
                    applyStatus(entity3, new StatusEffect(StatusEffectType.STUN, entity, 1, entity.getStunChanceOnLowerHp()), entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
            }
            checkDeath(entity3);
            if (endOfTurnAction != null) {
            }
            retaliate(entity, entity3, z3, i);
            return;
        }
    }

    protected void checkDeath(Entity entity) {
        boolean zContains = entity.getPositiveStatusEffects().contains(TETHER);
        if (entity.getCurrentHp() == 0) {
            if (entity instanceof Enemy) {
                if (entity.getPassiveSkill() == Skills.PASSIVE_ABSURD_GENEALOGY && Utils.random() < 0.65d) {
                    entity.setCurrentHp(entity.calculateTotalMaxHp());
                    entity.setCurrentMana(100);
                    entity.getNegativeStatusEffects().clear();
                    return;
                }
                Enemy enemy = (Enemy) entity;
                this.enemies.remove(enemy);
                if (entity == this.acting) {
                    int iIndexOf = this.fightingGroup.indexOf(entity);
                    List<Entity> list = this.fightingGroup;
                    if (iIndexOf == 0) {
                        iIndexOf = list.size();
                    }
                    this.acting = list.get(iIndexOf - 1);
                    this.turnEndRequested = true;
                }
                this.fightingGroup.remove(enemy);
                this.corpses.add(enemy);
                this.adventureRecap.addEnemyKilled(enemy);
                triggerEvent("kill_" + entity.getTrueClass());
                Logger.log(this, 36, Integer.valueOf(entity.getIdName()));
                healingNova();
                reanimate(enemy);
            } else {
                Adventurer adventurer = (Adventurer) entity;
                if (adventurer.isSummonedMinion()) {
                    this.adventurersExploring.remove(entity);
                    if (entity == this.acting) {
                        int iIndexOf2 = this.fightingGroup.indexOf(entity);
                        List<Entity> list2 = this.fightingGroup;
                        if (iIndexOf2 == 0) {
                            iIndexOf2 = list2.size();
                        }
                        this.acting = list2.get(iIndexOf2 - 1);
                        this.turnEndRequested = true;
                    }
                    this.fightingGroup.remove(entity);
                    for (Adventurer adventurer2 : this.adventurersExploring) {
                        if (adventurer2.getMinionBound() == entity) {
                            adventurer2.setMinionBound(null);
                            break;
                        }
                    }
                    triggerEvent("kill_" + entity.getTrueClass());
                    Logger.log(this, 37, Integer.valueOf(entity.getIdName()));
                } else {
                    QuestsManager.increment(QuestsManager.theEnd, 1L);
                    animateDamage(entity);
                    if ((adventurer.getAccessory() instanceof AmuletOfResurrection) && Utils.random() < 0.4d) {
                        adventurer.setCurrentHp(adventurer.calculateTotalMaxHp());
                        adventurer.getNegativeStatusEffects().clear();
                        adventurer.getPositiveStatusEffects().remove(TETHER);
                        Logger.log(this, Logger.AMULET_OF_RESURRECTION, adventurer);
                        return;
                    }
                    int experience = adventurer.getExperience() / 5;
                    Logger.log(this, 38, Integer.valueOf(adventurer.getIdName()), Integer.valueOf(experience), Integer.valueOf(getAreaType()));
                    if (getAreaType() == 0) {
                        adventurer.setExperience(adventurer.getExperience() - experience);
                        this.adventureRecap.addExpLost(experience);
                    }
                    if (adventurer.getMinionBound() != null) {
                        adventurer.getMinionBound().setCurrentHp(0);
                        checkDeath(adventurer.getMinionBound());
                    }
                    adventurer.getPositiveStatusEffects().clear();
                    adventurer.getNegativeStatusEffects().clear();
                }
            }
            if (zContains) {
                return;
            }
            reanimateAlchemistWithFeebleTether(entity);
            applyOnDeathStatusEffects(entity);
            return;
        }
        animateDamage(entity);
    }

    private void healingNova() {
        double healMissingHpOnEnemyDeath = 0.0d;
        for (Adventurer adventurer : this.adventurersExploring) {
            if (adventurer.getCurrentHp() > 0) {
                healMissingHpOnEnemyDeath += ((double) adventurer.getHealMissingHpOnEnemyDeath()) * adventurer.calculateHealingModifier();
            }
        }
        if (healMissingHpOnEnemyDeath == 0.0d) {
            return;
        }
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.getCurrentHp() > 0) {
                int iCalculateTotalMaxHp = adventurer2.calculateTotalMaxHp();
                adventurer2.setCurrentHp(Math.min(iCalculateTotalMaxHp, adventurer2.getCurrentHp() + Utils.round(0.01d * healMissingHpOnEnemyDeath * ((double) (iCalculateTotalMaxHp - adventurer2.getCurrentHp())))));
            }
        }
        Logger.log(this, Logger.HEALING_NOVA, Integer.valueOf((int) healMissingHpOnEnemyDeath));
    }

    private void applyOnDeathStatusEffects(Entity entity) {
        if (entity.calculateOnDeathEffectsOnAllies().isEmpty() && entity.calculateOnDeathEffectsOnEnemies().isEmpty()) {
            return;
        }
        List<Entity> listSelectTargets = selectTargets(entity, TARGET_ALL_ENEMIES);
        List<Entity> listSelectTargets2 = selectTargets(entity, TARGET_ALL_ALLIES);
        if (listSelectTargets2 != null && !listSelectTargets2.isEmpty()) {
            for (StatusEffect statusEffect : entity.calculateOnDeathEffectsOnAllies()) {
                for (Entity entity2 : listSelectTargets2) {
                    if (entity2.getCurrentHp() > 0) {
                        applyStatus(entity2, statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01d);
                    }
                }
            }
        }
        if (listSelectTargets == null || listSelectTargets.isEmpty()) {
            return;
        }
        for (StatusEffect statusEffect2 : entity.calculateOnDeathEffectsOnEnemies()) {
            for (Entity entity3 : listSelectTargets) {
                if (entity3.getCurrentHp() > 0) {
                    applyStatus(entity3, statusEffect2, entity.calculateIgnoreImmunityToStatus() * 0.01d);
                }
            }
        }
    }

    private void reanimateAlchemistWithFeebleTether(Entity entity) {
        if (entity.getTrueClass().equals("EldritchAlchemist")) {
            entity.setCurrentHp(entity.calculateTotalMaxHp());
            entity.setCurrentMana(100);
            applyStatus(entity, new StatusEffect(StatusEffectType.FEEBLE_TETHER, entity, 999, 1.0d), 0.0d);
        }
    }

    private void reanimate(Enemy enemy) {
        boolean z;
        String str;
        boolean z2;
        if (enemy.getNegativeStatusEffects().isEmpty()) {
            return;
        }
        Iterator<StatusEffect> it2 = enemy.getNegativeStatusEffects().iterator();
        Adventurer adventurer = null;
        String str2 = null;
        while (true) {
            z = false;
            if (it2.hasNext()) {
                StatusEffect next = it2.next();
                if (next.getType() == StatusEffectType.ABHORRENT_CURSE) {
                    adventurer = (Adventurer) next.getCause();
                    str = "BoneHydra";
                    z2 = true;
                    z = true;
                    break;
                }
                if (next.getType() == StatusEffectType.OMINOUS_CURSE) {
                    adventurer = (Adventurer) next.getCause();
                    str = "BoneNightmare";
                    z2 = false;
                    z = true;
                    break;
                }
                if (next.getType() == StatusEffectType.GREATER_CURSE) {
                    adventurer = (Adventurer) next.getCause();
                    str2 = "BoneHorror";
                } else {
                    if (next.getType() == StatusEffectType.CURSE) {
                        adventurer = (Adventurer) next.getCause();
                        str2 = "Skeleton";
                    }
                    if (next.getType() == StatusEffectType.LESSER_CURSE && str2 == null) {
                        adventurer = (Adventurer) next.getCause();
                        str2 = "Zombie";
                    }
                }
            }
            str = str2;
            z2 = false;
            break;
        }
        if (str == null || adventurer == null || adventurer.getCurrentHp() <= 0) {
            return;
        }
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.isSummonedMinion()) {
                this.adventurersExploring.remove(adventurer2);
                this.fightingGroup.remove(adventurer2);
                break;
            }
        }
        Adventurer adventurer3 = Adventurer.getInstance(str, -100, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        adventurer3.setWeapon((Weapon) Weapon.getInstance(z ? "SerpentJaws" : "DecomposedLimb"));
        if (z2) {
            adventurer3.setArmor((Armor) Armor.getInstance("SpikedSkeleton"));
        }
        if ("WickedScepter".equals(adventurer.getWeapon().getTrueClass())) {
            adventurer3.setAccessory((Accessory) Accessory.getInstance("EyeOfUr"));
        }
        if ("CursedScepter".equals(adventurer.getWeapon().getTrueClass())) {
            adventurer3.setAccessory((Accessory) Accessory.getInstance("AncientEye"));
        }
        adventurer3.setCurrentHp(adventurer3.calculateTotalMaxHp());
        adventurer.setMinionBound(adventurer3);
        if (adventurer.getAccessory() != null && (adventurer.getAccessory() instanceof SkeletonKey)) {
            applyStatus(adventurer3, new StatusEffect(StatusEffectType.SKELETON_KEY, adventurer, 999, 1.0d), 0.0d);
        }
        List<Entity> list = this.fightingGroup;
        list.add(list.indexOf(adventurer) + 1, adventurer3);
        this.adventurersExploring.add(adventurer3);
        Logger.log(this, 39, Integer.valueOf(adventurer3.getIdName()), Integer.valueOf(adventurer.getIdName()));
    }

    private void retaliate(Entity entity, Entity entity2, boolean z, int i) {
        long j;
        if (entity2.getCurrentHp() > 0 && !z) {
            int iCalculateRetaliationPhysicalDamage = entity2.calculateRetaliationPhysicalDamage();
            int iCalculateRetaliationMagicalDamage = entity2.calculateRetaliationMagicalDamage() + i;
            Pet pet = this.petExploring;
            int barrier = (pet == null || !(entity instanceof Adventurer)) ? 0 : pet.getBarrier();
            if (iCalculateRetaliationPhysicalDamage > 0) {
                int iApplyDamage = entity.applyDamage(iCalculateRetaliationPhysicalDamage, false, barrier, entity2.getArmorIgnored());
                Logger.log(this, 46, entity, Integer.valueOf(iApplyDamage));
                if (entity2 instanceof Adventurer) {
                    QuestsManager.increment(QuestsManager.spiky, iApplyDamage);
                }
            }
            if (iCalculateRetaliationMagicalDamage > 0) {
                if (i > 0 && (entity2 instanceof Adventurer)) {
                    QuestsManager.increment(QuestsManager.activeDeterrent, 1L);
                }
                j = 1;
                int iApplyDamage2 = entity.applyDamage(Utils.round(magicDamageAmplification() * ((double) iCalculateRetaliationMagicalDamage)), true, barrier, entity2.getArmorIgnored());
                Logger.log(this, 46, entity, Integer.valueOf(iApplyDamage2));
                if (entity2 instanceof Adventurer) {
                    QuestsManager.increment(QuestsManager.spiky, iApplyDamage2);
                }
            } else {
                j = 1;
            }
            if (iCalculateRetaliationPhysicalDamage > 0 || iCalculateRetaliationMagicalDamage > 0) {
                checkDeath(entity);
            }
            for (StatusEffect statusEffect : entity2.onSelfHitEffects()) {
                if (statusEffect.getType().negative) {
                    applyStatus(entity, statusEffect, entity2.calculateIgnoreImmunityToStatus() * 0.01d);
                }
            }
            Pet pet2 = this.petExploring;
            double counterattack = (pet2 == null || !(entity2 instanceof Adventurer)) ? 0.0d : pet2.getCounterattack() / 100.0d;
            if (entity.isForcesTargetToCounterattack() || Utils.random() < entity2.calculateCounterattackChance() + counterattack) {
                if (entity2 instanceof Adventurer) {
                    QuestsManager.increment(QuestsManager.expertDuelist, j);
                }
                dealDamage(entity2, entity, null, null);
            }
        }
        for (StatusEffect statusEffect2 : entity2.onSelfHitEffects()) {
            if (!statusEffect2.getType().negative) {
                applyStatus(entity2, statusEffect2, 0.0d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public List<Entity> selectTargets(Entity entity, String str) {
        ArrayList arrayList = new ArrayList();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2010700031:
                if (str.equals(TARGET_LOWEST_SHIELD_ALLY)) {
                    b = 0;
                }
                break;
            case -1014930783:
                if (str.equals(TARGET_MOST_NEGATIVE_CONDITIONS_OR_LOWEST_RELATIVE_ALLY)) {
                    b = 1;
                }
                break;
            case -967548685:
                if (str.equals(TARGET_LOWEST_ABSOLUTE_ALLY)) {
                    b = 2;
                }
                break;
            case -938285885:
                if (str.equals(TARGET_RANDOM)) {
                    b = 3;
                }
                break;
            case -700116748:
                if (str.equals(TARGET_RANDOM_ALLY)) {
                    b = 4;
                }
                break;
            case -225036020:
                if (str.equals(TARGET_RANDOM_ENEMY)) {
                    b = 5;
                }
                break;
            case -198196606:
                if (str.equals(TARGET_LOWEST_RELATIVE_ENEMY)) {
                    b = 6;
                }
                break;
            case -89587402:
                if (str.equals(TARGET_RANDOM_EXCEPT_SELF)) {
                    b = 7;
                }
                break;
            case 96673:
                if (str.equals(TARGET_ALL)) {
                    b = 8;
                }
                break;
            case 74508525:
                if (str.equals(TARGET_LOWEST_ABSOLUTE_ENEMY)) {
                    b = 9;
                }
                break;
            case 861851016:
                if (str.equals(TARGET_ALL_ENEMIES)) {
                    b = 10;
                }
                break;
            case 1020021236:
                if (str.equals(TARGET_ALL_ALLIES)) {
                    b = Ascii.VT;
                }
                break;
            case 1392064788:
                if (str.equals(TARGET_ALL_EXCEPT_SELF)) {
                    b = Ascii.FF;
                }
                break;
            case 1933148350:
                if (str.equals(TARGET_LOWEST_RELATIVE_ALLY)) {
                    b = Ascii.CR;
                }
                break;
            case 2047699943:
                if (str.equals(TARGET_RANDOM_ALLY_EXCEPT_SELF)) {
                    b = Ascii.SO;
                }
                break;
        }
        switch (b) {
            case 0:
                Entity entitySelectLowestRelativeShieldAlly = selectLowestRelativeShieldAlly(entity);
                if (entitySelectLowestRelativeShieldAlly == null) {
                    return null;
                }
                arrayList.add(entitySelectLowestRelativeShieldAlly);
                return arrayList;
            case 1:
                List<Entity> list = (List) (entity instanceof Adventurer ? this.adventurersExploring : this.enemies);
                if (list.isEmpty()) {
                    return null;
                }
                Entity entity2 = null;
                for (Entity entity3 : list) {
                    if (entity3.getCurrentHp() > 0 && (entity2 == null || entity3.getNegativeStatusEffects().size() > entity2.getNegativeStatusEffects().size())) {
                        entity2 = entity3;
                    }
                }
                if (entity2 == null) {
                    return null;
                }
                if (entity2.getNegativeStatusEffects().size() == 0) {
                    return selectTargets(entity, TARGET_LOWEST_RELATIVE_ALLY);
                }
                arrayList.add(entity2);
                return arrayList;
            case 2:
                Entity entitySelectLowestHpTarget = selectLowestHpTarget(entity, false, true);
                if (entitySelectLowestHpTarget == null) {
                    return null;
                }
                arrayList.add(entitySelectLowestHpTarget);
                return arrayList;
            case 3:
                Entity entitySelectRandomTarget = selectRandomTarget(entity, false);
                if (entitySelectRandomTarget == null) {
                    return null;
                }
                arrayList.add(entitySelectRandomTarget);
                return arrayList;
            case 4:
                List list2 = entity instanceof Adventurer ? this.adventurersExploring : this.enemies;
                if (list2.isEmpty()) {
                    return null;
                }
                arrayList.add((Entity) list2.get((int) (Utils.random() * ((double) list2.size()))));
                return arrayList;
            case 5:
                Entity entitySelectEnemyTarget = selectEnemyTarget(entity);
                if (entitySelectEnemyTarget == null) {
                    return null;
                }
                arrayList.add(entitySelectEnemyTarget);
                return arrayList;
            case 6:
                Entity entitySelectLowestHpTarget2 = selectLowestHpTarget(entity, true, false);
                if (entitySelectLowestHpTarget2 == null) {
                    return null;
                }
                arrayList.add(entitySelectLowestHpTarget2);
                return arrayList;
            case 7:
                Entity entitySelectRandomTarget2 = selectRandomTarget(entity, true);
                if (entitySelectRandomTarget2 == null) {
                    return null;
                }
                arrayList.add(entitySelectRandomTarget2);
                return arrayList;
            case 8:
                arrayList.addAll(this.adventurersExploring);
                arrayList.addAll(this.enemies);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            case 9:
                Entity entitySelectLowestHpTarget3 = selectLowestHpTarget(entity, true, true);
                if (entitySelectLowestHpTarget3 == null) {
                    return null;
                }
                arrayList.add(entitySelectLowestHpTarget3);
                return arrayList;
            case 10:
                arrayList.addAll(entity instanceof Adventurer ? this.enemies : this.adventurersExploring);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            case 11:
                arrayList.addAll(entity instanceof Adventurer ? this.adventurersExploring : this.enemies);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            case 12:
                arrayList.addAll(this.adventurersExploring);
                arrayList.addAll(this.enemies);
                arrayList.remove(entity);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            case 13:
                Entity entitySelectLowestHpTarget4 = selectLowestHpTarget(entity, false, false);
                if (entitySelectLowestHpTarget4 == null) {
                    return null;
                }
                arrayList.add(entitySelectLowestHpTarget4);
                return arrayList;
            case 14:
                ArrayList arrayList2 = new ArrayList(entity instanceof Adventurer ? this.adventurersExploring : this.enemies);
                arrayList2.remove(entity);
                if (arrayList2.isEmpty()) {
                    return null;
                }
                arrayList2.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return Area.lambda$selectTargets$2((Entity) obj);
                    }
                });
                if (arrayList2.isEmpty()) {
                    return null;
                }
                arrayList.add((Entity) arrayList2.get((int) (Utils.random() * ((double) arrayList2.size()))));
                return arrayList;
            default:
                int i = Integer.parseInt(str);
                for (int i2 = 0; i2 < i; i2++) {
                    Entity entitySelectEnemyTarget2 = selectEnemyTarget(entity);
                    if (entitySelectEnemyTarget2 == null) {
                        return null;
                    }
                    arrayList.add(entitySelectEnemyTarget2);
                }
                return arrayList;
        }
    }

    static /* synthetic */ boolean lambda$selectTargets$2(Entity entity) {
        return entity.getCurrentHp() <= 0;
    }

    private Entity selectEnemyTarget(Entity entity) {
        Pet pet;
        boolean z = entity instanceof Adventurer;
        ArrayList arrayList = new ArrayList(z ? this.enemies : this.adventurersExploring);
        if (entity.getTeam() != 0) {
            for (Enemy enemy : this.enemies) {
                if (enemy.getTeam() != entity.getTeam()) {
                    arrayList.add(enemy);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return null;
        }
        Entity entityTauntedBy = tauntedBy(entity, arrayList2);
        if (entityTauntedBy != null) {
            return entityTauntedBy;
        }
        List<Entity> listWeightedSelection = weightedSelection(arrayList2);
        if (listWeightedSelection.isEmpty()) {
            return null;
        }
        if (!z && (pet = this.petExploring) != null && pet.getDecoy() > 0.0d && Utils.random() < this.petExploring.getDecoy() / (((double) listWeightedSelection.size()) + this.petExploring.getDecoy())) {
            Logger.log(this, Logger.PET_DECOY, this.petExploring, entity);
            return null;
        }
        return listWeightedSelection.get((int) (Utils.random() * ((double) listWeightedSelection.size())));
    }

    private Entity selectPetTarget() {
        ArrayList arrayList = new ArrayList(this.enemies);
        if (arrayList.isEmpty()) {
            return null;
        }
        List<Entity> listWeightedSelection = weightedSelection(arrayList);
        return listWeightedSelection.get((int) (Utils.random() * ((double) listWeightedSelection.size())));
    }

    private Entity selectPetHealingTarget() {
        ArrayList<Entity> arrayList = new ArrayList(this.adventurersExploring);
        arrayList.sort(new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Area.lambda$selectPetHealingTarget$3((Entity) obj, (Entity) obj2);
            }
        });
        Entity entity = null;
        for (Entity entity2 : arrayList) {
            if (entity2.getCurrentHp() > 0 && (entity == null || ((double) entity.getCurrentHp()) / ((double) entity.calculateTotalMaxHp()) > ((double) entity2.getCurrentHp()) / ((double) entity2.calculateTotalMaxHp()))) {
                entity = entity2;
            }
        }
        return entity;
    }

    static /* synthetic */ int lambda$selectPetHealingTarget$3(Entity entity, Entity entity2) {
        return entity2.getNegativeStatusEffects().size() - entity.getNegativeStatusEffects().size();
    }

    private Entity selectRandomTarget(Entity entity, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.enemies);
        arrayList.addAll(this.adventurersExploring);
        if (z) {
            arrayList.remove(entity);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Entity entityTauntedBy = tauntedBy(entity, arrayList);
        if (entityTauntedBy != null) {
            return entityTauntedBy;
        }
        List<Entity> listWeightedSelection = weightedSelection(arrayList);
        if (listWeightedSelection.isEmpty()) {
            return null;
        }
        return listWeightedSelection.get((int) (Utils.random() * ((double) listWeightedSelection.size())));
    }

    private List<Entity> weightedSelection(List<? extends Entity> list) {
        ArrayList arrayList = new ArrayList();
        for (Entity entity : list) {
            if (entity.getCurrentHp() > 0) {
                for (int i = 0; i < entity.getThreat(); i++) {
                    arrayList.add(entity);
                }
            }
        }
        return arrayList;
    }

    private Entity tauntedBy(Entity entity, List<? extends Entity> list) {
        StatusEffect next;
        Iterator<StatusEffect> it2 = entity.getNegativeStatusEffects().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (next.getType() != StatusEffectType.TAUNT);
        if (next != null) {
            Entity cause = next.getCause();
            if (list.contains(cause)) {
                return cause;
            }
            entity.getNegativeStatusEffects().remove(next);
        }
        return null;
    }

    private Entity selectLowestHpTarget(Entity entity, boolean z, boolean z2) {
        ArrayList<Entity> arrayList = new ArrayList<>((List) (((!(entity instanceof Adventurer) || z) && !((entity instanceof Enemy) && z)) ? this.enemies : this.adventurersExploring));
        if (!z) {
            arrayList.sort(new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda6
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Area.lambda$selectLowestHpTarget$4((Entity) obj, (Entity) obj2);
                }
            });
        }
        Entity entityTauntedBy = tauntedBy(entity, arrayList);
        if (entityTauntedBy != null) {
            return entityTauntedBy;
        }
        Entity entity2 = null;
        for (Entity entity3 : arrayList) {
            if (entity3.getCurrentHp() > 0 && (entity2 == null || ((!z2 && ((double) entity2.getCurrentHp()) / ((double) entity2.calculateTotalMaxHp()) > ((double) entity3.getCurrentHp()) / ((double) entity3.calculateTotalMaxHp())) || (z2 && entity2.getCurrentHp() > entity3.getCurrentHp())))) {
                entity2 = entity3;
            }
        }
        return entity2;
    }

    static /* synthetic */ int lambda$selectLowestHpTarget$4(Entity entity, Entity entity2) {
        return entity2.getNegativeStatusEffects().size() - entity.getNegativeStatusEffects().size();
    }

    private Entity selectLowestRelativeShieldAlly(Entity entity) {
        ArrayList<Entity> arrayList = new ArrayList(entity instanceof Adventurer ? this.adventurersExploring : this.enemies);
        Collections.shuffle(arrayList);
        Entity entity2 = null;
        for (Entity entity3 : arrayList) {
            if (entity3.getCurrentHp() > 0) {
                if (entity2 != null) {
                    double dCalculateTotalMaxHp = entity3.calculateTotalMaxHp();
                    if (entity3.getCurrentShield() < ((int) (0.2d * dCalculateTotalMaxHp)) && ((double) entity3.getCurrentShield()) / dCalculateTotalMaxHp < ((double) entity2.getCurrentShield()) / ((double) entity2.calculateTotalMaxHp())) {
                    }
                }
                entity2 = entity3;
            }
        }
        return entity2;
    }

    protected void refreshDialog() {
        if (MainActivity.shownDialogDungeonDetail == null || MainActivity.shownDialogDungeonDetail.area != this) {
            return;
        }
        try {
            MainActivity.shownDialogDungeonDetail.refreshUnits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void refreshDarkness() {
        if (MainActivity.shownDialogDungeonDetail == null || MainActivity.shownDialogDungeonDetail.area != this) {
            return;
        }
        try {
            MainActivity.shownDialogDungeonDetail.refreshDarkness();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void invertLogColor() {
        if (MainActivity.shownDialogDungeonDetail == null || MainActivity.shownDialogDungeonDetail.area != this) {
            return;
        }
        try {
            MainActivity.shownDialogDungeonDetail.darkLog = !MainActivity.shownDialogDungeonDetail.darkLog;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void animateDamage(Entity entity) {
        if (MainActivity.shownDialogDungeonDetail == null || MainActivity.shownDialogDungeonDetail.area != this) {
            return;
        }
        try {
            MainActivity.shownDialogDungeonDetail.animateDamage(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshAdventurers() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.getContext() == null || MainActivity.dungeonsFragment.getBinding() == null) {
            return;
        }
        Resources resources = MainActivity.dungeonsFragment.getResources();
        Resources.Theme theme = MainActivity.dungeonsFragment.getContext().getTheme();
        ArrayList arrayList = new ArrayList(this.adventurersExploring);
        arrayList.removeIf(new Area$$ExternalSyntheticLambda0());
        int size = arrayList.size();
        if (size > 0) {
            Adventurer adventurer = (Adventurer) arrayList.get(0);
            getLayout().adventurerImage1.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.getImageId(), theme));
            getLayout().adventurerImage1.adventurerImage.setBackgroundResource(adventurer.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 1) {
            Adventurer adventurer2 = (Adventurer) arrayList.get(1);
            getLayout().adventurerImage2.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer2.getImageId(), theme));
            getLayout().adventurerImage2.adventurerImage.setBackgroundResource(adventurer2.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 2) {
            Adventurer adventurer3 = (Adventurer) arrayList.get(2);
            getLayout().adventurerImage3.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer3.getImageId(), theme));
            getLayout().adventurerImage3.adventurerImage.setBackgroundResource(adventurer3.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 3) {
            Adventurer adventurer4 = (Adventurer) arrayList.get(3);
            getLayout().adventurerImage4.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer4.getImageId(), theme));
            getLayout().adventurerImage4.adventurerImage.setBackgroundResource(adventurer4.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 4) {
            Adventurer adventurer5 = (Adventurer) arrayList.get(4);
            getLayout().adventurerImage5.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer5.getImageId(), theme));
            getLayout().adventurerImage5.adventurerImage.setBackgroundResource(adventurer5.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 5) {
            Adventurer adventurer6 = (Adventurer) arrayList.get(5);
            getLayout().adventurerImage6.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer6.getImageId(), theme));
            getLayout().adventurerImage6.adventurerImage.setBackgroundResource(adventurer6.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 6) {
            Adventurer adventurer7 = (Adventurer) arrayList.get(6);
            getLayout().adventurerImage7.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer7.getImageId(), theme));
            getLayout().adventurerImage7.adventurerImage.setBackgroundResource(adventurer7.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 7) {
            Adventurer adventurer8 = (Adventurer) arrayList.get(7);
            getLayout().adventurerImage8.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer8.getImageId(), theme));
            getLayout().adventurerImage8.adventurerImage.setBackgroundResource(adventurer8.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 8) {
            Adventurer adventurer9 = (Adventurer) arrayList.get(8);
            getLayout().adventurerImage9.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer9.getImageId(), theme));
            getLayout().adventurerImage9.adventurerImage.setBackgroundResource(adventurer9.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 9) {
            Adventurer adventurer10 = (Adventurer) arrayList.get(9);
            getLayout().adventurerImage10.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer10.getImageId(), theme));
            getLayout().adventurerImage10.adventurerImage.setBackgroundResource(adventurer10.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 10) {
            Adventurer adventurer11 = (Adventurer) arrayList.get(10);
            getLayout().adventurerImage11.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer11.getImageId(), theme));
            getLayout().adventurerImage11.adventurerImage.setBackgroundResource(adventurer11.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 11) {
            Adventurer adventurer12 = (Adventurer) arrayList.get(11);
            getLayout().adventurerImage12.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer12.getImageId(), theme));
            getLayout().adventurerImage12.adventurerImage.setBackgroundResource(adventurer12.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 12) {
            Adventurer adventurer13 = (Adventurer) arrayList.get(12);
            getLayout().adventurerImage13.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer13.getImageId(), theme));
            getLayout().adventurerImage13.adventurerImage.setBackgroundResource(adventurer13.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        if (size > 13) {
            Adventurer adventurer14 = (Adventurer) arrayList.get(13);
            getLayout().adventurerImage14.adventurerImage.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer14.getImageId(), theme));
            getLayout().adventurerImage14.adventurerImage.setBackgroundResource(adventurer14.isAscended() ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white);
        }
        getLayout().adventurerImage1.getRoot().setVisibility(size > 0 ? 0 : 8);
        getLayout().adventurerImage2.getRoot().setVisibility(size > 1 ? 0 : 8);
        getLayout().adventurerImage3.getRoot().setVisibility(size > 2 ? 0 : 8);
        getLayout().adventurerImage4.getRoot().setVisibility(size > 3 ? 0 : 8);
        getLayout().adventurerImage5.getRoot().setVisibility(size > 4 ? 0 : 8);
        getLayout().adventurerImage6.getRoot().setVisibility(size > 5 ? 0 : 8);
        getLayout().adventurerImage7.getRoot().setVisibility(size > 6 ? 0 : 8);
        getLayout().adventurerImage8.getRoot().setVisibility(size > 7 ? 0 : 8);
        getLayout().adventurerImage9.getRoot().setVisibility(size > 8 ? 0 : 8);
        getLayout().adventurerImage10.getRoot().setVisibility(size > 9 ? 0 : 8);
        getLayout().adventurerImage11.getRoot().setVisibility(size > 10 ? 0 : 8);
        getLayout().adventurerImage12.getRoot().setVisibility(size > 11 ? 0 : 8);
        getLayout().adventurerImage13.getRoot().setVisibility(size > 12 ? 0 : 8);
        getLayout().adventurerImage14.getRoot().setVisibility(size > 13 ? 0 : 8);
        getLayout().explorationTooltip.setVisibility(arrayList.isEmpty() ? 4 : 0);
        getLayout().pet.setVisibility(this.petExploring == null ? 4 : 0);
        if (this.petExploring != null) {
            getLayout().pet.setImageDrawable(ResourcesCompat.getDrawable(resources, this.petExploring.getIdImage(), theme));
        }
        refreshHpBars();
    }

    private void refreshHpBars() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.getContext() == null || MainActivity.dungeonsFragment.getBinding() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.adventurersExploring);
        arrayList.removeIf(new Area$$ExternalSyntheticLambda0());
        int size = arrayList.size();
        try {
            LayoutDungeonBinding layout = getLayout();
            if (size > 0) {
                layout.adventurerImage1.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(0)));
            }
            if (size > 1) {
                layout.adventurerImage2.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(1)));
            }
            if (size > 2) {
                layout.adventurerImage3.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(2)));
            }
            if (size > 3) {
                layout.adventurerImage4.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(3)));
            }
            if (size > 4) {
                layout.adventurerImage5.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(4)));
            }
            if (size > 5) {
                layout.adventurerImage6.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(5)));
            }
            if (size > 6) {
                layout.adventurerImage7.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(6)));
            }
            if (size > 7) {
                layout.adventurerImage8.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(7)));
            }
            if (size > 8) {
                layout.adventurerImage9.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(8)));
            }
            if (size > 9) {
                layout.adventurerImage10.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(9)));
            }
            if (size > 10) {
                layout.adventurerImage11.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(10)));
            }
            if (size > 11) {
                layout.adventurerImage12.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(11)));
            }
            if (size > 12) {
                layout.adventurerImage13.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(12)));
            }
            if (size > 13) {
                layout.adventurerImage14.hpBar.setProgress(getSummaryHpBarProgress((Adventurer) arrayList.get(13)));
            }
        } catch (Exception unused) {
        }
    }

    private int getSummaryHpBarProgress(Adventurer adventurer) {
        return (int) ((((double) adventurer.getCurrentHp()) * 100.0d) / ((double) adventurer.calculateTotalMaxHp()));
    }

    public void refreshLoot() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.getContext() == null || MainActivity.dungeonsFragment.getBinding() == null) {
            return;
        }
        Resources resources = MainActivity.dungeonsFragment.getResources();
        Resources.Theme theme = MainActivity.dungeonsFragment.getContext().getTheme();
        Iterator<Item> it2 = this.drops.iterator();
        int stack = 0;
        while (it2.hasNext()) {
            stack += it2.next().getStack();
        }
        boolean z = stack >= (MainActivity.data.isMerchantPackPurchased() ? 3000 : 2000);
        getLayout().lootImage.setVisibility(this.drops.isEmpty() ? 8 : 0);
        getLayout().lootImage.setImageDrawable(ResourcesCompat.getDrawable(resources, z ? R.drawable.loot_chest_full : R.drawable.loot_chest, theme));
        getLayout().fullLoot.setVisibility(this.drops.isEmpty() ? 8 : 0);
        getLayout().fullLoot.setText(String.format(resources.getString(MainActivity.data.isMerchantPackPurchased() ? R.string.loot_percentage_full_with_pack : R.string.loot_percentage_full), Integer.valueOf(stack)));
        getLayout().fullLoot.setTextColor(resources.getColor(z ? UIUtils.getFailureColor() : R.color.dim_white, theme));
    }

    public void refreshActionDisplayed() {
        if (!Utils.isMainLooper() || MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.getContext() == null || MainActivity.dungeonsFragment.getBinding() == null || this.action == null) {
            return;
        }
        try {
            final LayoutDungeonBinding layout = getLayout();
            layout.actionDescription.setText(this.action.getName());
            if (this.animator == null || this.animationInvalidationRequested) {
                this.animationInvalidationRequested = false;
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 1000);
                this.animator = valueAnimatorOfInt;
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.places.Area$$ExternalSyntheticLambda7
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Area.this.m208xc78e86b4(layout, valueAnimator);
                    }
                });
            }
            this.animator.setDuration(((long) this.action.getTurnsToComplete()) * 1000);
            this.animator.start();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: lambda$refreshActionDisplayed$5$it-paranoidsquirrels-idleguildmaster-storage-data-places-Area, reason: not valid java name */
    /* synthetic */ void m208xc78e86b4(LayoutDungeonBinding layoutDungeonBinding, ValueAnimator valueAnimator) {
        if (MainActivity.applicationPaused.value) {
            return;
        }
        layoutDungeonBinding.actionProgress.setProgress(((Integer) this.animator.getAnimatedValue()).intValue());
        if (MainActivity.shownDialogDungeonDetail == null || MainActivity.shownDialogDungeonDetail.binding == null || MainActivity.shownDialogDungeonDetail.area != this) {
            return;
        }
        MainActivity.shownDialogDungeonDetail.binding.actionProgressRight.setProgress(((Integer) this.animator.getAnimatedValue()).intValue());
        MainActivity.shownDialogDungeonDetail.binding.actionProgressLeft.setProgress(((Integer) this.animator.getAnimatedValue()).intValue());
    }

    public void refreshTries() {
        if (!Utils.isMainLooper() || MainActivity.raidsFragment == null || MainActivity.raidsFragment.getContext() == null || MainActivity.raidsFragment.getBinding() == null) {
            return;
        }
        getLayout().raidTryAvailable.setImageDrawable(ResourcesCompat.getDrawable(MainActivity.raidsFragment.getResources(), this.triesAvailable ? R.drawable.raid_try_available : R.drawable.raid_try_unavailable, MainActivity.raidsFragment.getContext().getTheme()));
    }

    public void invalidateAnimator() {
        this.animationInvalidationRequested = true;
    }

    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        return new LinkedHashMap<>();
    }

    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        return new LinkedHashMap<>();
    }
}
