.class public final synthetic Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/tasks/Continuation;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/internal/games_v2/zzgg;

.field public final synthetic zzb:Lcom/google/android/gms/internal/games_v2/zzgg;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;->zza:Lcom/google/android/gms/internal/games_v2/zzgg;

    iput-object p2, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;->zzb:Lcom/google/android/gms/internal/games_v2/zzgg;

    return-void
.end method


# virtual methods
.method public final then(Lcom/google/android/gms/tasks/Task;)Ljava/lang/Object;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;->zza:Lcom/google/android/gms/internal/games_v2/zzgg;

    iget-object v1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzb;->zzb:Lcom/google/android/gms/internal/games_v2/zzgg;

    invoke-static {v0, v1, p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;->zza(Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/internal/games_v2/zzgg;Lcom/google/android/gms/tasks/Task;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    move-result-object p1

    return-object p1
.end method
