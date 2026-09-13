package it.paranoidsquirrels.idleguildmaster.ui.dungeons;

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
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentDungeonsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;

/* JADX INFO: loaded from: classes3.dex */
public class DungeonsFragment extends Fragment {
    private FragmentDungeonsBinding binding;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentDungeonsBinding fragmentDungeonsBindingInflate = FragmentDungeonsBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = fragmentDungeonsBindingInflate;
        ConstraintLayout root = fragmentDungeonsBindingInflate.getRoot();
        attachListeners();
        refresh();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.dungeonsFragment = this;
    }

    public void refresh() {
        for (Area area : Utils.compileDungeonList()) {
            area.getLayout().dungeonImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), area.getSummaryDrawable(), getContext().getTheme()));
            area.getLayout().dungeonTitle.setText(area.getName());
            area.getLayout().raidTryAvailable.setVisibility(8);
            area.getLayout().epicRaid.setVisibility(8);
            area.refreshAdventurers();
            area.refreshLoot();
            area.refreshActionDisplayed();
        }
    }

    public void refreshDungeonVisibility() {
        for (Area area : Utils.compileDungeonList()) {
            area.getLayout().getRoot().setVisibility(area.isUnlocked() ? 0 : 8);
        }
    }

    public void attachListeners() {
        for (final Area area : Utils.compileDungeonList()) {
            area.getLayout().getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DungeonsFragment.this.m493x61bebc86(area, view);
                }
            });
            area.getLayout().dungeonAdventurersExploring.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DungeonsFragment.this.m494x3d803847(area, view);
                }
            });
            area.getLayout().lootImage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DungeonsFragment.this.m495x1941b408(area, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dungeons-DungeonsFragment, reason: not valid java name */
    /* synthetic */ void m493x61bebc86(Area area, View view) {
        UIUtils.clickArea(this, area);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dungeons-DungeonsFragment, reason: not valid java name */
    /* synthetic */ void m494x3d803847(Area area, View view) {
        UIUtils.clickArea(this, area);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dungeons-DungeonsFragment, reason: not valid java name */
    /* synthetic */ void m495x1941b408(Area area, View view) {
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
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.binding.navView.setSelectedItemId(R.id.navigation_dungeons);
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_dungeons);
    }

    public FragmentDungeonsBinding getBinding() {
        return this.binding;
    }
}
