package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SleepingPlanet extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int adventurersNumber() {
        return 14;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int costToRefresh() {
        return 15;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.raid_name_sleeping_planet;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_sleeping_planet;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_sleeping_planet;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().sleepingPlanet;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        int i = this.progress;
        if (i == 5) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtBeast")));
        }
        if (i == 8) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtDragon"), Enemy.getInstance("DreamwroughtBeast")));
        }
        if (i == 10) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtSwarm"), Enemy.getInstance("DreamwroughtBeast")));
        }
        if (i == 12) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtForge"), Enemy.getInstance("DreamwroughtBeast")));
        }
        if (i == 14) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Singularity")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_Singularity":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_UNITY);
                break;
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_12));
                        break;
                    case 13:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_13));
                        break;
                    case 14:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_14));
                        break;
                    case 15:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_room_15));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 5) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_sleeping_planet_encounter_1));
                    break;
                } else if (i == 8) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_sleeping_planet_encounter_2));
                    break;
                } else if (i == 10) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_sleeping_planet_encounter_3));
                    break;
                } else if (i == 12) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_sleeping_planet_encounter_4));
                    break;
                } else if (i == 14) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_sleeping_planet_encounter_5));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_sleeping_planet_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("DreamwroughtBeast"), Enemy.getInstance("DreamwroughtDragon"), Enemy.getInstance("DreamwroughtSwarm"), Enemy.getInstance("DreamwroughtForge"), Enemy.getInstance("Singularity"));
    }
}
