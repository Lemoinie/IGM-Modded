.class public final Lcom/google/android/gms/internal/ads/zzhfz;
.super Lcom/google/android/gms/internal/ads/zzgzu;
.source "com.google.android.gms:play-services-ads@@23.0.0"

# interfaces
.implements Lcom/google/android/gms/internal/ads/zzhbf;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/ads/zzhfz;


# instance fields
.field private zzA:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzB:Lcom/google/android/gms/internal/ads/zzheh;

.field private zzC:Ljava/lang/String;

.field private zzD:Lcom/google/android/gms/internal/ads/zzhdz;

.field private zzE:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzF:Lcom/google/android/gms/internal/ads/zzhfa;

.field private zzG:I

.field private zzH:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzI:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzJ:J

.field private zzK:Lcom/google/android/gms/internal/ads/zzhfy;

.field private zzL:B

.field private zzd:I

.field private zze:I

.field private zzf:I

.field private zzg:Ljava/lang/String;

.field private zzh:Ljava/lang/String;

.field private zzi:Ljava/lang/String;

.field private zzj:Lcom/google/android/gms/internal/ads/zzhed;

.field private zzk:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzl:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzm:Ljava/lang/String;

.field private zzn:Lcom/google/android/gms/internal/ads/zzhfj;

.field private zzo:Z

.field private zzp:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzq:Ljava/lang/String;

.field private zzr:Z

.field private zzs:Z

.field private zzt:Lcom/google/android/gms/internal/ads/zzgyl;

.field private zzu:Lcom/google/android/gms/internal/ads/zzhfr;

.field private zzv:Z

.field private zzw:Ljava/lang/String;

.field private zzx:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzy:Lcom/google/android/gms/internal/ads/zzhad;

.field private zzz:Lcom/google/android/gms/internal/ads/zzhfv;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/ads/zzhfz;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ads/zzhfz;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    const-class v1, Lcom/google/android/gms/internal/ads/zzhfz;

    .line 2
    invoke-static {v1, v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaU(Ljava/lang/Class;Lcom/google/android/gms/internal/ads/zzgzu;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/ads/zzgzu;-><init>()V

    const/4 v0, 0x2

    iput-byte v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzL:B

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzg:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzh:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzi:Ljava/lang/String;

    .line 2
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzk:Lcom/google/android/gms/internal/ads/zzhad;

    .line 3
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzl:Lcom/google/android/gms/internal/ads/zzhad;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzm:Ljava/lang/String;

    .line 4
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzp:Lcom/google/android/gms/internal/ads/zzhad;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzq:Ljava/lang/String;

    .line 5
    sget-object v1, Lcom/google/android/gms/internal/ads/zzgyl;->zzb:Lcom/google/android/gms/internal/ads/zzgyl;

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzt:Lcom/google/android/gms/internal/ads/zzgyl;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzw:Ljava/lang/String;

    .line 6
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzx:Lcom/google/android/gms/internal/ads/zzhad;

    .line 7
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzy:Lcom/google/android/gms/internal/ads/zzhad;

    .line 8
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzA:Lcom/google/android/gms/internal/ads/zzhad;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzC:Ljava/lang/String;

    .line 9
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzE:Lcom/google/android/gms/internal/ads/zzhad;

    .line 10
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzH:Lcom/google/android/gms/internal/ads/zzhad;

    .line 11
    invoke-static {}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaN()Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzI:Lcom/google/android/gms/internal/ads/zzhad;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/ads/zzheb;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaA()Lcom/google/android/gms/internal/ads/zzgzp;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/ads/zzheb;

    return-object v0
.end method

.method static synthetic zzc()Lcom/google/android/gms/internal/ads/zzhfz;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    return-object v0
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/ads/zzhfz;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzg:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzh(Lcom/google/android/gms/internal/ads/zzhfz;Ljava/lang/String;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzh:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzi(Lcom/google/android/gms/internal/ads/zzhfz;Lcom/google/android/gms/internal/ads/zzhed;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzj:Lcom/google/android/gms/internal/ads/zzhed;

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit8 p1, p1, 0x20

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    return-void
.end method

.method static synthetic zzj(Lcom/google/android/gms/internal/ads/zzhfz;Lcom/google/android/gms/internal/ads/zzhfp;)V
    .locals 2

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzk:Lcom/google/android/gms/internal/ads/zzhad;

    .line 2
    invoke-interface {v0}, Lcom/google/android/gms/internal/ads/zzhad;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 3
    invoke-static {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaO(Lcom/google/android/gms/internal/ads/zzhad;)Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzk:Lcom/google/android/gms/internal/ads/zzhad;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzk:Lcom/google/android/gms/internal/ads/zzhad;

    .line 4
    invoke-interface {p0, p1}, Lcom/google/android/gms/internal/ads/zzhad;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method static synthetic zzk(Lcom/google/android/gms/internal/ads/zzhfz;Ljava/lang/String;)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit8 v0, v0, 0x40

    iput v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzm:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzl(Lcom/google/android/gms/internal/ads/zzhfz;)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    and-int/lit8 v0, v0, -0x41

    iput v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    sget-object v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    iget-object v0, v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzm:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzm:Ljava/lang/String;

    return-void
.end method

.method static synthetic zzm(Lcom/google/android/gms/internal/ads/zzhfz;Lcom/google/android/gms/internal/ads/zzhfj;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzn:Lcom/google/android/gms/internal/ads/zzhfj;

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit16 p1, p1, 0x80

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    return-void
.end method

.method static synthetic zzn(Lcom/google/android/gms/internal/ads/zzhfz;Lcom/google/android/gms/internal/ads/zzhfr;)V
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iput-object p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzu:Lcom/google/android/gms/internal/ads/zzhfr;

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit16 p1, p1, 0x2000

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    return-void
.end method

.method static synthetic zzo(Lcom/google/android/gms/internal/ads/zzhfz;Ljava/lang/Iterable;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzx:Lcom/google/android/gms/internal/ads/zzhad;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ads/zzhad;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    invoke-static {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaO(Lcom/google/android/gms/internal/ads/zzhad;)Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzx:Lcom/google/android/gms/internal/ads/zzhad;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzx:Lcom/google/android/gms/internal/ads/zzhad;

    .line 3
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/ads/zzgxt;->zzav(Ljava/lang/Iterable;Ljava/util/List;)V

    return-void
.end method

.method static synthetic zzp(Lcom/google/android/gms/internal/ads/zzhfz;Ljava/lang/Iterable;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzy:Lcom/google/android/gms/internal/ads/zzhad;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ads/zzhad;->zzc()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2
    invoke-static {v0}, Lcom/google/android/gms/internal/ads/zzgzu;->zzaO(Lcom/google/android/gms/internal/ads/zzhad;)Lcom/google/android/gms/internal/ads/zzhad;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzy:Lcom/google/android/gms/internal/ads/zzhad;

    :cond_0
    iget-object p0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzy:Lcom/google/android/gms/internal/ads/zzhad;

    .line 3
    invoke-static {p1, p0}, Lcom/google/android/gms/internal/ads/zzgxt;->zzav(Ljava/lang/Iterable;Ljava/util/List;)V

    return-void
.end method

.method static synthetic zzq(Lcom/google/android/gms/internal/ads/zzhfz;I)V
    .locals 0

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zze:I

    iget p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    or-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzd:I

    return-void
.end method


# virtual methods
.method protected final zzb(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 45

    move-object/from16 v0, p0

    add-int/lit8 v1, p1, -0x1

    if-eqz v1, :cond_5

    const/4 v2, 0x2

    if-eq v1, v2, :cond_4

    const/4 v2, 0x3

    if-eq v1, v2, :cond_3

    const/4 v2, 0x4

    const/4 v3, 0x0

    if-eq v1, v2, :cond_2

    const/4 v2, 0x5

    if-eq v1, v2, :cond_1

    if-nez p2, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    const/4 v1, 0x1

    .line 2
    :goto_0
    iput-byte v1, v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzL:B

    return-object v3

    .line 1
    :cond_1
    sget-object v1, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    return-object v1

    :cond_2
    new-instance v1, Lcom/google/android/gms/internal/ads/zzheb;

    .line 3
    invoke-direct {v1, v3}, Lcom/google/android/gms/internal/ads/zzheb;-><init>(Lcom/google/android/gms/internal/ads/zzhdp;)V

    return-object v1

    :cond_3
    new-instance v1, Lcom/google/android/gms/internal/ads/zzhfz;

    .line 4
    invoke-direct {v1}, Lcom/google/android/gms/internal/ads/zzhfz;-><init>()V

    return-object v1

    .line 2
    :cond_4
    const-class v7, Lcom/google/android/gms/internal/ads/zzhfp;

    sget-object v14, Lcom/google/android/gms/internal/ads/zzhfk;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    sget-object v16, Lcom/google/android/gms/internal/ads/zzhea;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-class v22, Lcom/google/android/gms/internal/ads/zzhgd;

    const-class v30, Lcom/google/android/gms/internal/ads/zzhgj;

    const-class v35, Lcom/google/android/gms/internal/ads/zzhel;

    sget-object v38, Lcom/google/android/gms/internal/ads/zzhft;->zza:Lcom/google/android/gms/internal/ads/zzgzy;

    const-class v40, Lcom/google/android/gms/internal/ads/zzhfd;

    const-class v42, Lcom/google/android/gms/internal/ads/zzhfg;

    const-string v43, "zzJ"

    const-string v44, "zzK"

    const-string v2, "zzd"

    const-string v3, "zzg"

    const-string v4, "zzh"

    const-string v5, "zzi"

    const-string v6, "zzk"

    const-string v8, "zzo"

    const-string v9, "zzp"

    const-string v10, "zzq"

    const-string v11, "zzr"

    const-string v12, "zzs"

    const-string v13, "zze"

    const-string v15, "zzf"

    const-string v17, "zzj"

    const-string v18, "zzm"

    const-string v19, "zzn"

    const-string v20, "zzt"

    const-string v21, "zzl"

    const-string v23, "zzu"

    const-string v24, "zzv"

    const-string v25, "zzw"

    const-string v26, "zzx"

    const-string v27, "zzy"

    const-string v28, "zzz"

    const-string v29, "zzA"

    const-string v31, "zzB"

    const-string v32, "zzC"

    const-string v33, "zzD"

    const-string v34, "zzE"

    const-string v36, "zzF"

    const-string v37, "zzG"

    const-string v39, "zzH"

    const-string v41, "zzI"

    filled-new-array/range {v2 .. v44}, [Ljava/lang/Object;

    move-result-object v1

    sget-object v2, Lcom/google/android/gms/internal/ads/zzhfz;->zzb:Lcom/google/android/gms/internal/ads/zzhfz;

    const-string v3, "\u0001!\u0000\u0001\u0001!!\u0000\t\u0001\u0001\u1008\u0002\u0002\u1008\u0003\u0003\u1008\u0004\u0004\u041b\u0005\u1007\u0008\u0006\u001a\u0007\u1008\t\u0008\u1007\n\t\u1007\u000b\n\u180c\u0000\u000b\u180c\u0001\u000c\u1009\u0005\r\u1008\u0006\u000e\u1009\u0007\u000f\u100a\u000c\u0010\u001b\u0011\u1009\r\u0012\u1007\u000e\u0013\u1008\u000f\u0014\u001a\u0015\u001a\u0016\u1009\u0010\u0017\u001b\u0018\u1009\u0011\u0019\u1008\u0012\u001a\u1009\u0013\u001b\u001b\u001c\u1009\u0014\u001d\u180c\u0015\u001e\u001b\u001f\u001b \u1002\u0016!\u1009\u0017"

    invoke-static {v2, v3, v1}, Lcom/google/android/gms/internal/ads/zzhfz;->zzaR(Lcom/google/android/gms/internal/ads/zzhbe;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    :cond_5
    iget-byte v1, v0, Lcom/google/android/gms/internal/ads/zzhfz;->zzL:B

    .line 1
    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    return-object v1
.end method

.method public final zzd()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzm:Ljava/lang/String;

    return-object v0
.end method

.method public final zze()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzg:Ljava/lang/String;

    return-object v0
.end method

.method public final zzf()Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/ads/zzhfz;->zzk:Lcom/google/android/gms/internal/ads/zzhad;

    return-object v0
.end method
