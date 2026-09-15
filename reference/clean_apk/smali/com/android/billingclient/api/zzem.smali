.class final Lcom/android/billingclient/api/zzem;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# direct methods
.method static declared-synchronized zza(Landroid/content/Context;)D
    .locals 4

    const-class v0, Lcom/android/billingclient/api/zzem;

    monitor-enter v0

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzek;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzek;-><init>(Landroid/content/Context;)V

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    invoke-static {v1, p0}, Lcom/android/billingclient/api/zzem;->zze(Lcom/android/billingclient/api/zzel;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Double;

    invoke-virtual {p0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v1

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method static declared-synchronized zzb(Landroid/content/Context;)J
    .locals 4

    const-class v0, Lcom/android/billingclient/api/zzem;

    monitor-enter v0

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzej;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzej;-><init>(Landroid/content/Context;)V

    const-wide/16 v2, 0x3

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    invoke-static {v1, p0}, Lcom/android/billingclient/api/zzem;->zze(Lcom/android/billingclient/api/zzel;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v1

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method static declared-synchronized zzc(Landroid/content/Context;)J
    .locals 4

    const-class v0, Lcom/android/billingclient/api/zzem;

    monitor-enter v0

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzeh;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzeh;-><init>(Landroid/content/Context;)V

    const-wide/16 v2, 0x64

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    invoke-static {v1, p0}, Lcom/android/billingclient/api/zzem;->zze(Lcom/android/billingclient/api/zzel;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v1

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method static declared-synchronized zzd(Landroid/content/Context;)J
    .locals 4

    const-class v0, Lcom/android/billingclient/api/zzem;

    monitor-enter v0

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzei;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzei;-><init>(Landroid/content/Context;)V

    const-wide/32 v2, 0xea60

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    invoke-static {v1, p0}, Lcom/android/billingclient/api/zzem;->zze(Lcom/android/billingclient/api/zzel;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v1

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method private static zze(Lcom/android/billingclient/api/zzel;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .line 1
    :try_start_0
    invoke-interface {p0}, Lcom/android/billingclient/api/zzel;->zza()Ljava/lang/Object;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception p0

    const-string v0, "Fail to get the runtime flags: "

    .line 2
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    const-string v0, "RuntimeFlags"

    invoke-static {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    return-object p1
.end method
