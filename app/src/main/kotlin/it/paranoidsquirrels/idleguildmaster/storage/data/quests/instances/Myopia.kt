package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Myopia : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 7).toLong() * 50) + 300).toLong()
    }

    override fun configure() {
        idName = R.string.quest_myopia_name
        idDescription = R.string.quest_myopia_description
        defaultRarity = 1
        minimumDifficulty = 7
    }

    override fun realignStaticReference() {
        QuestsManager.myopia = this
    }
}
