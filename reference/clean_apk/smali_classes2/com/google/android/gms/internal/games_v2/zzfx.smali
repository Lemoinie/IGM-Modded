.class public final Lcom/google/android/gms/internal/games_v2/zzfx;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# direct methods
.method public static zza(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    const/4 v0, 0x0

    .line 1
    new-array v0, v0, [Ljava/lang/Object;

    if-eqz p0, :cond_0

    return-object p0

    :cond_0
    new-instance p0, Lcom/google/android/gms/internal/games_v2/zzfy;

    const-string v1, "expected a non-null reference"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/games_v2/zzfw;->zza(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/games_v2/zzfy;-><init>(Ljava/lang/String;)V

    throw p0
.end method
