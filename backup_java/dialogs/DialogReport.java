package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogReportBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;

/* JADX INFO: loaded from: classes3.dex */
public class DialogReport extends CustomDialog {
    public DialogReportBinding binding;
    public AdventureRecap recap;
    public String sourceArea;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogReportBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return String.format(getString(R.string.report_area), this.sourceArea);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogReportBinding dialogReportBindingInflate = DialogReportBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogReportBindingInflate;
        return dialogReportBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.durationValue.setText(UIUtils.formatSeconds(this.recap.getSecondsPassed()));
        this.binding.areasClearedValue.setText(String.valueOf(this.recap.getAreasCleared()));
        this.binding.teamWipedValue.setText(String.valueOf(this.recap.getWiped()));
        this.binding.expEarnedValue.setText(String.valueOf(this.recap.getExpEarned()));
        this.binding.expLostValue.setText(String.valueOf(this.recap.getExpLost()));
        this.binding.expPerHourValue.setText(UIUtils.formatDouble2Decimals((((double) (this.recap.getExpEarned() - this.recap.getExpLost())) * 3600.0d) / ((double) this.recap.getSecondsPassed())));
        this.binding.itemGrid.setAdapter((ListAdapter) UIUtils.getEnemyReportGridAdapter(getContext(), this.recap.getEnemiesKilled()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.itemGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogReport$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogReport.this.m401x794429d5(adapterView, view, i, j);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogReport$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogReport.this.m402xd829974(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogReport, reason: not valid java name */
    /* synthetic */ void m401x794429d5(AdapterView adapterView, View view, int i, long j) {
        UIUtils.getEnemyDetailDialog(getParentFragmentManager(), Enemy.getInstance(this.recap.getEnemiesKilled().get(i).getEnemy()));
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogReport, reason: not valid java name */
    /* synthetic */ void m402xd829974(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogReport = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogReport = null;
        super.onStop();
    }
}
