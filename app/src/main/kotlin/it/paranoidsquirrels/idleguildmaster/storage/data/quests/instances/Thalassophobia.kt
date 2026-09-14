package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Thalassophobia : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_thalassophobia_name
        idDescription = R.string.quest_thalassophobia_description
        defaultRarity = 4
        minimumDifficulty = 6
    }

    override fun realignStaticReference() {
        QuestsManager.thalassophobia = this
    }
}
