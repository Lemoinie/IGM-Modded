.class public final Lcom/google/android/gms/internal/ads/zzhfd;
.super Lcom/google/android/gms/internal/ads/zzgzu;
.source "com.google.android.gms:play-services-ads@@23.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/ads/zzhbf;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/ads/zzhfd;


# instance fields
.field private zzd:I

.field private zze:I

.field private zzf:I

.field private zzg:J

.field private zzh:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzhfd;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhfd;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzhfd;->zzb:Lcom/google/android/gms/internal/ads/zzhfd;

    const-class v1, Lcom/google/android/gms/internal/ads/zzhfd;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaU(Ljava/lang/Class;Lcom/google/android/gms/internal/ads/zzgzu;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/ads/zzgzu;-><init>()V

    return-void
.end method

.method static synthetic zza()Lcom/google/android/gms/internal/ads/zzhfd;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzhfd;->zzb:Lcom/google/android/gms/internal/ads/zzhfd;

    return-object v0
.end method


# virtual methods
.method protected final zzb(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    add-int/lit8 p1, p1, -0x1

    if-eqz p1, :cond_4

    const/4 p2, 0x2

    if-eq p1, p2, :cond_3

    const/4 p2, 0x3

    if-eq p1, p2, :cond_2

    const/4 p2, 0x4

    const/4 p3, 0x0

    if-eq p1, p2, :cond_1

    const/4 p2, 0x5

    if-eq p1, p2, :cond_0

    return-object p3

    .line 1
    :cond_0
    sget-object p1, Lcom/google/android/gms/internal/ads/zzhfd;->zzb:Lcom/google/android/gms/internal/ads/zzhfd;

    return-object p1

    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/ads/zzhfb;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/ads/zzhfb;-><init>(Lcom/google/android/gms/internal/ads/zzhdp;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/ads/zzhfd;

    invoke-direct {p1}, Lcom/google/android/gms/internal/ads/zzhfd;-><init>()V

    return-object p1

    .line 2
    :cond_3
    sget-object v2, Lcom/google/android/gms/internal/ads/zzhfc;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-string v4, "zzg"

    const-string v5, "zzh"

    const-string v0, "zzd"

    const-string v1, "zze"

    const-string v3, "zzf"

    filled-new-array/range {v0 .. v5}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/ads/zzhfd;->zzb:Lcom/google/android/gms/internal/ads/zzhfd;

    const-string p3, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u180c\u0000\u0002\u1004\u0001\u0003\u1002\u0002\u0004\u1002\u0003"

    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/ads/zzhfd;->zzaR(Lcom/google/android/gms/internal/ads/zzhbe;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
