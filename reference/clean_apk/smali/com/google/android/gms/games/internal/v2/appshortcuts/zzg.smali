.class public Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# direct methods
.method synthetic constructor <init>(Lcom/google/android/gms/games/internal/v2/appshortcuts/zzf;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static zzd(Landroid/content/Context;)Lcom/google/android/gms/games/internal/v2/appshortcuts/zzg;
    .locals 2

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x19

    if-ge v0, v1, :cond_0

    new-instance p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zza;

    invoke-direct {p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zza;-><init>()V

    return-object p0

    :cond_0
    new-instance v0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;

    invoke-direct {v0, p0}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zze;-><init>(Landroid/content/Context;)V

    return-object v0
.end method


# virtual methods
.method public zzc()V
    .locals 0

    return-void
.end method
