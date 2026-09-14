package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogQuartersBinding

class DialogQuarters : CustomDialog() {
    companion object {
        private const val MAX_LEVEL_QUARTERS = 23
    }

    @JvmField
    var binding: DialogQuartersBinding? = null
    private var upgradeConfirm: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogQuartersBinding
    }

    override fun getTitle(): String = getString(R.string.headquarters_quarters_name)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogQuartersBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val quartersPrice = Formulas.getQuartersPrice()
        UIUtils.populateMoneyContainer(b.money, quartersPrice, true)
        UIUtils.changeMoneyContainerColor(b.money, MainActivity.data.money >= quartersPrice)
        b.description.text = String.format(
            getString(R.string.headquarters_quarters_description_long),
            MainActivity.data.adventurers.size,
            Formulas.getQuartersCapacity()
        )
        b.buttonUpgrade.visibility = if (MainActivity.data.levelQuarters >= MAX_LEVEL_QUARTERS) 8 else 0
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.buttonUpgrade.setOnClickListener {
            if (!MainActivity.data.isSettingConfirmUpgrade) {
                upgradeQuarters()
            } else {
                if (upgradeConfirm != null) return@setOnClickListener
                val dialog = UIUtils.askConfirmUpgrade(context, R.string.headquarters_quarters_upgrade) { _, _ ->
                    upgradeQuarters()
                    upgradeConfirm?.dismiss()
                }
                upgradeConfirm = dialog
                dialog.setOnDismissListener {
                    upgradeConfirm = null
                }
                dialog.show()
            }
        }
        b.exit3.setOnClickListener {
            dismiss()
        }
    }

    private fun upgradeQuarters() {
        val quartersPrice = Formulas.getQuartersPrice()
        if (MainActivity.data.money >= quartersPrice) {
            MainActivity.data.money -= quartersPrice
            MainActivity.data.levelQuarters += 1
            initialize(null)
            (activity as? MainActivity)?.refresh()
            MainActivity.headquartersFragment?.refresh()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogQuarters = this
    }

    override fun onStop() {
        MainActivity.shownDialogQuarters = null
        super.onStop()
    }
}
