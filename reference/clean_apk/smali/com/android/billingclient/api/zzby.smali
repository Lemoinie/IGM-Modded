.class final Lcom/android/billingclient/api/zzby;
.super Lcom/google/android/gms/internal/play_billing/zzy;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field final zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

.field final zzb:Lcom/android/billingclient/api/zzcz;

.field final zzc:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzy;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzby;->zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    iput-object p2, p0, Lcom/android/billingclient/api/zzby;->zzb:Lcom/android/billingclient/api/zzcz;

    iput p3, p0, Lcom/android/billingclient/api/zzby;->zzc:I

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

    const/16 v0, 0x18

    const/4 v1, 0x0

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaG:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 2
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-static {v2, v0, v3, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v2, p0, Lcom/android/billingclient/api/zzby;->zzc:I

    .line 1
    invoke-interface {p1, v0, v2}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    .line 4
    invoke-interface {p1, v3, v1}, Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;->onExternalOfferReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V

    return-void

    .line 5
    :cond_0
    const-string v2, "BillingClient"

    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v3

    .line 6
    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 7
    invoke-static {v3, v4}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    if-eqz v3, :cond_1

    new-instance p1, Ljava/lang/StringBuilder;

    const-string v5, "createExternalOfferReportingDetailsAsync() failed. Response code: "

    .line 8
    invoke-direct {p1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 9
    sget v3, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 10
    invoke-static {v2, v0, v4, v1, v3}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v2, p0, Lcom/android/billingclient/api/zzby;->zzc:I

    .line 11
    invoke-interface {p1, v0, v2}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    .line 12
    invoke-interface {p1, v4, v1}, Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;->onExternalOfferReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V

    return-void

    :cond_1
    const-string v3, "CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS"

    .line 13
    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    :try_start_0
    new-instance v3, Lcom/android/billingclient/api/ExternalOfferReportingDetails;

    .line 14
    invoke-direct {v3, p1}, Lcom/android/billingclient/api/ExternalOfferReportingDetails;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    .line 20
    invoke-interface {p1, v4, v3}, Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;->onExternalOfferReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V

    return-void

    :catch_0
    move-exception p1

    const-string v3, "Error when parsing invalid external offer reporting details. \n Exception: "

    .line 15
    invoke-static {v2, v3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaH:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 16
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 17
    invoke-static {v2, v0, v3, v1, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v2, p0, Lcom/android/billingclient/api/zzby;->zzc:I

    .line 18
    invoke-interface {p1, v0, v2}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzby;->zza:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    .line 19
    invoke-interface {p1, v3, v1}, Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;->onExternalOfferReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V

    return-void
.end method
