.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzt;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/internal/games_v2/zzw;

.field public final synthetic zzb:Lcom/google/android/gms/internal/games_v2/zzy;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/games_v2/zzw;Lcom/google/android/gms/internal/games_v2/zzy;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzt;->zza:Lcom/google/android/gms/internal/games_v2/zzw;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzt;->zzb:Lcom/google/android/gms/internal/games_v2/zzy;

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2

    check-cast p1, Lcom/google/android/gms/internal/games_v2/zzx;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/internal/games_v2/zzx;->getService()Landroid/os/IInterface;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/games_v2/zzae;

    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzv;

    iget-object v1, p0, Lcom/google/android/gms/internal/games_v2/zzt;->zza:Lcom/google/android/gms/internal/games_v2/zzw;

    invoke-direct {v0, v1, p2}, Lcom/google/android/gms/internal/games_v2/zzv;-><init>(Lcom/google/android/gms/internal/games_v2/zzw;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    iget-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzt;->zzb:Lcom/google/android/gms/internal/games_v2/zzy;

    .line 2
    invoke-virtual {p1, v0, p2}, Lcom/google/android/gms/internal/games_v2/zzae;->zzd(Lcom/google/android/gms/internal/games_v2/zzad;Lcom/google/android/gms/internal/games_v2/zzy;)V

    return-void
.end method
