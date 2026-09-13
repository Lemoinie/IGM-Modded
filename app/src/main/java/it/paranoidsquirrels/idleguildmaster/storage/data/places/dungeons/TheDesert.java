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
public class TheDesert extends Area {
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
        return R.string.dungeon_name_the_desert;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_desert;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_desert;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().theDesert;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        int key = this.event == null ? 0 : this.event.getKey();
        if (key == 0 || key == 1) {
            if (dRandom >= 450.0d) {
                return new CopyOnWriteArrayList();
            }
            if (dRandom < 25.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 50.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriArcher")));
            }
            if (dRandom < 75.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wurm")));
            }
            if (dRandom < 100.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SandVulture")));
            }
            if (dRandom < 125.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wurm"), Enemy.getInstance("SandVulture")));
            }
            if (dRandom < 150.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wurm"), Enemy.getInstance("Wurm")));
            }
            if (dRandom < 175.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SandVulture"), Enemy.getInstance("SandVulture")));
            }
            if (dRandom < 200.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 225.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriArcher")));
            }
            if (dRandom < 245.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wurm"), Enemy.getInstance("SandVulture"), Enemy.getInstance("Wurm")));
            }
            if (dRandom < 265.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher")));
            }
            if (dRandom < 285.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 305.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage")));
            }
            if (dRandom < 325.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 345.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage")));
            }
            if (dRandom < 360.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage")));
            }
            if (dRandom < 375.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 390.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 405.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher")));
            }
            if (dRandom < 420.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriMage")));
            }
            if (dRandom < 435.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior")));
            }
            if (dRandom < 450.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Djinn")));
            }
        } else if (key == 2) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue"), Enemy.getInstance("SandStatue")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        double dRandom = Utils.random() * 1000.0d;
        int key = this.event == null ? 0 : this.event.getKey();
        if (key != 0 && key != 1) {
            if (key != 2) {
                return;
            }
            Logger.log(this, 41, new Object[0]);
            return;
        }
        if (dRandom < 10.0d) {
            collectItemFromGround(Item.getInstance("Quartz", 1));
            return;
        }
        if (dRandom < 35.0d) {
            collectItemFromGround(Item.getInstance("Sandstone", 1));
            return;
        }
        if (dRandom < 85.0d) {
            Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_finding_1));
            StatusEffect statusEffect = new StatusEffect(StatusEffectType.SILENCE, null, 5, 100.0d);
            for (Adventurer adventurer : this.adventurersExploring) {
                if (adventurer.getCurrentHp() > 0) {
                    applyStatus(adventurer, statusEffect, 0.0d);
                }
            }
            return;
        }
        if (dRandom < 100.0d) {
            for (Adventurer adventurer2 : this.adventurersExploring) {
                if (adventurer2.getCurrentHp() > 0) {
                    adventurer2.setCurrentHp(Math.min(adventurer2.calculateTotalMaxHp(), adventurer2.getCurrentHp() + 10));
                    adventurer2.setCurrentMana(Math.min(100, adventurer2.getCurrentMana() + 10));
                }
            }
            refreshDialog();
            Logger.log(this, 102, Integer.valueOf(R.string.log_the_desert_finding_2));
            return;
        }
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        int key = this.event == null ? 0 : this.event.getKey();
        str.hashCode();
        switch (str) {
            case "kill_SandStatue":
                QuestsManager.increment(QuestsManager.godFeared, 1L);
                break;
            case "kill_ShahuriWarrior":
            case "kill_ShahuriMage":
            case "kill_ShahuriArcher":
                if (key == 0) {
                    this.event = new Event(Event.SHAHURI_ARMY_CHARGING);
                    this.event.setProgress(1);
                    Logger.log(this, 44, Integer.valueOf(R.string.log_the_desert_event_1a), 1);
                } else if (key == 1) {
                    int progress = this.event.getProgress() + 1;
                    this.event.setProgress(progress);
                    Logger.log(this, 44, Integer.valueOf(R.string.log_the_desert_event_1a), Integer.valueOf(progress));
                    if (this.event.getProgress() >= 100) {
                        this.event = new Event(Event.SHAHURI_ARMY_READY);
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_desert_event_1b));
                    }
                }
                QuestsManager.increment(QuestsManager.conqueror, 1L);
                break;
            case "enter_room":
                if (key == 0 || key == 1) {
                    double dRandom = Utils.random();
                    if (dRandom < 0.2d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_room_1));
                    } else if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_room_2));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_room_3));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_room_4));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_room_5));
                    }
                    break;
                } else if (key == 2) {
                    if (this.event.getProgress() < 10) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_event_1c));
                    } else {
                        this.event = null;
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_desert_event_1e));
                    }
                    break;
                }
                            case "fight_start":
                if (key == 0 || key == 1) {
                    double dRandom2 = Utils.random();
                    if (dRandom2 < 0.2d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_encounter_1));
                    } else if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_desert_encounter_5));
                    }
                    break;
                } else if (key == 2) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_desert_event_1d));
                    this.event.setProgress(this.event.getProgress() + 1);
                    break;
                }
                            case "respawn":
                this.event = null;
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_desert_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getEternalBattlefield(), 100);
        linkedHashMap.put(MainActivity.data.getDivineArcheology(), 150);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Wurm"), Enemy.getInstance("SandVulture"), Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("Djinn"), Enemy.getInstance("SandStatue"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("ScrapMetal", 5), 200);
        linkedHashMap.put(Item.getInstance("Sandstone", 6), 200);
        linkedHashMap.put(Item.getInstance("WurmScale", 8), 200);
        linkedHashMap.put(Item.getInstance("Feather", 5), 200);
        linkedHashMap.put(Item.getInstance("MetamorphicSand", 10), 200);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("GlassKnife", 1), 100);
        linkedHashMap.put(Item.getInstance("WurmscalesShield", 1), 100);
        linkedHashMap.put(Item.getInstance("FeatherRobe", 1), 100);
        linkedHashMap.put(Item.getInstance("WurmscalesGloves", 1), 100);
        linkedHashMap.put(Item.getInstance("Scimitar", 1), 100);
        linkedHashMap.put(Item.getInstance("ShahuriBow", 1), 100);
        linkedHashMap.put(Item.getInstance("IronChainmail", 1), 100);
        linkedHashMap.put(Item.getInstance("WurmscalesJacket", 1), 100);
        linkedHashMap.put(Item.getInstance("WurmscalesBoots", 1), 100);
        linkedHashMap.put(Item.getInstance("IronHelm", 1), 100);
        return linkedHashMap;
    }
}
