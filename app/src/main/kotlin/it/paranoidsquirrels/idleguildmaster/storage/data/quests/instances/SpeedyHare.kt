package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class SpeedyHare : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 8).toLong() * 20) + 50).toLong()
    }

    override fun configure() {
        idName = R.string.quest_speedy_hare_name
        idDescription = R.string.quest_speedy_hare_description
        defaultRarity = 1
        minimumDifficulty = 8
    }

    override fun realignStaticReference() {
        QuestsManager.speedyHare = this
    }
}
