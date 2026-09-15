.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzeo;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/tasks/SuccessContinuation;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/internal/games_v2/zzer;

.field public final synthetic zzb:Lcom/google/android/gms/common/api/internal/TaskApiCall;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/games_v2/zzer;Lcom/google/android/gms/common/api/internal/TaskApiCall;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzeo;->zza:Lcom/google/android/gms/internal/games_v2/zzer;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzeo;->zzb:Lcom/google/android/gms/common/api/internal/TaskApiCall;

    return-void
.end method


# virtual methods
.method public final then(Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;
    .locals 1

    check-cast p1, Lcom/google/android/gms/games/AuthenticationResult;

    .line 1
    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzeo;->zza:Lcom/google/android/gms/internal/games_v2/zzer;

    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzeo;->zzb:Lcom/google/android/gms/common/api/internal/TaskApiCall;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/games_v2/zzer;->doRead(Lcom/google/android/gms/common/api/internal/TaskApiCall;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method
