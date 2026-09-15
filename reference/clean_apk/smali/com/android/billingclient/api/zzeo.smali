.class public final enum Lcom/android/billingclient/api/zzeo;
.super Ljava/lang/Enum;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field public static final enum zza:Lcom/android/billingclient/api/zzeo;

.field public static final enum zzb:Lcom/android/billingclient/api/zzeo;

.field public static final enum zzc:Lcom/android/billingclient/api/zzeo;

.field public static final enum zzd:Lcom/android/billingclient/api/zzeo;

.field public static final enum zze:Lcom/android/billingclient/api/zzeo;

.field public static final enum zzf:Lcom/android/billingclient/api/zzeo;

.field public static final enum zzg:Lcom/android/billingclient/api/zzeo;

.field private static final synthetic zzh:[Lcom/android/billingclient/api/zzeo;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzeo;

    const-string v1, "CANCEL"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/billingclient/api/zzeo;->zza:Lcom/android/billingclient/api/zzeo;

    new-instance v1, Lcom/android/billingclient/api/zzeo;

    const-string v2, "RESTORE"

    const/4 v3, 0x1

    .line 2
    invoke-direct {v1, v2, v3}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lcom/android/billingclient/api/zzeo;->zzb:Lcom/android/billingclient/api/zzeo;

    new-instance v2, Lcom/android/billingclient/api/zzeo;

    const-string v3, "PAUSE"

    const/4 v4, 0x2

    .line 3
    invoke-direct {v2, v3, v4}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v2, Lcom/android/billingclient/api/zzeo;->zzc:Lcom/android/billingclient/api/zzeo;

    new-instance v3, Lcom/android/billingclient/api/zzeo;

    const-string v4, "RESUME"

    const/4 v5, 0x3

    .line 4
    invoke-direct {v3, v4, v5}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lcom/android/billingclient/api/zzeo;->zzd:Lcom/android/billingclient/api/zzeo;

    new-instance v4, Lcom/android/billingclient/api/zzeo;

    const-string v5, "FIX_PAYMENT"

    const/4 v6, 0x4

    .line 5
    invoke-direct {v4, v5, v6}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v4, Lcom/android/billingclient/api/zzeo;->zze:Lcom/android/billingclient/api/zzeo;

    new-instance v5, Lcom/android/billingclient/api/zzeo;

    const-string v6, "CONFIRM_PRICE_CHANGE"

    const/4 v7, 0x5

    .line 6
    invoke-direct {v5, v6, v7}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lcom/android/billingclient/api/zzeo;->zzf:Lcom/android/billingclient/api/zzeo;

    new-instance v6, Lcom/android/billingclient/api/zzeo;

    const-string v7, "CONFIRM_PRICE_STEP_UP"

    const/4 v8, 0x6

    .line 7
    invoke-direct {v6, v7, v8}, Lcom/android/billingclient/api/zzeo;-><init>(Ljava/lang/String;I)V

    sput-object v6, Lcom/android/billingclient/api/zzeo;->zzg:Lcom/android/billingclient/api/zzeo;

    filled-new-array/range {v0 .. v6}, [Lcom/android/billingclient/api/zzeo;

    move-result-object v0

    sput-object v0, Lcom/android/billingclient/api/zzeo;->zzh:[Lcom/android/billingclient/api/zzeo;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static values()[Lcom/android/billingclient/api/zzeo;
    .locals 1

    .line 1
    sget-object v0, Lcom/android/billingclient/api/zzeo;->zzh:[Lcom/android/billingclient/api/zzeo;

    invoke-virtual {v0}, [Lcom/android/billingclient/api/zzeo;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/billingclient/api/zzeo;

    return-object v0
.end method
