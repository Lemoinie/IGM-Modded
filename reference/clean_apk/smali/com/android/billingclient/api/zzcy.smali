.class public final synthetic Lcom/android/billingclient/api/zzcy;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field public static final synthetic zza:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    sget v0, Lcom/android/billingclient/api/zzcz;->zza:I

    return-void
.end method

.method public static zza(Ljava/lang/Exception;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    if-nez p0, :cond_0

    return-object v0

    .line 1
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzbo;->zzc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ":"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 2
    sget v1, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x28

    if-le v1, v2, :cond_1

    const/4 v1, 0x0

    .line 3
    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    return-object p0

    :catchall_0
    move-exception p0

    const-string v1, "BillingLogger"

    const-string v2, "Unable to get truncated exception info"

    .line 4
    invoke-static {v1, v2, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-object v0
.end method

.method public static zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;
    .locals 2

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v0

    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object v1

    .line 3
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzb(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingResult;->getOnPurchasesUpdatedSubResponseCode()I

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingResult;->getOnPurchasesUpdatedSubResponseCode()I

    move-result p2

    .line 4
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    :cond_0
    if-eqz p0, :cond_1

    .line 5
    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    :cond_1
    if-eqz p3, :cond_2

    .line 6
    invoke-virtual {v0, p3}, Lcom/google/android/gms/internal/play_billing/zzjl;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    :cond_2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object p0

    .line 8
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 9
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 10
    invoke-virtual {p4, p1}, Lcom/google/android/gms/internal/play_billing/zzju;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_3

    .line 11
    invoke-virtual {p0, p4}, Lcom/google/android/gms/internal/play_billing/zzje;->zza(Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 12
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzjg;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object p0

    :catchall_0
    move-exception p0

    const-string p1, "BillingLogger"

    const-string p2, "Unable to create logging payload"

    .line 13
    invoke-static {p1, p2, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p0, 0x0

    return-object p0
.end method

.method public static zzc(ILcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjk;
    .locals 1

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjk;->zza()Lcom/google/android/gms/internal/play_billing/zzji;

    move-result-object v0

    .line 2
    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzji;->zze(I)Lcom/google/android/gms/internal/play_billing/zzji;

    sget-object p0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzju;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_0

    .line 4
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzji;->zza(Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 5
    :cond_0
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzjk;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception p0

    const-string p1, "BillingLogger"

    const-string v0, "Unable to create logging payload"

    .line 6
    invoke-static {p1, v0, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p0, 0x0

    return-object p0
.end method
