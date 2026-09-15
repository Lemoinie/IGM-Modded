.class public final Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;
    }
.end annotation


# instance fields
.field private final zza:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;Lcom/android/billingclient/api/zzda;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza(Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;)I

    move-result p1

    iput p1, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->zza:I

    return-void
.end method

.method public static newBuilder()Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;
    .locals 2

    new-instance v0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;-><init>(Lcom/android/billingclient/api/zzda;)V

    return-object v0
.end method


# virtual methods
.method public getBillingProgram()I
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;->zza:I

    return v0
.end method
