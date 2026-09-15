.class public final Lcom/google/android/gms/internal/play_billing/zzli;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzli;


# instance fields
.field private zzd:I

.field private zze:I

.field private zzf:Z

.field private zzg:J

.field private zzh:Z

.field private zzi:I

.field private zzj:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzli;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzli;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzli;->zzb:Lcom/google/android/gms/internal/play_billing/zzli;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzli;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzlg;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzli;->zzb:Lcom/google/android/gms/internal/play_billing/zzli;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzlg;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzli;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzli;->zzb:Lcom/google/android/gms/internal/play_billing/zzli;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzli;Z)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzh:Z

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/play_billing/zzli;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzi:I

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/play_billing/zzli;J)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    iput-wide p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzg:J

    return-void
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/play_billing/zzli;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzj:I

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/play_billing/zzli;Z)V
    .locals 0

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    or-int/lit8 p1, p1, 0x2

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzd:I

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzli;->zzf:Z

    return-void
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzli;->zzb:Lcom/google/android/gms/internal/play_billing/zzli;

    return-object p1

    .line 4
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzlg;-><init>(Lcom/google/android/gms/internal/play_billing/zzlh;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzli;

    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzli;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-string v5, "zzi"

    const-string v6, "zzj"

    const-string v0, "zzd"

    const-string v1, "zze"

    const-string v2, "zzf"

    const-string v3, "zzg"

    const-string v4, "zzh"

    filled-new-array/range {v0 .. v6}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzli;->zzb:Lcom/google/android/gms/internal/play_billing/zzli;

    const-string p3, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1007\u0001\u0003\u1002\u0002\u0004\u1007\u0003\u0005\u1004\u0004\u0006\u1004\u0005"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzli;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
