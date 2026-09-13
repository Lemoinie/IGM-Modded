package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
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
public class TheSouthernGrove extends Area {
    private static int PROGRESS_FOR_WURM = 14000;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 15;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_the_southern_grove;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_southern_grove;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_southern_grove;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().theSouthernGrove;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.event != null && this.event.getKey() == 1 && this.event.getProgress() >= PROGRESS_FOR_WURM) {
            this.event = new Event(Event.PRIMEVAL_WURM_COOLDOWN);
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("PrimevalWurm")));
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 600.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 20.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantTortoise")));
        }
        if (dRandom < 40.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 60.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 90.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 120.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 150.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 180.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 210.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("AncientEnt"), Enemy.getInstance("Dryad")));
        }
        if (dRandom < 240.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantMoth"), Enemy.getInstance("AncientEnt"), Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 260.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 280.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 300.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 320.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("Dryad")));
        }
        if (dRandom < 340.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("Dryad"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth")));
        }
        if (dRandom < 360.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("AncientEnt"), Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 380.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantMoth"), Enemy.getInstance("GiantTortoise"), Enemy.getInstance("Dryad"), Enemy.getInstance("GreenSpitfang")));
        }
        if (dRandom < 400.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("GiantTortoise")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if (this.event == null) {
            this.event = new Event(Event.PRIMEVAL_WURM_PROGRESS);
        }
        if (this.event.getKey() == 1) {
            double dCalculateTotalDexterity = 0.0d;
            int i = 0;
            for (Adventurer adventurer : this.adventurersExploring) {
                if (adventurer.getCurrentHp() > 0 && !adventurer.isSummonedMinion()) {
                    dCalculateTotalDexterity += (double) adventurer.calculateTotalDexterity();
                    i++;
                }
            }
            int iRound = Utils.round(dCalculateTotalDexterity / ((double) Math.max(1, i)));
            int iMax = Math.max(14, 300 - iRound);
            this.event.setProgress(this.event.getProgress() + iMax);
            int progress = ((PROGRESS_FOR_WURM - this.event.getProgress()) / iMax) + 1;
            if (this.event.getProgress() >= PROGRESS_FOR_WURM) {
                trapEncounter(R.string.log_the_southern_grove_wurm_trap, R.string.dexterity, 80, 1000, false);
                return;
            }
            Logger.log(this, 104, Integer.valueOf(iRound), Integer.valueOf(progress));
        } else if (this.event.getKey() == 2) {
            this.event.setProgress(this.event.getProgress() + 1);
            if (this.event.getProgress() > 40) {
                this.event = new Event(Event.PRIMEVAL_WURM_PROGRESS);
            }
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom < 60.0d) {
            collectItemFromGround(Item.getInstance("ElysianWood", 1));
            return;
        }
        if (dRandom < 110.0d) {
            trapEncounter(R.string.log_the_southern_grove_finding_1, R.string.dexterity, 50, 75, false);
        } else if (dRandom < 135.0d) {
            trapEncounter(R.string.log_the_southern_grove_finding_2, R.string.intelligence, 40, 90, true);
        } else {
            Logger.log(this, 41, new Object[0]);
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_Dryad":
                QuestsManager.increment(QuestsManager.innocence, 1L);
                break;
            case "enter_room":
                if (this.event != null && this.event.getKey() == 1) {
                    QuestsManager.incrementToValue(QuestsManager.marathon, this.progress);
                }
                double dRandom = Utils.random();
                if (dRandom < 0.1d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_1));
                    break;
                } else {
                    if (dRandom < 0.2d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_2));
                    } else if (dRandom < 0.3d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_3));
                    } else if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_4));
                    } else if (dRandom < 0.5d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_5));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_6));
                    } else if (dRandom < 0.7d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_7));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_8));
                    } else if (dRandom < 0.9d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_9));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_room_10));
                    }
                    break;
                }
                            case "kill_GiantTortoise":
                QuestsManager.increment(QuestsManager.speedyHare, 1L);
                break;
            case "fight_start":
                if (this.event != null && this.event.getKey() == 2 && this.event.getProgress() == 0) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_wurm_spawn));
                    break;
                } else {
                    double dRandom2 = Utils.random();
                    if (dRandom2 < 0.2d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_encounter_1));
                    } else if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_southern_grove_encounter_5));
                    }
                    break;
                }
                            case "respawn":
                this.event = new Event(Event.PRIMEVAL_WURM_PROGRESS);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_southern_grove_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getBarrenWastelands(), 60);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("GiantTortoise"), Enemy.getInstance("GiantMoth"), Enemy.getInstance("GreenSpitfang"), Enemy.getInstance("Dryad"), Enemy.getInstance("AncientEnt"), Enemy.getInstance("PrimevalWurm"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("ElysianWood", 12), 200);
        linkedHashMap.put(Item.getInstance("SpitfangScale", 5), 200);
        linkedHashMap.put(Item.getInstance("GiantShellFragment", 6), 200);
        linkedHashMap.put(Item.getInstance("GiantMothWing", 5), 200);
        linkedHashMap.put(Item.getInstance("FleetfootFabric", 2), 100);
        linkedHashMap.put(Item.getInstance("TortoiseThorn", 2), 100);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        Item item = Item.getInstance("TortoiseArmor", 1);
        Integer numValueOf = Integer.valueOf(Logger.STATUS_PETRIFIED);
        linkedHashMap.put(item, numValueOf);
        linkedHashMap.put(Item.getInstance("SpitfangJacket", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("MothRobe", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("VerdantHelm", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("TortoiseShield", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("VerdantBoots", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("VerdantGloves", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("VerdantBow", 1), numValueOf);
        linkedHashMap.put(Item.getInstance("VerdantBlade", 1), Integer.valueOf(Logger.LOST_EXPEDITION_FALL_DAMAGE));
        return linkedHashMap;
    }
}
