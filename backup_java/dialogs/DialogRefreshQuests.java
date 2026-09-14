package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRefreshQuestsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DialogRefreshQuests extends CustomDialog {
    private DialogRefreshQuestsBinding binding;
    private int gems = 100;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogRefreshQuestsBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_quests_refresh_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogRefreshQuestsBinding dialogRefreshQuestsBindingInflate = DialogRefreshQuestsBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogRefreshQuestsBindingInflate;
        return dialogRefreshQuestsBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        Iterator<Adventurer> it2 = MainActivity.data.getAdventurers().iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (!(it2.next().getDoctrine() instanceof EmptyDoctrine)) {
                i++;
            }
        }
        this.gems = (MainActivity.data.getAfflictionLevel() < 10 || MainActivity.data.getControlLevel() < 10 || MainActivity.data.getFortitudeLevel() < 10 || MainActivity.data.getGraceLevel() < 10 || MainActivity.data.getIllusionLevel() < 10 || MainActivity.data.getKnowledgeLevel() < 10 || MainActivity.data.getRuinLevel() < 10 || MainActivity.data.getWarLevel() < 10) ? Math.min(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, (i * 10) + 100) : 100;
        this.binding.confirmAmount.setText(String.valueOf(this.gems));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.confirmContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefreshQuests$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRefreshQuests.this.m399xfbb996cb(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefreshQuests$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRefreshQuests.this.m400xed0b264c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRefreshQuests, reason: not valid java name */
    /* synthetic */ void m399xfbb996cb(View view) {
        if (MainActivity.data.getGems() < this.gems) {
            return;
        }
        QuestsManager.extractQuests();
        MainActivity.data.setGems(MainActivity.data.getGems() - ((long) this.gems));
        MainActivity.data.setQuestsRefreshed(true);
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.reInitialize();
        }
        ((MainActivity) getActivity()).refresh();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRefreshQuests, reason: not valid java name */
    /* synthetic */ void m400xed0b264c(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogRefreshQuests = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogRefreshQuests = null;
        super.onStop();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
