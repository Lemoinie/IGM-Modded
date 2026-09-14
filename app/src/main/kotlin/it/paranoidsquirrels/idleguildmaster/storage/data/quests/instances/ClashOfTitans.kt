package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class ClashOfTitans : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 9).toLong() * 25) + 50).toLong()
    }

    override fun configure() {
        idName = R.string.quest_clash_of_titans_name
        idDescription = R.string.quest_clash_of_titans_description
        defaultRarity = 2
        minimumDifficulty = 9
    }

    override fun realignStaticReference() {
        QuestsManager.clashOfTitans = this
    }
}
