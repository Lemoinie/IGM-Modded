.class public final Lcom/google/android/gms/internal/games_v2/zzby;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field private static final zza:Ljava/util/concurrent/atomic/AtomicReference;

.field private static zzb:Z


# instance fields
.field private final zzc:Landroid/app/Application;

.field private final zzd:Lcom/google/android/gms/internal/games_v2/zzbb;

.field private final zze:Lcom/google/android/gms/games/internal/zzg;

.field private final zzf:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzby;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v0, 0x0

    sput-boolean v0, Lcom/google/android/gms/internal/games_v2/zzby;->zzb:Z

    return-void
.end method

.method private constructor <init>(Landroid/app/Application;Lcom/google/android/gms/internal/games_v2/zzbb;Lcom/google/android/gms/games/internal/zzg;Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzby;->zzc:Landroid/app/Application;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzby;->zzd:Lcom/google/android/gms/internal/games_v2/zzbb;

    iput-object p3, p0, Lcom/google/android/gms/internal/games_v2/zzby;->zze:Lcom/google/android/gms/games/internal/zzg;

    iput-object p4, p0, Lcom/google/android/gms/internal/games_v2/zzby;->zzf:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;

    return-void
.end method

.method public static zza()Landroid/app/Application;
    .locals 1

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzby;->zzb()V

    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzby;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    .line 2
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/games_v2/zzby;

    iget-object v0, v0, Lcom/google/android/gms/internal/games_v2/zzby;->zzc:Landroid/app/Application;

    return-object v0
.end method

.method public static zzb()V
    .locals 2

    .line 1
    sget-boolean v0, Lcom/google/android/gms/internal/games_v2/zzby;->zzb:Z

    const-string v1, "PlayGamesSdk has not been initialized. Ensure that PlayGamesSdk.initialize() has been called."

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/Preconditions;->checkState(ZLjava/lang/Object;)V

    return-void
.end method

.method public static zzc(Landroid/content/Context;)V
    .locals 6

    const/4 v0, 0x1

    if-eqz p0, :cond_0

    move v1, v0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 1
    :goto_0
    invoke-static {v1}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    sget-object v1, Lcom/google/android/gms/internal/games_v2/zzby;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    .line 2
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_3

    .line 3
    monitor-enter v1

    .line 4
    :try_start_0
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_2

    .line 5
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 6
    check-cast v2, Landroid/app/Application;

    goto :goto_1

    .line 7
    :cond_1
    move-object v2, p0

    check-cast v2, Landroid/app/Application;

    .line 8
    :goto_1
    invoke-static {v2}, Lcom/google/android/gms/internal/games_v2/zzbb;->zza(Landroid/app/Application;)Lcom/google/android/gms/internal/games_v2/zzbb;

    move-result-object v3

    .line 9
    invoke-static {v2}, Lcom/google/android/gms/games/internal/zzg;->zzb(Landroid/app/Application;)Lcom/google/android/gms/games/internal/zzg;

    move-result-object v4

    new-instance v5, Lcom/google/android/gms/internal/games_v2/zzby;

    .line 10
    invoke-static {p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;->zzd(Landroid/content/Context;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;

    move-result-object p0

    invoke-direct {v5, v2, v3, v4, p0}, Lcom/google/android/gms/internal/games_v2/zzby;-><init>(Landroid/app/Application;Lcom/google/android/gms/internal/games_v2/zzbb;Lcom/google/android/gms/games/internal/zzg;Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;)V

    .line 11
    invoke-virtual {v1, v5}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    iget-object p0, v5, Lcom/google/android/gms/internal/games_v2/zzby;->zzf:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;

    .line 12
    invoke-virtual {p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;->zzc()V

    iget-object p0, v5, Lcom/google/android/gms/internal/games_v2/zzby;->zzd:Lcom/google/android/gms/internal/games_v2/zzbb;

    .line 13
    invoke-virtual {p0}, Lcom/google/android/gms/internal/games_v2/zzbb;->zzc()V

    iget-object p0, v5, Lcom/google/android/gms/internal/games_v2/zzby;->zze:Lcom/google/android/gms/games/internal/zzg;

    .line 14
    invoke-virtual {p0}, Lcom/google/android/gms/games/internal/zzg;->zzg()V

    .line 15
    :cond_2
    monitor-exit v1

    goto :goto_2

    :catchall_0
    move-exception p0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p0

    :cond_3
    :goto_2
    sput-boolean v0, Lcom/google/android/gms/internal/games_v2/zzby;->zzb:Z

    return-void
.end method
