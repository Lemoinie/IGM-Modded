package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Spiky : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = difficulty.toLong() * 5000L
    }

    override fun configure() {
        idName = R.string.quest_spiky_name
        idDescription = R.string.quest_spiky_description
        defaultRarity = 1
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.spiky = this
    }
}
