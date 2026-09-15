.class final Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;
.super Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field private final zza:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, v0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;-><init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzf;)V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zza:Landroid/content/Context;

    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/tasks/Task;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    invoke-virtual {p2}, Lcom/google/android/gms/tasks/Task;->isSuccessful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p2}, Lcom/google/android/gms/tasks/Task;->getResult()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    return-object p0

    .line 3
    :cond_0
    invoke-static {p0, p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zze(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic zzb(Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;)V
    .locals 8

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zza:Landroid/content/Context;

    const-class v1, Lcom/google/android/gms/games/internal/v2/appshortcuts/PlayGamesAppShortcutsActivity;

    invoke-static {v0, v1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzu;->zza(Landroid/content/Context;Ljava/lang/Class;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;

    move-result-object v1

    const-class v2, Landroid/content/pm/ShortcutManager;

    .line 2
    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ShortcutManager;

    .line 3
    invoke-virtual {v0}, Landroid/content/pm/ShortcutManager;->getDynamicShortcuts()Ljava/util/List;

    move-result-object v2

    .line 4
    invoke-static {v2}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zzg(Ljava/util/List;)Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object v2

    .line 5
    invoke-virtual {v0}, Landroid/content/pm/ShortcutManager;->getPinnedShortcuts()Ljava/util/List;

    move-result-object v3

    .line 6
    invoke-static {v3}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zzg(Ljava/util/List;)Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object v3

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;->zza()I

    move-result v4

    if-gtz v4, :cond_0

    goto :goto_0

    .line 20
    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zza:Landroid/content/Context;

    .line 9
    new-instance v4, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;

    invoke-direct {v4, p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;-><init>(Landroid/content/Context;)V

    .line 10
    invoke-static {}, Lcom/google/android/gms/common/api/internal/TaskApiCall;->builder()Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object p0

    const/16 v5, 0x1a58

    .line 11
    invoke-virtual {p0, v5}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->setMethodKey(I)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object p0

    const/4 v5, 0x1

    new-array v5, v5, [Lcom/google/android/gms/common/Feature;

    sget-object v6, Lcom/google/android/gms/games/zzd;->zzg:Lcom/google/android/gms/common/Feature;

    const/4 v7, 0x0

    aput-object v6, v5, v7

    .line 12
    invoke-virtual {p0, v5}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->setFeatures([Lcom/google/android/gms/common/Feature;)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object p0

    .line 13
    invoke-virtual {p0, v7}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->setAutoResolveMissingFeatures(Z)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object p0

    new-instance v5, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;

    invoke-direct {v5, v4, v1, v2, v3}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;-><init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;Ljava/util/List;Ljava/util/List;)V

    .line 14
    invoke-virtual {p0, v5}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->run(Lcom/google/android/gms/common/api/internal/RemoteCall;)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object p0

    .line 15
    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->build()Lcom/google/android/gms/common/api/internal/TaskApiCall;

    move-result-object p0

    .line 16
    invoke-virtual {v4, p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;->doRead(Lcom/google/android/gms/common/api/internal/TaskApiCall;)Lcom/google/android/gms/tasks/Task;

    move-result-object p0

    .line 17
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzgl;->zza()Ljava/util/concurrent/Executor;

    move-result-object v1

    new-instance v4, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;

    invoke-direct {v4, v2, v3}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;-><init>(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;)V

    .line 18
    invoke-virtual {p0, v1, v4}, Lcom/google/android/gms/tasks/Task;->continueWith(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/Continuation;)Lcom/google/android/gms/tasks/Task;

    move-result-object p0

    goto :goto_1

    .line 7
    :cond_1
    :goto_0
    invoke-static {v2, v3}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zze(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    move-result-object p0

    .line 8
    invoke-static {p0}, Lcom/google/android/gms/tasks/Tasks;->forResult(Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;

    move-result-object p0

    .line 19
    :goto_1
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzgl;->zza()Ljava/util/concurrent/Executor;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzc;

    invoke-direct {v2, v0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzc;-><init>(Landroid/content/pm/ShortcutManager;)V

    .line 20
    invoke-virtual {p0, v1, v2}, Lcom/google/android/gms/tasks/Task;->addOnSuccessListener(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnSuccessListener;)Lcom/google/android/gms/tasks/Task;

    return-void
.end method

.method private static zze(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;
    .locals 3

    .line 1
    invoke-static {p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zzf(Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object p0

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzgg;->zzg()Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object v0

    .line 3
    invoke-static {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zzf(Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object p1

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzgg;->zzg()Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object v1

    .line 5
    new-instance v2, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    .line 6
    invoke-direct {v2, p0, v0, p1, v1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;-><init>(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    return-object v2
.end method

.method private static zzf(Lcom/google/android/gms/internal/games_v2/zzgg;)Lcom/google/android/gms/internal/games_v2/zzgg;
    .locals 4

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzgd;

    invoke-direct {v0}, Lcom/google/android/gms/internal/games_v2/zzgd;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 2
    check-cast v3, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzj;

    .line 3
    invoke-virtual {v3}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzj;->zza()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 4
    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/games_v2/zzgd;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/games_v2/zzgd;

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 5
    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/games_v2/zzgd;->zzb()Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object p0

    return-object p0
.end method

.method private static zzg(Ljava/util/List;)Lcom/google/android/gms/internal/games_v2/zzgg;
    .locals 6

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzgd;

    invoke-direct {v0}, Lcom/google/android/gms/internal/games_v2/zzgd;-><init>()V

    .line 2
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_0
    :goto_0
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ShortcutInfo;

    .line 3
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->isImmutable()Z

    move-result v2

    if-nez v2, :cond_0

    .line 4
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "PLAY_GAMES_SERVICES_"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 5
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->getId()Ljava/lang/String;

    move-result-object v2

    .line 6
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->getExtras()Landroid/os/PersistableBundle;

    move-result-object v3

    .line 7
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->isPinned()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    .line 8
    invoke-virtual {v1}, Landroid/content/pm/ShortcutInfo;->isEnabled()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 9
    new-instance v5, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzj;

    .line 10
    invoke-direct {v5, v2, v3, v4, v1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzj;-><init>(Ljava/lang/String;Landroid/os/PersistableBundle;Ljava/lang/Boolean;Ljava/lang/Boolean;)V

    .line 11
    invoke-virtual {v0, v5}, Lcom/google/android/gms/internal/games_v2/zzgd;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/games_v2/zzgd;

    goto :goto_0

    .line 12
    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/games_v2/zzgd;->zzb()Lcom/google/android/gms/internal/games_v2/zzgg;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final zzc()V
    .locals 3

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzfr;->zza()Lcom/google/android/gms/internal/games_v2/zzfo;

    new-instance v0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzd;

    invoke-direct {v0, p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzd;-><init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;)V

    new-instance v1, Ljava/lang/Thread;

    const-string v2, "initialize-shortcuts"

    .line 2
    invoke-direct {v1, v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    return-void
.end method
