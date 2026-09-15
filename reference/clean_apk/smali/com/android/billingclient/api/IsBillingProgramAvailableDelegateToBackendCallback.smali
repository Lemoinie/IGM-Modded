.class final Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;
.super Lcom/google/android/gms/internal/play_billing/zzab;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static final TAG:Ljava/lang/String; = "IsBillingProgramAvailableDelegateToBackendCallback"


# instance fields
.field final billingApiVersion:I

.field final billingLogger:Lcom/android/billingclient/api/zzcz;

.field final billingProgram:I

.field final executorService:Ljava/util/concurrent/ExecutorService;

.field final handler:Landroid/os/Handler;

.field final listener:Lcom/android/billingclient/api/BillingProgramAvailabilityListener;


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingProgramAvailabilityListener;ILcom/android/billingclient/api/zzcz;ILandroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzab;-><init>()V

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramAvailabilityListener;

    iput p2, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingProgram:I

    iput-object p3, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    iput p4, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingApiVersion:I

    iput-object p5, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->handler:Landroid/os/Handler;

    iput-object p6, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public onDelegateToBackendResponse(Landroid/os/Bundle;)V
    .locals 6

    .line 1
    new-instance v0, Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;

    iget v1, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingProgram:I

    invoke-direct {v0, v1}, Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;-><init>(I)V

    if-nez p1, :cond_0

    iget-object p1, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaT:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/android/billingclient/api/zzdf;->zzb:Lcom/android/billingclient/api/zzdf;

    .line 2
    invoke-virtual {v3}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v3

    iget v4, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingApiVersion:I

    .line 1
    invoke-static {v1, v2, p1, v3, v4}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    iget-object p1, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramAvailabilityListener;

    .line 3
    invoke-interface {p1, v2, v0}, Lcom/android/billingclient/api/BillingProgramAvailabilityListener;->onBillingProgramAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;)V

    return-void

    .line 4
    :cond_0
    sget-object v1, Lcom/android/billingclient/api/zzdf;->zzb:Lcom/android/billingclient/api/zzdf;

    .line 5
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v2

    iget-object v3, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    iget v4, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingApiVersion:I

    const-string v5, "IsBillingProgramAvailableDelegateToBackendCallback"

    .line 6
    invoke-static {p1, v5, v2, v3, v4}, Lcom/android/billingclient/api/zzdh;->zza(Landroid/os/Bundle;Ljava/lang/String;ILcom/android/billingclient/api/zzcz;I)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v2, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramAvailabilityListener;

    if-nez v2, :cond_1

    iget-object v0, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaR:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v1

    iget v3, p0, Lcom/android/billingclient/api/IsBillingProgramAvailableDelegateToBackendCallback;->billingApiVersion:I

    .line 8
    invoke-static {v2, p1, v0, v1, v3}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    return-void

    .line 9
    :cond_1
    invoke-interface {v2, p1, v0}, Lcom/android/billingclient/api/BillingProgramAvailabilityListener;->onBillingProgramAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramAvailabilityDetails;)V

    return-void
.end method
