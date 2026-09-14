package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Annihilator : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        when (difficulty) {
            2 -> targetProgress = 80L
            3 -> targetProgress = 150L
            4 -> targetProgress = 250L
            5 -> targetProgress = 400L
            6 -> targetProgress = 700L
            7 -> targetProgress = 1000L
            8 -> targetProgress = 1500L
            9 -> targetProgress = 2000L
            10 -> targetProgress = 3000L
            11 -> targetProgress = 5000L
            else -> targetProgress = 30L
        }
    }

    override fun configure() {
        idName = R.string.quest_annihilator_name
        idDescription = R.string.quest_annihilator_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.annihilator = this
    }
}
