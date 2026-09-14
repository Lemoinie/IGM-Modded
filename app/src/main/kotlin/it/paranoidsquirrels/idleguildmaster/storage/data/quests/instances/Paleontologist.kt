package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Paleontologist : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 10L
    }

    override fun configure() {
        idName = R.string.quest_paleontologist_name
        idDescription = R.string.quest_paleontologist_description
        defaultRarity = 1
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.paleontologist = this
    }
}
