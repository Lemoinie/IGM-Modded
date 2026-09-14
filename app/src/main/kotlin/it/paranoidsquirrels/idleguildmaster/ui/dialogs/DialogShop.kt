package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.IAPWrapper
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogShopBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon

class DialogShop : CustomDialog() {
    companion object {
        @JvmField
        val imperialVanguard1: Adventurer = Adventurer.getInstance("HolyKnight", -10, 1, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE_PLUS, Trait.BLESSED, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard2: Adventurer = Adventurer.getInstance("WhiteMage", -11, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.EMPATHETIC, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard3: Adventurer = Adventurer.getInstance("RedMage", -12, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.GIFTED, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard4: Adventurer = Adventurer.getInstance("Sureshot", -13, 1, 0, Item.getInstance("TrainingBow") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade1: Adventurer = Adventurer.getInstance("DarkKnight", -20, 1, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade2: Adventurer = Adventurer.getInstance("Necromancer", -21, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.CURSED, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade3: Adventurer = Adventurer.getInstance("Assassin", -22, 1, 0, Item.getInstance("Sickle") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade4: Adventurer = Adventurer.getInstance("PoisonBow", -23, 1, 0, Item.getInstance("TrainingBow") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.ALERT, PotionsDrank(), null, false)!!
    }

    @JvmField
    var binding: DialogShopBinding? = null
    private var shopDisabled: AlertDialog? = null
    private var tooltip: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogShopBinding
    }

    override fun getTitle(): String = getString(R.string.shop_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogShopBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.maxIdleTimeInfo.visibility = 8
        b.maxIdleTimeValue.visibility = 8
        b.maxIdleTimeDescription.visibility = 8

        b.bonusItemTextAdventurerPack.text = String.format(getString(R.string.shop_item_fourfold), getString(R.string.accessory_dreamcatcher_name))
        b.bonusItemTextAdventurerPack2.text = String.format(getString(R.string.shop_item_one), getString(R.string.consumable_evo23_vial_name))

        populateAdventurer(b.imperialVanguardAdventurer1, imperialVanguard1)
        populateAdventurer(b.imperialVanguardAdventurer2, imperialVanguard2)
        populateAdventurer(b.imperialVanguardAdventurer3, imperialVanguard3)
        populateAdventurer(b.imperialVanguardAdventurer4, imperialVanguard4)
        populateAdventurer(b.unholyCrusadeAdventurer1, unholyCrusade1)
        populateAdventurer(b.unholyCrusadeAdventurer2, unholyCrusade2)
        populateAdventurer(b.unholyCrusadeAdventurer3, unholyCrusade3)
        populateAdventurer(b.unholyCrusadeAdventurer4, unholyCrusade4)

        populatePrice(b.gems1Buy, IAPWrapper.ID_250_GEMS)
        populatePrice(b.gems2Buy, IAPWrapper.ID_550_GEMS)
        populatePrice(b.gems3Buy, IAPWrapper.ID_1200_GEMS)
        populatePrice(b.gems4Buy, IAPWrapper.ID_3300_GEMS)
        populatePrice(b.starterPackBuy, IAPWrapper.ID_STARTER_PACK)
        populatePrice(b.adventurerPackPreviousPrice, IAPWrapper.ID_MERCHANT_PACK)
        populatePrice(b.adventurerPackBuy, IAPWrapper.ID_ADVENTURER_PACK)
        populatePrice(b.merchantPackBuy, IAPWrapper.ID_MERCHANT_PACK)
        populatePrice(b.imperialVanguardBuy, IAPWrapper.ID_IMPERIAL_VANGUARD)
        populatePrice(b.unholyCrusadeBuy, IAPWrapper.ID_UNHOLY_CRUSADE)

        b.adventurerPackPreviousPrice.paintFlags = b.adventurerPackPreviousPrice.paintFlags or 16
        refresh()
    }

    private fun populateAdventurer(layoutAdventurerBinding: LayoutAdventurerBinding, adventurer: Adventurer) {
        val theme = context?.theme
        layoutAdventurerBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, theme))
        layoutAdventurerBinding.name.text = getString(adventurer.idName)
        layoutAdventurerBinding.level.visibility = 8
        layoutAdventurerBinding.cardView.visibility = 8
        layoutAdventurerBinding.expendableDoctrinePoints.visibility = 8
        layoutAdventurerBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
        layoutAdventurerBinding.weapon.visibility = 8
        layoutAdventurerBinding.armor.visibility = 8
        layoutAdventurerBinding.accessory.visibility = 8
        layoutAdventurerBinding.arrowUp.visibility = 8
        layoutAdventurerBinding.arrowDown.visibility = 8
        layoutAdventurerBinding.delete.visibility = 8
        layoutAdventurerBinding.root.setOnClickListener {
            UIUtils.getAdventurerDetailDialog(parentFragmentManager, adventurer, false, false)
        }
    }

    private fun populatePrice(textView: TextView, sku: String) {
        val details = MainActivity.IAPWrapper?.getProductDetails(sku) ?: return
        val oneTime = details.oneTimePurchaseOfferDetails ?: return
        textView.text = oneTime.formattedPrice
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.bonusItemImageAdventurerPack.setOnClickListener {
            UIUtils.openItemDetail(Item.getInstance("Dreamcatcher"))
        }
        b.bonusItemImageAdventurerPack2.setOnClickListener {
            UIUtils.openItemDetail(Item.getInstance("Evo23Vial2"))
        }
        b.bonusItemImageImperialVanguard.setOnClickListener {
            UIUtils.openItemDetail(Item.getInstance("Intercession"))
        }
        b.bonusItemImageUnholyCrusade.setOnClickListener {
            UIUtils.openItemDetail(Item.getInstance("Intercession"))
        }
        b.gems1Buy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_250_GEMS) }
        b.gems2Buy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_550_GEMS) }
        b.gems3Buy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_1200_GEMS) }
        b.gems4Buy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_3300_GEMS) }
        b.starterPackBuy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_STARTER_PACK) }
        b.adventurerPackBuy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_ADVENTURER_PACK) }
        b.merchantPackBuy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_MERCHANT_PACK) }
        b.imperialVanguardBuy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_IMPERIAL_VANGUARD) }
        b.unholyCrusadeBuy.setOnClickListener { startPurchaseFlow(IAPWrapper.ID_UNHOLY_CRUSADE) }
        b.maxIdleTimeInfo.setOnClickListener {
            if (tooltip != null) return@setOnClickListener
            val dialog = UIUtils.getInfoDialog(context, R.string.shop_tooltip_title, getString(R.string.shop_tooltip_body), false)!!
            tooltip = dialog
            dialog.setOnDismissListener { tooltip = null }
            dialog.show()
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    private fun startPurchaseFlow(sku: String) {
        val details = MainActivity.IAPWrapper?.getProductDetails(sku) ?: return
        activity?.let { act ->
            MainActivity.IAPWrapper?.purchaseFlow(details, act)
        }
    }

    fun refresh() {
        val b = binding ?: return
        b.starterPackBuy.visibility = if (MainActivity.data.isStarterPackPurchased) 8 else 0
        b.adventurerPackPreviousPrice.visibility = if (MainActivity.data.isAdventurerPackPurchased) 8 else 0
        b.adventurerPackBuy.visibility = if (MainActivity.data.isAdventurerPackPurchased) 8 else 0
        b.merchantPackBuy.visibility = if (MainActivity.data.isMerchantPackPurchased) 8 else 0
        b.imperialVanguardBuy.visibility = if (MainActivity.data.isImperialVanguardPurchased) 8 else 0
        b.unholyCrusadeBuy.visibility = if (MainActivity.data.isUnholyCrusadePurchased) 8 else 0

        b.checkStarterPack.visibility = if (MainActivity.data.isStarterPackPurchased) 0 else 8
        b.checkAdventurerPack.visibility = if (MainActivity.data.isAdventurerPackPurchased) 0 else 8
        b.checkMerchantPack.visibility = if (MainActivity.data.isMerchantPackPurchased) 0 else 8
        b.checkImperialVanguard.visibility = if (MainActivity.data.isImperialVanguardPurchased) 0 else 8
        b.checkUnholyCrusade.visibility = if (MainActivity.data.isUnholyCrusadePurchased) 0 else 8

        b.maxIdleTimeValue.text = (Math.min(4, MainActivity.data.amountOfPurchases) + 8).toString()
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogShop = this
    }

    override fun onStop() {
        MainActivity.shownDialogShop = null
        super.onStop()
    }
}
