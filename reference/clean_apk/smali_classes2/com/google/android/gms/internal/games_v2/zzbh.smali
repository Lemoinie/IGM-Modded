.class public final synthetic Lcom/google/android/gms/internal/games_v2/zzbh;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/internal/games_v2/zzbs;

.field public final synthetic zzb:Lcom/google/android/gms/internal/games_v2/zzbr;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/games_v2/zzbs;Lcom/google/android/gms/internal/games_v2/zzbr;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/games_v2/zzbh;->zza:Lcom/google/android/gms/internal/games_v2/zzbs;

    iput-object p2, p0, Lcom/google/android/gms/internal/games_v2/zzbh;->zzb:Lcom/google/android/gms/internal/games_v2/zzbr;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/games_v2/zzbh;->zza:Lcom/google/android/gms/internal/games_v2/zzbs;

    iget-object v1, p0, Lcom/google/android/gms/internal/games_v2/zzbh;->zzb:Lcom/google/android/gms/internal/games_v2/zzbr;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/games_v2/zzbs;->zzi(Lcom/google/android/gms/internal/games_v2/zzbr;)V

    return-void
.end method
