package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRecallAdventurersBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogRecallAdventurers extends CustomDialog {
    private DialogRecallAdventurersBinding binding;
    private AlertDialog confirmDialog;
    private AlertDialog noSpaceDialog;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogRecallAdventurersBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.drawer_recall_adventurers_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogRecallAdventurersBinding dialogRecallAdventurersBindingInflate = DialogRecallAdventurersBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogRecallAdventurersBindingInflate;
        return dialogRecallAdventurersBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.list.removeAllViews();
        List<Adventurer> dismissedAdventurers = MainActivity.data.getDismissedAdventurers();
        Iterator<Adventurer> it2 = dismissedAdventurers.iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                break;
            }
            final Adventurer next = it2.next();
            LayoutAdventurerBinding layoutAdventurerBindingInflate = LayoutAdventurerBinding.inflate(getLayoutInflater(), this.binding.list, false);
            if (next.isAscended()) {
                UIUtils.applyAscendedPalette(layoutAdventurerBindingInflate);
            }
            layoutAdventurerBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), next.getImageId(), getContext().getTheme()));
            layoutAdventurerBindingInflate.level.setText(String.valueOf(next.getLevel()));
            layoutAdventurerBindingInflate.name.setText(getString(next.getIdName()));
            MaterialCardView materialCardView = layoutAdventurerBindingInflate.cardView;
            if (next.getDoctrine().getTrueClass().equals("EmptyDoctrine")) {
                i = 8;
            }
            materialCardView.setVisibility(i);
            layoutAdventurerBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), next.getDoctrine().getIdImage(), getContext().getTheme()));
            layoutAdventurerBindingInflate.expendableDoctrinePoints.setVisibility(8);
            layoutAdventurerBindingInflate.traits.setText(UIUtils.traitsToShortString(next, getResources()));
            layoutAdventurerBindingInflate.weapon.setImageDrawable(Utils.getEquipmentDrawable(next.getWeapon(), getContext()));
            layoutAdventurerBindingInflate.accessory.setImageDrawable(Utils.getEquipmentDrawable(next.getAccessory(), getContext()));
            layoutAdventurerBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogRecallAdventurers.this.m387xd35bb132(next, view);
                }
            });
            this.binding.list.addView(layoutAdventurerBindingInflate.getRoot());
        }
        this.binding.scrollView.setVisibility(dismissedAdventurers.isEmpty() ? 8 : 0);
        this.binding.emptyList.setVisibility(dismissedAdventurers.isEmpty() ? 0 : 8);
    }

    /* JADX INFO: renamed from: lambda$initialize$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecallAdventurers, reason: not valid java name */
    /* synthetic */ void m387xd35bb132(final Adventurer adventurer, View view) {
        if (Formulas.getQuartersCapacity() <= MainActivity.data.getAdventurers().size()) {
            if (this.noSpaceDialog != null) {
                return;
            }
            AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.drawer_recall_adventurers_warning_no_space_header), String.format(getString(R.string.drawer_recall_adventurers_warning_no_space_body), getString(adventurer.getIdName())), false);
            this.noSpaceDialog = infoDialog;
            infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogRecallAdventurers.this.m384x7e37fc2f(dialogInterface);
                }
            });
            this.noSpaceDialog.show();
            return;
        }
        if (this.confirmDialog != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.drawer_recall_adventurers_title), String.format(getString(R.string.drawer_recall_adventurers_confirmation_body), getString(adventurer.getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogRecallAdventurers.this.m385x4543e330(adventurer, dialogInterface, i);
            }
        });
        this.confirmDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogRecallAdventurers.this.m386xc4fca31(dialogInterface);
            }
        });
        this.confirmDialog.show();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecallAdventurers, reason: not valid java name */
    /* synthetic */ void m384x7e37fc2f(DialogInterface dialogInterface) {
        this.noSpaceDialog = null;
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecallAdventurers, reason: not valid java name */
    /* synthetic */ void m385x4543e330(Adventurer adventurer, DialogInterface dialogInterface, int i) {
        MainActivity.data.getDismissedAdventurers().remove(adventurer);
        if (adventurer.getId() >= 0) {
            adventurer.setId(Utils.calculateNewAdventurerId());
        }
        MainActivity.data.getAdventurers().add(adventurer);
        Utils.triggerGuildSizeAchievementCheck();
        initialize(null);
        MainActivity.headquartersFragment.refresh();
        MainActivity.adventurersFragment.refresh();
        MainActivity.adventurersFragment.switchMode(0);
    }

    /* JADX INFO: renamed from: lambda$initialize$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecallAdventurers, reason: not valid java name */
    /* synthetic */ void m386xc4fca31(DialogInterface dialogInterface) {
        this.confirmDialog = null;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRecallAdventurers.this.m383x217ad643(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecallAdventurers, reason: not valid java name */
    /* synthetic */ void m383x217ad643(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogRecallAdventurers = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogRecallAdventurers = null;
        super.onStop();
    }
}
