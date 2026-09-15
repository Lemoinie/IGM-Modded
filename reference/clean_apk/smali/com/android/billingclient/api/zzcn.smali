.class public final synthetic Lcom/android/billingclient/api/zzcn;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzr;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/zzcw;

.field public final synthetic zzb:I


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzcw;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzcn;->zza:Lcom/android/billingclient/api/zzcw;

    iput p2, p0, Lcom/android/billingclient/api/zzcn;->zzb:I

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzp;)Ljava/lang/Object;
    .locals 2

    iget-object v0, p0, Lcom/android/billingclient/api/zzcn;->zza:Lcom/android/billingclient/api/zzcw;

    iget v1, p0, Lcom/android/billingclient/api/zzcn;->zzb:I

    invoke-static {v0, v1, p1}, Lcom/android/billingclient/api/zzcw;->zzaH(Lcom/android/billingclient/api/zzcw;ILcom/google/android/gms/internal/play_billing/zzp;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
