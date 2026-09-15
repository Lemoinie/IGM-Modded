.class public final Lcom/google/android/gms/internal/play_billing/zzed;
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

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzef;)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzee;->zzb()Lcom/google/android/gms/internal/play_billing/zzee;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method


# virtual methods
.method public final zza(Ljava/lang/Iterable;)Lcom/google/android/gms/internal/play_billing/zzed;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzm()V

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzed;->zza:Lcom/google/android/gms/internal/play_billing/zzgg;

    .line 2
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzee;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzc(Lcom/google/android/gms/internal/play_billing/zzee;Ljava/lang/Iterable;)V

    return-object p0
.end method
