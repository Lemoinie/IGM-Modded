package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class SmokingHot : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 3).toLong() * 100).toLong()
    }

    override fun configure() {
        idName = R.string.quest_smoking_hot_name
        idDescription = R.string.quest_smoking_hot_description
        defaultRarity = 1
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.smokingHot = this
    }
}
