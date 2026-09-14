package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Regicide : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_regicide_name
        idDescription = R.string.quest_regicide_description
        defaultRarity = 2
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.regicide = this
    }
}
