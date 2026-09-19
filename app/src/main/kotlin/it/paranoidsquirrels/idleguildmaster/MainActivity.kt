package it.paranoidsquirrels.idleguildmaster

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.util.MutableBoolean
import android.util.MutableLong
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.games.AuthenticationResult
import com.google.android.gms.games.PlayGames
import com.google.android.gms.games.PlayGamesSdk
import com.google.android.gms.games.SnapshotsClient
import com.google.android.gms.games.snapshot.Snapshot
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import it.paranoidsquirrels.idleguildmaster.databinding.ActivityMainBinding
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.SnapshotData
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.*
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment
import it.paranoidsquirrels.idleguildmaster.ui.guildactivities.GuildActivitiesFragment
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment
import java.util.Arrays
import java.util.Locale

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmField
        var context: Context? = null
        const val SAVE_FILE_NAME = "game_saved"

        @JvmField
        var IAPWrapper: IAPWrapper? = null

        @JvmField
        var adventurersFragment: AdventurersFragment = AdventurersFragment()

        @JvmField
        var data: Data = Data()

        @JvmField
        var dungeonsFragment: DungeonsFragment = DungeonsFragment()

        @JvmField
        var headquartersFragment: HeadquartersFragment = HeadquartersFragment()

        @JvmField
        var raidsFragment: RaidsFragment = RaidsFragment()

        @JvmField
        var guildActivitiesFragment: GuildActivitiesFragment = GuildActivitiesFragment()

        @JvmField
        var shownAdDialog: AlertDialog? = null

        @JvmField
        var shownAdFreeDialog: AlertDialog? = null

        @JvmField
        var shownDialogAdventurerDetailPromotion: DialogEntityDetail? = null

        @JvmField
        var shownDialogBestiary: DialogBestiary? = null

        @JvmField
        var shownDialogBuyFromMerchant: DialogBuyFromMerchant? = null

        @JvmField
        var shownDialogChangeTraitRare: DialogChangeTraitRare? = null

        @JvmField
        var shownDialogChooseAdventurer: DialogChooseAdventurer? = null

        @JvmField
        var shownDialogChooseDoctrine: DialogChooseDoctrine? = null

        @JvmField
        var shownDialogChoosePet: DialogChoosePet? = null

        @JvmField
        var shownDialogCloud: AlertDialog? = null

        @JvmField
        var shownDialogCollectDrops: DialogCollectDrops? = null

        @JvmField
        var shownDialogConsumeEvo23: DialogConsumeEvo23? = null

        @JvmField
        var shownDialogConsumeFood: DialogConsumeFood? = null

        @JvmField
        var shownDialogConsumeIntercession: DialogConsumeIntercession? = null

        @JvmField
        var shownDialogConsumePotion: DialogConsumePotion? = null

        @JvmField
        var shownDialogConsumePotionOfClumsiness: DialogConsumePotionOfClumsiness? = null

        @JvmField
        var shownDialogConsumePotionOfRejuvenation: DialogConsumePotionOfRejuvenation? = null

        @JvmField
        var shownDialogCraft: DialogCraft? = null

        @JvmField
        var shownDialogDoctrine: DialogDoctrine? = null

        @JvmField
        var shownDialogDoctrineReset: DialogDoctrineReset? = null

        @JvmField
        var shownDialogDungeonDetail: DialogDungeonDetail? = null

        @JvmField
        var shownDialogEntityDetail: DialogEntityDetail? = null

        @JvmField
        var shownDialogFaq: DialogFaq? = null

        @JvmField
        var shownDialogFullStorage: AlertDialog? = null

        @JvmField
        var shownDialogIdleProgress: DialogIdleProgress? = null

        @JvmField
        var shownDialogIndividualFaq: AlertDialog? = null

        @JvmField
        var shownDialogItemDetail: DialogItemDetail? = null

        @JvmField
        var shownDialogMarket: DialogMarket? = null

        @JvmField
        var shownDialogMerchant: DialogMerchant? = null

        @JvmField
        var shownDialogBlackMarket: DialogBlackMarket? = null

        @JvmField
        var shownDialogMergePet: DialogMergePet? = null

        @JvmField
        var shownDialogPetDetail: DialogPetDetail? = null

        @JvmField
        var shownDialogPromotionChoices: DialogPromotionChoices? = null

        @JvmField
        var shownDialogQuarters: DialogQuarters? = null

        @JvmField
        var shownDialogQuests: DialogQuests? = null

        @JvmField
        var shownDialogRecallAdventurers: DialogRecallAdventurers? = null

        @JvmField
        var shownDialogRecipes: DialogRecipes? = null

        @JvmField
        var shownDialogRedeemCode: DialogRedeemCode? = null

        @JvmField
        var shownDialogRefillRaidTry: DialogRefillRaidTry? = null

        @JvmField
        var shownDialogRefreshQuests: DialogRefreshQuests? = null

        @JvmField
        var shownDialogReport: DialogReport? = null

        @JvmField
        var shownDialogSelectEquipment: DialogSelectEquipment? = null

        @JvmField
        var shownDialogSell: DialogSell? = null

        @JvmField
        var shownDialogSendTeam: DialogSendTeam? = null

        @JvmField
        var shownDialogSettings: DialogSettings? = null

        @JvmField
        var shownDialogShelter: DialogShelter? = null

        @JvmField
        var shownDialogShop: DialogShop? = null

        @JvmField
        var shownDialogStorage: DialogStorage? = null

        @JvmField
        var shownDialogTavern: DialogTavern? = null

        @JvmField
        var shownDialogWorkshop: DialogWorkshop? = null

        @JvmField
        var shownKingMessageDialog: AlertDialog? = null

        @JvmField
        var shownMessagesReceived: DialogMessagesReceived? = null

        @JvmField
        val applicationPaused: MutableBoolean = MutableBoolean(false)

        @JvmField
        val IDLE_THREAD_FINISHED: MutableBoolean = MutableBoolean(false)
    }

    lateinit var binding: ActivityMainBinding

    private var handlerUI: Handler? = null
    private var updaterIdleProgress: Thread? = null
    private var updaterUI: Thread? = null

    private var rewardedAd: RewardedAd? = null
    private var adRequest: AdRequest? = null

    private val adCallback = object : FullScreenContentCallback() {
        override fun onAdClicked() {}
        override fun onAdImpression() {}
        override fun onAdShowedFullScreenContent() {}
        override fun onAdDismissedFullScreenContent() {
            rewardedAd = null
            loadAd()
        }
        override fun onAdFailedToShowFullScreenContent(adError: AdError) {
            rewardedAd = null
            loadAd()
        }
    }

    private fun getThis(): MainActivity = this

    override fun onCreate(bundle: Bundle?) {
        context = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(bundle)
        UIUtils.hideUI(window)
        supportActionBar?.hide()

        if (16 == (resources.configuration.uiMode and 48)) {
            startActivity(Intent(this, MainActivity::class.java))
            return
        }

        TrueTimeUtils.init()
        data = FileManager.load(this)
        QuestsManager.initializeFields(QuestsManager.calculateDifficulty())
        QuestsManager.realignQuests()
        PlayGamesSdk.initialize(this)

        MobileAds.initialize(this) {
            loadAd()
        }

        if (IAPWrapper == null) {
            val wrapper = IAPWrapper(applicationContext)
            IAPWrapper = wrapper
            wrapper.setRefreshGemsCallback { refreshGems() }
            wrapper.setRefreshAdventurersCallback { adventurersFragment?.refresh() }
            wrapper.setRefreshHeadquartersCallback { headquartersFragment?.refresh() }
            wrapper.setRefreshIconsCallback { refreshIcons() }
            wrapper.setRefreshShopCallback { shownDialogShop?.refresh() }
        }

        val lang = data.settingsLanguage
        val locale = Locale(if (lang.isNullOrEmpty()) Locale.getDefault().language else lang)
        Locale.setDefault(locale)
        val configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = UIUtils.getPagerAdapter(this)
        binding.pager.offscreenPageLimit = 4
        binding.pager.setPageTransformer(MarginPageTransformer(160))

        binding.navView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_adventurers -> binding.pager.setCurrentItem(1, true)
                R.id.navigation_dungeons -> binding.pager.setCurrentItem(2, true)
                R.id.navigation_raids -> binding.pager.setCurrentItem(3, true)
                R.id.navigation_guild_activities -> binding.pager.setCurrentItem(4, true)
                else -> binding.pager.setCurrentItem(0, true)
            }
            true
        }

        retroactivelyUnlockHiddenCityOfLarox()
        retroactivelyUnlockLostLands()
        retroactivelyUnlockTheLostExpedition()
        retroactivelyUnlockCelestialMothership()
        retroactivelyUnlockTheDireDescent()
        retroactivelyGrantIntercession()
        retroactivelyGrantEvo23Vial2()
        retroactivelyUnlockLast3()
        retroactivelySetSeenQuests()

        if (data.maxWealth == 0L && data.maxAdventurersOwned == 0) {
            AchievementsUtils.retroactivelyUnlockAchievements()
        }

        refresh()
        refreshRaidsFragmentVisibility()
        attachListeners()
    }

    fun refresh() {
        refreshMoney()
        refreshGems()
        refreshKingMessages()
        refreshTutorial()
        refreshIcons()
    }

    fun refreshMoney() {
        UIUtils.populateMoneyContainer(binding.money, data.money, false)
    }

    fun refreshGems() {
        binding.amountGems.text = data.gems.toString()
    }

    fun refreshKingMessages() {
        binding.kingMessage.visibility = if (data.messagesToShow.isNotEmpty()) View.VISIBLE else View.GONE
    }

    fun refreshTutorial() {
        val tutorialStep = data.tutorialStep
        if (tutorialStep >= 7) {
            binding.containerTutorial.visibility = View.GONE
            return
        }
        binding.containerTutorial.visibility = View.VISIBLE
        val textRes = when (tutorialStep) {
            0, 1 -> R.string.tutorial_2
            2 -> R.string.tutorial_3
            3 -> R.string.tutorial_4
            4 -> R.string.tutorial_5
            5 -> R.string.tutorial_6
            6 -> R.string.tutorial_7
            else -> 0
        }
        binding.tutorialStep.text = String.format(getString(R.string.tutorial_step), tutorialStep)
        binding.tutorialBody.text = Html.fromHtml(getString(textRes), Html.FROM_HTML_MODE_COMPACT)
    }

    fun refreshIcons() {
        binding.ad.visibility = View.GONE
        binding.adfree.visibility = View.GONE
        binding.shop.visibility = View.GONE
        binding.navViewDrawer.menu.findItem(R.id.shop)?.isVisible = false
        binding.navViewDrawer.menu.findItem(R.id.cafe_naver)?.isVisible = ("ko" == data.settingsLanguage)
        binding.newItems.visibility = if (data.isNewMerchantRegularItems) View.VISIBLE else View.GONE
        binding.blackMarket.visibility = if (data.isBlackMarketActive) View.VISIBLE else View.GONE
        binding.newBlackMarketItems.visibility = if (data.isBlackMarketActive && data.isNewBlackMarketItems) View.VISIBLE else View.GONE
        binding.navViewDrawer.menu.findItem(R.id.achievements)?.isVisible = false
        binding.navViewDrawer.menu.findItem(R.id.cloud)?.isVisible = false
        binding.navViewDrawer.menu.findItem(R.id.reddit)?.isVisible = false

        val noQuests = data.kingsQuests.isEmpty() && data.afflictionQuests.isEmpty() &&
                data.controlQuests.isEmpty() && data.fortitudeQuests.isEmpty() &&
                data.graceQuests.isEmpty() && data.illusionQuests.isEmpty() &&
                data.knowledgeQuests.isEmpty() && data.ruinQuests.isEmpty() &&
                data.warQuests.isEmpty()

        binding.quests.visibility = if (data.isQuestsSeen) View.VISIBLE else View.GONE
        val notifVis = if (!noQuests && QuestsManager.QUEST_NOTIFICATION && data.isQuestsSeen) View.VISIBLE else View.GONE
        binding.questsNotification.visibility = notifVis
    }

    fun refreshRaidsFragmentVisibility() {
        if (RaidsFragment.VISIBLE) {
            return
        }
        var unlocked = false
        for (area in Utils.compileRaidList()) {
            if (area.isUnlocked) {
                unlocked = true
                break
            }
        }
        RaidsFragment.VISIBLE = unlocked
        binding.navView.menu.getItem(3)?.isVisible = unlocked
    }

    fun attachListeners() {
        binding.containerGems.setOnClickListener {
            if (shownDialogShop == null && (IAPWrapper?.initialized == true)) {
                DialogShop().show(supportFragmentManager, "shop")
            }
        }

        binding.menuButton.setOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navViewDrawer.menu.findItem(R.id.shop)?.setOnMenuItemClickListener {
            if (shownDialogShop == null) {
                DialogShop().show(supportFragmentManager, "shop")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.settings)?.setOnMenuItemClickListener {
            if (shownDialogSettings == null) {
                DialogSettings().show(supportFragmentManager, "dialog_settings")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.dismissed_adventurers)?.setOnMenuItemClickListener {
            if (shownDialogRecallAdventurers == null) {
                DialogRecallAdventurers().show(supportFragmentManager, "dialog_recall_adventurers")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.messages_received)?.setOnMenuItemClickListener {
            if (shownMessagesReceived == null) {
                DialogMessagesReceived().show(supportFragmentManager, "dialog_messages_received")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.faq)?.setOnMenuItemClickListener {
            if (shownDialogFaq == null) {
                DialogFaq().show(supportFragmentManager, "dialog_faq")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.bestiary)?.setOnMenuItemClickListener {
            if (shownDialogBestiary == null) {
                DialogBestiary().show(supportFragmentManager, "dialog_bestiary")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.achievements)?.setOnMenuItemClickListener {
            PlayGames.getAchievementsClient(this).achievementsIntent.addOnSuccessListener { intent ->
                startActivityForResult(intent, 9003)
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.cloud)?.setOnMenuItemClickListener {
            if (shownDialogCloud == null) {
                try {
                    PlayGames.getGamesSignInClient(this).isAuthenticated.addOnCompleteListener { task ->
                        if (task.isSuccessful && (task.result as? AuthenticationResult)?.isAuthenticated == true) {
                            try {
                                loadSavedGame()?.addOnCompleteListener { task2 ->
                                    val snapshotData = task2.result as? SnapshotData
                                    if (task2.isSuccessful && snapshotData != null) {
                                        val dialog = UIUtils.getActionDialog(
                                            this@MainActivity,
                                            R.string.drawer_cloud_title,
                                            String.format(getString(R.string.drawer_cloud_description), snapshotData.description),
                                            R.string.yes
                                        ) { _, _ ->
                                            SaveManager.inhibitSave = true
                                            FileManager.overwriteFile(applicationContext, String(snapshotData.data ?: ByteArray(0)))
                                            finish()
                                            System.exit(0)
                                        }
                                        shownDialogCloud = dialog
                                        dialog.setOnDismissListener { shownDialogCloud = null }
                                        dialog.show()
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                } catch (_: Exception) {
                    Toast.makeText(this, "Error signing into Play Services", Toast.LENGTH_LONG).show()
                }
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.redeem_code)?.setOnMenuItemClickListener {
            if (shownDialogRedeemCode == null) {
                DialogRedeemCode().show(supportFragmentManager, "dialog_redeem_code")
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.reddit)?.setOnMenuItemClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com/r/IdleGuildMaster/")))
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(this, R.string.drawer_toast_no_browser, Toast.LENGTH_LONG).show()
            }
            true
        }

        binding.navViewDrawer.menu.findItem(R.id.mod_about)?.setOnMenuItemClickListener {
            DialogModAbout.show(this)
            true
        }
        binding.navViewDrawer.menu.findItem(R.id.mod_changelog)?.setOnMenuItemClickListener {
            DialogModAbout.showChangelog(this)
            true
        }
        binding.navViewDrawer.menu.findItem(R.id.cafe_naver)?.setOnMenuItemClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/idleguildmaster/")))
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(this, R.string.drawer_toast_no_browser, Toast.LENGTH_LONG).show()
            }
            true
        }

        binding.kingMessage.setOnClickListener {
            if (data.messagesToShow.isNotEmpty()) {
                if (shownKingMessageDialog != null) return@setOnClickListener
                val kingMessage = data.messagesToShow[0]
                val dialog = UIUtils.getInfoDialog(
                    this,
                    kingMessage.title,
                    getString(kingMessage.body),
                    true
                )
                shownKingMessageDialog = dialog
                dialog.setOnDismissListener {
                    shownKingMessageDialog = null
                }
                dialog.show()
                data.messagesToShow.removeAt(0)
            }
            refreshKingMessages()
        }

        binding.merchant.setOnClickListener {
            if (shownDialogMerchant == null) {
                DialogMerchant().show(supportFragmentManager, "merchant")
            }
        }

        binding.blackMarket.setOnClickListener {
            if (shownDialogBlackMarket == null && data.isBlackMarketActive) {
                DialogBlackMarket().show(supportFragmentManager, "black_market")
            }
        }

        binding.ad.setOnClickListener {
            if (shownAdDialog != null) return@setOnClickListener
            val dialog = UIUtils.getActionDialog(
                this,
                R.string.ad_dialog_title,
                String.format(getString(R.string.ad_dialog_body), data.adsWatched),
                R.string.ad_dialog_confirm
            ) { _, _ ->
                val ad = rewardedAd ?: return@getActionDialog
                ad.show(this@MainActivity) {
                    val wasFour = data.adsWatched == 4
                    data.adsWatched++
                    data.gems += if (wasFour) 15 else 5
                    refreshGems()
                    refreshIcons()
                    if (wasFour) {
                        UIUtils.getInfoDialog(
                            this@MainActivity,
                            R.string.all_ads_watched_dialog_title,
                            getString(R.string.all_ads_watched_dialog_body),
                            false
                        ).show()
                    }
                }
                shownAdDialog?.dismiss()
            }
            shownAdDialog = dialog
            dialog.setOnDismissListener { shownAdDialog = null }
            dialog.show()
        }

        binding.adfree.setOnClickListener {
            if (shownAdFreeDialog != null) return@setOnClickListener
            val dialog = UIUtils.getActionDialog(
                this,
                R.string.ad_free_dialog_title,
                getString(R.string.ad_free_dialog_body),
                R.string.ad_free_dialog_confirm
            ) { _, _ ->
                shownAdFreeDialog?.dismiss()
            }
            shownAdFreeDialog = dialog
            dialog.setOnDismissListener {
                data.adsWatched = 5
                data.gems += 35
                refreshGems()
                refreshIcons()
                shownAdFreeDialog = null
            }
            dialog.show()
        }

        binding.shop.setOnClickListener {
            if (shownDialogShop == null) {
                DialogShop().show(supportFragmentManager, "shop")
            }
        }

        binding.quests.setOnClickListener {
            if (shownDialogQuests == null) {
                DialogQuests().show(supportFragmentManager, "quests")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (IAPWrapper?.initialized == true) {
            IAPWrapper?.queryAsync()
        }
        applicationPaused.value = false
        SaveManager.inhibitSave = false
        initializeThreads()
    }

    override fun onDestroy() {
        super.onDestroy()
        context = null
    }

    override fun onPause() {
        SaveManager.getInstance().stopTimerTask()
        SaveManager.getInstance().save(applicationContext)
        applicationPaused.value = true
        updaterUI?.let { handlerUI?.removeCallbacks(it) }
        handlerUI = null

        shownDialogIdleProgress?.dismiss()
        shownDialogIdleProgress = null

        shownDialogDungeonDetail?.dismiss()
        shownDialogDungeonDetail = null

        shownDialogPromotionChoices?.dismiss()
        shownDialogPromotionChoices = null

        super.onPause()
    }

    private fun initializeThreads() {
        // Offline idle is capped at 12 hours by vanilla purchases ("iMin"); the mod's
        // idleTimeCapHours override (12..168, 0 = unset) extends that cap when set.
        val idleCapHours = data.idleTimeCapHours
        val idleBonus = if (data.isIdleHoursPackPurchased) 6 else 0
        val vanillaCap = (Math.min(4, 4) + 8 + idleBonus) * Utils.ONE_HOUR_IN_SECONDS
        val iMin = if (idleCapHours in 12..168) idleCapHours * Utils.ONE_HOUR_IN_SECONDS else vanillaCap
        val lastAccess = data.lastAccess
        val jMillis = TrueTimeUtils.millis()
        val jMax = if (lastAccess != 0L) Math.max(1L, Math.min(iMin.toLong(), Math.round((jMillis - lastAccess) / 1000.0))) else 1L

        Utils.progressTavernTime(jMax)
        Utils.progressMarketTime(jMax)
        Utils.progressWorkshopTime(jMax)
        Utils.checkDismissedAdventurersExpiration(jMillis)

        var hasAdventurersExploring = false
        for (area in Utils.compileDungeonRaidList()) {
            if (area.adventurersExploringIds.isNotEmpty()) {
                hasAdventurersExploring = true
                break
            }
        }

        if (jMax > 60 && hasAdventurersExploring) {
            val dialog = DialogIdleProgress()
            shownDialogIdleProgress = dialog
            dialog.skipOnShowListener()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "dialog_idle_progress")
        }

        val mutableLong = MutableLong(0L)
        val j = jMax
        val thread = Thread {
            val list = Utils.compileDungeonRaidList()
            var i = 0
            while (true) {
                val j2 = i.toLong()
                if (j2 < j) {
                    if (applicationPaused.value) {
                        return@Thread
                    }
                    for (area in list) {
                        area.tick()
                    }
                    mutableLong.value++
                    data.lastAccess = jMillis - ((j - j2) * 1000)
                    i++
                } else {
                    IDLE_THREAD_FINISHED.value = true
                    SaveManager.getInstance().save(applicationContext)
                    return@Thread
                }
            }
        }
        updaterIdleProgress = thread
        thread.start()

        val mutableBoolean = MutableBoolean(true)
        val mutableBoolean2 = MutableBoolean(true)
        if (handlerUI == null) {
            handlerUI = Handler(Looper.getMainLooper())
            val j2 = jMax
            val thread2 = object : Runnable {
                override fun run() {
                    val ready = (headquartersFragment?.binding != null) &&
                            (dungeonsFragment?.binding != null) &&
                            (!RaidsFragment.VISIBLE || raidsFragment?.binding != null) &&
                            (adventurersFragment?.binding != null)

                    if (IDLE_THREAD_FINISHED.value && ready) {
                        if (mutableBoolean2.value) {
                            mutableBoolean2.value = false
                            onLoadingComplete()
                        }
                        Utils.nextTimeTick()
                        handlerUI?.postDelayed(this, if (mutableBoolean.value) 10L else 1000L)
                    } else {
                        shownDialogIdleProgress?.refreshProgress(((mutableLong.value * 100) / j2).toInt())
                        handlerUI?.postDelayed(this, 10L)
                    }
                    mutableBoolean.value = false
                }
            }
            updaterUI = Thread(thread2)
            handlerUI?.post(thread2)
        }
        SaveManager.getInstance().startTimer(applicationContext)
    }

    private fun onLoadingComplete() {
        headquartersFragment?.refresh()
        dungeonsFragment?.refresh()
        dungeonsFragment?.refreshDungeonVisibility()
        if (RaidsFragment.VISIBLE) {
            raidsFragment?.refresh()
            raidsFragment?.refreshRaidVisibility()
        }
        adventurersFragment?.refresh()
        refresh()
        refreshRaidsFragmentVisibility()
        shownDialogIdleProgress?.dismiss()
        shownDialogIdleProgress = null
        AchievementsUtils.flushQueue()
    }

    fun loadAd() {
        if (data.adsWatched >= 5) {
            rewardedAd = null
            refreshIcons()
            return
        }
        if (adRequest == null) {
            adRequest = AdRequest.Builder().build()
        }
        val request = adRequest ?: return
        RewardedAd.load(this, "ca-app-pub-4589624666705243/2778487135", request, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                rewardedAd = null
                refreshIcons()
                Handler(Looper.getMainLooper()).postDelayed({
                    loadAd()
                }, 60000L)
            }

            override fun onAdLoaded(ad: RewardedAd) {
                rewardedAd = ad
                ad.fullScreenContentCallback = adCallback
                refreshIcons()
            }
        })
    }

    fun loadSavedGame(): Task<SnapshotData>? {
        return try {
            PlayGames.getSnapshotsClient(this).open(SAVE_FILE_NAME, true, SnapshotsClient.RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED)
                .addOnFailureListener { }
                .continueWith { task ->
                    try {
                        val snapshot = (task.result as SnapshotsClient.DataOrConflict<*>).data as Snapshot
                        SnapshotData(snapshot.metadata.description, snapshot.snapshotContents.readFully())
                    } catch (e: Exception) {
                        e.printStackTrace()
                        null
                    }
                }
        } catch (_: Exception) {
            null
        }
    }

    private fun viewSaves() {
        PlayGames.getSnapshotsClient(this).getSelectSnapshotIntent("Saved Instance", true, true, 1)
            .addOnSuccessListener { intent ->
                startActivityForResult(intent, 9009)
            }
    }

    private fun retroactivelyUnlockHiddenCityOfLarox() {
        val area = data.hiddenCityOfLarox ?: return
        if ((data.barrenWastelands?.maxProgress ?: 0) < 100 || area.isUnlocked) {
            return
        }
        UIUtils.unlockArea(area)
    }

    private fun retroactivelyUnlockLostLands() {
        val area = data.lostLands ?: return
        if ((data.hiddenCityOfLarox?.maxProgress ?: 0) < 100 || area.isUnlocked) {
            return
        }
        UIUtils.unlockArea(area)
    }

    private fun retroactivelyUnlockTheLostExpedition() {
        val area = data.theLostExpedition ?: return
        if ((data.obsidianMines?.maxProgress ?: 0) < 220 || area.isUnlocked) {
            return
        }
        UIUtils.unlockArea(area)
    }

    private fun retroactivelyUnlockCelestialMothership() {
        val area = data.celestialMothership ?: return
        if ((data.barrenWastelands?.maxProgress ?: 0) < 180 || area.isUnlocked) {
            return
        }
        UIUtils.unlockArea(area)
    }

    private fun retroactivelyUnlockTheDireDescent() {
        val area = data.theDireDescent ?: return
        if ((data.lostLands?.maxProgress ?: 0) < 100 || area.isUnlocked) {
            return
        }
        UIUtils.unlockArea(area)
    }

    private fun retroactivelyGrantIntercession() {
        if (data.isIntercessionsRetroactivelyGranted) {
            return
        }
        data.isIntercessionsRetroactivelyGranted = true
        if (data.isImperialVanguardPurchased) {
            Utils.collectItem(Item.getInstance("Intercession", 1), data.items)
        }
        if (data.isUnholyCrusadePurchased) {
            Utils.collectItem(Item.getInstance("Intercession", 1), data.items)
        }
    }

    private fun retroactivelyGrantEvo23Vial2() {
        if (data.isVial2RetGrant) {
            return
        }
        data.isVial2RetGrant = true
        if (data.isAdventurerPackPurchased) {
            Utils.collectItem(Item.getInstance("Evo23Vial2", 1), data.items)
        }
    }

    private fun retroactivelyUnlockLast3() {
        if ((data.theDireDescent?.maxProgress ?: 0) >= 7) {
            val sp = data.sleepingPlanet
            if (sp != null && !sp.isUnlocked) {
                UIUtils.unlockArea(sp)
            }
            val k = data.kaunis
            if (k != null && !k.isUnlocked) {
                UIUtils.unlockArea(k)
            }
            val tt = data.theTower
            if (tt != null && !tt.isUnlocked) {
                UIUtils.unlockArea(tt)
            }
        }
    }

    private fun retroactivelySetSeenQuests() {
        if (data.kingsQuests.isEmpty() && data.afflictionQuests.isEmpty() &&
            data.controlQuests.isEmpty() && data.fortitudeQuests.isEmpty() &&
            data.graceQuests.isEmpty() && data.illusionQuests.isEmpty() &&
            data.knowledgeQuests.isEmpty() && data.ruinQuests.isEmpty() &&
            data.warQuests.isEmpty()) {
            return
        }
        data.isQuestsSeen = true
    }

    private fun retroactivelyAddKnownRecipes() {
        for (recipes in listOf(Recipes.VoltaicShock)) {
            for (ingredient in recipes.getIngredients()) {
                val tc = ingredient?.getTrueClass()
                if (tc != null && data.seenItems.contains(tc)) {
                    data.knownRecipes.add(recipes)
                    break
                }
            }
        }
    }

    fun testDataManipulation() {
        checkPrices()
    }

    fun checkPrices() {
        for (recipes in Recipes.values()) {
            var price = 0L
            for (item in recipes.getIngredients()) {
                if (item != null) {
                    price += item.getPrice() * item.getStack().toLong()
                }
            }
            val d = price.toDouble() * 1.5
            val jCeil = if (d % 0.5 == 0.0) Math.ceil(d).toLong() else Math.round(d)
            val result = recipes.getResult()
            if (result != null && jCeil != result.getPrice()) {
                println("Incorrect price for ${result.getTrueClass()}: expected $jCeil, found ${result.getPrice()}")
            }
        }
    }
}
