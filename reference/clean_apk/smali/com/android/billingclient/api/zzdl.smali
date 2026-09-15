.class final Lcom/android/billingclient/api/zzdl;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static zza:Z = false

.field private static zzb:J = 0xbb8L

.field private static zzc:J = 0x7530L

.field private static zzd:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method static zza()I
    .locals 1

    sget v0, Lcom/android/billingclient/api/zzdl;->zzd:I

    return v0
.end method

.method static zzb()J
    .locals 2

    sget-wide v0, Lcom/android/billingclient/api/zzdl;->zzc:J

    return-wide v0
.end method

.method static zzc()J
    .locals 2

    sget-wide v0, Lcom/android/billingclient/api/zzdl;->zzb:J

    return-wide v0
.end method

.method static zzd(J)V
    .locals 0

    sput-wide p0, Lcom/android/billingclient/api/zzdl;->zzc:J

    return-void
.end method

.method static zze(I)V
    .locals 0

    sput p0, Lcom/android/billingclient/api/zzdl;->zzd:I

    return-void
.end method

.method static zzf(J)V
    .locals 0

    sput-wide p0, Lcom/android/billingclient/api/zzdl;->zzb:J

    return-void
.end method

.method static zzg(Z)V
    .locals 0

    sput-boolean p0, Lcom/android/billingclient/api/zzdl;->zza:Z

    return-void
.end method

.method static zzh()Z
    .locals 1

    sget-boolean v0, Lcom/android/billingclient/api/zzdl;->zza:Z

    return v0
.end method
