.class public final Lcom/google/android/gms/internal/play_billing/zzgz;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzgz;


# instance fields
.field private zzd:Lcom/google/android/gms/internal/play_billing/zzgl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgz;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzgz;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzgz;->zzb:Lcom/google/android/gms/internal/play_billing/zzgz;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzgz;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhu;->zze()Lcom/google/android/gms/internal/play_billing/zzhu;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgz;->zzd:Lcom/google/android/gms/internal/play_billing/zzgl;

    return-void
.end method

.method static bridge synthetic zza()Lcom/google/android/gms/internal/play_billing/zzgz;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzgz;->zzb:Lcom/google/android/gms/internal/play_billing/zzgz;

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzgz;->zzb:Lcom/google/android/gms/internal/play_billing/zzgz;

    return-object p1

    .line 5
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzgx;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzgx;-><init>(Lcom/google/android/gms/internal/play_billing/zzgy;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzgz;

    .line 4
    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzgz;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-string p1, "zzd"

    const-class p2, Lcom/google/android/gms/internal/play_billing/zzja;

    filled-new-array {p1, p2}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzgz;->zzb:Lcom/google/android/gms/internal/play_billing/zzgz;

    new-instance p3, Lcom/google/android/gms/internal/play_billing/zzhv;

    const-string v0, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"

    .line 2
    invoke-direct {p3, p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzhv;-><init>(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)V

    return-object p3

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
