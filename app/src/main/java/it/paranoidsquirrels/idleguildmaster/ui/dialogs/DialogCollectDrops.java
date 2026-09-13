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
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogCollectDropsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes3.dex */
public class DialogCollectDrops extends CustomDialog {
    public DialogCollectDropsBinding binding;
    public List<Item> drops;
    public AdventureRecap recap;
    public String sourceArea;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogCollectDropsBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return String.format(getString(R.string.drops_collected_title), this.sourceArea);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogCollectDropsBinding dialogCollectDropsBindingInflate = DialogCollectDropsBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogCollectDropsBindingInflate;
        return dialogCollectDropsBindingInflate;
    }

    static /* synthetic */ int lambda$initialize$0(Item item) {
        return -item.getRarity();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.drops.sort(Comparator.comparingInt(new ToIntFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops$$ExternalSyntheticLambda4
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return DialogCollectDrops.lambda$initialize$0((Item) obj);
            }
        }));
        this.binding.itemGrid.setAdapter((ListAdapter) UIUtils.getItemsGridAdapter(getContext(), this.drops));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.itemGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogCollectDrops.this.m238xc57e9c9a(adapterView, view, i, j);
            }
        });
        this.binding.itemGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DialogCollectDrops.this.m239x61ec98f9(adapterView, view, i, j);
            }
        });
        this.binding.report.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCollectDrops.this.m240xfe5a9558(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCollectDrops.this.m241x9ac891b7(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCollectDrops, reason: not valid java name */
    /* synthetic */ void m238xc57e9c9a(AdapterView adapterView, View view, int i, long j) {
        UIUtils.openItemDetail(this.drops.get(i));
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCollectDrops, reason: not valid java name */
    /* synthetic */ boolean m239x61ec98f9(AdapterView adapterView, View view, int i, long j) {
        UIUtils.vibrate(getContext());
        DialogSell dialogSell = new DialogSell();
        dialogSell.setItem(this.drops.get(i));
        dialogSell.show(getParentFragmentManager(), "sell");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCollectDrops, reason: not valid java name */
    /* synthetic */ void m240xfe5a9558(View view) {
        if (MainActivity.shownDialogReport != null) {
            return;
        }
        DialogReport dialogReport = new DialogReport();
        dialogReport.sourceArea = this.sourceArea;
        dialogReport.recap = this.recap;
        dialogReport.show(getParentFragmentManager(), "dialog_report");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCollectDrops, reason: not valid java name */
    /* synthetic */ void m241x9ac891b7(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogCollectDrops = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogCollectDrops = null;
        super.onStop();
    }
}
