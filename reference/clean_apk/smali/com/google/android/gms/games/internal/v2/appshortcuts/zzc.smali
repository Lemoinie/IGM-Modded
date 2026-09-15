.class public final synthetic Lcom/google/android/gms/games/internal/v2/appshortcuts/zzc;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/tasks/OnSuccessListener;


# instance fields
.field public final synthetic zza:Landroid/content/pm/ShortcutManager;


# direct methods
.method public synthetic constructor <init>(Landroid/content/pm/ShortcutManager;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzc;->zza:Landroid/content/pm/ShortcutManager;

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/Object;)V
    .locals 3

    check-cast p1, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;

    .line 1
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;->zzd()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzc;->zza:Landroid/content/pm/ShortcutManager;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 3
    invoke-virtual {v1, v0}, Landroid/content/pm/ShortcutManager;->removeDynamicShortcuts(Ljava/util/List;)V

    .line 4
    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;->zza()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 5
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 6
    invoke-virtual {v1, v0}, Landroid/content/pm/ShortcutManager;->addDynamicShortcuts(Ljava/util/List;)Z

    .line 7
    :cond_1
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;->zzb()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 8
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 9
    invoke-virtual {v1, v0}, Landroid/content/pm/ShortcutManager;->disableShortcuts(Ljava/util/List;)V

    .line 10
    :cond_2
    invoke-virtual {p1}, Lcom/google/android/gms/games/internal/v2/appshortcuts/zzh;->zzc()Ljava/util/List;

    move-result-object p1

    if-eqz p1, :cond_3

    .line 11
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 12
    invoke-virtual {v1, p1}, Landroid/content/pm/ShortcutManager;->enableShortcuts(Ljava/util/List;)V

    :cond_3
    return-void
.end method
