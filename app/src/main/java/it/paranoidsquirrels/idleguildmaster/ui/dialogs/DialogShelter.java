package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogShelterBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogShelter extends CustomDialog {
    private static final int MAX_LEVEL_AUTOFEED = 1;
    private static final int MAX_LEVEL_SHELTER = 11;
    private ArrayAdapter<Pet> adapter;
    public DialogShelterBinding binding;
    private List<Pet> orderedPets;
    private AlertDialog upgradeConfirm = null;
    private AlertDialog help = null;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogShelterBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_shelter_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogShelterBinding dialogShelterBindingInflate = DialogShelterBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogShelterBindingInflate;
        return dialogShelterBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        ArrayList arrayList = new ArrayList(MainActivity.data.getPets());
        this.orderedPets = arrayList;
        arrayList.sort(Utils.petsComparator);
        long shelterPrice = Formulas.getShelterPrice();
        UIUtils.populateMoneyContainer(this.binding.money, shelterPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= shelterPrice);
        this.binding.description.setText(String.format(getString(R.string.headquarters_shelter_description_long), Integer.valueOf(MainActivity.data.getPets().size()), Integer.valueOf(Formulas.shelterCapacity())));
        this.binding.buttonUpgradeCapacity.setVisibility(MainActivity.data.getLevelShelter() >= 11 ? 8 : 0);
        long shelterAutofeedPrice = Formulas.getShelterAutofeedPrice();
        UIUtils.populateMoneyContainer(this.binding.moneyAutofeed, shelterAutofeedPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.moneyAutofeed, MainActivity.data.getMoney() >= shelterAutofeedPrice);
        this.binding.descriptionAutofeed.setVisibility(MainActivity.data.getLevelShelterAutofeed() > 0 ? 0 : 4);
        this.binding.buttonUpgradeAutofeed.setVisibility(MainActivity.data.getLevelShelterAutofeed() >= 1 ? 8 : 0);
        this.adapter = UIUtils.getPetsGridAdapter(getContext(), this.orderedPets);
        this.binding.petsGrid.setAdapter((ListAdapter) this.adapter);
        this.binding.emptyPets.setVisibility(MainActivity.data.getPets().isEmpty() ? 0 : 8);
        this.binding.petsGrid.setVisibility(MainActivity.data.getPets().isEmpty() ? 4 : 0);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgradeCapacity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShelter.this.m434xcfc884e6(view);
            }
        });
        this.binding.buttonUpgradeAutofeed.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShelter.this.m437xaa7711a9(view);
            }
        });
        this.binding.petsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogShelter.this.m438x9e0695ea(adapterView, view, i, j);
            }
        });
        this.binding.petsGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DialogShelter.this.m439x91961a2b(adapterView, view, i, j);
            }
        });
        this.binding.help.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShelter.this.m441x78b522ad(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShelter.this.m433x83dffd41(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m434xcfc884e6(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            upgradeShelter();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_shelter_upgrade_space, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogShelter.this.m431xe8a97c64(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogShelter.this.m432xdc3900a5(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m431xe8a97c64(DialogInterface dialogInterface, int i) {
        upgradeShelter();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m432xdc3900a5(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m437xaa7711a9(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            upgradeShelterAutofeed();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_shelter_upgrade_autofeed, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogShelter.this.m435xc3580927(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogShelter.this.m436xb6e78d68(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m435xc3580927(DialogInterface dialogInterface, int i) {
        upgradeShelterAutofeed();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m436xb6e78d68(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m438x9e0695ea(AdapterView adapterView, View view, int i, long j) {
        if (MainActivity.shownDialogPetDetail != null) {
            return;
        }
        MainActivity.shownDialogPetDetail = new DialogPetDetail();
        MainActivity.shownDialogPetDetail.pet = this.orderedPets.get(i);
        MainActivity.shownDialogPetDetail.show(getParentFragmentManager(), "pet_detail");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ boolean m439x91961a2b(AdapterView adapterView, View view, int i, long j) {
        if (MainActivity.data.getLevelShelterAutofeed() == 0) {
            return true;
        }
        Pet pet = this.orderedPets.get(i);
        UIUtils.vibrate(getContext());
        pet.setFavourite(!pet.isFavourite());
        this.orderedPets.sort(Utils.petsComparator);
        this.adapter.notifyDataSetChanged();
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m441x78b522ad(View view) {
        if (this.help != null) {
            return;
        }
        AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.headquarters_shelter_name), getString(R.string.headquarters_shelter_help), false);
        this.help = infoDialog;
        infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogShelter.this.m440x85259e6c(dialogInterface);
            }
        });
        this.help.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m440x85259e6c(DialogInterface dialogInterface) {
        this.help = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogShelter, reason: not valid java name */
    /* synthetic */ void m433x83dffd41(View view) {
        dismiss();
    }

    private void upgradeShelter() {
        long shelterPrice = Formulas.getShelterPrice();
        if (MainActivity.data.getMoney() >= shelterPrice) {
            MainActivity.data.setMoney(MainActivity.data.getMoney() - shelterPrice);
            MainActivity.data.setLevelShelter(MainActivity.data.getLevelShelter() + 1);
            initialize(null);
            ((MainActivity) getActivity()).refresh();
            MainActivity.headquartersFragment.refresh();
        }
    }

    private void upgradeShelterAutofeed() {
        long shelterAutofeedPrice = Formulas.getShelterAutofeedPrice();
        if (MainActivity.data.getMoney() >= shelterAutofeedPrice) {
            MainActivity.data.setMoney(MainActivity.data.getMoney() - shelterAutofeedPrice);
            MainActivity.data.setLevelShelterAutofeed(MainActivity.data.getLevelShelterAutofeed() + 1);
            initialize(null);
            ((MainActivity) getActivity()).refresh();
        }
    }

    public void refresh() {
        initialize(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogShelter = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogShelter = null;
        super.onStop();
    }
}
