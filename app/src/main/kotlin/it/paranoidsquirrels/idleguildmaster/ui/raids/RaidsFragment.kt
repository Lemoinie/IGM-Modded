package it.paranoidsquirrels.idleguildmaster.ui.raids

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentRaidsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class RaidsFragment : Fragment() {
    companion object {
        @JvmField
        var TO_REFRESH = true
        @JvmField
        var VISIBLE = false
    }

    private var _binding: FragmentRaidsBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val b = FragmentRaidsBinding.inflate(inflater, container, false)
        _binding = b
        attachListeners()
        refresh()
        Utils.refreshCooldowns(TrueTimeUtils.millis())
        return b.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainActivity.raidsFragment = this
    }

    fun refresh() {
        var hasRaid = false
        var hasEpicRaid = false
        for (area in Utils.compileRaidList()) {
            hasRaid = hasRaid || (area.isUnlocked && area.getAreaType() == 1)
            hasEpicRaid = hasEpicRaid || (area.isUnlocked && area.getAreaType() == 2)
            val layout = area.getLayout()
            layout.dungeonImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, area.getSummaryDrawable(), requireContext().theme)
            )
            layout.dungeonTitle.setText(area.getName())
            layout.root.visibility = if (!area.isUnlocked || area.completed()) View.INVISIBLE else View.VISIBLE
            layout.raidTryAvailable.visibility = View.VISIBLE
            layout.epicRaid.visibility = if (area.getAreaType() == 2) View.VISIBLE else View.GONE
            area.refreshAdventurers()
            area.refreshLoot()
            area.refreshActionDisplayed()
            area.refreshTries()
        }
        showRaidHelpDialog(hasRaid, hasEpicRaid)
    }

    fun refreshRaidVisibility() {
        var hasRaid = false
        var hasEpicRaid = false
        for (area in Utils.compileRaidList()) {
            hasRaid = hasRaid || (area.isUnlocked && area.getAreaType() == 1)
            hasEpicRaid = hasEpicRaid || (area.isUnlocked && area.getAreaType() == 2)
            area.getLayout().root.visibility = if (!area.isUnlocked || area.completed()) View.GONE else View.VISIBLE
        }
        showRaidHelpDialog(hasRaid, hasEpicRaid)
    }

    private fun showRaidHelpDialog(hasRaid: Boolean, hasEpicRaid: Boolean) {
        if (!MainActivity.data.isShownDialogEpicRaid && hasEpicRaid) {
            MainActivity.data.isShownDialogEpicRaid = true
            UIUtils.getInfoDialog(
                context,
                R.string.epic_raids_help_title,
                getString(R.string.epic_raids_help_body),
                false
            ).show()
        }
        if (MainActivity.data.isShownDialogRaid || !hasRaid) {
            return
        }
        MainActivity.data.isShownDialogRaid = true
        UIUtils.getInfoDialog(
            context,
            R.string.raids_help_title,
            getString(R.string.raids_help_body),
            false
        ).show()
    }

    fun attachListeners() {
        for (area in Utils.compileRaidList()) {
            area.getLayout().root.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.getLayout().dungeonAdventurersExploring.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.getLayout().lootImage.setOnClickListener {
                if (MainActivity.shownDialogCollectDrops == null) {
                    Utils.collectDrops(this, area)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        if (TO_REFRESH) {
            refreshRaidVisibility()
        }
        val mainActivity = activity as? MainActivity ?: return
        mainActivity.binding.navView.selectedItemId = R.id.navigation_raids
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_raids)
    }

    override fun onStart() {
        super.onStart()
    }
}
