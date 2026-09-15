.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzcp;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;


# instance fields
.field public final synthetic zza:Ljava/lang/String;

.field public final synthetic zzb:I


# direct methods
.method public synthetic constructor <init>(Ljava/lang/String;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzcp;->zza:Ljava/lang/String;

    iput p2, p0, Lcom/google/android/gms/internal/games_v2/zzcp;->zzb:I

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1

    check-cast p1, Lcom/google/android/gms/games/internal/zzaj;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    .line 1
    iget-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzcp;->zza:Ljava/lang/String;

    iget v0, p0, Lcom/google/android/gms/internal/games_v2/zzcp;->zzb:I

    invoke-virtual {p1, p2, v0}, Lcom/google/android/gms/games/internal/zzaj;->zzx(Ljava/lang/String;I)V

    return-void
.end method
