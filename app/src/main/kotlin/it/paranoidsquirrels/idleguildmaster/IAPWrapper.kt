package it.paranoidsquirrels.idleguildmaster

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.ItemTouchHelper
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ConsumeParams
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop
import java.util.ArrayList

class IAPWrapper(context: Context) {
    companion object {
        const val ID_1200_GEMS = "gems_1200"
        const val ID_250_GEMS = "gems_250"
        const val ID_3300_GEMS = "gems_3300"
        const val ID_550_GEMS = "gems_550"
        const val ID_ADVENTURER_PACK = "adventurer_pack"
        const val ID_IMPERIAL_VANGUARD = "imperial_vanguard"
        const val ID_MERCHANT_PACK = "merchant_pack"
        const val ID_STARTER_PACK = "starter_pack"
        const val ID_UNHOLY_CRUSADE = "unholy_crusade"
    }

    private val billingClient: BillingClient
    private var productDetails: List<ProductDetails>? = null
    private var refreshAdventurersCallback: Runnable? = null
    private var refreshGemsCallback: Runnable? = null
    private var refreshHeadquartersCallback: Runnable? = null
    private var refreshIconsCallback: Runnable? = null
    private var refreshShopCallback: Runnable? = null

    @JvmField
    var initialized: Boolean = false

    private val products: List<QueryProductDetailsParams.Product> = listOf(
        buildProduct(ID_250_GEMS),
        buildProduct(ID_550_GEMS),
        buildProduct(ID_1200_GEMS),
        buildProduct(ID_3300_GEMS),
        buildProduct(ID_STARTER_PACK),
        buildProduct(ID_ADVENTURER_PACK),
        buildProduct(ID_MERCHANT_PACK),
        buildProduct(ID_IMPERIAL_VANGUARD),
        buildProduct(ID_UNHOLY_CRUSADE)
    )
    private var reconnectMillis: Long = 10

    init {
        billingClient = BillingClient.newBuilder(context)
            .setListener { billingResult, list ->
                handlePurchase(billingResult, list)
            }
            .enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build())
            .build()
        startBillingClientConnection()
    }

    private fun buildProduct(str: String): QueryProductDetailsParams.Product {
        return QueryProductDetailsParams.Product.newBuilder()
            .setProductId(str)
            .setProductType(BillingClient.ProductType.INAPP)
            .build()
    }

    private fun startBillingClientConnection() {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == 0) {
                    reconnectMillis = 10L
                    queryProducts()
                    queryAsync()
                }
            }

            override fun onBillingServiceDisconnected() {
                Handler(Looper.getMainLooper()).postDelayed({
                    startBillingClientConnection()
                }, reconnectMillis)
                reconnectMillis *= 2L
            }
        })
    }

    private fun queryProducts() {
        billingClient.queryProductDetailsAsync(
            QueryProductDetailsParams.newBuilder().setProductList(products).build()
        ) { billingResult, list ->
            if (billingResult.responseCode == 0 && !list.isNullOrEmpty()) {
                productDetails = list
                initialized = true
                run(refreshIconsCallback)
            } else {
                initialized = false
            }
        }
    }

    fun queryAsync() {
        billingClient.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build()
        ) { billingResult, list ->
            handlePurchase(billingResult, list)
        }
    }

    private fun handlePurchase(billingResult: BillingResult, list: List<Purchase>?) {
        if (billingResult.responseCode != 0 || list == null) {
            return
        }
        for (purchase in list) {
            if (purchase.purchaseState == 1) {
                for (str in purchase.products) {
                    when (str) {
                        "gems_1200" -> handleGemsPurchase(purchase, 1200)
                        "gems_3300" -> handleGemsPurchase(purchase, 2000)
                        "gems_250" -> handleGemsPurchase(purchase, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)
                        "gems_550" -> handleGemsPurchase(purchase, 550)
                        else -> handlePackPurchase(purchase, str)
                    }
                }
            }
        }
    }

    private fun handleGemsPurchase(purchase: Purchase, i: Int) {
        billingClient.consumeAsync(
            ConsumeParams.newBuilder().setPurchaseToken(purchase.purchaseToken).build()
        ) { billingResult, _ ->
            if (billingResult.responseCode == 0) {
                MainActivity.data.amountOfPurchases += 1
                val j = i.toLong()
                MainActivity.data.gems += j
                MainActivity.data.totalGemsPurchased += j
                run(refreshGemsCallback)
                run(refreshShopCallback)
            }
        }
    }

    private fun handlePackPurchase(purchase: Purchase, str: String) {
        if (purchase.isAcknowledged) {
            return
        }
        billingClient.acknowledgePurchase(
            AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.purchaseToken).build()
        ) {
            when (str) {
                "adventurer_pack" -> {
                    if (!MainActivity.data.isAdventurerPackPurchased) {
                        MainActivity.data.isAdventurerPackPurchased = true
                        Utils.collectItem(Item.getInstance("Dreamcatcher", 4), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.items)
                        MainActivity.data.gems += 1000
                        MainActivity.data.totalGemsPurchased += 1000
                        MainActivity.data.amountOfPurchases += 1
                    }
                }
                "imperial_vanguard" -> {
                    if (!MainActivity.data.isImperialVanguardPurchased) {
                        MainActivity.data.isImperialVanguardPurchased = true
                        Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                        MainActivity.data.gems += 2000
                        MainActivity.data.totalGemsPurchased += 2000
                        MainActivity.data.adventurers.add(DialogShop.imperialVanguard1)
                        MainActivity.data.adventurers.add(DialogShop.imperialVanguard2)
                        MainActivity.data.adventurers.add(DialogShop.imperialVanguard3)
                        MainActivity.data.adventurers.add(DialogShop.imperialVanguard4)
                        MainActivity.data.amountOfPurchases += 1
                        Utils.triggerGuildSizeAchievementCheck()
                        run(refreshAdventurersCallback)
                    }
                }
                "starter_pack" -> {
                    if (!MainActivity.data.isStarterPackPurchased) {
                        MainActivity.data.isStarterPackPurchased = true
                        MainActivity.data.gems += 500
                        MainActivity.data.totalGemsPurchased += 500
                        MainActivity.data.amountOfPurchases += 1
                        run(refreshIconsCallback)
                    }
                }
                "unholy_crusade" -> {
                    if (!MainActivity.data.isUnholyCrusadePurchased) {
                        MainActivity.data.isUnholyCrusadePurchased = true
                        Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                        MainActivity.data.gems += 2000
                        MainActivity.data.totalGemsPurchased += 2000
                        MainActivity.data.adventurers.add(DialogShop.unholyCrusade1)
                        MainActivity.data.adventurers.add(DialogShop.unholyCrusade2)
                        MainActivity.data.adventurers.add(DialogShop.unholyCrusade3)
                        MainActivity.data.adventurers.add(DialogShop.unholyCrusade4)
                        MainActivity.data.amountOfPurchases += 1
                        Utils.triggerGuildSizeAchievementCheck()
                        run(refreshAdventurersCallback)
                    }
                }
                "merchant_pack" -> {
                    if (!MainActivity.data.isMerchantPackPurchased) {
                        MainActivity.data.isMerchantPackPurchased = true
                        MainActivity.data.gems += 1000
                        MainActivity.data.totalGemsPurchased += 1000
                        MainActivity.data.amountOfPurchases += 1
                    }
                }
            }
            run(refreshGemsCallback)
            run(refreshHeadquartersCallback)
            run(refreshShopCallback)
        }
    }

    fun getProductDetails(str: String): ProductDetails? {
        val list = productDetails ?: return null
        for (pd in list) {
            if (str == pd.productId) {
                return pd
            }
        }
        return null
    }

    fun purchaseFlow(productDetails: ProductDetails, activity: Activity) {
        billingClient.launchBillingFlow(
            activity,
            BillingFlowParams.newBuilder().setProductDetailsParamsList(
                listOf(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build())
            ).build()
        )
    }

    fun restorePurchases() {
        billingClient.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build()
        ) { billingResult, list ->
            if (billingResult.responseCode != 0 || list == null) {
                return@queryPurchasesAsync
            }
            var i = 0
            for (purchase in list) {
                for (str in purchase.products) {
                    when (str) {
                        "adventurer_pack" -> {
                            if (!MainActivity.data.isAdventurerPackPurchased) {
                                MainActivity.data.isAdventurerPackPurchased = true
                                Utils.collectItem(Item.getInstance("Dreamcatcher", 4), MainActivity.data.items)
                                Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.items)
                                MainActivity.data.gems += 1000
                                i++
                            }
                        }
                        "imperial_vanguard" -> {
                            if (!MainActivity.data.isImperialVanguardPurchased) {
                                i++
                                MainActivity.data.isImperialVanguardPurchased = true
                                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                                MainActivity.data.gems += 2000
                            }
                            val arrayList = arrayListOf(DialogShop.imperialVanguard1, DialogShop.imperialVanguard2, DialogShop.imperialVanguard3, DialogShop.imperialVanguard4)
                            val arrayList2 = ArrayList<Int>()
                            val arrayList3 = ArrayList<Adventurer>()
                            arrayList3.addAll(MainActivity.data.adventurers)
                            arrayList3.addAll(MainActivity.data.dismissedAdventurers)
                            for (adventurer in arrayList3) {
                                if (adventurer.id <= 0) {
                                    arrayList2.add(adventurer.id)
                                }
                            }
                            arrayList.removeAll { arrayList2.contains(it.id) }
                            MainActivity.data.adventurers.addAll(arrayList)
                            Utils.triggerGuildSizeAchievementCheck()
                            run(refreshAdventurersCallback)
                        }
                        "starter_pack" -> {
                            if (!MainActivity.data.isStarterPackPurchased) {
                                MainActivity.data.isStarterPackPurchased = true
                                MainActivity.data.gems += 500
                                i++
                            }
                        }
                        "unholy_crusade" -> {
                            if (!MainActivity.data.isUnholyCrusadePurchased) {
                                i++
                                MainActivity.data.isUnholyCrusadePurchased = true
                                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)
                                MainActivity.data.gems += 2000
                            }
                            val arrayList4 = arrayListOf(DialogShop.unholyCrusade1, DialogShop.unholyCrusade2, DialogShop.unholyCrusade3, DialogShop.unholyCrusade4)
                            val arrayList5 = ArrayList<Int>()
                            val arrayList6 = ArrayList<Adventurer>()
                            arrayList6.addAll(MainActivity.data.adventurers)
                            arrayList6.addAll(MainActivity.data.dismissedAdventurers)
                            for (adventurer2 in arrayList6) {
                                if (adventurer2.id <= 0) {
                                    arrayList5.add(adventurer2.id)
                                }
                            }
                            arrayList4.removeAll { arrayList5.contains(it.id) }
                            MainActivity.data.adventurers.addAll(arrayList4)
                            Utils.triggerGuildSizeAchievementCheck()
                            run(refreshAdventurersCallback)
                        }
                        "merchant_pack" -> {
                            if (!MainActivity.data.isMerchantPackPurchased) {
                                MainActivity.data.isMerchantPackPurchased = true
                                MainActivity.data.gems += 1000
                                i++
                            }
                        }
                    }
                }
            }
            MainActivity.data.amountOfPurchases += i
            run(refreshGemsCallback)
            run(refreshHeadquartersCallback)
            run(refreshShopCallback)
        }
    }

    fun setRefreshGemsCallback(runnable: Runnable?) {
        this.refreshGemsCallback = runnable
    }

    fun setRefreshHeadquartersCallback(runnable: Runnable?) {
        this.refreshHeadquartersCallback = runnable
    }

    fun setRefreshAdventurersCallback(runnable: Runnable?) {
        this.refreshAdventurersCallback = runnable
    }

    fun setRefreshIconsCallback(runnable: Runnable?) {
        this.refreshIconsCallback = runnable
    }

    fun setRefreshShopCallback(runnable: Runnable?) {
        this.refreshShopCallback = runnable
    }

    private fun run(runnable: Runnable?) {
        if (runnable == null) return
        (MainActivity.dungeonsFragment?.activity as? MainActivity)?.runOnUiThread(runnable)
    }
}
