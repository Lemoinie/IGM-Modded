package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Delirious : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 25).toLong()
    }

    override fun configure() {
        idName = R.string.quest_delirious_name
        idDescription = R.string.quest_delirious_description
        defaultRarity = 4
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.delirious = this
    }
}
