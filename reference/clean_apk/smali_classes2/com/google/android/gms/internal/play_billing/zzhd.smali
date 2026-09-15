.class final Lcom/google/android/gms/internal/play_billing/zzhd;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static final zza:Lcom/google/android/gms/internal/play_billing/zzhk;


# instance fields
.field private final zzb:Lcom/google/android/gms/internal/play_billing/zzhk;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzhb;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzhd;->zza:Lcom/google/android/gms/internal/play_billing/zzhk;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhc;

    const/4 v1, 0x2

    new-array v1, v1, [Lcom/google/android/gms/internal/play_billing/zzhk;

    const/4 v2, 0x0

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgb;->zza()Lcom/google/android/gms/internal/play_billing/zzgb;

    move-result-object v3

    aput-object v3, v1, v2

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzhd;->zza:Lcom/google/android/gms/internal/play_billing/zzhk;

    sget v3, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    const/4 v3, 0x1

    aput-object v2, v1, v3

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhc;-><init>([Lcom/google/android/gms/internal/play_billing/zzhk;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhk;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhd;->zzb:Lcom/google/android/gms/internal/play_billing/zzhk;

    return-void
.end method


# virtual methods
.method public final zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;
    .locals 8

    .line 1
    sget v0, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    const-class v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    sget v0, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhd;->zzb:Lcom/google/android/gms/internal/play_billing/zzhk;

    .line 3
    invoke-interface {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzhk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhj;

    move-result-object v2

    .line 4
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzhj;->zzb()Z

    move-result v0

    if-nez v0, :cond_2

    .line 5
    sget v0, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    .line 6
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhs;->zza()Lcom/google/android/gms/internal/play_billing/zzhr;

    move-result-object v3

    .line 7
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgw;->zza()Lcom/google/android/gms/internal/play_billing/zzgv;

    move-result-object v4

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzm()Lcom/google/android/gms/internal/play_billing/zzil;

    move-result-object v5

    .line 8
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzhj;->zzc()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzfw;->zza()Lcom/google/android/gms/internal/play_billing/zzfu;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    move-object v6, v0

    .line 10
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhi;->zza()Lcom/google/android/gms/internal/play_billing/zzhh;

    move-result-object v7

    move-object v1, p1

    .line 11
    invoke-static/range {v1 .. v7}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzhj;Lcom/google/android/gms/internal/play_billing/zzhr;Lcom/google/android/gms/internal/play_billing/zzgv;Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhh;)Lcom/google/android/gms/internal/play_billing/zzhp;

    move-result-object p1

    return-object p1

    .line 12
    :cond_2
    sget p1, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzm()Lcom/google/android/gms/internal/play_billing/zzil;

    move-result-object p1

    .line 13
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzfw;->zza()Lcom/google/android/gms/internal/play_billing/zzfu;

    move-result-object v0

    .line 14
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzhj;->zza()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc(Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhm;)Lcom/google/android/gms/internal/play_billing/zzhq;

    move-result-object p1

    return-object p1
.end method
