package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeEvo23Binding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumeEvo23 extends CustomDialog {
    public boolean alternative;
    private DialogConsumeEvo23Binding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumeEvo23Binding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_consume_evo23_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumeEvo23Binding dialogConsumeEvo23BindingInflate = DialogConsumeEvo23Binding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumeEvo23BindingInflate;
        return dialogConsumeEvo23BindingInflate;
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
            layoutAdventurerChangeTraitBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo23$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogConsumeEvo23.this.m243xec8a1f4(adventurer, view);
                }
            });
            this.binding.list.addView(layoutAdventurerChangeTraitBindingInflate.getRoot());
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeEvo23, reason: not valid java name */
    /* synthetic */ void m243xec8a1f4(Adventurer adventurer, View view) {
        if (MainActivity.shownDialogChangeTraitRare != null) {
            return;
        }
        DialogChangeTraitRare dialogChangeTraitRare = new DialogChangeTraitRare();
        dialogChangeTraitRare.adventurer = adventurer;
        dialogChangeTraitRare.alternative = this.alternative;
        dialogChangeTraitRare.show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_change_trait_rare");
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo23$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumeEvo23.this.m242x3178d643(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeEvo23, reason: not valid java name */
    /* synthetic */ void m242x3178d643(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumeEvo23 = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumeEvo23 = null;
        super.onStop();
    }
}
