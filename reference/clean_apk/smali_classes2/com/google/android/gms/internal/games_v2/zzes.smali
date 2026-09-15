.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzes;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Ljava/lang/String;

.field public final synthetic zzb:Z

.field public final synthetic zzc:Z

.field public final synthetic zzd:I


# direct methods
.method public synthetic constructor <init>(Ljava/lang/String;ZZI)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zza:Ljava/lang/String;

    iput-boolean p2, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzb:Z

    iput-boolean p3, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzc:Z

    iput p4, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzd:I

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4

    check-cast p1, Lcom/google/android/gms/games/internal/zzaj;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/zzaj;->getService()Landroid/os/IInterface;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/games/internal/zzao;

    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zza:Ljava/lang/String;

    iget-boolean v1, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzb:Z

    iget-boolean v2, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzc:Z

    iget v3, p0, Lcom/google/android/gms/internal/games_v2/zzes;->zzd:I

    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/google/android/gms/games/internal/zzao;->zzm(Ljava/lang/String;ZZI)Landroid/content/Intent;

    move-result-object p1

    .line 2
    invoke-virtual {p2, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setResult(Ljava/lang/Object;)V

    return-void
.end method
