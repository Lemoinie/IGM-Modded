.class public final Lcom/android/billingclient/api/LaunchExternalLinkParams;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;,
        Lcom/android/billingclient/api/LaunchExternalLinkParams$LinkType;,
        Lcom/android/billingclient/api/LaunchExternalLinkParams$LaunchMode;
    }
.end annotation


# instance fields
.field private final zza:Landroid/net/Uri;

.field private final zzb:I

.field private final zzc:I

.field private final zzd:I


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;Lcom/android/billingclient/api/zzdt;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzd(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)Landroid/net/Uri;

    move-result-object p2

    iput-object p2, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zza:Landroid/net/Uri;

    invoke-static {p1}, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzb(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I

    move-result p2

    iput p2, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzb:I

    invoke-static {p1}, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zzc(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I

    move-result p2

    iput p2, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzc:I

    invoke-static {p1}, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;->zza(Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;)I

    move-result p1

    iput p1, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzd:I

    return-void
.end method

.method public static newBuilder()Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;
    .locals 2

    new-instance v0, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/android/billingclient/api/LaunchExternalLinkParams$Builder;-><init>(Lcom/android/billingclient/api/zzdt;)V

    return-object v0
.end method


# virtual methods
.method public getBillingProgram()I
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzd:I

    return v0
.end method

.method public getLaunchMode()I
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzb:I

    return v0
.end method

.method public getLinkType()I
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zzc:I

    return v0
.end method

.method public getLinkUri()Landroid/net/Uri;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/LaunchExternalLinkParams;->zza:Landroid/net/Uri;

    return-object v0
.end method
