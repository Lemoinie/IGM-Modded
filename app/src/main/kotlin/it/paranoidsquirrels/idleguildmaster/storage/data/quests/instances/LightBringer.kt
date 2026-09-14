package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class LightBringer : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty.toLong() * 3) - 3).toLong()
    }

    override fun configure() {
        idName = R.string.quest_light_bringer_name
        idDescription = R.string.quest_light_bringer_description
        defaultRarity = 1
        minimumDifficulty = 3
    }

    override fun realignStaticReference() {
        QuestsManager.lightBringer = this
    }
}
