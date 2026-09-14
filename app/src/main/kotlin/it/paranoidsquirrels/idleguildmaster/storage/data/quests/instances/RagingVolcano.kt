package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class RagingVolcano : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_raging_volcano_name
        idDescription = R.string.quest_raging_volcano_description
        defaultRarity = 4
        minimumDifficulty = 11
    }

    override fun realignStaticReference() {
        QuestsManager.ragingVolcano = this
    }
}
