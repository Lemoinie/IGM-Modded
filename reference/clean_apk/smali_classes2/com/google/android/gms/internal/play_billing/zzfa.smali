.class final Lcom/google/android/gms/internal/play_billing/zzfa;
.super Lcom/google/android/gms/internal/play_billing/zzfd;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zzb:[B

.field private final zzc:I

.field private final zzd:I


# direct methods
.method constructor <init>([BII)V
    .locals 2

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzfd;-><init>(Lcom/google/android/gms/internal/play_billing/zzff;)V

    add-int v0, p2, p3

    array-length v1, p1

    .line 2
    invoke-static {p2, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzfa;->zzj(III)I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iput p2, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    iput p3, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzd:I

    return-void
.end method

.method static bridge synthetic zzb(Lcom/google/android/gms/internal/play_billing/zzfa;)I
    .locals 0

    iget p0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    return p0
.end method

.method static bridge synthetic zzi(Lcom/google/android/gms/internal/play_billing/zzfa;)[B
    .locals 0

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    return-object p0
.end method


# virtual methods
.method final zza(I)B
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    add-int/2addr v0, p1

    aget-byte p1, v1, v0

    return p1
.end method

.method protected final zzc(III)I
    .locals 1

    .line 1
    iget-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    invoke-static {p1, p2, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzb(I[BII)I

    move-result p1

    return p1
.end method

.method public final zzd()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzd:I

    return v0
.end method

.method public final zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzd:I

    invoke-static {p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzfa;->zzj(III)I

    move-result p2

    if-nez p2, :cond_0

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzfg;->zza:Lcom/google/android/gms/internal/play_billing/zzfg;

    return-object p1

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    add-int/2addr v1, p1

    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    .line 2
    invoke-direct {p1, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzfa;-><init>([BII)V

    return-object p1
.end method

.method protected final zzf([BIII)V
    .locals 1

    .line 1
    iget-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget p3, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    const/4 v0, 0x0

    invoke-static {p2, p3, p1, v0, p4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

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
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    iget v2, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzd:I

    invoke-virtual {p1, v0, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfl;->zzc([BII)V

    return-void
.end method

.method protected final zzh(Lcom/google/android/gms/internal/play_billing/zzfg;)Z
    .locals 4

    .line 1
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfe;

    if-nez v0, :cond_1

    instance-of v1, p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    if-eqz v1, :cond_0

    goto :goto_0

    .line 11
    :cond_0
    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzh(Lcom/google/android/gms/internal/play_billing/zzfg;)Z

    move-result p1

    return p1

    .line 1
    :cond_1
    :goto_0
    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzd:I

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v2

    if-gt v1, v2, :cond_5

    .line 3
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v2

    if-gt v1, v2, :cond_4

    const/4 v2, 0x0

    if-eqz v0, :cond_2

    .line 5
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfe;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget v3, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    .line 6
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfe;->zzb(Lcom/google/android/gms/internal/play_billing/zzfe;)[B

    move-result-object p1

    invoke-static {v0, v3, p1, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzl([BI[BII)Z

    move-result p1

    goto :goto_1

    :cond_2
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    if-eqz v0, :cond_3

    .line 7
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfa;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget v2, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    .line 8
    iget-object v3, p1, Lcom/google/android/gms/internal/play_billing/zzfa;->zzb:[B

    iget p1, p1, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    invoke-static {v0, v2, v3, p1, v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzl([BI[BII)Z

    move-result p1

    goto :goto_1

    .line 9
    :cond_3
    invoke-virtual {p1, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object p1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzfa;->zzc:I

    add-int/2addr v1, v0

    .line 10
    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzfa;->zze(II)Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzfg;->equals(Ljava/lang/Object;)Z

    move-result p1

    :goto_1
    return p1

    .line 3
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 4
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result p1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Ran off end of other: 0, "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1
    :cond_5
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Length too large: "

    .line 2
    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
