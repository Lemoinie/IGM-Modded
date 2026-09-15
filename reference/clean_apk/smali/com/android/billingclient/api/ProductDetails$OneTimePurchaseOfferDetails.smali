.class public final Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/ProductDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "OneTimePurchaseOfferDetails"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;,
        Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;,
        Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;,
        Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;,
        Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;
    }
.end annotation


# instance fields
.field private final zza:Ljava/lang/String;

.field private final zzb:J

.field private final zzc:Ljava/lang/String;

.field private final zzd:Ljava/lang/String;

.field private final zze:Ljava/lang/String;

.field private final zzf:Ljava/lang/String;

.field private final zzg:Ljava/util/List;

.field private final zzh:Ljava/lang/Long;

.field private final zzi:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;

.field private final zzj:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;

.field private final zzk:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;

.field private final zzl:Ljava/lang/String;

.field private final zzm:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;

.field private final zzn:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;

.field private final zzo:Lcom/android/billingclient/api/zzdv;


# direct methods
.method constructor <init>(Lorg/json/JSONObject;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "formattedPrice"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zza:Ljava/lang/String;

    const-string v0, "priceAmountMicros"

    .line 2
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzb:J

    const-string v0, "priceCurrencyCode"

    .line 3
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzc:Ljava/lang/String;

    const-string v0, "offerIdToken"

    .line 4
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-ne v3, v1, :cond_0

    move-object v0, v2

    :cond_0
    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzd:Ljava/lang/String;

    const-string v0, "offerId"

    .line 6
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 7
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-ne v3, v1, :cond_1

    move-object v0, v2

    :cond_1
    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zze:Ljava/lang/String;

    const-string v0, "purchaseOptionId"

    .line 8
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 9
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-ne v3, v1, :cond_2

    move-object v0, v2

    :cond_2
    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzf:Ljava/lang/String;

    const-string v0, "offerType"

    .line 10
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    const-string v0, "offerTags"

    .line 11
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    .line 12
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzg:Ljava/util/List;

    if-eqz v0, :cond_3

    const/4 v1, 0x0

    .line 13
    :goto_0
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v1, v3, :cond_3

    iget-object v3, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzg:Ljava/util/List;

    .line 14
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 15
    :cond_3
    const-string v0, "fullPriceMicros"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 16
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_1

    :cond_4
    move-object v0, v2

    :goto_1
    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzh:Ljava/lang/Long;

    const-string v0, "discountDisplayInfo"

    .line 17
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_5

    move-object v1, v2

    goto :goto_2

    .line 20
    :cond_5
    new-instance v1, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;

    .line 18
    invoke-direct {v1, v0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;-><init>(Lorg/json/JSONObject;)V

    .line 17
    :goto_2
    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzi:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;

    const-string v0, "validTimeWindow"

    .line 19
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_6

    move-object v1, v2

    goto :goto_3

    .line 22
    :cond_6
    new-instance v1, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;

    .line 20
    invoke-direct {v1, v0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;-><init>(Lorg/json/JSONObject;)V

    .line 19
    :goto_3
    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzj:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;

    const-string v0, "limitedQuantityInfo"

    .line 21
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_7

    move-object v1, v2

    goto :goto_4

    .line 25
    :cond_7
    new-instance v1, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;

    .line 22
    invoke-direct {v1, v0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;-><init>(Lorg/json/JSONObject;)V

    .line 21
    :goto_4
    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzk:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;

    const-string v0, "serializedDocid"

    .line 23
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzl:Ljava/lang/String;

    const-string v0, "preorderDetails"

    .line 24
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_8

    move-object v1, v2

    goto :goto_5

    .line 27
    :cond_8
    new-instance v1, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;

    .line 25
    invoke-direct {v1, v0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;-><init>(Lorg/json/JSONObject;)V

    .line 24
    :goto_5
    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzm:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;

    const-string v0, "rentalDetails"

    .line 26
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_9

    move-object v1, v2

    goto :goto_6

    .line 29
    :cond_9
    new-instance v1, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;

    .line 27
    invoke-direct {v1, v0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;-><init>(Lorg/json/JSONObject;)V

    .line 26
    :goto_6
    iput-object v1, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzn:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;

    const-string v0, "autoPayDetails"

    .line 28
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_a

    goto :goto_7

    .line 31
    :cond_a
    new-instance v2, Lcom/android/billingclient/api/zzdv;

    .line 29
    invoke-direct {v2, v0}, Lcom/android/billingclient/api/zzdv;-><init>(Lorg/json/JSONObject;)V

    .line 28
    :goto_7
    iput-object v2, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzo:Lcom/android/billingclient/api/zzdv;

    const-string v0, "pricingPhases"

    .line 30
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p1

    if-nez p1, :cond_b

    return-void

    :cond_b
    new-instance v0, Lcom/android/billingclient/api/ProductDetails$PricingPhases;

    .line 31
    invoke-direct {v0, p1}, Lcom/android/billingclient/api/ProductDetails$PricingPhases;-><init>(Lorg/json/JSONArray;)V

    return-void
.end method


# virtual methods
.method public getDiscountDisplayInfo()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzi:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$DiscountDisplayInfo;

    return-object v0
.end method

.method public getFormattedPrice()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zza:Ljava/lang/String;

    return-object v0
.end method

.method public getFullPriceMicros()Ljava/lang/Long;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzh:Ljava/lang/Long;

    return-object v0
.end method

.method public getLimitedQuantityInfo()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzk:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$LimitedQuantityInfo;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zze:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferTags()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzg:Ljava/util/List;

    return-object v0
.end method

.method public getOfferToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzd:Ljava/lang/String;

    return-object v0
.end method

.method public getPreorderDetails()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzm:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$PreorderDetails;

    return-object v0
.end method

.method public getPriceAmountMicros()J
    .locals 2

    iget-wide v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzb:J

    return-wide v0
.end method

.method public getPriceCurrencyCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzc:Ljava/lang/String;

    return-object v0
.end method

.method public getPurchaseOptionId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzf:Ljava/lang/String;

    return-object v0
.end method

.method public getRentalDetails()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzn:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$RentalDetails;

    return-object v0
.end method

.method public getValidTimeWindow()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzj:Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails$ValidTimeWindow;

    return-object v0
.end method

.method public final zza()Lcom/android/billingclient/api/zzdv;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzo:Lcom/android/billingclient/api/zzdv;

    return-object v0
.end method

.method final zzb()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->zzl:Ljava/lang/String;

    return-object v0
.end method
