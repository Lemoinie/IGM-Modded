package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class HeavyArmor : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = (Math.pow(1.7, (difficulty - 1).toDouble()) * 500.0).toLong()
    }

    override fun configure() {
        idName = R.string.quest_heavy_armor_name
        idDescription = R.string.quest_heavy_armor_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.heavyArmor = this
    }
}
