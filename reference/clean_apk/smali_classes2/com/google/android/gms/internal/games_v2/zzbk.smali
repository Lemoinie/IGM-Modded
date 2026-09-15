.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzbk;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/internal/games_v2/zzgm;

.field public final synthetic zzb:Lcom/google/android/gms/tasks/TaskCompletionSource;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/games_v2/zzgm;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzbk;->zza:Lcom/google/android/gms/internal/games_v2/zzgm;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzbk;->zzb:Lcom/google/android/gms/tasks/TaskCompletionSource;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbk;->zza:Lcom/google/android/gms/internal/games_v2/zzgm;

    invoke-interface {v0}, Lcom/google/android/gms/internal/games_v2/zzgm;->zza()Ljava/lang/Object;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzbi;

    iget-object v2, p0, Lcom/google/android/gms/internal/games_v2/zzbk;->zzb:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-direct {v1, v2}, Lcom/google/android/gms/internal/games_v2/zzbi;-><init>(Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    check-cast v0, Lcom/google/android/gms/tasks/Task;

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/tasks/Task;->addOnCompleteListener(Lcom/google/android/gms/tasks/OnCompleteListener;)Lcom/google/android/gms/tasks/Task;

    return-void
.end method
