package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ImperialRescue extends Area {
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
        return R.string.raid_name_imperial_rescue;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_imperial_rescue;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_imperial_rescue;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().imperialRescue;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.progress < this.maxProgress) {
            return new CopyOnWriteArrayList();
        }
        int i = this.progress;
        if (i == 1) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneCitizen")));
        }
        if (i == 2) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen")));
        }
        if (i == 3) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("CityWarden"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("CityWarden")));
        }
        if (i == 6) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard")));
        }
        if (i == 7) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialGuard")));
        }
        if (i == 9) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("InsaneCitizen")));
        }
        if (i == 11) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("ImperialGuard")));
        }
        if (i != 14) {
            return new CopyOnWriteArrayList();
        }
        return Utils.gotUniqueDrop("SkeletonKey", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EmperorClovisXXVIII")));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_12));
                        break;
                    case 13:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_13));
                        break;
                    case 14:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_room_14));
                        break;
                    case 15:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_imperial_rescue_room_15));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 1) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_1));
                } else if (i == 2) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_2));
                } else if (i == 3) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_3));
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_4));
                } else if (i == 7) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_5));
                } else if (i == 9) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_6));
                } else if (i == 11) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_7));
                } else if (i == 14) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_imperial_rescue_encounter_8));
                }
                for (Enemy enemy : this.enemies) {
                    applyStatus(enemy, new StatusEffect(StatusEffectType.DELIRIUM, enemy, 999, 1.0d), 0.0d);
                }
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_imperial_rescue_enter));
                break;
            case "kill_EmperorClovisXXVIII":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RESCUE_TEAM);
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("InsaneCitizen"), Enemy.getInstance("InsaneMerchant"), Enemy.getInstance("CityWarden"), Enemy.getInstance("ImperialGuard"), Enemy.getInstance("ImperialMage"), Enemy.getInstance("EmperorClovisXXVIII"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public boolean completed() {
        return this.maxProgress >= 15 && this.drops.isEmpty();
    }
}
