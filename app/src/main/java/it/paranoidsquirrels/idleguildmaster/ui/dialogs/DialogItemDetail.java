package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogItemDetailBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Evo23Vial;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Evo23Vial2;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Intercession;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.PotionOfClumsiness;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.PotionOfRejuvenation;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DialogItemDetail extends CustomDialog {
    private DialogItemDetailBinding binding;
    private AlertDialog consumeDialog = null;
    private List<Item> items;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogItemDetailBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        List<Item> list = this.items;
        if (list == null || list.isEmpty()) {
            dismiss();
            return "";
        }
        this.items.size();
        return getString(this.items.get(0).getIdName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogItemDetailBinding dialogItemDetailBindingInflate = DialogItemDetailBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogItemDetailBindingInflate;
        return dialogItemDetailBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        int iIndexOf = MainActivity.data.getItems().indexOf(this.items.get(0));
        Item item = iIndexOf == -1 ? Item.getInstance(this.items.get(0).getTrueClass(), 0) : MainActivity.data.getItems().get(iIndexOf);
        this.binding.item.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), item.getIdImage(), getContext().getTheme()));
        this.binding.item.image.setBackgroundResource(UIUtils.backgroundFromRarity(item.getRarity()));
        this.binding.type.setText(item.printType());
        this.binding.item.stack.setText(String.valueOf(item.getStack()));
        UIUtils.populateMoneyContainer(this.binding.money, item.getPrice(), true);
        this.binding.description.setText(item.getIdDescription());
        this.binding.sell.setVisibility(item.isNotSellable() ? 4 : 0);
        this.binding.messageNotSellable.setVisibility(item.isNotSellable() ? 0 : 4);
        this.binding.effects.setText(getEffect(item));
        this.binding.effects.setVisibility(((item instanceof Equipment) || (item instanceof Food)) ? 0 : 8);
        String source = getSource(item);
        this.binding.source.setText(source);
        this.binding.source.setVisibility(source.isEmpty() ? 8 : 0);
        this.binding.sourceTitle.setVisibility(source.isEmpty() ? 8 : 0);
        Recipes recipesInto = Recipes.into(item);
        this.binding.buildsFromTitle.setVisibility(recipesInto == null ? 8 : 0);
        this.binding.craft.setVisibility(recipesInto == null ? 8 : 0);
        boolean z = item instanceof Consumable;
        this.binding.consume.setVisibility(z ? 0 : 8);
        if (z) {
            this.binding.consume.setImageDrawable(ResourcesCompat.getDrawable(getResources(), ((Consumable) item).printConsumeImage(), getContext().getTheme()));
        }
        populateCraftLayout(this.binding.buildsFrom, recipesInto);
        this.binding.buildsIntoTitle.setVisibility(0);
        if (MainActivity.data.getSeenItems().contains(item.getTrueClass())) {
            this.binding.buildsIntoList.setVisibility(0);
            this.binding.buildsIntoHidden.setVisibility(8);
            this.binding.buildsIntoList.removeAllViews();
            List<Recipes> listFrom = Recipes.from(item);
            if (listFrom.isEmpty()) {
                this.binding.buildsIntoTitle.setVisibility(8);
            }
            for (Recipes recipes : listFrom) {
                LayoutCraftBinding layoutCraftBindingInflate = LayoutCraftBinding.inflate(getLayoutInflater(), this.binding.buildsIntoList, false);
                populateCraftLayout(layoutCraftBindingInflate, recipes);
                this.binding.buildsIntoList.addView(layoutCraftBindingInflate.getRoot());
            }
        } else {
            this.binding.buildsIntoTitle.setVisibility(0);
            this.binding.buildsIntoList.setVisibility(8);
            this.binding.buildsIntoHidden.setVisibility(0);
        }
        this.binding.back.setVisibility(this.items.size() <= 1 ? 8 : 0);
    }

    private String getEffect(Item item) {
        if (item instanceof Equipment) {
            return UIUtils.formatEquipmentDescription((Equipment) item, getResources());
        }
        return item instanceof Food ? String.format(getString(R.string.food_feed_power), Integer.valueOf(((Food) item).getFeedPower())) : "";
    }

    private String getSource(Item item) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it2 = item.getSource().iterator();
        while (it2.hasNext()) {
            sb.append("- ").append(getContext().getString(it2.next().intValue())).append("\n");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    private void populateCraftLayout(LayoutCraftBinding layoutCraftBinding, final Recipes recipes) {
        if (recipes == null) {
            layoutCraftBinding.getRoot().setVisibility(8);
            return;
        }
        layoutCraftBinding.getRoot().setVisibility(0);
        layoutCraftBinding.result.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getResult().getIdImage(), getContext().getTheme()));
        layoutCraftBinding.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getResult().getRarity()));
        layoutCraftBinding.result.stack.setText("1");
        layoutCraftBinding.result.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m342x7ba5487f(recipes, view);
            }
        });
        layoutCraftBinding.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(0).getIdImage(), getContext().getTheme()));
        layoutCraftBinding.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(0).getRarity()));
        layoutCraftBinding.ingredient1.stack.setText(String.valueOf(recipes.getIngredients().get(0).getStack()));
        layoutCraftBinding.ingredient1.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m343xe5d4d09e(recipes, view);
            }
        });
        if (recipes.getIngredients().size() > 1) {
            layoutCraftBinding.plusSign1.setVisibility(0);
            layoutCraftBinding.ingredient2.getRoot().setVisibility(0);
            layoutCraftBinding.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(1).getIdImage(), getContext().getTheme()));
            layoutCraftBinding.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(1).getRarity()));
            layoutCraftBinding.ingredient2.stack.setText(String.valueOf(recipes.getIngredients().get(1).getStack()));
            layoutCraftBinding.ingredient2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogItemDetail.this.m344x500458bd(recipes, view);
                }
            });
        } else {
            layoutCraftBinding.plusSign1.setVisibility(8);
            layoutCraftBinding.ingredient2.getRoot().setVisibility(8);
        }
        if (recipes.getIngredients().size() > 2) {
            layoutCraftBinding.plusSign2.setVisibility(0);
            layoutCraftBinding.ingredient3.getRoot().setVisibility(0);
            layoutCraftBinding.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), recipes.getIngredients().get(2).getIdImage(), getContext().getTheme()));
            layoutCraftBinding.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(2).getRarity()));
            layoutCraftBinding.ingredient3.stack.setText(String.valueOf(recipes.getIngredients().get(2).getStack()));
            layoutCraftBinding.ingredient3.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogItemDetail.this.m345xba33e0dc(recipes, view);
                }
            });
            return;
        }
        layoutCraftBinding.plusSign2.setVisibility(8);
        layoutCraftBinding.ingredient3.getRoot().setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$populateCraftLayout$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m342x7ba5487f(Recipes recipes, View view) {
        openItemDetail(recipes.getResult());
    }

    /* JADX INFO: renamed from: lambda$populateCraftLayout$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m343xe5d4d09e(Recipes recipes, View view) {
        openItemDetail(recipes.getIngredients().get(0));
    }

    /* JADX INFO: renamed from: lambda$populateCraftLayout$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m344x500458bd(Recipes recipes, View view) {
        openItemDetail(recipes.getIngredients().get(1));
    }

    /* JADX INFO: renamed from: lambda$populateCraftLayout$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m345xba33e0dc(Recipes recipes, View view) {
        openItemDetail(recipes.getIngredients().get(2));
    }

    public void openItemDetail(Item item) {
        if (item.equals(this.items.get(0))) {
            return;
        }
        this.items.add(0, item);
        getDialog().setTitle(getString(item.getIdName()));
        initialize(null);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m336x175761e1(view);
            }
        });
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m337x8186ea00(view);
            }
        });
        this.binding.craft.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m338xebb6721f(view);
            }
        });
        this.binding.consume.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m341x2a450a7c(view);
            }
        });
        this.binding.sell.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemDetail.this.m335xba373768(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m336x175761e1(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m337x8186ea00(View view) {
        this.items.remove(0);
        getDialog().setTitle(getString(this.items.get(0).getIdName()));
        initialize(null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m338xebb6721f(View view) {
        if (MainActivity.shownDialogCraft != null) {
            return;
        }
        DialogCraft dialogCraft = new DialogCraft();
        dialogCraft.setRecipe(Recipes.into(this.items.get(0)));
        dialogCraft.show(MainActivity.headquartersFragment.getParentFragmentManager(), "craft");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m341x2a450a7c(View view) {
        int iIndexOf = MainActivity.data.getItems().indexOf(this.items.get(0));
        Item item = iIndexOf == -1 ? Item.getInstance(this.items.get(0).getTrueClass(), 0) : MainActivity.data.getItems().get(iIndexOf);
        if (item instanceof Potion) {
            if (MainActivity.shownDialogConsumePotion != null) {
                return;
            }
            DialogConsumePotion dialogConsumePotion = new DialogConsumePotion();
            dialogConsumePotion.selected = (Potion) item;
            dialogConsumePotion.show(MainActivity.headquartersFragment.getParentFragmentManager(), "consume_potion");
            return;
        }
        if ("Geode".equals(item.getTrueClass())) {
            if (item.getStack() <= 0) {
                return;
            }
            int i = 0;
            for (int i2 = 0; i2 < item.getStack(); i2++) {
                i += Utils.random() < 0.01d ? 100 : 1;
            }
            QuestsManager.increment(QuestsManager.paleontologist, item.getStack());
            Utils.removeItemFromStorage(item);
            item.setStack(0);
            MainActivity.data.setGems(MainActivity.data.getGems() + ((long) i));
            initialize(null);
            if (MainActivity.shownDialogStorage != null) {
                MainActivity.shownDialogStorage.update();
            }
            MainActivity.headquartersFragment.refresh();
            ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshGems();
            if (this.consumeDialog != null) {
                return;
            }
            AlertDialog infoDialog = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.consume_geode_title), String.format(getString(R.string.consume_geode_body), Integer.valueOf(i)), false);
            this.consumeDialog = infoDialog;
            infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogItemDetail.this.m339x55e5fa3e(dialogInterface);
                }
            });
            this.consumeDialog.show();
            return;
        }
        if (item instanceof Egg) {
            if (item.getStack() <= 0) {
                return;
            }
            if (MainActivity.data.getPets().size() >= Formulas.shelterCapacity()) {
                if (this.consumeDialog != null) {
                    return;
                }
                AlertDialog infoDialog2 = UIUtils.getInfoDialog(getContext(), Integer.valueOf(R.string.consume_egg_no_spaces_title), getString(R.string.consume_egg_no_spaces_body), false);
                this.consumeDialog = infoDialog2;
                infoDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        DialogItemDetail.this.m340xc015825d(dialogInterface);
                    }
                });
                this.consumeDialog.show();
                return;
            }
            Pet petHatch = ((Egg) item).hatch();
            MainActivity.data.getPets().add(petHatch);
            Utils.removeItemFromStorage(Item.getInstance(item.getTrueClass(), 1));
            initialize(null);
            if (MainActivity.shownDialogStorage != null) {
                MainActivity.shownDialogStorage.update();
            }
            MainActivity.headquartersFragment.refresh();
            if (!MainActivity.data.isT4Pet() && petHatch.getAbilityNumber() == 4) {
                MainActivity.data.setT4Pet(true);
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_RARE_SPECIMEN);
            }
            DialogPetDetail dialogPetDetail = new DialogPetDetail();
            dialogPetDetail.pet = petHatch;
            dialogPetDetail.show(getParentFragmentManager(), "pet_detail");
            return;
        }
        if (item instanceof Food) {
            if (MainActivity.shownDialogConsumeFood != null) {
                return;
            }
            DialogConsumeFood dialogConsumeFood = new DialogConsumeFood();
            dialogConsumeFood.selected = (Food) item;
            dialogConsumeFood.show(MainActivity.headquartersFragment.getParentFragmentManager(), "consume_food");
            return;
        }
        if (item instanceof Evo23Vial) {
            if (MainActivity.shownDialogConsumeEvo23 == null && item.getStack() > 0) {
                new DialogConsumeEvo23().show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_consume_evo23");
                return;
            }
            return;
        }
        if (item instanceof Evo23Vial2) {
            if (MainActivity.shownDialogConsumeEvo23 == null && item.getStack() > 0) {
                DialogConsumeEvo23 dialogConsumeEvo23 = new DialogConsumeEvo23();
                dialogConsumeEvo23.alternative = true;
                dialogConsumeEvo23.show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_consume_evo23");
                return;
            }
            return;
        }
        if (item instanceof Intercession) {
            if (MainActivity.shownDialogConsumeIntercession == null && item.getStack() > 0) {
                new DialogConsumeIntercession().show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_consume_intercession");
                return;
            }
            return;
        }
        if (item instanceof PotionOfRejuvenation) {
            if (MainActivity.shownDialogConsumePotionOfRejuvenation == null && item.getStack() > 0) {
                new DialogConsumePotionOfRejuvenation().show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_consume_potion_of_rejuvenation");
                return;
            }
            return;
        }
        if ((item instanceof PotionOfClumsiness) && MainActivity.shownDialogConsumePotionOfClumsiness == null && item.getStack() > 0) {
            new DialogConsumePotionOfClumsiness().show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_consume_potion_of_clumsiness");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m339x55e5fa3e(DialogInterface dialogInterface) {
        this.consumeDialog = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m340xc015825d(DialogInterface dialogInterface) {
        this.consumeDialog = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogItemDetail, reason: not valid java name */
    /* synthetic */ void m335xba373768(View view) {
        if (MainActivity.shownDialogSell != null) {
            return;
        }
        DialogSell dialogSell = new DialogSell();
        dialogSell.setItem(this.items.get(0));
        dialogSell.show(MainActivity.headquartersFragment.getParentFragmentManager(), "sell");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogItemDetail = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogItemDetail = null;
        super.onStop();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> list) {
        this.items = list;
    }
}
