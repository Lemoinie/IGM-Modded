.class Lcom/google/android/gms/games/zzj;
.super Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# direct methods
.method synthetic constructor <init>(Lcom/google/android/gms/games/zzi;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;-><init>()V

    return-void
.end method


# virtual methods
.method public final bridge synthetic buildClient(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/ClientSettings;Ljava/lang/Object;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/Api$Client;
    .locals 9

    .line 1
    check-cast p4, Lcom/google/android/gms/games/zzn;

    if-nez p4, :cond_0

    .line 2
    new-instance p4, Lcom/google/android/gms/games/zzl;

    const/4 v0, 0x0

    invoke-direct {p4, v0}, Lcom/google/android/gms/games/zzl;-><init>(Lcom/google/android/gms/games/zzk;)V

    invoke-virtual {p4}, Lcom/google/android/gms/games/zzl;->zze()Lcom/google/android/gms/games/zzn;

    move-result-object p4

    .line 3
    :cond_0
    new-instance v8, Lcom/google/android/gms/games/internal/zzaj;

    invoke-static {}, Lcom/google/android/gms/games/internal/zzaq;->zza()Lcom/google/android/gms/games/internal/zzaq;

    move-result-object v7

    move-object v0, v8

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    .line 4
    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/games/internal/zzaj;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/ClientSettings;Lcom/google/android/gms/games/zzn;Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;Lcom/google/android/gms/games/internal/zzaq;)V

    iget-object p2, p4, Lcom/google/android/gms/games/zzn;->zzo:Lcom/google/android/gms/games/internal/zzl;

    .line 5
    invoke-virtual {p2}, Lcom/google/android/gms/games/internal/zzl;->zzc()Z

    move-result p2

    if-eqz p2, :cond_1

    .line 6
    sget p2, Lcom/google/android/gms/games/internal/zzg;->zza:I

    .line 7
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    check-cast p1, Landroid/app/Application;

    invoke-static {p1}, Lcom/google/android/gms/games/internal/zzg;->zzb(Landroid/app/Application;)Lcom/google/android/gms/games/internal/zzg;

    move-result-object p1

    .line 8
    invoke-virtual {v8, p1}, Lcom/google/android/gms/games/internal/zzaj;->zzS(Lcom/google/android/gms/games/internal/zzg;)V

    :cond_1
    return-object v8
.end method

.method public final getPriority()I
    .locals 1

    const/4 v0, 0x1

    return v0
.end method
