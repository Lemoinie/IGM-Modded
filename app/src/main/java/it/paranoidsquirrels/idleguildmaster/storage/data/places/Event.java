package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class Event {
    public static final String ANGRY_EYE = "angry_eye";
    public static final String BLIZZARD = "blizzard";
    public static final String ENRAGED_SPIRIT = "enraged_spirit";
    public static final String HALLS_EXPLORATION = "halls_exploration";
    public static final String HALLS_SKELETON_DOOR = "halls_skeleton_door";
    public static final String LOST_EXPEDITION_TRAPDOOR = "lost_expedition_trapdoor";
    public static final String MAGIC_AMPLIFICATION = "magic_amplification";
    public static final String PRIMEVAL_WURM_COOLDOWN = "primeval_wurm_cooldown";
    public static final String PRIMEVAL_WURM_PROGRESS = "primeval_wurm_progress";
    public static final String PYRAMID_DOOR_OPEN = "pyramid_door_open";
    public static final String SHAHURI_ARMY_CHARGING = "shahuri_army_charging";
    public static final String SHAHURI_ARMY_READY = "shahuri_army_ready";
    public static final String SUMMON_SMOLDERING_TITAN = "summon_smoldering_titan";
    public static final String THE_KRAKEN = "the_kraken";
    public static final String THE_KRAKEN_FIGHT = "the_kraken_fight";
    public static final String TUTORIAL = "tutorial";
    public static final String UNSPEAKABLE_HORROR = "unspeakable_horror";
    public static final String UNSPEAKABLE_HORROR_COOLDOWN = "unspeakable_horror_cooldown";
    public static final String WILL_O_WISP_HUNT = "will_o_wisp_hunt";
    private int key;
    private int progress;

    public Event() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public Event(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1946012796:
                if (str.equals(SHAHURI_ARMY_CHARGING)) {
                    b = 0;
                }
                break;
            case -1869128172:
                if (str.equals(PRIMEVAL_WURM_COOLDOWN)) {
                    b = 1;
                }
                break;
            case -1471589962:
                if (str.equals(UNSPEAKABLE_HORROR)) {
                    b = 2;
                }
                break;
            case -1268255732:
                if (str.equals(PYRAMID_DOOR_OPEN)) {
                    b = 3;
                }
                break;
            case -1088583578:
                if (str.equals(WILL_O_WISP_HUNT)) {
                    b = 4;
                }
                break;
            case -1030694695:
                if (str.equals(THE_KRAKEN_FIGHT)) {
                    b = 5;
                }
                break;
            case -814667500:
                if (str.equals(BLIZZARD)) {
                    b = 6;
                }
                break;
            case -740474821:
                if (str.equals(HALLS_SKELETON_DOOR)) {
                    b = 7;
                }
                break;
            case -491816301:
                if (str.equals(ANGRY_EYE)) {
                    b = 8;
                }
                break;
            case -142142402:
                if (str.equals(LOST_EXPEDITION_TRAPDOOR)) {
                    b = 9;
                }
                break;
            case 86904100:
                if (str.equals(MAGIC_AMPLIFICATION)) {
                    b = 10;
                }
                break;
            case 193276766:
                if (str.equals(TUTORIAL)) {
                    b = Ascii.VT;
                }
                break;
            case 414309566:
                if (str.equals(HALLS_EXPLORATION)) {
                    b = Ascii.FF;
                }
                break;
            case 958109090:
                if (str.equals(ENRAGED_SPIRIT)) {
                    b = Ascii.CR;
                }
                break;
            case 1197851592:
                if (str.equals(THE_KRAKEN)) {
                    b = Ascii.SO;
                }
                break;
            case 1609947504:
                if (str.equals(SHAHURI_ARMY_READY)) {
                    b = Ascii.SI;
                }
                break;
            case 1739617236:
                if (str.equals(UNSPEAKABLE_HORROR_COOLDOWN)) {
                    b = Ascii.DLE;
                }
                break;
            case 1894030419:
                if (str.equals(SUMMON_SMOLDERING_TITAN)) {
                    b = 17;
                }
                break;
            case 1970870486:
                if (str.equals(PRIMEVAL_WURM_PROGRESS)) {
                    b = Ascii.DC2;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 17:
            case 18:
                this.key = 1;
                break;
            case 1:
            case 5:
            case 7:
            case 11:
            case 15:
            case 16:
                this.key = 2;
                break;
        }
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
    }
}
