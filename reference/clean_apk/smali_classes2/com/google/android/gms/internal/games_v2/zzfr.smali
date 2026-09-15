.class public final Lcom/google/android/gms/internal/games_v2/zzfr;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field private static final zza:Lcom/google/android/gms/internal/games_v2/zzfo;

.field private static volatile zzb:Lcom/google/android/gms/internal/games_v2/zzfo;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzfq;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/games_v2/zzfq;-><init>(Lcom/google/android/gms/internal/games_v2/zzfp;)V

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzfr;->zza:Lcom/google/android/gms/internal/games_v2/zzfo;

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzfr;->zzb:Lcom/google/android/gms/internal/games_v2/zzfo;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/games_v2/zzfo;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzfr;->zzb:Lcom/google/android/gms/internal/games_v2/zzfo;

    return-object v0
.end method
