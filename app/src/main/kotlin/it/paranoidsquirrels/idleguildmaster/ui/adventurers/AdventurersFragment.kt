package it.paranoidsquirrels.idleguildmaster.ui.adventurers

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentAdventurersBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment
import kotlin.system.exitProcess

class AdventurersFragment : Fragment() {
    private var _binding: FragmentAdventurersBinding? = null
    val binding get() = _binding!!


    private var dismissDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val b = FragmentAdventurersBinding.inflate(inflater, container, false)
        _binding = b
        binding.slider.post {
            try {
                binding.imageArrow.tag = "compressed"
                binding.imageArrow.setImageDrawable(
                    ResourcesCompat.getDrawable(resources, R.drawable.menu_lift, requireContext().theme)
                )
                binding.slider.y = binding.menuCommands.height.toFloat()
            } catch (_: Exception) {
                activity?.finish()
                exitProcess(0)
            }
        }
        attachListeners()
        refresh()
        return b.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainActivity.adventurersFragment = this
    }

    fun refresh() {
        binding.adventurersList.removeAllViews()
        for (next in MainActivity.data.adventurers) {
            val itemBinding = LayoutAdventurerBinding.inflate(layoutInflater, binding.adventurersList, false)
            if (next.isAscended()) {
                UIUtils.applyAscendedPalette(itemBinding)
            }
            itemBinding.image.setImageDrawable(
                ResourcesCompat.getDrawable(resources, next.imageId, requireContext().theme)
            )
            itemBinding.name.text = getString(next.idName)
            itemBinding.level.text = next.level.toString()
            itemBinding.level.setTextColor(
                if (next.level >= next.maxLevel)
                    resources.getColor(R.color.brass_border, requireContext().theme)
                else
                    itemBinding.level.textColors.defaultColor
            )
            val doc = next.doctrine
            itemBinding.cardView.visibility = if (doc?.trueClass == "EmptyDoctrine") View.GONE else View.VISIBLE
            itemBinding.expendableDoctrinePoints.visibility = if (next.getDoctrinePoints() <= 0) View.GONE else View.VISIBLE
            if (doc != null) {
                itemBinding.doctrine.setImageDrawable(
                    ResourcesCompat.getDrawable(resources, doc.idImage, requireContext().theme)
                )
            }
            itemBinding.traits.text = UIUtils.traitsToShortString(next, resources)
            itemBinding.weapon.setImageDrawable(Utils.getEquipmentDrawable(next.weapon, requireContext()))
            itemBinding.weapon.setOnClickListener { detailEquipmentListener(next, "weapon") }
            itemBinding.armor.setImageDrawable(Utils.getEquipmentDrawable(next.armor, requireContext()))
            itemBinding.armor.setOnClickListener { detailEquipmentListener(next, "armor") }
            itemBinding.accessory.setImageDrawable(Utils.getEquipmentDrawable(next.accessory, requireContext()))
            itemBinding.accessory.setOnClickListener { detailEquipmentListener(next, "accessory") }
            itemBinding.arrowUp.setOnClickListener { moveAdventurer(next, true) }
            itemBinding.arrowDown.setOnClickListener { moveAdventurer(next, false) }
            itemBinding.delete.setOnClickListener { dismissAdventurer(next) }
            itemBinding.root.setOnClickListener {
                UIUtils.getAdventurerDetailDialog(parentFragmentManager, next, true, false)
            }
            binding.adventurersList.addView(itemBinding.root)
        }
        switchMode(0)
    }

    private fun detailEquipmentListener(adventurer: Adventurer, type: String) {
        if (MainActivity.shownDialogSelectEquipment != null) {
            return
        }
        val dialog = DialogSelectEquipment()
        dialog.type = type
        dialog.adventurer = adventurer
        dialog.show(parentFragmentManager, "select_equipment")
    }

    fun attachListeners() {
        binding.menuArrow.setOnClickListener {
            val isExpanded = binding.imageArrow.tag == "expanded"
            binding.imageArrow.tag = if (isExpanded) "compressed" else "expanded"
            binding.imageArrow.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    if (isExpanded) R.drawable.menu_lift else R.drawable.menu_drop,
                    requireContext().theme
                )
            )
            binding.slider.animate().y(if (isExpanded) binding.menuCommands.height.toFloat() else 0.0f).start()
        }
        binding.order.setOnClickListener { switchMode(1) }
        binding.dismiss.setOnClickListener { switchMode(2) }
        binding.done.setOnClickListener { switchMode(0) }
    }

    fun switchMode(mode: Int) {
        binding.order.visibility = if (mode == 0) View.VISIBLE else View.INVISIBLE
        binding.dismiss.visibility = if (mode == 0) View.VISIBLE else View.INVISIBLE
        binding.done.visibility = if (mode == 0) View.INVISIBLE else View.VISIBLE
        val childCount = binding.adventurersList.childCount
        for (i in 0 until childCount) {
            val childAt = binding.adventurersList.getChildAt(i)
            childAt.findViewWithTag<View>("weapon")?.visibility = if (mode == 0) View.VISIBLE else View.INVISIBLE
            childAt.findViewWithTag<View>("armor")?.visibility = if (mode == 0) View.VISIBLE else View.INVISIBLE
            childAt.findViewWithTag<View>("accessory")?.visibility = if (mode == 0) View.VISIBLE else View.INVISIBLE
            childAt.findViewWithTag<View>("arrow_up")?.visibility = if (mode == 1 && i != 0) View.VISIBLE else View.INVISIBLE
            childAt.findViewWithTag<View>("arrow_down")?.visibility = if (mode == 1 && i != childCount - 1) View.VISIBLE else View.INVISIBLE
            childAt.findViewWithTag<View>("dismiss")?.visibility = if (mode == 2) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun moveAdventurer(adventurer: Adventurer, up: Boolean) {
        val index = MainActivity.data.adventurers.indexOf(adventurer)
        MainActivity.data.adventurers.remove(adventurer)
        val newIndex = index + if (up) -1 else 1
        MainActivity.data.adventurers.add(newIndex, adventurer)
        val childAt = binding.adventurersList.getChildAt(index)
        binding.adventurersList.removeViewAt(index)
        binding.adventurersList.addView(childAt, newIndex)
        binding.adventurersList.getChildAt(0)?.findViewWithTag<View>("arrow_up")?.visibility = View.INVISIBLE
        binding.adventurersList.getChildAt(1)?.findViewWithTag<View>("arrow_up")?.visibility = View.VISIBLE
        val last = binding.adventurersList.childCount - 1
        binding.adventurersList.getChildAt(last)?.findViewWithTag<View>("arrow_down")?.visibility = View.INVISIBLE
        binding.adventurersList.getChildAt(last - 1)?.findViewWithTag<View>("arrow_down")?.visibility = View.VISIBLE
    }

    private fun dismissAdventurer(adventurer: Adventurer) {
        if (dismissDialog != null) {
            return
        }
        val savedAreas = ArrayList<Area>()
        var foundArea: Area? = null
        for (area in Utils.compileDungeonRaidList()) {
            if (foundArea == null && area.adventurersExploringIds.contains(Integer.valueOf(adventurer.id))) {
                foundArea = area
            }
            if (area.savedAdventurersIds.contains(Integer.valueOf(adventurer.id))) {
                savedAreas.add(area)
            }
        }
        var body = String.format(getString(R.string.dismiss_dialog_body), getString(adventurer.idName))
        if (foundArea != null) {
            body = body + "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon), getString(foundArea.getName()))
        }
        val dialog = UIUtils.getActionDialog(
            context,
            R.string.dismiss_dialog_title,
            body,
            R.string.yes
        ) { _, _ ->
            onConfirmDismiss(adventurer, foundArea, savedAreas)
        }
        dismissDialog = dialog
        dialog.setOnDismissListener {
            dismissDialog = null
        }
        dialog.show()
    }

    private fun onConfirmDismiss(adventurer: Adventurer, area: Area?, savedAreas: List<Area>) {
        val defaultWeapon = Utils.getDefaultWeapon(adventurer.weaponType)
        val hasDefaultWeapon = adventurer.weapon == defaultWeapon
        var extraItems = 0
        val weapon = adventurer.weapon
        if (!hasDefaultWeapon && weapon != null && !MainActivity.data.items.contains(weapon)) {
            extraItems++
        }
        val armor = adventurer.armor
        if (armor != null && !MainActivity.data.items.contains(armor)) {
            extraItems++
        }
        val accessory = adventurer.accessory
        if (accessory != null && !MainActivity.data.items.contains(accessory)) {
            extraItems++
        }
        val requiredSpace = MainActivity.data.items.size + extraItems
        val storageSpaces = Formulas.storageSpaces()
        if (requiredSpace > storageSpaces) {
            if (MainActivity.shownDialogFullStorage != null) {
                return
            }
            val dialog = UIUtils.getInfoDialog(
                context,
                R.string.no_storage_space_title,
                String.format(getString(R.string.no_storage_space_body_dismiss), requiredSpace - storageSpaces),
                false
            )
            MainActivity.shownDialogFullStorage = dialog
            dialog.setOnDismissListener {
                MainActivity.shownDialogFullStorage = null
            }
            dialog.show()
            return
        }
        if (area != null) {
            area.terminationRequested = true
        }
        for (savedArea in savedAreas) {
            savedArea.savedAdventurersIds.remove(Integer.valueOf(adventurer.id))
        }
        val idx = MainActivity.data.adventurers.indexOf(adventurer)
        MainActivity.data.adventurers.remove(adventurer)
        binding.adventurersList.removeViewAt(idx)
        if (!hasDefaultWeapon && adventurer.weapon != null) {
            Utils.collectItem(adventurer.weapon!!, MainActivity.data.items)
            adventurer.weapon = defaultWeapon
        }
        adventurer.armor?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.armor = null
        }
        adventurer.accessory?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.accessory = null
        }
        adventurer.timeWhenDismissed = TrueTimeUtils.millis()
        MainActivity.data.dismissedAdventurers.add(0, adventurer)
        MainActivity.headquartersFragment?.refresh()
        dismissDialog?.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        val mainActivity = activity as? MainActivity ?: return
        mainActivity.binding.navView.selectedItemId = R.id.navigation_adventurers
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_adventurers)
    }
}
