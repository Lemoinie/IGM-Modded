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
public class BlackwaterPort extends Area {
    private static final int EMPTY_ENEMIES_FOR_KRAKEN = 10;

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
        return R.string.dungeon_name_blackwater_port;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_blackwater_port;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_blackwater_port;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().blackwaterPort;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 385.0d) {
            if (this.event == null) {
                this.event = new Event(Event.THE_KRAKEN);
            }
            int progress = this.event.getProgress() + 1;
            this.event.setProgress(progress);
            if (progress == 10) {
                Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_blackwater_port_event_1a));
            }
            return new CopyOnWriteArrayList();
        }
        if (this.event != null && this.event.getProgress() >= 10) {
            this.event = new Event(Event.THE_KRAKEN_FIGHT);
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("MysteriousTentacle")));
        }
        this.event = null;
        if (dRandom < 1.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Mimic")));
        }
        if (dRandom < 11.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MysteriousTentacle")));
        }
        if (dRandom < 50.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 90.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate")));
        }
        if (dRandom < 110.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 130.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 150.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 170.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("PirateLieutenant")));
        }
        if (dRandom < 190.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant")));
        }
        if (dRandom < 205.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 220.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 235.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 250.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 265.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 280.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateCaptain"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 295.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateCaptain"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 310.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 325.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 340.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 355.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate")));
        }
        if (dRandom < 370.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("Pirate"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")));
        }
        if (dRandom < 385.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("Deckhand"), Enemy.getInstance("Deckhand")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if (this.event != null && this.event.getKey() == 2) {
            QuestsManager.increment(QuestsManager.thalassophobia, 1L);
            Item item = Item.getInstance("EyeOfTheAbyss", 1);
            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_blackwater_port_event_1d));
            collectItemFromGround(item);
            this.event = null;
            return;
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom < 30.0d) {
            Item item2 = Item.getInstance("Pearl", 1);
            Logger.log(this, 102, Integer.valueOf(R.string.log_blackwater_port_finding_1));
            collectItemFromGround(item2);
            return;
        }
        if (dRandom < 60.0d) {
            collectItemFromGround(Item.getInstance("GhostwoodStump", 1));
            return;
        }
        if (dRandom < 110.0d) {
            collectItemFromGround(Item.getInstance("MissingPage", 1));
            return;
        }
        if (dRandom < 160.0d) {
            trapEncounter(R.string.log_blackwater_port_finding_2, R.string.dexterity, 40, 40, false);
            return;
        }
        if (dRandom < 210.0d) {
            trapEncounter(R.string.log_blackwater_port_finding_3, R.string.dexterity, 10, 150, false);
            return;
        }
        if (dRandom < 260.0d) {
            trapEncounter(R.string.log_blackwater_port_finding_4, R.string.constitution, 20, 60, true);
        } else if (dRandom < 310.0d) {
            trapEncounter(R.string.log_blackwater_port_finding_5, R.string.intelligence, 20, 60, false);
        } else {
            Logger.log(this, 41, new Object[0]);
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_Mimic":
                QuestsManager.increment(QuestsManager.niceTry, 1L);
                break;
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.2d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_room_1));
                    break;
                } else {
                    if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_room_2));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_room_3));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_room_4));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_room_5));
                    }
                    break;
                }
                            case "flee":
            case "respawn":
                this.event = null;
                break;
            case "fight_start":
                if (this.event != null && this.event.getKey() == 2) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_blackwater_port_event_1b));
                    break;
                } else {
                    double dRandom2 = Utils.random();
                    if (dRandom2 < 0.2d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_blackwater_port_encounter_1));
                    } else if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_blackwater_port_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_blackwater_port_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_blackwater_port_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_blackwater_port_encounter_5));
                    }
                    break;
                }
                            case "victory":
                if (this.event != null && this.event.getKey() == 2) {
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_blackwater_port_event_1c));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_blackwater_port_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getFrostbitePeaks(), 100);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Deckhand"), Enemy.getInstance("Pirate"), Enemy.getInstance("PirateLieutenant"), Enemy.getInstance("PirateCaptain"), Enemy.getInstance("MysteriousTentacle"), Enemy.getInstance("Mimic"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("GhostwoodBoard", 2), 170);
        linkedHashMap.put(Item.getInstance("BlackIronScraps", 8), 166);
        linkedHashMap.put(Item.getInstance("ExoticVelvet", 2), 166);
        linkedHashMap.put(Item.getInstance("MysteriousAppendage", 4), 166);
        linkedHashMap.put(Item.getInstance("AbyssalSeashell", 8), 166);
        linkedHashMap.put(Item.getInstance("MonkeyHide", 5), 166);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("BlackIronArmor", 1), 91);
        linkedHashMap.put(Item.getInstance("ExoticRobe", 1), 91);
        linkedHashMap.put(Item.getInstance("BlackIronHelm", 1), 91);
        linkedHashMap.put(Item.getInstance("ExoticBoots", 1), 91);
        linkedHashMap.put(Item.getInstance("BlackIronGauntlets", 1), 91);
        linkedHashMap.put(Item.getInstance("GhostwoodShield", 1), 91);
        linkedHashMap.put(Item.getInstance("BlackIronCutlass", 1), 91);
        linkedHashMap.put(Item.getInstance("BlackIronScepter", 1), 91);
        linkedHashMap.put(Item.getInstance("BlackIronDagger", 1), 91);
        linkedHashMap.put(Item.getInstance("GhostwoodBow", 1), 91);
        linkedHashMap.put(Item.getInstance("MonkeyHideJacket", 1), 90);
        return linkedHashMap;
    }
}
