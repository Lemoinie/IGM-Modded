.class final Lcom/google/android/gms/internal/play_billing/zzgq;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field protected volatile zza:Lcom/google/android/gms/internal/play_billing/zzhm;

.field private final zzb:Lcom/google/android/gms/internal/play_billing/zzhm;

.field private volatile zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

.field private volatile zzd:Z


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/play_billing/zzhm;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 2
    invoke-interface {p1}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzl()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzb:Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 3
    sget p1, Lcom/google/android/gms/internal/play_billing/zzft;->zzb:I

    .line 4
    sget p1, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzd:Z

    return-void

    .line 1
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "message cannot be null"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzf()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final hashCode()I
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzf()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzf()Lcom/google/android/gms/internal/play_billing/zzhm;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method final zza(I)I
    .locals 2

    const/16 v0, 0x8

    .line 1
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v0

    add-int/2addr v0, v0

    const/16 v1, 0x10

    .line 2
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    .line 3
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    add-int/2addr v1, p1

    add-int/2addr v0, v1

    const/4 p1, 0x3

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzb(I)I

    move-result p1

    add-int/2addr v0, p1

    return v0
.end method

.method final zzb(I)I
    .locals 1

    const/16 p1, 0x18

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result p1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc()I

    move-result v0

    add-int/2addr p1, v0

    return p1
.end method

.method final zzc()I
    .locals 2

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgq;->zzd()I

    move-result v0

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzfo;->zzy(I)I

    move-result v1

    add-int/2addr v1, v0

    return v1
.end method

.method final zzd()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzfg;->zzd()I

    move-result v0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzn()I

    move-result v0

    :goto_0
    return v0
.end method

.method final zze()Lcom/google/android/gms/internal/play_billing/zzfg;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    return-object v0

    :cond_0
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    monitor-exit p0

    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;

    .line 2
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzj()Lcom/google/android/gms/internal/play_billing/zzfg;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzc:Lcom/google/android/gms/internal/play_billing/zzfg;

    .line 3
    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    .line 4
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method final zzf()Lcom/google/android/gms/internal/play_billing/zzhm;
    .locals 1

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zza:Lcom/google/android/gms/internal/play_billing/zzhm;
    :try_end_0
    .catch Lcom/google/android/gms/internal/play_billing/zzgs; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzft;->zzb()Z

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgq;->zzb:Lcom/google/android/gms/internal/play_billing/zzhm;

    return-object v0
.end method
