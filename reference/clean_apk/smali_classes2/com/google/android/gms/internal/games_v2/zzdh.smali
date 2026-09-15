.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzdh;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/games_v2/zzax;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;

.field public final synthetic zzb:I

.field public final synthetic zzc:I


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;II)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zza:Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;

    iput p2, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zzb:I

    iput p3, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zzc:I

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/tasks/Task;
    .locals 5

    .line 1
    invoke-static {}, Lcom/google/android/gms/common/api/internal/TaskApiCall;->builder()Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzdg;

    iget-object v2, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zza:Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;

    iget v3, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zzb:I

    iget v4, p0, Lcom/google/android/gms/internal/games_v2/zzdh;->zzc:I

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/internal/games_v2/zzdg;-><init>(Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;II)V

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;->run(Lcom/google/android/gms/common/api/internal/RemoteCall;)Lcom/google/android/gms/common/api/internal/TaskApiCall$Builder;

    move-result-object v0

    const/16 v1, 0x1a32

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
