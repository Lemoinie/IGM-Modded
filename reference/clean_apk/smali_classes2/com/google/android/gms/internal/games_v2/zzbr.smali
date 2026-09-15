.class final Lcom/google/android/gms/internal/games_v2/zzbr;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field private final zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

.field private final zzb:Lcom/google/android/gms/internal/games_v2/zzaw;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/games_v2/zzaw;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zzb:Lcom/google/android/gms/internal/games_v2/zzaw;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/common/api/GoogleApi;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zzb:Lcom/google/android/gms/internal/games_v2/zzaw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/games_v2/zzaw;->zza(Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/games_v2/zzgl;->zza()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzbq;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/games_v2/zzbq;-><init>(Lcom/google/android/gms/internal/games_v2/zzbr;)V

    .line 3
    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/tasks/Task;->addOnCompleteListener(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnCompleteListener;)Lcom/google/android/gms/tasks/Task;

    return-void
.end method

.method final synthetic zzb(Lcom/google/android/gms/tasks/Task;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/tasks/Task;->isSuccessful()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/tasks/Task;->getResult()Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setResult(Ljava/lang/Object;)V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 3
    invoke-virtual {p1}, Lcom/google/android/gms/tasks/Task;->getException()Ljava/lang/Exception;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/games_v2/zzfx;->zza(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setException(Ljava/lang/Exception;)V

    return-void
.end method

.method public final zzc(Ljava/lang/Exception;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbr;->zza:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setException(Ljava/lang/Exception;)V

    return-void
.end method
