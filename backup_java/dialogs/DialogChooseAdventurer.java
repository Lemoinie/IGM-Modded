package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChooseAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogChooseAdventurer extends CustomDialog {
    private DialogChooseAdventurerBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogChooseAdventurerBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.select_adventurer);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogChooseAdventurerBinding dialogChooseAdventurerBindingInflate = DialogChooseAdventurerBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogChooseAdventurerBindingInflate;
        return dialogChooseAdventurerBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        final int i = bundle.getInt("positionClicked");
        final List<Integer> list = MainActivity.shownDialogSendTeam.selectedAdventurersId;
        List<Adventurer> idleAdventurers = Utils.getIdleAdventurers((Integer[]) list.toArray(new Integer[0]));
        for (final Adventurer adventurer : idleAdventurers) {
            LayoutAdventurerBinding layoutAdventurerBindingInflate = LayoutAdventurerBinding.inflate(getLayoutInflater(), this.binding.list, false);
            if (adventurer.isAscended()) {
                UIUtils.applyAscendedPalette(layoutAdventurerBindingInflate);
            }
            layoutAdventurerBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
            layoutAdventurerBindingInflate.name.setText(getString(adventurer.getIdName()));
            layoutAdventurerBindingInflate.cardView.setVisibility(adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine") ? 8 : 0);
            layoutAdventurerBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
            layoutAdventurerBindingInflate.expendableDoctrinePoints.setVisibility(8);
            layoutAdventurerBindingInflate.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
            layoutAdventurerBindingInflate.weapon.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getWeapon(), getContext()));
            layoutAdventurerBindingInflate.armor.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getArmor(), getContext()));
            layoutAdventurerBindingInflate.accessory.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getAccessory(), getContext()));
            layoutAdventurerBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseAdventurer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogChooseAdventurer.this.m234x446c4c4a(i, list, adventurer, view);
                }
            });
            this.binding.list.addView(layoutAdventurerBindingInflate.getRoot());
        }
        this.binding.scrollView.setVisibility(idleAdventurers.isEmpty() ? 8 : 0);
        this.binding.noAdventurers.setVisibility(idleAdventurers.isEmpty() ? 0 : 8);
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChooseAdventurer, reason: not valid java name */
    /* synthetic */ void m234x446c4c4a(int i, List list, Adventurer adventurer, View view) {
        if (i >= list.size()) {
            list.add(list.size(), Integer.valueOf(adventurer.getId()));
        } else {
            list.remove(i);
            list.add(i, Integer.valueOf(adventurer.getId()));
        }
        if (MainActivity.shownDialogSendTeam != null) {
            MainActivity.shownDialogSendTeam.setupAdventurers();
        }
        dismiss();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseAdventurer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChooseAdventurer.this.m233x703bc119(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChooseAdventurer, reason: not valid java name */
    /* synthetic */ void m233x703bc119(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogChooseAdventurer = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogChooseAdventurer = null;
        super.onStop();
    }
}
