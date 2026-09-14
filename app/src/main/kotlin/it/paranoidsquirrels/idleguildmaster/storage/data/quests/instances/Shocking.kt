package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Shocking : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 3).toLong() * 50).toLong()
    }

    override fun configure() {
        idName = R.string.quest_shocking_name
        idDescription = R.string.quest_shocking_description
        defaultRarity = 1
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.shocking = this
    }
}
