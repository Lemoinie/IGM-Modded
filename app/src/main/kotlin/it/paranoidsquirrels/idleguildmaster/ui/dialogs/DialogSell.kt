package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Formulas
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSellBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction
import kotlin.math.max

class DialogSell : CustomDialog() {
    private var binding: DialogSellBinding? = null
    var item: Item? = null
    private var maxAmount: Int = 0
    private var slotsAvailable: Boolean = false

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogSellBinding
    }

    override fun getTitle(): String = String.format(getString(R.string.sell_dialog_title), getString(item?.getIdName() ?: 0))

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogSellBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val itm = item ?: return
        val b = binding ?: return
        val index = MainActivity.data.items.indexOf(itm)
        maxAmount = if (index == -1) 0 else MainActivity.data.items[index].getStack()
        item = Item.getInstance(itm.getTrueClass() ?: "", if (MainActivity.data.isSettingSellMaxAmount) maxAmount else 1)
        val curItem = item ?: return
        slotsAvailable = Formulas.marketListings() > (MainActivity.data.marketListings.size + MainActivity.data.soldMarketItems.size)
        context?.let { ctx ->
            b.item.image.setImageDrawable(ResourcesCompat.getDrawable(resources, curItem.getIdImage(), ctx.theme))
        }
        b.item.image.setBackgroundResource(UIUtils.backgroundFromRarity(curItem.getRarity()))
        b.sellPanel.visibility = if (maxAmount <= 0 || !slotsAvailable) 4 else 0
        b.warningNoItems.visibility = if (maxAmount > 0) 8 else 0
        b.warningFullListings.visibility = if (slotsAvailable) 8 else 0
        context?.let { ctx ->
            b.warningNoItems.setTextColor(resources.getColor(UIUtils.getFailureColor(), ctx.theme))
            b.warningFullListings.setTextColor(resources.getColor(UIUtils.getFailureColor(), ctx.theme))
        }
        b.seekBar.max = max(0, maxAmount - 1)
        changeAmount()
    }

    fun changeAmount() {
        val itm = item ?: return
        val b = binding ?: return
        b.seekBar.progress = itm.getStack() - 1
        b.time.text = UIUtils.formatSeconds(Math.round(itm.getSecondsToSell().toDouble()))
        b.number.text = itm.getStack().toString()
        b.item.stack.text = itm.getStack().toString()
        UIUtils.populateMoneyContainer(b.price, itm.getPrice() * itm.getStack().toLong(), false)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.sell.setOnClickListener {
            val itm = item ?: return@setOnClickListener
            if (maxAmount <= 0 || !slotsAvailable) return@setOnClickListener
            val itemAction = ItemAction(itm)
            MainActivity.data.marketListings.add(itemAction)
            Utils.removeItemFromStorage(itm)
            MainActivity.shownDialogItemDetail?.initialize(null)
            MainActivity.shownDialogStorage?.update()
            MainActivity.shownDialogRecipes?.update()
            MainActivity.shownDialogMarket?.addListing(itemAction)
            MainActivity.headquartersFragment?.refresh()
            dismiss()
        }
        b.close.setOnClickListener {
            dismiss()
        }
        b.buttonPlus.setOnClickListener {
            val itm = item ?: return@setOnClickListener
            if (itm.getStack() >= maxAmount) {
                itm.setStack(maxAmount)
                return@setOnClickListener
            }
            itm.setStack(itm.getStack() + 1)
            changeAmount()
        }
        b.buttonMinus.setOnClickListener {
            val itm = item ?: return@setOnClickListener
            if (itm.getStack() <= 1) {
                itm.setStack(1)
                return@setOnClickListener
            }
            itm.setStack(itm.getStack() - 1)
            changeAmount()
        }
        b.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    item?.setStack(progress + 1)
                    changeAmount()
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogSell = this
    }

    override fun onStop() {
        MainActivity.shownDialogSell = null
        super.onStop()
    }
}
