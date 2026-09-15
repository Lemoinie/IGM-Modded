.class final Lcom/google/android/gms/games/internal/v2/appshortcuts/zzo;
.super Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# direct methods
.method constructor <init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    .line 1
    invoke-direct {p0, p2}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;-><init>(Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    return-void
.end method


# virtual methods
.method public final zzb(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;)V
    .locals 1

    if-nez p1, :cond_0

    .line 1
    new-instance p1, Lcom/google/android/gms/common/api/Status;

    const/16 v0, 0x11

    invoke-direct {p1, v0}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;->zzd(Lcom/google/android/gms/common/api/Status;)V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzo;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->trySetResult(Ljava/lang/Object;)Z

    return-void
.end method
