package it.paranoidsquirrels.idleguildmaster.storage.data.places

import it.paranoidsquirrels.idleguildmaster.R

class Action(val type: Int) {
    companion object {
        const val ENTER_DUNGEON = 0
        const val ENTER_ROOM = 1
        const val FIGHT = 2
        const val LOOT = 3
        const val SEARCH = 4
        const val RESPAWN = 5
        const val FLEE = 6
    }

    var turnsPassed: Int = 0
    @Transient var turnsToComplete: Int = 0
        private set
    @Transient var name: Int = 0
        private set

    init {
        when (type) {
            ENTER_DUNGEON -> {
                turnsToComplete = 5
                name = R.string.action_enter_dungeon
            }
            ENTER_ROOM -> {
                turnsToComplete = 5
                name = R.string.action_enter_room
            }
            FIGHT -> {
                turnsToComplete = 2
                name = R.string.action_fight
            }
            LOOT -> {
                turnsToComplete = 5
                name = R.string.action_loot
            }
            SEARCH -> {
                turnsToComplete = 5
                name = R.string.action_search
            }
            RESPAWN -> {
                turnsToComplete = 18
                name = R.string.action_respawn
            }
            FLEE -> {
                turnsToComplete = 12
                name = R.string.action_flee
            }
        }
    }

    fun nextTurn() {
        turnsPassed++
    }

    fun finished(): Boolean = turnsPassed >= turnsToComplete
}
