.class final Lcom/android/billingclient/api/zzec;
.super Landroid/content/BroadcastReceiver;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private zza:Lcom/android/billingclient/api/BillingResult;

.field private zzb:Z

.field private final zzc:Lcom/android/billingclient/api/zzcz;


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/zzcz;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/billingclient/api/zzec;->zzb:Z

    iput-object p1, p0, Lcom/android/billingclient/api/zzec;->zzc:Lcom/android/billingclient/api/zzcz;

    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5

    .line 1
    const-string p1, "ProxyBillingReceiver"

    if-nez p2, :cond_0

    const-string p2, "Null intent!"

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    .line 2
    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Received intent action: "

    invoke-virtual {v1, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzn(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.android.vending.billing.IN_APP_BILLING_RESULT_UPDATE_ACTION"

    invoke-static {v0, v1}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const-wide/16 v1, 0x0

    const-string v3, "billingClientTransactionId"

    if-eqz v0, :cond_2

    .line 4
    const-string v0, "RESPONSE_CODE"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v0, "Missing RESPONSE_CODE in intent."

    .line 5
    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzec;->zzc:Lcom/android/billingclient/api/zzcz;

    if-eqz p1, :cond_3

    const/4 v0, 0x0

    .line 6
    invoke-virtual {p2, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v1

    .line 7
    invoke-interface {p1, v0, v1, v2}, Lcom/android/billingclient/api/zzcz;->zzj(Lcom/android/billingclient/api/BillingResult;J)V

    return-void

    :cond_1
    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object p1

    const/4 v4, 0x0

    .line 8
    invoke-virtual {p2, v0, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 9
    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    const-string v0, "DEBUG_MESSAGE"

    .line 10
    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzbo;->zzc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 11
    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    .line 12
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/zzec;->zza:Lcom/android/billingclient/api/BillingResult;

    iget-object v0, p0, Lcom/android/billingclient/api/zzec;->zzc:Lcom/android/billingclient/api/zzcz;

    if-eqz v0, :cond_3

    .line 13
    invoke-virtual {p2, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v1

    .line 14
    invoke-interface {v0, p1, v1, v2}, Lcom/android/billingclient/api/zzcz;->zzj(Lcom/android/billingclient/api/BillingResult;J)V

    return-void

    .line 15
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v4, "com.android.vending.billing.PLAY_BILLING_ACTIVITY_CREATED_ACTION"

    invoke-static {v0, v4}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/android/billingclient/api/zzec;->zzb:Z

    iget-object p1, p0, Lcom/android/billingclient/api/zzec;->zzc:Lcom/android/billingclient/api/zzcz;

    if-eqz p1, :cond_3

    .line 16
    invoke-virtual {p2, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    .line 17
    invoke-interface {p1, v0, v1}, Lcom/android/billingclient/api/zzcz;->zzk(J)V

    :cond_3
    return-void

    .line 18
    :cond_4
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    const-string v0, "Unexpected broadcast action: "

    invoke-virtual {v0, p2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method final zza()Lcom/android/billingclient/api/BillingResult;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/zzec;->zza:Lcom/android/billingclient/api/BillingResult;

    return-object v0
.end method

.method final zzb()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/billingclient/api/zzec;->zza:Lcom/android/billingclient/api/BillingResult;

    return-void
.end method

.method final zzc()Z
    .locals 1

    iget-boolean v0, p0, Lcom/android/billingclient/api/zzec;->zzb:Z

    return v0
.end method
