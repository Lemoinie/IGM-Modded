package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Miracle : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty - 6).toLong()
    }

    override fun configure() {
        idName = R.string.quest_miracle_name
        idDescription = R.string.quest_miracle_description
        defaultRarity = 3
        minimumDifficulty = 9
    }

    override fun realignStaticReference() {
        QuestsManager.miracle = this
    }
}
