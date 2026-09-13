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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMergePetBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutPetFeedingBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogMergePet extends CustomDialog {
    private DialogMergePetBinding binding;
    private AlertDialog confirmDialog;
    public Pet selected;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogMergePetBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return String.format(getString(R.string.pet_merge_title), getString(this.selected.getIdName()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogMergePetBinding dialogMergePetBindingInflate = DialogMergePetBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogMergePetBindingInflate;
        return dialogMergePetBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        final int iRound = Utils.round(((double) this.selected.calculateTotalFoodGiven()) * 0.8d);
        this.binding.foodSelected.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.selected.getIdImage(), getContext().getTheme()));
        this.binding.foodSelected.stack.setText(String.valueOf(this.selected.getLevel()));
        this.binding.description.setText(String.format(getString(R.string.pet_merge_description), Integer.valueOf(iRound)));
        this.binding.list.removeAllViews();
        ArrayList<Pet> arrayList = new ArrayList(MainActivity.data.getPets());
        arrayList.remove(this.selected);
        arrayList.sort(Utils.petsComparator);
        for (final Pet pet : arrayList) {
            LayoutPetFeedingBinding layoutPetFeedingBindingInflate = LayoutPetFeedingBinding.inflate(getLayoutInflater(), this.binding.list, false);
            layoutPetFeedingBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), pet.getIdImage(), getContext().getTheme()));
            layoutPetFeedingBindingInflate.level.setText(String.valueOf(pet.getLevel()));
            layoutPetFeedingBindingInflate.name.setText(getString(pet.getIdName()));
            int i = pet.totalFoodToNextLevel();
            layoutPetFeedingBindingInflate.detailFood.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(pet.getFood()), Integer.valueOf(i)));
            layoutPetFeedingBindingInflate.detailFoodBar.setProgress((int) (((double) (pet.getFood() * 100)) / ((double) i)));
            layoutPetFeedingBindingInflate.confirm.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogMergePet.this.m366xa4b411f6(pet, iRound, view);
                }
            });
            this.binding.list.addView(layoutPetFeedingBindingInflate.getRoot());
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMergePet, reason: not valid java name */
    /* synthetic */ void m366xa4b411f6(final Pet pet, final int i, View view) {
        final ArrayList arrayList = new ArrayList();
        Area areaFound = null;
        for (Area area2 : Utils.compileDungeonRaidList()) {
            if (areaFound == null && area2.getPetExploringId() != null && area2.getPetExploringId().equals(Integer.valueOf(this.selected.getId()))) {
                areaFound = area2;
            }
            if (area2.getSavedPetId() != null && area2.getSavedPetId().equals(Integer.valueOf(this.selected.getId()))) {
                arrayList.add(area2);
            }
        }
        final Area area = areaFound;
        String str = "" + String.format(getString(R.string.pet_merge_body), getString(this.selected.getIdName()), getString(pet.getIdName()));
        if (area != null) {
            str = str + "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon_pet), getString(area.getName()));
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.pet_merge), str, R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DialogMergePet.this.m364xa7f20a38(pet, i, arrayList, area, dialogInterface, i2);
            }
        });
        this.confirmDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogMergePet.this.m365x26530e17(dialogInterface);
            }
        });
        this.confirmDialog.show();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMergePet, reason: not valid java name */
    /* synthetic */ void m364xa7f20a38(Pet pet, int i, List list, Area area, DialogInterface dialogInterface, int i2) {
        MainActivity.data.getPets().remove(this.selected);
        pet.feed(i);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((Area) it2.next()).setSavedPetId(null);
        }
        if (area != null) {
            area.terminationRequested = true;
        }
        if (MainActivity.shownDialogShelter != null) {
            MainActivity.shownDialogShelter.refresh();
        }
        MainActivity.headquartersFragment.refresh();
        if (MainActivity.shownDialogPetDetail != null) {
            MainActivity.shownDialogPetDetail.dismiss();
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMergePet, reason: not valid java name */
    /* synthetic */ void m365x26530e17(DialogInterface dialogInterface) {
        this.confirmDialog = null;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMergePet.this.m363xaf90c5c5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMergePet, reason: not valid java name */
    /* synthetic */ void m363xaf90c5c5(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogMergePet = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogMergePet = null;
        super.onStop();
    }
}
