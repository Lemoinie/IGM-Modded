package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import android.content.res.Resources;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    public static final int ABILITY_CASTED = 29;
    public static final int ADVENTURER_SLAIN = 38;
    public static final int AMULET_OF_RESURRECTION = 119;
    public static final int ARCANE_SUPPRESSION = 116;
    public static final int BARD_SHIELD = 120;
    public static final int BOTCHED_OFFERING = 115;
    private static final String COLOR_FORMAT = "<font color=%s><strong>%s</strong></font>";
    public static final int DARKNESS_DESCRIPTION = 1;
    public static final int DEAL_DAMAGE = 33;
    public static final int DECAY = 20;
    public static final int DODGE_BASIC_ATTACK = 21;
    public static final int DODGE_FLYING = 45;
    public static final int DODGE_GENERIC = 22;
    public static final int DROP = 8;
    public static final int DUNGEON_UNLOCKED = 56;
    public static final int ENEMY_SLAIN = 36;
    public static final int ESCAPE = 43;
    public static final int EVENT = 100;
    public static final int EVENT_BENEFICIAL = 102;
    public static final int EVENT_EYE_DRAW = 48;
    public static final int EVENT_HARMFUL = 101;
    public static final int EVENT_MAGIC_AMPLIFICATION = 109;
    public static final int EVENT_SHAHURI = 44;
    public static final int EVENT_SIGNIFICANT = 103;
    public static final int EVENT_WILL_O_WISP = 47;
    public static final int EVENT_WURM_APPROACHING = 104;
    public static final int EXECUTION = 34;
    public static final int EXP_GAIN = 6;
    public static final int FLEE = 3;
    public static final int FROSTBITE_PEAKS_CRATE_FAILURE = 52;
    public static final int FROSTBITE_PEAKS_CRATE_FOUND = 51;
    public static final int FROSTBITE_PEAKS_CRATE_SUCCESS = 53;
    private static final String GREEN = "#3CC83C";
    public static final int HEAL = 24;
    public static final int HEALING_NOVA = 117;
    public static final int ITEM_FOUND = 40;
    public static final int LEVEL_UP = 7;
    public static final int LIFE_STEAL = 35;
    public static final int LOG_PET_DAMAGE = 105;
    public static final int LOG_PET_HEAL = 106;
    public static final int LOST_EXPEDITION_FALL_DAMAGE = 112;
    public static final int MINION_REANIMATED = 39;
    public static final int MINION_SLAIN = 37;
    public static final int NOTHING_FOUND = 41;
    private static final String NO_COLOR_FORMAT = "<strong>%s</strong>";
    public static final int NO_DROPS = 9;
    private static final String ORANGE = "#C86400";
    public static final int PARRY_BASIC_ATTACK = 31;
    public static final int PARRY_GENERIC = 32;
    public static final int PET_DECOY = 107;
    public static final int PET_EXECUTION = 108;
    public static final int PROGRESS = 55;
    private static final String RED = "#C84646";
    private static final String RED_COLORBLIND = "#FFC8C8";
    public static final int REGENERATION = 49;
    private static Resources RESOURCES = null;
    public static final int RESPAWN = 4;
    public static final int RETALIATION_DAMAGE = 46;
    public static final int REVIVE = 30;
    public static final int RITUAL_SUMMON_SMOLDERING_TITAN = 113;
    public static final int STATUS_APPLIED = 11;
    public static final int STATUS_APPLIED_FOREVER = 12;
    public static final int STATUS_BLEED = 19;
    public static final int STATUS_CLEARED = 10;
    public static final int STATUS_FEEBLE_TETHER = 110;
    public static final int STATUS_FROZEN = 50;
    public static final int STATUS_ON_FIRE = 17;
    public static final int STATUS_PETRIFIED = 111;
    public static final int STATUS_POISONED = 14;
    public static final int STATUS_REGENERATING = 18;
    public static final int STATUS_SILENCED = 16;
    public static final int STATUS_STUNNED = 15;
    public static final int STATUS_TAUNTED = 13;
    public static final int STATUS_TERRIFIED = 118;
    public static final int SUMMON_SMOLDERING_TITAN = 114;
    public static final int TEAM_DEAD = 2;
    public static final int TRAP_AVOIDED = 26;
    public static final int TRAP_DESCRIPTION = 25;
    public static final int TRAP_DISARMED = 28;
    public static final int TRAP_NOT_AVOIDED = 27;
    public static final int VICTORY = 5;
    private static final String YELLOW = "#C8C800";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:245:0x0bb3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:247:0x0bb6  */
    /* JADX WARN: Code duplicated, block: B:249:0x0bdc  */
    /* JADX WARN: Code duplicated, block: B:250:0x0be1  */
    /* JADX WARN: Code duplicated, block: B:253:0x0bfa  */
    /* JADX WARN: Code duplicated, block: B:254:0x0bff  */
    /* JADX WARN: Code duplicated, block: B:257:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:259:0x0c2a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:261:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:263:0x0c4b  */
    /* JADX WARN: Code duplicated, block: B:264:0x0c50  */
    /* JADX WARN: Code duplicated, block: B:267:0x0c69  */
    /* JADX WARN: Code duplicated, block: B:268:0x0c6e  */
    /* JADX WARN: Code duplicated, block: B:271:0x0c7f  */
    public static void log(Area area, int i, Object... objArr) {
        DialogDungeonDetail dialogDungeonDetail;
        String strWrap;
        int iIntValue;
        Entity entity;
        StatusEffect statusEffect;
        String red;
        String red2;
        Entity entity2;
        StatusEffect statusEffect2;
        String red3;
        String red4;
        if (Utils.isMainLooper() && (dialogDungeonDetail = MainActivity.shownDialogDungeonDetail) != null && dialogDungeonDetail.area == area) {
            if (RESOURCES == null) {
                if (MainActivity.dungeonsFragment == null || MainActivity.dungeonsFragment.getContext() == null) {
                    return;
                } else {
                    RESOURCES = MainActivity.dungeonsFragment.getResources();
                }
            }
            boolean zIsSettingVerboseLogs = MainActivity.data.isSettingVerboseLogs();
            boolean z = true;
            if (i == 55) {
                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_progress), RESOURCES.getString(((Integer) objArr[0]).intValue()), Integer.valueOf(((Integer) objArr[1]).intValue()), Integer.valueOf(((Integer) objArr[2]).intValue())), YELLOW);
            } else if (i == 56) {
                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_dungeon_unlocked), RESOURCES.getString(((Integer) objArr[0]).intValue())), YELLOW);
            } else {
                strWrap = null;
                String red5 = GREEN;
                switch (i) {
                    case 1:
                        if (zIsSettingVerboseLogs && (iIntValue = ((Integer) objArr[0]).intValue()) != 0) {
                            strWrap = UIUtils.darknessDescription(iIntValue, RESOURCES);
                        }
                        break;
                    case 2:
                        strWrap = wrap(RESOURCES.getString(R.string.log_defeat), getRed());
                        break;
                    case 3:
                        strWrap = RESOURCES.getString(R.string.log_flee);
                        break;
                    case 4:
                        strWrap = RESOURCES.getString(R.string.log_respawn);
                        break;
                    case 5:
                        strWrap = wrap(RESOURCES.getString(R.string.log_victory), GREEN);
                        break;
                    case 6:
                        strWrap = String.format(RESOURCES.getString(R.string.log_exp_gain), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN), wrap(((Integer) objArr[1]).intValue(), ORANGE));
                        break;
                    case 7:
                        strWrap = wrap(String.format(RESOURCES.getString(R.string.log_level_gain), RESOURCES.getString(((Integer) objArr[0]).intValue())), ORANGE);
                        break;
                    case 8:
                        strWrap = String.format(RESOURCES.getString(R.string.log_loot_item), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), getRed()), wrap(((Integer) objArr[1]).intValue(), ORANGE), wrap(RESOURCES.getString(((Integer) objArr[2]).intValue()), ORANGE));
                        break;
                    case 9:
                        strWrap = RESOURCES.getString(R.string.log_no_drops);
                        break;
                    case 10:
                        if (zIsSettingVerboseLogs) {
                            Entity entity3 = (Entity) objArr[0];
                            StatusEffectType statusEffectType = (StatusEffectType) objArr[1];
                            String string = RESOURCES.getString(R.string.status_effect_log_end);
                            String strWrap2 = wrap(RESOURCES.getString(entity3.getIdName()), entity3 instanceof Enemy ? getRed() : GREEN);
                            String string2 = RESOURCES.getString(statusEffectType.logDescription);
                            if (statusEffectType.negative) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string, strWrap2, wrap(string2, red5));
                            break;
                        }
                                            case 11:
                        if (zIsSettingVerboseLogs) {
                            boolean zEquals = "ko".equals(RESOURCES.getString(R.string.language_code));
                            Entity entity4 = (Entity) objArr[0];
                            StatusEffectType statusEffectType2 = (StatusEffectType) objArr[1];
                            int iIntValue2 = ((Integer) objArr[2]).intValue();
                            String strWrap3 = wrap(RESOURCES.getString(statusEffectType2.logDescription), statusEffectType2.negative ? getRed() : GREEN);
                            String strWrap4 = wrap(iIntValue2, statusEffectType2.negative ? getRed() : GREEN);
                            String string3 = RESOURCES.getString(R.string.log_effect);
                            String string4 = RESOURCES.getString(entity4.getIdName());
                            if (entity4 instanceof Enemy) {
                                red5 = getRed();
                            }
                            String strWrap5 = wrap(string4, red5);
                            String str = zEquals ? strWrap4 : strWrap3;
                            if (!zEquals) {
                                strWrap3 = strWrap4;
                            }
                            strWrap = String.format(string3, strWrap5, str, strWrap3);
                            break;
                        }
                                            case 12:
                        if (zIsSettingVerboseLogs) {
                            Entity entity5 = (Entity) objArr[0];
                            StatusEffectType statusEffectType3 = (StatusEffectType) objArr[1];
                            String string5 = RESOURCES.getString(R.string.status_effect_log_simple_omit_turns);
                            String strWrap6 = wrap(RESOURCES.getString(entity5.getIdName()), entity5 instanceof Enemy ? getRed() : GREEN);
                            String string6 = RESOURCES.getString(statusEffectType3.logDescription);
                            if (statusEffectType3.negative) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string5, strWrap6, wrap(string6, red5));
                            break;
                        }
                                            case 13:
                        if (zIsSettingVerboseLogs) {
                            boolean zEquals2 = "ko".equals(RESOURCES.getString(R.string.language_code));
                            Entity entity6 = (Entity) objArr[0];
                            StatusEffect statusEffect3 = (StatusEffect) objArr[1];
                            String strWrap7 = wrap(RESOURCES.getString(statusEffect3.getType().logDescription), statusEffect3.getType().negative ? getRed() : GREEN);
                            String strWrap8 = wrap(RESOURCES.getString(statusEffect3.getCause().getIdName()), statusEffect3.getCause() instanceof Enemy ? getRed() : GREEN);
                            String string7 = RESOURCES.getString(R.string.status_effect_log_cause);
                            String strWrap9 = wrap(RESOURCES.getString(entity6.getIdName()), entity6 instanceof Enemy ? getRed() : GREEN);
                            String str2 = zEquals2 ? strWrap8 : strWrap7;
                            if (!zEquals2) {
                                strWrap7 = strWrap8;
                            }
                            int turnsLeft = statusEffect3.getTurnsLeft();
                            if (statusEffect3.getType().negative) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string7, strWrap9, str2, strWrap7, wrap(turnsLeft, red5));
                            break;
                        }
                                            case 14:
                    case 15:
                    case 16:
                    case 18:
                        if (!zIsSettingVerboseLogs) {
                            entity = (Entity) objArr[0];
                            statusEffect = (StatusEffect) objArr[1];
                            String string8 = RESOURCES.getString(R.string.status_effect_log_simple);
                            String string9 = RESOURCES.getString(entity.getIdName());
                            if (entity instanceof Enemy) {
                                red = getRed();
                            } else {
                                red = GREEN;
                            }
                            String strWrap10 = wrap(string9, red);
                            String string10 = RESOURCES.getString(statusEffect.getType().logDescription);
                            if (statusEffect.getType().negative) {
                                red2 = getRed();
                            } else {
                                red2 = GREEN;
                            }
                            String strWrap11 = wrap(string10, red2);
                            int turnsLeft2 = statusEffect.getTurnsLeft();
                            if (statusEffect.getType().negative) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string8, strWrap10, strWrap11, wrap(turnsLeft2, red5));
                            break;
                        }
                                            case 17:
                    case 19:
                        if (zIsSettingVerboseLogs) {
                            entity2 = (Entity) objArr[0];
                            statusEffect2 = (StatusEffect) objArr[1];
                            int iIntValue3 = ((Integer) objArr[2]).intValue();
                            String string11 = RESOURCES.getString(R.string.status_effect_log_damage);
                            String string12 = RESOURCES.getString(entity2.getIdName());
                            if (entity2 instanceof Enemy) {
                                red3 = getRed();
                            } else {
                                red3 = GREEN;
                            }
                            String strWrap12 = wrap(string12, red3);
                            String string13 = RESOURCES.getString(statusEffect2.getType().logDescription);
                            if (statusEffect2.getType().negative) {
                                red4 = getRed();
                            } else {
                                red4 = GREEN;
                            }
                            String strWrap13 = wrap(string13, red4);
                            String strWrap14 = wrap(iIntValue3, getRed());
                            int turnsLeft3 = statusEffect2.getTurnsLeft();
                            if (statusEffect2.getType().negative) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string11, strWrap12, strWrap13, strWrap14, wrap(turnsLeft3, red5));
                            break;
                        }
                                            case 20:
                        if (zIsSettingVerboseLogs) {
                            Entity entity7 = (Entity) objArr[0];
                            int iIntValue4 = ((Integer) objArr[1]).intValue();
                            String string14 = RESOURCES.getString(R.string.log_decay);
                            String string15 = RESOURCES.getString(entity7.getIdName());
                            if (entity7 instanceof Enemy) {
                                red5 = getRed();
                            }
                            strWrap = String.format(string14, wrap(string15, red5), wrap(iIntValue4, getRed()));
                            break;
                        }
                                            case 21:
                        Entity entity8 = (Entity) objArr[0];
                        Entity entity9 = (Entity) objArr[1];
                        int iIntValue5 = ((Integer) objArr[2]).intValue();
                        String string16 = RESOURCES.getString(R.string.log_dodge_attack);
                        String strWrap15 = wrap(RESOURCES.getString(entity8.getIdName()), entity8 instanceof Enemy ? getRed() : GREEN);
                        String string17 = RESOURCES.getString(entity9.getIdName());
                        if (entity9 instanceof Enemy) {
                            red5 = getRed();
                        }
                        strWrap = String.format(string16, strWrap15, wrap(string17, red5), wrap(iIntValue5, (String) null));
                        break;
                    case 22:
                        Entity entity10 = (Entity) objArr[0];
                        int iIntValue6 = ((Integer) objArr[1]).intValue();
                        String string18 = RESOURCES.getString(R.string.log_dodge_skill);
                        String string19 = RESOURCES.getString(entity10.getIdName());
                        if (entity10 instanceof Enemy) {
                            red5 = getRed();
                        }
                        strWrap = String.format(string18, wrap(string19, red5), wrap(iIntValue6, (String) null));
                        break;
                    default:
                        switch (i) {
                            case 24:
                                int iIntValue7 = ((Integer) objArr[0]).intValue();
                                Entity entity11 = (Entity) objArr[1];
                                Entity entity12 = (Entity) objArr[2];
                                int iIntValue8 = ((Integer) objArr[3]).intValue();
                                boolean z2 = Boolean.parseBoolean(RESOURCES.getString(R.string.swap_amount_and_target_in_logs));
                                String strWrap16 = wrap(RESOURCES.getString(entity11.getIdName()), entity11 instanceof Enemy ? getRed() : GREEN);
                                String strWrap17 = wrap(iIntValue8, GREEN);
                                String string20 = RESOURCES.getString(entity12.getIdName());
                                if (entity12 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                String strWrap18 = wrap(string20, red5);
                                String string21 = RESOURCES.getString(R.string.log_healing);
                                String str3 = z2 ? strWrap18 : strWrap17;
                                if (!z2) {
                                    strWrap17 = strWrap18;
                                }
                                String str4 = String.format(string21, strWrap16, str3, strWrap17);
                                if (iIntValue7 == 1) {
                                    str4 = str4 + " " + wrap(RESOURCES.getString(R.string.log_critical_hit), (String) null);
                                }
                                strWrap = iIntValue7 != 2 ? str4 : str4 + " " + wrap(RESOURCES.getString(R.string.log_devastating_hit), (String) null);
                                break;
                            case 25:
                                strWrap = String.format(RESOURCES.getString(R.string.log_trap_roll_description), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), (String) null), wrap(((Integer) objArr[1]).intValue(), (String) null));
                                break;
                            case 26:
                                Entity entity13 = (Entity) objArr[0];
                                int iIntValue9 = ((Integer) objArr[1]).intValue();
                                String string22 = RESOURCES.getString(R.string.log_trap_avoided);
                                String string23 = RESOURCES.getString(entity13.getIdName());
                                if (entity13 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string22, wrap(string23, red5), wrap(iIntValue9, (String) null));
                                break;
                            case 27:
                                Entity entity14 = (Entity) objArr[0];
                                int iIntValue10 = ((Integer) objArr[1]).intValue();
                                int iIntValue11 = ((Integer) objArr[2]).intValue();
                                String string24 = RESOURCES.getString(R.string.log_trap_not_avoided);
                                String string25 = RESOURCES.getString(entity14.getIdName());
                                if (entity14 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string24, wrap(string25, red5), wrap(iIntValue10, getRed()), wrap(iIntValue11, (String) null));
                                break;
                            case 28:
                                Entity entity15 = (Entity) objArr[0];
                                String string26 = RESOURCES.getString(R.string.log_trap_disarmed);
                                String string27 = RESOURCES.getString(entity15.getIdName());
                                if (entity15 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string26, wrap(string27, red5));
                                break;
                            case 29:
                                Entity entity16 = (Entity) objArr[0];
                                String str5 = String.format(RESOURCES.getString(R.string.log_skill), RESOURCES.getString(entity16.getIdName()), RESOURCES.getString(entity16.getActiveSkill().nameRes));
                                if (entity16 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = wrap(str5, red5);
                                break;
                            case 30:
                                Entity entity17 = (Entity) objArr[0];
                                Entity entity18 = (Entity) objArr[1];
                                String string28 = RESOURCES.getString(R.string.log_revive);
                                String strWrap19 = wrap(RESOURCES.getString(entity17.getIdName()), entity17 instanceof Enemy ? getRed() : GREEN);
                                String string29 = RESOURCES.getString(entity18.getIdName());
                                if (entity18 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string28, strWrap19, wrap(string29, red5));
                                break;
                            case 31:
                                Entity entity19 = (Entity) objArr[0];
                                Entity entity20 = (Entity) objArr[1];
                                String string30 = RESOURCES.getString(R.string.log_parry_attack);
                                String strWrap20 = wrap(RESOURCES.getString(entity19.getIdName()), entity19 instanceof Enemy ? getRed() : GREEN);
                                String string31 = RESOURCES.getString(entity20.getIdName());
                                if (entity20 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string30, strWrap20, wrap(string31, red5));
                                break;
                            case 32:
                                Entity entity21 = (Entity) objArr[0];
                                String string32 = RESOURCES.getString(R.string.log_parry_skill);
                                String string33 = RESOURCES.getString(entity21.getIdName());
                                if (entity21 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string32, wrap(string33, red5));
                                break;
                            case 33:
                                int iIntValue12 = ((Integer) objArr[0]).intValue();
                                int iIntValue13 = ((Integer) objArr[1]).intValue();
                                Entity entity22 = (Entity) objArr[2];
                                Entity entity23 = (Entity) objArr[3];
                                int iIntValue14 = ((Integer) objArr[4]).intValue();
                                boolean z3 = Boolean.parseBoolean(RESOURCES.getString(R.string.swap_amount_and_target_in_logs));
                                String strWrap21 = wrap(RESOURCES.getString(entity22.getIdName()), entity22 instanceof Enemy ? getRed() : GREEN);
                                String strWrap22 = wrap(iIntValue14, getRed());
                                String string34 = RESOURCES.getString(entity23.getIdName());
                                if (entity23 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                String strWrap23 = wrap(string34, red5);
                                String string35 = RESOURCES.getString(iIntValue12);
                                String str6 = z3 ? strWrap23 : strWrap22;
                                if (!z3) {
                                    strWrap22 = strWrap23;
                                }
                                String str7 = String.format(string35, strWrap21, str6, strWrap22);
                                if (iIntValue13 == 1) {
                                    str7 = str7 + " " + wrap(RESOURCES.getString(R.string.log_critical_hit), (String) null);
                                }
                                strWrap = iIntValue13 != 2 ? str7 : str7 + " " + wrap(RESOURCES.getString(R.string.log_devastating_hit), (String) null);
                                break;
                            case 34:
                                Entity entity24 = (Entity) objArr[0];
                                Entity entity25 = (Entity) objArr[1];
                                String string36 = RESOURCES.getString(R.string.log_execution);
                                String strWrap24 = wrap(RESOURCES.getString(entity24.getIdName()), entity24 instanceof Enemy ? getRed() : GREEN);
                                String string37 = RESOURCES.getString(entity25.getIdName());
                                if (entity25 instanceof Enemy) {
                                    red5 = getRed();
                                }
                                strWrap = String.format(string36, strWrap24, wrap(string37, red5));
                                break;
                            case 35:
                                Entity entity26 = (Entity) objArr[0];
                                strWrap = String.format(RESOURCES.getString(R.string.log_lifesteal), wrap(RESOURCES.getString(entity26.getIdName()), entity26 instanceof Enemy ? getRed() : GREEN), wrap(((Integer) objArr[1]).intValue(), GREEN));
                                break;
                            case 36:
                                strWrap = String.format(RESOURCES.getString(R.string.log_enemy_death), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), getRed()));
                                break;
                            case 37:
                                strWrap = String.format(RESOURCES.getString(R.string.log_reanimated_unit_death), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN));
                                break;
                            case 38:
                                int iIntValue15 = ((Integer) objArr[0]).intValue();
                                strWrap = ((Integer) objArr[2]).intValue() != 0 ? String.format(RESOURCES.getString(R.string.log_adventurer_death_preserve_exp), wrap(RESOURCES.getString(iIntValue15), GREEN)) : String.format(RESOURCES.getString(R.string.log_adventurer_death), wrap(RESOURCES.getString(iIntValue15), GREEN), wrap(((Integer) objArr[1]).intValue(), ORANGE));
                                break;
                            case 39:
                                strWrap = String.format(RESOURCES.getString(R.string.log_reanimate_corpse), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN), wrap(RESOURCES.getString(((Integer) objArr[1]).intValue()), GREEN));
                                break;
                            case 40:
                                strWrap = String.format(RESOURCES.getString(R.string.log_search_item_found), wrap(((Integer) objArr[0]).intValue(), ORANGE), wrap(RESOURCES.getString(((Integer) objArr[1]).intValue()), ORANGE));
                                break;
                            case 41:
                                strWrap = RESOURCES.getString(R.string.log_search_no_item);
                                break;
                            default:
                                switch (i) {
                                    case 43:
                                        strWrap = String.format(RESOURCES.getString(R.string.log_escape), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), getRed()));
                                        break;
                                    case 44:
                                        strWrap = wrap(String.format(RESOURCES.getString(((Integer) objArr[0]).intValue()), Integer.valueOf(((Integer) objArr[1]).intValue())), YELLOW);
                                        break;
                                    case 45:
                                        Entity entity27 = (Entity) objArr[0];
                                        Entity entity28 = (Entity) objArr[1];
                                        String string38 = RESOURCES.getString(R.string.log_dodge_flying);
                                        String strWrap25 = wrap(RESOURCES.getString(entity27.getIdName()), entity27 instanceof Enemy ? getRed() : GREEN);
                                        String string39 = RESOURCES.getString(entity28.getIdName());
                                        if (entity28 instanceof Enemy) {
                                            red5 = getRed();
                                        }
                                        strWrap = String.format(string38, strWrap25, wrap(string39, red5));
                                        break;
                                    case 46:
                                        if (zIsSettingVerboseLogs) {
                                            Entity entity29 = (Entity) objArr[0];
                                            int iIntValue16 = ((Integer) objArr[1]).intValue();
                                            String string40 = RESOURCES.getString(R.string.log_damage_received_retaliation);
                                            String string41 = RESOURCES.getString(entity29.getIdName());
                                            if (entity29 instanceof Enemy) {
                                                red5 = getRed();
                                            }
                                            strWrap = String.format(string40, wrap(string41, red5), wrap(iIntValue16, getRed()));
                                            break;
                                        }
                                                                            case 47:
                                        strWrap = wrap(String.format(RESOURCES.getString(R.string.log_eternal_battlefield_event_1a), Integer.valueOf(((Integer) objArr[0]).intValue())), YELLOW);
                                        break;
                                    case 48:
                                        strWrap = String.format(RESOURCES.getString(R.string.log_the_golden_city_finding_2a), wrap(((Integer) objArr[0]).intValue(), getRed()), wrap(RESOURCES.getString(((Integer) objArr[1]).intValue()), GREEN));
                                        break;
                                    case 49:
                                        if (zIsSettingVerboseLogs) {
                                            Entity entity30 = (Entity) objArr[0];
                                            strWrap = String.format(RESOURCES.getString(R.string.log_regeneration), wrap(RESOURCES.getString(entity30.getIdName()), entity30 instanceof Enemy ? getRed() : GREEN), wrap(((Integer) objArr[1]).intValue(), GREEN));
                                            break;
                                        }
                                                                            case 50:
                                        if (zIsSettingVerboseLogs) {
                                            entity2 = (Entity) objArr[0];
                                            statusEffect2 = (StatusEffect) objArr[1];
                                            int iIntValue17 = ((Integer) objArr[2]).intValue();
                                            String string110 = RESOURCES.getString(R.string.status_effect_log_damage);
                                            String string111 = RESOURCES.getString(entity2.getIdName());
                                            if (entity2 instanceof Enemy) {
                                                red3 = getRed();
                                            } else {
                                                red3 = GREEN;
                                            }
                                            String strWrap110 = wrap(string111, red3);
                                            String string112 = RESOURCES.getString(statusEffect2.getType().logDescription);
                                            if (statusEffect2.getType().negative) {
                                                red4 = getRed();
                                            } else {
                                                red4 = GREEN;
                                            }
                                            String strWrap111 = wrap(string112, red4);
                                            String strWrap112 = wrap(iIntValue17, getRed());
                                            int turnsLeft4 = statusEffect2.getTurnsLeft();
                                            if (statusEffect2.getType().negative) {
                                                red5 = getRed();
                                            }
                                            strWrap = String.format(string110, strWrap110, strWrap111, strWrap112, wrap(turnsLeft4, red5));
                                            break;
                                        }
                                                                            case 51:
                                        strWrap = String.format(RESOURCES.getString(R.string.log_frostbite_peaks_finding_1a), wrap(((Integer) objArr[0]).intValue(), (String) null), wrap(RESOURCES.getString(((Integer) objArr[1]).intValue()), GREEN), wrap(((Integer) objArr[2]).intValue(), (String) null));
                                        break;
                                    case 52:
                                        strWrap = String.format(RESOURCES.getString(R.string.log_frostbite_peaks_finding_1b), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN));
                                        break;
                                    case 53:
                                        strWrap = String.format(RESOURCES.getString(R.string.log_frostbite_peaks_finding_1c), wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN));
                                        break;
                                    default:
                                        switch (i) {
                                            case 100:
                                                strWrap = RESOURCES.getString(((Integer) objArr[0]).intValue());
                                                break;
                                            case 101:
                                                strWrap = wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), getRed());
                                                break;
                                            case 102:
                                                strWrap = wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), GREEN);
                                                break;
                                            case EVENT_SIGNIFICANT /* 103 */:
                                                strWrap = wrap(RESOURCES.getString(((Integer) objArr[0]).intValue()), YELLOW);
                                                break;
                                            case 104:
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_the_southern_grove_wurm_chase), Integer.valueOf(((Integer) objArr[0]).intValue()), Integer.valueOf(((Integer) objArr[1]).intValue())), YELLOW);
                                                break;
                                            case 105:
                                                if (zIsSettingVerboseLogs) {
                                                    int iIntValue18 = ((Integer) objArr[0]).intValue();
                                                    Pet pet = (Pet) objArr[1];
                                                    Entity entity31 = (Entity) objArr[2];
                                                    int iIntValue19 = ((Integer) objArr[3]).intValue();
                                                    boolean z4 = Boolean.parseBoolean(RESOURCES.getString(R.string.swap_amount_and_target_in_logs));
                                                    String strWrap26 = wrap(RESOURCES.getString(pet.getIdName()), GREEN);
                                                    String strWrap27 = wrap(iIntValue19, getRed());
                                                    String strWrap28 = wrap(RESOURCES.getString(entity31.getIdName()), getRed());
                                                    String string42 = RESOURCES.getString(iIntValue18);
                                                    String str8 = z4 ? strWrap28 : strWrap27;
                                                    if (!z4) {
                                                        strWrap27 = strWrap28;
                                                    }
                                                    strWrap = String.format(string42, strWrap26, str8, strWrap27);
                                                    break;
                                                }
                                                                                            case LOG_PET_HEAL /* 106 */:
                                                if (zIsSettingVerboseLogs) {
                                                    Pet pet2 = (Pet) objArr[0];
                                                    Entity entity32 = (Entity) objArr[1];
                                                    int iIntValue20 = ((Integer) objArr[2]).intValue();
                                                    boolean z5 = Boolean.parseBoolean(RESOURCES.getString(R.string.swap_amount_and_target_in_logs));
                                                    String strWrap29 = wrap(RESOURCES.getString(pet2.getIdName()), GREEN);
                                                    String strWrap30 = wrap(iIntValue20, GREEN);
                                                    String strWrap31 = wrap(RESOURCES.getString(entity32.getIdName()), GREEN);
                                                    String string43 = RESOURCES.getString(R.string.log_healing);
                                                    String str9 = z5 ? strWrap31 : strWrap30;
                                                    if (!z5) {
                                                        strWrap30 = strWrap31;
                                                    }
                                                    strWrap = String.format(string43, strWrap29, str9, strWrap30);
                                                    break;
                                                }
                                                                                            case PET_DECOY /* 107 */:
                                                strWrap = String.format(RESOURCES.getString(R.string.log_pet_decoy), wrap(RESOURCES.getString(((Pet) objArr[0]).getIdName()), GREEN), wrap(RESOURCES.getString(((Entity) objArr[1]).getIdName()), getRed()));
                                                break;
                                            case 108:
                                                strWrap = String.format(RESOURCES.getString(R.string.log_pet_execution), wrap(RESOURCES.getString(((Entity) objArr[0]).getIdName()), getRed()), wrap(RESOURCES.getString(((Pet) objArr[1]).getIdName()), GREEN));
                                                break;
                                            case 109:
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_hidden_city_of_larox_event_magic_amplification), Integer.valueOf(((Integer) objArr[0]).intValue())), YELLOW);
                                                break;
                                            case STATUS_FEEBLE_TETHER /* 110 */:
                                                if (zIsSettingVerboseLogs) {
                                                    strWrap = wrap(String.format(RESOURCES.getString(R.string.status_effect_log_feeble_tether), RESOURCES.getString(((Entity) objArr[0]).getIdName())), getRed());
                                                    break;
                                                }
                                                                                            case STATUS_PETRIFIED /* 111 */:
                                                if (!zIsSettingVerboseLogs) {
                                                    entity = (Entity) objArr[0];
                                                    statusEffect = (StatusEffect) objArr[1];
                                                    String string44 = RESOURCES.getString(R.string.status_effect_log_simple);
                                                    String string45 = RESOURCES.getString(entity.getIdName());
                                                    if (entity instanceof Enemy) {
                                                        red = getRed();
                                                    } else {
                                                        red = GREEN;
                                                    }
                                                    String strWrap113 = wrap(string45, red);
                                                    String string113 = RESOURCES.getString(statusEffect.getType().logDescription);
                                                    if (statusEffect.getType().negative) {
                                                        red2 = getRed();
                                                    } else {
                                                        red2 = GREEN;
                                                    }
                                                    String strWrap114 = wrap(string113, red2);
                                                    int turnsLeft5 = statusEffect.getTurnsLeft();
                                                    if (statusEffect.getType().negative) {
                                                        red5 = getRed();
                                                    }
                                                    strWrap = String.format(string44, strWrap113, strWrap114, wrap(turnsLeft5, red5));
                                                    break;
                                                }
                                                                                            case LOST_EXPEDITION_FALL_DAMAGE /* 112 */:
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_the_lost_expedition_fall_damage), RESOURCES.getString(((Entity) objArr[0]).getIdName()), Integer.valueOf(((Integer) objArr[1]).intValue())), getRed());
                                                break;
                                            case RITUAL_SUMMON_SMOLDERING_TITAN /* 113 */:
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_lost_lands_event_increase), Integer.valueOf(((Integer) objArr[0]).intValue())), YELLOW);
                                                break;
                                            case SUMMON_SMOLDERING_TITAN /* 114 */:
                                                strWrap = wrap(RESOURCES.getString(R.string.log_lost_lands_event_summon), YELLOW);
                                                break;
                                            case BOTCHED_OFFERING /* 115 */:
                                                Entity entity33 = (Entity) objArr[0];
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_the_dire_descent_event_1), RESOURCES.getString(entity33.getIdName()), RESOURCES.getString(entity33.getActiveSkill().nameRes)), getRed());
                                                break;
                                            case ARCANE_SUPPRESSION /* 116 */:
                                                boolean zEquals3 = "ko".equals(RESOURCES.getString(R.string.language_code));
                                                Entity entity34 = (Entity) objArr[0];
                                                int iIntValue21 = ((Integer) objArr[1]).intValue();
                                                String string46 = RESOURCES.getString(R.string.doctrine_ability_arcane_suppression_name);
                                                String string47 = RESOURCES.getString(R.string.log_arcane_suppression);
                                                String string48 = RESOURCES.getString(entity34.getIdName());
                                                if (entity34 instanceof Enemy) {
                                                    red5 = getRed();
                                                }
                                                String strWrap32 = wrap(string48, red5);
                                                String strWrap33 = zEquals3 ? string46 : wrap(iIntValue21, getRed());
                                                if (zEquals3) {
                                                    string46 = wrap(iIntValue21, getRed());
                                                }
                                                strWrap = String.format(string47, strWrap32, strWrap33, string46);
                                                break;
                                            case HEALING_NOVA /* 117 */:
                                                String string49 = RESOURCES.getString(R.string.language_code);
                                                if (!"zh".equals(string49) && !"ko".equals(string49)) {
                                                    z = false;
                                                }
                                                String strValueOf = String.valueOf(((Integer) objArr[0]).intValue());
                                                String string50 = RESOURCES.getString(R.string.doctrine_ability_healing_nova_name);
                                                String string51 = RESOURCES.getString(R.string.log_healing_nova);
                                                String strWrap34 = wrap(z ? string50 : strValueOf, GREEN);
                                                if (!z) {
                                                    strValueOf = string50;
                                                }
                                                strWrap = String.format(string51, strWrap34, wrap(strValueOf, GREEN));
                                                break;
                                            case STATUS_TERRIFIED /* 118 */:
                                                if (zIsSettingVerboseLogs) {
                                                    entity2 = (Entity) objArr[0];
                                                    statusEffect2 = (StatusEffect) objArr[1];
                                                    int iIntValue110 = ((Integer) objArr[2]).intValue();
                                                    String string114 = RESOURCES.getString(R.string.status_effect_log_damage);
                                                    String string115 = RESOURCES.getString(entity2.getIdName());
                                                    if (entity2 instanceof Enemy) {
                                                        red3 = getRed();
                                                    } else {
                                                        red3 = GREEN;
                                                    }
                                                    String strWrap115 = wrap(string115, red3);
                                                    String string116 = RESOURCES.getString(statusEffect2.getType().logDescription);
                                                    if (statusEffect2.getType().negative) {
                                                        red4 = getRed();
                                                    } else {
                                                        red4 = GREEN;
                                                    }
                                                    String strWrap116 = wrap(string116, red4);
                                                    String strWrap117 = wrap(iIntValue110, getRed());
                                                    int turnsLeft6 = statusEffect2.getTurnsLeft();
                                                    if (statusEffect2.getType().negative) {
                                                        red5 = getRed();
                                                    }
                                                    strWrap = String.format(string114, strWrap115, strWrap116, strWrap117, wrap(turnsLeft6, red5));
                                                    break;
                                                }
                                                                                            case AMULET_OF_RESURRECTION /* 119 */:
                                                strWrap = wrap(String.format(RESOURCES.getString(R.string.log_amulet_of_resurrection), RESOURCES.getString(((Entity) objArr[0]).getIdName())), GREEN);
                                                break;
                                            case BARD_SHIELD /* 120 */:
                                                Entity entity35 = (Entity) objArr[0];
                                                Entity entity36 = (Entity) objArr[1];
                                                strWrap = String.format(RESOURCES.getString(R.string.log_shielding), wrap(RESOURCES.getString(entity35.getIdName()), entity35 instanceof Adventurer ? GREEN : getRed()), wrap(RESOURCES.getString(entity36.getIdName()), entity36 instanceof Adventurer ? GREEN : getRed()), wrap(((Integer) objArr[2]).intValue(), GREEN));
                                                break;
                                        }
                                                                        }
                                break;
                        }
                                        }
                return;
            }
            try {
                MainActivity.shownDialogDungeonDetail.log(strWrap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void invalidate() {
        RESOURCES = null;
    }

    private static String getRed() {
        return MainActivity.data.isSettingColorblindMode() ? RED_COLORBLIND : RED;
    }

    private static String wrap(String str, String str2) {
        if (str2 == null) {
            return String.format(NO_COLOR_FORMAT, str);
        }
        return String.format(COLOR_FORMAT, str2, str);
    }

    private static String wrap(int i, String str) {
        return wrap(String.valueOf(i), str);
    }
}
