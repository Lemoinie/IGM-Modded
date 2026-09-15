.class public final Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private zza:I


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzda;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza:I

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza:I

    return p0
.end method


# virtual methods
.method public build()Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;
    .locals 2

    .line 1
    iget v0, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza:I

    if-eqz v0, :cond_1

    const/4 v1, 0x5

    if-eq v0, v1, :cond_0

    .line 2
    new-instance v0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams;-><init>(Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;Lcom/android/billingclient/api/zzda;)V

    return-object v0

    .line 1
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Developer billing type must be specified for side by side billing."

    .line 2
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Billing program is not specified."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setBillingProgram(I)Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/BillingProgramReportingDetailsParams$Builder;->zza:I

    return-object p0
.end method
