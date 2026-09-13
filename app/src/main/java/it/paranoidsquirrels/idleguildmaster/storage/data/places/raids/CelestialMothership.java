package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Gcss;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialMothership extends Area {
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
        return R.string.raid_name_celestial_mothership;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_celestial_mothership;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_celestial_mothership;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().celestialMothership;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.progress < this.maxProgress) {
            return new CopyOnWriteArrayList();
        }
        int i = this.progress;
        if (i == 2) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus")));
        }
        if (i == 3) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("Oculus")));
        }
        if (i == 4 || i == 5 || i == 6) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer")));
        }
        if (i == 8) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer")));
        }
        if (i == 9) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialDestroyer")));
        }
        if (i == 12 || i == 15) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Gcss"), Enemy.getInstance("ReinforcedDoor"), Enemy.getInstance("Gcss")));
        }
        if (i != 17) {
            return new CopyOnWriteArrayList();
        }
        return Utils.gotUniqueDrop("Evo23Vial", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LegateHadrian")));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_ReinforcedDoor":
                for (Enemy enemy : this.enemies) {
                    if (enemy instanceof Gcss) {
                        enemy.setCurrentHp(0);
                        checkDeath(enemy);
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_celestial_mothership_event_1));
                    }
                }
                break;
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_12));
                        break;
                    case 13:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_13));
                        break;
                    case 14:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_14));
                        break;
                    case 15:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_15));
                        break;
                    case 16:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_16));
                        break;
                    case 17:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_17));
                        break;
                    case 18:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_room_18));
                        break;
                    case 19:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_celestial_mothership_room_19));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 2) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_1));
                    break;
                } else if (i == 3) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_2));
                    break;
                } else if (i == 4) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_3));
                    break;
                } else if (i == 5) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_4));
                    break;
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_5));
                    break;
                } else if (i == 8) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_6));
                    break;
                } else if (i == 9) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_7));
                    break;
                } else if (i == 12) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_8));
                    break;
                } else if (i == 15) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_9));
                    break;
                } else if (i == 17) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_celestial_mothership_encounter_10));
                    break;
                }
                            case "kill_LegateHadrian":
                MainActivity.data.getSeenEnemies().add("Gcss");
                MainActivity.data.getSeenEnemies().add("ReinforcedDoor");
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_INFILTRATOR);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_celestial_mothership_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Oculus"), Enemy.getInstance("CelestialLancer"), Enemy.getInstance("CelestialDestroyer"), Enemy.getInstance("Gcss"), Enemy.getInstance("ReinforcedDoor"), Enemy.getInstance("LegateHadrian"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public boolean completed() {
        return this.maxProgress >= 18 && this.drops.isEmpty();
    }
}
