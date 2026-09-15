.class public final synthetic Lcom/android/billingclient/api/zzcq;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Landroidx/core/util/Consumer;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/zzcw;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzcw;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzcq;->zza:Lcom/android/billingclient/api/zzcw;

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/zzcq;->zza:Lcom/android/billingclient/api/zzcw;

    check-cast p1, Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, p1}, Lcom/android/billingclient/api/zzcw;->zzaB(Lcom/android/billingclient/api/zzcw;Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method
