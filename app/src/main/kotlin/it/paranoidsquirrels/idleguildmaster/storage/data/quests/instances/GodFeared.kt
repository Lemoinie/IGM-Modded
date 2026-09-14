package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class GodFeared : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 300L
    }

    override fun configure() {
        idName = R.string.quest_god_feared_name
        idDescription = R.string.quest_god_feared_description
        defaultRarity = 4
        minimumDifficulty = 2
    }

    override fun realignStaticReference() {
        QuestsManager.godFeared = this
    }
}
