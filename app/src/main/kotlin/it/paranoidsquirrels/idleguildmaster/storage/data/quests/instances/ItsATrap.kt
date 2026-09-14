package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class ItsATrap : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty.toLong() * 20).toLong()
    }

    override fun configure() {
        idName = R.string.quest_its_a_trap_name
        idDescription = R.string.quest_its_a_trap_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.itsATrap = this
    }
}
