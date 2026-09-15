.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzdf;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Ljava/lang/String;

.field public final synthetic zzb:I

.field public final synthetic zzc:I

.field public final synthetic zzd:I

.field public final synthetic zze:Z


# direct methods
.method public synthetic constructor <init>(Ljava/lang/String;IIIZ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zza:Ljava/lang/String;

    iput p2, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzb:I

    iput p3, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzc:I

    iput p4, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzd:I

    iput-boolean p5, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zze:Z

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 7

    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/games/internal/zzaj;

    move-object v1, p2

    check-cast v1, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    iget-object v2, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zza:Ljava/lang/String;

    iget v3, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzb:I

    iget v4, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzc:I

    iget v5, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zzd:I

    iget-boolean v6, p0, Lcom/google/android/gms/internal/games_v2/zzdf;->zze:Z

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/games/internal/zzaj;->zzG(Lcom/google/android/gms/tasks/TaskCompletionSource;Ljava/lang/String;IIIZ)V

    return-void
.end method
