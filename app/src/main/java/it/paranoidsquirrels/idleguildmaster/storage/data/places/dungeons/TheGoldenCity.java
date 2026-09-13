package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheGoldenCity extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_the_golden_city;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_golden_city;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_golden_city;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().theGoldenCity;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        int key = this.event == null ? 0 : this.event.getKey();
        if (key == 0 || key == 1) {
            if (dRandom >= 470.0d) {
                return new CopyOnWriteArrayList();
            }
            if (dRandom < 30.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 60.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 80.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 100.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 120.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 130.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard")));
            }
            if (dRandom < 150.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest")));
            }
            if (dRandom < 170.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 190.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 210.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 230.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 240.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 250.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 260.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 270.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 280.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ImperialGuard")));
            }
            if (dRandom < 300.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 320.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 340.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 360.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 370.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 380.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsaneCitizen")));
            }
            if (dRandom < 390.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsanePriest")));
            }
            if (dRandom < 400.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("ImperialGuard")));
            }
            if (dRandom < 410.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 420.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 430.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 440.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 460.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
            }
            if (dRandom < 470.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("ArcaneAssassin"), Enemy.getInstance("CityWarden")));
            }
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom < 40.0d) {
            trapEncounter(R.string.log_the_golden_city_finding_3, R.string.dexterity, 20, 50, false);
            return;
        }
        if (dRandom < 60.0d) {
            Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_finding_2));
            for (Adventurer adventurer : this.adventurersExploring) {
                if (adventurer.getCurrentHp() > 0) {
                    int iMax = Math.max(1, 40 - adventurer.calculateTotalConstitution());
                    adventurer.applyDamage(iMax, true, this.petExploring != null ? this.petExploring.getBarrier() : 0, 0.0d);
                    refreshDialog();
                    Logger.log(this, 48, Integer.valueOf(iMax), Integer.valueOf(adventurer.getIdName()));
                }
            }
            return;
        }
        if (dRandom < 90.0d) {
            for (Adventurer adventurer2 : this.adventurersExploring) {
                adventurer2.setCurrentHp(adventurer2.calculateTotalMaxHp());
            }
            refreshDialog();
            Logger.log(this, 102, Integer.valueOf(R.string.log_the_golden_city_finding_1));
            return;
        }
        if (dRandom < 100.0d) {
            collectItemFromGround(Item.getInstance("SilkThread", 1));
            return;
        }
        if (dRandom < 110.0d) {
            collectItemFromGround(Item.getInstance("Redwood", 1));
            return;
        }
        if (dRandom < 115.0d) {
            collectItemFromGround(Item.getInstance("Ivory", 1));
        } else if (dRandom < 117.0d) {
            collectItemFromGround(Item.getInstance("GoldScraps", 1));
        } else {
            Logger.log(this, 41, new Object[0]);
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.2d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_room_1));
                } else if (dRandom < 0.4d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_room_2));
                } else if (dRandom < 0.6d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_room_3));
                } else if (dRandom < 0.8d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_room_4));
                } else {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_room_5));
                }
                if (this.event == null && Utils.random() < 0.003d) {
                    this.event = new Event(Event.ANGRY_EYE);
                    this.event.setProgress(5);
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_golden_city_event_1a));
                    break;
                }
                            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 < 0.2d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_encounter_1));
                } else if (dRandom2 < 0.4d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_encounter_2));
                } else if (dRandom2 < 0.6d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_encounter_3));
                } else if (dRandom2 < 0.8d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_encounter_4));
                } else {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_golden_city_encounter_5));
                }
                if (this.event != null && this.event.getKey() == 1) {
                    if (Utils.random() < 0.25d) {
                        this.event = null;
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_golden_city_event_1b));
                    } else {
                        for (Enemy enemy : this.enemies) {
                            applyStatus(enemy, new StatusEffect(StatusEffectType.DELIRIUM, enemy, 999, 1.0d), 0.0d);
                        }
                    }
                    break;
                }
                            case "victory":
                if (this.event != null && this.event.getKey() == 1) {
                    QuestsManager.increment(QuestsManager.delirious, this.corpses.size());
                    break;
                }
                            case "kill_InsaneCitizen":
                QuestsManager.increment(QuestsManager.psychiatrist, 1L);
                break;
            case "respawn":
                this.event = null;
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_golden_city_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getBlackwaterPort(), 100);
        linkedHashMap.put(MainActivity.data.getImperialRescue(), 150);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("InsanePriest"), Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ArcaneAssassin"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("SilkThread", 8), 200);
        linkedHashMap.put(Item.getInstance("GoldScraps", 6), 160);
        linkedHashMap.put(Item.getInstance("Emerald", 1), 160);
        linkedHashMap.put(Item.getInstance("Ruby", 1), 160);
        linkedHashMap.put(Item.getInstance("Ivory", 1), 160);
        linkedHashMap.put(Item.getInstance("BlackOoze", 10), 160);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("SilkRobe", 1), 125);
        linkedHashMap.put(Item.getInstance("BeltJacket", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenArmor", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenSword", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenBoots", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenGauntlets", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenHelm", 1), 125);
        linkedHashMap.put(Item.getInstance("GoldenShield", 1), 125);
        return linkedHashMap;
    }
}
