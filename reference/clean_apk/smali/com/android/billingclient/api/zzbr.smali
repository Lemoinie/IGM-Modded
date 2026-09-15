.class public final synthetic Lcom/android/billingclient/api/zzbr;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/zzbs;

.field public final synthetic zzb:Lcom/android/billingclient/api/BillingResult;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzbs;Lcom/android/billingclient/api/BillingResult;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzbr;->zza:Lcom/android/billingclient/api/zzbs;

    iput-object p2, p0, Lcom/android/billingclient/api/zzbr;->zzb:Lcom/android/billingclient/api/BillingResult;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbr;->zza:Lcom/android/billingclient/api/zzbs;

    iget-object v1, p0, Lcom/android/billingclient/api/zzbr;->zzb:Lcom/android/billingclient/api/BillingResult;

    :try_start_0
    iget-object v0, v0, Lcom/android/billingclient/api/zzbs;->zzb:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingClientStateListener;

    move-result-object v0

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    const-string v1, "BillingClient"

    const-string v2, "Exception calling onBillingSetupFinished."

    .line 2
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method
