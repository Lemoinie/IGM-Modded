package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Protector : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 1).toLong() * 60000) + 10000L
    }

    override fun configure() {
        idName = R.string.quest_protector_name
        idDescription = R.string.quest_protector_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.protector = this
    }
}
