package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeIntercessionBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumeIntercession extends CustomDialog {
    private DialogConsumeIntercessionBinding binding;
    private AlertDialog confirmDialog;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumeIntercessionBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_consume_evo23_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumeIntercessionBinding dialogConsumeIntercessionBindingInflate = DialogConsumeIntercessionBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumeIntercessionBindingInflate;
        return dialogConsumeIntercessionBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.list.removeAllViews();
        for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
            if (!adventurer.isAscended()) {
                LayoutAdventurerChangeTraitBinding layoutAdventurerChangeTraitBindingInflate = LayoutAdventurerChangeTraitBinding.inflate(getLayoutInflater(), this.binding.list, false);
                layoutAdventurerChangeTraitBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
                layoutAdventurerChangeTraitBindingInflate.level.setText(String.valueOf(adventurer.getLevel()));
                layoutAdventurerChangeTraitBindingInflate.cardView.setVisibility(8);
                layoutAdventurerChangeTraitBindingInflate.name.setText(getString(adventurer.getIdName()));
                layoutAdventurerChangeTraitBindingInflate.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
                layoutAdventurerChangeTraitBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogConsumeIntercession.this.m249xc67484b7(adventurer, view);
                    }
                });
                this.binding.list.addView(layoutAdventurerChangeTraitBindingInflate.getRoot());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeIntercession, reason: not valid java name */
    /* synthetic */ void m249xc67484b7(final Adventurer adventurer, View view) {
        if (this.confirmDialog != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.confirm), String.format(getString(R.string.dialog_intercession_confirm_choose), getString(adventurer.getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogConsumeIntercession.this.m247x5f182f35(adventurer, dialogInterface, i);
            }
        });
        this.confirmDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogConsumeIntercession.this.m248x92c659f6(dialogInterface);
            }
        });
        this.confirmDialog.show();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeIntercession, reason: not valid java name */
    /* synthetic */ void m247x5f182f35(Adventurer adventurer, DialogInterface dialogInterface, int i) {
        adventurer.setAscended(true);
        Utils.removeItemFromStorage(Item.getInstance("Intercession", 1));
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        MainActivity.adventurersFragment.refresh();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeIntercession, reason: not valid java name */
    /* synthetic */ void m248x92c659f6(DialogInterface dialogInterface) {
        this.confirmDialog = null;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumeIntercession.this.m246x95ea988(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeIntercession, reason: not valid java name */
    /* synthetic */ void m246x95ea988(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumeIntercession = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumeIntercession = null;
        super.onStop();
    }
}
