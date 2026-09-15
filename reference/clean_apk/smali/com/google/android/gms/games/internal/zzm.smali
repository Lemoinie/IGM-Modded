.class final Lcom/google/android/gms/games/internal/zzm;
.super Lcom/google/android/gms/internal/games_v2/zzak;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# instance fields
.field final synthetic zza:Lcom/google/android/gms/games/internal/zzaj;


# direct methods
.method constructor <init>(Lcom/google/android/gms/games/internal/zzaj;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/google/android/gms/games/internal/zzm;->zza:Lcom/google/android/gms/games/internal/zzaj;

    invoke-direct {p0}, Lcom/google/android/gms/internal/games_v2/zzak;-><init>()V

    return-void
.end method


# virtual methods
.method public final zza()Lcom/google/android/gms/internal/games_v2/zzaj;
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/games/internal/zzw;

    iget-object v1, p0, Lcom/google/android/gms/games/internal/zzm;->zza:Lcom/google/android/gms/games/internal/zzaj;

    invoke-direct {v0, v1}, Lcom/google/android/gms/games/internal/zzw;-><init>(Lcom/google/android/gms/games/internal/zzaj;)V

    return-object v0
.end method
