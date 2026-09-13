package it.paranoidsquirrels.idleguildmaster.storage.data.places;

/* JADX INFO: loaded from: classes3.dex */
public class EnemyCounter {
    private String enemy;
    private int timesSlain;

    public EnemyCounter(String str, int i) {
        this.enemy = str;
        this.timesSlain = i;
    }

    public String getEnemy() {
        return this.enemy;
    }

    public void setEnemy(String str) {
        this.enemy = str;
    }

    public int getTimesSlain() {
        return this.timesSlain;
    }

    public void setTimesSlain(int i) {
        this.timesSlain = i;
    }
}
