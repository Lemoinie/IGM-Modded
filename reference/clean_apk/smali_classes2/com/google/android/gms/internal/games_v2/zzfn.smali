.class public final Lcom/google/android/gms/internal/games_v2/zzfn;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field private static final zza:Lcom/google/android/gms/common/internal/GmsLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/common/internal/GmsLogger;

    const-string v1, "Games"

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/internal/GmsLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    return-void
.end method

.method public static zza(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/gms/common/internal/GmsLogger;->d(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static zzb(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    sget-object p0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    const-string p1, "GamesApiManager"

    invoke-static {p1}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "Authentication task failed"

    invoke-virtual {p0, p1, v0, p2}, Lcom/google/android/gms/common/internal/GmsLogger;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public static zzc(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/gms/common/internal/GmsLogger;->e(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static zzd(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/common/internal/GmsLogger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public static zze(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    sget-object p0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    const-string p1, "SnapshotContentsEntity"

    invoke-static {p1}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "Failed to write snapshot data"

    invoke-virtual {p0, p1, v0, p2}, Lcom/google/android/gms/common/internal/GmsLogger;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public static zzf(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/gms/common/internal/GmsLogger;->v(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static zzg(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1}, Lcom/google/android/gms/common/internal/GmsLogger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static zzh(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfn;->zza:Lcom/google/android/gms/common/internal/GmsLogger;

    invoke-static {p0}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzi(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/common/internal/GmsLogger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private static zzi(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 1
    const-string v0, "PlayGamesServices"

    filled-new-array {v0, p0}, [Ljava/lang/Object;

    move-result-object p0

    const-string v0, "%s[%s]"

    invoke-static {v0, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
