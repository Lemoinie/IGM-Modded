.class public final Lcom/google/android/gms/internal/ads/zzbcb;
.super Lcom/google/android/gms/internal/ads/zzgzu;
.source "com.google.android.gms:play-services-ads@@23.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/ads/zzhbf;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/ads/zzbcb;


# instance fields
.field private zzd:I

.field private zze:I

.field private zzf:I

.field private zzg:Lcom/google/android/gms/internal/ads/zzbcr;

.field private zzh:Lcom/google/android/gms/internal/ads/zzbct;

.field private zzi:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzj:Lcom/google/android/gms/internal/ads/zzbcv;

.field private zzk:Lcom/google/android/gms/internal/ads/zzbef;

.field private zzl:Lcom/google/android/gms/internal/ads/zzbdv;

.field private zzm:Lcom/google/android/gms/internal/ads/zzbdj;

.field private zzn:Lcom/google/android/gms/internal/ads/zzbdl;

.field private zzo:Lcom/google/android/gms/internal/ads/zzhad;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzbcb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzbcb;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzbcb;->zzb:Lcom/google/android/gms/internal/ads/zzbcb;

    const-class v1, Lcom/google/android/gms/internal/ads/zzbcb;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaU(Ljava/lang/Class;Lcom/google/android/gms/internal/ads/zzgzu;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/ads/zzgzu;-><init>()V

    const/16 v0, 0x3e8

    iput v0, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzf:I

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzbcb;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzi:Lcom/google/android/gms/internal/ads/zzhad;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzbcb;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzo:Lcom/google/android/gms/internal/ads/zzhad;

    return-void
.end method

.method static synthetic zza()Lcom/google/android/gms/internal/ads/zzbcb;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzbcb;->zzb:Lcom/google/android/gms/internal/ads/zzbcb;

    return-object v0
.end method

.method public static zzc()Lcom/google/android/gms/internal/ads/zzbcb;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzbcb;->zzb:Lcom/google/android/gms/internal/ads/zzbcb;

    return-object v0
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/ads/zzbcb;Lcom/google/android/gms/internal/ads/zzbbz;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/internal/ads/zzbbz;->zza()I

    move-result p1

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zze:I

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzd:I

    or-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzd:I

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/ads/zzbcb;Lcom/google/android/gms/internal/ads/zzbct;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzh:Lcom/google/android/gms/internal/ads/zzbct;

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzd:I

    or-int/lit8 p1, p1, 0x8

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzd:I

    return-void
.end method


# virtual methods
.method protected final zzb(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 17

    add-int/lit8 v0, p1, -0x1

    if-eqz v0, :cond_4

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2

    const/4 v1, 0x4

    const/4 v2, 0x0

    if-eq v0, v1, :cond_1

    const/4 v1, 0x5

    if-eq v0, v1, :cond_0

    return-object v2

    .line 1
    :cond_0
    sget-object v0, Lcom/google/android/gms/internal/ads/zzbcb;->zzb:Lcom/google/android/gms/internal/ads/zzbcb;

    return-object v0

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzbca;

    .line 4
    invoke-direct {v0, v2}, Lcom/google/android/gms/internal/ads/zzbca;-><init>(Lcom/google/android/gms/internal/ads/zzbbw;)V

    return-object v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/ads/zzbcb;

    .line 5
    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzbcb;-><init>()V

    return-object v0

    .line 2
    :cond_3
    sget-object v3, Lcom/google/android/gms/internal/ads/zzbby;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    sget-object v5, Lcom/google/android/gms/internal/ads/zzbdc;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-class v9, Lcom/google/android/gms/internal/ads/zzbcp;

    const-string v15, "zzo"

    const-class v16, Lcom/google/android/gms/internal/ads/zzber;

    const-string v1, "zzd"

    const-string v2, "zze"

    const-string v4, "zzf"

    const-string v6, "zzg"

    const-string v7, "zzh"

    const-string v8, "zzi"

    const-string v10, "zzj"

    const-string v11, "zzk"

    const-string v12, "zzl"

    const-string v13, "zzm"

    const-string v14, "zzn"

    filled-new-array/range {v1 .. v16}, [Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/ads/zzbcb;->zzb:Lcom/google/android/gms/internal/ads/zzbcb;

    const-string v2, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007\u180c\u0000\u0008\u180c\u0001\t\u1009\u0002\n\u1009\u0003\u000b\u001b\u000c\u1009\u0004\r\u1009\u0005\u000e\u1009\u0006\u000f\u1009\u0007\u0010\u1009\u0008\u0011\u001b"

    .line 3
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/ads/zzbcb;->zzaR(Lcom/google/android/gms/internal/ads/zzhbe;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_4
    const/4 v0, 0x1

    .line 1
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method

.method public final zzd()Lcom/google/android/gms/internal/ads/zzbct;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzbcb;->zzh:Lcom/google/android/gms/internal/ads/zzbct;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/ads/zzbct;->zzc()Lcom/google/android/gms/internal/ads/zzbct;

    move-result-object v0

    :cond_0
    return-object v0
.end method
