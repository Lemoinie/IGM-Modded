package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeFoodBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutPetFeedingBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumeFood extends CustomDialog {
    private DialogConsumeFoodBinding binding;
    public Food selected;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumeFoodBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(this.selected.getIdName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumeFoodBinding dialogConsumeFoodBindingInflate = DialogConsumeFoodBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumeFoodBindingInflate;
        return dialogConsumeFoodBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.feedAll.setChecked(true);
        this.binding.foodSelected.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.selected.getIdImage(), getContext().getTheme()));
        this.binding.foodSelected.stack.setText(String.valueOf(this.selected.getStack()));
        this.binding.list.removeAllViews();
        ArrayList<Pet> arrayList = new ArrayList(MainActivity.data.getPets());
        arrayList.sort(Utils.petsComparator);
        for (final Pet pet : arrayList) {
            final LayoutPetFeedingBinding layoutPetFeedingBindingInflate = LayoutPetFeedingBinding.inflate(getLayoutInflater(), this.binding.list, false);
            layoutPetFeedingBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), pet.getIdImage(), getContext().getTheme()));
            layoutPetFeedingBindingInflate.level.setText(String.valueOf(pet.getLevel()));
            layoutPetFeedingBindingInflate.name.setText(getString(pet.getIdName()));
            int i = pet.totalFoodToNextLevel();
            layoutPetFeedingBindingInflate.detailFood.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(pet.getFood()), Integer.valueOf(i)));
            layoutPetFeedingBindingInflate.detailFoodBar.setProgress((int) (((double) (pet.getFood() * 100)) / ((double) i)));
            layoutPetFeedingBindingInflate.confirm.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeFood$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogConsumeFood.this.m245xc6abfc69(pet, layoutPetFeedingBindingInflate, view);
                }
            });
            this.binding.list.addView(layoutPetFeedingBindingInflate.getRoot());
        }
        refreshListVisibility();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeFood, reason: not valid java name */
    /* synthetic */ void m245xc6abfc69(Pet pet, LayoutPetFeedingBinding layoutPetFeedingBinding, View view) {
        if (this.selected.getStack() <= 0) {
            return;
        }
        pet.feed(this.selected.getFeedPower() * (this.binding.feedAll.isChecked() ? this.selected.getStack() : 1));
        Utils.removeItemFromStorage(Item.getInstance(this.selected.getTrueClass(), this.binding.feedAll.isChecked() ? this.selected.getStack() : 1));
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        MainActivity.headquartersFragment.refresh();
        this.binding.foodSelected.stack.setText(String.valueOf(this.selected.getStack()));
        layoutPetFeedingBinding.level.setText(String.valueOf(pet.getLevel()));
        int i = pet.totalFoodToNextLevel();
        layoutPetFeedingBinding.detailFood.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(pet.getFood()), Integer.valueOf(i)));
        layoutPetFeedingBinding.detailFoodBar.setProgress((int) (((double) (pet.getFood() * 100)) / ((double) i)));
    }

    private void refreshListVisibility() {
        boolean z = this.binding.list.getChildCount() <= 0;
        this.binding.scrollView.setVisibility(z ? 8 : 0);
        this.binding.emptyList.setVisibility(z ? 0 : 8);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeFood$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumeFood.this.m244xd00c823a(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumeFood, reason: not valid java name */
    /* synthetic */ void m244xd00c823a(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumeFood = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumeFood = null;
        super.onStop();
    }
}
