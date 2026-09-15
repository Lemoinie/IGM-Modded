.class public final Lcom/google/android/gms/internal/games_v2/zzbb;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field private static final zza:Ljava/util/concurrent/atomic/AtomicReference;


# instance fields
.field private final zzb:Lcom/google/android/gms/internal/games_v2/zzba;

.field private final zzc:Lcom/google/android/gms/internal/games_v2/zzbc;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzbb;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method

.method constructor <init>(Landroid/app/Application;Lcom/google/android/gms/internal/games_v2/zzbc;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzba;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/google/android/gms/internal/games_v2/zzba;-><init>(Lcom/google/android/gms/internal/games_v2/zzbb;Landroid/app/Application;Lcom/google/android/gms/internal/games_v2/zzaz;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbb;->zzb:Lcom/google/android/gms/internal/games_v2/zzba;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzbb;->zzc:Lcom/google/android/gms/internal/games_v2/zzbc;

    return-void
.end method

.method static zza(Landroid/app/Application;)Lcom/google/android/gms/internal/games_v2/zzbb;
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzbb;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/games_v2/zzbb;

    if-eqz v1, :cond_0

    return-object v1

    :cond_0
    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzbb;

    .line 2
    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzbe;->zza(Landroid/app/Application;)Lcom/google/android/gms/internal/games_v2/zzbc;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/google/android/gms/internal/games_v2/zzbb;-><init>(Landroid/app/Application;Lcom/google/android/gms/internal/games_v2/zzbc;)V

    :cond_1
    const/4 p0, 0x0

    .line 3
    invoke-static {v0, p0, v1}, Landroidx/lifecycle/LifecycleKt$$ExternalSyntheticBackportWithForwarding0;->m(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_2

    goto :goto_0

    :cond_2
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object p0

    if-eqz p0, :cond_1

    :goto_0
    sget-object p0, Lcom/google/android/gms/internal/games_v2/zzbb;->zza:Ljava/util/concurrent/atomic/AtomicReference;

    .line 4
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/games_v2/zzbb;

    invoke-static {p0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/games_v2/zzbb;

    return-object p0
.end method

.method static bridge synthetic zzb(Lcom/google/android/gms/internal/games_v2/zzbb;)Lcom/google/android/gms/internal/games_v2/zzbc;
    .locals 0

    iget-object p0, p0, Lcom/google/android/gms/internal/games_v2/zzbb;->zzc:Lcom/google/android/gms/internal/games_v2/zzbc;

    return-object p0
.end method


# virtual methods
.method public final zzc()V
    .locals 2

    .line 1
    const-string v0, "AutomaticGamesAuthenticator"

    const-string v1, "startWatching()"

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/games_v2/zzfn;->zza(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbb;->zzb:Lcom/google/android/gms/internal/games_v2/zzba;

    .line 2
    invoke-static {v0}, Lcom/google/android/gms/internal/games_v2/zzba;->zza(Lcom/google/android/gms/internal/games_v2/zzba;)V

    return-void
.end method
