.class final Lcom/google/android/gms/internal/play_billing/zzeu;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field public zza:I

.field public zzb:J

.field public zzc:Ljava/lang/Object;

.field public final zzd:Lcom/google/android/gms/internal/play_billing/zzft;

.field public zze:I


# direct methods
.method constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget v0, Lcom/google/android/gms/internal/play_billing/zzft;->zzb:I

    .line 2
    sget v0, Lcom/google/android/gms/internal/play_billing/zzet;->zza:I

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzft;->zza:Lcom/google/android/gms/internal/play_billing/zzft;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzeu;->zzd:Lcom/google/android/gms/internal/play_billing/zzft;

    return-void
.end method

.method constructor <init>(Lcom/google/android/gms/internal/play_billing/zzft;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzeu;->zzd:Lcom/google/android/gms/internal/play_billing/zzft;

    return-void
.end method
