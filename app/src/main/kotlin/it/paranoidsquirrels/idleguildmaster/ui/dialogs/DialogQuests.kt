package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogQuestsBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutQuestBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import java.util.HashMap

class DialogQuests : CustomDialog() {
    @JvmField
    var binding: DialogQuestsBinding? = null
    private var completedInThisInstance = 0
    private val updateList: MutableMap<ProgressBar, Quest> = HashMap()

    private fun rewardFromRarity(rarity: Int, isKings: Boolean): Int {
        return when (rarity) {
            1 -> if (isKings) 10 else 1
            2 -> if (isKings) 20 else 2
            3 -> if (isKings) 40 else 3
            4 -> if (isKings) 100 else 5
            else -> 1
        }
    }

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogQuestsBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_quests_title)

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogQuestsBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        refreshLpInfo()
        updateList.clear()

        setupQuests(b.containerKingsQuests, b.kingsQuestsList, MainActivity.data.kingsQuests)
        setupQuests(b.containerAfflictionQuests, b.afflictionQuestsList, MainActivity.data.afflictionQuests)
        setupQuests(b.containerControlQuests, b.controlQuestsList, MainActivity.data.controlQuests)
        setupQuests(b.containerFortitudeQuests, b.fortitudeQuestsList, MainActivity.data.fortitudeQuests)
        setupQuests(b.containerGraceQuests, b.graceQuestsList, MainActivity.data.graceQuests)
        setupQuests(b.containerIllusionQuests, b.illusionQuestsList, MainActivity.data.illusionQuests)
        setupQuests(b.containerKnowledgeQuests, b.knowledgeQuestsList, MainActivity.data.knowledgeQuests)
        setupQuests(b.containerRuinQuests, b.ruinQuestsList, MainActivity.data.ruinQuests)
        setupQuests(b.containerWarQuests, b.warQuestsList, MainActivity.data.warQuests)

        b.scrollView.visibility = if (updateList.isEmpty()) 8 else 0
        b.noQuestsMessage.visibility = if (updateList.isEmpty()) 0 else 8
        b.refresh.visibility = if (MainActivity.data.isQuestsRefreshed) 8 else 0
    }

    private fun refreshLpInfo() {
        val b = binding ?: return
        setupLpInfo(b.afflictionLpBonus, b.afflictionProgress, MainActivity.data.afflictionLevel, MainActivity.data.afflictionProgress)
        setupLpInfo(b.controlLpBonus, b.controlProgress, MainActivity.data.controlLevel, MainActivity.data.controlProgress)
        setupLpInfo(b.fortitudeLpBonus, b.fortitudeProgress, MainActivity.data.fortitudeLevel, MainActivity.data.fortitudeProgress)
        setupLpInfo(b.graceLpBonus, b.graceProgress, MainActivity.data.graceLevel, MainActivity.data.graceProgress)
        setupLpInfo(b.illusionLpBonus, b.illusionProgress, MainActivity.data.illusionLevel, MainActivity.data.illusionProgress)
        setupLpInfo(b.knowledgeLpBonus, b.knowledgeProgress, MainActivity.data.knowledgeLevel, MainActivity.data.knowledgeProgress)
        setupLpInfo(b.ruinLpBonus, b.ruinProgress, MainActivity.data.ruinLevel, MainActivity.data.ruinProgress)
        setupLpInfo(b.warLpBonus, b.warProgress, MainActivity.data.warLevel, MainActivity.data.warProgress)
    }

    private fun setupLpInfo(bonusText: TextView, progressText: TextView, level: Int, progress: Int) {
        bonusText.text = if (level == 0) "" else String.format(getString(R.string.dialog_quests_lp_formatted), level)
        progressText.text = String.format(getString(R.string.dialog_quests_progress_formatted), Formulas.totalStarsToNextLp(level) - progress)
        if (level >= 10) {
            val theme = context?.theme
            val ascendedColor = resources.getColor(R.color.ascended_unit, theme)
            bonusText.setTextColor(ascendedColor)
            progressText.setTextColor(ascendedColor)
            progressText.setText(R.string.max)
        }
    }

    private fun setupQuests(constraintLayout: ConstraintLayout, linearLayout: LinearLayout, list: MutableList<Quest>) {
        val isKings = constraintLayout == binding?.containerKingsQuests
        val hasQuests = list.size > 0
        constraintLayout.visibility = if (hasQuests) 0 else 8
        linearLayout.visibility = if (hasQuests) 0 else 8
        linearLayout.removeAllViews()

        for (quest in list) {
            val itemBinding = LayoutQuestBinding.inflate(layoutInflater, linearLayout, false)
            updateList[itemBinding.questProgress] = quest
            itemBinding.questName.text = getString(quest.getIdName())
            itemBinding.questDescription.text = String.format(getString(quest.getIdDescription()), quest.getTargetProgress())
            itemBinding.questProgress.progress = Math.round(Math.min(1.0f, (quest.getProgress().toFloat() / quest.getTargetProgress().toFloat())) * 100.0f)

            val reward = rewardFromRarity(quest.getRarity(), isKings)
            itemBinding.questReward.text = if (isKings) String.format(getString(R.string.dialog_quests_gems_formatted), reward) else formatStars(reward, false)
            itemBinding.questRewardClickableText.text = if (isKings) String.format(getString(R.string.dialog_quests_gems_formatted), reward) else formatStars(reward, true)
            itemBinding.questRewardClickableGems.visibility = if (isKings) 0 else 8

            val isComplete = quest.getProgress() >= quest.getTargetProgress()
            itemBinding.questRewardClickable.visibility = if (isComplete) 0 else 8
            itemBinding.questReward.visibility = if (isComplete) 8 else 0
            itemBinding.questRewardGems.visibility = if (!isKings || isComplete) 8 else 0

            itemBinding.questRewardClickable.setOnClickListener {
                if (isKings) {
                    MainActivity.data.gems += reward.toLong()
                    (MainActivity.dungeonsFragment?.activity as? MainActivity)?.refreshGems()
                } else if (list === MainActivity.data.afflictionQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.afflictionLevel) - MainActivity.data.afflictionProgress
                    if (remaining <= reward) {
                        MainActivity.data.afflictionLevel += 1
                        MainActivity.data.afflictionProgress = reward - remaining
                    } else {
                        MainActivity.data.afflictionProgress += reward
                    }
                } else if (list === MainActivity.data.controlQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.controlLevel) - MainActivity.data.controlProgress
                    if (remaining <= reward) {
                        MainActivity.data.controlLevel += 1
                        MainActivity.data.controlProgress = reward - remaining
                    } else {
                        MainActivity.data.controlProgress += reward
                    }
                } else if (list === MainActivity.data.fortitudeQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.fortitudeLevel) - MainActivity.data.fortitudeProgress
                    if (remaining <= reward) {
                        MainActivity.data.fortitudeLevel += 1
                        MainActivity.data.fortitudeProgress = reward - remaining
                    } else {
                        MainActivity.data.fortitudeProgress += reward
                    }
                } else if (list === MainActivity.data.graceQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.graceLevel) - MainActivity.data.graceProgress
                    if (remaining <= reward) {
                        MainActivity.data.graceLevel += 1
                        MainActivity.data.graceProgress = reward - remaining
                    } else {
                        MainActivity.data.graceProgress += reward
                    }
                } else if (list === MainActivity.data.illusionQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.illusionLevel) - MainActivity.data.illusionProgress
                    if (remaining <= reward) {
                        MainActivity.data.illusionLevel += 1
                        MainActivity.data.illusionProgress = reward - remaining
                    } else {
                        MainActivity.data.illusionProgress += reward
                    }
                } else if (list === MainActivity.data.knowledgeQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.knowledgeLevel) - MainActivity.data.knowledgeProgress
                    if (remaining <= reward) {
                        MainActivity.data.knowledgeLevel += 1
                        MainActivity.data.knowledgeProgress = reward - remaining
                    } else {
                        MainActivity.data.knowledgeProgress += reward
                    }
                } else if (list === MainActivity.data.ruinQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.ruinLevel) - MainActivity.data.ruinProgress
                    if (remaining <= reward) {
                        MainActivity.data.ruinLevel += 1
                        MainActivity.data.ruinProgress = reward - remaining
                    } else {
                        MainActivity.data.ruinProgress += reward
                    }
                } else if (list === MainActivity.data.warQuests) {
                    val remaining = Formulas.totalStarsToNextLp(MainActivity.data.warLevel) - MainActivity.data.warProgress
                    if (remaining <= reward) {
                        MainActivity.data.warLevel += 1
                        MainActivity.data.warProgress = reward - remaining
                    } else {
                        MainActivity.data.warProgress += reward
                    }
                }
                linearLayout.removeView(itemBinding.root)
                list.remove(quest)
                updateList.remove(itemBinding.questProgress)
                refreshLpInfo()
                completedInThisInstance++
                if (updateList.isEmpty()) {
                    initialize(null)
                }
                (activity as? MainActivity)?.refreshIcons()
            }
            linearLayout.addView(itemBinding.root)
        }
    }

    private fun formatStars(stars: Int, wrapLines: Boolean): String {
        val sb = StringBuilder()
        for (i in 0 until stars) {
            if (wrapLines && (i == 2 || i == 4)) {
                sb.append("\n")
            }
            sb.append("★")
        }
        return sb.toString()
    }

    fun refreshCooldowns(days: Int, hours: Int, minutes: Int) {
        binding?.newQuestsTime?.text = String.format(getString(R.string.time_days_hours_minutes), days, hours, minutes)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.refresh.setOnClickListener {
            if (MainActivity.shownDialogRefreshQuests == null) {
                val dialog = DialogRefreshQuests()
                MainActivity.shownDialogRefreshQuests = dialog
                dialog.show(parentFragmentManager, "dialog_refresh_quests")
            }
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    fun update() {
        for ((progressBar, quest) in updateList) {
            progressBar.progress = Math.round(Math.min(1.0f, (quest.getProgress().toFloat() / quest.getTargetProgress().toFloat())) * 100.0f)
        }
    }

    fun reInitialize() {
        initialize(null)
    }

    override fun onStart() {
        super.onStart()
        completedInThisInstance = 0
        MainActivity.shownDialogQuests = this
    }

    override fun onResume() {
        super.onResume()
        Utils.refreshCooldowns(TrueTimeUtils.millis())
    }

    override fun onStop() {
        QuestsManager.QUEST_NOTIFICATION = notificationValue()
        (activity as? MainActivity)?.refreshIcons()
        MainActivity.shownDialogQuests = null
        val questsCompleted = MainActivity.data.questsCompleted
        if (questsCompleted < 150 && completedInThisInstance > 0) {
            if (questsCompleted < 25) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_BUSY, completedInThisInstance)
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_WORKAHOLIC, completedInThisInstance)
            MainActivity.data.questsCompleted = Math.min(150, questsCompleted + completedInThisInstance)
        }
        super.onStop()
    }

    private fun notificationValue(): Boolean {
        if (MainActivity.data.kingsQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.afflictionQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.controlQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.fortitudeQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.graceQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.illusionQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.knowledgeQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.ruinQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        if (MainActivity.data.warQuests.any { it.getProgress() >= it.getTargetProgress() }) return true
        return false
    }
}
