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
public class TheDireDescent extends Area {
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
        return R.string.raid_name_the_dire_descent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_dire_descent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_dire_descent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theDireDescent;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.progress < this.maxProgress) {
            return new CopyOnWriteArrayList();
        }
        if (this.progress != 5) {
            return new CopyOnWriteArrayList();
        }
        return Utils.gotUniqueDrop("SerpentLunge", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("HeraldXavi"), Enemy.getInstance("HeraldMaya"), Enemy.getInstance("HeraldShoran")));
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
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_6));
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_CORE);
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_room_8));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                if (this.progress == 5) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_the_dire_descent_encounter_1));
                    break;
                }
                            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_dire_descent_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getSleepingPlanet(), 7);
        linkedHashMap.put(MainActivity.data.getKaunis(), 7);
        linkedHashMap.put(MainActivity.data.getTheTower(), 7);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("HeraldXavi"), Enemy.getInstance("HeraldMaya"), Enemy.getInstance("HeraldShoran"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public boolean completed() {
        return this.maxProgress >= 7 && this.drops.isEmpty();
    }
}
