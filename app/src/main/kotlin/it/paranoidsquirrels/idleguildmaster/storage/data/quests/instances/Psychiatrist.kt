package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Psychiatrist : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 1000L
    }

    override fun configure() {
        idName = R.string.quest_psychiatrist_name
        idDescription = R.string.quest_psychiatrist_description
        defaultRarity = 1
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.psychiatrist = this
    }
}
