package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
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
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMarketBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutMarketItemBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DialogMarket extends CustomDialog {
    private static int MAX_LEVEL_LISTINGS = 10;
    private static int MAX_LEVEL_TIME = 25;
    private DialogMarketBinding binding;
    private AlertDialog cancel = null;
    private AlertDialog upgradeConfirm = null;
    private int soldInThisInstance = 0;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogMarketBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_market_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogMarketBinding dialogMarketBindingInflate = DialogMarketBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogMarketBindingInflate;
        return dialogMarketBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        updateUpgrades();
        populateListings();
        updateAnimation();
        updateVisibility();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgradeListings.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMarket.this.m348x9901481b(view);
            }
        });
        this.binding.buttonUpgradeTime.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMarket.this.m351x55bc96f8(view);
            }
        });
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMarket.this.m352xe9fb0697(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m348x9901481b(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpMarketListings();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_market_upgrade_queue, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogMarket.this.m346x708468dd(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogMarket.this.m347x4c2d87c(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m346x708468dd(DialogInterface dialogInterface, int i) {
        levelUpMarketListings();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m347x4c2d87c(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m351x55bc96f8(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpMarketTime();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_market_upgrade_time, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogMarket.this.m349x2d3fb7ba(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogMarket.this.m350xc17e2759(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m349x2d3fb7ba(DialogInterface dialogInterface, int i) {
        levelUpMarketTime();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m350xc17e2759(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m352xe9fb0697(View view) {
        dismiss();
    }

    private void populateListings() {
        this.binding.list.removeAllViews();
        Iterator<ItemAction> it2 = MainActivity.data.getSoldMarketItems().iterator();
        while (it2.hasNext()) {
            this.binding.list.addView(getItemLayout(it2.next(), true).getRoot());
        }
        Iterator<ItemAction> it3 = MainActivity.data.getMarketListings().iterator();
        while (it3.hasNext()) {
            this.binding.list.addView(getItemLayout(it3.next(), false).getRoot());
        }
    }

    private void updateUpgrades() {
        this.binding.description1.setText(String.format(getString(R.string.headquarters_market_description_long_1), Integer.valueOf(Formulas.marketListings())));
        this.binding.description2.setText(String.format(getString(R.string.headquarters_market_description_long_2), UIUtils.formatDouble2Decimals(1.0d / Math.pow(0.9d, MainActivity.data.getLevelMarketTime() + MainActivity.data.getUpgradeMarketTime()))));
        long marketListingsPrice = Formulas.getMarketListingsPrice();
        UIUtils.populateMoneyContainer(this.binding.money, marketListingsPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= marketListingsPrice);
        this.binding.buttonUpgradeListings.setVisibility(MainActivity.data.getLevelMarketListings() >= MAX_LEVEL_LISTINGS ? 8 : 0);
        long marketTimePrice = Formulas.getMarketTimePrice();
        UIUtils.populateMoneyContainer(this.binding.money2, marketTimePrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money2, MainActivity.data.getMoney() >= marketTimePrice);
        this.binding.buttonUpgradeTime.setVisibility(MainActivity.data.getLevelMarketTime() >= MAX_LEVEL_TIME ? 8 : 0);
    }

    private void updateVisibility() {
        this.binding.merchantPackBonus.setVisibility(MainActivity.data.isMerchantPackPurchased() ? 0 : 8);
        this.binding.scrollView.setVisibility(this.binding.list.getChildCount() > 0 ? 0 : 8);
        this.binding.emptyList.setVisibility(this.binding.list.getChildCount() > 0 ? 8 : 0);
    }

    public void completeItem() {
        DialogMarketBinding dialogMarketBinding = this.binding;
        if (dialogMarketBinding == null) {
            return;
        }
        View childAt = dialogMarketBinding.list.getChildAt(MainActivity.data.getSoldMarketItems().size() - 1);
        ((ProgressBar) childAt.findViewById(R.id.progressBar)).setVisibility(8);
        TextView textView = (TextView) childAt.findViewById(R.id.time_to_completion);
        textView.setText(getString(R.string.sold));
        textView.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        childAt.findViewById(R.id.price_container).setVisibility(0);
        childAt.findViewById(R.id.cancel).setVisibility(8);
        updateAnimation();
    }

    public void updateCountdown() {
        if (this.binding == null || MainActivity.data.getMarketListings().isEmpty()) {
            return;
        }
        TextView textView = (TextView) this.binding.list.getChildAt(MainActivity.data.getSoldMarketItems().size()).findViewById(R.id.time_to_completion);
        ItemAction itemAction = MainActivity.data.getMarketListings().get(0);
        textView.setText(UIUtils.formatSeconds(itemAction.getItem().getSecondsToSell() - itemAction.getSecondsPassed()));
    }

    public void addListing(ItemAction itemAction) {
        this.binding.list.addView(getItemLayout(itemAction, false).getRoot());
        updateVisibility();
        if (MainActivity.data.getMarketListings().size() == 1) {
            updateAnimation();
        }
    }

    private void updateAnimation() {
        if (MainActivity.data.getMarketListings().isEmpty()) {
            return;
        }
        final ProgressBar progressBar = (ProgressBar) this.binding.list.getChildAt(MainActivity.data.getSoldMarketItems().size()).findViewById(R.id.progressBar);
        ItemAction itemAction = MainActivity.data.getMarketListings().get(0);
        float fMillis = (float) ((((TrueTimeUtils.millis() - MainActivity.data.getLastAccess()) / 1000.0d) + itemAction.getSecondsPassed()) / itemAction.getItem().getSecondsToSell());
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(Math.round(fMillis * 1000.0f), 1000);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                progressBar.setProgress(((Integer) valueAnimatorOfInt.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.setDuration(Math.max(0L, ((long) ((1.0f - fMillis) * 1000.0f * itemAction.getItem().getSecondsToSell())) + 1000));
        valueAnimatorOfInt.start();
    }

    private LayoutMarketItemBinding getItemLayout(final ItemAction itemAction, boolean z) {
        LayoutMarketItemBinding layoutMarketItemBindingInflate = LayoutMarketItemBinding.inflate(getLayoutInflater(), this.binding.list, false);
        layoutMarketItemBindingInflate.name.setText(getString(itemAction.getItem().getIdName()));
        layoutMarketItemBindingInflate.item.image.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), itemAction.getItem().getIdImage(), getContext().getTheme()));
        layoutMarketItemBindingInflate.item.image.setBackgroundResource(R.drawable.object_border_rounded_left);
        layoutMarketItemBindingInflate.item.stack.setText(String.valueOf(itemAction.getItem().getStack()));
        layoutMarketItemBindingInflate.progressBar.setVisibility(z ? 8 : 0);
        layoutMarketItemBindingInflate.progressBar.setProgress((int) ((itemAction.getSecondsPassed() * 1000) / itemAction.getItem().getSecondsToSell()));
        layoutMarketItemBindingInflate.timeToCompletion.setText(z ? getString(R.string.sold) : UIUtils.formatSeconds(itemAction.getItem().getSecondsToSell() - itemAction.getSecondsPassed()));
        layoutMarketItemBindingInflate.timeToCompletion.setTextColor(getResources().getColor(z ? R.color.brass_border : R.color.dim_white, getContext().getTheme()));
        UIUtils.populateMoneyContainer(layoutMarketItemBindingInflate.price, itemAction.getItem().getPrice() * ((long) itemAction.getItem().getStack()), true);
        layoutMarketItemBindingInflate.price.amountCopper.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        layoutMarketItemBindingInflate.price.amountSilver.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        layoutMarketItemBindingInflate.price.amountGold.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        layoutMarketItemBindingInflate.price.amountPlatinum.setTextColor(getResources().getColor(R.color.brass_border, getContext().getTheme()));
        layoutMarketItemBindingInflate.priceContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMarket.this.m355x155cf35c(itemAction, view);
            }
        });
        layoutMarketItemBindingInflate.priceContainer.setVisibility(z ? 0 : 8);
        layoutMarketItemBindingInflate.cancel.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMarket.this.m356xa99b62fb(itemAction, view);
            }
        });
        layoutMarketItemBindingInflate.cancel.setVisibility(z ? 8 : 0);
        layoutMarketItemBindingInflate.containerItemWorkshop.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtils.openItemDetail(itemAction.getItem());
            }
        });
        return layoutMarketItemBindingInflate;
    }

    /* JADX INFO: renamed from: lambda$getItemLayout$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m355x155cf35c(ItemAction itemAction, View view) {
        collect(itemAction);
    }

    /* JADX INFO: renamed from: lambda$getItemLayout$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m356xa99b62fb(ItemAction itemAction, View view) {
        cancel(itemAction);
    }

    private void collect(ItemAction itemAction) {
        if (MainActivity.data.getSoldMarketItems().contains(itemAction)) {
            this.binding.list.removeView(this.binding.list.getChildAt(MainActivity.data.getSoldMarketItems().indexOf(itemAction)));
            MainActivity.data.getSoldMarketItems().remove(itemAction);
            long money = MainActivity.data.getMoney() + (itemAction.getItem().getPrice() * ((long) itemAction.getItem().getStack()));
            MainActivity.data.setMoney(money);
            if (MainActivity.data.getMaxWealth() < 1000000) {
                if (MainActivity.data.getMaxWealth() < WorkRequest.MIN_BACKOFF_MILLIS && money >= WorkRequest.MIN_BACKOFF_MILLIS) {
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_WEALTHY);
                }
                if (money >= 1000000) {
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FILTHY_RICH);
                }
                MainActivity.data.setMaxWealth(Math.max(MainActivity.data.getMaxWealth(), money));
            }
            this.soldInThisInstance += itemAction.getItem().getStack();
            if (itemAction.getItem().getUniqueOrigin() != null) {
                MainActivity.data.getUniqueItemsLost().add(itemAction.getItem().getUniqueOrigin());
            }
            updateVisibility();
            updateUpgrades();
            MainActivity.headquartersFragment.refresh();
            ((MainActivity) getActivity()).refresh();
        }
    }

    private void cancel(final ItemAction itemAction) {
        if (Formulas.storageSpaces() <= MainActivity.data.getItems().size() && !MainActivity.data.getItems().contains(itemAction.getItem())) {
            if (MainActivity.shownDialogFullStorage != null) {
                return;
            }
            MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.no_storage_space_title), getString(R.string.no_storage_space_body_cancel_listing), false);
            MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownDialogFullStorage = null;
                }
            });
            MainActivity.shownDialogFullStorage.show();
            return;
        }
        if (this.cancel != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.cancel), String.format(getString(R.string.cancel_listing_confirmation), Integer.valueOf(itemAction.getItem().getStack()), getString(itemAction.getItem().getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogMarket.this.m353x26083ef8(itemAction, dialogInterface, i);
            }
        });
        this.cancel = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogMarket.this.m354xba46ae97(dialogInterface);
            }
        });
        this.cancel.show();
    }

    /* JADX INFO: renamed from: lambda$cancel$12$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m353x26083ef8(ItemAction itemAction, DialogInterface dialogInterface, int i) {
        refund(itemAction);
    }

    /* JADX INFO: renamed from: lambda$cancel$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMarket, reason: not valid java name */
    /* synthetic */ void m354xba46ae97(DialogInterface dialogInterface) {
        this.cancel = null;
    }

    private void refund(ItemAction itemAction) {
        if (MainActivity.data.getMarketListings().contains(itemAction)) {
            int iIndexOf = MainActivity.data.getMarketListings().indexOf(itemAction);
            this.binding.list.removeView(this.binding.list.getChildAt(MainActivity.data.getSoldMarketItems().size() + iIndexOf));
            MainActivity.data.getMarketListings().remove(itemAction);
            Utils.collectItem(Item.getInstance(itemAction.getItem().getTrueClass(), itemAction.getItem().getStack()), MainActivity.data.getItems());
            updateVisibility();
            if (iIndexOf == 0) {
                updateAnimation();
            }
            MainActivity.headquartersFragment.refresh();
        }
    }

    private void levelUpMarketListings() {
        long marketListingsPrice = Formulas.getMarketListingsPrice();
        if (MainActivity.data.getMoney() < marketListingsPrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - marketListingsPrice);
        MainActivity.data.setLevelMarketListings(MainActivity.data.getLevelMarketListings() + 1);
        updateUpgrades();
        ((MainActivity) getActivity()).refresh();
    }

    private void levelUpMarketTime() {
        long marketTimePrice = Formulas.getMarketTimePrice();
        if (MainActivity.data.getMoney() < marketTimePrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - marketTimePrice);
        MainActivity.data.setLevelMarketTime(MainActivity.data.getLevelMarketTime() + 1);
        initialize(null);
        ((MainActivity) getActivity()).refresh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.soldInThisInstance = 0;
        MainActivity.shownDialogMarket = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        int i;
        long itemsSold = MainActivity.data.getItemsSold();
        if (itemsSold < WorkRequest.MIN_BACKOFF_MILLIS && (i = this.soldInThisInstance) > 0) {
            if (itemsSold < 100) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_APPRENTICE_MERCHANT, i);
            }
            if (itemsSold < 1000) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_SEASONED_MERCHANT, this.soldInThisInstance);
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_LEGENDARY_MERCHANT, this.soldInThisInstance);
            MainActivity.data.setItemsCrafted(Math.min(WorkRequest.MIN_BACKOFF_MILLIS, itemsSold + ((long) this.soldInThisInstance)));
        }
        MainActivity.shownDialogMarket = null;
        super.onStop();
    }
}
