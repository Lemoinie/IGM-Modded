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
    val binding get() = _binding!!


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
        for (area in Utils.compileDungeonList()) {
            val layout = area.layout
            layout.dungeonImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, area.summaryDrawable, requireContext().theme)
            )
            layout.dungeonTitle.setText(area.name)
            layout.raidTryAvailable.visibility = View.GONE
            layout.epicRaid.visibility = View.GONE
            area.refreshAdventurers()
            area.refreshLoot()
            area.refreshActionDisplayed()
        }
    }

    fun refreshDungeonVisibility() {
        for (area in Utils.compileDungeonList()) {
            area.layout.root.visibility = if (area.isUnlocked) View.VISIBLE else View.GONE
        }
    }

    fun attachListeners() {
        for (area in Utils.compileDungeonList()) {
            area.layout.root.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.layout.dungeonAdventurersExploring.setOnClickListener {
                UIUtils.clickArea(this, area)
            }
            area.layout.lootImage.setOnClickListener {
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
        val mainActivity = activity as? MainActivity ?: return
        mainActivity.binding.navView.selectedItemId = R.id.navigation_dungeons
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_dungeons)
    }
}
