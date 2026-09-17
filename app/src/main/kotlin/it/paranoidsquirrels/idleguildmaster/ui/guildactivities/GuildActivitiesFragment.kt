package it.paranoidsquirrels.idleguildmaster.ui.guildactivities

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
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentGuildActivitiesBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

/**
 * 5th bottom-nav tab hosting the Guild Activities: The Hunt (Daily Request) and
 * The Siege (Weekly Siege). Same card layout as the Raids tab (layout_dungeon
 * includes) but sourced from [Utils.compileGuildActivitiesList].
 */
class GuildActivitiesFragment : Fragment() {
    private var _binding: FragmentGuildActivitiesBinding? = null
    val binding: FragmentGuildActivitiesBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val b = FragmentGuildActivitiesBinding.inflate(inflater, container, false)
        _binding = b
        attachListeners()
        refresh()
        return b.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainActivity.guildActivitiesFragment = this
    }

    fun refresh() {
        if (_binding == null) return
        for (area in Utils.compileGuildActivitiesList()) {
            val layout = area.getLayout()
            layout.dungeonImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, area.getSummaryDrawable(), requireContext().theme)
            )
            layout.dungeonTitle.setText(area.getName())
            layout.root.visibility = View.VISIBLE
            layout.epicRaid.visibility = View.GONE
            area.refreshAdventurers()
            area.refreshLoot()
            area.refreshActionDisplayed()
            area.refreshTries()
        }
    }

    fun attachListeners() {
        if (_binding == null) return
        for (area in Utils.compileGuildActivitiesList()) {
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
        refresh()
        Utils.refreshCooldowns(TrueTimeUtils.millis())
        val mainActivity = activity as? MainActivity ?: return
        mainActivity.binding.navView.selectedItemId = R.id.navigation_guild_activities
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_guild_activities)
    }
}