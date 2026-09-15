.class public final Lcom/google/android/gms/internal/play_billing/zzkj;
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

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzkn;)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzko;->zza()Lcom/google/android/gms/internal/play_billing/zzko;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method


# virtual methods
.method public final zza(Z)Lcom/google/android/gms/internal/play_billing/zzkj;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkj;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzko;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzko;->zzc(Lcom/google/android/gms/internal/play_billing/zzko;Z)V

    return-object p0
.end method
