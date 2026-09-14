package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDungeonDetailBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutEntityFightingBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;

/* JADX INFO: loaded from: classes3.dex */
public class DialogDungeonDetail extends CustomDialog {
    public Area area;
    public DialogDungeonDetailBinding binding;
    public boolean darkLog = true;
    private AlertDialog darknessDialog;
    private AlertDialog retreatDialog;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogDungeonDetailBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(this.area.getName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout(-1, (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.9d));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogDungeonDetailBinding dialogDungeonDetailBindingInflate = DialogDungeonDetailBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogDungeonDetailBindingInflate;
        return dialogDungeonDetailBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.area.getDetailDrawable(), getContext().getTheme()));
        refreshUnits();
        refreshDarkness();
        boolean z = this.area.adventurersNumber() > 8;
        this.binding.paddingToRemove1.setVisibility(z ? 8 : 0);
        this.binding.paddingToRemove2.setVisibility(z ? 8 : 0);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDungeonDetail.this.m275x1a7e0fea(view);
            }
        });
        this.binding.retreat.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDungeonDetail.this.m278xee72be6d(view);
            }
        });
        this.binding.moon.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDungeonDetail.this.m280xd115dd6f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m275x1a7e0fea(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m278xee72be6d(View view) {
        if (MainActivity.data.isSettingConfirmRetreat()) {
            if (this.retreatDialog != null) {
                return;
            }
            AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.retreat), getString(R.string.retreat_confirmation), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogDungeonDetail.this.m276xbcf9f6b(dialogInterface, i);
                }
            });
            this.retreatDialog = actionDialog;
            actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogDungeonDetail.this.m277xfd212eec(dialogInterface);
                }
            });
            this.retreatDialog.show();
            return;
        }
        this.area.terminationRequested = true;
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m276xbcf9f6b(DialogInterface dialogInterface, int i) {
        this.area.terminationRequested = true;
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m277xfd212eec(DialogInterface dialogInterface) {
        this.retreatDialog = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m280xd115dd6f(View view) {
        if (this.darknessDialog != null || this.area.getDarkness() == 0) {
            return;
        }
        AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.darkness_dialog_title), UIUtils.darknessDescription(this.area.getLocalDarkness(), getResources()), false);
        this.darknessDialog = infoDialog;
        infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogDungeonDetail.this.m279xdfc44dee(dialogInterface);
            }
        });
        this.darknessDialog.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m279xdfc44dee(DialogInterface dialogInterface) {
        this.darknessDialog = null;
    }

    public void refreshUnits() {
        int size = this.area.getAdventurersExploring().size();
        int i = 1;
        for (int i2 = 1; i2 < 16; i2++) {
            refreshUnit(true, i2, size);
        }
        int size2 = this.area.getEnemies().size();
        while (true) {
            if (i >= 6) {
                break;
            }
            refreshUnit(false, i, size2);
            i++;
        }
        if (this.area.getPetExploring() != null) {
            this.binding.pet.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.area.getPetExploring().getIdImage(), getContext().getTheme()));
        }
        this.binding.pet.setVisibility(this.area.getPetExploring() == null ? 4 : 0);
        this.binding.pet.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDungeonDetail.this.m281x45e0e264(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$refreshUnits$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m281x45e0e264(View view) {
        if (MainActivity.shownDialogPetDetail != null) {
            return;
        }
        MainActivity.shownDialogPetDetail = new DialogPetDetail();
        MainActivity.shownDialogPetDetail.pet = this.area.getPetExploring();
        MainActivity.shownDialogPetDetail.show(getParentFragmentManager(), "pet_detail");
    }

    public void refreshDarkness() {
        if (this.area.getDarkness() == 0) {
            this.binding.moon.setVisibility(8);
            return;
        }
        if (this.area.getLocalDarkness() < 17) {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_0, getContext().getTheme()));
        } else if (this.area.getLocalDarkness() < 34) {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_1, getContext().getTheme()));
        } else if (this.area.getLocalDarkness() < 50) {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_2, getContext().getTheme()));
        } else if (this.area.getLocalDarkness() < 67) {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_3, getContext().getTheme()));
        } else if (this.area.getLocalDarkness() < 84) {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_4, getContext().getTheme()));
        } else {
            this.binding.moon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.darkness_5, getContext().getTheme()));
        }
        this.binding.moon.setVisibility(0);
    }

    private void refreshUnit(boolean z, int i, int i2) {
        LayoutEntityFightingBinding view = getView(i, z);
        if (i <= i2) {
            Area area = this.area;
            Entity entity = (Entity) (z ? area.getAdventurersExploring() : area.getEnemies()).get(i - 1);
            view.getRoot().setVisibility(0);
            refreshView(entity, view);
            refreshStatus(entity, view);
            attachDetailListener(z, entity, view);
            return;
        }
        view.getRoot().setVisibility(8);
    }

    private void refreshView(Entity entity, LayoutEntityFightingBinding layoutEntityFightingBinding) {
        layoutEntityFightingBinding.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), entity.getCurrentHp() > 0 ? entity.getImageId() : R.drawable.tombstone, getContext().getTheme()));
        layoutEntityFightingBinding.hpBar.setProgress((int) ((((double) entity.getCurrentHp()) / ((double) entity.calculateTotalMaxHp())) * 100.0d));
        layoutEntityFightingBinding.shieldBar.setProgress((int) ((((double) entity.getCurrentShield()) / ((double) entity.calculateTotalMaxHp())) * 100.0d));
        layoutEntityFightingBinding.manaBar.setProgress((int) ((((double) entity.getCurrentMana()) / 100.0d) * 100.0d));
        layoutEntityFightingBinding.manaBar.setVisibility((entity.getActiveSkill() == Skills.ACTIVE_NONE || entity.getActiveSkill() == null) ? 8 : 0);
        layoutEntityFightingBinding.manaBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(entity.getCurrentMana() == 100 ? R.color.white : R.color.mana_bar, getContext().getTheme())));
    }

    private void refreshStatus(Entity entity, LayoutEntityFightingBinding layoutEntityFightingBinding) {
        int i = 0;
        for (StatusEffect statusEffect : entity.getPositiveStatusEffects()) {
            if (i >= 3) {
                break;
            }
            i++;
            getStatusSlot(layoutEntityFightingBinding, i).setImageDrawable(ResourcesCompat.getDrawable(getResources(), statusEffect.getType().icon, getContext().getTheme()));
        }
        for (StatusEffect statusEffect2 : entity.getNegativeStatusEffects()) {
            if (i >= 3) {
                break;
            }
            i++;
            getStatusSlot(layoutEntityFightingBinding, i).setImageDrawable(ResourcesCompat.getDrawable(getResources(), statusEffect2.getType().icon, getContext().getTheme()));
        }
        while (true) {
            i++;
            if (i >= 4) {
                return;
            } else {
                getStatusSlot(layoutEntityFightingBinding, i).setImageResource(0);
            }
        }
    }

    private void attachDetailListener(final boolean z, final Entity entity, LayoutEntityFightingBinding layoutEntityFightingBinding) {
        layoutEntityFightingBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDungeonDetail.this.m274xd0719cdb(z, entity, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachDetailListener$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogDungeonDetail, reason: not valid java name */
    /* synthetic */ void m274xd0719cdb(boolean z, Entity entity, View view) {
        if (!z) {
            UIUtils.getEnemyDetailDialog(getParentFragmentManager(), (Enemy) entity);
        } else {
            Adventurer adventurer = (Adventurer) entity;
            UIUtils.getAdventurerDetailDialog(getParentFragmentManager(), adventurer, !adventurer.isSummonedMinion(), false);
        }
    }

    public void animateDamage(Entity entity) {
        boolean z = entity instanceof Adventurer;
        Area area = this.area;
        LayoutEntityFightingBinding view = getView((z ? area.getAdventurersExploring() : area.getEnemies()).indexOf(entity) + 1, z);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view.image, "translationX", 0.0f, 10.0f, 0.0f, -10.0f, 0.0f);
        objectAnimatorOfFloat.setRepeatCount(3);
        objectAnimatorOfFloat.setDuration(50L);
        objectAnimatorOfFloat.start();
        view.animation.setImageResource(R.drawable.animated_icon_damaged);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view.animation, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(500L);
        objectAnimatorOfFloat2.start();
    }

    public void log(String str) {
        if (str == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(Html.fromHtml(str, 0));
        textView.setPadding(12, 4, 12, 4);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (!this.darkLog) {
            textView.setBackgroundColor(getContext().getResources().getColor(R.color.dungeon_log_lighter_background, getContext().getTheme()));
        }
        this.binding.logs.addView(textView, 0);
        if (this.binding.logs.getChildCount() > 100) {
            this.binding.logs.removeViewAt(99);
        }
    }

    private ImageView getStatusSlot(LayoutEntityFightingBinding layoutEntityFightingBinding, int i) {
        if (i == 1) {
            return layoutEntityFightingBinding.status1;
        }
        if (i == 2) {
            return layoutEntityFightingBinding.status2;
        }
        return layoutEntityFightingBinding.status3;
    }

    private LayoutEntityFightingBinding getView(int i, boolean z) {
        switch (i) {
            case 1:
                DialogDungeonDetailBinding dialogDungeonDetailBinding = this.binding;
                return z ? dialogDungeonDetailBinding.adventurer1 : dialogDungeonDetailBinding.enemy1;
            case 2:
                DialogDungeonDetailBinding dialogDungeonDetailBinding2 = this.binding;
                return z ? dialogDungeonDetailBinding2.adventurer2 : dialogDungeonDetailBinding2.enemy2;
            case 3:
                DialogDungeonDetailBinding dialogDungeonDetailBinding3 = this.binding;
                return z ? dialogDungeonDetailBinding3.adventurer3 : dialogDungeonDetailBinding3.enemy3;
            case 4:
                DialogDungeonDetailBinding dialogDungeonDetailBinding4 = this.binding;
                return z ? dialogDungeonDetailBinding4.adventurer4 : dialogDungeonDetailBinding4.enemy4;
            case 5:
                DialogDungeonDetailBinding dialogDungeonDetailBinding5 = this.binding;
                return z ? dialogDungeonDetailBinding5.adventurer5 : dialogDungeonDetailBinding5.enemy5;
            case 6:
                return this.binding.adventurer6;
            case 7:
                return this.binding.adventurer7;
            case 8:
                return this.binding.adventurer8;
            case 9:
                return this.binding.adventurer9;
            case 10:
                return this.binding.adventurer10;
            case 11:
                return this.binding.adventurer11;
            case 12:
                return this.binding.adventurer12;
            case 13:
                return this.binding.adventurer13;
            case 14:
                return this.binding.adventurer14;
            default:
                return this.binding.adventurer15;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogDungeonDetail = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogDungeonDetail = null;
        super.onStop();
    }
}
