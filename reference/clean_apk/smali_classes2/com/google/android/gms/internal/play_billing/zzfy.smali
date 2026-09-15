.class final Lcom/google/android/gms/internal/play_billing/zzfy;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static final zzd:Lcom/google/android/gms/internal/play_billing/zzfy;


# instance fields
.field final zza:Lcom/google/android/gms/internal/play_billing/zzid;

.field zzb:Z

.field zzc:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzfy;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzfy;-><init>(Z)V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzd:Lcom/google/android/gms/internal/play_billing/zzfy;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzhy;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    return-void
.end method

.method private constructor <init>(Z)V
    .locals 0

    .line 2
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzhy;

    invoke-direct {p1}, Lcom/google/android/gms/internal/play_billing/zzhy;-><init>()V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzg()V

    .line 4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzg()V

    return-void
.end method

.method static zza(Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)I
    .locals 1

    shl-int/lit8 p1, p1, 0x3

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    .line 2
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjb;->zzj:Lcom/google/android/gms/internal/play_billing/zzjb;

    if-ne p0, v0, :cond_0

    add-int/2addr p1, p1

    .line 3
    :cond_0
    invoke-static {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)I

    move-result p0

    add-int/2addr p1, p0

    return p1
.end method

.method static zzb(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)I
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjb;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjc;->zza:Lcom/google/android/gms/internal/play_billing/zzjc;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzjb;->ordinal()I

    move-result p0

    const/4 v0, 0x4

    const/16 v1, 0x8

    packed-switch p0, :pswitch_data_0

    .line 37
    new-instance p0, Ljava/lang/RuntimeException;

    const-string p1, "There is no way to get here, but the compiler thinks otherwise."

    .line 39
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 6
    :pswitch_0
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    add-long v0, p0, p0

    const/16 v2, 0x3f

    shr-long/2addr p0, v2

    xor-long/2addr p0, v0

    .line 7
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 8
    :pswitch_1
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p0

    add-int p1, p0, p0

    shr-int/lit8 p0, p0, 0x1f

    xor-int/2addr p0, p1

    .line 9
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p0

    return p0

    .line 10
    :pswitch_2
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v1

    .line 11
    :pswitch_3
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v0

    .line 1
    :pswitch_4
    instance-of p0, p1, Lcom/google/android/gms/internal/play_billing/zzgi;

    if-eqz p0, :cond_0

    .line 2
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgi;

    invoke-interface {p1}, Lcom/google/android/gms/internal/play_billing/zzgi;->zza()I

    move-result p0

    int-to-long p0, p0

    .line 3
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 4
    :cond_0
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p0

    int-to-long p0, p0

    .line 5
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 12
    :pswitch_5
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p0

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p0

    return p0

    .line 27
    :pswitch_6
    instance-of p0, p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz p0, :cond_1

    .line 13
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    .line 14
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result p0

    .line 15
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    :goto_0
    add-int/2addr p1, p0

    return p1

    .line 16
    :cond_1
    check-cast p1, [B

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    .line 17
    array-length p0, p1

    .line 18
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    goto :goto_0

    .line 12
    :pswitch_7
    instance-of p0, p1, Lcom/google/android/gms/internal/play_billing/zzgq;

    if-eqz p0, :cond_2

    .line 26
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgq;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc()I

    move-result p0

    return p0

    .line 27
    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzx(Lcom/google/android/gms/internal/play_billing/zzhm;)I

    move-result p0

    return p0

    .line 28
    :pswitch_8
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-interface {p1}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzn()I

    move-result p0

    return p0

    .line 18
    :pswitch_9
    instance-of p0, p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz p0, :cond_3

    .line 19
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    .line 20
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result p0

    .line 21
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    goto :goto_0

    .line 22
    :cond_3
    check-cast p1, Ljava/lang/String;

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    .line 23
    sget p0, Lcom/google/android/gms/internal/play_billing/zzix;->zza:I

    .line 24
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzb(Ljava/lang/String;)I

    move-result p0

    .line 25
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    goto :goto_0

    .line 29
    :pswitch_a
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    const/4 p0, 0x1

    return p0

    .line 30
    :pswitch_b
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v0

    .line 31
    :pswitch_c
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v1

    .line 32
    :pswitch_d
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p0

    int-to-long p0, p0

    .line 33
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 34
    :pswitch_e
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 35
    :pswitch_f
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    .line 36
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result p0

    return p0

    .line 37
    :pswitch_10
    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v0

    .line 38
    :pswitch_11
    check-cast p1, Ljava/lang/Double;

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    sget p0, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    return v1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static zzc(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)I
    .locals 5

    .line 1
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzb()Lcom/google/android/gms/internal/play_billing/zzjb;

    move-result-object v0

    .line 2
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result v1

    .line 3
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zze()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 4
    check-cast p1, Ljava/util/List;

    .line 5
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .line 6
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzd()Z

    move-result p0

    const/4 v3, 0x0

    if-eqz p0, :cond_2

    .line 9
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result p0

    if-nez p0, :cond_1

    move p0, v3

    :goto_0
    if-ge v3, v2, :cond_0

    .line 10
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .line 11
    invoke-static {v0, v4}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzb(Lcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Object;)I

    move-result v4

    add-int/2addr p0, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    shl-int/lit8 p1, v1, 0x3

    .line 12
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    add-int/2addr p1, p0

    .line 13
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p0

    add-int/2addr p1, p0

    return p1

    :cond_1
    return v3

    :cond_2
    move p0, v3

    :goto_1
    if-ge v3, v2, :cond_3

    .line 7
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .line 8
    invoke-static {v0, v1, v4}, Lcom/google/android/gms/internal/play_billing/zzfy;->zza(Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)I

    move-result v4

    add-int/2addr p0, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    :cond_3
    return p0

    .line 14
    :cond_4
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zza(Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)I

    move-result p0

    return p0
.end method

.method public static zze()Lcom/google/android/gms/internal/play_billing/zzfy;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzd:Lcom/google/android/gms/internal/play_billing/zzfy;

    return-object v0
.end method

.method static zzi(Lcom/google/android/gms/internal/play_billing/zzfo;Lcom/google/android/gms/internal/play_billing/zzjb;ILjava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjb;->zzj:Lcom/google/android/gms/internal/play_billing/zzjb;

    if-eq p1, v0, :cond_3

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzjb;->zza()I

    move-result v0

    .line 3
    invoke-virtual {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzs(II)V

    .line 4
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzjc;->zza:Lcom/google/android/gms/internal/play_billing/zzjc;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzjb;->ordinal()I

    move-result p1

    packed-switch p1, :pswitch_data_0

    return-void

    .line 9
    :pswitch_0
    check-cast p3, Ljava/lang/Long;

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p1

    add-long v0, p1, p1

    const/16 p3, 0x3f

    shr-long/2addr p1, p3

    xor-long/2addr p1, v0

    .line 10
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzw(J)V

    return-void

    .line 11
    :pswitch_1
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    add-int p2, p1, p1

    shr-int/lit8 p1, p1, 0x1f

    xor-int/2addr p1, p2

    .line 12
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzu(I)V

    return-void

    .line 13
    :pswitch_2
    check-cast p3, Ljava/lang/Long;

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p1

    .line 14
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzk(J)V

    return-void

    .line 15
    :pswitch_3
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    .line 16
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzi(I)V

    return-void

    .line 4
    :pswitch_4
    instance-of p1, p3, Lcom/google/android/gms/internal/play_billing/zzgi;

    if-eqz p1, :cond_0

    .line 5
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzgi;

    invoke-interface {p3}, Lcom/google/android/gms/internal/play_billing/zzgi;->zza()I

    move-result p1

    .line 6
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzm(I)V

    return-void

    .line 7
    :cond_0
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    .line 8
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzm(I)V

    return-void

    .line 17
    :pswitch_5
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzu(I)V

    return-void

    .line 22
    :pswitch_6
    instance-of p1, p3, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz p1, :cond_1

    .line 18
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-virtual {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzg(Lcom/google/android/gms/internal/play_billing/zzfg;)V

    return-void

    .line 19
    :cond_1
    check-cast p3, [B

    .line 20
    array-length p1, p3

    const/4 p2, 0x0

    invoke-virtual {p0, p3, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zze([BII)V

    return-void

    .line 23
    :pswitch_7
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzn(Lcom/google/android/gms/internal/play_billing/zzhm;)V

    return-void

    .line 24
    :pswitch_8
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 25
    invoke-interface {p3, p0}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzD(Lcom/google/android/gms/internal/play_billing/zzfo;)V

    return-void

    .line 17
    :pswitch_9
    instance-of p1, p3, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz p1, :cond_2

    .line 21
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-virtual {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzg(Lcom/google/android/gms/internal/play_billing/zzfg;)V

    return-void

    .line 22
    :cond_2
    check-cast p3, Ljava/lang/String;

    invoke-virtual {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzr(Ljava/lang/String;)V

    return-void

    .line 26
    :pswitch_a
    check-cast p3, Ljava/lang/Boolean;

    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    .line 27
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb(B)V

    return-void

    .line 28
    :pswitch_b
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzi(I)V

    return-void

    .line 29
    :pswitch_c
    check-cast p3, Ljava/lang/Long;

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p1

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzk(J)V

    return-void

    .line 30
    :pswitch_d
    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzm(I)V

    return-void

    .line 31
    :pswitch_e
    check-cast p3, Ljava/lang/Long;

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p1

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzw(J)V

    return-void

    .line 32
    :pswitch_f
    check-cast p3, Ljava/lang/Long;

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide p1

    .line 33
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzw(J)V

    return-void

    .line 34
    :pswitch_10
    check-cast p3, Ljava/lang/Float;

    invoke-virtual {p3}, Ljava/lang/Float;->floatValue()F

    move-result p1

    .line 35
    invoke-static {p1}, Ljava/lang/Float;->floatToRawIntBits(F)I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzi(I)V

    return-void

    .line 36
    :pswitch_11
    check-cast p3, Ljava/lang/Double;

    invoke-virtual {p3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p1

    .line 37
    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToRawLongBits(D)J

    move-result-wide p1

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzk(J)V

    return-void

    .line 38
    :cond_3
    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzhm;

    const/4 p1, 0x3

    .line 39
    invoke-virtual {p0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzs(II)V

    .line 40
    invoke-interface {p3, p0}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzD(Lcom/google/android/gms/internal/play_billing/zzfo;)V

    const/4 p1, 0x4

    .line 41
    invoke-virtual {p0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzs(II)V

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static zzk(Ljava/util/Map$Entry;)Z
    .locals 4

    .line 1
    invoke-interface {p0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfx;

    .line 2
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzc()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object v1

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjc;->zzi:Lcom/google/android/gms/internal/play_billing/zzjc;

    if-ne v1, v2, :cond_2

    .line 3
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zze()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4
    invoke-interface {p0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/List;

    .line 5
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_2

    .line 6
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 7
    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzl(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 8
    :cond_1
    invoke-interface {p0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzl(Ljava/lang/Object;)Z

    move-result p0

    return p0

    :cond_2
    const/4 p0, 0x1

    return p0
.end method

.method private static zzl(Ljava/lang/Object;)Z
    .locals 1

    .line 1
    instance-of v0, p0, Lcom/google/android/gms/internal/play_billing/zzhn;

    if-eqz v0, :cond_0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzhn;

    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzo()Z

    move-result p0

    return p0

    :cond_0
    instance-of p0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;

    if-eqz p0, :cond_1

    const/4 p0, 0x1

    return p0

    :cond_1
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "Wrong object type used with protocol message reflection."

    .line 2
    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static final zzm(Ljava/util/Map$Entry;)I
    .locals 4

    .line 1
    invoke-interface {p0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfx;

    .line 2
    invoke-interface {p0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    .line 3
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzc()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjc;->zzi:Lcom/google/android/gms/internal/play_billing/zzjc;

    if-ne v2, v3, :cond_1

    .line 4
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zze()Z

    move-result v2

    if-nez v2, :cond_1

    .line 5
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzd()Z

    move-result v2

    if-nez v2, :cond_1

    instance-of v0, v1, Lcom/google/android/gms/internal/play_billing/zzgq;

    if-eqz v0, :cond_0

    .line 6
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgq;

    .line 7
    invoke-interface {p0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result p0

    invoke-virtual {v1, p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zza(I)I

    move-result p0

    return p0

    .line 8
    :cond_0
    invoke-interface {p0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result p0

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhm;

    const/16 v0, 0x8

    .line 9
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    add-int/2addr v0, v0

    const/16 v2, 0x10

    .line 10
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    .line 11
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p0

    add-int/2addr v2, p0

    const/16 p0, 0x18

    .line 12
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p0

    .line 13
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzx(Lcom/google/android/gms/internal/play_billing/zzhm;)I

    move-result v1

    add-int/2addr p0, v1

    add-int/2addr v0, v2

    add-int/2addr v0, p0

    return v0

    .line 14
    :cond_1
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method private static final zzn(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V
    .locals 2

    .line 1
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzb()Lcom/google/android/gms/internal/play_billing/zzjb;

    move-result-object v0

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 3
    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjb;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjc;->zza:Lcom/google/android/gms/internal/play_billing/zzjc;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzjb;->zzb()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzjc;->ordinal()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_2

    .line 4
    :pswitch_0
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzhm;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzgq;

    if-eqz v0, :cond_1

    goto :goto_1

    :pswitch_1
    instance-of v0, p1, Ljava/lang/Integer;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzgi;

    if-eqz v0, :cond_1

    goto :goto_1

    .line 6
    :pswitch_2
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-nez v0, :cond_0

    .line 5
    instance-of v0, p1, [B

    if-eqz v0, :cond_1

    goto :goto_1

    .line 6
    :pswitch_3
    instance-of v0, p1, Ljava/lang/String;

    goto :goto_0

    .line 7
    :pswitch_4
    instance-of v0, p1, Ljava/lang/Boolean;

    goto :goto_0

    .line 8
    :pswitch_5
    instance-of v0, p1, Ljava/lang/Double;

    goto :goto_0

    .line 9
    :pswitch_6
    instance-of v0, p1, Ljava/lang/Float;

    goto :goto_0

    .line 10
    :pswitch_7
    instance-of v0, p1, Ljava/lang/Long;

    goto :goto_0

    .line 11
    :pswitch_8
    instance-of v0, p1, Ljava/lang/Integer;

    :goto_0
    if-eqz v0, :cond_1

    :cond_0
    :goto_1
    return-void

    .line 3
    :cond_1
    :goto_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 12
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 13
    invoke-interface {p0}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzb()Lcom/google/android/gms/internal/play_billing/zzjb;

    move-result-object p0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzjb;->zzb()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object p0

    .line 14
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p1

    filled-new-array {v1, p0, p1}, [Ljava/lang/Object;

    move-result-object p0

    const-string p1, "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"

    .line 15
    invoke-static {p1, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public final bridge synthetic clone()Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzfy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzfy;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzid;->zzc()I

    move-result v2

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v2, :cond_0

    .line 2
    invoke-virtual {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzid;->zzg(I)Ljava/util/Map$Entry;

    move-result-object v4

    move-object v5, v4

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzhz;

    .line 3
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzhz;->zza()Ljava/lang/Comparable;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v5, v4}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzh(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 4
    :cond_0
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzid;->zzd()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 5
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzh(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V

    goto :goto_1

    :cond_1
    iget-boolean v1, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc:Z

    iput-boolean v1, v0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc:Z

    return-object v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 1

    if-ne p0, p1, :cond_0

    const/4 p1, 0x1

    return p1

    .line 1
    :cond_0
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfy;

    if-nez v0, :cond_1

    const/4 p1, 0x0

    return p1

    :cond_1
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfy;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 2
    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzid;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final hashCode()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->hashCode()I

    move-result v0

    return v0
.end method

.method public final zzd()I
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzc()I

    move-result v1

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v2, v1, :cond_0

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzid;->zzg(I)Ljava/util/Map$Entry;

    move-result-object v4

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzm(Ljava/util/Map$Entry;)I

    move-result v4

    add-int/2addr v3, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 2
    :cond_0
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzd()Ljava/lang/Iterable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 3
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzm(Ljava/util/Map$Entry;)I

    move-result v1

    add-int/2addr v3, v1

    goto :goto_1

    :cond_1
    return v3
.end method

.method public final zzf()Ljava/util/Iterator;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2
    invoke-static {}, Ljava/util/Collections;->emptyIterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0

    :cond_0
    iget-boolean v1, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc:Z

    if-eqz v1, :cond_1

    new-instance v1, Lcom/google/android/gms/internal/play_billing/zzgo;

    .line 3
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgo;-><init>(Ljava/util/Iterator;)V

    return-object v1

    .line 4
    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public final zzg()V
    .locals 5

    .line 1
    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzb:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzc()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzid;->zzg(I)Ljava/util/Map$Entry;

    move-result-object v3

    .line 2
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    instance-of v4, v3, Lcom/google/android/gms/internal/play_billing/zzgg;

    if-eqz v4, :cond_1

    .line 3
    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzgg;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzz()V

    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 4
    :cond_2
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzd()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 5
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    instance-of v3, v2, Lcom/google/android/gms/internal/play_billing/zzgg;

    if-eqz v3, :cond_3

    .line 6
    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzgg;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzz()V

    goto :goto_1

    .line 7
    :cond_4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zza()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzb:Z

    return-void
.end method

.method public final zzh(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V
    .locals 4

    .line 1
    invoke-interface {p1}, Lcom/google/android/gms/internal/play_billing/zzfx;->zze()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2
    instance-of v0, p2, Ljava/util/List;

    if-eqz v0, :cond_1

    .line 4
    check-cast p2, Ljava/util/List;

    .line 5
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    new-instance v1, Ljava/util/ArrayList;

    .line 6
    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_0

    .line 7
    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 8
    invoke-static {p1, v3}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzn(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V

    .line 9
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    move-object p2, v1

    goto :goto_1

    .line 2
    :cond_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Wrong object type used with protocol message reflection."

    .line 3
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 10
    :cond_2
    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzn(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)V

    .line 9
    :goto_1
    instance-of v0, p2, Lcom/google/android/gms/internal/play_billing/zzgq;

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc:Z

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 11
    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzid;->zzf(Ljava/lang/Comparable;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public final zzj()Z
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzc()I

    move-result v1

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v1, :cond_1

    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzid;->zzg(I)Ljava/util/Map$Entry;

    move-result-object v4

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzk(Ljava/util/Map$Entry;)Z

    move-result v4

    if-nez v4, :cond_0

    return v2

    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 2
    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzd()Ljava/lang/Iterable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 3
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzk(Ljava/util/Map$Entry;)Z

    move-result v1

    if-nez v1, :cond_2

    return v2

    :cond_3
    const/4 v0, 0x1

    return v0
.end method
