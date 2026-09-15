.class public final Lcom/google/android/gms/internal/play_billing/zzku;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzku;


# instance fields
.field private zzd:I

.field private zze:Lcom/google/android/gms/internal/play_billing/zzgl;

.field private zzf:I

.field private zzg:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzku;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzku;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzku;->zzb:Lcom/google/android/gms/internal/play_billing/zzku;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzku;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzku;->zzv()Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzku;->zze:Lcom/google/android/gms/internal/play_billing/zzgl;

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzku;->zzg:Ljava/lang/String;

    return-void
.end method

.method static bridge synthetic zza()Lcom/google/android/gms/internal/play_billing/zzku;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzku;->zzb:Lcom/google/android/gms/internal/play_billing/zzku;

    return-object v0
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzku;->zzb:Lcom/google/android/gms/internal/play_billing/zzku;

    return-object p1

    .line 5
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzks;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzks;-><init>(Lcom/google/android/gms/internal/play_billing/zzkt;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzku;

    .line 4
    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzku;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-string p1, "zzf"

    const-string p2, "zzg"

    const-string p3, "zzd"

    const-string v0, "zze"

    filled-new-array {p3, v0, p1, p2}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzku;->zzb:Lcom/google/android/gms/internal/play_billing/zzku;

    const-string p3, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002\u1004\u0000\u0003\u1008\u0001"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzku;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
