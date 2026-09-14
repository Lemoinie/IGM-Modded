package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class VampiricThirst : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (Math.pow(1.7, (difficulty - 3).toDouble()) * 5000.0).toLong()
    }

    override fun configure() {
        idName = R.string.quest_vampiric_thirst_name
        idDescription = R.string.quest_vampiric_thirst_description
        defaultRarity = 1
        minimumDifficulty = 4
    }

    override fun realignStaticReference() {
        QuestsManager.vampiricThirst = this
    }
}
