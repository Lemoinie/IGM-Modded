.class final enum Lcom/google/android/gms/internal/drive/zzkg;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/google/android/gms/internal/drive/zzkg;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum zzrg:Lcom/google/android/gms/internal/drive/zzkg;

.field public static final enum zzrh:Lcom/google/android/gms/internal/drive/zzkg;

.field public static final enum zzri:Lcom/google/android/gms/internal/drive/zzkg;

.field public static final enum zzrj:Lcom/google/android/gms/internal/drive/zzkg;

.field private static final synthetic zzrl:[Lcom/google/android/gms/internal/drive/zzkg;


# instance fields
.field private final zzrk:Z


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 5
    new-instance v0, Lcom/google/android/gms/internal/drive/zzkg;

    const-string v1, "SCALAR"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, Lcom/google/android/gms/internal/drive/zzkg;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/google/android/gms/internal/drive/zzkg;->zzrg:Lcom/google/android/gms/internal/drive/zzkg;

    .line 6
    new-instance v1, Lcom/google/android/gms/internal/drive/zzkg;

    const-string v3, "VECTOR"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4, v4}, Lcom/google/android/gms/internal/drive/zzkg;-><init>(Ljava/lang/String;IZ)V

    sput-object v1, Lcom/google/android/gms/internal/drive/zzkg;->zzrh:Lcom/google/android/gms/internal/drive/zzkg;

    .line 7
    new-instance v3, Lcom/google/android/gms/internal/drive/zzkg;

    const-string v5, "PACKED_VECTOR"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6, v4}, Lcom/google/android/gms/internal/drive/zzkg;-><init>(Ljava/lang/String;IZ)V

    sput-object v3, Lcom/google/android/gms/internal/drive/zzkg;->zzri:Lcom/google/android/gms/internal/drive/zzkg;

    .line 8
    new-instance v4, Lcom/google/android/gms/internal/drive/zzkg;

    const-string v5, "MAP"

    const/4 v6, 0x3

    invoke-direct {v4, v5, v6, v2}, Lcom/google/android/gms/internal/drive/zzkg;-><init>(Ljava/lang/String;IZ)V

    sput-object v4, Lcom/google/android/gms/internal/drive/zzkg;->zzrj:Lcom/google/android/gms/internal/drive/zzkg;

    .line 9
    filled-new-array {v0, v1, v3, v4}, [Lcom/google/android/gms/internal/drive/zzkg;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/drive/zzkg;->zzrl:[Lcom/google/android/gms/internal/drive/zzkg;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IZ)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)V"
        }
    .end annotation

    .line 2
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 3
    iput-boolean p3, p0, Lcom/google/android/gms/internal/drive/zzkg;->zzrk:Z

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/drive/zzkg;
    .locals 1

    .line 1
    sget-object v0, Lcom/google/android/gms/internal/drive/zzkg;->zzrl:[Lcom/google/android/gms/internal/drive/zzkg;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/drive/zzkg;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/drive/zzkg;

    return-object v0
.end method
