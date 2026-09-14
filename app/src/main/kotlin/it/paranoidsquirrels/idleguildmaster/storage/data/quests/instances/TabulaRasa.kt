package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class TabulaRasa : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 2).toLong() * 10).toLong()
    }

    override fun configure() {
        idName = R.string.quest_tabula_rasa_name
        idDescription = R.string.quest_tabula_rasa_description
        defaultRarity = 3
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.tabulaRasa = this
    }
}
