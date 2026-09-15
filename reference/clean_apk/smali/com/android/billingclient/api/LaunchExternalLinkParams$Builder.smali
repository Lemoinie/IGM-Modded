.class public final Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/LaunchExternalLinkParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private zza:Landroid/net/Uri;

.field private zzb:I

.field private zzc:I

.field private zzd:I


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb:I

    iput v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    iput v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzdt;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb:I

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd:I

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd:I

    return p0
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb:I

    return p0
.end method

.method static bridge synthetic zzc(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I
    .locals 0

    iget p0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    return p0
.end method

.method static bridge synthetic zzd(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)Landroid/net/Uri;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zza:Landroid/net/Uri;

    return-object p0
.end method


# virtual methods
.method public build()Lcom/android/billingclient/api/LaunchExternalLinkParams;
    .locals 4

    .line 1
    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    if-eqz v0, :cond_9

    iget v1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb:I

    if-eqz v1, :cond_8

    const/4 v2, 0x1

    if-eq v1, v2, :cond_1

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    goto :goto_0

    .line 9
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "App downloads must launch in an external browser or app."

    .line 10
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2
    :cond_1
    :goto_0
    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd:I

    if-eqz v0, :cond_7

    const/4 v1, 0x5

    const/4 v3, 0x0

    if-ne v0, v1, :cond_4

    .line 4
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 5
    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    if-ne v0, v2, :cond_2

    goto :goto_1

    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Link type must be LINK_TO_DIGITAL_CONTENT_OFFER for side by side billing with an external link."

    .line 6
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 4
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "External transaction token is required for side by side billing with an external link."

    .line 5
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 6
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zza:Landroid/net/Uri;

    if-eqz v0, :cond_6

    .line 8
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 10
    new-instance v0, Lcom/android/billingclient/api/LaunchExternalLinkParams;

    invoke-direct {v0, p0, v3}, Lcom/android/billingclient/api/LaunchExternalLinkParams;-><init>(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;Lcom/android/billingclient/api/zzdt;)V

    return-object v0

    .line 8
    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URI must have a scheme."

    .line 9
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 6
    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URI must be set."

    .line 7
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2
    :cond_7
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Billing program is required."

    .line 3
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1
    :cond_8
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Launch mode is required."

    .line 2
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1
    :cond_9
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Link type is required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setBillingProgram(I)Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd:I

    return-object p0
.end method

.method public setLaunchMode(I)Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb:I

    return-object p0
.end method

.method public setLinkType(I)Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
    .locals 0

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc:I

    return-object p0
.end method

.method public setLinkUri(Landroid/net/Uri;)Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zza:Landroid/net/Uri;

    return-object p0
.end method
