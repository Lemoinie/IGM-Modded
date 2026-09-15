.class public Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private oldProductId:Ljava/lang/String;

.field private replacementMode:I


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;->replacementMode:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzcx;)V
    .locals 0

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public build()Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;
    .locals 2

    .line 1
    new-instance v0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;

    invoke-direct {v0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;-><init>()V

    iget-object v1, p0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;->oldProductId:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;->-$$Nest$fputoldProductId(Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;Ljava/lang/String;)V

    iget v1, p0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;->replacementMode:I

    .line 2
    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;->-$$Nest$fputreplacementMode(Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams;I)V

    return-object v0
.end method

.method public setOldProductId(Ljava/lang/String;)Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;->oldProductId:Ljava/lang/String;

    return-object p0
.end method

.method public setReplacementMode(I)Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$SubscriptionProductReplacementParams$Builder;->replacementMode:I

    return-object p0
.end method
