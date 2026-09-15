.class public final Lcom/google/android/gms/games/internal/zzaq;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"


# static fields
.field private static final zza:Lcom/google/android/gms/games/internal/zzaq;


# instance fields
.field private volatile zzb:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/games/internal/zzaq;

    invoke-direct {v0}, Lcom/google/android/gms/games/internal/zzaq;-><init>()V

    sput-object v0, Lcom/google/android/gms/games/internal/zzaq;->zza:Lcom/google/android/gms/games/internal/zzaq;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/games/internal/zzaq;->zzb:Z

    return-void
.end method

.method public static zza()Lcom/google/android/gms/games/internal/zzaq;
    .locals 1

    sget-object v0, Lcom/google/android/gms/games/internal/zzaq;->zza:Lcom/google/android/gms/games/internal/zzaq;

    return-object v0
.end method


# virtual methods
.method public final zzb()V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/games/internal/zzaq;->zzb:Z

    return-void
.end method

.method public final zzc()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/games/internal/zzaq;->zzb:Z

    return v0
.end method
