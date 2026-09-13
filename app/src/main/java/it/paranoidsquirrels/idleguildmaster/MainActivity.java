package it.paranoidsquirrels.idleguildmaster;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.MutableBoolean;
import android.util.MutableLong;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.MarginPageTransformer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.PlayGamesSdk;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import it.paranoidsquirrels.idleguildmaster.databinding.ActivityMainBinding;
import it.paranoidsquirrels.idleguildmaster.storage.FileManager;
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.storage.data.SnapshotData;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBuyFromMerchant;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseAdventurer;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseDoctrine;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChoosePet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo23;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeFood;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfRejuvenation;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrineReset;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogFaq;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogIdleProgress;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMessagesReceived;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuests;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRedeemCode;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefreshQuests;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogReport;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop;
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment;
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends AppCompatActivity {
    public static IAPWrapper IAPWrapper = null;
    public static final String SAVE_FILE_NAME = "game_saved";
    public static AdventurersFragment adventurersFragment;
    public static Data data;
    public static DungeonsFragment dungeonsFragment;
    public static HeadquartersFragment headquartersFragment;
    public static RaidsFragment raidsFragment;
    public static AlertDialog shownAdDialog;
    public static AlertDialog shownAdFreeDialog;
    public static DialogEntityDetail shownDialogAdventurerDetailPromotion;
    public static DialogBestiary shownDialogBestiary;
    public static DialogBuyFromMerchant shownDialogBuyFromMerchant;
    public static DialogChangeTraitRare shownDialogChangeTraitRare;
    public static DialogChooseAdventurer shownDialogChooseAdventurer;
    public static DialogChooseDoctrine shownDialogChooseDoctrine;
    public static DialogChoosePet shownDialogChoosePet;
    public static AlertDialog shownDialogCloud;
    public static DialogCollectDrops shownDialogCollectDrops;
    public static DialogConsumeEvo23 shownDialogConsumeEvo23;
    public static DialogConsumeFood shownDialogConsumeFood;
    public static DialogConsumeIntercession shownDialogConsumeIntercession;
    public static DialogConsumePotion shownDialogConsumePotion;
    public static DialogConsumePotionOfClumsiness shownDialogConsumePotionOfClumsiness;
    public static DialogConsumePotionOfRejuvenation shownDialogConsumePotionOfRejuvenation;
    public static DialogCraft shownDialogCraft;
    public static DialogDoctrine shownDialogDoctrine;
    public static DialogDoctrineReset shownDialogDoctrineReset;
    public static DialogDungeonDetail shownDialogDungeonDetail;
    public static DialogEntityDetail shownDialogEntityDetail;
    public static DialogFaq shownDialogFaq;
    public static AlertDialog shownDialogFullStorage;
    public static DialogIdleProgress shownDialogIdleProgress;
    public static AlertDialog shownDialogIndividualFaq;
    public static DialogItemDetail shownDialogItemDetail;
    public static DialogMarket shownDialogMarket;
    public static DialogMerchant shownDialogMerchant;
    public static DialogMergePet shownDialogMergePet;
    public static DialogPetDetail shownDialogPetDetail;
    public static DialogPromotionChoices shownDialogPromotionChoices;
    public static DialogQuarters shownDialogQuarters;
    public static DialogQuests shownDialogQuests;
    public static DialogRecallAdventurers shownDialogRecallAdventurers;
    public static DialogRecipes shownDialogRecipes;
    public static DialogRedeemCode shownDialogRedeemCode;
    public static DialogRefillRaidTry shownDialogRefillRaidTry;
    public static DialogRefreshQuests shownDialogRefreshQuests;
    public static DialogReport shownDialogReport;
    public static DialogSelectEquipment shownDialogSelectEquipment;
    public static DialogSell shownDialogSell;
    public static DialogSendTeam shownDialogSendTeam;
    public static DialogSettings shownDialogSettings;
    public static DialogShelter shownDialogShelter;
    public static DialogShop shownDialogShop;
    public static DialogStorage shownDialogStorage;
    public static DialogTavern shownDialogTavern;
    public static DialogWorkshop shownDialogWorkshop;
    public static AlertDialog shownKingMessageDialog;
    public static DialogMessagesReceived shownMessagesReceived;
    public ActivityMainBinding binding;
    private Handler handlerUI;
    private Thread updaterIdleProgress;
    private Thread updaterUI;
    public static final MutableBoolean applicationPaused = new MutableBoolean(false);
    public static MutableBoolean IDLE_THREAD_FINISHED = new MutableBoolean(false);
    private AdRequest adRequest = null;
    private RewardedAd rewardedAd = null;
    private final FullScreenContentCallback adCallback = new FullScreenContentCallback() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity.3
        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            MainActivity.this.rewardedAd = null;
            MainActivity.this.loadAd();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            MainActivity.this.rewardedAd = null;
            MainActivity.this.loadAd();
        }
    };

    private MainActivity getThis() {
        return this;
    }

    static /* synthetic */ void lambda$loadSavedGame$35(Exception exc) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppCompatDelegate.setDefaultNightMode(2);
        super.onCreate(bundle);
        UIUtils.hideUI(getWindow());
        getSupportActionBar().hide();
        if (16 == (getResources().getConfiguration().uiMode & 48)) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            return;
        }
        TrueTimeUtils.init();
        data = FileManager.load(this);
        QuestsManager.initializeFields(QuestsManager.calculateDifficulty());
        QuestsManager.realignQuests();
        PlayGamesSdk.initialize(this);
        MobileAds.initialize(this, new OnInitializationCompleteListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda25
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                MainActivity.this.m201xc3bda385(initializationStatus);
            }
        });
        if (IAPWrapper == null) {
            IAPWrapper iAPWrapper = new IAPWrapper(getApplicationContext());
            IAPWrapper = iAPWrapper;
            iAPWrapper.setRefreshGemsCallback(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.refreshGems();
                }
            });
            IAPWrapper.setRefreshAdventurersCallback(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.adventurersFragment.refresh();
                }
            });
            IAPWrapper.setRefreshHeadquartersCallback(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.headquartersFragment.refresh();
                }
            });
            IAPWrapper.setRefreshIconsCallback(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.refreshIcons();
                }
            });
            IAPWrapper.setRefreshShopCallback(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.lambda$onCreate$3();
                }
            });
        }
        Locale locale = new Locale(data.getSettingsLanguage().isEmpty() ? Locale.getDefault().getLanguage() : data.getSettingsLanguage());
        Locale.setDefault(locale);
        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        ActivityMainBinding activityMainBindingInflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = activityMainBindingInflate;
        setContentView(activityMainBindingInflate.getRoot());
        this.binding.pager.setAdapter(UIUtils.getPagerAdapter(this));
        this.binding.pager.setOffscreenPageLimit(4);
        this.binding.pager.setPageTransformer(new MarginPageTransformer(160));
        this.binding.navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda31
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return MainActivity.this.m202xd1ea1a89(menuItem);
            }
        });
        retroactivelyUnlockHiddenCityOfLarox();
        retroactivelyUnlockLostLands();
        retroactivelyUnlockTheLostExpedition();
        retroactivelyUnlockCelestialMothership();
        retroactivelyUnlockTheDireDescent();
        retroactivelyGrantIntercession();
        retroactivelyGrantEvo23Vial2();
        retroactivelyUnlockLast3();
        retroactivelySetSeenQuests();
        if (data.getMaxWealth() == 0 && data.getMaxAdventurersOwned() == 0) {
            AchievementsUtils.retroactivelyUnlockAchievements();
        }
        refresh();
        refreshRaidsFragmentVisibility();
        attachListeners();
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m201xc3bda385(InitializationStatus initializationStatus) {
        loadAd();
    }

    static /* synthetic */ void lambda$onCreate$3() {
        DialogShop dialogShop = shownDialogShop;
        if (dialogShop != null) {
            dialogShop.refresh();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$4$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m202xd1ea1a89(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.navigation_adventurers) {
            this.binding.pager.setCurrentItem(1);
            return true;
        }
        if (itemId == R.id.navigation_dungeons) {
            this.binding.pager.setCurrentItem(2);
            return true;
        }
        if (itemId == R.id.navigation_raids) {
            this.binding.pager.setCurrentItem(3);
            return true;
        }
        this.binding.pager.setCurrentItem(0);
        return true;
    }

    public void refresh() {
        refreshMoney();
        refreshGems();
        refreshKingMessages();
        refreshTutorial();
        refreshIcons();
    }

    public void refreshMoney() {
        UIUtils.populateMoneyContainer(this.binding.money, data.getMoney(), false);
    }

    public void refreshGems() {
        this.binding.amountGems.setText(String.valueOf(data.getGems()));
    }

    public void refreshKingMessages() {
        this.binding.kingMessage.setVisibility(data.getMessagesToShow().size() > 0 ? 0 : 8);
    }

    public void refreshTutorial() {
        int tutorialStep = data.getTutorialStep();
        if (tutorialStep >= 7) {
            this.binding.containerTutorial.setVisibility(8);
            return;
        }
        int i = 0;
        this.binding.containerTutorial.setVisibility(0);
        switch (tutorialStep) {
            case 0:
            case 1:
                i = R.string.tutorial_2;
                break;
            case 2:
                i = R.string.tutorial_3;
                break;
            case 3:
                i = R.string.tutorial_4;
                break;
            case 4:
                i = R.string.tutorial_5;
                break;
            case 5:
                i = R.string.tutorial_6;
                break;
            case 6:
                i = R.string.tutorial_7;
                break;
        }
        this.binding.tutorialStep.setText(String.format(getString(R.string.tutorial_step), Integer.valueOf(tutorialStep)));
        this.binding.tutorialBody.setText(Html.fromHtml(getString(i), 63));
    }

    public void refreshIcons() {
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            return;
        }
        int i = 8;
        // Temporary disabled in UI per configuration (implemented but hidden)
        activityMainBinding.ad.setVisibility(8);
        this.binding.adfree.setVisibility(8);
        this.binding.shop.setVisibility(8);
        this.binding.navViewDrawer.getMenu().findItem(R.id.shop).setVisible(false);
        this.binding.navViewDrawer.getMenu().findItem(R.id.cafe_naver).setVisible("ko".equals(data.getSettingsLanguage()));
        this.binding.newItems.setVisibility(data.isNewMerchantRegularItems() ? 0 : 8);
        boolean z = data.getKingsQuests().isEmpty() && data.getAfflictionQuests().isEmpty() && data.getControlQuests().isEmpty() && data.getFortitudeQuests().isEmpty() && data.getGraceQuests().isEmpty() && data.getIllusionQuests().isEmpty() && data.getKnowledgeQuests().isEmpty() && data.getRuinQuests().isEmpty() && data.getWarQuests().isEmpty();
        this.binding.quests.setVisibility(data.isQuestsSeen() ? 0 : 8);
        ImageView imageView = this.binding.questsNotification;
        if (!z && QuestsManager.QUEST_NOTIFICATION && data.isQuestsSeen()) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public void refreshRaidsFragmentVisibility() {
        boolean z;
        if (RaidsFragment.VISIBLE) {
            return;
        }
        Iterator<Area> it2 = Utils.compileRaidList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            } else if (it2.next().isUnlocked()) {
                z = true;
                break;
            }
        }
        RaidsFragment.VISIBLE = z;
        this.binding.navView.getMenu().getItem(3).setVisible(z);
        if (z) {
            this.binding.pager.getAdapter().notifyItemInserted(3);
        }
    }

    public void attachListeners() {
        this.binding.containerGems.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m196x8453ea6f(view);
            }
        });
        this.binding.menuButton.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m197xc7df0830(view);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.shop).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m198xb6a25f1(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.settings).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m199x4ef543b2(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.dismissed_adventurers).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m200x92806173(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.messages_received).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m175xefcf7a07(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.faq).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda6
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m176x335a97c8(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.bestiary).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda7
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m177x76e5b589(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.achievements).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda8
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m179xfdfbf10b(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.cloud).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda9
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m183x4fb385d0(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.redeem_code).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda11
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m184x1da81466(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.reddit).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda22
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m185x61333227(menuItem);
            }
        });
        this.binding.navViewDrawer.getMenu().findItem(R.id.cafe_naver).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda33
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.this.m186xa4be4fe8(menuItem);
            }
        });
        this.binding.kingMessage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m187x2bd48b6a(view);
            }
        });
        this.binding.merchant.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m188x6f5fa92b(view);
            }
        });
        this.binding.ad.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m191x7d8c202f(view);
            }
        });
        this.binding.adfree.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m193xd296ea47(view);
            }
        });
        this.binding.shop.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m194x16220808(view);
            }
        });
        this.binding.quests.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m195x59ad25c9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m196x8453ea6f(View view) {
        if (shownDialogShop == null && IAPWrapper.initialized) {
            new DialogShop().show(getSupportFragmentManager(), "shop");
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m197xc7df0830(View view) {
        this.binding.drawerLayout.open();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m198xb6a25f1(MenuItem menuItem) {
        if (shownDialogShop != null) {
            return true;
        }
        new DialogShop().show(getSupportFragmentManager(), "shop");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m199x4ef543b2(MenuItem menuItem) {
        if (shownDialogSettings != null) {
            return true;
        }
        new DialogSettings().show(getSupportFragmentManager(), "dialog_settings");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m200x92806173(MenuItem menuItem) {
        if (shownDialogRecallAdventurers != null) {
            return true;
        }
        new DialogRecallAdventurers().show(getSupportFragmentManager(), "dialog_recall_adventurers");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m175xefcf7a07(MenuItem menuItem) {
        if (shownMessagesReceived != null) {
            return true;
        }
        new DialogMessagesReceived().show(getSupportFragmentManager(), "dialog_messages_received");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m176x335a97c8(MenuItem menuItem) {
        if (shownDialogFaq != null) {
            return true;
        }
        new DialogFaq().show(getSupportFragmentManager(), "dialog_faq");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$12$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m177x76e5b589(MenuItem menuItem) {
        if (shownDialogBestiary != null) {
            return true;
        }
        new DialogBestiary().show(getSupportFragmentManager(), "dialog_bestiary");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$14$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m179xfdfbf10b(MenuItem menuItem) {
        PlayGames.getAchievementsClient(this).getAchievementsIntent().addOnSuccessListener(new OnSuccessListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda32
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainActivity.this.m178xba70d34a((Intent) obj);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$13$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m178xba70d34a(Intent intent) {
        startActivityForResult(intent, 9003);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$19$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m183x4fb385d0(MenuItem menuItem) {
        if (shownDialogCloud == null) {
            try {
                PlayGames.getGamesSignInClient(this).isAuthenticated().addOnCompleteListener(new OnCompleteListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda13
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        MainActivity.this.m182xc28680f(task);
                    }
                });
            } catch (Exception unused) {
                Toast.makeText(this, "Error signing into Play Services", 1).show();
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$18$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m182xc28680f(Task task) {
        if (task.isSuccessful() && ((AuthenticationResult) task.getResult()).isAuthenticated()) {
            try {
                loadSavedGame().addOnCompleteListener(new OnCompleteListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda16
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task2) {
                        MainActivity.this.m181xc89d4a4e(task2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$17$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m181xc89d4a4e(final Task task) {
        if (!task.isSuccessful() || task.getResult() == null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(this, Integer.valueOf(R.string.drawer_cloud_title), String.format(getString(R.string.drawer_cloud_description), ((SnapshotData) task.getResult()).getDescription()), R.string.yes, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m180x41870ecc(task, dialogInterface, i);
            }
        });
        shownDialogCloud = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MainActivity.shownDialogCloud = null;
            }
        });
        shownDialogCloud.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$15$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m180x41870ecc(Task task, DialogInterface dialogInterface, int i) {
        SaveManager.inhibitSave = true;
        FileManager.overwriteFile(getApplicationContext(), new String(((SnapshotData) task.getResult()).getData()));
        getThis().finish();
        System.exit(0);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$20$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m184x1da81466(MenuItem menuItem) {
        if (shownDialogRedeemCode != null) {
            return true;
        }
        new DialogRedeemCode().show(getSupportFragmentManager(), "dialog_redeem_code");
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$21$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m185x61333227(MenuItem menuItem) {
        try {
            getThis().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.reddit.com/r/IdleGuildMaster/")));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getThis(), R.string.drawer_toast_no_browser, 1).show();
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$22$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ boolean m186xa4be4fe8(MenuItem menuItem) {
        try {
            getThis().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://cafe.naver.com/idleguildmaster/")));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getThis(), R.string.drawer_toast_no_browser, 1).show();
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$24$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m187x2bd48b6a(View view) {
        if (data.getMessagesToShow().size() > 0) {
            if (shownKingMessageDialog != null) {
                return;
            }
            KingMessage kingMessage = data.getMessagesToShow().get(0);
            AlertDialog infoDialog = UIUtils.getInfoDialog(this, Integer.valueOf(kingMessage.title), getString(kingMessage.body), true);
            shownKingMessageDialog = infoDialog;
            infoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda24
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainActivity.shownKingMessageDialog = null;
                }
            });
            shownKingMessageDialog.show();
            data.getMessagesToShow().remove(0);
        }
        refreshKingMessages();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$25$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m188x6f5fa92b(View view) {
        if (shownDialogMerchant != null) {
            return;
        }
        new DialogMerchant().show(getSupportFragmentManager(), "merchant");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$29$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m191x7d8c202f(View view) {
        if (shownAdDialog != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(this, Integer.valueOf(R.string.ad_dialog_title), String.format(getString(R.string.ad_dialog_body), Integer.valueOf(data.getAdsWatched())), R.string.ad_dialog_confirm, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m190xf675e4ad(dialogInterface, i);
            }
        });
        shownAdDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MainActivity.shownAdDialog = null;
            }
        });
        shownAdDialog.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$27$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m190xf675e4ad(DialogInterface dialogInterface, int i) {
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd == null) {
            return;
        }
        rewardedAd.show(this, new OnUserEarnedRewardListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda18
            @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
            public final void onUserEarnedReward(RewardItem rewardItem) {
                MainActivity.this.m189xb2eac6ec(rewardItem);
            }
        });
        shownAdDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$26$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m189xb2eac6ec(RewardItem rewardItem) {
        boolean z = data.getAdsWatched() == 4;
        Data data2 = data;
        data2.setAdsWatched(data2.getAdsWatched() + 1);
        Data data3 = data;
        data3.setGems(data3.getGems() + ((long) (z ? 15 : 5)));
        refreshGems();
        refreshIcons();
        if (z) {
            UIUtils.getInfoDialog(this, Integer.valueOf(R.string.all_ads_watched_dialog_title), getString(R.string.all_ads_watched_dialog_body), false).show();
        }
    }

    /* JADX INFO: renamed from: lambda$attachListeners$32$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m193xd296ea47(View view) {
        if (shownAdFreeDialog != null) {
            return;
        }
        AlertDialog actionDialog = UIUtils.getActionDialog(this, Integer.valueOf(R.string.ad_free_dialog_title), getString(R.string.ad_free_dialog_body), R.string.ad_free_dialog_confirm, new DialogInterface.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.shownAdFreeDialog.dismiss();
            }
        });
        shownAdFreeDialog = actionDialog;
        actionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MainActivity.this.m192x8f0bcc86(dialogInterface);
            }
        });
        shownAdFreeDialog.show();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$31$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m192x8f0bcc86(DialogInterface dialogInterface) {
        data.setAdsWatched(5);
        Data data2 = data;
        data2.setGems(data2.getGems() + 35);
        refreshGems();
        refreshIcons();
        shownAdFreeDialog = null;
    }

    /* JADX INFO: renamed from: lambda$attachListeners$33$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m194x16220808(View view) {
        if (shownDialogShop != null) {
            return;
        }
        new DialogShop().show(getSupportFragmentManager(), "shop");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$34$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m195x59ad25c9(View view) {
        if (shownDialogQuests != null) {
            return;
        }
        new DialogQuests().show(getSupportFragmentManager(), "quests");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (IAPWrapper.initialized) {
            IAPWrapper.queryAsync();
        }
        applicationPaused.value = false;
        SaveManager.inhibitSave = false;
        initializeThreads();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        SaveManager.getInstance().stopTimerTask();
        SaveManager.getInstance().save(getApplicationContext());
        applicationPaused.value = true;
        this.handlerUI.removeCallbacks(this.updaterUI);
        this.handlerUI = null;
        DialogIdleProgress dialogIdleProgress = shownDialogIdleProgress;
        if (dialogIdleProgress != null) {
            dialogIdleProgress.dismiss();
            shownDialogIdleProgress = null;
        }
        DialogDungeonDetail dialogDungeonDetail = shownDialogDungeonDetail;
        if (dialogDungeonDetail != null) {
            dialogDungeonDetail.dismiss();
            shownDialogDungeonDetail = null;
        }
        DialogPromotionChoices dialogPromotionChoices = shownDialogPromotionChoices;
        if (dialogPromotionChoices != null) {
            dialogPromotionChoices.dismiss();
            shownDialogPromotionChoices = null;
        }
        super.onPause();
    }

    private void initializeThreads() {
        boolean z;
        int iMin = (Math.min(4, 4) + 8) * Utils.ONE_HOUR_IN_SECONDS;
        long lastAccess = data.getLastAccess();
        final long jMillis = TrueTimeUtils.millis();
        long jMax = lastAccess != 0 ? Math.max(1L, Math.min(iMin, Math.round((jMillis - lastAccess) / 1000.0d))) : 1L;
        Utils.progressTavernTime(jMax);
        Utils.progressMarketTime(jMax);
        Utils.progressWorkshopTime(jMax);
        Utils.checkDismissedAdventurersExpiration(jMillis);
        Iterator<Area> it2 = Utils.compileDungeonRaidList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            } else if (!it2.next().getAdventurersExploringIds().isEmpty()) {
                z = true;
                break;
            }
        }
        if (jMax > 60 && z) {
            DialogIdleProgress dialogIdleProgress = new DialogIdleProgress();
            shownDialogIdleProgress = dialogIdleProgress;
            dialogIdleProgress.skipOnShowListener();
            shownDialogIdleProgress.setCancelable(false);
            shownDialogIdleProgress.show(getSupportFragmentManager(), "dialog_idle_progress");
        }
        final MutableLong mutableLong = new MutableLong(0L);
        final long j = jMax;
        Thread thread = new Thread() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                List<Area> listCompileDungeonRaidList = Utils.compileDungeonRaidList();
                int i = 0;
                while (true) {
                    long j2 = i;
                    if (j2 < j) {
                        if (MainActivity.applicationPaused.value) {
                            return;
                        }
                        Iterator<Area> it3 = listCompileDungeonRaidList.iterator();
                        while (it3.hasNext()) {
                            it3.next().tick();
                        }
                        mutableLong.value++;
                        MainActivity.data.setLastAccess(jMillis - ((j - j2) * 1000));
                        i++;
                    } else {
                        MainActivity.IDLE_THREAD_FINISHED.value = true;
                        SaveManager.getInstance().save(MainActivity.this.getApplicationContext());
                        return;
                    }
                }
            }
        };
        this.updaterIdleProgress = thread;
        thread.start();
        final MutableBoolean mutableBoolean = new MutableBoolean(true);
        final MutableBoolean mutableBoolean2 = new MutableBoolean(true);
        if (this.handlerUI == null) {
            this.handlerUI = new Handler();
            final long j2 = jMax;
            Thread thread2 = new Thread() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    boolean z2 = (MainActivity.headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null) && (MainActivity.dungeonsFragment != null && MainActivity.dungeonsFragment.getBinding() != null) && (!RaidsFragment.VISIBLE || (MainActivity.raidsFragment != null && MainActivity.raidsFragment.getBinding() != null)) && (MainActivity.adventurersFragment != null && MainActivity.adventurersFragment.getBinding() != null);
                    if (MainActivity.IDLE_THREAD_FINISHED.value && z2) {
                        if (mutableBoolean2.value) {
                            mutableBoolean2.value = false;
                            MainActivity.this.onLoadingComplete();
                        }
                        Utils.nextTimeTick();
                        MainActivity.this.handlerUI.postDelayed(this, mutableBoolean.value ? 10L : 1000L);
                    } else {
                        if (MainActivity.shownDialogIdleProgress != null) {
                            MainActivity.shownDialogIdleProgress.refreshProgress((int) ((mutableLong.value * 100) / j2));
                        }
                        MainActivity.this.handlerUI.postDelayed(this, 10L);
                    }
                    mutableBoolean.value = false;
                }
            };
            this.updaterUI = thread2;
            this.handlerUI.post(thread2);
        }
        SaveManager.getInstance().startTimer(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingComplete() {
        headquartersFragment.refresh();
        dungeonsFragment.refresh();
        dungeonsFragment.refreshDungeonVisibility();
        if (RaidsFragment.VISIBLE) {
            raidsFragment.refresh();
            raidsFragment.refreshRaidVisibility();
        }
        adventurersFragment.refresh();
        refresh();
        refreshRaidsFragmentVisibility();
        DialogIdleProgress dialogIdleProgress = shownDialogIdleProgress;
        if (dialogIdleProgress != null) {
            dialogIdleProgress.dismiss();
            shownDialogIdleProgress = null;
        }
        AchievementsUtils.flushQueue();
    }

    public void loadAd() {
        if (data.getAdsWatched() >= 5) {
            refreshIcons();
        } else {
            if (data.isStarterPackPurchased()) {
                return;
            }
            if (this.adRequest == null) {
                this.adRequest = new AdRequest.Builder().build();
            }
            RewardedAd.load(this, "ca-app-pub-4589624666705243/2778487135", this.adRequest, new AnonymousClass4());
        }
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.MainActivity$4, reason: invalid class name */
    class AnonymousClass4 extends RewardedAdLoadCallback {
        AnonymousClass4() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            MainActivity.this.rewardedAd = null;
            MainActivity.this.refreshIcons();
            new Handler().postDelayed(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.loadAd();
                }
            }, 60000L);
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$it-paranoidsquirrels-idleguildmaster-MainActivity$4, reason: not valid java name */
        /* synthetic */ void m204xbb49547a() {
            MainActivity.this.loadAd();
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(RewardedAd rewardedAd) {
            MainActivity.this.rewardedAd = rewardedAd;
            MainActivity.this.rewardedAd.setFullScreenContentCallback(MainActivity.this.adCallback);
            MainActivity.this.refreshIcons();
        }
    }

    public Task<SnapshotData> loadSavedGame() {
        try {
            return PlayGames.getSnapshotsClient(this).open(SAVE_FILE_NAME, true, 3).addOnFailureListener(new OnFailureListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda21
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    MainActivity.lambda$loadSavedGame$35(exc);
                }
            }).continueWith(new Continuation() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda23
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) throws Exception {
                    return MainActivity.lambda$loadSavedGame$36(task);
                }
            });
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ SnapshotData lambda$loadSavedGame$36(Task task) throws Exception {
        try {
            Snapshot snapshot = (Snapshot) ((SnapshotsClient.DataOrConflict) task.getResult()).getData();
            return new SnapshotData(snapshot.getMetadata().getDescription(), snapshot.getSnapshotContents().readFully());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void viewSaves() {
        PlayGames.getSnapshotsClient(this).getSelectSnapshotIntent("Saved Instance", true, true, 1).addOnSuccessListener(new OnSuccessListener() { // from class: it.paranoidsquirrels.idleguildmaster.MainActivity$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainActivity.this.m203x613e2bb5((Intent) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$viewSaves$37$it-paranoidsquirrels-idleguildmaster-MainActivity, reason: not valid java name */
    /* synthetic */ void m203x613e2bb5(Intent intent) {
        startActivityForResult(intent, 9009);
    }

    private void retroactivelyUnlockHiddenCityOfLarox() {
        if (data.getBarrenWastelands().getMaxProgress() < 100 || data.getHiddenCityOfLarox().isUnlocked()) {
            return;
        }
        UIUtils.unlockArea(data.getHiddenCityOfLarox());
    }

    private void retroactivelyUnlockLostLands() {
        if (data.getHiddenCityOfLarox().getMaxProgress() < 100 || data.getLostLands().isUnlocked()) {
            return;
        }
        UIUtils.unlockArea(data.getLostLands());
    }

    private void retroactivelyUnlockTheLostExpedition() {
        if (data.getObsidianMines().getMaxProgress() < 220 || data.getTheLostExpedition().isUnlocked()) {
            return;
        }
        UIUtils.unlockArea(data.getTheLostExpedition());
    }

    private void retroactivelyUnlockCelestialMothership() {
        if (data.getBarrenWastelands().getMaxProgress() < 180 || data.getCelestialMothership().isUnlocked()) {
            return;
        }
        UIUtils.unlockArea(data.getCelestialMothership());
    }

    private void retroactivelyUnlockTheDireDescent() {
        if (data.getLostLands().getMaxProgress() < 100 || data.getTheDireDescent().isUnlocked()) {
            return;
        }
        UIUtils.unlockArea(data.getTheDireDescent());
    }

    private void retroactivelyGrantIntercession() {
        if (data.isIntercessionsRetroactivelyGranted()) {
            return;
        }
        data.setIntercessionsRetroactivelyGranted(true);
        if (data.isImperialVanguardPurchased()) {
            Utils.collectItem(Item.getInstance("Intercession", 1), data.getItems());
        }
        if (data.isUnholyCrusadePurchased()) {
            Utils.collectItem(Item.getInstance("Intercession", 1), data.getItems());
        }
    }

    private void retroactivelyGrantEvo23Vial2() {
        if (data.isVial2RetGrant()) {
            return;
        }
        data.setVial2RetGrant(true);
        if (data.isAdventurerPackPurchased()) {
            Utils.collectItem(Item.getInstance("Evo23Vial2", 1), data.getItems());
        }
    }

    private void retroactivelyUnlockLast3() {
        if (data.getTheDireDescent().getMaxProgress() >= 7) {
            if (!data.getSleepingPlanet().isUnlocked()) {
                UIUtils.unlockArea(data.getSleepingPlanet());
            }
            if (!data.getKaunis().isUnlocked()) {
                UIUtils.unlockArea(data.getKaunis());
            }
            if (data.getTheTower().isUnlocked()) {
                return;
            }
            UIUtils.unlockArea(data.getTheTower());
        }
    }

    private void retroactivelySetSeenQuests() {
        if (data.getKingsQuests().isEmpty() && data.getAfflictionQuests().isEmpty() && data.getControlQuests().isEmpty() && data.getFortitudeQuests().isEmpty() && data.getGraceQuests().isEmpty() && data.getIllusionQuests().isEmpty() && data.getKnowledgeQuests().isEmpty() && data.getRuinQuests().isEmpty() && data.getWarQuests().isEmpty()) {
            return;
        }
        data.setQuestsSeen(true);
    }

    private void retroactivelyAddKnownRecipes() {
        for (Recipes recipes : Arrays.asList(Recipes.VoltaicShock)) {
            Iterator<Item> it2 = recipes.getIngredients().iterator();
            while (it2.hasNext()) {
                if (data.getSeenItems().contains(it2.next().getTrueClass())) {
                    data.getKnownRecipes().add(recipes);
                    break;
                }
            }
        }
    }

    void testDataManipulation() {
        checkPrices();
    }

    void checkPrices() {
        for (Recipes recipes : Recipes.values()) {
            long price = 0;
            for (Item item : recipes.getIngredients()) {
                price += item.getPrice() * ((long) item.getStack());
            }
            double d = price * 1.5d;
            long jCeil = d % 0.5d == 0.0d ? (long) Math.ceil(d) : Math.round(d);
            if (jCeil != recipes.getResult().getPrice()) {
                System.out.println("Incorrect price for " + recipes.getResult().getTrueClass() + ": expected " + jCeil + ", found " + recipes.getResult().getPrice());
            }
        }
    }
}
