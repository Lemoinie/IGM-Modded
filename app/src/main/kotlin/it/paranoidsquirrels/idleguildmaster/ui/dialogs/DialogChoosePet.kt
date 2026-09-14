package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChoosePetBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class DialogChoosePet : CustomDialog() {
    private var binding: DialogChoosePetBinding? = null
    @JvmField
    var idlePets: List<Pet>? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChoosePetBinding
    }

    override fun getTitle(): String = getString(R.string.select_pet)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChoosePetBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val pets = Utils.getIdlePets()
        idlePets = pets
        pets.sortWith(Utils.petsComparator)
        binding?.petsGrid?.adapter = UIUtils.getPetsGridAdapter(context, idlePets)
        binding?.noPets?.visibility = if (pets.isEmpty()) 0 else 8
        binding?.petsGrid?.visibility = if (pets.isEmpty()) 4 else 0
    }

    override fun attachListeners() {
        binding?.petsGrid?.setOnItemClickListener { _, _, i, _ ->
            idlePets?.getOrNull(i)?.let { pet ->
                MainActivity.shownDialogSendTeam?.selectedPetId = pet.id
                MainActivity.shownDialogSendTeam?.setupAdventurers()
            }
            dismiss()
        }
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogChoosePet = this
    }

    override fun onStop() {
        MainActivity.shownDialogChoosePet = null
        super.onStop()
    }
}
