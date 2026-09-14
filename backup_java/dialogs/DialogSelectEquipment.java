package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSelectEquipmentBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutSelectEquipmentBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.CopperArmor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes3.dex */
public class DialogSelectEquipment extends CustomDialog {
    public Adventurer adventurer;
    private DialogSelectEquipmentBinding binding;
    private AlertDialog confirm;
    public String type;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogSelectEquipmentBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        String str = this.type;
        if (str == null || this.adventurer == null) {
            dismiss();
            return "";
        }
        str.hashCode();
        switch (str) {
            case "accessory":
                return getString(R.string.select_accessory_title);
            case "weapon":
                return String.format(getString(R.string.select_equipment_variable_title), getString(this.adventurer.getDoctrine().canUseAllWeapons() ? R.string.type_generic : this.adventurer.getWeaponType()));
            case "armor":
                return String.format(getString(R.string.select_equipment_variable_title), getString(this.adventurer.getArmorType()));
            default:
                return "";
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogSelectEquipmentBinding dialogSelectEquipmentBindingInflate = DialogSelectEquipmentBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogSelectEquipmentBindingInflate;
        return dialogSelectEquipmentBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        Equipment accessory;
        int weaponType;
        this.binding.equipped.item.image.setBackgroundResource(R.drawable.object_border_rounded_left);
        String str = this.type;
        str.hashCode();
        switch (str) {
            case "accessory":
                accessory = this.adventurer.getAccessory();
                weaponType = R.string.type_accessory;
                break;
            case "weapon":
                accessory = this.adventurer.getWeapon();
                weaponType = this.adventurer.getWeaponType();
                break;
            case "armor":
                accessory = this.adventurer.getArmor();
                weaponType = this.adventurer.getArmorType();
                break;
            default:
                throw new NullPointerException("null type in DialogSelectEquipment initialize");
        }
        if (accessory != null) {
            this.binding.equipped.item.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), accessory.getIdImage(), getContext().getTheme()));
            this.binding.equipped.item.stack.setText("");
            this.binding.equipped.name.setText(accessory.getIdName());
            setGainLoss(this.binding.equipped, null, accessory);
            this.binding.equipped.effect.setText(accessory.getIdEffect() != 0 ? getString(accessory.getIdEffect()) : "");
        }
        ArrayList<Equipment> arrayList = new ArrayList();
        for (Item item : MainActivity.data.getItems()) {
            if (item.printType() == weaponType || (this.adventurer.getDoctrine().canUseAllWeapons() && "weapon".equals(this.type) && (item instanceof Weapon))) {
                arrayList.add((Equipment) item);
            }
        }
        arrayList.sort(Comparator.comparingInt(new ToIntFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda3
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return DialogSelectEquipment.lambda$initialize$0((Equipment) obj);
            }
        }));
        this.binding.list.removeAllViews();
        for (final Equipment equipment : arrayList) {
            LayoutSelectEquipmentBinding layoutSelectEquipmentBindingInflate = LayoutSelectEquipmentBinding.inflate(getLayoutInflater(), this.binding.list, false);
            layoutSelectEquipmentBindingInflate.item.image.setBackgroundResource(R.drawable.object_border_rounded_left);
            layoutSelectEquipmentBindingInflate.item.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), equipment.getIdImage(), getContext().getTheme()));
            layoutSelectEquipmentBindingInflate.item.stack.setText(String.valueOf(equipment.getStack()));
            layoutSelectEquipmentBindingInflate.name.setText(equipment.getIdName());
            setGainLoss(layoutSelectEquipmentBindingInflate, accessory, equipment);
            layoutSelectEquipmentBindingInflate.gain.setTextColor(getResources().getColor(R.color.success, getContext().getTheme()));
            layoutSelectEquipmentBindingInflate.loss.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
            layoutSelectEquipmentBindingInflate.effect.setText(equipment.getIdEffect() != 0 ? getString(equipment.getIdEffect()) : "");
            layoutSelectEquipmentBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogSelectEquipment.this.m407x17c7ada2(equipment, view);
                }
            });
            this.binding.list.addView(layoutSelectEquipmentBindingInflate.getRoot());
        }
        this.binding.scrollView.setVisibility(arrayList.size() > 0 ? 0 : 8);
        this.binding.noEquipments.setVisibility(arrayList.size() > 0 ? 8 : 0);
    }

    static /* synthetic */ int lambda$initialize$0(Equipment equipment) {
        return -equipment.getRarity();
    }

    /* JADX INFO: renamed from: lambda$initialize$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSelectEquipment, reason: not valid java name */
    /* synthetic */ void m407x17c7ada2(Equipment equipment, View view) {
        askSwap(equipment);
    }

    private void askSwap(final Equipment equipment) {
        final Equipment accessory;
        String str = this.type;
        str.hashCode();
        switch (str) {
            case "accessory":
                accessory = this.adventurer.getAccessory();
                break;
            case "weapon":
                accessory = this.adventurer.getWeapon();
                break;
            case "armor":
                accessory = this.adventurer.getArmor();
                break;
            default:
                throw new NullPointerException("null type in DialogSelectEquipment askSwap");
        }
        if (accessory == null) {
            swap(null, equipment);
            return;
        }
        if (Formulas.storageSpaces() <= MainActivity.data.getItems().size() && !MainActivity.data.getItems().contains(accessory) && equipment.getStack() > 1) {
            if (MainActivity.shownDialogFullStorage != null) {
                return;
            }
            MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.no_storage_space_title), getString(R.string.no_storage_space_body_swap), false);
            MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownDialogFullStorage = null;
                }
            });
            MainActivity.shownDialogFullStorage.show();
            return;
        }
        if (MainActivity.data.isSettingConfirmSwap()) {
            boolean zEquals = "ko".equals(getString(R.string.language_code));
            AlertDialog actionDialog = UIUtils.getActionDialog(getContext(), Integer.valueOf(R.string.change_equipment_title), String.format(getString(R.string.change_equipment_body), getString(zEquals ? accessory.getIdName() : equipment.getIdName()), getString(zEquals ? equipment.getIdName() : accessory.getIdName())), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogSelectEquipment.this.m403x6ae86166(accessory, equipment, dialogInterface, i);
                }
            });
            this.confirm = actionDialog;
            actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogSelectEquipment.this.m404x4e1414a7(dialogInterface);
                }
            });
            this.confirm.show();
            return;
        }
        swap(accessory, equipment);
    }

    /* JADX INFO: renamed from: lambda$askSwap$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSelectEquipment, reason: not valid java name */
    /* synthetic */ void m403x6ae86166(Equipment equipment, Equipment equipment2, DialogInterface dialogInterface, int i) {
        swap(equipment, equipment2);
    }

    /* JADX INFO: renamed from: lambda$askSwap$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSelectEquipment, reason: not valid java name */
    /* synthetic */ void m404x4e1414a7(DialogInterface dialogInterface) {
        this.confirm = null;
    }

    private void swap(Equipment equipment, Equipment equipment2) {
        Equipment equipment3 = (Equipment) Item.getInstance(equipment2.getTrueClass(), 1);
        if (equipment != null && !Utils.getDefaultWeapon(this.adventurer.getWeaponType()).equals(equipment)) {
            Utils.collectItem(equipment, MainActivity.data.getItems());
        }
        Utils.removeItemFromStorage(equipment3);
        String str = this.type;
        str.hashCode();
        switch (str) {
            case "accessory":
                this.adventurer.setAccessory((Accessory) equipment3);
                break;
            case "weapon":
                this.adventurer.setWeapon((Weapon) equipment3);
                break;
            case "armor":
                this.adventurer.setArmor((Armor) equipment3);
                break;
            default:
                throw new NullPointerException("null type in DialogSelectEquipment swap");
        }
        MainActivity.adventurersFragment.refresh();
        MainActivity.headquartersFragment.refresh();
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
            MainActivity.shownDialogEntityDetail.populateHelp(null, DialogEntityDetail.formatEquipmentHelp(equipment2, getResources()), true, this.type);
        }
        if (MainActivity.data.getTutorialStep() == 5 && (equipment2 instanceof CopperArmor)) {
            MainActivity.data.setTutorialStep(6);
            Utils.progressTavernTime(28800L);
            ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refresh();
        }
        int iCalculateTotalMaxHp = this.adventurer.calculateTotalMaxHp();
        if (this.adventurer.getCurrentHp() > iCalculateTotalMaxHp) {
            this.adventurer.setCurrentHp(iCalculateTotalMaxHp);
        }
        if ("SerpentSting".equals(equipment3.getTrueClass())) {
            this.adventurer.addStatusEffect(new StatusEffect(StatusEffectType.STUN_NOT_CLEANSABLE, this.adventurer, 1, 1.0d), 0.0d);
        }
        dismiss();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void unequip() {
        Equipment accessory;
        Weapon defaultWeapon = Utils.getDefaultWeapon(this.adventurer.getWeaponType());
        String str = this.type;
        str.hashCode();
        switch (str) {
            case "accessory":
                accessory = this.adventurer.getAccessory();
                break;
            case "weapon":
                accessory = this.adventurer.getWeapon();
                break;
            case "armor":
                accessory = this.adventurer.getArmor();
                break;
            default:
                throw new NullPointerException("null type in DialogSelectEquipment askSwap");
        }
        if (accessory == null || accessory.equals(defaultWeapon)) {
            return;
        }
        if (Formulas.storageSpaces() <= MainActivity.data.getItems().size() && !MainActivity.data.getItems().contains(accessory)) {
            if (MainActivity.shownDialogFullStorage != null) {
                return;
            }
            MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.no_storage_space_title), getString(R.string.no_storage_space_body_unequip), false);
            MainActivity.shownDialogFullStorage.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownDialogFullStorage = null;
                }
            });
            MainActivity.shownDialogFullStorage.show();
            return;
        }
        if (!defaultWeapon.equals(accessory)) {
            Utils.collectItem(accessory, MainActivity.data.getItems());
        }
        String str2 = this.type;
        str2.hashCode();
        switch (str2) {
            case "accessory":
                this.adventurer.setAccessory(null);
                break;
            case "weapon":
                this.adventurer.setWeapon(defaultWeapon);
                break;
            case "armor":
                this.adventurer.setArmor(null);
                break;
            default:
                throw new NullPointerException("null type in DialogSelectEquipment unequip");
        }
        MainActivity.adventurersFragment.refresh();
        MainActivity.headquartersFragment.refresh();
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
            MainActivity.shownDialogEntityDetail.populateHelp(null, this.type.equals("weapon") ? DialogEntityDetail.formatEquipmentHelp(defaultWeapon, getResources()) : "", true, this.type);
        }
        int iCalculateTotalMaxHp = this.adventurer.calculateTotalMaxHp();
        if (this.adventurer.getCurrentHp() > iCalculateTotalMaxHp) {
            this.adventurer.setCurrentHp(iCalculateTotalMaxHp);
        }
        dismiss();
    }

    private void setGainLoss(LayoutSelectEquipmentBinding layoutSelectEquipmentBinding, Equipment equipment, Equipment equipment2) {
        String str;
        int maxHp = equipment2.getMaxHp() - (equipment == null ? 0 : equipment.getMaxHp());
        String stat = UIUtils.formatStat(R.string.hp_difference, maxHp, getResources());
        String str2 = "";
        if (maxHp > 0) {
            str2 = "" + stat;
            str = "";
        } else {
            str = maxHp < 0 ? "" + stat : "";
        }
        int constitution = equipment2.getConstitution() - (equipment == null ? 0 : equipment.getConstitution());
        String stat2 = UIUtils.formatStat(R.string.constitution_difference, constitution, getResources());
        if (constitution > 0) {
            str2 = str2 + stat2;
        } else if (constitution < 0) {
            str = str + stat2;
        }
        int intelligence = equipment2.getIntelligence() - (equipment == null ? 0 : equipment.getIntelligence());
        String stat3 = UIUtils.formatStat(R.string.intelligence_difference, intelligence, getResources());
        if (intelligence > 0) {
            str2 = str2 + stat3;
        } else if (intelligence < 0) {
            str = str + stat3;
        }
        int dexterity = equipment2.getDexterity() - (equipment == null ? 0 : equipment.getDexterity());
        String stat4 = UIUtils.formatStat(R.string.dexterity_difference, dexterity, getResources());
        if (dexterity > 0) {
            str2 = str2 + stat4;
        } else if (dexterity < 0) {
            str = str + stat4;
        }
        int defense = equipment2.getDefense() - (equipment == null ? 0 : equipment.getDefense());
        String stat5 = UIUtils.formatStat(R.string.defense_difference, defense, getResources());
        if (defense > 0) {
            str2 = str2 + stat5;
        } else if (defense < 0) {
            str = str + stat5;
        }
        int magicDefense = equipment2.getMagicDefense() - (equipment == null ? 0 : equipment.getMagicDefense());
        String stat6 = UIUtils.formatStat(R.string.magic_defence_difference, magicDefense, getResources());
        if (magicDefense > 0) {
            str2 = str2 + stat6;
        } else if (magicDefense < 0) {
            str = str + stat6;
        }
        layoutSelectEquipmentBinding.gain.setText(str2);
        layoutSelectEquipmentBinding.gain.setVisibility(str2.isEmpty() ? 8 : 0);
        layoutSelectEquipmentBinding.loss.setText(str);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSelectEquipment.this.m405x5b8daff7(view);
            }
        });
        this.binding.unequip.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSelectEquipment.this.m406x3eb96338(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSelectEquipment, reason: not valid java name */
    /* synthetic */ void m405x5b8daff7(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSelectEquipment, reason: not valid java name */
    /* synthetic */ void m406x3eb96338(View view) {
        unequip();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogSelectEquipment = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogSelectEquipment = null;
        super.onStop();
    }
}
