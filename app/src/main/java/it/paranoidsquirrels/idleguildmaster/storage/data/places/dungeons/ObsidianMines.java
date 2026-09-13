package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
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
public class ObsidianMines extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_obsidian_mines;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_obsidian_mines;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_obsidian_mines;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().obsidianMines;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.event != null && this.event.getKey() == 1 && this.event.getProgress() >= 70) {
            this.event = new Event(Event.UNSPEAKABLE_HORROR_COOLDOWN);
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("PaleHermit")));
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 600.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 15.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 30.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("VampireBat")));
        }
        if (dRandom < 45.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ObsidianGolem")));
        }
        if (dRandom < 60.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner")));
        }
        if (dRandom < 85.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 110.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("VampireBat"), Enemy.getInstance("VampireBat")));
        }
        if (dRandom < 135.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat")));
        }
        if (dRandom < 160.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner"), Enemy.getInstance("ObsidianGolem")));
        }
        if (dRandom < 200.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 240.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 280.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("VampireBat")));
        }
        if (dRandom < 320.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 360.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("VampireBat")));
        }
        if (dRandom < 400.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("Beholder"), Enemy.getInstance("ObsidianGolem")));
        }
        if (dRandom < 440.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("VampireBat"), Enemy.getInstance("Beholder"), Enemy.getInstance("ObsidianGolem")));
        }
        if (dRandom < 480.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 520.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 560.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantSpider"), Enemy.getInstance("VampireBat"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("GiantSpider")));
        }
        if (dRandom < 600.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("VampireBat"), Enemy.getInstance("Beholder"), Enemy.getInstance("GiantSpider")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if (Utils.random() * 1000.0d < 10.0d) {
            collectItemFromGround(Item.getInstance("ObsidianChunk", 1));
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
                if (dRandom < 0.14d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_1));
                } else if (dRandom < 0.28d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_2));
                } else if (dRandom < 0.43d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_3));
                } else if (dRandom < 0.57d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_4));
                } else if (dRandom < 0.71d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_5));
                } else if (dRandom < 0.85d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_6));
                } else {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_room_7));
                }
                if (this.event == null) {
                    this.event = new Event(Event.UNSPEAKABLE_HORROR);
                    break;
                } else {
                    if (this.event.getKey() == 2) {
                        int progress = this.event.getProgress() + 1;
                        if (progress < 10) {
                            this.event.setProgress(progress);
                        } else {
                            this.event = new Event(Event.UNSPEAKABLE_HORROR);
                        }
                    } else if (this.event.getKey() == 1) {
                        int progress2 = this.event.getProgress();
                        boolean z = progress2 >= 50;
                        this.event.setProgress(progress2 + (z ? 5 : 1));
                        if (z) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_obsidian_mines_event_1a));
                        }
                    }
                    break;
                }
                            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 < 0.2d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_obsidian_mines_encounter_1));
                    break;
                } else {
                    if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_obsidian_mines_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_obsidian_mines_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_obsidian_mines_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_obsidian_mines_encounter_5));
                    }
                    break;
                }
                            case "kill_PaleHermit":
                QuestsManager.increment(QuestsManager.darknessWithin, 1L);
                break;
            case "kill_Beholder":
                QuestsManager.increment(QuestsManager.myopia, 1L);
                break;
            case "respawn":
                this.event = new Event(Event.UNSPEAKABLE_HORROR_COOLDOWN);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_obsidian_mines_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        if (this.event == null || this.event.getKey() != 1) {
            return 10;
        }
        return 10 + Math.min(70, this.event.getProgress());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getTheDreadfulAscent(), 100);
        linkedHashMap.put(MainActivity.data.getTheLostExpedition(), 220);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("VampireBat"), Enemy.getInstance("GiantSpider"), Enemy.getInstance("ObsidianGolem"), Enemy.getInstance("Beholder"), Enemy.getInstance("LostMiner"), Enemy.getInstance("PaleHermit"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("BatWing", 6), 230);
        linkedHashMap.put(Item.getInstance("CobwebBundle", 5), 230);
        linkedHashMap.put(Item.getInstance("ObsidianChunk", 6), 230);
        linkedHashMap.put(Item.getInstance("BatTooth", 4), 105);
        linkedHashMap.put(Item.getInstance("SpiderLeg", 4), 105);
        linkedHashMap.put(Item.getInstance("EldritchTendril", 2), 100);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("SpiderGloves", 1), 91);
        linkedHashMap.put(Item.getInstance("SpiderBoots", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianHelm", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianShield", 1), 91);
        linkedHashMap.put(Item.getInstance("SpiderRobe", 1), 91);
        linkedHashMap.put(Item.getInstance("NightwingJacket", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianCuirass", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianSword", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianDagger", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianBow", 1), 91);
        linkedHashMap.put(Item.getInstance("ObsidianScepter", 1), 90);
        return linkedHashMap;
    }
}
