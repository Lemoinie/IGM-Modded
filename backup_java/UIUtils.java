package it.paranoidsquirrels.idleguildmaster;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutBestiaryElementBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftNamedBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutMoneyBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDireDescent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent;
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam;
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment;
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class UIUtils {
    private static DecimalFormat df1 = new DecimalFormat("0.0");
    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public static void populateMoneyContainer(LayoutMoneyBinding layoutMoneyBinding, long j, boolean z) {
        long j2 = j % 100;
        long j3 = ((j % WorkRequest.MIN_BACKOFF_MILLIS) - j2) / 100;
        long j4 = (((j % 1000000) - j3) - j2) / WorkRequest.MIN_BACKOFF_MILLIS;
        long j5 = (((j - j4) - j3) - j2) / 1000000;
        layoutMoneyBinding.amountCopper.setText(String.valueOf(j2));
        layoutMoneyBinding.amountSilver.setText(String.valueOf(j3));
        layoutMoneyBinding.amountGold.setText(String.valueOf(j4));
        layoutMoneyBinding.amountPlatinum.setText(String.valueOf(j5));
        boolean z2 = j3 == 0 && j4 == 0 && j5 == 0;
        boolean z3 = j4 == 0 && j5 == 0;
        boolean z4 = j5 == 0;
        boolean z5 = z && j >= WorkRequest.MIN_BACKOFF_MILLIS;
        boolean z6 = z && j >= 1000000;
        layoutMoneyBinding.amountCopper.setVisibility(z5 ? 8 : 0);
        layoutMoneyBinding.imageCopper.setVisibility(z5 ? 8 : 0);
        layoutMoneyBinding.amountSilver.setVisibility((z2 || z6) ? 8 : 0);
        layoutMoneyBinding.imageSilver.setVisibility((z2 || z6) ? 8 : 0);
        layoutMoneyBinding.amountGold.setVisibility(z3 ? 8 : 0);
        layoutMoneyBinding.imageGold.setVisibility(z3 ? 8 : 0);
        layoutMoneyBinding.amountPlatinum.setVisibility(z4 ? 8 : 0);
        layoutMoneyBinding.imagePlatinum.setVisibility(z4 ? 8 : 0);
    }

    public static void changeMoneyContainerColor(LayoutMoneyBinding layoutMoneyBinding, boolean z) {
        int color = layoutMoneyBinding.getRoot().getContext().getColor(z ? R.color.dim_white : getFailureColor());
        layoutMoneyBinding.amountCopper.setTextColor(color);
        layoutMoneyBinding.amountSilver.setTextColor(color);
        layoutMoneyBinding.amountGold.setTextColor(color);
        layoutMoneyBinding.amountPlatinum.setTextColor(color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.AlertDialog$Builder] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.text.Spanned] */
    public static AlertDialog getInfoDialog(final Context context, Integer num, String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialog);
        if (num != null) {
            builder.setTitle(num.intValue());
        }
        if (z) {
            str = Html.fromHtml(str, 63).toString();
        }
        builder.setMessage(str);
        builder.setPositiveButton(R.string.close, null);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                UIUtils.lambda$getInfoDialog$0(alertDialogCreate, context, dialogInterface);
            }
        });
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.dialog_border);
        alertDialogCreate.getWindow().setFlags(8, 8);
        return alertDialogCreate;
    }

    static /* synthetic */ void lambda$getInfoDialog$0(AlertDialog alertDialog, Context context, DialogInterface dialogInterface) {
        alertDialog.getButton(-1).setTextColor(context.getResources().getColor(R.color.dim_white, context.getTheme()));
        hideUI(alertDialog.getWindow());
        alertDialog.getWindow().clearFlags(8);
    }

    public static AlertDialog getActionDialog(final Context context, Integer num, String str, int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialog);
        if (num != null) {
            builder.setTitle(num.intValue());
        }
        builder.setMessage(str);
        builder.setNegativeButton(context.getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(context.getString(i), onClickListener);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                UIUtils.lambda$getActionDialog$1(alertDialogCreate, context, dialogInterface);
            }
        });
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.dialog_border);
        alertDialogCreate.getWindow().setFlags(8, 8);
        return alertDialogCreate;
    }

    static /* synthetic */ void lambda$getActionDialog$1(AlertDialog alertDialog, Context context, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(context.getResources().getColor(R.color.dim_white, context.getTheme()));
        alertDialog.getButton(-1).setTextColor(context.getResources().getColor(R.color.brass_border, context.getTheme()));
        hideUI(alertDialog.getWindow());
        alertDialog.getWindow().clearFlags(8);
    }

    public static AlertDialog askConfirmUpgrade(Context context, int i, DialogInterface.OnClickListener onClickListener) {
        return getActionDialog(context, Integer.valueOf(R.string.confirm), String.format(context.getString(R.string.confirm_upgrade_body), context.getString(i)), R.string.yes, onClickListener);
    }

    public static void getAdventurerDetailDialog(FragmentManager fragmentManager, Entity entity, boolean z, boolean z2) {
        if (z2 || MainActivity.shownDialogEntityDetail == null) {
            if ((!z2 || MainActivity.shownDialogAdventurerDetailPromotion == null) && entity != null) {
                DialogEntityDetail dialogEntityDetail = new DialogEntityDetail();
                dialogEntityDetail.setEntity(entity);
                dialogEntityDetail.allowEquipmentChange = z;
                dialogEntityDetail.promotion = z2;
                dialogEntityDetail.show(fragmentManager, "dialog_entity_detail");
            }
        }
    }

    public static void getEnemyDetailDialog(FragmentManager fragmentManager, Entity entity) {
        getAdventurerDetailDialog(fragmentManager, entity, false, false);
    }

    public static int getFightRarity(List<Enemy> list) {
        int rarity = 1;
        for (Enemy enemy : list) {
            if (enemy.getRarity() > rarity) {
                rarity = enemy.getRarity();
            }
        }
        if (rarity == 1) {
            return R.string.rarity_common;
        }
        if (rarity == 2) {
            return R.string.rarity_uncommon;
        }
        if (rarity == 3) {
            return R.string.rarity_rare;
        }
        if (rarity == 4) {
            return R.string.rarity_epic;
        }
        if (rarity == 5) {
            return R.string.rarity_legendary;
        }
        return R.string.rarity_common;
    }

    public static int backgroundFromRarity(int i) {
        return R.drawable.object_border_dim_white;
    }

    public static String traitsToShortString(Adventurer adventurer, Resources resources) {
        Trait traitCommon = adventurer.getTraitCommon();
        Trait traitRare = adventurer.getTraitRare();
        if (traitCommon == null && traitRare == null) {
            return "";
        }
        if (traitCommon != null && traitRare != null) {
            return resources.getString(traitCommon.nameRes) + ", " + resources.getString(traitRare.nameRes);
        }
        if (traitCommon != null) {
            return resources.getString(traitCommon.nameRes);
        }
        return resources.getString(traitRare.nameRes);
    }

    public static String traitsToLongString(Adventurer adventurer, Resources resources) {
        Trait traitCommon = adventurer.getTraitCommon();
        Trait traitRare = adventurer.getTraitRare();
        if (traitCommon == null && traitRare == null) {
            return "";
        }
        if (traitCommon != null && traitRare != null) {
            return String.format(resources.getString(R.string.traits_formatted_2), resources.getString(traitCommon.nameRes), resources.getString(traitCommon.description), resources.getString(traitRare.nameRes), resources.getString(traitRare.description));
        }
        if (traitCommon != null) {
            return String.format(resources.getString(R.string.traits_formatted_1), resources.getString(traitCommon.nameRes), resources.getString(traitCommon.description));
        }
        return String.format(resources.getString(R.string.traits_formatted_1), resources.getString(traitRare.nameRes), resources.getString(traitRare.description));
    }

    public static void hideUI(Window window) {
        window.setNavigationBarColor(0);
        window.getDecorView().setSystemUiVisibility(5638);
    }

    public static void openItemDetail(Item item) {
        if (MainActivity.shownDialogItemDetail != null) {
            return;
        }
        try {
            FragmentManager parentFragmentManager = MainActivity.headquartersFragment.getParentFragmentManager();
            DialogItemDetail dialogItemDetail = new DialogItemDetail();
            dialogItemDetail.setItems(new ArrayList(Collections.singletonList(item)));
            dialogItemDetail.show(parentFragmentManager, "item_detail");
        } catch (Exception unused) {
        }
    }

    public static String formatSeconds(long j) {
        int i = (int) (j / 3600);
        int i2 = (int) ((j / 60) % 60);
        int i3 = (int) (j % 60);
        if (i == 0) {
            return String.format("%d:%s", Integer.valueOf(i2), i3 > 9 ? Integer.valueOf(i3) : "0" + i3);
        }
        return String.format("%d:%s:%s", Integer.valueOf(i), i2 > 9 ? Integer.valueOf(i2) : "0" + i2, i3 > 9 ? Integer.valueOf(i3) : "0" + i3);
    }

    public static String formatDouble1Decimal(double d) {
        return df1.format(d);
    }

    public static String formatDouble2Decimals(double d) {
        return df2.format(d);
    }

    public static String formatEquipmentDescription(Equipment equipment, Resources resources) {
        String str = formatStat(R.string.hp_difference, equipment.getMaxHp(), resources) + formatStat(R.string.constitution_difference, equipment.getConstitution(), resources) + formatStat(R.string.intelligence_difference, equipment.getIntelligence(), resources) + formatStat(R.string.dexterity_difference, equipment.getDexterity(), resources) + formatStat(R.string.defense_difference, equipment.getDefense(), resources) + formatStat(R.string.magic_defence_difference, equipment.getMagicDefense(), resources);
        return str + ((str.isEmpty() || equipment.getIdEffect() == 0) ? "" : "\n") + (equipment.getIdEffect() != 0 ? resources.getString(equipment.getIdEffect()) : "");
    }

    public static String formatStat(int i, int i2, Resources resources) {
        if (i2 == 0) {
            return "";
        }
        return String.format(resources.getString(i), i2 > 0 ? "+" : "", Integer.valueOf(i2)) + " ";
    }

    public static String darknessDescription(int i, Resources resources) {
        if (i == 0) {
            return String.format(resources.getString(R.string.log_darkness_0), Integer.valueOf(i));
        }
        if (i <= 25) {
            return String.format(resources.getString(R.string.log_darkness_1_25), Integer.valueOf(i));
        }
        if (i <= 50) {
            return String.format(resources.getString(R.string.log_darkness_26_50), Integer.valueOf(i));
        }
        if (i <= 75) {
            return String.format(resources.getString(R.string.log_darkness_51_75), Integer.valueOf(i));
        }
        return String.format(resources.getString(R.string.log_darkness_76_100), Integer.valueOf(i));
    }

    public static void vibrate(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(50L, -1));
        } else {
            vibrator.vibrate(50L);
        }
    }

    public static void unlockArea(Area area) {
        area.setUnlocked(true);
        area.setTriesAvailable(true);
        if (area instanceof TheDesert) {
            unlockMessage(KingMessage.MESSAGE_2);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_DESERT);
        } else if (area instanceof EternalBattlefield) {
            unlockMessage(KingMessage.MESSAGE_3);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ETERNAL_BATTLEFIELD);
        } else if (area instanceof TheGoldenCity) {
            unlockMessage(KingMessage.MESSAGE_4);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_GOLDEN_CITY);
        } else if (area instanceof BlackwaterPort) {
            unlockMessage(KingMessage.MESSAGE_5);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_BLACKWATER_PORT);
        } else if (area instanceof FrostbitePeaks) {
            unlockMessage(KingMessage.MESSAGE_6);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FROSTBITE_PEAKS);
        } else if (area instanceof ObsidianMines) {
            unlockMessage(KingMessage.MESSAGE_7);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_OBSIDIAN_MINES);
        } else if (area instanceof TheDreadfulAscent) {
            unlockMessage(KingMessage.MESSAGE_8);
        } else if (area instanceof TheSouthernGrove) {
            unlockMessage(KingMessage.MESSAGE_9);
            unlockMessage(KingMessage.MESSAGE_10);
            unlockMessage(KingMessage.MESSAGE_11);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_SOUTHERN_GROVE);
        } else if (area instanceof BarrenWastelands) {
            unlockMessage(KingMessage.MESSAGE_12);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_BARREN_WASTELANDS);
        } else if (area instanceof HiddenCityOfLarox) {
            unlockMessage(KingMessage.MESSAGE_13);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_HIDDEN_CITY);
        } else if (area instanceof LostLands) {
            unlockMessage(KingMessage.MESSAGE_14);
            AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_LOST_LANDS);
        } else if (area instanceof TheDireDescent) {
            unlockMessage(KingMessage.MESSAGE_15);
        } else if (area instanceof SleepingPlanet) {
            unlockMessage(KingMessage.MESSAGE_16);
            unlockMessage(KingMessage.MESSAGE_17);
        }
        if (MainActivity.dungeonsFragment != null && Utils.isMainLooper()) {
            MainActivity.dungeonsFragment.refreshDungeonVisibility();
            MainActivity mainActivity = (MainActivity) MainActivity.dungeonsFragment.getActivity();
            mainActivity.refreshKingMessages();
            mainActivity.refreshRaidsFragmentVisibility();
        }
        if (MainActivity.raidsFragment == null || !Utils.isMainLooper()) {
            return;
        }
        MainActivity.raidsFragment.refreshRaidVisibility();
    }

    private static void unlockMessage(KingMessage kingMessage) {
        MainActivity.data.getMessagesToShow().add(kingMessage);
        MainActivity.data.getMessagesGotten().add(kingMessage);
    }

    public static void clickArea(final Fragment fragment, final Area area) {
        if (area.getAdventurersExploringIds().isEmpty()) {
            if (area.getAreaType() == 0 || area.getTriesAvailable()) {
                if (MainActivity.shownDialogSendTeam != null) {
                    return;
                }
                MainActivity.shownDialogSendTeam = new DialogSendTeam();
                MainActivity.shownDialogSendTeam.area = area;
                MainActivity.shownDialogSendTeam.show(fragment.getParentFragmentManager(), "dialog_send_team");
                return;
            }
            if (MainActivity.shownDialogRefillRaidTry != null) {
                return;
            }
            final int iCostToRefresh = area.costToRefresh();
            MainActivity.shownDialogRefillRaidTry = new DialogRefillRaidTry();
            MainActivity.shownDialogRefillRaidTry.title = fragment.getString(R.string.gems_replenish_raid_tries_title);
            MainActivity.shownDialogRefillRaidTry.description = String.format(fragment.getString(R.string.gems_replenish_raid_tries_body), Integer.valueOf(iCostToRefresh));
            MainActivity.shownDialogRefillRaidTry.cost = iCostToRefresh;
            MainActivity.shownDialogRefillRaidTry.callback = new BooleanSupplier() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$$ExternalSyntheticLambda1
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    return UIUtils.lambda$clickArea$2(iCostToRefresh, area, fragment);
                }
            };
            MainActivity.shownDialogRefillRaidTry.show(fragment.getParentFragmentManager(), "dialog_spend_gems");
            return;
        }
        if (area.terminationRequested || MainActivity.shownDialogDungeonDetail != null) {
            return;
        }
        MainActivity.shownDialogDungeonDetail = new DialogDungeonDetail();
        MainActivity.shownDialogDungeonDetail.area = area;
        MainActivity.shownDialogDungeonDetail.show(fragment.getParentFragmentManager(), "dialog_dungeon_detail");
    }

    static /* synthetic */ boolean lambda$clickArea$2(int i, Area area, Fragment fragment) {
        long gems = MainActivity.data.getGems();
        long j = i;
        if (gems < j) {
            MainActivity.shownDialogRefillRaidTry.displayError();
            return false;
        }
        area.setTriesAvailable(true);
        MainActivity.data.setGems(gems - j);
        ((MainActivity) fragment.getActivity()).refreshGems();
        area.refreshTries();
        return true;
    }

    public static int getFailureColor() {
        return MainActivity.data.isSettingColorblindMode() ? R.color.failure_colorblind : R.color.failure;
    }

    public static void openDoctrineDialog(Adventurer adventurer, Doctrine doctrine) {
        if (MainActivity.shownDialogDoctrine != null) {
            return;
        }
        MainActivity.shownDialogDoctrine = new DialogDoctrine();
        MainActivity.shownDialogDoctrine.setDoctrine(doctrine == null ? adventurer.getDoctrine() : doctrine);
        MainActivity.shownDialogDoctrine.setAdventurer(adventurer);
        MainActivity.shownDialogDoctrine.setReadOnly(doctrine != null);
        MainActivity.shownDialogDoctrine.show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_doctrine");
    }

    public static void applyAscendedPalette(LayoutAdventurerBinding layoutAdventurerBinding) {
        Context context = layoutAdventurerBinding.getRoot().getContext();
        layoutAdventurerBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended);
        layoutAdventurerBinding.weapon.setBackgroundResource(R.drawable.object_border_ascended);
        layoutAdventurerBinding.armor.setBackgroundResource(R.drawable.object_border_ascended);
        layoutAdventurerBinding.accessory.setBackgroundResource(R.drawable.object_border_ascended);
        layoutAdventurerBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended);
        layoutAdventurerBinding.name.setTextColor(context.getResources().getColor(R.color.ascended_unit, context.getTheme()));
    }

    public static ScreenSlidePagerAdapter getPagerAdapter(FragmentActivity fragmentActivity) {
        return new ScreenSlidePagerAdapter(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            if (i == 1) {
                return new AdventurersFragment();
            }
            if (i == 2) {
                return new DungeonsFragment();
            }
            if (i == 3) {
                return new RaidsFragment();
            }
            return new HeadquartersFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RaidsFragment.VISIBLE ? 4 : 3;
        }
    }

    public static ArrayAdapter<Item> getItemsGridAdapter(Context context, List<Item> list) {
        return new GridAdapter(context, R.layout.layout_item_big_grid, list);
    }

    private static class GridAdapter extends ArrayAdapter<Item> {
        List<Item> items;
        int resource;

        public GridAdapter(Context context, int i, List<Item> list) {
            super(context, i);
            this.resource = i;
            this.items = list;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.stack);
            Item item = this.items.get(i);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), item.getIdImage(), getContext().getTheme()));
            imageView.setBackgroundResource(UIUtils.backgroundFromRarity(item.getRarity()));
            textView.setText(String.valueOf(item.getStack()));
            return view;
        }
    }

    public static ArrayAdapter<EnemyCounter> getEnemyReportGridAdapter(Context context, List<EnemyCounter> list) {
        return new GridAdapterEnemies(context, R.layout.layout_item_big_grid, list);
    }

    private static class GridAdapterEnemies extends ArrayAdapter<EnemyCounter> {
        List<EnemyCounter> enemies;
        int resource;

        public GridAdapterEnemies(Context context, int i, List<EnemyCounter> list) {
            super(context, i);
            this.resource = i;
            this.enemies = list;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.enemies.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.stack);
            EnemyCounter enemyCounter = this.enemies.get(i);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), Enemy.getInstance(enemyCounter.getEnemy()).getImageId(), getContext().getTheme()));
            imageView.setBackgroundResource(R.drawable.object_border_dim_white);
            textView.setText(String.valueOf(enemyCounter.getTimesSlain()));
            return view;
        }
    }

    public static BaseAdapter getRecipesListAdapter(List<Recipes> list) {
        return new RecipesAdapter(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class RecipesAdapter extends BaseAdapter {
        List<Recipes> recipes;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public RecipesAdapter(List<Recipes> list) {
            this.recipes = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.recipes.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutCraftNamedViewHolder layoutCraftNamedViewHolder;
            if (view == null) {
                layoutCraftNamedViewHolder = new LayoutCraftNamedViewHolder(LayoutCraftNamedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
            } else {
                layoutCraftNamedViewHolder = (LayoutCraftNamedViewHolder) view.getTag();
            }
            LayoutCraftNamedBinding layoutCraftNamedBinding = layoutCraftNamedViewHolder.binding;
            Context context = layoutCraftNamedBinding.getRoot().getContext();
            final Recipes recipes = get(i);
            layoutCraftNamedBinding.name.setText(recipes.getResult().getIdName());
            layoutCraftNamedBinding.result.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), recipes.getResult().getIdImage(), context.getTheme()));
            layoutCraftNamedBinding.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getResult().getRarity()));
            layoutCraftNamedBinding.result.stack.setText(String.valueOf(recipes.getResult().getStack()));
            layoutCraftNamedBinding.result.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$RecipesAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UIUtils.openItemDetail(recipes.getResult());
                }
            });
            layoutCraftNamedBinding.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), recipes.getIngredients().get(0).getIdImage(), context.getTheme()));
            layoutCraftNamedBinding.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(0).getRarity()));
            layoutCraftNamedBinding.ingredient1.stack.setText(String.valueOf(recipes.getIngredients().get(0).getStack()));
            layoutCraftNamedBinding.ingredient1.stack.setTextColor(context.getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(0)) ? R.color.dim_white : UIUtils.getFailureColor(), context.getTheme()));
            layoutCraftNamedBinding.ingredient1.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$RecipesAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UIUtils.openItemDetail(recipes.getIngredients().get(0));
                }
            });
            if (recipes.getIngredients().size() > 1) {
                layoutCraftNamedBinding.plusSign1.setVisibility(0);
                layoutCraftNamedBinding.ingredient2.getRoot().setVisibility(0);
                layoutCraftNamedBinding.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), recipes.getIngredients().get(1).getIdImage(), context.getTheme()));
                layoutCraftNamedBinding.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(1).getRarity()));
                layoutCraftNamedBinding.ingredient2.stack.setText(String.valueOf(recipes.getIngredients().get(1).getStack()));
                layoutCraftNamedBinding.ingredient2.stack.setTextColor(context.getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(1)) ? R.color.dim_white : UIUtils.getFailureColor(), context.getTheme()));
                layoutCraftNamedBinding.ingredient2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$RecipesAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UIUtils.openItemDetail(recipes.getIngredients().get(1));
                    }
                });
            } else {
                layoutCraftNamedBinding.plusSign1.setVisibility(8);
                layoutCraftNamedBinding.ingredient2.getRoot().setVisibility(8);
            }
            if (recipes.getIngredients().size() > 2) {
                layoutCraftNamedBinding.plusSign2.setVisibility(0);
                layoutCraftNamedBinding.ingredient3.getRoot().setVisibility(0);
                layoutCraftNamedBinding.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), recipes.getIngredients().get(2).getIdImage(), context.getTheme()));
                layoutCraftNamedBinding.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(recipes.getIngredients().get(2).getRarity()));
                layoutCraftNamedBinding.ingredient3.stack.setText(String.valueOf(recipes.getIngredients().get(2).getStack()));
                layoutCraftNamedBinding.ingredient3.stack.setTextColor(context.getResources().getColor(Utils.gotEnoughItem(recipes.getIngredients().get(2)) ? R.color.dim_white : UIUtils.getFailureColor(), context.getTheme()));
                layoutCraftNamedBinding.ingredient3.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$RecipesAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UIUtils.openItemDetail(recipes.getIngredients().get(2));
                    }
                });
            } else {
                layoutCraftNamedBinding.plusSign2.setVisibility(8);
                layoutCraftNamedBinding.ingredient3.getRoot().setVisibility(8);
            }
            return layoutCraftNamedViewHolder.view;
        }

        private Recipes get(int i) {
            int i2 = 0;
            for (Recipes recipes : this.recipes) {
                if (i == i2) {
                    return recipes;
                }
                i2++;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + i + " of a Set with size " + this.recipes.size());
        }

        private static class LayoutCraftNamedViewHolder {
            private LayoutCraftNamedBinding binding;
            private View view;

            LayoutCraftNamedViewHolder(LayoutCraftNamedBinding layoutCraftNamedBinding) {
                ConstraintLayout root = layoutCraftNamedBinding.getRoot();
                this.view = root;
                this.binding = layoutCraftNamedBinding;
                root.setTag(this);
            }
        }
    }

    public static BaseAdapter getBestiaryListAdapter(List<Area> list) {
        return new BestiaryAdapter(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class BestiaryAdapter extends BaseAdapter {
        List<Area> areas;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public BestiaryAdapter(List<Area> list) {
            this.areas = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.areas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutBestiaryElementViewHolder layoutBestiaryElementViewHolder;
            if (view == null) {
                layoutBestiaryElementViewHolder = new LayoutBestiaryElementViewHolder(LayoutBestiaryElementBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
            } else {
                layoutBestiaryElementViewHolder = (LayoutBestiaryElementViewHolder) view.getTag();
            }
            LayoutBestiaryElementBinding layoutBestiaryElementBinding = layoutBestiaryElementViewHolder.binding;
            Context context = layoutBestiaryElementBinding.getRoot().getContext();
            Area area = get(i);
            final List<Enemy> listListEnemies = area.listEnemies();
            layoutBestiaryElementBinding.areaName.setText(context.getString(area.getName()));
            layoutBestiaryElementBinding.enemiesGrid.setAdapter((ListAdapter) UIUtils.getEnemiesGridAdapter(context, listListEnemies));
            layoutBestiaryElementBinding.enemiesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$BestiaryAdapter$$ExternalSyntheticLambda0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                    UIUtils.BestiaryAdapter.lambda$getView$0(listListEnemies, adapterView, view2, i2, j);
                }
            });
            return layoutBestiaryElementViewHolder.view;
        }

        static /* synthetic */ void lambda$getView$0(List list, AdapterView adapterView, View view, int i, long j) {
            Enemy enemy = (Enemy) list.get(i);
            if (MainActivity.data.getSeenEnemies().contains(enemy.getTrueClass())) {
                UIUtils.getEnemyDetailDialog(MainActivity.headquartersFragment.getParentFragmentManager(), enemy);
            }
        }

        private Area get(int i) {
            int i2 = 0;
            for (Area area : this.areas) {
                if (i == i2) {
                    return area;
                }
                i2++;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + i + " of a Set with size " + this.areas.size());
        }

        private static class LayoutBestiaryElementViewHolder {
            private LayoutBestiaryElementBinding binding;
            private View view;

            LayoutBestiaryElementViewHolder(LayoutBestiaryElementBinding layoutBestiaryElementBinding) {
                ConstraintLayout root = layoutBestiaryElementBinding.getRoot();
                this.view = root;
                this.binding = layoutBestiaryElementBinding;
                root.setTag(this);
            }
        }
    }

    public static ArrayAdapter<Enemy> getEnemiesGridAdapter(Context context, List<Enemy> list) {
        return new BestiaryGridAdapter(context, R.layout.layout_bestiary_enemy, list);
    }

    private static class BestiaryGridAdapter extends ArrayAdapter<Enemy> {
        List<Enemy> enemies;
        int resource;

        public BestiaryGridAdapter(Context context, int i, List<Enemy> list) {
            super(context, i);
            this.resource = i;
            this.enemies = list;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.enemies.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            Enemy enemy = this.enemies.get(i);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), MainActivity.data.getSeenEnemies().contains(enemy.getTrueClass()) ? enemy.getImageId() : R.drawable.unknown, getContext().getTheme()));
            return view;
        }
    }

    public static BaseAdapter getKingMessagesAdapter(List<KingMessage> list) {
        return new KingMessagesAdapter(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class KingMessagesAdapter extends BaseAdapter {
        List<KingMessage> messages;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public KingMessagesAdapter(List<KingMessage> list) {
            this.messages = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.messages.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_king_message, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.message_text);
            final KingMessage kingMessage = this.messages.get(i);
            textView.setText(kingMessage.title);
            view.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$KingMessagesAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UIUtils.KingMessagesAdapter.lambda$getView$1(context, kingMessage, view2);
                }
            });
            return view;
        }

        static /* synthetic */ void lambda$getView$1(Context context, KingMessage kingMessage, View view) {
            if (MainActivity.shownKingMessageDialog != null) {
                return;
            }
            MainActivity.shownKingMessageDialog = UIUtils.getInfoDialog(context, Integer.valueOf(kingMessage.title), context.getString(kingMessage.body), true);
            MainActivity.shownKingMessageDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$KingMessagesAdapter$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownKingMessageDialog = null;
                }
            });
            MainActivity.shownKingMessageDialog.show();
        }

        private KingMessage get(int i) {
            int i2 = 0;
            for (KingMessage kingMessage : this.messages) {
                if (i == i2) {
                    return kingMessage;
                }
                i2++;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + i + " of a Set with size " + this.messages.size());
        }
    }

    public static BaseAdapter getDoctrinesAdapter(List<Doctrine> list, Adventurer adventurer) {
        return new DoctrinesAdapter(list, adventurer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DoctrinesAdapter extends BaseAdapter {
        Adventurer adventurer;
        List<Doctrine> doctrines;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public DoctrinesAdapter(List<Doctrine> list, Adventurer adventurer) {
            this.doctrines = list;
            this.adventurer = adventurer;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.doctrines.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Context context = viewGroup.getContext();
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_doctrine, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.doctrine_name);
            TextView textView2 = (TextView) view.findViewById(R.id.doctrine_description);
            ImageView imageView = (ImageView) view.findViewById(R.id.doctrine_image);
            final Doctrine doctrine = this.doctrines.get(i);
            textView.setText(context.getString(doctrine.getIdName()));
            textView2.setText(context.getString(doctrine.getIdDescriptionShort()));
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), doctrine.getIdImage(), context.getTheme()));
            view.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$DoctrinesAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UIUtils.openDoctrineDialog(DoctrinesAdapter.this.adventurer, doctrine);
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: lambda$getView$0$it-paranoidsquirrels-idleguildmaster-UIUtils$DoctrinesAdapter, reason: not valid java name */
        /* synthetic */ void m205x5a19b270(Doctrine doctrine, View view) {
            UIUtils.openDoctrineDialog(this.adventurer, doctrine);
        }

        private Doctrine get(int i) {
            int i2 = 0;
            for (Doctrine doctrine : this.doctrines) {
                if (i == i2) {
                    return doctrine;
                }
                i2++;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + i + " of a Set with size " + this.doctrines.size());
        }
    }

    public static BaseAdapter getFaqAdapter(List<Faq> list) {
        return new FaqAdapter(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class FaqAdapter extends BaseAdapter {
        List<Faq> faqs;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public FaqAdapter(List<Faq> list) {
            this.faqs = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.faqs.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_king_message, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.message_text);
            final Faq faq = this.faqs.get(i);
            textView.setText(faq.title);
            view.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$FaqAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UIUtils.FaqAdapter.lambda$getView$1(context, faq, view2);
                }
            });
            return view;
        }

        static /* synthetic */ void lambda$getView$1(Context context, Faq faq, View view) {
            if (MainActivity.shownDialogIndividualFaq != null) {
                return;
            }
            MainActivity.shownDialogIndividualFaq = UIUtils.getInfoDialog(context, Integer.valueOf(faq.title), context.getString(faq.body), false);
            MainActivity.shownDialogIndividualFaq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.UIUtils$FaqAdapter$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownDialogIndividualFaq = null;
                }
            });
            MainActivity.shownDialogIndividualFaq.show();
        }

        private Faq get(int i) {
            int i2 = 0;
            for (Faq faq : this.faqs) {
                if (i == i2) {
                    return faq;
                }
                i2++;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + i + " of a Set with size " + this.faqs.size());
        }
    }

    public static ArrayAdapter<Pet> getPetsGridAdapter(Context context, List<Pet> list) {
        return new PetsGridAdapter(context, R.layout.layout_pet_grid, list);
    }

    private static class PetsGridAdapter extends ArrayAdapter<Pet> {
        List<Pet> pets;
        int resource;

        public PetsGridAdapter(Context context, int i, List<Pet> list) {
            super(context, i);
            this.resource = i;
            this.pets = list;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.pets.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.level);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.autofeed);
            Pet pet = this.pets.get(i);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), pet.getIdImage(), getContext().getTheme()));
            textView.setText(String.valueOf(pet.getLevel()));
            imageView2.setVisibility(pet.isFavourite() ? 0 : 4);
            return view;
        }
    }
}
