.class final Lcom/google/android/gms/internal/play_billing/zzdl;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# direct methods
.method static zza(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    instance-of v0, p0, Ljava/lang/Error;

    if-eqz v0, :cond_1

    instance-of v0, p0, Ljava/lang/StackOverflowError;

    if-eqz v0, :cond_0

    goto :goto_0

    .line 2
    :cond_0
    check-cast p0, Ljava/lang/Error;

    throw p0

    :cond_1
    :goto_0
    return-void
.end method
