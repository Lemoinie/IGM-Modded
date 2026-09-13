package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.SmolderingTitan;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class LostLands extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 12;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_lost_lands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_lost_lands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_lost_lands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().lostLands;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.event != null && this.event.getKey() == 1 && this.event.getProgress() >= 100) {
            this.event = null;
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SmolderingTitan")));
        }
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 312.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 26.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Berserker")));
        }
        if (dRandom < 52.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pterodactyl")));
        }
        if (dRandom < 78.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Terrorsaurus")));
        }
        if (dRandom < 104.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("Berserker")));
        }
        if (dRandom < 130.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Berserker"), Enemy.getInstance("Berserker")));
        }
        if (dRandom < 156.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")));
        }
        if (dRandom < 182.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Berserker"), Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("Berserker")));
        }
        if (dRandom < 208.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Terrorsaurus"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")));
        }
        if (dRandom < 234.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Terrorsaurus"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Terrorsaurus")));
        }
        if (dRandom < 260.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Pterodactyl"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")));
        }
        if (dRandom < 286.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Berserker"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Terrorsaurus")));
        }
        if (dRandom < 312.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("Pterodactyl")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        if (Utils.random() * 1000.0d < 1.0d && Utils.random() < 0.1d) {
            Item item = Item.getInstance("Diamond", 1);
            Logger.log(this, 102, Integer.valueOf(R.string.log_lost_lands_finding_1));
            collectItemFromGround(item);
            return;
        }
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.1d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_1));
                    break;
                } else {
                    if (dRandom < 0.2d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_2));
                    } else if (dRandom < 0.3d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_3));
                    } else if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_4));
                    } else if (dRandom < 0.5d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_5));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_6));
                    } else if (dRandom < 0.7d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_7));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_8));
                    } else if (dRandom < 0.9d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_9));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_room_10));
                    }
                    break;
                }
                            case "fight_start":
                if (this.enemies.size() == 1 && (this.enemies.get(0) instanceof SmolderingTitan)) {
                    Logger.log(this, Logger.SUMMON_SMOLDERING_TITAN, new Object[0]);
                    break;
                } else {
                    double dRandom2 = Utils.random();
                    if (dRandom2 < 0.2d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_lost_lands_encounter_1));
                    } else if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_lost_lands_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_lost_lands_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_lost_lands_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_lost_lands_encounter_5));
                    }
                    break;
                }
                            case "respawn":
                this.event = null;
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_lost_lands_enter));
                break;
            case "kill_SmolderingTitan":
                QuestsManager.increment(QuestsManager.ragingVolcano, 1L);
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getTheDireDescent(), 100);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("AmanitaObscura"), Enemy.getInstance("Berserker"), Enemy.getInstance("Terrorsaurus"), Enemy.getInstance("Pterodactyl"), Enemy.getInstance("StoneShaman"), Enemy.getInstance("SmolderingTitan"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("Mithril", 9), 279);
        linkedHashMap.put(Item.getInstance("AncientHide", 9), 279);
        linkedHashMap.put(Item.getInstance("AncientMembrane", 9), 279);
        linkedHashMap.put(Item.getInstance("PoisonousFlesh", 1), 151);
        linkedHashMap.put(Item.getInstance("Kindlequartz", 1), 11);
        linkedHashMap.put(Item.getInstance("Diamond", 1), 1);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("AncientBoots", 1), 100);
        linkedHashMap.put(Item.getInstance("AncientGloves", 1), 100);
        linkedHashMap.put(Item.getInstance("MithrilHelm", 1), 100);
        linkedHashMap.put(Item.getInstance("MithrilShield", 1), 100);
        linkedHashMap.put(Item.getInstance("AncientArmor", 1), 100);
        linkedHashMap.put(Item.getInstance("AncientJacket", 1), 100);
        linkedHashMap.put(Item.getInstance("AncientRobe", 1), 100);
        linkedHashMap.put(Item.getInstance("MithrilSword", 1), 100);
        linkedHashMap.put(Item.getInstance("MithrilBow", 1), 100);
        linkedHashMap.put(Item.getInstance("MithrilDagger", 1), 100);
        return linkedHashMap;
    }
}
