.class public final Lcom/android/billingclient/api/EnableBillingProgramParams;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;
    }
.end annotation


# instance fields
.field private final zza:I

.field private final zzb:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;Lcom/android/billingclient/api/zzdk;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;->zza(Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;)I

    move-result p2

    iput p2, p0, Lcom/android/billingclient/api/EnableBillingProgramParams;->zza:I

    invoke-static {p1}, Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;->zzb(Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;)Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/EnableBillingProgramParams;->zzb:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    return-void
.end method

.method public static newBuilder()Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;
    .locals 1

    new-instance v0, Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;

    invoke-direct {v0}, Lcom/android/billingclient/api/EnableBillingProgramParams$Builder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public getBillingProgram()I
    .locals 1

    iget v0, p0, Lcom/android/billingclient/api/EnableBillingProgramParams;->zza:I

    return v0
.end method

.method public getDeveloperProvidedBillingListener()Lcom/android/billingclient/api/DeveloperProvidedBillingListener;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/EnableBillingProgramParams;->zzb:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    return-object v0
.end method
