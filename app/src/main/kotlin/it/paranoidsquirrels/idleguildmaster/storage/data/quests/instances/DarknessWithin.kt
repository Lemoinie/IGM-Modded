package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class DarknessWithin : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 10L
    }

    override fun configure() {
        idName = R.string.quest_darkness_within_name
        idDescription = R.string.quest_darkness_within_description
        defaultRarity = 4
        minimumDifficulty = 8
    }

    override fun realignStaticReference() {
        QuestsManager.darknessWithin = this
    }
}
