.class final Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;
.super Lcom/google/android/gms/internal/play_billing/zzab;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static final DELEGATE_TO_BACKEND_RESPONSE_DATA_KEY:Ljava/lang/String; = "RESPONSE_DATA"

.field private static final TAG:Ljava/lang/String; = "CreateBillingProgramReportingDetailsDelegateToBackendCallback"


# instance fields
.field final billingApiVersion:I

.field final billingLogger:Lcom/android/billingclient/api/zzcz;

.field final billingProgram:I

.field final executorService:Ljava/util/concurrent/ExecutorService;

.field final handler:Landroid/os/Handler;

.field final listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;ILcom/android/billingclient/api/zzcz;ILandroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzab;-><init>()V

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;

    iput p2, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingProgram:I

    iput-object p3, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    iput p4, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingApiVersion:I

    iput-object p5, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->handler:Landroid/os/Handler;

    iput-object p6, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method private parseReportingDetails(Landroid/os/Bundle;)Lcom/android/billingclient/api/BillingProgramReportingDetails;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 1
    const-string v0, "RESPONSE_DATA"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getByteArray(Ljava/lang/String;)[B

    move-result-object p1

    if-eqz p1, :cond_0

    .line 3
    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzdu;->zzb([B)Lcom/google/android/gms/internal/play_billing/zzdu;

    move-result-object p1

    new-instance v0, Lcom/android/billingclient/api/BillingProgramReportingDetails;

    .line 4
    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzdu;->zzc()Lcom/google/android/gms/internal/play_billing/zzea;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc()Ljava/lang/String;

    move-result-object p1

    iget v1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingProgram:I

    invoke-direct {v0, p1, v1}, Lcom/android/billingclient/api/BillingProgramReportingDetails;-><init>(Ljava/lang/String;I)V

    return-object v0

    .line 1
    :cond_0
    new-instance p1, Ljava/lang/Exception;

    const-string v0, "Response data is null"

    .line 2
    invoke-direct {p1, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private returnListenerResponseOnSuccess(Lcom/android/billingclient/api/BillingResult;Landroid/os/Bundle;)V
    .locals 7

    .line 1
    :try_start_0
    invoke-direct {p0, p2}, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->parseReportingDetails(Landroid/os/Bundle;)Lcom/android/billingclient/api/BillingProgramReportingDetails;

    move-result-object p2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    iget-object v0, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;

    .line 7
    invoke-interface {v0, p1, p2}, Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;->onCreateBillingProgramReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramReportingDetails;)V

    return-void

    :catch_0
    move-exception p1

    const-string p2, "CreateBillingProgramReportingDetailsDelegateToBackendCallback"

    const-string v0, "Got a JSON exception trying to decode billing program reporting details."

    .line 2
    invoke-static {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaS:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 3
    sget-object p2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v0, Lcom/android/billingclient/api/zzdf;->zzc:Lcom/android/billingclient/api/zzdf;

    .line 4
    invoke-virtual {v0}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v4

    iget v5, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingApiVersion:I

    .line 5
    invoke-static {p1}, Lcom/android/billingclient/api/zzcy;->zza(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v6

    move-object v2, p2

    .line 3
    invoke-static/range {v1 .. v6}, Lcom/android/billingclient/api/zzde;->zzb(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;IILjava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;

    const/4 v0, 0x0

    .line 6
    invoke-interface {p1, p2, v0}, Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;->onCreateBillingProgramReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramReportingDetails;)V

    return-void
.end method


# virtual methods
.method public onDelegateToBackendResponse(Landroid/os/Bundle;)V
    .locals 6

    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaT:Lcom/google/android/gms/internal/play_billing/zzjn;

    sget-object v2, Lcom/android/billingclient/api/zzdc;->zzh:Lcom/android/billingclient/api/BillingResult;

    sget-object v3, Lcom/android/billingclient/api/zzdf;->zzc:Lcom/android/billingclient/api/zzdf;

    .line 2
    invoke-virtual {v3}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v3

    iget v4, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingApiVersion:I

    .line 1
    invoke-static {v1, v2, p1, v3, v4}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    iget-object p1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;

    .line 3
    invoke-interface {p1, v2, v0}, Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;->onCreateBillingProgramReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramReportingDetails;)V

    return-void

    .line 4
    :cond_0
    sget-object v1, Lcom/android/billingclient/api/zzdf;->zzc:Lcom/android/billingclient/api/zzdf;

    .line 5
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v2

    iget-object v3, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    iget v4, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingApiVersion:I

    const-string v5, "CreateBillingProgramReportingDetailsDelegateToBackendCallback"

    .line 6
    invoke-static {p1, v5, v2, v3, v4}, Lcom/android/billingclient/api/zzdh;->zza(Landroid/os/Bundle;Ljava/lang/String;ILcom/android/billingclient/api/zzcz;I)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    iget-object v3, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->listener:Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;

    if-nez v3, :cond_1

    iget-object p1, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingLogger:Lcom/android/billingclient/api/zzcz;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzjn;->zzaR:Lcom/google/android/gms/internal/play_billing/zzjn;

    .line 7
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzdf;->zzb()I

    move-result v1

    iget v3, p0, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->billingApiVersion:I

    .line 8
    invoke-static {v0, v2, p1, v1, v3}, Lcom/android/billingclient/api/zzde;->zza(Lcom/google/android/gms/internal/play_billing/zzjn;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/zzcz;II)V

    return-void

    :cond_1
    invoke-virtual {v2}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    if-eqz v1, :cond_2

    .line 9
    invoke-interface {v3, v2, v0}, Lcom/android/billingclient/api/BillingProgramReportingDetailsListener;->onCreateBillingProgramReportingDetailsResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingProgramReportingDetails;)V

    return-void

    .line 10
    :cond_2
    invoke-direct {p0, v2, p1}, Lcom/android/billingclient/api/CreateBillingProgramReportingDetailsDelegateToBackendCallback;->returnListenerResponseOnSuccess(Lcom/android/billingclient/api/BillingResult;Landroid/os/Bundle;)V

    return-void
.end method
