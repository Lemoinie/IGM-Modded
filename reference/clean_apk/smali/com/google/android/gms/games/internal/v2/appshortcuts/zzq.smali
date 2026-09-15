.class Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;
.super Lcom/google/android/gms/games/internal/v2/appshortcuts/zzx;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field protected final zza:Lcom/google/android/gms/tasks/TaskCompletionSource;


# direct methods
.method constructor <init>(Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzx;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;)V
    .locals 1

    .line 1
    new-instance p1, Lcom/google/android/gms/common/api/Status;

    const/16 v0, 0xa

    invoke-direct {p1, v0}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;->zzd(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method

.method public zzc(Landroid/content/Intent;)V
    .locals 1

    .line 1
    new-instance p1, Lcom/google/android/gms/common/api/Status;

    const/16 v0, 0xa

    invoke-direct {p1, v0}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;->zzd(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method

.method public final zzd(Lcom/google/android/gms/common/api/Status;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzq;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-static {p1}, Lcom/google/android/gms/common/internal/ApiExceptionUtil;->fromStatus(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/ApiException;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->trySetException(Ljava/lang/Exception;)Z

    return-void
.end method
