.class final Lcom/google/android/gms/internal/play_billing/zzin;
.super Lcom/google/android/gms/internal/play_billing/zzil;
.source "com.android.billingclient:billing@@9.0.0"


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzil;-><init>()V

    return-void
.end method


# virtual methods
.method final bridge synthetic zza(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .line 1
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object v0, p1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzc()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzim;->zzf()Lcom/google/android/gms/internal/play_billing/zzim;

    move-result-object v0

    .line 2
    iput-object v0, p1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    :cond_0
    return-object v0
.end method

.method final zzb(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgg;

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzgg;->zzc:Lcom/google/android/gms/internal/play_billing/zzim;

    .line 2
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzim;->zzh()V

    return-void
.end method
