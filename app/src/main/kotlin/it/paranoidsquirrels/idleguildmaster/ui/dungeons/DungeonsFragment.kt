package it.paranoidsquirrels.idleguildmaster.ui.dungeons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentDungeonsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class DungeonsFragment : Fragment() {
    private var _binding: FragmentDungeonsBinding? = null
    val binding: FragmentDungeonsBinding? get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val b = FragmentDungeonsBinding.inflate(inflater, container, false)
        _binding = b
        attachListeners()
        refresh()
        return b.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainActivity.dungeonsFragment = this
    }

    fun refresh() {
        if (_binding == null) return
        for (area in Utils.compileDungeonList()) {
            val layout = area.getLayout()
            layout.dungeonImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, area.getSummaryDrawable(), requireContext().theme)
            )
            layout.dungeonTitle.setText(area.getName())
            layout.raidTryAvailable.visibility = View.GONE
            layout.epicRaid.visibility = View.GONE
            area.refreshAdventurers()
            area.refreshLoot()
            area.refreshActionDisplayed()
        }
    }

    fun refreshDungeonVisibility() {
        if (_binding == null) return
        for (area in Utils.compileDungeonList()) {
            area.getLayout().root.visibility = if (area.isUnlocked) View.VISIBLE else View.GONE
        }
    }

    fun attachListeners() {
        if (_binding == null) return
        for (area in Utils.compileDungeonList()) {
            area.getLayout().root.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.getLayout().dungeonAdventurersExploring.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.getLayout().lootImage.setOnClickListener {
                if (MainActivity.shownDialogCollectDrops == null) {
                    if (MainActivity.data.isSettingClaimAllChests) {
                        Utils.collectAllDungeonDrops(this)
                    } else {
                        Utils.collectDrops(this, area)
                    }
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
        val mainActivity = activity as? MainActivity ?: return
        mainActivity.binding.navView.selectedItemId = R.id.navigation_dungeons
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_dungeons)
    }
}
