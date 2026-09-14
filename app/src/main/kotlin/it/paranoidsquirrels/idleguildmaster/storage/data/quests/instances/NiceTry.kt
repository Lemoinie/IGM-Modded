package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class NiceTry : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 10L
    }

    override fun configure() {
        idName = R.string.quest_nice_try_name
        idDescription = R.string.quest_nice_try_description
        defaultRarity = 1
        minimumDifficulty = 5
    }

    override fun realignStaticReference() {
        QuestsManager.niceTry = this
    }
}
