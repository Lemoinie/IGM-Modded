package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Tormentor : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = if (difficulty == 1) 100L else difficulty.toLong() * 500
    }

    override fun configure() {
        idName = R.string.quest_tormentor_name
        idDescription = R.string.quest_tormentor_description
        defaultRarity = 3
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.tormentor = this
    }
}
