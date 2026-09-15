.class final Lcom/google/android/gms/internal/play_billing/zzfe;
.super Lcom/google/android/gms/internal/play_billing/zzfd;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zzb:[B


# direct methods
.method constructor <init>([B)V
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzfd;-><init>(Lcom/google/android/gms/internal/play_billing/zzff;)V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    return-void
.end method

.method static bridge synthetic zzb(Lcom/google/android/gms/internal/play_billing/zzfe;)[B
    .locals 0

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    return-object p0
.end method


# virtual methods
.method final zza(I)B
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    aget-byte p1, v0, p1

    return p1
.end method

.method protected final zzc(III)I
    .locals 1

    .line 1
    iget-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    const/4 v0, 0x0

    invoke-static {p1, p2, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzb(I[BII)I

    move-result p1

    return p1
.end method

.method public final zzd()I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    array-length v0, v0

    return v0
.end method

.method public final zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    array-length v0, p1

    const/4 v1, 0x0

    invoke-static {v1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzfe;->zzj(III)I

    move-result p2

    if-nez p2, :cond_0

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    return-object p1

    .line 2
    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzfa;

    invoke-direct {v0, p1, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzfa;-><init>([BII)V

    return-object v0
.end method

.method protected final zzf([BIII)V
    .locals 0

    .line 1
    iget-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    const/4 p3, 0x0

    invoke-static {p2, p3, p1, p3, p4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void
.end method

.method final zzg(Lcom/google/android/gms/internal/play_billing/zzex;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfl;

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    array-length v1, v0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzfl;->zzc([BII)V

    return-void
.end method

.method protected final zzh(Lcom/google/android/gms/internal/play_billing/zzfg;)Z
    .locals 5

    .line 1
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfe;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfe;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    invoke-static {v0, p1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result p1

    return p1

    :cond_0
    instance-of v1, p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    if-eqz v1, :cond_5

    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v3

    array-length v4, v2

    if-gt v4, v3, :cond_4

    .line 4
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v3

    if-gt v4, v3, :cond_3

    const/4 v3, 0x0

    if-eqz v0, :cond_1

    .line 6
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfe;

    .line 7
    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb:[B

    invoke-static {v2, v3, p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzl([BI[BII)Z

    move-result p1

    goto :goto_0

    :cond_1
    if-eqz v1, :cond_2

    .line 8
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    .line 9
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfa;->zzi(Lcom/google/android/gms/internal/play_billing/zzfa;)[B

    move-result-object v0

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb(Lcom/google/android/gms/internal/play_billing/zzfa;)I

    move-result p1

    invoke-static {v2, v3, v0, p1, v4}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzl([BI[BII)Z

    move-result p1

    goto :goto_0

    .line 10
    :cond_2
    invoke-virtual {p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfg;->zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object p1

    invoke-virtual {p0, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfe;->zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzfg;->equals(Ljava/lang/Object;)Z

    move-result p1

    :goto_0
    return p1

    .line 4
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 5
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result p1

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Ran off end of other: 0, "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2
    :cond_4
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Length too large: "

    .line 3
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 11
    :cond_5
    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzh(Lcom/google/android/gms/internal/play_billing/zzfg;)Z

    move-result p1

    return p1
.end method
