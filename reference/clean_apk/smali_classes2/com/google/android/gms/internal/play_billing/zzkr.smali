.class public final Lcom/google/android/gms/internal/play_billing/zzkr;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzkr;


# instance fields
.field private zzd:I

.field private zze:I

.field private zzf:Ljava/lang/Object;

.field private zzg:Lcom/google/android/gms/internal/play_billing/zzkb;

.field private zzh:Lcom/google/android/gms/internal/play_billing/zzke;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzkr;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzb:Lcom/google/android/gms/internal/play_billing/zzkr;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zzG(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzlb;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/16 p1, 0x8

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zzH(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzlf;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/4 p1, 0x4

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzkp;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzb:Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzkp;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzkr;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzb:Lcom/google/android/gms/internal/play_billing/zzkr;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzjg;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/4 p1, 0x2

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzjk;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/4 p1, 0x3

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzjs;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/4 p1, 0x7

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzjy;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzf:Ljava/lang/Object;

    const/4 p1, 0x5

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zze:I

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/play_billing/zzkr;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzg:Lcom/google/android/gms/internal/play_billing/zzkb;

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzd:I

    or-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkr;->zzd:I

    return-void
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 11

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

    if-ne p1, p2, :cond_0

    .line 1
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzkr;->zzb:Lcom/google/android/gms/internal/play_billing/zzkr;

    return-object p1

    .line 4
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzkp;-><init>(Lcom/google/android/gms/internal/play_billing/zzkq;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzkr;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-class v4, Lcom/google/android/gms/internal/play_billing/zzjg;

    const-class v5, Lcom/google/android/gms/internal/play_billing/zzjk;

    const-class v6, Lcom/google/android/gms/internal/play_billing/zzlf;

    const-class v7, Lcom/google/android/gms/internal/play_billing/zzjy;

    const-class v9, Lcom/google/android/gms/internal/play_billing/zzjs;

    const-class v10, Lcom/google/android/gms/internal/play_billing/zzlb;

    const-string v0, "zzf"

    const-string v1, "zze"

    const-string v2, "zzd"

    const-string v3, "zzg"

    const-string v8, "zzh"

    filled-new-array/range {v0 .. v10}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzkr;->zzb:Lcom/google/android/gms/internal/play_billing/zzkr;

    const-string p3, "\u0004\u0008\u0001\u0001\u0001\u0008\u0008\u0000\u0000\u0000\u0001\u1009\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006\u1009\u0001\u0007<\u0000\u0008<\u0000"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzkr;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
