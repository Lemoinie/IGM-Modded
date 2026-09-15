.class public final Lcom/google/android/gms/internal/ads/zzhdz;
.super Lcom/google/android/gms/internal/ads/zzgzu;
.source "com.google.android.gms:play-services-ads@@23.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/ads/zzhbf;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/ads/zzhaa;

.field private static final zzd:Lcom/google/android/gms/internal/ads/zzhaa;

.field private static final zze:Lcom/google/android/gms/internal/ads/zzhdz;


# instance fields
.field private zzf:I

.field private zzg:I

.field private zzh:Z

.field private zzi:Ljava/lang/String;

.field private zzj:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzk:I

.field private zzl:Z

.field private zzm:Z

.field private zzn:Z

.field private zzo:Ljava/lang/String;

.field private zzp:I

.field private zzq:I

.field private zzr:I

.field private zzs:Z

.field private zzt:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzu:Z

.field private zzv:J

.field private zzw:Lcom/google/android/gms/internal/ads/zzgzz;

.field private zzx:Z

.field private zzy:Lcom/google/android/gms/internal/ads/zzgzz;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzhdq;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhdq;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzhdz;->zzb:Lcom/google/android/gms/internal/ads/zzhaa;

    new-instance v0, Lcom/google/android/gms/internal/ads/zzhdr;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhdr;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzhdz;->zzd:Lcom/google/android/gms/internal/ads/zzhaa;

    new-instance v0, Lcom/google/android/gms/internal/ads/zzhdz;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhdz;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzhdz;->zze:Lcom/google/android/gms/internal/ads/zzhdz;

    const-class v1, Lcom/google/android/gms/internal/ads/zzhdz;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaU(Ljava/lang/Class;Lcom/google/android/gms/internal/ads/zzgzu;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/ads/zzgzu;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzi:Ljava/lang/String;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzj:Lcom/google/android/gms/internal/ads/zzhad;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzo:Ljava/lang/String;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhdz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzt:Lcom/google/android/gms/internal/ads/zzhad;

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhdz;->zzaJ()Lcom/google/android/gms/internal/ads/zzgzz;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzw:Lcom/google/android/gms/internal/ads/zzgzz;

    .line 5
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhdz;->zzaJ()Lcom/google/android/gms/internal/ads/zzgzz;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhdz;->zzy:Lcom/google/android/gms/internal/ads/zzgzz;

    return-void
.end method

.method static synthetic zza()Lcom/google/android/gms/internal/ads/zzhdz;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzhdz;->zze:Lcom/google/android/gms/internal/ads/zzhdz;

    return-object v0
.end method


# virtual methods
.method protected final zzb(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 26

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
    sget-object v0, Lcom/google/android/gms/internal/ads/zzhdz;->zze:Lcom/google/android/gms/internal/ads/zzhdz;

    return-object v0

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzhds;

    .line 3
    invoke-direct {v0, v2}, Lcom/google/android/gms/internal/ads/zzhds;-><init>(Lcom/google/android/gms/internal/ads/zzhdp;)V

    return-object v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/ads/zzhdz;

    .line 4
    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhdz;-><init>()V

    return-object v0

    .line 2
    :cond_3
    sget-object v3, Lcom/google/android/gms/internal/ads/zzhdy;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    sget-object v8, Lcom/google/android/gms/internal/ads/zzhdw;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-class v18, Lcom/google/android/gms/internal/ads/zzhdv;

    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhdj;->zza()Lcom/google/android/gms/internal/ads/zzgzy;

    move-result-object v22

    const-string v24, "zzy"

    sget-object v25, Lcom/google/android/gms/internal/ads/zzhdx;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-string v1, "zzf"

    const-string v2, "zzg"

    const-string v4, "zzh"

    const-string v5, "zzi"

    const-string v6, "zzj"

    const-string v7, "zzk"

    const-string v9, "zzl"

    const-string v10, "zzm"

    const-string v11, "zzn"

    const-string v12, "zzo"

    const-string v13, "zzp"

    const-string v14, "zzq"

    const-string v15, "zzr"

    const-string v16, "zzs"

    const-string v17, "zzt"

    const-string v19, "zzu"

    const-string v20, "zzv"

    const-string v21, "zzw"

    const-string v23, "zzx"

    filled-new-array/range {v1 .. v25}, [Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/ads/zzhdz;->zze:Lcom/google/android/gms/internal/ads/zzhdz;

    const-string v2, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001\u180c\u0000\u0002\u1007\u0001\u0003\u1008\u0002\u0004\u001a\u0005\u180c\u0003\u0006\u1007\u0004\u0007\u1007\u0005\u0008\u1007\u0006\t\u1008\u0007\n\u1004\u0008\u000b\u1004\t\u000c\u1004\n\r\u1007\u000b\u000e\u001b\u000f\u1007\u000c\u0010\u1002\r\u0011\u082c\u0012\u1007\u000e\u0013\u082c"

    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/ads/zzhdz;->zzaR(Lcom/google/android/gms/internal/ads/zzhbe;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_4
    const/4 v0, 0x1

    .line 1
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method
