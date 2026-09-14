package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class ActiveDeterrent : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 10L
    }

    override fun configure() {
        idName = R.string.quest_active_deterrent_name
        idDescription = R.string.quest_active_deterrent_description
        defaultRarity = 3
        minimumDifficulty = 10
    }

    override fun realignStaticReference() {
        QuestsManager.activeDeterrent = this
    }
}
