package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Exorcism : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 20).toLong()
    }

    override fun configure() {
        idName = R.string.quest_exorcism_name
        idDescription = R.string.quest_exorcism_description
        defaultRarity = 4
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.exorcism = this
    }
}
