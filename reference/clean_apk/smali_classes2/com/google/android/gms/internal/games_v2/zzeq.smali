.class final Lcom/google/android/gms/internal/games_v2/zzeq;
.super Lcom/google/android/gms/internal/games_v2/zzfl;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field final synthetic zza:Lcom/google/android/gms/tasks/TaskCompletionSource;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/games_v2/zzer;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    .line 1
    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzeq;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-direct {p0}, Lcom/google/android/gms/internal/games_v2/zzfl;-><init>()V

    return-void
.end method


# virtual methods
.method public final zzb(Lcom/google/android/gms/common/api/Status;)V
    .locals 1

    .line 1
    new-instance v0, Lcom/google/android/gms/common/api/ApiException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/common/api/ApiException;-><init>(Lcom/google/android/gms/common/api/Status;)V

    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzeq;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setException(Ljava/lang/Exception;)V

    return-void
.end method

.method public final zzc(Lcom/google/android/gms/internal/games_v2/zzau;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzeq;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-static {p1}, Lcom/google/android/gms/games/RecallAccess;->zza(Lcom/google/android/gms/internal/games_v2/zzau;)Lcom/google/android/gms/games/RecallAccess;

    move-result-object p1

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setResult(Ljava/lang/Object;)V

    return-void
.end method
