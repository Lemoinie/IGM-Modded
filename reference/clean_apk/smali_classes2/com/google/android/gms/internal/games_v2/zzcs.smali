.class public final Lcom/google/android/gms/internal/games_v2/zzcs;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/games/EventsClient;


# instance fields
.field private final zza:Lcom/google/android/gms/internal/games_v2/zzay;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/games_v2/zzay;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzcs;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    return-void
.end method


# virtual methods
.method public final increment(Ljava/lang/String;I)V
    .locals 1

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzcn;

    invoke-direct {v0, p1, p2}, Lcom/google/android/gms/internal/games_v2/zzcn;-><init>(Ljava/lang/String;I)V

    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzcs;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/games_v2/zzay;->zzb(Lcom/google/android/gms/internal/games_v2/zzax;)Lcom/google/android/gms/tasks/Task;

    return-void
.end method

.method public final load(Z)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/games/AnnotatedData<",
            "Lcom/google/android/gms/games/event/EventBuffer;",
            ">;>;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzco;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/games_v2/zzco;-><init>(Z)V

    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzcs;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/games_v2/zzay;->zzb(Lcom/google/android/gms/internal/games_v2/zzax;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final varargs loadByIds(Z[Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z[",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/games/AnnotatedData<",
            "Lcom/google/android/gms/games/event/EventBuffer;",
            ">;>;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzcq;

    invoke-direct {v0, p1, p2}, Lcom/google/android/gms/internal/games_v2/zzcq;-><init>(Z[Ljava/lang/String;)V

    iget-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzcs;->zza:Lcom/google/android/gms/internal/games_v2/zzay;

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/games_v2/zzay;->zzb(Lcom/google/android/gms/internal/games_v2/zzax;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method
