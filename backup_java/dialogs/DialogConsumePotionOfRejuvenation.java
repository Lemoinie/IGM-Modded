package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionOfRejuvenationBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumePotionOfRejuvenation extends CustomDialog {
    private DialogConsumePotionOfRejuvenationBinding binding;
    private AlertDialog confirmDialog;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumePotionOfRejuvenationBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_consume_evo23_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumePotionOfRejuvenationBinding dialogConsumePotionOfRejuvenationBindingInflate = DialogConsumePotionOfRejuvenationBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumePotionOfRejuvenationBindingInflate;
        return dialogConsumePotionOfRejuvenationBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.list.removeAllViews();
        for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
            int i = 0;
            LayoutAdventurerChangeTraitBinding layoutAdventurerChangeTraitBindingInflate = LayoutAdventurerChangeTraitBinding.inflate(getLayoutInflater(), this.binding.list, false);
            if (adventurer.isAscended()) {
                layoutAdventurerChangeTraitBindingInflate.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended);
                layoutAdventurerChangeTraitBindingInflate.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended);
                layoutAdventurerChangeTraitBindingInflate.name.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
            }
            layoutAdventurerChangeTraitBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
            layoutAdventurerChangeTraitBindingInflate.level.setText(String.valueOf(adventurer.getLevel()));
            MaterialCardView materialCardView = layoutAdventurerChangeTraitBindingInflate.cardView;
            if (adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine")) {
                i = 8;
            }
            materialCardView.setVisibility(i);
            layoutAdventurerChangeTraitBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
            layoutAdventurerChangeTraitBindingInflate.name.setText(getString(adventurer.getIdName()));
            layoutAdventurerChangeTraitBindingInflate.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
            layoutAdventurerChangeTraitBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfRejuvenation$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogConsumePotionOfRejuvenation.this.m257x9a3d4569(adventurer, view);
                }
            });
            this.binding.list.addView(layoutAdventurerChangeTraitBindingInflate.getRoot());
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfRejuvenation, reason: not valid java name */
    /* synthetic */ void m257x9a3d4569(Adventurer adventurer, View view) {
        DialogPromotionChoices.showConfirmationDialog(this, adventurer, Adventurer.getInstance(Utils.getBaseClass(adventurer), adventurer.getId(), 1, 0, adventurer.getWeapon(), adventurer.getArmor(), adventurer.getAccessory(), adventurer.getTraitCommon(), adventurer.getTraitRare(), adventurer.getPotionsDrank(), adventurer.getDoctrine(), adventurer.isAscended()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfRejuvenation$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumePotionOfRejuvenation.this.m256xfea2093a(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotionOfRejuvenation, reason: not valid java name */
    /* synthetic */ void m256xfea2093a(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumePotionOfRejuvenation = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumePotionOfRejuvenation = null;
        super.onStop();
    }
}
