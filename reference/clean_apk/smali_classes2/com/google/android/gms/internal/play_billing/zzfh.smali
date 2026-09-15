.class Lcom/google/android/gms/internal/play_billing/zzfh;
.super Lcom/google/android/gms/internal/play_billing/zzfk;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private zzb:I

.field private zzc:I

.field private zzd:I


# direct methods
.method synthetic constructor <init>([BIIZLcom/google/android/gms/internal/play_billing/zzfj;)V
    .locals 0

    const/4 p1, 0x0

    .line 1
    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfk;-><init>(Lcom/google/android/gms/internal/play_billing/zzfj;)V

    const p1, 0x7fffffff

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzd:I

    const/4 p1, 0x0

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzb:I

    return-void
.end method


# virtual methods
.method public final zza(I)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/android/gms/internal/play_billing/zzgs;
        }
    .end annotation

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzd:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzd:I

    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzb:I

    iget v2, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzc:I

    add-int/2addr v1, v2

    iput v1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzb:I

    if-lez v1, :cond_0

    iput v1, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzc:I

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzb:I

    goto :goto_0

    :cond_0
    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzfh;->zzc:I

    :goto_0
    return p1
.end method
