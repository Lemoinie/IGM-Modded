package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class FallingApart : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty - 5).toLong() * 5000L
    }

    override fun configure() {
        idName = R.string.quest_falling_apart_name
        idDescription = R.string.quest_falling_apart_description
        defaultRarity = 1
        minimumDifficulty = 6
    }

    override fun realignStaticReference() {
        QuestsManager.fallingApart = this
    }
}
