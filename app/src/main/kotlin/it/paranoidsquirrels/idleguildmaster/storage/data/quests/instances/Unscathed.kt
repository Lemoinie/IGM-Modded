package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Unscathed : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 3).toLong() * 25) + 50).toLong()
    }

    override fun configure() {
        idName = R.string.quest_unscathed_name
        idDescription = R.string.quest_unscathed_description
        defaultRarity = 3
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.unscathed = this
    }
}
