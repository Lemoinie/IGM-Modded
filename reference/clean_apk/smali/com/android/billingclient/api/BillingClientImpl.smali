.class Lcom/android/billingclient/api/BillingClientImpl;
.super Lcom/android/billingclient/api/BillingClient;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private zzA:Z

.field private zzB:Z

.field private zzC:Z

.field private zzD:Z

.field private zzE:Z

.field private zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

.field private zzG:Z

.field private zzH:Z

.field private zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

.field private volatile zzJ:Lcom/android/billingclient/api/BillingClientStateListener;

.field private zzK:Ljava/util/concurrent/ExecutorService;

.field private final zzL:Ljava/lang/Long;

.field private final zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

.field private final zza:Ljava/lang/Object;

.field private volatile zzb:I

.field private final zzc:Ljava/lang/String;

.field private final zzd:Ljava/lang/String;

.field private final zze:Landroid/os/Handler;

.field private volatile zzf:Lcom/android/billingclient/api/zzab;

.field private zzg:Landroid/content/Context;

.field private zzh:Lcom/android/billingclient/api/zzcz;

.field private volatile zzi:Lcom/google/android/gms/internal/play_billing/zzar;

.field private volatile zzj:Lcom/android/billingclient/api/zzbw;

.field private zzk:Z

.field private zzl:Z

.field private zzm:I

.field private zzn:Z

.field private zzo:Z

.field private zzp:Z

.field private zzq:Z

.field private zzr:Z

.field private zzs:Z

.field private zzt:Z

.field private zzu:Z

.field private zzv:Z

.field private zzw:Z

.field private zzx:Z

.field private zzy:Z

.field private zzz:Z


# direct methods
.method constructor <init>(Ljava/lang/String;Landroid/content/Context;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    new-instance p1, Ljava/lang/Object;

    invoke-direct {p1}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    new-instance p3, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p4

    invoke-direct {p3, p4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzk()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object p3

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    new-instance p3, Ljava/util/Random;

    .line 3
    invoke-direct {p3}, Ljava/util/Random;-><init>()V

    invoke-virtual {p3}, Ljava/util/Random;->nextLong()J

    move-result-wide p3

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p3

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzbf;->zza()Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object p4

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    const-string p4, "9.0.0"

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    .line 5
    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzaI()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    .line 6
    invoke-virtual {p2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkb;->zza()Lcom/google/android/gms/internal/play_billing/zzjz;

    move-result-object v1

    .line 8
    invoke-virtual {v1, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzx(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    if-eqz v0, :cond_0

    .line 9
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzy(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    :cond_0
    iget-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 10
    invoke-virtual {p4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p4

    invoke-virtual {v1, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzq(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 11
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p3

    invoke-virtual {v1, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzd(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-boolean p3, p5, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    .line 12
    invoke-virtual {v1, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzw(Z)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget p3, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 13
    invoke-virtual {v1, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zza(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    const-wide/32 p3, 0x365f4650

    .line 14
    invoke-virtual {v1, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzp(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 15
    invoke-static {v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbr(Lcom/google/android/gms/internal/play_billing/zzjz;Landroid/content/Context;)V

    :try_start_0
    iget-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 16
    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p2

    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 17
    invoke-virtual {p3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p3

    .line 18
    invoke-virtual {p2, p3, p1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p1

    iget p1, p1, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 19
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzjz;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    .line 23
    const-string p2, "BillingClient"

    const-string p3, "Error getting app version code."

    .line 20
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 19
    :goto_0
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 21
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    new-instance p3, Lcom/android/billingclient/api/zzdm;

    .line 22
    invoke-direct {p3, p1, p2}, Lcom/android/billingclient/api/zzdm;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzkb;)V

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 23
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    iget-object p1, p5, Lcom/android/billingclient/api/BillingClient$Builder;->zzb:Lcom/google/android/gms/internal/play_billing/zzbq;

    iget-boolean p1, p5, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 10

    move-object v9, p0

    .line 55
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    const/4 v0, 0x0

    iput v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    iput v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 56
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzk()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object v0

    iput-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    new-instance v0, Ljava/util/Random;

    .line 57
    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    invoke-virtual {v0}, Ljava/util/Random;->nextLong()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 58
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzbf;->zza()Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object v0

    iput-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    const-string v6, "9.0.0"

    iput-object v6, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    .line 59
    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzaI()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p3

    move-object v2, p4

    move-object v3, p2

    move-object v4, p5

    move-object/from16 v5, p6

    move-object/from16 v8, p9

    .line 60
    invoke-direct/range {v0 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/PendingPurchasesParams;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzcz;Lcom/android/billingclient/api/BillingClient$Builder;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 9

    move-object v8, p0

    .line 49
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    const/4 v0, 0x0

    iput v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, v8, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    iput v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 50
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzk()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object v0

    iput-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    new-instance v0, Ljava/util/Random;

    .line 51
    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    invoke-virtual {v0}, Ljava/util/Random;->nextLong()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 52
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzbf;->zza()Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object v0

    iput-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    const-string v5, "9.0.0"

    iput-object v5, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    .line 53
    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzaI()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p3

    move-object v2, p4

    move-object v3, p2

    move-object/from16 v7, p8

    .line 54
    invoke-direct/range {v0 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/PendingPurchasesParams;Lcom/android/billingclient/api/zzb;Ljava/lang/String;Lcom/android/billingclient/api/zzcz;Lcom/android/billingclient/api/BillingClient$Builder;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/PendingPurchasesParams;Landroid/content/Context;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzcz;Ljava/util/concurrent/ExecutorService;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 8

    .line 24
    const-string p1, "BillingClient"

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    new-instance p4, Ljava/lang/Object;

    invoke-direct {p4}, Ljava/lang/Object;-><init>()V

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    const/4 p4, 0x0

    iput p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    new-instance p5, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p6

    invoke-direct {p5, p6}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    iput p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 25
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzk()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object p5

    iput-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    new-instance p5, Ljava/util/Random;

    .line 26
    invoke-direct {p5}, Ljava/util/Random;-><init>()V

    invoke-virtual {p5}, Ljava/util/Random;->nextLong()J

    move-result-wide p5

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p5

    iput-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 27
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzbf;->zza()Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object p6

    iput-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    const-string p6, "9.0.0"

    iput-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    .line 28
    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzaI()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    .line 29
    invoke-virtual {p3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 30
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkb;->zza()Lcom/google/android/gms/internal/play_billing/zzjz;

    move-result-object v1

    .line 31
    invoke-virtual {v1, p6}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzx(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    if-eqz v0, :cond_0

    .line 32
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzy(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    :cond_0
    iget-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 33
    invoke-virtual {p6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p6

    invoke-virtual {v1, p6}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzq(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 34
    invoke-virtual {p5}, Ljava/lang/Long;->longValue()J

    move-result-wide p5

    invoke-virtual {v1, p5, p6}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzd(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-boolean p5, p7, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    .line 35
    invoke-virtual {v1, p5}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzw(Z)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget p5, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 36
    invoke-virtual {v1, p5}, Lcom/google/android/gms/internal/play_billing/zzjz;->zza(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    const-wide/32 p5, 0x365f4650

    .line 37
    invoke-virtual {v1, p5, p6}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzp(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 38
    invoke-static {v1, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbr(Lcom/google/android/gms/internal/play_billing/zzjz;Landroid/content/Context;)V

    :try_start_0
    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 39
    invoke-virtual {p3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p3

    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 40
    invoke-virtual {p5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p5

    .line 41
    invoke-virtual {p3, p5, p4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p3

    iget p3, p3, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 42
    invoke-virtual {v1, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzjz;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p3

    .line 48
    const-string p4, "Error getting app version code."

    .line 43
    invoke-static {p1, p4, p3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 42
    :goto_0
    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 44
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p4

    check-cast p4, Lcom/google/android/gms/internal/play_billing/zzkb;

    new-instance p5, Lcom/android/billingclient/api/zzdm;

    .line 45
    invoke-direct {p5, p3, p4}, Lcom/android/billingclient/api/zzdm;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzkb;)V

    iput-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    const-string p3, "Billing client should have a valid listener but the provided is null."

    .line 46
    invoke-static {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p1, Lcom/android/billingclient/api/zzab;

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p1

    .line 47
    invoke-direct/range {v0 .. v7}, Lcom/android/billingclient/api/zzab;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;)V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    iput-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 48
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    iget-object p1, p7, Lcom/android/billingclient/api/BillingClient$Builder;->zzb:Lcom/google/android/gms/internal/play_billing/zzbq;

    iget-boolean p1, p7, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    return-void
.end method

.method private initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/PendingPurchasesParams;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzcz;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 15

    move-object v1, p0

    move-object/from16 v2, p7

    move-object/from16 v3, p8

    .line 23
    const-string v4, "BillingClient"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 24
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkb;->zza()Lcom/google/android/gms/internal/play_billing/zzjz;

    move-result-object v5

    move-object/from16 v0, p6

    .line 25
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzx(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 26
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzy(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    :cond_0
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 27
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzq(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 28
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzd(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 29
    iget-boolean v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzw(Z)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 30
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zza(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    const-wide/32 v6, 0x365f4650

    .line 31
    invoke-virtual {v5, v6, v7}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzp(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    move-object/from16 v0, p1

    .line 32
    invoke-static {v5, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbr(Lcom/google/android/gms/internal/play_billing/zzjz;Landroid/content/Context;)V

    const/4 v6, 0x0

    :try_start_0
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 33
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v7, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 34
    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    .line 35
    invoke-virtual {v0, v7, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 36
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzjz;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 39
    const-string v7, "Error getting app version code."

    .line 37
    invoke-static {v4, v7, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_0
    if-eqz v2, :cond_1

    .line 36
    iput-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    goto :goto_1

    .line 43
    :cond_1
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 38
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzkb;

    new-instance v5, Lcom/android/billingclient/api/zzdm;

    .line 39
    invoke-direct {v5, v0, v2}, Lcom/android/billingclient/api/zzdm;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzkb;)V

    iput-object v5, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    :goto_1
    if-nez p2, :cond_2

    .line 36
    const-string v0, "Billing client should have a valid listener but the provided is null."

    .line 40
    invoke-static {v4, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    new-instance v0, Lcom/android/billingclient/api/zzab;

    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    const/4 v11, 0x0

    iget-object v14, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    const/4 v10, 0x0

    move-object v7, v0

    move-object/from16 v9, p2

    move-object/from16 v12, p4

    move-object/from16 v13, p5

    .line 41
    invoke-direct/range {v7 .. v14}, Lcom/android/billingclient/api/zzab;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;)V

    iput-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    move-object/from16 v2, p3

    iput-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    if-eqz p4, :cond_3

    const/4 v6, 0x1

    :cond_3
    iput-boolean v6, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzH:Z

    .line 42
    iget-object v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zzb:Lcom/google/android/gms/internal/play_billing/zzbq;

    .line 43
    iget-boolean v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    iput-boolean v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    return-void
.end method

.method private initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/PendingPurchasesParams;Lcom/android/billingclient/api/zzb;Ljava/lang/String;Lcom/android/billingclient/api/zzcz;Lcom/android/billingclient/api/BillingClient$Builder;)V
    .locals 15

    move-object v1, p0

    move-object/from16 v2, p6

    move-object/from16 v3, p7

    .line 1
    const-string v4, "BillingClient"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkb;->zza()Lcom/google/android/gms/internal/play_billing/zzjz;

    move-result-object v5

    move-object/from16 v0, p5

    .line 3
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzx(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 4
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzy(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    :cond_0
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 5
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzq(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 6
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzd(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 7
    iget-boolean v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzw(Z)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 8
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zza(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    const-wide/32 v6, 0x365f4650

    .line 9
    invoke-virtual {v5, v6, v7}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzp(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    move-object/from16 v0, p1

    .line 10
    invoke-static {v5, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbr(Lcom/google/android/gms/internal/play_billing/zzjz;Landroid/content/Context;)V

    const/4 v6, 0x0

    :try_start_0
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 11
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v7, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 12
    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    .line 13
    invoke-virtual {v0, v7, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 14
    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzjz;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 17
    const-string v7, "Error getting app version code."

    .line 15
    invoke-static {v4, v7, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_0
    if-eqz v2, :cond_1

    .line 14
    iput-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    goto :goto_1

    .line 22
    :cond_1
    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 16
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzkb;

    new-instance v5, Lcom/android/billingclient/api/zzdm;

    .line 17
    invoke-direct {v5, v0, v2}, Lcom/android/billingclient/api/zzdm;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzkb;)V

    iput-object v5, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    :goto_1
    if-nez p2, :cond_2

    .line 14
    const-string v0, "Billing client should have a valid listener but the provided is null."

    .line 18
    invoke-static {v4, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    new-instance v0, Lcom/android/billingclient/api/zzab;

    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    const/4 v13, 0x0

    iget-object v14, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    const/4 v10, 0x0

    const/4 v12, 0x0

    move-object v7, v0

    move-object/from16 v9, p2

    move-object/from16 v11, p4

    .line 19
    invoke-direct/range {v7 .. v14}, Lcom/android/billingclient/api/zzab;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;)V

    iput-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    move-object/from16 v2, p3

    iput-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    if-eqz p4, :cond_3

    const/4 v6, 0x1

    :cond_3
    iput-boolean v6, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzH:Z

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 20
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 21
    iget-object v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zzb:Lcom/google/android/gms/internal/play_billing/zzbq;

    .line 22
    iget-boolean v0, v3, Lcom/android/billingclient/api/BillingClient$Builder;->zza:Z

    iput-boolean v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    return-void
.end method

.method static bridge synthetic zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    return-object p0
.end method

.method static bridge synthetic zzB(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    return-object p0
.end method

.method static bridge synthetic zzC(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    return-object p0
.end method

.method public static synthetic zzD(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaO(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzE(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaN(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzF(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaM(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzG(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/LaunchExternalLinkParams;Landroid/app/Activity;)Ljava/lang/Void;
    .locals 8

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzD:Z

    if-nez v1, :cond_1

    const-string p2, "BillingClient"

    const-string p3, "Current client doesn\'t support launch external link."

    .line 3
    invoke-static {p2, p3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzH:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbs:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 6
    :try_start_2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 8
    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 9
    sget v6, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    const-string v6, "9.0.0"

    new-instance v7, Landroid/os/Bundle;

    .line 10
    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 11
    invoke-static {v7, v6, v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    .line 12
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzih;->zza()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v3

    const-string v4, "externalOfferUri"

    .line 13
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    .line 14
    invoke-virtual {p2}, Lcom/android/billingclient/api/LaunchExternalLinkParams;->getLinkUri()Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 15
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 16
    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v4, "externalOfferLaunchMode"

    .line 17
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    .line 18
    invoke-virtual {p2}, Lcom/android/billingclient/api/LaunchExternalLinkParams;->getLaunchMode()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 19
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 20
    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v4, "externalOfferLinkType"

    .line 21
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    .line 22
    invoke-virtual {p2}, Lcom/android/billingclient/api/LaunchExternalLinkParams;->getLinkType()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 23
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 24
    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v4, "externalOfferBillingProgram"

    .line 25
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    .line 26
    invoke-virtual {p2}, Lcom/android/billingclient/api/LaunchExternalLinkParams;->getBillingProgram()I

    move-result p2

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {v5, p2}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 27
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 28
    invoke-virtual {v3, v4, p2}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 29
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p2

    if-nez p2, :cond_3

    const-string p2, "externalTransactionToken"

    .line 30
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v4

    .line 31
    invoke-virtual {v4, v0}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 32
    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 33
    invoke-virtual {v3, p2, v4}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 34
    :cond_3
    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzih;

    const-string v3, "REQUEST_PARAMS"

    .line 35
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzer;->zzQ()[B

    move-result-object p2

    invoke-virtual {v7, v3, p2}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    new-instance p2, Lcom/android/billingclient/api/zzcc;

    new-instance v3, Ljava/lang/ref/WeakReference;

    .line 9
    invoke-direct {v3, p3}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {p2, p0, v3, p1, v0}, Lcom/android/billingclient/api/zzcc;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/ref/WeakReference;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/zzci;)V

    const/16 p3, 0x1b

    .line 36
    invoke-interface {v2, p3, v1, v7, p2}, Lcom/google/android/gms/internal/play_billing/zzar;->zzp(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzai;)V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception p2

    .line 5
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p2
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p2

    .line 37
    sget-object p3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p3, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method public static synthetic zzH(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaL(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzI(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaP(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaJ(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzK(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;)Ljava/lang/Void;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaK(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;)Ljava/lang/Void;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzL(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)Ljava/lang/Void;
    .locals 7

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_1

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    if-nez v1, :cond_1

    const-string v1, "BillingClient"

    const-string v2, "Current client doesn\'t support alternative billing only."

    .line 3
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzD:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzan:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 6
    :try_start_2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_1

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 8
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 9
    invoke-static {v3, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzh(Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    move-result-object v3

    new-instance v4, Lcom/android/billingclient/api/zzce;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    invoke-direct {v4, p1, v5, v6, v0}, Lcom/android/billingclient/api/zzce;-><init>(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V

    const/16 v5, 0x15

    .line 10
    invoke-interface {v2, v5, v1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzr(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzam;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    :catchall_0
    move-exception v2

    .line 5
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v1

    .line 11
    instance-of v2, v1, Landroid/os/DeadObjectException;

    if-eqz v2, :cond_3

    .line 12
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    goto :goto_0

    .line 13
    :cond_3
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 12
    :goto_0
    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaq:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 14
    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_1
    return-object v0
.end method

.method static zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;
    .locals 2

    .line 1
    :try_start_0
    invoke-interface {p5, p0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    long-to-double p1, p1

    new-instance p5, Lcom/android/billingclient/api/zzbb;

    invoke-direct {p5, p0, p3}, Lcom/android/billingclient/api/zzbb;-><init>(Ljava/util/concurrent/Future;Ljava/lang/Runnable;)V

    const-wide v0, 0x3fee666666666666L    # 0.95

    mul-double/2addr p1, v0

    double-to-long p1, p1

    .line 3
    invoke-virtual {p4, p5, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-object p0

    :catch_0
    move-exception p0

    const-string p1, "BillingClient"

    const-string p2, "Async task throws exception!"

    .line 2
    invoke-static {p1, p2, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzO(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/4 v2, 0x4

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 2
    invoke-virtual {p2}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p0

    .line 3
    invoke-interface {p1, v1, p0}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic zzP(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x9

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object p0

    .line 3
    invoke-interface {p1, v1, p0}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic zzQ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingConfigResponseListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0xd

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const/4 p0, 0x0

    .line 2
    invoke-interface {p1, v1, p0}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method

.method public static synthetic zzR(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzS(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)V
    .locals 6

    .line 1
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzT(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzU(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/4 v2, 0x3

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 2
    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method public static synthetic zzV(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzW(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/4 v2, 0x7

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    new-instance p0, Lcom/android/billingclient/api/QueryProductDetailsResult;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v0

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/android/billingclient/api/QueryProductDetailsResult;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 4
    invoke-interface {p1, v1, p0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/QueryProductDetailsResult;)V

    return-void
.end method

.method public static synthetic zzX(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzY(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingResult;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzab;->zzf()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/zzab;->zzf()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object p0

    const/4 v0, 0x0

    .line 3
    invoke-interface {p0, p1, v0}, Lcom/android/billingclient/api/PurchasesUpdatedListener;->onPurchasesUpdated(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_0
    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    const-string p0, "BillingClient"

    const-string p1, "No valid listener is set in BroadcastManager"

    .line 4
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic zzZ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/BillingClientImpl;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    return p0
.end method

.method private final zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;
    .locals 1

    .line 1
    const-string v0, "BillingClient"

    invoke-static {v0, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p3, 0x7

    .line 2
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 3
    invoke-direct {p0, p2, p3, p1, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    new-instance p2, Lcom/android/billingclient/api/zzch;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p3

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p1

    new-instance p4, Ljava/util/ArrayList;

    .line 4
    invoke-direct {p4}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p2, p3, p1, p4, v0}, Lcom/android/billingclient/api/zzch;-><init>(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V

    return-object p2
.end method

.method private final zzaB(I)Lcom/android/billingclient/api/BillingResult;
    .locals 3

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "Service connection is valid. No need to re-initialize."

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjk;->zza()Lcom/google/android/gms/internal/play_billing/zzji;

    move-result-object v0

    const/4 v1, 0x6

    .line 3
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzji;->zze(I)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object v1

    const/4 v2, 0x1

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzlg;->zze(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    if-lez p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 6
    :goto_0
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 7
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 8
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzji;->zzd(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 9
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjk;

    .line 10
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbh(Lcom/google/android/gms/internal/play_billing/zzjk;)V

    .line 11
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    return-object p1
.end method

.method private final zzaC()Lcom/android/billingclient/api/BillingResult;
    .locals 5

    const/4 v0, 0x3

    const/4 v1, 0x0

    filled-new-array {v1, v0}, [I

    move-result-object v0

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v2

    :goto_0
    const/4 v3, 0x2

    if-ge v1, v3, :cond_1

    :try_start_0
    aget v3, v0, v1

    .line 1
    iget v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    if-ne v4, v3, :cond_0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    goto :goto_1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 3
    :cond_1
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 5
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    :goto_1
    return-object v0

    :catchall_0
    move-exception v0

    .line 4
    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method

.method private final zzaD(I)Lcom/google/android/gms/internal/play_billing/zzdk;
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 4
    :cond_0
    new-instance v0, Lcom/android/billingclient/api/zzad;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzad;-><init>(Lcom/android/billingclient/api/BillingClientImpl;I)V

    .line 2
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzu;->zza(Lcom/google/android/gms/internal/play_billing/zzr;)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object p1

    return-object p1

    .line 1
    :cond_1
    :goto_0
    const-string p1, "BillingClient"

    const-string v0, "Already connected or not opted into auto reconnection."

    .line 3
    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzdf;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object p1

    return-object p1
.end method

.method private final synthetic zzaE(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/AcknowledgePurchaseParams;)Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    const/4 v2, 0x3

    if-nez v1, :cond_0

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p2, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 3
    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_0

    .line 4
    :cond_0
    invoke-virtual {p2}, Lcom/android/billingclient/api/AcknowledgePurchaseParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string p2, "BillingClient"

    const-string v1, "Please provide a valid purchase token."

    .line 5
    invoke-static {p2, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzz:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzg:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p2, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 7
    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_0

    :cond_1
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-nez v1, :cond_2

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzA:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 8
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zza:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p2, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 9
    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 10
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_3

    .line 11
    :try_start_2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, v1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaS(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0

    :cond_3
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 12
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 13
    invoke-virtual {p2}, Lcom/android/billingclient/api/AcknowledgePurchaseParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p2

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 14
    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 15
    sget v6, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    const-string v6, "9.0.0"

    new-instance v7, Landroid/os/Bundle;

    .line 16
    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 17
    invoke-static {v7, v6, v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    const/16 v3, 0x9

    .line 18
    invoke-interface {v2, v3, v1, p2, v7}, Lcom/google/android/gms/internal/play_billing/zzar;->zzd(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p2
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    const-string v1, "BillingClient"

    .line 21
    invoke-static {p2, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v1

    const-string v2, "BillingClient"

    .line 22
    invoke-static {p2, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 23
    invoke-static {v1, p2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-object v0

    :catchall_0
    move-exception p2

    .line 10
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p2

    .line 19
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzB:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaS(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-object v0

    :catch_1
    move-exception p2

    .line 20
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzB:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaS(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-object v0
.end method

.method private final synthetic zzaF(Lcom/android/billingclient/api/BillingConfigResponseListener;)Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    const/16 v2, 0xd

    if-nez v1, :cond_0

    const-string v1, "BillingClient"

    const-string v3, "Service disconnected."

    .line 2
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 3
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 4
    invoke-interface {p1, v3, v0}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    goto/16 :goto_0

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    if-nez v1, :cond_1

    const-string v1, "BillingClient"

    const-string v3, "Current client doesn\'t support get billing config."

    .line 5
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzF:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzz:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 7
    invoke-interface {p1, v3, v0}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    goto/16 :goto_0

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 8
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 9
    :try_start_2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbb(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_2
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzh()Z

    move-result v1

    if-eqz v1, :cond_4

    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 10
    sget-object v4, Lcom/android/billingclient/api/zzdf;->zza:Lcom/android/billingclient/api/zzdf;

    .line 11
    invoke-virtual {v4}, Lcom/android/billingclient/api/zzdf;->zza()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x18

    .line 12
    invoke-static {v1, v5, v3, v4}, Lcom/android/billingclient/api/zzdg;->zzb(Ljava/lang/String;ILandroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzej;

    move-result-object v3

    .line 13
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzih;->zza()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v4

    const-string v5, "PLAY_BILLING_LIBRARY_VERSION"

    .line 14
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v6

    invoke-virtual {v6, v1}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 15
    invoke-virtual {v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v1, "CALLING_PACKAGE"

    .line 16
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 17
    invoke-virtual {v4, v1, v5}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 18
    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzih;

    .line 19
    invoke-static {v3, v1}, Lcom/android/billingclient/api/zzdg;->zza(Lcom/google/android/gms/internal/play_billing/zzej;Lcom/google/android/gms/internal/play_billing/zzih;)Landroid/os/Bundle;

    move-result-object v1

    .line 20
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    const-string v3, "accountName"

    .line 21
    invoke-virtual {v1, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    new-instance v3, Lcom/android/billingclient/api/zzdq;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 22
    invoke-direct {v3, p1, v4, v5}, Lcom/android/billingclient/api/zzdq;-><init>(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/zzcz;I)V

    invoke-interface {v2, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzar;->zzm(Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzac;)V

    goto :goto_0

    :cond_4
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 23
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 24
    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 25
    sget v6, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    const-string v6, "9.0.0"

    new-instance v7, Landroid/os/Bundle;

    .line 26
    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 27
    invoke-static {v7, v6, v3, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    .line 28
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "accountName"

    .line 29
    invoke-virtual {v7, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    new-instance v3, Lcom/android/billingclient/api/zzca;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 25
    invoke-direct {v3, p1, v4, v5, v0}, Lcom/android/billingclient/api/zzca;-><init>(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V

    const/16 v4, 0x12

    .line 30
    invoke-interface {v2, v4, v1, v7, v3}, Lcom/google/android/gms/internal/play_billing/zzar;->zzo(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzag;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception v2

    .line 8
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v1

    .line 31
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaj:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbb(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception v1

    .line 32
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaj:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbb(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final synthetic zzaG(Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, -0x1

    const/4 v1, 0x0

    .line 1
    :try_start_0
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v3, :cond_0

    :try_start_2
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    invoke-direct {p0, v0, p1, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbe(ILcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 3
    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Lcom/android/billingclient/api/zzcg;

    new-instance v5, Ljava/lang/ref/WeakReference;

    invoke-direct {v5, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v4, v5, p3, v1}, Lcom/android/billingclient/api/zzcg;-><init>(Ljava/lang/ref/WeakReference;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/zzci;)V

    const/16 p2, 0xc

    .line 4
    invoke-interface {v3, p2, v2, p1, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzt(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzat;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception p1

    .line 1
    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p1
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p1

    const/4 p2, 0x6

    .line 6
    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 5
    invoke-direct {p0, p2, p3, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbe(ILcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception p1

    .line 4
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    invoke-direct {p0, v0, p2, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbe(ILcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v1
.end method

.method private final zzaH(Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/String;
    .locals 1

    const/4 p1, 0x0

    .line 1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    return-object p1

    :cond_0
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 2
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private static zzaI()Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    .line 1
    :try_start_0
    const-string v1, "com.android.billingclient.ktx.BuildConfig"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v2, "VERSION_NAME"

    .line 2
    invoke-virtual {v1, v2}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 3
    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    :catch_0
    return-object v0
.end method

.method private final synthetic zzaJ(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)Ljava/lang/Void;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    if-nez v1, :cond_1

    const-string v1, "BillingClient"

    const-string v2, "Current client doesn\'t support alternative billing only."

    .line 3
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzD:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzan:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 6
    :try_start_2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 8
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 9
    invoke-static {v3, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzh(Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    move-result-object v3

    new-instance v4, Lcom/android/billingclient/api/zzbx;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    invoke-direct {v4, p1, v5, v6, v0}, Lcom/android/billingclient/api/zzbx;-><init>(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V

    const/16 v5, 0x15

    .line 10
    invoke-interface {v2, v5, v1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzk(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzx;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception v2

    .line 5
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v1

    .line 11
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzar:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception v1

    .line 12
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzar:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final synthetic zzaK(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;)Ljava/lang/Void;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    const-string v0, "0"

    const/4 v1, 0x0

    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v2

    if-nez v2, :cond_0

    .line 2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_1

    :cond_0
    iget-boolean v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzD:Z

    if-nez v2, :cond_1

    const-string p2, "BillingClient"

    const-string v0, "Current client doesn\'t support the provided billing program."

    .line 3
    invoke-static {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzG:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbp:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_1

    :cond_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v3, :cond_2

    .line 39
    :try_start_2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_1

    :cond_2
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 6
    sget-object v5, Lcom/android/billingclient/api/zzdf;->zzc:Lcom/android/billingclient/api/zzdf;

    .line 7
    invoke-virtual {v5}, Lcom/android/billingclient/api/zzdf;->zza()Ljava/lang/String;

    move-result-object v5

    const/16 v6, 0x18

    .line 8
    invoke-static {v2, v6, v4, v5}, Lcom/android/billingclient/api/zzdg;->zzb(Ljava/lang/String;ILandroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzej;

    move-result-object v4

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzih;->zza()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v5

    const-string v6, "PLAY_BILLING_LIBRARY_VERSION"

    .line 10
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v7}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 11
    invoke-virtual {v5, v6, v2}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v2, "CALLING_PACKAGE"

    .line 12
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v6

    iget-object v7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v6

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 13
    invoke-virtual {v5, v2, v6}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v2, "BILLING_PROGRAM"

    .line 14
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v6

    .line 15
    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->getBillingProgram()I

    move-result v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 16
    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v6

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 17
    invoke-virtual {v5, v2, v6}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v2, "RESPONSE_FORMAT"

    .line 18
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v6

    const-string v7, "RESPONSE_FORMAT_PROTO"

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v6

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 19
    invoke-virtual {v5, v2, v6}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 20
    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->getBillingProgram()I

    move-result v2

    const/4 v6, 0x3

    if-ne v2, v6, :cond_3

    const-string v0, "APP_INSTALL_TIME_MILLIS"

    .line 21
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v2

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 22
    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    iget-object v7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 23
    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    iget-wide v6, v6, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    .line 24
    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    .line 25
    invoke-virtual {v2, v6}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 26
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 27
    invoke-virtual {v5, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    goto :goto_0

    .line 28
    :cond_3
    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->getBillingProgram()I

    move-result v2

    const/4 v6, 0x5

    if-ne v2, v6, :cond_4

    const-string v2, "DEVELOPER_BILLING_TYPE"

    .line 29
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v6

    .line 30
    invoke-virtual {v6, v0}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    .line 31
    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 32
    invoke-virtual {v5, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 33
    :cond_4
    :goto_0
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzih;

    .line 34
    invoke-static {v4, v0}, Lcom/android/billingclient/api/zzdg;->zza(Lcom/google/android/gms/internal/play_billing/zzej;Lcom/google/android/gms/internal/play_billing/zzih;)Landroid/os/Bundle;

    move-result-object v0

    new-instance v2, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;

    .line 35
    invoke-virtual {p2}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->getBillingProgram()I

    move-result v6

    iget-object v7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v8, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 36
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v9

    .line 37
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v10

    move-object v4, v2

    move-object v5, p1

    invoke-direct/range {v4 .. v10}, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;-><init>(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;ILcom/android/billingclient/api/zzcz;ILandroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V

    .line 38
    invoke-interface {v3, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzar;->zzm(Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzac;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    :catchall_0
    move-exception p2

    .line 5
    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p2

    .line 40
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v0, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_1

    :catch_1
    move-exception p2

    .line 41
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v0, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_1
    return-object v1
.end method

.method private final synthetic zzaL(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)Ljava/lang/Void;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    if-nez v1, :cond_1

    const-string v1, "BillingClient"

    const-string v2, "Current client doesn\'t support external offer."

    .line 3
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzu:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaE:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 6
    :try_start_2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 8
    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 9
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-wide v3, v3, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 10
    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    .line 11
    sget v8, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    const-string v8, "9.0.0"

    new-instance v9, Landroid/os/Bundle;

    .line 12
    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 13
    invoke-static {v9, v8, v5, v6, v7}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    const-string v5, "appInstallTimeMillis"

    .line 14
    invoke-virtual {v9, v5, v3, v4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    new-instance v3, Lcom/android/billingclient/api/zzby;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 11
    invoke-direct {v3, p1, v4, v5, v0}, Lcom/android/billingclient/api/zzby;-><init>(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V

    const/16 v4, 0x16

    .line 15
    invoke-interface {v2, v4, v1, v9, v3}, Lcom/google/android/gms/internal/play_billing/zzar;->zzl(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzz;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception v2

    .line 5
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v1

    .line 16
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaF:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception v1

    .line 17
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaF:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final synthetic zzaM(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)Ljava/lang/Void;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_0
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzD:Z

    if-nez v0, :cond_1

    const-string v0, "BillingClient"

    const-string v1, "Current client doesn\'t support the provided billing program."

    .line 3
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object v5, Lcom/android/billingclient/api/zzdc;->zzG:Lcom/android/billingclient/api/BillingResult;

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbp:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v7, 0x0

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    invoke-direct/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v1, :cond_2

    .line 21
    :try_start_2
    sget-object v5, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v7, 0x0

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    invoke-direct/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_2
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 6
    sget-object v3, Lcom/android/billingclient/api/zzdf;->zzb:Lcom/android/billingclient/api/zzdf;

    .line 7
    invoke-virtual {v3}, Lcom/android/billingclient/api/zzdf;->zza()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x18

    .line 8
    invoke-static {v0, v4, v2, v3}, Lcom/android/billingclient/api/zzdg;->zzb(Ljava/lang/String;ILandroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzej;

    move-result-object v2

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzih;->zza()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v3

    const-string v4, "PLAY_BILLING_LIBRARY_VERSION"

    .line 10
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v5

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 11
    invoke-virtual {v3, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v0, "CALLING_PACKAGE"

    .line 12
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v4

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 13
    invoke-virtual {v3, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    const-string v0, "BILLING_PROGRAM"

    .line 14
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzja;->zza()Lcom/google/android/gms/internal/play_billing/zziy;

    move-result-object v4

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/play_billing/zziy;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zziy;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzja;

    .line 15
    invoke-virtual {v3, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzie;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzja;)Lcom/google/android/gms/internal/play_billing/zzie;

    .line 16
    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzih;

    .line 17
    invoke-static {v2, v0}, Lcom/android/billingclient/api/zzdg;->zza(Lcom/google/android/gms/internal/play_billing/zzej;Lcom/google/android/gms/internal/play_billing/zzih;)Landroid/os/Bundle;

    move-result-object v0

    new-instance v9, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 18
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v7

    .line 19
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v8

    move-object v2, v9

    move-object v3, p1

    move v4, p2

    invoke-direct/range {v2 .. v8}, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;-><init>(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/zzcz;ILandroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V

    .line 20
    invoke-interface {v1, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzar;->zzm(Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzac;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception v1

    .line 5
    :try_start_3
    monitor-exit v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v1
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v0

    move-object v6, v0

    .line 22
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v6, v0

    .line 23
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaj:Lcom/google/android/gms/internal/play_billing/zzjn;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    const/4 p1, 0x0

    return-object p1
.end method

.method private final synthetic zzaN(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)Ljava/lang/Void;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v1

    invoke-direct {p0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    if-nez v1, :cond_1

    const-string v1, "BillingClient"

    const-string v2, "Current client doesn\'t support external offer."

    .line 3
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzu:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaE:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 5
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_2

    .line 6
    :try_start_2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 7
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 8
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 9
    invoke-static {v3, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzh(Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    move-result-object v3

    new-instance v4, Lcom/android/billingclient/api/zzcf;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    invoke-direct {v4, p1, v5, v6, v0}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/zzcz;ILcom/android/billingclient/api/zzci;)V

    const/16 v5, 0x18

    .line 10
    invoke-interface {v2, v5, v1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzs(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzao;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception v2

    .line 5
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v1

    .line 11
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaC:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception v1

    .line 12
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaC:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final synthetic zzaO(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_0

    .line 2
    :try_start_2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 3
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 4
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 5
    invoke-static {v3, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzh(Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    move-result-object v3

    new-instance v4, Lcom/android/billingclient/api/zzbz;

    new-instance v5, Ljava/lang/ref/WeakReference;

    invoke-direct {v5, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v4, v5, p3, v0}, Lcom/android/billingclient/api/zzbz;-><init>(Ljava/lang/ref/WeakReference;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/zzci;)V

    const/16 p2, 0x15

    .line 6
    invoke-interface {v2, p2, v1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzn(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzae;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception p2

    .line 1
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p2

    .line 7
    sget-object p3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzav:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p3, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception p2

    .line 8
    sget-object p3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzav:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p3, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final synthetic zzaP(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Void;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    .line 1
    :try_start_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_0

    .line 2
    :try_start_2
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 3
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 4
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 5
    invoke-static {v3, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzh(Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    move-result-object v3

    new-instance v4, Lcom/android/billingclient/api/zzcb;

    new-instance v5, Ljava/lang/ref/WeakReference;

    invoke-direct {v5, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v4, v5, p3, v0}, Lcom/android/billingclient/api/zzcb;-><init>(Ljava/lang/ref/WeakReference;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/zzci;)V

    const/16 p2, 0x16

    .line 6
    invoke-interface {v2, p2, v1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzar;->zzp(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzai;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catchall_0
    move-exception p2

    .line 1
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p2
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p2

    .line 7
    sget-object p3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaJ:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p3, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    goto :goto_0

    :catch_1
    move-exception p2

    .line 8
    sget-object p3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaJ:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-direct {p0, p1, p3, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :goto_0
    return-object v0
.end method

.method private final zzaQ(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    :try_start_0
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object p2

    invoke-interface {p2, p1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3
    new-instance p2, Lcom/android/billingclient/api/zzbk;

    invoke-direct {p2, p1, p4}, Lcom/android/billingclient/api/zzbk;-><init>(Ljava/util/concurrent/Future;Ljava/lang/Runnable;)V

    const-wide/16 p3, 0x6f54

    .line 4
    invoke-virtual {p5, p2, p3, p4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-object p1

    :catch_0
    move-exception p1

    .line 1
    const-string p2, "BillingClient"

    const-string p3, "Async task throws exception!"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 3
    throw p1
.end method

.method private final zzaR(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .locals 9

    const-string v0, "Error consuming purchase with token. Response code: "

    const-string v1, "Consuming purchase with token: "

    .line 1
    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    :try_start_0
    const-string v2, "BillingClient"

    new-instance v3, Ljava/lang/StringBuilder;

    .line 2
    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 3
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_0

    .line 4
    :try_start_2
    sget-object v5, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v7, "Service has been reset to null."

    const/4 v8, 0x0

    move-object v2, p0

    move-object v3, p2

    move-object v4, p1

    invoke-direct/range {v2 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaV(Lcom/android/billingclient/api/ConsumeResponseListener;Ljava/lang/String;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)V

    return-void

    :cond_0
    iget-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 5
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-boolean v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 6
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    const-string v7, "9.0.0"

    new-instance v8, Landroid/os/Bundle;

    .line 7
    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    if-eqz v3, :cond_1

    .line 8
    invoke-static {v8, v7, v4, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    :cond_1
    const/16 v3, 0x9

    .line 9
    invoke-interface {v2, v3, v1, p1, v8}, Lcom/google/android/gms/internal/play_billing/zzar;->zze(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "RESPONSE_CODE"

    .line 10
    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    const-string v3, "BillingClient"

    .line 11
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 15
    :cond_2
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 12
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x3

    .line 13
    invoke-interface {v2, v3, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzar;->zza(ILjava/lang/String;Ljava/lang/String;)I

    move-result v2

    const-string v1, ""

    .line 14
    :goto_0
    invoke-static {v2, v1}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v5

    if-nez v2, :cond_3

    const-string v0, "BillingClient"

    const-string v1, "Successfully consumed purchase."

    .line 16
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    invoke-interface {p2, v5, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void

    :cond_3
    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 15
    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    move-object v2, p0

    move-object v3, p2

    move-object v4, p1

    invoke-direct/range {v2 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaV(Lcom/android/billingclient/api/ConsumeResponseListener;Ljava/lang/String;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)V
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    return-void

    :catchall_0
    move-exception v0

    .line 3
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v0

    move-object v8, v0

    .line 18
    sget-object v5, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzC:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v7, "Error consuming purchase!"

    move-object v2, p0

    move-object v3, p2

    move-object v4, p1

    invoke-direct/range {v2 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaV(Lcom/android/billingclient/api/ConsumeResponseListener;Ljava/lang/String;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)V

    return-void

    :catch_1
    move-exception v0

    move-object v8, v0

    .line 19
    sget-object v5, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzC:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v7, "Error consuming purchase!"

    move-object v2, p0

    move-object v3, p2

    move-object v4, p1

    invoke-direct/range {v2 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaV(Lcom/android/billingclient/api/ConsumeResponseListener;Ljava/lang/String;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)V

    return-void
.end method

.method private final zzaS(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 2

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "Error in acknowledge purchase!"

    invoke-static {v0, v1, p4}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x3

    .line 2
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 3
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 4
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0xe

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 3
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x21

    .line 1
    invoke-static {p5}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p5

    .line 2
    invoke-direct {p0, p4, v0, p3, p5}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    new-instance p4, Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;

    invoke-direct {p4, p2}, Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;-><init>(I)V

    .line 3
    invoke-interface {p1, p3, p4}, Lcom/android/billingclient/api/BillingProgramAvailabilityListener;->onBillingProgramAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;)V

    return-void
.end method

.method private final zzaV(Lcom/android/billingclient/api/ConsumeResponseListener;Ljava/lang/String;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 1

    .line 1
    const-string v0, "BillingClient"

    invoke-static {v0, p5, p6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p5, 0x4

    .line 2
    invoke-static {p6}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p6

    .line 3
    invoke-direct {p0, p4, p5, p3, p6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 4
    invoke-interface {p1, p3, p2}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void
.end method

.method private final zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0xf

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    const/4 p3, 0x0

    .line 3
    invoke-interface {p1, p2, p3}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    return-void
.end method

.method private final zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x23

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    const/4 p3, 0x0

    .line 3
    invoke-interface {p1, p2, p3}, Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;->onCreateBillingProgramReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramReportingDetails;)V

    return-void
.end method

.method private final zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x18

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    const/4 p3, 0x0

    .line 3
    invoke-interface {p1, p2, p3}, Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;->onExternalOfferReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V

    return-void
.end method

.method private final zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x17

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 3
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;->onExternalOfferAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method public static synthetic zzaa(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzab(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public static synthetic zzac(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method static bridge synthetic zzad(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    return-void
.end method

.method static bridge synthetic zzae(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzar;)V
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    return-void
.end method

.method static bridge synthetic zzaf(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    return-void
.end method

.method static bridge synthetic zzag(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:Z

    return-void
.end method

.method static bridge synthetic zzah(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzcf;)V
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    return-void
.end method

.method static bridge synthetic zzai(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 0

    const/4 p4, 0x0

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method static bridge synthetic zzaj(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 0

    const/4 p4, 0x0

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method static bridge synthetic zzak(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 0

    const/4 p4, 0x0

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method static bridge synthetic zzal(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjg;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    return-void
.end method

.method static bridge synthetic zzam(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjk;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbh(Lcom/google/android/gms/internal/play_billing/zzjk;)V

    return-void
.end method

.method static bridge synthetic zzan(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    return-void
.end method

.method static bridge synthetic zzao(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .locals 3

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    const/16 v0, 0x1c

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-lt p1, v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzE:Z

    const/16 v0, 0x1b

    if-lt p1, v0, :cond_1

    move v0, v1

    goto :goto_1

    :cond_1
    move v0, v2

    :goto_1
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzD:Z

    const/16 v0, 0x1a

    if-lt p1, v0, :cond_2

    move v0, v1

    goto :goto_2

    :cond_2
    move v0, v2

    :goto_2
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzC:Z

    const/16 v0, 0x18

    if-lt p1, v0, :cond_3

    move v0, v1

    goto :goto_3

    :cond_3
    move v0, v2

    :goto_3
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    const/16 v0, 0x17

    if-lt p1, v0, :cond_4

    move v0, v1

    goto :goto_4

    :cond_4
    move v0, v2

    :goto_4
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Z

    const/16 v0, 0x16

    if-lt p1, v0, :cond_5

    move v0, v1

    goto :goto_5

    :cond_5
    move v0, v2

    :goto_5
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    const/16 v0, 0x15

    if-lt p1, v0, :cond_6

    move v0, v1

    goto :goto_6

    :cond_6
    move v0, v2

    :goto_6
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    const/16 v0, 0x14

    if-lt p1, v0, :cond_7

    move v0, v1

    goto :goto_7

    :cond_7
    move v0, v2

    :goto_7
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    const/16 v0, 0x13

    if-lt p1, v0, :cond_8

    move v0, v1

    goto :goto_8

    :cond_8
    move v0, v2

    :goto_8
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    const/16 v0, 0x12

    if-lt p1, v0, :cond_9

    move v0, v1

    goto :goto_9

    :cond_9
    move v0, v2

    :goto_9
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    const/16 v0, 0x11

    if-lt p1, v0, :cond_a

    move v0, v1

    goto :goto_a

    :cond_a
    move v0, v2

    :goto_a
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    const/16 v0, 0x10

    if-lt p1, v0, :cond_b

    move v0, v1

    goto :goto_b

    :cond_b
    move v0, v2

    :goto_b
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    const/16 v0, 0xf

    if-lt p1, v0, :cond_c

    move v0, v1

    goto :goto_c

    :cond_c
    move v0, v2

    :goto_c
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    const/16 v0, 0xe

    if-lt p1, v0, :cond_d

    move v0, v1

    goto :goto_d

    :cond_d
    move v0, v2

    :goto_d
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    const/16 v0, 0xc

    if-lt p1, v0, :cond_e

    move v0, v1

    goto :goto_e

    :cond_e
    move v0, v2

    :goto_e
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    const/16 v0, 0x9

    if-lt p1, v0, :cond_f

    move v0, v1

    goto :goto_f

    :cond_f
    move v0, v2

    :goto_f
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    const/16 v0, 0x8

    if-lt p1, v0, :cond_10

    move v0, v1

    goto :goto_10

    :cond_10
    move v0, v2

    :goto_10
    iput-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzo:Z

    const/4 v0, 0x6

    if-lt p1, v0, :cond_11

    goto :goto_11

    :cond_11
    move v1, v2

    :goto_11
    iput-boolean v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    return-void
.end method

.method static bridge synthetic zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .locals 0

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    return-void
.end method

.method static bridge synthetic zzaq(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .locals 2

    if-nez p1, :cond_3

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter p1

    :try_start_0
    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    monitor-exit p1

    return-void

    :cond_0
    const/4 v0, 0x2

    .line 2
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    .line 3
    :goto_0
    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_2

    iget-boolean p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    .line 4
    invoke-virtual {v0, p0}, Lcom/android/billingclient/api/zzab;->zzj(Z)V

    :cond_2
    return-void

    :catchall_0
    move-exception p0

    .line 3
    :try_start_1
    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0

    :cond_3
    const/4 p1, 0x0

    .line 5
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    return-void
.end method

.method static bridge synthetic zzar(Lcom/android/billingclient/api/BillingClientImpl;)V
    .locals 0

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbm()V

    return-void
.end method

.method static bridge synthetic zzat(Lcom/android/billingclient/api/BillingClientImpl;J)Z
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result p0

    return p0
.end method

.method static bridge synthetic zzau(Lcom/android/billingclient/api/BillingClientImpl;)Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    iget p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v1, 0x1

    if-ne p0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    monitor-exit v0

    return v1

    :catchall_0
    move-exception p0

    .line 2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p0
.end method

.method static bridge synthetic zzav(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;ZI)Lcom/android/billingclient/api/zzed;
    .locals 0

    const/16 p3, 0x9

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbt(Ljava/lang/String;ZI)Lcom/android/billingclient/api/zzed;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzaw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final synthetic zzax(ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    :try_start_0
    iget-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter p4
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    monitor-exit p4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_0

    .line 2
    :try_start_2
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzd(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1

    :cond_0
    iget-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 3
    invoke-virtual {p4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    move v1, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, p5

    .line 4
    invoke-interface/range {v0 .. v6}, Lcom/google/android/gms/internal/play_billing/zzar;->zzg(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p1
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    return-object p1

    :catchall_0
    move-exception p1

    .line 1
    :try_start_3
    monitor-exit p4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p1
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p1

    .line 5
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zze:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p1

    .line 5
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zze(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1

    :catch_1
    move-exception p1

    .line 7
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p3, Lcom/google/android/gms/internal/play_billing/zzjn;->zze:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 8
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p1

    .line 7
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zze(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1
.end method

.method private final synthetic zzay(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v1, :cond_0

    .line 2
    :try_start_2
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzd(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1

    :cond_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 3
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v6, 0x0

    const/4 v2, 0x3

    move-object v4, p1

    move-object v5, p2

    .line 4
    invoke-interface/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzar;->zzf(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    return-object p1

    :catchall_0
    move-exception p1

    .line 1
    :try_start_3
    monitor-exit v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw p1
    :try_end_4
    .catch Landroid/os/DeadObjectException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception p1

    .line 5
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zze:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p1

    .line 5
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zze(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1

    :catch_1
    move-exception p1

    .line 7
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zze:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 8
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p1

    .line 7
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zze(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1
.end method

.method private final zzaz()Landroid/os/Handler;
    .locals 2

    .line 1
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    goto :goto_0

    :cond_0
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    :goto_0
    return-object v0
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/BillingClientImpl;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    return p0
.end method

.method private zzbA(I)V
    .locals 2

    .line 1
    :try_start_0
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p1, v0}, Lcom/android/billingclient/api/zzcy;->zzc(ILcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjk;

    move-result-object p1

    .line 1
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbh(Lcom/google/android/gms/internal/play_billing/zzjk;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingClient"

    const-string v1, "Unable to log."

    .line 3
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzba(Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x19

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 3
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;->onExternalOfferInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzbb(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 2

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "getBillingConfig got an exception."

    invoke-static {v0, v1, p4}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/16 v0, 0xd

    .line 2
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 3
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    const/4 p3, 0x0

    .line 4
    invoke-interface {p1, p2, p3}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method

.method private final zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x25

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 3
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;->onLaunchExternalLinkResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzbd(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 1

    const/16 v0, 0x10

    .line 1
    invoke-static {p4}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p4

    .line 2
    invoke-direct {p0, p3, v0, p2, p4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 3
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;->onAlternativeBillingOnlyInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzbe(ILcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V
    .locals 2

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "showInAppMessages error."

    invoke-static {v0, v1, p3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    .line 2
    invoke-static {p3}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object p3

    .line 3
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    if-eqz p2, :cond_0

    .line 4
    invoke-virtual {v1, p2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    :cond_0
    if-eqz p3, :cond_1

    .line 5
    invoke-virtual {v1, p3}, Lcom/google/android/gms/internal/play_billing/zzjl;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 6
    :cond_1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object p1

    .line 7
    invoke-virtual {p1, v1}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    const/16 p2, 0x1e

    .line 8
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 9
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    .line 11
    const-string p2, "BillingLogger"

    const-string p3, "Unable to create logging payload"

    .line 10
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p1, 0x0

    .line 11
    :goto_0
    invoke-interface {v0, p1}, Lcom/android/billingclient/api/zzcz;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    return-void
.end method

.method private final zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/zzcz;->zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingClient"

    const-string v1, "Unable to log."

    .line 2
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbg(Lcom/google/android/gms/internal/play_billing/zzjg;JZ)V
    .locals 6

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    invoke-interface/range {v0 .. v5}, Lcom/android/billingclient/api/zzcz;->zze(Lcom/google/android/gms/internal/play_billing/zzjg;IJZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbh(Lcom/google/android/gms/internal/play_billing/zzjk;)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/zzcz;->zzg(Lcom/google/android/gms/internal/play_billing/zzjk;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingClient"

    const-string v1, "Unable to log."

    .line 2
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V
    .locals 3

    .line 1
    :try_start_0
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    const/4 v1, 0x6

    const/4 v2, 0x0

    .line 2
    invoke-static {p1, v1, p2, v2, v0}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzje;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object p2

    if-lez p3, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 4
    :goto_0
    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 5
    invoke-virtual {p2, p3}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 6
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzje;->zze(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 7
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;

    .line 8
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 9
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbj(I)V
    .locals 6

    const-string v0, "Setting clientState from "

    .line 1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    monitor-exit v1

    return-void

    :cond_0
    const-string v2, "BillingClient"

    iget v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    invoke-static {v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbq(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbq(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    .line 2
    invoke-direct {v5, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, " to "

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    .line 4
    monitor-exit v1

    return-void

    :catchall_0
    move-exception p1

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p1
.end method

.method private final declared-synchronized zzbk()V
    .locals 1

    monitor-enter p0

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzK:Ljava/util/concurrent/ExecutorService;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzK:Ljava/util/concurrent/ExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private final zzbl(Lcom/android/billingclient/api/BillingClientStateListener;I)V
    .locals 7

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2
    invoke-direct {p0, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaB(I)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    monitor-exit v0

    goto/16 :goto_3

    .line 43
    :cond_0
    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    const-string v1, "BillingClient"

    const-string v2, "Client is already in the process of connecting to billing service."

    .line 3
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzK:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 4
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzd:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v1, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 5
    monitor-exit v0

    :goto_0
    move-object p2, v2

    goto/16 :goto_3

    :cond_1
    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v3, 0x3

    if-ne v1, v3, :cond_2

    const-string v1, "BillingClient"

    const-string v2, "Client was already closed and can\'t be reused. Please create another instance."

    .line 6
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzL:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v1, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 8
    monitor-exit v0

    goto :goto_0

    .line 9
    :cond_2
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    const/4 v1, 0x0

    if-nez p2, :cond_3

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzJ:Lcom/android/billingclient/api/BillingClientStateListener;

    move p2, v1

    .line 10
    :cond_3
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbm()V

    const-string v3, "BillingClient"

    const-string v4, "Starting in-app billing setup."

    .line 11
    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v3, Lcom/android/billingclient/api/zzbw;

    const/4 v4, 0x0

    .line 12
    invoke-direct {v3, p0, p1, p2, v4}, Lcom/android/billingclient/api/zzbw;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingClientStateListener;ILcom/android/billingclient/api/zzci;)V

    iput-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    .line 13
    invoke-virtual {v3}, Lcom/android/billingclient/api/zzbw;->zzf()V

    .line 14
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    new-instance v0, Landroid/content/Intent;

    const-string v3, "com.android.vending.billing.InAppBillingService.BIND"

    .line 15
    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v3, "com.android.vending"

    .line 16
    invoke-virtual {v0, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 17
    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 18
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_a

    .line 19
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 20
    iget-object v5, v3, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v5, :cond_9

    .line 21
    iget-object v5, v3, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v5, v5, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    .line 22
    iget-object v3, v3, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v3, v3, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    const-string v6, "com.android.vending"

    .line 23
    invoke-static {v5, v6}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    if-eqz v3, :cond_8

    new-instance v6, Landroid/content/ComponentName;

    .line 24
    invoke-direct {v6, v5, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v3, Landroid/content/Intent;

    .line 25
    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 26
    invoke-virtual {v3, v6}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    const-string v5, "playBillingLibraryVersion"

    .line 27
    invoke-virtual {v3, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_1
    iget v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v6, 0x2

    if-ne v5, v6, :cond_4

    .line 28
    invoke-direct {p0, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaB(I)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    monitor-exit v0

    goto/16 :goto_3

    :cond_4
    iget v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    if-eq v5, v2, :cond_5

    const-string v1, "BillingClient"

    const-string v2, "Client state no longer CONNECTING, returning service disconnected."

    .line 29
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzba:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 30
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v1, v2, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 31
    monitor-exit v0

    goto/16 :goto_0

    :cond_5
    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    .line 32
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-lez p2, :cond_6

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x1d

    if-lt v0, v6, :cond_6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 33
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    .line 34
    invoke-virtual {v0, v3, v2, v6, v5}, Landroid/content/Context;->bindService(Landroid/content/Intent;ILjava/util/concurrent/Executor;Landroid/content/ServiceConnection;)Z

    move-result v0

    goto :goto_1

    .line 42
    :cond_6
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 35
    invoke-virtual {v0, v3, v5, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    :goto_1
    if-eqz v0, :cond_7

    .line 34
    const-string p2, "BillingClient"

    const-string v0, "Service was bonded successfully."

    .line 36
    invoke-static {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    move-object p2, v4

    goto :goto_3

    :cond_7
    const-string v0, "BillingClient"

    const-string v2, "Connection to Billing service is blocked."

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzM:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 37
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :catchall_0
    move-exception p1

    .line 32
    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw p1

    .line 35
    :cond_8
    const-string v0, "BillingClient"

    const-string v2, "The device doesn\'t have valid Play Store."

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzN:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 38
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_9
    const-string v0, "BillingClient"

    const-string v2, "The device doesn\'t have valid Play Store."

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzN:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 39
    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_a
    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzO:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 40
    :goto_2
    invoke-direct {p0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    const-string v0, "BillingClient"

    const-string v1, "Billing service unavailable on device."

    .line 41
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzb:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v3, v0, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbi(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    move-object p2, v0

    :goto_3
    if-eqz p2, :cond_b

    .line 43
    invoke-interface {p1, p2}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    :cond_b
    return-void

    :catchall_1
    move-exception p1

    .line 14
    :try_start_3
    monitor-exit v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw p1
.end method

.method private final zzbm()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    invoke-virtual {v2, v3}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_0

    :catchall_0
    move-exception v2

    .line 4
    :try_start_3
    const-string v3, "BillingClient"

    const-string v4, "There was an exception while unbinding service!"

    .line 2
    invoke-static {v3, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :try_start_4
    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    goto :goto_0

    :catchall_1
    move-exception v2

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    .line 3
    throw v2

    .line 4
    :cond_0
    :goto_0
    monitor-exit v0

    return-void

    :catchall_2
    move-exception v1

    monitor-exit v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v1
.end method

.method private final zzbn(J)Z
    .locals 5

    .line 1
    const-string v0, "BillingClient"

    .line 0
    const-string v1, "Reconnection succeeded with result: "

    const-string v2, "Reconnection failed with result: "

    .line 1
    :try_start_0
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x1d

    if-ge v3, v4, :cond_0

    const-wide/16 p1, 0x0

    :cond_0
    const/4 v3, 0x1

    invoke-direct {p0, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaD(I)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object v3

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, p1, p2, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/android/billingclient/api/BillingResult;

    .line 2
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p2

    if-nez p2, :cond_1

    .line 3
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p1

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 4
    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 5
    :cond_1
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p1

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    .line 6
    instance-of p2, p1, Ljava/lang/InterruptedException;

    if-eqz p2, :cond_2

    .line 7
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Thread;->interrupt()V

    :cond_2
    const-string p2, "Error during reconnection attempt: "

    .line 8
    invoke-static {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 9
    :goto_0
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result p1

    return p1
.end method

.method private final zzbo(J)Z
    .locals 12

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzb(Lcom/google/android/gms/internal/play_billing/zzbq;)Lcom/google/android/gms/internal/play_billing/zzbn;

    move-result-object v0

    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zza()I

    move-result v1

    const/4 v2, 0x1

    move-wide v3, p1

    :goto_0
    const-string v5, "BillingClient"

    if-gt v2, v1, :cond_5

    const-wide/16 v6, 0x0

    .line 2
    :try_start_0
    invoke-static {v6, v7, v3, v4}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    cmp-long v8, v3, v6

    if-gtz v8, :cond_0

    const-string v3, "No time remaining for reconnection attempt."

    .line 3
    invoke-static {v5, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result p1

    return p1

    .line 5
    :cond_0
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaD(I)Lcom/google/android/gms/internal/play_billing/zzdk;

    move-result-object v8

    sget-object v9, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 6
    invoke-interface {v8, v3, v4, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/billingclient/api/BillingResult;

    .line 7
    invoke-virtual {v3}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v4

    if-nez v4, :cond_1

    .line 8
    invoke-virtual {v3}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Reconnection succeeded with result: "

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 9
    invoke-static {v5, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 10
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result p1

    return p1

    .line 11
    :cond_1
    invoke-virtual {v3}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Reconnection failed with result: "

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 12
    invoke-static {v5, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v3

    .line 13
    instance-of v4, v3, Ljava/lang/InterruptedException;

    if-eqz v4, :cond_2

    .line 14
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Thread;->interrupt()V

    :cond_2
    const-string v4, "Error during reconnection attempt: "

    .line 15
    invoke-static {v5, v4, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 12
    :goto_1
    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 16
    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzbn;->zza(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v3

    sub-long v3, p1, v3

    add-int/lit8 v8, v2, -0x1

    int-to-double v8, v8

    const-wide/high16 v10, 0x4000000000000000L    # 2.0

    .line 17
    invoke-static {v10, v11, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v8

    double-to-long v8, v8

    const-wide/16 v10, 0x3e8

    mul-long/2addr v8, v10

    cmp-long v10, v3, v8

    if-gez v10, :cond_3

    const-string p1, "Reconnection failed due to timeout limit reached."

    .line 20
    invoke-static {v5, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 21
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result p1

    return p1

    :cond_3
    if-ge v2, v1, :cond_4

    cmp-long v6, v8, v6

    if-lez v6, :cond_4

    .line 18
    :try_start_1
    invoke-static {v8, v9}, Ljava/lang/Thread;->sleep(J)V

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 19
    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzbn;->zza(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v3
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    sub-long v3, p1, v3

    goto :goto_2

    :catch_1
    move-exception p1

    .line 22
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Thread;->interrupt()V

    const-string p2, "Error sleeping during reconnection attempt: "

    .line 23
    invoke-static {v5, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    :cond_4
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    .line 19
    :cond_5
    :goto_3
    const-string p1, "Max retries reached."

    .line 24
    invoke-static {v5, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result p1

    return p1
.end method

.method private final zzbp()Z
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    const/4 v2, 0x2

    const/4 v3, 0x0

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    if-eqz v1, :cond_0

    const/4 v3, 0x1

    :cond_0
    monitor-exit v0

    return v3

    :catchall_0
    move-exception v1

    .line 2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static final zzbq(I)Ljava/lang/String;
    .locals 1

    if-eqz p0, :cond_2

    const/4 v0, 0x1

    if-eq p0, v0, :cond_1

    const/4 v0, 0x2

    if-eq p0, v0, :cond_0

    const-string p0, "CLOSED"

    return-object p0

    :cond_0
    const-string p0, "CONNECTED"

    return-object p0

    :cond_1
    const-string p0, "CONNECTING"

    return-object p0

    :cond_2
    const-string p0, "DISCONNECTED"

    return-object p0
.end method

.method private static final zzbr(Lcom/google/android/gms/internal/play_billing/zzjz;Landroid/content/Context;)V
    .locals 4

    .line 1
    :try_start_0
    const-string v0, "activity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/ActivityManager;

    if-eqz p1, :cond_0

    .line 2
    new-instance v0, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v0}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 3
    invoke-virtual {p1, v0}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 4
    iget-wide v0, v0, Landroid/app/ActivityManager$MemoryInfo;->totalMem:J

    const-wide/32 v2, 0x100000

    div-long/2addr v0, v2

    long-to-int p1, v0

    .line 5
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget-object p1, Landroid/os/Build;->BRAND:Ljava/lang/String;

    .line 6
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzr(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget-object p1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 7
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzu(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget-object p1, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 8
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzt(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;

    sget-object p1, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    .line 9
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzs(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjz;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    return-void

    :catch_0
    move-exception p0

    const-string p1, "BillingClient"

    const-string v0, "Runtime error while populating device info."

    .line 10
    invoke-static {p1, v0, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;
    .locals 1

    const/16 p1, 0x9

    .line 1
    invoke-static {p5}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p3, p1, p2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    const-string p1, "BillingClient"

    .line 2
    invoke-static {p1, p4, p5}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance p1, Lcom/android/billingclient/api/zzed;

    const/4 p3, 0x0

    invoke-direct {p1, p2, p3}, Lcom/android/billingclient/api/zzed;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-object p1
.end method

.method private final zzbt(Ljava/lang/String;ZI)Lcom/android/billingclient/api/zzed;
    .locals 16

    move-object/from16 v7, p0

    .line 1
    const-string v0, "Querying owned items, item type: "

    invoke-static/range {p1 .. p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "BillingClient"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/util/ArrayList;

    .line 2
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    iget-boolean v2, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    iget-object v3, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    .line 3
    invoke-virtual {v3}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForOneTimeProducts()Z

    move-result v3

    iget-object v4, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    .line 4
    invoke-virtual {v4}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForPrepaidPlans()Z

    move-result v4

    iget-object v5, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 5
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    new-instance v14, Landroid/os/Bundle;

    .line 6
    invoke-direct {v14}, Landroid/os/Bundle;-><init>()V

    const-string v8, "9.0.0"

    iget-object v9, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    .line 7
    invoke-static {v14, v8, v9, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    const/4 v5, 0x1

    if-eqz v1, :cond_0

    if-eqz v3, :cond_0

    const-string v1, "enablePendingPurchases"

    .line 8
    invoke-virtual {v14, v1, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_0
    if-eqz v2, :cond_1

    if-eqz v4, :cond_1

    const-string v1, "enablePendingPurchaseForSubscriptions"

    .line 9
    invoke-virtual {v14, v1, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_1
    const/4 v1, 0x0

    if-eqz p2, :cond_2

    const-string v2, "includeSuspendedSubscriptions"

    .line 10
    invoke-virtual {v14, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_2
    move-object v12, v1

    :goto_0
    :try_start_0
    iget-object v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :try_start_1
    iget-object v8, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 11
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v8, :cond_3

    .line 56
    :try_start_2
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v5, "Service has been reset to null"

    const/4 v6, 0x0

    const/16 v2, 0x9

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0

    :cond_3
    if-eqz p2, :cond_4

    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzC:Z

    if-nez v1, :cond_4

    .line 57
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzx:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbH:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v5, "Include suspended subscriptions is not supported"

    const/4 v6, 0x0

    const/16 v2, 0x9

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0

    :cond_4
    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-nez v1, :cond_5

    iget-object v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 14
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x3

    move-object/from16 v4, p1

    .line 15
    invoke-interface {v8, v3, v1, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzar;->zzh(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    goto :goto_3

    :cond_5
    move-object/from16 v4, p1

    .line 36
    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzC:Z

    if-eqz v1, :cond_6

    const/16 v1, 0x1a

    :goto_1
    move v9, v1

    goto :goto_2

    .line 13
    :cond_6
    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    if-eqz v1, :cond_7

    const/16 v1, 0x18

    goto :goto_1

    :cond_7
    iget-boolean v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    if-eqz v1, :cond_8

    const/16 v1, 0x13

    goto :goto_1

    :cond_8
    const/16 v9, 0x9

    .line 36
    :goto_2
    iget-object v1, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 12
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v11, p1

    move-object v13, v14

    .line 13
    invoke-interface/range {v8 .. v13}, Lcom/google/android/gms/internal/play_billing/zzar;->zzi(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 16
    :goto_3
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    const-string v6, "getPurchase()"

    const-string v8, "BillingClient"

    if-nez v1, :cond_9

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "%s got null owned items list"

    .line 17
    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzab:Lcom/google/android/gms/internal/play_billing/zzjn;

    :goto_4
    move-object v8, v6

    move-object v6, v3

    goto/16 :goto_6

    .line 18
    :cond_9
    invoke-static {v1, v8}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v9

    .line 19
    invoke-static {v1, v8}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object v11

    .line 20
    invoke-virtual {v11, v9}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    .line 21
    invoke-virtual {v11, v10}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    .line 22
    invoke-virtual {v11}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object v10

    if-eqz v9, :cond_a

    .line 23
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    filled-new-array {v6, v9}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "%s failed. Response code: %s"

    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 24
    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    move-object v8, v6

    move-object v6, v10

    goto/16 :goto_6

    :cond_a
    const-string v9, "INAPP_PURCHASE_ITEM_LIST"

    .line 25
    invoke-virtual {v1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_f

    const-string v9, "INAPP_PURCHASE_DATA_LIST"

    .line 26
    invoke-virtual {v1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_f

    const-string v9, "INAPP_DATA_SIGNATURE_LIST"

    .line 27
    invoke-virtual {v1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_b

    goto :goto_5

    .line 38
    :cond_b
    const-string v9, "INAPP_PURCHASE_ITEM_LIST"

    .line 28
    invoke-virtual {v1, v9}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    const-string v10, "INAPP_PURCHASE_DATA_LIST"

    .line 29
    invoke-virtual {v1, v10}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    const-string v11, "INAPP_DATA_SIGNATURE_LIST"

    .line 30
    invoke-virtual {v1, v11}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v11

    if-nez v9, :cond_c

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "Bundle returned from %s contains null SKUs list."

    .line 31
    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 32
    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzad:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_4

    :cond_c
    if-nez v10, :cond_d

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "Bundle returned from %s contains null purchases list."

    .line 33
    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 34
    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzae:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto/16 :goto_4

    :cond_d
    if-nez v11, :cond_e

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "Bundle returned from %s contains null signatures list."

    .line 35
    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 36
    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaf:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto/16 :goto_4

    :cond_e
    sget-object v6, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    sget-object v8, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_6

    .line 27
    :cond_f
    :goto_5
    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v9, "Bundle returned from %s doesn\'t contain required fields."

    .line 37
    invoke-static {v9, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 38
    invoke-static {v8, v6}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzjn;->zzac:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto/16 :goto_4

    .line 17
    :goto_6
    sget-object v9, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    if-eq v6, v9, :cond_10

    const-string v5, "Purchase bundle invalid"

    const/4 v0, 0x0

    const/16 v2, 0x9

    move-object/from16 v1, p0

    move-object v3, v6

    move-object v4, v8

    move-object v6, v0

    .line 60
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0

    :cond_10
    const-string v6, "INAPP_PURCHASE_ITEM_LIST"

    .line 39
    invoke-virtual {v1, v6}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    const-string v8, "INAPP_PURCHASE_DATA_LIST"

    .line 40
    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v8

    const-string v9, "INAPP_DATA_SIGNATURE_LIST"

    .line 41
    invoke-virtual {v1, v9}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    const/4 v10, 0x0

    move v11, v10

    .line 42
    :goto_7
    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v12

    if-ge v10, v12, :cond_12

    .line 43
    invoke-virtual {v8, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 44
    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 45
    invoke-virtual {v6, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    invoke-static {v15}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    const-string v5, "Sku is owned: "

    const-string v2, "BillingClient"

    invoke-virtual {v5, v15}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 46
    invoke-static {v2, v5}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_3
    new-instance v2, Lcom/android/billingclient/api/Purchase;

    .line 47
    invoke-direct {v2, v12, v13}, Lcom/android/billingclient/api/Purchase;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v5, v7, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    .line 48
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzcf;->isEmpty()Z
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    .line 49
    invoke-virtual {v2}, Lcom/android/billingclient/api/Purchase;->getPurchaseToken()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_11

    const-string v5, "BillingClient"

    const-string v11, "BUG: empty/null token!"

    .line 50
    invoke-static {v5, v11}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v11, 0x1

    .line 51
    :cond_11
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v10, v10, 0x1

    const/4 v5, 0x1

    goto :goto_7

    :catch_0
    move-exception v0

    move-object v6, v0

    .line 11
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzY:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v5, "Got an exception trying to decode the purchase!"

    const/16 v2, 0x9

    move-object/from16 v1, p0

    .line 61
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0

    :cond_12
    if-eqz v11, :cond_13

    .line 51
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzz:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v5, 0x9

    .line 52
    invoke-direct {v7, v2, v5, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    :cond_13
    const-string v2, "INAPP_CONTINUATION_TOKEN"

    .line 53
    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Continuation token: "

    const-string v3, "BillingClient"

    invoke-virtual {v2, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 54
    invoke-static {v3, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_14

    new-instance v1, Lcom/android/billingclient/api/zzed;

    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {v1, v2, v0}, Lcom/android/billingclient/api/zzed;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-object v1

    :cond_14
    const/4 v5, 0x1

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    .line 11
    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v0
    :try_end_5
    .catch Landroid/os/DeadObjectException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    :catch_1
    move-exception v0

    move-object v6, v0

    .line 58
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzZ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v5, "Got exception trying to get purchases try to reconnect"

    const/16 v2, 0x9

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0

    :catch_2
    move-exception v0

    move-object v6, v0

    .line 59
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjn;->zzZ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v5, "Got exception trying to get purchases try to reconnect"

    const/16 v2, 0x9

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbs(ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzed;

    move-result-object v0

    return-object v0
.end method

.method private final zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V
    .locals 7

    .line 1
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v0

    const/4 v1, 0x0

    const-string v2, "Unable to create logging payload"

    const-string v3, "BillingLogger"

    const/4 v4, 0x5

    if-eqz v0, :cond_0

    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    .line 2
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object v0

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v5

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v6

    .line 4
    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p1

    .line 5
    invoke-virtual {v5, p1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzb(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 6
    invoke-virtual {v5, p2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    invoke-virtual {v0, v5}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 8
    invoke-virtual {v0, v4}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzki;->zza()Lcom/google/android/gms/internal/play_billing/zzkf;

    move-result-object p1

    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzkf;->zza(I)Lcom/google/android/gms/internal/play_billing/zzkf;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzki;

    .line 10
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzje;->zzc(Lcom/google/android/gms/internal/play_billing/zzki;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 11
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v1, p1

    goto :goto_0

    :catch_0
    move-exception p1

    .line 12
    invoke-static {v3, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 13
    :goto_0
    invoke-direct {p0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    return-void

    .line 14
    :cond_0
    sget p1, Lcom/android/billingclient/api/zzcy;->zza:I

    .line 15
    :try_start_1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjk;->zza()Lcom/google/android/gms/internal/play_billing/zzji;

    move-result-object p1

    .line 16
    invoke-virtual {p1, v4}, Lcom/google/android/gms/internal/play_billing/zzji;->zze(I)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 17
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzki;->zza()Lcom/google/android/gms/internal/play_billing/zzkf;

    move-result-object p2

    invoke-virtual {p2, p3}, Lcom/google/android/gms/internal/play_billing/zzkf;->zza(I)Lcom/google/android/gms/internal/play_billing/zzkf;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzki;

    .line 18
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzji;->zzb(Lcom/google/android/gms/internal/play_billing/zzki;)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 19
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjk;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, p1

    goto :goto_1

    :catch_1
    move-exception p1

    .line 20
    invoke-static {v3, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 14
    :goto_1
    invoke-direct {p0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbh(Lcom/google/android/gms/internal/play_billing/zzjk;)V

    return-void
.end method

.method private zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V
    .locals 2

    .line 1
    :try_start_0
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    const/4 v1, 0x0

    .line 2
    invoke-static {p1, p2, p3, v1, v0}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    .line 1
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 3
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbw(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;J)V
    .locals 4

    .line 1
    const-string p2, "Unable to log."

    const-string v0, "BillingClient"

    :try_start_0
    sget v1, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    const/4 v2, 0x2

    const/4 v3, 0x0

    .line 2
    invoke-static {p1, v2, p3, v3, v1}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:I

    .line 3
    invoke-interface {p3, p1, v1, p4, p5}, Lcom/android/billingclient/api/zzcz;->zzc(Lcom/google/android/gms/internal/play_billing/zzjg;IJ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 4
    :try_start_2
    invoke-static {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    return-void

    :catchall_1
    move-exception p1

    .line 5
    invoke-static {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbx(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V
    .locals 1

    .line 1
    :try_start_0
    sget v0, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 2
    invoke-static {p1, p2, p3, p4, v0}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    .line 3
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbf(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 4
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V
    .locals 2

    .line 1
    :try_start_0
    sget p2, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    const/4 v0, 0x2

    const/4 v1, 0x0

    .line 2
    invoke-static {p1, v0, p3, v1, p2}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    .line 3
    invoke-direct {p0, p1, p4, p5, p6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbg(Lcom/google/android/gms/internal/play_billing/zzjg;JZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 4
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzbz(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;JZ)V
    .locals 1

    .line 1
    :try_start_0
    sget p2, Lcom/android/billingclient/api/zzcy;->zza:I

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    const/4 v0, 0x2

    .line 2
    invoke-static {p1, v0, p3, p4, p2}, Lcom/android/billingclient/api/zzcy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjg;

    move-result-object p1

    .line 3
    invoke-direct {p0, p1, p5, p6, p7}, Lcom/android/billingclient/api/BillingClientImpl;->zzbg(Lcom/google/android/gms/internal/play_billing/zzjg;JZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 4
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method static bridge synthetic zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    return-object p0
.end method

.method public static synthetic zzd(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzay(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic zze(Lcom/android/billingclient/api/BillingClientImpl;ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 0

    invoke-direct/range {p0 .. p5}, Lcom/android/billingclient/api/BillingClientImpl;->zzax(ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzf(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/os/Handler;
    .locals 0

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzg(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)Landroid/os/ResultReceiver;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    new-instance v1, Lcom/android/billingclient/api/zzbt;

    invoke-direct {v1, p0, v0, p1}, Lcom/android/billingclient/api/zzbt;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)V

    return-object v1
.end method

.method static bridge synthetic zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzab;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    return-object p0
.end method

.method static bridge synthetic zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingClientStateListener;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzJ:Lcom/android/billingclient/api/BillingClientStateListener;

    return-object p0
.end method

.method static bridge synthetic zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    return-object p0
.end method

.method static bridge synthetic zzm(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingResult;
    .locals 0

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzn(Ljava/lang/Exception;)Lcom/android/billingclient/api/BillingResult;
    .locals 0

    .line 1
    instance-of p0, p0, Landroid/os/DeadObjectException;

    if-eqz p0, :cond_0

    .line 2
    sget-object p0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    goto :goto_0

    .line 3
    :cond_0
    sget-object p0, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    :goto_0
    return-object p0
.end method

.method static bridge synthetic zzp(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/PendingPurchasesParams;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    return-object p0
.end method

.method static bridge synthetic zzq(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzar;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    return-object p0
.end method

.method static bridge synthetic zzr(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzbq;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzM:Lcom/google/android/gms/internal/play_billing/zzbq;

    return-object p0
.end method

.method static bridge synthetic zzs(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzcf;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzI:Lcom/google/android/gms/internal/play_billing/zzcf;

    return-object p0
.end method

.method static bridge synthetic zzt(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Long;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    return-object p0
.end method

.method public static synthetic zzu(Lcom/android/billingclient/api/BillingClientImpl;ILcom/google/android/gms/internal/play_billing/zzp;)Ljava/lang/Object;
    .locals 1

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzbs;

    invoke-direct {v0, p0, p2}, Lcom/android/billingclient/api/zzbs;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzp;)V

    invoke-direct {p0, v0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbl(Lcom/android/billingclient/api/BillingClientStateListener;I)V

    const-string p0, "reconnectIfNeeded"

    return-object p0
.end method

.method public static synthetic zzv(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)Ljava/lang/Object;
    .locals 3

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    const/4 v2, 0x4

    invoke-direct {p0, v0, v2, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 3
    invoke-virtual {p2}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p0

    .line 4
    invoke-interface {p1, v1, p0}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    goto :goto_0

    .line 5
    :cond_0
    invoke-direct {p0, p2, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaR(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V

    :goto_0
    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ProductDetailsResponseListener;Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/Object;
    .locals 2

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzb()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbo(J)Z

    move-result v0

    const/4 v1, 0x7

    if-nez v0, :cond_0

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p2, v1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    new-instance p0, Lcom/android/billingclient/api/QueryProductDetailsResult;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object p2

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v1

    invoke-direct {p0, p2, v1}, Lcom/android/billingclient/api/QueryProductDetailsResult;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 5
    invoke-interface {p1, v0, p0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/QueryProductDetailsResult;)V

    goto :goto_0

    :cond_0
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-nez v0, :cond_1

    const-string p2, "BillingClient"

    const-string v0, "Querying product details is not supported."

    .line 6
    invoke-static {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzt:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzs:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p2, v1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    new-instance p0, Lcom/android/billingclient/api/QueryProductDetailsResult;

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object p2

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v1

    invoke-direct {p0, p2, v1}, Lcom/android/billingclient/api/QueryProductDetailsResult;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 10
    invoke-interface {p1, v0, p0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/QueryProductDetailsResult;)V

    goto :goto_0

    .line 11
    :cond_1
    invoke-virtual {p0, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzi(Lcom/android/billingclient/api/QueryProductDetailsParams;)Lcom/android/billingclient/api/zzch;

    move-result-object p0

    invoke-virtual {p0}, Lcom/android/billingclient/api/zzch;->zza()I

    move-result p2

    invoke-virtual {p0}, Lcom/android/billingclient/api/zzch;->zzb()Ljava/lang/String;

    move-result-object v0

    .line 12
    invoke-static {p2, v0}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    new-instance v0, Lcom/android/billingclient/api/QueryProductDetailsResult;

    invoke-virtual {p0}, Lcom/android/billingclient/api/zzch;->zzc()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/billingclient/api/zzch;->zzd()Ljava/util/List;

    move-result-object p0

    invoke-direct {v0, v1, p0}, Lcom/android/billingclient/api/QueryProductDetailsResult;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 13
    invoke-interface {p1, p2, v0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/QueryProductDetailsResult;)V

    :goto_0
    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzx(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/AcknowledgePurchaseParams;)Ljava/lang/Object;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaE(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/AcknowledgePurchaseParams;)Ljava/lang/Object;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzy(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Object;
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaG(Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Object;

    const/4 p0, 0x0

    return-object p0
.end method

.method public static synthetic zzz(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingConfigResponseListener;)Ljava/lang/Object;
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaF(Lcom/android/billingclient/api/BillingConfigResponseListener;)Ljava/lang/Object;

    const/4 p0, 0x0

    return-object p0
.end method


# virtual methods
.method public acknowledgePurchase(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzal;

    invoke-direct {v0, p0, p2, p1}, Lcom/android/billingclient/api/zzal;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;Lcom/android/billingclient/api/AcknowledgePurchaseParams;)V

    new-instance v3, Lcom/android/billingclient/api/zzan;

    invoke-direct {v3, p0, p2}, Lcom/android/billingclient/api/zzan;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v1, 0x3

    .line 5
    invoke-direct {p0, v0, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 6
    invoke-interface {p2, p1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    :cond_0
    return-void
.end method

.method public consumeAsync(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzbc;

    invoke-direct {v0, p0, p2, p1}, Lcom/android/billingclient/api/zzbc;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V

    new-instance v3, Lcom/android/billingclient/api/zzbd;

    invoke-direct {v3, p0, p2, p1}, Lcom/android/billingclient/api/zzbd;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x4

    .line 5
    invoke-direct {p0, v1, v2, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 6
    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v0, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public createAlternativeBillingOnlyReportingDetailsAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzax;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzax;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzay;

    invoke-direct {v3, p0, p1}, Lcom/android/billingclient/api/zzay;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    .line 5
    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaW(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :cond_0
    return-void
.end method

.method public createBillingProgramReportingDetailsAsync(Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;)V
    .locals 6

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzaq;

    invoke-direct {v1, p0, p2, p1}, Lcom/android/billingclient/api/zzaq;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;)V

    new-instance v4, Lcom/android/billingclient/api/zzar;

    invoke-direct {v4, p0, p2}, Lcom/android/billingclient/api/zzar;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v5

    const-wide/16 v2, 0x7530

    move-object v0, p0

    .line 2
    invoke-direct/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzaQ(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 3
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 4
    invoke-direct {p0, p2, v0, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaX(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void
.end method

.method public createExternalOfferReportingDetailsAsync(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzav;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzav;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzbe;

    invoke-direct {v3, p0, p1}, Lcom/android/billingclient/api/zzbe;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    .line 5
    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaY(Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :cond_0
    return-void
.end method

.method public endConnection()V
    .locals 6

    const/16 v0, 0xc

    .line 1
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbA(I)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    .line 2
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzab;->zzi()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    .line 11
    :try_start_1
    const-string v2, "BillingClient"

    const-string v3, "There was an exception while shutting down broadcast manager while ending connection!"

    .line 3
    invoke-static {v2, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_4

    .line 2
    :cond_0
    :goto_0
    :try_start_2
    const-string v1, "BillingClient"

    const-string v2, "Unbinding from service."

    .line 4
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 5
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbm()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v1

    .line 3
    :try_start_3
    const-string v2, "BillingClient"

    const-string v3, "There was an exception while unbinding from the service while ending connection!"

    .line 6
    invoke-static {v2, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_4

    :goto_1
    const/4 v1, 0x0

    const/4 v2, 0x3

    .line 7
    :try_start_4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbk()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 9
    :try_start_5
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    :goto_2
    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzJ:Lcom/android/billingclient/api/BillingClientStateListener;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_4

    goto :goto_3

    :catchall_2
    move-exception v3

    .line 6
    :try_start_6
    const-string v4, "BillingClient"

    const-string v5, "There was an exception while shutting down the executor service while ending connection!"

    .line 8
    invoke-static {v4, v5, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 9
    :try_start_7
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    goto :goto_2

    .line 11
    :goto_3
    monitor-exit v0

    return-void

    :catchall_3
    move-exception v3

    .line 9
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbj(I)V

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzJ:Lcom/android/billingclient/api/BillingClientStateListener;

    .line 10
    throw v3

    :catchall_4
    move-exception v1

    .line 11
    monitor-exit v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    throw v1
.end method

.method public getBillingConfigAsync(Lcom/android/billingclient/api/GetBillingConfigParams;Lcom/android/billingclient/api/BillingConfigResponseListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzas;

    invoke-direct {v0, p0, p2}, Lcom/android/billingclient/api/zzas;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingConfigResponseListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzat;

    invoke-direct {v3, p0, p2}, Lcom/android/billingclient/api/zzat;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingConfigResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v1, 0xd

    .line 5
    invoke-direct {p0, v0, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    const/4 v0, 0x0

    .line 6
    invoke-interface {p2, p1, v0}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    :cond_0
    return-void
.end method

.method public final getConnectionState()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    iget v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:I

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    .line 2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public isAlternativeBillingOnlyAvailableAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzaz;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzba;

    invoke-direct {v3, p0, p1}, Lcom/android/billingclient/api/zzba;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    .line 5
    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaT(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :cond_0
    return-void
.end method

.method public isBillingProgramAvailableAsync(ILcom/android/billingclient/api/BillingProgramAvailabilityListener;)V
    .locals 7

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzao;

    invoke-direct {v0, p0, p2, p1}, Lcom/android/billingclient/api/zzao;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)V

    new-instance v3, Lcom/android/billingclient/api/zzap;

    invoke-direct {v3, p0, p2, p1}, Lcom/android/billingclient/api/zzap;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingProgramAvailabilityListener;I)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p2

    move v3, p1

    .line 5
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaU(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :cond_0
    return-void
.end method

.method public isExternalOfferAvailableAsync(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzaf;

    invoke-direct {v0, p0, p1}, Lcom/android/billingclient/api/zzaf;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzag;

    invoke-direct {v3, p0, p1}, Lcom/android/billingclient/api/zzag;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v2, 0x0

    .line 5
    invoke-direct {p0, p1, v0, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaZ(Lcom/android/billingclient/api/ExternalOfferAvailabilityListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    :cond_0
    return-void
.end method

.method public final isFeatureSupported(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult;
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzc()J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbn(J)Z

    move-result v2

    const/4 v3, 0x5

    if-nez v2, :cond_1

    .line 2
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-virtual {v1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v4

    if-eqz v4, :cond_0

    .line 3
    invoke-direct {v0, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    goto :goto_0

    .line 4
    :cond_0
    invoke-direct {v0, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbA(I)V

    :goto_0
    return-object v1

    .line 5
    :cond_1
    sget v2, Lcom/android/billingclient/api/zzdc;->zzJ:I

    .line 6
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->hashCode()I

    move-result v2

    const/16 v5, 0xe

    const/16 v6, 0xd

    const/16 v7, 0xc

    const/16 v8, 0xb

    const/16 v9, 0xa

    const/16 v10, 0x9

    const/16 v11, 0x8

    const/4 v12, 0x7

    const/4 v13, 0x6

    const/4 v14, 0x3

    const/4 v15, 0x4

    const/4 v4, 0x1

    sparse-switch v2, :sswitch_data_0

    goto/16 :goto_1

    .line 26
    :sswitch_0
    const-string v2, "subscriptions"

    .line 6
    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v2, 0x0

    goto/16 :goto_2

    :sswitch_1
    const-string v2, "priceChangeConfirmation"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v2, 0x2

    goto/16 :goto_2

    :sswitch_2
    const-string v2, "ooo"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v2, 0x11

    goto/16 :goto_2

    :sswitch_3
    const-string v2, "nnn"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v2, 0x10

    goto/16 :goto_2

    :sswitch_4
    const-string v2, "mmm"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v2, 0xf

    goto/16 :goto_2

    :sswitch_5
    const-string v2, "lll"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v5

    goto/16 :goto_2

    :sswitch_6
    const-string v2, "kkk"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v6

    goto/16 :goto_2

    :sswitch_7
    const-string v2, "jjj"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v7

    goto/16 :goto_2

    :sswitch_8
    const-string v2, "iii"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v8

    goto/16 :goto_2

    :sswitch_9
    const-string v2, "hhh"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v9

    goto :goto_2

    :sswitch_a
    const-string v2, "ggg"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v10

    goto :goto_2

    :sswitch_b
    const-string v2, "fff"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v11

    goto :goto_2

    :sswitch_c
    const-string v2, "eee"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v12

    goto :goto_2

    :sswitch_d
    const-string v2, "ddd"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v3

    goto :goto_2

    :sswitch_e
    const-string v2, "ccc"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v13

    goto :goto_2

    :sswitch_f
    const-string v2, "bbb"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v14

    goto :goto_2

    :sswitch_10
    const-string v2, "aaa"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v15

    goto :goto_2

    :sswitch_11
    const-string v2, "subscriptionsUpdate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v4

    goto :goto_2

    :cond_2
    :goto_1
    const/4 v2, -0x1

    :goto_2
    packed-switch v2, :pswitch_data_0

    .line 23
    invoke-static/range {p1 .. p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "BillingClient"

    const-string v3, "Unsupported feature: "

    invoke-virtual {v3, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 25
    invoke-static {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzy:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzH:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 26
    invoke-direct {v0, v1, v2, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    .line 24
    :pswitch_0
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzE:Z

    if-eqz v1, :cond_3

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_3

    .line 7
    :cond_3
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzr:Lcom/android/billingclient/api/BillingResult;

    .line 24
    :goto_3
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbM:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v3, 0x16

    .line 7
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_1
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzC:Z

    if-eqz v1, :cond_4

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_4

    .line 8
    :cond_4
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzx:Lcom/android/billingclient/api/BillingResult;

    .line 7
    :goto_4
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbH:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v3, 0x15

    .line 8
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_2
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    if-eqz v1, :cond_5

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_5

    .line 9
    :cond_5
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzw:Lcom/android/billingclient/api/BillingResult;

    .line 8
    :goto_5
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbo:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v3, 0x14

    .line 9
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_3
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Z

    if-eqz v1, :cond_6

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_6

    .line 10
    :cond_6
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzv:Lcom/android/billingclient/api/BillingResult;

    .line 9
    :goto_6
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaZ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v3, 0x13

    .line 10
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_4
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzB:Z

    if-eqz v1, :cond_7

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_7

    .line 11
    :cond_7
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzu:Lcom/android/billingclient/api/BillingResult;

    .line 10
    :goto_7
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaE:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v3, 0x12

    .line 11
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_5
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    if-eqz v1, :cond_8

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_8

    .line 12
    :cond_8
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzD:Lcom/android/billingclient/api/BillingResult;

    .line 11
    :goto_8
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzan:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 12
    invoke-direct {v0, v1, v2, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_6
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-eqz v1, :cond_9

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_9

    .line 13
    :cond_9
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzC:Lcom/android/billingclient/api/BillingResult;

    .line 12
    :goto_9
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzah:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 13
    invoke-direct {v0, v1, v2, v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_7
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    if-eqz v1, :cond_a

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_a

    .line 14
    :cond_a
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzA:Lcom/android/billingclient/api/BillingResult;

    .line 13
    :goto_a
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzG:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 14
    invoke-direct {v0, v1, v2, v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_8
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    if-eqz v1, :cond_b

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_b

    .line 15
    :cond_b
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzz:Lcom/android/billingclient/api/BillingResult;

    .line 14
    :goto_b
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzF:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 15
    invoke-direct {v0, v1, v2, v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_9
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-eqz v1, :cond_c

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_c

    .line 16
    :cond_c
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzs:Lcom/android/billingclient/api/BillingResult;

    .line 15
    :goto_c
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzt:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 16
    invoke-direct {v0, v1, v2, v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_a
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-eqz v1, :cond_d

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_d

    .line 17
    :cond_d
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzp:Lcom/android/billingclient/api/BillingResult;

    .line 16
    :goto_d
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzai:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 17
    invoke-direct {v0, v1, v2, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_b
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-eqz v1, :cond_e

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_e

    .line 18
    :cond_e
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzp:Lcom/android/billingclient/api/BillingResult;

    .line 17
    :goto_e
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzs:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 18
    invoke-direct {v0, v1, v2, v11}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_c
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    if-eqz v1, :cond_f

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_f

    .line 19
    :cond_f
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzq:Lcom/android/billingclient/api/BillingResult;

    .line 18
    :goto_f
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzu:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 19
    invoke-direct {v0, v1, v2, v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_d
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    if-eqz v1, :cond_10

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_10

    .line 20
    :cond_10
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzo:Lcom/android/billingclient/api/BillingResult;

    .line 19
    :goto_10
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzE:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 20
    invoke-direct {v0, v1, v2, v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_e
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    if-eqz v1, :cond_11

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_11

    .line 21
    :cond_11
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzt:Lcom/android/billingclient/api/BillingResult;

    .line 20
    :goto_11
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzD:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 21
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_f
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzo:Z

    if-eqz v1, :cond_12

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_12

    .line 22
    :cond_12
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzn:Lcom/android/billingclient/api/BillingResult;

    .line 21
    :goto_12
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzI:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 22
    invoke-direct {v0, v1, v2, v15}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    :pswitch_10
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    if-eqz v1, :cond_13

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_13

    .line 23
    :cond_13
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzm:Lcom/android/billingclient/api/BillingResult;

    .line 22
    :goto_13
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzj:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 23
    invoke-direct {v0, v1, v2, v14}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    .line 6
    :pswitch_11
    iget-boolean v1, v0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:Z

    if-eqz v1, :cond_14

    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    goto :goto_14

    .line 24
    :cond_14
    sget-object v1, Lcom/android/billingclient/api/zzdc;->zzl:Lcom/android/billingclient/api/BillingResult;

    .line 6
    :goto_14
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzi:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v3, 0x2

    .line 24
    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbu(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;I)V

    return-object v1

    nop

    :sswitch_data_0
    .sparse-switch
        -0x1928a0a1 -> :sswitch_11
        0x17841 -> :sswitch_10
        0x17c22 -> :sswitch_f
        0x18003 -> :sswitch_e
        0x183e4 -> :sswitch_d
        0x187c5 -> :sswitch_c
        0x18ba6 -> :sswitch_b
        0x18f87 -> :sswitch_a
        0x19368 -> :sswitch_9
        0x19749 -> :sswitch_8
        0x19b2a -> :sswitch_7
        0x19f0b -> :sswitch_6
        0x1a2ec -> :sswitch_5
        0x1a6cd -> :sswitch_4
        0x1aaae -> :sswitch_3
        0x1ae8f -> :sswitch_2
        0xc5ff92e -> :sswitch_1
        0x7674caf6 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final isReady()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzG:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbp()Z

    move-result v0

    return v0
.end method

.method public launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;
    .locals 25

    move-object/from16 v9, p0

    move-object/from16 v0, p1

    .line 1
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    invoke-virtual {v1}, Ljava/util/Random;->nextLong()J

    move-result-wide v7

    iget-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    if-eqz v1, :cond_2a

    iget-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    .line 2
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzab;->zzf()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object v1

    if-eqz v1, :cond_2a

    .line 3
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->getDeveloperBillingOptionParams()Lcom/android/billingclient/api/DeveloperBillingOptionParams;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzab;

    .line 4
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzab;->zzd()Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    move-result-object v1

    if-nez v1, :cond_0

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbJ:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 5
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzI:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbw(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;J)V

    return-object v0

    :cond_0
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzc()J

    move-result-wide v1

    .line 6
    invoke-direct {v9, v1, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbn(J)Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbw(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;J)V

    .line 8
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    :cond_1
    iget-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v2, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    if-eqz v2, :cond_2

    iget-object v2, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Lcom/android/billingclient/api/zzbw;

    .line 9
    invoke-virtual {v2}, Lcom/android/billingclient/api/zzbw;->zzg()Z

    move-result v2

    move v15, v2

    goto :goto_0

    :cond_2
    const/4 v15, 0x0

    .line 10
    :goto_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 11
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzj()Ljava/util/ArrayList;

    move-result-object v1

    .line 12
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzk()Ljava/util/List;

    move-result-object v2

    const/4 v6, 0x0

    .line 13
    invoke-static {v1, v6}, Lcom/google/android/gms/internal/play_billing/zzcg;->zza(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/billingclient/api/zzen;

    .line 14
    invoke-static {v2, v6}, Lcom/google/android/gms/internal/play_billing/zzcg;->zza(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    if-nez v4, :cond_29

    .line 16
    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v4

    .line 17
    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v10

    invoke-virtual {v10}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v14

    const-string v10, "subs"

    .line 18
    invoke-virtual {v14, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzk:Z

    if-eqz v10, :cond_3

    goto :goto_1

    .line 115
    :cond_3
    const-string v0, "BillingClient"

    const-string v1, "Current client doesn\'t support subscriptions."

    .line 146
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzi:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 147
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzl:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move v7, v15

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 148
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    .line 19
    :cond_4
    :goto_1
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzu()Z

    move-result v10

    if-eqz v10, :cond_5

    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-nez v10, :cond_5

    const-string v0, "BillingClient"

    const-string v1, "Current client doesn\'t support extra params for buy intent."

    .line 20
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzr:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 21
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzf:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move v7, v15

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 22
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    .line 23
    :cond_5
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v10

    const/4 v13, 0x1

    if-le v10, v13, :cond_6

    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-nez v10, :cond_6

    const-string v0, "BillingClient"

    const-string v1, "Current client doesn\'t support multi-item purchases."

    .line 24
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzs:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 25
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzp:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move v7, v15

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 26
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    .line 27
    :cond_6
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_7

    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-nez v10, :cond_7

    const-string v0, "BillingClient"

    const-string v1, "Current client doesn\'t support purchases with ProductDetails."

    .line 28
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzt:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 29
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzs:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move v7, v15

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 30
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    .line 31
    :cond_7
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_8
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_9

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    .line 32
    invoke-virtual {v11}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zzb()Ljava/lang/String;

    move-result-object v11

    if-eqz v11, :cond_8

    const-string v12, ":"

    .line 33
    invoke-virtual {v11, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_8

    iget-boolean v11, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzE:Z

    if-nez v11, :cond_8

    const-string v0, "BillingClient"

    const-string v1, "Current Play Store version doesn\'t support gift code purchase."

    .line 34
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbM:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 35
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzr:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move v7, v15

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 36
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    .line 37
    :cond_9
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzd()Lcom/android/billingclient/api/BillingResult;

    move-result-object v10

    .line 38
    sget-object v11, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    if-eq v10, v11, :cond_a

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbd:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v10

    move-wide v5, v7

    move v7, v15

    .line 39
    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 40
    invoke-virtual {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v10

    :cond_a
    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-eqz v10, :cond_21

    iget-boolean v11, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    iget-boolean v12, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    iget-object v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    .line 41
    invoke-virtual {v10}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForOneTimeProducts()Z

    move-result v16

    iget-object v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    .line 42
    invoke-virtual {v10}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForPrepaidPlans()Z

    move-result v17

    iget-boolean v10, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzH:Z

    iget-object v3, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    iget-object v6, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v13, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 43
    invoke-virtual {v13}, Ljava/lang/Long;->longValue()J

    move-result-wide v19

    iget-object v13, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 44
    invoke-virtual {v13}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v21

    move/from16 v22, v10

    move-object/from16 v10, p2

    const/4 v0, 0x1

    move/from16 v13, v16

    move-object/from16 v23, v14

    move/from16 v14, v17

    move/from16 v24, v15

    move/from16 v15, v22

    move-object/from16 v16, v3

    move-object/from16 v17, v6

    move-wide/from16 v18, v19

    move-object/from16 v20, v21

    move-wide/from16 v21, v7

    .line 45
    invoke-static/range {v10 .. v22}, Lcom/google/android/gms/internal/play_billing/zzc;->zzf(Lcom/android/billingclient/api/BillingFlowParams;ZZZZZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;J)Landroid/os/Bundle;

    move-result-object v10

    .line 46
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_f

    new-instance v3, Ljava/util/ArrayList;

    .line 77
    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    new-instance v6, Ljava/util/ArrayList;

    .line 78
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    new-instance v6, Ljava/util/ArrayList;

    .line 79
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    new-instance v6, Ljava/util/ArrayList;

    .line 80
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    new-instance v6, Ljava/util/ArrayList;

    .line 81
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 82
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_e

    .line 84
    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_b

    const-string v6, "skuDetailsTokens"

    .line 85
    invoke-virtual {v10, v6, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 86
    :cond_b
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v0, :cond_d

    new-instance v3, Ljava/util/ArrayList;

    .line 87
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-direct {v3, v6}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v6, Ljava/util/ArrayList;

    .line 88
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    invoke-direct {v6, v11}, Ljava/util/ArrayList;-><init>(I)V

    .line 89
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v11

    if-gt v11, v0, :cond_c

    .line 91
    const-string v1, "additionalSkus"

    .line 92
    invoke-virtual {v10, v1, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    const-string v1, "additionalSkuTypes"

    .line 93
    invoke-virtual {v10, v1, v6}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_2

    .line 90
    :cond_c
    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/zzen;

    const/4 v1, 0x0

    .line 91
    throw v1

    :cond_d
    :goto_2
    move-object/from16 v16, v4

    goto/16 :goto_5

    :cond_e
    const/4 v1, 0x0

    .line 82
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/zzen;

    .line 83
    throw v1

    .line 109
    :cond_f
    new-instance v1, Ljava/util/ArrayList;

    .line 47
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v3, Ljava/util/ArrayList;

    .line 48
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-direct {v3, v6}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v6, Ljava/util/ArrayList;

    .line 49
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    new-instance v11, Ljava/util/ArrayList;

    .line 50
    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    new-instance v12, Ljava/util/ArrayList;

    .line 51
    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    new-instance v13, Ljava/util/ArrayList;

    .line 52
    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    const/4 v14, 0x0

    .line 53
    :goto_3
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v15

    if-ge v14, v15, :cond_13

    .line 54
    invoke-interface {v2, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    .line 55
    invoke-virtual {v15}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v0

    .line 56
    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->zzb()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->isEmpty()Z

    move-result v16

    if-nez v16, :cond_10

    move-object/from16 v16, v4

    .line 57
    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->zzb()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    :cond_10
    move-object/from16 v16, v4

    .line 58
    :goto_4
    invoke-virtual {v15}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zzb()Ljava/lang/String;

    move-result-object v4

    .line 59
    invoke-virtual {v11, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 60
    invoke-virtual {v0, v4}, Lcom/android/billingclient/api/ProductDetails;->zzc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 61
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_11

    .line 62
    invoke-virtual {v12, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_11
    if-lez v14, :cond_12

    .line 63
    invoke-interface {v2, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v0

    .line 64
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 65
    invoke-interface {v2, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v0

    .line 66
    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_12
    add-int/lit8 v14, v14, 0x1

    move-object/from16 v4, v16

    const/4 v0, 0x1

    goto :goto_3

    :cond_13
    move-object/from16 v16, v4

    const-string v0, "SKU_OFFER_ID_TOKEN_LIST"

    .line 67
    invoke-virtual {v10, v0, v11}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 68
    invoke-virtual {v13}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_14

    const-string v0, "autoPayBalanceThresholdList"

    .line 69
    invoke-virtual {v10, v0, v13}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 70
    :cond_14
    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_15

    const-string v0, "skuDetailsTokens"

    .line 71
    invoke-virtual {v10, v0, v6}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 72
    :cond_15
    invoke-virtual {v12}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_16

    const-string v0, "SKU_SERIALIZED_DOCID_LIST"

    .line 73
    invoke-virtual {v10, v0, v12}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 74
    :cond_16
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_17

    const-string v0, "additionalSkus"

    .line 75
    invoke-virtual {v10, v0, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    const-string v0, "additionalSkuTypes"

    .line 76
    invoke-virtual {v10, v0, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 93
    :cond_17
    :goto_5
    const-string v0, "SKU_OFFER_ID_TOKEN_LIST"

    .line 94
    invoke-virtual {v10, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_18

    iget-boolean v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    if-nez v0, :cond_18

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzu:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzq:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v7

    move/from16 v7, v24

    .line 95
    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 96
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    :cond_18
    if-eqz v5, :cond_19

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->zza()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_19

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v0

    .line 98
    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->zza()Ljava/lang/String;

    move-result-object v0

    const-string v1, "skuPackageName"

    .line 99
    invoke-virtual {v10, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v6, 0x0

    const/4 v13, 0x1

    goto :goto_6

    :cond_19
    const/4 v6, 0x0

    const/4 v13, 0x0

    .line 100
    :goto_6
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1a

    const-string v0, "accountName"

    .line 101
    invoke-virtual {v10, v0, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    :cond_1a
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-nez v0, :cond_1b

    const-string v0, "BillingClient"

    const-string v1, "Activity\'s intent is null."

    .line 103
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_7

    .line 111
    :cond_1b
    const-string v1, "PROXY_PACKAGE"

    .line 104
    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1c

    const-string v1, "PROXY_PACKAGE"

    .line 105
    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "proxyPackage"

    .line 106
    invoke-virtual {v10, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_1
    iget-object v1, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 107
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v3, 0x0

    .line 108
    invoke-virtual {v1, v0, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    const-string v1, "proxyPackageVersion"

    .line 109
    invoke-virtual {v10, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_7

    .line 129
    :catch_0
    const-string v0, "proxyPackageVersion"

    const-string v1, "package not found"

    .line 110
    invoke-virtual {v10, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    :cond_1c
    :goto_7
    iget-boolean v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzE:Z

    if-eqz v0, :cond_1d

    const/16 v0, 0x1c

    :goto_8
    move v3, v0

    goto :goto_9

    .line 137
    :cond_1d
    iget-boolean v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-eqz v0, :cond_1e

    .line 111
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1e

    const/16 v0, 0x11

    goto :goto_8

    :cond_1e
    iget-boolean v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    if-eqz v0, :cond_1f

    if-eqz v13, :cond_1f

    const/16 v0, 0xf

    goto :goto_8

    :cond_1f
    iget-boolean v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-eqz v0, :cond_20

    const/16 v0, 0x9

    goto :goto_8

    :cond_20
    const/4 v0, 0x6

    goto :goto_8

    .line 103
    :goto_9
    new-instance v17, Lcom/android/billingclient/api/zzah;

    move-object/from16 v1, v17

    move-object/from16 v2, p0

    move-object/from16 v4, v16

    move-object/from16 v5, v23

    move-object v11, v6

    move-object/from16 v6, p2

    move-wide v12, v7

    move-object v7, v10

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/zzah;-><init>(Lcom/android/billingclient/api/BillingClientImpl;ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)V

    iget-object v0, v9, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 112
    invoke-virtual/range {p0 .. p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v22

    const-wide/16 v18, 0x1388

    const/16 v20, 0x0

    move-object/from16 v21, v0

    .line 113
    invoke-static/range {v17 .. v22}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    goto :goto_a

    :cond_21
    move-object/from16 v16, v4

    move-object v11, v6

    move-wide v12, v7

    move-object/from16 v23, v14

    move/from16 v24, v15

    .line 76
    new-instance v1, Lcom/android/billingclient/api/zzai;

    move-object/from16 v0, v16

    move-object/from16 v2, v23

    invoke-direct {v1, v9, v0, v2}, Lcom/android/billingclient/api/zzai;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v5, v9, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 114
    invoke-virtual/range {p0 .. p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    const-wide/16 v2, 0x1388

    const/4 v4, 0x0

    .line 115
    invoke-static/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object v0

    :goto_a
    if-nez v0, :cond_22

    .line 113
    :try_start_2
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzc:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v12

    move/from16 v7, v24

    .line 116
    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzby(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;JZ)V

    .line 117
    invoke-virtual {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v0

    :cond_22
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x1388

    .line 118
    invoke-interface {v0, v2, v3, v1}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Landroid/os/Bundle;

    const-string v0, "BillingClient"

    .line 119
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v0

    const-string v2, "BillingClient"

    .line 120
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v0, :cond_28

    const-string v3, "BillingClient"

    new-instance v4, Ljava/lang/StringBuilder;

    .line 121
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to buy item, Error response code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    invoke-static {v0, v2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v10

    const-string v2, "BillingClient"
    :try_end_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_6
    .catch Ljava/util/concurrent/CancellationException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4

    if-nez v1, :cond_23

    :try_start_3
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_b

    .line 128
    :cond_23
    const-string v0, "LOG_REASON"

    .line 123
    invoke-virtual {v1, v0}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_24

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_b

    .line 124
    :cond_24
    instance-of v3, v0, Ljava/lang/Integer;

    if-eqz v3, :cond_25

    .line 125
    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzjn;

    move-result-object v0

    goto :goto_b

    :cond_25
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 126
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unexpected type for bundle log reason: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_b

    :catchall_0
    move-exception v0

    .line 127
    :try_start_4
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    const-string v3, "Failed to get log reason from bundle: "

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 122
    :goto_b
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    if-ne v0, v2, :cond_26

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    :cond_26
    move-object v2, v0

    const-string v3, "BillingClient"
    :try_end_4
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_4 .. :try_end_4} :catch_6
    .catch Ljava/util/concurrent/CancellationException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    if-nez v1, :cond_27

    :goto_c
    move-object v5, v11

    goto :goto_d

    .line 131
    :cond_27
    :try_start_5
    const-string v0, "ADDITIONAL_LOG_DETAILS"

    .line 128
    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-object v5, v0

    goto :goto_d

    :catchall_1
    move-exception v0

    .line 129
    :try_start_6
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Failed to get additional log details from bundle: "

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_c

    :goto_d
    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v10

    move-wide v6, v12

    move/from16 v8, v24

    .line 130
    invoke-direct/range {v1 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzbz(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;JZ)V

    .line 131
    invoke-virtual {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v10

    .line 126
    :cond_28
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/android/billingclient/api/ProxyBillingActivity;

    move-object/from16 v3, p1

    .line 132
    invoke-direct {v0, v3, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "BUY_INTENT"

    .line 133
    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    const-string v2, "BUY_INTENT"

    .line 134
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    const-string v1, "billingClientTransactionId"

    .line 135
    invoke-virtual {v0, v1, v12, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    const-string v1, "wasServiceAutoReconnected"
    :try_end_6
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/util/concurrent/CancellationException; {:try_start_6 .. :try_end_6} :catch_5
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    move/from16 v8, v24

    .line 136
    :try_start_7
    invoke-virtual {v0, v1, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 137
    invoke-virtual {v3, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_7
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/util/concurrent/CancellationException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    return-object v0

    :catch_1
    move-exception v0

    goto :goto_e

    :catch_2
    move-exception v0

    goto :goto_10

    :catch_3
    move-exception v0

    goto :goto_10

    :catch_4
    move-exception v0

    move/from16 v8, v24

    .line 145
    :goto_e
    const-string v1, "BillingClient"

    const-string v2, "Exception while launching billing flow. Try to reconnect"

    .line 138
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zze:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v10, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    .line 139
    invoke-static {v0}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v1, p0

    move-object v4, v10

    move-wide v6, v12

    .line 140
    invoke-direct/range {v1 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzbz(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;JZ)V

    .line 141
    invoke-virtual {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v10

    :catch_5
    move-exception v0

    goto :goto_f

    :catch_6
    move-exception v0

    :goto_f
    move/from16 v8, v24

    .line 10
    :goto_10
    const-string v1, "BillingClient"

    const-string v2, "Time out while launching billing flow. Try to reconnect"

    .line 142
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzd:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v10, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    .line 143
    invoke-static {v0}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v1, p0

    move-object v4, v10

    move-wide v6, v12

    .line 144
    invoke-direct/range {v1 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzbz(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;Ljava/lang/String;JZ)V

    .line 145
    invoke-virtual {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v10

    :cond_29
    move-object v11, v6

    .line 15
    throw v11

    :catchall_2
    move-exception v0

    .line 10
    :try_start_8
    monitor-exit v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    throw v0

    :cond_2a
    move-wide v12, v7

    .line 148
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzl:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 149
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzE:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    move-object/from16 v1, p0

    move-object v4, v0

    move-wide v5, v12

    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzbw(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;J)V

    return-object v0
.end method

.method public launchExternalLink(Landroid/app/Activity;Lcom/android/billingclient/api/LaunchExternalLinkParams;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)V
    .locals 6

    if-eqz p1, :cond_0

    .line 1
    :try_start_0
    new-instance v1, Lcom/android/billingclient/api/zzau;

    invoke-direct {v1, p0, p3, p2, p1}, Lcom/android/billingclient/api/zzau;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/LaunchExternalLinkParams;Landroid/app/Activity;)V

    new-instance v4, Lcom/android/billingclient/api/zzaw;

    invoke-direct {v4, p0, p3}, Lcom/android/billingclient/api/zzaw;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v5

    const-wide/16 v2, 0x7530

    move-object v0, p0

    .line 2
    invoke-direct/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzaQ(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 3
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 4
    invoke-direct {p0, p3, p2, v0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbc(Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/Exception;)V

    return-void

    .line 2
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Please provide a valid activity."

    .line 5
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public queryProductDetailsAsync(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzbh;

    invoke-direct {v0, p0, p2, p1}, Lcom/android/billingclient/api/zzbh;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ProductDetailsResponseListener;Lcom/android/billingclient/api/QueryProductDetailsParams;)V

    new-instance v3, Lcom/android/billingclient/api/zzbi;

    invoke-direct {v3, p0, p2}, Lcom/android/billingclient/api/zzbi;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v4

    .line 2
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    const-wide/16 v1, 0x7530

    .line 3
    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_0

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/4 v1, 0x7

    .line 5
    invoke-direct {p0, v0, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    new-instance v0, Lcom/android/billingclient/api/QueryProductDetailsResult;

    .line 6
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v1

    .line 7
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/android/billingclient/api/QueryProductDetailsResult;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 8
    invoke-interface {p2, p1, v0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/QueryProductDetailsResult;)V

    :cond_0
    return-void
.end method

.method public final queryPurchasesAsync(Lcom/android/billingclient/api/QueryPurchasesParams;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .locals 7

    .line 1
    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryPurchasesParams;->zza()Ljava/lang/String;

    move-result-object v0

    .line 2
    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryPurchasesParams;->getIncludeSuspendedSubscriptions()Z

    move-result p1

    new-instance v1, Lcom/android/billingclient/api/zzbm;

    .line 3
    invoke-direct {v1, p0, p2, v0, p1}, Lcom/android/billingclient/api/zzbm;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchasesResponseListener;Ljava/lang/String;Z)V

    new-instance v4, Lcom/android/billingclient/api/zzae;

    invoke-direct {v4, p0, p2}, Lcom/android/billingclient/api/zzae;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchasesResponseListener;)V

    .line 4
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaz()Landroid/os/Handler;

    move-result-object v5

    .line 5
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    const-wide/16 v2, 0x7530

    .line 6
    invoke-static/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_0

    .line 7
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    const/16 v1, 0x9

    .line 8
    invoke-direct {p0, v0, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzca;->zzk()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v0

    invoke-interface {p2, p1, v0}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :cond_0
    return-void
.end method

.method public showAlternativeBillingOnlyInformationDialog(Landroid/app/Activity;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)Lcom/android/billingclient/api/BillingResult;
    .locals 8

    if-eqz p1, :cond_3

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzc()J

    move-result-wide v0

    .line 2
    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbn(J)Z

    move-result v0

    const/16 v1, 0x10

    if-nez v0, :cond_0

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 3
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p1, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p2

    :cond_0
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Z

    if-nez v0, :cond_1

    const-string p1, "BillingClient"

    const-string p2, "Current Play Store version doesn\'t support alternative billing only."

    .line 4
    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzan:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 5
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzD:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p1, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p2

    :cond_1
    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 6
    new-instance v0, Lcom/android/billingclient/api/zzbo;

    invoke-direct {v0, p0, v6, p2}, Lcom/android/billingclient/api/zzbo;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V

    new-instance v2, Lcom/android/billingclient/api/zzaj;

    invoke-direct {v2, p0, p2, p1, v0}, Lcom/android/billingclient/api/zzaj;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)V

    new-instance v5, Lcom/android/billingclient/api/zzak;

    invoke-direct {v5, p0, p2}, Lcom/android/billingclient/api/zzak;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V

    .line 7
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v7

    const-wide/16 v3, 0x7530

    .line 8
    invoke-static/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_2

    .line 9
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 10
    invoke-direct {p0, p2, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p1

    .line 11
    :cond_2
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    .line 1
    :cond_3
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Please provide a valid activity."

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public showExternalOfferInformationDialog(Landroid/app/Activity;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;)Lcom/android/billingclient/api/BillingResult;
    .locals 8

    if-eqz p1, :cond_3

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzc()J

    move-result-wide v0

    .line 2
    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbn(J)Z

    move-result v0

    const/16 v1, 0x19

    if-nez v0, :cond_0

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzb:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 3
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p1, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p2

    :cond_0
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    if-nez v0, :cond_1

    const-string p1, "BillingClient"

    const-string p2, "Current Play Store version doesn\'t support external offer."

    .line 4
    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaE:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 5
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzu:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p1, v1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p2

    :cond_1
    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 6
    new-instance v0, Lcom/android/billingclient/api/zzbp;

    invoke-direct {v0, p0, v6, p2}, Lcom/android/billingclient/api/zzbp;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;)V

    new-instance v2, Lcom/android/billingclient/api/zzbf;

    invoke-direct {v2, p0, p2, p1, v0}, Lcom/android/billingclient/api/zzbf;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;Landroid/app/Activity;Landroid/os/ResultReceiver;)V

    new-instance v5, Lcom/android/billingclient/api/zzbg;

    invoke-direct {v5, p0, p2}, Lcom/android/billingclient/api/zzbg;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferInformationDialogListener;)V

    .line 7
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v7

    const-wide/16 v3, 0x7530

    .line 8
    invoke-static/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_2

    .line 9
    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaC()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 10
    invoke-direct {p0, p2, v1, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbv(Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    return-object p1

    .line 11
    :cond_2
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    .line 1
    :cond_3
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Please provide a valid activity."

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public final showInAppMessages(Landroid/app/Activity;Lcom/android/billingclient/api/InAppMessageParams;Lcom/android/billingclient/api/InAppMessageResponseListener;)Lcom/android/billingclient/api/BillingResult;
    .locals 8

    .line 1
    invoke-static {}, Lcom/android/billingclient/api/zzdl;->zzc()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzbn(J)Z

    move-result v0

    const-string v1, "BillingClient"

    if-nez v0, :cond_0

    const-string p1, "Service disconnected."

    .line 2
    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    :cond_0
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    if-nez v0, :cond_1

    const-string p1, "Current client doesn\'t support showing in-app messages."

    .line 4
    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    .line 5
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzt:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    :cond_1
    const v0, 0x1020002

    .line 6
    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 7
    invoke-virtual {v0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    if-nez v2, :cond_2

    const-string v3, "Could not retrieve the window token from the activity instance."

    .line 8
    invoke-static {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    new-instance v1, Landroid/graphics/Rect;

    .line 9
    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 10
    invoke-virtual {v0, v1}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    new-instance v0, Landroid/os/Bundle;

    .line 11
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v3, "KEY_WINDOW_TOKEN"

    .line 12
    invoke-static {v0, v3, v2}, Landroidx/core/app/BundleCompat;->putBinder(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V

    .line 13
    iget v2, v1, Landroid/graphics/Rect;->left:I

    const-string v3, "KEY_DIMEN_LEFT"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 14
    iget v2, v1, Landroid/graphics/Rect;->top:I

    const-string v3, "KEY_DIMEN_TOP"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 15
    iget v2, v1, Landroid/graphics/Rect;->right:I

    const-string v3, "KEY_DIMEN_RIGHT"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 16
    iget v1, v1, Landroid/graphics/Rect;->bottom:I

    const-string v2, "KEY_DIMEN_BOTTOM"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    const-string v2, "playBillingLibraryVersion"

    .line 17
    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    if-eqz v1, :cond_3

    const-string v2, "playBillingLibraryWrapperVersion"

    .line 18
    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    :cond_3
    invoke-virtual {p2}, Lcom/android/billingclient/api/InAppMessageParams;->zza()Ljava/util/ArrayList;

    move-result-object p2

    const-string v1, "KEY_CATEGORY_IDS"

    .line 20
    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 21
    new-instance p2, Lcom/android/billingclient/api/zzbn;

    invoke-direct {p2, p0, v6, p3}, Lcom/android/billingclient/api/zzbn;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/InAppMessageResponseListener;)V

    new-instance v2, Lcom/android/billingclient/api/zzbj;

    invoke-direct {v2, p0, v0, p1, p2}, Lcom/android/billingclient/api/zzbj;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)V

    const/4 v5, 0x0

    .line 22
    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v7

    const-wide/16 v3, 0x1388

    .line 23
    invoke-static/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    .line 24
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    return-object p1
.end method

.method public startConnection(Lcom/android/billingclient/api/BillingClientStateListener;)V
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, p1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzbl(Lcom/android/billingclient/api/BillingClientStateListener;I)V

    return-void
.end method

.method final declared-synchronized zzM()Ljava/util/concurrent/ExecutorService;
    .locals 2

    monitor-enter p0

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzK:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_0

    sget v0, Lcom/google/android/gms/internal/play_billing/zzc;->zza:I

    new-instance v1, Lcom/android/billingclient/api/zzbl;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzbl;-><init>(Lcom/android/billingclient/api/BillingClientImpl;)V

    invoke-static {v0, v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzK:Ljava/util/concurrent/ExecutorService;

    :cond_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzK:Ljava/util/concurrent/ExecutorService;
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

.method public final zzas(Ljava/lang/Runnable;)V
    .locals 2

    .line 1
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 2
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    .line 3
    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method final zzi(Lcom/android/billingclient/api/QueryProductDetailsParams;)Lcom/android/billingclient/api/zzch;
    .locals 23
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    move-object/from16 v1, p0

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    new-instance v2, Ljava/util/ArrayList;

    .line 2
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 3
    invoke-virtual/range {p1 .. p1}, Lcom/android/billingclient/api/QueryProductDetailsParams;->zzb()Ljava/lang/String;

    move-result-object v9

    .line 4
    invoke-virtual/range {p1 .. p1}, Lcom/android/billingclient/api/QueryProductDetailsParams;->zza()Lcom/google/android/gms/internal/play_billing/zzca;

    move-result-object v10

    .line 5
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v11

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v11, :cond_e

    add-int/lit8 v13, v3, 0x14

    if-le v13, v11, :cond_0

    move v4, v11

    goto :goto_1

    :cond_0
    move v4, v13

    :goto_1
    new-instance v8, Ljava/util/ArrayList;

    .line 6
    invoke-interface {v10, v3, v4}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v3

    invoke-direct {v8, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance v3, Ljava/util/ArrayList;

    .line 7
    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x0

    :goto_2
    if-ge v5, v4, :cond_1

    invoke-interface {v8, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    .line 8
    check-cast v6, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    .line 9
    invoke-virtual {v6}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zza()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    :cond_1
    new-instance v7, Landroid/os/Bundle;

    .line 10
    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    const-string v4, "ITEM_ID_LIST"

    .line 11
    invoke-virtual {v7, v4, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object v14, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Ljava/lang/String;

    const-string v3, "playBillingLibraryVersion"

    .line 12
    invoke-virtual {v7, v3, v14}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_0
    iget-object v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zza:Ljava/lang/Object;

    monitor-enter v3
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    :try_start_1
    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Lcom/google/android/gms/internal/play_billing/zzar;

    .line 13
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    const/4 v6, 0x0

    if-nez v4, :cond_2

    .line 60
    :try_start_2
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v3, "Service has been reset to null."

    invoke-direct {v1, v0, v2, v3, v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :cond_2
    iget-boolean v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    const/4 v5, 0x1

    if-eqz v3, :cond_3

    iget-object v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzF:Lcom/android/billingclient/api/PendingPurchasesParams;

    .line 14
    invoke-virtual {v3}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForPrepaidPlans()Z

    move-result v3

    if-eqz v3, :cond_3

    move v15, v5

    goto :goto_3

    :cond_3
    const/4 v15, 0x0

    .line 15
    :goto_3
    invoke-direct/range {p0 .. p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaH(Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/String;

    .line 16
    invoke-direct/range {p0 .. p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaH(Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/String;

    .line 17
    invoke-direct/range {p0 .. p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaH(Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/String;

    .line 18
    invoke-direct/range {p0 .. p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaH(Lcom/android/billingclient/api/QueryProductDetailsParams;)Ljava/lang/String;

    const/16 v19, 0x0

    const/16 v20, 0x1

    const/16 v16, 0x1

    const/16 v17, 0x1

    const/16 v18, 0x1

    invoke-static/range {v15 .. v20}, Lcom/google/android/gms/internal/play_billing/zza;->zza(ZZZZZZ)Lcom/google/android/gms/internal/play_billing/zza;

    move-result-object v19

    iget-boolean v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-eq v5, v3, :cond_4

    const/16 v3, 0x11

    goto :goto_4

    :cond_4
    const/16 v3, 0x14

    :goto_4
    move v5, v3

    iget-object v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Landroid/content/Context;

    .line 19
    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v22

    iget-object v15, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Ljava/lang/String;

    iget-object v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzL:Ljava/lang/Long;

    .line 20
    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v20

    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v16, v8

    .line 21
    invoke-static/range {v14 .. v21}, Lcom/google/android/gms/internal/play_billing/zzc;->zzg(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zza;J)Landroid/os/Bundle;

    move-result-object v14

    move-object v3, v4

    move v4, v5

    move-object/from16 v5, v22

    move-object v15, v6

    move-object v6, v9

    move-object/from16 v16, v8

    move-object v8, v14

    .line 22
    invoke-interface/range {v3 .. v8}, Lcom/google/android/gms/internal/play_billing/zzar;->zzj(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3
    :try_end_2
    .catch Landroid/os/DeadObjectException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    if-nez v3, :cond_5

    .line 48
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzB:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzR:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v3, "queryProductDetailsAsync got empty product details response."

    invoke-direct {v1, v0, v2, v3, v15}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :cond_5
    const-string v4, "DETAILS_LIST"

    .line 23
    invoke-virtual {v3, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    const/4 v5, 0x6

    if-nez v4, :cond_7

    const-string v0, "BillingClient"

    .line 49
    invoke-static {v3, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v0

    const-string v2, "BillingClient"

    .line 50
    invoke-static {v3, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzk(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v0, :cond_6

    .line 51
    invoke-static {v0, v2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "getSkuDetails() failed for queryProductDetailsAsync. Response code: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    invoke-direct {v1, v2, v3, v0, v15}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    .line 53
    :cond_6
    invoke-static {v5, v2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzS:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v3, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync."

    .line 54
    invoke-direct {v1, v0, v2, v3, v15}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :cond_7
    const-string v4, "DETAILS_LIST"

    .line 24
    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    if-nez v4, :cond_8

    .line 55
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzB:Lcom/android/billingclient/api/BillingResult;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzT:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v3, "queryProductDetailsAsync got null response list"

    invoke-direct {v1, v0, v2, v3, v15}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :cond_8
    new-instance v6, Ljava/util/ArrayList;

    .line 25
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    const/4 v8, 0x0

    :goto_5
    if-ge v8, v7, :cond_9

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    .line 26
    check-cast v14, Ljava/lang/String;

    :try_start_3
    new-instance v15, Lcom/android/billingclient/api/ProductDetails;

    .line 27
    invoke-direct {v15, v14}, Lcom/android/billingclient/api/ProductDetails;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    .line 28
    invoke-virtual {v15}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v14

    const-string v12, "Got product details: "

    invoke-virtual {v12, v14}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string v14, "BillingClient"

    invoke-static {v14, v12}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    invoke-virtual {v6, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v8, v8, 0x1

    goto :goto_5

    :catch_0
    move-exception v0

    .line 13
    const-string v2, "Error trying to decode SkuDetails."

    .line 56
    invoke-static {v5, v2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzU:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v4, "Got a JSON exception trying to decode ProductDetails. \n Exception: "

    .line 57
    invoke-direct {v1, v2, v3, v4, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    .line 29
    :cond_9
    const-string v4, "UNFETCHED_PRODUCT_LIST"

    .line 30
    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    new-instance v4, Ljava/util/ArrayList;

    .line 31
    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    :try_start_4
    new-instance v4, Ljava/util/ArrayList;

    .line 32
    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    if-eqz v3, :cond_a

    .line 33
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_6
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_d

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    new-instance v8, Lcom/android/billingclient/api/UnfetchedProduct;

    .line 34
    invoke-direct {v8, v7}, Lcom/android/billingclient/api/UnfetchedProduct;-><init>(Ljava/lang/String;)V

    const-string v7, "BillingClient"

    .line 35
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    const-string v14, "Got unfetchedProduct: "

    invoke-virtual {v14, v12}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v7, v12}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    invoke-interface {v4, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 37
    :cond_a
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_7
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_d

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    .line 38
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_b
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_c

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/android/billingclient/api/ProductDetails;

    .line 39
    invoke-virtual {v7}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zza()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_b

    .line 40
    invoke-virtual {v7}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zzb()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v14, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_b

    goto :goto_7

    .line 41
    :cond_c
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    const-string v12, "productId"

    .line 42
    invoke-virtual {v7}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zza()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v8, v12, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v8

    const-string v12, "type"

    .line 43
    invoke-virtual {v7}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zzb()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v12, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "statusCode"

    const/4 v12, 0x0

    .line 44
    invoke-virtual {v7, v8, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v7

    new-instance v8, Lcom/android/billingclient/api/UnfetchedProduct;

    .line 45
    invoke-virtual {v7}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v8, v7}, Lcom/android/billingclient/api/UnfetchedProduct;-><init>(Ljava/lang/String;)V

    invoke-interface {v4, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_7

    .line 46
    :cond_d
    invoke-interface {v0, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 47
    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    move v3, v13

    goto/16 :goto_0

    :catch_1
    move-exception v0

    .line 57
    const-string v2, "Error trying to decode SkuDetails."

    .line 58
    invoke-static {v5, v2}, Lcom/android/billingclient/api/zzdc;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzU:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v4, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: "

    .line 59
    invoke-direct {v1, v2, v3, v4, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :catchall_0
    move-exception v0

    .line 13
    :try_start_5
    monitor-exit v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v0
    :try_end_6
    .catch Landroid/os/DeadObjectException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    :catch_2
    move-exception v0

    .line 61
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzQ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v4, "queryProductDetailsAsync got a remote exception (try to reconnect)."

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    :catch_3
    move-exception v0

    .line 62
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzQ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v4, "queryProductDetailsAsync got a remote exception (try to reconnect)."

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaA(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;Ljava/lang/Exception;)Lcom/android/billingclient/api/zzch;

    move-result-object v0

    return-object v0

    .line 45
    :cond_e
    const-string v3, ""

    new-instance v4, Lcom/android/billingclient/api/zzch;

    const/4 v5, 0x0

    invoke-direct {v4, v5, v3, v0, v2}, Lcom/android/billingclient/api/zzch;-><init>(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V

    return-object v4
.end method

.method final zzl()Lcom/android/billingclient/api/zzcz;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzcz;

    return-object v0
.end method

.method final zzo(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;
    .locals 2

    .line 1
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v0

    if-eqz v0, :cond_0

    return-object p1

    :cond_0
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/os/Handler;

    new-instance v1, Lcom/android/billingclient/api/zzam;

    invoke-direct {v1, p0, p1}, Lcom/android/billingclient/api/zzam;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingResult;)V

    .line 2
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-object p1
.end method
