.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzej;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/games_v2/zzax;


# instance fields
.field public final synthetic zza:Ljava/lang/String;

.field public final synthetic zzb:Ljava/lang/String;

.field public final synthetic zzc:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zza:Ljava/lang/String;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zzb:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zzc:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/tasks/Task;
    .locals 5

    .line 1
    invoke-static {}, Lcom/google/android/gms/common/api/internal/TaskApiCall;->builder()Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzea;

    iget-object v2, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zza:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zzb:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gms/internal/games_v2/zzej;->zzc:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/internal/games_v2/zzea;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->run(Lcom/google/android/gms/common/api/internal/RemoteCall;)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object v0

    const/16 v1, 0x1a38

    .line 3
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->setMethodKey(I)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object v0

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->build()Lcom/google/android/gms/common/api/internal/TaskApiCall;

    move-result-object v0

    .line 5
    invoke-virtual {p1, v0}, Lcom/google/android/gms/common/api/GoogleApi;->doRead(Lcom/google/android/gms/common/api/internal/TaskApiCall;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method
