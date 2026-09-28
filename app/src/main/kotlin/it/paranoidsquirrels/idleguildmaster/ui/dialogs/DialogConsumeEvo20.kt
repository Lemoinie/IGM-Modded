package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChoosePetBinding

class DialogConsumeEvo20 : CustomDialog() {
    private var binding: DialogChoosePetBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChoosePetBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo20_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChoosePetBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        reloadPets()
    }

    fun reloadPets() {
        val pets = MainActivity.data.pets
        binding?.petsGrid?.adapter = UIUtils.getPetsGridAdapter(context, pets)
        binding?.noPets?.visibility = if (pets.isEmpty()) 0 else 8
        binding?.petsGrid?.visibility = if (pets.isEmpty()) 4 else 0
    }

    override fun attachListeners() {
        binding?.petsGrid?.setOnItemClickListener { _, _, i, _ ->
            MainActivity.data.pets.getOrNull(i)?.let { pet ->
                val dialog = DialogChangePetAbility()
                dialog.pet = pet
                dialog.show(parentFragmentManager, "dialog_change_pet_ability")
            }
        }
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogConsumeEvo20 = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumeEvo20 = null
        super.onStop()
    }
}