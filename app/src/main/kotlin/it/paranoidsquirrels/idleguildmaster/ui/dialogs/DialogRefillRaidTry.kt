package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRefillRaidTryBinding
import java.util.function.BooleanSupplier

class DialogRefillRaidTry : CustomDialog() {
    @JvmField
    var binding: DialogRefillRaidTryBinding? = null
    @JvmField
    var callback: BooleanSupplier? = null
    @JvmField
    var cost: Int = 0
    @JvmField
    var description: String? = null
    @JvmField
    var title: String? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogRefillRaidTryBinding
    }

    override fun getTitle(): String = title ?: ""

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogRefillRaidTryBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.confirmText.text = description
        b.amountGems.text = cost.toString()
        context?.let { ctx ->
            b.error.setTextColor(resources.getColor(UIUtils.getFailureColor(), ctx.theme))
        }
        b.error.visibility = 8
        b.shop.visibility = 8
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.cancel.setOnClickListener {
            dismiss()
        }
        b.containerGems.setOnClickListener {
            if (callback?.asBoolean == true) {
                dismiss()
            }
        }
        b.shop.setOnClickListener {
            if (MainActivity.shownDialogShop == null) {
                DialogShop().show(parentFragmentManager, "shop")
            }
        }
    }

    fun displayError() {
        binding?.error?.visibility = 0
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogRefillRaidTry = this
    }

    override fun onStop() {
        MainActivity.shownDialogRefillRaidTry = null
        super.onStop()
    }
}
