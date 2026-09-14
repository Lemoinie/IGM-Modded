package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class BotchedRitual : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_botched_ritual_name
        idDescription = R.string.quest_botched_ritual_description
        defaultRarity = 2
        minimumDifficulty = 8
    }

    override fun realignStaticReference() {
        QuestsManager.botchedRitual = this
    }

    override fun cannotAppearWith(): Quest? = QuestsManager.endlessAgony
}
