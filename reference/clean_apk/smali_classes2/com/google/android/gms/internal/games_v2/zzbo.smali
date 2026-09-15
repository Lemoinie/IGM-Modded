.class final enum Lcom/google/android/gms/internal/games_v2/zzbo;
.super Ljava/lang/Enum;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field public static final enum zza:Lcom/google/android/gms/internal/games_v2/zzbo;

.field public static final enum zzb:Lcom/google/android/gms/internal/games_v2/zzbo;

.field public static final enum zzc:Lcom/google/android/gms/internal/games_v2/zzbo;

.field private static final synthetic zzd:[Lcom/google/android/gms/internal/games_v2/zzbo;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/games_v2/zzbo;

    const-string v1, "AUTOMATIC"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/games_v2/zzbo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzbo;->zza:Lcom/google/android/gms/internal/games_v2/zzbo;

    new-instance v1, Lcom/google/android/gms/internal/games_v2/zzbo;

    const-string v2, "AUTOMATIC_PENDING_EXPLICIT"

    const/4 v3, 0x1

    .line 2
    invoke-direct {v1, v2, v3}, Lcom/google/android/gms/internal/games_v2/zzbo;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lcom/google/android/gms/internal/games_v2/zzbo;->zzb:Lcom/google/android/gms/internal/games_v2/zzbo;

    new-instance v2, Lcom/google/android/gms/internal/games_v2/zzbo;

    const-string v3, "EXPLICIT"

    const/4 v4, 0x2

    .line 3
    invoke-direct {v2, v3, v4}, Lcom/google/android/gms/internal/games_v2/zzbo;-><init>(Ljava/lang/String;I)V

    sput-object v2, Lcom/google/android/gms/internal/games_v2/zzbo;->zzc:Lcom/google/android/gms/internal/games_v2/zzbo;

    filled-new-array {v0, v1, v2}, [Lcom/google/android/gms/internal/games_v2/zzbo;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/games_v2/zzbo;->zzd:[Lcom/google/android/gms/internal/games_v2/zzbo;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/games_v2/zzbo;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/games_v2/zzbo;->zzd:[Lcom/google/android/gms/internal/games_v2/zzbo;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/games_v2/zzbo;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/games_v2/zzbo;

    return-object v0
.end method
