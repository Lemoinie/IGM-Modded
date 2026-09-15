.class final Lcom/google/android/gms/games/internal/zzw;
.super Lcom/google/android/gms/internal/games_v2/zzaj;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field final synthetic zza:Lcom/google/android/gms/games/internal/zzaj;


# direct methods
.method constructor <init>(Lcom/google/android/gms/games/internal/zzaj;)V
    .locals 1

    .line 1
    iput-object p1, p0, Lcom/google/android/gms/games/internal/zzw;->zza:Lcom/google/android/gms/games/internal/zzaj;

    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/zzaj;->getContext()Landroid/content/Context;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object p1

    const/16 v0, 0x3e8

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/games_v2/zzaj;-><init>(Landroid/os/Looper;I)V

    return-void
.end method


# virtual methods
.method protected final zza(Ljava/lang/String;I)V
    .locals 3

    .line 1
    const-string v0, "GamesGmsClientImpl"

    .line 0
    const-string v1, "Unable to increment event "

    .line 1
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gms/games/internal/zzw;->zza:Lcom/google/android/gms/games/internal/zzaj;

    invoke-virtual {v2}, Lcom/google/android/gms/games/internal/zzaj;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/games/internal/zzw;->zza:Lcom/google/android/gms/games/internal/zzaj;

    .line 2
    invoke-virtual {v1}, Lcom/google/android/gms/games/internal/zzaj;->getService()Landroid/os/IInterface;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/games/internal/zzao;

    invoke-virtual {v1, p1, p2}, Lcom/google/android/gms/games/internal/zzao;->zzw(Ljava/lang/String;I)V

    return-void

    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    .line 3
    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " by "

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " because the games client is no longer connected"

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzc(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 4
    sget p2, Lcom/google/android/gms/games/internal/zzaj;->zze:I

    const-string p2, "Is player signed out?"

    .line 5
    invoke-static {v0, p2, p1}, Lcom/google/android/gms/internal/games_v2/zzfn;->zzd(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void

    :catch_1
    move-exception p1

    .line 6
    invoke-static {p1}, Lcom/google/android/gms/games/internal/zzaj;->zzr(Landroid/os/RemoteException;)V

    return-void
.end method
