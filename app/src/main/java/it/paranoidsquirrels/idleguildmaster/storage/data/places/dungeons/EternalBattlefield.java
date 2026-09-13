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
public class EternalBattlefield extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 20;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_eternal_battlefield;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_eternal_battlefield;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_eternal_battlefield;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().eternalBattlefield;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        int key = this.event == null ? 0 : this.event.getKey();
        if (key == 0 || key == 1) {
            if (dRandom >= 580.0d) {
                return new CopyOnWriteArrayList();
            }
            if (dRandom < 20.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DeathHound")));
            }
            if (dRandom < 40.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead")));
            }
            if (dRandom < 60.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 90.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 120.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("DeathHound")));
            }
            if (dRandom < 150.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 180.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 210.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Abomination"), Enemy.getInstance("UndeadWarlord")));
            }
            if (dRandom < 240.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Ghoul"), Enemy.getInstance("WillOWisp")));
            }
            if (dRandom < 260.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 280.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 300.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 320.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 340.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Abomination"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 360.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("DeathHound")));
            }
            if (dRandom < 380.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("WillOWisp"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 400.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Ghoul"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 420.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DeathHound"), Enemy.getInstance("Ghoul"), Enemy.getInstance("DeathHound")));
            }
            if (dRandom < 440.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 460.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 480.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Ghoul"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 500.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 520.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadArcher")));
            }
            if (dRandom < 540.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 560.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")));
            }
            if (dRandom < 580.0d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("WillOWisp"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("Undead")));
            }
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if ((this.event == null ? 0 : this.event.getKey()) == 1 && this.event.getProgress() >= 200) {
            this.event = null;
            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_eternal_battlefield_event_1b));
            collectItemFromGround(Item.getInstance("OrbOfEctoplasm", 1));
            return;
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom < 40.0d) {
            trapEncounter(R.string.log_eternal_battlefield_finding_1, R.string.dexterity, 7, 80, false);
        } else if (dRandom < 80.0d) {
            trapEncounter(R.string.log_eternal_battlefield_finding_2, R.string.intelligence, 21, 30, true);
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
                    Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_room_1));
                    break;
                } else {
                    if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_room_2));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_room_3));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_room_4));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_room_5));
                    }
                    break;
                }
                            case "kill_WillOWisp":
                if (this.event == null || this.event.getKey() == 0) {
                    this.event = new Event(Event.WILL_O_WISP_HUNT);
                }
                int progress = this.event.getProgress() + 1;
                this.event.setProgress(progress);
                Logger.log(this, 47, Integer.valueOf(progress));
                QuestsManager.increment(QuestsManager.exorcism, 1L);
                break;
            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 < 0.2d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_eternal_battlefield_encounter_1));
                    break;
                } else {
                    if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_eternal_battlefield_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_eternal_battlefield_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_eternal_battlefield_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_eternal_battlefield_encounter_5));
                    }
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_eternal_battlefield_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getTheGoldenCity(), 100);
        linkedHashMap.put(MainActivity.data.getAncientGraveDigging(), 150);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("WillOWisp"), Enemy.getInstance("Ghoul"), Enemy.getInstance("Abomination"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("BoneFragment", 8), 200);
        linkedHashMap.put(Item.getInstance("TatteredHide", 5), 160);
        linkedHashMap.put(Item.getInstance("ElongatedBone", 1), 160);
        linkedHashMap.put(Item.getInstance("SharpRib", 1), 160);
        linkedHashMap.put(Item.getInstance("SpectralCloth", 1), 160);
        linkedHashMap.put(Item.getInstance("InfectedBlood", 1), 160);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("UndeadGreaves", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadHelm", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadGloves", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadStaff", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadShield", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadSword", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadJacket", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadCuirass", 1), 100);
        linkedHashMap.put(Item.getInstance("UndeadKnife", 1), 100);
        linkedHashMap.put(Item.getInstance("SpectralRobe", 1), 100);
        return linkedHashMap;
    }
}
