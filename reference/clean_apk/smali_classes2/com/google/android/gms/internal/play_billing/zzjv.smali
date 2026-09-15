.class public final Lcom/google/android/gms/internal/play_billing/zzjv;
.super Lcom/google/android/gms/internal/play_billing/zzgc;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# direct methods
.method private constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    throw v0
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzjx;)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzb()Lcom/google/android/gms/internal/play_billing/zzjy;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzju;)Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzc(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzju;)V

    return-object p0
.end method

.method public final zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjp;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzjy;->zze(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzjp;)V

    return-object p0
.end method

.method public final zzc(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzjv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjy;

    const-string v0, "ProxyBillingBroadcastReceiver"

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzf(Lcom/google/android/gms/internal/play_billing/zzjy;Ljava/lang/String;)V

    return-object p0
.end method

.method public final zzd(Lcom/google/android/gms/internal/play_billing/zzky;)Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzg(Lcom/google/android/gms/internal/play_billing/zzjy;Lcom/google/android/gms/internal/play_billing/zzky;)V

    return-object p0
.end method

.method public final zze(I)Lcom/google/android/gms/internal/play_billing/zzjv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzjv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjy;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzjy;->zzh(Lcom/google/android/gms/internal/play_billing/zzjy;I)V

    return-object p0
.end method
