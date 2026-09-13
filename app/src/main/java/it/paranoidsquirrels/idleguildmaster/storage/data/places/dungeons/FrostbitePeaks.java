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
public class FrostbitePeaks extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_frostbite_peaks;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_frostbite_peaks;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_frostbite_peaks;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().frostbitePeaks;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 290.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 20.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("TrollWhelp")));
        }
        if (dRandom < 40.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 60.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior")));
        }
        if (dRandom < 65.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("IceElemental"), Enemy.getInstance("IceElemental")));
        }
        if (dRandom < 85.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp")));
        }
        if (dRandom < 105.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 125.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("Troll"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 145.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 165.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 185.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior")));
        }
        if (dRandom < 205.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("TrollWarrior")));
        }
        if (dRandom < 210.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("IceElemental"), Enemy.getInstance("SnowWyvern"), Enemy.getInstance("IceElemental")));
        }
        if (dRandom < 230.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWhelp")));
        }
        if (dRandom < 250.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 270.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("Troll")));
        }
        if (dRandom < 290.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TrollWarrior"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("TrollWarrior")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 10.0d) {
            if (dRandom < 30.0d) {
                collectItemFromGround(Item.getInstance("Winterwood", 1));
                return;
            }
            if (dRandom < 50.0d) {
                collectItemFromGround(Item.getInstance("IceFiber", 1));
                return;
            }
            if (dRandom < 60.0d) {
                collectItemFromGround(Item.getInstance("FrostmetalOre", 1));
                return;
            } else if (dRandom < 100.0d) {
                trapEncounter(R.string.log_frostbite_peaks_finding_2, R.string.constitution, 35, 70, false);
                return;
            } else {
                Logger.log(this, 41, new Object[0]);
                return;
            }
        }
        Adventurer adventurer = null;
        int i = 0;
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.getCurrentHp() > 0) {
                int iCalculateTotalDexterity = adventurer2.calculateTotalDexterity();
                if (adventurer == null || iCalculateTotalDexterity > i) {
                    adventurer = adventurer2;
                    i = iCalculateTotalDexterity;
                }
            }
        }
        if (adventurer != null) {
            int i2 = i / 2;
            Logger.log(this, 51, Integer.valueOf(i), Integer.valueOf(adventurer.getIdName()), Integer.valueOf(i2));
            if (Utils.random() * 100.0d < i2) {
                Logger.log(this, 53, Integer.valueOf(adventurer.getIdName()));
                collectItemFromGround(Item.getInstance("Winterwood", 3));
                collectItemFromGround(Item.getInstance("FrostmetalOre", 3));
                collectItemFromGround(Item.getInstance("IceFiber", 3));
                if (Utils.random() < 0.25d) {
                    collectItemFromGround(Item.getInstance("FrostCrystal", 1));
                    return;
                }
                return;
            }
            Logger.log(this, 52, Integer.valueOf(adventurer.getIdName()));
            return;
        }
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        boolean z = false;
        switch (str) {
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.14d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_1));
                } else if (dRandom < 0.28d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_2));
                } else if (dRandom < 0.43d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_3));
                } else if (dRandom < 0.57d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_4));
                } else if (dRandom < 0.71d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_5));
                } else if (dRandom < 0.85d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_6));
                } else {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_room_7));
                }
                if (this.event == null) {
                    if (Utils.random() < 0.01d) {
                        this.event = new Event(Event.BLIZZARD);
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_frostbite_peaks_event_1a));
                    }
                } else if (this.event.getKey() == 1) {
                    int progress = this.event.getProgress() + 1;
                    this.event.setProgress(progress);
                    if (progress > 5) {
                        this.event = null;
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_frostbite_peaks_event_1b));
                    }
                }
                StatusEffect statusEffect = new StatusEffect(StatusEffectType.FROZEN, null, 3, 100.0d);
                if (this.event != null && this.event.getKey() == 1) {
                    z = true;
                }
                for (Adventurer adventurer : this.adventurersExploring) {
                    if (Utils.random() < (z ? 0.15d : 0.05d)) {
                        applyStatus(adventurer, statusEffect, 0.0d);
                    }
                }
                break;
            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 >= 0.2d) {
                    if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_frostbite_peaks_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_frostbite_peaks_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_frostbite_peaks_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_frostbite_peaks_encounter_5));
                    }
                    break;
                } else {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_frostbite_peaks_encounter_1));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_frostbite_peaks_enter));
                break;
            case "kill_IceElemental":
                QuestsManager.increment(QuestsManager.iceBreaker, 1L);
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        if (this.event == null || this.event.getKey() != 1) {
            return 0;
        }
        return ((int) (Utils.random() * 20.0d)) + 40;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getObsidianMines(), 100);
        linkedHashMap.put(MainActivity.data.getTheCultistRebels(), 150);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("TrollWhelp"), Enemy.getInstance("Troll"), Enemy.getInstance("TrollWarrior"), Enemy.getInstance("TrollShaman"), Enemy.getInstance("IceElemental"), Enemy.getInstance("SnowWyvern"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("IceFiber", 6), 200);
        linkedHashMap.put(Item.getInstance("FrostmetalOre", 5), 200);
        linkedHashMap.put(Item.getInstance("TrollHide", 5), 200);
        linkedHashMap.put(Item.getInstance("Winterwood", 6), 200);
        linkedHashMap.put(Item.getInstance("FrostCrystal", 1), 200);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("FrostmetalSword", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterwoodBow", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterwoodStaff", 1), 91);
        linkedHashMap.put(Item.getInstance("FrostmetalDagger", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterCape", 1), 91);
        linkedHashMap.put(Item.getInstance("TrollskinJacket", 1), 91);
        linkedHashMap.put(Item.getInstance("FrostmetalArmor", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterBoots", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterGloves", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterHelm", 1), 91);
        linkedHashMap.put(Item.getInstance("WinterShield", 1), 90);
        return linkedHashMap;
    }
}
