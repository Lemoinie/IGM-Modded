package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogTavernBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutTavernAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogTavern extends CustomDialog {
    private static final int MAX_LEVEL_TAVERN_CAPACITY = 7;
    private static final int MAX_LEVEL_TAVERN_TIME = 20;
    private DialogTavernBinding binding;
    private AlertDialog recruitUnavailableDialog = null;
    private AlertDialog help = null;
    private AlertDialog upgradeConfirm = null;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogTavernBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_tavern_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogTavernBinding dialogTavernBindingInflate = DialogTavernBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogTavernBindingInflate;
        return dialogTavernBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        long tavernCapacityPrice = Formulas.getTavernCapacityPrice();
        UIUtils.populateMoneyContainer(this.binding.money, tavernCapacityPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= tavernCapacityPrice);
        this.binding.buttonUpgradeCapacity.setVisibility(MainActivity.data.getLevelTavernCapacity() >= 7 ? 8 : 0);
        long tavernTimePrice = Formulas.getTavernTimePrice();
        UIUtils.populateMoneyContainer(this.binding.money2, tavernTimePrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money2, MainActivity.data.getMoney() >= tavernTimePrice);
        this.binding.buttonUpgradeTime.setVisibility(MainActivity.data.getLevelTavernTime() >= 20 ? 8 : 0);
        this.binding.lock.setBackground(ResourcesCompat.getDrawable(getResources(), MainActivity.data.isTavernLocked() ? R.drawable.lock_close : R.drawable.lock_open, getContext().getTheme()));
        refreshProgressBar();
        refreshAdventurers();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgradeCapacity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTavern.this.m468xa4f4f0f7(view);
            }
        });
        this.binding.buttonUpgradeTime.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTavern.this.m471x61b03fd4(view);
            }
        });
        this.binding.lock.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTavern.this.m472xf5eeaf73(view);
            }
        });
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTavern.this.m473x8a2d1f12(view);
            }
        });
        this.binding.help.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTavern.this.m475xb2a9fe50(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m468xa4f4f0f7(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpTavernCapacity();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_tavern_upgrade_capacity, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogTavern.this.m466x7c7811b9(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogTavern.this.m467x10b68158(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m466x7c7811b9(DialogInterface dialogInterface, int i) {
        levelUpTavernCapacity();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m467x10b68158(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m471x61b03fd4(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpTavernTime();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_tavern_upgrade_time, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogTavern.this.m469x39336096(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogTavern.this.m470xcd71d035(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m469x39336096(DialogInterface dialogInterface, int i) {
        levelUpTavernTime();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m470xcd71d035(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m472xf5eeaf73(View view) {
        toggleLock();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m473x8a2d1f12(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m475xb2a9fe50(View view) {
        if (this.help != null) {
            return;
        }
        AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.headquarters_tavern_name), getString(R.string.headquarters_tavern_help), false);
        this.help = infoDialog;
        infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogTavern.this.m474x1e6b8eb1(dialogInterface);
            }
        });
        this.help.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m474x1e6b8eb1(DialogInterface dialogInterface) {
        this.help = null;
    }

    public void refreshProgressBar() {
        DialogTavernBinding dialogTavernBinding = this.binding;
        if (dialogTavernBinding == null) {
            return;
        }
        dialogTavernBinding.nextVisitor.setText(String.format(getString(R.string.next_visitor), UIUtils.formatSeconds(MainActivity.data.getNextTavernVisit())));
        double tavernVisitorInterval = Formulas.getTavernVisitorInterval();
        this.binding.progressBar.setProgress((int) ((1.0d - ((tavernVisitorInterval - (MainActivity.data.getNextTavernVisit() * 1000.0d)) / tavernVisitorInterval)) * 100.0d));
    }

    public void refreshAdventurers() {
        DialogTavernBinding dialogTavernBinding = this.binding;
        if (dialogTavernBinding == null) {
            return;
        }
        dialogTavernBinding.description1.setText(String.format(getString(R.string.headquarters_tavern_description_long_1), Integer.valueOf(MainActivity.data.getTavernGuests().size()), Integer.valueOf(Formulas.getTavernCapacity())));
        this.binding.description2.setText(String.format(getString(R.string.headquarters_tavern_description_long_2), UIUtils.formatSeconds(Formulas.getTavernVisitorInterval() / 1000)));
        this.binding.list.removeAllViews();
        List<Adventurer> tavernGuests = MainActivity.data.getTavernGuests();
        Iterator<Adventurer> it2 = tavernGuests.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            final Adventurer next = it2.next();
            LayoutTavernAdventurerBinding layoutTavernAdventurerBindingInflate = LayoutTavernAdventurerBinding.inflate(getLayoutInflater(), this.binding.list, false);
            layoutTavernAdventurerBindingInflate.name.setText(getString(next.getIdName()));
            layoutTavernAdventurerBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), next.getImageId(), getContext().getTheme()));
            if (!next.isSeen()) {
                layoutTavernAdventurerBindingInflate.isNew.setText(R.string.is_new);
            }
            layoutTavernAdventurerBindingInflate.traits.setText(UIUtils.traitsToShortString(next, getResources()));
            if (Formulas.getQuartersCapacity() <= MainActivity.data.getAdventurers().size()) {
                layoutTavernAdventurerBindingInflate.recruitButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.object_border_unavailable_rounded_right, getContext().getTheme()));
                layoutTavernAdventurerBindingInflate.recruitButton.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogTavern.this.m476x2a87612(view);
                    }
                });
            } else {
                layoutTavernAdventurerBindingInflate.recruitButton.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogTavern.this.m477x96e6e5b1(view);
                    }
                });
            }
            layoutTavernAdventurerBindingInflate.containerAdventurerTavern.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogTavern.this.m478x2b255550(next, view);
                }
            });
            this.binding.list.addView(layoutTavernAdventurerBindingInflate.getRoot());
        }
        if (MainActivity.shownDialogEntityDetail != null && !tavernGuests.contains(MainActivity.shownDialogEntityDetail.getEntity())) {
            MainActivity.shownDialogEntityDetail.dismiss();
        }
        AlertDialog alertDialog = this.recruitUnavailableDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.binding.scrollView.setVisibility(tavernGuests.isEmpty() ? 8 : 0);
        this.binding.emptyList.setVisibility(tavernGuests.isEmpty() ? 0 : 8);
    }

    /* JADX INFO: renamed from: lambda$refreshAdventurers$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m476x2a87612(View view) {
        showFullQuartersDialog();
    }

    /* JADX INFO: renamed from: lambda$refreshAdventurers$11$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m477x96e6e5b1(View view) {
        recruitAdventurer(((LinearLayout) view.getParent().getParent()).indexOfChild((View) view.getParent()));
    }

    /* JADX INFO: renamed from: lambda$refreshAdventurers$12$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m478x2b255550(Adventurer adventurer, View view) {
        UIUtils.getAdventurerDetailDialog(getParentFragmentManager(), adventurer, false, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogTavern = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogTavern = null;
        Iterator<Adventurer> it2 = MainActivity.data.getTavernGuests().iterator();
        while (it2.hasNext()) {
            it2.next().setSeen(true);
        }
        MainActivity.headquartersFragment.refresh();
        super.onStop();
    }

    private void levelUpTavernCapacity() {
        long tavernCapacityPrice = Formulas.getTavernCapacityPrice();
        if (MainActivity.data.getMoney() < tavernCapacityPrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - tavernCapacityPrice);
        MainActivity.data.setLevelTavernCapacity(MainActivity.data.getLevelTavernCapacity() + 1);
        initialize(null);
        ((MainActivity) getActivity()).refresh();
        MainActivity.headquartersFragment.refresh();
    }

    private void levelUpTavernTime() {
        long tavernTimePrice = Formulas.getTavernTimePrice();
        if (MainActivity.data.getMoney() < tavernTimePrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - tavernTimePrice);
        MainActivity.data.setLevelTavernTime(MainActivity.data.getLevelTavernTime() + 1);
        MainActivity.data.setNextTavernVisit((long) (MainActivity.data.getNextTavernVisit() * 0.9d));
        initialize(null);
        ((MainActivity) getActivity()).refresh();
    }

    private void toggleLock() {
        if (MainActivity.data.isTavernLocked()) {
            MainActivity.data.setTavernLocked(false);
            this.binding.lock.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.lock_open, getContext().getTheme()));
        } else {
            MainActivity.data.setTavernLocked(true);
            this.binding.lock.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.lock_close, getContext().getTheme()));
        }
        MainActivity.headquartersFragment.refresh();
    }

    private void showFullQuartersDialog() {
        if (this.recruitUnavailableDialog != null) {
            return;
        }
        AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.recruit_unavailable_title), getString(R.string.recruit_unavailable_body), false);
        this.recruitUnavailableDialog = infoDialog;
        infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogTavern.this.m479x76e64cb4(dialogInterface);
            }
        });
        this.recruitUnavailableDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showFullQuartersDialog$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogTavern, reason: not valid java name */
    /* synthetic */ void m479x76e64cb4(DialogInterface dialogInterface) {
        this.recruitUnavailableDialog = null;
    }

    private void recruitAdventurer(int i) {
        Adventurer adventurer = MainActivity.data.getTavernGuests().get(i);
        MainActivity.data.getTavernGuests().remove(adventurer);
        adventurer.setId(Utils.calculateNewAdventurerId());
        MainActivity.data.getAdventurers().add(adventurer);
        Utils.triggerGuildSizeAchievementCheck();
        refreshAdventurers();
        int tutorialStep = MainActivity.data.getTutorialStep();
        if (tutorialStep == 1 || tutorialStep == 6) {
            MainActivity.data.setTutorialStep(tutorialStep + 1);
            if (tutorialStep == 6) {
                Utils.progressTavernTime(28800L);
            }
            ((MainActivity) getActivity()).refreshTutorial();
        }
        MainActivity.headquartersFragment.refresh();
        MainActivity.adventurersFragment.refresh();
        MainActivity.adventurersFragment.switchMode(0);
    }
}
