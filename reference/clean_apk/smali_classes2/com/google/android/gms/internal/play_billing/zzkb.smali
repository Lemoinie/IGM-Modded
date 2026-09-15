.class public final Lcom/google/android/gms/internal/play_billing/zzkb;
.super Lcom/google/android/gms/internal/play_billing/zzgg;
.source "com.android.billingclient:billing@@9.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzhn;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzkb;


# instance fields
.field private zzd:I

.field private zze:Ljava/lang/String;

.field private zzf:Ljava/lang/String;

.field private zzg:Ljava/lang/String;

.field private zzh:I

.field private zzi:J

.field private zzj:J

.field private zzk:Z

.field private zzl:I

.field private zzm:I

.field private zzn:J

.field private zzo:Ljava/lang/String;

.field private zzp:Ljava/lang/String;

.field private zzq:Ljava/lang/String;

.field private zzr:Ljava/lang/String;

.field private zzs:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzkb;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    const-class v1, Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzB(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzgg;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzgg;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zze:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzf:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzg:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzo:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzp:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzq:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzr:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzG(Lcom/google/android/gms/internal/play_billing/zzkb;J)V
    .locals 0

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 p1, p1, 0x200

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    const-wide/32 p1, 0x365f4650

    iput-wide p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzn:J

    return-void
.end method

.method static synthetic zzH(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzg:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzI(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x400

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzo:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzJ(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x2000

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzr:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzK(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x1000

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzq:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzL(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x800

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzp:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzM(Lcom/google/android/gms/internal/play_billing/zzkb;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x4000

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzs:I

    return-void
.end method

.method static synthetic zzN(Lcom/google/android/gms/internal/play_billing/zzkb;Z)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x40

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzk:Z

    return-void
.end method

.method static synthetic zzO(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zze:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzP(Lcom/google/android/gms/internal/play_billing/zzkb;Ljava/lang/String;)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzf:Ljava/lang/String;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzjz;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgg;->zzp()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    return-object v0
.end method

.method static bridge synthetic zzb()Lcom/google/android/gms/internal/play_billing/zzkb;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzkb;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x80

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzl:I

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/play_billing/zzkb;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit16 v0, v0, 0x100

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzm:I

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/play_billing/zzkb;I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzh:I

    return-void
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/play_billing/zzkb;J)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-wide p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzi:J

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/play_billing/zzkb;J)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzd:I

    iput-wide p1, p0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzj:J

    return-void
.end method


# virtual methods
.method protected final zzd(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 17

    add-int/lit8 v0, p1, -0x1

    if-eqz v0, :cond_4

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2

    const/4 v1, 0x4

    const/4 v2, 0x0

    if-eq v0, v1, :cond_1

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzkb;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    return-object v0

    .line 4
    :cond_0
    throw v2

    .line 2
    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzjz;

    .line 3
    invoke-direct {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzjz;-><init>(Lcom/google/android/gms/internal/play_billing/zzka;)V

    return-object v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzkb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzkb;-><init>()V

    return-object v0

    .line 1
    :cond_3
    const-string v15, "zzr"

    const-string v16, "zzs"

    const-string v1, "zzd"

    const-string v2, "zze"

    const-string v3, "zzg"

    const-string v4, "zzh"

    const-string v5, "zzi"

    const-string v6, "zzf"

    const-string v7, "zzj"

    const-string v8, "zzk"

    const-string v9, "zzl"

    const-string v10, "zzm"

    const-string v11, "zzn"

    const-string v12, "zzo"

    const-string v13, "zzp"

    const-string v14, "zzq"

    filled-new-array/range {v1 .. v16}, [Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzkb;->zzb:Lcom/google/android/gms/internal/play_billing/zzkb;

    const-string v2, "\u0004\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0002\u0003\u1004\u0003\u0004\u1002\u0004\u0005\u1008\u0001\u0006\u1002\u0005\u0007\u1007\u0006\u0008\u1004\u0007\t\u1004\u0008\n\u1002\t\u000b\u1008\n\u000c\u1008\u000b\r\u1008\u000c\u000e\u1008\r\u000f\u1004\u000e"

    .line 2
    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/play_billing/zzkb;->zzy(Lcom/google/android/gms/internal/play_billing/zzhm;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_4
    const/4 v0, 0x1

    .line 1
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method
