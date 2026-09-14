package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class HitOrMiss : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (Math.pow(1.5, (difficulty - 1).toDouble()) * 100.0).toLong()
    }

    override fun configure() {
        idName = R.string.quest_hit_or_miss_name
        idDescription = R.string.quest_hit_or_miss_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.hitOrMiss = this
    }
}
