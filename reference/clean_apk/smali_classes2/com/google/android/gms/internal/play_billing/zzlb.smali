.class public final Lcom/google/android/gms/internal/play_billing/zzlb;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzlb;


# instance fields
.field private zzd:I

.field private zze:Lcom/google/android/gms/internal/play_billing/zzjp;

.field private zzf:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzlb;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb:Lcom/google/android/gms/internal/play_billing/zzlb;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzkz;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb:Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzkz;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzlb;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb:Lcom/google/android/gms/internal/play_billing/zzlb;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzlb;Lcom/google/android/gms/internal/play_billing/zzjp;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zze:Lcom/google/android/gms/internal/play_billing/zzjp;

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzd:I

    or-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzd:I

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/play_billing/zzlb;J)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzd:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzd:I

    iput-wide p1, p0, Lcom/google/android/gms/internal/play_billing/zzlb;->zzf:J

    return-void
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb:Lcom/google/android/gms/internal/play_billing/zzlb;

    return-object p1

    .line 4
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzkz;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzkz;-><init>(Lcom/google/android/gms/internal/play_billing/zzla;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzlb;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-string p1, "zze"

    const-string p2, "zzf"

    const-string p3, "zzd"

    filled-new-array {p3, p1, p2}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb:Lcom/google/android/gms/internal/play_billing/zzlb;

    const-string p3, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1002\u0001"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzlb;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
