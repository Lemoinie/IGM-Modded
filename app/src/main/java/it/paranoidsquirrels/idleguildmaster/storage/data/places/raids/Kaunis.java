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
public class Kaunis extends Area {
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
        return 18;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.raid_name_kaunis;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_kaunis;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_kaunis;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().kaunis;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        int i = this.progress;
        if (i == 1) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot")));
        }
        if (i == 6) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot"), Enemy.getInstance("Enforcer"), Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot")));
        }
        if (i != 16) {
            switch (i) {
                case 9:
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Phantasm")));
                case 10:
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Enforcer"), Enemy.getInstance("Enforcer"), Enemy.getInstance("Necrobot")));
                case 11:
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot"), Enemy.getInstance("Cerebrum"), Enemy.getInstance("Necrobot"), Enemy.getInstance("Necrobot")));
                case 12:
                    return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Phantasm"), Enemy.getInstance("Necrobot")));
                default:
                    return new CopyOnWriteArrayList();
            }
        }
        return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ChiefScientistAva"), Enemy.getInstance("KingAino"), Enemy.getInstance("FirstMinisterAtos")));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "kill_KingAino":
            case "kill_ChiefScientistAva":
            case "kill_FirstMinisterAtos":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_COUNCIL);
                break;
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_12));
                        break;
                    case 13:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_13));
                        break;
                    case 14:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_14));
                        break;
                    case 15:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_15));
                        break;
                    case 16:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_16));
                        break;
                    case 17:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_room_17));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 1) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_1));
                    break;
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_2));
                    break;
                } else if (i != 16) {
                    switch (i) {
                        case 9:
                            Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_3));
                            break;
                        case 10:
                            Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_4));
                            break;
                        case 11:
                            Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_5));
                            break;
                        case 12:
                            Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_6));
                            break;
                    }
                } else {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_kaunis_encounter_7));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_kaunis_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Necrobot"), Enemy.getInstance("Enforcer"), Enemy.getInstance("Phantasm"), Enemy.getInstance("Cerebrum"), Enemy.getInstance("ChiefScientistAva"), Enemy.getInstance("KingAino"), Enemy.getInstance("FirstMinisterAtos"));
    }
}
