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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogStorageBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes3.dex */
public class DialogStorage extends CustomDialog {
    public static final int MAX_STORAGE_LEVEL = 80;
    private ArrayAdapter<Item> adapter;
    public DialogStorageBinding binding;
    private boolean filtersHidden;
    private List<Item> items;
    private AlertDialog upgradeConfirm = null;
    private AlertDialog cantSell = null;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogStorageBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_storage_name);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogStorageBinding dialogStorageBindingInflate = DialogStorageBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogStorageBindingInflate;
        return dialogStorageBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        refreshSpaces();
        this.binding.radiobuttonType.setChecked(true);
        this.binding.radiobuttonAll.setChecked(true);
        this.filtersHidden = true;
        configureFiltersVisibility();
        configureVisibility();
    }

    private void configureFiltersVisibility() {
        configureFilterVisibility(this.binding.radiobuttonAll);
        configureFilterVisibility(this.binding.radiobuttonMaterials);
        configureFilterVisibility(this.binding.radiobuttonWeapons);
        configureFilterVisibility(this.binding.radiobuttonArmors);
        configureFilterVisibility(this.binding.radiobuttonAccessories);
        configureFilterVisibility(this.binding.radiobuttonConsumables);
        configureFilterVisibility(this.binding.radiobuttonType);
        configureFilterVisibility(this.binding.radiobuttonQuantity);
        configureFilterVisibility(this.binding.radiobuttonAlphabetical);
        configureFilterVisibility(this.binding.radiobuttonPriceUnit);
        configureFilterVisibility(this.binding.radiobuttonPriceTotal);
    }

    private void configureFilterVisibility(RadioButton radioButton) {
        radioButton.setVisibility((!this.filtersHidden || radioButton.isChecked()) ? 0 : 8);
    }

    private void configureOrder() {
        int checkedRadioButtonId = this.binding.radioGroupOrderBy.getCheckedRadioButtonId();
        if (checkedRadioButtonId == this.binding.radiobuttonType.getId()) {
            this.items.sort(Utils.itemsByTypeComparator);
        } else if (checkedRadioButtonId == this.binding.radiobuttonQuantity.getId()) {
            this.items.sort(Comparator.comparingInt(new ToIntFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda7
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return DialogStorage.lambda$configureOrder$0((Item) obj);
                }
            }));
        } else if (checkedRadioButtonId == this.binding.radiobuttonAlphabetical.getId()) {
            this.items.sort(Comparator.comparing(new Function() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DialogStorage.this.m465x28ccb623((Item) obj);
                }
            }));
        } else if (checkedRadioButtonId == this.binding.radiobuttonPriceUnit.getId()) {
            this.items.sort(Comparator.comparingLong(new ToLongFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda9
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return DialogStorage.lambda$configureOrder$2((Item) obj);
                }
            }));
        } else if (checkedRadioButtonId == this.binding.radiobuttonPriceTotal.getId()) {
            this.items.sort(Comparator.comparingLong(new ToLongFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda10
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return DialogStorage.lambda$configureOrder$3((Item) obj);
                }
            }));
        }
        this.adapter.notifyDataSetChanged();
        this.binding.noItemsTooltip.setVisibility(this.items.isEmpty() ? 0 : 8);
        this.binding.itemGrid.setVisibility(this.items.isEmpty() ? 4 : 0);
    }

    static /* synthetic */ int lambda$configureOrder$0(Item item) {
        return -item.getStack();
    }

    /* JADX INFO: renamed from: lambda$configureOrder$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ String m465x28ccb623(Item item) {
        return getString(item.getIdName());
    }

    static /* synthetic */ long lambda$configureOrder$2(Item item) {
        return -item.getPrice();
    }

    static /* synthetic */ long lambda$configureOrder$3(Item item) {
        return (-item.getPrice()) * ((long) item.getStack());
    }

    private void configureVisibility() {
        int checkedRadioButtonId = this.binding.radioGroupVisibility.getCheckedRadioButtonId();
        this.items = new ArrayList(MainActivity.data.getItems());
        if (checkedRadioButtonId == this.binding.radiobuttonMaterials.getId()) {
            this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda12
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogStorage.lambda$configureVisibility$4((Item) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonWeapons.getId()) {
            this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda13
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogStorage.lambda$configureVisibility$5((Item) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonArmors.getId()) {
            this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda14
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogStorage.lambda$configureVisibility$6((Item) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonAccessories.getId()) {
            this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda15
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogStorage.lambda$configureVisibility$7((Item) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonConsumables.getId()) {
            this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda16
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogStorage.lambda$configureVisibility$8((Item) obj);
                }
            });
        }
        this.adapter = UIUtils.getItemsGridAdapter(getContext(), this.items);
        this.binding.itemGrid.setAdapter((ListAdapter) this.adapter);
        configureOrder();
    }

    static /* synthetic */ boolean lambda$configureVisibility$4(Item item) {
        return (item instanceof Equipment) || (item instanceof Consumable);
    }

    static /* synthetic */ boolean lambda$configureVisibility$5(Item item) {
        return !(item instanceof Weapon);
    }

    static /* synthetic */ boolean lambda$configureVisibility$6(Item item) {
        return !(item instanceof Armor);
    }

    static /* synthetic */ boolean lambda$configureVisibility$7(Item item) {
        return !(item instanceof Accessory);
    }

    static /* synthetic */ boolean lambda$configureVisibility$8(Item item) {
        return !(item instanceof Consumable);
    }

    public void update() {
        refreshSpaces();
        this.items.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda17
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DialogStorage.lambda$update$9((Item) obj);
            }
        });
        this.adapter.notifyDataSetChanged();
        this.binding.noItemsTooltip.setVisibility(this.items.isEmpty() ? 0 : 8);
        this.binding.itemGrid.setVisibility(this.items.isEmpty() ? 4 : 0);
    }

    static /* synthetic */ boolean lambda$update$9(Item item) {
        return item.getStack() == 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.buttonUpgradeSpaces.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogStorage.this.m457x80088b59(view);
            }
        });
        this.binding.itemGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda19
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogStorage.this.m458x73980f9a(adapterView, view, i, j);
            }
        });
        this.binding.itemGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DialogStorage.this.m460x5ab7181c(adapterView, view, i, j);
            }
        });
        this.binding.filtersArrowContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogStorage.this.m461x4e469c5d(view);
            }
        });
        this.binding.radioGroupOrderBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogStorage.this.m462x41d6209e(radioGroup, i);
            }
        });
        this.binding.radioGroupVisibility.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogStorage.this.m463x3565a4df(radioGroup, i);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogStorage.this.m464x28f52920(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$12$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m457x80088b59(View view) {
        if (!MainActivity.data.isSettingConfirmUpgrade()) {
            levelUpStorageSpaces();
        } else {
            if (this.upgradeConfirm != null) {
                return;
            }
            AlertDialog alertDialogAskConfirmUpgrade = UIUtils.askConfirmUpgrade(getContext(), R.string.headquarters_storage_upgrade_capacity, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogStorage.this.m455x98e982d7(dialogInterface, i);
                }
            });
            this.upgradeConfirm = alertDialogAskConfirmUpgrade;
            alertDialogAskConfirmUpgrade.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogStorage.this.m456x8c790718(dialogInterface);
                }
            });
            this.upgradeConfirm.show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m455x98e982d7(DialogInterface dialogInterface, int i) {
        levelUpStorageSpaces();
        this.upgradeConfirm.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m456x8c790718(DialogInterface dialogInterface) {
        this.upgradeConfirm = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m458x73980f9a(AdapterView adapterView, View view, int i, long j) {
        UIUtils.openItemDetail(this.items.get(i));
    }

    /* JADX INFO: renamed from: lambda$attachListeners$15$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ boolean m460x5ab7181c(AdapterView adapterView, View view, int i, long j) {
        Item item = this.items.get(i);
        UIUtils.vibrate(getContext());
        if (item.isNotSellable()) {
            if (this.cantSell != null) {
                return true;
            }
            AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.headquarters_storage_dialog_not_sellable_title), getString(R.string.headquarters_storage_dialog_not_sellable_body), false);
            this.cantSell = infoDialog;
            infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogStorage.this.m459x672793db(dialogInterface);
                }
            });
            this.cantSell.show();
        } else {
            DialogSell dialogSell = new DialogSell();
            dialogSell.setItem(item);
            dialogSell.show(MainActivity.headquartersFragment.getParentFragmentManager(), "sell");
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$14$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m459x672793db(DialogInterface dialogInterface) {
        this.cantSell = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$16$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m461x4e469c5d(View view) {
        this.binding.filtersArrow.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.filtersHidden ? R.drawable.menu_lift : R.drawable.menu_drop, getContext().getTheme()));
        this.filtersHidden = !this.filtersHidden;
        configureFiltersVisibility();
        this.binding.buttonUpgradeSpaces.setVisibility((!this.filtersHidden || MainActivity.data.getLevelStorage() >= 80) ? 8 : 0);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$17$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m462x41d6209e(RadioGroup radioGroup, int i) {
        configureOrder();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$18$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m463x3565a4df(RadioGroup radioGroup, int i) {
        configureVisibility();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$19$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogStorage, reason: not valid java name */
    /* synthetic */ void m464x28f52920(View view) {
        dismiss();
    }

    private void levelUpStorageSpaces() {
        long storageCapacityPrice = Formulas.getStorageCapacityPrice();
        if (MainActivity.data.getMoney() < storageCapacityPrice) {
            return;
        }
        MainActivity.data.setMoney(MainActivity.data.getMoney() - storageCapacityPrice);
        MainActivity.data.setLevelStorage(MainActivity.data.getLevelStorage() + 1);
        refreshSpaces();
        ((MainActivity) getActivity()).refresh();
        MainActivity.headquartersFragment.refresh();
    }

    private void refreshSpaces() {
        long storageCapacityPrice = Formulas.getStorageCapacityPrice();
        UIUtils.populateMoneyContainer(this.binding.money, storageCapacityPrice, true);
        UIUtils.changeMoneyContainerColor(this.binding.money, MainActivity.data.getMoney() >= storageCapacityPrice);
        this.binding.description.setText(String.format(getString(R.string.headquarters_storage_description_long), Integer.valueOf(MainActivity.data.getItems().size()), Integer.valueOf(Formulas.storageSpaces())));
        this.binding.buttonUpgradeSpaces.setVisibility(MainActivity.data.getLevelStorage() >= 80 ? 8 : 0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogStorage = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogStorage = null;
        super.onStop();
    }
}
