.class public final synthetic Lcom/android/billingclient/api/zzbv;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/zzbw;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzbw;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzbv;->zza:Lcom/android/billingclient/api/zzbw;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/zzbv;->zza:Lcom/android/billingclient/api/zzbw;

    invoke-static {v0}, Lcom/android/billingclient/api/zzbw;->zzb(Lcom/android/billingclient/api/zzbw;)V

    return-void
.end method
