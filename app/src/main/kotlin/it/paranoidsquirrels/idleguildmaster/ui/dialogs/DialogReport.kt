package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogReportBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap

class DialogReport : CustomDialog() {
    @JvmField
    var binding: DialogReportBinding? = null
    @JvmField
    var recap: AdventureRecap? = null
    @JvmField
    var sourceArea: String? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogReportBinding
    }

    override fun getTitle(): String = String.format(getString(R.string.report_area), sourceArea)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogReportBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val r = recap ?: return
        val b = binding ?: return
        b.durationValue.text = UIUtils.formatSeconds(r.secondsPassed.toLong())
        b.areasClearedValue.text = r.areasCleared.toString()
        b.teamWipedValue.text = r.wiped.toString()
        b.expEarnedValue.text = r.expEarned.toString()
        b.expLostValue.text = r.expLost.toString()
        b.expPerHourValue.text = UIUtils.formatDouble2Decimals(((r.expEarned - r.expLost).toDouble() * 3600.0) / r.secondsPassed.toDouble())
        b.itemGrid.adapter = UIUtils.getEnemyReportGridAdapter(context, r.enemiesKilled)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.itemGrid.setOnItemClickListener { _, _, i, _ ->
            recap?.enemiesKilled?.getOrNull(i)?.let {
                UIUtils.getEnemyDetailDialog(parentFragmentManager, Enemy.getInstance(it.enemy ?: ""))
            }
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogReport = this
    }

    override fun onStop() {
        MainActivity.shownDialogReport = null
        super.onStop()
    }
}
