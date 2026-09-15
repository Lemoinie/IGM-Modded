.class final Lcom/google/android/gms/internal/play_billing/zzhp;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhw;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/play_billing/zzhw<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final zza:[I

.field private static final zzb:Lsun/misc/Unsafe;


# instance fields
.field private final zzc:[I

.field private final zzd:[Ljava/lang/Object;

.field private final zze:I

.field private final zzf:I

.field private final zzg:Lcom/google/android/gms/internal/play_billing/zzhm;

.field private final zzh:Z

.field private final zzi:[I

.field private final zzj:I

.field private final zzk:I

.field private final zzl:Lcom/google/android/gms/internal/play_billing/zzil;

.field private final zzm:Lcom/google/android/gms/internal/play_billing/zzfu;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    .line 1
    new-array v0, v0, [I

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzhp;->zza:[I

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzis;->zzg()Lsun/misc/Unsafe;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    return-void
.end method

.method private constructor <init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/play_billing/zzhm;Z[IIILcom/google/android/gms/internal/play_billing/zzhr;Lcom/google/android/gms/internal/play_billing/zzgv;Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhh;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd:[Ljava/lang/Object;

    iput p3, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zze:I

    iput p4, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzf:I

    const/4 p1, 0x0

    if-eqz p13, :cond_0

    instance-of p2, p5, Lcom/google/android/gms/internal/play_billing/zzgd;

    if-eqz p2, :cond_0

    const/4 p1, 0x1

    :cond_0
    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    iput-object p7, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzi:[I

    iput p8, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzj:I

    iput p9, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzk:I

    iput-object p12, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl:Lcom/google/android/gms/internal/play_billing/zzil;

    iput-object p13, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm:Lcom/google/android/gms/internal/play_billing/zzfu;

    iput-object p5, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzg:Lcom/google/android/gms/internal/play_billing/zzhm;

    return-void
.end method

.method private final zzA(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 5

    .line 1
    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    .line 2
    :cond_0
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v0

    const v1, 0xfffff

    and-int/2addr v0, v1

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    int-to-long v2, v0

    .line 3
    invoke-virtual {v1, p2, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 6
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object p2

    .line 7
    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v4

    if-nez v4, :cond_2

    .line 8
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 9
    invoke-virtual {v1, p1, v2, v3, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_0

    .line 10
    :cond_1
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object v4

    .line 11
    invoke-interface {p2, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 12
    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 13
    :goto_0
    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    return-void

    .line 14
    :cond_2
    invoke-virtual {v1, p1, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    .line 15
    invoke-static {p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 16
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object v4

    .line 17
    invoke-interface {p2, v4, p3}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 18
    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v4

    .line 19
    :cond_3
    invoke-interface {p2, p3, v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    .line 3
    :cond_4
    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    new-instance v0, Ljava/lang/IllegalStateException;

    .line 4
    aget p1, p1, p3

    .line 5
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance p3, Ljava/lang/StringBuilder;

    const-string v1, "Source subfield "

    invoke-direct {p3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " is present but null: "

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final zzB(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 6

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    aget v1, v0, p3

    .line 2
    invoke-direct {p0, p2, v1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-nez v2, :cond_0

    return-void

    .line 3
    :cond_0
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    const v3, 0xfffff

    and-int/2addr v2, v3

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    int-to-long v4, v2

    .line 4
    invoke-virtual {v3, p2, v4, v5}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 7
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object p2

    .line 8
    invoke-direct {p0, p1, v1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-nez v0, :cond_2

    .line 9
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 10
    invoke-virtual {v3, p1, v4, v5, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_0

    .line 11
    :cond_1
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object v0

    .line 12
    invoke-interface {p2, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 13
    invoke-virtual {v3, p1, v4, v5, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 14
    :goto_0
    invoke-direct {p0, p1, v1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzD(Ljava/lang/Object;II)V

    return-void

    .line 15
    :cond_2
    invoke-virtual {v3, p1, v4, v5}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    .line 16
    invoke-static {p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 17
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object v0

    .line 18
    invoke-interface {p2, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 19
    invoke-virtual {v3, p1, v4, v5, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v0

    .line 20
    :cond_3
    invoke-interface {p2, p3, v2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    .line 4
    :cond_4
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 5
    aget p3, v0, p3

    .line 6
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Source subfield "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p3, " is present but null: "

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private final zzC(Ljava/lang/Object;I)V
    .locals 4

    .line 1
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzn(I)I

    move-result p2

    const v0, 0xfffff

    and-int/2addr v0, p2

    int-to-long v0, v0

    const-wide/32 v2, 0xfffff

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    return-void

    :cond_0
    ushr-int/lit8 p2, p2, 0x14

    .line 2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    const/4 v3, 0x1

    shl-int p2, v3, p2

    or-int/2addr p2, v2

    .line 3
    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzD(Ljava/lang/Object;II)V
    .locals 2

    .line 1
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzn(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzE(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 2
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    return-void
.end method

.method private final zzF(Ljava/lang/Object;IILjava/lang/Object;)V
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 2
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzD(Ljava/lang/Object;II)V

    return-void
.end method

.method private final zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result p1

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result p2

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private final zzH(Ljava/lang/Object;I)Z
    .locals 7

    .line 1
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzn(I)I

    move-result v0

    const v1, 0xfffff

    and-int v2, v0, v1

    int-to-long v2, v2

    const-wide/32 v4, 0xfffff

    cmp-long v4, v2, v4

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-nez v4, :cond_14

    .line 2
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result p2

    and-int v0, p2, v1

    invoke-static {p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result p2

    int-to-long v0, v0

    const-wide/16 v2, 0x0

    packed-switch p2, :pswitch_data_0

    .line 25
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzN()Z

    move-result p1

    return p1

    .line 3
    :pswitch_0
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    return v6

    :cond_0
    return v5

    .line 4
    :pswitch_1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_1

    return v6

    :cond_1
    return v5

    .line 5
    :pswitch_2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_2

    return v6

    :cond_2
    return v5

    .line 6
    :pswitch_3
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_3

    return v6

    :cond_3
    return v5

    .line 7
    :pswitch_4
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_4

    return v6

    :cond_4
    return v5

    .line 8
    :pswitch_5
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_5

    return v6

    :cond_5
    return v5

    .line 9
    :pswitch_6
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_6

    return v6

    :cond_6
    return v5

    .line 10
    :pswitch_7
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_7

    return v6

    :cond_7
    return v5

    .line 11
    :pswitch_8
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_8

    return v6

    :cond_8
    return v5

    .line 12
    :pswitch_9
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    .line 13
    instance-of p2, p1, Ljava/lang/String;

    if-eqz p2, :cond_a

    .line 14
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_9

    return v6

    :cond_9
    return v5

    :cond_a
    instance-of p2, p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz p2, :cond_c

    .line 15
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_b

    return v6

    :cond_b
    return v5

    .line 16
    :cond_c
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzN()Z

    move-result p1

    return p1

    .line 17
    :pswitch_a
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result p1

    return p1

    .line 18
    :pswitch_b
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_d

    return v6

    :cond_d
    return v5

    .line 19
    :pswitch_c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_e

    return v6

    :cond_e
    return v5

    .line 20
    :pswitch_d
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_f

    return v6

    :cond_f
    return v5

    .line 21
    :pswitch_e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_10

    return v6

    :cond_10
    return v5

    .line 22
    :pswitch_f
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_11

    return v6

    :cond_11
    return v5

    .line 23
    :pswitch_10
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->floatToRawIntBits(F)I

    move-result p1

    if-eqz p1, :cond_12

    return v6

    :cond_12
    return v5

    .line 24
    :pswitch_11
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToRawLongBits(D)J

    move-result-wide p1

    cmp-long p1, p1, v2

    if-eqz p1, :cond_13

    return v6

    :cond_13
    return v5

    :cond_14
    ushr-int/lit8 p2, v0, 0x14

    shl-int p2, v6, p2

    .line 26
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    and-int/2addr p1, p2

    if-eqz p1, :cond_15

    return v6

    :cond_15
    return v5

    nop

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

.method private final zzI(Ljava/lang/Object;IIII)Z
    .locals 1

    const v0, 0xfffff

    if-ne p3, v0, :cond_0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result p1

    return p1

    :cond_0
    and-int p1, p4, p5

    if-eqz p1, :cond_1

    const/4 p1, 0x1

    return p1

    :cond_1
    const/4 p1, 0x0

    return p1
.end method

.method private static zzJ(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzhw;)Z
    .locals 2

    const v0, 0xfffff

    and-int/2addr p1, v0

    int-to-long v0, p1

    .line 1
    invoke-static {p0, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    .line 2
    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzk(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static zzK(Ljava/lang/Object;)Z
    .locals 1

    if-nez p0, :cond_0

    const/4 p0, 0x0

    return p0

    .line 1
    :cond_0
    instance-of v0, p0, Lcom/google/android/gms/internal/play_billing/zzgg;

    if-eqz v0, :cond_1

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzgg;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzF()Z

    move-result p0

    return p0

    :cond_1
    const/4 p0, 0x1

    return p0
.end method

.method private final zzL(Ljava/lang/Object;Ljava/lang/Object;I)Z
    .locals 2

    .line 1
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzn(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    .line 2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    .line 3
    invoke-static {p2, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p2

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private final zzM(Ljava/lang/Object;II)Z
    .locals 2

    .line 1
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzn(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    .line 2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private zzN()Z
    .locals 1

    .line 1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method

.method private static final zzO([BIILcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzeu;)I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjb;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    invoke-virtual {p3}, Lcom/google/android/gms/internal/play_billing/zzjb;->ordinal()I

    move-result p3

    packed-switch p3, :pswitch_data_0

    .line 21
    :pswitch_0
    new-instance p0, Ljava/lang/RuntimeException;

    const-string p1, "unsupported field type."

    .line 22
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 3
    :pswitch_1
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 4
    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto/16 :goto_2

    .line 5
    :pswitch_2
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    iget p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 6
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto/16 :goto_2

    .line 19
    :pswitch_3
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zza([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    goto/16 :goto_2

    .line 7
    :pswitch_4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzht;->zza()Lcom/google/android/gms/internal/play_billing/zzht;

    move-result-object p3

    invoke-virtual {p3, p4}, Lcom/google/android/gms/internal/play_billing/zzht;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object p3

    .line 8
    invoke-static {p3, p0, p1, p2, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzd(Lcom/google/android/gms/internal/play_billing/zzhw;[BIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    goto/16 :goto_2

    .line 2
    :pswitch_5
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzg([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    goto/16 :goto_2

    .line 20
    :pswitch_6
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    const-wide/16 p3, 0x0

    cmp-long p1, p1, p3

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    .line 21
    :goto_0
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_2

    :pswitch_7
    add-int/lit8 p2, p1, 0x4

    .line 16
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result p0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_1

    :pswitch_8
    add-int/lit8 p2, p1, 0x8

    .line 15
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide p0

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_1

    .line 11
    :pswitch_9
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    iget p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 12
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_2

    .line 9
    :pswitch_a
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 10
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_2

    :pswitch_b
    add-int/lit8 p2, p1, 0x4

    .line 13
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result p0

    invoke-static {p0}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result p0

    .line 14
    invoke-static {p0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_1

    :pswitch_c
    add-int/lit8 p2, p1, 0x8

    .line 17
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide p0

    invoke-static {p0, p1}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide p0

    .line 18
    invoke-static {p0, p1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    :goto_1
    move p0, p2

    :goto_2
    return p0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_0
        :pswitch_4
        :pswitch_3
        :pswitch_9
        :pswitch_9
        :pswitch_7
        :pswitch_8
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static final zzP(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjd;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 2
    check-cast p1, Ljava/lang/String;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzH(ILjava/lang/String;)V

    return-void

    .line 3
    :cond_0
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzd(ILcom/google/android/gms/internal/play_billing/zzfg;)V

    return-void
.end method

.method static zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzim;
    .locals 2

    .line 1
    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzc()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzf()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v0

    .line 2
    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    :cond_0
    return-object v0
.end method

.method static zzl(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzhj;Lcom/google/android/gms/internal/play_billing/zzhr;Lcom/google/android/gms/internal/play_billing/zzgv;Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhh;)Lcom/google/android/gms/internal/play_billing/zzhp;
    .locals 33

    move-object/from16 v0, p1

    .line 1
    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzhv;

    if-eqz v1, :cond_36

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhv;

    .line 2
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzd()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x0

    .line 3
    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const v5, 0xd800

    if-lt v4, v5, :cond_0

    const/4 v4, 0x1

    :goto_0
    add-int/lit8 v7, v4, 0x1

    .line 4
    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_1

    move v4, v7

    goto :goto_0

    :cond_0
    const/4 v7, 0x1

    :cond_1
    add-int/lit8 v4, v7, 0x1

    .line 5
    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_3

    and-int/lit16 v7, v7, 0x1fff

    const/16 v9, 0xd

    :goto_1
    add-int/lit8 v10, v4, 0x1

    .line 6
    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_2

    and-int/lit16 v4, v4, 0x1fff

    shl-int/2addr v4, v9

    or-int/2addr v7, v4

    add-int/lit8 v9, v9, 0xd

    move v4, v10

    goto :goto_1

    :cond_2
    shl-int/2addr v4, v9

    or-int/2addr v7, v4

    move v4, v10

    :cond_3
    if-nez v7, :cond_4

    sget-object v7, Lcom/google/android/gms/internal/play_billing/zzhp;->zza:[I

    move v9, v3

    move v11, v9

    move v12, v11

    move v13, v12

    move v14, v13

    move/from16 v17, v14

    move-object/from16 v16, v7

    move/from16 v7, v17

    goto/16 :goto_a

    :cond_4
    add-int/lit8 v7, v4, 0x1

    .line 7
    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_6

    and-int/lit16 v4, v4, 0x1fff

    const/16 v9, 0xd

    :goto_2
    add-int/lit8 v10, v7, 0x1

    .line 8
    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_5

    and-int/lit16 v7, v7, 0x1fff

    shl-int/2addr v7, v9

    or-int/2addr v4, v7

    add-int/lit8 v9, v9, 0xd

    move v7, v10

    goto :goto_2

    :cond_5
    shl-int/2addr v7, v9

    or-int/2addr v4, v7

    move v7, v10

    :cond_6
    add-int/lit8 v9, v7, 0x1

    .line 9
    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_8

    and-int/lit16 v7, v7, 0x1fff

    const/16 v10, 0xd

    :goto_3
    add-int/lit8 v11, v9, 0x1

    .line 10
    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v5, :cond_7

    and-int/lit16 v9, v9, 0x1fff

    shl-int/2addr v9, v10

    or-int/2addr v7, v9

    add-int/lit8 v10, v10, 0xd

    move v9, v11

    goto :goto_3

    :cond_7
    shl-int/2addr v9, v10

    or-int/2addr v7, v9

    move v9, v11

    :cond_8
    add-int/lit8 v10, v9, 0x1

    .line 11
    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v5, :cond_a

    and-int/lit16 v9, v9, 0x1fff

    const/16 v11, 0xd

    :goto_4
    add-int/lit8 v12, v10, 0x1

    .line 12
    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v5, :cond_9

    and-int/lit16 v10, v10, 0x1fff

    shl-int/2addr v10, v11

    or-int/2addr v9, v10

    add-int/lit8 v11, v11, 0xd

    move v10, v12

    goto :goto_4

    :cond_9
    shl-int/2addr v10, v11

    or-int/2addr v9, v10

    move v10, v12

    :cond_a
    add-int/lit8 v11, v10, 0x1

    .line 13
    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v5, :cond_c

    and-int/lit16 v10, v10, 0x1fff

    const/16 v12, 0xd

    :goto_5
    add-int/lit8 v13, v11, 0x1

    .line 14
    invoke-virtual {v1, v11}, Ljava/lang/String;->charAt(I)C

    move-result v11

    if-lt v11, v5, :cond_b

    and-int/lit16 v11, v11, 0x1fff

    shl-int/2addr v11, v12

    or-int/2addr v10, v11

    add-int/lit8 v12, v12, 0xd

    move v11, v13

    goto :goto_5

    :cond_b
    shl-int/2addr v11, v12

    or-int/2addr v10, v11

    move v11, v13

    :cond_c
    add-int/lit8 v12, v11, 0x1

    .line 15
    invoke-virtual {v1, v11}, Ljava/lang/String;->charAt(I)C

    move-result v11

    if-lt v11, v5, :cond_e

    and-int/lit16 v11, v11, 0x1fff

    const/16 v13, 0xd

    :goto_6
    add-int/lit8 v14, v12, 0x1

    .line 16
    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v5, :cond_d

    and-int/lit16 v12, v12, 0x1fff

    shl-int/2addr v12, v13

    or-int/2addr v11, v12

    add-int/lit8 v13, v13, 0xd

    move v12, v14

    goto :goto_6

    :cond_d
    shl-int/2addr v12, v13

    or-int/2addr v11, v12

    move v12, v14

    :cond_e
    add-int/lit8 v13, v12, 0x1

    .line 17
    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v5, :cond_10

    and-int/lit16 v12, v12, 0x1fff

    const/16 v14, 0xd

    :goto_7
    add-int/lit8 v15, v13, 0x1

    .line 18
    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_f

    and-int/lit16 v13, v13, 0x1fff

    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    add-int/lit8 v14, v14, 0xd

    move v13, v15

    goto :goto_7

    :cond_f
    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    move v13, v15

    :cond_10
    add-int/lit8 v14, v13, 0x1

    .line 19
    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_12

    :goto_8
    add-int/lit8 v13, v14, 0x1

    .line 20
    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v5, :cond_11

    move v14, v13

    goto :goto_8

    :cond_11
    move v14, v13

    :cond_12
    add-int/lit8 v13, v14, 0x1

    .line 21
    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v5, :cond_14

    and-int/lit16 v14, v14, 0x1fff

    const/16 v15, 0xd

    :goto_9
    add-int/lit8 v16, v13, 0x1

    .line 22
    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_13

    and-int/lit16 v13, v13, 0x1fff

    shl-int/2addr v13, v15

    or-int/2addr v14, v13

    add-int/lit8 v15, v15, 0xd

    move/from16 v13, v16

    goto :goto_9

    :cond_13
    shl-int/2addr v13, v15

    or-int/2addr v14, v13

    move/from16 v13, v16

    :cond_14
    add-int v15, v14, v12

    add-int/2addr v15, v4

    add-int v16, v4, v4

    add-int v16, v16, v7

    .line 23
    new-array v7, v15, [I

    move/from16 v17, v14

    move v14, v10

    move-object/from16 v32, v7

    move v7, v4

    move v4, v13

    move v13, v9

    move/from16 v9, v16

    move-object/from16 v16, v32

    .line 6
    :goto_a
    sget-object v10, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    .line 24
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zze()[Ljava/lang/Object;

    move-result-object v15

    .line 25
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zza()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    add-int v18, v17, v12

    add-int v12, v11, v11

    mul-int/lit8 v11, v11, 0x3

    .line 26
    new-array v11, v11, [I

    .line 27
    new-array v12, v12, [Ljava/lang/Object;

    move/from16 v22, v17

    move/from16 v21, v18

    const/16 v19, 0x0

    const/16 v20, 0x0

    :goto_b
    if-ge v4, v2, :cond_35

    add-int/lit8 v23, v4, 0x1

    .line 28
    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_16

    and-int/lit16 v4, v4, 0x1fff

    move/from16 v8, v23

    const/16 v23, 0xd

    :goto_c
    add-int/lit8 v24, v8, 0x1

    .line 29
    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v5, :cond_15

    and-int/lit16 v8, v8, 0x1fff

    shl-int v8, v8, v23

    or-int/2addr v4, v8

    add-int/lit8 v23, v23, 0xd

    move/from16 v8, v24

    goto :goto_c

    :cond_15
    shl-int v8, v8, v23

    or-int/2addr v4, v8

    move/from16 v8, v24

    goto :goto_d

    :cond_16
    move/from16 v8, v23

    :goto_d
    add-int/lit8 v23, v8, 0x1

    .line 30
    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v5, :cond_18

    and-int/lit16 v8, v8, 0x1fff

    move/from16 v6, v23

    const/16 v23, 0xd

    :goto_e
    add-int/lit8 v25, v6, 0x1

    .line 31
    invoke-virtual {v1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-lt v6, v5, :cond_17

    and-int/lit16 v6, v6, 0x1fff

    shl-int v6, v6, v23

    or-int/2addr v8, v6

    add-int/lit8 v23, v23, 0xd

    move/from16 v6, v25

    goto :goto_e

    :cond_17
    shl-int v6, v6, v23

    or-int/2addr v8, v6

    move/from16 v6, v25

    goto :goto_f

    :cond_18
    move/from16 v6, v23

    :goto_f
    and-int/lit16 v5, v8, 0x400

    if-eqz v5, :cond_19

    add-int/lit8 v5, v19, 0x1

    .line 32
    aput v20, v16, v19

    move/from16 v19, v5

    :cond_19
    and-int/lit16 v5, v8, 0xff

    move/from16 v25, v2

    and-int/lit16 v2, v8, 0x800

    move/from16 v26, v14

    const/16 v14, 0x33

    if-lt v5, v14, :cond_23

    add-int/lit8 v14, v6, 0x1

    .line 33
    invoke-virtual {v1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    move/from16 v27, v14

    const v14, 0xd800

    if-lt v6, v14, :cond_1b

    and-int/lit16 v6, v6, 0x1fff

    move/from16 v14, v27

    const/16 v27, 0xd

    :goto_10
    add-int/lit8 v30, v14, 0x1

    .line 34
    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    move/from16 v31, v13

    const v13, 0xd800

    if-lt v14, v13, :cond_1a

    and-int/lit16 v13, v14, 0x1fff

    shl-int v13, v13, v27

    or-int/2addr v6, v13

    add-int/lit8 v27, v27, 0xd

    move/from16 v14, v30

    move/from16 v13, v31

    goto :goto_10

    :cond_1a
    shl-int v13, v14, v27

    or-int/2addr v6, v13

    move/from16 v14, v30

    goto :goto_11

    :cond_1b
    move/from16 v31, v13

    move/from16 v14, v27

    :goto_11
    add-int/lit8 v13, v5, -0x33

    move/from16 v27, v14

    const/16 v14, 0x9

    if-eq v13, v14, :cond_1f

    const/16 v14, 0x11

    if-ne v13, v14, :cond_1c

    goto :goto_13

    :cond_1c
    const/16 v14, 0xc

    if-ne v13, v14, :cond_20

    .line 36
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzc()I

    move-result v13

    const/4 v14, 0x1

    if-eq v13, v14, :cond_1e

    if-eqz v2, :cond_1d

    goto :goto_12

    :cond_1d
    const/4 v2, 0x0

    goto :goto_15

    :cond_1e
    :goto_12
    add-int/lit8 v13, v9, 0x1

    div-int/lit8 v24, v20, 0x3

    add-int v24, v24, v24

    add-int/lit8 v24, v24, 0x1

    .line 37
    aget-object v9, v15, v9

    aput-object v9, v12, v24

    goto :goto_14

    :cond_1f
    :goto_13
    const/4 v14, 0x1

    add-int/lit8 v13, v9, 0x1

    .line 34
    div-int/lit8 v24, v20, 0x3

    add-int v24, v24, v24

    add-int/lit8 v28, v24, 0x1

    .line 35
    aget-object v9, v15, v9

    aput-object v9, v12, v28

    :goto_14
    move v9, v13

    :cond_20
    :goto_15
    add-int/2addr v6, v6

    .line 38
    aget-object v13, v15, v6

    .line 39
    instance-of v14, v13, Ljava/lang/reflect/Field;

    if-eqz v14, :cond_21

    .line 40
    check-cast v13, Ljava/lang/reflect/Field;

    goto :goto_16

    .line 41
    :cond_21
    check-cast v13, Ljava/lang/String;

    invoke-static {v3, v13}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzy(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    .line 42
    aput-object v13, v15, v6

    add-int/lit8 v14, v21, 0x1

    .line 43
    aput v20, v16, v21

    move/from16 v21, v14

    .line 44
    :goto_16
    invoke-virtual {v10, v13}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v13, v13

    add-int/lit8 v6, v6, 0x1

    .line 45
    aget-object v14, v15, v6

    move/from16 v28, v2

    .line 46
    instance-of v2, v14, Ljava/lang/reflect/Field;

    if-eqz v2, :cond_22

    .line 47
    check-cast v14, Ljava/lang/reflect/Field;

    goto :goto_17

    .line 48
    :cond_22
    check-cast v14, Ljava/lang/String;

    invoke-static {v3, v14}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzy(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v14

    .line 49
    aput-object v14, v15, v6

    :goto_17
    move v2, v13

    .line 50
    invoke-virtual {v10, v14}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v6, v13

    move/from16 v29, v2

    move v13, v9

    move/from16 v2, v28

    move-object/from16 v28, v0

    move v9, v6

    move/from16 v6, v27

    const/4 v0, 0x0

    move/from16 v27, v4

    move-object v4, v1

    goto/16 :goto_21

    :cond_23
    move/from16 v31, v13

    add-int/lit8 v13, v9, 0x1

    .line 51
    aget-object v14, v15, v9

    check-cast v14, Ljava/lang/String;

    invoke-static {v3, v14}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzy(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v14

    move/from16 v27, v4

    const/16 v4, 0x9

    if-eq v5, v4, :cond_2d

    const/16 v4, 0x11

    if-ne v5, v4, :cond_24

    goto/16 :goto_1c

    :cond_24
    const/16 v4, 0x1b

    if-eq v5, v4, :cond_2c

    const/16 v4, 0x31

    if-ne v5, v4, :cond_25

    add-int/lit8 v9, v9, 0x2

    move-object/from16 v28, v0

    const/4 v0, 0x1

    goto :goto_1a

    :cond_25
    const/16 v4, 0xc

    if-eq v5, v4, :cond_29

    const/16 v4, 0x1e

    if-eq v5, v4, :cond_29

    const/16 v4, 0x2c

    if-ne v5, v4, :cond_26

    goto :goto_18

    :cond_26
    const/16 v4, 0x32

    if-ne v5, v4, :cond_28

    add-int/lit8 v4, v9, 0x2

    add-int/lit8 v28, v22, 0x1

    .line 56
    aput v20, v16, v22

    div-int/lit8 v22, v20, 0x3

    .line 57
    aget-object v13, v15, v13

    add-int v22, v22, v22

    aput-object v13, v12, v22

    if-eqz v2, :cond_27

    add-int/lit8 v22, v22, 0x1

    add-int/lit8 v13, v9, 0x3

    .line 58
    aget-object v4, v15, v4

    aput-object v4, v12, v22

    move-object v4, v1

    move/from16 v22, v28

    move-object/from16 v28, v0

    goto :goto_1e

    :cond_27
    move v13, v4

    move/from16 v22, v28

    const/4 v2, 0x0

    move-object/from16 v28, v0

    goto :goto_1d

    :cond_28
    move-object/from16 v28, v0

    const/4 v0, 0x1

    goto :goto_1d

    .line 54
    :cond_29
    :goto_18
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzc()I

    move-result v4

    move-object/from16 v28, v0

    const/4 v0, 0x1

    if-eq v4, v0, :cond_2b

    if-eqz v2, :cond_2a

    goto :goto_19

    :cond_2a
    move-object v4, v1

    const/4 v2, 0x0

    goto :goto_1e

    :cond_2b
    :goto_19
    add-int/lit8 v9, v9, 0x2

    div-int/lit8 v4, v20, 0x3

    add-int/2addr v4, v4

    add-int/2addr v4, v0

    .line 55
    aget-object v13, v15, v13

    aput-object v13, v12, v4

    goto :goto_1b

    :cond_2c
    move-object/from16 v28, v0

    const/4 v0, 0x1

    add-int/lit8 v9, v9, 0x2

    .line 66
    :goto_1a
    div-int/lit8 v4, v20, 0x3

    add-int/2addr v4, v4

    add-int/2addr v4, v0

    .line 53
    aget-object v13, v15, v13

    aput-object v13, v12, v4

    :goto_1b
    move-object v4, v1

    move v13, v9

    goto :goto_1e

    :cond_2d
    :goto_1c
    move-object/from16 v28, v0

    const/4 v0, 0x1

    .line 51
    div-int/lit8 v4, v20, 0x3

    add-int/2addr v4, v4

    add-int/2addr v4, v0

    .line 52
    invoke-virtual {v14}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v9

    aput-object v9, v12, v4

    :goto_1d
    move-object v4, v1

    .line 59
    :goto_1e
    invoke-virtual {v10, v14}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v0

    long-to-int v0, v0

    and-int/lit16 v1, v8, 0x1000

    const v9, 0xfffff

    if-eqz v1, :cond_31

    const/16 v1, 0x11

    if-gt v5, v1, :cond_31

    add-int/lit8 v1, v6, 0x1

    .line 60
    invoke-virtual {v4, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const v14, 0xd800

    if-lt v6, v14, :cond_2f

    and-int/lit16 v6, v6, 0x1fff

    const/16 v9, 0xd

    :goto_1f
    add-int/lit8 v23, v1, 0x1

    .line 61
    invoke-virtual {v4, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-lt v1, v14, :cond_2e

    and-int/lit16 v1, v1, 0x1fff

    shl-int/2addr v1, v9

    or-int/2addr v6, v1

    add-int/lit8 v9, v9, 0xd

    move/from16 v1, v23

    goto :goto_1f

    :cond_2e
    shl-int/2addr v1, v9

    or-int/2addr v6, v1

    move/from16 v1, v23

    :cond_2f
    add-int v9, v7, v7

    div-int/lit8 v23, v6, 0x20

    add-int v9, v9, v23

    .line 62
    aget-object v14, v15, v9

    move/from16 v29, v0

    .line 63
    instance-of v0, v14, Ljava/lang/reflect/Field;

    if-eqz v0, :cond_30

    .line 64
    check-cast v14, Ljava/lang/reflect/Field;

    goto :goto_20

    .line 65
    :cond_30
    check-cast v14, Ljava/lang/String;

    invoke-static {v3, v14}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzy(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v14

    .line 66
    aput-object v14, v15, v9

    :goto_20
    move v9, v1

    .line 67
    invoke-virtual {v10, v14}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v0

    long-to-int v0, v0

    rem-int/lit8 v6, v6, 0x20

    move/from16 v32, v9

    move v9, v0

    move v0, v6

    move/from16 v6, v32

    goto :goto_21

    :cond_31
    move/from16 v29, v0

    const/4 v0, 0x0

    :goto_21
    add-int/lit8 v1, v20, 0x1

    .line 68
    aput v27, v11, v20

    add-int/lit8 v14, v20, 0x2

    move-object/from16 v27, v3

    and-int/lit16 v3, v8, 0x200

    if-eqz v3, :cond_32

    const/high16 v3, 0x20000000

    goto :goto_22

    :cond_32
    const/4 v3, 0x0

    :goto_22
    and-int/lit16 v8, v8, 0x100

    if-eqz v8, :cond_33

    const/high16 v8, 0x10000000

    goto :goto_23

    :cond_33
    const/4 v8, 0x0

    :goto_23
    if-eqz v2, :cond_34

    const/high16 v2, -0x80000000

    goto :goto_24

    :cond_34
    const/4 v2, 0x0

    :goto_24
    shl-int/lit8 v5, v5, 0x14

    or-int/2addr v3, v8

    or-int/2addr v2, v3

    or-int/2addr v2, v5

    or-int v2, v2, v29

    .line 69
    aput v2, v11, v1

    add-int/lit8 v20, v20, 0x3

    shl-int/lit8 v0, v0, 0x14

    or-int/2addr v0, v9

    .line 70
    aput v0, v11, v14

    move-object v1, v4

    move v4, v6

    move v9, v13

    move/from16 v2, v25

    move/from16 v14, v26

    move-object/from16 v3, v27

    move-object/from16 v0, v28

    move/from16 v13, v31

    const v5, 0xd800

    goto/16 :goto_b

    :cond_35
    move-object/from16 v28, v0

    move/from16 v31, v13

    move/from16 v26, v14

    .line 58
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhp;

    .line 71
    invoke-virtual/range {v28 .. v28}, Lcom/google/android/gms/internal/play_billing/zzhv;->zza()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v14

    const/4 v15, 0x0

    move-object v9, v0

    move-object v10, v11

    move-object v11, v12

    move/from16 v12, v31

    move/from16 v13, v26

    move-object/from16 v19, p2

    move-object/from16 v20, p3

    move-object/from16 v21, p4

    move-object/from16 v22, p5

    move-object/from16 v23, p6

    invoke-direct/range {v9 .. v23}, Lcom/google/android/gms/internal/play_billing/zzhp;-><init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/play_billing/zzhm;Z[IIILcom/google/android/gms/internal/play_billing/zzhr;Lcom/google/android/gms/internal/play_billing/zzgv;Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhh;)V

    return-object v0

    .line 72
    :cond_36
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzii;

    const/4 v0, 0x0

    .line 73
    throw v0
.end method

.method private static zzm(Ljava/lang/Object;J)I
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Integer;

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    return p0
.end method

.method private final zzn(I)I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    add-int/lit8 p1, p1, 0x2

    aget p1, v0, p1

    return p1
.end method

.method private final zzo(II)I
    .locals 6

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    array-length v1, v0

    div-int/lit8 v1, v1, 0x3

    const/4 v2, -0x1

    add-int/2addr v1, v2

    :goto_0
    if-gt p2, v1, :cond_2

    add-int v3, v1, p2

    ushr-int/lit8 v3, v3, 0x1

    mul-int/lit8 v4, v3, 0x3

    aget v5, v0, v4

    if-ne p1, v5, :cond_0

    return v4

    :cond_0
    if-ge p1, v5, :cond_1

    add-int/lit8 v1, v3, -0x1

    goto :goto_0

    :cond_1
    add-int/lit8 p2, v3, 0x1

    goto :goto_0

    :cond_2
    return v2
.end method

.method private static zzp(I)I
    .locals 0

    ushr-int/lit8 p0, p0, 0x14

    and-int/lit16 p0, p0, 0xff

    return p0
.end method

.method private final zzq(I)I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    add-int/lit8 p1, p1, 0x1

    aget p1, v0, p1

    return p1
.end method

.method private static zzr(Ljava/lang/Object;J)J
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    return-wide p0
.end method

.method private final zzs(I)Lcom/google/android/gms/internal/play_billing/zzgj;
    .locals 1

    .line 1
    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd:[Ljava/lang/Object;

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgj;

    return-object p1
.end method

.method private final zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd:[Ljava/lang/Object;

    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    aget-object v1, v0, p1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhw;

    if-eqz v1, :cond_0

    return-object v1

    :cond_0
    add-int/lit8 v1, p1, 0x1

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzht;->zza()Lcom/google/android/gms/internal/play_billing/zzht;

    move-result-object v2

    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/Class;

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzht;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 3
    aput-object v1, v0, p1

    return-object v1
.end method

.method private final zzu(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzil;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    aget v0, v0, p2

    .line 2
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    .line 3
    invoke-static {p1, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-nez p1, :cond_0

    return-object p3

    .line 4
    :cond_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzs(I)Lcom/google/android/gms/internal/play_billing/zzgj;

    move-result-object v1

    if-nez v1, :cond_1

    return-object p3

    .line 5
    :cond_1
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhg;

    .line 6
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzv(I)Ljava/lang/Object;

    move-result-object p2

    .line 7
    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzhf;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object p2

    .line 8
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_2
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 9
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 10
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-interface {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzgj;->zza(I)Z

    move-result v3

    if-nez v3, :cond_2

    if-nez p3, :cond_3

    .line 11
    invoke-virtual {p4, p5}, Lcom/google/android/gms/internal/play_billing/zzil;->zza(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    .line 12
    :cond_3
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzb(Lcom/google/android/gms/internal/play_billing/zzhe;Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v3

    .line 13
    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 14
    new-array v4, v3, [B

    .line 15
    sget v5, Lcom/google/android/gms/internal/play_billing/zzfo;->zzb:I

    .line 16
    new-instance v5, Lcom/google/android/gms/internal/play_billing/zzfl;

    const/4 v6, 0x0

    invoke-direct {v5, v4, v6, v3}, Lcom/google/android/gms/internal/play_billing/zzfl;-><init>([BII)V

    .line 17
    :try_start_0
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v5, p2, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzhf;->zze(Lcom/google/android/gms/internal/play_billing/zzfo;Lcom/google/android/gms/internal/play_billing/zzhe;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 18
    invoke-static {v5, v4}, Lcom/google/android/gms/internal/play_billing/zzfc;->zza(Lcom/google/android/gms/internal/play_billing/zzfo;[B)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v2

    shl-int/lit8 v3, v0, 0x3

    .line 19
    move-object v4, p3

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzim;

    or-int/lit8 v3, v3, 0x2

    .line 20
    invoke-virtual {v4, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzim;->zzj(ILjava/lang/Object;)V

    .line 21
    invoke-interface {p1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    :catch_0
    move-exception p1

    new-instance p2, Ljava/lang/RuntimeException;

    .line 22
    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :cond_4
    return-object p3
.end method

.method private final zzv(I)Ljava/lang/Object;
    .locals 1

    .line 1
    div-int/lit8 p1, p1, 0x3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd:[Ljava/lang/Object;

    add-int/2addr p1, p1

    aget-object p1, v0, p1

    return-object p1
.end method

.method private final zzw(Ljava/lang/Object;I)Ljava/lang/Object;
    .locals 3

    .line 1
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v0

    .line 2
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    .line 3
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result p2

    if-nez p2, :cond_0

    .line 4
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_0
    int-to-long v1, v1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    .line 5
    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    .line 6
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_1

    return-object p1

    .line 7
    :cond_1
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2

    .line 8
    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2
    return-object p2
.end method

.method private final zzx(Ljava/lang/Object;II)Ljava/lang/Object;
    .locals 3

    .line 1
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v0

    .line 2
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result p2

    if-nez p2, :cond_0

    .line 3
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_0
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    .line 4
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result p3

    const v1, 0xfffff

    and-int/2addr p3, v1

    int-to-long v1, p3

    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    .line 5
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_1

    return-object p1

    .line 6
    :cond_1
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhw;->zze()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2

    .line 7
    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2
    return-object p2
.end method

.method private static zzy(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 6

    .line 1
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception v0

    .line 2
    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    .line 3
    array-length v2, v1

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v2, :cond_1

    aget-object v4, v1, v3

    .line 4
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    return-object v4

    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_1
    new-instance v2, Ljava/lang/RuntimeException;

    .line 5
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    .line 6
    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Field "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " for "

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, " not found. Known fields are "

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v2, p0, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method private static zzz(Ljava/lang/Object;)V
    .locals 2

    .line 1
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 2
    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    const-string v1, "Mutating immutable message: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;)I
    .locals 19

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    .line 1
    sget-object v8, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    const/4 v9, 0x0

    const v10, 0xfffff

    move v1, v9

    move v11, v1

    move v12, v11

    move v0, v10

    :goto_0
    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    array-length v3, v2

    if-ge v11, v3, :cond_1b

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v4

    .line 2
    aget v13, v2, v11

    add-int/lit8 v5, v11, 0x2

    .line 3
    aget v2, v2, v5

    and-int v5, v2, v10

    const/16 v14, 0x11

    const/4 v15, 0x1

    if-gt v4, v14, :cond_2

    if-eq v5, v0, :cond_1

    if-ne v5, v10, :cond_0

    move v0, v9

    goto :goto_1

    :cond_0
    int-to-long v0, v5

    .line 4
    invoke-virtual {v8, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_1
    move v1, v0

    move v0, v5

    :cond_1
    ushr-int/lit8 v2, v2, 0x14

    shl-int v2, v15, v2

    move v14, v0

    move/from16 v16, v1

    move v5, v2

    goto :goto_2

    :cond_2
    move v14, v0

    move/from16 v16, v1

    move v5, v9

    :goto_2
    and-int v0, v3, v10

    .line 5
    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzfz;->zzJ:Lcom/google/android/gms/internal/play_billing/zzfz;

    .line 6
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfz;->zza()I

    move-result v1

    if-lt v4, v1, :cond_3

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzfz;->zzW:Lcom/google/android/gms/internal/play_billing/zzfz;

    .line 5
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfz;->zza()I

    :cond_3
    int-to-long v2, v0

    const/16 v17, 0x3f

    packed-switch v4, :pswitch_data_0

    goto/16 :goto_19

    .line 7
    :pswitch_0
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 8
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 9
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 10
    invoke-static {v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhx;->zza(ILcom/google/android/gms/internal/play_billing/zzhm;Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v0

    goto/16 :goto_13

    .line 11
    :pswitch_1
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 12
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v1

    add-long v3, v1, v1

    shr-long v1, v1, v17

    .line 13
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    xor-long/2addr v1, v3

    .line 14
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    .line 15
    :pswitch_2
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 16
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v1

    add-int v2, v1, v1

    shr-int/lit8 v1, v1, 0x1f

    .line 17
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    xor-int/2addr v1, v2

    .line 18
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    goto/16 :goto_16

    .line 19
    :pswitch_3
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 20
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_18

    .line 21
    :pswitch_4
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 22
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_17

    .line 23
    :pswitch_5
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 24
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v1

    int-to-long v1, v1

    .line 25
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 26
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    .line 27
    :pswitch_6
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 28
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v1

    .line 29
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 30
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    goto/16 :goto_16

    .line 31
    :pswitch_7
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 32
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 33
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 34
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v1

    .line 35
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_14

    .line 36
    :pswitch_8
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 37
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    .line 38
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    sget v3, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 39
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzer;

    .line 40
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 41
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzer;->zzi(Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v1

    .line 42
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_14

    .line 43
    :pswitch_9
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 44
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v2, :cond_4

    .line 45
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 46
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 47
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v1

    .line 48
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_14

    .line 49
    :cond_4
    check-cast v1, Ljava/lang/String;

    .line 50
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 51
    sget v2, Lcom/google/android/gms/internal/play_billing/zzix;->zza:I

    .line 52
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzb(Ljava/lang/String;)I

    move-result v1

    .line 53
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_14

    .line 54
    :pswitch_a
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 55
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_15

    .line 56
    :pswitch_b
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 57
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_17

    .line 58
    :pswitch_c
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 59
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_18

    .line 60
    :pswitch_d
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 61
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v1

    int-to-long v1, v1

    .line 62
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 63
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    .line 64
    :pswitch_e
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 65
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v1

    .line 66
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 67
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    .line 68
    :pswitch_f
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 69
    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v1

    .line 70
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 71
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    .line 72
    :pswitch_10
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 73
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_17

    .line 74
    :pswitch_11
    invoke-direct {v6, v7, v13, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 75
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_18

    .line 76
    :pswitch_12
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzv(I)Ljava/lang/Object;

    move-result-object v1

    .line 77
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhg;

    .line 78
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhf;

    .line 79
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhg;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_5

    goto/16 :goto_11

    .line 80
    :cond_5
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhg;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    move v2, v9

    :goto_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 81
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v13, v4, v3}, Lcom/google/android/gms/internal/play_billing/zzhf;->zza(ILjava/lang/Object;Ljava/lang/Object;)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_3

    .line 82
    :pswitch_13
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 83
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 84
    sget v2, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 85
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_6

    move v4, v9

    goto :goto_5

    :cond_6
    move v3, v9

    move v4, v3

    :goto_4
    if-ge v3, v2, :cond_7

    .line 86
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-static {v13, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhx;->zza(ILcom/google/android/gms/internal/play_billing/zzhm;Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v5

    add-int/2addr v4, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    :cond_7
    :goto_5
    add-int/2addr v12, v4

    goto/16 :goto_19

    .line 87
    :pswitch_14
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 88
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzj(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 89
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 90
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 91
    :pswitch_15
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 92
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzi(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 93
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 94
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 95
    :pswitch_16
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 96
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzf(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 97
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 98
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 99
    :pswitch_17
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 100
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzd(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 101
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 102
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 103
    :pswitch_18
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 104
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzb(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 105
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 106
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 107
    :pswitch_19
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 108
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzk(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 109
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 110
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 111
    :pswitch_1a
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 112
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 113
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 114
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 115
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 116
    :pswitch_1b
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 117
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzd(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 118
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 119
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 120
    :pswitch_1c
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 121
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzf(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 122
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 123
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_6

    .line 124
    :pswitch_1d
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 125
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzg(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 126
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 127
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_6

    .line 128
    :pswitch_1e
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 129
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzl(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 130
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 131
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_6

    .line 132
    :pswitch_1f
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 133
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzh(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 134
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 135
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_6

    .line 136
    :pswitch_20
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 137
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzd(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 138
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 139
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_6

    .line 140
    :pswitch_21
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 141
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzf(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_1a

    shl-int/lit8 v1, v13, 0x3

    .line 142
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 143
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    :goto_6
    add-int/2addr v1, v2

    add-int/2addr v1, v0

    :cond_8
    :goto_7
    add-int/2addr v12, v1

    goto/16 :goto_19

    .line 144
    :pswitch_22
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 145
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 146
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_9

    :goto_8
    move v0, v9

    goto/16 :goto_13

    :cond_9
    shl-int/lit8 v2, v13, 0x3

    .line 147
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzj(Ljava/util/List;)I

    move-result v0

    .line 148
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    :goto_9
    mul-int/2addr v1, v2

    goto/16 :goto_16

    .line 149
    :pswitch_23
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 150
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 151
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_a

    goto :goto_8

    :cond_a
    shl-int/lit8 v2, v13, 0x3

    .line 152
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzi(Ljava/util/List;)I

    move-result v0

    .line 153
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_9

    .line 154
    :pswitch_24
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 155
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zze(ILjava/util/List;Z)I

    move-result v0

    goto/16 :goto_13

    .line 156
    :pswitch_25
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 157
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzc(ILjava/util/List;Z)I

    move-result v0

    goto/16 :goto_13

    .line 158
    :pswitch_26
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 159
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 160
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_b

    goto :goto_8

    :cond_b
    shl-int/lit8 v2, v13, 0x3

    .line 161
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzb(Ljava/util/List;)I

    move-result v0

    .line 162
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_9

    .line 163
    :pswitch_27
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 164
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 165
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_c

    goto :goto_8

    :cond_c
    shl-int/lit8 v2, v13, 0x3

    .line 166
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzk(Ljava/util/List;)I

    move-result v0

    .line 167
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_9

    .line 168
    :pswitch_28
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 169
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 170
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_d

    move v1, v9

    goto/16 :goto_7

    :cond_d
    shl-int/lit8 v2, v13, 0x3

    .line 171
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    mul-int/2addr v1, v2

    move v2, v9

    .line 172
    :goto_a
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_8

    .line 173
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 174
    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v3

    .line 175
    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v4

    add-int/2addr v4, v3

    add-int/2addr v1, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    .line 176
    :pswitch_29
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 177
    sget v2, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 178
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_e

    move v3, v9

    goto :goto_c

    :cond_e
    shl-int/lit8 v3, v13, 0x3

    .line 179
    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v3

    mul-int/2addr v3, v2

    move v4, v9

    :goto_b
    if-ge v4, v2, :cond_f

    .line 180
    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    .line 181
    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzer;

    .line 182
    invoke-virtual {v5, v1}, Lcom/google/android/gms/internal/play_billing/zzer;->zzi(Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v5

    .line 183
    invoke-static {v5}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v13

    add-int/2addr v13, v5

    add-int/2addr v3, v13

    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    :cond_f
    :goto_c
    add-int/2addr v12, v3

    goto/16 :goto_19

    .line 184
    :pswitch_2a
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 185
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_10

    goto/16 :goto_11

    :cond_10
    shl-int/lit8 v2, v13, 0x3

    .line 186
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    mul-int/2addr v2, v1

    instance-of v3, v0, Lcom/google/android/gms/internal/play_billing/zzgu;

    if-eqz v3, :cond_12

    .line 195
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgu;

    move v3, v9

    :goto_d
    if-ge v3, v1, :cond_18

    .line 196
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgu;->zza()Ljava/lang/Object;

    move-result-object v4

    instance-of v5, v4, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v5, :cond_11

    .line 197
    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 198
    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v4

    .line 199
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v5

    goto :goto_e

    .line 200
    :cond_11
    check-cast v4, Ljava/lang/String;

    .line 201
    sget v5, Lcom/google/android/gms/internal/play_billing/zzix;->zza:I

    .line 202
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zziu;->zzb(Ljava/lang/String;)I

    move-result v4

    .line 203
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v5

    :goto_e
    add-int/2addr v5, v4

    add-int/2addr v2, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_d

    :cond_12
    move v3, v9

    :goto_f
    if-ge v3, v1, :cond_18

    .line 187
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    instance-of v5, v4, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v5, :cond_13

    .line 188
    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 189
    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v4

    .line 190
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v5

    goto :goto_10

    .line 191
    :cond_13
    check-cast v4, Ljava/lang/String;

    .line 192
    sget v5, Lcom/google/android/gms/internal/play_billing/zzix;->zza:I

    .line 193
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zziu;->zzb(Ljava/lang/String;)I

    move-result v4

    .line 194
    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v5

    :goto_10
    add-int/2addr v5, v4

    add-int/2addr v2, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_f

    .line 204
    :pswitch_2b
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 205
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 206
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_14

    goto/16 :goto_8

    :cond_14
    shl-int/lit8 v1, v13, 0x3

    .line 207
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    add-int/2addr v1, v15

    mul-int/2addr v0, v1

    goto/16 :goto_13

    .line 208
    :pswitch_2c
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 209
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzc(ILjava/util/List;Z)I

    move-result v0

    goto/16 :goto_13

    .line 210
    :pswitch_2d
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 211
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zze(ILjava/util/List;Z)I

    move-result v0

    goto/16 :goto_13

    .line 212
    :pswitch_2e
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 213
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 214
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_15

    goto/16 :goto_8

    :cond_15
    shl-int/lit8 v2, v13, 0x3

    .line 215
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzg(Ljava/util/List;)I

    move-result v0

    .line 216
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_9

    .line 217
    :pswitch_2f
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 218
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 219
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_16

    goto/16 :goto_8

    :cond_16
    shl-int/lit8 v2, v13, 0x3

    .line 220
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzl(Ljava/util/List;)I

    move-result v0

    .line 221
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto/16 :goto_9

    .line 222
    :pswitch_30
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 223
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 224
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_17

    :goto_11
    move v2, v9

    goto :goto_12

    :cond_17
    shl-int/lit8 v1, v13, 0x3

    .line 225
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzh(Ljava/util/List;)I

    move-result v2

    .line 226
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 227
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    mul-int/2addr v0, v1

    add-int/2addr v2, v0

    :cond_18
    :goto_12
    add-int/2addr v12, v2

    goto/16 :goto_19

    .line 228
    :pswitch_31
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 229
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzc(ILjava/util/List;Z)I

    move-result v0

    goto :goto_13

    .line 230
    :pswitch_32
    invoke-virtual {v8, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 231
    invoke-static {v13, v0, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zze(ILjava/util/List;Z)I

    move-result v0

    :goto_13
    add-int/2addr v12, v0

    goto/16 :goto_19

    :pswitch_33
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide v3, v2

    move v2, v11

    move-wide v9, v3

    move v3, v14

    move/from16 v4, v16

    .line 232
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 233
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 234
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 235
    invoke-static {v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhx;->zza(ILcom/google/android/gms/internal/play_billing/zzhm;Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v0

    goto :goto_13

    :pswitch_34
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 236
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 237
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v1

    add-long v3, v1, v1

    shr-long v1, v1, v17

    .line 238
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    xor-long/2addr v1, v3

    .line 239
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    :pswitch_35
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 240
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 241
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    add-int v2, v1, v1

    shr-int/lit8 v1, v1, 0x1f

    .line 242
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    xor-int/2addr v1, v2

    .line 243
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    goto/16 :goto_16

    :pswitch_36
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 244
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 245
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_18

    :pswitch_37
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 246
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 247
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_17

    :pswitch_38
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 248
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 249
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    int-to-long v1, v1

    .line 250
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 251
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto/16 :goto_16

    :pswitch_39
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 252
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 253
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    .line 254
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 255
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    goto/16 :goto_16

    :pswitch_3a
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 256
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 257
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 258
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 259
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v1

    .line 260
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_14

    :pswitch_3b
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 261
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 262
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    .line 263
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    sget v3, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 264
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzer;

    .line 265
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 266
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzer;->zzi(Lcom/google/android/gms/internal/play_billing/zzhw;)I

    move-result v1

    .line 267
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    :goto_14
    add-int/2addr v2, v1

    add-int/2addr v0, v2

    goto/16 :goto_13

    :pswitch_3c
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 268
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 269
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v2, :cond_19

    .line 270
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 271
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 272
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v1

    .line 273
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_14

    .line 274
    :cond_19
    check-cast v1, Ljava/lang/String;

    .line 275
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 276
    sget v2, Lcom/google/android/gms/internal/play_billing/zzix;->zza:I

    .line 277
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzb(Ljava/lang/String;)I

    move-result v1

    .line 278
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v2

    goto :goto_14

    :pswitch_3d
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 279
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 280
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    :goto_15
    add-int/2addr v0, v15

    goto/16 :goto_13

    :pswitch_3e
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 281
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 282
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_17

    :pswitch_3f
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 283
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 284
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    goto/16 :goto_18

    :pswitch_40
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 285
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 286
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    int-to-long v1, v1

    .line 287
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 288
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto :goto_16

    :pswitch_41
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 289
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 290
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v1

    .line 291
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 292
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    goto :goto_16

    :pswitch_42
    move-wide v9, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 293
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 294
    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v1

    .line 295
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    .line 296
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzz(J)I

    move-result v1

    :goto_16
    add-int/2addr v0, v1

    goto/16 :goto_13

    :pswitch_43
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 297
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 298
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    :goto_17
    add-int/lit8 v0, v0, 0x4

    goto/16 :goto_13

    :pswitch_44
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v14

    move/from16 v4, v16

    .line 299
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_1a

    shl-int/lit8 v0, v13, 0x3

    .line 300
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    :goto_18
    add-int/lit8 v0, v0, 0x8

    goto/16 :goto_13

    :cond_1a
    :goto_19
    add-int/lit8 v11, v11, 0x3

    move v0, v14

    move/from16 v1, v16

    const/4 v9, 0x0

    const v10, 0xfffff

    goto/16 :goto_0

    .line 301
    :cond_1b
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 302
    move-object v1, v0

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzim;

    .line 303
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzim;->zza()I

    move-result v0

    add-int/2addr v12, v0

    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_1e

    .line 304
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzc()I

    move-result v1

    const/4 v9, 0x0

    const/16 v18, 0x0

    :goto_1a
    if-ge v9, v1, :cond_1c

    .line 305
    invoke-virtual {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzid;->zzg(I)Ljava/util/Map$Entry;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzhz;

    .line 306
    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzhz;->zza()Ljava/lang/Comparable;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)I

    move-result v2

    add-int v18, v18, v2

    add-int/lit8 v9, v9, 0x1

    goto :goto_1a

    .line 307
    :cond_1c
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzid;->zzd()Ljava/lang/Iterable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 308
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzfx;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzc(Lcom/google/android/gms/internal/play_billing/zzfx;Ljava/lang/Object;)I

    move-result v1

    add-int v18, v18, v1

    goto :goto_1b

    :cond_1d
    add-int v12, v12, v18

    :cond_1e
    return v12

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
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

.method public final zzb(Ljava/lang/Object;)I
    .locals 8

    const/4 v0, 0x0

    move v1, v0

    move v2, v1

    .line 1
    :goto_0
    iget-object v3, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    array-length v3, v3

    const v4, 0xfffff

    if-ge v1, v3, :cond_3

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v5

    const/16 v6, 0x32

    if-le v5, v6, :cond_0

    const/16 v6, 0x45

    if-lt v5, v6, :cond_2

    :cond_0
    and-int/2addr v3, v4

    int-to-long v3, v3

    const/16 v6, 0x25

    const/16 v7, 0x20

    packed-switch v5, :pswitch_data_0

    goto/16 :goto_4

    :pswitch_0
    mul-int/lit8 v2, v2, 0x35

    .line 2
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto/16 :goto_3

    :pswitch_1
    mul-int/lit8 v2, v2, 0x35

    .line 3
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto/16 :goto_3

    :pswitch_2
    mul-int/lit8 v2, v2, 0x35

    .line 4
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 5
    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v6

    goto :goto_1

    :pswitch_3
    mul-int/lit8 v2, v2, 0x35

    .line 6
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    goto/16 :goto_2

    :pswitch_4
    mul-int/lit8 v2, v2, 0x35

    .line 7
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto/16 :goto_3

    :pswitch_5
    mul-int/lit8 v2, v2, 0x35

    .line 8
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    goto/16 :goto_2

    :pswitch_6
    mul-int/lit8 v2, v2, 0x35

    .line 9
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto/16 :goto_3

    :pswitch_7
    mul-int/lit8 v2, v2, 0x35

    .line 10
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto/16 :goto_3

    :pswitch_8
    mul-int/lit8 v2, v2, 0x35

    .line 11
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto/16 :goto_3

    :pswitch_9
    mul-int/lit8 v2, v2, 0x35

    .line 12
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto/16 :goto_3

    :pswitch_a
    mul-int/lit8 v2, v2, 0x35

    .line 13
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 14
    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v6

    :cond_1
    :goto_1
    add-int/2addr v2, v6

    goto :goto_4

    :pswitch_b
    mul-int/lit8 v2, v2, 0x35

    .line 15
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    goto :goto_3

    :pswitch_c
    mul-int/lit8 v2, v2, 0x35

    .line 16
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zza(Z)I

    move-result v3

    goto :goto_3

    :pswitch_d
    mul-int/lit8 v2, v2, 0x35

    .line 17
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto :goto_3

    :pswitch_e
    mul-int/lit8 v2, v2, 0x35

    .line 18
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    goto :goto_2

    :pswitch_f
    mul-int/lit8 v2, v2, 0x35

    .line 19
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto :goto_3

    :pswitch_10
    mul-int/lit8 v2, v2, 0x35

    .line 20
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    goto :goto_2

    :pswitch_11
    mul-int/lit8 v2, v2, 0x35

    .line 21
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    goto :goto_2

    :pswitch_12
    mul-int/lit8 v2, v2, 0x35

    .line 22
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    goto :goto_3

    :pswitch_13
    mul-int/lit8 v2, v2, 0x35

    .line 23
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    .line 24
    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgm;->zza:[B

    :goto_2
    ushr-long v5, v3, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    :goto_3
    add-int/2addr v2, v3

    :cond_2
    :goto_4
    add-int/lit8 v1, v1, 0x3

    goto/16 :goto_0

    .line 22
    :cond_3
    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzk:I

    :goto_5
    iget-object v3, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzi:[I

    array-length v5, v3

    if-ge v1, v5, :cond_5

    .line 25
    aget v3, v3, v1

    .line 26
    invoke-direct {p0, p1, v0, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v5

    if-nez v5, :cond_4

    mul-int/lit8 v2, v2, 0x35

    .line 27
    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v3

    and-int/2addr v3, v4

    int-to-long v5, v3

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_5
    mul-int/lit8 v2, v2, 0x35

    .line 28
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 29
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    add-int/2addr v2, v0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_6

    mul-int/lit8 v2, v2, 0x35

    .line 30
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 31
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzid;->hashCode()I

    move-result p1

    add-int/2addr v2, p1

    :cond_6
    return v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_13
        :pswitch_12
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
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method final zzc(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I
    .locals 38
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object/from16 v15, p2

    move/from16 v14, p4

    move/from16 v13, p5

    move-object/from16 v12, p6

    .line 1
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzz(Ljava/lang/Object;)V

    sget-object v11, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    move/from16 v0, p3

    const/4 v1, -0x1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const v5, 0xfffff

    :goto_0
    const-string v8, "Failed to parse the message."

    const/16 v17, 0x0

    if-ge v0, v14, :cond_8f

    add-int/lit8 v3, v0, 0x1

    .line 2
    aget-byte v0, v15, v0

    if-gez v0, :cond_0

    .line 3
    invoke-static {v0, v15, v3, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzj(I[BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v3, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    goto :goto_1

    :cond_0
    move/from16 v37, v3

    move v3, v0

    move/from16 v0, v37

    :goto_1
    ushr-int/lit8 v9, v3, 0x3

    const/4 v10, 0x3

    if-le v9, v1, :cond_2

    div-int/2addr v2, v10

    iget v1, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zze:I

    if-lt v9, v1, :cond_1

    iget v1, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzf:I

    if-gt v9, v1, :cond_1

    .line 5
    invoke-direct {v6, v9, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzo(II)I

    move-result v1

    goto :goto_2

    :cond_1
    const/4 v1, -0x1

    :goto_2
    const/4 v2, 0x0

    goto :goto_3

    .line 275
    :cond_2
    iget v1, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zze:I

    if-lt v9, v1, :cond_3

    iget v1, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzf:I

    if-gt v9, v1, :cond_3

    const/4 v2, 0x0

    .line 4
    invoke-direct {v6, v9, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzo(II)I

    move-result v1

    goto :goto_3

    :cond_3
    const/4 v2, 0x0

    const/4 v1, -0x1

    :goto_3
    const/4 v10, -0x1

    if-ne v1, v10, :cond_4

    move/from16 v21, v2

    move/from16 v22, v4

    move/from16 v16, v5

    move-object/from16 v20, v8

    move/from16 v19, v10

    move-object v8, v11

    move-object v5, v12

    move v6, v13

    move v2, v0

    move/from16 v10, v21

    move v4, v3

    move v12, v9

    goto/16 :goto_4f

    :cond_4
    and-int/lit8 v2, v3, 0x7

    .line 286
    iget-object v10, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    add-int/lit8 v20, v1, 0x1

    move/from16 v21, v3

    .line 6
    aget v3, v10, v20

    move-object/from16 v20, v8

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v8

    const v16, 0xfffff

    and-int v13, v3, v16

    int-to-long v13, v13

    move/from16 v22, v9

    const/high16 v23, 0x20000000

    const-string v9, ""

    const-wide/16 v25, 0x0

    move-object/from16 v27, v9

    const-string v9, "CodedInputStream encountered an embedded string or message which claimed to have negative size."

    move-object/from16 v28, v9

    const/16 v9, 0x11

    if-gt v8, v9, :cond_15

    add-int/lit8 v9, v1, 0x2

    .line 7
    aget v9, v10, v9

    ushr-int/lit8 v10, v9, 0x14

    const/16 v24, 0x1

    shl-int v10, v24, v10

    const v6, 0xfffff

    and-int/2addr v9, v6

    move-wide/from16 v30, v13

    if-eq v9, v5, :cond_7

    if-eq v5, v6, :cond_5

    int-to-long v13, v5

    .line 8
    invoke-virtual {v11, v7, v13, v14, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_5
    if-ne v9, v6, :cond_6

    const/4 v4, 0x0

    goto :goto_4

    :cond_6
    int-to-long v4, v9

    .line 9
    invoke-virtual {v11, v7, v4, v5}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    :goto_4
    move/from16 v16, v9

    goto :goto_5

    :cond_7
    move/from16 v16, v5

    :goto_5
    packed-switch v8, :pswitch_data_0

    move v5, v0

    move v9, v1

    move v8, v6

    const/4 v0, 0x3

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_14

    or-int/2addr v4, v10

    .line 10
    invoke-direct {v6, v7, v9}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzw(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v0

    shl-int/lit8 v1, v22, 0x3

    or-int/lit8 v13, v1, 0x4

    .line 11
    invoke-direct {v6, v9}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    move v2, v8

    move-object v8, v0

    move/from16 v18, v9

    move/from16 v14, v21

    move/from16 v3, v22

    const/16 v19, -0x1

    move-object v9, v1

    const/16 v21, 0x0

    move-object/from16 v10, p2

    move-object v1, v11

    move v11, v5

    move-object v5, v12

    move/from16 v12, p4

    move/from16 v5, p4

    move/from16 p3, v4

    move/from16 v4, v18

    move/from16 v18, v14

    move-object/from16 v14, p6

    .line 12
    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v8

    .line 13
    invoke-direct {v6, v7, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzE(Ljava/lang/Object;ILjava/lang/Object;)V

    move/from16 v13, p5

    move-object/from16 v12, p6

    move-object v11, v1

    move v1, v3

    move v2, v4

    move v14, v5

    move v0, v8

    move/from16 v5, v16

    move/from16 v3, v18

    move/from16 v4, p3

    goto/16 :goto_0

    :pswitch_0
    if-nez v2, :cond_8

    or-int v8, v4, v10

    .line 14
    invoke-static {v15, v0, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v9

    iget-wide v2, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 15
    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide v4

    move-object v0, v11

    move v14, v1

    move-object/from16 v1, p1

    move/from16 v10, v21

    const/4 v13, 0x0

    move-wide/from16 v2, v30

    .line 16
    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    move-object/from16 v6, p0

    move/from16 v13, p5

    move v4, v8

    move v0, v9

    move v3, v10

    goto :goto_6

    :cond_8
    move/from16 v5, p4

    move v9, v0

    move v8, v4

    move v2, v6

    move-object v0, v12

    move/from16 v18, v21

    move/from16 v3, v22

    const/16 v19, -0x1

    const/16 v21, 0x0

    move-object/from16 v6, p0

    goto/16 :goto_d

    :pswitch_1
    move v14, v1

    move/from16 v9, v21

    const/4 v13, 0x0

    if-nez v2, :cond_9

    or-int/2addr v4, v10

    .line 17
    invoke-static {v15, v0, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 18
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result v1

    move-wide/from16 v2, v30

    .line 19
    invoke-virtual {v11, v7, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move-object/from16 v6, p0

    move/from16 v13, p5

    move v3, v9

    :goto_6
    move v2, v14

    move/from16 v5, v16

    move/from16 v1, v22

    move/from16 v14, p4

    goto/16 :goto_0

    :cond_9
    move/from16 v5, p4

    move v8, v4

    move v2, v6

    move/from16 v18, v9

    move-object v1, v11

    move/from16 v21, v13

    move v4, v14

    move/from16 v3, v22

    const/16 v19, -0x1

    move-object/from16 v6, p0

    move v9, v0

    move-object v0, v12

    goto/16 :goto_12

    :pswitch_2
    move v14, v1

    move/from16 v9, v21

    move-wide/from16 v32, v30

    const/4 v13, 0x0

    if-nez v2, :cond_c

    .line 20
    invoke-static {v15, v0, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    move v8, v6

    move-object/from16 v6, p0

    .line 21
    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzs(I)Lcom/google/android/gms/internal/play_billing/zzgj;

    move-result-object v2

    const/high16 v5, -0x80000000

    and-int/2addr v3, v5

    if-eqz v3, :cond_b

    if-eqz v2, :cond_b

    invoke-interface {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzgj;->zza(I)Z

    move-result v2

    if-eqz v2, :cond_a

    goto :goto_7

    .line 23
    :cond_a
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v2

    move/from16 v19, v14

    int-to-long v13, v1

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v2, v9, v1}, Lcom/google/android/gms/internal/play_billing/zzim;->zzj(ILjava/lang/Object;)V

    goto :goto_8

    :cond_b
    :goto_7
    move/from16 v19, v14

    or-int/2addr v4, v10

    move-wide/from16 v13, v32

    .line 22
    invoke-virtual {v11, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_8

    :cond_c
    move v8, v6

    move-object/from16 v6, p0

    move/from16 v5, p4

    move v2, v8

    move/from16 v18, v9

    move-object v1, v11

    move/from16 v21, v13

    move/from16 v3, v22

    const/16 v19, -0x1

    move v9, v0

    move v8, v4

    move-object v0, v12

    move v4, v14

    goto/16 :goto_12

    :pswitch_3
    move/from16 v19, v1

    move v8, v6

    move/from16 v9, v21

    move-wide/from16 v13, v30

    const/4 v1, 0x2

    move-object/from16 v6, p0

    if-ne v2, v1, :cond_d

    or-int/2addr v4, v10

    .line 24
    invoke-static {v15, v0, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zza([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-object v1, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    .line 25
    invoke-virtual {v11, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_8
    move/from16 v14, p4

    move/from16 v13, p5

    move v3, v9

    move/from16 v5, v16

    move/from16 v2, v19

    goto/16 :goto_11

    :pswitch_4
    move/from16 v19, v1

    move v8, v6

    move/from16 v9, v21

    const/4 v1, 0x2

    move-object/from16 v6, p0

    if-ne v2, v1, :cond_d

    or-int/2addr v10, v4

    move/from16 v13, v19

    .line 26
    invoke-direct {v6, v7, v13}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzw(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v14

    .line 27
    invoke-direct {v6, v13}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    move v5, v0

    move-object v0, v14

    move-object/from16 v2, p2

    move v3, v5

    move/from16 v4, p4

    move-object/from16 v5, p6

    .line 28
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzn(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;[BIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    .line 29
    invoke-direct {v6, v7, v13, v14}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzE(Ljava/lang/Object;ILjava/lang/Object;)V

    move/from16 v14, p4

    move v3, v9

    move v4, v10

    move v2, v13

    move/from16 v5, v16

    move/from16 v1, v22

    move/from16 v13, p5

    goto/16 :goto_0

    :cond_d
    move/from16 v5, p4

    move v2, v8

    move/from16 v18, v9

    move-object v1, v11

    move/from16 v3, v22

    const/16 v21, 0x0

    move v9, v0

    move v8, v4

    move-object v0, v12

    move/from16 v4, v19

    const/16 v19, -0x1

    goto/16 :goto_12

    :pswitch_5
    move v5, v0

    move v8, v6

    move/from16 v9, v21

    move-wide/from16 v13, v30

    const/4 v0, 0x2

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_12

    and-int v0, v3, v23

    if-eqz v0, :cond_e

    or-int v0, v4, v10

    .line 32
    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzg([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    move v4, v0

    move v0, v2

    goto :goto_a

    .line 30
    :cond_e
    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_10

    or-int v3, v4, v10

    if-nez v2, :cond_f

    move-object/from16 v4, v27

    .line 288
    iput-object v4, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    goto :goto_9

    :cond_f
    new-instance v4, Ljava/lang/String;

    .line 31
    sget-object v5, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v4, v15, v0, v2, v5}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    iput-object v4, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    add-int/2addr v0, v2

    :goto_9
    move v4, v3

    .line 32
    :goto_a
    iget-object v2, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    .line 33
    invoke-virtual {v11, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_c

    .line 30
    :cond_10
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    move-object/from16 v1, v28

    .line 287
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 288
    throw v0

    :pswitch_6
    move v5, v0

    move v8, v6

    move/from16 v9, v21

    move-wide/from16 v13, v30

    move-object/from16 v6, p0

    if-nez v2, :cond_12

    or-int/2addr v4, v10

    .line 34
    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v2, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    cmp-long v2, v2, v25

    if-eqz v2, :cond_11

    const/4 v2, 0x1

    goto :goto_b

    :cond_11
    const/4 v2, 0x0

    .line 35
    :goto_b
    invoke-static {v7, v13, v14, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzm(Ljava/lang/Object;JZ)V

    goto :goto_c

    :pswitch_7
    move v5, v0

    move v8, v6

    move/from16 v9, v21

    move-wide/from16 v13, v30

    const/4 v0, 0x5

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_12

    add-int/lit8 v0, v5, 0x4

    or-int/2addr v4, v10

    .line 36
    invoke-static {v15, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v2

    invoke-virtual {v11, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :goto_c
    move/from16 v14, p4

    move/from16 v13, p5

    move v2, v1

    move v3, v9

    move/from16 v5, v16

    goto/16 :goto_11

    :cond_12
    move v2, v8

    move/from16 v18, v9

    move-object v0, v12

    move/from16 v3, v22

    const/16 v19, -0x1

    const/16 v21, 0x0

    move v8, v4

    move v9, v5

    move/from16 v5, p4

    goto :goto_d

    :pswitch_8
    move v5, v0

    move v8, v6

    move/from16 v9, v21

    move-wide/from16 v13, v30

    const/4 v0, 0x1

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_13

    add-int/lit8 v17, v5, 0x8

    or-int/2addr v10, v4

    .line 37
    invoke-static {v15, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v4

    move-object v0, v11

    move v2, v1

    move-object/from16 v1, p1

    move/from16 v21, v9

    move v9, v2

    move-wide v2, v13

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    goto :goto_e

    :cond_13
    move/from16 v21, v9

    move v9, v5

    move v2, v8

    move-object v0, v12

    move/from16 v18, v21

    move/from16 v3, v22

    const/16 v19, -0x1

    const/16 v21, 0x0

    move/from16 v5, p4

    move v8, v4

    :goto_d
    move v4, v1

    move-object v1, v11

    goto/16 :goto_12

    :pswitch_9
    move v5, v0

    move v9, v1

    move v8, v6

    move-wide/from16 v13, v30

    move-object/from16 v6, p0

    if-nez v2, :cond_14

    or-int/2addr v4, v10

    .line 38
    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 39
    invoke-virtual {v11, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_f

    :pswitch_a
    move v5, v0

    move v9, v1

    move v8, v6

    move-wide/from16 v13, v30

    move-object/from16 v6, p0

    if-nez v2, :cond_14

    or-int/2addr v10, v4

    .line 40
    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v17

    iget-wide v4, v12, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    move-object v0, v11

    move-object/from16 v1, p1

    move-wide v2, v13

    .line 41
    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    :goto_e
    move/from16 v14, p4

    move/from16 v13, p5

    move v2, v9

    move v4, v10

    move/from16 v5, v16

    move/from16 v0, v17

    goto :goto_10

    :pswitch_b
    move v5, v0

    move v9, v1

    move v8, v6

    move-wide/from16 v13, v30

    const/4 v0, 0x5

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_14

    add-int/lit8 v0, v5, 0x4

    or-int/2addr v4, v10

    .line 42
    invoke-static {v15, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v1

    .line 43
    invoke-static {v7, v13, v14, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzp(Ljava/lang/Object;JF)V

    goto :goto_f

    :pswitch_c
    move v5, v0

    move v9, v1

    move v8, v6

    move-wide/from16 v13, v30

    const/4 v0, 0x1

    move-object/from16 v6, p0

    if-ne v2, v0, :cond_14

    add-int/lit8 v0, v5, 0x8

    or-int/2addr v4, v10

    .line 44
    invoke-static {v15, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v1

    .line 45
    invoke-static {v7, v13, v14, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzo(Ljava/lang/Object;JD)V

    :goto_f
    move/from16 v14, p4

    move/from16 v13, p5

    move v2, v9

    move/from16 v5, v16

    :goto_10
    move/from16 v3, v21

    :goto_11
    move/from16 v1, v22

    goto/16 :goto_0

    :cond_14
    move v2, v8

    move-object v1, v11

    move-object v0, v12

    move/from16 v18, v21

    move/from16 v3, v22

    const/16 v19, -0x1

    const/16 v21, 0x0

    move v8, v4

    move v4, v9

    move v9, v5

    move/from16 v5, p4

    :goto_12
    move/from16 v6, p5

    move-object v5, v0

    move v12, v3

    move v10, v4

    move/from16 v22, v8

    move v2, v9

    move/from16 v4, v18

    move-object v8, v1

    goto/16 :goto_4f

    :cond_15
    move/from16 v24, v0

    move/from16 v16, v5

    move-object v0, v12

    move/from16 v18, v21

    move-object/from16 v9, v27

    const/16 v19, -0x1

    const/16 v21, 0x0

    move/from16 v5, p4

    move-object v12, v11

    move/from16 v27, v22

    move/from16 v22, v4

    move v4, v1

    move-object/from16 v1, v28

    const/16 v11, 0x1b

    if-ne v8, v11, :cond_19

    const/4 v11, 0x2

    if-ne v2, v11, :cond_18

    .line 46
    invoke-virtual {v12, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 47
    invoke-interface {v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()Z

    move-result v2

    if-nez v2, :cond_17

    .line 48
    invoke-interface {v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->size()I

    move-result v2

    if-nez v2, :cond_16

    const/16 v2, 0xa

    goto :goto_13

    :cond_16
    add-int/2addr v2, v2

    .line 49
    :goto_13
    invoke-interface {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v1

    .line 50
    invoke-virtual {v12, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_17
    move-object v13, v1

    .line 51
    invoke-direct {v6, v4}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v8

    move/from16 v11, v24

    move/from16 v9, v18

    move-object/from16 v10, p2

    move/from16 v1, v27

    move-object v2, v12

    move/from16 v12, p4

    move-object/from16 v14, p6

    .line 52
    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zze(Lcom/google/android/gms/internal/play_billing/zzhw;I[BIILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v3

    move/from16 v13, p5

    move-object v12, v0

    move-object v11, v2

    move v0, v3

    move v2, v4

    move v14, v5

    move/from16 v5, v16

    move/from16 v3, v18

    move/from16 v4, v22

    goto/16 :goto_0

    :cond_18
    move-object v7, v0

    move v10, v4

    move-object/from16 v34, v12

    move/from16 v36, v18

    move-object/from16 v6, v20

    move/from16 v11, v24

    move/from16 v35, v27

    move v12, v5

    goto/16 :goto_41

    :cond_19
    move/from16 v11, v24

    move-object/from16 v24, v10

    move/from16 v10, v27

    move/from16 v27, v4

    const/16 v4, 0x31

    move-object/from16 v28, v9

    const-string v9, "Protocol message had invalid UTF-8."

    move-object/from16 v30, v9

    const-string v9, "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."

    if-gt v8, v4, :cond_72

    int-to-long v3, v3

    .line 53
    invoke-virtual {v12, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v23

    move-wide/from16 v31, v3

    move-object/from16 v3, v23

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 54
    invoke-interface {v3}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()Z

    move-result v4

    if-nez v4, :cond_1a

    .line 55
    invoke-interface {v3}, Lcom/google/android/gms/internal/play_billing/zzgl;->size()I

    move-result v4

    add-int/2addr v4, v4

    .line 56
    invoke-interface {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v3

    .line 57
    invoke-virtual {v12, v7, v13, v14, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_1a
    move-object v13, v3

    packed-switch v8, :pswitch_data_1

    move-object v14, v0

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v10, v20

    const/4 v0, 0x3

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_6f

    and-int/lit8 v0, v7, -0x8

    or-int/lit8 v9, v0, 0x4

    .line 58
    invoke-direct {v6, v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    move v2, v11

    move/from16 v3, p4

    move v4, v9

    move-object/from16 v20, v10

    move v10, v5

    move-object/from16 v5, p6

    .line 59
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzc(Lcom/google/android/gms/internal/play_billing/zzhw;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-object v1, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    .line 60
    invoke-interface {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3a

    :pswitch_d
    const/4 v3, 0x2

    if-ne v2, v3, :cond_1f

    .line 64
    sget v2, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 65
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 66
    invoke-static {v15, v11, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v3, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v3, :cond_1e

    .line 67
    array-length v1, v15

    sub-int/2addr v1, v2

    if-gt v3, v1, :cond_1d

    add-int/2addr v3, v2

    :goto_14
    if-ge v2, v3, :cond_1b

    .line 68
    invoke-static {v15, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    move/from16 p3, v2

    iget-wide v1, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 69
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide v1

    invoke-virtual {v13, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    move/from16 v2, p3

    goto :goto_14

    :cond_1b
    if-ne v2, v3, :cond_1c

    move-object v14, v0

    move v0, v2

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move/from16 v10, v27

    goto/16 :goto_19

    .line 356
    :cond_1c
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 293
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 294
    throw v0

    .line 67
    :cond_1d
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 291
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 292
    throw v0

    .line 66
    :cond_1e
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 289
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 290
    throw v0

    :cond_1f
    if-nez v2, :cond_21

    .line 70
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 71
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 72
    invoke-static {v15, v11, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget-wide v2, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 73
    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide v2

    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    :goto_15
    if-ge v1, v5, :cond_20

    .line 74
    invoke-static {v15, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v3, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    move/from16 v14, v18

    if-ne v14, v3, :cond_27

    .line 75
    invoke-static {v15, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget-wide v2, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide v2

    .line 76
    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    move/from16 v18, v14

    goto :goto_15

    :cond_20
    move/from16 v14, v18

    goto/16 :goto_18

    :cond_21
    move-object v14, v0

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move/from16 v10, v27

    goto/16 :goto_1f

    :pswitch_e
    move/from16 v14, v18

    const/4 v3, 0x2

    if-ne v2, v3, :cond_26

    .line 77
    sget v2, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 78
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzgh;

    .line 79
    invoke-static {v15, v11, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v3, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v3, :cond_25

    .line 80
    array-length v1, v15

    sub-int/2addr v1, v2

    if-gt v3, v1, :cond_24

    add-int/2addr v3, v2

    :goto_16
    if-ge v2, v3, :cond_22

    .line 81
    invoke-static {v15, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v1, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 82
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result v1

    invoke-virtual {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    goto :goto_16

    :cond_22
    if-ne v2, v3, :cond_23

    move v8, v10

    move-object/from16 v34, v12

    move v7, v14

    move/from16 v10, v27

    move-object v14, v0

    move v0, v2

    goto :goto_19

    .line 294
    :cond_23
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 299
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 300
    throw v0

    .line 80
    :cond_24
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 297
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 298
    throw v0

    .line 79
    :cond_25
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 295
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 296
    throw v0

    :cond_26
    if-nez v2, :cond_30

    .line 83
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 84
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzgh;

    .line 85
    invoke-static {v15, v11, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 86
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result v2

    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    :goto_17
    if-ge v1, v5, :cond_27

    .line 87
    invoke-static {v15, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v3, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v14, v3, :cond_27

    .line 88
    invoke-static {v15, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result v2

    .line 89
    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    goto :goto_17

    :cond_27
    :goto_18
    move v8, v10

    move-object/from16 v34, v12

    move v7, v14

    move/from16 v10, v27

    move-object v14, v0

    move v0, v1

    :goto_19
    move v12, v5

    goto/16 :goto_3c

    :pswitch_f
    move/from16 v14, v18

    const/4 v1, 0x2

    if-ne v2, v1, :cond_28

    .line 90
    invoke-static {v15, v11, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzf([BILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    move-object v8, v0

    move-object/from16 v18, v12

    move/from16 v9, v27

    move v12, v5

    goto :goto_1a

    :cond_28
    if-nez v2, :cond_30

    move-object v8, v0

    move v0, v14

    move-object/from16 v1, p2

    move v2, v11

    move/from16 v3, p4

    move/from16 v9, v27

    move-object v4, v13

    move-object/from16 v18, v12

    move v12, v5

    move-object/from16 v5, p6

    .line 91
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzk(I[BIILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    .line 92
    :goto_1a
    invoke-direct {v6, v9}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzs(I)Lcom/google/android/gms/internal/play_billing/zzgj;

    move-result-object v0

    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl:Lcom/google/android/gms/internal/play_billing/zzil;

    .line 93
    sget v3, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    if-eqz v0, :cond_2e

    .line 94
    instance-of v3, v13, Ljava/util/RandomAccess;

    if-eqz v3, :cond_2c

    .line 95
    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v3

    move/from16 p3, v1

    move-object/from16 v1, v17

    move/from16 v4, v21

    move v5, v4

    :goto_1b
    if-ge v4, v3, :cond_2b

    .line 96
    invoke-interface {v13, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/Integer;

    move/from16 v27, v9

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I

    move-result v9

    invoke-interface {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgj;->zza(I)Z

    move-result v23

    if-eqz v23, :cond_2a

    if-eq v4, v5, :cond_29

    .line 97
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v13, v5, v9}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_29
    add-int/lit8 v5, v5, 0x1

    goto :goto_1c

    .line 98
    :cond_2a
    invoke-static {v7, v10, v9, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzn(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzil;)Ljava/lang/Object;

    move-result-object v1

    :goto_1c
    add-int/lit8 v4, v4, 0x1

    move/from16 v9, v27

    goto :goto_1b

    :cond_2b
    move/from16 v27, v9

    if-eq v5, v3, :cond_2f

    .line 99
    invoke-interface {v13, v5, v3}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_1e

    :cond_2c
    move/from16 p3, v1

    move/from16 v27, v9

    .line 100
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    move-object/from16 v3, v17

    :cond_2d
    :goto_1d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2f

    .line 101
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-interface {v0, v4}, Lcom/google/android/gms/internal/play_billing/zzgj;->zza(I)Z

    move-result v5

    if-nez v5, :cond_2d

    .line 102
    invoke-static {v7, v10, v4, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzn(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzil;)Ljava/lang/Object;

    move-result-object v3

    .line 103
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_1d

    :cond_2e
    move/from16 p3, v1

    move/from16 v27, v9

    :cond_2f
    :goto_1e
    move/from16 v0, p3

    move v7, v14

    move-object/from16 v34, v18

    move-object v14, v8

    move v8, v10

    move/from16 v10, v27

    goto/16 :goto_3c

    :cond_30
    move v8, v10

    move-object/from16 v34, v12

    move v7, v14

    move/from16 v10, v27

    move-object v14, v0

    :goto_1f
    move v12, v5

    goto/16 :goto_3b

    :pswitch_10
    move-object v8, v0

    move/from16 v14, v18

    const/4 v0, 0x2

    move-object/from16 v18, v12

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_38

    .line 104
    invoke-static {v15, v11, v8}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v8, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_37

    .line 105
    array-length v3, v15

    sub-int/2addr v3, v0

    if-gt v2, v3, :cond_36

    if-nez v2, :cond_31

    .line 106
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-interface {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_21

    .line 107
    :cond_31
    invoke-static {v15, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzk([BII)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v3

    invoke-interface {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    :goto_20
    add-int/2addr v0, v2

    :goto_21
    if-ge v0, v12, :cond_35

    .line 108
    invoke-static {v15, v0, v8}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v3, v8, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v14, v3, :cond_35

    .line 109
    invoke-static {v15, v2, v8}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v8, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_34

    .line 110
    array-length v3, v15

    sub-int/2addr v3, v0

    if-gt v2, v3, :cond_33

    if-nez v2, :cond_32

    .line 308
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 111
    invoke-interface {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_21

    .line 112
    :cond_32
    invoke-static {v15, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzk([BII)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v3

    invoke-interface {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_20

    .line 110
    :cond_33
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 307
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 308
    throw v0

    .line 109
    :cond_34
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 305
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 306
    throw v0

    :cond_35
    move v7, v14

    move-object/from16 v34, v18

    move-object v14, v8

    move v8, v10

    goto/16 :goto_39

    .line 105
    :cond_36
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 303
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 304
    throw v0

    .line 104
    :cond_37
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 301
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 302
    throw v0

    :pswitch_11
    move-object v8, v0

    move/from16 v14, v18

    const/4 v0, 0x2

    move-object/from16 v18, v12

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_38

    .line 113
    invoke-direct {v6, v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v0

    move-object v4, v8

    move-object/from16 v3, v20

    move-object v8, v0

    move v9, v14

    move v0, v10

    move-object/from16 v10, p2

    move v1, v11

    move v2, v12

    move-object/from16 v34, v18

    move/from16 v12, p4

    move v7, v14

    move-object/from16 v14, p6

    .line 114
    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zze(Lcom/google/android/gms/internal/play_billing/zzhw;I[BIILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v8

    move v12, v2

    move-object v14, v4

    move v10, v5

    move/from16 v37, v8

    move v8, v0

    move/from16 v0, v37

    goto/16 :goto_3c

    :cond_38
    move v7, v14

    move-object/from16 v34, v18

    move-object v14, v8

    move v8, v10

    goto/16 :goto_25

    :pswitch_12
    move-object v4, v0

    move v0, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v3, v20

    const/4 v8, 0x2

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v8, :cond_46

    const-wide/32 v8, 0x20000000

    and-long v8, v31, v8

    cmp-long v2, v8, v25

    if-nez v2, :cond_3e

    .line 115
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v8, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v8, :cond_3d

    if-nez v8, :cond_39

    move-object/from16 v10, v28

    .line 116
    invoke-interface {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_23

    :cond_39
    move-object/from16 v10, v28

    .line 123
    new-instance v9, Ljava/lang/String;

    .line 117
    sget-object v14, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v9, v15, v2, v8, v14}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    .line 118
    invoke-interface {v13, v9}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    :goto_22
    add-int/2addr v2, v8

    :goto_23
    if-ge v2, v12, :cond_3c

    .line 119
    invoke-static {v15, v2, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v8

    iget v9, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v9, :cond_3c

    .line 120
    invoke-static {v15, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v8, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v8, :cond_3b

    if-nez v8, :cond_3a

    .line 121
    invoke-interface {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_23

    :cond_3a
    new-instance v9, Ljava/lang/String;

    .line 122
    sget-object v14, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v9, v15, v2, v8, v14}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    .line 123
    invoke-interface {v13, v9}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_22

    .line 120
    :cond_3b
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 311
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 312
    throw v0

    :cond_3c
    move v8, v0

    move v0, v2

    move-object/from16 v20, v3

    move-object v14, v4

    goto/16 :goto_39

    .line 115
    :cond_3d
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 309
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 310
    throw v0

    :cond_3e
    move-object/from16 v10, v28

    .line 124
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v8, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v8, :cond_45

    if-nez v8, :cond_3f

    .line 125
    invoke-interface {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    move/from16 v27, v0

    goto :goto_24

    :cond_3f
    add-int v9, v2, v8

    .line 126
    invoke-static {v15, v2, v9}, Lcom/google/android/gms/internal/play_billing/zzix;->zzb([BII)Z

    move-result v14

    if-eqz v14, :cond_44

    .line 316
    new-instance v14, Ljava/lang/String;

    move/from16 v27, v0

    .line 127
    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v14, v15, v2, v8, v0}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    .line 128
    invoke-interface {v13, v14}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    move v2, v9

    :goto_24
    if-ge v2, v12, :cond_43

    .line 129
    invoke-static {v15, v2, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v8, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v8, :cond_43

    .line 130
    invoke-static {v15, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v0, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v0, :cond_42

    if-nez v0, :cond_40

    .line 131
    invoke-interface {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_24

    :cond_40
    add-int v8, v2, v0

    .line 132
    invoke-static {v15, v2, v8}, Lcom/google/android/gms/internal/play_billing/zzix;->zzb([BII)Z

    move-result v9

    if-eqz v9, :cond_41

    .line 320
    new-instance v9, Ljava/lang/String;

    .line 133
    sget-object v14, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v9, v15, v2, v0, v14}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    .line 134
    invoke-interface {v13, v9}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    move v2, v8

    goto :goto_24

    .line 132
    :cond_41
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    move-object/from16 v1, v30

    .line 319
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 320
    throw v0

    .line 130
    :cond_42
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 317
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 318
    throw v0

    :cond_43
    move v0, v2

    goto/16 :goto_2d

    :cond_44
    move-object/from16 v1, v30

    .line 126
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 315
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 316
    throw v0

    .line 124
    :cond_45
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 313
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 314
    throw v0

    :cond_46
    move v8, v0

    move-object/from16 v20, v3

    move-object v14, v4

    :goto_25
    move v10, v5

    goto/16 :goto_3b

    :pswitch_13
    move-object v4, v0

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v3, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    move/from16 v27, v10

    if-ne v2, v0, :cond_4c

    .line 135
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 136
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzew;

    .line 137
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_4b

    .line 138
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_4a

    add-int/2addr v2, v0

    :goto_26
    if-ge v0, v2, :cond_48

    .line 139
    invoke-static {v15, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    move/from16 p3, v0

    iget-wide v0, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    cmp-long v0, v0, v25

    if-eqz v0, :cond_47

    const/4 v10, 0x1

    goto :goto_27

    :cond_47
    move/from16 v10, v21

    .line 140
    :goto_27
    invoke-virtual {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzew;->zze(Z)V

    move/from16 v0, p3

    goto :goto_26

    :cond_48
    if-ne v0, v2, :cond_49

    goto/16 :goto_2d

    .line 300
    :cond_49
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 325
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 326
    throw v0

    .line 138
    :cond_4a
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 323
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 324
    throw v0

    .line 137
    :cond_4b
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 321
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 322
    throw v0

    :cond_4c
    if-nez v2, :cond_55

    .line 141
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 142
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzew;

    .line 143
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    cmp-long v1, v1, v25

    if-eqz v1, :cond_4d

    const/4 v10, 0x1

    goto :goto_28

    :cond_4d
    move/from16 v10, v21

    .line 144
    :goto_28
    invoke-virtual {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzew;->zze(Z)V

    :goto_29
    if-ge v0, v12, :cond_54

    .line 145
    invoke-static {v15, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_54

    .line 146
    invoke-static {v15, v1, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    cmp-long v1, v1, v25

    if-eqz v1, :cond_4e

    const/4 v10, 0x1

    goto :goto_2a

    :cond_4e
    move/from16 v10, v21

    .line 147
    :goto_2a
    invoke-virtual {v13, v10}, Lcom/google/android/gms/internal/play_billing/zzew;->zze(Z)V

    goto :goto_29

    :pswitch_14
    move-object v4, v0

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v3, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    move/from16 v27, v10

    if-ne v2, v0, :cond_53

    .line 148
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 149
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzgh;

    .line 150
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_52

    .line 151
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_51

    add-int v1, v0, v2

    .line 152
    invoke-virtual {v13}, Lcom/google/android/gms/internal/play_billing/zzgh;->size()I

    move-result v8

    shr-int/lit8 v2, v2, 0x2

    add-int/2addr v8, v2

    invoke-virtual {v13, v8}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzi(I)V

    :goto_2b
    if-ge v0, v1, :cond_4f

    .line 153
    invoke-static {v15, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v2

    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    add-int/lit8 v0, v0, 0x4

    goto :goto_2b

    :cond_4f
    if-ne v0, v1, :cond_50

    goto :goto_2d

    .line 326
    :cond_50
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 331
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 332
    throw v0

    .line 151
    :cond_51
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 329
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 330
    throw v0

    .line 150
    :cond_52
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 327
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 328
    throw v0

    :cond_53
    const/4 v0, 0x5

    if-ne v2, v0, :cond_55

    add-int/lit8 v0, v11, 0x4

    .line 154
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 155
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzgh;

    .line 156
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v1

    invoke-virtual {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    :goto_2c
    if-ge v0, v12, :cond_54

    .line 157
    invoke-static {v15, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_54

    .line 158
    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v0

    invoke-virtual {v13, v0}, Lcom/google/android/gms/internal/play_billing/zzgh;->zzh(I)V

    add-int/lit8 v0, v1, 0x4

    goto :goto_2c

    :cond_54
    :goto_2d
    move-object/from16 v20, v3

    goto/16 :goto_31

    :cond_55
    move-object/from16 v20, v3

    goto/16 :goto_30

    :pswitch_15
    move-object v4, v0

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v3, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    move/from16 v27, v10

    if-ne v2, v0, :cond_5a

    .line 159
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 160
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 161
    invoke-static {v15, v11, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_59

    .line 162
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_58

    add-int v1, v0, v2

    .line 163
    invoke-virtual {v13}, Lcom/google/android/gms/internal/play_billing/zzha;->size()I

    move-result v8

    shr-int/lit8 v2, v2, 0x3

    add-int/2addr v8, v2

    invoke-virtual {v13, v8}, Lcom/google/android/gms/internal/play_billing/zzha;->zzg(I)V

    :goto_2e
    if-ge v0, v1, :cond_56

    move-object/from16 v20, v3

    .line 164
    invoke-static {v15, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v2

    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    add-int/lit8 v0, v0, 0x8

    move-object/from16 v3, v20

    goto :goto_2e

    :cond_56
    move-object/from16 v20, v3

    if-ne v0, v1, :cond_57

    goto :goto_31

    .line 332
    :cond_57
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 337
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 338
    throw v0

    .line 162
    :cond_58
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 335
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 336
    throw v0

    .line 161
    :cond_59
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 333
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 334
    throw v0

    :cond_5a
    move-object/from16 v20, v3

    const/4 v0, 0x1

    if-ne v2, v0, :cond_5b

    add-int/lit8 v0, v11, 0x8

    .line 165
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 166
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 167
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v1

    invoke-virtual {v13, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    :goto_2f
    if-ge v0, v12, :cond_5c

    .line 168
    invoke-static {v15, v0, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v4, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_5c

    .line 169
    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v2

    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    add-int/lit8 v0, v1, 0x8

    goto :goto_2f

    :cond_5b
    :goto_30
    move-object v14, v4

    move v10, v5

    move/from16 v8, v27

    goto/16 :goto_3b

    :pswitch_16
    move-object v4, v0

    move-object/from16 v34, v12

    move/from16 v7, v18

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    move/from16 v27, v10

    if-ne v2, v0, :cond_5d

    .line 170
    invoke-static {v15, v11, v13, v4}, Lcom/google/android/gms/internal/play_billing/zzev;->zzf([BILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    :cond_5c
    :goto_31
    move-object v14, v4

    move v10, v5

    move/from16 v8, v27

    goto/16 :goto_3c

    :cond_5d
    if-nez v2, :cond_5e

    move/from16 v8, v27

    move v0, v7

    move-object/from16 v1, p2

    move v2, v11

    move-object/from16 v10, v20

    move/from16 v3, p4

    move-object v14, v4

    move-object v4, v13

    move v9, v5

    move-object/from16 v5, p6

    .line 171
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzk(I[BIILcom/google/android/gms/internal/play_billing/zzgl;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    move v10, v9

    goto/16 :goto_3c

    :cond_5e
    move-object v14, v4

    move/from16 v8, v27

    goto/16 :goto_25

    :pswitch_17
    move-object v14, v0

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v10, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_63

    .line 172
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 173
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 174
    invoke-static {v15, v11, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_62

    .line 175
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_61

    add-int/2addr v2, v0

    :goto_32
    if-ge v0, v2, :cond_5f

    .line 176
    invoke-static {v15, v0, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v3, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 177
    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    goto :goto_32

    :cond_5f
    if-ne v0, v2, :cond_60

    goto/16 :goto_38

    .line 338
    :cond_60
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 343
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 344
    throw v0

    .line 175
    :cond_61
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 341
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 342
    throw v0

    .line 174
    :cond_62
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 339
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 340
    throw v0

    :cond_63
    if-nez v2, :cond_6f

    .line 178
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 179
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzha;

    .line 180
    invoke-static {v15, v11, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 181
    invoke-virtual {v13, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    :goto_33
    if-ge v0, v12, :cond_6e

    .line 182
    invoke-static {v15, v0, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_6e

    .line 183
    invoke-static {v15, v1, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 184
    invoke-virtual {v13, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzha;->zzf(J)V

    goto :goto_33

    :pswitch_18
    move-object v14, v0

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v10, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_68

    .line 185
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 186
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzga;

    .line 187
    invoke-static {v15, v11, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_67

    .line 188
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_66

    add-int v1, v0, v2

    .line 189
    invoke-virtual {v13}, Lcom/google/android/gms/internal/play_billing/zzga;->size()I

    move-result v3

    shr-int/lit8 v2, v2, 0x2

    add-int/2addr v3, v2

    invoke-virtual {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzga;->zzg(I)V

    :goto_34
    if-ge v0, v1, :cond_64

    .line 190
    invoke-static {v15, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    .line 191
    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzga;->zzf(F)V

    add-int/lit8 v0, v0, 0x4

    goto :goto_34

    :cond_64
    if-ne v0, v1, :cond_65

    goto/16 :goto_38

    .line 4
    :cond_65
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 349
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 350
    throw v0

    .line 188
    :cond_66
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 347
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 348
    throw v0

    .line 187
    :cond_67
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 345
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 346
    throw v0

    :cond_68
    const/4 v0, 0x5

    if-ne v2, v0, :cond_6f

    add-int/lit8 v0, v11, 0x4

    .line 192
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 193
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzga;

    .line 194
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v1

    .line 195
    invoke-virtual {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzga;->zzf(F)V

    :goto_35
    if-ge v0, v12, :cond_6e

    .line 196
    invoke-static {v15, v0, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_6e

    .line 197
    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v0

    .line 198
    invoke-virtual {v13, v0}, Lcom/google/android/gms/internal/play_billing/zzga;->zzf(F)V

    add-int/lit8 v0, v1, 0x4

    goto :goto_35

    :pswitch_19
    move-object v14, v0

    move v8, v10

    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v10, v20

    const/4 v0, 0x2

    move v12, v5

    move/from16 v5, v27

    if-ne v2, v0, :cond_6d

    .line 199
    sget v0, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 200
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfq;

    .line 201
    invoke-static {v15, v11, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v2, :cond_6c

    .line 202
    array-length v1, v15

    sub-int/2addr v1, v0

    if-gt v2, v1, :cond_6b

    add-int v1, v0, v2

    .line 203
    invoke-virtual {v13}, Lcom/google/android/gms/internal/play_billing/zzfq;->size()I

    move-result v3

    shr-int/lit8 v2, v2, 0x3

    add-int/2addr v3, v2

    invoke-virtual {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzfq;->zzg(I)V

    :goto_36
    if-ge v0, v1, :cond_69

    .line 204
    invoke-static {v15, v0}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    .line 205
    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfq;->zzf(D)V

    add-int/lit8 v0, v0, 0x8

    goto :goto_36

    :cond_69
    if-ne v0, v1, :cond_6a

    goto :goto_38

    .line 373
    :cond_6a
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 355
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 356
    throw v0

    .line 202
    :cond_6b
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 353
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 354
    throw v0

    .line 201
    :cond_6c
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 351
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 352
    throw v0

    :cond_6d
    const/4 v0, 0x1

    if-ne v2, v0, :cond_6f

    add-int/lit8 v0, v11, 0x8

    .line 206
    sget v1, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 207
    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfq;

    .line 208
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v1

    .line 209
    invoke-virtual {v13, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfq;->zzf(D)V

    :goto_37
    if-ge v0, v12, :cond_6e

    .line 210
    invoke-static {v15, v0, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v1

    iget v2, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v2, :cond_6e

    .line 211
    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    .line 212
    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfq;->zzf(D)V

    add-int/lit8 v0, v1, 0x8

    goto :goto_37

    :cond_6e
    :goto_38
    move-object/from16 v20, v10

    :goto_39
    move v10, v5

    goto :goto_3c

    :goto_3a
    if-ge v0, v12, :cond_70

    .line 61
    invoke-static {v15, v0, v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v1, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ne v7, v1, :cond_70

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    move/from16 v3, p4

    move v4, v9

    move-object/from16 v5, p6

    .line 62
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzc(Lcom/google/android/gms/internal/play_billing/zzhw;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-object v1, v14, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    .line 63
    invoke-interface {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->add(Ljava/lang/Object;)Z

    goto :goto_3a

    :cond_6f
    move-object/from16 v20, v10

    goto/16 :goto_25

    :goto_3b
    move v0, v11

    :cond_70
    :goto_3c
    if-eq v0, v11, :cond_71

    move/from16 v13, p5

    move v3, v7

    move v1, v8

    move v2, v10

    move/from16 v5, v16

    move/from16 v4, v22

    move-object/from16 v11, v34

    move-object/from16 v7, p1

    move-object/from16 v37, v14

    move v14, v12

    move-object/from16 v12, v37

    goto/16 :goto_0

    :cond_71
    move/from16 v6, p5

    move v2, v0

    move v4, v7

    move v12, v8

    move-object v5, v14

    move-object/from16 v8, v34

    move-object/from16 v7, p1

    goto/16 :goto_4f

    :cond_72
    move-object/from16 v34, v12

    move/from16 v7, v18

    move-object/from16 v1, v30

    move v12, v5

    move-object v5, v0

    move-object/from16 v0, v28

    move/from16 v37, v27

    move/from16 v27, v10

    move/from16 v10, v37

    const/16 v4, 0x32

    if-ne v8, v4, :cond_7e

    const/4 v4, 0x2

    if-ne v2, v4, :cond_7d

    .line 213
    invoke-direct {v6, v10}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzv(I)Ljava/lang/Object;

    move-result-object v0

    move v4, v7

    move-object/from16 v8, v34

    move-object/from16 v7, p1

    .line 214
    invoke-virtual {v8, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    .line 215
    move-object v2, v1

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzhg;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzhg;->zze()Z

    move-result v2

    if-nez v2, :cond_73

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhg;->zza()Lcom/google/android/gms/internal/play_billing/zzhg;

    move-result-object v2

    .line 216
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzhg;->zzb()Lcom/google/android/gms/internal/play_billing/zzhg;

    move-result-object v2

    .line 217
    invoke-static {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzhh;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    invoke-virtual {v8, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v1, v2

    .line 219
    :cond_73
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhf;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v13

    .line 220
    move-object v14, v1

    check-cast v14, Lcom/google/android/gms/internal/play_billing/zzhg;

    .line 221
    invoke-static {v15, v11, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-ltz v1, :cond_7c

    sub-int v2, v12, v0

    if-gt v1, v2, :cond_7c

    add-int v9, v0, v1

    .line 358
    iget-object v1, v13, Lcom/google/android/gms/internal/play_billing/zzhe;->zzb:Ljava/lang/Object;

    iget-object v3, v13, Lcom/google/android/gms/internal/play_billing/zzhe;->zzd:Ljava/lang/Object;

    move-object v2, v1

    move-object v1, v3

    :goto_3d
    if-ge v0, v9, :cond_79

    move-object/from16 p3, v1

    add-int/lit8 v1, v0, 0x1

    .line 222
    aget-byte v0, v15, v0

    if-gez v0, :cond_74

    .line 223
    invoke-static {v0, v15, v1, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzj(I[BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    move/from16 v37, v1

    move v1, v0

    move/from16 v0, v37

    :cond_74
    move-object/from16 v18, v2

    ushr-int/lit8 v2, v0, 0x3

    move/from16 v23, v4

    and-int/lit8 v4, v0, 0x7

    const/4 v5, 0x1

    if-eq v2, v5, :cond_78

    const/4 v5, 0x2

    if-eq v2, v5, :cond_77

    :cond_75
    move-object/from16 v7, p6

    move-object/from16 v34, v8

    move-object/from16 v8, v18

    move-object/from16 v6, v20

    move/from16 v36, v23

    move/from16 v35, v27

    move-object/from16 v18, v3

    :cond_76
    move-object/from16 v3, p3

    goto/16 :goto_3e

    .line 229
    :cond_77
    iget-object v5, v13, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc:Lcom/google/android/gms/internal/play_billing/zzjb;

    .line 224
    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzjb;->zza()I

    move-result v2

    if-ne v4, v2, :cond_75

    .line 225
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    move-object/from16 v2, v20

    move-object/from16 v0, p2

    move-object v6, v2

    move-object/from16 v34, v8

    move-object/from16 v8, v18

    move/from16 v2, p4

    move-object/from16 v18, v3

    move-object v3, v5

    move/from16 v5, v23

    move/from16 v35, v27

    move-object/from16 v7, p6

    move/from16 v36, v5

    move-object/from16 v5, p6

    .line 226
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzO([BIILcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-object v1, v7, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    move-object/from16 v20, v6

    move-object v5, v7

    move-object v2, v8

    move-object/from16 v3, v18

    move-object/from16 v8, v34

    goto :goto_40

    :cond_78
    move-object/from16 v7, p6

    move-object/from16 v34, v8

    move-object/from16 v8, v18

    move-object/from16 v6, v20

    move/from16 v36, v23

    move/from16 v35, v27

    move-object/from16 v18, v3

    iget-object v3, v13, Lcom/google/android/gms/internal/play_billing/zzhe;->zza:Lcom/google/android/gms/internal/play_billing/zzjb;

    .line 227
    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzjb;->zza()I

    move-result v2

    if-ne v4, v2, :cond_76

    const/4 v4, 0x0

    move-object/from16 v0, p2

    move-object/from16 v8, p3

    move/from16 v2, p4

    move-object/from16 v5, p6

    .line 228
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzO([BIILcom/google/android/gms/internal/play_billing/zzjb;Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-object v2, v7, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    move-object/from16 v20, v6

    move-object v5, v7

    move-object v1, v8

    goto :goto_3f

    .line 229
    :goto_3e
    invoke-static {v0, v15, v1, v12, v7}, Lcom/google/android/gms/internal/play_billing/zzev;->zzo(I[BIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    move-object v1, v3

    move-object/from16 v20, v6

    move-object v5, v7

    move-object v2, v8

    :goto_3f
    move-object/from16 v3, v18

    move-object/from16 v8, v34

    move/from16 v27, v35

    :goto_40
    move/from16 v4, v36

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    goto/16 :goto_3d

    :cond_79
    move-object v3, v1

    move/from16 v36, v4

    move-object v7, v5

    move-object/from16 v34, v8

    move-object/from16 v6, v20

    move/from16 v35, v27

    move-object v8, v2

    if-ne v0, v9, :cond_7b

    .line 230
    invoke-interface {v14, v8, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-eq v9, v11, :cond_7a

    move-object/from16 v6, p0

    move/from16 v13, p5

    move v0, v9

    move v2, v10

    move v14, v12

    move/from16 v5, v16

    move/from16 v4, v22

    move-object/from16 v11, v34

    move/from16 v1, v35

    move/from16 v3, v36

    move-object v12, v7

    move-object/from16 v7, p1

    goto/16 :goto_0

    :cond_7a
    move-object/from16 v20, v6

    move-object v5, v7

    move v2, v9

    goto :goto_42

    .line 228
    :cond_7b
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 359
    invoke-direct {v0, v6}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 360
    throw v0

    .line 221
    :cond_7c
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 357
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 358
    throw v0

    :cond_7d
    move/from16 v36, v7

    move-object/from16 v6, v20

    move/from16 v35, v27

    move-object v7, v5

    :goto_41
    move-object/from16 v20, v6

    move-object v5, v7

    move v2, v11

    :goto_42
    move-object/from16 v8, v34

    move/from16 v12, v35

    move/from16 v4, v36

    move-object/from16 v7, p1

    move/from16 v6, p5

    goto/16 :goto_4f

    :cond_7e
    move/from16 v36, v7

    move-object/from16 v6, v20

    move/from16 v35, v27

    move-object v7, v5

    move-object/from16 v5, v34

    add-int/lit8 v4, v10, 0x2

    .line 231
    aget v4, v24, v4

    const v9, 0xfffff

    and-int/2addr v4, v9

    move/from16 v18, v10

    int-to-long v9, v4

    packed-switch v8, :pswitch_data_2

    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    move-object/from16 v7, p1

    goto/16 :goto_4d

    :pswitch_1a
    const/4 v4, 0x3

    if-ne v2, v4, :cond_7f

    move/from16 v4, v36

    and-int/lit8 v0, v4, -0x8

    or-int/lit8 v13, v0, 0x4

    move-object v2, v6

    move-object v3, v7

    move/from16 v0, v18

    move/from16 v1, v35

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    .line 232
    invoke-direct {v6, v7, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzx(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v14

    .line 233
    invoke-direct {v6, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v9

    move-object v8, v14

    const v10, 0xfffff

    move-object/from16 v10, p2

    move/from16 v24, v11

    move/from16 v12, p4

    move-object/from16 v20, v2

    move-object v2, v14

    move-object/from16 v14, p6

    .line 234
    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzev;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v8

    .line 235
    invoke-direct {v6, v7, v1, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzF(Ljava/lang/Object;IILjava/lang/Object;)V

    move v12, v1

    move v0, v8

    goto/16 :goto_46

    :cond_7f
    move-object/from16 v20, v6

    move-object v3, v7

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object v8, v5

    move/from16 v12, v35

    move/from16 v4, v36

    goto/16 :goto_49

    :pswitch_1b
    move-object v8, v6

    move-object v3, v7

    move/from16 v24, v11

    move/from16 v0, v18

    move/from16 v1, v35

    move/from16 v4, v36

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    if-nez v2, :cond_80

    move/from16 v11, v24

    .line 236
    invoke-static {v15, v11, v3}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget-wide v11, v3, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 237
    invoke-static {v11, v12}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzc(J)J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    invoke-virtual {v5, v7, v13, v14, v11}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 238
    invoke-virtual {v5, v7, v9, v10, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move/from16 v18, v0

    move v12, v1

    move v0, v2

    move-object/from16 v20, v8

    move/from16 v11, v24

    goto/16 :goto_46

    :cond_80
    move/from16 v18, v0

    move v12, v1

    move-object/from16 v20, v8

    move/from16 v11, v24

    goto/16 :goto_48

    :pswitch_1c
    move-object v8, v6

    move-object v3, v7

    move/from16 v24, v11

    move/from16 v0, v18

    move/from16 v1, v35

    move/from16 v4, v36

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    if-nez v2, :cond_81

    move/from16 v11, v24

    .line 239
    invoke-static {v15, v11, v3}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v12, v3, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 240
    invoke-static {v12}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzb(I)I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v5, v7, v13, v14, v12}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 241
    invoke-virtual {v5, v7, v9, v10, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_45

    :cond_81
    move/from16 v11, v24

    goto/16 :goto_47

    :pswitch_1d
    move-object v8, v6

    move-object v3, v7

    move/from16 v0, v18

    move/from16 v1, v35

    move/from16 v4, v36

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    if-nez v2, :cond_84

    .line 242
    invoke-static {v15, v11, v3}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v12, v3, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    move/from16 p3, v2

    .line 243
    invoke-direct {v6, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzs(I)Lcom/google/android/gms/internal/play_billing/zzgj;

    move-result-object v2

    if-eqz v2, :cond_83

    invoke-interface {v2, v12}, Lcom/google/android/gms/internal/play_billing/zzgj;->zza(I)Z

    move-result v2

    if-eqz v2, :cond_82

    goto :goto_43

    .line 246
    :cond_82
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v2

    int-to-long v9, v12

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v2, v4, v9}, Lcom/google/android/gms/internal/play_billing/zzim;->zzj(ILjava/lang/Object;)V

    goto :goto_44

    .line 244
    :cond_83
    :goto_43
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v5, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 245
    invoke-virtual {v5, v7, v9, v10, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :goto_44
    move/from16 v18, v0

    move v12, v1

    move-object/from16 v20, v8

    move/from16 v0, p3

    goto :goto_46

    :pswitch_1e
    move-object v8, v6

    move-object v3, v7

    move/from16 v0, v18

    move/from16 v1, v35

    move/from16 v4, v36

    const/4 v12, 0x2

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    if-ne v2, v12, :cond_84

    .line 247
    invoke-static {v15, v11, v3}, Lcom/google/android/gms/internal/play_billing/zzev;->zza([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget-object v12, v3, Lcom/google/android/gms/internal/play_billing/zzeu;->zzc:Ljava/lang/Object;

    .line 248
    invoke-virtual {v5, v7, v13, v14, v12}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 249
    invoke-virtual {v5, v7, v9, v10, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :goto_45
    move/from16 v18, v0

    move v12, v1

    move v0, v2

    move-object/from16 v20, v8

    :goto_46
    move-object v8, v5

    move-object v5, v3

    goto/16 :goto_4e

    :cond_84
    :goto_47
    move/from16 v18, v0

    move v12, v1

    move-object/from16 v20, v8

    :goto_48
    move-object v8, v5

    goto :goto_49

    :pswitch_1f
    move-object v8, v6

    move-object v3, v7

    move/from16 v0, v18

    move/from16 v1, v35

    move/from16 v4, v36

    const/4 v12, 0x2

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    if-ne v2, v12, :cond_85

    .line 250
    invoke-direct {v6, v7, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzx(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v9

    .line 251
    invoke-direct {v6, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    move v12, v0

    move-object v0, v9

    move v10, v1

    move-object v1, v2

    move-object/from16 v2, p2

    move-object v13, v3

    move v3, v11

    move v14, v4

    move/from16 v4, p4

    move-object/from16 v20, v8

    move-object v8, v5

    move-object/from16 v5, p6

    .line 252
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzn(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;[BIILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    .line 253
    invoke-direct {v6, v7, v10, v12, v9}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzF(Ljava/lang/Object;IILjava/lang/Object;)V

    move/from16 v18, v12

    move-object v5, v13

    move v4, v14

    move v12, v10

    goto/16 :goto_4e

    :cond_85
    move-object/from16 v20, v8

    move-object v8, v5

    move/from16 v18, v0

    move v12, v1

    :goto_49
    move-object v5, v3

    goto/16 :goto_4d

    :pswitch_20
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    const/4 v6, 0x2

    move-object/from16 v7, p1

    if-ne v2, v6, :cond_8a

    .line 254
    invoke-static {v15, v11, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v2

    iget v6, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    if-nez v6, :cond_86

    .line 255
    invoke-virtual {v8, v7, v13, v14, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_4b

    :cond_86
    and-int v0, v3, v23

    add-int v3, v2, v6

    if-eqz v0, :cond_88

    .line 256
    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzix;->zzb([BII)Z

    move-result v0

    if-eqz v0, :cond_87

    goto :goto_4a

    :cond_87
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 361
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 362
    throw v0

    :cond_88
    :goto_4a
    new-instance v0, Ljava/lang/String;

    .line 257
    sget-object v1, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, v15, v2, v6, v1}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    .line 258
    invoke-virtual {v8, v7, v13, v14, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move v2, v3

    .line 259
    :goto_4b
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move v0, v2

    goto/16 :goto_4e

    :pswitch_21
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    move-object/from16 v7, p1

    if-nez v2, :cond_8a

    .line 260
    invoke-static {v15, v11, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    cmp-long v1, v1, v25

    if-eqz v1, :cond_89

    const/16 v29, 0x1

    goto :goto_4c

    :cond_89
    move/from16 v29, v21

    .line 261
    :goto_4c
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 262
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_4e

    :pswitch_22
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    const/4 v0, 0x5

    move-object/from16 v7, p1

    if-ne v2, v0, :cond_8a

    add-int/lit8 v0, v11, 0x4

    .line 263
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 264
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_4e

    :pswitch_23
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    const/4 v0, 0x1

    move-object/from16 v7, p1

    if-ne v2, v0, :cond_8a

    add-int/lit8 v0, v11, 0x8

    .line 265
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 266
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_4e

    :pswitch_24
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    move-object/from16 v7, p1

    if-nez v2, :cond_8a

    .line 267
    invoke-static {v15, v11, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzi([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget v1, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zza:I

    .line 268
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 269
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_4e

    :pswitch_25
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    move-object/from16 v7, p1

    if-nez v2, :cond_8a

    .line 270
    invoke-static {v15, v11, v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzl([BILcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    iget-wide v1, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzb:J

    .line 271
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 272
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_4e

    :pswitch_26
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    const/4 v0, 0x5

    move-object/from16 v7, p1

    if-ne v2, v0, :cond_8a

    add-int/lit8 v0, v11, 0x4

    .line 273
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v1

    .line 274
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 275
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_4e

    :pswitch_27
    move-object v8, v5

    move-object/from16 v20, v6

    move-object v5, v7

    move/from16 v12, v35

    move/from16 v4, v36

    const/4 v0, 0x1

    move-object/from16 v7, p1

    if-ne v2, v0, :cond_8a

    add-int/lit8 v0, v11, 0x8

    .line 276
    invoke-static {v15, v11}, Lcom/google/android/gms/internal/play_billing/zzev;->zzp([BI)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v1

    .line 277
    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v8, v7, v13, v14, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 278
    invoke-virtual {v8, v7, v9, v10, v12}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_4e

    :cond_8a
    :goto_4d
    move v0, v11

    :goto_4e
    if-eq v0, v11, :cond_8b

    move-object/from16 v6, p0

    move/from16 v14, p4

    move/from16 v13, p5

    move v3, v4

    move-object v11, v8

    move v1, v12

    move/from16 v2, v18

    move/from16 v4, v22

    move-object v12, v5

    move/from16 v5, v16

    goto/16 :goto_0

    :cond_8b
    move/from16 v6, p5

    move v2, v0

    move/from16 v10, v18

    :goto_4f
    if-ne v4, v6, :cond_8c

    if-eqz v6, :cond_8c

    const v0, 0xfffff

    move-object/from16 v9, p0

    move v10, v2

    move v11, v4

    move/from16 v5, v16

    move/from16 v4, v22

    goto/16 :goto_51

    :cond_8c
    move-object/from16 v9, p0

    .line 371
    iget-boolean v0, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_8e

    iget-object v0, v5, Lcom/google/android/gms/internal/play_billing/zzeu;->zzd:Lcom/google/android/gms/internal/play_billing/zzft;

    .line 279
    sget v1, Lcom/google/android/gms/internal/play_billing/zzft;->zzb:I

    .line 280
    sget v1, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzft;->zza:Lcom/google/android/gms/internal/play_billing/zzft;

    if-eq v0, v1, :cond_8e

    iget-object v1, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzg:Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 281
    sget v3, Lcom/google/android/gms/internal/play_billing/zzev;->zza:I

    .line 282
    invoke-virtual {v0, v1, v12}, Lcom/google/android/gms/internal/play_billing/zzft;->zza(Lcom/google/android/gms/internal/play_billing/zzhm;I)Lcom/google/android/gms/internal/play_billing/zzgf;

    move-result-object v0

    if-nez v0, :cond_8d

    .line 283
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v11

    move v0, v4

    move-object/from16 v1, p2

    move/from16 v3, p4

    move v13, v4

    move-object v4, v11

    move-object/from16 v5, p6

    .line 284
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzh(I[BIILcom/google/android/gms/internal/play_billing/zzim;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    goto :goto_50

    .line 372
    :cond_8d
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgd;

    .line 373
    throw v17

    :cond_8e
    move v13, v4

    .line 285
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v4

    move v0, v13

    move-object/from16 v1, p2

    move/from16 v3, p4

    move-object/from16 v5, p6

    .line 286
    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzev;->zzh(I[BIILcom/google/android/gms/internal/play_billing/zzim;Lcom/google/android/gms/internal/play_billing/zzeu;)I

    move-result v0

    :goto_50
    move/from16 v14, p4

    move-object v11, v8

    move v2, v10

    move v1, v12

    move v3, v13

    move/from16 v5, v16

    move/from16 v4, v22

    move-object/from16 v12, p6

    move v13, v6

    move-object v6, v9

    goto/16 :goto_0

    :cond_8f
    move/from16 v22, v4

    move/from16 v16, v5

    move-object v9, v6

    move-object/from16 v20, v8

    move-object v8, v11

    move v6, v13

    move v10, v0

    move v11, v3

    const v0, 0xfffff

    :goto_51
    if-eq v5, v0, :cond_90

    int-to-long v0, v5

    .line 363
    invoke-virtual {v8, v7, v0, v1, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_90
    iget v0, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzj:I

    move v8, v0

    move-object/from16 v3, v17

    :goto_52
    iget v0, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzk:I

    if-ge v8, v0, :cond_91

    iget-object v0, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzi:[I

    iget-object v4, v9, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl:Lcom/google/android/gms/internal/play_billing/zzil;

    .line 364
    aget v2, v0, v8

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v5, p1

    .line 365
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzu(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzil;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzim;

    add-int/lit8 v8, v8, 0x1

    goto :goto_52

    :cond_91
    if-eqz v3, :cond_92

    .line 366
    move-object v0, v3

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzim;

    .line 367
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iput-object v3, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    :cond_92
    if-nez v6, :cond_94

    move/from16 v0, p4

    if-ne v10, v0, :cond_93

    goto :goto_53

    :cond_93
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    move-object/from16 v1, v20

    .line 368
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 369
    throw v0

    :cond_94
    move/from16 v0, p4

    move-object/from16 v1, v20

    if-gt v10, v0, :cond_95

    if-ne v11, v6, :cond_95

    :goto_53
    return v10

    :cond_95
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgs;

    .line 370
    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgs;-><init>(Ljava/lang/String;)V

    .line 371
    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_9
        :pswitch_2
        :pswitch_7
        :pswitch_8
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x12
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_16
        :pswitch_f
        :pswitch_14
        :pswitch_15
        :pswitch_e
        :pswitch_d
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_16
        :pswitch_f
        :pswitch_14
        :pswitch_15
        :pswitch_e
        :pswitch_d
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x33
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_24
        :pswitch_1d
        :pswitch_22
        :pswitch_23
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
    .end packed-switch
.end method

.method public final zze()Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzg:Lcom/google/android/gms/internal/play_billing/zzhm;

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzs()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    return-object v0
.end method

.method public final zzf(Ljava/lang/Object;)V
    .locals 7

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzK(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_2

    :cond_0
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzgg;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 2
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    const v2, 0x7fffffff

    .line 3
    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzC(I)V

    iput v1, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zza:I

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzA()V

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_5

    .line 5
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    const v3, 0xfffff

    and-int/2addr v3, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v2

    int-to-long v3, v3

    const/16 v5, 0x9

    if-eq v2, v5, :cond_3

    const/16 v5, 0x3c

    if-eq v2, v5, :cond_2

    const/16 v5, 0x44

    if-eq v2, v5, :cond_2

    packed-switch v2, :pswitch_data_0

    goto :goto_1

    .line 10
    :pswitch_0
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    .line 11
    invoke-virtual {v2, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 12
    move-object v6, v5

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzhg;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzhg;->zzc()V

    .line 13
    invoke-virtual {v2, p1, v3, v4, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_1

    .line 6
    :pswitch_1
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 7
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzb()V

    goto :goto_1

    .line 8
    :cond_2
    aget v2, v0, v1

    .line 9
    invoke-direct {p0, p1, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 10
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v5, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzf(Ljava/lang/Object;)V

    goto :goto_1

    .line 14
    :cond_3
    :pswitch_2
    invoke-direct {p0, p1, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 15
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v5, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzf(Ljava/lang/Object;)V

    :cond_4
    :goto_1
    add-int/lit8 v1, v1, 0x3

    goto :goto_0

    :cond_5
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl:Lcom/google/android/gms/internal/play_billing/zzil;

    .line 16
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzil;->zzb(Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm:Lcom/google/android/gms/internal/play_billing/zzfu;

    .line 17
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzfu;->zza(Ljava/lang/Object;)V

    :cond_6
    :goto_2
    return-void

    :pswitch_data_0
    .packed-switch 0x11
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zzg(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 8

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzz(Ljava/lang/Object;)V

    .line 2
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    array-length v2, v1

    if-ge v0, v2, :cond_4

    .line 3
    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    const v3, 0xfffff

    and-int/2addr v3, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v2

    .line 4
    aget v1, v1, v0

    int-to-long v3, v3

    packed-switch v2, :pswitch_data_0

    goto/16 :goto_2

    .line 13
    :pswitch_0
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzB(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 14
    :pswitch_1
    invoke-direct {p0, p2, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 15
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p1, v3, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 16
    invoke-direct {p0, p1, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzD(Ljava/lang/Object;II)V

    goto/16 :goto_2

    .line 17
    :pswitch_2
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzB(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 18
    :pswitch_3
    invoke-direct {p0, p2, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 19
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p1, v3, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 20
    invoke-direct {p0, p1, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzD(Ljava/lang/Object;II)V

    goto/16 :goto_2

    .line 21
    :pswitch_4
    sget v1, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    .line 22
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 23
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhh;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 24
    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_2

    .line 5
    :pswitch_5
    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 6
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzgl;

    .line 7
    invoke-interface {v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->size()I

    move-result v5

    .line 8
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->size()I

    move-result v6

    if-lez v5, :cond_1

    if-lez v6, :cond_1

    .line 9
    invoke-interface {v1}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()Z

    move-result v7

    if-nez v7, :cond_0

    add-int/2addr v6, v5

    .line 10
    invoke-interface {v1, v6}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzgl;

    move-result-object v1

    .line 11
    :cond_0
    invoke-interface {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgl;->addAll(Ljava/util/Collection;)Z

    :cond_1
    if-gtz v5, :cond_2

    goto :goto_1

    :cond_2
    move-object v2, v1

    .line 12
    :goto_1
    invoke-static {p1, v3, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_2

    .line 25
    :pswitch_6
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzA(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 26
    :pswitch_7
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 27
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzr(Ljava/lang/Object;JJ)V

    .line 28
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 29
    :pswitch_8
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 30
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 31
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 32
    :pswitch_9
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 33
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzr(Ljava/lang/Object;JJ)V

    .line 34
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 35
    :pswitch_a
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 36
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 37
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 38
    :pswitch_b
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 39
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 40
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 41
    :pswitch_c
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 42
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 43
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 44
    :pswitch_d
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 45
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 46
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 47
    :pswitch_e
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzA(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 48
    :pswitch_f
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 49
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    .line 50
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 51
    :pswitch_10
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 52
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzm(Ljava/lang/Object;JZ)V

    .line 53
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto/16 :goto_2

    .line 54
    :pswitch_11
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 55
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 56
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 57
    :pswitch_12
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 58
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzr(Ljava/lang/Object;JJ)V

    .line 59
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 60
    :pswitch_13
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 61
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzq(Ljava/lang/Object;JI)V

    .line 62
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 63
    :pswitch_14
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 64
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzr(Ljava/lang/Object;JJ)V

    .line 65
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 66
    :pswitch_15
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 67
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzr(Ljava/lang/Object;JJ)V

    .line 68
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 69
    :pswitch_16
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 70
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result v1

    invoke-static {p1, v3, v4, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzp(Ljava/lang/Object;JF)V

    .line 71
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    goto :goto_2

    .line 72
    :pswitch_17
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzH(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 73
    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide v1

    invoke-static {p1, v3, v4, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzo(Ljava/lang/Object;JD)V

    .line 74
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzC(Ljava/lang/Object;I)V

    :cond_3
    :goto_2
    add-int/lit8 v0, v0, 0x3

    goto/16 :goto_0

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzl:Lcom/google/android/gms/internal/play_billing/zzil;

    .line 75
    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzp(Lcom/google/android/gms/internal/play_billing/zzil;Ljava/lang/Object;Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm:Lcom/google/android/gms/internal/play_billing/zzfu;

    .line 76
    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzo(Lcom/google/android/gms/internal/play_billing/zzfu;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_5
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
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
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zzh(Ljava/lang/Object;[BIILcom/google/android/gms/internal/play_billing/zzeu;)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v6, p5

    .line 1
    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/play_billing/zzeu;)I

    return-void
.end method

.method public final zzi(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjd;)V
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object/from16 v8, p2

    .line 1
    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_0

    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    iget-object v1, v0, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 2
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzid;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 3
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzf()Ljava/util/Iterator;

    move-result-object v0

    .line 4
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    move-object v10, v0

    goto :goto_0

    :cond_0
    const/4 v10, 0x0

    :goto_0
    iget-object v11, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    sget-object v12, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    const v13, 0xfffff

    move v0, v13

    const/4 v1, 0x0

    const/4 v15, 0x0

    :goto_1
    array-length v2, v11

    if-ge v15, v2, :cond_7

    .line 5
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v3

    .line 6
    aget v5, v11, v15

    const/16 v4, 0x11

    const/4 v9, 0x1

    if-gt v3, v4, :cond_3

    add-int/lit8 v4, v15, 0x2

    .line 7
    aget v4, v11, v4

    and-int v14, v4, v13

    if-eq v14, v0, :cond_2

    if-ne v14, v13, :cond_1

    const/4 v0, 0x0

    goto :goto_2

    :cond_1
    int-to-long v0, v14

    .line 8
    invoke-virtual {v12, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_2
    move v1, v0

    move v0, v14

    :cond_2
    ushr-int/lit8 v4, v4, 0x14

    shl-int v4, v9, v4

    move v14, v0

    move/from16 v17, v1

    move/from16 v18, v4

    goto :goto_3

    :cond_3
    move v14, v0

    move/from16 v17, v1

    const/16 v18, 0x0

    :goto_3
    if-nez v10, :cond_6

    and-int v0, v2, v13

    int-to-long v1, v0

    packed-switch v3, :pswitch_data_0

    :cond_4
    :goto_4
    move-object/from16 v16, v10

    goto/16 :goto_7

    .line 117
    :pswitch_0
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 118
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 119
    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzq(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    goto :goto_4

    .line 120
    :pswitch_1
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 121
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzE(IJ)V

    goto :goto_4

    .line 122
    :pswitch_2
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 123
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzC(II)V

    goto :goto_4

    .line 124
    :pswitch_3
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 125
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzA(IJ)V

    goto :goto_4

    .line 126
    :pswitch_4
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 127
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzy(II)V

    goto :goto_4

    .line 128
    :pswitch_5
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 129
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzi(II)V

    goto :goto_4

    .line 130
    :pswitch_6
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 131
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzJ(II)V

    goto :goto_4

    .line 132
    :pswitch_7
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 133
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzd(ILcom/google/android/gms/internal/play_billing/zzfg;)V

    goto :goto_4

    .line 134
    :pswitch_8
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 135
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    .line 136
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzw(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    goto/16 :goto_4

    .line 137
    :pswitch_9
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 138
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v5, v0, v8}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzP(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjd;)V

    goto/16 :goto_4

    .line 139
    :pswitch_a
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 140
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 141
    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzb(IZ)V

    goto/16 :goto_4

    .line 142
    :pswitch_b
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 143
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzk(II)V

    goto/16 :goto_4

    .line 144
    :pswitch_c
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 145
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzm(IJ)V

    goto/16 :goto_4

    .line 146
    :pswitch_d
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 147
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzm(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzr(II)V

    goto/16 :goto_4

    .line 148
    :pswitch_e
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 149
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzL(IJ)V

    goto/16 :goto_4

    .line 150
    :pswitch_f
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 151
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzr(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzt(IJ)V

    goto/16 :goto_4

    .line 152
    :pswitch_10
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 153
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    .line 154
    invoke-interface {v8, v5, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzo(IF)V

    goto/16 :goto_4

    .line 155
    :pswitch_11
    invoke-direct {v6, v7, v5, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 156
    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    .line 157
    invoke-interface {v8, v5, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzf(ID)V

    goto/16 :goto_4

    .line 158
    :pswitch_12
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 159
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzv(I)Ljava/lang/Object;

    move-result-object v1

    .line 160
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhf;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v1

    .line 161
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhg;

    .line 162
    invoke-interface {v8, v5, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzv(ILcom/google/android/gms/internal/play_billing/zzhe;Ljava/util/Map;)V

    goto/16 :goto_4

    .line 110
    :pswitch_13
    aget v0, v11, v15

    .line 111
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 112
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    .line 113
    sget v3, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    if-eqz v1, :cond_4

    .line 114
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    const/4 v3, 0x0

    .line 115
    :goto_5
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_4

    .line 116
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    move-object v5, v8

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzfp;

    invoke-virtual {v5, v0, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzfp;->zzq(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    .line 107
    :pswitch_14
    aget v0, v11, v15

    .line 108
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 109
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzB(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 104
    :pswitch_15
    aget v0, v11, v15

    .line 105
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 106
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzA(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 101
    :pswitch_16
    aget v0, v11, v15

    .line 102
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 103
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzz(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 98
    :pswitch_17
    aget v0, v11, v15

    .line 99
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 100
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzy(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 95
    :pswitch_18
    aget v0, v11, v15

    .line 96
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 97
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzs(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 92
    :pswitch_19
    aget v0, v11, v15

    .line 93
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 94
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzC(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 89
    :pswitch_1a
    aget v0, v11, v15

    .line 90
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 91
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzq(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 86
    :pswitch_1b
    aget v0, v11, v15

    .line 87
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 88
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzt(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 83
    :pswitch_1c
    aget v0, v11, v15

    .line 84
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 85
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzu(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 80
    :pswitch_1d
    aget v0, v11, v15

    .line 81
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 82
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzw(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 77
    :pswitch_1e
    aget v0, v11, v15

    .line 78
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 79
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzD(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 74
    :pswitch_1f
    aget v0, v11, v15

    .line 75
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 76
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzx(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 71
    :pswitch_20
    aget v0, v11, v15

    .line 72
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 73
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzv(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 68
    :pswitch_21
    aget v0, v11, v15

    .line 69
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 70
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzr(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 65
    :pswitch_22
    aget v0, v11, v15

    .line 66
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v3, 0x0

    .line 67
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzB(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_23
    const/4 v3, 0x0

    .line 62
    aget v0, v11, v15

    .line 63
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 64
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzA(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_24
    const/4 v3, 0x0

    .line 59
    aget v0, v11, v15

    .line 60
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 61
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzz(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_25
    const/4 v3, 0x0

    .line 56
    aget v0, v11, v15

    .line 57
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 58
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzy(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_26
    const/4 v3, 0x0

    .line 53
    aget v0, v11, v15

    .line 54
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 55
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzs(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_27
    const/4 v3, 0x0

    .line 50
    aget v0, v11, v15

    .line 51
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 52
    invoke-static {v0, v1, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzC(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    .line 45
    :pswitch_28
    aget v0, v11, v15

    .line 46
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 47
    sget v2, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    if-eqz v1, :cond_4

    .line 48
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 49
    invoke-interface {v8, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zze(ILjava/util/List;)V

    goto/16 :goto_4

    .line 38
    :pswitch_29
    aget v0, v11, v15

    .line 39
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 40
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v2

    .line 41
    sget v3, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    if-eqz v1, :cond_4

    .line 42
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    const/4 v3, 0x0

    .line 43
    :goto_6
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_4

    .line 44
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    move-object v5, v8

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzfp;

    invoke-virtual {v5, v0, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzfp;->zzw(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    .line 33
    :pswitch_2a
    aget v0, v11, v15

    .line 34
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 35
    sget v2, Lcom/google/android/gms/internal/play_billing/zzhx;->zza:I

    if-eqz v1, :cond_4

    .line 36
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 37
    invoke-interface {v8, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzI(ILjava/util/List;)V

    goto/16 :goto_4

    .line 30
    :pswitch_2b
    aget v0, v11, v15

    .line 31
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v9, 0x0

    .line 32
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzq(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_2c
    const/4 v9, 0x0

    .line 27
    aget v0, v11, v15

    .line 28
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 29
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzt(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_2d
    const/4 v9, 0x0

    .line 24
    aget v0, v11, v15

    .line 25
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 26
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzu(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_2e
    const/4 v9, 0x0

    .line 21
    aget v0, v11, v15

    .line 22
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 23
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzw(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_2f
    const/4 v9, 0x0

    .line 18
    aget v0, v11, v15

    .line 19
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 20
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzD(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_30
    const/4 v9, 0x0

    .line 15
    aget v0, v11, v15

    .line 16
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 17
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzx(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_31
    const/4 v9, 0x0

    .line 12
    aget v0, v11, v15

    .line 13
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 14
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzv(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_32
    const/4 v9, 0x0

    .line 9
    aget v0, v11, v15

    .line 10
    invoke-virtual {v12, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 11
    invoke-static {v0, v1, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzr(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzjd;Z)V

    goto/16 :goto_4

    :pswitch_33
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-wide v3, v1

    move-object/from16 v1, p1

    move v2, v15

    move-object/from16 v16, v10

    move-wide v9, v3

    move v3, v14

    move/from16 v4, v17

    move v13, v5

    move/from16 v5, v18

    .line 163
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 164
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 165
    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzq(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    goto/16 :goto_7

    :pswitch_34
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 166
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 167
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzE(IJ)V

    goto/16 :goto_7

    :pswitch_35
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 168
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 169
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzC(II)V

    goto/16 :goto_7

    :pswitch_36
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 170
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 171
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzA(IJ)V

    goto/16 :goto_7

    :pswitch_37
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 172
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 173
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzy(II)V

    goto/16 :goto_7

    :pswitch_38
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 174
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 175
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzi(II)V

    goto/16 :goto_7

    :pswitch_39
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 176
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 177
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzJ(II)V

    goto/16 :goto_7

    :pswitch_3a
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 178
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 179
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzd(ILcom/google/android/gms/internal/play_billing/zzfg;)V

    goto/16 :goto_7

    :pswitch_3b
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 180
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 181
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    .line 182
    invoke-direct {v6, v15}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzw(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhw;)V

    goto/16 :goto_7

    :pswitch_3c
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 183
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 184
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v13, v0, v8}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzP(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjd;)V

    goto/16 :goto_7

    :pswitch_3d
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 185
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 186
    invoke-static {v7, v9, v10}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result v0

    .line 187
    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzb(IZ)V

    goto/16 :goto_7

    :pswitch_3e
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 188
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 189
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzk(II)V

    goto/16 :goto_7

    :pswitch_3f
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 190
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 191
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzm(IJ)V

    goto/16 :goto_7

    :pswitch_40
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 192
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 193
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzr(II)V

    goto/16 :goto_7

    :pswitch_41
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 194
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 195
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzL(IJ)V

    goto/16 :goto_7

    :pswitch_42
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 196
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 197
    invoke-virtual {v12, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzt(IJ)V

    goto :goto_7

    :pswitch_43
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 198
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 199
    invoke-static {v7, v9, v10}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result v0

    .line 200
    invoke-interface {v8, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzo(IF)V

    goto :goto_7

    :pswitch_44
    move v13, v5

    move-object/from16 v16, v10

    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v15

    move v3, v14

    move/from16 v4, v17

    move/from16 v5, v18

    .line 201
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 202
    invoke-static {v7, v9, v10}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide v0

    .line 203
    invoke-interface {v8, v13, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzf(ID)V

    :cond_5
    :goto_7
    add-int/lit8 v15, v15, 0x3

    move v0, v14

    move-object/from16 v10, v16

    move/from16 v1, v17

    const v13, 0xfffff

    goto/16 :goto_1

    :cond_6
    move-object/from16 v16, v10

    .line 209
    invoke-interface/range {v16 .. v16}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzge;

    const/4 v0, 0x0

    .line 210
    throw v0

    :cond_7
    move-object/from16 v16, v10

    const/4 v0, 0x0

    if-nez v16, :cond_8

    .line 204
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 205
    move-object v1, v0

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzim;

    .line 206
    invoke-virtual {v0, v8}, Lcom/google/android/gms/internal/play_billing/zzim;->zzl(Lcom/google/android/gms/internal/play_billing/zzjd;)V

    return-void

    .line 207
    :cond_8
    invoke-interface/range {v16 .. v16}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzge;

    .line 208
    throw v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
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

.method public final zzj(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 6

    const/4 v0, 0x0

    move v1, v0

    .line 1
    :goto_0
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    array-length v2, v2

    const v3, 0xfffff

    if-ge v1, v2, :cond_3

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v4

    const/16 v5, 0x32

    if-le v4, v5, :cond_0

    const/16 v5, 0x45

    if-ge v4, v5, :cond_0

    goto/16 :goto_3

    :cond_0
    and-int/2addr v2, v3

    int-to-long v2, v2

    packed-switch v4, :pswitch_data_0

    goto/16 :goto_3

    .line 2
    :pswitch_0
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzL(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 3
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 4
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto/16 :goto_3

    .line 5
    :pswitch_1
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 6
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    goto :goto_1

    .line 7
    :pswitch_2
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 8
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    :goto_1
    if-nez v2, :cond_2

    goto/16 :goto_2

    .line 9
    :pswitch_3
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 10
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 11
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto/16 :goto_3

    .line 12
    :pswitch_4
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 13
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto/16 :goto_3

    .line 14
    :pswitch_5
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 15
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 16
    :pswitch_6
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 17
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto/16 :goto_3

    .line 18
    :pswitch_7
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 19
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 20
    :pswitch_8
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 21
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 22
    :pswitch_9
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 23
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 24
    :pswitch_a
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 25
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 26
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto/16 :goto_3

    .line 27
    :pswitch_b
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 28
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 29
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto/16 :goto_3

    .line 30
    :pswitch_c
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 31
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    .line 32
    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto/16 :goto_3

    .line 33
    :pswitch_d
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 34
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzw(Ljava/lang/Object;J)Z

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 35
    :pswitch_e
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 36
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto/16 :goto_3

    .line 37
    :pswitch_f
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 38
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto/16 :goto_3

    .line 39
    :pswitch_10
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 40
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto :goto_3

    .line 41
    :pswitch_11
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 42
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto :goto_3

    .line 43
    :pswitch_12
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 44
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto :goto_3

    .line 45
    :pswitch_13
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 46
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    .line 47
    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zzb(Ljava/lang/Object;J)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v2

    if-ne v4, v2, :cond_1

    goto :goto_3

    .line 48
    :pswitch_14
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzG(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 49
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v4

    .line 50
    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzis;->zza(Ljava/lang/Object;J)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-nez v2, :cond_1

    goto :goto_3

    :cond_1
    :goto_2
    return v0

    :cond_2
    :goto_3
    add-int/lit8 v1, v1, 0x3

    goto/16 :goto_0

    .line 47
    :cond_3
    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzk:I

    :goto_4
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzi:[I

    array-length v4, v2

    if-ge v1, v4, :cond_7

    .line 51
    aget v2, v2, v1

    .line 52
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzL(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-nez v4, :cond_4

    return v0

    .line 53
    :cond_4
    invoke-direct {p0, p1, v0, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_5

    goto :goto_5

    .line 54
    :cond_5
    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v2

    and-int/2addr v2, v3

    int-to-long v4, v2

    .line 55
    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    .line 56
    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzE(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    return v0

    :cond_6
    :goto_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 57
    :cond_7
    move-object v1, p1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v1, v1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 58
    move-object v2, p2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v2, v2, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 59
    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_8

    return v0

    :cond_8
    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_9

    .line 60
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 61
    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p2, p2, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 62
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_9
    const/4 p1, 0x1

    return p1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_14
        :pswitch_13
        :pswitch_12
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
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final zzk(Ljava/lang/Object;)Z
    .locals 17

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    const/4 v8, 0x0

    const v9, 0xfffff

    move v1, v8

    move v10, v1

    move v0, v9

    .line 1
    :goto_0
    iget v2, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzj:I

    const/4 v3, 0x1

    if-ge v10, v2, :cond_b

    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzi:[I

    aget v11, v2, v10

    .line 2
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzq(I)I

    move-result v12

    iget-object v13, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzc:[I

    add-int/lit8 v2, v11, 0x2

    .line 3
    aget v2, v13, v2

    and-int v4, v2, v9

    ushr-int/lit8 v2, v2, 0x14

    shl-int v14, v3, v2

    if-eq v4, v0, :cond_1

    if-eq v4, v9, :cond_0

    int-to-long v0, v4

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb:Lsun/misc/Unsafe;

    .line 4
    invoke-virtual {v2, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :cond_0
    move/from16 v16, v1

    move v15, v4

    goto :goto_1

    :cond_1
    move v15, v0

    move/from16 v16, v1

    :goto_1
    const/high16 v0, 0x10000000

    and-int/2addr v0, v12

    if-eqz v0, :cond_2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v15

    move/from16 v4, v16

    move v5, v14

    .line 5
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-nez v0, :cond_2

    return v8

    :cond_2
    invoke-static {v12}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzp(I)I

    move-result v0

    const/16 v1, 0x9

    if-eq v0, v1, :cond_9

    const/16 v1, 0x11

    if-eq v0, v1, :cond_9

    const/16 v1, 0x1b

    if-eq v0, v1, :cond_7

    const/16 v1, 0x3c

    if-eq v0, v1, :cond_6

    const/16 v1, 0x44

    if-eq v0, v1, :cond_6

    const/16 v1, 0x31

    if-eq v0, v1, :cond_7

    const/16 v1, 0x32

    if-eq v0, v1, :cond_3

    goto/16 :goto_3

    :cond_3
    and-int v0, v12, v9

    int-to-long v0, v0

    .line 12
    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    .line 13
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhg;

    .line 14
    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_a

    .line 15
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzv(I)Ljava/lang/Object;

    move-result-object v1

    .line 16
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhf;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzhf;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc:Lcom/google/android/gms/internal/play_billing/zzjb;

    .line 17
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzjb;->zzb()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object v1

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjc;->zzi:Lcom/google/android/gms/internal/play_billing/zzjc;

    if-ne v1, v2, :cond_a

    .line 18
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const/4 v1, 0x0

    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    if-nez v1, :cond_5

    .line 19
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzht;->zza()Lcom/google/android/gms/internal/play_billing/zzht;

    move-result-object v1

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzht;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 20
    :cond_5
    invoke-interface {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzk(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    return v8

    .line 21
    :cond_6
    aget v0, v13, v11

    .line 22
    invoke-direct {v6, v7, v0, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 23
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v0

    invoke-static {v7, v12, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzJ(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzhw;)Z

    move-result v0

    if-nez v0, :cond_a

    return v8

    :cond_7
    and-int v0, v12, v9

    int-to-long v0, v0

    .line 6
    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzis;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 7
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_a

    .line 8
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    move v2, v8

    .line 9
    :goto_2
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_a

    .line 10
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 11
    invoke-interface {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzhw;->zzk(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    return v8

    :cond_8
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_9
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v15

    move/from16 v4, v16

    move v5, v14

    .line 24
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzI(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 25
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzt(I)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v0

    invoke-static {v7, v12, v0}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzJ(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzhw;)Z

    move-result v0

    if-nez v0, :cond_a

    return v8

    :cond_a
    :goto_3
    add-int/lit8 v10, v10, 0x1

    move v0, v15

    move/from16 v1, v16

    goto/16 :goto_0

    :cond_b
    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzhp;->zzh:Z

    if-eqz v0, :cond_c

    .line 26
    move-object v0, v7

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 27
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzj()Z

    move-result v0

    if-nez v0, :cond_c

    return v8

    :cond_c
    return v3
.end method
