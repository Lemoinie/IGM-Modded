.class final Lcom/android/billingclient/api/zzdq;
.super Lcom/google/android/gms/internal/play_billing/zzab;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field final zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

.field final zzb:Lcom/android/billingclient/api/zzcz;

.field final zzc:I


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/zzcz;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzab;-><init>()V

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/android/billingclient/api/zzdq;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdq;->zzb:Lcom/android/billingclient/api/zzcz;

    iput p3, p0, Lcom/android/billingclient/api/zzdq;->zzc:I

    return-void
.end method

.method private final zza(Lcom/android/billingclient/api/BillingResult;)V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzdq;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/billingclient/api/zzdq;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaR:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v2, Lcom/android/billingclient/api/zzdf;->zza:Lcom/android/billingclient/api/zzdf;

    .line 2
    invoke-virtual {v2}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v2

    iget v3, p0, Lcom/android/billingclient/api/zzdq;->zzc:I

    .line 1
    invoke-static {v1, p1, v0, v2, v3}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    return-void

    :cond_0
    const/4 v1, 0x0

    .line 3
    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method


# virtual methods
.method public final onDelegateToBackendResponse(Landroid/os/Bundle;)V
    .locals 10

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/zzdq;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaT:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/android/billingclient/api/zzdf;->zza:Lcom/android/billingclient/api/zzdf;

    .line 2
    invoke-virtual {v2}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v2

    iget v3, p0, Lcom/android/billingclient/api/zzdq;->zzc:I

    .line 1
    invoke-static {v0, v1, p1, v2, v3}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    .line 3
    invoke-direct {p0, v1}, Lcom/android/billingclient/api/zzdq;->zza(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    .line 4
    :cond_0
    sget-object v0, Lcom/android/billingclient/api/zzdf;->zza:Lcom/android/billingclient/api/zzdf;

    .line 5
    invoke-virtual {v0}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzdq;->zzb:Lcom/android/billingclient/api/zzcz;

    iget v2, p0, Lcom/android/billingclient/api/zzdq;->zzc:I

    .line 6
    const-string v3, "GetBillingConfigDelegateToBackendCallback"

    invoke-static {p1, v3, v0, v1, v2}, Lcom/android/billingclient/api/zzdh;->zza(Landroid/os/Bundle;Ljava/lang/String;ILcom/android/billingclient/api/zzcz;I)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    if-nez v1, :cond_2

    :try_start_0
    const-string v1, "RESPONSE_DATA"

    .line 7
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getByteArray(Ljava/lang/String;)[B

    move-result-object p1

    if-eqz p1, :cond_1

    .line 9
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzdx;->zzb([B)Lcom/google/android/gms/internal/play_billing/zzdx;

    move-result-object p1

    .line 10
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzdx;->zzc()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/android/billingclient/api/BillingConfig;->forCountryCode(Ljava/lang/String;)Lcom/android/billingclient/api/BillingConfig;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    iget-object v1, p0, Lcom/android/billingclient/api/zzdq;->zza:Lcom/android/billingclient/api/BillingConfigResponseListener;

    .line 16
    invoke-interface {v1, v0, p1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    .line 7
    :cond_1
    :try_start_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Response data is null"

    .line 8
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    :catch_0
    move-exception p1

    .line 17
    const-string v0, "Got a JSON exception trying to decode BillingConfig. \n Exception: "

    .line 11
    invoke-static {v3, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v6, p0, Lcom/android/billingclient/api/zzdq;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaS:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 12
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/android/billingclient/api/zzdf;->zza:Lcom/android/billingclient/api/zzdf;

    .line 13
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v7

    iget v8, p0, Lcom/android/billingclient/api/zzdq;->zzc:I

    .line 14
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v9

    move-object v5, v0

    .line 12
    invoke-static/range {v4 .. v9}, Lcom/android/billingclient/api/zzde;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;IILjava/lang/String;)V

    .line 15
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/zzdq;->zza(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    .line 17
    :cond_2
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/zzdq;->zza(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method
