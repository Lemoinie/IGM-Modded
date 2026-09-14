package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class AndStayDead : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_and_stay_dead_name
        idDescription = R.string.quest_and_stay_dead_description
        defaultRarity = 2
        minimumDifficulty = 5
    }

    override fun realignStaticReference() {
        QuestsManager.andStayDead = this
    }
}
