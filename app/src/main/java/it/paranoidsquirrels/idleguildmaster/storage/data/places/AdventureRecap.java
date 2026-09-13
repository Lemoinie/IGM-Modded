package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AdventureRecap {
    private int areasCleared;
    private List<EnemyCounter> enemiesKilled = new CopyOnWriteArrayList();
    private int expEarned;
    private int expLost;
    private int secondsPassed;
    private int wiped;

    public List<EnemyCounter> getEnemiesKilled() {
        return this.enemiesKilled;
    }

    public int getSecondsPassed() {
        return this.secondsPassed;
    }

    public int getAreasCleared() {
        return this.areasCleared;
    }

    public int getWiped() {
        return this.wiped;
    }

    public int getExpEarned() {
        return this.expEarned;
    }

    public int getExpLost() {
        return this.expLost;
    }

    public void setSecondsPassed(int i) {
        this.secondsPassed = i;
    }

    public void setEnemiesKilled(List<EnemyCounter> list) {
        this.enemiesKilled = list;
    }

    public void setAreasCleared(int i) {
        this.areasCleared = i;
    }

    public void setWiped(int i) {
        this.wiped = i;
    }

    public void setExpEarned(int i) {
        this.expEarned = i;
    }

    public void setExpLost(int i) {
        this.expLost = i;
    }

    public void addEnemyKilled(Enemy enemy) {
        if (enemy == null) {
            return;
        }
        String trueClass = enemy.getTrueClass();
        for (EnemyCounter enemyCounter : this.enemiesKilled) {
            if (trueClass.equals(enemyCounter.getEnemy())) {
                enemyCounter.setTimesSlain(enemyCounter.getTimesSlain() + 1);
                return;
            }
        }
        this.enemiesKilled.add(new EnemyCounter(trueClass, 1));
    }

    public void addSecondPassed() {
        this.secondsPassed++;
    }

    public void addAreaCleared() {
        this.areasCleared++;
    }

    public void addWipe() {
        this.wiped++;
    }

    public void addExpEarned(int i) {
        this.expEarned += i;
    }

    public void addExpLost(int i) {
        this.expLost += i;
    }
}
