package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogWorkshopBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutWorkshopItemBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.CopperArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Leather;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DialogWorkshop extends CustomDialog {
    private static int MAX_LEVEL_QUEUE = 10;
    private static int MAX_LEVEL_TIME = 25;
    private DialogWorkshopBinding binding;
    private AlertDialog cancel = null;
    private AlertDialog upgradeConfirm = null;
    private int craftedInThisInstance = 0;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogWorkshopBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_workshop_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogWorkshopBinding dialogWorkshopBindingInflate = DialogWorkshopBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogWorkshopBindingInflate;
        return dialogWorkshopBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        updateUpgrades();
        populateCraftingList();
        updateAnimation();
        updateVisibility();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgradeQueue.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m482x5138e9a6(view);
            }
        });
        this.binding.buttonUpgradeTime.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m485xcc5bf543(view);
            }
        });
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m486x4abcf922(view);
            }
        });
        this.binding.recipes.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m487xc91dfd01(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m482x5138e9a6(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpWorkshopQueue();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_workshop_upgrade_queue, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogWorkshop.this.m480x5476e1e8(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogWorkshop.this.m481xd2d7e5c7(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m480x5476e1e8(DialogInterface dialogInterface, int i) {
        levelUpWorkshopQueue();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m481xd2d7e5c7(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m485xcc5bf543(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpWorkshopTime();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_workshop_upgrade_time, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogWorkshop.this.m483xcf99ed85(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogWorkshop.this.m484x4dfaf164(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m483xcf99ed85(DialogInterface dialogInterface, int i) {
        levelUpWorkshopTime();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m484x4dfaf164(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m486x4abcf922(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m487xc91dfd01(View view) {
        if (MainActivity.shownDialogRecipes == null) {
            new DialogRecipes().show(getParentFragmentManager(), "dialog_recipes");
        }
    }

    private void populateCraftingList() {
        this.binding.list.removeAllViews();
        Iterator<ItemAction> it2 = MainActivity.data.getCompletedWorkshopItems().iterator();
        while (it2.hasNext()) {
            this.binding.list.addView(getItemLayout(it2.next(), true).getRoot());
        }
        Iterator<ItemAction> it3 = MainActivity.data.getWorkshopQueue().iterator();
        while (it3.hasNext()) {
            this.binding.list.addView(getItemLayout(it3.next(), false).getRoot());
        }
    }

    private void updateUpgrades() {
        this.binding.description1.setText(String.format(getString(R.string.headquarters_workshop_description_long_1), Integer.valueOf(Formulas.workshopQueue())));
        this.binding.description2.setText(String.format(getString(R.string.headquarters_workshop_description_long_2), UIUtils.formatDouble2Decimals(1.0d / Math.pow(0.9d, MainActivity.data.getLevelWorkshopTime() + MainActivity.data.getUpgradeWorkshopTime()))));
        long workshopQueuePrice = Formulas.getWorkshopQueuePrice();
        UIUtils.populateMoneyContainer(this.binding.money, workshopQueuePrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= workshopQueuePrice);
        this.binding.buttonUpgradeQueue.setVisibility(MainActivity.data.getLevelWorkshopQueue() >= MAX_LEVEL_QUEUE ? 8 : 0);
        long workshopTimePrice = Formulas.getWorkshopTimePrice();
        UIUtils.populateMoneyContainer(this.binding.money2, workshopTimePrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money2, MainActivity.data.getMoney() >= workshopTimePrice);
        this.binding.buttonUpgradeTime.setVisibility(MainActivity.data.getLevelWorkshopTime() >= MAX_LEVEL_TIME ? 8 : 0);
    }

    private void updateVisibility() {
        this.binding.merchantPackBonus.setVisibility(MainActivity.data.isMerchantPackPurchased() ? 0 : 8);
        this.binding.scrollView.setVisibility(this.binding.list.getChildCount() > 0 ? 0 : 8);
        this.binding.emptyList.setVisibility(this.binding.list.getChildCount() > 0 ? 8 : 0);
    }

    public void completeItem() {
        DialogWorkshopBinding dialogWorkshopBinding = this.binding;
        if (dialogWorkshopBinding == null) {
            return;
        }
        View childAt = dialogWorkshopBinding.list.getChildAt(MainActivity.data.getCompletedWorkshopItems().size() - 1);
        ((ProgressBar) childAt.findViewById(R.id.progressBar)).setVisibility(8);
        TextView textView = (TextView) childAt.findViewById(R.id.time_to_completion);
        textView.setText(getString(R.string.complete));
        textView.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        ImageView imageView = (ImageView) childAt.findViewById(R.id.action);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.check_brass, getContext().getTheme()));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m490x4b230f54(view);
            }
        });
        updateAnimation();
    }

    /* JADX INFO: renamed from: lambda$completeItem$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m490x4b230f54(View view) {
        collect(MainActivity.data.getCompletedWorkshopItems().get(MainActivity.data.getCompletedWorkshopItems().size() - 1));
    }

    public void updateCountdown() {
        if (this.binding == null || MainActivity.data.getWorkshopQueue().isEmpty()) {
            return;
        }
        TextView textView = (TextView) this.binding.list.getChildAt(MainActivity.data.getCompletedWorkshopItems().size()).findViewById(R.id.time_to_completion);
        ItemAction itemAction = MainActivity.data.getWorkshopQueue().get(0);
        textView.setText(UIUtils.formatSeconds(itemAction.getItem().getSecondsToCraft() - itemAction.getSecondsPassed()));
    }

    public void addProject(ItemAction itemAction) {
        this.binding.list.addView(getItemLayout(itemAction, false).getRoot());
        updateVisibility();
        if (MainActivity.data.getWorkshopQueue().size() == 1) {
            updateAnimation();
        }
    }

    private LayoutWorkshopItemBinding getItemLayout(final ItemAction itemAction, boolean z) {
        LayoutWorkshopItemBinding layoutWorkshopItemBindingInflate = LayoutWorkshopItemBinding.inflate(getLayoutInflater(), this.binding.list, false);
        layoutWorkshopItemBindingInflate.name.setText(getString(itemAction.getItem().getIdName()));
        layoutWorkshopItemBindingInflate.item.image.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), itemAction.getItem().getIdImage(), getContext().getTheme()));
        layoutWorkshopItemBindingInflate.item.image.setBackgroundResource(R.drawable.object_border_rounded_left);
        layoutWorkshopItemBindingInflate.item.stack.setText(String.valueOf(itemAction.getItem().getStack()));
        layoutWorkshopItemBindingInflate.progressBar.setVisibility(z ? 8 : 0);
        layoutWorkshopItemBindingInflate.progressBar.setProgress((int) ((itemAction.getSecondsPassed() * 1000) / itemAction.getItem().getSecondsToCraft()));
        layoutWorkshopItemBindingInflate.timeToCompletion.setText(z ? getString(R.string.complete) : UIUtils.formatSeconds(itemAction.getItem().getSecondsToCraft() - itemAction.getSecondsPassed()));
        layoutWorkshopItemBindingInflate.timeToCompletion.setTextColor(getResources().getColor(z ? R.color.brass_border : R.color.dim_white, getContext().getTheme()));
        layoutWorkshopItemBindingInflate.action.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), z ? R.drawable.check_brass : R.drawable.delete, getContext().getTheme()));
        layoutWorkshopItemBindingInflate.action.setOnClickListener(z ? new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m492xa3b7cc86(itemAction, view);
            }
        } : new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWorkshop.this.m491xfd31adc4(itemAction, view);
            }
        });
        layoutWorkshopItemBindingInflate.containerItemWorkshop.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(itemAction.getItem());
            }
        });
        return layoutWorkshopItemBindingInflate;
    }

    /* JADX INFO: renamed from: lambda$getItemLayout$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m491xfd31adc4(ItemAction itemAction, View view) {
        cancel(itemAction);
    }

    /* JADX INFO: renamed from: lambda$getItemLayout$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m492xa3b7cc86(ItemAction itemAction, View view) {
        collect(itemAction);
    }

    private void collect(ItemAction itemAction) {
        if (MainActivity.data.getCompletedWorkshopItems().contains(itemAction)) {
            if (Formulas.storageSpaces() <= MainActivity.data.getItems().size() && !MainActivity.data.getItems().contains(itemAction.getItem())) {
                if (MainActivity.shownDialogFullStorage != null) {
                    return;
                }
                MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.no_storage_space_title), getString(R.string.no_storage_space_body_craft), false);
                MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MainActivity.shownDialogFullStorage = null;
                    }
                });
                MainActivity.shownDialogFullStorage.show();
                return;
            }
            this.binding.list.removeView(this.binding.list.getChildAt(MainActivity.data.getCompletedWorkshopItems().indexOf(itemAction)));
            MainActivity.data.getCompletedWorkshopItems().remove(itemAction);
            Utils.collectItem(itemAction.getItem(), MainActivity.data.getItems());
            this.craftedInThisInstance += itemAction.getItem().getStack();
            updateVisibility();
            QuestsManager.incrementToValue(QuestsManager.masterCrafter, (long) (itemAction.getItem().getPrice() * 0.01d));
            if (MainActivity.data.getTutorialStep() == 3 && (itemAction.getItem() instanceof Leather)) {
                MainActivity.data.setTutorialStep(4);
                Utils.collectItem(Item.getInstance("CopperIngot", 2), MainActivity.data.getItems());
                ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refresh();
            } else if (MainActivity.data.getTutorialStep() == 4 && (itemAction.getItem() instanceof CopperArmor)) {
                MainActivity.data.setTutorialStep(5);
                ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refresh();
            }
            MainActivity.headquartersFragment.refresh();
        }
    }

    private void cancel(final ItemAction itemAction) {
        if (this.cancel != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.cancel), String.format(getString(R.string.cancel_crafting_confirmation), Integer.valueOf(itemAction.getItem().getStack()), getString(itemAction.getItem().getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogWorkshop.this.m488x36bea122(itemAction, dialogInterface, i);
            }
        });
        this.cancel = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogWorkshop.this.m489xb51fa501(dialogInterface);
            }
        });
        this.cancel.show();
    }

    /* JADX INFO: renamed from: lambda$cancel$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m488x36bea122(ItemAction itemAction, DialogInterface dialogInterface, int i) {
        refund(itemAction);
    }

    /* JADX INFO: renamed from: lambda$cancel$14$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogWorkshop, reason: not valid java name */
    /* synthetic */ void m489xb51fa501(DialogInterface dialogInterface) {
        this.cancel = null;
    }

    private void refund(ItemAction itemAction) {
        if (MainActivity.data.getWorkshopQueue().contains(itemAction)) {
            int iIndexOf = MainActivity.data.getWorkshopQueue().indexOf(itemAction);
            this.binding.list.removeView(this.binding.list.getChildAt(MainActivity.data.getCompletedWorkshopItems().size() + iIndexOf));
            MainActivity.data.getWorkshopQueue().remove(itemAction);
            Recipes recipesInto = Recipes.into(itemAction.getItem());
            if (recipesInto != null) {
                for (Item item : recipesInto.getIngredients()) {
                    Utils.collectItem(Item.getInstance(item.getTrueClass(), item.getStack() * itemAction.getItem().getStack()), MainActivity.data.getItems());
                }
            }
            updateVisibility();
            if (iIndexOf == 0) {
                updateAnimation();
            }
            MainActivity.headquartersFragment.refresh();
        }
    }

    private void updateAnimation() {
        if (MainActivity.data.getWorkshopQueue().isEmpty()) {
            return;
        }
        final ProgressBar progressBar = (ProgressBar) this.binding.list.getChildAt(MainActivity.data.getCompletedWorkshopItems().size()).findViewById(R.id.progressBar);
        ItemAction itemAction = MainActivity.data.getWorkshopQueue().get(0);
        float fMillis = (float) ((((TrueTimeUtils.millis() - MainActivity.data.getLastAccess()) / 1000.0d) + itemAction.getSecondsPassed()) / itemAction.getItem().getSecondsToCraft());
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(Math.round(fMillis * 1000.0f), 1000);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                progressBar.setProgress(((Integer) valueAnimatorOfInt.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.setDuration(Math.max(0L, ((long) ((1.0f - fMillis) * 1000.0f * itemAction.getItem().getSecondsToCraft())) + 1000));
        valueAnimatorOfInt.start();
    }

    private void levelUpWorkshopQueue() {
        long workshopQueuePrice = Formulas.getWorkshopQueuePrice();
        if (MainActivity.data.getMoney() < workshopQueuePrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - workshopQueuePrice);
        MainActivity.data.setLevelWorkshopQueue(MainActivity.data.getLevelWorkshopQueue() + 1);
        updateUpgrades();
        ((MainActivity) getActivity()).refresh();
    }

    private void levelUpWorkshopTime() {
        long workshopTimePrice = Formulas.getWorkshopTimePrice();
        if (MainActivity.data.getMoney() < workshopTimePrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - workshopTimePrice);
        MainActivity.data.setLevelWorkshopTime(MainActivity.data.getLevelWorkshopTime() + 1);
        initialize(null);
        ((MainActivity) getActivity()).refresh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.craftedInThisInstance = 0;
        MainActivity.shownDialogWorkshop = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        int i;
        long itemsCrafted = MainActivity.data.getItemsCrafted();
        if (itemsCrafted < WorkRequest.MIN_BACKOFF_MILLIS && (i = this.craftedInThisInstance) > 0) {
            if (itemsCrafted < 100) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_APPRENTICE_BLACKSMITH, i);
            }
            if (itemsCrafted < 1000) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_SEASONED_BLACKSMITH, this.craftedInThisInstance);
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_LEGENDARY_BLACKSMITH, this.craftedInThisInstance);
            MainActivity.data.setItemsCrafted(Math.min(WorkRequest.MIN_BACKOFF_MILLIS, itemsCrafted + ((long) this.craftedInThisInstance)));
        }
        MainActivity.shownDialogWorkshop = null;
        super.onStop();
    }
}
