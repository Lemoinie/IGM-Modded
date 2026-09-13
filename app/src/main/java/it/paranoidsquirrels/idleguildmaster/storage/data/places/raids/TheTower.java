package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheTower extends Area {
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
    public int getName() {
        return R.string.raid_name_the_tower;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_tower;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_tower;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theTower;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        int i = this.progress;
        if (i == 8) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Lazarus")));
        }
        if (i == 12) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Phoenix")));
        }
        if (i == 16) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("HeadlessKnight")));
        }
        if (i == 22) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Ultraslime")));
        }
        if (i == 26) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TheExiled")));
        }
        if (i == 31) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TheAncient")));
        }
        if (i == 35) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("TheMachine")));
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
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_9));
                        break;
                    case 10:
                    case 14:
                    case 18:
                    case 24:
                    case 28:
                    case 33:
                        resurrectAndHeal();
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_12));
                        break;
                    case 13:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_13));
                        break;
                    case 15:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_15));
                        break;
                    case 16:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_16));
                        break;
                    case 17:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_17));
                        break;
                    case 19:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_19));
                        break;
                    case 20:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_20));
                        break;
                    case 21:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_21));
                        break;
                    case 22:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_22));
                        break;
                    case 23:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_23));
                        break;
                    case 25:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_25));
                        break;
                    case 26:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_26));
                        break;
                    case 27:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_27));
                        break;
                    case 29:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_29));
                        break;
                    case 30:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_30));
                        break;
                    case 31:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_31));
                        break;
                    case 32:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_32));
                        break;
                    case 34:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_34));
                        break;
                    case 35:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_35));
                        break;
                    case 36:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_36));
                        break;
                    case 37:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_37));
                        break;
                    case 38:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_38));
                        break;
                    case 39:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_room_39));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 8) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_1));
                    break;
                } else if (i == 12) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_2));
                    break;
                } else if (i == 16) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_3));
                    break;
                } else if (i == 22) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_4));
                    break;
                } else if (i == 26) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_5));
                    break;
                } else if (i == 31) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_6));
                    break;
                } else if (i == 35) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_tower_encounter_7));
                    break;
                }
                            case "kill_TheMachine":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_TOWER);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_tower_enter));
                break;
        }
    }

    private void resurrectAndHeal() {
        Adventurer adventurer = null;
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.getCurrentHp() <= 0 && adventurer == null) {
                adventurer = adventurer2;
            }
            if (adventurer2.getCurrentHp() > 0) {
                adventurer2.setCurrentHp(adventurer2.calculateTotalMaxHp());
            }
        }
        if (adventurer != null) {
            adventurer.setCurrentHp(adventurer.calculateTotalMaxHp());
            Logger.log(this, 102, Integer.valueOf(R.string.log_the_tower_event_resurrect));
        }
        Logger.log(this, 102, Integer.valueOf(R.string.log_the_tower_event_heal));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return this.progress == 31 ? 50 : 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Lazarus"), Enemy.getInstance("Phoenix"), Enemy.getInstance("HeadlessKnight"), Enemy.getInstance("Ultraslime"), Enemy.getInstance("TheExiled"), Enemy.getInstance("TheAncient"), Enemy.getInstance("TheMachine"));
    }
}
