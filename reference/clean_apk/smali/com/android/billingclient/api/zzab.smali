.class final Lcom/android/billingclient/api/zzab;
.super Ljava/lang/Object;
.source "com.android.billingclient:billing@@9.0.0"


# instance fields
.field private final zza:Landroid/content/Context;

.field private final zzb:Lcom/android/billingclient/api/PurchasesUpdatedListener;

.field private final zzc:Lcom/android/billingclient/api/zzb;

.field private final zzd:Lcom/android/billingclient/api/UserChoiceBillingListener;

.field private final zze:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

.field private final zzf:Lcom/android/billingclient/api/zzcz;

.field private final zzg:Lcom/android/billingclient/api/zzaa;

.field private final zzh:Lcom/android/billingclient/api/zzaa;

.field private zzi:Z

.field private zzj:Lcom/google/android/gms/internal/play_billing/zzcf;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzdp;Lcom/android/billingclient/api/zzb;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/DeveloperProvidedBillingListener;Lcom/android/billingclient/api/zzcz;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzk()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object p3

    iput-object p3, p0, Lcom/android/billingclient/api/zzab;->zzj:Lcom/google/android/gms/internal/play_billing/zzcf;

    iput-object p1, p0, Lcom/android/billingclient/api/zzab;->zza:Landroid/content/Context;

    iput-object p2, p0, Lcom/android/billingclient/api/zzab;->zzb:Lcom/android/billingclient/api/PurchasesUpdatedListener;

    iput-object p4, p0, Lcom/android/billingclient/api/zzab;->zzc:Lcom/android/billingclient/api/zzb;

    iput-object p5, p0, Lcom/android/billingclient/api/zzab;->zzd:Lcom/android/billingclient/api/UserChoiceBillingListener;

    iput-object p6, p0, Lcom/android/billingclient/api/zzab;->zze:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    iput-object p7, p0, Lcom/android/billingclient/api/zzab;->zzf:Lcom/android/billingclient/api/zzcz;

    new-instance p1, Lcom/android/billingclient/api/zzaa;

    const/4 p2, 0x1

    .line 2
    invoke-direct {p1, p0, p2}, Lcom/android/billingclient/api/zzaa;-><init>(Lcom/android/billingclient/api/zzab;Z)V

    iput-object p1, p0, Lcom/android/billingclient/api/zzab;->zzg:Lcom/android/billingclient/api/zzaa;

    new-instance p1, Lcom/android/billingclient/api/zzaa;

    const/4 p2, 0x0

    .line 3
    invoke-direct {p1, p0, p2}, Lcom/android/billingclient/api/zzaa;-><init>(Lcom/android/billingclient/api/zzab;Z)V

    iput-object p1, p0, Lcom/android/billingclient/api/zzab;->zzh:Lcom/android/billingclient/api/zzaa;

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/zzab;)Lcom/android/billingclient/api/zzb;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zzc:Lcom/android/billingclient/api/zzb;

    return-object p0
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/zzab;)Lcom/android/billingclient/api/zzcz;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zzf:Lcom/android/billingclient/api/zzcz;

    return-object p0
.end method

.method static bridge synthetic zzc(Lcom/android/billingclient/api/zzab;)Lcom/android/billingclient/api/DeveloperProvidedBillingListener;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zze:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    return-object p0
.end method

.method static bridge synthetic zze(Lcom/android/billingclient/api/zzab;)Lcom/android/billingclient/api/PurchasesUpdatedListener;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zzb:Lcom/android/billingclient/api/PurchasesUpdatedListener;

    return-object p0
.end method

.method static bridge synthetic zzg(Lcom/android/billingclient/api/zzab;)Lcom/android/billingclient/api/UserChoiceBillingListener;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zzd:Lcom/android/billingclient/api/UserChoiceBillingListener;

    return-object p0
.end method

.method static bridge synthetic zzh(Lcom/android/billingclient/api/zzab;)Lcom/google/android/gms/internal/play_billing/zzcf;
    .locals 0

    iget-object p0, p0, Lcom/android/billingclient/api/zzab;->zzj:Lcom/google/android/gms/internal/play_billing/zzcf;

    return-object p0
.end method


# virtual methods
.method final zzd()Lcom/android/billingclient/api/DeveloperProvidedBillingListener;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/zzab;->zze:Lcom/android/billingclient/api/DeveloperProvidedBillingListener;

    return-object v0
.end method

.method final zzf()Lcom/android/billingclient/api/PurchasesUpdatedListener;
    .locals 1

    iget-object v0, p0, Lcom/android/billingclient/api/zzab;->zzb:Lcom/android/billingclient/api/PurchasesUpdatedListener;

    return-object v0
.end method

.method final zzi()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/android/billingclient/api/zzab;->zzg:Lcom/android/billingclient/api/zzaa;

    iget-object v1, p0, Lcom/android/billingclient/api/zzab;->zza:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/zzaa;->zzc(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzab;->zzh:Lcom/android/billingclient/api/zzaa;

    .line 2
    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/zzaa;->zzc(Landroid/content/Context;)V

    return-void
.end method

.method final zzj(Z)V
    .locals 3

    .line 1
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "com.android.vending.billing.PURCHASES_UPDATED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED"

    .line 2
    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const-string v2, "com.android.vending.billing.ALTERNATIVE_BILLING"

    .line 3
    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    iput-boolean p1, p0, Lcom/android/billingclient/api/zzab;->zzi:Z

    iget-object p1, p0, Lcom/android/billingclient/api/zzab;->zzh:Lcom/android/billingclient/api/zzaa;

    iget-object v2, p0, Lcom/android/billingclient/api/zzab;->zza:Landroid/content/Context;

    .line 4
    invoke-virtual {p1, v2, v1}, Lcom/android/billingclient/api/zzaa;->zza(Landroid/content/Context;Landroid/content/IntentFilter;)V

    iget-boolean p1, p0, Lcom/android/billingclient/api/zzab;->zzi:Z

    if-eqz p1, :cond_0

    iget-object p1, p0, Lcom/android/billingclient/api/zzab;->zzg:Lcom/android/billingclient/api/zzaa;

    const-string v1, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST"

    .line 5
    invoke-virtual {p1, v2, v0, v1}, Lcom/android/billingclient/api/zzaa;->zzb(Landroid/content/Context;Landroid/content/IntentFilter;Ljava/lang/String;)V

    return-void

    :cond_0
    iget-object p1, p0, Lcom/android/billingclient/api/zzab;->zzg:Lcom/android/billingclient/api/zzaa;

    .line 6
    invoke-virtual {p1, v2, v0}, Lcom/android/billingclient/api/zzaa;->zza(Landroid/content/Context;Landroid/content/IntentFilter;)V

    return-void
.end method

.method final zzk(Lcom/google/android/gms/internal/play_billing/zzcf;)V
    .locals 0

    iput-object p1, p0, Lcom/android/billingclient/api/zzab;->zzj:Lcom/google/android/gms/internal/play_billing/zzcf;

    return-void
.end method
