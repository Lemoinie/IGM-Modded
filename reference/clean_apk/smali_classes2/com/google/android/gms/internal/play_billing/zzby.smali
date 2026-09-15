.class final Lcom/google/android/gms/internal/play_billing/zzby;
.super Lcom/google/android/gms/internal/play_billing/zzbs;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zza:Lcom/google/android/gms/internal/play_billing/zzca;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/play_billing/zzca;I)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzca;->size()I

    move-result v0

    invoke-direct {p0, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzbs;-><init>(II)V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzby;->zza:Lcom/google/android/gms/internal/play_billing/zzca;

    return-void
.end method


# virtual methods
.method final zza(I)Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzby;->zza:Lcom/google/android/gms/internal/play_billing/zzca;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzca;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
