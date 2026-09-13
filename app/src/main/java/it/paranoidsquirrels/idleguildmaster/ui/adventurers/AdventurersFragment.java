package it.paranoidsquirrels.idleguildmaster.ui.adventurers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.FragmentAdventurersBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AdventurersFragment extends Fragment {
    private FragmentAdventurersBinding binding;
    private AlertDialog dismissDialog;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentAdventurersBinding fragmentAdventurersBindingInflate = FragmentAdventurersBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = fragmentAdventurersBindingInflate;
        ConstraintLayout root = fragmentAdventurersBindingInflate.getRoot();
        this.binding.slider.post(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AdventurersFragment.this.m215x9293ad2e();
            }
        });
        attachListeners();
        refresh();
        return root;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m215x9293ad2e() {
        try {
            this.binding.imageArrow.setTag("compressed");
            this.binding.imageArrow.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.menu_lift, getContext().getTheme()));
            this.binding.slider.setY(this.binding.menuCommands.getHeight());
        } catch (Exception unused) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            System.exit(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity.adventurersFragment = this;
    }

    public void refresh() {
        this.binding.adventurersList.removeAllViews();
        Iterator<Adventurer> it2 = MainActivity.data.getAdventurers().iterator();
        while (true) {
            int i = 0;
            if (it2.hasNext()) {
                final Adventurer next = it2.next();
                LayoutAdventurerBinding layoutAdventurerBindingInflate = LayoutAdventurerBinding.inflate(getLayoutInflater(), this.binding.adventurersList, false);
                if (next.isAscended()) {
                    UIUtils.applyAscendedPalette(layoutAdventurerBindingInflate);
                }
                layoutAdventurerBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), next.getImageId(), getContext().getTheme()));
                layoutAdventurerBindingInflate.name.setText(getString(next.getIdName()));
                layoutAdventurerBindingInflate.level.setText(String.valueOf(next.getLevel()));
                layoutAdventurerBindingInflate.level.setTextColor(next.getLevel() >= next.getMaxLevel() ? getResources().getColor(R.color.brass_border, getContext().getTheme()) : layoutAdventurerBindingInflate.level.getTextColors().getDefaultColor());
                layoutAdventurerBindingInflate.cardView.setVisibility(next.getDoctrine().getTrueClass().equals("EmptyDoctrine") ? 8 : 0);
                ImageView imageView = layoutAdventurerBindingInflate.expendableDoctrinePoints;
                if (next.getDoctrinePoints() <= 0) {
                    i = 8;
                }
                imageView.setVisibility(i);
                layoutAdventurerBindingInflate.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), next.getDoctrine().getIdImage(), getContext().getTheme()));
                layoutAdventurerBindingInflate.traits.setText(UIUtils.traitsToShortString(next, getResources()));
                layoutAdventurerBindingInflate.weapon.setImageDrawable(Utils.getEquipmentDrawable(next.getWeapon(), getContext()));
                layoutAdventurerBindingInflate.weapon.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m216xe6b5eb30(next, view);
                    }
                });
                layoutAdventurerBindingInflate.armor.setImageDrawable(Utils.getEquipmentDrawable(next.getArmor(), getContext()));
                layoutAdventurerBindingInflate.armor.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m217xadc1d231(next, view);
                    }
                });
                layoutAdventurerBindingInflate.accessory.setImageDrawable(Utils.getEquipmentDrawable(next.getAccessory(), getContext()));
                layoutAdventurerBindingInflate.accessory.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m218x74cdb932(next, view);
                    }
                });
                layoutAdventurerBindingInflate.arrowUp.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m219x3bd9a033(next, view);
                    }
                });
                layoutAdventurerBindingInflate.arrowDown.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m220x2e58734(next, view);
                    }
                });
                layoutAdventurerBindingInflate.delete.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m221xc9f16e35(next, view);
                    }
                });
                layoutAdventurerBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdventurersFragment.this.m222x90fd5536(next, view);
                    }
                });
                this.binding.adventurersList.addView(layoutAdventurerBindingInflate.getRoot());
            } else {
                switchMode(0);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$refresh$1$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m216xe6b5eb30(Adventurer adventurer, View view) {
        detailEquipmentListener(adventurer, "weapon");
    }

    /* JADX INFO: renamed from: lambda$refresh$2$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m217xadc1d231(Adventurer adventurer, View view) {
        detailEquipmentListener(adventurer, "armor");
    }

    /* JADX INFO: renamed from: lambda$refresh$3$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m218x74cdb932(Adventurer adventurer, View view) {
        detailEquipmentListener(adventurer, "accessory");
    }

    /* JADX INFO: renamed from: lambda$refresh$4$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m219x3bd9a033(Adventurer adventurer, View view) {
        moveAdventurer(adventurer, true);
    }

    /* JADX INFO: renamed from: lambda$refresh$5$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m220x2e58734(Adventurer adventurer, View view) {
        moveAdventurer(adventurer, false);
    }

    /* JADX INFO: renamed from: lambda$refresh$6$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m221xc9f16e35(Adventurer adventurer, View view) {
        dismissAdventurer(adventurer);
    }

    /* JADX INFO: renamed from: lambda$refresh$7$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m222x90fd5536(Adventurer adventurer, View view) {
        UIUtils.getAdventurerDetailDialog(getParentFragmentManager(), adventurer, true, false);
    }

    private void detailEquipmentListener(Adventurer adventurer, String str) {
        if (MainActivity.shownDialogSelectEquipment != null) {
            return;
        }
        DialogSelectEquipment dialogSelectEquipment = new DialogSelectEquipment();
        dialogSelectEquipment.type = str;
        dialogSelectEquipment.adventurer = adventurer;
        dialogSelectEquipment.show(getParentFragmentManager(), "select_equipment");
    }

    public void attachListeners() {
        this.binding.menuArrow.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdventurersFragment.this.m211xbdaae516(view);
            }
        });
        this.binding.order.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdventurersFragment.this.m212x84b6cc17(view);
            }
        });
        this.binding.dismiss.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdventurersFragment.this.m209xf7d07dab(view);
            }
        });
        this.binding.done.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdventurersFragment.this.m210xbedc64ac(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m211xbdaae516(View view) {
        boolean zEquals = this.binding.imageArrow.getTag().equals("expanded");
        this.binding.imageArrow.setTag(zEquals ? "compressed" : "expanded");
        this.binding.imageArrow.setImageDrawable(ResourcesCompat.getDrawable(getResources(), zEquals ? R.drawable.menu_lift : R.drawable.menu_drop, getContext().getTheme()));
        this.binding.slider.animate().y(zEquals ? this.binding.menuCommands.getHeight() : 0.0f).start();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m212x84b6cc17(View view) {
        switchMode(1);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m209xf7d07dab(View view) {
        switchMode(2);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m210xbedc64ac(View view) {
        switchMode(0);
    }

    public void switchMode(int i) {
        this.binding.order.setVisibility(i == 0 ? 0 : 4);
        this.binding.dismiss.setVisibility(i == 0 ? 0 : 4);
        this.binding.done.setVisibility(i == 0 ? 4 : 0);
        int childCount = this.binding.adventurersList.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.binding.adventurersList.getChildAt(i2);
            childAt.findViewWithTag("weapon").setVisibility(i == 0 ? 0 : 4);
            childAt.findViewWithTag("armor").setVisibility(i == 0 ? 0 : 4);
            childAt.findViewWithTag("accessory").setVisibility(i == 0 ? 0 : 4);
            childAt.findViewWithTag("arrow_up").setVisibility((i != 1 || i2 == 0) ? 4 : 0);
            childAt.findViewWithTag("arrow_down").setVisibility((i != 1 || i2 == childCount + (-1)) ? 4 : 0);
            childAt.findViewWithTag("dismiss").setVisibility(i == 2 ? 0 : 4);
            i2++;
        }
    }

    private void moveAdventurer(Adventurer adventurer, boolean z) {
        int iIndexOf = MainActivity.data.getAdventurers().indexOf(adventurer);
        MainActivity.data.getAdventurers().remove(adventurer);
        MainActivity.data.getAdventurers().add((z ? -1 : 1) + iIndexOf, adventurer);
        View childAt = this.binding.adventurersList.getChildAt(iIndexOf);
        this.binding.adventurersList.removeViewAt(iIndexOf);
        this.binding.adventurersList.addView(childAt, iIndexOf + (z ? -1 : 1));
        this.binding.adventurersList.getChildAt(0).findViewWithTag("arrow_up").setVisibility(4);
        this.binding.adventurersList.getChildAt(1).findViewWithTag("arrow_up").setVisibility(0);
        this.binding.adventurersList.getChildAt(this.binding.adventurersList.getChildCount() - 1).findViewWithTag("arrow_down").setVisibility(4);
        this.binding.adventurersList.getChildAt(this.binding.adventurersList.getChildCount() - 2).findViewWithTag("arrow_down").setVisibility(0);
    }

    private void dismissAdventurer(final Adventurer adventurer) {
        if (this.dismissDialog != null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Area areaFound = null;
        for (Area area2 : Utils.compileDungeonRaidList()) {
            if (areaFound == null && area2.getAdventurersExploringIds().contains(Integer.valueOf(adventurer.getId()))) {
                areaFound = area2;
            }
            if (area2.getSavedAdventurersIds().contains(Integer.valueOf(adventurer.getId()))) {
                arrayList.add(area2);
            }
        }
        final Area area = areaFound;
        String str = String.format(getString(R.string.dismiss_dialog_body), getString(adventurer.getIdName()));
        if (area != null) {
            str = str + "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon), getString(area.getName()));
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.dismiss_dialog_title), str, R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AdventurersFragment.this.m213x9b6f041c(adventurer, area, arrayList, dialogInterface, i);
            }
        });
        this.dismissDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AdventurersFragment.this.m214x627aeb1d(dialogInterface);
            }
        });
        this.dismissDialog.show();
    }

    /* JADX INFO: renamed from: lambda$dismissAdventurer$13$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m213x9b6f041c(Adventurer adventurer, Area area, List list, DialogInterface dialogInterface, int i) {
        Weapon defaultWeapon = Utils.getDefaultWeapon(adventurer.getWeaponType());
        boolean zEquals = adventurer.getWeapon().equals(defaultWeapon);
        int size = MainActivity.data.getItems().size() + ((zEquals || MainActivity.data.getItems().contains(adventurer.getWeapon())) ? 0 : 1) + ((adventurer.getArmor() == null || MainActivity.data.getItems().contains(adventurer.getArmor())) ? 0 : 1) + ((adventurer.getAccessory() == null || MainActivity.data.getItems().contains(adventurer.getAccessory())) ? 0 : 1);
        int iStorageSpaces = Formulas.storageSpaces();
        if (size > iStorageSpaces) {
            if (MainActivity.shownDialogFullStorage != null) {
                return;
            }
            MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.no_storage_space_title), String.format(getString(R.string.no_storage_space_body_dismiss), Integer.valueOf(size - iStorageSpaces)), false);
            MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface2) {
                    MainActivity.shownDialogFullStorage = null;
                }
            });
            MainActivity.shownDialogFullStorage.show();
            return;
        }
        if (area != null) {
            area.terminationRequested = true;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((Area) it2.next()).getSavedAdventurersIds().remove(Integer.valueOf(adventurer.getId()));
        }
        int iIndexOf = MainActivity.data.getAdventurers().indexOf(adventurer);
        MainActivity.data.getAdventurers().remove(adventurer);
        this.binding.adventurersList.removeViewAt(iIndexOf);
        if (!zEquals) {
            Utils.collectItem(adventurer.getWeapon(), MainActivity.data.getItems());
            adventurer.setWeapon(defaultWeapon);
        }
        if (adventurer.getArmor() != null) {
            Utils.collectItem(adventurer.getArmor(), MainActivity.data.getItems());
            adventurer.setArmor(null);
        }
        if (adventurer.getAccessory() != null) {
            Utils.collectItem(adventurer.getAccessory(), MainActivity.data.getItems());
            adventurer.setAccessory(null);
        }
        adventurer.setTimeWhenDismissed(TrueTimeUtils.millis());
        MainActivity.data.getDismissedAdventurers().add(0, adventurer);
        MainActivity.headquartersFragment.refresh();
        this.dismissDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$dismissAdventurer$14$it-paranoidsquirrels-idleguildmaster-ui-adventurers-AdventurersFragment, reason: not valid java name */
    /* synthetic */ void m214x627aeb1d(DialogInterface dialogInterface) {
        this.dismissDialog = null;
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
        mainActivity.binding.navView.setSelectedItemId(R.id.navigation_adventurers);
        mainActivity.binding.fragmentName.setText(R.string.fragment_name_adventurers);
    }

    public FragmentAdventurersBinding getBinding() {
        return this.binding;
    }
}
