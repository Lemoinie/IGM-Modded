.class public final Lcom/google/android/gms/internal/games_v2/zzdt;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/games/PlayerStatsClient;


# instance fields
.field private final zza:Lcom/google/android/gms/internal/games_v2/zzay;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/games_v2/zzay;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzdt;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    return-void
.end method


# virtual methods
.method public final loadPlayerStats(Z)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/games/AnnotatedData<",
            "Lcom/google/android/gms/games/stats/PlayerStats;",
            ">;>;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzdr;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/games_v2/zzdr;-><init>(Z)V

    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzdt;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/games_v2/zzay;->zzb(Lcom/google/android/gms/internal/games_v2/zzax;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method
