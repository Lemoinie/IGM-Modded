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
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TheLostExpedition extends Area {
    private static double PROBABILITY_OF_TRAPDOOR = 0.2d;

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
        return 100;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.raid_name_the_lost_expedition;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_the_lost_expedition;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_the_lost_expedition;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.raidsFragment.getBinding().theLostExpedition;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        if (this.event == null) {
            int i = this.progress;
            if (i == 2) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner")));
            }
            if (i == 4) {
                return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner")));
            }
            if (i != 14) {
                switch (i) {
                    case 8:
                        return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("BleakDisciple"), Enemy.getInstance("EldritchHound"), Enemy.getInstance("BleakDisciple")));
                    case 9:
                        return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EldritchHound"), Enemy.getInstance("EldritchHound"), Enemy.getInstance("BleakDisciple"), Enemy.getInstance("EldritchHound"), Enemy.getInstance("EldritchHound")));
                    case 10:
                        return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("EldritchHound"), Enemy.getInstance("BleakDisciple"), Enemy.getInstance("BleakDeacon"), Enemy.getInstance("BleakDisciple"), Enemy.getInstance("EldritchHound")));
                }
            }
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("BleakDisciple"), Enemy.getInstance("AvatarOfTheAncient"), Enemy.getInstance("BleakDisciple")));
        }
        int progress = this.event.getProgress();
        if (progress == 5) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner")));
        }
        if (progress == 7) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner"), Enemy.getInstance("TekeliLiFirstApostle"), Enemy.getInstance("LostMiner"), Enemy.getInstance("LostMiner")));
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
                if (this.event == null) {
                    switch (this.progress) {
                        case 1:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_1));
                            break;
                        case 2:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_2));
                            break;
                        case 3:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_3));
                            break;
                        case 4:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_4));
                            break;
                        case 5:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_5));
                            break;
                        case 6:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_6));
                            break;
                        case 7:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_7));
                            break;
                        case 8:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_8));
                            break;
                        case 9:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_9));
                            break;
                        case 10:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_10));
                            break;
                        case 11:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_11));
                            if (Utils.random() < PROBABILITY_OF_TRAPDOOR) {
                                this.event = new Event(Event.LOST_EXPEDITION_TRAPDOOR);
                            }
                            break;
                        case 12:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_12));
                            break;
                        case 13:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_13));
                            break;
                        case 14:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_14));
                            break;
                        case 15:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_15));
                            this.terminationRequested = true;
                            break;
                    }
                } else {
                    switch (this.event.getProgress()) {
                        case 1:
                            Logger.log(this, Logger.EVENT_SIGNIFICANT, Integer.valueOf(R.string.log_the_lost_expedition_room_12a));
                            int barrier = this.petExploring != null ? this.petExploring.getBarrier() : 0;
                            for (Adventurer adventurer : this.adventurersExploring) {
                                if (adventurer.getCurrentHp() > 0) {
                                    int iApplyDamage = adventurer.applyDamage(40.0d, false, barrier, 0.0d);
                                    refreshDialog();
                                    Logger.log(this, Logger.LOST_EXPEDITION_FALL_DAMAGE, adventurer, Integer.valueOf(iApplyDamage));
                                }
                            }
                            break;
                        case 2:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_13a));
                            break;
                        case 3:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_14a));
                            break;
                        case 4:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_15a));
                            break;
                        case 5:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_16a));
                            break;
                        case 6:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_17a));
                            break;
                        case 7:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_18a));
                            break;
                        case 8:
                            Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_room_19a));
                            this.terminationRequested = true;
                            break;
                    }
                    this.event.setProgress(Math.min(8, this.event.getProgress() + 1));
                    break;
                }
                            case "kill_AvatarOfTheAncient":
                QuestsManager.increment(QuestsManager.eldritchHorror, 1L);
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_COSMIC_HORROR);
                break;
            case "fight_start":
                if (this.event == null) {
                    int i = this.progress;
                    if (i == 2) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_1));
                        break;
                    } else if (i == 4) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_2));
                        break;
                    } else if (i != 14) {
                        switch (i) {
                            case 8:
                                Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_3));
                                break;
                            case 9:
                                Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_4));
                                break;
                            case 10:
                                Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_5));
                                break;
                        }
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_6));
                        break;
                    }
                } else {
                    int progress = this.event.getProgress();
                    if (progress == 5) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_6a));
                        break;
                    } else if (progress == 7) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_the_lost_expedition_encounter_7a));
                        break;
                    }
                }
                break;
            case "kill_TekeliLiFirstApostle":
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_APOSTLE);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_the_lost_expedition_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        return new LinkedHashMap<>();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("LostMiner"), Enemy.getInstance("BleakDisciple"), Enemy.getInstance("EldritchHound"), Enemy.getInstance("BleakDeacon"), Enemy.getInstance("TekeliLiFirstApostle"), Enemy.getInstance("AvatarOfTheAncient"));
    }
}
