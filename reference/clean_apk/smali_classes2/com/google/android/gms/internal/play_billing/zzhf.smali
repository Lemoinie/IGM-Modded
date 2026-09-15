.class public final Lcom/google/android/gms/internal/play_billing/zzhf;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zza:Lcom/google/android/gms/internal/play_billing/zzhe;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p2, Lcom/google/android/gms/internal/play_billing/zzhe;

    const-string v0, ""

    invoke-direct {p2, p1, v0, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzhe;-><init>(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)V

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzhf;->zza:Lcom/google/android/gms/internal/play_billing/zzhe;

    return-void
.end method

.method static zzb(Lcom/google/android/gms/internal/play_billing/zzhe;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhe;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc:Lcom/google/android/gms/internal/play_billing/zzjb;

    const/4 v1, 0x1

    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zza(Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)I

    move-result p1

    const/4 v0, 0x2

    .line 2
    invoke-static {p0, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zza(Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)I

    move-result p0

    add-int/2addr p1, p0

    return p1
.end method

.method public static zzd(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhf;
    .locals 1

    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzhf;

    const-string v0, ""

    invoke-direct {p1, p0, v0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhf;-><init>(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)V

    return-object p1
.end method

.method static zze(Lcom/google/android/gms/internal/play_billing/zzfo;Lcom/google/android/gms/internal/play_billing/zzhe;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    iget-object v0, p1, Lcom/google/android/gms/internal/play_billing/zzhe;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    const/4 v1, 0x1

    invoke-static {p0, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzi(Lcom/google/android/gms/internal/play_billing/zzfo;Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)V

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc:Lcom/google/android/gms/internal/play_billing/zzjb;

    const/4 p2, 0x2

    .line 2
    invoke-static {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzi(Lcom/google/android/gms/internal/play_billing/zzfo;Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final zza(ILjava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhf;->zza:Lcom/google/android/gms/internal/play_billing/zzhe;

    shl-int/lit8 p1, p1, 0x3

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    .line 2
    invoke-static {v0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzb(Lcom/google/android/gms/internal/play_billing/zzhe;Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p2

    .line 3
    invoke-static {p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p3

    add-int/2addr p3, p2

    add-int/2addr p1, p3

    return p1
.end method

.method final zzc()Lcom/google/android/gms/internal/play_billing/zzhe;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhf;->zza:Lcom/google/android/gms/internal/play_billing/zzhe;

    return-object v0
.end method
