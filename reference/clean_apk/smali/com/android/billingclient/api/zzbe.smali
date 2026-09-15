.class public final synthetic Lcom/android/billingclient/api/zzbe;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/BillingClientImpl;

.field public final synthetic zzb:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzbe;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    iput-object p2, p0, Lcom/android/billingclient/api/zzbe;->zzb:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/android/billingclient/api/zzbe;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    iget-object v1, p0, Lcom/android/billingclient/api/zzbe;->zzb:Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;

    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzab(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ExternalOfferReportingDetailsListener;)V

    return-void
.end method
