package it.paranoidsquirrels.idleguildmaster.ui.raids;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentRaidsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;

/* JADX INFO: loaded from: classes3.dex */
public class RaidsFragment extends Fragment {
    public static boolean TO_REFRESH = true;
    public static boolean VISIBLE = false;
    private FragmentRaidsBinding binding;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentRaidsBinding fragmentRaidsBindingInflate = FragmentRaidsBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = fragmentRaidsBindingInflate;
        ConstraintLayout root = fragmentRaidsBindingInflate.getRoot();
        attachListeners();
        refresh();
        Utils.refreshCooldowns(TrueTimeUtils.millis());
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.raidsFragment = this;
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = false;
        for (Area area : Utils.compileRaidList()) {
            z = z || (area.isUnlocked() && area.getAreaType() == 1);
            z2 = z2 || (area.isUnlocked() && area.getAreaType() == 2);
            area.getLayout().dungeonImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), area.getSummaryDrawable(), getContext().getTheme()));
            area.getLayout().dungeonTitle.setText(area.getName());
            area.getLayout().getRoot().setVisibility((!area.isUnlocked() || area.completed()) ? 4 : 0);
            area.getLayout().raidTryAvailable.setVisibility(0);
            area.getLayout().epicRaid.setVisibility(area.getAreaType() == 2 ? 0 : 8);
            area.refreshAdventurers();
            area.refreshLoot();
            area.refreshActionDisplayed();
            area.refreshTries();
        }
        showRaidHelpDialog(z, z2);
    }

    public void refreshRaidVisibility() {
        boolean z = false;
        boolean z2 = false;
        for (Area area : Utils.compileRaidList()) {
            z = z || (area.isUnlocked() && area.getAreaType() == 1);
            z2 = z2 || (area.isUnlocked() && area.getAreaType() == 2);
            area.getLayout().getRoot().setVisibility((!area.isUnlocked() || area.completed()) ? 8 : 0);
        }
        showRaidHelpDialog(z, z2);
    }

    private void showRaidHelpDialog(boolean z, boolean z2) {
        if (!MainActivity.data.isShownDialogEpicRaid() && z2) {
            MainActivity.data.setShownDialogEpicRaid(true);
            UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.epic_raids_help_title), getString(R.string.epic_raids_help_body), false).show();
        }
        if (MainActivity.data.isShownDialogRaid() || !z) {
            return;
        }
        MainActivity.data.setShownDialogRaid(true);
        UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.raids_help_title), getString(R.string.raids_help_body), false).show();
    }

    public void attachListeners() {
        for (final Area area : Utils.compileRaidList()) {
            area.getLayout().getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RaidsFragment.this.m502x9755753e(area, view);
                }
            });
            area.getLayout().dungeonAdventurersExploring.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RaidsFragment.this.m503x51cb15bf(area, view);
                }
            });
            area.getLayout().lootImage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RaidsFragment.this.m504xc40b640(area, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-raids-RaidsFragment, reason: not valid java name */
    /* synthetic */ void m502x9755753e(Area area, View view) {
        UIUtils.clickArea(this, area);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-raids-RaidsFragment, reason: not valid java name */
    /* synthetic */ void m503x51cb15bf(Area area, View view) {
        UIUtils.clickArea(this, area);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-raids-RaidsFragment, reason: not valid java name */
    /* synthetic */ void m504xc40b640(Area area, View view) {
        if (MainActivity.shownDialogCollectDrops == null) {
            Utils.collectDrops(this, area);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TO_REFRESH) {
            refreshRaidVisibility();
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.binding.navView.setSelectedItemId(R.id.navigation_raids);
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_raids);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public FragmentRaidsBinding getBinding() {
        return this.binding;
    }
}
