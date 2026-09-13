package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSendTeamBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogSendTeam extends CustomDialog {
    public Area area;
    public DialogSendTeamBinding binding;
    public List<Integer> selectedAdventurersId;
    public Integer selectedPetId;
    private List<LayoutAdventurerBinding> slotsList;
    private AlertDialog teamMembersBusy = null;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogSendTeamBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.team_composition);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogSendTeamBinding dialogSendTeamBindingInflate = DialogSendTeamBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogSendTeamBindingInflate;
        return dialogSendTeamBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        if (this.area == null) {
            dismiss();
        }
        int iAdventurersNumber = this.area.adventurersNumber();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.binding.scrollView.getLayoutParams().height = (int) Math.min(displayMetrics.density * iAdventurersNumber * 68, ((double) displayMetrics.heightPixels) * 0.6d);
        this.selectedAdventurersId = new ArrayList();
        this.area.getAdventurersExploringIds().clear();
        this.slotsList = Arrays.asList(this.binding.adventurer1, this.binding.adventurer2, this.binding.adventurer3, this.binding.adventurer4, this.binding.adventurer5, this.binding.adventurer6, this.binding.adventurer7, this.binding.adventurer8, this.binding.adventurer9, this.binding.adventurer10, this.binding.adventurer11, this.binding.adventurer12, this.binding.adventurer13, this.binding.adventurer14);
        for (int i = 13; i > iAdventurersNumber - 1; i--) {
            this.slotsList.get(i).getRoot().setVisibility(8);
        }
        setupAdventurers();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.save.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m412x9cafb266(view);
            }
        });
        this.binding.load.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m414x9971ba24(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m415x17d2be03(view);
            }
        });
        this.binding.clear.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m416x9633c1e2(view);
            }
        });
        this.binding.send.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m417x1494c5c1(view);
            }
        });
        this.binding.petContainer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSendTeam.this.m418x92f5c9a0(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m412x9cafb266(View view) {
        this.area.getSavedAdventurersIds().clear();
        this.area.getSavedAdventurersIds().addAll(this.selectedAdventurersId);
        this.area.setSavedPetId(this.selectedPetId);
        blink((TextView) view, true);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m414x9971ba24(View view) {
        if (this.area.getSavedAdventurersIds().isEmpty() && this.area.getSavedPetId() == null) {
            blink((TextView) view, false);
            return;
        }
        this.selectedAdventurersId.clear();
        ArrayList arrayList = new ArrayList(this.area.getSavedAdventurersIds());
        this.selectedPetId = this.area.getSavedPetId();
        ArrayList arrayList2 = new ArrayList();
        for (Area area : Utils.compileDungeonRaidList()) {
            for (Integer num : area.getAdventurersExploringIds()) {
                if (this.area.getSavedAdventurersIds().contains(num)) {
                    arrayList.remove(num);
                    for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
                        if (adventurer.getId() == num.intValue()) {
                            arrayList2.add(String.format(getString(R.string.load_team_busy_member), getString(adventurer.getIdName()), getString(area.getName())));
                            break;
                        }
                    }
                }
            }
            if (area.getPetExploringId() != null && area.getPetExploringId().equals(this.area.getSavedPetId())) {
                for (Pet pet : MainActivity.data.getPets()) {
                    if (pet.getId() == this.selectedPetId.intValue()) {
                        arrayList2.add(String.format(getString(R.string.load_team_busy_member), getString(pet.getIdName()), getString(area.getName())));
                        break;
                    }
                }
                this.selectedPetId = null;
            }
        }
        this.selectedAdventurersId.addAll(arrayList);
        if ((arrayList.size() < this.area.getSavedAdventurersIds().size() || (this.selectedPetId == null && this.area.getSavedPetId() != null)) && this.teamMembersBusy == null) {
            StringBuilder sb = new StringBuilder("");
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) arrayList2.get(i));
                if (i < size - 1) {
                    sb.append(System.lineSeparator());
                }
            }
            AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.load_team_busy_members), sb.toString(), false);
            this.teamMembersBusy = infoDialog;
            infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogSendTeam.this.m413x1b10b645(dialogInterface);
                }
            });
            this.teamMembersBusy.show();
        }
        setupAdventurers();
        blink((TextView) view, true);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m413x1b10b645(DialogInterface dialogInterface) {
        this.teamMembersBusy = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m415x17d2be03(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m416x9633c1e2(View view) {
        this.selectedAdventurersId.clear();
        this.selectedPetId = null;
        setupAdventurers();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m417x1494c5c1(View view) {
        if (this.selectedAdventurersId.size() > 0) {
            this.area.terminationRequested = false;
            this.area.setAdventurersExploringIds(this.selectedAdventurersId);
            this.area.setPetExploringId(this.selectedPetId);
            this.area.setTriesAvailable(false);
            this.area.refreshTries();
            if (MainActivity.data.isSettingAutoOpenDungeonDetail()) {
                UIUtils.clickArea(MainActivity.dungeonsFragment, this.area);
            }
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m418x92f5c9a0(View view) {
        if (MainActivity.shownDialogChoosePet == null) {
            MainActivity.shownDialogChoosePet = new DialogChoosePet();
            MainActivity.shownDialogChoosePet.show(getParentFragmentManager(), "dialog_choose_pet");
        }
    }

    private void blink(final TextView textView, boolean z) {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getContext().getColor(R.color.dim_white), getContext().getColor(z ? R.color.success : UIUtils.getFailureColor()), getContext().getColor(R.color.dim_white));
        valueAnimatorOfArgb.setInterpolator(new LinearInterpolator());
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfArgb.setDuration(400L);
        valueAnimatorOfArgb.start();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogSendTeam = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogSendTeam = null;
        super.onStop();
    }

    public void setupAdventurers() {
        int iAdventurersNumber = this.area.adventurersNumber();
        int i = 0;
        while (true) {
            Pet pet = null;
            Adventurer adventurer = null;
            pet = null;
            if (i < iAdventurersNumber) {
                LayoutAdventurerBinding layoutAdventurerBinding = this.slotsList.get(i);
                int i2 = i + 1;
                if (this.selectedAdventurersId.size() >= i2) {
                    for (Adventurer adventurer2 : MainActivity.data.getAdventurers()) {
                        if (adventurer2.getId() == this.selectedAdventurersId.get(i).intValue()) {
                            adventurer = adventurer2;
                            break;
                        }
                    }
                    if (adventurer == null) {
                        try {
                            this.area.getSavedAdventurersIds().remove(this.selectedAdventurersId.get(i));
                        } catch (Exception unused) {
                            this.area.getSavedAdventurersIds().clear();
                        }
                        dismiss();
                        return;
                    }
                    layoutAdventurerBinding.image.setVisibility(0);
                    layoutAdventurerBinding.weapon.setVisibility(0);
                    layoutAdventurerBinding.armor.setVisibility(0);
                    layoutAdventurerBinding.accessory.setVisibility(0);
                    layoutAdventurerBinding.plusSign.setVisibility(8);
                    if (adventurer.isAscended()) {
                        UIUtils.applyAscendedPalette(layoutAdventurerBinding);
                    } else {
                        layoutAdventurerBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_dim_white);
                        layoutAdventurerBinding.weapon.setBackgroundResource(R.drawable.object_border_dim_white);
                        layoutAdventurerBinding.armor.setBackgroundResource(R.drawable.object_border_dim_white);
                        layoutAdventurerBinding.accessory.setBackgroundResource(R.drawable.object_border_dim_white);
                        layoutAdventurerBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left);
                        layoutAdventurerBinding.name.setTextColor(getResources().getColor(R.color.dim_white, getContext().getTheme()));
                    }
                    layoutAdventurerBinding.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getImageId(), getContext().getTheme()));
                    layoutAdventurerBinding.name.setText(getString(adventurer.getIdName()));
                    layoutAdventurerBinding.cardView.setVisibility(adventurer.getDoctrine().getTrueClass().equals("EmptyDoctrine") ? 8 : 0);
                    layoutAdventurerBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
                    layoutAdventurerBinding.expendableDoctrinePoints.setVisibility(8);
                    layoutAdventurerBinding.traits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
                    layoutAdventurerBinding.weapon.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getWeapon(), getContext()));
                    layoutAdventurerBinding.armor.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getArmor(), getContext()));
                    layoutAdventurerBinding.accessory.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getAccessory(), getContext()));
                } else {
                    layoutAdventurerBinding.image.setVisibility(4);
                    layoutAdventurerBinding.name.setText("");
                    layoutAdventurerBinding.traits.setText("");
                    layoutAdventurerBinding.cardView.setVisibility(8);
                    layoutAdventurerBinding.weapon.setVisibility(4);
                    layoutAdventurerBinding.armor.setVisibility(4);
                    layoutAdventurerBinding.accessory.setVisibility(4);
                    layoutAdventurerBinding.plusSign.setVisibility(0);
                }
                final int slotIndex = i;
                layoutAdventurerBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogSendTeam.this.m419x72c038aa(slotIndex, view);
                    }
                });
                i = i2;
            } else {
                if (this.selectedPetId != null) {
                    for (Pet pet2 : MainActivity.data.getPets()) {
                        if (pet2.getId() == this.selectedPetId.intValue()) {
                            pet = pet2;
                            break;
                        }
                    }
                }
                this.binding.imagePetPlus.setVisibility(pet != null ? 4 : 0);
                this.binding.imagePet.setVisibility(pet == null ? 4 : 0);
                if (pet != null) {
                    this.binding.imagePet.setImageDrawable(ResourcesCompat.getDrawable(getResources(), pet.getIdImage(), getContext().getTheme()));
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$setupAdventurers$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSendTeam, reason: not valid java name */
    /* synthetic */ void m419x72c038aa(int i, View view) {
        if (MainActivity.shownDialogChooseAdventurer == null) {
            MainActivity.shownDialogChooseAdventurer = new DialogChooseAdventurer();
            Bundle bundle = new Bundle();
            bundle.putInt("positionClicked", i);
            MainActivity.shownDialogChooseAdventurer.setArguments(bundle);
            MainActivity.shownDialogChooseAdventurer.show(getParentFragmentManager(), "dialog_choose_adventurer");
        }
    }
}
