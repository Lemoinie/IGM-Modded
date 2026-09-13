package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogIdleProgressBinding;

/* JADX INFO: loaded from: classes3.dex */
public class DialogIdleProgress extends CustomDialog {
    public DialogIdleProgressBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogIdleProgressBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.loading_screen_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogIdleProgressBinding dialogIdleProgressBindingInflate = DialogIdleProgressBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogIdleProgressBindingInflate;
        return dialogIdleProgressBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        refreshProgress(0);
        this.binding.progressBar.setVisibility(4);
    }

    public void refreshProgress(int i) {
        try {
            this.binding.progressBar.setVisibility(0);
            this.binding.progressBar.setProgress(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
