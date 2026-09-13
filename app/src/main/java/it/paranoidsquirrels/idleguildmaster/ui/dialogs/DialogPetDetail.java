package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogPetDetailBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogPetDetail extends CustomDialog {
    private static final String ORANGE_BOLD = "<font color=#C86400><strong>%s</strong></font>";
    private DialogPetDetailBinding binding;
    public Pet pet;
    private AlertDialog setFreeDialog = null;
    private boolean isSmallScreen = false;
    private int descriptionLinesDisplayed = Integer.MAX_VALUE;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogPetDetailBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(this.pet.getIdName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogPetDetailBinding dialogPetDetailBindingInflate = DialogPetDetailBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogPetDetailBindingInflate;
        return dialogPetDetailBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.isSmallScreen = getResources().getDisplayMetrics().heightPixels < 1400;
        this.binding.description.setMaxLines(this.isSmallScreen ? 1 : Integer.MAX_VALUE);
        this.binding.detailImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.pet.getIdImage(), getContext().getTheme()));
        this.binding.detailLevel.setText(String.format(getString(R.string.pet_level_formatted), Integer.valueOf(this.pet.getLevel())));
        this.binding.petType.setText(getString(this.pet.printPetType()));
        int i = this.pet.totalFoodToNextLevel();
        this.binding.detailExperience.setText(String.format(getString(R.string.pet_food_formatted), Integer.valueOf(this.pet.getFood()), Integer.valueOf(i)));
        this.binding.detailExperienceBar.setProgress((int) (((double) (this.pet.getFood() * 100)) / ((double) i)));
        this.binding.description.setText(getString(this.pet.getIdDescription()));
        this.binding.ability1Name.setText(String.format(getString(R.string.pet_ability_name_unlocked), getString(this.pet.getPetAbility1().name), Integer.valueOf(this.pet.getLevel())));
        this.binding.ability2Name.setText(this.pet.getLevel() > 20 ? String.format(getString(R.string.pet_ability_name_unlocked), getString(this.pet.getPetAbility2().name), Integer.valueOf(this.pet.getLevel() - 20)) : String.format(getString(R.string.pet_ability_name_locked), getString(this.pet.getPetAbility2().name), 21));
        this.binding.ability3Name.setText(this.pet.getLevel() > 40 ? String.format(getString(R.string.pet_ability_name_unlocked), getString(this.pet.getPetAbility3().name), Integer.valueOf(this.pet.getLevel() - 40)) : String.format(getString(R.string.pet_ability_name_locked), getString(this.pet.getPetAbility3().name), 41));
        this.binding.ability4Name.setText(this.pet.getLevel() > 60 ? String.format(getString(R.string.pet_ability_name_unlocked), getString(this.pet.getPetAbility4().name), Integer.valueOf(this.pet.getLevel() - 60)) : String.format(getString(R.string.pet_ability_name_locked), getString(this.pet.getPetAbility4().name), 61));
        this.binding.ability1Description.setText(Html.fromHtml(formatPetAbilityDescription(this.pet.getPetAbility1()), 0));
        this.binding.ability2Description.setText(Html.fromHtml(formatPetAbilityDescription(this.pet.getPetAbility2()), 0));
        this.binding.ability3Description.setText(Html.fromHtml(formatPetAbilityDescription(this.pet.getPetAbility3()), 0));
        this.binding.ability4Description.setText(Html.fromHtml(formatPetAbilityDescription(this.pet.getPetAbility4()), 0));
        this.binding.lockAbility2.setVisibility(this.pet.getLevel() > 20 ? 8 : 0);
        this.binding.lockAbility3.setVisibility(this.pet.getLevel() > 40 ? 8 : 0);
        this.binding.lockAbility4.setVisibility(this.pet.getLevel() > 60 ? 8 : 0);
        this.binding.containerAbility3.setVisibility(this.pet.getAbilityNumber() > 2 ? 0 : 8);
        this.binding.containerAbility4.setVisibility(this.pet.getAbilityNumber() <= 3 ? 8 : 0);
        this.binding.dismiss.setText(((this.pet.getLevel() > 1 || this.pet.getFood() > 0) && MainActivity.data.getPets().size() > 1) ? R.string.pet_merge : R.string.pet_set_free);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.dismiss.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogPetDetail.this.m370xdfb8ee11(view);
            }
        });
        if (this.isSmallScreen) {
            this.binding.description.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogPetDetail.this.m371x2d786612(view);
                }
            });
        }
        this.binding.exit2.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogPetDetail.this.m372x7b37de13(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPetDetail, reason: not valid java name */
    /* synthetic */ void m370xdfb8ee11(View view) {
        boolean z = (this.pet.getLevel() > 1 || this.pet.getFood() > 0) && MainActivity.data.getPets().size() > 1;
        if (z || this.setFreeDialog == null) {
            if (!z || MainActivity.shownDialogConsumeFood == null) {
                if (z) {
                    DialogMergePet dialogMergePet = new DialogMergePet();
                    dialogMergePet.selected = this.pet;
                    dialogMergePet.show(getParentFragmentManager(), "merge_pet");
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                Area areaFound = null;
                for (Area area2 : Utils.compileDungeonRaidList()) {
                    if (areaFound == null && area2.getPetExploringId() != null && area2.getPetExploringId().equals(Integer.valueOf(this.pet.getId()))) {
                        areaFound = area2;
                    }
                    if (area2.getSavedPetId() != null && area2.getSavedPetId().equals(Integer.valueOf(this.pet.getId()))) {
                        arrayList.add(area2);
                    }
                }
                final Area area = areaFound;
                String str = "" + String.format(getString(R.string.pet_set_free_body), getString(this.pet.getIdName()));
                if (area != null) {
                    str = str + "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon_pet), getString(area.getName()));
                }
                AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.pet_set_free), str, R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DialogPetDetail.this.m368x4439fe0f(arrayList, area, dialogInterface, i);
                    }
                });
                this.setFreeDialog = actionDialog;
                actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        DialogPetDetail.this.m369x91f97610(dialogInterface);
                    }
                });
                this.setFreeDialog.show();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPetDetail, reason: not valid java name */
    /* synthetic */ void m368x4439fe0f(List list, Area area, DialogInterface dialogInterface, int i) {
        MainActivity.data.getPets().remove(this.pet);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((Area) it2.next()).setSavedPetId(null);
        }
        if (area != null) {
            area.terminationRequested = true;
        }
        if (MainActivity.shownDialogShelter != null) {
            MainActivity.shownDialogShelter.refresh();
        }
        MainActivity.headquartersFragment.refresh();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPetDetail, reason: not valid java name */
    /* synthetic */ void m369x91f97610(DialogInterface dialogInterface) {
        this.setFreeDialog = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPetDetail, reason: not valid java name */
    /* synthetic */ void m371x2d786612(View view) {
        this.binding.description.setMaxLines(this.binding.description.getMaxLines() <= 1 ? Integer.MAX_VALUE : 1);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogPetDetail, reason: not valid java name */
    /* synthetic */ void m372x7b37de13(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility;

        static {
            int[] iArr = new int[PetAbility.values().length];
            $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility = iArr;
            try {
                iArr[PetAbility.FIGHTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.HEALER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.DECOY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.OPPORTUNIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.MAGIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.SAVAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.BRIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.EXPERIENCE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.DROPS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.COUNTERATTACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.LIFESTEAL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.REGENERATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[PetAbility.BARRIER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public String formatPetAbilityDescription(PetAbility petAbility) {
        String string = getString(petAbility.description);
        switch (AnonymousClass1.$SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$pets$PetAbility[petAbility.ordinal()]) {
            case 1:
                return String.format(string, wrap(Utils.round(this.pet.getFighter() * 0.9d)), wrap(Utils.round(this.pet.getFighter() * 1.1d)));
            case 2:
                return String.format(string, wrap(Utils.round(this.pet.getHealer() * 0.9d)), wrap(Utils.round(this.pet.getHealer() * 1.1d)));
            case 3:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getDecoy())));
            case 4:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getOpportunist())));
            case 5:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getStatusEffectChance())), wrap(this.pet.getStatusEffectTurns()));
            case 6:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getSavage())));
            case 7:
                return String.format(string, wrap(this.pet.getBright()));
            case 8:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getExperience())));
            case 9:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getDrops())));
            case 10:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getCounterattack())));
            case 11:
                return String.format(string, wrap(UIUtils.formatDouble2Decimals(this.pet.getLifesteal())));
            case 12:
                return String.format(string, wrap(this.pet.getRegeneration()));
            case 13:
                return String.format(string, wrap(this.pet.getBarrier()));
            default:
                return "";
        }
    }

    private static String wrap(String str) {
        return String.format(ORANGE_BOLD, str);
    }

    private static String wrap(int i) {
        return wrap(String.valueOf(i));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogPetDetail = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogPetDetail = null;
        super.onStop();
    }
}
