.class final Lcom/android/billingclient/api/zzdh;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# direct methods
.method public static zza(Landroid/os/Bundle;Ljava/lang/String;ILcom/android/billingclient/api/zzcz;I)Lcom/android/billingclient/api/BillingResult;
    .locals 7

    .line 1
    const-string v0, "BILLING_RESULT"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2
    :try_start_0
    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getByteArray(Ljava/lang/String;)[B

    move-result-object v0

    if-eqz v0, :cond_2

    .line 4
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzeh;->zzc([B)Lcom/google/android/gms/internal/play_billing/zzeh;

    move-result-object v0

    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object v1

    .line 5
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzeh;->zza()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    .line 6
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzeh;->zze()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    .line 7
    invoke-virtual {v1}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    if-eqz v1, :cond_0

    sget-object p0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzw:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 8
    invoke-static {p0, v0, p3, p2, p4}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    return-object v0

    :cond_0
    const-string v1, "RESPONSE_DATA"

    .line 9
    invoke-virtual {p0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result p0

    if-nez p0, :cond_1

    const-string p0, "delegateToBackendAsync returned a bundle with neither an error nor response data"

    .line 10
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaW:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 11
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-static {p0, v0, p3, p2, p4}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    :cond_1
    return-object v0

    .line 2
    :cond_2
    new-instance p0, Ljava/lang/Exception;

    const-string v0, "Billing result is null"

    .line 3
    invoke-direct {p0, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception p0

    .line 16
    const-string v0, "Failed parsing BillingResult."

    .line 12
    invoke-static {p1, v0, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaV:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 13
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    .line 14
    invoke-static {p0}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v6

    move-object v2, p1

    move-object v3, p3

    move v4, p2

    move v5, p4

    .line 13
    invoke-static/range {v1 .. v6}, Lcom/android/billingclient/api/zzde;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;IILjava/lang/String;)V

    return-object p1

    .line 11
    :cond_3
    const-string p0, "delegateToBackendAsync does not contain a billing result in the response"

    .line 15
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaU:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 16
    sget-object p1, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-static {p0, p1, p3, p2, p4}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    return-object p1
.end method
