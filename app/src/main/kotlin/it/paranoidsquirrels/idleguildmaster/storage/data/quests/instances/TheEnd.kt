package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class TheEnd : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 15).toLong()
    }

    override fun configure() {
        idName = R.string.quest_the_end_name
        idDescription = R.string.quest_the_end_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.theEnd = this
    }
}
