package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class CriticalHit : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        when (difficulty) {
            1 -> targetProgress = 100L
            2 -> targetProgress = 300L
            3 -> targetProgress = 1000L
            4 -> targetProgress = 3000L
            5 -> targetProgress = 5000L
            6 -> targetProgress = 7500L
            7 -> targetProgress = 10000L
            8 -> targetProgress = 13750L
            9 -> targetProgress = 17500L
            10 -> targetProgress = 21250L
            else -> targetProgress = 25000L
        }
    }

    override fun configure() {
        idName = R.string.quest_critical_hit_name
        idDescription = R.string.quest_critical_hit_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.criticalHit = this
    }
}
