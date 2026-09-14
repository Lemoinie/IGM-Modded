package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChooseAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer

class DialogChooseAdventurer : CustomDialog() {
    private var binding: DialogChooseAdventurerBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChooseAdventurerBinding
    }

    override fun getTitle(): String = getString(R.string.select_adventurer)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChooseAdventurerBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val positionClicked = arguments?.getInt("positionClicked") ?: 0
        val selectedIds = MainActivity.shownDialogSendTeam?.selectedAdventurersId ?: mutableListOf()
        val idleAdventurers = Utils.getIdleAdventurers(*selectedIds.toTypedArray())
        for (adventurer in idleAdventurers) {
            val itemBinding = LayoutAdventurerBinding.inflate(layoutInflater, b.list, false)
            if (adventurer.isAscended()) {
                UIUtils.applyAscendedPalette(itemBinding)
            }
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, ctx.theme))
                adventurer.doctrine?.let { doc ->
                    itemBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, ctx.theme))
                }
                itemBinding.weapon.setImageDrawable(Utils.getEquipmentDrawable(adventurer.weapon, ctx))
                itemBinding.armor.setImageDrawable(Utils.getEquipmentDrawable(adventurer.armor, ctx))
                itemBinding.accessory.setImageDrawable(Utils.getEquipmentDrawable(adventurer.accessory, ctx))
            }
            itemBinding.name.text = getString(adventurer.idName)
            itemBinding.cardView.visibility = if (adventurer.doctrine?.trueClass == "EmptyDoctrine") 8 else 0
            itemBinding.expendableDoctrinePoints.visibility = 8
            itemBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
            itemBinding.root.setOnClickListener {
                if (positionClicked >= selectedIds.size) {
                    selectedIds.add(selectedIds.size, adventurer.id)
                } else {
                    selectedIds.removeAt(positionClicked)
                    selectedIds.add(positionClicked, adventurer.id)
                }
                MainActivity.shownDialogSendTeam?.setupAdventurers()
                dismiss()
            }
            b.list.addView(itemBinding.root)
        }
        b.scrollView.visibility = if (idleAdventurers.isEmpty()) 8 else 0
        b.noAdventurers.visibility = if (idleAdventurers.isEmpty()) 0 else 8
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogChooseAdventurer = this
    }

    override fun onStop() {
        MainActivity.shownDialogChooseAdventurer = null
        super.onStop()
    }
}
