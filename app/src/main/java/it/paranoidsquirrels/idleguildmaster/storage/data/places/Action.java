package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public class Action {
    public static final int ENTER_DUNGEON = 0;
    public static final int ENTER_ROOM = 1;
    public static final int FIGHT = 2;
    public static final int FLEE = 6;
    public static final int LOOT = 3;
    public static final int RESPAWN = 5;
    public static final int SEARCH = 4;
    private transient int name;
    private int turnsPassed = 0;
    private transient int turnsToComplete;
    private int type;

    public Action(int i) {
        this.type = i;
        switch (i) {
            case 0:
                this.turnsToComplete = 5;
                this.name = R.string.action_enter_dungeon;
                break;
            case 1:
                this.turnsToComplete = 5;
                this.name = R.string.action_enter_room;
                break;
            case 2:
                this.turnsToComplete = 2;
                this.name = R.string.action_fight;
                break;
            case 3:
                this.turnsToComplete = 5;
                this.name = R.string.action_loot;
                break;
            case 4:
                this.turnsToComplete = 5;
                this.name = R.string.action_search;
                break;
            case 5:
                this.turnsToComplete = 18;
                this.name = R.string.action_respawn;
                break;
            case 6:
                this.turnsToComplete = 12;
                this.name = R.string.action_flee;
                break;
        }
    }

    public int getType() {
        return this.type;
    }

    public void nextTurn() {
        this.turnsPassed++;
    }

    public boolean finished() {
        return this.turnsPassed >= this.turnsToComplete;
    }

    public int getTurnsPassed() {
        return this.turnsPassed;
    }

    public void setTurnsPassed(int i) {
        this.turnsPassed = i;
    }

    public int getTurnsToComplete() {
        return this.turnsToComplete;
    }

    public int getName() {
        return this.name;
    }
}
