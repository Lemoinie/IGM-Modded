package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BarrenWastelands extends Area {
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
        return R.string.dungeon_name_barren_wastelands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_barren_wastelands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_barren_wastelands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().barrenWastelands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 495.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 100.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Banshee")));
        }
        if (dRandom < 130.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Banshee")));
        }
        if (dRandom < 160.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Banshee")));
        }
        if (dRandom < 190.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Banshee")));
        }
        if (dRandom < 220.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Banshee"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 250.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus"), Enemy.getInstance("Banshee"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 267.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 284.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus")));
        }
        if (dRandom < 301.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialDestroyer")));
        }
        if (dRandom < 318.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 335.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 352.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 369.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 386.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 403.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 420.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 437.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer")));
        }
        if (dRandom < 454.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 471.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")));
        }
        if (dRandom < 488.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus"), Enemy.getInstance("Iconoclast")));
        }
        if (dRandom < 495.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("Oculus")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if (Utils.random() * 1000.0d < 20.0d) {
            trapEncounter(R.string.log_barren_wastelands_finding_1, R.string.dexterity, 30, 70, false);
        } else {
            Logger.log(this, 41, new Object[0]);
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_Banshee":
                QuestsManager.increment(QuestsManager.clashOfTitans, 1L);
                break;
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.1d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_1));
                    break;
                } else {
                    if (dRandom < 0.2d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_2));
                    } else if (dRandom < 0.3d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_3));
                    } else if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_4));
                    } else if (dRandom < 0.5d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_5));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_6));
                    } else if (dRandom < 0.7d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_7));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_8));
                    } else if (dRandom < 0.9d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_9));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_room_10));
                    }
                }
                break;
            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 < 0.2d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_barren_wastelands_encounter_1));
                    break;
                } else {
                    if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_barren_wastelands_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_barren_wastelands_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_barren_wastelands_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_barren_wastelands_encounter_5));
                    }
                }
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_barren_wastelands_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getHiddenCityOfLarox(), 100);
        linkedHashMap.put(MainActivity.data.getCelestialMothership(), 180);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Iconoclast"), Enemy.getInstance("Oculus"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("Banshee"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("ElasticMembrane", 12), 260);
        linkedHashMap.put(Item.getInstance("CelestialScraps", 5), 260);
        linkedHashMap.put(Item.getInstance("BansheeScale", 6), 260);
        Item item = Item.getInstance("AetherIgnis", 1);
        Integer numValueOf = Integer.valueOf(Logger.STATUS_FEEBLE_TETHER);
        linkedHashMap.put(item, numValueOf);
        linkedHashMap.put(Item.getInstance("ChainLink", 1), numValueOf);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        Item item = Item.getInstance("CelestialArmor", 1);
        Integer numValueOf = Integer.valueOf(Logger.STATUS_PETRIFIED);
        linkedHashMap.put(item, numValueOf);
        linkedHashMap.put(Item.getInstance("BansheeJacket", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("ElasticRobe", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("CelestialHelmet", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("CelestialShield", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("BansheeGloves", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("ElasticBoots", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("CelestialSword", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("BansheeDagger", 1), Integer.valueOf(Logger.LOST_EXPEDITION_FALL_DAMAGE));
        return linkedHashMap;
    }
}
