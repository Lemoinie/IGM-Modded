package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class SmartFighter : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = if (difficulty == 1) 1000L else ((difficulty - 1).toLong() * 10000L) + 5000L
    }

    override fun configure() {
        idName = R.string.quest_smart_fighter_name
        idDescription = R.string.quest_smart_fighter_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.smartFighter = this
    }
}
