package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBuyFromMerchantBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import java.util.function.BooleanSupplier

class DialogBuyFromMerchant : CustomDialog() {
    @JvmField
    var binding: DialogBuyFromMerchantBinding? = null
    @JvmField
    var callback: BooleanSupplier? = null
    @JvmField
    var offer: MerchantOffer? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogBuyFromMerchantBinding
    }

    override fun getTitle(): String = getString(R.string.merchant_dialog_confirm_buy_title)

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogBuyFromMerchantBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val off = offer ?: return
        val b = binding ?: return
        val item = off.item ?: return
        b.confirmText.text = if (item.getStack() > 1) {
            String.format(getString(R.string.merchant_dialog_confirm_buy_multiple_body), item.getStack(), getString(item.getIdName()))
        } else {
            String.format(getString(R.string.merchant_dialog_confirm_buy_single_body), getString(item.getIdName()))
        }
        b.containerMoney.visibility = if (off.isGems) 8 else 0
        b.containerGems.visibility = if (off.isGems) 0 else 8
        b.shop.visibility = 8
        if (off.isGems) {
            b.amountGems.text = off.price.toString()
        } else {
            UIUtils.populateMoneyContainer(b.amountMoney, off.price, true)
        }
        context?.let { ctx ->
            b.error.setTextColor(resources.getColor(UIUtils.getFailureColor(), ctx.theme))
        }
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.cancel.setOnClickListener {
            dismiss()
        }
        b.priceContainer.setOnClickListener {
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

    fun writeError(str: String) {
        binding?.error?.text = str
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogBuyFromMerchant = this
    }

    override fun onStop() {
        MainActivity.shownDialogBuyFromMerchant = null
        super.onStop()
    }
}
