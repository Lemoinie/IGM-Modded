package it.paranoidsquirrels.idleguildmaster;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class IAPWrapper {
    public static final String ID_1200_GEMS = "gems_1200";
    public static final String ID_250_GEMS = "gems_250";
    public static final String ID_3300_GEMS = "gems_3300";
    public static final String ID_550_GEMS = "gems_550";
    public static final String ID_ADVENTURER_PACK = "adventurer_pack";
    public static final String ID_IMPERIAL_VANGUARD = "imperial_vanguard";
    public static final String ID_MERCHANT_PACK = "merchant_pack";
    public static final String ID_STARTER_PACK = "starter_pack";
    public static final String ID_UNHOLY_CRUSADE = "unholy_crusade";
    private final BillingClient billingClient;
    private List<ProductDetails> productDetails;
    private Runnable refreshAdventurersCallback;
    private Runnable refreshGemsCallback;
    private Runnable refreshHeadquartersCallback;
    private Runnable refreshIconsCallback;
    private Runnable refreshShopCallback;
    public boolean initialized = false;
    private List<QueryProductDetailsParams.Product> products = Arrays.asList(buildProduct(ID_250_GEMS), buildProduct(ID_550_GEMS), buildProduct(ID_1200_GEMS), buildProduct(ID_3300_GEMS), buildProduct(ID_STARTER_PACK), buildProduct(ID_ADVENTURER_PACK), buildProduct(ID_MERCHANT_PACK), buildProduct(ID_IMPERIAL_VANGUARD), buildProduct(ID_UNHOLY_CRUSADE));
    private long reconnectMillis = 10;

    static /* synthetic */ long access$030(IAPWrapper iAPWrapper, long j) {
        long j2 = iAPWrapper.reconnectMillis * j;
        iAPWrapper.reconnectMillis = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePurchase(BillingResult billingResult, List<Purchase> list) {
        if (billingResult.getResponseCode() != 0 || list == null) {
            return;
        }
        for (Purchase purchase : list) {
            if (purchase.getPurchaseState() == 1) {
                for (String str : purchase.getProducts()) {
                    str.hashCode();
                    switch (str) {
                        case "gems_1200":
                            handleGemsPurchase(purchase, 1200);
                            break;
                        case "gems_3300":
                            handleGemsPurchase(purchase, 2000);
                            break;
                        case "gems_250":
                            handleGemsPurchase(purchase, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                            break;
                        case "gems_550":
                            handleGemsPurchase(purchase, 550);
                            break;
                        default:
                            handlePackPurchase(purchase, str);
                            break;
                    }
                }
            }
        }
    }

    private void handleGemsPurchase(Purchase purchase, final int i) {
        this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new ConsumeResponseListener() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda1
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                IAPWrapper.this.m170x51de2fea(i, billingResult, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleGemsPurchase$0$it-paranoidsquirrels-idleguildmaster-IAPWrapper, reason: not valid java name */
    /* synthetic */ void m170x51de2fea(int i, BillingResult billingResult, String str) {
        if (billingResult.getResponseCode() == 0) {
            MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
            long j = i;
            MainActivity.data.setGems(MainActivity.data.getGems() + j);
            MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + j);
            run(this.refreshGemsCallback);
            run(this.refreshShopCallback);
        }
    }

    private void handlePackPurchase(Purchase purchase, final String str) {
        if (purchase.isAcknowledged()) {
            return;
        }
        this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new AcknowledgePurchaseResponseListener() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda4
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                IAPWrapper.this.m171xdbeedcc0(str, billingResult);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handlePackPurchase$1$it-paranoidsquirrels-idleguildmaster-IAPWrapper, reason: not valid java name */
    /* synthetic */ void m171xdbeedcc0(String str, BillingResult billingResult) {
        str.hashCode();
        switch (str) {
            case "adventurer_pack":
                if (!MainActivity.data.isAdventurerPackPurchased()) {
                    MainActivity.data.setAdventurerPackPurchased(true);
                    Utils.collectItem(Item.getInstance("Dreamcatcher", 4), MainActivity.data.getItems());
                    Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.getItems());
                    MainActivity.data.setGems(MainActivity.data.getGems() + 1000);
                    MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + 1000);
                    MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
                    break;
                }
                            case "imperial_vanguard":
                if (!MainActivity.data.isImperialVanguardPurchased()) {
                    MainActivity.data.setImperialVanguardPurchased(true);
                    Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
                    MainActivity.data.setGems(MainActivity.data.getGems() + 2000);
                    MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + 2000);
                    MainActivity.data.getAdventurers().add(DialogShop.imperialVanguard1);
                    MainActivity.data.getAdventurers().add(DialogShop.imperialVanguard2);
                    MainActivity.data.getAdventurers().add(DialogShop.imperialVanguard3);
                    MainActivity.data.getAdventurers().add(DialogShop.imperialVanguard4);
                    MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
                    Utils.triggerGuildSizeAchievementCheck();
                    run(this.refreshAdventurersCallback);
                    break;
                }
                            case "starter_pack":
                if (!MainActivity.data.isStarterPackPurchased()) {
                    MainActivity.data.setStarterPackPurchased(true);
                    MainActivity.data.setGems(MainActivity.data.getGems() + 500);
                    MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + 500);
                    MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
                    run(this.refreshIconsCallback);
                    break;
                }
                            case "unholy_crusade":
                if (!MainActivity.data.isUnholyCrusadePurchased()) {
                    MainActivity.data.setUnholyCrusadePurchased(true);
                    Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
                    MainActivity.data.setGems(MainActivity.data.getGems() + 2000);
                    MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + 2000);
                    MainActivity.data.getAdventurers().add(DialogShop.unholyCrusade1);
                    MainActivity.data.getAdventurers().add(DialogShop.unholyCrusade2);
                    MainActivity.data.getAdventurers().add(DialogShop.unholyCrusade3);
                    MainActivity.data.getAdventurers().add(DialogShop.unholyCrusade4);
                    MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
                    Utils.triggerGuildSizeAchievementCheck();
                    run(this.refreshAdventurersCallback);
                    break;
                }
                            case "merchant_pack":
                if (!MainActivity.data.isMerchantPackPurchased()) {
                    MainActivity.data.setMerchantPackPurchased(true);
                    MainActivity.data.setGems(MainActivity.data.getGems() + 1000);
                    MainActivity.data.setTotalGemsPurchased(MainActivity.data.getTotalGemsPurchased() + 1000);
                    MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + 1);
                    break;
                }
                        }
        run(this.refreshGemsCallback);
        run(this.refreshHeadquartersCallback);
        run(this.refreshShopCallback);
    }

    private QueryProductDetailsParams.Product buildProduct(String str) {
        return QueryProductDetailsParams.Product.newBuilder().setProductId(str).setProductType(BillingClient.ProductType.INAPP).build();
    }

    public IAPWrapper(Context context) {
        this.billingClient = BillingClient.newBuilder(context).setListener(new PurchasesUpdatedListener() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda6
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                IAPWrapper.this.handlePurchase(billingResult, list);
            }
        }).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        startBillingClientConnection();
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.IAPWrapper$1, reason: invalid class name */
    class AnonymousClass1 implements BillingClientStateListener {
        AnonymousClass1() {
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            if (billingResult.getResponseCode() == 0) {
                IAPWrapper.this.reconnectMillis = 10L;
                IAPWrapper.this.queryProducts();
                IAPWrapper.this.queryAsync();
            }
        }

        /* JADX INFO: renamed from: lambda$onBillingServiceDisconnected$0$it-paranoidsquirrels-idleguildmaster-IAPWrapper$1, reason: not valid java name */
        /* synthetic */ void m174xeadd961e() {
            IAPWrapper.this.startBillingClientConnection();
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IAPWrapper.this.startBillingClientConnection();
                }
            }, IAPWrapper.this.reconnectMillis);
            IAPWrapper.access$030(IAPWrapper.this, 2L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBillingClientConnection() {
        this.billingClient.startConnection(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryProducts() {
        this.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(this.products).build(), new ProductDetailsResponseListener() {
            @Override
            public final void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                IAPWrapper.this.m172xf5109e71(billingResult, list);
            }
        });
    }

    /* synthetic */ void m172xf5109e71(BillingResult billingResult, List<ProductDetails> list) {
        if (billingResult.getResponseCode() == 0 && list != null && !list.isEmpty()) {
            this.productDetails = list;
            this.initialized = true;
            run(this.refreshIconsCallback);
            return;
        }
        this.initialized = false;
    }

    public void queryAsync() {
        this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(), new PurchasesResponseListener() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda5
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                IAPWrapper.this.handlePurchase(billingResult, list);
            }
        });
    }

    public ProductDetails getProductDetails(String str) {
        List<ProductDetails> list = this.productDetails;
        if (list == null) {
            return null;
        }
        for (ProductDetails productDetails : list) {
            if (str.equals(productDetails.getProductId())) {
                return productDetails;
            }
        }
        return null;
    }

    public void purchaseFlow(ProductDetails productDetails, Activity activity) {
        this.billingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(Arrays.asList(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build())).build());
    }

    public void restorePurchases() {
        this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(), new PurchasesResponseListener() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda7
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                IAPWrapper.this.m173x41143a6(billingResult, list);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$restorePurchases$5$it-paranoidsquirrels-idleguildmaster-IAPWrapper, reason: not valid java name */
    /* synthetic */ void m173x41143a6(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() != 0 || list == null) {
            return;
        }
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            for (String str : ((Purchase) it2.next()).getProducts()) {
                str.hashCode();
                switch (str) {
                    case "adventurer_pack":
                        if (!MainActivity.data.isAdventurerPackPurchased()) {
                            MainActivity.data.setAdventurerPackPurchased(true);
                            Utils.collectItem(Item.getInstance("Dreamcatcher", 4), MainActivity.data.getItems());
                            Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.getItems());
                            MainActivity.data.setGems(MainActivity.data.getGems() + 1000);
                            i++;
                        }
                        break;
                    case "imperial_vanguard":
                        if (!MainActivity.data.isImperialVanguardPurchased()) {
                            i++;
                            MainActivity.data.setImperialVanguardPurchased(true);
                            Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
                            MainActivity.data.setGems(MainActivity.data.getGems() + 2000);
                        }
                        ArrayList arrayList = new ArrayList(Arrays.asList(DialogShop.imperialVanguard1, DialogShop.imperialVanguard2, DialogShop.imperialVanguard3, DialogShop.imperialVanguard4));
                        final ArrayList arrayList2 = new ArrayList();
                        ArrayList<Adventurer> arrayList3 = new ArrayList();
                        arrayList3.addAll(MainActivity.data.getAdventurers());
                        arrayList3.addAll(MainActivity.data.getDismissedAdventurers());
                        for (Adventurer adventurer : arrayList3) {
                            if (adventurer.getId() <= 0) {
                                arrayList2.add(Integer.valueOf(adventurer.getId()));
                            }
                        }
                        arrayList.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda2
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return arrayList2.contains(Integer.valueOf(((Adventurer) obj).getId()));
                            }
                        });
                        MainActivity.data.getAdventurers().addAll(arrayList);
                        Utils.triggerGuildSizeAchievementCheck();
                        run(this.refreshAdventurersCallback);
                        break;
                    case "starter_pack":
                        if (!MainActivity.data.isStarterPackPurchased()) {
                            MainActivity.data.setStarterPackPurchased(true);
                            MainActivity.data.setGems(MainActivity.data.getGems() + 500);
                            i++;
                        }
                        break;
                    case "unholy_crusade":
                        if (!MainActivity.data.isUnholyCrusadePurchased()) {
                            i++;
                            MainActivity.data.setUnholyCrusadePurchased(true);
                            Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
                            MainActivity.data.setGems(MainActivity.data.getGems() + 2000);
                        }
                        ArrayList arrayList4 = new ArrayList(Arrays.asList(DialogShop.unholyCrusade1, DialogShop.unholyCrusade2, DialogShop.unholyCrusade3, DialogShop.unholyCrusade4));
                        final ArrayList arrayList5 = new ArrayList();
                        ArrayList<Adventurer> arrayList6 = new ArrayList();
                        arrayList6.addAll(MainActivity.data.getAdventurers());
                        arrayList6.addAll(MainActivity.data.getDismissedAdventurers());
                        for (Adventurer adventurer2 : arrayList6) {
                            if (adventurer2.getId() <= 0) {
                                arrayList5.add(Integer.valueOf(adventurer2.getId()));
                            }
                        }
                        arrayList4.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.IAPWrapper$$ExternalSyntheticLambda3
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return arrayList5.contains(Integer.valueOf(((Adventurer) obj).getId()));
                            }
                        });
                        MainActivity.data.getAdventurers().addAll(arrayList4);
                        Utils.triggerGuildSizeAchievementCheck();
                        run(this.refreshAdventurersCallback);
                        break;
                    case "merchant_pack":
                        if (!MainActivity.data.isMerchantPackPurchased()) {
                            MainActivity.data.setMerchantPackPurchased(true);
                            MainActivity.data.setGems(MainActivity.data.getGems() + 1000);
                            i++;
                        }
                        break;
                }
            }
        }
        MainActivity.data.setAmountOfPurchases(MainActivity.data.getAmountOfPurchases() + i);
        run(this.refreshGemsCallback);
        run(this.refreshHeadquartersCallback);
        run(this.refreshShopCallback);
    }

    public void setRefreshGemsCallback(Runnable runnable) {
        this.refreshGemsCallback = runnable;
    }

    public void setRefreshHeadquartersCallback(Runnable runnable) {
        this.refreshHeadquartersCallback = runnable;
    }

    public void setRefreshAdventurersCallback(Runnable runnable) {
        this.refreshAdventurersCallback = runnable;
    }

    public void setRefreshIconsCallback(Runnable runnable) {
        this.refreshIconsCallback = runnable;
    }

    public void setRefreshShopCallback(Runnable runnable) {
        this.refreshShopCallback = runnable;
    }

    private void run(Runnable runnable) {
        ((MainActivity) MainActivity.dungeonsFragment.getActivity()).runOnUiThread(runnable);
    }
}
