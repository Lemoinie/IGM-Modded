package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeEvo23Binding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility

class DialogChangePetAbility : CustomDialog() {
    companion object {
        /** The 16 vanilla pet abilities minus any the pet already possesses (duplicate prevention). */
        @JvmStatic
        fun availableAbilities(pet: Pet?): List<PetAbility> {
            if (pet == null) return emptyList()
            val existingAbilities = setOfNotNull(
                pet.petAbility1,
                pet.petAbility2,
                pet.petAbility3,
                pet.petAbility4
            )
            return PetAbility.values().filter { ability ->
                ability != PetAbility.EMPTY && ability !in existingAbilities
            }
        }

        /** Slot 1 is always unlocked; later slots unlock by level or by the pet's ability count. */
        @JvmStatic
        fun isSlotUnlocked(slot: Int, pet: Pet?): Boolean {
            if (pet == null) return false
            return when (slot) {
                1 -> true
                2 -> pet.level >= 21 || pet.abilityNumber >= 2
                3 -> pet.level >= 41 || pet.abilityNumber >= 3
                else -> pet.level >= 61 || pet.abilityNumber >= 4
            }
        }

        /** Shared Evo-20 core (UI confirmation and unit tests): replaces the slot's ability,
         *  recomputes the pet's abilities and consumes 1x Evo-20 Vial. Returns false when the
         *  slot is locked, the choice is invalid, or no vial is available. */
        @JvmStatic
        fun applyAbilityChange(pet: Pet?, slot: Int, ability: PetAbility): Boolean {
            if (pet == null || ability == PetAbility.EMPTY || !isSlotUnlocked(slot, pet)) return false
            val hasVial = MainActivity.data.items.any { it.getTrueClass() == "Evo20Vial" && it.getStack() > 0 }
            if (!hasVial) return false
            when (slot) {
                1 -> pet.petAbility1 = ability
                2 -> pet.petAbility2 = ability
                3 -> pet.petAbility3 = ability
                else -> pet.petAbility4 = ability
            }
            pet.refreshAbilities()
            Utils.removeItemFromStorage(Item.getInstance("Evo20Vial", 1))
            return true
        }
    }

    @JvmField
    var pet: Pet? = null
    private var binding: DialogConsumeEvo23Binding? = null
    private var selectedSlot = 0
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeEvo23Binding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo20_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumeEvo23Binding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        renderSlots()
    }

    private fun renderSlots() {
        val b = binding ?: return
        val p = pet ?: return
        b.list.removeAllViews()
        for (slot in 1..4) {
            val current = when (slot) {
                1 -> p.petAbility1
                2 -> p.petAbility2
                3 -> p.petAbility3
                else -> p.petAbility4
            }
            val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
            itemBinding.name.text = String.format(
                getString(R.string.dialog_change_pet_ability_slot),
                slot,
                getString(current.nameRes)
            )
            itemBinding.description.text = getString(current.description)
            if (isSlotUnlocked(slot, p)) {
                itemBinding.root.setOnClickListener {
                    selectedSlot = slot
                    renderAbilities()
                }
            } else {
                itemBinding.root.alpha = 0.4f
            }
            b.list.addView(itemBinding.root)
        }
    }

    private fun renderAbilities() {
        val b = binding ?: return
        val p = pet ?: return
        b.list.removeAllViews()
        for (ability in availableAbilities(p)) {
            val itemBinding = LayoutTraitBinding.inflate(layoutInflater, b.list, false)
            itemBinding.name.text = getString(ability.nameRes)
            itemBinding.description.text = getString(ability.description)
            itemBinding.root.setOnClickListener {
                confirmAbilityChange(ability)
            }
            b.list.addView(itemBinding.root)
        }
    }

    private fun confirmAbilityChange(ability: PetAbility) {
        if (confirmDialog != null) return
        val p = pet ?: return
        val message = String.format(
            getString(R.string.dialog_consume_evo20_confirm_body),
            getString(p.idName),
            getString(ability.nameRes)
        )
        val dialog = UIUtils.getActionDialog(
            context,
            R.string.dialog_consume_evo20_title,
            message,
            R.string.yes
        ) { dialogInterface, _ ->
            if (applyAbilityChange(p, selectedSlot, ability)) {
                // Reflect the consumed vial immediately and close the pet select dialog, like Evo-22.
                MainActivity.shownDialogItemDetail?.initialize(null)
                MainActivity.shownDialogStorage?.update()
                MainActivity.headquartersFragment?.refresh()
                MainActivity.shownDialogConsumeEvo20?.dismiss()
                FileManager.saveNow(context)
            }
            dialogInterface.dismiss()
            dismiss()
        }
        confirmDialog = dialog
        dialog.setOnDismissListener { confirmDialog = null }
        dialog.show()
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }
}