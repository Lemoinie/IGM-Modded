package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMerchantBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class DialogMerchant extends CustomDialog {
    public DialogMerchantBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogMerchantBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.merchant_dialog_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogMerchantBinding dialogMerchantBindingInflate = DialogMerchantBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogMerchantBindingInflate;
        return dialogMerchantBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.newRegular.setVisibility(MainActivity.data.isNewMerchantRegularItems() ? 0 : 4);
        this.binding.newSpecial.setVisibility(MainActivity.data.isNewMerchantSpecialItems() ? 0 : 4);
        MainActivity.data.setNewMerchantRegularItems(false);
        MainActivity.data.setNewMerchantSpecialItems(false);
        ((MainActivity) getActivity()).refreshIcons();
        ArrayList arrayList = new ArrayList();
        Iterator<MerchantOffer> it2 = MainActivity.data.getMerchantRegularStockItems().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getItem());
        }
        this.binding.regularItemGrid.setAdapter((ListAdapter) UIUtils.getItemsGridAdapter(getContext(), arrayList));
        ArrayList arrayList2 = new ArrayList();
        Iterator<MerchantOffer> it3 = MainActivity.data.getMerchantSpecialReserve().iterator();
        while (it3.hasNext()) {
            arrayList2.add(it3.next().getItem());
        }
        this.binding.specialItemGrid.setAdapter((ListAdapter) UIUtils.getItemsGridAdapter(getContext(), arrayList2));
        boolean zIsEmpty = MainActivity.data.getMerchantRegularStockItems().isEmpty();
        this.binding.regularItemGrid.setVisibility(zIsEmpty ? 8 : 0);
        this.binding.noRegularItems.setVisibility(zIsEmpty ? 0 : 8);
        boolean zIsEmpty2 = MainActivity.data.getMerchantSpecialReserve().isEmpty();
        this.binding.specialItemGrid.setVisibility(zIsEmpty2 ? 8 : 0);
        this.binding.noSpecialItems.setVisibility(zIsEmpty2 ? 0 : 8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Utils.refreshCooldowns(TrueTimeUtils.millis());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.regularItemGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogMerchant.this.m357x3436fa29(adapterView, view, i, j);
            }
        });
        this.binding.specialItemGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogMerchant.this.m358xb297fe08(adapterView, view, i, j);
            }
        });
        this.binding.regularItemGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DialogMerchant.this.m359x30f901e7(adapterView, view, i, j);
            }
        });
        this.binding.specialItemGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DialogMerchant.this.m360xaf5a05c6(adapterView, view, i, j);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogMerchant.this.m361x2dbb09a5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ void m357x3436fa29(AdapterView adapterView, View view, int i, long j) {
        openBuyDialog(MainActivity.data.getMerchantRegularStockItems().get(i), false);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ void m358xb297fe08(AdapterView adapterView, View view, int i, long j) {
        openBuyDialog(MainActivity.data.getMerchantSpecialReserve().get(i), true);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ boolean m359x30f901e7(AdapterView adapterView, View view, int i, long j) {
        UIUtils.vibrate(getContext());
        UIUtils.openItemDetail(MainActivity.data.getMerchantRegularStockItems().get(i).getItem());
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ boolean m360xaf5a05c6(AdapterView adapterView, View view, int i, long j) {
        UIUtils.vibrate(getContext());
        UIUtils.openItemDetail(MainActivity.data.getMerchantSpecialReserve().get(i).getItem());
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ void m361x2dbb09a5(View view) {
        dismiss();
    }

    private void openBuyDialog(final MerchantOffer merchantOffer, final boolean z) {
        if (MainActivity.shownDialogBuyFromMerchant != null) {
            return;
        }
        DialogBuyFromMerchant dialogBuyFromMerchant = new DialogBuyFromMerchant();
        dialogBuyFromMerchant.offer = merchantOffer;
        dialogBuyFromMerchant.callback = new BooleanSupplier() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return DialogMerchant.this.m362x39fcb3a(merchantOffer, z);
            }
        };
        dialogBuyFromMerchant.show(getParentFragmentManager(), "select_equipment");
    }

    /* JADX INFO: renamed from: lambda$openBuyDialog$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogMerchant, reason: not valid java name */
    /* synthetic */ boolean m362x39fcb3a(MerchantOffer merchantOffer, boolean z) {
        if (!(merchantOffer.getItem() instanceof Upgrade) && Utils.remainingInventorySpaceAfterCollecting(false, merchantOffer.getItem()) < 0) {
            MainActivity.shownDialogBuyFromMerchant.writeError(getString(R.string.error_not_enough_space));
            return false;
        }
        if (merchantOffer.isGems()) {
            long gems = MainActivity.data.getGems() - merchantOffer.getPrice();
            if (gems < 0) {
                MainActivity.shownDialogBuyFromMerchant.writeError(getString(R.string.error_not_enough_gems));
                return false;
            }
            MainActivity.data.setGems(gems);
            ((MainActivity) getActivity()).refreshGems();
        } else {
            long money = MainActivity.data.getMoney() - merchantOffer.getPrice();
            if (money < 0) {
                MainActivity.shownDialogBuyFromMerchant.writeError(getString(R.string.error_not_enough_money));
                return false;
            }
            MainActivity.data.setMoney(money);
            ((MainActivity) getActivity()).refreshMoney();
        }
        if (z) {
            MainActivity.data.getMerchantSpecialReserve().remove(merchantOffer);
        } else {
            MainActivity.data.getMerchantRegularStockItems().remove(merchantOffer);
        }
        if (merchantOffer.getItem().getUniqueOrigin() != null) {
            MainActivity.data.getUniqueItemsLost().remove(merchantOffer.getItem().getUniqueOrigin());
        }
        if (merchantOffer.getItem() instanceof Upgrade) {
            ((Upgrade) merchantOffer.getItem()).use();
        } else {
            Utils.collectItem(merchantOffer.getItem(), MainActivity.data.getItems());
        }
        MainActivity.headquartersFragment.refresh();
        initialize(null);
        return true;
    }

    public void refreshCooldowns(int i, int i2, int i3) {
        this.binding.regularItemsCountdown.setText(String.format(getString(R.string.time_hours_minutes), Integer.valueOf(i2), Integer.valueOf(i3)));
        this.binding.specialItemsCountdown.setText(String.format(getString(R.string.time_days_hours_minutes), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public void newItems() {
        if (MainActivity.shownDialogBuyFromMerchant != null) {
            MainActivity.shownDialogBuyFromMerchant.dismiss();
        }
        initialize(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogMerchant = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogMerchant = null;
        super.onStop();
    }
}
