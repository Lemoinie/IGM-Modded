package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Innocence : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 8).toLong() * 10) + 15).toLong()
    }

    override fun configure() {
        idName = R.string.quest_innocence_name
        idDescription = R.string.quest_innocence_description
        defaultRarity = 1
        minimumDifficulty = 8
    }

    override fun realignStaticReference() {
        QuestsManager.innocence = this
    }
}
