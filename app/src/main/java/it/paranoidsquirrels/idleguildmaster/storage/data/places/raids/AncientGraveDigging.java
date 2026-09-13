package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Necrolith;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AncientGraveDigging extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int adventurersNumber() {
        return 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.raid_name_ancient_grave_digging;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_ancient_grave_digging;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_ancient_grave_digging;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().ancientGraveDigging;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        int i = this.progress;
        if (i == 3) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Undead"), Enemy.getInstance("Undead")));
        }
        if (i == 4) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Abomination"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Undead")));
        }
        if (i == 6) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadArcher"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadGeneral"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadArcher")));
        }
        if (i == 11) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Necrolith"), Enemy.getInstance("KabarTheRotten"), Enemy.getInstance("Necrolith")));
        }
        if (i == 8) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("DeathHound")));
        }
        if (i == 9) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadGeneral"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("UndeadWarlord")));
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
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_3));
                        break;
                    case 4:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_4));
                        break;
                    case 5:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_5));
                        break;
                    case 6:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_6));
                        break;
                    case 7:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_7));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_8));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_9));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_10));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_11));
                        break;
                    case 12:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_room_12));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 3) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_1));
                    break;
                } else if (i == 4) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_2));
                    break;
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_3));
                    break;
                } else if (i == 11) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_6));
                    break;
                } else if (i == 8) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_4));
                    break;
                } else if (i == 9) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_ancient_grave_digging_encounter_5));
                    break;
                }
                            case "kill_KabarTheRotten":
                for (Enemy enemy : this.enemies) {
                    if (enemy instanceof Necrolith) {
                        enemy.setCurrentHp(0);
                        checkDeath(enemy);
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_ancient_grave_digging_event_1));
                    }
                }
                QuestsManager.increment(QuestsManager.andStayDead, 1L);
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_NECROMANCER);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_ancient_grave_digging_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return this.progress + 25;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Undead"), Enemy.getInstance("UndeadArcher"), Enemy.getInstance("DeathHound"), Enemy.getInstance("UndeadWarlord"), Enemy.getInstance("Abomination"), Enemy.getInstance("UndeadGeneral"), Enemy.getInstance("KabarTheRotten"), Enemy.getInstance("Necrolith"));
    }
}
