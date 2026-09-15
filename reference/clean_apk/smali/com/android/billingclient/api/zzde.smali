.class final Lcom/android/billingclient/api/zzde;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# direct methods
.method static zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V
    .locals 2

    .line 1
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    const/4 v0, 0x0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p0, p3, p1, v0, v1}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p0

    .line 3
    invoke-interface {p2, p0, p4}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    return-void
.end method

.method static zzb(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;IILjava/lang/String;)V
    .locals 1

    .line 1
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p0, p3, p1, p5, v0}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p0

    .line 3
    invoke-interface {p2, p0, p4}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V

    return-void
.end method
