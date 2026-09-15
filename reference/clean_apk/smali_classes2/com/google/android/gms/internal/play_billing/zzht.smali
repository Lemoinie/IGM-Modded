.class final Lcom/google/android/gms/internal/play_billing/zzht;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# static fields
.field private static final zza:Lcom/google/android/gms/internal/play_billing/zzht;


# instance fields
.field private final zzb:Lcom/google/android/gms/internal/play_billing/zzhd;

.field private final zzc:Ljava/util/concurrent/ConcurrentMap;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzht;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzht;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzht;->zza:Lcom/google/android/gms/internal/play_billing/zzht;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzht;->zzc:Ljava/util/concurrent/ConcurrentMap;

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhd;

    .line 2
    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzhd;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzht;->zzb:Lcom/google/android/gms/internal/play_billing/zzhd;

    return-void
.end method

.method static zza()Lcom/google/android/gms/internal/play_billing/zzht;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzht;->zza:Lcom/google/android/gms/internal/play_billing/zzht;

    return-object v0
.end method

.method private zzc(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Lcom/google/android/gms/internal/play_billing/zzhw<",
            "TT;>;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzht;->zzc:Ljava/util/concurrent/ConcurrentMap;

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzht;->zzb:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzhd;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object v1

    .line 2
    invoke-interface {v0, p1, v1}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhw;

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object v1
.end method


# virtual methods
.method final zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzht;->zzc:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 2
    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzht;->zzc(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzhw;

    move-result-object p1

    return-object p1

    .line 3
    :cond_0
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzhw;

    return-object v0
.end method
