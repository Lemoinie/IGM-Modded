.class final Lcom/android/billingclient/api/zzdm;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/android/billingclient/api/zzcz;


# instance fields
.field private zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

.field private final zzc:Lcom/android/billingclient/api/zzdo;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    .locals 1

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzdo;

    invoke-direct {v0, p1}, Lcom/android/billingclient/api/zzdo;-><init>(Landroid/content/Context;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    return-void
.end method

.method private final zzo(Lcom/google/android/gms/internal/play_billing/zzjg;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    .locals 1

    if-nez p1, :cond_0

    return-void

    .line 1
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v0

    .line 2
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 5
    invoke-virtual {p2, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingLogger"

    const-string v0, "Unable to log."

    .line 6
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzp(Lcom/google/android/gms/internal/play_billing/zzjk;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    .locals 1

    if-nez p1, :cond_0

    return-void

    .line 1
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v0

    .line 2
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzb(Lcom/google/android/gms/internal/play_billing/zzjk;)Lcom/google/android/gms/internal/play_billing/zzkp;

    iget-object p1, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-virtual {p1, p2}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingLogger"

    const-string v0, "Unable to log."

    .line 5
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-direct {p0, p1, v0}, Lcom/android/billingclient/api/zzdm;->zzo(Lcom/google/android/gms/internal/play_billing/zzjg;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 2
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzb(Lcom/google/android/gms/internal/play_billing/zzjg;I)V
    .locals 1

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {p0, p1}, Lcom/android/billingclient/api/zzdm;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingLogger"

    const-string v0, "Unable to log."

    .line 3
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzc(Lcom/google/android/gms/internal/play_billing/zzjg;IJ)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 2
    :cond_0
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 3
    invoke-virtual {p2, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 4
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 5
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzdm;->zzo(Lcom/google/android/gms/internal/play_billing/zzjg;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 4
    const-string p2, "BillingLogger"

    const-string p3, "Unable to log."

    .line 6
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzd(Lcom/google/android/gms/internal/play_billing/zzjg;JZ)V
    .locals 2

    .line 1
    :try_start_0
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzje;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzjg;->zze()Lcom/google/android/gms/internal/play_billing/zzko;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 3
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/play_billing/zzkj;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 4
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzje;->zzd(Lcom/google/android/gms/internal/play_billing/zzkj;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 5
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;

    const-wide/16 v0, 0x0

    cmp-long p4, p2, v0

    if-nez p4, :cond_0

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    goto :goto_0

    .line 9
    :cond_0
    iget-object p4, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 6
    invoke-virtual {p4}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p4

    check-cast p4, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 7
    invoke-virtual {p4, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 8
    invoke-virtual {p4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 9
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzdm;->zzo(Lcom/google/android/gms/internal/play_billing/zzjg;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 8
    const-string p2, "BillingLogger"

    const-string p3, "Unable to log."

    .line 10
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zze(Lcom/google/android/gms/internal/play_billing/zzjg;IJZ)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzje;

    .line 3
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzjg;->zze()Lcom/google/android/gms/internal/play_billing/zzko;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 4
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzkj;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 5
    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzje;->zzd(Lcom/google/android/gms/internal/play_billing/zzkj;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 6
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjg;

    const-wide/16 v0, 0x0

    cmp-long p2, p3, v0

    if-nez p2, :cond_0

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    goto :goto_0

    .line 10
    :cond_0
    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 7
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 8
    invoke-virtual {p2, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 9
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 10
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzdm;->zzo(Lcom/google/android/gms/internal/play_billing/zzjg;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 9
    const-string p2, "BillingLogger"

    const-string p3, "Unable to log."

    .line 11
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzf(Lcom/google/android/gms/internal/play_billing/zzjk;)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-direct {p0, p1, v0}, Lcom/android/billingclient/api/zzdm;->zzp(Lcom/google/android/gms/internal/play_billing/zzjk;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 2
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzg(Lcom/google/android/gms/internal/play_billing/zzjk;I)V
    .locals 1

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjz;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    iput-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {p0, p1}, Lcom/android/billingclient/api/zzdm;->zzf(Lcom/google/android/gms/internal/play_billing/zzjk;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingLogger"

    const-string v0, "Unable to log."

    .line 3
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzh(Lcom/google/android/gms/internal/play_billing/zzjk;JZ)V
    .locals 2

    .line 1
    :try_start_0
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzji;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzjk;->zzc()Lcom/google/android/gms/internal/play_billing/zzko;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 3
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/play_billing/zzkj;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzkj;

    .line 4
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzji;->zzc(Lcom/google/android/gms/internal/play_billing/zzkj;)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 5
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjk;

    const-wide/16 v0, 0x0

    cmp-long p4, p2, v0

    if-nez p4, :cond_0

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    goto :goto_0

    .line 9
    :cond_0
    iget-object p4, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 6
    invoke-virtual {p4}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p4

    check-cast p4, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 7
    invoke-virtual {p4, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 8
    invoke-virtual {p4}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 9
    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzdm;->zzp(Lcom/google/android/gms/internal/play_billing/zzjk;Lcom/google/android/gms/internal/play_billing/zzkb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 8
    const-string p2, "BillingLogger"

    const-string p3, "Unable to log."

    .line 10
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzi(Lcom/google/android/gms/internal/play_billing/zzjs;)V
    .locals 2

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzc(Lcom/google/android/gms/internal/play_billing/zzjs;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 5
    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 6
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzj(Lcom/android/billingclient/api/BillingResult;J)V
    .locals 3

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zza()Lcom/google/android/gms/internal/play_billing/zzjv;

    move-result-object v0

    const/4 v1, 0x4

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zze(I)Lcom/google/android/gms/internal/play_billing/zzjv;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zze:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zza(Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjv;

    if-eqz p1, :cond_0

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v1

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v2

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p1

    .line 6
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzb(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzjv;

    .line 8
    :cond_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object p1

    const-wide/16 v1, 0x0

    cmp-long v1, p2, v1

    if-nez v1, :cond_1

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    goto :goto_0

    .line 15
    :cond_1
    iget-object v1, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 9
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 10
    invoke-virtual {v1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 11
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 12
    :goto_0
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 13
    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzd(Lcom/google/android/gms/internal/play_billing/zzjv;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 14
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 15
    invoke-virtual {p2, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 11
    const-string p2, "BillingLogger"

    const-string p3, "Unable to log."

    .line 16
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzk(J)V
    .locals 4

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zza()Lcom/google/android/gms/internal/play_billing/zzjv;

    move-result-object v0

    const/4 v1, 0x4

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zze(I)Lcom/google/android/gms/internal/play_billing/zzjv;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zzf:Lcom/google/android/gms/internal/play_billing/zzju;

    .line 3
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zza(Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjv;

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    .line 5
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v1

    const-wide/16 v2, 0x0

    cmp-long v2, p1, v2

    if-nez v2, :cond_0

    iget-object p1, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    goto :goto_0

    .line 12
    :cond_0
    iget-object v2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 6
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzq()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 7
    invoke-virtual {v2, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzjz;->zze(J)Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 8
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 9
    :goto_0
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 10
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzkp;->zze(Lcom/google/android/gms/internal/play_billing/zzjy;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 11
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    iget-object p2, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 12
    invoke-virtual {p2, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 8
    const-string p2, "BillingLogger"

    const-string v0, "Unable to log."

    .line 13
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzl(Lcom/google/android/gms/internal/play_billing/zzky;)V
    .locals 3

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zza()Lcom/google/android/gms/internal/play_billing/zzjv;

    move-result-object v1

    const-string v2, "ProxyBillingBroadcastReceiver"

    .line 4
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzjv;->zzc(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjv;

    const/4 v2, 0x2

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzjv;->zze(I)Lcom/google/android/gms/internal/play_billing/zzjv;

    .line 6
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzjv;->zzd(Lcom/google/android/gms/internal/play_billing/zzky;)Lcom/google/android/gms/internal/play_billing/zzjv;

    .line 7
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzd(Lcom/google/android/gms/internal/play_billing/zzjv;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 8
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 9
    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 10
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzm(Lcom/google/android/gms/internal/play_billing/zzlb;)V
    .locals 3

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v1

    iget-object v2, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzq(Lcom/google/android/gms/internal/play_billing/zzlb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 4
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzkr;

    .line 5
    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 6
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final zzn(Lcom/google/android/gms/internal/play_billing/zzlf;)V
    .locals 2

    if-nez p1, :cond_0

    return-void

    .line 1
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzkr;->zza()Lcom/google/android/gms/internal/play_billing/zzkp;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzdm;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzp(Lcom/google/android/gms/internal/play_billing/zzkb;)Lcom/google/android/gms/internal/play_billing/zzkp;

    .line 3
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzkp;->zzr(Lcom/google/android/gms/internal/play_billing/zzlf;)Lcom/google/android/gms/internal/play_billing/zzkp;

    iget-object p1, p0, Lcom/android/billingclient/api/zzdm;->zzc:Lcom/android/billingclient/api/zzdo;

    .line 4
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzkr;

    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzdo;->zza(Lcom/google/android/gms/internal/play_billing/zzkr;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string v0, "BillingLogger"

    const-string v1, "Unable to log."

    .line 5
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method
