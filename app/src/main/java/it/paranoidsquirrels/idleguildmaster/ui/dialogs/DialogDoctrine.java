package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDoctrineBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDoctrineAbilityBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class DialogDoctrine extends CustomDialog {
    private static DecimalFormat df = new DecimalFormat("#.#");
    private Adventurer adventurer;
    private DialogDoctrineBinding binding;
    private AlertDialog confirmChoose;
    private Doctrine doctrine;
    private TextView levelOfSelectedUI;
    private boolean openWithAvailablePoints;
    private boolean readOnly;
    private DoctrineAbility selected;
    private MaterialCardView selectedUI;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogDoctrineBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        try {
            return getString(this.doctrine.getIdName());
        } catch (Exception unused) {
            dismiss();
            return "";
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogDoctrineBinding dialogDoctrineBindingInflate = DialogDoctrineBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogDoctrineBindingInflate;
        return dialogDoctrineBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        if (this.doctrine == null) {
            dismiss();
            return;
        }
        int doctrinePoints = this.adventurer.getDoctrinePoints();
        this.openWithAvailablePoints = doctrinePoints > 0;
        TextView textView = this.binding.loyaltyPoints;
        String string = getString(R.string.dialog_doctrine_loyalty_points_formatted);
        if (this.readOnly) {
            doctrinePoints = this.adventurer.simulateDoctrinePoints(this.doctrine);
        }
        textView.setText(String.format(string, Integer.valueOf(doctrinePoints)));
        String str = String.format(getString(R.string.dialog_doctrine_loyalty_points_bonus_formatted), Integer.valueOf(this.doctrine.bonusQuestPoints()), Integer.valueOf(this.adventurer.doctrinePointsFromLevels()));
        if (this.adventurer.getLevel() < 45) {
            str = str + " " + String.format(getString(R.string.dialog_doctrine_loyalty_points_bonus_addendum), Integer.valueOf(15 - (((int) (((double) this.adventurer.getLevel()) + ((((double) (this.adventurer.getMaxLevel() - 5)) * 0.5d) * ((double) (this.adventurer.getMaxLevel() / 5))))) % 15)));
        }
        this.binding.lpFromQuests.setText(str);
        clearAbilitySelected();
        this.binding.description.setText(this.doctrine.getIdDescription());
        this.binding.abilitiesRow1.removeAllViews();
        this.binding.abilitiesRow2.removeAllViews();
        this.binding.abilitiesRow3.removeAllViews();
        for (final DoctrineAbility doctrineAbility : this.doctrine.getAbilities()) {
            LinearLayout correctRow = getCorrectRow(doctrineAbility.getType().row);
            final LayoutDoctrineAbilityBinding layoutDoctrineAbilityBindingInflate = LayoutDoctrineAbilityBinding.inflate(getLayoutInflater(), correctRow, false);
            layoutDoctrineAbilityBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), doctrineAbility.getType().image, getContext().getTheme()));
            layoutDoctrineAbilityBindingInflate.level.setText(String.valueOf(doctrineAbility.getLevel()));
            layoutDoctrineAbilityBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogDoctrine.this.m271xf92a8edb(doctrineAbility, layoutDoctrineAbilityBindingInflate, view);
                }
            });
            correctRow.addView(layoutDoctrineAbilityBindingInflate.getRoot());
        }
        DoctrineAbility doctrineAbility2 = this.selected;
        if (doctrineAbility2 != null) {
            onClick(doctrineAbility2);
        }
        this.binding.reset.setVisibility(this.readOnly ? 8 : 0);
        this.binding.choose.setVisibility(this.readOnly ? 0 : 8);
    }

    /* JADX INFO: renamed from: lambda$initialize$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m271xf92a8edb(DoctrineAbility doctrineAbility, LayoutDoctrineAbilityBinding layoutDoctrineAbilityBinding, View view) {
        onClick(doctrineAbility);
        MaterialCardView materialCardView = layoutDoctrineAbilityBinding.cardView;
        this.selectedUI = materialCardView;
        materialCardView.setStrokeWidth(2);
        this.levelOfSelectedUI = layoutDoctrineAbilityBinding.level;
    }

    private void onClick(DoctrineAbility doctrineAbility) {
        MaterialCardView materialCardView = this.selectedUI;
        if (materialCardView != null) {
            materialCardView.setStrokeWidth(0);
            this.selectedUI = null;
        }
        if (doctrineAbility == null) {
            clearAbilitySelected();
            return;
        }
        this.selected = doctrineAbility;
        updatePlusMinusVisibility(doctrineAbility);
        updateDescription(doctrineAbility);
    }

    private void updatePlusMinusVisibility(DoctrineAbility doctrineAbility) {
        if (this.readOnly) {
            return;
        }
        this.binding.plus.setVisibility(doctrineAbility.getLevel() < doctrineAbility.getType().maxLevel ? 0 : 8);
        this.binding.minus.setVisibility(doctrineAbility.getLevel() <= 0 ? 8 : 0);
    }

    private void updateDescription(DoctrineAbility doctrineAbility) {
        String string;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        this.binding.name.setVisibility(0);
        this.binding.cost.setVisibility(0);
        this.binding.name.setText(String.format(getString(R.string.dialog_doctrine_name_level_formatted), getString(doctrineAbility.getType().nameRes), Integer.valueOf(doctrineAbility.getLevel()), Integer.valueOf(doctrineAbility.getType().maxLevel)));
        this.binding.cost.setText(String.valueOf(doctrineAbility.getType().cost));
        int i = doctrineAbility.getType().formatMode;
        if (i != 0) {
            if (i == 1) {
                z = doctrineAbility.getLevel() >= doctrineAbility.getType().maxLevel;
                String strValueOf = String.valueOf(doctrineAbility.getType().increasePerLevel * doctrineAbility.getLevel());
                str = z ? "" : String.format(getString(R.string.doctrine_ability_increased_arg), String.valueOf(doctrineAbility.getType().increasePerLevel));
                if (z) {
                    str2 = String.format(getString(R.string.doctrine_ability_max_flat), strValueOf);
                } else {
                    str2 = String.format(getString(R.string.doctrine_ability_increased_flat), strValueOf, str);
                }
                string = String.format(getString(doctrineAbility.getType().description), str2);
            } else if (i == 2) {
                z = doctrineAbility.getLevel() >= doctrineAbility.getType().maxLevel;
                String strValueOf2 = String.valueOf(doctrineAbility.getType().increasePerLevel * doctrineAbility.getLevel());
                str = z ? "" : String.format(getString(R.string.doctrine_ability_increased_arg), String.valueOf(doctrineAbility.getType().increasePerLevel));
                if (z) {
                    str3 = String.format(getString(R.string.doctrine_ability_max_percent), strValueOf2);
                } else {
                    str3 = String.format(getString(R.string.doctrine_ability_increased_percent), strValueOf2, str);
                }
                string = String.format(getString(doctrineAbility.getType().description), str3);
            } else if (i != 3) {
                string = null;
            } else {
                z = doctrineAbility.getLevel() >= doctrineAbility.getType().maxLevel;
                String str5 = df.format(((double) (doctrineAbility.getType().increasePerLevel * doctrineAbility.getLevel())) * 0.1d);
                str = z ? "" : String.format(getString(R.string.doctrine_ability_increased_arg), df.format(((double) doctrineAbility.getType().increasePerLevel) * 0.1d));
                if (z) {
                    str4 = String.format(getString(R.string.doctrine_ability_max_percent), str5);
                } else {
                    str4 = String.format(getString(R.string.doctrine_ability_increased_percent), str5, str);
                }
                string = String.format(getString(doctrineAbility.getType().description), str4);
            }
        } else {
            string = getString(doctrineAbility.getType().description);
        }
        this.binding.description.setText(string);
    }

    private void clearAbilitySelected() {
        this.selected = null;
        this.binding.name.setVisibility(8);
        this.binding.cost.setVisibility(8);
        this.binding.plus.setVisibility(8);
        this.binding.minus.setVisibility(8);
        this.binding.description.setText("");
    }

    private LinearLayout getCorrectRow(int i) {
        if (i == 1) {
            return this.binding.abilitiesRow1;
        }
        if (i == 2) {
            return this.binding.abilitiesRow2;
        }
        if (i == 3) {
            return this.binding.abilitiesRow3;
        }
        return this.binding.abilitiesRow1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m262x40742aa(view);
            }
        });
        this.binding.minus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m263x82684689(view);
            }
        });
        this.binding.plus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m265x7f2a4e47(view);
            }
        });
        this.binding.choose.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m268xfa4d59e4(view);
            }
        });
        this.binding.reset.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m269x78ae5dc3(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDoctrine.this.m270xf70f61a2(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m262x40742aa(View view) {
        onClick(null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m263x82684689(View view) {
        int iCalculateTotalMaxHp;
        DoctrineAbility doctrineAbility = this.selected;
        if (doctrineAbility == null || this.selectedUI == null || doctrineAbility.getLevel() <= 0) {
            return;
        }
        int level = this.selected.getLevel() - 1;
        this.selected.setLevel(level);
        this.doctrine.realignLevels();
        this.levelOfSelectedUI.setText(String.valueOf(level));
        updateDescription(this.selected);
        updatePlusMinusVisibility(this.selected);
        this.binding.loyaltyPoints.setText(String.format(getString(R.string.dialog_doctrine_loyalty_points_formatted), Integer.valueOf(this.adventurer.getDoctrinePoints())));
        if (this.selected.getType() == DoctrineAbilityType.WEAPON_MASTER) {
            removeWeaponMaster(getResources(), this.adventurer);
        }
        if ((this.selected.getType() == DoctrineAbilityType.IMPROVED_HEALTH || this.selected.getType() == DoctrineAbilityType.EXALTED_HEALTH || this.selected.getType() == DoctrineAbilityType.LORE_MASTER) && this.adventurer.getCurrentHp() > (iCalculateTotalMaxHp = this.adventurer.calculateTotalMaxHp())) {
            this.adventurer.setCurrentHp(iCalculateTotalMaxHp);
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m265x7f2a4e47(View view) {
        DoctrineAbility doctrineAbility = this.selected;
        if (doctrineAbility == null || this.selectedUI == null || doctrineAbility.getLevel() >= this.selected.getType().maxLevel) {
            return;
        }
        if (this.adventurer.getDoctrinePoints() < this.selected.getType().cost) {
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getContext().getColor(R.color.dim_white), getContext().getColor(UIUtils.getFailureColor()), getContext().getColor(R.color.dim_white));
            valueAnimatorOfArgb.setInterpolator(new LinearInterpolator());
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DialogDoctrine.this.m264xc94a68(valueAnimator);
                }
            });
            valueAnimatorOfArgb.setDuration(750L);
            valueAnimatorOfArgb.start();
            return;
        }
        int level = this.selected.getLevel() + 1;
        this.selected.setLevel(level);
        this.doctrine.realignLevels();
        this.levelOfSelectedUI.setText(String.valueOf(level));
        updateDescription(this.selected);
        updatePlusMinusVisibility(this.selected);
        this.binding.loyaltyPoints.setText(String.format(getString(R.string.dialog_doctrine_loyalty_points_formatted), Integer.valueOf(this.adventurer.getDoctrinePoints())));
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m264xc94a68(ValueAnimator valueAnimator) {
        this.binding.cost.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.binding.loyaltyPoints.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m268xfa4d59e4(View view) {
        if (this.confirmChoose != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.confirm), String.format(getString(R.string.dialog_doctrine_confirm_choose), getString(this.adventurer.getIdName()), getString(this.doctrine.getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogDoctrine.this.m266xfd8b5226(dialogInterface, i);
            }
        });
        this.confirmChoose = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogDoctrine.this.m267x7bec5605(dialogInterface);
            }
        });
        this.confirmChoose.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m266xfd8b5226(DialogInterface dialogInterface, int i) {
        this.adventurer.setDoctrine(this.doctrine);
        this.readOnly = false;
        if (MainActivity.shownDialogChooseDoctrine != null) {
            MainActivity.shownDialogChooseDoctrine.dismiss();
        }
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
        }
        MainActivity.adventurersFragment.refresh();
        initialize(null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m267x7bec5605(DialogInterface dialogInterface) {
        this.confirmChoose = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m269x78ae5dc3(View view) {
        if (MainActivity.shownDialogDoctrineReset != null) {
            return;
        }
        MainActivity.shownDialogDoctrineReset = new DialogDoctrineReset();
        MainActivity.shownDialogDoctrineReset.setAdventurer(this.adventurer);
        MainActivity.shownDialogDoctrineReset.show(getParentFragmentManager(), "dialog_reset_doctrine");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDoctrine, reason: not valid java name */
    /* synthetic */ void m270xf70f61a2(View view) {
        dismiss();
    }

    public static void removeWeaponMaster(Resources resources, Adventurer adventurer) {
        if (adventurer.getWeapon().printType() == adventurer.getWeaponType()) {
            return;
        }
        Weapon defaultWeapon = Utils.getDefaultWeapon(adventurer.getWeaponType());
        Utils.collectItem(adventurer.getWeapon(), MainActivity.data.getItems());
        adventurer.setWeapon(defaultWeapon);
        MainActivity.adventurersFragment.refresh();
        MainActivity.headquartersFragment.refresh();
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
            MainActivity.shownDialogEntityDetail.populateHelp(null, DialogEntityDetail.formatEquipmentHelp(defaultWeapon, resources), true, "weapon");
        }
        int iCalculateTotalMaxHp = adventurer.calculateTotalMaxHp();
        if (adventurer.getCurrentHp() > iCalculateTotalMaxHp) {
            adventurer.setCurrentHp(iCalculateTotalMaxHp);
        }
    }

    public Adventurer getAdventurer() {
        return this.adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public Doctrine getDoctrine() {
        return this.doctrine;
    }

    public void setDoctrine(Doctrine doctrine) {
        this.doctrine = doctrine;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogDoctrine = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        if (!MainActivity.data.isDoctrineMaxed() && isMaxed()) {
            MainActivity.data.setDoctrineMaxed(true);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_JACK_OF_ONE_TRADE);
        }
        MainActivity.shownDialogDoctrine = null;
        super.onStop();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        try {
            if (this.openWithAvailablePoints != (this.adventurer.getDoctrinePoints() > 0)) {
                if (MainActivity.shownDialogEntityDetail != null) {
                    MainActivity.shownDialogEntityDetail.update();
                }
                MainActivity.adventurersFragment.refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDismiss(dialogInterface);
    }

    private boolean isMaxed() {
        Doctrine doctrine = this.doctrine;
        if (doctrine instanceof EmptyDoctrine) {
            return false;
        }
        for (DoctrineAbility doctrineAbility : doctrine.getAbilities()) {
            if (doctrineAbility.getLevel() < doctrineAbility.getType().maxLevel) {
                return false;
            }
        }
        return true;
    }
}
