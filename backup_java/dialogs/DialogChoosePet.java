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
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChoosePetBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogChoosePet extends CustomDialog {
    private DialogChoosePetBinding binding;
    List<Pet> idlePets;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogChoosePetBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.select_pet);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogChoosePetBinding dialogChoosePetBindingInflate = DialogChoosePetBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogChoosePetBindingInflate;
        return dialogChoosePetBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        List<Pet> idlePets = Utils.getIdlePets();
        this.idlePets = idlePets;
        idlePets.sort(Utils.petsComparator);
        this.binding.petsGrid.setAdapter((ListAdapter) UIUtils.getPetsGridAdapter(getContext(), this.idlePets));
        this.binding.noPets.setVisibility(this.idlePets.isEmpty() ? 0 : 8);
        this.binding.petsGrid.setVisibility(this.idlePets.isEmpty() ? 4 : 0);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.petsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChoosePet$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DialogChoosePet.this.m236x36035347(adapterView, view, i, j);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChoosePet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChoosePet.this.m237x83c2cb48(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChoosePet, reason: not valid java name */
    /* synthetic */ void m236x36035347(AdapterView adapterView, View view, int i, long j) {
        MainActivity.shownDialogSendTeam.selectedPetId = Integer.valueOf(this.idlePets.get(i).getId());
        MainActivity.shownDialogSendTeam.setupAdventurers();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogChoosePet, reason: not valid java name */
    /* synthetic */ void m237x83c2cb48(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogChoosePet = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogChoosePet = null;
        super.onStop();
    }
}
