package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class FromHell : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (((difficulty - 10).toLong() * 5) + 15).toLong()
    }

    override fun configure() {
        idName = R.string.quest_from_hell_name
        idDescription = R.string.quest_from_hell_description
        defaultRarity = 2
        minimumDifficulty = 10
    }

    override fun realignStaticReference() {
        QuestsManager.fromHell = this
    }
}
