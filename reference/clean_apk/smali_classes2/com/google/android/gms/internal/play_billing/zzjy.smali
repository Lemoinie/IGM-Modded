.class public final Lcom/google/android/gms/internal/play_billing/zzjy;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzjy;


# instance fields
.field private zzd:I

.field private zze:Ljava/lang/String;

.field private zzf:I

.field private zzg:Lcom/google/android/gms/internal/play_billing/zzgk;

.field private zzh:Lcom/google/android/gms/internal/play_billing/zzgl;

.field private zzi:Lcom/google/android/gms/internal/play_billing/zzjp;

.field private zzj:Z

.field private zzk:Z

.field private zzl:Lcom/google/android/gms/internal/play_billing/zzky;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzjy;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb:Lcom/google/android/gms/internal/play_billing/zzjy;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzjy;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zze:Ljava/lang/String;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzu()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzg:Lcom/google/android/gms/internal/play_billing/zzgk;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzv()Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzh:Lcom/google/android/gms/internal/play_billing/zzgl;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb:Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjv;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzjy;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb:Lcom/google/android/gms/internal/play_billing/zzjy;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzju;)V
    .locals 2

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzg:Lcom/google/android/gms/internal/play_billing/zzgk;

    .line 2
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 3
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->size()I

    move-result v1

    add-int/2addr v1, v1

    .line 4
    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzg(I)Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzg:Lcom/google/android/gms/internal/play_billing/zzgk;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzg:Lcom/google/android/gms/internal/play_billing/zzgk;

    .line 5
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzju;->zza()I

    move-result p1

    invoke-interface {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzh(I)V

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzjp;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzi:Lcom/google/android/gms/internal/play_billing/zzjp;

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    or-int/lit8 p1, p1, 0x4

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/play_billing/zzjy;Ljava/lang/String;)V
    .locals 0

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    or-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    const-string p1, "ProxyBillingBroadcastReceiver"

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zze:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzky;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzl:Lcom/google/android/gms/internal/play_billing/zzky;

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    or-int/lit8 p1, p1, 0x20

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/play_billing/zzjy;I)V
    .locals 0

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzf:I

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    or-int/lit8 p1, p1, 0x2

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzjy;->zzd:I

    return-void
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 12

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb:Lcom/google/android/gms/internal/play_billing/zzjy;

    return-object p1

    .line 5
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzjv;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzjv;-><init>(Lcom/google/android/gms/internal/play_billing/zzjx;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzjy;

    .line 4
    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzjy;-><init>()V

    return-object p1

    .line 1
    :cond_3
    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjw;->zza:Lcom/google/android/gms/internal/play_billing/zzgj;

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzjt;->zza:Lcom/google/android/gms/internal/play_billing/zzgj;

    const-class v7, Lcom/google/android/gms/internal/play_billing/zzku;

    const-string v10, "zzk"

    const-string v11, "zzl"

    const-string v0, "zzd"

    const-string v1, "zze"

    const-string v2, "zzf"

    const-string v4, "zzg"

    const-string v6, "zzh"

    const-string v8, "zzi"

    const-string v9, "zzj"

    filled-new-array/range {v0 .. v11}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb:Lcom/google/android/gms/internal/play_billing/zzjy;

    const-string p3, "\u0004\u0008\u0000\u0001\u0001\u0008\u0008\u0000\u0002\u0000\u0001\u1008\u0000\u0002\u180c\u0001\u0003\u082c\u0004\u001b\u0005\u1009\u0002\u0006\u1007\u0003\u0007\u1007\u0004\u0008\u1009\u0005"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
