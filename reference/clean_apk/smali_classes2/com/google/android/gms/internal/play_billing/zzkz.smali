.class public final Lcom/google/android/gms/internal/play_billing/zzkz;
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

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzla;)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzlb;->zzb()Lcom/google/android/gms/internal/play_billing/zzlb;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzkz;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkz;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjp;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzlb;->zzc(Lcom/google/android/gms/internal/play_billing/zzlb;Lcom/google/android/gms/internal/play_billing/zzjp;)V

    return-object p0
.end method

.method public final zzb(J)Lcom/google/android/gms/internal/play_billing/zzkz;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkz;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzlb;->zze(Lcom/google/android/gms/internal/play_billing/zzlb;J)V

    return-object p0
.end method
