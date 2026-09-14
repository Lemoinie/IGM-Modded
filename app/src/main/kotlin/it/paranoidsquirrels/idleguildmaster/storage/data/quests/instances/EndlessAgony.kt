package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class EndlessAgony : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_endless_agony_name
        idDescription = R.string.quest_endless_agony_description
        defaultRarity = 2
        minimumDifficulty = 8
    }

    override fun realignStaticReference() {
        QuestsManager.endlessAgony = this
    }

    override fun cannotAppearWith(): Quest? = QuestsManager.botchedRitual
}
