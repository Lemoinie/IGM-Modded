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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionOfClumsinessBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumePotionOfClumsiness extends CustomDialog {
    private DialogConsumePotionOfClumsinessBinding binding;
    private AlertDialog confirmDialog;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumePotionOfClumsinessBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_consume_evo23_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumePotionOfClumsinessBinding dialogConsumePotionOfClumsinessBindingInflate = DialogConsumePotionOfClumsinessBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumePotionOfClumsinessBindingInflate;
        return dialogConsumePotionOfClumsinessBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.list.removeAllViews();
        for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
            if (adventurer.getPotionsDrank().get(10) != 0) {
                LayoutAdventurerChangeTraitBinding layoutAdventurerChangeTraitBindingInflate = LayoutAdventurerChangeTraitBinding.inflate(getLayoutInflater(), this.binding.list, false);
                if (adventurer.isAscended()) {
                    layoutAdventurerChangeTraitBindingInflate.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended);
                    layoutAdventurerChangeTraitBindingInflate.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended);
                    layoutAdventurerChangeTraitBindingInflate.name.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
                }
                layoutAdventurerChangeTraitBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
                layoutAdventurerChangeTraitBindingInflate.level.setText(String.valueOf(adventurer.getLevel()));
                layoutAdventurerChangeTraitBindingInflate.cardView.setVisibility(adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine") ? 8 : 0);
                layoutAdventurerChangeTraitBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
                layoutAdventurerChangeTraitBindingInflate.name.setText(getString(adventurer.getIdName()));
                layoutAdventurerChangeTraitBindingInflate.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
                layoutAdventurerChangeTraitBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogConsumePotionOfClumsiness.this.m255x13729ce5(adventurer, view);
                    }
                });
                this.binding.list.addView(layoutAdventurerChangeTraitBindingInflate.getRoot());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfClumsiness, reason: not valid java name */
    /* synthetic */ void m255x13729ce5(final Adventurer adventurer, View view) {
        if (this.confirmDialog != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.confirm), String.format(getString(R.string.dialog_clumsiness_confirm), getString(adventurer.getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogConsumePotionOfClumsiness.this.m253x527ff0e3(adventurer, dialogInterface, i);
            }
        });
        this.confirmDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogConsumePotionOfClumsiness.this.m254x32f946e4(dialogInterface);
            }
        });
        this.confirmDialog.show();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfClumsiness, reason: not valid java name */
    /* synthetic */ void m253x527ff0e3(Adventurer adventurer, DialogInterface dialogInterface, int i) {
        Utils.removeItemFromStorage(Item.getInstance("PotionOfClumsiness", 1));
        adventurer.getPotionsDrank().resetAgility();
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfClumsiness, reason: not valid java name */
    /* synthetic */ void m254x32f946e4(DialogInterface dialogInterface) {
        this.confirmDialog = null;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumePotionOfClumsiness.this.m252x8f2820f6(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfClumsiness, reason: not valid java name */
    /* synthetic */ void m252x8f2820f6(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumePotionOfClumsiness = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumePotionOfClumsiness = null;
        super.onStop();
    }
}
