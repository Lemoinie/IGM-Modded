package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Marathon : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 60L
    }

    override fun configure() {
        idName = R.string.quest_marathon_name
        idDescription = R.string.quest_marathon_description
        defaultRarity = 4
        minimumDifficulty = 9
    }

    override fun realignStaticReference() {
        QuestsManager.marathon = this
    }
}
