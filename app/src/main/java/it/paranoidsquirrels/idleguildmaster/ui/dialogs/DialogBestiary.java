package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBestiaryBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.ArrayList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class DialogBestiary extends CustomDialog {
    private BaseAdapter adapter;
    public DialogBestiaryBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogBestiaryBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.drawer_bestiary_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogBestiaryBinding dialogBestiaryBindingInflate = DialogBestiaryBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogBestiaryBindingInflate;
        return dialogBestiaryBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        ArrayList arrayList = new ArrayList(Utils.compileDungeonList());
        arrayList.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DialogBestiary.lambda$initialize$0((Area) obj);
            }
        });
        ArrayList arrayList2 = new ArrayList(Utils.compileRaidList());
        arrayList2.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DialogBestiary.lambda$initialize$1((Area) obj);
            }
        });
        constraintHeight(this.binding.dungeonsBestiaryList, arrayList.size() > 3);
        constraintHeight(this.binding.raidsBestiaryList, arrayList2.size() > 3);
        this.binding.dungeonsBestiaryList.setAdapter((ListAdapter) UIUtils.getBestiaryListAdapter(arrayList));
        this.binding.raidsBestiaryList.setAdapter((ListAdapter) UIUtils.getBestiaryListAdapter(arrayList2));
        this.binding.radiobuttonDungeons.setChecked(true);
        toggle();
    }

    static /* synthetic */ boolean lambda$initialize$0(Area area) {
        return !area.isUnlocked();
    }

    static /* synthetic */ boolean lambda$initialize$1(Area area) {
        return !area.isUnlocked();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogBestiary.this.m224xbcf0f162(radioGroup, i);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBestiary.this.m225x3b51f541(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogBestiary, reason: not valid java name */
    /* synthetic */ void m224xbcf0f162(RadioGroup radioGroup, int i) {
        toggle();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogBestiary, reason: not valid java name */
    /* synthetic */ void m225x3b51f541(View view) {
        dismiss();
    }

    private void toggle() {
        boolean z = this.binding.radioGroup.getCheckedRadioButtonId() == R.id.radiobutton_dungeons;
        this.binding.dungeonsBestiaryList.setVisibility(z ? 0 : 8);
        this.binding.raidsBestiaryList.setVisibility(z ? 8 : 0);
    }

    private void constraintHeight(View view, boolean z) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.constrainedHeight = z;
        view.setLayoutParams(layoutParams);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogBestiary = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogBestiary = null;
        super.onStop();
    }
}
