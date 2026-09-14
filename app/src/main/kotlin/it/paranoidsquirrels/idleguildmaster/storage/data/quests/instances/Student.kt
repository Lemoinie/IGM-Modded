package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class Student : Quest() {
    override fun calculateTargetProgress(difficulty: Int) {
        targetProgress = if (difficulty == 1) 1000L else (Math.pow(1.5, (difficulty - 1).toDouble()) * 5000.0).toLong()
    }

    override fun configure() {
        idName = R.string.quest_student_name
        idDescription = R.string.quest_student_description
        defaultRarity = 1
        minimumDifficulty = 1
    }

    override fun realignStaticReference() {
        QuestsManager.student = this
    }
}
