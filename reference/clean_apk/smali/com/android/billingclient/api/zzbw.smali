.class final Lcom/android/billingclient/api/zzbw;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field final synthetic zza:Lcom/android/billingclient/api/BillingClientImpl;

.field private final zzb:Lcom/android/billingclient/api/BillingClientStateListener;

.field private final zzc:Lcom/google/android/gms/internal/play_billing/zzbn;

.field private final zzd:Lcom/google/android/gms/internal/play_billing/zzbn;

.field private final zze:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingClientStateListener;ILcom/android/billingclient/api/zzci;)V
    .locals 0

    .line 1
    invoke-static {p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzr(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object p4

    .line 2
    invoke-static {p4}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzc(Lcom/google/android/gms/internal/play_billing/zzbq;)Lcom/google/android/gms/internal/play_billing/zzbn;

    move-result-object p4

    iput-object p4, p0, Lcom/android/billingclient/api/zzbw;->zzc:Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzr(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzbq;

    move-result-object p1

    .line 3
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzc(Lcom/google/android/gms/internal/play_billing/zzbq;)Lcom/google/android/gms/internal/play_billing/zzbn;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/zzbw;->zzd:Lcom/google/android/gms/internal/play_billing/zzbn;

    iput-object p2, p0, Lcom/android/billingclient/api/zzbw;->zzb:Lcom/android/billingclient/api/BillingClientStateListener;

    iput p3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    return-void
.end method

.method public static synthetic zza(Lcom/android/billingclient/api/zzbw;)Ljava/lang/Object;
    .locals 27

    move-object/from16 v7, p0

    .line 1
    iget-object v0, v7, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v2

    const/4 v8, 0x0

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    .line 61
    monitor-exit v1

    :goto_0
    move-object v1, v8

    goto/16 :goto_17

    .line 2
    :cond_0
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v2

    const/4 v4, 0x0

    const/4 v9, 0x1

    if-ne v2, v9, :cond_1

    move v10, v9

    goto :goto_1

    :cond_1
    move v10, v4

    .line 3
    :goto_1
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 4
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    new-instance v1, Landroid/os/Bundle;

    .line 5
    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string v2, "accountName"

    .line 6
    invoke-virtual {v1, v2, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzB(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzC(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzt(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Long;

    move-result-object v6

    .line 7
    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v11

    .line 8
    invoke-static {v1, v2, v5, v11, v12}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    goto :goto_2

    :cond_2
    move-object v1, v8

    :goto_2
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zza:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v5

    monitor-enter v5

    .line 9
    :try_start_1
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzq(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzar;

    move-result-object v11

    .line 10
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v11, :cond_3

    iget-object v0, v7, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    .line 11
    invoke-static {v0, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget v1, v7, Lcom/android/billingclient/api/zzbw;->zze:I

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbc:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 12
    sget-object v3, Lcom/android/billingclient/api/zzdc;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzan(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 13
    invoke-direct {v7, v3}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_0

    :cond_3
    iget-object v0, v7, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v0

    .line 14
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    :try_start_2
    const-string v5, "inapp"

    const/16 v12, 0x19

    .line 15
    invoke-interface {v11, v12, v0, v5}, Lcom/google/android/gms/internal/play_billing/zzar;->zzb(ILjava/lang/String;Ljava/lang/String;)I

    move-result v5
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_d

    if-nez v5, :cond_8

    iget-object v13, v7, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v0

    .line 17
    invoke-static {v0}, Lcom/android/billingclient/api/zzem;->zzb(Landroid/content/Context;)J

    move-result-wide v14

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v0

    .line 18
    invoke-static {v0}, Lcom/android/billingclient/api/zzem;->zzc(Landroid/content/Context;)J

    move-result-wide v0

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v2

    .line 19
    invoke-static {v2}, Lcom/android/billingclient/api/zzem;->zza(Landroid/content/Context;)D

    move-result-wide v16

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v2

    .line 20
    invoke-static {v2}, Lcom/android/billingclient/api/zzem;->zzd(Landroid/content/Context;)J

    move-result-wide v5

    move v2, v4

    move-wide v3, v0

    move-object v0, v8

    :goto_3
    int-to-long v8, v2

    cmp-long v8, v8, v14

    if-gtz v8, :cond_7

    .line 21
    :try_start_3
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0
    :try_end_3
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_b
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_9

    :try_start_4
    new-instance v9, Landroid/os/Bundle;

    .line 22
    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    const-string v1, "callingPackage"

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v19
    :try_end_4
    .catch Ljava/lang/SecurityException; {:try_start_4 .. :try_end_4} :catch_8
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_9

    .line 23
    :try_start_5
    invoke-virtual/range {v19 .. v19}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v12

    .line 24
    invoke-virtual {v9, v1, v12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzB(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzC(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzt(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Long;

    move-result-object v19
    :try_end_5
    .catch Ljava/lang/SecurityException; {:try_start_5 .. :try_end_5} :catch_8
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_7

    move-wide/from16 v20, v3

    move v4, v2

    .line 25
    :try_start_6
    invoke-virtual/range {v19 .. v19}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 26
    invoke-static {v9, v1, v12, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzc;->zzc(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;J)Landroid/os/Bundle;

    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzp(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/PendingPurchasesParams;

    move-result-object v1
    :try_end_6
    .catch Ljava/lang/SecurityException; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    if-eqz v1, :cond_4

    :try_start_7
    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzp(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/PendingPurchasesParams;

    move-result-object v1

    .line 27
    invoke-virtual {v1}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForOneTimeProducts()Z

    move-result v1

    if-eqz v1, :cond_4

    const-string v1, "enablePendingPurchases"

    const/4 v2, 0x1

    .line 28
    invoke-virtual {v9, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V
    :try_end_7
    .catch Ljava/lang/SecurityException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    goto :goto_4

    :catch_0
    move-exception v0

    move v2, v4

    goto/16 :goto_a

    :cond_4
    :goto_4
    :try_start_8
    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzp(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/PendingPurchasesParams;

    move-result-object v1
    :try_end_8
    .catch Ljava/lang/SecurityException; {:try_start_8 .. :try_end_8} :catch_6
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    if-eqz v1, :cond_5

    :try_start_9
    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzp(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/PendingPurchasesParams;

    move-result-object v1

    .line 29
    invoke-virtual {v1}, Lcom/android/billingclient/api/PendingPurchasesParams;->isEnabledForPrepaidPlans()Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "enablePendingPurchaseForSubscriptions"
    :try_end_9
    .catch Ljava/lang/SecurityException; {:try_start_9 .. :try_end_9} :catch_0
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_1

    const/4 v12, 0x1

    .line 30
    :try_start_a
    invoke-virtual {v9, v1, v12}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V
    :try_end_a
    .catch Ljava/lang/SecurityException; {:try_start_a .. :try_end_a} :catch_0
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_5

    goto :goto_5

    :catch_1
    move-exception v0

    const/4 v12, 0x1

    goto :goto_6

    :cond_5
    const/4 v12, 0x1

    :goto_5
    :try_start_b
    invoke-static {v13}, Lcom/android/billingclient/api/BillingClientImpl;->zzc(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v1

    .line 31
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    new-instance v2, Lcom/android/billingclient/api/zzcd;
    :try_end_b
    .catch Ljava/lang/SecurityException; {:try_start_b .. :try_end_b} :catch_6
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_5

    const/16 v18, 0x0

    move-object v1, v2

    move-object v12, v2

    move-object v2, v13

    move-object/from16 v22, v3

    move-wide/from16 v23, v20

    move-object/from16 v3, p0

    move/from16 v20, v4

    move-object v4, v0

    move-object/from16 v21, v13

    move-wide/from16 v25, v14

    move-wide v13, v5

    move/from16 v5, v20

    move-object/from16 v6, v18

    :try_start_c
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/zzcd;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/zzbw;Ljava/lang/Boolean;ILcom/android/billingclient/api/zzci;)V
    :try_end_c
    .catch Ljava/lang/SecurityException; {:try_start_c .. :try_end_c} :catch_4
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_3

    move-object/from16 v0, v22

    const/16 v1, 0x19

    .line 32
    :try_start_d
    invoke-interface {v11, v1, v0, v9, v12}, Lcom/google/android/gms/internal/play_billing/zzar;->zzq(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzak;)V
    :try_end_d
    .catch Ljava/lang/SecurityException; {:try_start_d .. :try_end_d} :catch_4
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_2

    goto/16 :goto_16

    :catch_2
    move-exception v0

    goto :goto_9

    :catch_3
    move-exception v0

    const/16 v1, 0x19

    goto :goto_9

    :catch_4
    move-exception v0

    goto :goto_7

    :catch_5
    move-exception v0

    :goto_6
    move-wide/from16 v25, v14

    move-wide/from16 v23, v20

    const/16 v1, 0x19

    move/from16 v20, v4

    move-object/from16 v21, v13

    goto :goto_8

    :catch_6
    move-exception v0

    move/from16 v20, v4

    :goto_7
    move/from16 v2, v20

    goto/16 :goto_a

    :catch_7
    move-exception v0

    move/from16 v20, v2

    move-wide/from16 v23, v3

    move-object/from16 v21, v13

    move-wide/from16 v25, v14

    const/16 v1, 0x19

    goto :goto_8

    :catch_8
    move-exception v0

    move/from16 v20, v2

    goto :goto_a

    :catch_9
    move-exception v0

    move/from16 v20, v2

    move-wide/from16 v23, v3

    move v1, v12

    move-object/from16 v21, v13

    move-wide/from16 v25, v14

    :goto_8
    move-wide v13, v5

    :goto_9
    if-eqz v8, :cond_6

    .line 39
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Transient error during initialize(), retrying in "

    .line 33
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-wide/from16 v3, v23

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v5, "ms"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v5, "BillingClient"

    invoke-static {v5, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 34
    :try_start_e
    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V
    :try_end_e
    .catch Ljava/lang/InterruptedException; {:try_start_e .. :try_end_e} :catch_a

    long-to-double v2, v3

    mul-double v2, v2, v16

    long-to-double v4, v13

    .line 35
    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    double-to-long v3, v2

    move/from16 v2, v20

    add-int/lit8 v2, v2, 0x1

    move v12, v1

    move-wide v5, v13

    move-object/from16 v13, v21

    move-wide/from16 v14, v25

    goto/16 :goto_3

    :catch_a
    move-exception v0

    move/from16 v2, v20

    move-object v1, v0

    .line 37
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 38
    invoke-direct {v7, v1, v10, v2}, Lcom/android/billingclient/api/zzbw;->zzl(Ljava/lang/Exception;ZI)V

    goto/16 :goto_16

    :cond_6
    move/from16 v2, v20

    goto :goto_b

    :catch_b
    move-exception v0

    .line 39
    :goto_a
    invoke-direct {v7, v0, v10, v2}, Lcom/android/billingclient/api/zzbw;->zzl(Ljava/lang/Exception;ZI)V

    goto/16 :goto_16

    .line 36
    :cond_7
    :goto_b
    invoke-direct {v7, v0, v10, v2}, Lcom/android/billingclient/api/zzbw;->zzl(Ljava/lang/Exception;ZI)V

    goto/16 :goto_16

    :cond_8
    const/16 v5, 0x1c

    move v8, v3

    move v6, v5

    :goto_c
    if-lt v6, v3, :cond_b

    :try_start_f
    const-string v8, "BillingClient"

    new-instance v9, Ljava/lang/StringBuilder;

    .line 40
    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "trying subs apiVersion: "

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    if-nez v1, :cond_9

    const-string v8, "subs"

    .line 41
    invoke-interface {v11, v6, v0, v8}, Lcom/google/android/gms/internal/play_billing/zzar;->zzb(ILjava/lang/String;Ljava/lang/String;)I

    move-result v8

    goto :goto_d

    .line 49
    :cond_9
    const-string v8, "subs"

    .line 42
    invoke-interface {v11, v6, v0, v8, v1}, Lcom/google/android/gms/internal/play_billing/zzar;->zzc(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)I

    move-result v8

    :goto_d
    if-nez v8, :cond_a

    .line 41
    const-string v9, "BillingClient"

    new-instance v12, Ljava/lang/StringBuilder;

    .line 43
    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "highestLevelSupportedForSubs: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v9, v12}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_e

    :cond_a
    add-int/lit8 v6, v6, -0x1

    goto :goto_c

    :catch_c
    move-exception v0

    goto/16 :goto_15

    :cond_b
    move v6, v4

    :goto_e
    iget-object v9, v7, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v12, 0x5

    if-lt v6, v12, :cond_c

    const/4 v12, 0x1

    goto :goto_f

    :cond_c
    move v12, v4

    .line 44
    :goto_f
    invoke-static {v9, v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    if-lt v6, v3, :cond_d

    const/4 v12, 0x1

    goto :goto_10

    :cond_d
    move v12, v4

    .line 45
    :goto_10
    invoke-static {v9, v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzag(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    if-ge v6, v3, :cond_e

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzjn;->zzi:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v6, "BillingClient"

    const-string v12, "In-app billing API does not support subscription on this device."

    .line 46
    invoke-static {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    :cond_e
    :goto_11
    if-lt v5, v3, :cond_11

    const-string v6, "BillingClient"

    new-instance v8, Ljava/lang/StringBuilder;

    .line 47
    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "trying inapp apiVersion: "

    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    if-nez v1, :cond_f

    const-string v6, "inapp"

    .line 48
    invoke-interface {v11, v5, v0, v6}, Lcom/google/android/gms/internal/play_billing/zzar;->zzb(ILjava/lang/String;Ljava/lang/String;)I

    move-result v6

    goto :goto_12

    .line 60
    :cond_f
    const-string v6, "inapp"

    .line 49
    invoke-interface {v11, v5, v0, v6, v1}, Lcom/google/android/gms/internal/play_billing/zzar;->zzc(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)I

    move-result v6

    :goto_12
    move v8, v6

    if-nez v8, :cond_10

    .line 50
    invoke-static {v9, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzad(Lcom/android/billingclient/api/BillingClientImpl;I)V

    const-string v0, "BillingClient"

    invoke-static {v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzb(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v1

    new-instance v5, Ljava/lang/StringBuilder;

    .line 51
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "mHighestLevelSupportedForInApp: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_13

    :cond_10
    add-int/lit8 v5, v5, -0x1

    goto :goto_11

    :cond_11
    :goto_13
    invoke-static {v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzb(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v0

    .line 52
    invoke-static {v9, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzao(Lcom/android/billingclient/api/BillingClientImpl;I)V

    invoke-static {v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzb(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v0

    if-ge v0, v3, :cond_12

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzJ:Lcom/google/android/gms/internal/play_billing/zzjn;

    const-string v1, "BillingClient"

    const-string v2, "In-app billing API version 3 is not supported on this device."

    .line 53
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_14

    :cond_12
    move-object v3, v2

    .line 54
    :goto_14
    invoke-static {v9, v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaq(Lcom/android/billingclient/api/BillingClientImpl;I)V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_c

    if-nez v8, :cond_13

    .line 56
    invoke-direct {v7, v10, v4}, Lcom/android/billingclient/api/zzbw;->zzj(ZI)V

    .line 57
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzi:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {v7, v0}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_16

    .line 58
    :cond_13
    sget-object v0, Lcom/android/billingclient/api/zzdc;->zzb:Lcom/android/billingclient/api/BillingResult;

    const/4 v4, 0x0

    const/4 v6, 0x0

    move-object/from16 v1, p0

    move-object v2, v0

    move v5, v10

    .line 59
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/zzbw;->zzi(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V

    .line 60
    invoke-direct {v7, v0}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_16

    .line 55
    :goto_15
    invoke-direct {v7, v0, v10}, Lcom/android/billingclient/api/zzbw;->zzm(Ljava/lang/Exception;Z)V

    goto :goto_16

    :catch_d
    move-exception v0

    .line 16
    invoke-direct {v7, v0, v10}, Lcom/android/billingclient/api/zzbw;->zzm(Ljava/lang/Exception;Z)V

    :goto_16
    const/4 v1, 0x0

    :goto_17
    return-object v1

    :catchall_0
    move-exception v0

    .line 10
    :try_start_10
    monitor-exit v5
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    throw v0

    :catchall_1
    move-exception v0

    .line 3
    :try_start_11
    monitor-exit v1
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    throw v0
.end method

.method public static synthetic zzb(Lcom/android/billingclient/api/zzbw;)V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzx:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 2
    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzk:Lcom/android/billingclient/api/BillingResult;

    iget v3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    invoke-static {v0, v1, v2, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzan(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 3
    invoke-direct {p0, v2}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method static bridge synthetic zzc(Lcom/android/billingclient/api/zzbw;Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V
    .locals 0

    invoke-direct/range {p0 .. p5}, Lcom/android/billingclient/api/zzbw;->zzi(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V

    return-void
.end method

.method static bridge synthetic zzd(Lcom/android/billingclient/api/zzbw;ZI)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzbw;->zzj(ZI)V

    return-void
.end method

.method static bridge synthetic zze(Lcom/android/billingclient/api/zzbw;Lcom/android/billingclient/api/BillingResult;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzh(Z)Ljava/lang/Long;
    .locals 3

    const/4 v0, 0x0

    if-eqz p1, :cond_1

    .line 1
    :try_start_0
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object p1

    monitor-enter p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/zzbw;->zzc:Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzg()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzf()Lcom/google/android/gms/internal/play_billing/zzbn;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 2
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzbn;->zza(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    monitor-exit p1

    return-object v1

    .line 3
    :cond_0
    monitor-exit p1

    return-object v0

    :catchall_0
    move-exception v1

    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v1

    :cond_1
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object p1

    monitor-enter p1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    :try_start_3
    iget-object v1, p0, Lcom/android/billingclient/api/zzbw;->zzd:Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzg()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 4
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzf()Lcom/google/android/gms/internal/play_billing/zzbn;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzbn;->zza(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    monitor-exit p1

    return-object v1

    .line 6
    :cond_2
    monitor-exit p1

    goto :goto_0

    :catchall_1
    move-exception v1

    monitor-exit p1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :try_start_4
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    :catchall_2
    move-exception p1

    const-string v1, "BillingClient"

    const-string v2, "Exception getting connection establishment duration."

    .line 7
    invoke-static {v1, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_0
    return-object v0
.end method

.method private final zzi(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V
    .locals 2

    .line 1
    :try_start_0
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v0

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    .line 2
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p1

    .line 3
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzb(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 4
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 5
    invoke-virtual {v0, p5}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    if-eqz p3, :cond_0

    .line 6
    invoke-virtual {v0, p3}, Lcom/google/android/gms/internal/play_billing/zzjl;->zza(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    :cond_0
    invoke-direct {p0, p4}, Lcom/android/billingclient/api/zzbw;->zzh(Z)Ljava/lang/Long;

    move-result-object p1

    if-eqz p4, :cond_3

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object p2

    iget p3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    if-lez p3, :cond_1

    const/4 p4, 0x1

    goto :goto_0

    :cond_1
    const/4 p4, 0x0

    .line 9
    :goto_0
    invoke-virtual {p2, p4}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 10
    invoke-virtual {p2, p3}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 11
    invoke-virtual {p2, p5}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    if-eqz p1, :cond_2

    .line 12
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide p3

    .line 13
    invoke-virtual {p2, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzc(J)Lcom/google/android/gms/internal/play_billing/zzlg;

    :cond_2
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    .line 14
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object p3

    .line 15
    invoke-virtual {p3, v0}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    const/4 p4, 0x6

    .line 16
    invoke-virtual {p3, p4}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 17
    invoke-virtual {p3, p2}, Lcom/google/android/gms/internal/play_billing/zzje;->zze(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 18
    invoke-virtual {p3}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzjg;

    .line 19
    invoke-static {p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzal(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjg;)V

    return-void

    .line 20
    :cond_3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzlb;->zza()Lcom/google/android/gms/internal/play_billing/zzkz;

    move-result-object p2

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzkz;->zza(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzkz;

    if-eqz p1, :cond_4

    .line 21
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide p3

    .line 22
    invoke-virtual {p2, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzkz;->zzb(J)Lcom/google/android/gms/internal/play_billing/zzkz;

    :cond_4
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object p1

    .line 23
    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzcz;->zzm(Lcom/google/android/gms/internal/play_billing/zzlb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Unable to log."

    .line 24
    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzj(ZI)V
    .locals 4

    .line 1
    :try_start_0
    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzbw;->zzh(Z)Ljava/lang/Long;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz p1, :cond_2

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjk;->zza()Lcom/google/android/gms/internal/play_billing/zzji;

    move-result-object p1

    const/4 v2, 0x6

    invoke-virtual {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzji;->zze(I)Lcom/google/android/gms/internal/play_billing/zzji;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object v2

    iget v3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    if-lez v3, :cond_0

    const/4 v1, 0x1

    .line 4
    :cond_0
    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 5
    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 6
    invoke-virtual {v2, p2}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    if-eqz v0, :cond_1

    .line 7
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 8
    invoke-virtual {v2, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzc(J)Lcom/google/android/gms/internal/play_billing/zzlg;

    :cond_1
    iget-object p2, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    .line 9
    invoke-virtual {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzji;->zzd(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzji;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzjk;

    .line 10
    invoke-static {p2, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzam(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjk;)V

    return-void

    .line 11
    :cond_2
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzlb;->zza()Lcom/google/android/gms/internal/play_billing/zzkz;

    move-result-object p1

    .line 12
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v2

    .line 13
    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 14
    invoke-virtual {v2, p2}, Lcom/google/android/gms/internal/play_billing/zzjl;->zzc(I)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 15
    invoke-virtual {p1, v2}, Lcom/google/android/gms/internal/play_billing/zzkz;->zza(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzkz;

    if-eqz v0, :cond_3

    .line 16
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 17
    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzkz;->zzb(J)Lcom/google/android/gms/internal/play_billing/zzkz;

    :cond_3
    iget-object p2, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object p2

    .line 18
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzlb;

    invoke-interface {p2, p1}, Lcom/android/billingclient/api/zzcz;->zzm(Lcom/google/android/gms/internal/play_billing/zzlb;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    const-string p2, "BillingClient"

    const-string v0, "Unable to log."

    .line 19
    invoke-static {p2, v0, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private final zzk(Lcom/android/billingclient/api/BillingResult;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v0

    const/4 v2, 0x3

    if-ne v0, v2, :cond_0

    .line 2
    monitor-exit v1

    return-void

    .line 3
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zzb:Lcom/android/billingclient/api/BillingClientStateListener;

    .line 4
    invoke-interface {v0, p1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void

    :catchall_0
    move-exception p1

    .line 3
    const-string v0, "BillingClient"

    const-string v1, "Exception while calling onBillingSetupFinished."

    .line 5
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void

    :catchall_1
    move-exception p1

    .line 3
    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw p1
.end method

.method private final zzl(Ljava/lang/Exception;ZI)V
    .locals 7

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "Exception while invoking initialize AIDL method"

    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 2
    instance-of v0, p1, Landroid/os/DeadObjectException;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbB:Lcom/google/android/gms/internal/play_billing/zzjn;

    :goto_0
    move-object v3, v0

    goto :goto_1

    .line 3
    :cond_0
    instance-of v0, p1, Landroid/os/RemoteException;

    if-eqz v0, :cond_1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbD:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    .line 4
    :cond_1
    instance-of v0, p1, Ljava/lang/SecurityException;

    if-eqz v0, :cond_2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbC:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbA:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    .line 5
    :goto_1
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v1, 0x0

    .line 6
    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    .line 7
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzn(Ljava/lang/Exception;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    move-object v1, p0

    move v5, p2

    move v6, p3

    .line 8
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/zzbw;->zzi(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V

    .line 9
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzn(Ljava/lang/Exception;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method private final zzm(Ljava/lang/Exception;Z)V
    .locals 7

    .line 1
    const-string v0, "BillingClient"

    const-string v1, "Exception while checking if billing is supported; try to reconnect"

    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 2
    instance-of v0, p1, Landroid/os/DeadObjectException;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaM:Lcom/google/android/gms/internal/play_billing/zzjn;

    :goto_0
    move-object v3, v0

    goto :goto_1

    .line 3
    :cond_0
    instance-of v0, p1, Landroid/os/RemoteException;

    if-eqz v0, :cond_1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaL:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    .line 4
    :cond_1
    instance-of v0, p1, Ljava/lang/SecurityException;

    if-eqz v0, :cond_2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaN:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzP:Lcom/google/android/gms/internal/play_billing/zzjn;

    goto :goto_0

    .line 2
    :goto_1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzP:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 5
    invoke-virtual {v3, v0}, Lcom/google/android/gms/internal/play_billing/zzjn;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 6
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    :cond_3
    const/4 v0, 0x0

    :goto_2
    move-object v4, v0

    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v1, 0x0

    .line 7
    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    .line 8
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzn(Ljava/lang/Exception;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    const/4 v6, 0x0

    move-object v1, p0

    move v5, p2

    .line 9
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/zzbw;->zzi(Lcom/android/billingclient/api/BillingResult;Lcom/google/android/gms/internal/play_billing/zzjn;Ljava/lang/String;ZI)V

    .line 10
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzn(Ljava/lang/Exception;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method


# virtual methods
.method public final onBindingDied(Landroid/content/ComponentName;)V
    .locals 5

    .line 1
    const-string p1, "BillingClient"

    const-string v0, "Billing service died."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    const/4 p1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    .line 2
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzau(Lcom/android/billingclient/api/BillingClientImpl;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object v0

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object v1

    const/4 v2, 0x6

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 6
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbf:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object v2

    iget v3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    if-lez v3, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :cond_0
    move v4, p1

    .line 9
    :goto_0
    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 10
    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 11
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zze(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 12
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzjg;

    .line 13
    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzcz;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    goto :goto_1

    .line 19
    :cond_1
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object v0

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjs;->zzb()Lcom/google/android/gms/internal/play_billing/zzjs;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzcz;->zzi(Lcom/google/android/gms/internal/play_billing/zzjs;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    const-string v1, "BillingClient"

    const-string v2, "Unable to log."

    .line 14
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 13
    :goto_1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 15
    :try_start_1
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_3

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v2

    if-nez v2, :cond_2

    goto :goto_2

    .line 16
    :cond_2
    invoke-static {v0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    .line 17
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzar(Lcom/android/billingclient/api/BillingClientImpl;)V

    .line 18
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :try_start_2
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zzb:Lcom/android/billingclient/api/BillingClientStateListener;

    .line 19
    invoke-interface {p1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingServiceDisconnected()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    return-void

    :catchall_1
    move-exception p1

    .line 18
    const-string v0, "BillingClient"

    const-string v1, "Exception while calling onBillingServiceDisconnected."

    .line 20
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void

    .line 21
    :cond_3
    :goto_2
    :try_start_3
    monitor-exit v1

    return-void

    :catchall_2
    move-exception p1

    .line 18
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    throw p1
.end method

.method public final onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 7

    .line 1
    const-string p1, "BillingClient"

    const-string v0, "Billing service connected."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v0

    monitor-enter v0

    .line 2
    :try_start_0
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_0

    .line 11
    monitor-exit v0

    return-void

    .line 3
    :cond_0
    invoke-static {p2}, Lcom/google/android/gms/internal/play_billing/zzaq;->zzu(Landroid/os/IBinder;)Lcom/google/android/gms/internal/play_billing/zzar;

    move-result-object p2

    invoke-static {p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzae(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzar;)V

    .line 4
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    new-instance v1, Lcom/android/billingclient/api/zzbu;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzbu;-><init>(Lcom/android/billingclient/api/zzbw;)V

    new-instance v4, Lcom/android/billingclient/api/zzbv;

    invoke-direct {v4, p0}, Lcom/android/billingclient/api/zzbv;-><init>(Lcom/android/billingclient/api/zzbw;)V

    .line 5
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzf(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/os/Handler;

    move-result-object v5

    .line 6
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzM()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    const-wide/16 v2, 0x7530

    .line 7
    invoke-static/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzN(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Future;

    move-result-object p2

    if-nez p2, :cond_1

    iget p2, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    .line 8
    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzm(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzy:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 9
    invoke-static {p1, v1, v0, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzan(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;I)V

    .line 10
    invoke-direct {p0, v0}, Lcom/android/billingclient/api/zzbw;->zzk(Lcom/android/billingclient/api/BillingResult;)V

    :cond_1
    return-void

    :catchall_0
    move-exception p1

    .line 4
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method public final onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 5

    .line 1
    const-string p1, "BillingClient"

    const-string v0, "Billing service disconnected."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    const/4 p1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    .line 2
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzau(Lcom/android/billingclient/api/BillingClientImpl;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object v0

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjg;->zza()Lcom/google/android/gms/internal/play_billing/zzje;

    move-result-object v1

    const/4 v2, 0x6

    .line 5
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zzp(I)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 6
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzjp;->zza()Lcom/google/android/gms/internal/play_billing/zzjl;

    move-result-object v2

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzjn;->zzbe:Lcom/google/android/gms/internal/play_billing/zzjn;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzjl;->zze(Lcom/google/android/gms/internal/play_billing/zzjn;)Lcom/google/android/gms/internal/play_billing/zzjl;

    .line 7
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zzb(Lcom/google/android/gms/internal/play_billing/zzjl;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzli;->zza()Lcom/google/android/gms/internal/play_billing/zzlg;

    move-result-object v2

    iget v3, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    if-lez v3, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :cond_0
    move v4, p1

    .line 9
    :goto_0
    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzlg;->zza(Z)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 10
    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzlg;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzlg;

    .line 11
    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzje;->zze(Lcom/google/android/gms/internal/play_billing/zzlg;)Lcom/google/android/gms/internal/play_billing/zzje;

    .line 12
    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzi()Lcom/google/android/gms/internal/play_billing/zzgg;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzjg;

    .line 13
    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzcz;->zza(Lcom/google/android/gms/internal/play_billing/zzjg;)V

    goto :goto_1

    .line 19
    :cond_1
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzk(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzcz;

    move-result-object v0

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzlf;->zzb()Lcom/google/android/gms/internal/play_billing/zzlf;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzcz;->zzn(Lcom/google/android/gms/internal/play_billing/zzlf;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    const-string v1, "BillingClient"

    const-string v2, "Unable to log."

    .line 14
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 13
    :goto_1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_1
    iget-object v2, p0, Lcom/android/billingclient/api/zzbw;->zzd:Lcom/google/android/gms/internal/play_billing/zzbn;

    .line 15
    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzd()Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzbn;->zze()Lcom/google/android/gms/internal/play_billing/zzbn;

    .line 16
    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_2

    .line 21
    monitor-exit v1

    return-void

    .line 17
    :cond_2
    invoke-static {v0, p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzap(Lcom/android/billingclient/api/BillingClientImpl;I)V

    .line 18
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :try_start_2
    iget-object p1, p0, Lcom/android/billingclient/api/zzbw;->zzb:Lcom/android/billingclient/api/BillingClientStateListener;

    .line 19
    invoke-interface {p1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingServiceDisconnected()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    return-void

    :catchall_1
    move-exception p1

    .line 18
    const-string v0, "BillingClient"

    const-string v1, "Exception while calling onBillingServiceDisconnected."

    .line 20
    invoke-static {v0, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void

    :catchall_2
    move-exception p1

    .line 18
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    throw p1
.end method

.method public final zzf()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzbw;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;)Ljava/lang/Object;

    move-result-object v0

    monitor-enter v0

    :try_start_0
    iget-object v1, p0, Lcom/android/billingclient/api/zzbw;->zzc:Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zzd()Lcom/google/android/gms/internal/play_billing/zzbn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzbn;->zze()Lcom/google/android/gms/internal/play_billing/zzbn;

    .line 2
    monitor-exit v0

    return-void

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method final zzg()Z
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/zzbw;->zze:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method
