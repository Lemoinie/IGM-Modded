package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRecipesBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes3.dex */
public class DialogRecipes extends CustomDialog {
    private BaseAdapter adapter;
    public DialogRecipesBinding binding;
    private List<Recipes> recipes;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogRecipesBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.headquarters_workshop_recipes_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogRecipesBinding dialogRecipesBindingInflate = DialogRecipesBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogRecipesBindingInflate;
        return dialogRecipesBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.radiobuttonType.setChecked(true);
        this.binding.radiobuttonAll.setChecked(true);
        this.binding.hideInsufficientIngredients.setChecked(true);
        configureVisibility();
    }

    private void configureOrder() {
        int checkedRadioButtonId = this.binding.radioGroupOrderBy.getCheckedRadioButtonId();
        if (checkedRadioButtonId == this.binding.radiobuttonType.getId()) {
            this.recipes.sort(Utils.recipesByTypeComparator);
        } else if (checkedRadioButtonId == this.binding.radiobuttonAlphabetical.getId()) {
            this.recipes.sort(Comparator.comparing(new Function() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DialogRecipes.this.m392xe6114c0c((Recipes) obj);
                }
            }));
        } else if (checkedRadioButtonId == this.binding.radiobuttonCraftableAmount.getId()) {
            this.recipes.sort(Comparator.comparingInt(new ToIntFunction() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda3
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return DialogRecipes.lambda$configureOrder$1((Recipes) obj);
                }
            }));
        }
        this.adapter.notifyDataSetChanged();
        this.binding.noRecipesTooltip.setVisibility(this.recipes.isEmpty() ? 0 : 8);
        this.binding.recipeList.setVisibility(this.recipes.isEmpty() ? 4 : 0);
    }

    /* JADX INFO: renamed from: lambda$configureOrder$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecipes, reason: not valid java name */
    /* synthetic */ String m392xe6114c0c(Recipes recipes) {
        return getString(recipes.getResult().getIdName());
    }

    static /* synthetic */ int lambda$configureOrder$1(Recipes recipes) {
        return -Utils.maxCraftableAmount(recipes);
    }

    private void configureVisibility() {
        this.recipes = new ArrayList(MainActivity.data.getKnownRecipes());
        int checkedRadioButtonId = this.binding.radioGroupVisibility.getCheckedRadioButtonId();
        if (checkedRadioButtonId == this.binding.radiobuttonMaterials.getId()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$configureVisibility$2((Recipes) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonWeapons.getId()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda6
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$configureVisibility$3((Recipes) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonArmors.getId()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda7
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$configureVisibility$4((Recipes) obj);
                }
            });
        } else if (checkedRadioButtonId == this.binding.radiobuttonAccessories.getId()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda8
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$configureVisibility$5((Recipes) obj);
                }
            });
        }
        if (this.binding.hideInsufficientIngredients.isChecked()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda9
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$configureVisibility$6((Recipes) obj);
                }
            });
        }
        this.adapter = UIUtils.getRecipesListAdapter(this.recipes);
        this.binding.recipeList.setAdapter((ListAdapter) this.adapter);
        configureOrder();
    }

    static /* synthetic */ boolean lambda$configureVisibility$2(Recipes recipes) {
        return recipes.getResult() instanceof Equipment;
    }

    static /* synthetic */ boolean lambda$configureVisibility$3(Recipes recipes) {
        return !(recipes.getResult() instanceof Weapon);
    }

    static /* synthetic */ boolean lambda$configureVisibility$4(Recipes recipes) {
        return !(recipes.getResult() instanceof Armor);
    }

    static /* synthetic */ boolean lambda$configureVisibility$5(Recipes recipes) {
        return !(recipes.getResult() instanceof Accessory);
    }

    static /* synthetic */ boolean lambda$configureVisibility$6(Recipes recipes) {
        return Utils.maxCraftableAmount(recipes) < 1;
    }

    static /* synthetic */ boolean lambda$update$7(Recipes recipes) {
        return Utils.maxCraftableAmount(recipes) < 1;
    }

    public void update() {
        if (this.binding.hideInsufficientIngredients.isChecked()) {
            this.recipes.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DialogRecipes.lambda$update$7((Recipes) obj);
                }
            });
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.radioGroupOrderBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda10
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogRecipes.this.m390x4b033e2c(radioGroup, i);
            }
        });
        this.binding.radioGroupVisibility.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda11
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogRecipes.this.m391x3e92c26d(radioGroup, i);
            }
        });
        this.binding.hideInsufficientIngredients.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DialogRecipes.this.m388x49bd9d01(compoundButton, z);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRecipes.this.m389x3d4d2142(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecipes, reason: not valid java name */
    /* synthetic */ void m390x4b033e2c(RadioGroup radioGroup, int i) {
        configureOrder();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecipes, reason: not valid java name */
    /* synthetic */ void m391x3e92c26d(RadioGroup radioGroup, int i) {
        configureVisibility();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecipes, reason: not valid java name */
    /* synthetic */ void m388x49bd9d01(CompoundButton compoundButton, boolean z) {
        configureVisibility();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRecipes, reason: not valid java name */
    /* synthetic */ void m389x3d4d2142(View view) {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogRecipes = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogRecipes = null;
        super.onStop();
    }
}
