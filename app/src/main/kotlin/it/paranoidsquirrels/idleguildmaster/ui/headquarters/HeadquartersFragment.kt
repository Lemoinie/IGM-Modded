package it.paranoidsquirrels.idleguildmaster.ui.headquarters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentHeadquartersBinding
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop

class HeadquartersFragment : Fragment() {
    private var _binding: FragmentHeadquartersBinding? = null
    val binding: FragmentHeadquartersBinding? get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val b = FragmentHeadquartersBinding.inflate(inflater, container, false)
        _binding = b
        attachListeners()
        refresh()
        return b.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainActivity.headquartersFragment = this
    }

    fun refresh() {
        val b = _binding ?: return
        val data = MainActivity.data
        b.quartersDescription.text = String.format(
            getString(R.string.headquarters_quarters_description_short),
            data.adventurers.size,
            Formulas.getQuartersCapacity()
        )
        b.tavernDescription.text = String.format(
            getString(R.string.headquarters_tavern_description_short),
            data.tavernGuests.size,
            Formulas.getTavernCapacity()
        )
        val hasUnseenGuest = data.tavernGuests.isNotEmpty() && !data.tavernGuests[0].isSeen()
        b.tavernDot.visibility = if (hasUnseenGuest) View.VISIBLE else View.GONE
        b.tavernNew.visibility = if (hasUnseenGuest) View.VISIBLE else View.GONE

        b.storageDescription.text = String.format(
            getString(R.string.headquarters_storage_description_short),
            data.items.size,
            Formulas.storageSpaces()
        )
        b.shelterDescription.text = String.format(
            getString(R.string.headquarters_shelter_description_short),
            data.pets.size,
            Formulas.shelterCapacity()
        )
        val marketCount = data.soldMarketItems.size + data.marketListings.size
        b.marketDescription.text = if (marketCount == 0) "" else String.format(
            getString(R.string.headquarters_market_description_short),
            data.soldMarketItems.size,
            marketCount
        )
        val workshopCount = data.completedWorkshopItems.size + data.workshopQueue.size
        b.workshopDescription.text = if (workshopCount == 0) "" else String.format(
            getString(R.string.headquarters_workshop_description_short),
            data.completedWorkshopItems.size,
            workshopCount
        )
        b.tavernDescription.setTextColor(
            resources.getColor(
                if (data.isTavernLocked) UIUtils.getFailureColor() else R.color.dim_white,
                requireContext().theme
            )
        )
    }

    fun attachListeners() {
        val b = _binding ?: return
        b.quartersContainer.setOnClickListener {
            if (MainActivity.shownDialogQuarters == null) {
                DialogQuarters().show(parentFragmentManager, "dialog_quarters")
            }
        }
        b.tavernContainer.setOnClickListener {
            if (MainActivity.shownDialogTavern == null) {
                DialogTavern().show(parentFragmentManager, "dialog_tavern")
            }
        }
        b.storageContainer.setOnClickListener {
            if (MainActivity.shownDialogStorage == null) {
                DialogStorage().show(parentFragmentManager, "dialog_storage")
            }
        }
        b.marketContainer.setOnClickListener {
            if (MainActivity.shownDialogMarket == null) {
                DialogMarket().show(parentFragmentManager, "dialog_market")
            }
        }
        b.workshopContainer.setOnClickListener {
            if (MainActivity.shownDialogWorkshop == null) {
                DialogWorkshop().show(parentFragmentManager, "dialog_storage")
            }
        }
        b.shelterContainer.setOnClickListener {
            if (MainActivity.shownDialogShelter == null) {
                DialogShelter().show(parentFragmentManager, "dialog_shelter")
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
        mainActivity.binding.navView.selectedItemId = R.id.navigation_headquarters
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_headquarters)
    }
}
