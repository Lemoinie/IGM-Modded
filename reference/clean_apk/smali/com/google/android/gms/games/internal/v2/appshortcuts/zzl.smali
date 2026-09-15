.class public final synthetic Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;

.field public final synthetic zzb:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;

.field public final synthetic zzc:Ljava/util/List;

.field public final synthetic zzd:Ljava/util/List;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;Ljava/util/List;Ljava/util/List;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zza:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;

    iput-object p2, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzb:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;

    iput-object p3, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzc:Ljava/util/List;

    iput-object p4, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzd:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 3

    check-cast p1, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzv;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzv;->getService()Landroid/os/IInterface;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzw;

    new-instance v0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzo;

    iget-object v1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zza:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;

    invoke-direct {v0, v1, p2}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzo;-><init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzr;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    iget-object p2, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzb:Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;

    iget-object v1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzc:Ljava/util/List;

    iget-object v2, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzl;->zzd:Ljava/util/List;

    .line 2
    invoke-virtual {p1, v0, p2, v1, v2}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzw;->zzd(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzy;Lcom/google/android/gms/games/internal/v2/appshortcuts/zzs;Ljava/util/List;Ljava/util/List;)V

    return-void
.end method
