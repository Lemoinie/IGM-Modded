package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class CrystalClear : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = ((difficulty - 4).toLong() * 25).toLong()
    }

    override fun configure() {
        idName = R.string.quest_crystal_clear_name
        idDescription = R.string.quest_crystal_clear_description
        defaultRarity = 3
        minimumDifficulty = 5
    }

    override fun realignStaticReference() {
        QuestsManager.crystalClear = this
    }
}
