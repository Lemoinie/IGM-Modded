package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ProgressBar
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

        // Divine Champion Pack hero preview
        @JvmField
        val divineChampionHero: Adventurer = Adventurer.getInstance("DivineChampion", -40, 45, 0, null, null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, PotionsDrank(), null, false)!!

        // Senko Pet (Level 50, 5 Traits — first trait SAVAGE)
        @JvmField
        val senkoPetPreview: Pet? = Pet.getInstance("Senko", -100, 50, 0, PetAbility.SAVAGE, PetAbility.REGENERATION, PetAbility.DROPS, PetAbility.EXPERIENCE)
    }

    enum class Category {
        ALL, STARTER, ADVENTURERS, COMPANIONS, MERCHANT, WORKSHOP, STORAGE, UTILITY, EQUIPMENT, INFRASTRUCTURE
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

    /**
     * Async inflation for the shop.
     *
     * The shop layout (~600+ views across all 11 pack sections, including the 5
     * `shop_bundle_*.xml` sub-layouts) used to be inflated synchronously on the
     * main thread, which caused a visible stutter every time the dialog opened.
     * We now show a lightweight shell immediately and inflate the full
     * `dialog_shop.xml` on a background thread (the same pattern Android's
     * AsyncLayoutInflater uses internally). When inflation finishes, the
     * fully-inflated content is bound and attached on the main thread (1-2 frames
     * later), and the existing initialize/attachListeners logic runs unchanged.
     * All layouts, visuals, and click interactions are pixel-identical to the
     * previous synchronous path.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(0))
            setBackgroundDrawableResource(R.drawable.dialog_border)
            setFlags(8, 8)
            decorView.systemUiVisibility = activity?.window?.decorView?.systemUiVisibility ?: 0
        }
        dialog?.setOnShowListener { _ ->
            try {
                dialog?.window?.clearFlags(8)
                val wm = activity?.getSystemService("window") as? WindowManager
                wm?.updateViewLayout(dialog?.window?.decorView, dialog?.window?.attributes)
            } catch (_: Exception) {
                dismiss()
            }
        }

        // Lightweight shell with a transient loading spinner so the dialog opens
        // instantly instead of blocking on the full shop view tree.
        val shell = FrameLayout(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            addView(
                ProgressBar(context),
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
        }

        // Inflate the full shop layout off the main thread; bind + attach on the
        // main thread once it completes. A new inflater is created up front (main
        // thread) and used from the worker, mirroring AsyncLayoutInflater.
        val shopInflater = LayoutInflater.from(requireContext())
        val mainHandler = Handler(Looper.getMainLooper())
        Thread {
            val shopView = try {
                shopInflater.inflate(R.layout.dialog_shop, null)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
            if (shopView != null) {
                mainHandler.post {
                    if (isAdded) {
                        val b = DialogShopBinding.bind(shopView)
                        binding = b
                        shell.removeAllViews()
                        shell.addView(
                            shopView,
                            ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                        )
                        try {
                            initialize(arguments)
                            attachListeners()
                            dialog?.setTitle(getTitle())
                            setLayout()
                        } catch (e: Exception) {
                            e.printStackTrace()
                            dismiss()
                        }
                    }
                }
            }
        }.start()

        return shell
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

        // Divine Champion pack hero preview (displayed like the other adventurer packs)
        populateAdventurer(b.containerConvertedBundle.divineChampionAdventurer, divineChampionHero)

        // Converted starter packs — state how many items each pack grants
        setCountedItemText(b.containerConvertedBundle.divineChampionR2Text, 1, R.string.armor_heavy_champion_armor_name)
        setCountedItemText(b.containerConvertedBundle.divineChampionR3Text, 1, R.string.accessory_spiked_primeval_shield_name)
        setCountedItemText(b.containerConvertedBundle.divineChampionR4Text, 1, R.string.weapon_sword_ghastly_scimitar_name)

        setCountedItemText(b.containerConvertedBundle.eternalReliquaryR1Text, 2, R.string.accessory_eternal_hunger_name)
        setCountedItemText(b.containerConvertedBundle.eternalReliquaryR2Text, 1, R.string.armor_medium_scarlet_veil_name)
        setCountedItemText(b.containerConvertedBundle.eternalReliquaryR3Text, 1, R.string.armor_medium_reassembling_jacket_name)
        setCountedItemText(b.containerConvertedBundle.eternalReliquaryR4Text, 1, R.string.accessory_seeking_glass_name)

        setCountedItemText(b.containerConvertedBundle.alchemistBountyR1Text, 100, R.string.consumable_potion_of_constitution_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR2Text, 100, R.string.consumable_potion_of_dexterity_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR3Text, 100, R.string.consumable_potion_of_intelligence_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR4Text, 100, R.string.consumable_potion_of_health_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR5Text, 100, R.string.consumable_potion_of_defense_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR6Text, 100, R.string.consumable_potion_of_magic_defense_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR7Text, 100, R.string.consumable_potion_of_precision_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR8Text, 100, R.string.consumable_potion_of_viciousness_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR9Text, 100, R.string.consumable_potion_of_darkness_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR10Text, 100, R.string.consumable_potion_of_immunity_name)
        setCountedItemText(b.containerConvertedBundle.alchemistBountyR11Text, 100, R.string.consumable_potion_of_agility_name)

        setCountedItemText(b.containerConvertedBundle.patricianWardrobeR1Text, 2, R.string.armor_heavy_patrician_armor_name)
        setCountedItemText(b.containerConvertedBundle.patricianWardrobeR2Text, 19, R.string.accessory_diamond_amulet_name)
        setCountedItemText(b.containerConvertedBundle.patricianWardrobeR3Text, 10, R.string.armor_medium_cottontail_jacket_name)
        setCountedItemText(b.containerConvertedBundle.patricianWardrobeR4Text, 6, R.string.armor_light_ghost_rabbit_cloak_name)

        setCountedItemText(b.containerConvertedBundle.royalTreasuryR2Text, 10, R.string.food_ceremonial_cake_name)
        setCountedItemText(b.containerConvertedBundle.scarletShroudR1Text, 1, R.string.armor_medium_scarlet_shroud_name)

        // Utility bundle counts
        setCountedItemText(b.containerUtilityExpansionBundle.intercessionTextSacred, 1, R.string.consumable_intercession_name)
        setCountedItemText(b.containerUtilityExpansionBundle.evolutionCrateR1Text, 1, R.string.consumable_evo22_vial_name)
        setCountedItemText(b.containerUtilityExpansionBundle.evolutionCrateR2Text, 1, R.string.consumable_evo23_vial_name)
        setCountedItemText(b.containerUtilityExpansionBundle.evolutionCrateR3Text, 2, R.string.accessory_dreamcatcher_name)

        selectCategory(Category.ALL)
        refresh()
    }

    private fun setCountedItemText(textView: TextView, count: Int, nameRes: Int) {
        textView.text = String.format(getString(R.string.shop_item_x), count, getString(nameRes))
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
        b.chipCategoryEquipment.setOnClickListener { selectCategory(Category.EQUIPMENT) }
        b.chipCategoryInfrastructure.setOnClickListener { selectCategory(Category.INFRASTRUCTURE) }

        // Bonus Item Detail Click Listeners
        b.bonusItemImageAdventurerPack.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Dreamcatcher")) }
        b.bonusItemImageAdventurerPack2.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Evo23Vial2")) }
        b.bonusItemImageImperialVanguard.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.bonusItemImageUnholyCrusade.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.bonusItemImagePrimalVanguard.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }
        b.containerUtilityExpansionBundle.intercessionImageSacred.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Intercession")) }

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

        // Converted Redeem Codes (Starter Bundle)
        b.containerConvertedBundle.divineChampionBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_divine_champion), 500, MainActivity.data.isDivineChampionPackPurchased) {
                MainActivity.data.isDivineChampionPackPurchased = true
                val hero = Adventurer.getInstance("DivineChampion", -40, 45, 0, null, null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, PotionsDrank(), null, false)
                if (hero != null) MainActivity.data.adventurers.add(hero)
                Utils.collectItem(Item.getInstance("ChampionArmor", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("SpikedPrimevalShield", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("GhastlyScimitar", 1), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
                Utils.triggerGuildSizeAchievementCheck()
            }
        }

        b.containerConvertedBundle.eternalReliquaryBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_eternal_reliquary), 500, MainActivity.data.isEternalReliquaryPurchased) {
                MainActivity.data.isEternalReliquaryPurchased = true
                Utils.collectItem(Item.getInstance("EternalHunger", 2), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("ScarletVeil", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("ReassemblingJacket", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("SeekingGlass", 1), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerConvertedBundle.alchemistBountyBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_alchemist_bounty), 100, MainActivity.data.isAlchemistBountyPurchased) {
                MainActivity.data.isAlchemistBountyPurchased = true
                mapOf(
                    "PotionOfConstitution" to 100, "PotionOfDexterity" to 100, "PotionOfIntelligence" to 100,
                    "PotionOfHealth" to 100, "PotionOfDefense" to 100, "PotionOfMagicDefense" to 100,
                    "PotionOfPrecision" to 100, "PotionOfViciousness" to 100, "PotionOfDarkness" to 100,
                    "PotionOfImmunity" to 100, "PotionOfAgility" to 100
                ).forEach { (name, count) ->
                    Utils.collectItem(Item.getInstance(name, count), MainActivity.data.items)
                }
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerConvertedBundle.patricianWardrobeBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_patrician_wardrobe), 300, MainActivity.data.isPatricianWardrobePurchased) {
                MainActivity.data.isPatricianWardrobePurchased = true
                Utils.collectItem(Item.getInstance("PatricianArmor", 2), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("DiamondAmulet", 19), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("CottontailJacket", 10), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("GhostRabbitCloak", 6), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerConvertedBundle.royalTreasuryBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_royal_treasury), 500, MainActivity.data.isRoyalTreasuryPurchased) {
                MainActivity.data.isRoyalTreasuryPurchased = true
                MainActivity.data.money += 10_000_000L // 10 Platinum Coins
                Utils.collectItem(Item.getInstance("CeremonialCake", 10), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerConvertedBundle.scarletShroudBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_scarlet_shroud), 500, MainActivity.data.isScarletShroudPurchased) {
                MainActivity.data.isScarletShroudPurchased = true
                Utils.collectItem(Item.getInstance("ScarletShroud", 1), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Converted pack item / adventurer detail previews (click to inspect)
        b.containerConvertedBundle.divineChampionR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("ChampionArmor")) }
        b.containerConvertedBundle.divineChampionR3Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("SpikedPrimevalShield")) }
        b.containerConvertedBundle.divineChampionR4Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("GhastlyScimitar")) }

        b.containerConvertedBundle.eternalReliquaryR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("EternalHunger")) }
        b.containerConvertedBundle.eternalReliquaryR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("ScarletVeil")) }
        b.containerConvertedBundle.eternalReliquaryR3Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("ReassemblingJacket")) }
        b.containerConvertedBundle.eternalReliquaryR4Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("SeekingGlass")) }

        b.containerConvertedBundle.alchemistBountyR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfConstitution")) }
        b.containerConvertedBundle.patricianWardrobeR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PatricianArmor")) }
        b.containerConvertedBundle.patricianWardrobeR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("DiamondAmulet")) }
        b.containerConvertedBundle.patricianWardrobeR3Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("CottontailJacket")) }
        b.containerConvertedBundle.patricianWardrobeR4Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("GhostRabbitCloak")) }

        b.containerConvertedBundle.royalTreasuryR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("CeremonialCake")) }
        b.containerConvertedBundle.scarletShroudR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("ScarletShroud")) }

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
                val pet = Pet.getInstance("Senko", -100, 50, 0, PetAbility.SAVAGE, PetAbility.REGENERATION, PetAbility.DROPS, PetAbility.EXPERIENCE)
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
            confirmAndPurchase(getString(R.string.shop_title_grand_merchant), 2500, MainActivity.data.isMerchantPackPurchased) {
                MainActivity.data.isMerchantPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.tradeBaronBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_trade_baron), 5000, MainActivity.data.isTradeBaronPurchased) {
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
            confirmAndPurchase(getString(R.string.shop_title_master_workshop), 2500, MainActivity.data.isMasterWorkshopPurchased) {
                MainActivity.data.isMasterWorkshopPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.grandmasterWorkshopBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_grandmaster_workshop), 5000, MainActivity.data.isGrandmasterWorkshopPurchased) {
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
        b.containerUtilityExpansionBundle.deepPocketsBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_deep_pockets), 1000, MainActivity.data.isMaxLootPackPurchased) {
                MainActivity.data.isMaxLootPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.extendedVigilBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_extended_vigil), 750, MainActivity.data.isIdleHoursPackPurchased) {
                MainActivity.data.isIdleHoursPackPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.sacredIntercessionBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_sacred_intercession), 500, MainActivity.data.isSacredIntercessionPurchased) {
                MainActivity.data.isSacredIntercessionPurchased = true
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
            }
        }

        // Companion Bundle: 10x Ceremonial Cake for 10,000 Gems (one-time)
        b.cakePackBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_cake_pack), 10000, MainActivity.data.isCakePackPurchased) {
                MainActivity.data.isCakePackPurchased = true
                Utils.collectItem(Item.getInstance("CeremonialCake", 10), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Equipment Bundle
        b.containerEquipmentBundle.celestialBowBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_celestial_bow), 1000, MainActivity.data.isCelestialBowPurchased) {
                MainActivity.data.isCelestialBowPurchased = true
                Utils.collectItem(Item.getInstance("CelestialBow", 1), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerEquipmentBundle.iconCelestialBow.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("CelestialBow")) }

        // Infrastructure Bundle (plan: Barracks Expansion I/II, Grand Tavern, Sanctuary Grounds I/II)
        b.containerInfrastructureBundle.barracks1Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_barracks_i), 1000, MainActivity.data.isBarracks1Purchased) {
                MainActivity.data.isBarracks1Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerInfrastructureBundle.barracks2Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_barracks_ii), 2000, MainActivity.data.isBarracks2Purchased) {
                MainActivity.data.isBarracks2Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerInfrastructureBundle.grandTavernBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_grand_tavern), 1250, MainActivity.data.isGrandTavernPurchased) {
                MainActivity.data.isGrandTavernPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerInfrastructureBundle.sanctuary1Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_sanctuary_i), 750, MainActivity.data.isSanctuary1Purchased) {
                MainActivity.data.isSanctuary1Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerInfrastructureBundle.sanctuary2Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_sanctuary_ii), 1250, MainActivity.data.isSanctuary2Purchased) {
                MainActivity.data.isSanctuary2Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Utility Expansion (plan: Extended Vigil II/III/IV, Eternal Vigil, Deep Pockets II)
        b.containerUtilityExpansionBundle.vigil2Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_idle_hours_ii), 2000, MainActivity.data.isIdleHoursPack2Purchased) {
                MainActivity.data.isIdleHoursPack2Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.vigil3Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_idle_hours_iii), 3500, MainActivity.data.isIdleHoursPack3Purchased) {
                MainActivity.data.isIdleHoursPack3Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.vigil4Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_idle_hours_iv), 7000, MainActivity.data.isIdleHoursPack4Purchased) {
                MainActivity.data.isIdleHoursPack4Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.eternalVigilBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_eternal_vigil), 10000, MainActivity.data.isEternalVigilPurchased) {
                MainActivity.data.isEternalVigilPurchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerUtilityExpansionBundle.deepPockets2Buy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_deep_pockets_ii), 2000, MainActivity.data.isMaxLootPack2Purchased) {
                MainActivity.data.isMaxLootPack2Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Evolutionary Synthesis Crate (one-time key ascension material pack)
        b.containerUtilityExpansionBundle.evolutionCrateR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Evo22Vial")) }
        b.containerUtilityExpansionBundle.evolutionCrateR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Evo23Vial")) }
        b.containerUtilityExpansionBundle.evolutionCrateR3Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("Dreamcatcher")) }

        // Alchemist's Bounty potions (click to inspect)
        b.containerConvertedBundle.alchemistBountyR1Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfConstitution")) }
        b.containerConvertedBundle.alchemistBountyR2Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfDexterity")) }
        b.containerConvertedBundle.alchemistBountyR3Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfIntelligence")) }
        b.containerConvertedBundle.alchemistBountyR4Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfHealth")) }
        b.containerConvertedBundle.alchemistBountyR5Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfDefense")) }
        b.containerConvertedBundle.alchemistBountyR6Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfMagicDefense")) }
        b.containerConvertedBundle.alchemistBountyR7Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfPrecision")) }
        b.containerConvertedBundle.alchemistBountyR8Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfViciousness")) }
        b.containerConvertedBundle.alchemistBountyR9Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfDarkness")) }
        b.containerConvertedBundle.alchemistBountyR10Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfImmunity")) }
        b.containerConvertedBundle.alchemistBountyR11Icon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("PotionOfAgility")) }
        b.containerUtilityExpansionBundle.evolutionCrateBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_evolution_crate), 1000, MainActivity.data.isEvolutionSynthesisPurchased) {
                MainActivity.data.isEvolutionSynthesisPurchased = true
                Utils.collectItem(Item.getInstance("Evo22Vial", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("Evo23Vial", 1), MainActivity.data.items)
                Utils.collectItem(Item.getInstance("Dreamcatcher", 2), MainActivity.data.items)
                MainActivity.data.amountOfPurchases += 1
            }
        }

        // Storage Expansion (plan: Dimensional Vault, Infinite Hoard)
        b.containerStorageExpansionBundle.dimensionalVaultBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_storage_100), 1500, MainActivity.data.isStoragePack100Purchased) {
                MainActivity.data.isStoragePack100Purchased = true
                MainActivity.data.amountOfPurchases += 1
            }
        }

        b.containerStorageExpansionBundle.infiniteHoardBuy.setOnClickListener {
            confirmAndPurchase(getString(R.string.shop_title_storage_150), 2000, MainActivity.data.isStoragePack150Purchased) {
                MainActivity.data.isStoragePack150Purchased = true
                MainActivity.data.amountOfPurchases += 1
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
        updateChip(b.chipCategoryEquipment, category == Category.EQUIPMENT)
        updateChip(b.chipCategoryInfrastructure, category == Category.INFRASTRUCTURE)

        b.containerStarterBundle.visibility = if (category == Category.ALL || category == Category.STARTER) View.VISIBLE else View.GONE
        b.containerAdventurerBundle.visibility = if (category == Category.ALL || category == Category.ADVENTURERS) View.VISIBLE else View.GONE
        b.containerCompanionBundle.visibility = if (category == Category.ALL || category == Category.COMPANIONS) View.VISIBLE else View.GONE
        b.containerMerchantBundle.visibility = if (category == Category.ALL || category == Category.MERCHANT) View.VISIBLE else View.GONE
        b.containerWorkshopBundle.visibility = if (category == Category.ALL || category == Category.WORKSHOP) View.VISIBLE else View.GONE
        b.containerStorageBundle.visibility = if (category == Category.ALL || category == Category.STORAGE) View.VISIBLE else View.GONE
        b.containerUtilityExpansionBundle.root.visibility = if (category == Category.ALL || category == Category.UTILITY) View.VISIBLE else View.GONE
        b.containerConvertedBundle.root.visibility = if (category == Category.ALL || category == Category.STARTER) View.VISIBLE else View.GONE
        b.containerEquipmentBundle.root.visibility = if (category == Category.ALL || category == Category.EQUIPMENT) View.VISIBLE else View.GONE
        b.containerInfrastructureBundle.root.visibility = if (category == Category.ALL || category == Category.INFRASTRUCTURE) View.VISIBLE else View.GONE
        b.containerStorageExpansionBundle.root.visibility = if (category == Category.ALL || category == Category.STORAGE) View.VISIBLE else View.GONE
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
        fun setPurchasedState(buyButton: View, checkView: View, isPurchased: Boolean) {
            buyButton.visibility = if (isPurchased) View.GONE else View.VISIBLE
            checkView.visibility = if (isPurchased) View.VISIBLE else View.GONE
        }

        // Starter Bundle
        setPurchasedState(b.starterPackBuy, b.checkStarterPack, MainActivity.data.isStarterPackPurchased)
        setPurchasedState(b.adventurerPackBuy, b.checkAdventurerPack, MainActivity.data.isAdventurerPackPurchased)

        // Converted Redeem Code packs
        setPurchasedState(b.containerConvertedBundle.divineChampionBuy, b.containerConvertedBundle.checkDivineChampion, MainActivity.data.isDivineChampionPackPurchased)
        setPurchasedState(b.containerConvertedBundle.eternalReliquaryBuy, b.containerConvertedBundle.checkEternalReliquary, MainActivity.data.isEternalReliquaryPurchased)
        setPurchasedState(b.containerConvertedBundle.alchemistBountyBuy, b.containerConvertedBundle.checkAlchemistBounty, MainActivity.data.isAlchemistBountyPurchased)
        setPurchasedState(b.containerConvertedBundle.patricianWardrobeBuy, b.containerConvertedBundle.checkPatricianWardrobe, MainActivity.data.isPatricianWardrobePurchased)
        setPurchasedState(b.containerConvertedBundle.royalTreasuryBuy, b.containerConvertedBundle.checkRoyalTreasury, MainActivity.data.isRoyalTreasuryPurchased)
        setPurchasedState(b.containerConvertedBundle.scarletShroudBuy, b.containerConvertedBundle.checkScarletShroud, MainActivity.data.isScarletShroudPurchased)

        // Adventurer Bundle
        setPurchasedState(b.imperialVanguardBuy, b.checkImperialVanguard, MainActivity.data.isImperialVanguardPurchased)
        setPurchasedState(b.unholyCrusadeBuy, b.checkUnholyCrusade, MainActivity.data.isUnholyCrusadePurchased)
        setPurchasedState(b.primalVanguardBuy, b.checkPrimalVanguard, MainActivity.data.isPrimalVanguardPurchased)

        // Companion Bundle
        setPurchasedState(b.senkoPackBuy, b.checkSenkoPack, MainActivity.data.isSenkoPackPurchased)
        setPurchasedState(b.cakePackBuy, b.checkCakePack, MainActivity.data.isCakePackPurchased)

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
        setPurchasedState(b.containerUtilityExpansionBundle.deepPocketsBuy, b.containerUtilityExpansionBundle.checkDeepPockets, MainActivity.data.isMaxLootPackPurchased)
        setPurchasedState(b.containerUtilityExpansionBundle.extendedVigilBuy, b.containerUtilityExpansionBundle.checkExtendedVigil, MainActivity.data.isIdleHoursPackPurchased)
        setPurchasedState(b.containerUtilityExpansionBundle.sacredIntercessionBuy, b.containerUtilityExpansionBundle.checkSacredIntercession, MainActivity.data.isSacredIntercessionPurchased)

        // Equipment Bundle
        setPurchasedState(b.containerEquipmentBundle.celestialBowBuy, b.containerEquipmentBundle.checkCelestialBow, MainActivity.data.isCelestialBowPurchased)

        // Infrastructure Bundle
        setPurchasedState(b.containerInfrastructureBundle.barracks1Buy, b.containerInfrastructureBundle.checkBarracks1, MainActivity.data.isBarracks1Purchased)
        setPurchasedState(b.containerInfrastructureBundle.barracks2Buy, b.containerInfrastructureBundle.checkBarracks2, MainActivity.data.isBarracks2Purchased)
        setPurchasedState(b.containerInfrastructureBundle.grandTavernBuy, b.containerInfrastructureBundle.checkGrandTavern, MainActivity.data.isGrandTavernPurchased)
        setPurchasedState(b.containerInfrastructureBundle.sanctuary1Buy, b.containerInfrastructureBundle.checkSanctuary1, MainActivity.data.isSanctuary1Purchased)
        setPurchasedState(b.containerInfrastructureBundle.sanctuary2Buy, b.containerInfrastructureBundle.checkSanctuary2, MainActivity.data.isSanctuary2Purchased)

        // Utility Expansion Bundle
        setPurchasedState(b.containerUtilityExpansionBundle.vigil2Buy, b.containerUtilityExpansionBundle.checkVigil2, MainActivity.data.isIdleHoursPack2Purchased)
        setPurchasedState(b.containerUtilityExpansionBundle.vigil3Buy, b.containerUtilityExpansionBundle.checkVigil3, MainActivity.data.isIdleHoursPack3Purchased)
        setPurchasedState(b.containerUtilityExpansionBundle.vigil4Buy, b.containerUtilityExpansionBundle.checkVigil4, MainActivity.data.isIdleHoursPack4Purchased)
        setPurchasedState(b.containerUtilityExpansionBundle.eternalVigilBuy, b.containerUtilityExpansionBundle.checkEternalVigil, MainActivity.data.isEternalVigilPurchased)
        setPurchasedState(b.containerUtilityExpansionBundle.deepPockets2Buy, b.containerUtilityExpansionBundle.checkDeepPockets2, MainActivity.data.isMaxLootPack2Purchased)
        setPurchasedState(b.containerUtilityExpansionBundle.evolutionCrateBuy, b.containerUtilityExpansionBundle.checkEvolutionCrate, MainActivity.data.isEvolutionSynthesisPurchased)

        // Storage Expansion Bundle
        setPurchasedState(b.containerStorageExpansionBundle.dimensionalVaultBuy, b.containerStorageExpansionBundle.checkDimensionalVault, MainActivity.data.isStoragePack100Purchased)
        setPurchasedState(b.containerStorageExpansionBundle.infiniteHoardBuy, b.containerStorageExpansionBundle.checkInfiniteHoard, MainActivity.data.isStoragePack150Purchased)

        // Max Idle Time Info
        var idleBonus = 0
        if (MainActivity.data.isIdleHoursPackPurchased) idleBonus += 6
        if (MainActivity.data.isIdleHoursPack2Purchased) idleBonus += 6
        if (MainActivity.data.isIdleHoursPack3Purchased) idleBonus += 24
        if (MainActivity.data.isIdleHoursPack4Purchased) idleBonus += 48
        if (MainActivity.data.isEternalVigilPurchased) idleBonus += 72
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
