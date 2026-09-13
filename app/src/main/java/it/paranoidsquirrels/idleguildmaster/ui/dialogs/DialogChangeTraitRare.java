package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChangeTraitRareBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTraitBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DialogChangeTraitRare extends CustomDialog {
    public Adventurer adventurer;
    public boolean alternative;
    private DialogChangeTraitRareBinding binding;
    private AlertDialog confirm;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogChangeTraitRareBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_change_trait_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogChangeTraitRareBinding dialogChangeTraitRareBindingInflate = DialogChangeTraitRareBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogChangeTraitRareBindingInflate;
        return dialogChangeTraitRareBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.current.name.setText(getString(this.adventurer.getTraitRare() == null ? R.string.trait_null_name : this.adventurer.getTraitRare().name));
        this.binding.current.description.setText(getString(this.adventurer.getTraitRare() == null ? R.string.trait_null_description : this.adventurer.getTraitRare().description));
        ArrayList arrayList = new ArrayList(Arrays.asList(Trait.EMPATHETIC, Trait.GIFTED, Trait.INTIMIDATING, Trait.FOCUSED, Trait.DRAGON_BLOOD, Trait.CURSED, Trait.REACTIVE, Trait.NOCTURNAL, Trait.MINDFUL, Trait.TROLL_BLOOD, Trait.NIMBLE, Trait.RUTHLESS, Trait.BLESSED, Trait.ALERT));
        if (this.adventurer.getTraitRare() != null) {
            arrayList.remove(this.adventurer.getTraitRare());
        }
        this.binding.list.removeAllViews();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            addTraitToList((Trait) it2.next());
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChangeTraitRare.this.m232xf5ffe7f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChangeTraitRare, reason: not valid java name */
    /* synthetic */ void m232xf5ffe7f(View view) {
        dismiss();
    }

    private void addTraitToList(final Trait trait) {
        LayoutTraitBinding layoutTraitBindingInflate = LayoutTraitBinding.inflate(getLayoutInflater(), this.binding.list, false);
        layoutTraitBindingInflate.name.setText(getString(trait.name));
        layoutTraitBindingInflate.description.setText(getString(trait.description));
        layoutTraitBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChangeTraitRare.this.m231x57fb4828(trait, view);
            }
        });
        this.binding.list.addView(layoutTraitBindingInflate.getRoot());
    }

    /* JADX INFO: renamed from: lambda$addTraitToList$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChangeTraitRare, reason: not valid java name */
    /* synthetic */ void m231x57fb4828(final Trait trait, View view) {
        if (this.confirm != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.dialog_change_trait_confirm_title), String.format(getString(R.string.dialog_change_trait_confirm_body), getString(this.adventurer.getIdName()), getString(this.adventurer.getTraitRare() == null ? R.string.trait_null_name : this.adventurer.getTraitRare().name), getString(trait.name)), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogChangeTraitRare.this.m229x91a3e1a6(trait, dialogInterface, i);
            }
        });
        this.confirm = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogChangeTraitRare.this.m230x74cf94e7(dialogInterface);
            }
        });
        this.confirm.show();
    }

    /* JADX INFO: renamed from: lambda$addTraitToList$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChangeTraitRare, reason: not valid java name */
    /* synthetic */ void m229x91a3e1a6(Trait trait, DialogInterface dialogInterface, int i) {
        this.adventurer.changeRareTrait(trait);
        Utils.removeItemFromStorage(Item.getInstance(this.alternative ? "Evo23Vial2" : "Evo23Vial", 1));
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
        }
        MainActivity.headquartersFragment.refresh();
        MainActivity.adventurersFragment.refresh();
        if (MainActivity.shownDialogConsumeEvo23 != null) {
            MainActivity.shownDialogConsumeEvo23.dismiss();
        }
        if (MainActivity.shownDialogChangeTraitRare != null) {
            MainActivity.shownDialogChangeTraitRare.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: renamed from: lambda$addTraitToList$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChangeTraitRare, reason: not valid java name */
    /* synthetic */ void m230x74cf94e7(DialogInterface dialogInterface) {
        this.confirm = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogChangeTraitRare = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogChangeTraitRare = null;
        super.onStop();
    }
}
