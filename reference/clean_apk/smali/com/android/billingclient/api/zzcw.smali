.class final Lcom/android/billingclient/api/zzcw;
.super Lcom/android/billingclient/api/BillingClientImpl;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zza:Landroid/content/Context;

.field private volatile zzb:I

.field private volatile zzc:Lcom/google/android/gms/internal/play_billing/zzba;

.field private volatile zzd:Lcom/android/billingclient/api/zzcu;

.field private volatile zze:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method constructor <init>(Ljava/lang/String;Landroid/content/Context;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 6

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, p2

    move-object v5, p5

    .line 1
    invoke-direct/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Ljava/lang/String;Landroid/content/Context;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    iput-object p2, p0, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 11

    move-object v10, p0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v9, p9

    .line 4
    invoke-direct/range {v0 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V

    const/4 v0, 0x0

    iput v0, v10, Lcom/android/billingclient/api/zzcw;->zzb:I

    move-object v0, p3

    iput-object v0, v10, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 10

    move-object v9, p0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v1, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v8, p8

    .line 3
    invoke-direct/range {v0 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V

    const/4 v0, 0x0

    iput v0, v9, Lcom/android/billingclient/api/zzcw;->zzb:I

    move-object v0, p3

    iput-object v0, v9, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 8

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v1, 0x0

    const/4 v4, 0x0

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v7, p7

    .line 2
    invoke-direct/range {v0 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    iput-object p3, p0, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    return-void
.end method

.method public static synthetic zzaA(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->queryProductDetailsAsync(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    return-void
.end method

.method public static synthetic zzaB(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/BillingResult;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-void
.end method

.method static bridge synthetic zzaC(Lcom/android/billingclient/api/zzcw;Lcom/google/android/gms/internal/play_billing/zzba;)V
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    return-void
.end method

.method static bridge synthetic zzaD(Lcom/android/billingclient/api/zzcw;I)V
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    return-void
.end method

.method static bridge synthetic zzaE(Lcom/android/billingclient/api/zzcw;I)Z
    .locals 0

    invoke-static {p1}, Lcom/android/billingclient/api/zzcw;->zzaO(I)Z

    move-result p0

    return p0
.end method

.method static bridge synthetic zzaG(Lcom/android/billingclient/api/zzcw;II)Lcom/android/billingclient/api/BillingResult;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcw;->zzaP(II)Lcom/android/billingclient/api/BillingResult;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic zzaH(Lcom/android/billingclient/api/zzcw;ILcom/google/android/gms/internal/play_billing/zzp;)Ljava/lang/Object;
    .locals 3

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    if-eq p1, v2, :cond_4

    const/4 v2, 0x3

    if-eq p1, v2, :cond_3

    const/4 v2, 0x4

    if-eq p1, v2, :cond_2

    const/4 v2, 0x5

    if-eq p1, v2, :cond_1

    const/4 v2, 0x6

    if-eq p1, v2, :cond_0

    const-string p1, "QUERY_PRODUCT_DETAILS_ASYNC"

    goto :goto_0

    .line 3
    :cond_0
    const-string p1, "START_CONNECTION"

    goto :goto_0

    :cond_1
    const-string p1, "IS_FEATURE_SUPPORTED"

    goto :goto_0

    :cond_2
    const-string p1, "CONSUME_ASYNC"

    goto :goto_0

    :cond_3
    const-string p1, "ACKNOWLEDGE_PURCHASE"

    goto :goto_0

    :cond_4
    const-string p1, "LAUNCH_BILLING_FLOW"

    .line 1
    :goto_0
    new-instance v2, Lcom/android/billingclient/api/zzct;

    .line 2
    invoke-direct {v2, p2}, Lcom/android/billingclient/api/zzct;-><init>(Lcom/google/android/gms/internal/play_billing/zzp;)V

    .line 3
    invoke-interface {v0, v1, p1, v2}, Lcom/google/android/gms/internal/play_billing/zzba;->zza(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzbc;)V

    goto :goto_1

    :cond_5
    const/4 p1, 0x0

    .line 4
    throw p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception p1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaQ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v1, 0x1c

    .line 5
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzF:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v0, v1, v2}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const-string p0, "BillingClientTesting"

    const-string v0, "An error occurred while retrieving billing override."

    .line 6
    invoke-static {p0, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p0, 0x0

    .line 7
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-virtual {p2, p0}, Lcom/google/android/gms/internal/play_billing/zzp;->zzb(Ljava/lang/Object;)Z

    .line 3
    :goto_1
    const-string p0, "billingOverrideService.getBillingOverride"

    return-object p0
.end method

.method static bridge synthetic zzaI(Lcom/android/billingclient/api/zzcw;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    .locals 0

    const/16 p2, 0x1c

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method static bridge synthetic zzaJ(Lcom/android/billingclient/api/zzcw;I)V
    .locals 0

    const/16 p1, 0x1a

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzcw;->zzaS(I)V

    return-void
.end method

.method private final zzaK(Lcom/google/android/gms/internal/play_billing/zzdk;)I
    .locals 6

    .line 1
    const-string v0, "BillingClientTesting"

    const/4 v1, 0x0

    const/16 v2, 0x1c

    :try_start_0
    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v4, 0x6f54

    invoke-interface {p1, v4, v5, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return p1

    :catch_0
    move-exception p1

    .line 2
    instance-of v3, p1, Ljava/lang/InterruptedException;

    if-eqz v3, :cond_0

    .line 3
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->interrupt()V

    :cond_0
    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaQ:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 4
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzF:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v3, v2, v4}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const-string v2, "An error occurred while retrieving billing override."

    .line 5
    invoke-static {v0, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return v1

    :catch_1
    move-exception p1

    .line 1
    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaX:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzF:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v3, v2, v4}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const-string v2, "Asynchronous call to Billing Override Service timed out."

    .line 7
    invoke-static {v0, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return v1
.end method

.method private final declared-synchronized zzaL()Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1

    monitor-enter p0

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;

    :cond_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private final declared-synchronized zzaM()V
    .locals 4

    monitor-enter p0

    const/16 v0, 0x1b

    .line 1
    :try_start_0
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/zzcw;->zzaS(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    const/4 v0, 0x3

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    if-eqz v1, :cond_0

    const-string v1, "BillingClientTesting"

    const-string v3, "Unbinding from Billing Override Service."

    .line 2
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;

    .line 3
    invoke-virtual {v1, v3}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    new-instance v1, Lcom/android/billingclient/api/zzcu;

    .line 4
    invoke-direct {v1, p0, v2}, Lcom/android/billingclient/api/zzcu;-><init>(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/zzcv;)V

    iput-object v1, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;

    :cond_0
    iput-object v2, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;

    .line 5
    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    iput-object v2, p0, Lcom/android/billingclient/api/zzcw;->zze:Ljava/util/concurrent/ScheduledExecutorService;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    goto :goto_1

    :catch_0
    move-exception v1

    :try_start_2
    const-string v2, "BillingClientTesting"

    const-string v3, "There was an exception while ending Billing Override Service connection!"

    .line 6
    invoke-static {v2, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 5
    :cond_1
    :goto_0
    :try_start_3
    iput v0, p0, Lcom/android/billingclient/api/zzcw;->zzb:I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    monitor-exit p0

    return-void

    .line 6
    :goto_1
    :try_start_4
    iput v0, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    .line 7
    throw v1

    :catchall_1
    move-exception v0

    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0
.end method

.method private final declared-synchronized zzaN()V
    .locals 8

    monitor-enter p0

    .line 1
    :try_start_0
    invoke-virtual {p0}, Lcom/android/billingclient/api/zzcw;->zzaF()Z

    move-result v0

    const/16 v1, 0x1a

    if-eqz v0, :cond_0

    const-string v0, "BillingClientTesting"

    const-string v2, "Billing Override Service connection is valid. No need to re-initialize."

    .line 2
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    invoke-direct {p0, v1}, Lcom/android/billingclient/api/zzcw;->zzaS(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget v0, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    const/4 v2, 0x1

    if-ne v0, v2, :cond_1

    const-string v0, "BillingClientTesting"

    const-string v1, "Client is already in the process of connecting to Billing Override Service."

    .line 4
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void

    :cond_1
    :try_start_2
    iget v0, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    const/4 v3, 0x3

    if-ne v0, v3, :cond_2

    const-string v0, "BillingClientTesting"

    const-string v2, "Billing Override Service Client was already closed and can\'t be reused. Please create another instance."

    .line 5
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "Billing Override Service connection is disconnected."

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzL:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v3, -0x1

    .line 6
    invoke-static {v3, v0}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    .line 7
    invoke-direct {p0, v2, v1, v0}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-void

    :cond_2
    :try_start_3
    iput v2, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    const-string v0, "BillingClientTesting"

    const-string v3, "Starting Billing Override Service setup."

    .line 8
    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/android/billingclient/api/zzcu;

    const/4 v3, 0x0

    .line 9
    invoke-direct {v0, p0, v3}, Lcom/android/billingclient/api/zzcu;-><init>(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/zzcv;)V

    iput-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;

    new-instance v0, Landroid/content/Intent;

    const-string v3, "com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND"

    .line 10
    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v3, "com.google.android.apps.play.billingtestcompanion"

    .line 11
    invoke-virtual {v0, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v3, p0, Lcom/android/billingclient/api/zzcw;->zza:Landroid/content/Context;

    .line 12
    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v0, v5}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v4

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    if-eqz v4, :cond_5

    .line 13
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_5

    .line 14
    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ResolveInfo;

    .line 15
    iget-object v7, v4, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v7, :cond_6

    .line 16
    iget-object v6, v4, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v6, v6, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    .line 17
    iget-object v4, v4, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v4, v4, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    const-string v7, "com.google.android.apps.play.billingtestcompanion"

    .line 18
    invoke-static {v6, v7}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    if-eqz v4, :cond_4

    new-instance v7, Landroid/content/ComponentName;

    .line 19
    invoke-direct {v7, v6, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v4, Landroid/content/Intent;

    .line 20
    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 21
    invoke-virtual {v4, v7}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;

    .line 22
    invoke-virtual {v3, v4, v0, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "BillingClientTesting"

    const-string v1, "Billing Override Service was bonded successfully."

    .line 23
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    monitor-exit p0

    return-void

    :cond_3
    :try_start_4
    const-string v0, "BillingClientTesting"

    const-string v2, "Connection to Billing Override Service is blocked."

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzM:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 24
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 28
    :cond_4
    const-string v0, "BillingClientTesting"

    const-string v2, "The device doesn\'t have valid Play Billing Lab."

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzM:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 25
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_5
    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzO:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 24
    :cond_6
    :goto_0
    iput v5, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    const-string v0, "BillingClientTesting"

    const-string v2, "Billing Override Service unavailable on device."

    .line 26
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "Billing Override Service unavailable on device."

    const/4 v2, 0x2

    .line 27
    invoke-static {v2, v0}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    .line 28
    invoke-direct {p0, v6, v1, v0}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    :try_start_5
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v0
.end method

.method private static final zzaO(I)Z
    .locals 0

    if-lez p0, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method private final zzaP(II)Lcom/android/billingclient/api/BillingResult;
    .locals 1

    .line 1
    const-string v0, "Billing override value was set by a license tester."

    invoke-static {p2, v0}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaO:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    invoke-direct {p0, v0, p1, p2}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p2
.end method

.method private final zzaQ(I)Lcom/google/android/gms/internal/play_billing/zzdk;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lcom/android/billingclient/api/zzcw;->zzaF()Z

    move-result v0

    if-nez v0, :cond_0

    const-string p1, "BillingClientTesting"

    const-string v0, "Billing Override Service is not ready."

    .line 2
    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaP:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v0, -0x1

    const-string v1, "Billing Override Service connection is disconnected."

    .line 3
    invoke-static {v0, v1}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    const/16 v1, 0x1c

    .line 4
    invoke-direct {p0, p1, v1, v0}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const/4 p1, 0x0

    .line 5
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzdf;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object p1

    return-object p1

    :cond_0
    new-instance v0, Lcom/android/billingclient/api/zzcn;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzcn;-><init>(Lcom/android/billingclient/api/zzcw;I)V

    .line 6
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzu;->zza(Lcom/google/android/gms/internal/play_billing/zzr;)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object p1

    return-object p1
.end method

.method private final zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    .locals 2

    .line 1
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    const/4 v0, 0x0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p1, p2, p3, v0, v1}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    const-string p2, "ApiFailure should not be null"

    .line 3
    invoke-static {p1, p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzl()Lcom/android/billingclient/api/zzcz;

    move-result-object p2

    .line 4
    invoke-interface {p2, p1}, Lcom/android/billingclient/api/zzcz;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    return-void
.end method

.method private final zzaS(I)V
    .locals 1

    .line 1
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p1, v0}, Lcom/android/billingclient/api/zzcy;->zzc(ILcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjk;

    move-result-object p1

    const-string v0, "ApiSuccess should not be null"

    .line 3
    invoke-static {p1, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjk;

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzl()Lcom/android/billingclient/api/zzcz;

    move-result-object v0

    .line 4
    invoke-interface {v0, p1}, Lcom/android/billingclient/api/zzcz;->zzf(Lcom/google/android/gms/internal/play_billing/zzjk;)V

    return-void
.end method

.method private final zzaT(ILandroidx/core/util/Consumer;Ljava/lang/Runnable;)V
    .locals 5

    .line 1
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzcw;->zzaQ(I)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object v0

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 2
    invoke-direct {p0}, Lcom/android/billingclient/api/zzcw;->zzaL()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v2

    const-wide/16 v3, 0x6f54

    .line 3
    invoke-static {v0, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzdf;->zzb(Lcom/google/android/gms/internal/play_billing/zzdk;JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/ScheduledExecutorService;)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object v0

    new-instance v1, Lcom/android/billingclient/api/zzcs;

    .line 4
    invoke-direct {v1, p0, p1, p2, p3}, Lcom/android/billingclient/api/zzcs;-><init>(Lcom/android/billingclient/api/zzcw;ILandroidx/core/util/Consumer;Ljava/lang/Runnable;)V

    .line 5
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    .line 4
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzdf;->zzc(Lcom/google/android/gms/internal/play_billing/zzdk;Lcom/google/android/gms/internal/play_billing/zzdd;Ljava/util/concurrent/Executor;)V

    return-void
.end method

.method public static synthetic zzax(Lcom/android/billingclient/api/zzcw;Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic zzay(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->acknowledgePurchase(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    return-void
.end method

.method public static synthetic zzaz(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->consumeAsync(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V

    return-void
.end method


# virtual methods
.method public final acknowledgePurchase(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .locals 2

    .line 1
    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/android/billingclient/api/zzco;

    invoke-direct {v0, p2}, Lcom/android/billingclient/api/zzco;-><init>(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    new-instance v1, Lcom/android/billingclient/api/zzcp;

    invoke-direct {v1, p0, p1, p2}, Lcom/android/billingclient/api/zzcp;-><init>(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    const/4 p1, 0x3

    .line 2
    invoke-direct {p0, p1, v0, v1}, Lcom/android/billingclient/api/zzcw;->zzaT(ILandroidx/core/util/Consumer;Ljava/lang/Runnable;)V

    return-void
.end method

.method public final consumeAsync(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .locals 2

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzcl;

    invoke-direct {v0, p2, p1}, Lcom/android/billingclient/api/zzcl;-><init>(Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V

    new-instance v1, Lcom/android/billingclient/api/zzcm;

    invoke-direct {v1, p0, p1, p2}, Lcom/android/billingclient/api/zzcm;-><init>(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V

    const/4 p1, 0x4

    invoke-direct {p0, p1, v0, v1}, Lcom/android/billingclient/api/zzcw;->zzaT(ILandroidx/core/util/Consumer;Ljava/lang/Runnable;)V

    return-void
.end method

.method public final endConnection()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/android/billingclient/api/zzcw;->zzaM()V

    .line 2
    invoke-super {p0}, Lcom/android/billingclient/api/BillingClientImpl;->endConnection()V

    return-void
.end method

.method public final launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;
    .locals 3

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzcq;

    invoke-direct {v0, p0}, Lcom/android/billingclient/api/zzcq;-><init>(Lcom/android/billingclient/api/zzcw;)V

    new-instance v1, Lcom/android/billingclient/api/zzcr;

    invoke-direct {v1, p0, p1, p2}, Lcom/android/billingclient/api/zzcr;-><init>(Lcom/android/billingclient/api/zzcw;Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)V

    const/4 p1, 0x2

    .line 2
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzcw;->zzaQ(I)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object p2

    .line 3
    invoke-direct {p0, p2}, Lcom/android/billingclient/api/zzcw;->zzaK(Lcom/google/android/gms/internal/play_billing/zzdk;)I

    move-result p2

    invoke-static {p2}, Lcom/android/billingclient/api/zzcw;->zzaO(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 4
    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcw;->zzaP(II)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    .line 5
    invoke-interface {v0, p1}, Landroidx/core/util/Consumer;->accept(Ljava/lang/Object;)V

    goto :goto_0

    .line 6
    :cond_0
    :try_start_0
    invoke-interface {v1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/android/billingclient/api/BillingResult;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object p1, p2

    goto :goto_0

    :catch_0
    move-exception p2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaY:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v0, p1, v1}, Lcom/android/billingclient/api/zzcw;->zzaR(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const-string p1, "BillingClientTesting"

    const-string v0, "An internal error occurred."

    .line 8
    invoke-static {p1, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object p1, v1

    :goto_0
    return-object p1
.end method

.method public final queryProductDetailsAsync(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .locals 2

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzcj;

    invoke-direct {v0, p2}, Lcom/android/billingclient/api/zzcj;-><init>(Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    new-instance v1, Lcom/android/billingclient/api/zzck;

    invoke-direct {v1, p0, p1, p2}, Lcom/android/billingclient/api/zzck;-><init>(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    const/4 p1, 0x7

    invoke-direct {p0, p1, v0, v1}, Lcom/android/billingclient/api/zzcw;->zzaT(ILandroidx/core/util/Consumer;Ljava/lang/Runnable;)V

    return-void
.end method

.method public final startConnection(Lcom/android/billingclient/api/BillingClientStateListener;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/android/billingclient/api/zzcw;->zzaN()V

    .line 2
    invoke-super {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->startConnection(Lcom/android/billingclient/api/BillingClientStateListener;)V

    return-void
.end method

.method public final declared-synchronized zzaF()Z
    .locals 2

    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/android/billingclient/api/zzcw;->zzb:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzc:Lcom/google/android/gms/internal/play_billing/zzba;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/billingclient/api/zzcw;->zzd:Lcom/android/billingclient/api/zzcu;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    monitor-exit p0

    const/4 v0, 0x1

    return v0

    :cond_0
    monitor-exit p0

    const/4 v0, 0x0

    return v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
