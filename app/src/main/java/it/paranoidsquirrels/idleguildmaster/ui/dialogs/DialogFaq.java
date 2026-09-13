package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Faq;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogFaqBinding;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DialogFaq extends CustomDialog {
    private BaseAdapter adapter;
    private DialogFaqBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogFaqBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.drawer_faq_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogFaqBinding dialogFaqBindingInflate = DialogFaqBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogFaqBindingInflate;
        return dialogFaqBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.adapter = UIUtils.getFaqAdapter(Arrays.asList(Faq.values()));
        this.binding.faqList.setAdapter((ListAdapter) this.adapter);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogFaq$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogFaq.this.m334xce15e215(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogFaq, reason: not valid java name */
    /* synthetic */ void m334xce15e215(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogFaq = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogFaq = null;
        super.onStop();
    }
}
