package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class EldritchHorror : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = 5L
    }

    override fun configure() {
        idName = R.string.quest_eldritch_horror_name
        idDescription = R.string.quest_eldritch_horror_description
        defaultRarity = 2
        minimumDifficulty = 9
    }

    override fun realignStaticReference() {
        QuestsManager.eldritchHorror = this
    }
}
