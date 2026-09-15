.class final Lcom/google/android/gms/internal/play_billing/zzhq;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhw;


# instance fields
.field private final zza:Lcom/google/android/gms/internal/play_billing/zzhm;

.field private final zzb:Lcom/google/android/gms/internal/play_billing/zzil;

.field private final zzc:Z

.field private final zzd:Lcom/google/android/gms/internal/play_billing/zzfu;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhm;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzb:Lcom/google/android/gms/internal/play_billing/zzil;

    instance-of p1, p3, Lcom/google/android/gms/internal/play_billing/zzgd;

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc:Z

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzd:Lcom/google/android/gms/internal/play_billing/zzfu;

    iput-object p3, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;

    return-void
.end method

.method static zzc(Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhm;)Lcom/google/android/gms/internal/play_billing/zzhq;
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhq;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhq;-><init>(Lcom/google/android/gms/internal/play_billing/zzil;Lcom/google/android/gms/internal/play_billing/zzfu;Lcom/google/android/gms/internal/play_billing/zzhm;)V

    return-object v0
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;)I
    .locals 2

    .line 1
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 2
    move-object v1, v0

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzim;

    .line 3
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzim;->zzb()I

    move-result v0

    iget-boolean v1, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc:Z

    if-eqz v1, :cond_0

    .line 4
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 5
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzd()I

    move-result p1

    add-int/2addr v0, p1

    :cond_0
    return v0
.end method

.method public final zzb(Ljava/lang/Object;)I
    .locals 2

    .line 1
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 2
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    iget-boolean v1, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc:Z

    if-eqz v1, :cond_0

    .line 3
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    mul-int/lit8 v0, v0, 0x35

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfy;->zza:Lcom/google/android/gms/internal/play_billing/zzid;

    .line 4
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzid;->hashCode()I

    move-result p1

    add-int/2addr v0, p1

    :cond_0
    return v0
.end method

.method public final zze()Ljava/lang/Object;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;

    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzs()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    return-object v0

    .line 2
    :cond_0
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzw()Lcom/google/android/gms/internal/play_billing/zzhl;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhl;->zzk()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v0

    return-object v0
.end method

.method public final zzf(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzb:Lcom/google/android/gms/internal/play_billing/zzil;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzil;->zzb(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzd:Lcom/google/android/gms/internal/play_billing/zzfu;

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzfu;->zza(Ljava/lang/Object;)V

    return-void
.end method

.method public final zzg(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzb:Lcom/google/android/gms/internal/play_billing/zzil;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzp(Lcom/google/android/gms/internal/play_billing/zzil;Ljava/lang/Object;Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzd:Lcom/google/android/gms/internal/play_billing/zzfu;

    .line 2
    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzo(Lcom/google/android/gms/internal/play_billing/zzfu;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_0
    return-void
.end method

.method public final zzh(Ljava/lang/Object;[BIILcom/google/android/gms/internal/play_billing/zzeu;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    move-object p2, p1

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object p3, p2, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzc()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object p4

    if-eq p3, p4, :cond_0

    goto :goto_0

    .line 4
    :cond_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzf()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object p3

    .line 2
    iput-object p3, p2, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 3
    :goto_0
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    const/4 p1, 0x0

    .line 4
    throw p1
.end method

.method public final zzi(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzjd;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 2
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzf()Ljava/util/Iterator;

    move-result-object v0

    .line 3
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 4
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 5
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzfx;

    .line 6
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzc()Lcom/google/android/gms/internal/play_billing/zzjc;

    move-result-object v3

    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzjc;->zzi:Lcom/google/android/gms/internal/play_billing/zzjc;

    if-ne v3, v4, :cond_1

    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zze()Z

    move-result v3

    if-nez v3, :cond_1

    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zzd()Z

    move-result v3

    if-nez v3, :cond_1

    .line 13
    instance-of v3, v1, Lcom/google/android/gms/internal/play_billing/zzgn;

    if-eqz v3, :cond_0

    .line 7
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result v2

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgn;->zza()Lcom/google/android/gms/internal/play_billing/zzgq;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgq;->zze()Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v1

    .line 8
    invoke-interface {p2, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzx(ILjava/lang/Object;)V

    goto :goto_0

    .line 9
    :cond_0
    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza()I

    move-result v2

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p2, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzjd;->zzx(ILjava/lang/Object;)V

    goto :goto_0

    .line 6
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Found invalid MessageSet item."

    .line 13
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 10
    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 11
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzim;

    .line 12
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzim;->zzk(Lcom/google/android/gms/internal/play_billing/zzjd;)V

    return-void
.end method

.method public final zzj(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 2

    .line 1
    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 2
    move-object v1, p2

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v1, v1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 3
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return p1

    :cond_0
    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzhq;->zzc:Z

    if-eqz v0, :cond_1

    .line 4
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 5
    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p2, p2, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 6
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzfy;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_1
    const/4 p1, 0x1

    return p1
.end method

.method public final zzk(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgd;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgd;->zzb:Lcom/google/android/gms/internal/play_billing/zzfy;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfy;->zzj()Z

    move-result p1

    return p1
.end method
