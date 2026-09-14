package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBuyFromMerchantBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class DialogBuyFromMerchant extends CustomDialog {
    public DialogBuyFromMerchantBinding binding;
    public BooleanSupplier callback;
    public MerchantOffer offer;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogBuyFromMerchantBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.merchant_dialog_confirm_buy_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogBuyFromMerchantBinding dialogBuyFromMerchantBindingInflate = DialogBuyFromMerchantBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogBuyFromMerchantBindingInflate;
        return dialogBuyFromMerchantBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.confirmText.setText(this.offer.getItem().getStack() > 1 ? String.format(getString(R.string.merchant_dialog_confirm_buy_multiple_body), Integer.valueOf(this.offer.getItem().getStack()), getString(this.offer.getItem().getIdName())) : String.format(getString(R.string.merchant_dialog_confirm_buy_single_body), getString(this.offer.getItem().getIdName())));
        int i = 8;
        this.binding.containerMoney.setVisibility(this.offer.isGems() ? 8 : 0);
        this.binding.containerGems.setVisibility(this.offer.isGems() ? 0 : 8);
        TextView textView = this.binding.shop;
        // Temporary disabled in UI per configuration (implemented but hidden)
        textView.setVisibility(8);
        if (this.offer.isGems()) {
            this.binding.amountGems.setText(String.valueOf(this.offer.getPrice()));
        } else {
            UIUtils.populateMoneyContainer(this.binding.amountMoney, this.offer.getPrice(), true);
        }
        this.binding.error.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBuyFromMerchant$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyFromMerchant.this.m226xa03305b7(view);
            }
        });
        this.binding.priceContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBuyFromMerchant$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyFromMerchant.this.m227x835eb8f8(view);
            }
        });
        this.binding.shop.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBuyFromMerchant$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyFromMerchant.this.m228x668a6c39(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogBuyFromMerchant, reason: not valid java name */
    /* synthetic */ void m226xa03305b7(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogBuyFromMerchant, reason: not valid java name */
    /* synthetic */ void m227x835eb8f8(View view) {
        if (this.callback.getAsBoolean()) {
            dismiss();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogBuyFromMerchant, reason: not valid java name */
    /* synthetic */ void m228x668a6c39(View view) {
        if (MainActivity.shownDialogShop != null) {
            return;
        }
        new DialogShop().show(getParentFragmentManager(), "shop");
    }

    public void writeError(String str) {
        this.binding.error.setText(str);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogBuyFromMerchant = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogBuyFromMerchant = null;
        super.onStop();
    }
}
