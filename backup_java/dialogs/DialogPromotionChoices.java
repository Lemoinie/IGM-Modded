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
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogPromotionChoicesBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerPromotionBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DialogPromotionChoices extends CustomDialog {
    public static AlertDialog confirmDialog;
    private Adventurer adventurer;
    private DialogPromotionChoicesBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogPromotionChoicesBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.adventurers_dialog_promote_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogPromotionChoicesBinding dialogPromotionChoicesBindingInflate = DialogPromotionChoicesBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogPromotionChoicesBindingInflate;
        return dialogPromotionChoicesBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        Iterator<String> it2 = this.adventurer.getNextClasses().iterator();
        while (it2.hasNext()) {
            final Adventurer adventurer = Adventurer.getInstance(it2.next(), this.adventurer.getId(), 1, 0, this.adventurer.getWeapon(), this.adventurer.getArmor(), this.adventurer.getAccessory(), this.adventurer.getTraitCommon(), this.adventurer.getTraitRare(), this.adventurer.getPotionsDrank(), this.adventurer.getDoctrine(), this.adventurer.isAscended());
            int i = 0;
            LayoutAdventurerPromotionBinding layoutAdventurerPromotionBindingInflate = LayoutAdventurerPromotionBinding.inflate(getLayoutInflater(), this.binding.promotionPossibilities, false);
            if (adventurer.isAscended()) {
                layoutAdventurerPromotionBindingInflate.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended);
                layoutAdventurerPromotionBindingInflate.promotionImage.setBackgroundResource(R.drawable.object_border_rounded_left_ascended);
                layoutAdventurerPromotionBindingInflate.promotionLevelup.setBackgroundResource(R.drawable.object_border_rounded_right_ascended);
                layoutAdventurerPromotionBindingInflate.promotionName.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
            }
            layoutAdventurerPromotionBindingInflate.promotionImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
            layoutAdventurerPromotionBindingInflate.promotionName.setText(getString(adventurer.getIdName()));
            layoutAdventurerPromotionBindingInflate.promotionTraits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
            MaterialCardView materialCardView = layoutAdventurerPromotionBindingInflate.cardView;
            if (adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine")) {
                i = 8;
            }
            materialCardView.setVisibility(i);
            layoutAdventurerPromotionBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
            layoutAdventurerPromotionBindingInflate.promotionLevelup.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.check_brass, getContext().getTheme()));
            final Adventurer adventurer2 = this.adventurer;
            layoutAdventurerPromotionBindingInflate.promotionLevelup.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogPromotionChoices.this.m374x33448440(adventurer2, adventurer, view);
                }
            });
            layoutAdventurerPromotionBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogPromotionChoices.this.m375xb58f391f(adventurer, view);
                }
            });
            this.binding.promotionPossibilities.addView(layoutAdventurerPromotionBindingInflate.getRoot());
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPromotionChoices, reason: not valid java name */
    /* synthetic */ void m374x33448440(Adventurer adventurer, Adventurer adventurer2, View view) {
        showConfirmationDialog(this, adventurer, adventurer2);
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPromotionChoices, reason: not valid java name */
    /* synthetic */ void m375xb58f391f(Adventurer adventurer, View view) {
        UIUtils.getAdventurerDetailDialog(getParentFragmentManager(), adventurer, false, true);
    }

    public static void showConfirmationDialog(final CustomDialog customDialog, Adventurer adventurer, final Adventurer adventurer2) {
        Area next;
        if (confirmDialog != null) {
            return;
        }
        Iterator<Area> it2 = Utils.compileDungeonRaidList().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!next.getAdventurersExploringIds().contains(Integer.valueOf(adventurer.getId())));
        final Area area = next;
        final int iIndexOf = MainActivity.data.getAdventurers().indexOf(adventurer);
        if (iIndexOf == -1) {
            return;
        }
        final boolean z = adventurer2.isAscended() && !adventurer.isAscended();
        String str = String.format(customDialog.getContext().getString(z ? R.string.adventurers_dialog_confirm_ascension_message : R.string.adventurers_dialog_confirm_promotion_message), customDialog.getContext().getString(adventurer.getIdName()), customDialog.getContext().getString(adventurer2.getIdName()));
        if (area != null) {
            str = str + "\n\n" + String.format(customDialog.getContext().getString(R.string.adventurers_dialog_confirm_promotion_message_extra), customDialog.getContext().getString(area.getName()));
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(customDialog.getContext(), Integer.valueOf(R.string.adventurers_dialog_confirm_promotion_title), str, z ? R.string.adventurers_dialog_confirm_ascension_ok : R.string.adventurers_dialog_confirm_promotion_ok, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogPromotionChoices.lambda$showConfirmationDialog$2(iIndexOf, adventurer2, z, area, customDialog, dialogInterface, i);
            }
        });
        confirmDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogPromotionChoices.confirmDialog = null;
            }
        });
        confirmDialog.show();
    }

    static /* synthetic */ void lambda$showConfirmationDialog$2(int i, Adventurer adventurer, boolean z, Area area, CustomDialog customDialog, DialogInterface dialogInterface, int i2) {
        MainActivity.data.getAdventurers().set(i, adventurer);
        MainActivity.adventurersFragment.refresh();
        unlockTierAchievements(adventurer.getMaxLevel() / 5);
        if (!MainActivity.data.isEverAscended() && z) {
            MainActivity.data.setEverAscended(true);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ASCENDED);
        }
        if (area != null) {
            if (area.getAreaType() == 0) {
                area.restartRequested = true;
            } else {
                area.terminationRequested = true;
            }
        }
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.dismiss();
        }
        if (customDialog instanceof DialogPromotionChoices) {
            customDialog.dismiss();
        }
        if (customDialog instanceof DialogConsumePotionOfRejuvenation) {
            customDialog.dismiss();
            Utils.removeItemFromStorage(Item.getInstance("PotionOfRejuvenation", 1));
            Iterator<DoctrineAbility> it2 = adventurer.getDoctrine().getAbilities().iterator();
            while (it2.hasNext()) {
                it2.next().setLevel(0);
            }
            if (MainActivity.shownDialogItemDetail != null) {
                MainActivity.shownDialogItemDetail.initialize(null);
            }
            if (MainActivity.shownDialogStorage != null) {
                MainActivity.shownDialogStorage.update();
            }
        }
        confirmDialog.dismiss();
    }

    private static void unlockTierAchievements(int i) {
        if (i <= MainActivity.data.getMaxAdventurerTier()) {
            return;
        }
        for (int i2 = 2; i2 <= 9; i2++) {
            if (i2 >= MainActivity.data.getMaxAdventurerTier()) {
                switch (i2) {
                    case 2:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_NOVICE);
                    case 3:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_SKILLED);
                    case 4:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_EXPERT);
                    case 5:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_VETERAN);
                    case 6:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_LEGENDARY);
                    case 7:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_MYTHIC);
                    case 8:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FABLED);
                    case 9:
                        AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_DIVINE);
                        break;
                }
            }
        }
        MainActivity.data.setMaxAdventurerTier(i);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogPromotionChoices.this.m373xe5f417ac(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPromotionChoices, reason: not valid java name */
    /* synthetic */ void m373xe5f417ac(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogPromotionChoices = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogPromotionChoices = null;
        super.onStop();
    }

    public Adventurer getAdventurer() {
        return this.adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
}
