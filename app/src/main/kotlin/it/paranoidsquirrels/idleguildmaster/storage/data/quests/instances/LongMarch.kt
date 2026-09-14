package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class LongMarch : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = if (difficulty == 1) 500L else (difficulty - 1).toLong() * 3000
    }

    override fun configure() {
        idName = R.string.quest_long_march_name
        idDescription = R.string.quest_long_march_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.longMarch = this
    }
}
