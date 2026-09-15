.class public final enum Lcom/google/android/gms/internal/ads/zzfoj;
.super Ljava/lang/Enum;
.source "com.google.android.gms:play-services-ads@@23.0.0"


# static fields
.field public static final enum zza:Lcom/google/android/gms/internal/ads/zzfoj;

.field public static final enum zzb:Lcom/google/android/gms/internal/ads/zzfoj;

.field public static final enum zzc:Lcom/google/android/gms/internal/ads/zzfoj;

.field private static final synthetic zzd:[Lcom/google/android/gms/internal/ads/zzfoj;


# instance fields
.field private final zze:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzfoj;

    const-string v1, "CTV"

    const/4 v2, 0x0

    const-string v3, "ctv"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/internal/ads/zzfoj;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzfoj;->zza:Lcom/google/android/gms/internal/ads/zzfoj;

    new-instance v1, Lcom/google/android/gms/internal/ads/zzfoj;

    const-string v2, "MOBILE"

    const/4 v3, 0x1

    .line 2
    const-string v4, "mobile"

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/internal/ads/zzfoj;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/google/android/gms/internal/ads/zzfoj;->zzb:Lcom/google/android/gms/internal/ads/zzfoj;

    new-instance v2, Lcom/google/android/gms/internal/ads/zzfoj;

    const-string v3, "OTHER"

    const/4 v4, 0x2

    .line 3
    const-string v5, "other"

    invoke-direct {v2, v3, v4, v5}, Lcom/google/android/gms/internal/ads/zzfoj;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v2, Lcom/google/android/gms/internal/ads/zzfoj;->zzc:Lcom/google/android/gms/internal/ads/zzfoj;

    filled-new-array {v0, v1, v2}, [Lcom/google/android/gms/internal/ads/zzfoj;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/ads/zzfoj;->zzd:[Lcom/google/android/gms/internal/ads/zzfoj;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/google/android/gms/internal/ads/zzfoj;->zze:Ljava/lang/String;

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/ads/zzfoj;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/ads/zzfoj;->zzd:[Lcom/google/android/gms/internal/ads/zzfoj;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/ads/zzfoj;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/ads/zzfoj;

    return-object v0
.end method


# virtual methods
.method public final toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzfoj;->zze:Ljava/lang/String;

    return-object v0
.end method
