package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class LuckyRoll : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 50).toLong()
    }

    override fun configure() {
        idName = R.string.quest_lucky_roll_name
        idDescription = R.string.quest_lucky_roll_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.luckyRoll = this
    }
}
