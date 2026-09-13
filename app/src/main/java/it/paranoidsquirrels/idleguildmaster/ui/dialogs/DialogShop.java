package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.android.billingclient.api.ProductDetails;
import it.paranoidsquirrels.idleguildmaster.IAPWrapper;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogShopBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;

/* JADX INFO: loaded from: classes3.dex */
public class DialogShop extends CustomDialog {
    public static Adventurer imperialVanguard1 = Adventurer.getInstance("HolyKnight", -10, 1, 0, (Weapon) Item.getInstance("Spade"), null, null, Trait.BRUTE_PLUS, Trait.BLESSED, new PotionsDrank(), null, false);
    public static Adventurer imperialVanguard2 = Adventurer.getInstance("WhiteMage", -11, 1, 0, (Weapon) Item.getInstance("Cane"), null, null, Trait.BOOKWORM_PLUS, Trait.EMPATHETIC, new PotionsDrank(), null, false);
    public static Adventurer imperialVanguard3 = Adventurer.getInstance("RedMage", -12, 1, 0, (Weapon) Item.getInstance("Cane"), null, null, Trait.BOOKWORM_PLUS, Trait.GIFTED, new PotionsDrank(), null, false);
    public static Adventurer imperialVanguard4 = Adventurer.getInstance("Sureshot", -13, 1, 0, (Weapon) Item.getInstance("TrainingBow"), null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, new PotionsDrank(), null, false);
    public static Adventurer unholyCrusade1 = Adventurer.getInstance("DarkKnight", -20, 1, 0, (Weapon) Item.getInstance("Spade"), null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, new PotionsDrank(), null, false);
    public static Adventurer unholyCrusade2 = Adventurer.getInstance("Necromancer", -21, 1, 0, (Weapon) Item.getInstance("Cane"), null, null, Trait.BOOKWORM_PLUS, Trait.CURSED, new PotionsDrank(), null, false);
    public static Adventurer unholyCrusade3 = Adventurer.getInstance("Assassin", -22, 1, 0, (Weapon) Item.getInstance("Sickle"), null, null, Trait.FERAL_PLUS, Trait.RUTHLESS, new PotionsDrank(), null, false);
    public static Adventurer unholyCrusade4 = Adventurer.getInstance("PoisonBow", -23, 1, 0, (Weapon) Item.getInstance("TrainingBow"), null, null, Trait.FERAL_PLUS, Trait.ALERT, new PotionsDrank(), null, false);
    public DialogShopBinding binding;
    private AlertDialog shopDisabled;
    private AlertDialog tooltip;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogShopBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.shop_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogShopBinding dialogShopBindingInflate = DialogShopBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogShopBindingInflate;
        return dialogShopBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.maxIdleTimeInfo.setVisibility(8);
        this.binding.maxIdleTimeValue.setVisibility(8);
        this.binding.maxIdleTimeDescription.setVisibility(8);
        this.binding.bonusItemTextAdventurerPack.setText(String.format(getString(R.string.shop_item_fourfold), getString(R.string.accessory_dreamcatcher_name)));
        this.binding.bonusItemTextAdventurerPack2.setText(String.format(getString(R.string.shop_item_one), getString(R.string.consumable_evo23_vial_name)));
        populateAdventurer(this.binding.imperialVanguardAdventurer1, imperialVanguard1);
        populateAdventurer(this.binding.imperialVanguardAdventurer2, imperialVanguard2);
        populateAdventurer(this.binding.imperialVanguardAdventurer3, imperialVanguard3);
        populateAdventurer(this.binding.imperialVanguardAdventurer4, imperialVanguard4);
        populateAdventurer(this.binding.unholyCrusadeAdventurer1, unholyCrusade1);
        populateAdventurer(this.binding.unholyCrusadeAdventurer2, unholyCrusade2);
        populateAdventurer(this.binding.unholyCrusadeAdventurer3, unholyCrusade3);
        populateAdventurer(this.binding.unholyCrusadeAdventurer4, unholyCrusade4);
        populatePrice(this.binding.gems1Buy, IAPWrapper.ID_250_GEMS);
        populatePrice(this.binding.gems2Buy, IAPWrapper.ID_550_GEMS);
        populatePrice(this.binding.gems3Buy, IAPWrapper.ID_1200_GEMS);
        populatePrice(this.binding.gems4Buy, IAPWrapper.ID_3300_GEMS);
        populatePrice(this.binding.starterPackBuy, IAPWrapper.ID_STARTER_PACK);
        populatePrice(this.binding.adventurerPackPreviousPrice, IAPWrapper.ID_MERCHANT_PACK);
        populatePrice(this.binding.adventurerPackBuy, IAPWrapper.ID_ADVENTURER_PACK);
        populatePrice(this.binding.merchantPackBuy, IAPWrapper.ID_MERCHANT_PACK);
        populatePrice(this.binding.imperialVanguardBuy, IAPWrapper.ID_IMPERIAL_VANGUARD);
        populatePrice(this.binding.unholyCrusadeBuy, IAPWrapper.ID_UNHOLY_CRUSADE);
        this.binding.adventurerPackPreviousPrice.setPaintFlags(this.binding.adventurerPackPreviousPrice.getPaintFlags() | 16);
        refresh();
    }

    private void populateAdventurer(LayoutAdventurerBinding layoutAdventurerBinding, final Adventurer adventurer) {
        layoutAdventurerBinding.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
        layoutAdventurerBinding.name.setText(getString(adventurer.getIdName()));
        layoutAdventurerBinding.level.setVisibility(8);
        layoutAdventurerBinding.cardView.setVisibility(8);
        layoutAdventurerBinding.expendableDoctrinePoints.setVisibility(8);
        layoutAdventurerBinding.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
        layoutAdventurerBinding.weapon.setVisibility(8);
        layoutAdventurerBinding.armor.setVisibility(8);
        layoutAdventurerBinding.accessory.setVisibility(8);
        layoutAdventurerBinding.arrowUp.setVisibility(8);
        layoutAdventurerBinding.arrowDown.setVisibility(8);
        layoutAdventurerBinding.delete.setVisibility(8);
        layoutAdventurerBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m454xd0c0be0b(adventurer, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$populateAdventurer$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m454xd0c0be0b(Adventurer adventurer, View view) {
        UIUtils.getAdventurerDetailDialog(getParentFragmentManager(), adventurer, false, false);
    }

    private void populatePrice(TextView textView, String str) {
        ProductDetails productDetails = MainActivity.IAPWrapper.getProductDetails(str);
        if (productDetails == null) {
            return;
        }
        textView.setText(productDetails.getOneTimePurchaseOfferDetails().getFormattedPrice());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.bonusItemImageAdventurerPack.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(Item.getInstance("Dreamcatcher"));
            }
        });
        this.binding.bonusItemImageAdventurerPack2.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(Item.getInstance("Evo23Vial2"));
            }
        });
        this.binding.bonusItemImageImperialVanguard.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(Item.getInstance("Intercession"));
            }
        });
        this.binding.bonusItemImageUnholyCrusade.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(Item.getInstance("Intercession"));
            }
        });
        this.binding.gems1Buy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m449x12bf5cb2(view);
            }
        });
        this.binding.gems2Buy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m450x18c32811(view);
            }
        });
        this.binding.gems3Buy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m451x1ec6f370(view);
            }
        });
        this.binding.gems4Buy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m452x24cabecf(view);
            }
        });
        this.binding.starterPackBuy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m453x2ace8a2e(view);
            }
        });
        this.binding.adventurerPackBuy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m442x736fd81a(view);
            }
        });
        this.binding.merchantPackBuy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m443x7973a379(view);
            }
        });
        this.binding.imperialVanguardBuy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m444x7f776ed8(view);
            }
        });
        this.binding.unholyCrusadeBuy.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m445x857b3a37(view);
            }
        });
        this.binding.maxIdleTimeInfo.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m447x9182d0f5(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShop.this.m448x97869c54(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m449x12bf5cb2(View view) {
        startPurchaseFlow(IAPWrapper.ID_250_GEMS);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m450x18c32811(View view) {
        startPurchaseFlow(IAPWrapper.ID_550_GEMS);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m451x1ec6f370(View view) {
        startPurchaseFlow(IAPWrapper.ID_1200_GEMS);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m452x24cabecf(View view) {
        startPurchaseFlow(IAPWrapper.ID_3300_GEMS);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m453x2ace8a2e(View view) {
        startPurchaseFlow(IAPWrapper.ID_STARTER_PACK);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m442x736fd81a(View view) {
        startPurchaseFlow(IAPWrapper.ID_ADVENTURER_PACK);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m443x7973a379(View view) {
        startPurchaseFlow(IAPWrapper.ID_MERCHANT_PACK);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$12$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m444x7f776ed8(View view) {
        startPurchaseFlow(IAPWrapper.ID_IMPERIAL_VANGUARD);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m445x857b3a37(View view) {
        startPurchaseFlow(IAPWrapper.ID_UNHOLY_CRUSADE);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$15$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m447x9182d0f5(View view) {
        if (this.tooltip != null) {
            return;
        }
        AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.shop_tooltip_title), getString(R.string.shop_tooltip_body), false);
        this.tooltip = infoDialog;
        infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogShop.this.m446x8b7f0596(dialogInterface);
            }
        });
        this.tooltip.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$14$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m446x8b7f0596(DialogInterface dialogInterface) {
        this.tooltip = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$16$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShop, reason: not valid java name */
    /* synthetic */ void m448x97869c54(View view) {
        dismiss();
    }

    private void startPurchaseFlow(String str) {
        ProductDetails productDetails = MainActivity.IAPWrapper.getProductDetails(str);
        if (productDetails == null) {
            return;
        }
        MainActivity.IAPWrapper.purchaseFlow(productDetails, getActivity());
    }

    public void refresh() {
        this.binding.starterPackBuy.setVisibility(MainActivity.data.isStarterPackPurchased() ? 8 : 0);
        this.binding.adventurerPackPreviousPrice.setVisibility(MainActivity.data.isAdventurerPackPurchased() ? 8 : 0);
        this.binding.adventurerPackBuy.setVisibility(MainActivity.data.isAdventurerPackPurchased() ? 8 : 0);
        this.binding.merchantPackBuy.setVisibility(MainActivity.data.isMerchantPackPurchased() ? 8 : 0);
        this.binding.imperialVanguardBuy.setVisibility(MainActivity.data.isImperialVanguardPurchased() ? 8 : 0);
        this.binding.unholyCrusadeBuy.setVisibility(MainActivity.data.isUnholyCrusadePurchased() ? 8 : 0);
        this.binding.checkStarterPack.setVisibility(MainActivity.data.isStarterPackPurchased() ? 0 : 8);
        this.binding.checkAdventurerPack.setVisibility(MainActivity.data.isAdventurerPackPurchased() ? 0 : 8);
        this.binding.checkMerchantPack.setVisibility(MainActivity.data.isMerchantPackPurchased() ? 0 : 8);
        this.binding.checkImperialVanguard.setVisibility(MainActivity.data.isImperialVanguardPurchased() ? 0 : 8);
        this.binding.checkUnholyCrusade.setVisibility(MainActivity.data.isUnholyCrusadePurchased() ? 0 : 8);
        this.binding.maxIdleTimeValue.setText(String.valueOf(Math.min(4, MainActivity.data.getAmountOfPurchases()) + 8));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogShop = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogShop = null;
        super.onStop();
    }
}
