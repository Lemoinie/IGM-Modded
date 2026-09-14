package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class CoupDEtat : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 100L
    }

    override fun configure() {
        idName = R.string.quest_coup_detat_name
        idDescription = R.string.quest_coup_detat_description
        defaultRarity = 1
        minimumDifficulty = 10
    }

    override fun realignStaticReference() {
        QuestsManager.coupDEtat = this
    }
}
