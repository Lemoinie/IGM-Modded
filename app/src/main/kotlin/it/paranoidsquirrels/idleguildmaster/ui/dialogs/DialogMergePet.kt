package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMergePetBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutPetFeedingBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class DialogMergePet : CustomDialog() {
    private var binding: DialogMergePetBinding? = null
    private var confirmDialog: AlertDialog? = null
    @JvmField
    var selected: Pet? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogMergePetBinding
    }

    override fun getTitle(): String = String.format(getString(R.string.pet_merge_title), getString(selected?.idName ?: 0))

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogMergePetBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val sel = selected ?: return
        val b = binding ?: return
        val foodGiven = Utils.round(sel.calculateTotalFoodGiven().toDouble() * 0.8)
        context?.let { ctx ->
            b.foodSelected.image.setImageDrawable(ResourcesCompat.getDrawable(resources, sel.idImage, ctx.theme))
        }
        b.foodSelected.stack.text = sel.level.toString()
        b.description.text = String.format(getString(R.string.pet_merge_description), foodGiven)
        b.list.removeAllViews()
        val pets = ArrayList(MainActivity.data.pets)
        pets.remove(sel)
        pets.sortWith(Utils.petsComparator)
        for (pet in pets) {
            val itemBinding = LayoutPetFeedingBinding.inflate(layoutInflater, b.list, false)
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, pet.idImage, ctx.theme))
            }
            itemBinding.level.text = pet.level.toString()
            itemBinding.name.text = getString(pet.idName)
            val totalFood = pet.totalFoodToNextLevel()
            itemBinding.detailFood.text = String.format(getString(R.string.min_bar_max), pet.food, totalFood)
            itemBinding.detailFoodBar.progress = ((pet.food * 100) / totalFood)
            itemBinding.confirm.setOnClickListener {
                showConfirmMerge(pet, foodGiven)
            }
            b.list.addView(itemBinding.root)
        }
    }

    private fun showConfirmMerge(pet: Pet, foodGiven: Int) {
        val sel = selected ?: return
        val savedAreas = mutableListOf<Area>()
        var activeArea: Area? = null
        for (area in Utils.compileDungeonRaidList()) {
            if (activeArea == null && area.petExploringId != null && area.petExploringId == sel.id) {
                activeArea = area
            }
            if (area.savedPetId != null && area.savedPetId == sel.id) {
                savedAreas.add(area)
            }
        }
        var msg = String.format(getString(R.string.pet_merge_body), getString(sel.idName), getString(pet.idName))
        if (activeArea != null) {
            msg += "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon_pet), getString(activeArea.name))
        }
        val actionDialog = UIUtils.getActionDialog(
            context,
            R.string.pet_merge,
            msg,
            R.string.yes
        ) { _, _ ->
            MainActivity.data.pets.remove(sel)
            pet.feed(foodGiven)
            for (saved in savedAreas) {
                saved.savedPetId = null
            }
            if (activeArea != null) {
                activeArea.terminationRequested = true
            }
            MainActivity.shownDialogShelter?.refresh()
            MainActivity.headquartersFragment?.refresh()
            MainActivity.shownDialogPetDetail?.dismiss()
            dismiss()
        }
        confirmDialog = actionDialog
        actionDialog.setOnDismissListener {
            confirmDialog = null
        }
        confirmDialog?.show()
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogMergePet = this
    }

    override fun onStop() {
        MainActivity.shownDialogMergePet = null
        super.onStop()
    }
}
