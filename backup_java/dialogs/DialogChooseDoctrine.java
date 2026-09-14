package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChooseDoctrineBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DialogChooseDoctrine extends CustomDialog {
    private BaseAdapter adapter;
    private Adventurer adventurer;
    private DialogChooseDoctrineBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogChooseDoctrineBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_choose_doctrine_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogChooseDoctrineBinding dialogChooseDoctrineBindingInflate = DialogChooseDoctrineBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogChooseDoctrineBindingInflate;
        return dialogChooseDoctrineBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.adapter = UIUtils.getDoctrinesAdapter(Arrays.asList(Doctrine.getInstance("DoctrineOfFortitude"), Doctrine.getInstance("DoctrineOfIllusion"), Doctrine.getInstance("DoctrineOfWar"), Doctrine.getInstance("DoctrineOfAffliction"), Doctrine.getInstance("DoctrineOfKnowledge"), Doctrine.getInstance("DoctrineOfRuin"), Doctrine.getInstance("DoctrineOfGrace"), Doctrine.getInstance("DoctrineOfControl")), this.adventurer);
        this.binding.doctrineList.setAdapter((ListAdapter) this.adapter);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseDoctrine$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChooseDoctrine.this.m235x4b468542(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChooseDoctrine, reason: not valid java name */
    /* synthetic */ void m235x4b468542(View view) {
        dismiss();
    }

    public Adventurer getAdventurer() {
        return this.adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogChooseDoctrine = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogChooseDoctrine = null;
        super.onStop();
    }
}
