.class public final Lcom/google/android/gms/internal/play_billing/zzkv;
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

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzkx;)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzky;->zzb()Lcom/google/android/gms/internal/play_billing/zzky;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method


# virtual methods
.method public final zza(I)Lcom/google/android/gms/internal/play_billing/zzkv;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkv;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzky;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzky;->zzc(Lcom/google/android/gms/internal/play_billing/zzky;I)V

    return-object p0
.end method
