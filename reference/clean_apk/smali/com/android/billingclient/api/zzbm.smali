.class final Lcom/android/billingclient/api/zzbm;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Ljava/util/concurrent/Callable;


# instance fields
.field final synthetic zza:Lcom/android/billingclient/api/PurchasesResponseListener;

.field final synthetic zzb:Ljava/lang/String;

.field final synthetic zzc:Z

.field final synthetic zzd:Lcom/android/billingclient/api/BillingClientImpl;


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchasesResponseListener;Ljava/lang/String;Z)V
    .locals 0

    .line 1
    iput-object p2, p0, Lcom/android/billingclient/api/zzbm;->zza:Lcom/android/billingclient/api/PurchasesResponseListener;

    iput-object p3, p0, Lcom/android/billingclient/api/zzbm;->zzb:Ljava/lang/String;

    iput-boolean p4, p0, Lcom/android/billingclient/api/zzbm;->zzc:Z

    invoke-static {p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/android/billingclient/api/zzbm;->zzd:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final bridge synthetic call()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbm;->zzd:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzat(Lcom/android/billingclient/api/BillingClientImpl;J)Z

    move-result v1

    const/16 v2, 0x9

    if-nez v1, :cond_0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzbm;->zza:Lcom/android/billingclient/api/PurchasesResponseListener;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v1

    .line 4
    invoke-interface {v0, v3, v1}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/android/billingclient/api/zzbm;->zzb:Ljava/lang/String;

    .line 5
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v1, "BillingClient"

    const-string v3, "Please provide a valid product type."

    .line 6
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzX:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zze:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzbm;->zza:Lcom/android/billingclient/api/PurchasesResponseListener;

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v1

    .line 9
    invoke-interface {v0, v3, v1}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto :goto_0

    :cond_1
    iget-boolean v3, p0, Lcom/android/billingclient/api/zzbm;->zzc:Z

    .line 10
    invoke-static {v0, v1, v3, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzav(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;ZI)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzed;->zzb()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/android/billingclient/api/zzbm;->zza:Lcom/android/billingclient/api/PurchasesResponseListener;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzed;->zza()Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzed;->zzb()Ljava/util/List;

    move-result-object v0

    .line 11
    invoke-interface {v1, v2, v0}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/zzbm;->zza:Lcom/android/billingclient/api/PurchasesResponseListener;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzed;->zza()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    .line 12
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method
