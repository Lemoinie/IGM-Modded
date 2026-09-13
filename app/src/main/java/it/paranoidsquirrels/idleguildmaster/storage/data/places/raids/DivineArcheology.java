package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DivineArcheology extends Area {
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
        return R.string.raid_name_divine_archeology;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_divine_archeology;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_divine_archeology;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().divineArcheology;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.progress < this.maxProgress) {
            return new CopyOnWriteArrayList();
        }
        int i = this.progress;
        if (i == 2) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriWarrior")));
        }
        if (i == 9) {
            return Utils.gotUniqueDrop("EyesOfTheSwordsman", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShaKireFirstSwordsman")));
        }
        if (i == 12) {
            if (this.event == null || this.event.getKey() != 1) {
                return new CopyOnWriteArrayList();
            }
            return Utils.gotUniqueDrop("DivineZygote", this) ? new CopyOnWriteArrayList() : new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("ShaTheHiddenGod")));
        }
        if (i == 4 || i == 5 || i == 6) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("SandDemon"), Enemy.getInstance("SandDemon"), Enemy.getInstance("SandDemon"), Enemy.getInstance("SandDemon"), Enemy.getInstance("SandDemon")));
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
        int iCalculateTotalConstitution = 0;
        switch (str) {
            case "enter_room":
                switch (this.progress) {
                    case 1:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_1));
                        break;
                    case 2:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_2));
                        break;
                    case 3:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_3));
                        break;
                    case 4:
                    case 5:
                    case 6:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_divine_archeology_room_4));
                        break;
                    case 7:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_divine_archeology_room_5));
                        break;
                    case 8:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_6));
                        break;
                    case 9:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_7));
                        break;
                    case 10:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_8));
                        break;
                    case 11:
                        Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_room_9));
                        break;
                    case 12:
                        for (Adventurer adventurer : this.adventurersExploring) {
                            if (adventurer.getCurrentHp() > 0) {
                                iCalculateTotalConstitution += adventurer.calculateTotalConstitution();
                            }
                        }
                        if (iCalculateTotalConstitution >= 200) {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_divine_archeology_room_10b));
                            this.event = new Event(Event.PYRAMID_DOOR_OPEN);
                        } else {
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_divine_archeology_room_10a));
                            this.terminationRequested = true;
                            this.event = null;
                        }
                        break;
                    case 13:
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_divine_archeology_room_11));
                        this.terminationRequested = true;
                        break;
                }
                            case "fight_start":
                int i = this.progress;
                if (i == 2) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_1));
                    break;
                } else if (i == 9) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_5));
                    break;
                } else if (i == 12) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_6));
                    break;
                } else if (i == 4) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_2));
                    break;
                } else if (i == 5) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_3));
                    break;
                } else if (i == 6) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_divine_archeology_encounter_4));
                    break;
                }
                            case "kill_ShaTheHiddenGod":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_DEICIDE);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_divine_archeology_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("ShahuriWarrior"), Enemy.getInstance("ShahuriArcher"), Enemy.getInstance("ShahuriMage"), Enemy.getInstance("SandDemon"), Enemy.getInstance("ShaKireFirstSwordsman"), Enemy.getInstance("ShaTheHiddenGod"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public boolean completed() {
        return this.maxProgress >= 13 && this.drops.isEmpty();
    }
}
