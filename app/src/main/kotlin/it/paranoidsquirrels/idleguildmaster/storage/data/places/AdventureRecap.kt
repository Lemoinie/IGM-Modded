package it.paranoidsquirrels.idleguildmaster.storage.data.places

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy

class AdventureRecap {
    var secondsPassed: Int = 0
    var enemiesKilled: MutableList<EnemyCounter> = ArrayList()
    var areasCleared: Int = 0
    var wiped: Int = 0
    var expEarned: Int = 0
    var expLost: Int = 0

    fun addEnemyKilled(enemy: Enemy?) {
        if (enemy == null) return
        val trueClass = enemy.trueClass ?: return
        for (counter in enemiesKilled) {
            if (trueClass == counter.enemy) {
                counter.timesSlain++
                return
            }
        }
        enemiesKilled.add(EnemyCounter(trueClass, 1))
    }

    fun addSecondPassed() {
        secondsPassed++
    }

    fun addAreaCleared() {
        areasCleared++
    }

    fun addWipe() {
        wiped++
    }

    fun addExpEarned(exp: Int) {
        expEarned += exp
    }

    fun addExpLost(exp: Int) {
        expLost += exp
    }
}
