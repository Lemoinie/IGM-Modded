package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CustomDialog extends AppCompatDialogFragment {
    private boolean skipOnShowListener = false;

    protected abstract void attachListeners();

    protected abstract ViewBinding getBinding();

    protected abstract String getTitle();

    protected abstract ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z);

    protected abstract void initialize(Bundle bundle);

    protected abstract void setBinding(ViewBinding viewBinding);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_border);
        getDialog().getWindow().setFlags(8, 8);
        getDialog().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility());
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                CustomDialog.this.m223x2d023132(dialogInterface);
            }
        });
        setBinding(inflate(layoutInflater, viewGroup, false));
        try {
            initialize(getArguments());
            attachListeners();
            getDialog().setTitle(getTitle());
            setLayout();
            return getBinding().getRoot();
        } catch (Exception e) {
            e.printStackTrace();
            dismiss();
            return getBinding().getRoot();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-CustomDialog, reason: not valid java name */
    /* synthetic */ void m223x2d023132(DialogInterface dialogInterface) {
        try {
            getDialog().getWindow().clearFlags(8);
            if (this.skipOnShowListener) {
                return;
            }
            ((WindowManager) getActivity().getSystemService("window")).updateViewLayout(getDialog().getWindow().getDecorView(), getDialog().getWindow().getAttributes());
        } catch (Exception unused) {
            dismiss();
        }
    }

    protected void setLayout() {
        getDialog().getWindow().setLayout(-1, -2);
    }

    public void skipOnShowListener() {
        this.skipOnShowListener = true;
    }
}
