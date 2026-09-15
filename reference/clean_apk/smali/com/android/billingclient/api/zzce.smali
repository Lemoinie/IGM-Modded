.class final Lcom/android/billingclient/api/zzce;
.super Lcom/google/android/gms/internal/play_billing/zzal;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field final zza:Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;

.field final zzb:Lcom/android/billingclient/api/zzcz;

.field final zzc:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzal;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzce;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;

    iput-object p2, p0, Lcom/android/billingclient/api/zzce;->zzb:Lcom/android/billingclient/api/zzcz;

    iput p3, p0, Lcom/android/billingclient/api/zzce;->zzc:I

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

    const/4 v0, 0x0

    const/16 v1, 0xe

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/zzce;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzao:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 2
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-static {v2, v1, v3, v0, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v1, p0, Lcom/android/billingclient/api/zzce;->zzc:I

    .line 1
    invoke-interface {p1, v0, v1}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzce;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;

    .line 4
    invoke-interface {p1, v3}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    .line 5
    :cond_0
    const-string v2, "BillingClient"

    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v3

    .line 6
    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 7
    invoke-static {v3, p1}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    if-eqz v3, :cond_1

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "isAlternativeBillingOnlyAvailableAsync() failed. Response code: "

    .line 8
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/android/billingclient/api/zzce;->zzb:Lcom/android/billingclient/api/zzcz;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 9
    sget v4, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 10
    invoke-static {v3, v1, p1, v0, v4}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object v0

    iget v1, p0, Lcom/android/billingclient/api/zzce;->zzc:I

    .line 11
    invoke-interface {v2, v0, v1}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    :cond_1
    iget-object v0, p0, Lcom/android/billingclient/api/zzce;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;

    .line 12
    invoke-interface {v0, p1}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method
