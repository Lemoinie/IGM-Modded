package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDoctrineResetBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;

/* JADX INFO: loaded from: classes3.dex */
public class DialogDoctrineReset extends CustomDialog {
    private Adventurer adventurer;
    private DialogDoctrineResetBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogDoctrineResetBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.reset);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogDoctrineResetBinding dialogDoctrineResetBindingInflate = DialogDoctrineResetBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogDoctrineResetBindingInflate;
        return dialogDoctrineResetBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.body.setText(String.format(getString(R.string.dialog_doctrine_confirm_reset), getString(this.adventurer.getIdName())));
        this.binding.errorNoGems.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.errorNoGems.setVisibility(8);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.containerGems.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrineReset$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrineReset.this.m272x3dab7544(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrineReset$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrineReset.this.m273x2efd04c5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrineReset, reason: not valid java name */
    /* synthetic */ void m272x3dab7544(View view) {
        if (MainActivity.data.getGems() >= 50) {
            MainActivity.data.setGems(MainActivity.data.getGems() - 50);
            ((MainActivity) getActivity()).refreshGems();
            this.adventurer.setDoctrine(Doctrine.getInstance("EmptyDoctrine"));
            DialogDoctrine.removeWeaponMaster(getResources(), this.adventurer);
            if (MainActivity.shownDialogDoctrine != null) {
                MainActivity.shownDialogDoctrine.dismiss();
            }
            if (MainActivity.shownDialogEntityDetail != null) {
                MainActivity.shownDialogEntityDetail.update();
            }
            MainActivity.adventurersFragment.refresh();
            dismiss();
            return;
        }
        this.binding.errorNoGems.setVisibility(0);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrineReset, reason: not valid java name */
    /* synthetic */ void m273x2efd04c5(View view) {
        dismiss();
    }

    public Adventurer getAdventurer() {
        return this.adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogDoctrineReset = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogDoctrineReset = null;
        super.onStop();
    }
}
