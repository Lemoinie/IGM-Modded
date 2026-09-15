.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzcr;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Z

.field public final synthetic zzb:[Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Z[Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Lcom/google/android/gms/internal/games_v2/zzcr;->zza:Z

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzcr;->zzb:[Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2

    check-cast p1, Lcom/google/android/gms/games/internal/zzaj;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    iget-boolean v0, p0, Lcom/google/android/gms/internal/games_v2/zzcr;->zza:Z

    iget-object v1, p0, Lcom/google/android/gms/internal/games_v2/zzcr;->zzb:[Ljava/lang/String;

    invoke-virtual {p1, p2, v0, v1}, Lcom/google/android/gms/games/internal/zzaj;->zzB(Lcom/google/android/gms/tasks/TaskCompletionSource;Z[Ljava/lang/String;)V

    return-void
.end method
