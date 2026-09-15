.class public final Lcom/google/android/gms/internal/ads/zzgml;
.super Lcom/google/android/gms/internal/ads/zzgmi;
.source "com.google.android.gms:play-services-ads@@23.0.0"


# direct methods
.method public constructor <init>([BI)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;
        }
    .end annotation

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/ads/zzgmi;-><init>([BI)V

    return-void
.end method


# virtual methods
.method final zza()I
    .locals 1

    const/16 v0, 0x18

    return v0
.end method

.method final zzb([II)[I
    .locals 11

    .line 1
    array-length v0, p1

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    const/16 v0, 0x10

    .line 2
    new-array v2, v0, [I

    iget-object v3, p0, Lcom/google/android/gms/internal/ads/zzgml;->zza:[I

    new-array v0, v0, [I

    .line 3
    invoke-static {v0, v3}, Lcom/google/android/gms/internal/ads/zzgme;->zzb([I[I)V

    const/4 v3, 0x0

    .line 4
    aget v4, p1, v3

    const/16 v5, 0xc

    aput v4, v0, v5

    const/4 v4, 0x1

    .line 5
    aget v4, p1, v4

    const/16 v6, 0xd

    aput v4, v0, v6

    const/4 v4, 0x2

    .line 6
    aget v4, p1, v4

    const/16 v7, 0xe

    aput v4, v0, v7

    const/4 v4, 0x3

    .line 7
    aget v4, p1, v4

    const/16 v8, 0xf

    aput v4, v0, v8

    .line 8
    invoke-static {v0}, Lcom/google/android/gms/internal/ads/zzgme;->zzc([I)V

    aget v4, v0, v5

    const/4 v9, 0x4

    aput v4, v0, v9

    aget v4, v0, v6

    const/4 v10, 0x5

    aput v4, v0, v10

    aget v4, v0, v7

    aput v4, v0, v1

    aget v1, v0, v8

    const/4 v4, 0x7

    aput v1, v0, v4

    const/16 v1, 0x8

    .line 9
    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    .line 10
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/ads/zzgme;->zzb([I[I)V

    aput p2, v2, v5

    aput v3, v2, v6

    .line 11
    aget p2, p1, v9

    aput p2, v2, v7

    .line 12
    aget p1, p1, v10

    aput p1, v2, v8

    return-object v2

    .line 1
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    mul-int/lit8 v0, v0, 0x20

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    filled-new-array {p2}, [Ljava/lang/Object;

    move-result-object p2

    const-string v0, "XChaCha20 uses 192-bit nonces, but got a %d-bit nonce"

    .line 2
    invoke-static {v0, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
