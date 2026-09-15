.class public final Lcom/google/android/gms/internal/ads/zzfnf;
.super Lcom/google/android/gms/internal/ads/zzgzu;
.source "com.google.android.gms:play-services-ads@@23.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/ads/zzhbf;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/ads/zzhaa;

.field private static final zzd:Lcom/google/android/gms/internal/ads/zzfnf;


# instance fields
.field private zzA:Lcom/google/android/gms/internal/ads/zzhac;

.field private zzB:I

.field private zzC:I

.field private zzD:J

.field private zzE:I

.field private zzF:Ljava/lang/String;

.field private zzG:Ljava/lang/String;

.field private zzH:Ljava/lang/String;

.field private zzI:Ljava/lang/String;

.field private zzJ:Ljava/lang/String;

.field private zzK:Ljava/lang/String;

.field private zzL:Ljava/lang/String;

.field private zzM:Ljava/lang/String;

.field private zzN:Ljava/lang/String;

.field private zzO:Ljava/lang/String;

.field private zzP:Ljava/lang/String;

.field private zzQ:J

.field private zzR:I

.field private zzS:I

.field private zzT:Lcom/google/android/gms/internal/ads/zzfnr;

.field private zze:I

.field private zzf:I

.field private zzg:I

.field private zzh:Ljava/lang/String;

.field private zzi:J

.field private zzj:J

.field private zzk:J

.field private zzl:Lcom/google/android/gms/internal/ads/zzgzz;

.field private zzm:Z

.field private zzn:J

.field private zzo:J

.field private zzp:J

.field private zzq:J

.field private zzr:I

.field private zzs:Ljava/lang/String;

.field private zzt:Ljava/lang/String;

.field private zzu:Ljava/lang/String;

.field private zzv:Ljava/lang/String;

.field private zzw:Ljava/lang/String;

.field private zzx:I

.field private zzy:Ljava/lang/String;

.field private zzz:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzfnd;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzfnd;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzfnf;->zzb:Lcom/google/android/gms/internal/ads/zzhaa;

    new-instance v0, Lcom/google/android/gms/internal/ads/zzfnf;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzfnf;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzfnf;->zzd:Lcom/google/android/gms/internal/ads/zzfnf;

    const-class v1, Lcom/google/android/gms/internal/ads/zzfnf;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaU(Ljava/lang/Class;Lcom/google/android/gms/internal/ads/zzgzu;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/ads/zzgzu;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzh:Ljava/lang/String;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzfnf;->zzaJ()Lcom/google/android/gms/internal/ads/zzgzz;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzl:Lcom/google/android/gms/internal/ads/zzgzz;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzs:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzt:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzu:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzv:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzw:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzy:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzz:Ljava/lang/String;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzfnf;->zzaL()Lcom/google/android/gms/internal/ads/zzhac;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzA:Lcom/google/android/gms/internal/ads/zzhac;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzF:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzG:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzH:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzI:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzJ:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzK:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzL:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzM:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzN:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzO:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzP:Ljava/lang/String;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/ads/zzfne;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/ads/zzfnf;->zzd:Lcom/google/android/gms/internal/ads/zzfnf;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaA()Lcom/google/android/gms/internal/ads/zzgzp;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/ads/zzfne;

    return-object v0
.end method

.method static synthetic zzc()Lcom/google/android/gms/internal/ads/zzfnf;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzfnf;->zzd:Lcom/google/android/gms/internal/ads/zzfnf;

    return-object v0
.end method

.method static synthetic zzd(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzO:Ljava/lang/String;

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzP:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/ads/zzfnf;Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzm:Z

    return-void
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/ads/zzfnf;J)V
    .locals 0

    iput-wide p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzn:J

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/ads/zzfnf;J)V
    .locals 0

    iput-wide p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzo:J

    return-void
.end method

.method static synthetic zzi(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzs:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzj(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzv:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzk(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzw:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzl(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 0

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzx:I

    return-void
.end method

.method static synthetic zzm(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/Iterable;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzA:Lcom/google/android/gms/internal/ads/zzhac;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ads/zzhac;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    invoke-static {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaM(Lcom/google/android/gms/internal/ads/zzhac;)Lcom/google/android/gms/internal/ads/zzhac;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzA:Lcom/google/android/gms/internal/ads/zzhac;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzA:Lcom/google/android/gms/internal/ads/zzhac;

    .line 3
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/ads/zzgxt;->zzav(Ljava/lang/Iterable;Ljava/util/List;)V

    return-void
.end method

.method static synthetic zzn(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 0

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzC:I

    return-void
.end method

.method static synthetic zzo(Lcom/google/android/gms/internal/ads/zzfnf;J)V
    .locals 0

    iput-wide p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzD:J

    return-void
.end method

.method static synthetic zzp(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzF:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzq(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzG:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzr(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzK:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzs(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzL:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzt(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzM:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzu(Lcom/google/android/gms/internal/ads/zzfnf;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzN:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzv(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 0

    add-int/lit8 p1, p1, -0x2

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzf:I

    return-void
.end method

.method static synthetic zzw(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 0

    const/4 p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzr:I

    return-void
.end method

.method static synthetic zzx(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    add-int/lit8 p1, p1, -0x2

    .line 1
    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzB:I

    return-void

    :cond_0
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "Can\'t get the number of an unknown enum value."

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static synthetic zzy(Lcom/google/android/gms/internal/ads/zzfnf;I)V
    .locals 1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    add-int/lit8 p1, p1, -0x2

    .line 1
    iput p1, p0, Lcom/google/android/gms/internal/ads/zzfnf;->zzE:I

    return-void

    :cond_0
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "Can\'t get the number of an unknown enum value."

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method


# virtual methods
.method protected final zzb(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 43

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

    if-eq v0, v1, :cond_0

    return-object v2

    .line 1
    :cond_0
    sget-object v0, Lcom/google/android/gms/internal/ads/zzfnf;->zzd:Lcom/google/android/gms/internal/ads/zzfnf;

    return-object v0

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzfne;

    .line 3
    invoke-direct {v0, v2}, Lcom/google/android/gms/internal/ads/zzfne;-><init>(Lcom/google/android/gms/internal/ads/zzfnd;)V

    return-object v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/ads/zzfnf;

    .line 4
    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzfnf;-><init>()V

    return-object v0

    .line 2
    :cond_3
    const-string v41, "zzg"

    const-string v42, "zzT"

    const-string v1, "zze"

    const-string v2, "zzf"

    const-string v3, "zzm"

    const-string v4, "zzn"

    const-string v5, "zzr"

    const-string v6, "zzs"

    const-string v7, "zzv"

    const-string v8, "zzw"

    const-string v9, "zzx"

    const-string v10, "zzB"

    const-string v11, "zzC"

    const-string v12, "zzD"

    const-string v13, "zzE"

    const-string v14, "zzF"

    const-string v15, "zzG"

    const-string v16, "zzK"

    const-string v17, "zzL"

    const-string v18, "zzM"

    const-string v19, "zzN"

    const-string v20, "zzO"

    const-string v21, "zzP"

    const-string v22, "zzt"

    const-string v23, "zzu"

    const-string v24, "zzy"

    const-string v25, "zzz"

    const-string v26, "zzA"

    const-string v27, "zzH"

    const-string v28, "zzI"

    const-string v29, "zzJ"

    const-string v30, "zzQ"

    const-string v31, "zzh"

    const-string v32, "zzi"

    const-string v33, "zzj"

    const-string v34, "zzk"

    const-string v35, "zzo"

    const-string v36, "zzp"

    const-string v37, "zzq"

    const-string v38, "zzl"

    const-string v39, "zzR"

    const-string v40, "zzS"

    filled-new-array/range {v1 .. v42}, [Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/ads/zzfnf;->zzd:Lcom/google/android/gms/internal/ads/zzfnf;

    const-string v2, "\u0000)\u0000\u0001\u0001))\u0000\u0002\u0000\u0001\u000c\u0002\u0007\u0003\u0002\u0004\u000c\u0005\u0208\u0006\u0208\u0007\u0208\u0008\u0004\t\u000c\n\u0004\u000b\u0002\u000c\u000c\r\u0208\u000e\u0208\u000f\u0208\u0010\u0208\u0011\u0208\u0012\u0208\u0013\u0208\u0014\u0208\u0015\u0208\u0016\u0208\u0017\u0208\u0018\u0208\u0019%\u001a\u0208\u001b\u0208\u001c\u0208\u001d\u0002\u001e\u0208\u001f\u0002 \u0002!\u0002\"\u0002#\u0002$\u0002%,&\u000c\'\u000c(\u000c)\u1009\u0000"

    invoke-static {v1, v2, v0}, Lcom/google/android/gms/internal/ads/zzfnf;->zzaR(Lcom/google/android/gms/internal/ads/zzhbe;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_4
    const/4 v0, 0x1

    .line 1
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method
