package it.paranoidsquirrels.idleguildmaster.storage.data.places.raids;

import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SkeletonKey;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheCultistRebels extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int adventurersNumber() {
        return 8;
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
        return R.string.raid_name_the_cultist_rebels;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_cultist_rebels;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_cultist_rebels;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theCultistRebels;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.event == null) {
            return new CopyOnWriteArrayList();
        }
        if (this.event.getKey() == 1 && (this.event.getProgress() == 1 || this.event.getProgress() == 2 || this.event.getProgress() == 3 || this.event.getProgress() == 6 || this.event.getProgress() == 7 || this.event.getProgress() == 8 || this.event.getProgress() == 11 || this.event.getProgress() == 12 || this.event.getProgress() == 13)) {
            double dRandom = Utils.random();
            if (dRandom < 0.4d) {
                return new CopyOnWriteArrayList();
            }
            if (dRandom < 0.75d) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LesserTitan")));
            }
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Crusader"), Enemy.getInstance("Crusader"), Enemy.getInstance("Crusader"), Enemy.getInstance("Crusader"), Enemy.getInstance("Crusader")));
        }
        if (this.event.getKey() == 1 && this.event.getProgress() == 14) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Claris"), Enemy.getInstance("Thorvus")));
        }
        return (this.event.getKey() == 2 && this.event.getProgress() == 2) ? new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("PrimordialTitan"))) : new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        Logger.log(this, 41, new Object[0]);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        int i;
        int i2;
        str.hashCode();
        switch (str) {
            case "kill_Thorvus":
            case "kill_Claris":
                if (this.enemies.size() == 0) {
                    QuestsManager.increment(QuestsManager.botchedRitual, 1L);
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_CULTISTS);
                    break;
                }
                            case "enter_room":
                int i3 = this.progress;
                if (i3 == 1) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_1));
                    break;
                } else if (i3 == 2) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_2));
                    break;
                } else if (i3 == 3) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_3));
                    break;
                } else if (i3 == 4) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_4));
                    break;
                } else if (i3 == 5) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_5));
                    this.event = new Event(Event.HALLS_EXPLORATION);
                    break;
                } else if (this.event == null) {
                    this.terminationRequested = true;
                    break;
                } else if (this.event.getKey() == 1) {
                    int progress = this.event.getProgress();
                    if (progress == 3) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_7));
                        this.event.setProgress(this.event.getProgress() + 1);
                    } else if (progress == 4) {
                        double dRandom = Utils.random();
                        if (dRandom <= 0.2d) {
                            i = R.string.log_the_cultist_rebels_room_7a;
                        } else if (dRandom <= 0.4d) {
                            i = R.string.log_the_cultist_rebels_room_7b;
                        } else if (dRandom <= 0.6d) {
                            i = R.string.log_the_cultist_rebels_room_7c;
                        } else if (dRandom <= 0.8d) {
                            i = R.string.log_the_cultist_rebels_room_7d;
                        } else {
                            i = R.string.log_the_cultist_rebels_room_7e;
                        }
                        Logger.log(this, 100, Integer.valueOf(i));
                        this.event.setProgress(this.event.getProgress() + 1);
                    } else if (progress == 8) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_8));
                        this.event.setProgress(this.event.getProgress() + 1);
                        Iterator<Adventurer> it2 = this.adventurersExploring.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().getAccessory() instanceof SkeletonKey) {
                                this.event = new Event(Event.HALLS_SKELETON_DOOR);
                                break;
                            }
                        }
                    } else if (progress == 9) {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_cultist_rebels_room_9));
                        this.event.setProgress(this.event.getProgress() + 1);
                    } else if (progress == 13) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_10));
                        this.event.setProgress(this.event.getProgress() + 1);
                    } else if (progress == 14) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_11));
                        this.event.setProgress(this.event.getProgress() + 1);
                        this.terminationRequested = true;
                    } else {
                        double dRandom2 = Utils.random();
                        if (dRandom2 <= 0.333d) {
                            i2 = R.string.log_the_cultist_rebels_room_6a;
                        } else if (dRandom2 <= 0.666d) {
                            i2 = R.string.log_the_cultist_rebels_room_6b;
                        } else {
                            i2 = R.string.log_the_cultist_rebels_room_6c;
                        }
                        Logger.log(this, 100, Integer.valueOf(i2));
                        if (Utils.random() < 0.5d) {
                            this.event.setProgress(this.event.getProgress() + 1);
                        }
                    }
                    break;
                } else if (this.event.getKey() == 2) {
                    int progress2 = this.event.getProgress();
                    if (progress2 == 0) {
                        Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_cultist_rebels_room_9a));
                        this.event.setProgress(this.event.getProgress() + 1);
                        break;
                    } else if (progress2 == 1) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_10a));
                        this.event.setProgress(this.event.getProgress() + 1);
                        break;
                    } else if (progress2 == 2) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_room_11));
                        this.event.setProgress(this.event.getProgress() + 1);
                        this.terminationRequested = true;
                        break;
                    }
                }
                break;
            case "fight_start":
                if (this.event != null) {
                    if (this.event.getKey() == 1 && this.event.getProgress() == 14) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_cultist_rebels_encounter_3));
                    } else if (this.event.getKey() == 2 && this.event.getProgress() == 2) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_cultist_rebels_encounter_4));
                    } else if (this.enemies.size() != 1) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_cultist_rebels_encounter_2));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_cultist_rebels_encounter_1));
                    }
                    break;
                }
                            case "kill_PrimordialTitan":
                QuestsManager.increment(QuestsManager.endlessAgony, 1L);
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_AGONIZING_TITAN);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_cultist_rebels_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Crusader"), Enemy.getInstance("LesserTitan"), Enemy.getInstance("Claris"), Enemy.getInstance("Thorvus"), Enemy.getInstance("PrimordialTitan"));
    }
}
