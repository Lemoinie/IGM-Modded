package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSellBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;

/* JADX INFO: loaded from: classes3.dex */
public class DialogSell extends CustomDialog {
    private DialogSellBinding binding;
    private Item item;
    private int maxAmount;
    private boolean slotsAvailable;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogSellBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return String.format(getString(R.string.sell_dialog_title), getString(this.item.getIdName()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogSellBinding dialogSellBindingInflate = DialogSellBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogSellBindingInflate;
        return dialogSellBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        int iIndexOf = MainActivity.data.getItems().indexOf(this.item);
        this.maxAmount = iIndexOf == -1 ? 0 : MainActivity.data.getItems().get(iIndexOf).getStack();
        this.item = Item.getInstance(this.item.getTrueClass(), MainActivity.data.isSettingSellMaxAmount() ? this.maxAmount : 1);
        this.slotsAvailable = Formulas.marketListings() > MainActivity.data.getMarketListings().size() + MainActivity.data.getSoldMarketItems().size();
        this.binding.item.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.item.getIdImage(), getContext().getTheme()));
        this.binding.item.image.setBackgroundResource(UIUtils.backgroundFromRarity(this.item.getRarity()));
        this.binding.sellPanel.setVisibility((this.maxAmount <= 0 || !this.slotsAvailable) ? 4 : 0);
        this.binding.warningNoItems.setVisibility(this.maxAmount > 0 ? 8 : 0);
        this.binding.warningFullListings.setVisibility(this.slotsAvailable ? 8 : 0);
        this.binding.warningNoItems.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.warningFullListings.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.seekBar.setMax(Math.max(0, this.maxAmount - 1));
        changeAmount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeAmount() {
        this.binding.seekBar.setProgress(this.item.getStack() - 1);
        this.binding.time.setText(UIUtils.formatSeconds(Math.round(this.item.getSecondsToSell())));
        this.binding.number.setText(String.valueOf(this.item.getStack()));
        this.binding.item.stack.setText(String.valueOf(this.item.getStack()));
        UIUtils.populateMoneyContainer(this.binding.price, this.item.getPrice() * ((long) this.item.getStack()), false);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.sell.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSell.this.m408xf4ac5833(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSell.this.m409xfab02392(view);
            }
        });
        this.binding.buttonPlus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSell.this.m410xb3eef1(view);
            }
        });
        this.binding.buttonMinus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSell.this.m411x6b7ba50(view);
            }
        });
        this.binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    DialogSell.this.item.setStack(i + 1);
                    DialogSell.this.changeAmount();
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSell, reason: not valid java name */
    /* synthetic */ void m408xf4ac5833(View view) {
        if (this.maxAmount <= 0 || !this.slotsAvailable) {
            return;
        }
        ItemAction itemAction = new ItemAction(this.item);
        MainActivity.data.getMarketListings().add(itemAction);
        Utils.removeItemFromStorage(this.item);
        if (MainActivity.shownDialogItemDetail != null) {
            MainActivity.shownDialogItemDetail.initialize(null);
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        if (MainActivity.shownDialogRecipes != null) {
            MainActivity.shownDialogRecipes.update();
        }
        if (MainActivity.shownDialogMarket != null) {
            MainActivity.shownDialogMarket.addListing(itemAction);
        }
        MainActivity.headquartersFragment.refresh();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSell, reason: not valid java name */
    /* synthetic */ void m409xfab02392(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSell, reason: not valid java name */
    /* synthetic */ void m410xb3eef1(View view) {
        int stack = this.item.getStack();
        int i = this.maxAmount;
        if (stack >= i) {
            this.item.setStack(i);
            return;
        }
        Item item = this.item;
        item.setStack(item.getStack() + 1);
        changeAmount();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSell, reason: not valid java name */
    /* synthetic */ void m411x6b7ba50(View view) {
        if (this.item.getStack() <= 1) {
            this.item.setStack(1);
            return;
        }
        Item item = this.item;
        item.setStack(item.getStack() - 1);
        changeAmount();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogSell = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogSell = null;
        super.onStop();
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
