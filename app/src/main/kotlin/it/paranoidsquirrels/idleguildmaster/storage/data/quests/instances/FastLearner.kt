package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class FastLearner : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 100).toLong()
    }

    override fun configure() {
        idName = R.string.quest_fast_learner_name
        idDescription = R.string.quest_fast_learner_description
        defaultRarity = 3
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.fastLearner = this
    }
}
