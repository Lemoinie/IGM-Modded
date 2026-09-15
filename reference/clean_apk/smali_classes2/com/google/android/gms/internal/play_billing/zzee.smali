.class public final Lcom/google/android/gms/internal/play_billing/zzee;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzee;


# instance fields
.field private zzd:Lcom/google/android/gms/internal/play_billing/zzgl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzee;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzee;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:Lcom/google/android/gms/internal/play_billing/zzee;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzee;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzee;->zzv()Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Lcom/google/android/gms/internal/play_billing/zzgl;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzed;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:Lcom/google/android/gms/internal/play_billing/zzee;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzed;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzee;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:Lcom/google/android/gms/internal/play_billing/zzee;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzee;Ljava/lang/Iterable;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Lcom/google/android/gms/internal/play_billing/zzgl;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->size()I

    move-result v1

    add-int/2addr v1, v1

    .line 3
    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Lcom/google/android/gms/internal/play_billing/zzgl;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 4
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzer;->zzk(Ljava/lang/Iterable;Ljava/util/List;)V

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
    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:Lcom/google/android/gms/internal/play_billing/zzee;

    return-object p1

    .line 5
    :cond_0
    throw p3

    .line 2
    :cond_1
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzed;

    .line 3
    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzed;-><init>(Lcom/google/android/gms/internal/play_billing/zzef;)V

    return-object p1

    :cond_2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzee;

    .line 4
    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzee;-><init>()V

    return-object p1

    .line 1
    :cond_3
    const-string p1, "zzd"

    const-class p2, Lcom/google/android/gms/internal/play_billing/zzec;

    filled-new-array {p1, p2}, [Ljava/lang/Object;

    move-result-object p1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:Lcom/google/android/gms/internal/play_billing/zzee;

    const-string p3, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"

    .line 2
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x1

    .line 1
    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method
