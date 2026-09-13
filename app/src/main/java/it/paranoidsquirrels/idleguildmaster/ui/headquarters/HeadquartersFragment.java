package it.paranoidsquirrels.idleguildmaster.ui.headquarters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentHeadquartersBinding;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop;

/* JADX INFO: loaded from: classes3.dex */
public class HeadquartersFragment extends Fragment {
    private FragmentHeadquartersBinding binding;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentHeadquartersBinding fragmentHeadquartersBindingInflate = FragmentHeadquartersBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = fragmentHeadquartersBindingInflate;
        ConstraintLayout root = fragmentHeadquartersBindingInflate.getRoot();
        attachListeners();
        refresh();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.headquartersFragment = this;
    }

    public void refresh() {
        this.binding.quartersDescription.setText(String.format(getString(R.string.headquarters_quarters_description_short), Integer.valueOf(MainActivity.data.getAdventurers().size()), Integer.valueOf(Formulas.getQuartersCapacity())));
        this.binding.tavernDescription.setText(String.format(getString(R.string.headquarters_tavern_description_short), Integer.valueOf(MainActivity.data.getTavernGuests().size()), Integer.valueOf(Formulas.getTavernCapacity())));
        int i = 8;
        this.binding.tavernDot.setVisibility((MainActivity.data.getTavernGuests().isEmpty() || MainActivity.data.getTavernGuests().get(0).isSeen()) ? 8 : 0);
        TextView textView = this.binding.tavernNew;
        if (!MainActivity.data.getTavernGuests().isEmpty() && !MainActivity.data.getTavernGuests().get(0).isSeen()) {
            i = 0;
        }
        textView.setVisibility(i);
        this.binding.storageDescription.setText(String.format(getString(R.string.headquarters_storage_description_short), Integer.valueOf(MainActivity.data.getItems().size()), Integer.valueOf(Formulas.storageSpaces())));
        this.binding.shelterDescription.setText(String.format(getString(R.string.headquarters_shelter_description_short), Integer.valueOf(MainActivity.data.getPets().size()), Integer.valueOf(Formulas.shelterCapacity())));
        int size = MainActivity.data.getSoldMarketItems().size() + MainActivity.data.getMarketListings().size();
        this.binding.marketDescription.setText(size == 0 ? "" : String.format(getString(R.string.headquarters_market_description_short), Integer.valueOf(MainActivity.data.getSoldMarketItems().size()), Integer.valueOf(size)));
        int size2 = MainActivity.data.getCompletedWorkshopItems().size() + MainActivity.data.getWorkshopQueue().size();
        this.binding.workshopDescription.setText(size2 != 0 ? String.format(getString(R.string.headquarters_workshop_description_short), Integer.valueOf(MainActivity.data.getCompletedWorkshopItems().size()), Integer.valueOf(size2)) : "");
        this.binding.tavernDescription.setTextColor(getResources().getColor(MainActivity.data.isTavernLocked() ? UIUtils.getFailureColor() : R.color.dim_white, getContext().getTheme()));
    }

    public void attachListeners() {
        this.binding.quartersContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m496x3d2a446(view);
            }
        });
        this.binding.tavernContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m497x3780cf07(view);
            }
        });
        this.binding.storageContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m498x6b2ef9c8(view);
            }
        });
        this.binding.marketContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m499x9edd2489(view);
            }
        });
        this.binding.workshopContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m500xd28b4f4a(view);
            }
        });
        this.binding.shelterContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeadquartersFragment.this.m501x6397a0b(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m496x3d2a446(View view) {
        if (MainActivity.shownDialogQuarters == null) {
            new DialogQuarters().show(getParentFragmentManager(), "dialog_quarters");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m497x3780cf07(View view) {
        if (MainActivity.shownDialogTavern == null) {
            new DialogTavern().show(getParentFragmentManager(), "dialog_tavern");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m498x6b2ef9c8(View view) {
        if (MainActivity.shownDialogStorage == null) {
            new DialogStorage().show(getParentFragmentManager(), "dialog_storage");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m499x9edd2489(View view) {
        if (MainActivity.shownDialogMarket == null) {
            new DialogMarket().show(getParentFragmentManager(), "dialog_market");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m500xd28b4f4a(View view) {
        if (MainActivity.shownDialogWorkshop == null) {
            new DialogWorkshop().show(getParentFragmentManager(), "dialog_storage");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-headquarters-HeadquartersFragment, reason: not valid java name */
    /* synthetic */ void m501x6397a0b(View view) {
        if (MainActivity.shownDialogShelter == null) {
            new DialogShelter().show(getParentFragmentManager(), "dialog_shelter");
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
        mainActivity.binding.navView.setSelectedItemId(R.id.navigation_headquarters);
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_headquarters);
    }

    public FragmentHeadquartersBinding getBinding() {
        return this.binding;
    }
}
