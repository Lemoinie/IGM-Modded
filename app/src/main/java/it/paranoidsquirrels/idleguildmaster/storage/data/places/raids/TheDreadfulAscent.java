package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheDreadfulAscent extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int adventurersNumber() {
        return 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 2;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.raid_name_the_dreadful_ascent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_dreadful_ascent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_dreadful_ascent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theDreadfulAscent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.progress < this.maxProgress) {
            return new CopyOnWriteArrayList();
        }
        int i = this.progress;
        if (i == 2) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul")));
        }
        if (i == 3) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul")));
        }
        if (i == 4 || i == 5 || i == 8) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul"), Enemy.getInstance("EtherealSoul")));
        }
        if (i == 10) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("KasimirTheSeer")));
        }
        if (i != 11) {
            return new CopyOnWriteArrayList();
        }
        return Utils.gotUniqueDrop("SerpentStaff", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("HeraldKali")));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_HeraldKali":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_SEER);
                break;
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_room_12));
                        break;
                    case 13:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_dreadful_ascent_room_13));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 2) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_1));
                    break;
                } else if (i == 3) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_2));
                    break;
                } else if (i == 4) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_3));
                    break;
                } else if (i == 5) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_4));
                    break;
                } else if (i == 8) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_5));
                    break;
                } else if (i == 10) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dreadful_ascent_encounter_6));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_dreadful_ascent_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getTheSouthernGrove(), 13);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("EtherealSoul"), Enemy.getInstance("KasimirTheSeer"), Enemy.getInstance("HeraldKali"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public boolean completed() {
        return this.maxProgress >= 13 && this.drops.isEmpty();
    }
}
