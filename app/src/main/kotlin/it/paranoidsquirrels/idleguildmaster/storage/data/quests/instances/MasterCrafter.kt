package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class MasterCrafter : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (difficulty - 1).toLong()
    }

    override fun configure() {
        idName = R.string.quest_master_crafter_name
        idDescription = R.string.quest_master_crafter_description
        defaultRarity = 1
        minimumDifficulty = 2
    }

    override fun realignStaticReference() {
        QuestsManager.masterCrafter = this
    }
}
