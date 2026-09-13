package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheSlimePond extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int adventurersNumber() {
        return 5;
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
        return R.string.raid_name_the_slime_pond;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_slime_pond;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_slime_pond;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theSlimePond;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        int i = this.progress;
        if (i != 2 && i != 3 && i != 4) {
            if (i == 6) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SlimeKing")));
            }
            return new CopyOnWriteArrayList();
        }
        int i2 = this.progress + 1;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            double dRandom = Utils.random();
            if (dRandom < 0.695d) {
                copyOnWriteArrayList.add(Enemy.getInstance("Slime"));
            } else if (dRandom < 0.795d) {
                copyOnWriteArrayList.add(Enemy.getInstance("FireSlime"));
            } else if (dRandom < 0.895d) {
                copyOnWriteArrayList.add(Enemy.getInstance("ElectricSlime"));
            } else if (dRandom < 0.995d) {
                copyOnWriteArrayList.add(Enemy.getInstance("FrozenSlime"));
            } else {
                copyOnWriteArrayList.add(Enemy.getInstance("VoidSlime"));
            }
        }
        return copyOnWriteArrayList;
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
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_room_7));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 2) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_slime_pond_encounter_1));
                    break;
                } else if (i == 3) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_slime_pond_encounter_2));
                    break;
                } else if (i == 4) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_slime_pond_encounter_3));
                    break;
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_slime_pond_encounter_4));
                    break;
                }
                            case "kill_SlimeKing":
                QuestsManager.increment(QuestsManager.regicide, 1L);
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ROYAL_PUDDING);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_slime_pond_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Slime"), Enemy.getInstance("FireSlime"), Enemy.getInstance("ElectricSlime"), Enemy.getInstance("FrozenSlime"), Enemy.getInstance("VoidSlime"), Enemy.getInstance("SlimeKing"));
    }
}
