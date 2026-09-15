.class public final enum Lcom/google/android/gms/internal/play_billing/zzju;
.super Ljava/lang/Enum;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzgi;


# static fields
.field public static final enum zza:Lcom/google/android/gms/internal/play_billing/zzju;

.field public static final enum zzb:Lcom/google/android/gms/internal/play_billing/zzju;

.field public static final enum zzc:Lcom/google/android/gms/internal/play_billing/zzju;

.field public static final enum zzd:Lcom/google/android/gms/internal/play_billing/zzju;

.field public static final enum zze:Lcom/google/android/gms/internal/play_billing/zzju;

.field public static final enum zzf:Lcom/google/android/gms/internal/play_billing/zzju;

.field private static final synthetic zzg:[Lcom/google/android/gms/internal/play_billing/zzju;


# instance fields
.field private final zzh:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v1, "BROADCAST_ACTION_UNSPECIFIED"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zza:Lcom/google/android/gms/internal/play_billing/zzju;

    new-instance v1, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v2, "PURCHASES_UPDATED_ACTION"

    const/4 v3, 0x1

    .line 2
    invoke-direct {v1, v2, v3, v3}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v1, Lcom/google/android/gms/internal/play_billing/zzju;->zzb:Lcom/google/android/gms/internal/play_billing/zzju;

    new-instance v2, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v3, "LOCAL_PURCHASES_UPDATED_ACTION"

    const/4 v4, 0x2

    .line 3
    invoke-direct {v2, v3, v4, v4}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v2, Lcom/google/android/gms/internal/play_billing/zzju;->zzc:Lcom/google/android/gms/internal/play_billing/zzju;

    new-instance v3, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v4, "ALTERNATIVE_BILLING_ACTION"

    const/4 v5, 0x3

    .line 4
    invoke-direct {v3, v4, v5, v5}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v3, Lcom/google/android/gms/internal/play_billing/zzju;->zzd:Lcom/google/android/gms/internal/play_billing/zzju;

    new-instance v4, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v5, "IN_APP_BILLING_RESULT_UPDATE_ACTION"

    const/4 v6, 0x4

    .line 5
    invoke-direct {v4, v5, v6, v6}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v4, Lcom/google/android/gms/internal/play_billing/zzju;->zze:Lcom/google/android/gms/internal/play_billing/zzju;

    new-instance v5, Lcom/google/android/gms/internal/play_billing/zzju;

    const-string v6, "PLAY_BILLING_ACTIVITY_CREATED_ACTION"

    const/4 v7, 0x5

    .line 6
    invoke-direct {v5, v6, v7, v7}, Lcom/google/android/gms/internal/play_billing/zzju;-><init>(Ljava/lang/String;II)V

    sput-object v5, Lcom/google/android/gms/internal/play_billing/zzju;->zzf:Lcom/google/android/gms/internal/play_billing/zzju;

    filled-new-array/range {v0 .. v5}, [Lcom/google/android/gms/internal/play_billing/zzju;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zzg:[Lcom/google/android/gms/internal/play_billing/zzju;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lcom/google/android/gms/internal/play_billing/zzju;->zzh:I

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/play_billing/zzju;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzju;->zzg:[Lcom/google/android/gms/internal/play_billing/zzju;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/play_billing/zzju;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/play_billing/zzju;

    return-object v0
.end method


# virtual methods
.method public final toString()Ljava/lang/String;
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzju;->zzh:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final zza()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzju;->zzh:I

    return v0
.end method
