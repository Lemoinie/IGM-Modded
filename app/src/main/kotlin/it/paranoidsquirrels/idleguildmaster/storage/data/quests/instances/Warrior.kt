package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Warrior : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = if (difficulty == 1) 1000L else 5000L * difficulty.toLong()
    }

    override fun configure() {
        idName = R.string.quest_warrior_name
        idDescription = R.string.quest_warrior_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.warrior = this
    }
}
