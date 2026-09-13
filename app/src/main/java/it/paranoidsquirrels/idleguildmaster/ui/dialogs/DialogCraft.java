package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogCraftBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftBigBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;

/* JADX INFO: loaded from: classes3.dex */
public class DialogCraft extends CustomDialog {
    private DialogCraftBinding binding;
    private Item item;
    private int maxAmount;
    private Recipes recipe;
    private boolean slotsAvailable;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogCraftBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return String.format(getString(R.string.craft_dialog_title), getString(this.recipe.getResult().getIdName()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogCraftBinding dialogCraftBindingInflate = DialogCraftBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogCraftBindingInflate;
        return dialogCraftBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.slotsAvailable = Formulas.workshopQueue() > MainActivity.data.getWorkshopQueue().size() + MainActivity.data.getCompletedWorkshopItems().size();
        this.maxAmount = Utils.maxCraftableAmount(this.recipe);
        this.item = Item.getInstance(this.recipe.getResult().getTrueClass(), MainActivity.data.isSettingCraftMaxAmount() ? this.maxAmount : 1);
        populateCraftLayout(this.binding.buildsFrom, this.recipe);
        this.binding.warningFullQueue.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.warningNoIngredients.setTextColor(getResources().getColor(UIUtils.getFailureColor(), getContext().getTheme()));
        this.binding.craftPanel.setVisibility((this.maxAmount <= 0 || !this.slotsAvailable) ? 4 : 0);
        this.binding.warningNoIngredients.setVisibility(this.maxAmount > 0 ? 8 : 0);
        this.binding.warningFullQueue.setVisibility(this.slotsAvailable ? 8 : 0);
        this.binding.seekBar.setMax(Math.max(0, this.maxAmount - 1));
        changeAmount();
    }

    private void populateCraftLayout(LayoutCraftBigBinding layoutCraftBigBinding, Recipes recipes) {
        if (recipes == null) {
            layoutCraftBigBinding.getRoot().setVisibility(8);
            return;
        }
        layoutCraftBigBinding.getRoot().setVisibility(0);
        layoutCraftBigBinding.result.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getResult().getIdImage(), getContext().getTheme()));
        layoutCraftBigBinding.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getResult().getRarity()));
        layoutCraftBigBinding.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(0).getIdImage(), getContext().getTheme()));
        layoutCraftBigBinding.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(0).getRarity()));
        layoutCraftBigBinding.ingredient1.stack.setTextColor(getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(0)) ? R.color.dim_white : UIUtils.getFailureColor(), getContext().getTheme()));
        if (recipes.getIngredients().size() > 1) {
            layoutCraftBigBinding.plusSign1.setVisibility(0);
            layoutCraftBigBinding.ingredient2.getRoot().setVisibility(0);
            layoutCraftBigBinding.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(1).getIdImage(), getContext().getTheme()));
            layoutCraftBigBinding.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(1).getRarity()));
            layoutCraftBigBinding.ingredient2.stack.setTextColor(getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(1)) ? R.color.dim_white : UIUtils.getFailureColor(), getContext().getTheme()));
        } else {
            layoutCraftBigBinding.plusSign1.setVisibility(8);
            layoutCraftBigBinding.ingredient2.getRoot().setVisibility(8);
        }
        if (recipes.getIngredients().size() > 2) {
            layoutCraftBigBinding.plusSign2.setVisibility(0);
            layoutCraftBigBinding.ingredient3.getRoot().setVisibility(0);
            layoutCraftBigBinding.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(2).getIdImage(), getContext().getTheme()));
            layoutCraftBigBinding.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(2).getRarity()));
            layoutCraftBigBinding.ingredient3.stack.setTextColor(getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(2)) ? R.color.dim_white : UIUtils.getFailureColor(), getContext().getTheme()));
            return;
        }
        layoutCraftBigBinding.plusSign2.setVisibility(8);
        layoutCraftBigBinding.ingredient3.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeAmount() {
        this.binding.seekBar.setProgress(this.item.getStack() - 1);
        this.binding.time.setText(UIUtils.formatSeconds(Math.round(this.item.getSecondsToCraft())));
        this.binding.number.setText(String.valueOf(this.item.getStack()));
        this.binding.buildsFrom.result.stack.setText(String.valueOf(this.item.getStack()));
        this.binding.buildsFrom.ingredient1.stack.setText(String.valueOf(this.recipe.getIngredients().get(0).getStack() * this.item.getStack()));
        if (this.recipe.getIngredients().size() > 1) {
            this.binding.buildsFrom.ingredient2.stack.setText(String.valueOf(this.recipe.getIngredients().get(1).getStack() * this.item.getStack()));
        }
        if (this.recipe.getIngredients().size() > 2) {
            this.binding.buildsFrom.ingredient3.stack.setText(String.valueOf(this.recipe.getIngredients().get(2).getStack() * this.item.getStack()));
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.craft.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCraft.this.m258xa002f55f(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCraft.this.m259x5a7895e0(view);
            }
        });
        this.binding.buttonPlus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCraft.this.m260x14ee3661(view);
            }
        });
        this.binding.buttonMinus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCraft.this.m261xcf63d6e2(view);
            }
        });
        this.binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    DialogCraft.this.item.setStack(i + 1);
                    DialogCraft.this.changeAmount();
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCraft, reason: not valid java name */
    /* synthetic */ void m258xa002f55f(View view) {
        if (this.maxAmount <= 0 || !this.slotsAvailable) {
            return;
        }
        ItemAction itemAction = new ItemAction(Item.getInstance(this.recipe.getResult().getTrueClass(), this.item.getStack()));
        MainActivity.data.getWorkshopQueue().add(itemAction);
        for (Item item : this.recipe.getIngredients()) {
            Utils.removeItemFromStorage(Item.getInstance(item.getTrueClass(), item.getStack() * this.item.getStack()));
        }
        if (MainActivity.shownDialogStorage != null) {
            MainActivity.shownDialogStorage.update();
        }
        if (MainActivity.shownDialogRecipes != null) {
            MainActivity.shownDialogRecipes.update();
        }
        if (MainActivity.shownDialogWorkshop != null) {
            MainActivity.shownDialogWorkshop.addProject(itemAction);
        }
        MainActivity.headquartersFragment.refresh();
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCraft, reason: not valid java name */
    /* synthetic */ void m259x5a7895e0(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCraft, reason: not valid java name */
    /* synthetic */ void m260x14ee3661(View view) {
        int stack = this.item.getStack();
        int i = this.maxAmount;
        if (stack >= i) {
            this.item.setStack(i);
            return;
        }
        Item item = this.item;
        item.setStack(item.getStack() + 1);
        changeAmount();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogCraft, reason: not valid java name */
    /* synthetic */ void m261xcf63d6e2(View view) {
        if (this.item.getStack() <= 1) {
            this.item.setStack(1);
            return;
        }
        Item item = this.item;
        item.setStack(item.getStack() - 1);
        changeAmount();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogCraft = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogCraft = null;
        super.onStop();
    }

    public Recipes getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipes recipes) {
        this.recipe = recipes;
    }
}
