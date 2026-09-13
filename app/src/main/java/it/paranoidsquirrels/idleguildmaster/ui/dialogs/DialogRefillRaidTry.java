package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRefillRaidTryBinding;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class DialogRefillRaidTry extends CustomDialog {
    public DialogRefillRaidTryBinding binding;
    public BooleanSupplier callback;
    public int cost;
    public String description;
    public String title;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogRefillRaidTryBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return this.title;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogRefillRaidTryBinding dialogRefillRaidTryBindingInflate = DialogRefillRaidTryBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogRefillRaidTryBindingInflate;
        return dialogRefillRaidTryBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.confirmText.setText(this.description);
        this.binding.amountGems.setText(String.valueOf(this.cost));
        this.binding.error.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.error.setVisibility(8);
        this.binding.shop.setVisibility(MainActivity.IAPWrapper.initialized ? 0 : 8);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRefillRaidTry.this.m396x2ab5dafa(view);
            }
        });
        this.binding.containerGems.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRefillRaidTry.this.m397x1c076a7b(view);
            }
        });
        this.binding.shop.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRefillRaidTry.this.m398xd58f9fc(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRefillRaidTry, reason: not valid java name */
    /* synthetic */ void m396x2ab5dafa(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRefillRaidTry, reason: not valid java name */
    /* synthetic */ void m397x1c076a7b(View view) {
        if (this.callback.getAsBoolean()) {
            dismiss();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRefillRaidTry, reason: not valid java name */
    /* synthetic */ void m398xd58f9fc(View view) {
        if (MainActivity.shownDialogShop != null) {
            return;
        }
        new DialogShop().show(getParentFragmentManager(), "shop");
    }

    public void displayError() {
        this.binding.error.setVisibility(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogRefillRaidTry = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogRefillRaidTry = null;
        super.onStop();
    }
}
