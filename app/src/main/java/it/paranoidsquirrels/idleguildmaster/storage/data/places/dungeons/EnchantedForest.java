package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.Formulas;
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
public class EnchantedForest extends Area {
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
        return R.string.dungeon_name_enchanted_forest;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_enchanted_forest;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_enchanted_forest;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().enchantedForest;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        int key = this.event == null ? 0 : this.event.getKey();
        if (key != 0) {
            if (key == 1) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ForestSpirit")));
            }
            if (key == 2) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TutorialWolf")));
            }
        } else {
            if (dRandom >= 500.0d) {
                return new CopyOnWriteArrayList();
            }
            if (Formulas.getQuartersCapacity() <= 2) {
                if (dRandom < 100.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf")));
                }
                if (dRandom < 200.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Boar")));
                }
                if (dRandom < 300.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Treant")));
                }
                if (dRandom < 400.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Centaur")));
                }
                if (dRandom < 500.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")));
                }
            } else {
                if (dRandom < 10.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("GoldenRabbit")));
                }
                if (dRandom < 30.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Ent")));
                }
                if (dRandom < 80.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf")));
                }
                if (dRandom < 130.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Boar")));
                }
                if (dRandom < 180.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Treant")));
                }
                if (dRandom < 210.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Centaur")));
                }
                if (dRandom < 240.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 270.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 300.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Boar"), Enemy.getInstance("Boar")));
                }
                if (dRandom < 330.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Treant")));
                }
                if (dRandom < 360.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Boar"), Enemy.getInstance("Treant")));
                }
                if (dRandom < 380.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Treant"), Enemy.getInstance("Treant")));
                }
                if (dRandom < 400.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Centaur"), Enemy.getInstance("Centaur")));
                }
                if (dRandom < 420.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 440.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 460.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Treant"), Enemy.getInstance("Boar"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 480.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Centaur"), Enemy.getInstance("Wolf")));
                }
                if (dRandom < 500.0d) {
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Treant"), Enemy.getInstance("Centaur"), Enemy.getInstance("Boar")));
                }
            }
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom < 50.0d) {
            collectItemFromGround(Item.getInstance("CopperOre", 1));
            return;
        }
        if (dRandom < 150.0d) {
            collectItemFromGround(Item.getInstance("Wood", 1));
            return;
        }
        if (dRandom < 170.0d) {
            for (Adventurer adventurer : this.adventurersExploring) {
                adventurer.setCurrentHp(adventurer.calculateTotalMaxHp());
            }
            refreshDialog();
            Logger.log(this, 102, Integer.valueOf(R.string.log_enchanted_forest_finding_1));
            return;
        }
        if (dRandom >= 190.0d) {
            if (dRandom < 230.0d) {
                trapEncounter(R.string.log_enchanted_forest_finding_3, R.string.dexterity, 10, 10, false);
                return;
            } else {
                Logger.log(this, 41, new Object[0]);
                return;
            }
        }
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.getCurrentHp() > 0) {
                adventurer2.setCurrentMana(100);
            }
        }
        refreshDialog();
        Logger.log(this, 102, Integer.valueOf(R.string.log_enchanted_forest_finding_2));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.2d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_room_1));
                    break;
                } else {
                    if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_room_2));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_room_3));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_room_4));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_room_5));
                    }
                    break;
                }
                            case "kill_GoldenRabbit":
                QuestsManager.increment(QuestsManager.softAndFluffy, 1L);
                this.event = new Event(Event.ENRAGED_SPIRIT);
                Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_enchanted_forest_event_1a));
                break;
            case "fight_start":
                if (this.event != null && this.event.getKey() == 1) {
                    this.event = null;
                    Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_enchanted_forest_event_1b));
                    break;
                } else {
                    double dRandom2 = Utils.random();
                    if (dRandom2 < 0.2d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_enchanted_forest_encounter_1));
                    } else if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_enchanted_forest_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_enchanted_forest_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_enchanted_forest_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_enchanted_forest_encounter_5));
                    }
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_enchanted_forest_enter));
                if (MainActivity.data.getTutorialStep() == 2) {
                    this.event = new Event(Event.TUTORIAL);
                    break;
                }
                        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getTheDesert(), 80);
        linkedHashMap.put(MainActivity.data.getTheSlimePond(), 150);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Wolf"), Enemy.getInstance("Boar"), Enemy.getInstance("Treant"), Enemy.getInstance("Centaur"), Enemy.getInstance("Ent"), Enemy.getInstance("GoldenRabbit"), Enemy.getInstance("ForestSpirit"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("BeastPelt", 3), 240);
        linkedHashMap.put(Item.getInstance("PlantFiber", 6), 240);
        linkedHashMap.put(Item.getInstance("CopperOre", 5), 240);
        linkedHashMap.put(Item.getInstance("Wood", 8), 240);
        linkedHashMap.put(Item.getInstance("CottontailFur", 1), 40);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("LeatherJacket", 1), 91);
        linkedHashMap.put(Item.getInstance("FangDagger", 1), 91);
        linkedHashMap.put(Item.getInstance("ClothRobe", 1), 91);
        linkedHashMap.put(Item.getInstance("EnchantedStaff", 1), 91);
        linkedHashMap.put(Item.getInstance("CopperSword", 1), 91);
        linkedHashMap.put(Item.getInstance("CopperArmor", 1), 91);
        linkedHashMap.put(Item.getInstance("WoodenBow", 1), 91);
        linkedHashMap.put(Item.getInstance("LeatherBoots", 1), 91);
        linkedHashMap.put(Item.getInstance("LeatherGloves", 1), 91);
        linkedHashMap.put(Item.getInstance("CopperHelmet", 1), 91);
        linkedHashMap.put(Item.getInstance("WoodenBuckler", 1), 90);
        return linkedHashMap;
    }
}
