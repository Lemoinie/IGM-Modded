package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Pulverization : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 1000L
    }

    override fun configure() {
        idName = R.string.quest_pulverization_name
        idDescription = R.string.quest_pulverization_description
        defaultRarity = 3
        minimumDifficulty = 7
    }

    override fun realignStaticReference() {
        QuestsManager.pulverization = this
    }
}
