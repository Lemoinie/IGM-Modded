package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogQuartersBinding;

/* JADX INFO: loaded from: classes3.dex */
public class DialogQuarters extends CustomDialog {
    private static final int MAX_LEVEL_QUARTERS = 23;
    public DialogQuartersBinding binding;
    private AlertDialog upgradeConfirm = null;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogQuartersBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_quarters_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogQuartersBinding dialogQuartersBindingInflate = DialogQuartersBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogQuartersBindingInflate;
        return dialogQuartersBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        long quartersPrice = Formulas.getQuartersPrice();
        UIUtils.populateMoneyContainer(this.binding.money, quartersPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= quartersPrice);
        this.binding.description.setText(String.format(getString(R.string.headquarters_quarters_description_long), Integer.valueOf(MainActivity.data.getAdventurers().size()), Integer.valueOf(Formulas.getQuartersCapacity())));
        this.binding.buttonUpgrade.setVisibility(MainActivity.data.getLevelQuarters() >= 23 ? 8 : 0);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgrade.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogQuarters.this.m378x2b7eb66(view);
            }
        });
        this.binding.exit3.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogQuarters.this.m379x8118ef45(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuarters, reason: not valid java name */
    /* synthetic */ void m378x2b7eb66(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            upgradeQuarters();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_quarters_upgrade, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogQuarters.this.m376x5f5e3a8(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogQuarters.this.m377x8456e787(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuarters, reason: not valid java name */
    /* synthetic */ void m376x5f5e3a8(DialogInterface dialogInterface, int i) {
        upgradeQuarters();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuarters, reason: not valid java name */
    /* synthetic */ void m377x8456e787(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuarters, reason: not valid java name */
    /* synthetic */ void m379x8118ef45(View view) {
        dismiss();
    }

    private void upgradeQuarters() {
        long quartersPrice = Formulas.getQuartersPrice();
        if (MainActivity.data.getMoney() >= quartersPrice) {
            MainActivity.data.setMoney(MainActivity.data.getMoney() - quartersPrice);
            MainActivity.data.setLevelQuarters(MainActivity.data.getLevelQuarters() + 1);
            initialize(null);
            ((MainActivity) getActivity()).refresh();
            MainActivity.headquartersFragment.refresh();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogQuarters = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogQuarters = null;
        super.onStop();
    }
}
