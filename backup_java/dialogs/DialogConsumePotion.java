package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerPotionsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;

/* JADX INFO: loaded from: classes3.dex */
public class DialogConsumePotion extends CustomDialog {
    private DialogConsumePotionBinding binding;
    public Potion selected;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogConsumePotionBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(this.selected.getIdName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogConsumePotionBinding dialogConsumePotionBindingInflate = DialogConsumePotionBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogConsumePotionBindingInflate;
        return dialogConsumePotionBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.potionSelected.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.selected.getIdImage(), getContext().getTheme()));
        this.binding.potionSelected.stack.setText(String.valueOf(this.selected.getStack()));
        this.binding.list.removeAllViews();
        for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
            final int iCalculateMaxPotions = adventurer.calculateMaxPotions(this.selected.getPotionType());
            int i = adventurer.getPotionsDrank().get(this.selected.getPotionType());
            if (i < iCalculateMaxPotions) {
                final LayoutAdventurerPotionsBinding layoutAdventurerPotionsBindingInflate = LayoutAdventurerPotionsBinding.inflate(getLayoutInflater(), this.binding.list, false);
                if (adventurer.isAscended()) {
                    layoutAdventurerPotionsBindingInflate.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended);
                    layoutAdventurerPotionsBindingInflate.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended);
                    layoutAdventurerPotionsBindingInflate.potionsContainer.setBackgroundResource(R.drawable.object_border_rounded_right_ascended);
                    layoutAdventurerPotionsBindingInflate.name.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
                    layoutAdventurerPotionsBindingInflate.potionAmount.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
                }
                layoutAdventurerPotionsBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
                layoutAdventurerPotionsBindingInflate.level.setText(String.valueOf(adventurer.getLevel()));
                layoutAdventurerPotionsBindingInflate.cardView.setVisibility(adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine") ? 8 : 0);
                layoutAdventurerPotionsBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
                layoutAdventurerPotionsBindingInflate.name.setText(getString(adventurer.getIdName()));
                layoutAdventurerPotionsBindingInflate.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
                layoutAdventurerPotionsBindingInflate.potionAmount.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(i), Integer.valueOf(iCalculateMaxPotions)));
                layoutAdventurerPotionsBindingInflate.potionsContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogConsumePotion.this.m251xdcb162de(adventurer, layoutAdventurerPotionsBindingInflate, iCalculateMaxPotions, view);
                    }
                });
                this.binding.list.addView(layoutAdventurerPotionsBindingInflate.getRoot());
            }
        }
        refreshListVisibility();
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotion, reason: not valid java name */
    /* synthetic */ void m251xdcb162de(Adventurer adventurer, LayoutAdventurerPotionsBinding layoutAdventurerPotionsBinding, int i, View view) {
        if (this.selected.getStack() <= 0) {
            return;
        }
        adventurer.getPotionsDrank().increase(this.selected.getPotionType());
        Utils.removeItemFromStorage(Item.getInstance(this.selected.getTrueClass(), 1));
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        MainActivity.headquartersFragment.refresh();
        this.binding.potionSelected.stack.setText(String.valueOf(this.selected.getStack()));
        int i2 = adventurer.getPotionsDrank().get(this.selected.getPotionType());
        layoutAdventurerPotionsBinding.potionAmount.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(i2), Integer.valueOf(i)));
        if (i2 >= i) {
            this.binding.list.removeView(layoutAdventurerPotionsBinding.getRoot());
            refreshListVisibility();
            checkHeavyDrinker(adventurer);
        }
    }

    private void refreshListVisibility() {
        boolean z = this.binding.list.getChildCount() <= 0;
        this.binding.scrollView.setVisibility(z ? 8 : 0);
        this.binding.emptyList.setVisibility(z ? 0 : 8);
    }

    public static void checkHeavyDrinker(Adventurer adventurer) {
        if (MainActivity.data.isPotsMaxed() || adventurer.getPotionsDrank().get(0) < adventurer.calculateMaxPotions(0) || adventurer.getPotionsDrank().get(1) < adventurer.calculateMaxPotions(1) || adventurer.getPotionsDrank().get(2) < adventurer.calculateMaxPotions(2) || adventurer.getPotionsDrank().get(3) < adventurer.calculateMaxPotions(3) || adventurer.getPotionsDrank().get(4) < adventurer.calculateMaxPotions(4) || adventurer.getPotionsDrank().get(5) < adventurer.calculateMaxPotions(5) || adventurer.getPotionsDrank().get(6) < adventurer.calculateMaxPotions(6) || adventurer.getPotionsDrank().get(7) < adventurer.calculateMaxPotions(7) || adventurer.getPotionsDrank().get(8) < adventurer.calculateMaxPotions(8) || adventurer.getPotionsDrank().get(9) < adventurer.calculateMaxPotions(9) || adventurer.getPotionsDrank().get(10) < adventurer.calculateMaxPotions(10)) {
            return;
        }
        MainActivity.data.setPotsMaxed(true);
        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_HEAVY_DRINKER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogConsumePotion.this.m250x1007b86f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogConsumePotion, reason: not valid java name */
    /* synthetic */ void m250x1007b86f(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogConsumePotion = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogConsumePotion = null;
        super.onStop();
    }
}
