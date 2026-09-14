package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class SoothingRemedy : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 5).toLong() * 2000).toLong()
    }

    override fun configure() {
        idName = R.string.quest_soothing_remedy_name
        idDescription = R.string.quest_soothing_remedy_description
        defaultRarity = 1
        minimumDifficulty = 6
    }

    override fun realignStaticReference() {
        QuestsManager.soothingRemedy = this
    }
}
