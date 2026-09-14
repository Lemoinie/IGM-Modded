package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogCollectDropsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap

class DialogCollectDrops : CustomDialog() {
    @JvmField
    var binding: DialogCollectDropsBinding? = null
    @JvmField
    var drops: MutableList<Item>? = null
    @JvmField
    var recap: AdventureRecap? = null
    @JvmField
    var sourceArea: String? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogCollectDropsBinding
    }

    override fun getTitle(): String = String.format(getString(R.string.drops_collected_title), sourceArea)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogCollectDropsBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        drops?.sortWith(compareByDescending { it.getRarity() })
        b.itemGrid.adapter = UIUtils.getItemsGridAdapter(context, drops)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.itemGrid.setOnItemClickListener { _, _, i, _ ->
            drops?.getOrNull(i)?.let { UIUtils.openItemDetail(it) }
        }
        b.itemGrid.setOnItemLongClickListener { _, _, i, _ ->
            drops?.getOrNull(i)?.let { item ->
                UIUtils.vibrate(context)
                val dialogSell = DialogSell()
                dialogSell.item = item
                dialogSell.show(parentFragmentManager, "sell")
            }
            true
        }
        b.report.setOnClickListener {
            if (MainActivity.shownDialogReport != null) return@setOnClickListener
            val dialogReport = DialogReport()
            dialogReport.sourceArea = sourceArea
            dialogReport.recap = recap
            dialogReport.show(parentFragmentManager, "dialog_report")
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogCollectDrops = this
    }

    override fun onStop() {
        MainActivity.shownDialogCollectDrops = null
        super.onStop()
    }
}
