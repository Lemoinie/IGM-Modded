package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogShopBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility

class DialogShop : CustomDialog() {
    companion object {
        // Imperial Vanguard (Tier 4)
        @JvmField
        val imperialVanguard1: Adventurer = Adventurer.getInstance("HolyKnight", -10, 1, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE_PLUS, Trait.BLESSED, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard2: Adventurer = Adventurer.getInstance("WhiteMage", -11, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.EMPATHETIC, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard3: Adventurer = Adventurer.getInstance("RedMage", -12, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.GIFTED, PotionsDrank(), null, false)!!
        @JvmField
        val imperialVanguard4: Adventurer = Adventurer.getInstance("Sureshot", -13, 1, 0, Item.getInstance("TrainingBow") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, PotionsDrank(), null, false)!!

        // Unholy Crusade (Tier 4)
        @JvmField
        val unholyCrusade1: Adventurer = Adventurer.getInstance("DarkKnight", -20, 1, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade2: Adventurer = Adventurer.getInstance("Necromancer", -21, 1, 0, Item.getInstance("Cane") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.CURSED, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade3: Adventurer = Adventurer.getInstance("Assassin", -22, 1, 0, Item.getInstance("Sickle") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, PotionsDrank(), null, false)!!
        @JvmField
        val unholyCrusade4: Adventurer = Adventurer.getInstance("PoisonBow", -23, 1, 0, Item.getInstance("TrainingBow") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.ALERT, PotionsDrank(), null, false)!!

        // Primal Vanguard (Tier 4)
        @JvmField
        val primalVanguard1: Adventurer = Adventurer.getInstance("WolfRider", -30, 1, 0, Item.getInstance("TrainingBow") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.NIMBLE, PotionsDrank(), null, false)!!
        @JvmField
        val primalVanguard2: Adventurer = Adventurer.getInstance("ShadowDancer", -31, 1, 0, Item.getInstance("Sickle") as? Weapon, null, null, Trait.FERAL_PLUS, Trait.NOCTURNAL, PotionsDrank(), null, false)!!
        @JvmField
        val primalVanguard3: Adventurer = Adventurer.getInstance("SilverTongue", -32, 1, 0, Item.getInstance("Sickle") as? Weapon, null, null, Trait.BOOKWORM_PLUS, Trait.EMPATHETIC, PotionsDrank(), null, false)!!
        @JvmField
        val primalVanguard4: Adventurer = Adventurer.getInstance("IronWarden", -33, 1, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE_PLUS, Trait.INTIMIDATING, PotionsDrank(), null, false)!!

        // Senko Pet (Level 50, 5 Traits)
        @JvmField
        val senkoPetPreview: Pet? = Pet.getInstance("Senko", -100, 50, 0, PetAbility.HEALER, PetAbility.REGENERATION, PetAbility.DROPS, PetAbility.EXPERIENCE)
    }

    enum class Category {
        ALL, STARTER, ADVENTURERS, COMPANIONS, MERCHANT, WORKSHOP, STORAGE, UTILITY
    }

    @JvmField
    var binding: DialogShopBinding? = null
    private var tooltip: AlertDialog? = null
    private var selectedCategory: Category = Category.ALL

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

        b.bonusItemTextAdventurerPack.text = String.format(getString(R.string.shop_item_fourfold), getString(R.string.accessory_dreamcatcher_name))
        b.bonusItemTextAdventurerPack2.text = String.format(getString(R.string.shop_item_one), getString(R.string.consumable_evo23_vial_name))

        // Adventurer previews
        populateAdventurer(b.imperialVanguardAdventurer1, imperialVanguard1)
        populateAdventurer(b.imperialVanguardAdventurer2, imperialVanguard2)
        populateAdventurer(b.imperialVanguardAdventurer3, imperialVanguard3)
        populateAdventurer(b.imperialVanguardAdventurer4, imperialVanguard4)

        populateAdventurer(b.unholyCrusadeAdventurer1, unholyCrusade1)
        populateAdventurer(b.unholyCrusadeAdventurer2, unholyCrusade2)
        populateAdventurer(b.unholyCrusadeAdventurer3, unholyCrusade3)
        populateAdventurer(b.unholyCrusadeAdventurer4, unholyCrusade4)

        populateAdventurer(b.primalVanguardAdventurer1, primalVanguard1)
        populateAdventurer(b.primalVanguardAdventurer2, primalVanguard2)
        populateAdventurer(b.primalVanguardAdventurer3, primalVanguard3)
        populateAdventurer(b.primalVanguardAdventurer4, primalVanguard4)

        selectCategory(Category.ALL)
        refresh()
    }

    private fun populateAdventurer(layoutAdventurerBinding: LayoutAdventurerBinding, adventurer: Adventurer) {
        val theme = context?.theme
        layoutAdventurerBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, theme))
        layoutAdventurerBinding.name.text = getString(adventurer.idName)
        layoutAdventurerBinding.level.visibility = View.GONE
        layoutAdventurerBinding.cardView.visibility = View.GONE
        layoutAdventurerBinding.expendableDoctrinePoints.visibility = View.GONE
        layoutAdventurerBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
        layoutAdventurerBinding.weapon.visibility = View.GONE
        layoutAdventurerBinding.armor.visibility = View.GONE
        layoutAdventurerBinding.accessory.visibility = View.GONE
        layoutAdventurerBinding.arrowUp.visibility = View.GONE
        layoutAdventurerBinding.arrowDown.visibility = View.GONE
        layoutAdventurerBinding.delete.visibility = View.GONE
        layoutAdventurerBinding.root.setOnClickListener {
            UIUtils.getAdventurerDetailDialog(parentFragmentManager, adventurer, false, false)
        }
    }

    override fun attachListeners() {
        val b = binding ?: return

        // Category Filter Listeners
        b.chipCategoryAll.setOnClickListener { selectCategory(Category.ALL) }
        b.chipCategoryStarter.setOnClickListener { selectCategory(Category.STARTER) }
        b.chipCategoryAdventurers.setOnClickListener { selectCategory(Category.ADVENTURERS) }
        b.chipCategoryCompanions.setOnClickListener { selectCategory(Category.COMPANIONS) }
        b.chipCategoryMerchant.setOnClickListener { selectCategory(Category.MERCHANT) }
        b.chipCategoryWorkshop.setOnClickListener { selectCategory(Category.WORKSHOP) }
        b.chipCategoryStorage.setOnClickListener { selectCategory(Category.STORAGE) }
        b.chipCategoryUtility.setOnClickListener { selectCategory(Category.UTILITY) }

        // Bonus Item Detail Click Listeners
        b.bonusItemImageAdventurerPack.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Dreamcatcher")) }
        b.bonusItemImageAdventurerPack2.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Evo23Vial2")) }
        b.bonusItemImageImperialVanguard.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.bonusItemImageUnholyCrusade.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.bonusItemImagePrimalVanguard.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.intercessionImageSacred.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }

        // Pet Detail Preview
        b.imageSenkoPet.setOnClickListener {
            if (senkoPetPreview != null && MainActivity.shownDialogPetDetail == null) {
                val dialog = DialogPetDetail()
                MainActivity.shownDialogPetDetail = dialog
                dialog.pet = senkoPetPreview
                dialog.show(parentFragmentManager, "pet_detail")
            }
        }

        // ================= Purchase Click Listeners =================

        // Starter Bundle
        b.starterPackBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_guild_initiate), 500, MainActivity.data.isStarterPackPurchased) {
                MainActivity.data.isStarterPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.adventurerPackBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_explorers_cache), 1000, MainActivity.data.isAdventurerPackPurchased) {
                MainActivity.data.isAdventurerPackPurchased = true
                Utils.collectItem(Item.getInstance("Dreamcatcher", 4), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Adventurer Bundle (5,000 Gems each)
        b.imperialVanguardBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_imperial_vanguard), 5000, MainActivity.data.isImperialVanguardPurchased) {
                MainActivity.data.isImperialVanguardPurchased = true
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                MainActivity.data.adventurers.add(imperialVanguard1)
                MainActivity.data.adventurers.add(imperialVanguard2)
                MainActivity.data.adventurers.add(imperialVanguard3)
                MainActivity.data.adventurers.add(imperialVanguard4)
                MainActivity.data.amountOfPurchases += 1
                Utils.triggerGuildSizeAchievementCheck()
            }
        }

        b.unholyCrusadeBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_unholy_crusade), 5000, MainActivity.data.isUnholyCrusadePurchased) {
                MainActivity.data.isUnholyCrusadePurchased = true
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                MainActivity.data.adventurers.add(unholyCrusade1)
                MainActivity.data.adventurers.add(unholyCrusade2)
                MainActivity.data.adventurers.add(unholyCrusade3)
                MainActivity.data.adventurers.add(unholyCrusade4)
                MainActivity.data.amountOfPurchases += 1
                Utils.triggerGuildSizeAchievementCheck()
            }
        }

        b.primalVanguardBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_primal_vanguard), 5000, MainActivity.data.isPrimalVanguardPurchased) {
                MainActivity.data.isPrimalVanguardPurchased = true
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                MainActivity.data.adventurers.add(primalVanguard1)
                MainActivity.data.adventurers.add(primalVanguard2)
                MainActivity.data.adventurers.add(primalVanguard3)
                MainActivity.data.adventurers.add(primalVanguard4)
                MainActivity.data.amountOfPurchases += 1
                Utils.triggerGuildSizeAchievementCheck()
            }
        }

        // Companion Bundle (2,500 Gems)
        b.senkoPackBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_senko_pack), 2500, MainActivity.data.isSenkoPackPurchased) {
                MainActivity.data.isSenkoPackPurchased = true
                val pet = Pet.getInstance("Senko", -100, 50, 0, PetAbility.HEALER, PetAbility.REGENERATION, PetAbility.DROPS, PetAbility.EXPERIENCE)
                if (pet != null) {
                    MainActivity.data.pets.add(pet)
                }
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Merchant Bundle
        b.apprenticeMerchantBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_apprentice_merchant), 500, MainActivity.data.isApprenticeMerchantPurchased) {
                MainActivity.data.isApprenticeMerchantPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.journeymanMerchantBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_journeyman_merchant), 1000, MainActivity.data.isJourneymanMerchantPurchased) {
                MainActivity.data.isJourneymanMerchantPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.merchantPackBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_grand_merchant), 1000, MainActivity.data.isMerchantPackPurchased) {
                MainActivity.data.isMerchantPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.tradeBaronBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_trade_baron), 1500, MainActivity.data.isTradeBaronPurchased) {
                MainActivity.data.isTradeBaronPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Workshop Bundle
        b.apprenticeWorkshopBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_apprentice_workshop), 500, MainActivity.data.isApprenticeWorkshopPurchased) {
                MainActivity.data.isApprenticeWorkshopPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.journeymanWorkshopBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_journeyman_workshop), 1000, MainActivity.data.isJourneymanWorkshopPurchased) {
                MainActivity.data.isJourneymanWorkshopPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.masterWorkshopBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_master_workshop), 1000, MainActivity.data.isMasterWorkshopPurchased) {
                MainActivity.data.isMasterWorkshopPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.grandmasterWorkshopBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_grandmaster_workshop), 1500, MainActivity.data.isGrandmasterWorkshopPurchased) {
                MainActivity.data.isGrandmasterWorkshopPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Storage Bundle
        b.minorStorageBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_minor_storage), 500, MainActivity.data.isStoragePack35Purchased) {
                MainActivity.data.isStoragePack35Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.expandedStorageBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_expanded_storage), 750, MainActivity.data.isStoragePack50Purchased) {
                MainActivity.data.isStoragePack50Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.grandStorageBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_grand_storage), 1000, MainActivity.data.isStoragePack70Purchased) {
                MainActivity.data.isStoragePack70Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Utility Bundle
        b.deepPocketsBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_deep_pockets), 750, MainActivity.data.isMaxLootPackPurchased) {
                MainActivity.data.isMaxLootPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.extendedVigilBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_extended_vigil), 750, MainActivity.data.isIdleHoursPackPurchased) {
                MainActivity.data.isIdleHoursPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.sacredIntercessionBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_sacred_intercession), 500, false) {
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
            }
        }

        // Max Idle Time Info Tooltip
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

    private fun selectCategory(category: Category) {
        selectedCategory = category
        val b = binding ?: return
        val theme = context?.theme

        fun updateChip(chip: TextView, isSelected: Boolean) {
            chip.background = ResourcesCompat.getDrawable(
                resources,
                if (isSelected) R.drawable.object_border_buy else R.drawable.object_border_dim_white,
                theme
            )
            chip.setTextColor(
                resources.getColor(
                    if (isSelected) R.color.brass_filler else R.color.dim_white,
                    theme
                )
            )
        }

        updateChip(b.chipCategoryAll, category == Category.ALL)
        updateChip(b.chipCategoryStarter, category == Category.STARTER)
        updateChip(b.chipCategoryAdventurers, category == Category.ADVENTURERS)
        updateChip(b.chipCategoryCompanions, category == Category.COMPANIONS)
        updateChip(b.chipCategoryMerchant, category == Category.MERCHANT)
        updateChip(b.chipCategoryWorkshop, category == Category.WORKSHOP)
        updateChip(b.chipCategoryStorage, category == Category.STORAGE)
        updateChip(b.chipCategoryUtility, category == Category.UTILITY)

        b.containerStarterBundle.visibility = if (category == Category.ALL || category == Category.STARTER) View.VISIBLE else View.GONE
        b.containerAdventurerBundle.visibility = if (category == Category.ALL || category == Category.ADVENTURERS) View.VISIBLE else View.GONE
        b.containerCompanionBundle.visibility = if (category == Category.ALL || category == Category.COMPANIONS) View.VISIBLE else View.GONE
        b.containerMerchantBundle.visibility = if (category == Category.ALL || category == Category.MERCHANT) View.VISIBLE else View.GONE
        b.containerWorkshopBundle.visibility = if (category == Category.ALL || category == Category.WORKSHOP) View.VISIBLE else View.GONE
        b.containerStorageBundle.visibility = if (category == Category.ALL || category == Category.STORAGE) View.VISIBLE else View.GONE
        b.containerUtilityBundle.visibility = if (category == Category.ALL || category == Category.UTILITY) View.VISIBLE else View.GONE
    }

    private fun confirmAndPurchase(packName: String, price: Int, isPurchased: Boolean, onPurchase: () -> Unit) {
        if (isPurchased) return
        val ctx = context ?: return

        if (MainActivity.data.gems < price) {
            AlertDialog.Builder(ctx)
                .setTitle(packName)
                .setMessage(R.string.shop_not_enough_gems)
                .setPositiveButton(android.R.string.ok, null)
                .show()
            return
        }

        AlertDialog.Builder(ctx)
            .setTitle(packName)
            .setMessage(String.format(getString(R.string.shop_confirm_purchase), packName, price))
            .setPositiveButton(android.R.string.ok) { _, _ ->
                MainActivity.data.gems -= price
                onPurchase()
                val act = activity as? MainActivity
                act?.let {
                    it.refreshGems()
                    MainActivity.adventurersFragment?.refresh()
                    MainActivity.headquartersFragment?.refresh()
                    it.refreshIcons()
                }
                SaveManager.getInstance().save(ctx)
                refresh()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    fun refresh() {
        val b = binding ?: return

        // Update Current Gems
        b.currentGemsValue.text = MainActivity.data.gems.toString()

        // Helper to update buy button & checkmark visibility
        fun setPurchasedState(buyButton: TextView, checkView: View, isPurchased: Boolean) {
            buyButton.visibility = if (isPurchased) View.GONE else View.VISIBLE
            checkView.visibility = if (isPurchased) View.VISIBLE else View.GONE
        }

        // Starter Bundle
        setPurchasedState(b.starterPackBuy, b.checkStarterPack, MainActivity.data.isStarterPackPurchased)
        setPurchasedState(b.adventurerPackBuy, b.checkAdventurerPack, MainActivity.data.isAdventurerPackPurchased)

        // Adventurer Bundle
        setPurchasedState(b.imperialVanguardBuy, b.checkImperialVanguard, MainActivity.data.isImperialVanguardPurchased)
        setPurchasedState(b.unholyCrusadeBuy, b.checkUnholyCrusade, MainActivity.data.isUnholyCrusadePurchased)
        setPurchasedState(b.primalVanguardBuy, b.checkPrimalVanguard, MainActivity.data.isPrimalVanguardPurchased)

        // Companion Bundle
        setPurchasedState(b.senkoPackBuy, b.checkSenkoPack, MainActivity.data.isSenkoPackPurchased)

        // Merchant Bundle
        setPurchasedState(b.apprenticeMerchantBuy, b.checkApprenticeMerchant, MainActivity.data.isApprenticeMerchantPurchased)
        setPurchasedState(b.journeymanMerchantBuy, b.checkJourneymanMerchant, MainActivity.data.isJourneymanMerchantPurchased)
        setPurchasedState(b.merchantPackBuy, b.checkMerchantPack, MainActivity.data.isMerchantPackPurchased)
        setPurchasedState(b.tradeBaronBuy, b.checkTradeBaron, MainActivity.data.isTradeBaronPurchased)

        // Workshop Bundle
        setPurchasedState(b.apprenticeWorkshopBuy, b.checkApprenticeWorkshop, MainActivity.data.isApprenticeWorkshopPurchased)
        setPurchasedState(b.journeymanWorkshopBuy, b.checkJourneymanWorkshop, MainActivity.data.isJourneymanWorkshopPurchased)
        setPurchasedState(b.masterWorkshopBuy, b.checkMasterWorkshop, MainActivity.data.isMasterWorkshopPurchased)
        setPurchasedState(b.grandmasterWorkshopBuy, b.checkGrandmasterWorkshop, MainActivity.data.isGrandmasterWorkshopPurchased)

        // Storage Bundle
        setPurchasedState(b.minorStorageBuy, b.checkMinorStorage, MainActivity.data.isStoragePack35Purchased)
        setPurchasedState(b.expandedStorageBuy, b.checkExpandedStorage, MainActivity.data.isStoragePack50Purchased)
        setPurchasedState(b.grandStorageBuy, b.checkGrandStorage, MainActivity.data.isStoragePack70Purchased)

        // Utility Bundle
        setPurchasedState(b.deepPocketsBuy, b.checkDeepPockets, MainActivity.data.isMaxLootPackPurchased)
        setPurchasedState(b.extendedVigilBuy, b.checkExtendedVigil, MainActivity.data.isIdleHoursPackPurchased)

        // Max Idle Time Info
        val idleBonus = if (MainActivity.data.isIdleHoursPackPurchased) 6 else 0
        b.maxIdleTimeValue.text = (Math.min(4, MainActivity.data.amountOfPurchases) + 8 + idleBonus).toString()
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
