.class final Lcom/android/billingclient/api/zzcc;
.super Lcom/google/android/gms/internal/play_billing/zzah;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field final zza:Ljava/lang/ref/WeakReference;

.field final zzb:Landroid/os/ResultReceiver;

.field final synthetic zzc:Lcom/android/billingclient/api/BillingClientImpl;


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/ref/WeakReference;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;Lcom/android/billingclient/api/zzci;)V
    .locals 0

    .line 1
    invoke-static {p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/android/billingclient/api/zzcc;->zzc:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzah;-><init>()V

    iput-object p2, p0, Lcom/android/billingclient/api/zzcc;->zza:Ljava/lang/ref/WeakReference;

    .line 2
    invoke-static {p1, p3}, Lcom/android/billingclient/api/BillingClientImpl;->zzg(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/LaunchExternalLinkResponseListener;)Landroid/os/ResultReceiver;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    return-void
.end method


# virtual methods
.method public final zza(Landroid/os/Bundle;)V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    const/16 v0, 0x25

    const/4 v1, 0x6

    .line 1
    const-string v2, "BillingClient"

    if-nez p1, :cond_0

    const-string p1, "Response bundle is null."

    invoke-static {v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzcc;->zzc:Lcom/android/billingclient/api/BillingClientImpl;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbr:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-static {p1, v2, v0, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    const/4 v0, 0x0

    .line 3
    invoke-virtual {p1, v1, v0}, Landroid/os/ResultReceiver;->send(ILandroid/os/Bundle;)V

    return-void

    .line 4
    :cond_0
    const-string v3, "RESPONSE_CODE"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v3, "Response bundle doesn\'t contain a response code."

    .line 5
    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/android/billingclient/api/zzcc;->zzc:Lcom/android/billingclient/api/BillingClientImpl;

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbw:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 6
    sget-object v4, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v3, v0, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzaw(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;ILcom/android/billingclient/api/BillingResult;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    .line 7
    invoke-virtual {v0, v1, p1}, Landroid/os/ResultReceiver;->send(ILandroid/os/Bundle;)V

    return-void

    .line 8
    :cond_1
    invoke-static {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_2

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Unable to launch intent for launch external link dialog. Response code: "

    .line 9
    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    .line 10
    invoke-virtual {v1, v0, p1}, Landroid/os/ResultReceiver;->send(ILandroid/os/Bundle;)V

    return-void

    :cond_2
    const-string v0, "EXTERNAL_PAYMENT_DIALOG_INTENT"

    .line 11
    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/app/PendingIntent;

    const-string v4, "An internal error occurred."

    const-string v5, "DEBUG_MESSAGE"

    if-nez v0, :cond_3

    const-string v0, "Pending intent not found in response bundle."

    .line 12
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Landroid/os/Bundle;

    .line 13
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 14
    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 15
    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    .line 16
    invoke-virtual {v0, v1, p1}, Landroid/os/ResultReceiver;->send(ILandroid/os/Bundle;)V

    return-void

    :cond_3
    :try_start_0
    iget-object p1, p0, Lcom/android/billingclient/api/zzcc;->zza:Ljava/lang/ref/WeakReference;

    .line 17
    invoke-virtual {p1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/Activity;

    new-instance v6, Landroid/content/Intent;

    const-class v7, Lcom/android/billingclient/api/ProxyBillingActivityV2;

    .line 18
    invoke-direct {v6, p1, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v7, "launch_external_link_result_receiver"

    iget-object v8, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    .line 19
    invoke-virtual {v6, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    const-string v7, "launch_external_link_flow_pending_intent"

    .line 20
    invoke-virtual {v6, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 21
    invoke-virtual {p1, v6}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    const-string v0, "Runtime error while launching intent for launch external link dialog."

    .line 22
    invoke-static {v2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v0, Landroid/os/Bundle;

    .line 23
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 24
    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 25
    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbE:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 26
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzjn;->zza()I

    move-result v2

    const-string v3, "INTERNAL_LOG_ERROR_REASON"

    .line 27
    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 28
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzbo;->zzc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    filled-new-array {v2, p1}, [Ljava/lang/Object;

    move-result-object p1

    const-string v2, "%s: %s"

    invoke-static {v2, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS"

    .line 29
    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzcc;->zzb:Landroid/os/ResultReceiver;

    .line 30
    invoke-virtual {p1, v1, v0}, Landroid/os/ResultReceiver;->send(ILandroid/os/Bundle;)V

    return-void
.end method
