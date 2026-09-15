.class final Lcom/android/billingclient/api/zzca;
.super Lcom/google/android/gms/internal/play_billing/zzaf;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field final zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

.field final zzb:Lcom/android/billingclient/api/zzcz;

.field final zzc:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzaf;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    iput-object p2, p0, Lcom/android/billingclient/api/zzca;->zzb:Lcom/android/billingclient/api/zzcz;

    iput p3, p0, Lcom/android/billingclient/api/zzca;->zzc:I

    return-void
.end method


# virtual methods
.method public final zza(Landroid/os/Bundle;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    const/16 v0, 0xd

    const/4 v1, 0x0

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/zzca;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzak:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 2
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-static {v2, v0, v3, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v2, p0, Lcom/android/billingclient/api/zzca;->zzc:I

    .line 1
    invoke-interface {p1, v0, v2}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 4
    invoke-interface {p1, v3, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    .line 5
    :cond_0
    const-string v2, "BillingClient"

    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v3

    .line 6
    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object v5

    .line 7
    invoke-virtual {v5, v3}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    invoke-virtual {v5, v4}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    if-eqz v3, :cond_1

    new-instance p1, Ljava/lang/StringBuilder;

    const-string v4, "getBillingConfig() failed. Response code: "

    .line 8
    invoke-direct {p1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 9
    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v2, p0, Lcom/android/billingclient/api/zzca;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 10
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 11
    invoke-static {v3, v0, p1, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v3, p0, Lcom/android/billingclient/api/zzca;->zzc:I

    .line 12
    invoke-interface {v2, v0, v3}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 13
    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    .line 14
    :cond_1
    const-string v3, "BILLING_CONFIG"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    const-string p1, "getBillingConfig() returned a bundle with neither an error nor a billing config response"

    .line 15
    invoke-static {v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    const/4 p1, 0x6

    .line 16
    invoke-virtual {v5, p1}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v2, p0, Lcom/android/billingclient/api/zzca;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzal:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 17
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 18
    invoke-static {v3, v0, p1, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v3, p0, Lcom/android/billingclient/api/zzca;->zzc:I

    .line 19
    invoke-interface {v2, v0, v3}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 20
    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    .line 21
    :cond_2
    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    :try_start_0
    new-instance v3, Lcom/android/billingclient/api/BillingConfig;

    .line 22
    invoke-direct {v3, p1}, Lcom/android/billingclient/api/BillingConfig;-><init>(Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 23
    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    invoke-interface {p1, v4, v3}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    const-string v3, "Got a JSON exception trying to decode BillingConfig. \n Exception: "

    .line 24
    invoke-static {v2, v3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzca;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzam:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 25
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 26
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 27
    invoke-static {v2, v0, v3, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v2, p0, Lcom/android/billingclient/api/zzca;->zzc:I

    .line 25
    invoke-interface {p1, v0, v2}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzca;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 28
    invoke-interface {p1, v3, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method
