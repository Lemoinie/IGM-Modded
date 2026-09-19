package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogShelterBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import java.util.ArrayList

class DialogShelter : CustomDialog() {
    companion object {
        private const val MAX_LEVEL_AUTOFEED = 1
        private const val MAX_LEVEL_EFFECTIVENESS = 5
        private const val MAX_LEVEL_SHELTER = 11
    }

    private var adapter: ArrayAdapter<Pet>? = null
    @JvmField
    var binding: DialogShelterBinding? = null
    private var orderedPets: MutableList<Pet> = ArrayList()
    private var upgradeConfirm: AlertDialog? = null
    private var help: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogShelterBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_shelter_name)

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogShelterBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        orderedPets = ArrayList(MainActivity.data.pets)
        orderedPets.sortWith(Utils.petsComparator)

        val shelterPrice = Formulas.getShelterPrice()
        UIUtils.populateMoneyContainer(b.money, shelterPrice, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= shelterPrice)
        b.description.text = String.format(
            getString(R.string.headquarters_shelter_description_long),
            MainActivity.data.pets.size,
            Formulas.shelterCapacity()
        ) + "\n" + String.format(
            getString(R.string.headquarters_shelter_description_feed_effectiveness),
            Formulas.getShelterEffectivenessPercent()
        )
        b.buttonUpgradeCapacity.visibility = if (MainActivity.data.levelShelter >= MAX_LEVEL_SHELTER) 8 else 0

        val shelterAutofeedEnabled = MainActivity.data.levelShelterAutofeed >= 1
        if (shelterAutofeedEnabled) {
            // Right-hand button becomes "Effectiveness +10%" and is hidden at max.
            val effectivenessPrice = Formulas.getShelterEffectivenessPrice()
            UIUtils.populateMoneyContainer(b.moneyAutofeed, effectivenessPrice, true)
            UIUtils.changeMoneyContainerColor(b.moneyAutofeed, MainActivity.data.money >= effectivenessPrice)
            b.upgradeAutofeedDescription.setText(R.string.headquarters_shelter_upgrade_effectiveness)
            b.buttonUpgradeAutofeed.visibility = if (MainActivity.data.levelShelterEffectiveness >= MAX_LEVEL_EFFECTIVENESS) 8 else 0
            val effectivenessPercent = Formulas.getShelterEffectivenessPercent()
            b.descriptionAutofeed.text = if (effectivenessPercent > 0) {
                getString(R.string.headquarters_shelter_description_autofeed) + "\n" +
                    String.format(getString(R.string.headquarters_shelter_description_effectiveness), effectivenessPercent)
            } else {
                getString(R.string.headquarters_shelter_description_autofeed)
            }
            b.descriptionAutofeed.visibility = 0
        } else {
            val shelterAutofeedPrice = Formulas.getShelterAutofeedPrice()
            UIUtils.populateMoneyContainer(b.moneyAutofeed, shelterAutofeedPrice, true)
            UIUtils.changeMoneyContainerColor(b.moneyAutofeed, MainActivity.data.money >= shelterAutofeedPrice)
            b.upgradeAutofeedDescription.setText(R.string.headquarters_shelter_upgrade_autofeed)
            b.descriptionAutofeed.visibility = if (MainActivity.data.levelShelterAutofeed > 0) 0 else 4
            b.buttonUpgradeAutofeed.visibility = if (MainActivity.data.levelShelterAutofeed >= MAX_LEVEL_AUTOFEED) 8 else 0
        }

        adapter = UIUtils.getPetsGridAdapter(context, orderedPets)
        b.petsGrid.adapter = adapter as ListAdapter

        val isEmpty = MainActivity.data.pets.isEmpty()
        b.emptyPets.visibility = if (isEmpty) 0 else 8
        b.petsGrid.visibility = if (isEmpty) 4 else 0
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgradeCapacity.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                upgradeShelter()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_shelter_upgrade_space) { _, _ ->
                    upgradeShelter()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }
        b.buttonUpgradeAutofeed.setOnClickListener {
            val effectiveness = MainActivity.data.levelShelterAutofeed >= 1
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                if (effectiveness) upgradeShelterEffectiveness() else upgradeShelterAutofeed()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val confirmTitle = if (effectiveness) R.string.headquarters_shelter_upgrade_effectiveness_confirm else R.string.headquarters_shelter_upgrade_autofeed
                val dialog = UIUtils.askConfirmUpgrade(context, confirmTitle) { _, _ ->
                    if (effectiveness) upgradeShelterEffectiveness() else upgradeShelterAutofeed()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener { upgradeConfirm = null }
                dialog.show()
            }
        }
        b.petsGrid.setOnItemClickListener { _, _, position, _ ->
            if (MainActivity.shownDialogPetDetail != null) return@setOnItemClickListener
            val dialog = DialogPetDetail()
            MainActivity.shownDialogPetDetail = dialog
            dialog.pet = orderedPets[position]
            dialog.show(parentFragmentManager, "pet_detail")
        }
        b.petsGrid.setOnItemLongClickListener { _, _, position, _ ->
            if (MainActivity.data.levelShelterAutofeed == 0) {
                return@setOnItemLongClickListener true
            }
            val pet = orderedPets[position]
            UIUtils.vibrate(context)
            pet.setFavourite(!pet.isFavourite())
            orderedPets.sortWith(Utils.petsComparator)
            // Recreate the adapter after re-sorting: UIUtils.getPetsGridAdapter copies the
            // list, so notifyDataSetChanged on the OLD adapter rebinds its stale pre-sort
            // order and positions drift (long-pressing pet N marks a different pet).
            adapter = UIUtils.getPetsGridAdapter(context, orderedPets)
            b.petsGrid.adapter = adapter as ListAdapter
            true
        }
        b.help.setOnClickListener {
            if (help != null) return@setOnClickListener
            val dialog = UIUtils.getInfoDialog(context, R.string.headquarters_shelter_name, getString(R.string.headquarters_shelter_help), false)
            help = dialog
            dialog.setOnDismissListener { help = null }
            dialog.show()
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    private fun upgradeShelter() {
        val shelterPrice = Formulas.getShelterPrice()
        if (MainActivity.data.money >= shelterPrice) {
            MainActivity.data.money -= shelterPrice
            MainActivity.data.levelShelter += 1
            initialize(null)
            (activity as? MainActivity)?.refresh()
            MainActivity.headquartersFragment?.refresh()
        }
    }

    private fun upgradeShelterAutofeed() {
        val shelterAutofeedPrice = Formulas.getShelterAutofeedPrice()
        if (MainActivity.data.money >= shelterAutofeedPrice) {
            MainActivity.data.money -= shelterAutofeedPrice
            MainActivity.data.levelShelterAutofeed += 1
            initialize(null)
            (activity as? MainActivity)?.refresh()
        }
    }

    private fun upgradeShelterEffectiveness() {
        if (MainActivity.data.levelShelterEffectiveness >= MAX_LEVEL_EFFECTIVENESS) return
        val effectivenessPrice = Formulas.getShelterEffectivenessPrice()
        if (MainActivity.data.money >= effectivenessPrice) {
            MainActivity.data.money -= effectivenessPrice
            MainActivity.data.levelShelterEffectiveness += 1
            initialize(null)
            (activity as? MainActivity)?.refresh()
            MainActivity.headquartersFragment?.refresh()
        }
    }

    fun refresh() {
        initialize(null)
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogShelter = this
    }

    override fun onStop() {
        MainActivity.shownDialogShelter = null
        super.onStop()
    }
}
