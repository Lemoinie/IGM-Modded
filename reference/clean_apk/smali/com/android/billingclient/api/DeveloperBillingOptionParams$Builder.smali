.class public final Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/DeveloperBillingOptionParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private zza:Landroid/net/Uri;

.field private zzb:I

.field private zzc:I


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzb:I

    iput v0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzc:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzdi;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzb:I

    iput p1, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzc:I

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzc:I

    return p0
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzb:I

    return p0
.end method

.method static bridge synthetic zzc(Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;)Landroid/net/Uri;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zza:Landroid/net/Uri;

    return-object p0
.end method


# virtual methods
.method public build()Lcom/android/billingclient/api/DeveloperBillingOptionParams;
    .locals 3

    .line 1
    iget v0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzc:I

    if-eqz v0, :cond_4

    const/4 v1, 0x5

    const/4 v2, 0x0

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zza:Landroid/net/Uri;

    if-eqz v0, :cond_1

    .line 2
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "External transaction token is required for side by side billing with an external link."

    .line 3
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zza:Landroid/net/Uri;

    if-eqz v0, :cond_3

    .line 4
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    goto :goto_1

    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URI must have a scheme."

    .line 5
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    :goto_1
    new-instance v0, Lcom/android/billingclient/api/DeveloperBillingOptionParams;

    invoke-direct {v0, p0, v2}, Lcom/android/billingclient/api/DeveloperBillingOptionParams;-><init>(Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;Lcom/android/billingclient/api/zzdi;)V

    return-object v0

    .line 1
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Billing program is required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setBillingProgram(I)Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzc:I

    return-object p0
.end method

.method public setLaunchMode(I)Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zzb:I

    return-object p0
.end method

.method public setLinkUri(Landroid/net/Uri;)Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/DeveloperBillingOptionParams$Builder;->zza:Landroid/net/Uri;

    return-object p0
.end method
