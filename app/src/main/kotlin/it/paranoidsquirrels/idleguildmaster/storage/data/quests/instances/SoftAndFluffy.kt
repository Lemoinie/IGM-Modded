package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class SoftAndFluffy : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 2).toLong() * 5).toLong()
    }

    override fun configure() {
        idName = R.string.quest_soft_and_fluffy_name
        idDescription = R.string.quest_soft_and_fluffy_description
        defaultRarity = 2
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.softAndFluffy = this
    }
}
